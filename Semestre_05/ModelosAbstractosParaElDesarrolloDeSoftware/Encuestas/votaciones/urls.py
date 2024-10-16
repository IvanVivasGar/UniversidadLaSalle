from django.urls import path

#punto (.) porque estamos en la misma carpeta
from . import views

urlpatterns = [
    #Cuando el usuario llega a la ruta del path
    #/votaciones/
    path("", views.index, name = "index"),
    #/votaciones/10/
    path("<int:pregunta_id>/", views.detail, name="detail"),
    #/votaciones/10/results
    path("<int:pregunta_id>/results/", views.results, name="results"),
    #/votaciones/10/vote
    path("<int:pregunta_id>/vote/", views.vote, name="vote")
]