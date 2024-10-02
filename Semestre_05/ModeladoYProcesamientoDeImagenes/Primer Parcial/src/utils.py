from skimage.io import imread
from skimage.color import rgb2gray
import numpy as np
import matplotlib.pyplot as plt

def read_image(image_path):
    # Leer la imagen
    img = imread(image_path)
    # Si está a color la convertimos a escala de grises
    if len(img.shape) == 3:
        img = rgb2gray(img)
        img = (img * 255).astype(np.uint8)
    else:
        img = img.astype(np.uint8)
    return img

def quantize(img, l):
    q_img = np.floor(img / 255 * (2 ** l))
    return q_img

def image_bit_combination(img, bits):
    combined_img = np.zeros_like(img, dtype=np.uint8)

    for i in range(img.shape[0]): # recorre filas
        for z in range(img.shape[1]): # recorre columnas
            pixel_value = img[i, z]
            binary_str = bin(pixel_value)[2:].zfill(8)
            binary_str_reversed = binary_str[::-1]
            accumulated_value = 0
            for bit in bits:
                bit_value = int(binary_str_reversed[bit])
                accumulated_value += bit_value * (2 ** bit)
            combined_img[i, z] = accumulated_value
    return combined_img

import numpy as np
import matplotlib.pyplot as plt
import utils
# funcion que grafica en un histograma la cantidad de intensidades que se repiten en una imagen


def histograma(img, bins, normalizar):
    hist = np.zeros(bins)
    w, h = img.shape
    for i in range(w):
        for j in range(h):
            intensidad = img[i, j]
            #se suma 1 a la intensidad en el histograma para indicar que se repite una vez
            hist[intensidad] += 1

    if normalizar:
        hist = hist / (w * h)

    return hist

img = utils.read_image('./data/pepper.jpg')
bins = 256 #2-8
hist = histograma(img, bins, True)
total = sum(hist)
print(total)

plt.bar(range(bins), hist)

plt.show()


# img = read_image('C:\\Users\\Ivan Vivas\\Documents\\Repositorios GitHub\\ModeladoYProcesamientoDeImagenes\\Clases\\data\\pepper.jpg')
# print(img)

# plt.imshow(img, cmap='gray')
# plt.axis('off')
# plt.show()

# # Lista para almacenar los diferentes niveles de cuantizacion
# quantize_imgs = []
# for i in range(1, 9):
#     q_img = quantize(img, i)
#     quantize_imgs.append(q_img)

# print(quantize_imgs)

# fig, axes = plt.subplots(2, 4, figsize=(15, 5))
# for i, q_img in enumerate(quantize_imgs):
#     plt.subplot(2, 4, i+1)
#     plt.imshow(q_img, cmap = 'gray')
#     plt.axis('off')
#     plt.title(f'Quantized level {i}')
# plt.show()

# bit_list = [0, 1, 2, 3, 4, 5, 6, 7]
# bit_image = image_bit_combination(img, bit_list)

# print(img)
# print()
# print(bit_image)

# plt.imshow(bit_image, cmap = 'gray')
# plt.axis('off')
# plt.show()