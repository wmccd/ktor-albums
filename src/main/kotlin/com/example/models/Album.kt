package com.example.models

data class Album(
    val id: String = "",
    val actId: String = "",
    val title: String = "",
    val releaseYear: Int = 0,
    val trackCount: Int = 0
)

val albumStorage = mutableListOf<Album>(
    Album(
        id = "1",
        actId = "1",
        title = "Mighty Fine Bobbin'",
        releaseYear = 2018,
        trackCount = 12
    ),
    Album(
        id = "2",
        actId = "1",
        title = "Bobbin', But Gently'",
        releaseYear = 2017,
        trackCount = 11
    ),
    Album(
        id = "3",
        actId = "1",
        title = "Bobbin the Night Away",
        releaseYear = 2015,
        trackCount = 14
    ),
    Album(
        id = "4",
        actId = "2",
        title = "The Killing Floor Bob",
        releaseYear = 2017,
        trackCount = 11
    ),
)
