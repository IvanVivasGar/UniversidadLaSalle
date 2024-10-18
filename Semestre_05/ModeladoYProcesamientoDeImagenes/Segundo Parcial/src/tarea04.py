import utils
from scipy.signal import convolve2d

img = utils.read_image('data/pepper.jpg')
img_impulsivo = utils.ruido_impulsivo(img, 0.7)

img_conv_personal_gaussiano = utils.conv2d(img_impulsivo, utils.gaussian_kernel(10, 5))
img_conv_scipy_gaussiano = convolve2d(img_impulsivo, utils.gaussian_kernel(10, 5), mode='same', boundary='wrap')

img_conv_personal_promedio = utils.conv2d(img_impulsivo, utils.filtro_promedio(5))
img_conv_scipy_promedio = convolve2d(img_impulsivo, utils.filtro_promedio(5), mode='same', boundary='wrap')

utils.plot_images([img,
                   img_conv_personal_gaussiano,
                   img_conv_scipy_gaussiano, img_impulsivo,
                   img_conv_personal_promedio,
                   img_conv_scipy_promedio],
                   ["Imagen Original",
                    "Convolucion Personal Filtro Gaussiano",
                    "Convolucion Scipy Filtro Gaussiano",
                    "Imagen con Ruido Impulsivo",
                    "Convolucion Personal Filtro Promedio",
                    "Convolucion Scipy Filtro Promedio"],
                    3)