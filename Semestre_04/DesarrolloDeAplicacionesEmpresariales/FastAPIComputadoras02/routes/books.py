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

books_router= APIRouter()

# ================ Estructura de la clase libro ================
from pydantic import BaseModel, Field


class Book(BaseModel):
    title: str = Field(min_length=1, max_length=30)
    author: str = Field(min_length=1, max_length=50)
    year: int = Field(le=2024)
    category: str = Field(min_length=1, max_length=30)
    pages: int = Field(ge=1)

    # ================ Crea un nuevo libro ================
@books_router.post("/books/", tags=["Books"], status_code=200, dependencies=[Depends(HTTPBearer())])
def create_book(book: Book) -> dict:
    
    db = Session()
    # Verificar si la categoría ya existe
    if not db.query(CategoryModel).filter(CategoryModel.name == book.category).first():
        raise HTTPException(status_code=400, detail="La categoría no existe, creala primero.")
    else:
        # Crear un nuevo libro
        new_book = BookModel(**book.dict())
        db.add(new_book)
        db.commit()
        db.refresh(new_book)
        return JSONResponse(status_code=200, content={"message": "Libro agregado con éxito."})

# ================ Modifica un libro ================
@books_router.put('/books/{id}', tags=["Books"], status_code=200, dependencies=[Depends(HTTPBearer())])
def modify_book(id: int, book: Book) -> dict:

    db = Session()

    # Verificar si la categoría existe
    category_exists = db.query(CategoryModel).filter(CategoryModel.name == book.category).first()
    if not category_exists:
        raise HTTPException(status_code=400, detail=f"La categoría '{book.category}' no existe.")

    # Verificar si el libro existe
    book_exists = db.query(BookModel).filter(BookModel.id == id).first()
    if not book_exists:
        raise HTTPException(status_code=400, detail=f"El libro con el id {id} no existe.")

    # Modificar el libro con el id proporcionado
    book_exists.title = book.title
    book_exists.author = book.author
    book_exists.year = book.year
    book_exists.category = book.category
    book_exists.pages = book.pages

    db.commit()

    return JSONResponse(status_code=200, content={"message": f"El libro con el id {id} se ha actualizado."})

# ================ Retorna todos los libros registrados ================ 
@books_router.get("/books", tags=["Books"], response_model=List[Book], status_code=200, dependencies=[Depends(HTTPBearer())])
def get_books() -> List[Book]:
    db = Session()
    result = db.query(BookModel).all()
    return JSONResponse(status_code=200, content=jsonable_encoder(result))

# ================ Buscar libros por id ================ 
@books_router.get("/books/{id}", tags=["Books"], status_code=200, dependencies=[Depends(HTTPBearer())])
def get_book_id(id: int = Path(..., ge=1, le=2000)):
    db = Session()
    book = db.query(BookModel).filter(BookModel.id == id).first()
    if book is None:
        raise HTTPException(status_code=404, detail=f"El libro con el id {id} no existe.")
    return JSONResponse(status_code=200, content=jsonable_encoder(book))

# ================ Buscar libros por categoría ================
@books_router.get("/books_by_category/", tags=["Books"], response_model=List[Book], status_code=200, dependencies=[Depends(HTTPBearer())])
def get_books_by_category(category: str = Query(..., min_length=1)):

    db = Session()
    books = db.query(BookModel).filter(BookModel.category == category).all()
    return JSONResponse(content=jsonable_encoder(books))

# ================ Eliminar un libro ================
@books_router.delete('/books/{id}', tags=["Books"], status_code=200, dependencies=[Depends(HTTPBearer())])
def delete_book(id: int = Path(..., title="ID del libro", description="ID del libro a eliminar")):
    db = Session()
    book = db.query(BookModel).filter(BookModel.id == id).first()
    if book is None:
        raise HTTPException(status_code=404, detail=f"El libro con el id {id} no existe.")
    
    db.delete(book)
    db.commit()
    return JSONResponse(status_code=200, content={"message": f"El libro con el id {id} se ha eliminado."})