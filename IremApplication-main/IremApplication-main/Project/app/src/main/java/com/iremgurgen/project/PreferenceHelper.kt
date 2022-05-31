package com.iremgurgen.project

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    companion object {
        private const val prefsFileName = "irem_preferences"
        private const val infoConst = "info"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFileName, MODE_PRIVATE)

    var informationData: InformationData?
        get() = prefs.getString(infoConst, null)?.let { myMoshi.adapter(InformationData::class.java).fromJson(it) }
        set(value) = prefs.edit().putString(infoConst, myMoshi.adapter(InformationData::class.java).toJson(value)).apply()

}