package cu.todus.android.data.preferences;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.xmpp.XMPPUtils;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\"\u001a\u00020\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0007HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018¨\u00065"}, d2 = {"Lcu/todus/android/data/preferences/Owner;", "", "uid", "", User.COLUMN_ALIAS, "photoUrl", "version", "", "info", User.COLUMN_PHOTO_THUMBNAIL, "username", HintConstants.AUTOFILL_HINT_PASSWORD, "token", "expire", "", User.COLUMN_TODUS_ID, "countryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "getUid", "()Ljava/lang/String;", "getAlias", "getPhotoUrl", "getVersion", "()I", "getInfo", "getPhotoThumbnail", "getUsername", "getPassword", "getToken", "getExpire", "()J", "getToDusId", "getCountryCode", "getNameWithDomain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Owner {
    public static final int $stable = 0;
    private final String alias;
    private final int countryCode;
    private final long expire;
    private final String info;
    private final String password;
    private final String photoThumbnail;
    private final String photoUrl;
    private final String toDusId;
    private final String token;
    private final String uid;
    private final String username;
    private final int version;

    public Owner() {
        this(null, null, null, 0, null, null, null, null, null, 0L, null, 0, 4095, null);
    }

    public static /* synthetic */ Owner copy$default(Owner owner, String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, long j10, String str9, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = owner.uid;
        }
        return owner.copy(str, (i12 & 2) != 0 ? owner.alias : str2, (i12 & 4) != 0 ? owner.photoUrl : str3, (i12 & 8) != 0 ? owner.version : i10, (i12 & 16) != 0 ? owner.info : str4, (i12 & 32) != 0 ? owner.photoThumbnail : str5, (i12 & 64) != 0 ? owner.username : str6, (i12 & 128) != 0 ? owner.password : str7, (i12 & 256) != 0 ? owner.token : str8, (i12 & 512) != 0 ? owner.expire : j10, (i12 & 1024) != 0 ? owner.toDusId : str9, (i12 & 2048) != 0 ? owner.countryCode : i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getExpire() {
        return this.expire;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlias() {
        return this.alias;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPhotoThumbnail() {
        return this.photoThumbnail;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final Owner copy(String uid, String alias, String photoUrl, int version, String info, String photoThumbnail, String username, String password, String token, long expire, String toDusId, int countryCode) {
        y.i(uid, "uid");
        y.i(alias, "alias");
        y.i(photoUrl, "photoUrl");
        y.i(info, "info");
        y.i(photoThumbnail, "photoThumbnail");
        y.i(username, "username");
        y.i(password, "password");
        y.i(token, "token");
        y.i(toDusId, "toDusId");
        return new Owner(uid, alias, photoUrl, version, info, photoThumbnail, username, password, token, expire, toDusId, countryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) other;
        return y.d(this.uid, owner.uid) && y.d(this.alias, owner.alias) && y.d(this.photoUrl, owner.photoUrl) && this.version == owner.version && y.d(this.info, owner.info) && y.d(this.photoThumbnail, owner.photoThumbnail) && y.d(this.username, owner.username) && y.d(this.password, owner.password) && y.d(this.token, owner.token) && this.expire == owner.expire && y.d(this.toDusId, owner.toDusId) && this.countryCode == owner.countryCode;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final long getExpire() {
        return this.expire;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getNameWithDomain() {
        return XMPPUtils.INSTANCE.fromUserNameToJID(this.username);
    }

    public final String getPassword() {
        return this.password;
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

    public final String getToken() {
        return this.token;
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
        return (((((((((((((((((((((this.uid.hashCode() * 31) + this.alias.hashCode()) * 31) + this.photoUrl.hashCode()) * 31) + this.version) * 31) + this.info.hashCode()) * 31) + this.photoThumbnail.hashCode()) * 31) + this.username.hashCode()) * 31) + this.password.hashCode()) * 31) + this.token.hashCode()) * 31) + l.a(this.expire)) * 31) + this.toDusId.hashCode()) * 31) + this.countryCode;
    }

    public String toString() {
        return "Owner(uid=" + this.uid + ", alias=" + this.alias + ", photoUrl=" + this.photoUrl + ", version=" + this.version + ", info=" + this.info + ", photoThumbnail=" + this.photoThumbnail + ", username=" + this.username + ", password=" + this.password + ", token=" + this.token + ", expire=" + this.expire + ", toDusId=" + this.toDusId + ", countryCode=" + this.countryCode + ")";
    }

    public Owner(String uid, String alias, String photoUrl, int i10, String info, String photoThumbnail, String username, String password, String token, long j10, String toDusId, int i11) {
        y.i(uid, "uid");
        y.i(alias, "alias");
        y.i(photoUrl, "photoUrl");
        y.i(info, "info");
        y.i(photoThumbnail, "photoThumbnail");
        y.i(username, "username");
        y.i(password, "password");
        y.i(token, "token");
        y.i(toDusId, "toDusId");
        this.uid = uid;
        this.alias = alias;
        this.photoUrl = photoUrl;
        this.version = i10;
        this.info = info;
        this.photoThumbnail = photoThumbnail;
        this.username = username;
        this.password = password;
        this.token = token;
        this.expire = j10;
        this.toDusId = toDusId;
        this.countryCode = i11;
    }

    public /* synthetic */ Owner(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, long j10, String str9, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? "" : str4, (i12 & 32) != 0 ? "" : str5, (i12 & 64) != 0 ? "" : str6, (i12 & 128) != 0 ? "" : str7, (i12 & 256) != 0 ? "" : str8, (i12 & 512) != 0 ? -1L : j10, (i12 & 1024) == 0 ? str9 : "", (i12 & 2048) != 0 ? 53 : i11);
    }
}
