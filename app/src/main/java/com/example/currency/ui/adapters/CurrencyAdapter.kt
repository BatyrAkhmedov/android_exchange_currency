package com.example.currency.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency_lib.data.model.Currency

class CurrencyAdapter(private val context: Context, private var currencyList: List<Currency>) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    fun updateData(newCurrencyList: List<Currency>) {
        currencyList = newCurrencyList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currency = currencyList[position]
        holder.bind(currency)
    }

    override fun getItemCount(): Int = currencyList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(android.R.id.text1)
        private val rateTextView: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(currency: Currency) {
            nameTextView.text = currency.name
            rateTextView.text = currency.currentRate.toString()

            itemView.setBackgroundColor(if (currency.changeInLast24Hours > 0) {
                android.graphics.Color.GREEN
            } else {
                android.graphics.Color.RED
            })
        }
    }
}