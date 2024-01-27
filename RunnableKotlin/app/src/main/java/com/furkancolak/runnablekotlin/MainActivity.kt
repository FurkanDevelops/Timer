package com.furkancolak.runnablekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.furkancolak.runnablekotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

var runnable :  Runnable = Runnable{}
var handler : Handler = Handler(Looper.getMainLooper())
var number = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // RUNNABLE - HANDLER
        // HANDLERİN AMACI RUNNABLE I YÖNETEBİLMEK

    }
    fun start(view :View){
        number =0
        runnable = object : Runnable{
            override fun run() {
                number ++
                binding.txt.text = "Time : "+ number
                handler.postDelayed(runnable,1000)// 1 saniyede 1 başlar

            }

        }
        handler.post(runnable)// runnable başlatmak için kullanılır
        binding.button2.isEnabled = false // tuşa bir daha basmayı engeller
    }

    fun stop(view :View){
        binding.button2.isEnabled = true
        number = 0
        binding.txt.text = "Time : "+ number
        handler.removeCallbacks(runnable) // runnable durmuş olur
    }
}