package com.joblogic.todoapp.ui.callList


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
import com.joblogic.todoapp.databinding.FragmentCallListBinding
import com.joblogic.todoapp.ui.BaseFragment

class CallListFragment : BaseFragment() {

    private lateinit var viewModel: CallListViewModel
    private lateinit var navController: NavController
    private lateinit var binding: FragmentCallListBinding
    private lateinit var callListAdapter: CallListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(CallListViewModel::class.java)
        val view: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_call_list, container, false)
        binding = view as FragmentCallListBinding
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
        viewModel.callModelsList.observe(viewLifecycleOwner, Observer {
            callListAdapter = CallListAdapter(it)
            binding.callListRecyclerview.adapter = callListAdapter
        })
        viewModel.fetchCallList()
    }





}