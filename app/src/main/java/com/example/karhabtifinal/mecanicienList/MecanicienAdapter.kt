package com.example.karhabtifinal.mecanicienList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.MecanicienDetail
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.Mecanicien
import com.example.karhabtifinal.data.*
import tn.esprit.annoncerecyclerview.mecanicienList.MecanicienViewHolder


class MecanicienAdapter(val MecanicienList: MutableList<Mecanicien>) :
    RecyclerView.Adapter<MecanicienViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicienViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mecanicien_single_item, parent, false)

        return MecanicienViewHolder(view)
    }

    override fun onBindViewHolder(holder: MecanicienViewHolder, position: Int) {

        val name = MecanicienList[position].name
        val adress = MecanicienList[position].adress
        val email = MecanicienList[position].email
        val phoneNumber = MecanicienList[position].phoneNumber
        val birthDate = MecanicienList[position].birthDate



        holder.name.text = name
        holder.adress.text = adress
        holder.phoneNumber.text = phoneNumber


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MecanicienDetail::class.java)
            intent.apply {

                putExtra(NAME, name)
                putExtra(ADRESS, adress)
                putExtra(EMAIL, email)
                putExtra(PHONENUMBER, phoneNumber)
                putExtra(BIRTHDATE, birthDate)

            }
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = MecanicienList.size

}