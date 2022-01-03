package com.example.karhabtifinal

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.karhabtifinal.data.Annonce
import com.example.karhabtifinal.data.AnnonceList
import tn.esprit.annoncerecyclerview.annonceList.AnnonceViewHolder
import java.util.*

class DetailsFragment : Fragment() {
    lateinit var pic: ImageView
    lateinit var titre: TextView
    lateinit var marque: TextView
    lateinit var description: TextView
    lateinit var gouvernorat: TextView

    lateinit var delegation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_detail)

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

        /*     @RequiresApi(Build.VERSION_CODES.O)
        fun onBindViewHolder(holder: AnnonceViewHolder, position: Int) {

                 val edc = annonce
            holder.titre.text=edc.titre
            holder.description.text = edc.description
            holder.marque.text = edc.marque
            //loadImageToMovie(context,edc.image.toByteArray(),holder.pic,null)
            val myByteArray = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Base64.getDecoder().decode(edc.image)
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            loadImageToMovie(context, myByteArray, holder.pic, null)

        }*/
    }

}