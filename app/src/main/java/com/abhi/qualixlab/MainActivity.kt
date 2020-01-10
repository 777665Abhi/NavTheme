package com.abhi.qualixlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main)
        btAddOption.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        })
    }
}
