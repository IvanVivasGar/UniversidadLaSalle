from django.urls import path

#punto (.) porque estamos en la misma carpeta
from . import views 


app_name="votaciones"
urlpatterns = [
    #Cuando el usuario llega a la ruta del path 
    #/votaciones/
    path("", views.IndexView.as_view(), name = "index"),
    #/votaciones/10/
    path("<int:pk>/votar/", views.DetailView.as_view(), name="detail"),
    #/votaciones/10/results
    path("<int:pk>/results/", views.ResultView.as_view(), name="results"),
    #/votaciones/10/vote
    path("<int:pregunta_id>/vote/", views.vote, name="vote")
]