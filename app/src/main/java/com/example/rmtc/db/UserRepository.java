package com.example.rmtc.db;
import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.rmtc.User;
import java.util.List;

public class UserRepository {

    private final UserDao userDao;
    private final LiveData<List<User>> userLiveData;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();

        userLiveData = userDao.getUsers();
    }

    public LiveData<List<User>> getUserLiveData() {
        return userLiveData;
    }

    public void setUser(User user) {
        AppDatabase.databaseExecutor.execute(() -> userDao.setUser(user));
    }

    public LiveData<User> getCurrentUser(final String username, final String password) {
        return userDao.getCurrentUser(username, password);
    }
}
