#Created on Sat May 04 2024 at 1:16:38 by Kevin Jonathan Tavera Perez

#File: jwt_bearer.py

#Copyright (c) 2024 company

from jwt_manager import validate_token;
from fastapi.security import HTTPBearer;
from fastapi import HTTPException, Request;

class JWTBearer(HTTPBearer):
    async def __call__(self, request: Request):#Sobreescribimos el método __call__ de la clase HTTPBearer
        auth = await super().__call__(request) #Llamamos al método __call__ de la clase padre HTTPBearer
        data = validate_token(auth.credentials) #Validamos el token
        email = data.get('email')  # Obtenemos el valor de 'email' o None si no existe
        if email != 'admin@gmail.com': #Si el email no es igual a '
            raise HTTPException(status_code=403, detail='Las credenciales son inválidas')