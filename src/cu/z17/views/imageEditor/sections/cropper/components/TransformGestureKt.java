package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0096\u0001\u0010\u0010\u001a\u00020\b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000626\u0010\u000e\u001a2\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r\u0012\u0004\u0012\u00020\b0\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "panZoomLock", "consume", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Lua/k0;", "onGestureStart", "Lkotlin/Function6;", "Landroidx/compose/ui/geometry/Offset;", "", "", "onGesture", "onGestureEnd", "detectTransformGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/jvm/functions/Function1;Llb/q;Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TransformGestureKt {

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.TransformGestureKt$detectTransformGestures$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.TransformGestureKt$detectTransformGestures$4", f = "TransformGesture.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 77}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lua/k0;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass4 extends cb.k implements Function2 {
        final /* synthetic */ boolean $consume;
        final /* synthetic */ lb.q $onGesture;
        final /* synthetic */ Function1 $onGestureEnd;
        final /* synthetic */ Function1 $onGestureStart;
        final /* synthetic */ boolean $panZoomLock;
        final /* synthetic */ PointerEventPass $pass;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(PointerEventPass pointerEventPass, Function1 function1, boolean z10, lb.q qVar, boolean z11, Function1 function2, ab.e<? super AnonymousClass4> eVar) {
            super(2, eVar);
            this.$pass = pointerEventPass;
            this.$onGestureStart = function1;
            this.$panZoomLock = z10;
            this.$onGesture = qVar;
            this.$consume = z11;
            this.$onGestureEnd = function2;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$pass, this.$onGestureStart, this.$panZoomLock, this.$onGesture, this.$consume, this.$onGestureEnd, eVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, ab.e<? super k0> eVar) {
            return ((AnonymousClass4) create(awaitPointerEventScope, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:106:0x00e7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:107:0x0100 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:108:? A[LOOP:3: B:24:0x00ee->B:108:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:26:0x00f4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00d2 -> B:18:0x00d5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 595
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.TransformGestureKt.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z10, boolean z11, PointerEventPass pointerEventPass, Function1 function1, lb.q qVar, Function1 function2, ab.e<? super k0> eVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass4(pointerEventPass, function1, z10, qVar, z11, function2, null), eVar);
        return objAwaitEachGesture == bb.b.g() ? objAwaitEachGesture : k0.f43947a;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z10, boolean z11, PointerEventPass pointerEventPass, Function1 function1, lb.q qVar, Function1 function2, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        if ((i10 & 8) != 0) {
            function1 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TransformGestureKt.detectTransformGestures$lambda$0((PointerInputChange) obj2);
                }
            };
        }
        if ((i10 & 32) != 0) {
            function2 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TransformGestureKt.detectTransformGestures$lambda$1((PointerInputChange) obj2);
                }
            };
        }
        Function1 function3 = function2;
        PointerEventPass pointerEventPass2 = pointerEventPass;
        return detectTransformGestures(pointerInputScope, z10, z11, pointerEventPass2, function1, qVar, function3, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 detectTransformGestures$lambda$0(PointerInputChange it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 detectTransformGestures$lambda$1(PointerInputChange it) {
        y.i(it, "it");
        return k0.f43947a;
    }
}
