package com.wultimaproject.shinny2019.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.runner.screenshot.Screenshot.capture
import com.google.common.truth.Truth.assertThat
import com.wultimaproject.shinny2019.MainCoroutineRule
import com.wultimaproject.shinny2019.model.Result
import com.wultimaproject.shinny2019.model.Result.Error
import com.wultimaproject.shinny2019.model.Result.Success
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import com.wultimaproject.shinny2019.ui.repositories.DbRepositoryGeneralInterface
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.lang.Exception


@ExperimentalCoroutinesApi
internal class ContactListVMTest {

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var SUT: ContactListVM
    private lateinit var dbRepositoryFake: DbRepositoryFake

    var sampleContact: Contact = Contact(3, "name", "address", "message", "phoneNumber")

    @Before
        fun setup(){
        dbRepositoryFake = DbRepositoryFake()
//        runBlocking { dbRepositoryFake.addSampleContact(sampleContact)}
        SUT = ContactListVM(dbRepositoryFake)
//        SUT.getContact.observeForever(observer)
    }

    //contactSaved_success

    @Test
     fun contactSaved_success(){
        dbRepositoryFake.setReturnError(false)

        SUT.addSampleContact()
        assertTrue( dbRepositoryFake.contactListSaved.values.first() == sampleContact)
//        assertTrue( dbRepositoryFake.contactListSaved.values.first().uid == sampleContact.uid)
//        assertTrue( dbRepositoryFake.contactListSaved.values.first().name == sampleContact.name)
//        assertTrue( dbRepositoryFake.contactListSaved.values.first().address.equals(sampleContact.address))
//        assertTrue( dbRepositoryFake.contactListSaved.values.first().message == sampleContact.message)
//        assertTrue( dbRepositoryFake.contactListSaved.values.first().phoneNumber == sampleContact.phoneNumber)
//        assertTrue( dbRepositoryFake.contactListSaved.values.first() == Contact(4, "name", "addresss", "message", "phoneNumber"))

    }

    //contactSaved_fail








    //helper class

    class DbRepositoryFake: DbRepositoryGeneralInterface{
        var contactListSaved: LinkedHashMap<Int, Contact> = LinkedHashMap<Int, Contact>()
        val sampleContact: Contact = Contact(3, "name", "address", "message", "phoneNumber")
        private var shouldReturnError: Boolean = false

        fun setReturnError(flag: Boolean){
            shouldReturnError = flag
        }

        override suspend fun addSampleContact(contact: Contact) {
                contactListSaved[contact.uid] = sampleContact
        }

        override suspend fun loadAllContacts(): Result<List<Contact>> {
            return if (shouldReturnError){
                Error(Exception("loadAllContactsTestError"))
            } else {
                Success (contactListSaved.values.toList())
            }
        }

    }



}
