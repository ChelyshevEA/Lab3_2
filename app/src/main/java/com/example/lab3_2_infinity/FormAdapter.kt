package com.example.lab3_2_infinity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText

class FormAdapter(
    private val context: Context,
    private val dataSource: ArrayList<Form>
): BaseAdapter() {
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = dataSource.size

    override fun getItem(position: Int): Any = dataSource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.list_item_form, parent, false).also {
            val item = getItem(position) as Form
            val product = it.findViewById<EditText>(R.id.product)
            val quantity = it.findViewById<EditText>(R.id.quantity)
            val price = it.findViewById<EditText>(R.id.price)
            product.setText(item.product)
            quantity.setText(item.quantity.toString())
            price.setText(item.price.toString())
            product.isEnabled = false
            product.setTextColor(R.color.black)
            quantity.isEnabled = false
            quantity.setTextColor(R.color.black)
            price.isEnabled = false
            price.setTextColor(R.color.black)
        }
        return view
    }
}