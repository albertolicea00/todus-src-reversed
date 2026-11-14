package cu.todus.android.uiCompose.main.screen.chat.preview;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class MsgPreviewKt$CardWithAnimatedBorder$3$1 implements PointerInputEventHandler {
    final /* synthetic */ lb.a $onClick;
    final /* synthetic */ lb.a $onLongClick;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt$CardWithAnimatedBorder$3$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.preview.MsgPreviewKt$CardWithAnimatedBorder$3$1$2", f = "MsgPreview.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "it", "Lua/k0;", "<anonymous>", "(Landroidx/compose/foundation/gestures/PressGestureScope;Landroidx/compose/ui/geometry/Offset;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        final /* synthetic */ lb.a $onClick;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
            this.$onClick = aVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m9908invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m5636unboximpl(), (ab.e) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m9908invoked4ec7I(PressGestureScope pressGestureScope, long j10, ab.e<? super k0> eVar) {
            return new AnonymousClass2(this.$onClick, eVar).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            this.$onClick.invoke();
            return k0.f43947a;
        }
    }

    public MsgPreviewKt$CardWithAnimatedBorder$3$1(lb.a aVar, lb.a aVar2) {
        this.$onLongClick = aVar;
        this.$onClick = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(lb.a aVar, Offset offset) {
        aVar.invoke();
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final lb.a aVar = this.$onLongClick;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgPreviewKt$CardWithAnimatedBorder$3$1.invoke$lambda$0(aVar, (Offset) obj);
            }
        }, new AnonymousClass2(this.$onClick, null), null, eVar, 9, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : k0.f43947a;
    }
}
