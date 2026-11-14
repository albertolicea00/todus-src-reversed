package cu.todus.android.di;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.db.CacheDatabase;
import cu.todus.android.db.ToDusDatabase;
import cu.todus.android.db.dao.cache.BotShortcutDao;
import cu.todus.android.db.dao.cache.ProductDao;
import cu.todus.android.db.dao.cache.WelcomeMessageDao;
import cu.todus.android.db.dao.notifications.ConfigDao;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.ChunkDao;
import cu.todus.android.db.dao.toDus.ContactDao;
import cu.todus.android.db.dao.toDus.LinkedDeviceDao;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.RosterChangeDao;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.db.dao.toDus.StickerDao;
import cu.todus.android.db.dao.toDus.StickerPackDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010X\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010Y\u001a\u00020I2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcu/todus/android/di/DatabaseModule;", "", "appContext", "Landroid/content/Context;", "ownerId", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "toDusDatabase", "Lcu/todus/android/db/ToDusDatabase;", "getToDusDatabase", "()Lcu/todus/android/db/ToDusDatabase;", "configDao", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "getConfigDao", "()Lcu/todus/android/db/dao/notifications/ConfigDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "getAttachmentDao", "()Lcu/todus/android/db/dao/toDus/AttachmentDao;", "contactDao", "Lcu/todus/android/db/dao/toDus/ContactDao;", "getContactDao", "()Lcu/todus/android/db/dao/toDus/ContactDao;", "markerActionDao", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "getMarkerActionDao", "()Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "getMessageDao", "()Lcu/todus/android/db/dao/toDus/MessageDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "getRoomDao", "()Lcu/todus/android/db/dao/toDus/RoomDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "getUserDao", "()Lcu/todus/android/db/dao/toDus/UserDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "getUserRoomJoinDao", "()Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "linkedDeviceDao", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "getLinkedDeviceDao", "()Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "getReactionDao", "()Lcu/todus/android/db/dao/toDus/ReactionDao;", "stickerPackDao", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "getStickerPackDao", "()Lcu/todus/android/db/dao/toDus/StickerPackDao;", "stickerDao", "Lcu/todus/android/db/dao/toDus/StickerDao;", "getStickerDao", "()Lcu/todus/android/db/dao/toDus/StickerDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "getStatusDao", "()Lcu/todus/android/db/dao/toDus/StatusDao;", "rosterChangeDao", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "getRosterChangeDao", "()Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "chunkDao", "Lcu/todus/android/db/dao/toDus/ChunkDao;", "getChunkDao", "()Lcu/todus/android/db/dao/toDus/ChunkDao;", "cacheDatabase", "Lcu/todus/android/db/CacheDatabase;", "getCacheDatabase", "()Lcu/todus/android/db/CacheDatabase;", "productDao", "Lcu/todus/android/db/dao/cache/ProductDao;", "getProductDao", "()Lcu/todus/android/db/dao/cache/ProductDao;", "welcomeMessageDao", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "getWelcomeMessageDao", "()Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "botShortcutDao", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "getBotShortcutDao", "()Lcu/todus/android/db/dao/cache/BotShortcutDao;", "provideToDusDatabase", "provideCacheDatabase", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatabaseModule {
    private final AttachmentDao attachmentDao;
    private final BotShortcutDao botShortcutDao;
    private final CacheDatabase cacheDatabase;
    private final ChunkDao chunkDao;
    private final ConfigDao configDao;
    private final ContactDao contactDao;
    private final LinkedDeviceDao linkedDeviceDao;
    private final MarkerActionDao markerActionDao;
    private final MessageDao messageDao;
    private final String ownerId;
    private final ProductDao productDao;
    private final ReactionDao reactionDao;
    private final RoomDao roomDao;
    private final RosterChangeDao rosterChangeDao;
    private final StatusDao statusDao;
    private final StickerDao stickerDao;
    private final StickerPackDao stickerPackDao;
    private final ToDusDatabase toDusDatabase;
    private final UserDao userDao;
    private final UserRoomJoinDao userRoomJoinDao;
    private final WelcomeMessageDao welcomeMessageDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/di/DatabaseModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/di/DatabaseModule;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<DatabaseModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public DatabaseModule(Context appContext, String ownerId) {
        y.i(appContext, "appContext");
        y.i(ownerId, "ownerId");
        this.ownerId = ownerId;
        ToDusDatabase toDusDatabaseProvideToDusDatabase = provideToDusDatabase(appContext);
        this.toDusDatabase = toDusDatabaseProvideToDusDatabase;
        this.configDao = toDusDatabaseProvideToDusDatabase.configDao();
        this.attachmentDao = toDusDatabaseProvideToDusDatabase.attachmentDao();
        this.contactDao = toDusDatabaseProvideToDusDatabase.contactDao();
        this.markerActionDao = toDusDatabaseProvideToDusDatabase.marketActionDao();
        this.messageDao = toDusDatabaseProvideToDusDatabase.messageDao();
        this.roomDao = toDusDatabaseProvideToDusDatabase.roomDao();
        this.userDao = toDusDatabaseProvideToDusDatabase.userDao();
        this.userRoomJoinDao = toDusDatabaseProvideToDusDatabase.userRoomJoinDao();
        this.linkedDeviceDao = toDusDatabaseProvideToDusDatabase.linkedDeviceDao();
        this.reactionDao = toDusDatabaseProvideToDusDatabase.reactionDao();
        this.stickerPackDao = toDusDatabaseProvideToDusDatabase.stickerPackDao();
        this.stickerDao = toDusDatabaseProvideToDusDatabase.stickerDao();
        this.statusDao = toDusDatabaseProvideToDusDatabase.statusDao();
        this.rosterChangeDao = toDusDatabaseProvideToDusDatabase.rosterChangeDao();
        this.chunkDao = toDusDatabaseProvideToDusDatabase.chunkDao();
        CacheDatabase cacheDatabaseProvideCacheDatabase = provideCacheDatabase(appContext);
        this.cacheDatabase = cacheDatabaseProvideCacheDatabase;
        this.productDao = cacheDatabaseProvideCacheDatabase.productDao();
        this.welcomeMessageDao = cacheDatabaseProvideCacheDatabase.welcomeMessageDao();
        this.botShortcutDao = cacheDatabaseProvideCacheDatabase.botShortcutDao();
    }

    private final CacheDatabase provideCacheDatabase(Context appContext) {
        return CacheDatabase.INSTANCE.createInstance(appContext);
    }

    private final ToDusDatabase provideToDusDatabase(Context appContext) {
        return ToDusDatabase.INSTANCE.createInstance(appContext, this.ownerId);
    }

    public final AttachmentDao getAttachmentDao() {
        return this.attachmentDao;
    }

    public final BotShortcutDao getBotShortcutDao() {
        return this.botShortcutDao;
    }

    public final CacheDatabase getCacheDatabase() {
        return this.cacheDatabase;
    }

    public final ChunkDao getChunkDao() {
        return this.chunkDao;
    }

    public final ConfigDao getConfigDao() {
        return this.configDao;
    }

    public final ContactDao getContactDao() {
        return this.contactDao;
    }

    public final LinkedDeviceDao getLinkedDeviceDao() {
        return this.linkedDeviceDao;
    }

    public final MarkerActionDao getMarkerActionDao() {
        return this.markerActionDao;
    }

    public final MessageDao getMessageDao() {
        return this.messageDao;
    }

    public final ProductDao getProductDao() {
        return this.productDao;
    }

    public final ReactionDao getReactionDao() {
        return this.reactionDao;
    }

    public final RoomDao getRoomDao() {
        return this.roomDao;
    }

    public final RosterChangeDao getRosterChangeDao() {
        return this.rosterChangeDao;
    }

    public final StatusDao getStatusDao() {
        return this.statusDao;
    }

    public final StickerDao getStickerDao() {
        return this.stickerDao;
    }

    public final StickerPackDao getStickerPackDao() {
        return this.stickerPackDao;
    }

    public final ToDusDatabase getToDusDatabase() {
        return this.toDusDatabase;
    }

    public final UserDao getUserDao() {
        return this.userDao;
    }

    public final UserRoomJoinDao getUserRoomJoinDao() {
        return this.userRoomJoinDao;
    }

    public final WelcomeMessageDao getWelcomeMessageDao() {
        return this.welcomeMessageDao;
    }
}
