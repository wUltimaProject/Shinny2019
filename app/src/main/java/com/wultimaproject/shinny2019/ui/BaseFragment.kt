package com.wultimaproject.shinny2019.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wultimaproject.shinny2019.viewmodels.BaseVM

open class BaseFragment: Fragment(){
    private lateinit var _actualFragment: Fragment
    private lateinit var _actualVm: BaseVM

    fun setCurrentFragment(fragment: Fragment){
        _actualFragment = fragment
    }

    fun setCurrentVM(vm: BaseVM){
        _actualVm = vm
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        _actualVm.navigateToFragment.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                findNavController().navigate(it.actionId)
            }
        })
    }


}