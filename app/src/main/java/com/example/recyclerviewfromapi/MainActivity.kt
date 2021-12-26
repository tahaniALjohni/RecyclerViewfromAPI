package com.example.recyclerviewfromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var nameList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val recyclerview=findViewById<RecyclerView>(R.id.recycler)
        recyclerview.layoutManager= LinearLayoutManager(this)

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface!!.getClient()?.enqueue(object : Callback<Person?> {
            override fun onResponse(call: Call<Person?>, response: Response<Person?>) {
                nameList= arrayListOf()

                val people = response.body()!!
                for (index in people) nameList.add("${index.name}")

                recyclerview.adapter= RecyclerViewAdapter(nameList)
                recyclerview.adapter?.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<Person?>, t: Throwable) {
                Log.d("Error",t.toString())
                call.cancel()
            }
        })
    }
}