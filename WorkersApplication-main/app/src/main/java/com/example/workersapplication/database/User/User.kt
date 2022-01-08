package com.example.workersapplication.database.User

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Tables in database*/
@Entity(tableName = "User_Table")
data class User(
    @PrimaryKey val uid: Int,
    @NonNull @ColumnInfo(name = "firstname") val fname: String,
    @NonNull @ColumnInfo(name = "lastname") val lname: String,
    @NonNull @ColumnInfo(name = "email") val email: String,
    @NonNull @ColumnInfo(name = "locality") val locality: String,
    @NonNull @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "time") val time: Int,
    @ColumnInfo(name = "expected_salary") val expected_salary: Int,
    @ColumnInfo(name = "requirements") val requirements: String,
    @NonNull @ColumnInfo(name = "contact_no_user") val contact_no_user: Int
)
