from django.db import models
from django.db.models import Model


# Create your models here.
class Pregunta(models.Model):
    texto_pregunta = models.CharField(max_length=200)
    fecha_publicacion = models.DateTimeField("fecha de publicacion de la pregunta")

class Respuesta(models.Model):
    pregunta = models.ForeignKey(Pregunta, on_delete=models.CASCADE)
    texto_respuesta = models.CharField(max_length=200)
    votos = models.IntegerField(default=0)