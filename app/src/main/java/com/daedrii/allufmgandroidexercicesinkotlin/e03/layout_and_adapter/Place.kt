package com.daedrii.allufmgandroidexercicesinkotlin.e03.layout_and_adapter

data class Place(
    var name: String?, // nome do local
    var photoId: Int?, // id da foto do local
    var distance: Double?, // distância (em km)
    var rate: Float?, // nota (1 a 5)
    var description: String?
)