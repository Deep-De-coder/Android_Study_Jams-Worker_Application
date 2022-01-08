package com.example.workersapplication.database.User

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addUser(user: User)

    @Query("SELECT * FROM User_Table")
    fun getAll(): LiveData<List<User>>
}