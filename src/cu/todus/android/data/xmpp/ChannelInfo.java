package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.xmpp.iq.channels.CreateChannelIQ;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0087\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u000bHÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u00066"}, d2 = {"Lcu/todus/android/data/xmpp/ChannelInfo;", "", "id", "", "name", "created", "subject", "link", "picUrl", "pictureThumbnail", "public", "", CreateChannelIQ.SUBS, "aff", "rights", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "getCreated", "getSubject", "getLink", "getPicUrl", "getPictureThumbnail", "getPublic", "()I", "getSubs", "getAff", "getRights", "()Ljava/util/List;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChannelInfo {
    public static final int $stable = 8;
    private final String aff;
    private final String created;
    private String id;
    private final String link;
    private final String name;
    private final String picUrl;
    private final String pictureThumbnail;
    private final int public;
    private final List<String> rights;
    private final String subject;
    private final int subs;
    private final String version;

    public ChannelInfo() {
        this(null, null, null, null, null, null, null, 0, 0, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelInfo copy$default(ChannelInfo channelInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, String str8, List list, String str9, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = channelInfo.id;
        }
        if ((i12 & 2) != 0) {
            str2 = channelInfo.name;
        }
        if ((i12 & 4) != 0) {
            str3 = channelInfo.created;
        }
        if ((i12 & 8) != 0) {
            str4 = channelInfo.subject;
        }
        if ((i12 & 16) != 0) {
            str5 = channelInfo.link;
        }
        if ((i12 & 32) != 0) {
            str6 = channelInfo.picUrl;
        }
        if ((i12 & 64) != 0) {
            str7 = channelInfo.pictureThumbnail;
        }
        if ((i12 & 128) != 0) {
            i10 = channelInfo.public;
        }
        if ((i12 & 256) != 0) {
            i11 = channelInfo.subs;
        }
        if ((i12 & 512) != 0) {
            str8 = channelInfo.aff;
        }
        if ((i12 & 1024) != 0) {
            list = channelInfo.rights;
        }
        if ((i12 & 2048) != 0) {
            str9 = channelInfo.version;
        }
        List list2 = list;
        String str10 = str9;
        int i13 = i11;
        String str11 = str8;
        String str12 = str7;
        int i14 = i10;
        String str13 = str5;
        String str14 = str6;
        return channelInfo.copy(str, str2, str3, str4, str13, str14, str12, i14, i13, str11, list2, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAff() {
        return this.aff;
    }

    public final List<String> component11() {
        return this.rights;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPictureThumbnail() {
        return this.pictureThumbnail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getPublic() {
        return this.public;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSubs() {
        return this.subs;
    }

    public final ChannelInfo copy(String id2, String name, String created, String subject, String link, String picUrl, String pictureThumbnail, int i10, int subs, String aff, List<String> rights, String version) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(created, "created");
        y.i(subject, "subject");
        y.i(link, "link");
        y.i(picUrl, "picUrl");
        y.i(pictureThumbnail, "pictureThumbnail");
        y.i(aff, "aff");
        y.i(rights, "rights");
        y.i(version, "version");
        return new ChannelInfo(id2, name, created, subject, link, picUrl, pictureThumbnail, i10, subs, aff, rights, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelInfo)) {
            return false;
        }
        ChannelInfo channelInfo = (ChannelInfo) other;
        return y.d(this.id, channelInfo.id) && y.d(this.name, channelInfo.name) && y.d(this.created, channelInfo.created) && y.d(this.subject, channelInfo.subject) && y.d(this.link, channelInfo.link) && y.d(this.picUrl, channelInfo.picUrl) && y.d(this.pictureThumbnail, channelInfo.pictureThumbnail) && this.public == channelInfo.public && this.subs == channelInfo.subs && y.d(this.aff, channelInfo.aff) && y.d(this.rights, channelInfo.rights) && y.d(this.version, channelInfo.version);
    }

    public final String getAff() {
        return this.aff;
    }

    public final String getCreated() {
        return this.created;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final String getPictureThumbnail() {
        return this.pictureThumbnail;
    }

    public final int getPublic() {
        return this.public;
    }

    public final List<String> getRights() {
        return this.rights;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final int getSubs() {
        return this.subs;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.created.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.link.hashCode()) * 31) + this.picUrl.hashCode()) * 31) + this.pictureThumbnail.hashCode()) * 31) + this.public) * 31) + this.subs) * 31) + this.aff.hashCode()) * 31) + this.rights.hashCode()) * 31) + this.version.hashCode();
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public String toString() {
        return "ChannelInfo(id=" + this.id + ", name=" + this.name + ", created=" + this.created + ", subject=" + this.subject + ", link=" + this.link + ", picUrl=" + this.picUrl + ", pictureThumbnail=" + this.pictureThumbnail + ", public=" + this.public + ", subs=" + this.subs + ", aff=" + this.aff + ", rights=" + this.rights + ", version=" + this.version + ")";
    }

    public ChannelInfo(String id2, String name, String created, String subject, String link, String picUrl, String pictureThumbnail, int i10, int i11, String aff, List<String> rights, String version) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(created, "created");
        y.i(subject, "subject");
        y.i(link, "link");
        y.i(picUrl, "picUrl");
        y.i(pictureThumbnail, "pictureThumbnail");
        y.i(aff, "aff");
        y.i(rights, "rights");
        y.i(version, "version");
        this.id = id2;
        this.name = name;
        this.created = created;
        this.subject = subject;
        this.link = link;
        this.picUrl = picUrl;
        this.pictureThumbnail = pictureThumbnail;
        this.public = i10;
        this.subs = i11;
        this.aff = aff;
        this.rights = rights;
        this.version = version;
    }

    public /* synthetic */ ChannelInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, String str8, List list, String str9, int i12, p pVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? "" : str4, (i12 & 16) != 0 ? "" : str5, (i12 & 32) != 0 ? "" : str6, (i12 & 64) != 0 ? "" : str7, (i12 & 128) != 0 ? -1 : i10, (i12 & 256) == 0 ? i11 : -1, (i12 & 512) != 0 ? UserRoomJoin.AFFILIATION_MEMBER : str8, (i12 & 1024) != 0 ? new ArrayList() : list, (i12 & 2048) != 0 ? "" : str9);
    }
}
