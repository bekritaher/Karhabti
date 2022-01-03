package tn.esprit.annoncerecyclerview.mecanicienList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R


class MecanicienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView
    val adress: TextView = itemView.findViewById<TextView>(R.id.adress)
    val phoneNumber: TextView = itemView.findViewById<TextView>(R.id.phoneNumber)


    init {

        name = itemView.findViewById<TextView>(R.id.name)

    }

}