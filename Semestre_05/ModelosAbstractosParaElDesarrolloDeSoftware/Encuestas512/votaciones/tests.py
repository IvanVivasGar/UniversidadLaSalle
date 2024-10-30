from django.test import TestCase
from .models import Pregunta, Respuesta
from django.utils import timezone

# Create your tests here.
class RespuestaModelTest(TestCase):
    def test_crear_respuesta_para_pregunta(self):
        pregunta = Pregunta(texto_pregunta="¿Te gusta viajar?", fecha_publicacion = timezone.now())
        pregunta.save()
        respuesta = Respuesta(pregunta=pregunta, texto_respuesta="Si", votos=0)
        respuesta.save()
        self.assertEqual(respuesta.pregunta, pregunta)

    def test_eliminar_pregunta_con_sus_respuestas(self):
        pregunta = Pregunta(texto_pregunta="¿Cómo estás?", fecha_publicacion = timezone.now())
        pregunta.save()
        respuesta = Respuesta(pregunta=pregunta, texto_respuesta="Bien", votos=0)
        respuesta.save()
        pregunta_id = pregunta.id
        respuesta_id = respuesta.id
        pregunta.delete()

        with self.assertRaises(Pregunta.DoesNotExist):
            Pregunta.objects.get(pk=pregunta_id)

        with self.assertRaises(Respuesta.DoesNotExist):
            Respuesta.objects.get(pk=respuesta_id)