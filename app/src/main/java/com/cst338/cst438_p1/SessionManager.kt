package com.cst338.cst438_p1

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "session")

class SessionManager(private val context: Context) {

    private val USER_ID = intPreferencesKey("uid")

    // use Int? in case prefs[USER_ID] = null
    val userId: Flow<Int?> = context.dataStore.data.map { prefs ->
        prefs[USER_ID]
    }

    suspend fun login(userId: Int) {
        context.dataStore.edit { prefs ->
            prefs[USER_ID] = userId
        }
    }

    suspend fun logout() {
        context.dataStore.edit { prefs ->
            prefs.remove(USER_ID)
        }
    }
}