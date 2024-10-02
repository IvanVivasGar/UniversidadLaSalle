import numpy as np
import utils

def histograma(img, bins):
    hist = np.zeros(bins)
    w, h = img.shape
    for i in range(w):
        for j in range(h):
            intensidad = int(img[i, j])
            #se suma 1 a la intensidad en el histograma para indicar que se repite una vez
            hist[intensidad] += 1

    # if normalizar:
    #     #dividir cada conteo en el numero total de pixeles (ancho * altura)
    #     hist /=(w*h)
    return hist

# Crear la tabla de Look Up
def crear_lookup_table(hist, total_pixeles):
    # Normalizar histograma
    hist_normalizado = hist / total_pixeles

    # Suma acumulada del histograma normalizado
    suma_ac = np.cumsum(hist_normalizado)

    # Crear la tabla
    tabla = []
    for i in range(len(hist)):
        intensidad = i
        conteo = int(hist[i])  # Mantener el conteo sin normalización
        pr = hist_normalizado[i]  # Histograma normalizado
        suma_acum = suma_ac[i]
        multiplicacion = suma_acum * 7
        entero = int(np.round(multiplicacion))

        fila = [intensidad, conteo, round(pr, 4), round(suma_acum, 4), round(multiplicacion, 4), entero]
        tabla.append(fila)

    return tabla

# Leer la imagen
img = utils.read_image('data/naranja.jpg')

# Cuantizar la imagen a 3 bits
img_cuantizada = utils.cuantizar(img, 8, 3)

# Calcular el histograma para la imagen cuantizada
bins = 8  # 2^3 = 8 niveles
total_pixeles = img_cuantizada.size
hist = histograma(img_cuantizada, bins)

# Crear la Look Up Table
lookup_table = crear_lookup_table(hist, total_pixeles)

# Mostrar la tabla
print(f"{'Intensidad':<12}{'Conteo':<12}{'Pr (Norm)':<12}{'Suma Ac.':<12}{'Mult. por 7':<12}{'Entero'}")
for fila in lookup_table:
    print(f"{fila[0]:<12}{fila[1]:<12}{fila[2]:<12}{fila[3]:<12}{fila[4]:<12}{fila[5]}")
print(f"Suma total del conteo: {sum([fila[1] for fila in lookup_table])}")

#LookUpTable (lista)
#Intensidades posibles / Conteo (histograma) / Histograma normalizado (pr) / Suma pr / (L-1)Sumapr / Enteros