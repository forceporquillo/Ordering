package com.example.rmtc.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rmtc.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create a database with ease using RoomDatabase from Architecture Components library
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
abstract class AppDatabase extends RoomDatabase {

    /**
     * An interface Data Access Object which lets us query the users
     * @return
     */
    abstract UserDao userDao();

    /**
     * Store instance of this DB to static field.
     *
     * This is singleton pattern
     */


    private static volatile AppDatabase INSTANCE;

    /**
     * We want our UI to be efficient as possible
     * so we use thread to query our data in the background thread.
     */

    private static final int NUM_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUM_THREADS);

    /**
     *
     * Create singleton instance of database using RoomBuilder
     * @param context the context of the activity which gets the context of application root
     * @return instance of this database
     */
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
