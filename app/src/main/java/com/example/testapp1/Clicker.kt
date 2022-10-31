package com.example.testapp1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.testapp1.databinding.ActivityClickerBinding


class Clicker : AppCompatActivity(){
    private lateinit var bind: ActivityClickerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var counter = 0
        var step = 1
        var cancelNext = false
        var lastToast = Toast(applicationContext)
        super.onCreate(savedInstanceState)
        bind = ActivityClickerBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.incrementBtn.setOnClickListener {
            counter += step
            bind.counterValue.text = counter.toString()
            val text = (counter - step).toString() + " + " + step + " = " + counter
            if(cancelNext) lastToast.cancel()
            lastToast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            lastToast.show()
            cancelNext = true
        }

        bind.decrementBtn.setOnClickListener {
            counter -= step
            bind.counterValue.text = counter.toString()
            val text = (counter - step).toString() + " - " + step + " = " + counter
            if(cancelNext)
                lastToast.cancel()
            lastToast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            lastToast.show()
            cancelNext = true
        }

        bind.counterStep.addTextChangedListener {
            if(bind.counterStep.text.isEmpty()) {
                bind.incrementBtn.text = "INCREMENT"
                bind.decrementBtn.text = "DECREMENT"
                step = 1
            } else {
                step = bind.counterStep.text.toString().toInt()
                bind.incrementBtn.text = "+$step"
                bind.decrementBtn.text = "-$step"
            }
        }

        bind.mainMenuBtn.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

    }
}