from models.movie import Movie as MovieModel

class MovieService():
    def __init__(self) -> None:
        self.db = db

    # RETORNO DE TODAS LAS PELICULAS
    def get_movies(self):
        result = self.db.query(MovieModel).all()
        return result

    def get_movie_id(self, id = int) -> MovieModel:
        result = self.db.query(MovieModel).filter(MovieModel.id == id).first()
        return result

    def get_movie_category(self, category = str) -> MovieModel:
        result = self.db.query(MovieModel).filter(MovieModel.category == category).all()
        return result