import utils

img = utils.read_image('data/pepper.jpg')
imgRuido = utils.ruido_impulsivo(img, 0.9)
imgFiltroMediana = utils.filtro_mediana(imgRuido, 3)
imgFiltroMediana2 = utils.filtro_mediana(imgRuido, 5)

utils.plot_images([img,
                   imgRuido,
                   imgFiltroMediana,
                   imgFiltroMediana2],
                   ['Imagen Original',
                    'Imagen Ruido Impulsivo',
                    'Filtro Mediana',
                    'Filtro Mediana'],
                    'Filtrado Mediana',
                    4)