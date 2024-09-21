from fastapi import FastAPI, Body, Path, Query
from fastapi.responses import HTMLResponse, JSONResponse
from pydantic import BaseModel, Field
from typing import Optional, List

app = FastAPI()
app.title = "PROYECTO 1er Parcial API"

books = [
    {
        "id" : 1,
        "title" : "Harry Potter y la Camara de los secretos",
        "author" : "J.K Rowling",
        "year" : 1998,
        "category" : {
            "id": 1,
            "name": "Fantasia",
        },
        "pages" : 320,
    },
    {
        "id" : 2,
        "title" : "harry potter philosopher's stone",
        "author" : "J.K Rowling",
        "year" : 1997,
        "category" : {
            "id": 1,
            "name": "Fantasia",
        },
        "pages" : 320,
    }
]

categories = [
    {
        "id": 1,
        "name": "Fantasia",
    },
    {
        "id": 2,
        "name": "Misterio",
    }
]

class Category(BaseModel):
    id : int = Field(ge = 1)
    name : str = Field(min_length = 1, max_length = 30)
    class config:
        json_schema_extra = {
            "category" : {
                "id" : 1,
                "name" : "Misterio"
            }
        }

# Estructura de la clase libro
class Book(BaseModel):
    id: Optional[int] = None
    title: str = Field(min_length=1,max_length=30)
    author: str = Field(min_length=1,max_length=50)
    year: str
    category: Category
    pages: int = Field(ge=1)
    class config:

        json_schema_extra = {
            "book":{
                "title": "Titulo del libro",
                "author": "Autor del libro",
                "year": "Año de publicacion",
                "category": {
                    "id" : 1,
                    "name" : "Fantasy"
                },
                "pages": 1
            }
        }

# Contador global para id
class AutoIncrement:
    _id = 0

    @classmethod
    def get_id(cls):
        cls._id += 1
        return cls._id

    def delete_int(cls):
        cls._id -= 1
        return cls._id

auto_increment_id_categories = AutoIncrement()
auto_increment_id_books = AutoIncrement()
# auto_increment_id_categories = len(categories) + 1
# next_book_id = len(books) + 1

# =========Seccion Books=========

# Retorna todos los libros registrados
@app.get("/books", tags = ["Books"], response_model = List[Book], status_code = 200)
def get_books() -> List[Book]:
    return JSONResponse(content = books, status_code=200)

# Buscar libros por id
@app.get("/books/{id}", tags = ["Books"], status_code=200)
def get_book_id(id : int = Path(ge = 1, le = 2000)):
    for item in books:
        if item['id'] == id:
            return JSONResponse(status_code = 200, content = item)
    return JSONResponse(status_code = 400, content = {"message" : "No existe un libro con ese identificador."})

# Buscar libros por categoria
@app.get("/books/", tags = ["Books"], response_model = List[Book], status_code = 200)
def get_book_category(category : str = Query) -> List[Book]:
    data = [item for item in books if item['category']['name'].lower().strip().replace(" ", "") == category.lower().strip().replace(" ", "")]
    return JSONResponse(content = data)

@app.get('/books/', tags=['Books'], status_code=200)
def get_books_by_category(category:str):
    bookList = []
    for book in books:
        if book["category"] == category:
            bookList.append(book)
    return bookList

# Crear libros
@app.post("/books/" , tags = ["Books"], status_code=200)
def create_book(title: str = Body(), author: str = Body(), year: str = Body(), category: str = Body(), pages: int = Body()):
    if not any(cat["name"].lower().strip() == category.lower().strip() for cat in categories):
        return JSONResponse(status_code=400, content={"message": f"La categoría '{category}' no existe."})

    global auto_increment_id_books
    # Crea una nueva instancia para el modelo book
    new_book = {
                    "id" : auto_increment_id_books.get_id(),
                    "title": title,
                    "author": author,
                    "year": year,
                    "category": category,
                    "pages": pages
                }

    # Agregar un nuevo libro
    books.append(new_book)
    return books

# @app.post('/books/', tags = ['Books'])
# def create_books(title:str = Body(), author:str = Body(),year:int = Body(),category:str = Body(),pages:int = Body()):
#     global auto_increment_id_books
#     new_book = {
#         "id" = auto_increment_id_books.get_id(),
#         "title" = title,

#     }
#     for item in books:
#         if name.lower().strip().replace(" ", "") == item["Category"].lower().strip().replace(" ", ""):
#             new_book = {"id": auto_increment_id_books.getid(), "name" : name}
#             books.append(new_book)

# Modifica un libro
@app.put('/books/{id}', tags=["Books"], status_code=200)
def modify_book(id: int = Path(), title: str = Body(), author: str = Body(), year: str = Body(), category: str = Body(), pages: int = Body()):
    if not any(cat["name"].lower().strip() == category.lower().strip() for cat in categories):
        return JSONResponse(status_code=400, content={"message": f"La categoría '{category}' no existe."})
    # Check if the provided id exists in the list of books
    if not any(book['id'] == id for book in books):
        return JSONResponse(status_code=400, content={"message": f"El libro con el id {id} no existe."})
    
    # Update the book with the provided id
    for book in books:
        if book['id'] == id:
            book['title'] = title
            book['author'] = author
            book['year'] = year
            book['category'] = category
            book['pages'] = pages
            return JSONResponse(status_code=200, content={"message": f"El libro con el id {id} se ha actualizado."})
        
# Eliminar un libro
@app.delete('/books/{id}', tags=["Books"],status_code=200)
def delete_book(id : int = Path(title="id", description="id del libro")):
    for item in books:
        if any(id == id for book in books):
            auto_increment_id_books.delete_int
            books.remove(item)
            return JSONResponse(status_code=200, content={"message": f"El libro con el id {id} se ha eliminado."})

# ==============Seccion categorias==============

# Retorna todas las categorias
@app.get("/categories", tags = ["Categories"], response_model = List[Category], status_code = 200)
def get_categories() -> List[Category]:
    return JSONResponse(content=categories,status_code = 200)

# Crea categorias solo si no existen
@app.post('/categories', tags=["Categories"], status_code=200)
def create_category(name: str = Query):
    global auto_increment_id_categories
    for item in categories:
        if name.lower().strip().replace(" ", "") == item["name"].lower().strip().replace(" ", ""):
            return JSONResponse(status_code=400, content={"message": "Esa categoria ya existe."})
    new_category = {"id": auto_increment_id_categories.get_id(), "name": name}
    categories.append(new_category)

    return JSONResponse(status_code=200, content={"message": "Categoria agregada con exito"})

# Eliminar la categoria, solo si no tiene ningun libro dentro
@app.delete('/categories/{name}', tags = ["Categories"], status_code=200)
def delete_category(name : str = Query):
    global auto_increment_id_categories
    for item in categories:
        if item['name'].lower().strip().replace(" ", "") == name.lower().strip().replace(" ", ""):
            for item in books:
                if item['category']['name'].lower().strip().replace(" ", "") == name.lower().strip().replace(" ", ""):
                    return JSONResponse(status_code = 400, content = {"message" : "La categoria tiene libros afiliados, no se puede eliminar."})
            auto_increment_id_categories.delete_int
            categories.remove(item)

            for index, category in enumerate(categories, start=1):
                category['id'] = index
    return JSONResponse(status_code = 400, content = {"message" : "No existe tal categoria"})

# Modificar categorias
@app.put('/categories/{name}', tags=["Categories"], status_code=200)
def modify_category(name: str = Query, newName: str = Query):
    global books
    for item in categories:
        if item["name"].lower().strip().replace(" ", "") == name.lower().strip().replace(" ", ""):
            item["name"] = newName
            for book in books:
                if book["category"]["name"].lower().strip().replace(" ", "") == name.lower().strip().replace(" ", ""):
                    book["category"]["name"] = newName
            return JSONResponse(status_code=200, content={"message": "La categoría se modificó correctamente."})
    return JSONResponse(status_code=400, content={"message": "No existe tal categoría."})

# @app.put('/categories/{name}', tags = ["Categories"], status_code = 200)
# def modify_category(name : str = Query, newName : str = Query):
#     for item in categories:
#         if item["name"].lower().strip().replace(" ", "") == name.lower().strip().replace(" ", ""):
#             item["name"] = newName
#             return JSONResponse(status_code = 200, content = item)