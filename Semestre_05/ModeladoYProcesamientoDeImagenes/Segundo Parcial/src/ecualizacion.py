import numpy as np
import utils

#Función de ecualización de histograma usando la LUT
def histogram_equalization(img):
    total_pixeles = img.size
    hist = utils.histograma(img, 256, False)
    lookup_table = utils.crear_lookup_table(hist, total_pixeles)

    #Aplicar la LUT a la imagen
    img_eq = np.zeros_like(img)
    for i in range(img.shape[0]):
        for j in range(img.shape[1]):
            pixel = img[i, j]
            img_eq[i, j] = lookup_table[pixel][5]

    return img_eq

def imprimir_imagenes(img_original):
    img_cuantizada = utils.cuantizar(img_original, 8, 3)

    histograma_img_original = utils.histograma(img_original, 256, False)
    histograma_img_cuantizada = utils.histograma(img_cuantizada, 256, False)

    img_original_ecualizada = histogram_equalization(img_original)
    img_cuantizada_ecualizada = histogram_equalization(img_cuantizada)

    histograma_original_ecualizada = utils.histograma(img_original_ecualizada, 256, False)
    histograma_cuantizada_ecualizada = utils.histograma(img_cuantizada_ecualizada, 256, False)

        # LISTAS DE IMAGENES E HISTOGRAMAS
    lista_pre = [img_original, img_cuantizada]
    lista_titulos_pre = ['Imagen Original', 'Imagen Cuantizada']
    lista_histograma_pre = [histograma_img_original, histograma_img_cuantizada]

    lista_ecualizada = [img_original_ecualizada, img_cuantizada_ecualizada]
    lista_titulos_ecualizados = ['Imagen Original Ecualizada', 'Imagen Cuantizada Ecualizada']
    lista_histograma_ecualizada = [histograma_original_ecualizada, histograma_cuantizada_ecualizada]

    lista_titulos_histogramas = ['Histograma', 'Histograma']

    utils.imagenes_histogramas(lista_pre, lista_titulos_pre, lista_histograma_pre, lista_titulos_histogramas)
    utils.imagenes_histogramas(lista_ecualizada, lista_titulos_ecualizados, lista_histograma_ecualizada, lista_titulos_histogramas)

img1 = utils.read_image('data/moon.jpg')
img2 = utils.read_image('data/flor.jpg')

imprimir_imagenes(img1)
imprimir_imagenes(img2)