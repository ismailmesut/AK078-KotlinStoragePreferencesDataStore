package com.ismailmesutmujde.kotlinstoragepreferencesdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


class AppPref(var context : Context) {
    val Context.dataStore : DataStore<Preferences> by preferencesDataStore("informations")

    companion object {
        val NAME_KEY = stringPreferencesKey("NAME")
        val AGE_KEY = intPreferencesKey("AGE")
        val HEIGHT_KEY = doublePreferencesKey("HEIGHT")
        val AREYOUSINGLE_KEY = booleanPreferencesKey("AREYOUSINGLE")
        val FRIEND_LIST_KEY = stringSetPreferencesKey("FRIEND_LIST")
        val COUNTER_KEY = intPreferencesKey("COUNTER")
    }

    suspend fun recordName(name: String) {
        context.dataStore.edit {
            it[NAME_KEY] = name
        }
    }

    suspend fun readName() : String {
        val p = context.dataStore.data.first()
        return p[NAME_KEY] ?: "no name"
    }

    suspend fun deleteName() {
        context.dataStore.edit {
            it.remove(NAME_KEY)
        }
    }

    suspend fun recordAge(age: Int) {
        context.dataStore.edit {
            it[AGE_KEY] = age
        }
    }

    suspend fun readAge() : Int {
        val p = context.dataStore.data.first()
        return p[AGE_KEY] ?: 0
    }

    suspend fun deleteAge() {
        context.dataStore.edit {
            it.remove(AGE_KEY)
        }
    }

    suspend fun recordHeight(height: Double) {
        context.dataStore.edit {
            it[HEIGHT_KEY] = height
        }
    }

    suspend fun readHeight() : Double {
        val p = context.dataStore.data.first()
        return p[HEIGHT_KEY] ?: 0.0
    }

    suspend fun deleteHeight() {
        context.dataStore.edit {
            it.remove(HEIGHT_KEY)
        }
    }

    suspend fun recordAreYouSingle(areYouSingle: Boolean) {
        context.dataStore.edit {
            it[AREYOUSINGLE_KEY] = areYouSingle
        }
    }

    suspend fun readAreYouSingle() : Boolean {
        val p = context.dataStore.data.first()
        return p[AREYOUSINGLE_KEY] ?: false
    }

    suspend fun deleteAreYouSingle() {
        context.dataStore.edit {
            it.remove(AREYOUSINGLE_KEY)
        }
    }

    suspend fun recordFriendList(friendList: Set<String>) {
        context.dataStore.edit {
            it[FRIEND_LIST_KEY] = friendList
        }
    }

    suspend fun readFriendList() : Set<String>? {
        val p = context.dataStore.data.first()
        return p[FRIEND_LIST_KEY]
    }

    suspend fun deleteFriendList() {
        context.dataStore.edit {
            it.remove(FRIEND_LIST_KEY)
        }
    }

    suspend fun recordCounter(counter: Int) {
        context.dataStore.edit {
            it[COUNTER_KEY] = counter
        }
    }

    suspend fun readCounter() : Int {
        val p = context.dataStore.data.first()
        return p[COUNTER_KEY] ?: 0
    }

    suspend fun deleteCounter() {
        context.dataStore.edit {
            it.remove(COUNTER_KEY)
        }
    }

}