package com.keertana.sample_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val BASE_URL="https://api.publicapis.org/"
class ListDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_display)

        val actionBar=supportActionBar
        actionBar!!.title="Second Activity"
        actionBar.setDisplayHomeAsUpEnabled(true)


    }


}