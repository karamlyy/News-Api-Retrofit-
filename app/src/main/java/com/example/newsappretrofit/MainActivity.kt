package com.example.newsappretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappretrofit.databinding.ActivityMainBinding
import com.example.newsappretrofit.model.Results

import com.example.newsappretrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        getNews()
    }
    fun getNews(){
        val call: Call<Results?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getNews()
        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: Call<Results?>?, response: Response<Results?>?) {
                val newsList: Results = response?.body() as Results
                binding.recyclerView.adapter = Adapter(newsList.results)
            }
            override fun onFailure(call: Call<Results?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}


