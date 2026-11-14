package cu.todus.android.db;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcu/todus/android/db/Migrations;", "", "<init>", "()V", "MIGRATION_2_3", "Landroidx/room/migration/Migration;", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "MIGRATION_10_11", "getMIGRATION_10_11", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Migrations {
    public static final Migrations INSTANCE = new Migrations();
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS status (id TEXT NOT NULL, creatorId TEXT NOT NULL, repliedId TEXT NOT NULL, createdAt INTEGER NOT NULL, isPublic INTEGER NOT NULL, isDelete INTEGER NOT NULL, type TEXT NOT NULL, content TEXT NOT NULL, uploadState INT NOT NULL,PRIMARY KEY(id))");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS reaction_tmp(id TEXT NOT NULL, entity TEXT NOT NULL, userId TEXT NOT NULL, roomId TEXT NOT NULL, reactionContent TEXT NOT NULL, reactionState INT NOT NULL, createdAt INTEGER NOT NULL,PRIMARY KEY(id))");
            db2.execSQL("INSERT INTO reaction_tmp(id, entity, userId, roomId, reactionContent, reactionState, createdAt) SELECT id, msg, userId, roomId, reactionContent, reactionState, createdAt FROM reaction;");
            db2.execSQL("DROP TABLE reaction;");
            db2.execSQL("ALTER TABLE reaction_tmp RENAME TO reaction;");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("ALTER TABLE status ADD seen INTEGER NOT NULL DEFAULT 0 ;");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("ALTER TABLE marker ADD createdAt INTEGER NOT NULL DEFAULT 0 ;");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("ALTER TABLE status ADD messageEntities TEXT NOT NULL DEFAULT '[]' ;");
            db2.execSQL("ALTER TABLE status ADD location TEXT NOT NULL DEFAULT '' ;");
            db2.execSQL("ALTER TABLE status ADD canRespond INTEGER NOT NULL DEFAULT 0 ;");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("ALTER TABLE status ADD viewCount INT NOT NULL DEFAULT 0 ;");
            db2.execSQL("ALTER TABLE status ADD interactCount INT NOT NULL DEFAULT 0 ;");
            db2.execSQL("ALTER TABLE status ADD shareCount INT NOT NULL DEFAULT 0 ;");
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("ALTER TABLE status ADD closed INTEGER NOT NULL DEFAULT 0 ;");
            db2.execSQL("UPDATE status set closed = seen;");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("\n            CREATE TABLE IF NOT EXISTS roster_change (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                phone TEXT NOT NULL,\n                changeType TEXT NOT NULL,\n                timestamp INTEGER NOT NULL,\n                previousName TEXT,\n                currentName TEXT,\n                synced INTEGER NOT NULL,\n                targetVersion INTEGER\n            )\n        ");
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: cu.todus.android.db.Migrations$MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            y.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS message_chunks (\n    originalMsgId TEXT NOT NULL,\n    chunkIndex INTEGER NOT NULL,\n    textContent TEXT NOT NULL,\n    PRIMARY KEY(originalMsgId, chunkIndex)\n)");
        }
    };
    public static final int $stable = 8;

    private Migrations() {
    }

    public final Migration getMIGRATION_10_11() {
        return MIGRATION_10_11;
    }

    public final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }

    public final Migration getMIGRATION_8_9() {
        return MIGRATION_8_9;
    }

    public final Migration getMIGRATION_9_10() {
        return MIGRATION_9_10;
    }
}
