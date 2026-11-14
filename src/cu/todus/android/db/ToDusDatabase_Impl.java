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
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.db.dao.notifications.ConfigDao;
import cu.todus.android.db.dao.notifications.ConfigDao_Impl;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.AttachmentDao_Impl;
import cu.todus.android.db.dao.toDus.ChunkDao;
import cu.todus.android.db.dao.toDus.ChunkDao_Impl;
import cu.todus.android.db.dao.toDus.ContactDao;
import cu.todus.android.db.dao.toDus.ContactDao_Impl;
import cu.todus.android.db.dao.toDus.LinkedDeviceDao;
import cu.todus.android.db.dao.toDus.LinkedDeviceDao_Impl;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.db.dao.toDus.MarkerActionDao_Impl;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.MessageDao_Impl;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.ReactionDao_Impl;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.RoomDao_Impl;
import cu.todus.android.db.dao.toDus.RosterChangeDao;
import cu.todus.android.db.dao.toDus.RosterChangeDao_Impl;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.db.dao.toDus.StatusDao_Impl;
import cu.todus.android.db.dao.toDus.StickerDao;
import cu.todus.android.db.dao.toDus.StickerDao_Impl;
import cu.todus.android.db.dao.toDus.StickerPackDao;
import cu.todus.android.db.dao.toDus.StickerPackDao_Impl;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserDao_Impl;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u000f\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000e0\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00190F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001c0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001f0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010HR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\"0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010HR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020%0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020(0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010HR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020+0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010HR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020.0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010HR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u0002010F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010HR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u0002040F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010HR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u0002070F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010HR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020:0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010HR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020=0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010HR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020@0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010HR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020C0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010H¨\u0006W"}, d2 = {"Lcu/todus/android/db/ToDusDatabase_Impl;", "Lcu/todus/android/db/ToDusDatabase;", "<init>", "()V", "Landroidx/room/RoomOpenDelegate;", "createOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "Landroidx/room/InvalidationTracker;", "createInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "Lua/k0;", "clearAllTables", "", "Lsb/d;", "", "getRequiredTypeConverterClasses", "()Ljava/util/Map;", "", "Landroidx/room/migration/AutoMigrationSpec;", "getRequiredAutoMigrationSpecClasses", "()Ljava/util/Set;", "autoMigrationSpecs", "Landroidx/room/migration/Migration;", "createAutoMigrations", "(Ljava/util/Map;)Ljava/util/List;", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "configDao", "()Lcu/todus/android/db/dao/notifications/ConfigDao;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "()Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "()Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/ContactDao;", "contactDao", "()Lcu/todus/android/db/dao/toDus/ContactDao;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "()Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "attachmentDao", "()Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "userRoomJoinDao", "()Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "marketActionDao", "()Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "linkedDeviceDao", "()Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "()Lcu/todus/android/db/dao/toDus/ReactionDao;", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "stickerPackDao", "()Lcu/todus/android/db/dao/toDus/StickerPackDao;", "Lcu/todus/android/db/dao/toDus/StickerDao;", "stickerDao", "()Lcu/todus/android/db/dao/toDus/StickerDao;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "statusDao", "()Lcu/todus/android/db/dao/toDus/StatusDao;", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "rosterChangeDao", "()Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "Lcu/todus/android/db/dao/toDus/ChunkDao;", "chunkDao", "()Lcu/todus/android/db/dao/toDus/ChunkDao;", "Lua/n;", "_configDao", "Lua/n;", "_userDao", "_roomDao", "_contactDao", "_messageDao", "_attachmentDao", "_userRoomJoinDao", "_markerActionDao", "_linkedDeviceDao", "_reactionDao", "_stickerPackDao", "_stickerDao", "_statusDao", "_rosterChangeDao", "_chunkDao", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusDatabase_Impl extends ToDusDatabase {
    public static final int $stable = 8;
    private final ua.n _configDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.d
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._configDao$lambda$0(this.f20242c);
        }
    });
    private final ua.n _userDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.o
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._userDao$lambda$0(this.f20843c);
        }
    });
    private final ua.n _roomDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.p
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._roomDao$lambda$0(this.f20844c);
        }
    });
    private final ua.n _contactDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.q
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._contactDao$lambda$0(this.f20845c);
        }
    });
    private final ua.n _messageDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.r
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._messageDao$lambda$0(this.f20846c);
        }
    });
    private final ua.n _attachmentDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.e
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._attachmentDao$lambda$0(this.f20833c);
        }
    });
    private final ua.n _userRoomJoinDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.f
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._userRoomJoinDao$lambda$0(this.f20834c);
        }
    });
    private final ua.n _markerActionDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.g
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._markerActionDao$lambda$0(this.f20835c);
        }
    });
    private final ua.n _linkedDeviceDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.h
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._linkedDeviceDao$lambda$0(this.f20836c);
        }
    });
    private final ua.n _reactionDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.i
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._reactionDao$lambda$0(this.f20837c);
        }
    });
    private final ua.n _stickerPackDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.j
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._stickerPackDao$lambda$0(this.f20838c);
        }
    });
    private final ua.n _stickerDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.k
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._stickerDao$lambda$0(this.f20839c);
        }
    });
    private final ua.n _statusDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.l
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._statusDao$lambda$0(this.f20840c);
        }
    });
    private final ua.n _rosterChangeDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.m
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._rosterChangeDao$lambda$0(this.f20841c);
        }
    });
    private final ua.n _chunkDao = ua.o.a(new lb.a() { // from class: cu.todus.android.db.n
        @Override // lb.a
        public final Object invoke() {
            return ToDusDatabase_Impl._chunkDao$lambda$0(this.f20842c);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentDao_Impl _attachmentDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new AttachmentDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChunkDao_Impl _chunkDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new ChunkDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfigDao_Impl _configDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new ConfigDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactDao_Impl _contactDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new ContactDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedDeviceDao_Impl _linkedDeviceDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new LinkedDeviceDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MarkerActionDao_Impl _markerActionDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new MarkerActionDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageDao_Impl _messageDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new MessageDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactionDao_Impl _reactionDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new ReactionDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomDao_Impl _roomDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new RoomDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RosterChangeDao_Impl _rosterChangeDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new RosterChangeDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusDao_Impl _statusDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new StatusDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerDao_Impl _stickerDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new StickerDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerPackDao_Impl _stickerPackDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new StickerPackDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserDao_Impl _userDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new UserDao_Impl(toDusDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserRoomJoinDao_Impl _userRoomJoinDao$lambda$0(ToDusDatabase_Impl toDusDatabase_Impl) {
        return new UserRoomJoinDao_Impl(toDusDatabase_Impl);
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public AttachmentDao attachmentDao() {
        return (AttachmentDao) this._attachmentDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public ChunkDao chunkDao() {
        return (ChunkDao) this._chunkDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(true, "user", Room.TABLE_NAME, UserRoomJoin.TABLE_NAME, Attachment.TABLE_NAME, Message.TABLE_NAME, "marker", "Contact", "linked_device", Config.TABLE_NAME, "reaction", StickerPack.TABLE_NAME, "sticker", "status", "roster_change", "message_chunks");
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public ConfigDao configDao() {
        return (ConfigDao) this._configDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public ContactDao contactDao() {
        return (ContactDao) this._contactDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<sb.d, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        y.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "user", Room.TABLE_NAME, UserRoomJoin.TABLE_NAME, Attachment.TABLE_NAME, Message.TABLE_NAME, "marker", "Contact", "linked_device", Config.TABLE_NAME, "reaction", StickerPack.TABLE_NAME, "sticker", "status", "roster_change", "message_chunks");
    }

    @Override // androidx.room.RoomDatabase
    public Set<sb.d> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<sb.d, List<sb.d>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(z0.b(ConfigDao.class), ConfigDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(UserDao.class), UserDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(RoomDao.class), RoomDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(ContactDao.class), ContactDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(MessageDao.class), MessageDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(AttachmentDao.class), AttachmentDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(UserRoomJoinDao.class), UserRoomJoinDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(MarkerActionDao.class), MarkerActionDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(LinkedDeviceDao.class), LinkedDeviceDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(ReactionDao.class), ReactionDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(StickerPackDao.class), StickerPackDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(StickerDao.class), StickerDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(StatusDao.class), StatusDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(RosterChangeDao.class), RosterChangeDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(z0.b(ChunkDao.class), ChunkDao_Impl.INSTANCE.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public LinkedDeviceDao linkedDeviceDao() {
        return (LinkedDeviceDao) this._linkedDeviceDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public MarkerActionDao marketActionDao() {
        return (MarkerActionDao) this._markerActionDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public MessageDao messageDao() {
        return (MessageDao) this._messageDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public ReactionDao reactionDao() {
        return (ReactionDao) this._reactionDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public RoomDao roomDao() {
        return (RoomDao) this._roomDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public RosterChangeDao rosterChangeDao() {
        return (RosterChangeDao) this._rosterChangeDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public StatusDao statusDao() {
        return (StatusDao) this._statusDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public StickerDao stickerDao() {
        return (StickerDao) this._stickerDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public StickerPackDao stickerPackDao() {
        return (StickerPackDao) this._stickerPackDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public UserDao userDao() {
        return (UserDao) this._userDao.getValue();
    }

    @Override // cu.todus.android.db.ToDusDatabase
    public UserRoomJoinDao userRoomJoinDao() {
        return (UserRoomJoinDao) this._userRoomJoinDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: cu.todus.android.db.ToDusDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(11, "189ce46590e141168ad35a339a57f766", "cbd72432fff57e8215b5685c3b8424f2"); // pragma: allowlist secret
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) throws Exception {
                y.i(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `user` (`uid` TEXT NOT NULL, `username` TEXT NOT NULL, `alias` TEXT NOT NULL, `photoUrl` TEXT NOT NULL, `description` TEXT NOT NULL, `version` INTEGER NOT NULL, `photoThumbnail` TEXT NOT NULL, `official` INTEGER NOT NULL, `blocked` INTEGER NOT NULL, `toDusId` TEXT NOT NULL, PRIMARY KEY(`uid`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `rooms` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `type` INTEGER NOT NULL, `version` TEXT NOT NULL, `subject` TEXT NOT NULL, `config` TEXT NOT NULL, `lastUpdate` INTEGER NOT NULL, `unreadMessages` INTEGER NOT NULL, `msgId` TEXT NOT NULL, `pined` INTEGER NOT NULL, `secret` INTEGER NOT NULL, `isMuted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_rooms_id` ON `rooms` (`id`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `rooms_pined_lastUpdate_index` ON `rooms` (`pined`, `lastUpdate`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `user_room_join` (`userId` TEXT NOT NULL, `roomId` TEXT NOT NULL, `affiliation` TEXT NOT NULL, PRIMARY KEY(`userId`, `roomId`), FOREIGN KEY(`roomId`) REFERENCES `rooms`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_user_room_join_roomId` ON `user_room_join` (`roomId`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `attachments` (`id` TEXT NOT NULL, `msg` TEXT NOT NULL, `content` TEXT NOT NULL, `state` INTEGER NOT NULL, `type` INTEGER NOT NULL, `persistent` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`msg`) REFERENCES `messages`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_attachments_msg` ON `attachments` (`msg`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `messages` (`id` TEXT NOT NULL, `roomId` TEXT NOT NULL, `userSender` TEXT NOT NULL, `content` TEXT NOT NULL, `createAt` INTEGER NOT NULL, `state` INTEGER NOT NULL, `payload` TEXT, `messageEntities` TEXT NOT NULL, `publId` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`roomId`) REFERENCES `rooms`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_messages_id` ON `messages` (`id`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_messages_roomId` ON `messages` (`roomId`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `messages_createAt_index` ON `messages` (`createAt`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `marker` (`uid` TEXT NOT NULL, `msg` TEXT NOT NULL, `room` TEXT NOT NULL, `marker` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`msg`) REFERENCES `messages`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_marker_msg` ON `marker` (`msg`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `Contact` (`phone` TEXT NOT NULL, `uid` TEXT NOT NULL, `fName` TEXT NOT NULL, `phoneType` TEXT NOT NULL, `photoUri` TEXT NOT NULL, `state` TEXT, PRIMARY KEY(`phone`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `linked_device` (`session_id` TEXT NOT NULL, `device` TEXT NOT NULL, `url` TEXT NOT NULL, `last_time` INTEGER NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`session_id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `heritage` (`tag` TEXT NOT NULL, `alert` INTEGER NOT NULL, `sound` TEXT NOT NULL, `priority` INTEGER NOT NULL, `color` INTEGER NOT NULL, PRIMARY KEY(`tag`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `reaction` (`id` TEXT NOT NULL, `entity` TEXT NOT NULL, `userId` TEXT NOT NULL, `roomId` TEXT NOT NULL, `reactionContent` TEXT NOT NULL, `reactionState` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `stickerPack` (`name` TEXT NOT NULL, `title` TEXT NOT NULL, `thumb` TEXT NOT NULL, `createAt` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `sticker` (`id` TEXT NOT NULL, `packName` TEXT NOT NULL, `name` TEXT NOT NULL, `folder` TEXT NOT NULL, `favorite` INTEGER NOT NULL, `lastUse` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`packName`) REFERENCES `stickerPack`(`name`) ON UPDATE CASCADE ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `status` (`id` TEXT NOT NULL, `creatorId` TEXT NOT NULL, `repliedId` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `isPublic` INTEGER NOT NULL, `isDelete` INTEGER NOT NULL, `canRespond` INTEGER NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, `seen` INTEGER NOT NULL, `closed` INTEGER NOT NULL, `messageEntities` TEXT NOT NULL, `uploadState` INTEGER NOT NULL, `location` TEXT NOT NULL, `viewCount` INTEGER NOT NULL, `interactCount` INTEGER NOT NULL, `shareCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `roster_change` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `phone` TEXT NOT NULL, `changeType` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `previousName` TEXT, `currentName` TEXT, `synced` INTEGER NOT NULL, `targetVersion` INTEGER)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `message_chunks` (`originalMsgId` TEXT NOT NULL, `chunkIndex` INTEGER NOT NULL, `textContent` TEXT NOT NULL, PRIMARY KEY(`originalMsgId`, `chunkIndex`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '189ce46590e141168ad35a339a57f766')"); // pragma: allowlist secret
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) throws Exception {
                y.i(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `user`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `rooms`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `user_room_join`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `attachments`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `messages`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `marker`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `Contact`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `linked_device`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `heritage`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `reaction`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `stickerPack`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `sticker`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `status`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `roster_change`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `message_chunks`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                y.i(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) throws Exception {
                y.i(connection, "connection");
                SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
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
                linkedHashMap.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, 1));
                linkedHashMap.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, 1));
                linkedHashMap.put(User.COLUMN_ALIAS, new TableInfo.Column(User.COLUMN_ALIAS, "TEXT", true, 0, null, 1));
                linkedHashMap.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, 1));
                linkedHashMap.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                linkedHashMap.put("version", new TableInfo.Column("version", "INTEGER", true, 0, null, 1));
                linkedHashMap.put(User.COLUMN_PHOTO_THUMBNAIL, new TableInfo.Column(User.COLUMN_PHOTO_THUMBNAIL, "TEXT", true, 0, null, 1));
                linkedHashMap.put("official", new TableInfo.Column("official", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("blocked", new TableInfo.Column("blocked", "INTEGER", true, 0, null, 1));
                linkedHashMap.put(User.COLUMN_TODUS_ID, new TableInfo.Column(User.COLUMN_TODUS_ID, "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("user", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo.Companion companion = TableInfo.INSTANCE;
                TableInfo tableInfo2 = companion.read(connection, "user");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "user(cu.todus.android.data.db.entity.toDus.User).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("version", new TableInfo.Column("version", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("subject", new TableInfo.Column("subject", "TEXT", true, 0, null, 1));
                linkedHashMap2.put(Room.CONFIG_CONFIG, new TableInfo.Column(Room.CONFIG_CONFIG, "TEXT", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_LAST_UPDATE, new TableInfo.Column(Room.COLUMN_LAST_UPDATE, "INTEGER", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_UNREAD, new TableInfo.Column(Room.COLUMN_UNREAD, "INTEGER", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_LAST_MSG, new TableInfo.Column(Room.COLUMN_LAST_MSG, "TEXT", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_PINED, new TableInfo.Column(Room.COLUMN_PINED, "INTEGER", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_SECRET, new TableInfo.Column(Room.COLUMN_SECRET, "INTEGER", true, 0, null, 1));
                linkedHashMap2.put(Room.COLUMN_MUTED, new TableInfo.Column(Room.COLUMN_MUTED, "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_rooms_id", false, v.e("id"), v.e("ASC")));
                linkedHashSet2.add(new TableInfo.Index("rooms_pined_lastUpdate_index", false, w.q(Room.COLUMN_PINED, Room.COLUMN_LAST_UPDATE), w.q("ASC", "ASC")));
                TableInfo tableInfo3 = new TableInfo(Room.TABLE_NAME, linkedHashMap2, linkedHashSet, linkedHashSet2);
                TableInfo tableInfo4 = companion.read(connection, Room.TABLE_NAME);
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "rooms(cu.todus.android.data.db.entity.toDus.Room).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                linkedHashMap3.put("roomId", new TableInfo.Column("roomId", "TEXT", true, 2, null, 1));
                linkedHashMap3.put(UserRoomJoin.COLUMN_AFFILIATION, new TableInfo.Column(UserRoomJoin.COLUMN_AFFILIATION, "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                linkedHashSet3.add(new TableInfo.ForeignKey(Room.TABLE_NAME, "CASCADE", "NO ACTION", v.e("roomId"), v.e("id")));
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_user_room_join_roomId", false, v.e("roomId"), v.e("ASC")));
                TableInfo tableInfo5 = new TableInfo(UserRoomJoin.TABLE_NAME, linkedHashMap3, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfo6 = companion.read(connection, UserRoomJoin.TABLE_NAME);
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "user_room_join(cu.todus.android.data.db.entity.toDus.UserRoomJoin).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap4.put("msg", new TableInfo.Column("msg", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put(Attachment.COLUMN_PERSISTENT, new TableInfo.Column(Attachment.COLUMN_PERSISTENT, "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                linkedHashSet5.add(new TableInfo.ForeignKey(Message.TABLE_NAME, "CASCADE", "CASCADE", v.e("msg"), v.e("id")));
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_attachments_msg", false, v.e("msg"), v.e("ASC")));
                TableInfo tableInfo7 = new TableInfo(Attachment.TABLE_NAME, linkedHashMap4, linkedHashSet5, linkedHashSet6);
                TableInfo tableInfo8 = companion.read(connection, Attachment.TABLE_NAME);
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "attachments(cu.todus.android.data.db.entity.toDus.Attachment).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap5.put("roomId", new TableInfo.Column("roomId", "TEXT", true, 0, null, 1));
                linkedHashMap5.put(Message.COLUMN_USER_SENDER, new TableInfo.Column(Message.COLUMN_USER_SENDER, "TEXT", true, 0, null, 1));
                linkedHashMap5.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                linkedHashMap5.put("createAt", new TableInfo.Column("createAt", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put(Message.COLUMN_PAYLOAD, new TableInfo.Column(Message.COLUMN_PAYLOAD, "TEXT", false, 0, null, 1));
                linkedHashMap5.put(Message.COLUMN_MESSAGE_ENTITIES, new TableInfo.Column(Message.COLUMN_MESSAGE_ENTITIES, "TEXT", true, 0, null, 1));
                linkedHashMap5.put(Message.COLUMN_MESSAGE_PUBL_ID, new TableInfo.Column(Message.COLUMN_MESSAGE_PUBL_ID, "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                linkedHashSet7.add(new TableInfo.ForeignKey(Room.TABLE_NAME, "CASCADE", "CASCADE", v.e("roomId"), v.e("id")));
                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                linkedHashSet8.add(new TableInfo.Index("index_messages_id", false, v.e("id"), v.e("ASC")));
                linkedHashSet8.add(new TableInfo.Index("index_messages_roomId", false, v.e("roomId"), v.e("ASC")));
                linkedHashSet8.add(new TableInfo.Index("messages_createAt_index", false, v.e("createAt"), v.e("ASC")));
                TableInfo tableInfo9 = new TableInfo(Message.TABLE_NAME, linkedHashMap5, linkedHashSet7, linkedHashSet8);
                TableInfo tableInfo10 = companion.read(connection, Message.TABLE_NAME);
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "messages(cu.todus.android.data.db.entity.toDus.Message).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, 1));
                linkedHashMap6.put("msg", new TableInfo.Column("msg", "TEXT", true, 0, null, 1));
                linkedHashMap6.put(MarkerAction.COLUMN_ROOM, new TableInfo.Column(MarkerAction.COLUMN_ROOM, "TEXT", true, 0, null, 1));
                linkedHashMap6.put("marker", new TableInfo.Column("marker", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                linkedHashSet9.add(new TableInfo.ForeignKey(Message.TABLE_NAME, "CASCADE", "CASCADE", v.e("msg"), v.e("id")));
                LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                linkedHashSet10.add(new TableInfo.Index("index_marker_msg", false, v.e("msg"), v.e("ASC")));
                TableInfo tableInfo11 = new TableInfo("marker", linkedHashMap6, linkedHashSet9, linkedHashSet10);
                TableInfo tableInfo12 = companion.read(connection, "marker");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenDelegate.ValidationResult(false, "marker(cu.todus.android.data.db.entity.toDus.MarkerAction).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("phone", new TableInfo.Column("phone", "TEXT", true, 1, null, 1));
                linkedHashMap7.put("uid", new TableInfo.Column("uid", "TEXT", true, 0, null, 1));
                linkedHashMap7.put(Contact.COLUMN_FULL_NAME, new TableInfo.Column(Contact.COLUMN_FULL_NAME, "TEXT", true, 0, null, 1));
                linkedHashMap7.put(Contact.COLUMN_PHONE_TYPE, new TableInfo.Column(Contact.COLUMN_PHONE_TYPE, "TEXT", true, 0, null, 1));
                linkedHashMap7.put(Contact.COLUMN_PHOTO_URI, new TableInfo.Column(Contact.COLUMN_PHOTO_URI, "TEXT", true, 0, null, 1));
                linkedHashMap7.put("state", new TableInfo.Column("state", "TEXT", false, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo("Contact", linkedHashMap7, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo14 = companion.read(connection, "Contact");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenDelegate.ValidationResult(false, "Contact(cu.todus.android.data.db.entity.toDus.Contact).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                linkedHashMap8.put(LinkedDevice.COLUMN_ID, new TableInfo.Column(LinkedDevice.COLUMN_ID, "TEXT", true, 1, null, 1));
                linkedHashMap8.put(LinkedDevice.COLUMN_DEVICE, new TableInfo.Column(LinkedDevice.COLUMN_DEVICE, "TEXT", true, 0, null, 1));
                linkedHashMap8.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                linkedHashMap8.put(LinkedDevice.COLUMN_LAST_TIME, new TableInfo.Column(LinkedDevice.COLUMN_LAST_TIME, "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("linked_device", linkedHashMap8, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo16 = companion.read(connection, "linked_device");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenDelegate.ValidationResult(false, "linked_device(cu.todus.android.data.db.entity.toDus.LinkedDevice).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                linkedHashMap9.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                linkedHashMap9.put("alert", new TableInfo.Column("alert", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("sound", new TableInfo.Column("sound", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("color", new TableInfo.Column("color", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo17 = new TableInfo(Config.TABLE_NAME, linkedHashMap9, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo18 = companion.read(connection, Config.TABLE_NAME);
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenDelegate.ValidationResult(false, "heritage(cu.todus.android.data.db.entity.configs.Config).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                linkedHashMap10.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap10.put(Reaction.COLUMN_ENTITY, new TableInfo.Column(Reaction.COLUMN_ENTITY, "TEXT", true, 0, null, 1));
                linkedHashMap10.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, 1));
                linkedHashMap10.put("roomId", new TableInfo.Column("roomId", "TEXT", true, 0, null, 1));
                linkedHashMap10.put("reactionContent", new TableInfo.Column("reactionContent", "TEXT", true, 0, null, 1));
                linkedHashMap10.put(Reaction.COLUMN_REACTION_STATE, new TableInfo.Column(Reaction.COLUMN_REACTION_STATE, "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo19 = new TableInfo("reaction", linkedHashMap10, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo20 = companion.read(connection, "reaction");
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenDelegate.ValidationResult(false, "reaction(cu.todus.android.data.db.entity.toDus.Reaction).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20);
                }
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                linkedHashMap11.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                linkedHashMap11.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap11.put("thumb", new TableInfo.Column("thumb", "TEXT", true, 0, null, 1));
                linkedHashMap11.put("createAt", new TableInfo.Column("createAt", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo21 = new TableInfo(StickerPack.TABLE_NAME, linkedHashMap11, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo22 = companion.read(connection, StickerPack.TABLE_NAME);
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenDelegate.ValidationResult(false, "stickerPack(cu.todus.android.data.db.entity.toDus.StickerPack).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22);
                }
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                linkedHashMap12.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap12.put(Sticker.COLUMN_PACK_NAME, new TableInfo.Column(Sticker.COLUMN_PACK_NAME, "TEXT", true, 0, null, 1));
                linkedHashMap12.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap12.put("folder", new TableInfo.Column("folder", "TEXT", true, 0, null, 1));
                linkedHashMap12.put(Sticker.COLUMN_FAVORITE, new TableInfo.Column(Sticker.COLUMN_FAVORITE, "INTEGER", true, 0, null, 1));
                linkedHashMap12.put(Sticker.COLUMN_LAST_USE, new TableInfo.Column(Sticker.COLUMN_LAST_USE, "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                linkedHashSet11.add(new TableInfo.ForeignKey(StickerPack.TABLE_NAME, "CASCADE", "CASCADE", v.e(Sticker.COLUMN_PACK_NAME), v.e("name")));
                TableInfo tableInfo23 = new TableInfo("sticker", linkedHashMap12, linkedHashSet11, new LinkedHashSet());
                TableInfo tableInfo24 = companion.read(connection, "sticker");
                if (!tableInfo23.equals(tableInfo24)) {
                    return new RoomOpenDelegate.ValidationResult(false, "sticker(cu.todus.android.data.db.entity.toDus.Sticker).\n Expected:\n" + tableInfo23 + "\n Found:\n" + tableInfo24);
                }
                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                linkedHashMap13.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap13.put(Status.COLUMN_CREATOR_ID, new TableInfo.Column(Status.COLUMN_CREATOR_ID, "TEXT", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_REPLIED_ID, new TableInfo.Column(Status.COLUMN_REPLIED_ID, "TEXT", true, 0, null, 1));
                linkedHashMap13.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("isPublic", new TableInfo.Column("isPublic", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_IS_DELETED, new TableInfo.Column(Status.COLUMN_IS_DELETED, "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("canRespond", new TableInfo.Column("canRespond", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_SEEN, new TableInfo.Column(Status.COLUMN_SEEN, "INTEGER", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_CLOSED, new TableInfo.Column(Status.COLUMN_CLOSED, "INTEGER", true, 0, null, 1));
                linkedHashMap13.put(Message.COLUMN_MESSAGE_ENTITIES, new TableInfo.Column(Message.COLUMN_MESSAGE_ENTITIES, "TEXT", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_UPLOAD_STATE, new TableInfo.Column(Status.COLUMN_UPLOAD_STATE, "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, 1));
                linkedHashMap13.put(Status.COLUMN_VIEW_COUNT, new TableInfo.Column(Status.COLUMN_VIEW_COUNT, "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("interactCount", new TableInfo.Column("interactCount", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("shareCount", new TableInfo.Column("shareCount", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo25 = new TableInfo("status", linkedHashMap13, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo26 = companion.read(connection, "status");
                if (!tableInfo25.equals(tableInfo26)) {
                    return new RoomOpenDelegate.ValidationResult(false, "status(cu.todus.android.data.db.entity.toDus.Status).\n Expected:\n" + tableInfo25 + "\n Found:\n" + tableInfo26);
                }
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                linkedHashMap14.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap14.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, 1));
                linkedHashMap14.put("changeType", new TableInfo.Column("changeType", "TEXT", true, 0, null, 1));
                linkedHashMap14.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("previousName", new TableInfo.Column("previousName", "TEXT", false, 0, null, 1));
                linkedHashMap14.put("currentName", new TableInfo.Column("currentName", "TEXT", false, 0, null, 1));
                linkedHashMap14.put("synced", new TableInfo.Column("synced", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("targetVersion", new TableInfo.Column("targetVersion", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo27 = new TableInfo("roster_change", linkedHashMap14, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo28 = companion.read(connection, "roster_change");
                if (!tableInfo27.equals(tableInfo28)) {
                    return new RoomOpenDelegate.ValidationResult(false, "roster_change(cu.todus.android.data.db.entity.toDus.RosterChange).\n Expected:\n" + tableInfo27 + "\n Found:\n" + tableInfo28);
                }
                LinkedHashMap linkedHashMap15 = new LinkedHashMap();
                linkedHashMap15.put("originalMsgId", new TableInfo.Column("originalMsgId", "TEXT", true, 1, null, 1));
                linkedHashMap15.put("chunkIndex", new TableInfo.Column("chunkIndex", "INTEGER", true, 2, null, 1));
                linkedHashMap15.put("textContent", new TableInfo.Column("textContent", "TEXT", true, 0, null, 1));
                TableInfo tableInfo29 = new TableInfo("message_chunks", linkedHashMap15, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo30 = companion.read(connection, "message_chunks");
                if (tableInfo29.equals(tableInfo30)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "message_chunks(cu.todus.android.data.db.entity.toDus.ChunkEntity).\n Expected:\n" + tableInfo29 + "\n Found:\n" + tableInfo30);
            }
        };
    }
}
