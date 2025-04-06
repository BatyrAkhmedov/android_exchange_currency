package com.example.currency.presentation.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.databinding.CurrencyListItemBinding
import com.example.currency.presentation.model.CurrencyUiModel
import com.example.currency_lib.domain.model.Currency
//private var currencyList: List<CurrencyUiModel>
class CurrencyAdapter() :
    ListAdapter<CurrencyUiModel, CurrencyVH>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyVH {
        val binding =
            CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyVH(binding)
    }

    override fun onBindViewHolder(holder: CurrencyVH, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }

}