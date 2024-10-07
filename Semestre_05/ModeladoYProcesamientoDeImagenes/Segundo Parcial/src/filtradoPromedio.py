import utils
from scipy.signal import convolve2d

img = utils.read_image('data/caitlinclark.webp')
img_ruido_gaussiano = utils.suma_ruido(img, sigma = 150)

img_convolucionada = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(55), mode='same', boundary='wrap')
img_convolucionada2 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(57), mode='same', boundary='wrap')
img_convolucionada3 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(59), mode='same', boundary='wrap')
img_convolucionada4 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(61), mode='same', boundary='wrap')
img_convolucionada5 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(63), mode='same', boundary='wrap')
img_convolucionada6 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(65), mode='same', boundary='wrap')
img_convolucionada7 = convolve2d(img_ruido_gaussiano, utils.filtro_promedio(67), mode='same', boundary='wrap')

# Lista de Imagenes
list_images = [img,
               img_convolucionada,
               img_convolucionada2,
               img_convolucionada3,
               img_convolucionada4,
               img_convolucionada5,
               img_convolucionada6,
               img_convolucionada7]

list_titles = ['Imagen Original',
               'Filtro 55x55',
               'Filtro 57x57',
               'Filtro 59x59',
               'Filtro 61x61',
               'Filtro 63x63',
               'Filtro 65x65',
               'Filtro 67x67']

utils.plot_images(list_images, list_titles, 4)

img_filtro_gaussiano = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 55), mode='same', boundary='wrap')
img_filtro_gaussiano2 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 57), mode='same', boundary='wrap')
img_filtro_gaussiano3 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 59), mode='same', boundary='wrap')
img_filtro_gaussiano4 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 61), mode='same', boundary='wrap')
img_filtro_gaussiano5 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 63), mode='same', boundary='wrap')
img_filtro_gaussiano6 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 65), mode='same', boundary='wrap')
img_filtro_gaussiano7 = convolve2d(img_ruido_gaussiano, utils.gaussian_kernel(70, 67), mode='same', boundary='wrap')

# Lista de Imagenes
list_images_gaussian = [img,
               img_filtro_gaussiano,
               img_filtro_gaussiano2,
               img_filtro_gaussiano3,
               img_filtro_gaussiano4,
               img_filtro_gaussiano5,
               img_filtro_gaussiano6,
               img_filtro_gaussiano7]

list_titles_gaussian = ['Imagen Original',
               'Filtro Gaussiano 55x55',
               'Filtro Gaussiano 57x57',
               'Filtro Gaussiano 59x59',
               'Filtro Gaussiano 61x61',
               'Filtro Gaussiano 63x63',
               'Filtro Gaussiano 65x65',
               'Filtro Gaussiano 67x67']

utils.plot_images(list_images_gaussian, list_titles_gaussian, 4)