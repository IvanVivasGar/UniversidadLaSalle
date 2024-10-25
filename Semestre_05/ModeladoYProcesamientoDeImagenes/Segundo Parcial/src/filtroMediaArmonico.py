import utils

img = utils.read_image('data/pepper.jpg')
imgRuido = utils.ruido_impulsivo(img, 0.2)
imgRuido2 = utils.ruido_impulsivo(img, 0.8)
imgFiltroMediaGeo = utils.media_armonica(imgRuido, 3)
imgFiltroMediaGeo2 = utils.media_armonica(imgRuido2, 3)

utils.plot_images([img,
                   imgRuido2,
                   imgFiltroMediaGeo,
                   imgFiltroMediaGeo2],
                   ['Imagen Original',
                    'Imagen Ruido Impulsivo',
                    'Filtro Media Armonico 0.2',
                    'Filtro Media Armonico 0.8'],
                    'Filtrado Armonico',
                    4)