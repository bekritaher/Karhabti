package com.example.karhabtifinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.karhabtifinal.data.*


class MecanicienDetail : AppCompatActivity() {

    lateinit var pic: ImageView
    lateinit var name: TextView
    lateinit var adress: TextView
    lateinit var email: TextView
    lateinit var phoneNumber: TextView

    lateinit var birthDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_mecanicien_detail)


        pic = findViewById(R.id.pic2)
        name = findViewById(R.id.name)
        adress = findViewById(R.id.adress)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phoneNumber)
        birthDate = findViewById(R.id.birthDate)

        pic.setImageResource(intent.getIntExtra(PIC, 0))

        val namex = intent.getStringExtra(NAME)
        val adressx = intent.getStringExtra(ADRESS)
        val emailx = intent.getStringExtra(EMAIL)
        val phoneNumberx = intent.getStringExtra(PHONENUMBER)
        val birthDatex = intent.getStringExtra(BIRTHDATE)



        name.text = "$namex"
        adress.text = "$adressx"
        email.text = "$emailx"
        phoneNumber.text = "$phoneNumberx"
        birthDate.text = "$birthDatex"

    }
}