package com.joblogic.todoapp.ui.buyList


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
import com.joblogic.todoapp.databinding.FragmentBuyListBinding
import com.joblogic.todoapp.ui.BaseFragment

class BuyListFragment : BaseFragment() {

    private lateinit var viewModel: BuyListViewModel
    private lateinit var navController: NavController
    private lateinit var binding: FragmentBuyListBinding
    private lateinit var buyListAdapter: BuyListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(BuyListViewModel::class.java)
        val view: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_buy_list, container, false)
        binding = view as FragmentBuyListBinding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        subscribeUi()
        return view.root
    }

    private fun subscribeUi() {
        binding.backButton.setOnClickListener {
            navController.popBackStack()
        }

        viewModel.loadingBarIsVisible.observe(viewLifecycleOwner, Observer {
            if(it) {
                binding.loadingAnimation.visibility=View.VISIBLE
            } else {
                binding.loadingAnimation.visibility =View.GONE
            }
        })
        viewModel.buyModelsList.observe(viewLifecycleOwner, Observer {
            buyListAdapter = BuyListAdapter(it)
            binding.buyListRecyclerview.adapter = buyListAdapter
        })
        viewModel.fetchBuyList()
    }





}