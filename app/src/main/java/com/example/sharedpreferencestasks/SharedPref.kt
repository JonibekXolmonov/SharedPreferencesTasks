package com.example.sharedpreferencestasks

import android.content.Context
import com.example.sharedpreferencestasks.model.Member
import com.example.sharedpreferencestasks.model.User
import com.google.gson.Gson

class SharedPref(private val context: Context) {

    val sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
    val gson = Gson()

    fun save(key: String, data: Long) {
        sharedPref.edit().putLong(key, data).apply()
    }

    fun save(key: String, data: Boolean) {
        sharedPref.edit().putBoolean(key, data).apply()
    }

    fun save(key: String, data: Int) {
        sharedPref.edit().putInt(key, data).apply()
    }

    fun save(key: String, data: Double) {
        sharedPref.edit().putFloat(key, data.toFloat()).apply()
    }

    fun save(key: String, objects: Any) {
        val toJsonMember = gson.toJson(objects)
        sharedPref.edit().putString(key, toJsonMember).apply()
    }

    fun getMember(key: String): Member {
        val gsonMember = sharedPref.getString(key, "")

        return gson.fromJson(gsonMember, Member::class.java)
    }

    fun getUser(key: String): User {
        val gsonUser = sharedPref.getString(key, "")

        return gson.fromJson(gsonUser, User::class.java)
    }

    fun get(key: String): Any {
        if (sharedPref.contains(key)) {
            sharedPref.all.entries.forEach {
                if (it.key == key) {
                    return it.value!!
                }
            }
        }
        return 0
    }
}