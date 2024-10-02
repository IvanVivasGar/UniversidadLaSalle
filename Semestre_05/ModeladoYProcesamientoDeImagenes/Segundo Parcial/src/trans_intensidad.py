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

# # Cuantización a 3 bits
# def cuantizar_3_bits(img):
#     L = 8  # Bits originales (imagen de 8 bits)
#     k = 3  # Bits a los que se va a cuantizar (3 bits)
#     factor_cuantizacion = (2**k - 1) / (2**L - 1)  # Factor de cuantización
#     img_cuantizada = np.floor(img * factor_cuantizacion).astype(np.uint8)
#     return img_cuantizada

img = read_image('/Users/ivanvivasgarcia/Downloads/segundoparcial/data/pepper.jpg')

def histograma(img, bins, normalizar):
    hist = np.zeros(bins)
    w, h = img.shape
    for i in range(w):
        for j in range(h):
            intensidad = int(img[i, j])
            #se suma 1 a la intensidad en el histograma para indicar que se repite una vez
            hist[intensidad] += 1

    if normalizar:
        #dividir cada conteo en el numero total de pixeles (ancho * altura)
        hist /=(w*h) 

    return hist

#Negativo de una imagen
#L son los niveles de intensidad que tiene la imagen (2^8 por ejemplo)
def negativo_img(img, L):
    img_out = (L-1) - img
    return img_out

#Logaritmo (log(1+0)=0     y      log (1+255)=2.4)
#C puede ir de 0 a 106.25
# Función de Logaritmo
def log_img(img, c):
    img = img.astype(np.float64)  # Asegurarse de trabajar con flotantes para evitar errores en el logaritmo
    img_out = c * np.log(1 + img)
    img_out = np.clip(img_out, 0, 255)  # Asegurar que los valores estén dentro del rango [0, 255]
    return img_out.astype(np.uint8)


w, h = img.shape
total_pixeles = w*h

#Parametros del histograma
bins = 256 #2-8
normalizar = True

hist = histograma(img, bins, normalizar)

#Suma acumulada de histograma normalizado
suma_ac = np.cumsum(hist)
print("Suma acumulada del histograma normalizado:")
print(suma_ac)

total = hist.sum()
print(f"⚪️ Número total de píxeles: {total_pixeles}")
print(f"⚪️ Suma del histograma: {total:.5f}")

if normalizar:
    if np.isclose(total, 1, atol=1e-5):
        print('✅ Histograma Normalizado Ok')
    else:
        print('🚨 Fail en normalización')
else:
    if total == total_pixeles:
        print('✅ Histograma no Normalizado Ok')
    else:
        print('🚨 Fail en no normalizada')

plt.bar(range(bins), hist, width=1)
plt.xlabel('Intensidad de píxeles')
if normalizar:
    plt.ylabel('Frecuencia relativa (normalizada)')
else:
    plt.ylabel('Frecuencia')
plt.title('Histograma de la imagen (Normalizado)' if normalizar else 'Histograma de la imagen')
plt.show()

plt.plot(suma_ac, color='b')
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Suma acumulada de la probabilidad')
plt.title('Suma acumulada del histograma normalizado')
plt.show()

# Aplicar la función de negativo de la imagen
L = 256  # Niveles de intensidad para una imagen de 8 bits
img_negativa = negativo_img(img, L)

# Graficar la imagen original
plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.imshow(img, cmap='gray')
plt.title('Imagen Original')
plt.axis('off')

# Graficar la imagen negativa
plt.subplot(1, 2, 2)
plt.imshow(img_negativa, cmap='gray')
plt.title('Imagen Negativa')
plt.axis('off')
plt.show()

# Calcular y graficar el histograma de la imagen negativa
hist_negativa = histograma(img_negativa, bins, normalizar)

plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.bar(range(bins), hist, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen Original')

plt.subplot(1, 2, 2)
plt.bar(range(bins), hist_negativa, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen Negativa')
plt.show()


# Parámetro para la transformación logarítmica
c = 15  # Ajusta este valor según la escala de la imagen

# Aplicar la transformación logarítmica a la imagen
img_log = log_img(img, c)

# Graficar la imagen transformada con logaritmo
plt.subplot(1, 2, 2)
plt.imshow(img_log, cmap='gray')
plt.title('Imagen Transformada con Logaritmo')
plt.axis('off')
plt.show()

# Calcular y graficar el histograma de la imagen transformada con logaritmo
hist_log = histograma(img_log, bins, normalizar)

plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.bar(range(bins), hist, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen Original')

plt.subplot(1, 2, 2)
plt.bar(range(bins), hist_log, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen con Logaritmo')
plt.show()

# Función de corrección gamma
def gamma_img(img, gamma, c=1):
    img = img.astype(np.float64)  # Asegurarse de trabajar con flotantes para evitar errores en la potencia
    img_out = c * np.power(img / 255.0, gamma) * 255.0
    img_out = np.clip(img_out, 0, 255)  # Asegurar que los valores estén dentro del rango [0, 255]
    return img_out.astype(np.uint8)

# Parámetros para la corrección gamma
gamma = 1.7  # Ajusta este valor según la escala de la imagen
c = 0.1  # Ajusta este valor para ver el efecto de la constante

# Aplicar la corrección gamma a la imagen
img_gamma = gamma_img(img, gamma, c)

# Graficar la imagen transformada con corrección gamma
plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.imshow(img, cmap='gray')
plt.title('Imagen Original')
plt.axis('off')

plt.subplot(1, 2, 2)
plt.imshow(img_gamma, cmap='gray')
plt.title('Imagen Transformada con Corrección Gamma')
plt.axis('off')
plt.show()

# Calcular y graficar el histograma de la imagen transformada con corrección gamma
hist_gamma = histograma(img_gamma, bins, normalizar)

plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.bar(range(bins), hist, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen Original')

plt.subplot(1, 2, 2)
plt.bar(range(bins), hist_gamma, width=1)
plt.xlabel('Intensidad de píxeles')
plt.ylabel('Frecuencia relativa (normalizada)' if normalizar else 'Frecuencia')
plt.title('Histograma de la Imagen con Corrección Gamma')
plt.show()
