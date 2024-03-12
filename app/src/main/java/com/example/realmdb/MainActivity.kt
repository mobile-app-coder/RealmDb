package com.example.realmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realmdb.models.Course
import com.example.realmdb.ui.theme.RealmDbTheme
import com.example.realmdb.viewModel.HomeScreen

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealmDbTheme {
//                val courses by viewModel.courses.collectAsState()
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//                    items(courses) { course ->
//                        CourseItem(
//                            course = course,
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .fillMaxWidth()
//                        )
//                    }
//                }

                HomeScreen()
            }
        }
    }
}


@Composable
fun CourseItem(
    course: Course,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = course.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(
            text = "hello this course by" + course.teacher?.address?.fullName,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Enrolled students ${course.enrolledStudents.joinToString { it.name }}",
            fontSize = 10.sp
        )
    }
}