package com.joblogic.todoapp.ui.sellList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.joblogic.todoapp.R
import com.joblogic.todoapp.constant.Constants
import com.joblogic.todoapp.databinding.FragmentSellListBinding
import com.joblogic.todoapp.ui.BaseFragment

class SellListFragment : BaseFragment() {

    private lateinit var viewModel: SellViewModel
    private lateinit var binding: FragmentSellListBinding
    private lateinit var navController: NavController
    private lateinit var sellListAdapter: SellListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(SellViewModel::class.java)
        val view: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sell_list, container, false)
        binding = view as FragmentSellListBinding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        subscribeUi()
        return view.root
    }

    private fun subscribeUi() {
        binding.backButton.setOnClickListener {
            navController.popBackStack()
        }
        viewModel.sellModelsList.observe(viewLifecycleOwner, Observer {
            if(it.isNullOrEmpty()){
                viewModel.insertSellingData(Constants.getSellingData())
            } else {
                sellListAdapter = SellListAdapter(it)
                binding.sellListRecyclerview.adapter = sellListAdapter
            }
        })
    }





}