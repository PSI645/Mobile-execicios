package com.example.constraintlayout.network

import com.example.constraintlayout.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST(value = "/cadastrar")
    fun criarUsuario(
        @Body user: Usuario
    ): Call<Usuario>
}