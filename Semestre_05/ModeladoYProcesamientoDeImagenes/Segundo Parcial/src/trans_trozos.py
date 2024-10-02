import numpy as np
from skimage.io import imread
import matplotlib.pyplot as plt
from skimage import color
import time

def read_image(image_path):
    img = imread(image_path)
    if len(img.shape) == 3:
        img = color.rgb2gray(img)
        img = (img*255).astype(np.uint8)
    else:
        img = img.astype(np.uint8)
    return img

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

# Read the image
image_path = '/Users/ivanvivasgarcia/Downloads/segundoparcial/data/caitlinclark.webp'
img = read_image(image_path)

LUT = LUT_trozos(255, 120, 198)
inicio = time.time()
img2 = trans_trozos3(img, LUT)
fin = time.time()
print(fin - inicio)


        # IMAGEN PEQUEÑA
# Read another image
image_path2 = '/Users/ivanvivasgarcia/Downloads/segundoparcial/data/pepper.jpg'
img3 = read_image(image_path2)

LUT2 = LUT_trozos(255, 100, 150)
inicio2 = time.time()
img4 = trans_trozos3(img3, LUT2)
fin2 = time.time()
print(fin2 - inicio2)

# Display the second original image
plt.figure(figsize=(12, 6))
plt.subplot(2, 2, 1)
plt.imshow(img3, cmap='gray')
plt.title('Original Image 2')
plt.axis('off')

# Display the second transformed image
plt.subplot(2, 2, 2)
plt.imshow(img4, cmap='gray')
plt.title('Transformed Image 2')
plt.axis('off')

# Display the histogram of the second original image
plt.subplot(2, 2, 3)
plt.hist(img3.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Original Histogram 2')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

# Display the histogram of the second transformed image
plt.subplot(2, 2, 4)
plt.hist(img4.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Transformed Histogram 2')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

plt.tight_layout()
plt.show()


        # IMAGEN MEDIANA
# Read a third image
image_path3 = '/Users/ivanvivasgarcia/Downloads/segundoparcial/data/tetera.jpg'
img5 = read_image(image_path3)

LUT3 = LUT_trozos(255, 80, 160)
inicio3 = time.time()
img6 = trans_trozos3(img5, LUT3)
fin3 = time.time()
print(fin3 - inicio3)

# Display the third original image
plt.figure(figsize=(12, 6))
plt.subplot(2, 2, 1)
plt.imshow(img5, cmap='gray')
plt.title('Original Image 3')
plt.axis('off')

# Display the third transformed image
plt.subplot(2, 2, 2)
plt.imshow(img6, cmap='gray')
plt.title('Transformed Image 3')
plt.axis('off')

# Display the histogram of the third original image
plt.subplot(2, 2, 3)
plt.hist(img5.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Original Histogram 3')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

# Display the histogram of the third transformed image
plt.subplot(2, 2, 4)
plt.hist(img6.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Transformed Histogram 3')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

plt.tight_layout()
plt.show()

        # IMAGEN GRANDE
# Display the original image
plt.figure(figsize=(12, 6))
plt.subplot(2, 2, 1)
plt.imshow(img, cmap='gray')
plt.title('Original Image')
plt.axis('off')

# Display the transformed image
plt.subplot(2, 2, 2)
plt.imshow(img2, cmap='gray')
plt.title('Transformed Image')
plt.axis('off')

# Display the histogram of the original image
plt.subplot(2, 2, 3)
plt.hist(img.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Original Histogram')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

# Display the histogram of the transformed image
plt.subplot(2, 2, 4)
plt.hist(img2.ravel(), bins=256, color='black', alpha=0.75)
plt.title('Transformed Histogram')
plt.xlabel('Pixel intensity')
plt.ylabel('Frequency')

plt.tight_layout()
plt.show()