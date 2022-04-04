package com.joblogic.todoapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.joblogic.todoapp.R
import com.joblogic.todoapp.databinding.FragmentHomeBinding
import com.joblogic.todoapp.ui.BaseFragment

class HomeFragment : BaseFragment(), View.OnClickListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
        val view: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding = view as FragmentHomeBinding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        subscribeUi()
        return view.root
    }

    private fun subscribeUi() {
        binding.callList.setOnClickListener(this)
        binding.buyList.setOnClickListener(this)
        binding.sellList.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.call_list -> navController.navigate(R.id.action_navigation_home_to_callListFragment)
            R.id.buy_list -> navController.navigate(R.id.action_navigation_home_to_buyListFragment)
            R.id.sell_list -> navController.navigate(R.id.action_navigation_home_to_sellListFragment)
        }
    }



}