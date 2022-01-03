package com.example.karhabtifinal.annonceList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.Annonce
import tn.esprit.annoncerecyclerview.annonceList.AnnonceViewHolder
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.util.*


class AnnonceAdapter(val AnnonceList: MutableList<Annonce>, val context: Context) :
    RecyclerView.Adapter<AnnonceViewHolder>() {
    private val placeholder: Drawable? = ContextCompat.getDrawable(context, R.drawable.splash1)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnonceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.annonce_single_item, parent, false)

        return AnnonceViewHolder(view)
    }

    fun loadImageToMovie(
        context: Context,
        source: ByteArray,
        target: ImageView,
        placeholder: Drawable?
    ) {
        if (source == null) {
            Glide.with(context).load(placeholder).into(target)
        } else {
            Glide.with(context).load(source).placeholder(placeholder).error(placeholder)
                .into(target)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: AnnonceViewHolder, position: Int) {
        val edc = AnnonceList[position]
        holder.titre.text = edc.titre
        holder.description.text = edc.description
        holder.marque.text = edc.marque
        //loadImageToMovie(context,edc.image.toByteArray(),holder.pic,null)
        val myByteArray = Base64.getDecoder().decode(edc.image)
        loadImageToMovie(context, myByteArray, holder.pic, null)


        /*  holder.itemView.setOnClickListener{
              val intent = Intent(holder.itemView.context, DetailActivity::class.java)
              intent.apply {


              }
              holder.itemView.context.startActivity(intent)
          }*/

    }


    override fun getItemCount(): Int = AnnonceList.size

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val DESCRIPTION = itemView.findViewById<TextView>(R.id.description)
        val MARQUE = itemView.findViewById<TextView>(R.id.marque)
        val TITRE = itemView.findViewById<TextView>(R.id.titre)
        val IMAGE = itemView.findViewById<TextView>(R.id.titre)

    }
}