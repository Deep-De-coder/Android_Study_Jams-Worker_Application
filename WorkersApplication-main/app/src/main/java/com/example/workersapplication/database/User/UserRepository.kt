package com.example.workersapplication.database.User

import androidx.lifecycle.LiveData

class UserRepository (private val UserDao: UserDao) {
    val readAllData: LiveData<List<User>> = UserDao.getAll()

    suspend fun addUser(user: User){
        UserDao.addUser(user)
    }
}