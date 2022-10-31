package com.example.testapp1


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp1.databinding.ActivityQuadraticCalculatorBinding
import kotlin.math.sqrt

class QuadraticCalculator : AppCompatActivity() {

    private lateinit var bind: ActivityQuadraticCalculatorBinding
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        var toast: Toast
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadratic_calculator)
        bind = ActivityQuadraticCalculatorBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.mainMenuBtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }


        bind.calculateBtn.setOnClickListener {
            val a = bind.quadraticA.text?.toString()?.toDoubleOrNull()
            val b = bind.quadraticB.text?.toString()?.toDoubleOrNull()
            val c = bind.quadraticC.text?.toString()?.toDoubleOrNull()
            if (a != null && b != null && c != null) {
                val results = quadraticFunction(a, b, c)
                val text: String = results.toString()
                toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            }
        }
    }


    private fun quadraticFunction(a: Double, b: Double, c: Double) {
        val toast: Toast
        val delta = b*b + 4*a*c
        if (delta > 0) {
            val x1 = (-b + sqrt(delta)) / (2 * a)
            val x2 = (-b - sqrt(delta)) / (2 * a)
            toast = Toast.makeText(applicationContext, "x1 $x1 and x2 $x2", Toast.LENGTH_SHORT)
            toast.show()
        } else if (delta < 0) {
            toast = Toast.makeText(applicationContext, "No solutions", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val x = (-b/2*a)
            toast = Toast.makeText(applicationContext, "x1 $x", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}



