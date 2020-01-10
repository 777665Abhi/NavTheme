package com.abhi.qualixlab.utils

import android.app.Activity

object SharedData {
    val PREF = "PREF"
    val NAV_TYPE = "NAV_TYPE"
    val THEME_TYPE = "THEME_TYPE"

    /*-----------------------------APP SOUND*/
    fun setNav(activity: Activity, navType: String) {
        val preferences =activity.getSharedPreferences(PREF, 0)
        val editor = preferences.edit()
        editor.putString(NAV_TYPE, navType)
        editor.commit()
    }

    fun getNav(activity: Activity): String {
        val preferences =activity.getSharedPreferences(PREF, 0)
        return preferences.getString(NAV_TYPE, Utils.NAV_BOTTOM)!!
    }
    /*-----------------------------  THEME TYPE*/
    fun setTheme(activity: Activity, theme: String) {
        val preferences =activity.getSharedPreferences(PREF, 0)
        val editor = preferences.edit()

        editor.putString(THEME_TYPE, theme)
        editor.commit()
    }

    fun getTheme(activity: Activity): String {
        val preferences =activity.getSharedPreferences(PREF, 0)
        return preferences.getString(THEME_TYPE, Utils.THEME_1)!!
    }


}