//package com.wultimaproject.shinny2019.ui.viewmodels
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.wultimaproject.shinny2019.model.db.Contact
//import com.wultimaproject.shinny2019.model.db.ContactDao
//import com.wultimaproject.shinny2019.ui.repositories.DbRepository
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import org.hamcrest.MatcherAssert.assertThat
//import org.junit.Assert.assertNull
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.Mockito.times
//import org.mockito.Mockito.verify
//import org.mockito.junit.MockitoJUnitRunner
//import javax.inject.Inject
//
//
//@RunWith(MockitoJUnitRunner::class)
//class ContactListVMTest{
//
//@Mock lateinit var dbRepositoryMock: DbRepository
//    @Mock lateinit var contactDaoMock: ContactDao
//
//
//    val sampleContact: Contact = Contact(1, "name", "address", "message", "phoneNumber")
//
//    private var SUT: ContactListVM? = null
//
//    @Before
//    fun setup(){
//        SUT = ContactListVM(dbRepositoryMock)
//        fillDbWithContacts()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun addNewContactInDb_DaoCalled(){
////        fillDbWithContacts()
//        GlobalScope.launch {
//            SUT?.addSampleContact()
//            verify(contactDaoMock).save(sampleContact)
//        }
//    }
//
////load all contacts from db, verify loadAllContact method has been called
//    @Test
//    @Throws(Exception::class)
//    fun loadAllMethod_isCalled(){
//    fillDbWithContacts()
//    SUT?.loadContacts()
//    verify(dbRepositoryMock, times(1)).loadAllContacts()
//}
//
//
////    load all contacts from db, db empty, empty list returned
//    @Test
//    @Throws(java.lang.Exception::class)
//    fun connectionToDb_db_empty_fail(){
//        SUT?.loadContacts()
//        val contact: List<Contact> = verify(dbRepositoryMock).loadAllContacts()
//        assertNull(contact)
//    }
//
//
//
//    //load all contacts from db: success
//    @Test
//    @Throws(Exception::class)
//    fun connectionToDb_success() {
//        fillDbWithContacts()
//        SUT?.loadContacts()
//        var contacts:List<Contact> = verify(dbRepositoryMock).loadAllContacts()
//        assertTrue(contact)
//    }
//
//    //load contacts from db: fail
//
//    //delete contact from db: success
//    //delete contact to db: fail
//
//
//
//    //region helper methods
//
//    fun fillDbWithContacts(){
//        GlobalScope.launch {
//            dbRepositoryMock.addSampleContact(sampleContact)
//        }
//    }
//
//    //endregion
//
//}
