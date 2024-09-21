package com.ismailmesutmujde.kotlinstoragepreferencesdatastore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appPref = AppPref(this)

        val job = CoroutineScope(Dispatchers.Main).launch {
            //appPref.recordName("Ahmet")
            appPref.deleteName()
            val incomingName = appPref.readName()
            Log.e("Incoming Name", incomingName)
        }
    }
}