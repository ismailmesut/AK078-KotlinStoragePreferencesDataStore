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
            appPref.recordName("Ahmet")
            appPref.recordAge(23)
            appPref.recordHeight(1.78)
            appPref.recordAreYouSingle(true)

            val friendList = HashSet<String>()
            friendList.add("Mehmet")
            friendList.add("Zeynep")
            appPref.recordFriendList(friendList)


            //appPref.deleteName()
            //appPref.deleteAge()
            //appPref.deleteHeight()
            //appPref.deleteAreYouSingle()
            //appPref.deleteFriendList()

            val incomingName = appPref.readName()
            val incomingAge = appPref.readAge()
            val incomingHeight = appPref.readHeight()
            val incomingAreYouSingle = appPref.readAreYouSingle()

            Log.e("Incoming Name", incomingName)
            Log.e("Incoming Age", incomingAge.toString())
            Log.e("Incoming Height", incomingHeight.toString())
            Log.e("Incoming AreYouSingle", incomingAreYouSingle.toString())

            val incomingFriendList = appPref.readFriendList()
            if (incomingFriendList != null) {
                for (f in incomingFriendList) {
                    Log.e("Incoming Friend", f)
                }
            }

        }
    }
}