package com.example.currency.presentation.recycler_view

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.databinding.CurrencyListItemBinding
import com.example.currency.presentation.model.CurrencyUiModel

class CurrencyVH(private val binding: CurrencyListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(currency: CurrencyUiModel) {
        binding.name.text = currency.name
        binding.rate.text = currency.rate
        itemView.setBackgroundColor(
            if (currency.changeInLast24Hours > 0) Color.GREEN
            else if (currency.changeInLast24Hours < 0) Color.RED
            else Color.WHITE
        )
    }
}