package com.abhi.qualixlab.utils

import android.content.Context
import android.content.Intent

class Utils {
    companion object {
        val THEME_1: String ="THEME_1"
        val THEME_2: String ="THEME_2"
        val THEME_3: String ="THEME_3"

        val NAV_SIDE: String ="NAV_SIDE"
        val NAV_BOTTOM: String ="NAV_BOTTOM"


        fun moveNextScreen(source: Context, destination: Class<*>) {
            val intent = Intent(source, destination)
            intent.flags=Intent.FLAG_ACTIVITY_NO_ANIMATION
            source.startActivity(intent)

        }

        fun moveNextScreenWithNoStack(source: Context, destination: Class<*>) {
            val intent = Intent(source, destination)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
            source.startActivity(intent)
        }
    }
}