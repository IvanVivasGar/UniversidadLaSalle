import numpy as np
import matplotlib.pyplot as plt
import os
from skimage import color
from skimage.io import imread


"""
Function to read an image from a given path, convert it to grayscale if necessary, and return it as an 8-bit unsigned integer array.

Parameters:
    - image_path: String representing the relative path to the image file.

Returns:
    - imagen: 2D numpy array representing the grayscale image.
"""

def read_image(image_path):
    # Extract the base path for the father of the directory in which this .py is located
    current_file_path = os.path.abspath(__file__)
    current_dir = os.path.dirname(current_file_path)
    base_path = os.path.dirname(current_dir)
    final_path = os.path.join(base_path, image_path)

    # Read the image
    imagen = imread(final_path)

    # Convert to grayscale if the image is RGB
    if len(imagen.shape) == 3:
        imagen = color.rgb2gray(imagen)
        imagen = (imagen * 255).astype(np.uint8)
    else:
        imagen = imagen.astype(np.uint8)

    return imagen


"""
Function to plot a list of images with their corresponding titles in a grid layout.

Parameters:
    - images: List of 2D numpy arrays representing the images to be plotted.
    - titles: List of strings representing the titles for each image.
    - fig_title: String representing the title for the entire figure.
    - cols: Integer representing the number of columns in the grid layout (default is 3).

Returns:
    - None
"""

def plot_images(images, titles, fig_title, cols=3):
    assert len(images) == len(titles), "The number of images must match the number of titles"

    n_images = len(images)
    rows = (n_images + cols - 1) // cols  # Calculate the number of rows needed

    fig, axes = plt.subplots(rows, cols, figsize=(cols * 3, rows * 3))  # Set column width to 300 pixels (3 inches) and row height to 300 pixels (3 inches)
    fig.canvas.manager.set_window_title(fig_title)  # Set the window title
    axes = axes.flatten()  # Flatten in case of a single row

    for i, (img, title) in enumerate(zip(images, titles)):
        axes[i].imshow(img, cmap='gray')
        axes[i].set_title(title)
        axes[i].axis('off')

    # Hide any remaining empty subplots
    for j in range(i + 1, len(axes)):
        axes[j].axis('off')

    plt.tight_layout()
    plt.show()


"""
Function to compute the histogram of an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - bins: Integer representing the number of intensities in the histogram.
    - normalizar: Boolean indicating whether to normalize the histogram.

Returns:
    - histograma: 1D numpy array representing the histogram of the image.
"""

def histograma(img, bins, normalizar):
    histograma = np.zeros(bins)
    w, h = img.shape
    for i in range(w):
        for j in range(h):
            intensidad = int(img[i, j])
            # Increment the histogram bin corresponding to the intensity
            histograma[intensidad] += 1

    if normalizar:
        # Normalize the histogram by dividing by the total number of pixels (width * height)
        histograma /= (w * h)

    return histograma


"""
Function to quantize an image from its original bit depth to a target bit depth.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - bits_originales: Integer representing the original bit depth of the image.
    - bits_destino: Integer representing the target bit depth for quantization.

Returns:
    - img_cuantizada: 2D numpy array representing the quantized image.
"""

def cuantizar(img, bits_originales, bits_destino):
    factor_cuantizacion = (2 ** bits_destino - 1) / (2 ** bits_originales - 1)
    img_cuantizada = np.floor(img * factor_cuantizacion).astype(np.uint8)
    return img_cuantizada


"""
Function to create a lookup table for histogram equalization.

Parameters:
    - hist: 1D numpy array representing the histogram of the image.
    - total_pixeles: Integer representing the total number of pixels in the image.

Returns:
    - tabla: List of lists where each sublist contains:
        - intensidad: Original intensity value.
        - conteo: Number of pixels with that intensity.
        - pr: Normalized probability of the intensity.
        - suma_acum: Cumulative distribution function value for the intensity.
        - multiplicacion: Product of the cumulative distribution function value and the maximum intensity value.
        - entero: Rounded integer value of the multiplicacion.
"""

def crear_lookup_table(hist, total_pixeles):
    hist_normalizado = hist / total_pixeles
    suma_ac = np.cumsum(hist_normalizado)

    tabla = []
    for i in range(len(hist)):
        intensidad = i
        conteo = int(hist[i])
        pr = hist_normalizado[i]
        suma_acum = suma_ac[i]
        multiplicacion = suma_acum * (len(hist) - 1)
        entero = int(np.round(multiplicacion))

        fila = [intensidad, conteo, round(pr, 4), round(suma_acum, 4), round(multiplicacion, 4), entero]
        tabla.append(fila)

    return tabla


"""
Function to display a list of images and their corresponding histograms side by side.

Parameters:
    - imagenes: List of 2D numpy arrays representing the grayscale images.
    - titulos_imagenes: List of strings representing the titles for each image.
    - histogramas: List of 1D numpy arrays representing the histograms of the images.
    - titulos_histogramas: List of strings representing the titles for each histogram.

Returns:
    - None
"""

def imagenes_histogramas(imagenes, titulos_imagenes, histogramas, titulos_histogramas):
    assert len(imagenes) == len(titulos_imagenes) == len(histogramas) == len(titulos_histogramas), "All input lists must have the same length"

    n = len(imagenes)
    fig, axes = plt.subplots(n, 2, figsize=(12, 6 * n))

    for i in range(n):
        # Display the image
        axes[i, 0].imshow(imagenes[i], cmap='gray')
        axes[i, 0].set_title(titulos_imagenes[i])
        axes[i, 0].axis('off')

        # Display the histogram
        axes[i, 1].plot(range(len(histogramas[i])), histogramas[i])
        axes[i, 1].set_title(titulos_histogramas[i])
        axes[i, 1].set_xlim([0, len(histogramas[i]) - 1])

    plt.tight_layout()
    plt.show()


"""
Function to add Gaussian noise to an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - sigma: Float representing the standard deviation of the Gaussian noise.

Returns:
    - img_out: 2D numpy array representing the noisy image.
"""

def ruido_gaussiano(img, sigma):
    w, h = img.shape
    img_ruido = np.random.normal(0, sigma, (w, h))
    img_out = img + img_ruido
    img_out = np.clip(img_out, 0, 255).astype(np.uint8)
    return img_out


"""
Function to compute the mean of multiple noisy images.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - n: Integer representing the number of noisy images to generate.
    - sigma: Float representing the standard deviation of the Gaussian noise.

Returns:
    - g_bar: 2D numpy array representing the mean image.
"""

def mean_image(img, n, sigma):
    g_bar = np.zeros(img.shape, dtype=np.float64)
    for r in range(n):
        img_ruidosa = suma_ruido(img, sigma)
        g_bar += img_ruidosa
    g_bar /= n
    g_bar = np.clip(g_bar, 0, 255).astype(np.uint8)
    return g_bar

"""
Function to create an averaging filter kernel.

Parameters:
    - n: Integer representing the size of the kernel (n x n).

Returns:
    - kernel: 2D numpy array representing the averaging filter kernel.
"""

def filtro_promedio(n):
    kernel = 1 / (n * n) * np.ones((n, n))
    return kernel

"""
Function to create a Gaussian filter kernel.

Parameters:
    - sigma: Float representing the standard deviation of the Gaussian distribution.
    - n: Integer representing the size of the kernel (n x n). Must be an odd number.

Returns:
    - kernel: 2D numpy array representing the Gaussian filter kernel.
"""

def gaussian_kernel(sigma, n):
    if n % 2 == 0:
        raise ValueError('Kernel size n should be an odd number')

    # Define grid (x, y) coordinates
    a = -(n // 2)
    b = n // 2
    x, y = np.meshgrid(np.arange(a, b + 1), np.arange(a, b + 1))

    # Compute Gaussian function
    g = 1 / (2 * np.pi * sigma ** 2) * np.exp(-((x ** 2 + y ** 2) / (2 * sigma ** 2)))

    # Normalize so that the sum of the kernel is 1
    g /= g.sum()

    return g

"""
Function to add impulsive noise (salt and pepper noise) to an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - probability: Float representing the probability of a pixel being affected by noise.

Returns:
    - img_ruido: 2D numpy array representing the noisy image.
"""

def ruido_impulsivo(img, probability):
    w, h = img.shape
    img_ruido = np.zeros((w, h))
    probas = np.random.random((w, h))
    ruido = np.random.randint(0, 2, (w,h)) * 255
    for i in range(w):
        for j in range(h):
            if probas[i,j] > probability:
                img_ruido[i,j] = ruido[i,j]
            else:
                img_ruido[i,j] = img[i,j]
    return img_ruido

"""
Function to add multiplicative noise to an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - sigmaM: Float representing the standard deviation of the multiplicative noise.

Returns:
    - img_ruido: 2D numpy array representing the noise applied to the image.
    - img_out: 2D numpy array representing the noisy image.
"""

def multiplicar_ruido(img, sigmaM):
    w, h = img.shape[:2]
    img_ruido = np.random.normal(1, sigmaM, (w, h))
    img_out = img * img_ruido
    img_out = np.clip(img_out, 0, 255).astype(np.uint8)
    return img_out

"""
Function to apply a 2D convolution to an image using a given kernel.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - k: 2D numpy array representing the convolution kernel.

Returns:
    - img_out: 2D numpy array representing the convolved image.
"""

def conv2d(img, kernel):
    kernel_rotado = np.rot90(kernel, 2)
    padding_height = kernel.shape[0] // 2
    padding_width = kernel.shape[1] // 2
    img_padded = np.pad(img, ((padding_height, padding_height), (padding_width, padding_width)), mode='constant', constant_values=0)
    img_out = np.zeros_like(img)
    for i in range(img.shape[0]):
        for j in range(img.shape[1]):
            region = img_padded[i:i + kernel.shape[0], j:j + kernel.shape[1]]
            img_out[i, j] = np.sum(region * kernel_rotado)

    img_out = np.clip(img_out, 0, 255).astype(np.uint8)
    return img_out

"""
Function to apply an arithmetic mean filter to an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - w_size: Integer representing the size of the window (w_size x w_size).

Returns:
    - img_out: 2D numpy array representing the filtered image.
"""

def media_aritmetica(img, w_size, str_filtro):
    padding_height = w_size // 2
    padding_width = w_size // 2
    img_padded = np.pad(img, ((padding_height, padding_height), (padding_width, padding_width)), mode='constant', constant_values=0)
    img_out = np.zeros_like(img)
    for i in range(img.shape[0]):
        for j in range(img.shape[1]):
            region = img_padded[i:i + w_size, j:j + w_size]
            img_out[i, j] = np.mean(region)

    return img_out

"""
Function to apply a geometric mean filter to an image.

Parameters:
    - img: 2D numpy array representing the grayscale image.
    - w_size: Integer representing the size of the window (w_size x w_size).

Returns:
    - img_out: 2D numpy array representing the filtered image.

Note:
    - Bad for impulsive noise
"""

def media_geometrica(img, w_size):
    padding_height = w_size // 2
    padding_width = w_size // 2
    img_padded = np.pad(img, ((padding_height, padding_height), (padding_width, padding_width)), mode='constant', constant_values=0)
    img_out = np.zeros(img.shape)
    for i in range(img.shape[0]):
        for j in range(img.shape[1]):
            region = img_padded[i:i + w_size, j:j + w_size]
            img_out[i, j] = (np.prod(region)) ** (1/w_size)
    return img_out