package com.wultimaproject.shinny2019.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wultimaproject.shinny2019.MainCoroutineRule
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import javax.inject.Inject

@ExperimentalCoroutinesApi
class ContactListVMTestNoMock{


    private lateinit var SUT: ContactListVM



    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoreRoutine = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    val sampleContact = Contact(3, "name", "address", "message", "phoneNumber")

    @Before
    fun setup(){

        SUT = ContactListVM(DbRepositoryFake())
    }

    //add single contact to db - success
    @Test
    fun addSingleContactToDb_success(){
        SUT.addSampleContact()
        verify(dbRepository).addSampleContact(sampleContact)
    }
    //add single contact to db - fail
    //add list contact to db - success
    //add list contact to db - fail


    //loadContacts list - fail (contactsList is null)
    //loadContacts list - success - list.size > 0
    //loadContacts list - success - list.size = 0



    private class DbRepositoryFake : DbRepository() {

    }

}