from django.http import HttpResponse

# Create your views here.

def index(request):
    return HttpResponse("Hola Mundo. Estas en el componente de votaciones")