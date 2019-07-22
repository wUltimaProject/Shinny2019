package com.wultimaproject.shinny2019.ui.viewmodels

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import com.google.common.cache.ForwardingLoadingCache
import com.wultimaproject.shinny2019.model.Result
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepositoryGeneralInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Rule


class ContactListVM (private val dbRepository: DbRepositoryGeneralInterface) : ViewModel(){

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    var getContact: MutableLiveData<List<Contact>> = MutableLiveData()
    var sampleContact: Contact = Contact(3, "name", "address", "message", "phoneNumber")


    fun addSampleContact() = viewModelScope.launch {
            dbRepository.addSampleContact(sampleContact)
            loadContacts()
        }




    fun loadContacts() {
        GlobalScope.launch {
            val result = dbRepository.loadAllContacts() as Result.Success<List<Contact>>
            getContact.postValue(result.data)
        }


    }
}