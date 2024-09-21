from fastapi import APIRouter
from jwt_manager import create_token
from fastapi.responses import JSONResponse
from models.user import User
from schemas.user import User
from fastapi.responses import HTMLResponse

user_router = APIRouter()

@user_router.post('/login',tags=['auth'])
def login(user:User):
  if user.email == "admin@gmail.com" and user.password == "admin":
    token:str = create_token(user.dict())
    return JSONResponse(status_code=200,content=token) 

@user_router.get("/", tags=["home"])
def message():
  return HTMLResponse('<h1>Hello world</h1>');

