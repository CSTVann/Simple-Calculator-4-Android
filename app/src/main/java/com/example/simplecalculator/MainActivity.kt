package com.example.simplecalculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btAdd: Button
    lateinit var btSub: Button
    lateinit var btMultiply: Button
    lateinit var btDivide: Button

    lateinit var etFirstNum: EditText
    lateinit var etSecondNum: EditText

    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btAdd = findViewById(R.id.btAdd)
        btSub = findViewById(R.id.btSub)
        btMultiply = findViewById(R.id.btMultiply)
        btDivide = findViewById(R.id.btDivide)

        etFirstNum = findViewById(R.id.etFirstNum)
        etSecondNum = findViewById(R.id.etSecondNum)

        txtResult = findViewById(R.id.txtResult)

        //set the listener to the buttons
        btAdd.setOnClickListener(this)
        btSub.setOnClickListener(this)
        btMultiply.setOnClickListener(this)
        btDivide.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set OnClickListener for the buttons
        btAdd.setOnClickListener(this)
        btSub.setOnClickListener(this)
        btMultiply.setOnClickListener(this)
        btDivide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (TextUtils.isEmpty(etFirstNum.text.toString()) && TextUtils.isEmpty(etSecondNum.text.toString())){
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_SHORT).show()
        }else
        {
            val num1 = Integer.parseInt(etFirstNum.text.toString())
            val num2 = Integer.parseInt(etSecondNum.text.toString())

            if (v != null) {
                when (v.id) {
                    R.id.btAdd -> {
                        val ResultA = num1 + num2
                        txtResult.text = ResultA.toString()
                    }
                    R.id.btSub -> {
                        val ResultB = num1 - num2
                        txtResult.text = ResultB.toString()
                    }
                    R.id.btMultiply -> {
                        val ResultC = num1 * num2
                        txtResult.text = ResultC.toString()
                    }
                    R.id.btDivide -> {
                        val ResultD = num1 / num2
                        txtResult.text = ResultD.toString()
                    }
                }
            }
        }
    }
}
