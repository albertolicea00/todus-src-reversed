package cu.todus.android.data.db.pojo.content;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ButtonTemplate;", "", "msgPlaceholder", "", "msgSteps", "", "Lcu/todus/android/data/db/pojo/content/TemplateContent;", "autoSend", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getMsgPlaceholder", "()Ljava/lang/String;", "getMsgSteps", "()Ljava/util/List;", "getAutoSend", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ButtonTemplate {
    public static final int $stable = 0;
    private final boolean autoSend;
    private final String msgPlaceholder;
    private final List<TemplateContent> msgSteps;

    public ButtonTemplate(String msgPlaceholder, List<TemplateContent> msgSteps, boolean z10) {
        y.i(msgPlaceholder, "msgPlaceholder");
        y.i(msgSteps, "msgSteps");
        this.msgPlaceholder = msgPlaceholder;
        this.msgSteps = msgSteps;
        this.autoSend = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonTemplate copy$default(ButtonTemplate buttonTemplate, String str, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = buttonTemplate.msgPlaceholder;
        }
        if ((i10 & 2) != 0) {
            list = buttonTemplate.msgSteps;
        }
        if ((i10 & 4) != 0) {
            z10 = buttonTemplate.autoSend;
        }
        return buttonTemplate.copy(str, list, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsgPlaceholder() {
        return this.msgPlaceholder;
    }

    public final List<TemplateContent> component2() {
        return this.msgSteps;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoSend() {
        return this.autoSend;
    }

    public final ButtonTemplate copy(String msgPlaceholder, List<TemplateContent> msgSteps, boolean autoSend) {
        y.i(msgPlaceholder, "msgPlaceholder");
        y.i(msgSteps, "msgSteps");
        return new ButtonTemplate(msgPlaceholder, msgSteps, autoSend);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonTemplate)) {
            return false;
        }
        ButtonTemplate buttonTemplate = (ButtonTemplate) other;
        return y.d(this.msgPlaceholder, buttonTemplate.msgPlaceholder) && y.d(this.msgSteps, buttonTemplate.msgSteps) && this.autoSend == buttonTemplate.autoSend;
    }

    public final boolean getAutoSend() {
        return this.autoSend;
    }

    public final String getMsgPlaceholder() {
        return this.msgPlaceholder;
    }

    public final List<TemplateContent> getMsgSteps() {
        return this.msgSteps;
    }

    public int hashCode() {
        return (((this.msgPlaceholder.hashCode() * 31) + this.msgSteps.hashCode()) * 31) + r.a(this.autoSend);
    }

    public String toString() {
        return "ButtonTemplate(msgPlaceholder=" + this.msgPlaceholder + ", msgSteps=" + this.msgSteps + ", autoSend=" + this.autoSend + ")";
    }

    public /* synthetic */ ButtonTemplate(String str, List list, boolean z10, int i10, p pVar) {
        this(str, list, (i10 & 4) != 0 ? false : z10);
    }
}
