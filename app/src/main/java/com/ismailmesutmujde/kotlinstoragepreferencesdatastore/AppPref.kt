package com.ismailmesutmujde.kotlinstoragepreferencesdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


class AppPref(var context : Context) {
    val Context.dataStore : DataStore<Preferences> by preferencesDataStore("informations")

    companion object {
        val NAME_KEY = stringPreferencesKey("NAME")
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
}