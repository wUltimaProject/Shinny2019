package com.wultimaproject.shinny2019.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject


@RunWith(MockitoJUnitRunner::class)
class ContactListVMTest{

@Mock lateinit var dbRepositoryMock: DbRepository

//    @Inject lateinit var dbRepositoryMock:  DbRepository

//    lateinit var dbRepositoryMock: DbRepository

    private var SUT: ContactListVM? = null

    @Before
    fun setup(){
//        dbRepositoryMock = Mockito.mock(DbRepository::class.java)
        SUT = ContactListVM(dbRepositoryMock)
//        dbRepositoryMock = DbRepository()
    }



    //load contacts from db: success
    @Test
    @Throws(Exception::class)
    fun connectionToDb_success() {
        SUT?.loadContacts()
        val contacts: List<Contact> = verify(dbRepositoryMock, times(1)).loadAllContacts()
        assertTrue(contacts.isNotEmpty())

    }

    //load contacts from db: fail

    //delete contact from db: success
    //delete contact to db: fail

}
