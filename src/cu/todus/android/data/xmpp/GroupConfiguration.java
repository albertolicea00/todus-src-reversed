package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J%\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003JM\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/xmpp/GroupConfiguration;", "", "roomName", "", "subject", "version", "customConfigs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getRoomName", "()Ljava/lang/String;", "getSubject", "getVersion", "getCustomConfigs", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class GroupConfiguration {
    public static final int $stable = 8;
    private final HashMap<String, String> customConfigs;
    private final String roomName;
    private final String subject;
    private final String version;

    public GroupConfiguration(String roomName, String subject, String version, HashMap<String, String> customConfigs) {
        y.i(roomName, "roomName");
        y.i(subject, "subject");
        y.i(version, "version");
        y.i(customConfigs, "customConfigs");
        this.roomName = roomName;
        this.subject = subject;
        this.version = version;
        this.customConfigs = customConfigs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupConfiguration copy$default(GroupConfiguration groupConfiguration, String str, String str2, String str3, HashMap map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = groupConfiguration.roomName;
        }
        if ((i10 & 2) != 0) {
            str2 = groupConfiguration.subject;
        }
        if ((i10 & 4) != 0) {
            str3 = groupConfiguration.version;
        }
        if ((i10 & 8) != 0) {
            map = groupConfiguration.customConfigs;
        }
        return groupConfiguration.copy(str, str2, str3, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoomName() {
        return this.roomName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final HashMap<String, String> component4() {
        return this.customConfigs;
    }

    public final GroupConfiguration copy(String roomName, String subject, String version, HashMap<String, String> customConfigs) {
        y.i(roomName, "roomName");
        y.i(subject, "subject");
        y.i(version, "version");
        y.i(customConfigs, "customConfigs");
        return new GroupConfiguration(roomName, subject, version, customConfigs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupConfiguration)) {
            return false;
        }
        GroupConfiguration groupConfiguration = (GroupConfiguration) other;
        return y.d(this.roomName, groupConfiguration.roomName) && y.d(this.subject, groupConfiguration.subject) && y.d(this.version, groupConfiguration.version) && y.d(this.customConfigs, groupConfiguration.customConfigs);
    }

    public final HashMap<String, String> getCustomConfigs() {
        return this.customConfigs;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.roomName.hashCode() * 31) + this.subject.hashCode()) * 31) + this.version.hashCode()) * 31) + this.customConfigs.hashCode();
    }

    public String toString() {
        return "GroupConfiguration(roomName=" + this.roomName + ", subject=" + this.subject + ", version=" + this.version + ", customConfigs=" + this.customConfigs + ")";
    }
}
