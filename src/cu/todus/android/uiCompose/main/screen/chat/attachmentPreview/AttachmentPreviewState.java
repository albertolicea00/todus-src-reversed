package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.runtime.Immutable;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewState;", "", Service.Endpoint.LINKED_DEVICES_LIST, "", "", "fromOwner", "", Room.COLUMN_LAST_MSG, "isSecret", "<init>", "(Ljava/util/List;ZLjava/lang/String;Z)V", "getList", "()Ljava/util/List;", "getFromOwner", "()Z", "getMsgId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AttachmentPreviewState {
    public static final int $stable = 0;
    private final boolean fromOwner;
    private final boolean isSecret;
    private final List<String> list;
    private final String msgId;

    public AttachmentPreviewState(List<String> list, boolean z10, String msgId, boolean z11) {
        kotlin.jvm.internal.y.i(list, "list");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        this.list = list;
        this.fromOwner = z10;
        this.msgId = msgId;
        this.isSecret = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentPreviewState copy$default(AttachmentPreviewState attachmentPreviewState, List list, boolean z10, String str, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = attachmentPreviewState.list;
        }
        if ((i10 & 2) != 0) {
            z10 = attachmentPreviewState.fromOwner;
        }
        if ((i10 & 4) != 0) {
            str = attachmentPreviewState.msgId;
        }
        if ((i10 & 8) != 0) {
            z11 = attachmentPreviewState.isSecret;
        }
        return attachmentPreviewState.copy(list, z10, str, z11);
    }

    public final List<String> component1() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFromOwner() {
        return this.fromOwner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSecret() {
        return this.isSecret;
    }

    public final AttachmentPreviewState copy(List<String> list, boolean fromOwner, String msgId, boolean isSecret) {
        kotlin.jvm.internal.y.i(list, "list");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        return new AttachmentPreviewState(list, fromOwner, msgId, isSecret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentPreviewState)) {
            return false;
        }
        AttachmentPreviewState attachmentPreviewState = (AttachmentPreviewState) other;
        return kotlin.jvm.internal.y.d(this.list, attachmentPreviewState.list) && this.fromOwner == attachmentPreviewState.fromOwner && kotlin.jvm.internal.y.d(this.msgId, attachmentPreviewState.msgId) && this.isSecret == attachmentPreviewState.isSecret;
    }

    public final boolean getFromOwner() {
        return this.fromOwner;
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        return (((((this.list.hashCode() * 31) + androidx.camera.camera2.adapter.r.a(this.fromOwner)) * 31) + this.msgId.hashCode()) * 31) + androidx.camera.camera2.adapter.r.a(this.isSecret);
    }

    public final boolean isSecret() {
        return this.isSecret;
    }

    public String toString() {
        return "AttachmentPreviewState(list=" + this.list + ", fromOwner=" + this.fromOwner + ", msgId=" + this.msgId + ", isSecret=" + this.isSecret + ")";
    }
}
