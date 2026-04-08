package com.example.constraintlayout.network

import android.app.admin.TargetUser
import com.example.constraintlayout.model.Usuario
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST(value = "/cadastrar")
    fun criarUsuario(
        @Body user: Usuario
    ): Call<String>
}