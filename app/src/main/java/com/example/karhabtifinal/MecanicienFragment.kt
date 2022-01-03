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
import com.example.karhabtifinal.mecanicienList.MecanicienAdapter
import com.example.karhabtifinal.data.Mecanicien
import com.example.karhabtifinal.data.MecanicienList
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.android.material.card.MaterialCardView
import retrofit2.Response
import javax.security.auth.callback.Callback
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit


class MecanicienFragment : Fragment() {


    lateinit var recylcerMecanicien: RecyclerView
    lateinit var recylcerMecanicienAdapter: MecanicienAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mecanicien, container, false)



        recylcerMecanicien = view.findViewById(R.id.recyclerMecanicien)
        var mecanicienList: MutableList<Mecanicien> = ArrayList()





        recylcerMecanicienAdapter = MecanicienAdapter(mecanicienList)

        recylcerMecanicien.adapter = recylcerMecanicienAdapter

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.MecanicienList().enqueue(object : retrofit2.Callback<MecanicienList> {
            override fun onResponse(
                call: retrofit2.Call<MecanicienList>,
                response: Response<MecanicienList>
            ) {
                response.body()?.mecanicien?.let { mecanicienList.addAll(it) }
                recylcerMecanicienAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: retrofit2.Call<MecanicienList>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })

        recylcerMecanicien.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return view


    }
}