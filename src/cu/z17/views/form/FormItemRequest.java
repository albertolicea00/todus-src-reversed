package cu.z17.views.form;

import androidx.compose.runtime.Immutable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J}\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\fHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00067"}, d2 = {"Lcu/z17/views/form/FormItemRequest;", "", "id", "", "type", "Lcu/z17/views/form/FormItemType;", "label", "description", AppMeasurementSdk.ConditionalUserProperty.VALUE, "okRegex", "errorLabel", "limit", "", "displaySize", "", "selectionList", "", "imageForm", "Lcu/z17/views/form/ImageForm;", "<init>", "(Ljava/lang/String;Lcu/z17/views/form/FormItemType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/util/List;Lcu/z17/views/form/ImageForm;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcu/z17/views/form/FormItemType;", "getLabel", "getDescription", "getValue", "getOkRegex", "getErrorLabel", "getLimit", "()I", "getDisplaySize", "()F", "getSelectionList", "()Ljava/util/List;", "getImageForm", "()Lcu/z17/views/form/ImageForm;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FormItemRequest {
    public static final int $stable = 0;
    private final String description;
    private final float displaySize;
    private final String errorLabel;
    private final String id;
    private final ImageForm imageForm;
    private final String label;
    private final int limit;
    private final String okRegex;
    private final List<String> selectionList;
    private final FormItemType type;
    private final String value;

    public FormItemRequest(String id2, FormItemType type, String label, String description, String value, String okRegex, String errorLabel, int i10, float f10, List<String> selectionList, ImageForm imageForm) {
        kotlin.jvm.internal.y.i(id2, "id");
        kotlin.jvm.internal.y.i(type, "type");
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(description, "description");
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(okRegex, "okRegex");
        kotlin.jvm.internal.y.i(errorLabel, "errorLabel");
        kotlin.jvm.internal.y.i(selectionList, "selectionList");
        kotlin.jvm.internal.y.i(imageForm, "imageForm");
        this.id = id2;
        this.type = type;
        this.label = label;
        this.description = description;
        this.value = value;
        this.okRegex = okRegex;
        this.errorLabel = errorLabel;
        this.limit = i10;
        this.displaySize = f10;
        this.selectionList = selectionList;
        this.imageForm = imageForm;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormItemRequest copy$default(FormItemRequest formItemRequest, String str, FormItemType formItemType, String str2, String str3, String str4, String str5, String str6, int i10, float f10, List list, ImageForm imageForm, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = formItemRequest.id;
        }
        if ((i11 & 2) != 0) {
            formItemType = formItemRequest.type;
        }
        if ((i11 & 4) != 0) {
            str2 = formItemRequest.label;
        }
        if ((i11 & 8) != 0) {
            str3 = formItemRequest.description;
        }
        if ((i11 & 16) != 0) {
            str4 = formItemRequest.value;
        }
        if ((i11 & 32) != 0) {
            str5 = formItemRequest.okRegex;
        }
        if ((i11 & 64) != 0) {
            str6 = formItemRequest.errorLabel;
        }
        if ((i11 & 128) != 0) {
            i10 = formItemRequest.limit;
        }
        if ((i11 & 256) != 0) {
            f10 = formItemRequest.displaySize;
        }
        if ((i11 & 512) != 0) {
            list = formItemRequest.selectionList;
        }
        if ((i11 & 1024) != 0) {
            imageForm = formItemRequest.imageForm;
        }
        List list2 = list;
        ImageForm imageForm2 = imageForm;
        int i12 = i10;
        float f11 = f10;
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str2;
        return formItemRequest.copy(str, formItemType, str10, str3, str9, str7, str8, i12, f11, list2, imageForm2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.selectionList;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ImageForm getImageForm() {
        return this.imageForm;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FormItemType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOkRegex() {
        return this.okRegex;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getErrorLabel() {
        return this.errorLabel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getDisplaySize() {
        return this.displaySize;
    }

    public final FormItemRequest copy(String id2, FormItemType type, String label, String description, String value, String okRegex, String errorLabel, int limit, float displaySize, List<String> selectionList, ImageForm imageForm) {
        kotlin.jvm.internal.y.i(id2, "id");
        kotlin.jvm.internal.y.i(type, "type");
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(description, "description");
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(okRegex, "okRegex");
        kotlin.jvm.internal.y.i(errorLabel, "errorLabel");
        kotlin.jvm.internal.y.i(selectionList, "selectionList");
        kotlin.jvm.internal.y.i(imageForm, "imageForm");
        return new FormItemRequest(id2, type, label, description, value, okRegex, errorLabel, limit, displaySize, selectionList, imageForm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormItemRequest)) {
            return false;
        }
        FormItemRequest formItemRequest = (FormItemRequest) other;
        return kotlin.jvm.internal.y.d(this.id, formItemRequest.id) && this.type == formItemRequest.type && kotlin.jvm.internal.y.d(this.label, formItemRequest.label) && kotlin.jvm.internal.y.d(this.description, formItemRequest.description) && kotlin.jvm.internal.y.d(this.value, formItemRequest.value) && kotlin.jvm.internal.y.d(this.okRegex, formItemRequest.okRegex) && kotlin.jvm.internal.y.d(this.errorLabel, formItemRequest.errorLabel) && this.limit == formItemRequest.limit && Float.compare(this.displaySize, formItemRequest.displaySize) == 0 && kotlin.jvm.internal.y.d(this.selectionList, formItemRequest.selectionList) && this.imageForm == formItemRequest.imageForm;
    }

    public final String getDescription() {
        return this.description;
    }

    public final float getDisplaySize() {
        return this.displaySize;
    }

    public final String getErrorLabel() {
        return this.errorLabel;
    }

    public final String getId() {
        return this.id;
    }

    public final ImageForm getImageForm() {
        return this.imageForm;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getOkRegex() {
        return this.okRegex;
    }

    public final List<String> getSelectionList() {
        return this.selectionList;
    }

    public final FormItemType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.label.hashCode()) * 31) + this.description.hashCode()) * 31) + this.value.hashCode()) * 31) + this.okRegex.hashCode()) * 31) + this.errorLabel.hashCode()) * 31) + this.limit) * 31) + Float.floatToIntBits(this.displaySize)) * 31) + this.selectionList.hashCode()) * 31) + this.imageForm.hashCode();
    }

    public String toString() {
        return "FormItemRequest(id=" + this.id + ", type=" + this.type + ", label=" + this.label + ", description=" + this.description + ", value=" + this.value + ", okRegex=" + this.okRegex + ", errorLabel=" + this.errorLabel + ", limit=" + this.limit + ", displaySize=" + this.displaySize + ", selectionList=" + this.selectionList + ", imageForm=" + this.imageForm + ")";
    }

    public /* synthetic */ FormItemRequest(String str, FormItemType formItemType, String str2, String str3, String str4, String str5, String str6, int i10, float f10, List list, ImageForm imageForm, int i11, kotlin.jvm.internal.p pVar) {
        this(str, formItemType, str2, (i11 & 8) != 0 ? "" : str3, str4, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? "" : str6, (i11 & 128) != 0 ? Integer.MAX_VALUE : i10, (i11 & 256) != 0 ? 1.0f : f10, (i11 & 512) != 0 ? va.w.n() : list, (i11 & 1024) != 0 ? ImageForm.ROUND_CORNERS : imageForm);
    }
}
