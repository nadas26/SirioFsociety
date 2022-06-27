package com.example.siriofsociety

class ArticleModel (
    val id: String = "table0",
    val description: String = "Texte descriptif de l'article",
    val name: String = "Table Ronde",
    val prix: String = "756€",
    val imageURL: String = "https://media.kavehome.com/media/cache/df/75/df754cc10396c9875dce3d019e1fa9ff.jpg",
    val category: String = "Tables",
    var like: Boolean = false,
    var cart: Boolean = false,
    var rating: Int = 3,
)