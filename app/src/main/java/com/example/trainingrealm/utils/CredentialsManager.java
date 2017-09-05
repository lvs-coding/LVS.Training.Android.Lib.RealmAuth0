package com.example.trainingrealm.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.auth0.android.result.Credentials;
import com.example.trainingrealm.R;

import static com.example.trainingrealm.utils.Constants.ACCESS_TOKEN;
import static com.example.trainingrealm.utils.Constants.EXPIRES_IN;
import static com.example.trainingrealm.utils.Constants.ID_TOKEN;
import static com.example.trainingrealm.utils.Constants.REFRESH_TOKEN;
import static com.example.trainingrealm.utils.Constants.TOKEN_TYPE;

public class CredentialsManager {

    public static void saveCredentials(Context context, Credentials credentials) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.auth0_preferences), Context.MODE_PRIVATE);

        sharedPref.edit()
                .putString(ID_TOKEN, credentials.getIdToken())
                .putString(REFRESH_TOKEN, credentials.getRefreshToken())
                .putString(ACCESS_TOKEN, credentials.getAccessToken())
                .putString(TOKEN_TYPE, credentials.getType())
                .putLong(EXPIRES_IN, credentials.getExpiresIn())
                .apply();
    }

    public static Credentials getCredentials(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.auth0_preferences), Context.MODE_PRIVATE);

        return new Credentials(
                sharedPref.getString(ID_TOKEN, null),
                sharedPref.getString(ACCESS_TOKEN, null),
                sharedPref.getString(TOKEN_TYPE, null),
                sharedPref.getString(REFRESH_TOKEN, null),
                sharedPref.getLong(EXPIRES_IN, 0));
    }

    public static void deleteCredentials(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.auth0_preferences), Context.MODE_PRIVATE);

        sharedPref.edit()
                .putString(ID_TOKEN, null)
                .putString(REFRESH_TOKEN, null)
                .putString(ACCESS_TOKEN, null)
                .putString(TOKEN_TYPE, null)
                .putLong(EXPIRES_IN, 0)
                .apply();
    }
}
