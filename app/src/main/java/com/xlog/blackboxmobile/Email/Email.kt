package com.xlog.blackboxmobile.Email

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.xlog.blackboxmobile.R
import kotlinx.android.synthetic.main.activity_email.*

class Email : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        setSupportActionBar(emailToolbar)
        val actionBar = supportActionBar

        actionBar!!.title = "Compose"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.email_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
