from fastapi import FastAPI
from fastapi.responses import HTMLResponse, JSONResponse
from pydantic import BaseModel
from jwt_manager import create_token
from config.database import  engine, Base
from middlewares.error_handler import ErrorHandler
from routes.movie import movie_router
from routes.user import user_router

app = FastAPI();
app.title = "Mi primera chamba en FastAPI"

app.add_middleware(ErrorHandler)
app.include_router(movie_router)
app.include_router(user_router)


Base.metadata.create_all(bind=engine)




   

  


