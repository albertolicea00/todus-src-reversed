package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcu/todus/android/data/db/pojo/content/TemplateContent;", "", "step", "", "title", "", "label", "type", "minLines", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getStep", "()I", "getTitle", "()Ljava/lang/String;", "getLabel", "getType", "getMinLines", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TemplateContent {
    public static final int $stable = 0;
    public static final String CONTACT_TYPE = "contact";
    public static final String NUMBER_TYPE = "number";
    public static final String TEXT_TYPE = "text";
    private final String label;
    private final int minLines;
    private final int step;
    private final String title;
    private final String type;

    public TemplateContent(int i10, String title, String label, String type, int i11) {
        y.i(title, "title");
        y.i(label, "label");
        y.i(type, "type");
        this.step = i10;
        this.title = title;
        this.label = label;
        this.type = type;
        this.minLines = i11;
    }

    public static /* synthetic */ TemplateContent copy$default(TemplateContent templateContent, int i10, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = templateContent.step;
        }
        if ((i12 & 2) != 0) {
            str = templateContent.title;
        }
        if ((i12 & 4) != 0) {
            str2 = templateContent.label;
        }
        if ((i12 & 8) != 0) {
            str3 = templateContent.type;
        }
        if ((i12 & 16) != 0) {
            i11 = templateContent.minLines;
        }
        int i13 = i11;
        String str4 = str2;
        return templateContent.copy(i10, str, str4, str3, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStep() {
        return this.step;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMinLines() {
        return this.minLines;
    }

    public final TemplateContent copy(int step, String title, String label, String type, int minLines) {
        y.i(title, "title");
        y.i(label, "label");
        y.i(type, "type");
        return new TemplateContent(step, title, label, type, minLines);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateContent)) {
            return false;
        }
        TemplateContent templateContent = (TemplateContent) other;
        return this.step == templateContent.step && y.d(this.title, templateContent.title) && y.d(this.label, templateContent.label) && y.d(this.type, templateContent.type) && this.minLines == templateContent.minLines;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getMinLines() {
        return this.minLines;
    }

    public final int getStep() {
        return this.step;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.step * 31) + this.title.hashCode()) * 31) + this.label.hashCode()) * 31) + this.type.hashCode()) * 31) + this.minLines;
    }

    public String toString() {
        return "TemplateContent(step=" + this.step + ", title=" + this.title + ", label=" + this.label + ", type=" + this.type + ", minLines=" + this.minLines + ")";
    }
}
