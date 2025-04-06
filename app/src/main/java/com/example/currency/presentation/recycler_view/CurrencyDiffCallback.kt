package com.example.currency.presentation.recycler_view

import androidx.recyclerview.widget.DiffUtil
import com.example.currency.presentation.model.CurrencyUiModel

class CurrencyDiffCallback : DiffUtil.ItemCallback<CurrencyUiModel>(){
    override fun areItemsTheSame(oldItem: CurrencyUiModel, newItem: CurrencyUiModel): Boolean {
       return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CurrencyUiModel, newItem: CurrencyUiModel): Boolean {
        return oldItem == newItem
    }
}