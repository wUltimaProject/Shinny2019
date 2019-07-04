package com.wultimaproject.shinny2019.ui.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import javax.inject.Inject



class ContactListVM @Inject constructor(val dbRepository: DbRepository) : ViewModel(){



    fun loadContacts(){
        dbRepository.loadAllContacts()
    }



}