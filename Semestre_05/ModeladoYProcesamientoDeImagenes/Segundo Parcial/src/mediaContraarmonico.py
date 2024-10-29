import utils

img = utils.read_image('data/pepper.jpg')
imgRuido = utils.ruido_impulsivo(img, 0.8)
imgFiltroMediaConarm = utils.media_contraarmonico(imgRuido, 3, 0)
imgFiltroMediaConarm2 = utils.media_contraarmonico(imgRuido, 3, -1)

utils.plot_images([img,
                   imgRuido,
                   imgFiltroMediaConarm,
                   imgFiltroMediaConarm2],
                   ['Imagen Original',
                    'Imagen Ruido Impulsivo',
                    'Filtro Media Contrarmonico 0',
                    'Filtro Media Contrarmonico -1'],
                    'Filtrado Contraarmonico',
                    4)