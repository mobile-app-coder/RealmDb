package com.example.realmdb.models

import io.realm.kotlin.types.EmbeddedRealmObject

// teacher 1 to 1 Address
// teacher 1 to many course
// student many to many course

class Address : EmbeddedRealmObject {
    var fullName: String = ""
    var street: String = ""
    var houseNumber: Int = 0
    var zipCode: Int = 0
    var teacher: Teacher? = null
}