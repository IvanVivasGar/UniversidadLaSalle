import utils

img = utils.read_image('data/pepper.jpg')
imgRuido = utils.ruido_gaussiano(img, 20)
imgFiltroMedia = utils.media_aritmetica(img, 3)

utils.plot_images([img, imgRuido, imgFiltroMedia], ['Imagen Original', 'Imagen Ruido Gaussiano', 'Imagen Filtro Media Aritmetica'], 3)