package com.abhi.qualixlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhi.qualixlab.utils.SharedData
import com.abhi.qualixlab.utils.Utils

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when(SharedData.getTheme(this) )
        {
            Utils.THEME_1->
            {
                setTheme(R.style.AppTheme_1)
            }
            Utils.THEME_2->
            {
                setTheme(R.style.AppTheme_2)
            }
            Utils.THEME_3->
            {
                setTheme(R.style.AppTheme_3)
            }
        }
        setContentView(R.layout.activity_base)
    }
}
