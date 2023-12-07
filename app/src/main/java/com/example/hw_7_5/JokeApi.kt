package com.example.hw_7_5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface JokeApi {
    @GET("random/joke")
    fun getJoke(
        @Header("X-RapidAPI-Key") key:String = "7753737404msh1de34a18e6f9f85p107731jsne1168a9b8ff3",
        @Header("X-RapidAPI-Host") host: String = "dad-jokes.p.rapidapi.com"
    ):Call<JokeModel>

}