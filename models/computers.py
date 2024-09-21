from config.database import Base
from sqlalchemy import Column, Integer, String

class Computer(Base):
    __tablename__ = "computers"

    id = Column(Integer, primary_key = True)
    marca = Column(String)
    modelo = Column(String)
    color = Column(String)
    ram = Column(Integer)
    almacenamiento = Column(String)