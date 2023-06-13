package com.myss.regulus.network

import com.myss.regulus.model.datosEstudiantesItem
import retrofit2.http.GET
import retrofit2.Call

interface ApiEstudiantes {

    @GET("students")
    fun getEstudiantes(): Call<List<datosEstudiantesItem>>
}
