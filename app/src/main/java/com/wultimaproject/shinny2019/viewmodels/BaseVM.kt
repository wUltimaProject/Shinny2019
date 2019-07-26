package com.wultimaproject.shinny2019.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.wultimaproject.shinny2019.models.db.SingleEventLiveData

open class BaseVM : ViewModel(){

     val _navigateToFragment = MutableLiveData<SingleEventLiveData<NavDirections>>()

    val navigateToFragment : LiveData<SingleEventLiveData<NavDirections>>
        get() = _navigateToFragment

    fun navigate(directions: NavDirections) {
        _navigateToFragment.value = SingleEventLiveData(directions)
    }


}