from django.http import HttpResponse
from .models import Pregunta
from django.template import loader

# Create your views here.
def index(request):
    lista_preguntas_recientes = Pregunta.objects.order_by("fecha_publicacion")[:4]
    template = loader.get_template("votaciones/index.html")
    context = {
        "lista_preguntas_recientes": lista_preguntas_recientes,
    }
    return HttpResponse(template.render(context, request))

def detail(request, pregunta_id):
    return HttpResponse("Estas en la pregunta %s" %pregunta_id)

def results(request, pregunta_id):
    respuesta = "Estas viendo las respuestas de la pregunta %s"
    return HttpResponse(respuesta % pregunta_id)

def vote(request, pregunta_id):
    return HttpResponse("Estás votando en la pregunta %s"% pregunta_id)