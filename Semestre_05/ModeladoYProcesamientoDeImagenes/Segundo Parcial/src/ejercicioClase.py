import utils
from scipy.signal import convolve2d

def crear_listas_convolve(img, lista_kernels, funcion):
    lista_convolve = []

    # Check if img is a list
    if isinstance(img, list):
        for single_img in img:
            lista_convolve.extend(crear_listas_convolve(single_img, lista_kernels, funcion))
        return lista_convolve

    if funcion == "promedio":
        for size in lista_kernels:
            kernel = utils.filtro_promedio(size)
            convoluted_img = convolve2d(img, kernel, mode='same', boundary='wrap')
            lista_convolve.append(convoluted_img)
    else:
        for size in lista_kernels:
            kernel = utils.gaussian_kernel(10, size)
            convoluted_img = convolve2d(img, kernel, mode='same', boundary='wrap')
            lista_convolve.append(convoluted_img)

    return lista_convolve

img = utils.read_image('data/pepper.jpg')

img_ruido_gaussiano = utils.ruido_gaussiano(img, 30)
img_ruido_multiplicativo = utils.multiplicar_ruido(img, 0.5)
img_ruido_impulsivo = utils.ruido_impulsivo(img, 0.7)

# FILTRO PROMEDIO

img_gauss_filtro_prom_list = crear_listas_convolve(img_ruido_gaussiano, [3, 5, 7, 9, 11, 13, 15, 17], "promedio")
img_multi_filtro_prom_list = crear_listas_convolve(img_ruido_multiplicativo, [3, 5, 7, 9, 11, 13, 15, 17], "promedio")
img_impul_filtro_prom_list = crear_listas_convolve(img_ruido_impulsivo, [3, 5, 7, 9, 11, 13, 15, 17], "promedio")

utils.plot_images(img_gauss_filtro_prom_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)
utils.plot_images(img_multi_filtro_prom_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)
utils.plot_images(img_impul_filtro_prom_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)

# FILTRO GAUSSIANO

img_gauss_filtro_gauss_list = crear_listas_convolve(img_ruido_gaussiano, [3, 5, 7, 9, 11, 13, 15, 17], "gaussiano")
img_multi_filtro_gauss_list = crear_listas_convolve(img_ruido_multiplicativo, [3, 5, 7, 9, 11, 13, 15, 17], "gaussiano")
img_impul_filtro_gauss_list = crear_listas_convolve(img_ruido_impulsivo, [3, 5, 7, 9, 11, 13, 15, 17], "gaussiano")

utils.plot_images(img_gauss_filtro_gauss_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)
utils.plot_images(img_multi_filtro_gauss_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)
utils.plot_images(img_impul_filtro_gauss_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)

# DOBLE FILTRADO PROM
img_gauss_doble_filtro_prom_list = crear_listas_convolve(img_ruido_gaussiano, [3, 5, 7, 9, 11, 13, 15, 17], "promedio")
utils.plot_images(img_gauss_doble_filtro_prom_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)

# DOBLE FILTRADO GAUSSIANO
img_gauss_doble_filtro_gauss_list = crear_listas_convolve(img_ruido_gaussiano, [3, 5, 7, 9, 11, 13, 15, 17], "gaussiano")
utils.plot_images(img_gauss_doble_filtro_gauss_list, ["3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15", "17x17"], 4)