package com.wultimaproject.shinny2019.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wultimaproject.shinny2019.MainCoroutineRule
import com.wultimaproject.shinny2019.models.Result
import com.wultimaproject.shinny2019.models.Result.Error
import com.wultimaproject.shinny2019.models.Result.Success
import com.wultimaproject.shinny2019.models.db.Contact
import com.wultimaproject.shinny2019.repositories.DbRepositoryGeneralInterface
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
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
        SUT = ContactListVM(dbRepositoryFake)
    }

    @Test
    fun loadContacts_empty(){
        SUT.loadContacts()
        runBlocking {
            var size = dbRepositoryFake.contactListSaved.size
            assertTrue(size == 0)
        }
    }

    @Test
    fun loadContacts_withContacts(){
        dbRepositoryFake.addFakeSampleContact(sampleContact)
        SUT.loadContacts()
        runBlocking {
            //            verify(dbRepositoryFake, times(1)).loadAllContacts()
            var size = dbRepositoryFake.contactListSaved.size
            assertTrue(size > 0)
            assertTrue(dbRepositoryFake.contactListSaved.values.first().name.equals("name"))
        }
    }



    //===============================================================================//

    class DbRepositoryFake: DbRepositoryGeneralInterface{
        var contactListSaved: LinkedHashMap<Int, Contact> = LinkedHashMap<Int, Contact>()
        val sampleContact: Contact = Contact(3, "name", "address", "message", "phoneNumber")
        private var shouldReturnError: Boolean = false


        fun addFakeSampleContact(contact: Contact){
            GlobalScope.launch {
                contactListSaved[contact.uid] = sampleContact
            }
        }

        override suspend fun addSampleContact(contact: Contact) {}

        override suspend fun loadAllContacts(): Result<List<Contact>> {
            return if (shouldReturnError){
                Error(Exception("loadAllContactsTestError"))
            } else {
                Success (contactListSaved.values.toList())
            }
        }
    }



}
