package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

/**
 * Room entity representing a toDus user profile cached locally.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.User
 */
@Immutable
@Entity(tableName = User.TABLE_NAME)
public final class User {

    public static final String TABLE_NAME = "user";

    public static final String COLUMN_UID = "uid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_ALIAS = "alias";
    public static final String COLUMN_PHOTO_URL = "pictureUrl";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_VERSION = "version";
    public static final String COLUMN_PHOTO_THUMBNAIL = "photoThumbnail";
    public static final String COLUMN_OFFICIAL = "official";
    public static final String COLUMN_BLOCKED = "blocked";
    public static final String COLUMN_TODUS_ID = "toDusId";

    @PrimaryKey
    private final String uid;
    private final String username;
    private final String alias;
    private final String photoUrl;
    private final String description;
    private final int version;
    private final String photoThumbnail;
    private final int official;
    private final boolean blocked;
    private final String toDusId;

    public User() {
        this("", "", "", "", "", -1, "", 0, false, "");
    }

    public User(
            String uid,
            String username,
            String alias,
            String photoUrl,
            String description,
            int version,
            String photoThumbnail,
            int official,
            boolean blocked,
            String toDusId
    ) {
        this.uid = Objects.requireNonNull(uid, "uid");
        this.username = Objects.requireNonNull(username, "username");
        this.alias = Objects.requireNonNull(alias, "alias");
        this.photoUrl = Objects.requireNonNull(photoUrl, "photoUrl");
        this.description = Objects.requireNonNull(description, "description");
        this.version = version;
        this.photoThumbnail = Objects.requireNonNull(photoThumbnail, "photoThumbnail");
        this.official = official;
        this.blocked = blocked;
        this.toDusId = Objects.requireNonNull(toDusId, "toDusId");
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getAlias() {
        return alias;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getVersion() {
        return version;
    }

    public String getPhotoThumbnail() {
        return photoThumbnail;
    }

    public int getOfficial() {
        return official;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public String getToDusId() {
        return toDusId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        return version == that.version
                && official == that.official
                && blocked == that.blocked
                && Objects.equals(uid, that.uid)
                && Objects.equals(username, that.username)
                && Objects.equals(alias, that.alias)
                && Objects.equals(photoUrl, that.photoUrl)
                && Objects.equals(description, that.description)
                && Objects.equals(photoThumbnail, that.photoThumbnail)
                && Objects.equals(toDusId, that.toDusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uid,
                username,
                alias,
                photoUrl,
                description,
                version,
                photoThumbnail,
                official,
                blocked,
                toDusId
        );
    }

    @Override
    public String toString() {
        return "User(uid=" + uid
                + ", username=" + username
                + ", alias=" + alias
                + ", photoUrl=" + photoUrl
                + ", description=" + description
                + ", version=" + version
                + ", photoThumbnail=" + photoThumbnail
                + ", official=" + official
                + ", blocked=" + blocked
                + ", toDusId=" + toDusId + ")";
    }
}
