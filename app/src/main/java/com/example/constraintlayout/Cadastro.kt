package com.example.constraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constraintlayout.model.Usuario
import com.example.constraintlayout.network.ApiClient1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Cadastro : AppCompatActivity() {

    private val apiService = ApiClient1.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nome = findViewById<EditText>(R.id.editTextNome)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)
        val cpf = findViewById<EditText>(R.id.editTextCPF)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val senha = findViewById<EditText>(R.id.editTextSenha)

        var btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            var usuario = Usuario(
                nome = nome.text.toString(),
                email = email.text.toString(),
                telefone = telefone.text.toString(),
                senha = senha.text.toString(),
                cpf = cpf.text.toString()
            )

            fazerCadastro(usuario)

        }
    }
    fun fazerCadastro(usuario: Usuario) {
        apiService.criarUsuario(usuario).enqueue(object : Callback<Usuario> {

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@Cadastro,
                        "Cadastrado com Sucesso",
                        Toast.LENGTH_LONG
                    ).show()

                } else {
                    Toast.makeText(
                        this@Cadastro,
                        "Erro: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(
                    this@Cadastro,
                    "Falha na rede: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
                println(t.message)
            }
        })
    }

}
