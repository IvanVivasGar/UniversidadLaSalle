package com.ivanvivas.heroesapp.models

data class Publisher (val id:Int, val name:String, val image:String) {
    companion object{
        val publishers = listOf(
            Publisher(0,"Marvel","https://wallpapers.com/images/hd/marvel-pictures-a8zq5u8qw3ega7cx.jpg"),
            Publisher(1,"DC Comics","https://sm.ign.com/ign_es/news/d/dc-comics-/dc-comics-layoffs-reportedly-affect-a-third-of-editorial-sta_g9ap.jpg")
        )
    }
}