package com.example.realmdb

import android.app.Application
import com.example.realmdb.models.Address
import com.example.realmdb.models.Course
import com.example.realmdb.models.Student
import com.example.realmdb.models.Teacher
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class MyApp : Application() {
    companion object {
        lateinit var realm: Realm
    }

    override fun onCreate() {
        super.onCreate()
        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    Address::class,
                    Teacher::class,
                    Student::class,
                    Course::class
                )
            )
        )
    }

}