package edu.ivanvivas.foodapp.models

data class Category (val id:Int, val name:String, val image:String){
    companion object{
        val categories = mutableListOf<Category>(
            Category(1,"Fast Food","https://static.vecteezy.com/system/resources/thumbnails/019/607/567/small_2x/fast-food-vector-clipart-design-graphic-clipart-design-free-png.png"),
            Category(2,"Chinese","https://i.pinimg.com/originals/23/c7/ba/23c7ba22eaf3de0cf11ef32cecf4d8fd.png"),
            Category(3,"Italian","https://png.pngtree.com/png-vector/20230329/ourmid/pngtree-pizza-italian-pie-italian-food-png-image_6673167.png"),
            Category(4,"Mexican","https://images.vexels.com/media/users/3/181353/isolated/preview/1f0da6687abc94f096fef731e614292f-mexico-food-color-illustration.png"),
            Category(5,"American","https://cdn-icons-png.flaticon.com/512/7593/7593369.png"),
        )
    }
}