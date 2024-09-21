from config.database import Base
from sqlalchemy import Column, Integer, String

# Estructura de la clase categoría
class Category(Base):

    __tablename__ = "categories"
    
    id = Column(Integer, primary_key=True, unique=True, index=True, autoincrement=True)
    name = Column(String(30),nullable=False)

    def __init__(self, name):
        self.name = name.lower()