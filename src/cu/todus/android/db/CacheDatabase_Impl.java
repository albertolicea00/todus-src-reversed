package cu.todus.android.db;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.db.dao.cache.BotShortcutDao;
import cu.todus.android.db.dao.cache.BotShortcutDao_Impl;
import cu.todus.android.db.dao.cache.ProductDao;
import cu.todus.android.db.dao.cache.ProductDao_Impl;
import cu.todus.android.db.dao.cache.WelcomeMessageDao;
import cu.todus.android.db.dao.cache.WelcomeMessageDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u000f\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000e0\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$¨\u0006'"}, d2 = {"Lcu/todus/android/db/CacheDatabase_Impl;", "Lcu/todus/android/db/CacheDatabase;", "<init>", "()V", "Landroidx/room/RoomOpenDelegate;", "createOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "Landroidx/room/InvalidationTracker;", "createInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "Lua/k0;", "clearAllTables", "", "Lsb/d;", "", "getRequiredTypeConverterClasses", "()Ljava/util/Map;", "", "Landroidx/room/migration/AutoMigrationSpec;", "getRequiredAutoMigrationSpecClasses", "()Ljava/util/Set;", "autoMigrationSpecs", "Landroidx/room/migration/Migration;", "createAutoMigrations", "(Ljava/util/Map;)Ljava/util/List;", "Lcu/todus/android/db/dao/cache/ProductDao;", "productDao", "()Lcu/todus/android/db/dao/cache/ProductDao;", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "welcomeMessageDao", "()Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "botShortcutDao", "()Lcu/todus/android/db/dao/cache/BotShortcutDao;", "Lua/n;", "_productDao", "Lua/n;", "_welcomeMessageDao", "_botShortcutDao", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CacheDatabase_Impl extends CacheDatabase {
    public static final int $stable = 8;
    private final ua.n _productDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.a
        @Override // lb.a
        public final Object invoke() {
            return CacheDatabase_Impl._productDao$lambda$0(this.f20239c);
        }
    });
    private final ua.n _welcomeMessageDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.b
        @Override // lb.a
        public final Object invoke() {
            return CacheDatabase_Impl._welcomeMessageDao$lambda$0(this.f20240c);
        }
    });
    private final ua.n _botShortcutDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.c
        @Override // lb.a
        public final Object invoke() {
            return CacheDatabase_Impl._botShortcutDao$lambda$0(this.f20241c);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final BotShortcutDao_Impl _botShortcutDao$lambda$0(CacheDatabase_Impl cacheDatabase_Impl) {
        return new BotShortcutDao_Impl(cacheDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductDao_Impl _productDao$lambda$0(CacheDatabase_Impl cacheDatabase_Impl) {
        return new ProductDao_Impl(cacheDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WelcomeMessageDao_Impl _welcomeMessageDao$lambda$0(CacheDatabase_Impl cacheDatabase_Impl) {
        return new WelcomeMessageDao_Impl(cacheDatabase_Impl);
    }

    @Override // cu.todus.android.db.CacheDatabase
    public BotShortcutDao botShortcutDao() {
        return (BotShortcutDao) this._botShortcutDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "product", WelcomeMessage.TABLE_NAME, BotShortcut.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<sb.d, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        y.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "product", WelcomeMessage.TABLE_NAME, BotShortcut.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public Set<sb.d> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<sb.d, List<sb.d>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(z0.b(ProductDao.class), ProductDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(WelcomeMessageDao.class), WelcomeMessageDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(BotShortcutDao.class), BotShortcutDao_Impl.INSTANCE.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // cu.todus.android.db.CacheDatabase
    public ProductDao productDao() {
        return (ProductDao) this._productDao.getValue();
    }

    @Override // cu.todus.android.db.CacheDatabase
    public WelcomeMessageDao welcomeMessageDao() {
        return (WelcomeMessageDao) this._welcomeMessageDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: cu.todus.android.db.CacheDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(6, "8d87ab42ab4303b5a545389c657c4c1c", "242a556cfe3f459191cd8f6d8829e25f"); // pragma: allowlist secret
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) throws Exception {
                y.i(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `product` (`id` INTEGER NOT NULL, `createdAt` TEXT NOT NULL, `description` TEXT NOT NULL, `name` TEXT NOT NULL, `pictureUrl` TEXT NOT NULL, `price` REAL NOT NULL, `isPublic` INTEGER NOT NULL, `info` TEXT, `offset` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `welcome_message` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `image` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `bot_shortcut` (`id` INTEGER NOT NULL, `roomId` TEXT NOT NULL, `location` TEXT NOT NULL, `icon` TEXT NOT NULL, `label` TEXT NOT NULL, `description` TEXT NOT NULL, `btnColor` TEXT NOT NULL, `btnContent` TEXT NOT NULL, `createAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8d87ab42ab4303b5a545389c657c4c1c')"); // pragma: allowlist secret
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) throws Exception {
                y.i(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `product`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `welcome_message`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `bot_shortcut`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                y.i(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                y.i(connection, "connection");
                this.this$0.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                y.i(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                y.i(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                y.i(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, 1));
                linkedHashMap.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                linkedHashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap.put(User.COLUMN_PHOTO_URL, new TableInfo.Column(User.COLUMN_PHOTO_URL, "TEXT", true, 0, null, 1));
                linkedHashMap.put("price", new TableInfo.Column("price", "REAL", true, 0, null, 1));
                linkedHashMap.put("isPublic", new TableInfo.Column("isPublic", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("info", new TableInfo.Column("info", "TEXT", false, 0, null, 1));
                linkedHashMap.put("offset", new TableInfo.Column("offset", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("product", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo.Companion companion = TableInfo.INSTANCE;
                TableInfo tableInfo2 = companion.read(connection, "product");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "product(cu.todus.android.data.db.entity.cache.Product).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap2.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo(WelcomeMessage.TABLE_NAME, linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo4 = companion.read(connection, WelcomeMessage.TABLE_NAME);
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "welcome_message(cu.todus.android.data.db.entity.cache.WelcomeMessage).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap3.put("roomId", new TableInfo.Column("roomId", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("btnColor", new TableInfo.Column("btnColor", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("btnContent", new TableInfo.Column("btnContent", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("createAt", new TableInfo.Column("createAt", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo(BotShortcut.TABLE_NAME, linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo6 = companion.read(connection, BotShortcut.TABLE_NAME);
                if (tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "bot_shortcut(cu.todus.android.data.db.entity.cache.BotShortcut).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
            }
        };
    }
}
