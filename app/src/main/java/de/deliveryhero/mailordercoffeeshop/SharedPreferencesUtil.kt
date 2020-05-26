package de.deliveryhero.mailordercoffeeshop

import android.app.Activity
import android.content.Context

object SharedPreferencesUtil {

        private val IS_FIRST_LAUNCH = "is_first_launch"

        fun setIsFirstLaunchToFalse(context: Context) {
            val editor = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE).edit()
            editor.putBoolean(IS_FIRST_LAUNCH, false)
            editor.commit()
        }

        fun isFirstLaunch(context: Context): Boolean {
            val sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
            return sharedPreferences.getBoolean(IS_FIRST_LAUNCH, true)
        }
}
