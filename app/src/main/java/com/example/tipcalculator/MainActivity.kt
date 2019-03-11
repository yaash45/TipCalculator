package com.example.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var increase_tip = findViewById<Button>(R.id.increase_tip)
        var decrease_tip = findViewById<Button>(R.id.decrease_tip)
        var increase_split = findViewById<Button>(R.id.increase_split)
        var decrease_split = findViewById<Button>(R.id.decrease_split)
        var calculate = findViewById<Button>(R.id.calculate)


        increase_split.setOnClickListener(View.OnClickListener {

            var split_text = findViewById<EditText>(R.id.split_value)

            var split_num: Int = split_text.getText().toString().toInt() + 1

            if (split_num <= 0) {
                split_num = 1
                split_text.setText(split_num.toString())
            }
            else
                split_text.setText(split_num.toString())

        })

        decrease_split.setOnClickListener(View.OnClickListener {

            var split_text = findViewById<EditText>(R.id.split_value)

            var split_num: Int = split_text.getText().toString().toInt() - 1

            if (split_num <= 0) {
                split_num = 1
                split_text.setText(split_num.toString())
            }
            else
                split_text.setText(split_num.toString())

        })

        increase_tip.setOnClickListener(View.OnClickListener {

            var tip_text = findViewById<EditText>(R.id.tip_value)

            var tip: Int = tip_text.getText().toString().toInt() + 1

            if (tip < 0) {
                tip = 0
                tip_text.setText(tip.toString())
            }
            else if (tip > 100) {
                tip = 100
                tip_text.setText(tip.toString())
            }
            else {
                tip_text.setText(tip.toString())
            }

        })

        decrease_tip.setOnClickListener(View.OnClickListener {

            var tip_text = findViewById<EditText>(R.id.tip_value)

            var tip: Int = tip_text.getText().toString().toInt() - 1

            if (tip < 0) {
                tip = 0
                tip_text.setText(tip.toString())
            }
            else if (tip > 100) {
                tip = 100
                tip_text.setText(tip.toString())
            }
            else {
                tip_text.setText(tip.toString())
            }
        })

        calculate.setOnClickListener(View.OnClickListener {

            var tip_text = findViewById<EditText>(R.id.tip_value)
            var split_text = findViewById<EditText>(R.id.split_value)
            var bill_text = findViewById<EditText>(R.id.bill_amount)

            var total_bill_display = findViewById<TextView>(R.id.total_amount)
            var total_tip_display = findViewById<TextView>(R.id.total_tip)
            var total_per_person = findViewById<TextView>(R.id.total_per_person)

            var split = split_text.getText().toString().toInt()
            var bill: Double = bill_text.getText().toString().toDouble()
            var tip: Double = (tip_text.getText().toString().toDouble()/100)*bill;

            total_bill_display.text = ((bill + tip).toString())
            total_tip_display.text = "%.2f".format(tip)
            total_per_person.text = "%.2f".format(((bill+tip)/split))

        })

    }
}

