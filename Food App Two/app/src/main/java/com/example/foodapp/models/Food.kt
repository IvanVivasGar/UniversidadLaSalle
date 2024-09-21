package com.example.foodapp.models

data class Food(val id : Int,
                val name: String,
                val price : Double,
                val description: String,
                val image : String,
                val rating : Double,
                val restaurantId : Int
){
    val computedPrice : String get() = "$$price"

    companion object {
        val foods = mutableListOf<Food>(
            // Burger King
            Food(1, "Whopper", 99.8, "Una hamburguesa a la parrilla con tomate, lechuga, mayonesa, ketchup y pepinillos en un suave pan con semillas de sésamo.", "https://bk-latam-prod.s3.amazonaws.com/sites/burgerking.latam/files/BK_Web_WHOPPER_500X540px.png", 4.5, 1),
            Food(2, "Chicken Fries", 59.8, "Tiras de pollo empanizadas en forma de papas fritas, servidas con tu elección de salsas.", "https://www.whopper.ie/wp-content/uploads/2021/04/Chicken_Fries_-1200x800_DE-1.png", 4.3, 1),

            // McDonald's
            Food(3, "Big Mac", 79.8, "Dos hamburguesas de res, salsa especial, lechuga, queso, pepinillos, cebollas en un pan con semillas de sésamo.", "https://i.pinimg.com/originals/38/7a/0d/387a0d5aceb27c67f56309b06ea78f3b.png", 4.6, 2),
            Food(4, "McFlurry", 49.8, "Helado suave con tu elección de ingredientes mezclados a la perfección.", "https://i.pinimg.com/originals/4e/43/26/4e4326fcd0792fe52bf7cc26dd4e8b76.png", 4.7, 2),

            // KFC
            Food(5, "Pollo Original Recipe", 119.8, "Piezas clásicas de pollo jugoso sazonadas con la receta original de KFC.", "https://www.pngmart.com/files/16/Crunchy-KFC-Chicken-PNG-Clipart.png", 4.4, 3),
            Food(6, "Famous Bowl", 99.8, "Puré de papas, maíz dulce, pollo crujiente y salsa gravy, cubierto con queso.", "https://plaza.delivery/uploads/productos/f5a5f3448bae3d4375999af3b77dd94e.png", 4.2, 3),

            // Pizza Hut
            Food(7, "Pizza de Pepperoni", 159.8, "Pizza clásica de pepperoni con queso mozzarella sobre una corteza tradicional de Pizza Hut.", "https://png.pngtree.com/png-clipart/20230928/original/pngtree-pepperoni-pizza-isolated-with-clipping-path-png-image_13007895.png", 4.5, 4),
            Food(8, "Pizza con Orilla Rellena de Queso", 199.8, "Una pizza grande con orilla rellena de queso fundido.", "https://png.pngtree.com/png-clipart/20230928/original/pngtree-pepperoni-pizza-isolated-with-clipping-path-png-image_13007895.png", 4.6, 4),

            // Subway
            Food(9, "Italian B.M.T.", 129.8, "Salami de Génova, pepperoni picante y jamón de la Selva Negra con tu elección de verduras frescas y condimentos en pan recién horneado.", "https://png.pngtree.com/png-clipart/20230421/original/pngtree-italian-bmt-and-cola-subway-package-meal-picture-image_9118978.png", 4.7, 5),
            Food(10, "Meatball Marinara", 119.8, "Albóndigas al estilo italiano en salsa marinara, servidas en pan recién horneado con tu elección de verduras y condimentos.", "https://129757024.cdn6.editmysite.com/uploads/1/2/9/7/129757024/s841251545676646705_p8_i1_w400.png", 4.5, 5),
        )
    }
}
