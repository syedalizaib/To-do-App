package com.joblogic.todoapp.ui.buyList

import androidx.databinding.ViewDataBinding
import com.joblogic.todoapp.R
import com.joblogic.todoapp.base.RecyclerBaseAdapter
import com.joblogic.todoapp.databinding.ViewListItemBuyBinding
import com.joblogic.todoapp.entities.ItemToBuy

class BuyListAdapter(var items: List<ItemToBuy>) :
    RecyclerBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.view_list_item_buy

    override fun getViewModel(position: Int): Any? = items[position]

    override fun getItemCount(): Int = items.size


    override fun onViewReady(viewDataBinding: ViewDataBinding, position: Int) {
        super.onViewReady(viewDataBinding, position)
        //can be used for more login handling
        val binding = viewDataBinding as ViewListItemBuyBinding
        binding.viewmodel=items[position]

    }


}