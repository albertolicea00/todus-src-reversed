package cu.todus.android.uiCompose.shared.optTextField;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcu/todus/android/uiCompose/shared/optTextField/SecretFormattedTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "<init>", "()V", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SecretFormattedTransformation implements VisualTransformation {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString text) {
        y.i(text, "text");
        int i10 = 0;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        int i11 = 0;
        while (i10 < text.length()) {
            char cCharAt = text.charAt(i10);
            int i12 = i11 + 1;
            if (i11 < text.length() - 1) {
                builder.append("*");
                builder.append("-");
            } else {
                builder.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        return new TransformedText(builder.toAnnotatedString(), new OffsetMapping() { // from class: cu.todus.android.uiCompose.shared.optTextField.SecretFormattedTransformation$filter$offsetMapping$1
            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int originalToTransformed(int offset) {
                return offset <= 0 ? offset : offset + (offset - 1);
            }

            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int transformedToOriginal(int offset) {
                return offset <= 0 ? offset : (offset + 1) / 2;
            }
        });
    }
}
