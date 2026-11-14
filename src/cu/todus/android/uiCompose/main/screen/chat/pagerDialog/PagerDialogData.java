package cu.todus.android.uiCompose.main.screen.chat.pagerDialog;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogData;", "", "title", "", "buttonTemplate", "Lcu/todus/android/data/db/pojo/content/ButtonTemplate;", "autoSend", "", "roomId", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/ButtonTemplate;ZLjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getButtonTemplate", "()Lcu/todus/android/data/db/pojo/content/ButtonTemplate;", "getAutoSend", "()Z", "getRoomId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PagerDialogData {
    public static final int $stable = 0;
    private final boolean autoSend;
    private final ButtonTemplate buttonTemplate;
    private final String roomId;
    private final String title;

    public PagerDialogData(String title, ButtonTemplate buttonTemplate, boolean z10, String roomId) {
        y.i(title, "title");
        y.i(buttonTemplate, "buttonTemplate");
        y.i(roomId, "roomId");
        this.title = title;
        this.buttonTemplate = buttonTemplate;
        this.autoSend = z10;
        this.roomId = roomId;
    }

    public static /* synthetic */ PagerDialogData copy$default(PagerDialogData pagerDialogData, String str, ButtonTemplate buttonTemplate, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pagerDialogData.title;
        }
        if ((i10 & 2) != 0) {
            buttonTemplate = pagerDialogData.buttonTemplate;
        }
        if ((i10 & 4) != 0) {
            z10 = pagerDialogData.autoSend;
        }
        if ((i10 & 8) != 0) {
            str2 = pagerDialogData.roomId;
        }
        return pagerDialogData.copy(str, buttonTemplate, z10, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ButtonTemplate getButtonTemplate() {
        return this.buttonTemplate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoSend() {
        return this.autoSend;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    public final PagerDialogData copy(String title, ButtonTemplate buttonTemplate, boolean autoSend, String roomId) {
        y.i(title, "title");
        y.i(buttonTemplate, "buttonTemplate");
        y.i(roomId, "roomId");
        return new PagerDialogData(title, buttonTemplate, autoSend, roomId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerDialogData)) {
            return false;
        }
        PagerDialogData pagerDialogData = (PagerDialogData) other;
        return y.d(this.title, pagerDialogData.title) && y.d(this.buttonTemplate, pagerDialogData.buttonTemplate) && this.autoSend == pagerDialogData.autoSend && y.d(this.roomId, pagerDialogData.roomId);
    }

    public final boolean getAutoSend() {
        return this.autoSend;
    }

    public final ButtonTemplate getButtonTemplate() {
        return this.buttonTemplate;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.buttonTemplate.hashCode()) * 31) + androidx.camera.camera2.adapter.r.a(this.autoSend)) * 31) + this.roomId.hashCode();
    }

    public String toString() {
        return "PagerDialogData(title=" + this.title + ", buttonTemplate=" + this.buttonTemplate + ", autoSend=" + this.autoSend + ", roomId=" + this.roomId + ")";
    }

    public /* synthetic */ PagerDialogData(String str, ButtonTemplate buttonTemplate, boolean z10, String str2, int i10, kotlin.jvm.internal.p pVar) {
        this(str, buttonTemplate, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? "" : str2);
    }
}
