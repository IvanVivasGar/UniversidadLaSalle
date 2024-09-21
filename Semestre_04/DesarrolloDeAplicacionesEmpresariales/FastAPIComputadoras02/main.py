from fastapi import Depends, FastAPI, Body, Path, Query, HTTPException
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Field
from typing import List
from config.database import Session, engine, Base
from models.books import Book as BookModel
from models.category import Category as CategoryModel
from jwt_manager import create_token, validate_token
from fastapi.security import HTTPBearer;
from fastapi import HTTPException, Request;

from middlewares.error_handler import ErrorHandler
from routes.books import books_router
from routes.categories import categories_router
from routes.users import users_router

# from error_handler import ErrorHandler
# from fastapi.middleware.wsgi import add_middleware


app = FastAPI()
# app.add_middleware(ErrorHandler)
app.title = "PROYECTO BIBLIOTECA API" 

app.add_middleware(ErrorHandler)
app.include_router(books_router)
app.include_router(categories_router)
app.include_router(users_router)    

Base.metadata.create_all(bind=engine)


