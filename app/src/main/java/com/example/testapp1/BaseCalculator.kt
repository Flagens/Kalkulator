package com.example.testapp1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import org.mariuszgromada.math.mxparser.Expression
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.testapp1.databinding.ActivityBaseCalculatorBinding
import java.text.DecimalFormat


class BaseCalculator : AppCompatActivity() {
    private lateinit var bind: ActivityBaseCalculatorBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadratic_calculator)
        bind = ActivityBaseCalculatorBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.mainMenuBtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
        bind.calcHelloBtn.setOnClickListener {
            val myToast = Toast.makeText(applicationContext,"HELLO",Toast.LENGTH_SHORT)
            myToast.show()
        }
        bind.calcCBtn.setOnClickListener {
            bind.calcInput.text = ""
            bind.calcOutput.text ="Wynik: "
        }

        bind.calc0Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("0")
        }
        bind.calc1Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("1")
        }
        bind.calc2Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("2")
        }
        bind.calc3Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("3")
        }
        bind.calc4Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("4")
        }
        bind.calc5Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("5")
        }
        bind.calc6Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("6")
        }
        bind.calc7Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("7")
        }
        bind.calc8Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("8")
        }
        bind.calc9Btn.setOnClickListener {
            bind.calcInput.text = addToInputText("9")
        }
        bind.calcPointBtn.setOnClickListener {
            bind.calcInput.text = addToInputText(".")
        }
        bind.calcDivisionBtn.setOnClickListener {
            bind.calcInput.text = addToInputText("÷") // ALT + 0247
        }
        bind.calcMultiplicationBtn.setOnClickListener {
            bind.calcInput.text = addToInputText("×") // ALT + 0215
        }
        bind.calcSubtractionBtn.setOnClickListener {
            bind.calcInput.text = addToInputText("-")
        }
        bind.calcAdditionBtn.setOnClickListener {
            bind.calcInput.text = addToInputText("+")
        }

        bind.calcEqualsBtn.setOnClickListener {
            showResult()
        }


    }
    private fun addToInputText(buttonValue: String): String {
        return "${bind.calcInput.text}$buttonValue"
    }
    private fun getInputExpression(): String {
        var expression = bind.calcInput.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }
    @SuppressLint("SetTextI18n")
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                bind.calcOutput.text = "Error"

            } else {
                bind.calcOutput.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            bind.calcOutput.text = "Error"
        }
    }


}