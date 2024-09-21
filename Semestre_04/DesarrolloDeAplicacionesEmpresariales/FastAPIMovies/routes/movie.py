from fastapi import APIRouter
from fastapi import Path, Query, Depends
from fastapi.responses import JSONResponse

from pydantic import BaseModel, Field
from typing import  Optional, List



from config.database import Session
from models.movie import Movie as MovieModel
from fastapi.encoders import jsonable_encoder
from middlewares.jwt_bearer import JWTBearer

movie_router = APIRouter()


class Movie(BaseModel):
    id: Optional[int] = None #Indicamos que es opcional
    title: str = Field(min_length=5, max_length=15)
    overview: str = Field(min_length=15, max_length=50)
    year: int = Field(le=2024)
    rating: float = Field(ge=1, le=10)
    category: str = Field(min_length=5, max_length=15)

    class Config:
        json_schema_extra = {
            "example":{
                "id": 1,
                "title": "Titulo Pelicula",
                "overview": "Descripcion de la pelicula",
                "year": 2023,
                "rating": 6.6,
                "category": "Accion"
            }
        }

# @movie_router.get("/movies", tags=["movies"], response_model = List[Movie],status_code=200)
@movie_router.get("/movies", tags=["movies"], response_model = List[Movie],status_code=200)
def get_movies() -> List[Movie]:
  db = Session()
  result = db.query(MovieModel).all()
  return JSONResponse(content=jsonable_encoder(result),status_code=200)


@movie_router.get("/movies:{id}",tags=["movies"])
def get_movie(id : int = Path(ge=1,le=2000)) -> Movie:
  db = Session()
  result = db.query(MovieModel).filter(MovieModel.id == id).first()
  #  for item in movies:
  #   if item["id"] == id:
  #     return JSONResponse(content=item)
  if not result:
    return JSONResponse(status_code=404, content={'message': 'No encontrado'}) 
  return JSONResponse(content=jsonable_encoder(result),status_code=200)

@movie_router.get('/movies/', tags=['movies'])
def get_movies_by_category(category:str = Query(min_length=5,max_length=15)) -> List[Movie]:
  db = Session()
  result = db.query(MovieModel).filter(MovieModel.category == category).all()
  # return JSONResponse(content=[item for item in movies if item ['category'] == category])
  return JSONResponse(status_code=200,content=jsonable_encoder(result))

# @movie_router.post('/movies', tags=['movies'])
# def create_movie(id: int = Body(), title:str = Body(), overview:str = Body(),year:int = Body(),rating:float = Body(),category:str = Body()):
#   movies.append({
#     "id": id,
#     "title": title,
#     "overview": overview,
#     "year": year,
#     "rating": rating,
#     "category": category
#   })
#   return movies

@movie_router.post('/movies', tags=['movies'])
def create_movie(movie:Movie) -> dict:
  db = Session()
  # Use model and pass info 
  new_movie = MovieModel(**movie.model_dump())
  # Add movie to DB
  db.add(new_movie)
  # Save data into DB
  db.commit()
  # movies.append(movie)
  return JSONResponse(content={"Message": "Se ha registrado la pelicula"} )



@movie_router.put('/movies/{id}',tags=['movies'] ,response_model = List[Movie],status_code=200)
def update_movie(id: int, movie: Movie) -> dict:
  db = Session()
  result = db.query(MovieModel).filter(MovieModel.id == id).first()

  if not result:
      return JSONResponse(status_code=404, content={'message':'No encontrado'})
  
  result.title = movie.title
  result.overview = movie.overview
  result.year = movie.year
  result.rating = movie.rating
  result.category = movie.category

  db.commit()


  # for item in movies:
  #   if item["id"] == id:
  #     item["title"] = movie.title,
  #     item["overview"] = movie.overview,
  #     item["year"] = movie.year,
  #     item["rating"] = movie.rating,
  #     item["category"] = movie.category
  return JSONResponse(content={"Message": "Se ha modificado la pelicula"}, status_code=200 )
    
@movie_router.delete('/movies/{id}',tags=['movies'], response_model = List[Movie],status_code=200)
def delete_movie(id: int) -> dict:
  db = Session()
  result = db.query(MovieModel).filter(MovieModel.id == id).first()
  # for item in movies:
  #   if item["id"] == id:
  #     movies.remove(item)
  #     return JSONResponse(content={"message": "Se ha eliminado la pelicula"}, status_code=200 )
  if not result:
     return JSONResponse(status_code=404,content={'message':'No encontrado'})
  db.delete(result)
  db.commit()
  return JSONResponse(status_code=202, content={'message' : 'Se ha eliminado la pelicula'})