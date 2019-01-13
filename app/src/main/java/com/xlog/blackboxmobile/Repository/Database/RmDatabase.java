package com.xlog.blackboxmobile.Repository.Database;

import android.content.Context;

import com.xlog.blackboxmobile.Repository.Dao.RmDao;
import com.xlog.blackboxmobile.Repository.Entity.TokenEntity;
import com.xlog.blackboxmobile.Repository.Entity.UserDetailsEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {TokenEntity.class, UserDetailsEntity.class}, version = 3, exportSchema = false)
public abstract class RmDatabase extends RoomDatabase {

    private static final String DB_NAME = "RoomDatabase.db";
    private static RmDatabase INSTANCE;

    public abstract RmDao rmDao();

    public static RmDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RmDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RmDatabase.class, DB_NAME).addMigrations(MIGRATION_1_3)
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;

    }

    static final Migration MIGRATION_1_3 = new Migration(1, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `UserDetails` (`id` INTEGER, " + "`user_id` TEXT,`account_id` TEXT,`image` TEXT,`first_name` TEXT,`last_name` TEXT,`account_type` TEXT, PRIMARY KEY(`id`))");
        }
    };
}