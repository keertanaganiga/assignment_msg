package com.keertana.sample_login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//        fetchDataBtn.setOnClickListener {
//            val intent= Intent(this,ListDisplay::class.java)
//            startActivity(intent)
//        }
        fetchDataBtn. setOnClickListener {
            if (et_email.text.trim().isNotEmpty() || et_password.text.trim().isNotEmpty()){
                Toast.makeText(this,"Input Provided",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,ListDisplay::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Input required",Toast.LENGTH_SHORT).show()
            }
        }

    }

}
