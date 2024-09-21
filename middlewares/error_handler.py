#Created on Sat May 04 2024 at 1:16:10 by Kevin Jonathan Tavera Perez

#File: error_handler.py

#Copyright (c) 2024 company


from starlette.middleware.base import BaseHTTPMiddleware;
from fastapi import Request, FastAPI, Response;
from fastapi.responses import JSONResponse;

class ErrorHandler(BaseHTTPMiddleware):
    def __init__(self, app: FastAPI) -> None:
        super().__init__(app) #Llamamos al constructor de la clase padre BaseHTTPMiddleware
    async def dispatch(self, request: Request, call_next) -> Response | JSONResponse: #Sobreescribimos el método dispatch
        try:
            return await call_next(request)
        except Exception as e:
            return JSONResponse(status_code = 500, content = {"error": str(e)})