package fr.purplegiraffe.recyclerdemob2

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required

@RealmClass
open class Account()  : RealmObject() {

    var serviceName:String = ""
    var username = ""
    var password = ""
    var email = ""

}