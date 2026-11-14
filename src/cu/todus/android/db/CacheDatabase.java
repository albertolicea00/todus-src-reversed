package cu.todus.android.db;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
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
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@TypeConverters({ToDusTypeConverter.class, Data.class, JobTypeConverters.class})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcu/todus/android/db/CacheDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "productDao", "Lcu/todus/android/db/dao/cache/ProductDao;", "welcomeMessageDao", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "botShortcutDao", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Database(entities = {Product.class, WelcomeMessage.class, BotShortcut.class}, exportSchema = false, version = 6)
public abstract class CacheDatabase extends RoomDatabase {
    private static final String DB_NAME = "cache.db";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcu/todus/android/db/CacheDatabase$Companion;", "", "<init>", "()V", "DB_NAME", "", "createInstance", "Lcu/todus/android/db/CacheDatabase;", "context", "Landroid/content/Context;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final CacheDatabase createInstance(Context context) {
            y.i(context, "context");
            return (CacheDatabase) Room.databaseBuilder(context, CacheDatabase.class, CacheDatabase.DB_NAME).fallbackToDestructiveMigrationOnDowngrade().fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }

        private Companion() {
        }
    }

    public abstract BotShortcutDao botShortcutDao();

    public abstract ProductDao productDao();

    public abstract WelcomeMessageDao welcomeMessageDao();
}
