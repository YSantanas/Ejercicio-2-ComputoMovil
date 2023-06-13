package com.myss.regulus.Pnetwork

import com.myss.regulus.model.datosEstudiantesItem
import retrofit2.http.GET
import retrofit2.Call

interface ApiProfesor {

    @GET("staff")
    fun getProfesor(): Call<List<datosEstudiantesItem>>
}
