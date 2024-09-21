from fastapi import Path, Query, Depends, APIRouter
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Field
from typing import Optional, List
from config.database import Session
from models.movie import Movie as MovieModel
from fastapi.encoders import jsonable_encoder
from middlewares.jwt_bearer import JWTBearer
from services.movie import MovieService
from schemas.movie import Movie

movie_router = APIRouter()

class Movie(BaseModel):
    id: Optional[int] = None #Indicamos que es opcional
    title: str = Field(min_length=5, max_length=15)
    overview: str = Field(min_length=15, max_length=50)
    year: int = Field(le=2024)
    rating: float = Field(ge=1, le=10)
    category: str = Field(min_length=5, max_length=15)

@movie_router.get('/movies', tags=['movies'], response_model= List[Movie], status_code=200, dependencies=[Depends(JWTBearer())])
def get_movies() -> List[Movie]:
    db = Session()
    result = MovieService(db).get_movies()
    return JSONResponse(status_code=200, content= jsonable_encoder(result))

@movie_router.get('/movies/{id}', tags=['movies'])
def get_movie(id: int = Path(ge=1, le=2000)) -> Movie:
    db = Session()
    result = MovieService(db).get_movie_id(id)
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    return JSONResponse(status_code = 404, content = jsonable_encoder(result))

@movie_router.get('/movies/', tags=['movies'])
def get_movies_by_category(category: str = Query(min_length=5, max_length=15)) -> List[Movie]:
    db = Session()
    result = db.query(MovieModel).filter(MovieModel.category == category).all()
    return JSONResponse(status_code = 200, content = jsonable_encoder(result))

@movie_router.post('/movies', tags=['movies'])
def create_movie(movie: Movie) -> dict:
    db = Session()
    #Utilizamos el modelo y le pasamos la informacion que vamos a registrar
    new_movie = MovieModel(**movie.model_dump())
    #Ahora a la BD añadimos esa Pelicula
    db.add(new_movie)
    #Guardamos Datos
    db.commit()
    return JSONResponse(content={"message": "Se ha registrado la pelicula"})

@movie_router.put('/movies/{id}', tags=['movies'], response_model= dict, status_code=200)
def update_movie(id: int, movie: Movie) -> dict:
    db = Session()
    result = db.query(MovieModel).filter(MovieModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    result.title = movie.title
    result.overview = movie.overview
    result.year = movie.year
    result.rating = movie.rating
    result.category = movie.category
    db.commit()
    return JSONResponse(status_code = 200, content = {'message': 'The movie was modified correctly'})

@movie_router.delete('/movies/{id}', tags=['movies'], response_model= dict, status_code=200)
def delete_movie(id: int) -> dict:
    db = Session()
    result = db.query(MovieModel).filter(MovieModel.id == id).first()
    if not result:
        return JSONResponse(status_code = 404, content = {'message': 'Not found'})
    db.delete(result)
    db.commit()
    JSONResponse(status_code = 200, content = {'message': 'The movie was deleted correctly'})