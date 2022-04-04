package com.joblogic.todoapp.ui.callList

import androidx.databinding.ViewDataBinding
import com.joblogic.todoapp.R
import com.joblogic.todoapp.base.RecyclerBaseAdapter
import com.joblogic.todoapp.databinding.ViewListItemCallBinding
import com.joblogic.todoapp.entities.ItemToCall

class CallListAdapter(var items: List<ItemToCall>) :
    RecyclerBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.view_list_item_call

    override fun getViewModel(position: Int): Any? = items[position]

    override fun getItemCount(): Int = items.size


    override fun onViewReady(viewDataBinding: ViewDataBinding, position: Int) {
        super.onViewReady(viewDataBinding, position)
        //can be used for more login handling
        val binding = viewDataBinding as ViewListItemCallBinding
        binding.viewmodel=items[position]

    }


}