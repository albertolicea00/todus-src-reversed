package cu.todus.android.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
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
import cu.todus.android.data.db.entity.toDus.Room as ToDusRoom;
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

/**
 * Primary Room database ({@code toDus.db}, schema version 11) storing users,
 * rooms, messages, attachments, reactions, statuses, stickers, and linked devices.
 *
 * @obfuscated_class cu.todus.android.db.ToDusDatabase
 */
@Database(
        entities = {
                User.class,
                ToDusRoom.class,
                UserRoomJoin.class,
                Attachment.class,
                Message.class,
                MarkerAction.class,
                Contact.class,
                LinkedDevice.class,
                Config.class,
                Reaction.class,
                StickerPack.class,
                Sticker.class,
                Status.class,
                RosterChange.class,
                ChunkEntity.class
        },
        exportSchema = false,
        version = 11
)
@TypeConverters({ToDusTypeConverter.class, Data.class, JobTypeConverters.class})
public abstract class ToDusDatabase extends RoomDatabase {

    private static final String DB_NAME = "toDus.db";

    public static ToDusDatabase createInstance(Context context, String ownerId) {
        Migrations migrations = Migrations.INSTANCE;
        return Room.databaseBuilder(context, ToDusDatabase.class, DB_NAME)
                .fallbackToDestructiveMigrationOnDowngrade()
                .allowMainThreadQueries()
                .addMigrations(
                        migrations.getMIGRATION_2_3(),
                        migrations.getMIGRATION_3_4(),
                        migrations.getMIGRATION_4_5(),
                        migrations.getMIGRATION_5_6(),
                        migrations.getMIGRATION_6_7(),
                        migrations.getMIGRATION_7_8(),
                        migrations.getMIGRATION_8_9(),
                        migrations.getMIGRATION_9_10(),
                        migrations.getMIGRATION_10_11()
                )
                .build();
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
