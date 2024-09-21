import utils
import numpy as np
import matplotlib.pyplot as plt

#    for i in range (img2.shape[0]):
#        for z in range(img2.shape[1]):
#            if img2[i][z] == 0:
#                img2[i][z] = img2[i][z] + img1[i][z]


def actividad(img1, img2):
    mask = (img2 == 0)
    img2[mask] += img1[mask]
    return img2

def sumar_imagenes(img1, img2, alpha):
    return (1 - alpha) * img1 + (alpha * img2)

def restar_imagenes(img1, img2):
    img_resultante = img1 - img2
    return np.clip(img_resultante, 0, 255)

def multiplicar_imagenes(img1, img2):
    img_resultante = img1 * img2
    return np.clip(img_resultante, 0, 255)

def division_imagenes(img1, img2):
    img_resultante = img1 / img2 + 0.000001
    return np.clip(img_resultante, 0, 255)

def suma_ponderada(img1, img2, a):
    return (1-a) * img1 + a*img2

def suma_ruido(img, sigma):
    w, h = img.shape
    img_ruido = np.random.normal(0, sigma, (w, h))
    img_out = np.clip(img + img_ruido, 0, 255)
    return img_ruido, img_out

# img = utils.read_image('data\\caitlinClark.jpg')

# img1 = utils.read_image('C:\\Users\\Ivan Vivas\\Documents\\Repositorios GitHub\\ModeladoYProcesamientoDeImagenes\\Clases\\data\\corridor.jpg')
# img2 = utils.read_image('C:\\Users\\Ivan Vivas\\Documents\\Repositorios GitHub\\ModeladoYProcesamientoDeImagenes\\Clases\\data\\person.jpg')

# img_resultante = sumar_imagenes(img1, img2, 0.1)
# img_resultante_resta = restar_imagenes(img1, img2)
# img_resultante_multiplicacion = multiplicar_imagenes(img1, img2,)
# img_resultante_division = division_imagenes(img1, img2)
# img_resultante_actividad = actividad(img1, img2)

# plt.imshow(img_resultante_multiplicacion, cmap='gray')
# plt.axis('off')
# plt.show()

# img_ruido, img_out = suma_ruido(img, 50)
# plt.figure(figsize = (12, 6))

# plt.subplot(1, 3, 1)
# plt.title("Imagen Original")
# plt.imshow(img, cmap='gray')
# plt.axis('off')

# plt.subplot(1, 3, 2)
# plt.title("Ruido")
# plt.imshow(img_ruido, cmap='gray')
# plt.axis('off')

# plt.subplot(1, 3, 3)
# plt.title("Imagen con Ruido")
# plt.imshow(img_out, cmap='gray')
# plt.axis('off')

# plt.show()