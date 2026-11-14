package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = "user")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0014\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\tHÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006."}, d2 = {"Lcu/todus/android/data/db/entity/toDus/User;", "", "uid", "", "username", User.COLUMN_ALIAS, "photoUrl", "description", "version", "", User.COLUMN_PHOTO_THUMBNAIL, "official", "blocked", "", User.COLUMN_TODUS_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZLjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getUsername", "getAlias", "getPhotoUrl", "getDescription", "getVersion", "()I", "getPhotoThumbnail", "getOfficial", "getBlocked", "()Z", "getToDusId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class User {
    public static final int $stable = 0;
    public static final String COLUMN_ALIAS = "alias";
    public static final String COLUMN_BLOCKED = "blocked";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_OFFICIAL = "official";
    public static final String COLUMN_PHOTO_THUMBNAIL = "photoThumbnail";
    public static final String COLUMN_PHOTO_URL = "pictureUrl";
    public static final String COLUMN_TODUS_ID = "toDusId";
    public static final String COLUMN_UID = "uid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_VERSION = "version";
    public static final String TABLE_NAME = "user";
    private final String alias;
    private final boolean blocked;
    private final String description;
    private final int official;
    private final String photoThumbnail;
    private final String photoUrl;
    private final String toDusId;

    @PrimaryKey
    private final String uid;
    private final String username;
    private final int version;

    public User() {
        this(null, null, null, null, null, 0, null, 0, false, null, 1023, null);
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, String str5, int i10, String str6, int i11, boolean z10, String str7, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = user.uid;
        }
        if ((i12 & 2) != 0) {
            str2 = user.username;
        }
        if ((i12 & 4) != 0) {
            str3 = user.alias;
        }
        if ((i12 & 8) != 0) {
            str4 = user.photoUrl;
        }
        if ((i12 & 16) != 0) {
            str5 = user.description;
        }
        if ((i12 & 32) != 0) {
            i10 = user.version;
        }
        if ((i12 & 64) != 0) {
            str6 = user.photoThumbnail;
        }
        if ((i12 & 128) != 0) {
            i11 = user.official;
        }
        if ((i12 & 256) != 0) {
            z10 = user.blocked;
        }
        if ((i12 & 512) != 0) {
            str7 = user.toDusId;
        }
        boolean z11 = z10;
        String str8 = str7;
        String str9 = str6;
        int i13 = i11;
        String str10 = str5;
        int i14 = i10;
        return user.copy(str, str2, str3, str4, str10, i14, str9, i13, z11, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlias() {
        return this.alias;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPhotoThumbnail() {
        return this.photoThumbnail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getOfficial() {
        return this.official;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getBlocked() {
        return this.blocked;
    }

    public final User copy(String uid, String username, String alias, String photoUrl, String description, int version, String photoThumbnail, int official, boolean blocked, String toDusId) {
        y.i(uid, "uid");
        y.i(username, "username");
        y.i(alias, "alias");
        y.i(photoUrl, "photoUrl");
        y.i(description, "description");
        y.i(photoThumbnail, "photoThumbnail");
        y.i(toDusId, "toDusId");
        return new User(uid, username, alias, photoUrl, description, version, photoThumbnail, official, blocked, toDusId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return y.d(this.uid, user.uid) && y.d(this.username, user.username) && y.d(this.alias, user.alias) && y.d(this.photoUrl, user.photoUrl) && y.d(this.description, user.description) && this.version == user.version && y.d(this.photoThumbnail, user.photoThumbnail) && this.official == user.official && this.blocked == user.blocked && y.d(this.toDusId, user.toDusId);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getOfficial() {
        return this.official;
    }

    public final String getPhotoThumbnail() {
        return this.photoThumbnail;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((this.uid.hashCode() * 31) + this.username.hashCode()) * 31) + this.alias.hashCode()) * 31) + this.photoUrl.hashCode()) * 31) + this.description.hashCode()) * 31) + this.version) * 31) + this.photoThumbnail.hashCode()) * 31) + this.official) * 31) + r.a(this.blocked)) * 31) + this.toDusId.hashCode();
    }

    public String toString() {
        return "User(uid=" + this.uid + ", username=" + this.username + ", alias=" + this.alias + ", photoUrl=" + this.photoUrl + ", description=" + this.description + ", version=" + this.version + ", photoThumbnail=" + this.photoThumbnail + ", official=" + this.official + ", blocked=" + this.blocked + ", toDusId=" + this.toDusId + ")";
    }

    public User(String uid, String username, String alias, String photoUrl, String description, int i10, String photoThumbnail, int i11, boolean z10, String toDusId) {
        y.i(uid, "uid");
        y.i(username, "username");
        y.i(alias, "alias");
        y.i(photoUrl, "photoUrl");
        y.i(description, "description");
        y.i(photoThumbnail, "photoThumbnail");
        y.i(toDusId, "toDusId");
        this.uid = uid;
        this.username = username;
        this.alias = alias;
        this.photoUrl = photoUrl;
        this.description = description;
        this.version = i10;
        this.photoThumbnail = photoThumbnail;
        this.official = i11;
        this.blocked = z10;
        this.toDusId = toDusId;
    }

    public /* synthetic */ User(String str, String str2, String str3, String str4, String str5, int i10, String str6, int i11, boolean z10, String str7, int i12, p pVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? "" : str4, (i12 & 16) != 0 ? "" : str5, (i12 & 32) != 0 ? -1 : i10, (i12 & 64) != 0 ? "" : str6, (i12 & 128) != 0 ? 0 : i11, (i12 & 256) != 0 ? false : z10, (i12 & 512) != 0 ? "" : str7);
    }
}
