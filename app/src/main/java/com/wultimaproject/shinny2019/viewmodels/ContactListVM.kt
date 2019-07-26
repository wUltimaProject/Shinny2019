package com.wultimaproject.shinny2019.viewmodels

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import com.wultimaproject.shinny2019.models.NavigationCommand
import com.wultimaproject.shinny2019.models.Result
import com.wultimaproject.shinny2019.models.db.Contact
import com.wultimaproject.shinny2019.repositories.DbRepositoryGeneralInterface
import com.wultimaproject.shinny2019.ui.AddContactDialogFragment
import com.wultimaproject.shinny2019.ui.ContactListFragmentDirections
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Rule


class ContactListVM (private val dbRepository: DbRepositoryGeneralInterface) : BaseVM(){

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    var getContact: MutableLiveData<List<Contact>> = MutableLiveData()

    /**
     *
     * Called  from FAB to add new contact. It will create a new Intent for the intended Activity/fragment
     */
    fun addSampleContact() = viewModelScope.launch {
            navigate(ContactListFragmentDirections.actionContactlist())
        }


    fun loadContacts() {
        GlobalScope.launch {
            val result = dbRepository.loadAllContacts()
            result.let {
                when (it) {
                    is Result.Success ->  getContact.postValue(it.data)
                    is Result.Error -> Log.d("log", "error while returning contact list")// return@let it.exception
                    is Result.Loading -> TODO("loader or smthng")
                }
            }
        }
    }


}