package com.example.karhabtifinal


import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.customview.widget.ViewDragHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.annonceList.AnnonceAdapter
import com.example.karhabtifinal.data.Annonce
import com.example.karhabtifinal.data.AnnonceList
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.android.material.card.MaterialCardView
import retrofit2.Response
import javax.security.auth.callback.Callback
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit


class AnnoncesFragment : Fragment() {


    lateinit var recylcerAnnonce: RecyclerView
    lateinit var recylcerAnnonceAdapter: AnnonceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_annonces, container, false)



        recylcerAnnonce = view.findViewById(R.id.recyclerAnnonce)
        var annonceList: MutableList<Annonce> = ArrayList()

        recylcerAnnonceAdapter = AnnonceAdapter(annonceList, requireContext())

        recylcerAnnonce.adapter = recylcerAnnonceAdapter

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.AnnonceList().enqueue(object : retrofit2.Callback<AnnonceList> {
            override fun onResponse(
                call: retrofit2.Call<AnnonceList>,
                response: Response<AnnonceList>
            ) {
                response.body()?.annonce?.let { annonceList.addAll(it) }
                recylcerAnnonceAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: retrofit2.Call<AnnonceList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        recylcerAnnonce.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return view


    }
}

//private fun doList() {
//  var annonceliste : MutableList<Annonce> = ArrayList()
//   val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
//     retro.AnnonceList().enqueue(object : Callback<AnnonceList> {
//
//       //     override fun onResponse(call: Call<AnnonceList>, response: Response<AnnonceList>) {
//                Toast.makeText(context, "Liste in ", Toast.LENGTH_SHORT).show()
//                if (response.body().toString() != "")
//                //  Log.e("listNews", response.body().toString())
//                {
//                    val annonceList: AnnonceList = response.body() as AnnonceList
//                    // Log.e("list",response.body().toString())
//                    for (i: Annonce in annonceList.annonce) {
//                        annonceliste.add(
//                 //           Annonce(_id = i._id, title = i.title, description = i.description,date = i.date)
//                        )
//                        Toast.makeText(context, "ajout  ", Toast.LENGTH_SHORT).show()
//                    }
//                   // AnnonceAdapter = AnnonceAdapter(annonceliste)
//               //     annonceRecyclerView.adapter = AnnonceAdapter
//             //       annonceRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                }
//            }
//
//            //override fun onFailure(call: Call<AnnonceList>, t: Throwable) {
//              //  Log.e("Error", t.message.toString())
//               // Toast.makeText(context, "Liste out ", Toast.LENGTH_SHORT).show()
//            //}
//        })
//
//    }
//}
//
