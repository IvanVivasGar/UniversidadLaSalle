import os; #importamos la libreria os para manipular el sistema operativo
from sqlalchemy import create_engine #crear el motor de la base de datos
from sqlalchemy.orm.session import sessionmaker #manipular sesiones
from sqlalchemy.ext.declarative import declarative_base #manipular base de datos

sqlite_file_name = "../database.sqlite" #nombre de la base de datos

#Estamos leyendo el directorio acutal que es database.py
base_dir = os.path.dirname(os.path.realpath(__file__))

#creamos la url de la base de datos uniendo las 2 variables anteeriores
databases_url = f"sqlite:///{os.path.join(base_dir, sqlite_file_name)}"

engine = create_engine(databases_url, echo=True)   #creamos el motor de la base de datos

Session = sessionmaker(bind=engine) #creamos una sesion para la base de datos

Base = declarative_base() #creamos una base de datos