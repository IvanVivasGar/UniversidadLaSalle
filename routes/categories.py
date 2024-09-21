from fastapi import APIRouter, Depends, FastAPI, Body, Path, Query, HTTPException
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Field
from typing import List
from config.database import Session, engine, Base
from models.books import Book as BookModel
from models.category import Category as CategoryModel
from jwt_manager import create_token, validate_token
from jwt_manager import create_token, validate_token
from fastapi.security import HTTPBearer;
from fastapi import HTTPException, Request;
# from error_handler import ErrorHandler
# from fastapi.middleware.wsgi import add_middleware

categories_router=APIRouter()

# ================ Estructura de la clase categoría ================
class Category(BaseModel):
    name: str = Field(min_length=1, max_length=30)
# ____________________________________________
# ================ CATEGORIAS ================

# ================ Retorna todas las categorías ================
@categories_router.get("/categories", tags=["Categories"], response_model=List[Category], status_code=200, dependencies=[Depends(HTTPBearer())])
def get_categories() -> List[Category]:
    db = Session()
    result = db.query(CategoryModel).all()
    return JSONResponse(status_code=200, content=jsonable_encoder(result))

# ================ Crea una nueva categoría ================
@categories_router.post('/categories', tags=["Categories"], dependencies=[Depends(HTTPBearer())])
def create_category(name:Category):
    db = Session()
    
    if db.query(CategoryModel).filter(CategoryModel.name == name.name).first():
        raise HTTPException(status_code=400, detail="Esa categoría ya existe.")
    else:
        db = Session()
        new_category = CategoryModel(**name.dict())
        db.add(new_category)
        db.commit()
        db.refresh(new_category)
        return JSONResponse(status_code=200, content={"message": "Categoría agregada con éxito."})

# ================ Eliminar una categoría ================
@categories_router.delete('/categories/{id}', tags=["Categories"], status_code=200, dependencies=[Depends(HTTPBearer())])
def delete_categoria(category: str):
        
        db = Session()
        # Buscar la categoría por su nombre
        find_category = db.query(CategoryModel).filter(CategoryModel.name == category).first()
        
        # Verificar si hay libros asociados a la categoría
        find_book_with_category = db.query(BookModel).filter(BookModel.category == category).first()
        
        if not find_book_with_category:
            # Si no hay libros asociados, eliminar la categoría
            db.delete(find_category)  # Eliminar el objeto de categoría
            db.commit()
            return "Categoría eliminada exitosamente."
        else:
            return "No se puede eliminar la categoría porque existen libros asociados a ella."

# ================ Modificar una categoría ================
@categories_router.put('/categories/{id}', tags=["Categories"], status_code=200, dependencies=[Depends(HTTPBearer())])
def modify_category(id: int = Path(..., title="ID de la categoría", description="ID de la categoría a modificar"), new_name: str = Query(..., min_length=1)):
    
    db=Session()

    # Verifica el id de la categoria a modificar y almacena el nombre de la categoria en una variable 

    category = db.query(CategoryModel).filter(CategoryModel.id == id).first()
    if not category:
        raise HTTPException(status_code=404, detail=f"La categoría con el id {id} no existe.")

    existing_category = db.query(CategoryModel).filter(CategoryModel.name == new_name).first()
    if existing_category:
        raise HTTPException(status_code=400, detail="Ya existe una categoría con ese nombre.")

    old_name = category.name
    category.name = new_name
    db.commit()

    # Buscar libros que contengan el id de la categoria modificada y actualiza el nombre de la categoria
    books_with_category = db.query(BookModel).filter(BookModel.category == old_name).all()
    for book in books_with_category:
        book.category = new_name
    db.commit()
    

    return JSONResponse(status_code=200, content={"message": f"La categoría con el ID {id} se ha modificado correctamente."})