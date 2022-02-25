package com.abedfattal.json.assets

import android.annotation.SuppressLint
import android.content.Context
import androidx.startup.Initializer


/**
 * An initializer for library configuration.
 * Must be initialized before using any functionality from the package,
 * mainly it's good pattern to be call [init] inside your [android.app.Application.onCreate] subclass.
 *
 * */
class ContextInitializer : Initializer<Unit> {
    override fun create(c: Context) {
        context = c
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        internal lateinit var context: Context

    }

}