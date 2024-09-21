from fastapi import APIRouter
from fastapi import Path, Query, Depends
from fastapi.responses import JSONResponse

from pydantic import BaseModel, Field
from typing import  Optional, List



from config.database import Session
from models.computers import Computer as ComputerModel
from fastapi.encoders import jsonable_encoder
from middlewares.jwt_bearer import JWTBearer

computers_router = APIRouter()

class Computer(BaseModel):
    id: Optional[int] = None #Indicamos que es opcional
    marca: str = Field(min_length = 2, max_length=15)
    modelo: str = Field(min_length = 2, max_length=50)
    color: str = Field
    ram: int = Field(ge=1)
    almacenamiento: str

    class Config:
        json_schema_extra = {
            "example":{
                "id": 1,
                "marca": "ASUS",
                "modelo": "G2409g",
                "color": "Azul",
                "ram": 16,
                "almacenamiento": "250gb"
            }
        }

@computers_router.get('/computers', tags=['computers'], response_model= List[Computer], status_code=200)
def get_computers() -> List[Computer]:
    db = Session()
    result = db.query(ComputerModel).all()
    return JSONResponse(status_code=200, content= jsonable_encoder(result))

@computers_router.get('/computers/{id}', tags=['computers'])
def get_computers(id: int = Path(ge=1, le=2000)) -> Computer:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    return JSONResponse(status_code = 200, content = jsonable_encoder(result))

@computers_router.get('/computers/', tags=['computers'])
def get_computers_by_brand(marca: str = Query(max_length=15)) -> List[Computer]:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.marca == marca).all()
    return JSONResponse(status_code = 200, content = jsonable_encoder(result))

@computers_router.post('/computers', tags=['computers'])
def create_computers(computer: Computer) -> dict:
    db = Session()
    new_computer = ComputerModel(**computer.model_dump())
    db.add(new_computer)
    db.commit()
    return JSONResponse(content={"message": "The computer has been registered"})

@computers_router.put('/computers/{id}', tags=['computers'], response_model= dict, status_code=200)
def update_computers(id: int, computer: Computer) -> dict:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    result.marca = computer.marca
    result.modelo = computer.modelo
    result.color = computer.color
    result.ram = computer.ram
    result.almacenamiento = computer.almacenamiento
    db.commit()
    return JSONResponse(status_code = 200, content = {'message': 'The computer was modified correctly'})

@computers_router.delete('/computers/{id}', tags=['computers'], response_model= dict, status_code=200)
def delete_computers(id: int) -> dict:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    db.delete(result)
    db.commit()
    return JSONResponse(status_code = 200, content = {'message': 'The computer was deleted correctly'})