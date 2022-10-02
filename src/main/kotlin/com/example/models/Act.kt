package com.example.models

data class Act(
    val id: String = "",
    val name: String = "",
    val yearFirstActive: Int = 1900,
    val yearLastActive: Int = 1900
)

val actStorage = mutableListOf<Act>(
    Act(
        id = "1",
        name = "The Mighty Bobbins",
        yearFirstActive = 1999,
        yearLastActive = 2022
    ),
    Act(
        id = "2",
        name = "Bob Bobbins",
        yearFirstActive = 2018,
        yearLastActive = 2022
    )
)

