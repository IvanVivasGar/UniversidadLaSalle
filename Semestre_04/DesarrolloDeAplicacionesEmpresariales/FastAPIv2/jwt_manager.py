from jwt import encode
from jwt import decode

def create_token(data:dict):
  token: str = encode(payload=data, key="roger-goated-siuuu", algorithm="HS256")
  return token

def validate_token(token:str) -> dict:
  data: dict=decode(token,key="roger-goated-siuuu",algorithms=["HS256"])
  return data
 