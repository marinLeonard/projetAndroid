package fr.purplegiraffe.recyclerdemob2

import org.junit.Test

import org.junit.Assert.*

class AccountTest {
    val account = Account()

    @Test
    fun getSetServiceName() {
        assertEquals("", account.serviceName)
        account.serviceName = "service"
        assertEquals("service", account.serviceName)
    }



    @Test
    fun getSetUsername() {
        assertEquals("", account.username)
        account.serviceName = "username"
        assertEquals("username", account.serviceName)
    }


    @Test
    fun getSetPassword() {
        assertEquals("", account.password)
        account.password = "password"
        assertEquals("password", account.password)
    }


    @Test
    fun getSetEmail() {
        assertEquals("", account.email)
        account.email = "email"
        assertEquals("email", account.email)
    }

}