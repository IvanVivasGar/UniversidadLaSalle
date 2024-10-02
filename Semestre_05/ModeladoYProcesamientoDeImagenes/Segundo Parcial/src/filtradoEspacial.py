import utils
import numpy as np
from scipy.signal import convolve2d, correlate2d

img = utils.read_image('data/caitlinclark.webp')

kernel = np.array([[1, 2, 1], [0, 0, 0], [-1, -2, -1]])

img_convolucionada = convolve2d(img, kernel, mode = 'same', boundary = 'fill', fillvalue = 0)
img_correlacionada = correlate2d(img, kernel, mode = 'same', boundary = 'fill', fillvalue = 0)

utils.plot_images([img, img_convolucionada, img_correlacionada], ['Imagen Original', 'Imagen Convolucionada', 'Imagen Correlacionada'])