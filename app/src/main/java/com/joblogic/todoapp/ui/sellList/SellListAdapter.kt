package com.joblogic.todoapp.ui.sellList

import androidx.databinding.ViewDataBinding
import com.joblogic.todoapp.R
import com.joblogic.todoapp.base.RecyclerBaseAdapter
import com.joblogic.todoapp.databinding.ViewListItemSellBinding
import com.joblogic.todoapp.entities.ItemToSell

class SellListAdapter(var items: List<ItemToSell>) :
    RecyclerBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.view_list_item_sell

    override fun getViewModel(position: Int): Any? = items[position]

    override fun getItemCount(): Int = items.size


    override fun onViewReady(viewDataBinding: ViewDataBinding, position: Int) {
        super.onViewReady(viewDataBinding, position)
        //can be used for more login handling
        val binding = viewDataBinding as ViewListItemSellBinding
        binding.viewmodel=items[position]

    }


}