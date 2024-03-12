package com.example.realmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realmdb.models.Address
import com.example.realmdb.models.Course
import com.example.realmdb.models.Student
import com.example.realmdb.models.Teacher
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val real = MyApp.realm

    init {
        //createSampleEntries()
    }

    val courses = real
        .query<Course>(
            "enrolledStudents.@count >= 2",

        )
        .asFlow()
        .map { results ->
            results.list.toList()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    private fun createSampleEntries() {
        viewModelScope.launch {
            real.write {
                val address = Address().apply {
                    fullName = "Chimboyliq"
                    street = "Sohil"
                    houseNumber = 13
                    zipCode = 0

                }
                val address2 = Address().apply {
                    fullName = "Gazalkent"
                    street = "Anarov"
                    houseNumber = 15
                    zipCode = 0
                }

                val course1 = Course().apply {
                    name = "Android development in jetpack compose"
                }
                val course2 = Course().apply {
                    name = "Android basics"
                }
                val course3 = Course().apply {
                    name = "Kotlin basics"
                }

                val teacher1 = Teacher().apply {
                    this.address = address
                    courses = realmListOf(course1, course2)
                }

                val teacher2 = Teacher().apply {
                    this.address = address2
                    courses = realmListOf(course3)
                }
                course1.teacher = teacher1
                course2.teacher = teacher1
                course3.teacher = teacher2

                address.teacher = teacher1
                address2.teacher = teacher2

                val student = Student().apply {
                    name = "Sardor"

                }
                val student2 = Student().apply {
                    name = "Sayot"
                }

                course1.enrolledStudents.add(student)
                course2.enrolledStudents.add(student2)
                course3.enrolledStudents.addAll(listOf(student, student2))

                copyToRealm(teacher1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(teacher2, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(course1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(course2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(course3, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(student, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(student2, updatePolicy = UpdatePolicy.ALL)


            }
        }
    }
}