from fastapi import FastAPI, Body, Path, Query, Request, HTTPException, Depends
from fastapi.responses import HTMLResponse, JSONResponse
from fastapi.security.http import HTTPAuthorizationCredentials
from pydantic import BaseModel, Field
from typing import Coroutine, Optional, List
from jwt_manager import create_token, validate_token
from fastapi.security import HTTPBearer
from config.database import Session, engine, Base
from models.computers import Computer as ComputerModel
from fastapi.encoders import jsonable_encoder

app = FastAPI()
app.title = "Venta de Computadoras"

Base.metadata.create_all(bind = engine)

class User(BaseModel):
    email:str
    password:str

class JWTBearer(HTTPBearer):
    async def __call__(self, request: Request):
        auth = await super().__call__(request)
        data = validate_token(auth.credentials)
        if data['email'] != "admin@gmail.com":
            raise HTTPException(status_code=403, detail="Credenciales Incorrectas")

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

computadoras = [
    {
        "id": 0,
        "marca":"Asus",
        "modelo": "Republic of Gamers",
        "color": "Blanca",
        "ram": 16,
        "almacenamiento": "1TB"
    },
    {
        "id": 1,
        "marca":"HP",
        "modelo": "Pavilion",
        "color": "Negra",
        "ram": 8,
        "almacenamiento": "500GB"
    }
]

@app.post('/login', tags=['auth'])
def login(user: User):
    if user.email == "admin@gmail.com" and user.password == "admin":
        token: str = create_token(user.dict())
        return JSONResponse(status_code=200, content=token)

@app.get('/computers', tags=['computers'], response_model= List[Computer], status_code=200)
def get_computers() -> List[Computer]:
    db = Session()
    result = db.query(ComputerModel).all()
    return JSONResponse(status_code=200, content= jsonable_encoder(result))

@app.get('/computers/{id}', tags=['computers'])
def get_computers(id: int = Path(ge=1, le=2000)) -> Computer:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    return JSONResponse(status_code = 200, content = jsonable_encoder(result))

@app.get('/computers/', tags=['computers'])
def get_computers_by_brand(marca: str = Query(max_length=15)) -> List[Computer]:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.marca == marca).all()
    return JSONResponse(status_code = 200, content = jsonable_encoder(result))

@app.post('/computers', tags=['computers'])
def create_computers(computer: Computer) -> dict:
    db = Session()
    new_computer = ComputerModel(**computer.model_dump())
    db.add(new_computer)
    db.commit()
    computadoras.append(computer)
    return JSONResponse(content={"message": "The computer has been registered"})

@app.put('/computers/{id}', tags=['computers'], response_model= dict, status_code=200)
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

@app.delete('/computers/{id}', tags=['computers'], response_model= dict, status_code=200)
def delete_computers(id: int) -> dict:
    db = Session()
    result = db.query(ComputerModel).filter(ComputerModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    db.delete(result)
    db.commit()
    return JSONResponse(status_code = 200, content = {'message': 'The computer was deleted correctly'})