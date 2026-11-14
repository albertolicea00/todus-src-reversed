package cu.todus.android.db;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.ChunkEntity;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.RosterChange;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
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
import cu.todus.android.db.typeconverter.Data;
import cu.todus.android.db.typeconverter.JobTypeConverters;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@TypeConverters({ToDusTypeConverter.class, Data.class, JobTypeConverters.class})
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H&¨\u0006#"}, d2 = {"Lcu/todus/android/db/ToDusDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "configDao", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "contactDao", "Lcu/todus/android/db/dao/toDus/ContactDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "marketActionDao", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "linkedDeviceDao", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "stickerPackDao", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "stickerDao", "Lcu/todus/android/db/dao/toDus/StickerDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "rosterChangeDao", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "chunkDao", "Lcu/todus/android/db/dao/toDus/ChunkDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Database(entities = {User.class, Room.class, UserRoomJoin.class, Attachment.class, Message.class, MarkerAction.class, Contact.class, LinkedDevice.class, Config.class, Reaction.class, StickerPack.class, Sticker.class, Status.class, RosterChange.class, ChunkEntity.class}, exportSchema = false, version = 11)
public abstract class ToDusDatabase extends RoomDatabase {
    private static final String DB_NAME = "toDus.db";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/todus/android/db/ToDusDatabase$Companion;", "", "<init>", "()V", "DB_NAME", "", "createInstance", "Lcu/todus/android/db/ToDusDatabase;", "context", "Landroid/content/Context;", "ownerId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final ToDusDatabase createInstance(Context context, String ownerId) {
            y.i(context, "context");
            y.i(ownerId, "ownerId");
            RoomDatabase.Builder builderAllowMainThreadQueries = androidx.room.Room.databaseBuilder(context, ToDusDatabase.class, ToDusDatabase.DB_NAME).fallbackToDestructiveMigrationOnDowngrade().allowMainThreadQueries();
            Migrations migrations = Migrations.INSTANCE;
            return (ToDusDatabase) builderAllowMainThreadQueries.addMigrations(migrations.getMIGRATION_2_3(), migrations.getMIGRATION_3_4(), migrations.getMIGRATION_4_5(), migrations.getMIGRATION_5_6(), migrations.getMIGRATION_6_7(), migrations.getMIGRATION_7_8(), migrations.getMIGRATION_8_9(), migrations.getMIGRATION_9_10(), migrations.getMIGRATION_10_11()).build();
        }

        private Companion() {
        }
    }

    public abstract AttachmentDao attachmentDao();

    public abstract ChunkDao chunkDao();

    public abstract ConfigDao configDao();

    public abstract ContactDao contactDao();

    public abstract LinkedDeviceDao linkedDeviceDao();

    public abstract MarkerActionDao marketActionDao();

    public abstract MessageDao messageDao();

    public abstract ReactionDao reactionDao();

    public abstract RoomDao roomDao();

    public abstract RosterChangeDao rosterChangeDao();

    public abstract StatusDao statusDao();

    public abstract StickerDao stickerDao();

    public abstract StickerPackDao stickerPackDao();

    public abstract UserDao userDao();

    public abstract UserRoomJoinDao userRoomJoinDao();
}
