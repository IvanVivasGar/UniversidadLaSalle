from django.http import HttpResponse, Http404
from django.template import loader
from django.shortcuts import render, get_object_or_404
from .models import Pregunta

# Create your views here.
def index(request):
    lista_preguntas_recientes = Pregunta.objects.order_by("fecha_publicacion")[:4]
    #//template = loader.get_template("votaciones/index.html")
    context = {
        "lista_preguntas_recientes": lista_preguntas_recientes,
    }
    #//return HttpResponse(template.render(context, request))
    return render(request, "votaciones/index.html", context)

def detail(request, pregunta_id):
    #// try:
    #//     pregunta = Pregunta.objects.get(pk=pregunta_id) #PRIMARY KEY
    #// except Pregunta.DoesNotExist:
    #//     raise Http404("La pregunta no existe")
    pregunta = get_object_or_404(Pregunta, pk=pregunta_id)
    #//return HttpResponse("Estas en la pregunta %s" %pregunta_id)
    return render(request, "votaciones/detalle.html", {"pregunta": pregunta})

def results(request, pregunta_id):
    respuesta = "Estas viendo las respuestas de la pregunta %s"
    return HttpResponse(respuesta % pregunta_id)

def vote(request, pregunta_id):
    return HttpResponse("Estás votando en la pregunta %s"% pregunta_id)