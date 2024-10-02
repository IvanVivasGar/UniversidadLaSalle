import numpy as np
import time
import utils

def trans_trozos1(img, r1):
    w, h = img.shape
    img_out = np.zeros((w, h))
    for x in range(w):
        for y in range(h):
            intensidad = img[x, y]
            if intensidad < r1:
                img_out[x, y] = 0
            else:
                img_out[x, y] = 255
    return img_out

def trans_trozos2(img, r1, r2):
    w, h = img.shape
    img_out = np.zeros((w, h))
    for x in range(w):
        for y in range(h):
            intensidad = img[x, y]
            if intensidad < r1:
                img_out[x, y] = 0
            elif intensidad < r2:
                img_out[x, y] = 128
            else:
                img_out[x, y] = 255
    return img_out

def trans_trozos3(img, LUT):
    w, h = img.shape
    img_out = np.zeros((w, h))
    for x in range(w):
        for y in range(h):
            intensidad = img[x, y]
            img_out[x, y] = LUT[intensidad]
    return img_out

def LUT_trozos(int_max, r1, r2):
    LUT = np.zeros(int_max + 1)
    for i in range(int_max + 1):
        if i < r1:
            LUT[i] = 0
        elif i < r2:
            LUT[i] = 128
        else:
            LUT[i] = 255
    return LUT



    # IMAGEN PEQUEÑA
img_pequena = utils.read_image('data/pepper.jpg')

LUT_pequena = LUT_trozos(255, 100, 150)
inicio_pequena = time.time()
img_pequena_trozos = trans_trozos3(img_pequena, LUT_pequena)
fin_pequena = time.time()
print(f'Tiempo de ejecucion: {fin_pequena - inicio_pequena}')

    # IMAGEN MEDIANA
img_mediana = utils.read_image('data/tetera.jpg')

LUT_mediana = LUT_trozos(255, 80, 160)
inicio_mediana = time.time()
img_mediana_trozos = trans_trozos3(img_mediana, LUT_mediana)
fin_mediana = time.time()
print(f'Tiempo de ejecucion: {fin_mediana - inicio_mediana}')

    # IMAGEN GRANDE
img_grande = utils.read_image('data/caitlinclark.webp')

LUT_grande = LUT_trozos(255, 120, 198)
inicio_grande = time.time()
img_grande_trozos = trans_trozos3(img_grande, LUT_grande)
fin_grande = time.time()
print(f'Tiempo de ejecucion: {fin_grande - inicio_grande}')



images = [img_grande, img_grande_trozos,
          img_mediana, img_mediana_trozos,
          img_pequena, img_pequena_trozos]

img_titles = ["Imagen Grande", "Imagen Grande Trozos",
              "Imagen Mediana", "Imagen Mediana Trozos",
              "Imagen Pequeña", "Imagen Pequeña Trozos"]

utils.plot_images(images, img_titles, 2)