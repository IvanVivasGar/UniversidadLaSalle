package edu.ivanvivas.foodapp.models

data class Restaurant(val id: Int,val name:String,val image:String){
    companion object{
        val restaurants = mutableListOf<Restaurant>(
            Restaurant(1,"Burger King","https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Burger_King_logo_%281999%29.svg/2024px-Burger_King_logo_%281999%29.svg.png"),
            Restaurant(2,"McDonald's","https://brandemia.org/contenido/subidas/2022/10/marca-mcdonalds-logo-1024x572.png"),
            Restaurant(3,"KFC","https://grains.org/lta/wp-content/uploads/sites/6/2018/01/KFC-logo-MAIN-STORY.png"),
            Restaurant(4,"Pizza Hut","https://graffica.info/wp-content/uploads/2017/07/Pizza_Hut_Logo_3.png"),
            Restaurant(5,"Subway","https://newsroom.subway.com/download/Subway+Choicemark.png"),
        )
    }
}