package com.example.trainingrealm;


import android.app.Application;

import com.example.trainingrealm.data.local.model.Migration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class TaskListApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("tasky.realm")
                .schemaVersion(1)
               // .migration(new Migration())
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
