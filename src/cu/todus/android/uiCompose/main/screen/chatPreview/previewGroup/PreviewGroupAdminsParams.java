package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.pojo.RoomMember;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupAdminsParams;", "", "groupId", "", "groupMember", "Lcu/todus/android/data/db/pojo/RoomMember;", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/RoomMember;)V", "getGroupId", "()Ljava/lang/String;", "getGroupMember", "()Lcu/todus/android/data/db/pojo/RoomMember;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PreviewGroupAdminsParams {
    public static final int $stable = 0;
    private final String groupId;
    private final RoomMember groupMember;

    public PreviewGroupAdminsParams(String groupId, RoomMember groupMember) {
        kotlin.jvm.internal.y.i(groupId, "groupId");
        kotlin.jvm.internal.y.i(groupMember, "groupMember");
        this.groupId = groupId;
        this.groupMember = groupMember;
    }

    public static /* synthetic */ PreviewGroupAdminsParams copy$default(PreviewGroupAdminsParams previewGroupAdminsParams, String str, RoomMember roomMember, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = previewGroupAdminsParams.groupId;
        }
        if ((i10 & 2) != 0) {
            roomMember = previewGroupAdminsParams.groupMember;
        }
        return previewGroupAdminsParams.copy(str, roomMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RoomMember getGroupMember() {
        return this.groupMember;
    }

    public final PreviewGroupAdminsParams copy(String groupId, RoomMember groupMember) {
        kotlin.jvm.internal.y.i(groupId, "groupId");
        kotlin.jvm.internal.y.i(groupMember, "groupMember");
        return new PreviewGroupAdminsParams(groupId, groupMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewGroupAdminsParams)) {
            return false;
        }
        PreviewGroupAdminsParams previewGroupAdminsParams = (PreviewGroupAdminsParams) other;
        return kotlin.jvm.internal.y.d(this.groupId, previewGroupAdminsParams.groupId) && kotlin.jvm.internal.y.d(this.groupMember, previewGroupAdminsParams.groupMember);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final RoomMember getGroupMember() {
        return this.groupMember;
    }

    public int hashCode() {
        return (this.groupId.hashCode() * 31) + this.groupMember.hashCode();
    }

    public String toString() {
        return "PreviewGroupAdminsParams(groupId=" + this.groupId + ", groupMember=" + this.groupMember + ")";
    }
}
