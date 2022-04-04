package com.joblogic.todoapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.joblogic.todoapp.R
import com.joblogic.todoapp.constant.DelayConstant
import com.joblogic.todoapp.ui.BaseFragment

class SplashFragment : BaseFragment() {

    private lateinit var splashViewModel: SplashViewModel
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        splashViewModel = ViewModelProvider(this, factory).get(SplashViewModel::class.java)
        val view: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return view.root
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            navController.navigate(R.id.action_splashFragment_to_homeFragment)
        }, DelayConstant.SPLASH_DELAY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

}