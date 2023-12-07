package com.example.hw_7_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw_7_5.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.btnJoke.setOnClickListener {
            RetrofitService.api.getJoke().enqueue(object :Callback<JokeModel>{
                override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                    binding.tvSetup.text = response.body()?.body?.first()?.setup.toString()
                    binding.tvPunchline.text = response.body()?.body?.first()?.punchline.toString()
                }
                override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}