package fr.purplegiraffe.recyclerdemob2

import io.realm.Realm

class GestionAccount {

    var realm: Realm = Realm.getDefaultInstance()





    fun createAccount(account: Account)
    {
        realm.beginTransaction()
        realm.copyToRealm(account)
        realm.commitTransaction()
    }


    fun getAllAccount() : List<Account>
    {
        return realm.where(Account::class.java).findAll()
    }

    fun getAccount(username:String, serviceName:String) : Account?
    {
        return realm.where(Account::class.java).contains("username", username).contains("serviceName", serviceName).findFirst();
    }

    fun deleteAccount(account: Account)
    {
        realm.beginTransaction()
        account.deleteFromRealm()
        realm.commitTransaction()
    }

    fun UpdateAccount(username:String, serviceName:String, modification: Account)
    {
        realm.beginTransaction()
        var accountToUpdate = getAccount(username, serviceName)
        if (accountToUpdate != null) {
            accountToUpdate.username = modification.username;
            accountToUpdate.password = modification.password;
            accountToUpdate.serviceName = modification.serviceName;
            accountToUpdate.email = modification.email;
        }
        realm.commitTransaction()
    }


}