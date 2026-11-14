package cu.todus.android.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import cu.todus.android.db.dao.cache.BotShortcutDao;
import cu.todus.android.db.dao.cache.ProductDao;
import cu.todus.android.db.dao.cache.WelcomeMessageDao;
import cu.todus.android.db.typeconverter.Data;
import cu.todus.android.db.typeconverter.JobTypeConverters;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;

/**
 * Secondary Room cache database ({@code cache.db}, schema version 6) for
 * catalog products, welcome messages, and bot shortcuts.
 *
 * @obfuscated_class cu.todus.android.db.CacheDatabase
 */
@Database(
        entities = {Product.class, WelcomeMessage.class, BotShortcut.class},
        exportSchema = false,
        version = 6
)
@TypeConverters({ToDusTypeConverter.class, Data.class, JobTypeConverters.class})
public abstract class CacheDatabase extends RoomDatabase {

    private static final String DB_NAME = "cache.db";

    public static CacheDatabase createInstance(Context context) {
        return Room.databaseBuilder(context, CacheDatabase.class, DB_NAME)
                .fallbackToDestructiveMigrationOnDowngrade()
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public abstract BotShortcutDao botShortcutDao();

    public abstract ProductDao productDao();

    public abstract WelcomeMessageDao welcomeMessageDao();
}
