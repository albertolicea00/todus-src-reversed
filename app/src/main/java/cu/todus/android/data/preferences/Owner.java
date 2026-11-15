package cu.todus.android.data.preferences;

import cu.todus.android.xmpp.XMPPUtils;
import java.util.Objects;

/**
 * Authenticated local account owner profile and credentials persisted in preferences.
 *
 * @obfuscated_class cu.todus.android.data.preferences.Owner
 */
public final class Owner {
    private final String uid;
    private final String alias;
    private final String photoUrl;
    private final int version;
    private final String info;
    private final String photoThumbnail;
    private final String username;
    private final String password;
    private final String token;
    private final long expire;
    private final String toDusId;
    private final int countryCode;

    public Owner() {
        this("", "", "", 0, "", "", "", "", "", -1L, "", 53);
    }

    public Owner(
            String uid,
            String alias,
            String photoUrl,
            int version,
            String info,
            String photoThumbnail,
            String username,
            String password,
            String token,
            long expire,
            String toDusId,
            int countryCode) {
        this.uid = Objects.requireNonNull(uid, "uid");
        this.alias = Objects.requireNonNull(alias, "alias");
        this.photoUrl = Objects.requireNonNull(photoUrl, "photoUrl");
        this.version = version;
        this.info = Objects.requireNonNull(info, "info");
        this.photoThumbnail = Objects.requireNonNull(photoThumbnail, "photoThumbnail");
        this.username = Objects.requireNonNull(username, "username");
        this.password = Objects.requireNonNull(password, "password");
        this.token = Objects.requireNonNull(token, "token");
        this.expire = expire;
        this.toDusId = Objects.requireNonNull(toDusId, "toDusId");
        this.countryCode = countryCode;
    }

    public String getUid() {
        return this.uid;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public int getVersion() {
        return this.version;
    }

    public String getInfo() {
        return this.info;
    }

    public String getPhotoThumbnail() {
        return this.photoThumbnail;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getToken() {
        return this.token;
    }

    public long getExpire() {
        return this.expire;
    }

    public String getToDusId() {
        return this.toDusId;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public String getNameWithDomain() {
        return XMPPUtils.INSTANCE.fromUserNameToJID(this.username);
    }

    public Owner copy(
            String uid,
            String alias,
            String photoUrl,
            int version,
            String info,
            String photoThumbnail,
            String username,
            String password,
            String token,
            long expire,
            String toDusId,
            int countryCode) {
        return new Owner(
                Objects.requireNonNull(uid, "uid"),
                Objects.requireNonNull(alias, "alias"),
                Objects.requireNonNull(photoUrl, "photoUrl"),
                version,
                Objects.requireNonNull(info, "info"),
                Objects.requireNonNull(photoThumbnail, "photoThumbnail"),
                Objects.requireNonNull(username, "username"),
                Objects.requireNonNull(password, "password"),
                Objects.requireNonNull(token, "token"),
                expire,
                Objects.requireNonNull(toDusId, "toDusId"),
                countryCode
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Owner)) {
            return false;
        }
        Owner that = (Owner) other;
        return Objects.equals(this.uid, that.uid)
                && Objects.equals(this.alias, that.alias)
                && Objects.equals(this.photoUrl, that.photoUrl)
                && this.version == that.version
                && Objects.equals(this.info, that.info)
                && Objects.equals(this.photoThumbnail, that.photoThumbnail)
                && Objects.equals(this.username, that.username)
                && Objects.equals(this.password, that.password)
                && Objects.equals(this.token, that.token)
                && this.expire == that.expire
                && Objects.equals(this.toDusId, that.toDusId)
                && this.countryCode == that.countryCode;
    }

    @Override
    public int hashCode() {
        return (((((((((((((((((((((this.uid.hashCode() * 31)
                + this.alias.hashCode()) * 31)
                + this.photoUrl.hashCode()) * 31)
                + this.version) * 31)
                + this.info.hashCode()) * 31)
                + this.photoThumbnail.hashCode()) * 31)
                + this.username.hashCode()) * 31)
                + this.password.hashCode()) * 31)
                + this.token.hashCode()) * 31)
                + Long.hashCode(this.expire)) * 31)
                + this.toDusId.hashCode()) * 31)
                + this.countryCode;
    }

    @Override
    public String toString() {
        return "Owner(uid=" + this.uid
                + ", alias=" + this.alias
                + ", photoUrl=" + this.photoUrl
                + ", version=" + this.version
                + ", info=" + this.info
                + ", photoThumbnail=" + this.photoThumbnail
                + ", username=" + this.username
                + ", password=" + this.password
                + ", token=" + this.token
                + ", expire=" + this.expire
                + ", toDusId=" + this.toDusId
                + ", countryCode=" + this.countryCode + ")";
    }
}
