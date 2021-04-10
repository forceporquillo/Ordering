package com.example.rmtc.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rmtc.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
abstract class AppDatabase extends RoomDatabase {

    abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUM_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUM_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase"
                    )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
