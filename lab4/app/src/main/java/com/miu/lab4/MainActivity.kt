package com.miu.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var users = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUsers()
        setContentView(R.layout.activity_main)
    }

    fun addUsers() {
        users.add(User("salah", "khdairat", "salah@gmail.com", "123"))
        users.add(User("joud", "khdairat", "joud@gmail.com", "123"))
        users.add(User("zain", "khdairat", "zain@gmail.com", "123"))
        users.add(User("mohammad", "khdairat", "moh@gmail.com", "123"))
        users.add(User("lina", "khdairat", "lina@gmail.com", "123"))
    }
}