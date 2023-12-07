package com.example.hw_7_5

data class JokeModel(
    val body: ArrayList<JokeList>
)

data class JokeList(
    val setup: String,
    val punchline: String
)
