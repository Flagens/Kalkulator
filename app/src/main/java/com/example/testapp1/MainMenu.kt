package com.example.testapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp1.databinding.ActivityMainMenuBinding

class   MainMenu : AppCompatActivity() {
    private lateinit var bind: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        bind = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.clickerBtn.setOnClickListener{
            val intent = Intent(this, Clicker::class.java)
            startActivity(intent)
        }

        bind.baseCalculatorBtn.setOnClickListener{
            val intent = Intent(this, BaseCalculator::class.java)
            startActivity(intent)
        }

        bind.quadraticCalculatorBtn.setOnClickListener{
            val intent = Intent(this, QuadraticCalculator::class.java)
            startActivity(intent)
        }
    }
}