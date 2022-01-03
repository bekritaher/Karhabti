package com.example.karhabtifinal.network

import com.example.karhabtifinal.data.AnnonceList
import com.example.karhabtifinal.data.MecanicienList
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("api/authentification/login")
    fun login(
        @Body body: JsonObject
    ): Call<JsonObject>

    @POST("api/authentification/register")
    fun register(
        @Body body: JsonObject
    ): Call<JsonObject>

    @POST("api/Annonce/stores")
    fun stores(
        @Body body: JsonObject
    ): Call<JsonObject>

    @GET("api/Annonce/")
    fun AnnonceList(): Call<AnnonceList>

    @POST("api/mecanicien/store")
    fun store2(
        @Body body: JsonObject
    ): Call<JsonObject>


    @GET("api/mecanicien/index/")
    fun MecanicienList(): Call<MecanicienList>

}