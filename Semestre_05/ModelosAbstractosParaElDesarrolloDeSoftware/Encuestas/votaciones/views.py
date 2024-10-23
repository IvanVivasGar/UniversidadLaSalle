from django.db.models import F
from django.http import HttpResponse, Http404, HttpResponseRedirect
from django.template import loader
from django.shortcuts import render, get_object_or_404
from .models import Pregunta, Respuesta
from django.urls import reverse

# Create your views here.
def index(request):
    lista_preguntas_recientes = Pregunta.objects.order_by("fecha_publicacion")[:3]
    #//template = loader.get_template("votaciones/index.html")
    context = {
        "lista_preguntas_recientes": lista_preguntas_recientes,
    }
    #//return HttpResponse(template.render(context, request))
    return render(request, "votaciones/index.html", context)


def detail(request, pregunta_id):
    #// try:
    #  //   pregunta = Pregunta.objects.get(pk=pregunta_id)
    #// except Pregunta.DoesNotExist:
    #  //   raise Http404("La pregunta no existe")
    pregunta = get_object_or_404(Pregunta, pk=pregunta_id)
    #//return HttpResponse("Estas en la pregunta %s" % pregunta_id)
    return render(request, "votaciones/detalle.html", {"pregunta":pregunta})

def results(request, pregunta_id):
    #//respuesta = "Estas viendo la respuesta de la pregunta %s"
    pregunta = get_object_or_404(Pregunta, pk=pregunta_id)
    return render(request,"votaciones/resultados.html", {"pregunta": pregunta})
    #//return HttpResponse(respuesta % pregunta_id)

def vote(request, pregunta_id):
    pregunta = get_object_or_404(Pregunta, pk=pregunta_id)
    try:
        respuesta_seleccionada = pregunta.respuesta_set.get(pk=request.POST["respuesta"])
    except (KeyError,Respuesta.DoesNotExist):
        return render(request, "votaciones/detalle.html", {"pregunta":pregunta, "error_message": "No has seleccionado una respuesta"})
    else:
        respuesta_seleccionada.votos = F("votos") + 1
        respuesta_seleccionada.save()
        return HttpResponseRedirect(reverse("votaciones:results", args=(pregunta.id,)))
    #//return HttpResponse("Estas votando en la pregunta %s" % pregunta_id)