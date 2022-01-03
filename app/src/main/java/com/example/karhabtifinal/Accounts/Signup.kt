package com.example.karhabtifinal.Accounts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.karhabtifinal.MainActivity
import com.example.karhabtifinal.network.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import com.example.karhabtifinal.R
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initAction()
    }

    fun initAction() {
        buttonSub.setOnClickListener {

            val email = loginEmail.text.toString().trim()
            val name = loginNom.text.toString().trim()
            val password = loginMdp.text.toString().trim()
            val confirmPassword = loginMdp2.text.toString().trim()
            val phoneNumber = loginNumber.text.toString().trim()
            val birthDate = loginDate.text.toString().trim()

            /*  if(email.isEmpty()){
                  loginEmail.error="Email vide!"
                  loginEmail.requestFocus()
                  return@setOnClickListener
              }
              if(name.isEmpty()){
                  loginNom.error="Email vide!"
                  loginNom.requestFocus()
                  return@setOnClickListener
              }
              if(password.isEmpty()){
                  loginMdp.error="Mot de passe vide!"
                  loginMdp.requestFocus()
                  return@setOnClickListener
              }
              if(confirmPassword.isEmpty()){
                  loginMdp2.error="Confirm Mot de passe vide!"
                  loginMdp2.requestFocus()
                  return@setOnClickListener
              }
              if(phoneNumber.isEmpty()){
                  loginNumber.error="Numéro Télephone vide!"
                  loginNumber.requestFocus()
                  return@setOnClickListener
              }
              if(birthDate.isEmpty()){
                  loginDate.error="Date de naissance vide!"
                  loginDate.requestFocus()
                  return@setOnClickListener
              }*/
            Register()

        }
    }

    fun Register() {
        val paramObject1 = JSONObject()
        paramObject1.put("email", loginEmail.text.toString().trim())
        paramObject1.put("name", loginNom.text.toString().trim())
        paramObject1.put("password", loginMdp.text.toString().trim())
        paramObject1.put("confirmPassword", loginMdp2.text.toString().trim())
        paramObject1.put("phoneNumber", loginNumber.text.toString().trim())
        paramObject1.put("birthDate", loginDate.text.toString().trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)

        retro.register(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                initgo()
                Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }


    fun initgo() {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
}


