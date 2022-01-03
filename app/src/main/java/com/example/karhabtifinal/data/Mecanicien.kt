package com.example.karhabtifinal.data


import androidx.annotation.DrawableRes

const val PIC = "PIC"
const val NAME = "NAME"
const val ADRESS = "ADRESS"
const val EMAIL = "EMAIL"
const val PHONENUMBER = "PHONENUMBER"
const val BIRTHDATE = "BIRTHDATE"

data class Mecanicien(


    val name: String,

    val adress: String,

    val email: String,

    val phoneNumber: String,

    val birthDate: String

)