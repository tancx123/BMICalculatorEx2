package com.example.bmicalculatorex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.bmicalculatorex2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calculateBMI(weight: Double, height: Double): Double {
            return weight / Math.pow(height, 2.0)
        }


        buttonCalculate.setOnClickListener() {
            try {
                val weight: Double = editTextWeight.text.toString().toDouble()
                val height: Double = editTextHeight.text.toString().toDouble()
                val bmi: Double = calculateBMI(weight, height)

                val status: String

                if (bmi < 18.50) {
                    image.setImageResource(R.drawable.under)
                    status = "Under"
                } else if (bmi < 24.9) {
                    image.setImageResource(R.drawable.normal)
                    status = "Normal"
                } else {
                    image.setImageResource(R.drawable.over)
                    status = "Over"
                }
                textViewBMI.text = "BMI %.2f (%s)".format(bmi, status)
            } catch (ex: Exception) {
                val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }

            buttonReset.setOnClickListener() {
                image.setImageResource(R.drawable.empty)
                textViewBMI.text = ""
                editTextHeight.text.clear()
                editTextWeight.text.clear()
                editTextWeight.requestFocus()
            }

        }

        //
    }
}
