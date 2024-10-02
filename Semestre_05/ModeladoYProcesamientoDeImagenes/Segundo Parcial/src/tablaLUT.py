import matplotlib.pyplot as plt
from skimage import color 
from skimage.io import imread
import numpy as np

def read_image(image_path):
    img = imread(image_path)
    if len(img.shape) == 3:
        img = color.rgb2gray(img)
        img = (img*255).astype(np.uint8)
    else: 
        img = img.astype(np.uint8)
    return img

# Cuantización a 3 bits
def cuantizar_3_bits(img):
    L = 8  # Bits originales (imagen de 8 bits)
    k = 3  # Bits a los que se va a cuantizar (3 bits)
    factor_cuantizacion = (2**k - 1) / (2**L - 1)  # Factor de cuantización
    img_cuantizada = np.floor(img * factor_cuantizacion).astype(np.uint8)
    return img_cuantizada

img = read_image('/Users/ivanvivasgarcia/Downloads/segundoparcial/data/naranja.jpg')

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

# Cuantizar la imagen a 3 bits
img_cuantizada = cuantizar_3_bits(img)

# Calcular el histograma para la imagen cuantizada
bins = 8  # 2^3 = 8 niveles
#normalizar = True
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