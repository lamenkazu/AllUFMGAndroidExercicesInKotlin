package com.daedrii.allufmgandroidexercicesinkotlin.e03.fragments

data class Place(
    var name: String?, // nome do local
    var description: String?,
    var photoId: Int?, // id da foto do local
    var distance: Double?, // distância (em km)
    var rate: Float?, // nota (1 a 5)

)