package cu.todus.android.uiCompose.main.screen.createGroup;

import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupParams;", "", "groupName", "", "members", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getGroupName", "()Ljava/lang/String;", "getMembers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CreateGroupParams {
    public static final int $stable = 0;
    private final String groupName;
    private final List<String> members;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateGroupParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateGroupParams copy$default(CreateGroupParams createGroupParams, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = createGroupParams.groupName;
        }
        if ((i10 & 2) != 0) {
            list = createGroupParams.members;
        }
        return createGroupParams.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public final List<String> component2() {
        return this.members;
    }

    public final CreateGroupParams copy(String groupName, List<String> members) {
        kotlin.jvm.internal.y.i(groupName, "groupName");
        kotlin.jvm.internal.y.i(members, "members");
        return new CreateGroupParams(groupName, members);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateGroupParams)) {
            return false;
        }
        CreateGroupParams createGroupParams = (CreateGroupParams) other;
        return kotlin.jvm.internal.y.d(this.groupName, createGroupParams.groupName) && kotlin.jvm.internal.y.d(this.members, createGroupParams.members);
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final List<String> getMembers() {
        return this.members;
    }

    public int hashCode() {
        return (this.groupName.hashCode() * 31) + this.members.hashCode();
    }

    public String toString() {
        return "CreateGroupParams(groupName=" + this.groupName + ", members=" + this.members + ")";
    }

    public CreateGroupParams(String groupName, List<String> members) {
        kotlin.jvm.internal.y.i(groupName, "groupName");
        kotlin.jvm.internal.y.i(members, "members");
        this.groupName = groupName;
        this.members = members;
    }

    public /* synthetic */ CreateGroupParams(String str, List list, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? va.w.n() : list);
    }
}
