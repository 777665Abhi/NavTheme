package com.abhi.qualixlab.setting

import android.os.Bundle
import android.view.View
import com.abhi.qualixlab.BaseActivity
import com.abhi.qualixlab.MainActivity
import com.abhi.qualixlab.R
import com.abhi.qualixlab.utils.SharedData
import com.abhi.qualixlab.utils.Utils
import com.abhi.qualixlab.utils.Utils.Companion.moveNextScreenWithNoStack
import kotlinx.android.synthetic.main.activity_seting.*
import kotlinx.android.synthetic.main.custom_toolbar.*


class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seting)
        initView()
    }

    fun initView() {
        //setting toolbar
        setSupportActionBar(toolbar)
        //enabling back button
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        btApplySetting.setOnClickListener(View.OnClickListener {
            when (bgNav.checkedRadioButtonId) {
                R.id.rdBtBottom -> {
                    SharedData.setNav(this, Utils.NAV_BOTTOM)
                }
                R.id.rdBtSide -> {
                    SharedData.setNav(this, Utils.NAV_SIDE)
                }
            }

            when (bgTheme.checkedRadioButtonId) {
                R.id.rdBtTheme1 -> {
                    SharedData.setTheme(this, Utils.THEME_1)
                }
                R.id.rdBtTheme2 -> {
                    SharedData.setTheme(this, Utils.THEME_2)
                }
                R.id.rdBtTheme3 -> {
                    SharedData.setTheme(this, Utils.THEME_3)
                }
            }
//            onBackPressed()
            moveNextScreenWithNoStack(this, MainActivity::class.java)

        })


    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
