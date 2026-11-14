package cu.todus.android.data.db.pojo.info;

import androidx.compose.runtime.Immutable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012.\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\u0019\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\tHÆ\u0003Jg\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000320\b\u0002\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR9\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcu/todus/android/data/db/pojo/info/ConfigChangeInGroup;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "prevVersion", "", "version", "roomName", "subject", "customConfigs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getPrevVersion", "()Ljava/lang/String;", "getVersion", "getRoomName", "getSubject", "getCustomConfigs", "()Ljava/util/HashMap;", "isEmpty", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConfigChangeInGroup extends MessagePayload {
    public static final int $stable = 0;
    private final HashMap<String, String> customConfigs;
    private final String prevVersion;
    private final String roomName;
    private final String subject;
    private final String version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigChangeInGroup(String prevVersion, String version, String str, String str2, HashMap<String, String> map) {
        super(MessagePayload.TYPE.CONFIG_CHANGE_IN_GROUP);
        y.i(prevVersion, "prevVersion");
        y.i(version, "version");
        this.prevVersion = prevVersion;
        this.version = version;
        this.roomName = str;
        this.subject = str2;
        this.customConfigs = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigChangeInGroup copy$default(ConfigChangeInGroup configChangeInGroup, String str, String str2, String str3, String str4, HashMap map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = configChangeInGroup.prevVersion;
        }
        if ((i10 & 2) != 0) {
            str2 = configChangeInGroup.version;
        }
        if ((i10 & 4) != 0) {
            str3 = configChangeInGroup.roomName;
        }
        if ((i10 & 8) != 0) {
            str4 = configChangeInGroup.subject;
        }
        if ((i10 & 16) != 0) {
            map = configChangeInGroup.customConfigs;
        }
        HashMap map2 = map;
        String str5 = str3;
        return configChangeInGroup.copy(str, str2, str5, str4, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrevVersion() {
        return this.prevVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRoomName() {
        return this.roomName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final HashMap<String, String> component5() {
        return this.customConfigs;
    }

    public final ConfigChangeInGroup copy(String prevVersion, String version, String roomName, String subject, HashMap<String, String> customConfigs) {
        y.i(prevVersion, "prevVersion");
        y.i(version, "version");
        return new ConfigChangeInGroup(prevVersion, version, roomName, subject, customConfigs);
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigChangeInGroup)) {
            return false;
        }
        ConfigChangeInGroup configChangeInGroup = (ConfigChangeInGroup) other;
        return y.d(this.prevVersion, configChangeInGroup.prevVersion) && y.d(this.version, configChangeInGroup.version) && y.d(this.roomName, configChangeInGroup.roomName) && y.d(this.subject, configChangeInGroup.subject) && y.d(this.customConfigs, configChangeInGroup.customConfigs);
    }

    public final HashMap<String, String> getCustomConfigs() {
        return this.customConfigs;
    }

    public final String getPrevVersion() {
        return this.prevVersion;
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

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public int hashCode() {
        int iHashCode = ((this.prevVersion.hashCode() * 31) + this.version.hashCode()) * 31;
        String str = this.roomName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subject;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        HashMap<String, String> map = this.customConfigs;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isEmpty() {
        HashMap<String, String> map;
        String str = this.roomName;
        if (str != null && str.length() != 0) {
            return false;
        }
        String str2 = this.subject;
        return (str2 == null || str2.length() == 0) && (map = this.customConfigs) != null && map.isEmpty();
    }

    public String toString() {
        return "ConfigChangeInGroup(prevVersion=" + this.prevVersion + ", version=" + this.version + ", roomName=" + this.roomName + ", subject=" + this.subject + ", customConfigs=" + this.customConfigs + ")";
    }
}
