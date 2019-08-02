package com.mredrock.cyxbs.freshman.util

import android.app.Activity
import android.content.Context
import android.content.Intent

public inline fun <reified T: Activity> Context.startActivity(
    vararg params: Pair<String, String>) {
    val intent = Intent(this, T::class.java)
    params.forEach { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}