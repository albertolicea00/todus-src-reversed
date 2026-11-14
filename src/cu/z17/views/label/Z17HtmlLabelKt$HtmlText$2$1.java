package cu.z17.views.label;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class Z17HtmlLabelKt$HtmlText$2$1 implements PointerInputEventHandler {
    final /* synthetic */ AnnotatedString $annotatedString;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ lb.a $onClick;
    final /* synthetic */ lb.a $onLongClick;
    final /* synthetic */ UriHandler $uriHandler;

    public Z17HtmlLabelKt$HtmlText$2$1(lb.a aVar, MutableState<TextLayoutResult> mutableState, lb.a aVar2, AnnotatedString annotatedString, UriHandler uriHandler) {
        this.$onLongClick = aVar;
        this.$layoutResult = mutableState;
        this.$onClick = aVar2;
        this.$annotatedString = annotatedString;
        this.$uriHandler = uriHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(lb.a aVar, Offset offset) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$3(MutableState mutableState, lb.a aVar, AnnotatedString annotatedString, UriHandler uriHandler, Offset offset) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) mutableState.getValue();
        if (textLayoutResult != null) {
            int iM8228getOffsetForPositionk4lQ0M = textLayoutResult.m8228getOffsetForPositionk4lQ0M(offset.m5636unboximpl());
            AnnotatedString.Range range = (AnnotatedString.Range) va.g0.y0(annotatedString.getStringAnnotations(iM8228getOffsetForPositionk4lQ0M, iM8228getOffsetForPositionk4lQ0M));
            if (range != null) {
                if (kotlin.jvm.internal.y.d(range.getTag(), "url")) {
                    uriHandler.openUri((String) range.getItem());
                }
                return ua.k0.f43947a;
            }
        }
        aVar.invoke();
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final lb.a aVar = this.$onLongClick;
        Function1 function1 = new Function1() { // from class: cu.z17.views.label.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17HtmlLabelKt$HtmlText$2$1.invoke$lambda$0(aVar, (Offset) obj);
            }
        };
        final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
        final lb.a aVar2 = this.$onClick;
        final AnnotatedString annotatedString = this.$annotatedString;
        final UriHandler uriHandler = this.$uriHandler;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, null, new Function1() { // from class: cu.z17.views.label.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17HtmlLabelKt$HtmlText$2$1.invoke$lambda$3(mutableState, aVar2, annotatedString, uriHandler, (Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
