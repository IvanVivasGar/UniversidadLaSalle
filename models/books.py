from config.database import Base
from sqlalchemy import Column, Integer, String, Float

# Estructura de la clase libro
class Book(Base):

    __tablename__ = "books"

    id = Column(Integer, primary_key=True, unique=True, index=True, autoincrement=True)
    title = Column(String, nullable=False) #nullable sirve para indicar si el campo puede ser nulo o no en la base de datos
    author = Column(String, nullable=False)
    year = Column(Integer, nullable=False)
    category = Column(String, nullable=False)
    pages = Column(Integer, nullable=False)

    def __init__(self, title, author, year, category, pages):
        self.title = title.lower()
        self.author = author.lower()
        self.year = year
        self.category = category.lower()
        self.pages = pages