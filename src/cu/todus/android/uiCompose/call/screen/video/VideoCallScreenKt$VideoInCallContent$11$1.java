package cu.todus.android.uiCompose.call.screen.video;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class VideoCallScreenKt$VideoInCallContent$11$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<Boolean> $controlsVisible$delegate;

    public VideoCallScreenKt$VideoInCallContent$11$1(MutableState<Boolean> mutableState) {
        this.$controlsVisible$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(MutableState mutableState, Offset offset) {
        VideoCallScreenKt.VideoInCallContent$lambda$6(mutableState, !VideoCallScreenKt.VideoInCallContent$lambda$5(mutableState));
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final MutableState<Boolean> mutableState = this.$controlsVisible$delegate;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: cu.todus.android.uiCompose.call.screen.video.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoCallScreenKt$VideoInCallContent$11$1.invoke$lambda$0(mutableState, (Offset) obj);
            }
        }, eVar, 7, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : k0.f43947a;
    }
}
