import utils

img = utils.read_image('data/pepper.jpg')
imgRuido = utils.ruido_gaussiano(img, 20)
imgRuido2 = utils.ruido_gaussiano(img, 50)
imgFiltroMediaGeo = utils.media_geometrica(imgRuido, 3)
imgFiltroMediaGeo2 = utils.media_geometrica(imgRuido2, 3)

utils.plot_images([img,
                   imgRuido2,
                   imgFiltroMediaGeo,
                   imgFiltroMediaGeo2],
                   ['Imagen Original',
                    'Imagen Ruido Gaussiano',
                    'Filtro Media Geometrica 0.8',
                    'Filtro Media Geometrica 0.9'],
                    'Filtrado Geometrico',
                    4)