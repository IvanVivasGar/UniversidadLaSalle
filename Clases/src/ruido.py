import matplotlib.pyplot as plt
from skimage import color
from skimage.io import imread
import numpy as np
import utils

# Cargar la imagen y convertirla a tipo float32
img1 = utils.read_image('Clases\\data\\pepper.jpg').astype(np.float32)

# Función para añadir ruido gaussiano a una imagen
def agregar_ruido(img, sigma):
    filas, columnas = img.shape
    ruido = np.random.normal(0, sigma, (filas, columnas))
    img_con_ruido = img + ruido
    img_con_ruido = np.clip(img_con_ruido, 0, 255).astype(np.uint8)
    return img_con_ruido

# Función para calcular el promedio de imágenes con ruido
def promedio_imagen(img, num_imagenes, sigma):
    acumulador = np.zeros(img.shape, dtype=np.float64)
    for _ in range(num_imagenes):
        img_ruidosa = agregar_ruido(img, sigma)
        acumulador += img_ruidosa
    acumulador /= num_imagenes
    acumulador = np.clip(acumulador, 0, 255).astype(np.uint8)
    return acumulador

# Listas de valores para el número de imágenes y el sigma del ruido
num_imagenes_lista = [2, 8, 16]
sigma_lista = [10, 30, 50]

# Crear una figura con subgráficos
fig, axes = plt.subplots(len(num_imagenes_lista), len(sigma_lista), figsize=(12, 8))

# Ajustar la estructura de 'axes' según el número de valores en las listas
if len(num_imagenes_lista) == 1 and len(sigma_lista) == 1:
    axes = [[axes]]
elif len(num_imagenes_lista) == 1:
    axes = [axes]
elif len(sigma_lista) == 1:
    axes = [[ax] for ax in axes]

# Generar y mostrar las imágenes con ruido promedio
for i, num_imagenes in enumerate(num_imagenes_lista):
    for j, sigma in enumerate(sigma_lista):
        img_promedio = promedio_imagen(img1, num_imagenes, sigma)
        axes[i][j].imshow(img_promedio, cmap='gray')
        axes[i][j].axis('off')
        axes[i][j].set_title(f'n={num_imagenes}, σ={sigma}')

plt.tight_layout()
plt.show()