package com.example.workersapplication.database.workers

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workers(

    @PrimaryKey val wid: Int,
    @NonNull @ColumnInfo(name = "fname") val fName: String,
    @NonNull @ColumnInfo(name = "lname") val lName: String,
    @NonNull @ColumnInfo(name = "gender") val gender: String,
    @NonNull @ColumnInfo(name = "age") val age: Int,
    @NonNull @ColumnInfo(name = "experience") val experience: Int,
    @NonNull @ColumnInfo(name = "locality") val locality: String,
    @NonNull @ColumnInfo(name = "city") val city: String,
    @NonNull @ColumnInfo(name = "price") val price: Int,
    @NonNull @ColumnInfo(name = "families_cared") val families_cared: Int,
    @NonNull @ColumnInfo(name = "rating") val rating: Float,
    @NonNull @ColumnInfo(name = "category") val category: String,
    @NonNull @ColumnInfo(name = "contact_no") val contact_no: String,


)