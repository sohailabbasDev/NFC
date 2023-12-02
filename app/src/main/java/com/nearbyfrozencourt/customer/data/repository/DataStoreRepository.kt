package com.nearbyfrozencourt.customer.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStoreRepository ( private val context : Context) {

    // to make sure there is only one instance
    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "data_store")
//        val ON_BOARD_BOOLEAN_KEY = booleanPreferencesKey("on_boarding_boolean")
        val USER_LOGGED_IN_BOOLEAN_KEY = booleanPreferencesKey("user_logged_boolean")
        val AUTH_TOKEN = stringPreferencesKey("auth_token_string")
//        val USER_UID_KEY = stringPreferencesKey("user_uid_string")
//        val USER_LINK_KEY = stringPreferencesKey("url_link")
    }

//    val getOnBoardBoolean: Flow<Boolean> = context.dataStore.data
//        .catch { exception ->
//            if (exception is IOException) {
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }
//        .map { preferences ->
//            preferences[ON_BOARD_BOOLEAN_KEY] ?: false
//        }

//    suspend fun saveOnBoardBoolean(boolean: Boolean) {
//        context.dataStore.edit {
//            it[ON_BOARD_BOOLEAN_KEY] = boolean
//        }
//    }

    val getUserLoggedBoolean: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[USER_LOGGED_IN_BOOLEAN_KEY] ?: false
        }

    suspend fun saveUserLoggedBoolean(boolean: Boolean) {
        context.dataStore.edit {
            it[USER_LOGGED_IN_BOOLEAN_KEY] = boolean
        }
    }

    val getAuthToken: Flow<String> = context.dataStore.data
        .catch {exception ->
            if (exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }
        .map { preferences ->
            preferences[AUTH_TOKEN] ?: ""
        }

    suspend fun setAuthToken(token : String){
        context.dataStore.edit {
            it[AUTH_TOKEN] = token
        }
    }

//    val getUserUID: Flow<String> = context.dataStore.data
//        .catch {exception ->
//            if (exception is IOException){
//                emit(emptyPreferences())
//            }else{
//                throw exception
//            }
//        }
//        .map { preferences ->
//            preferences[USER_UID_KEY] ?: ""
//        }
//
//    suspend fun saveUserUID(uid : String){
//        context.dataStore.edit {
//            it[USER_UID_KEY] = uid
//        }
//    }
}