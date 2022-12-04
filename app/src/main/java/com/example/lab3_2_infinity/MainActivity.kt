package com.example.lab3_2_infinity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView

data class Form(
    val product: String,
    val quantity: Int,
    val price: Int
)

class MainActivity : AppCompatActivity() {
    private val listOfForms = arrayListOf<Form>()
    private var state = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productInput: EditText = findViewById(R.id.product)
        val quantityInput: EditText = findViewById(R.id.quantity)
        val priceInput: EditText = findViewById(R.id.price)
        val moreButton: Button = findViewById(R.id.more)
        val listOfFormsView: ListView = findViewById(R.id.list_forms)
        val adapter = FormAdapter(this, listOfForms)
        listOfFormsView.adapter = adapter
        moreButton.setOnClickListener {
            if (priceInput.text.isNotEmpty() && quantityInput.text.isNotEmpty() && priceInput.text.isNotEmpty()) {
                listOfForms.add(
                    Form(
                        product = productInput.text.toString(),
                        quantity = quantityInput.text.toString().toInt(),
                        price = priceInput.text.toString().toInt()
                    )
                )
                productInput.text.clear()
                quantityInput.text.clear()
                priceInput.text.clear()
            }
        }
        val enoughButton: Button = findViewById(R.id.enough)
        enoughButton.setOnClickListener {
            if (state) {
                findViewById<LinearLayout>(R.id.single_form).visibility = View.GONE
                moreButton.visibility = View.GONE
                adapter.notifyDataSetChanged()
                listOfFormsView.visibility = View.VISIBLE
                enoughButton.text = "Добавить ещё"
                state = false
            } else {
                findViewById<LinearLayout>(R.id.single_form).visibility = View.VISIBLE
                moreButton.visibility = View.VISIBLE
                listOfFormsView.visibility = View.GONE
                enoughButton.text = "Вывести результат"
                state = true
            }
        }
    }
}