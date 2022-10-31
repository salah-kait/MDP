package com.miu.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.provider.AlarmClock.EXTRA_MESSAGE

class MainActivity : AppCompatActivity() {
    var users = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUsers()
        setContentView(R.layout.activity_main)

        val user = intent.getSerializableExtra(EXTRA_MESSAGE) as? User
        if (user != null) {
            users.add(user)
            Toast.makeText(this, "Account create for ${user._firstName} ${user._lastName}", Toast.LENGTH_LONG).show()
        }
    }

    fun addUsers() {
        users.add(User("salah", "khdairat", "salah@gmail.com", "123"))
        users.add(User("joud", "khdairat", "joud@gmail.com", "123"))
        users.add(User("zain", "khdairat", "zain@gmail.com", "123"))
        users.add(User("mohammad", "khdairat", "moh@gmail.com", "123"))
        users.add(User("lina", "khdairat", "lina@gmail.com", "123"))
    }

    fun login(view: View) {
        var email: String = findViewById<EditText>(R.id.emailAddress).text.toString()
        var password: String = findViewById<EditText>(R.id.password).text.toString()
        var userFound: Boolean = false

        for(user in users) {
            if(user._email.equals(email) && user._password.equals(password)) {
                userFound = true
            }
        }

        if(userFound) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ShoppingCategoryActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, email)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_LONG).show()
        }
    }

    fun register(view: View) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}