package cu.z17.views.zoomables;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.z17.views.imageEditor.sections.cropper.components.TransformGestureKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ZoomModifierKt$zoom$2$transformModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ boolean $consume;
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ Function1 $onGesture;
    final /* synthetic */ Function1 $onGestureEnd;
    final /* synthetic */ Function1 $onGestureStart;
    final /* synthetic */ ZoomState $zoomState;

    public ZoomModifierKt$zoom$2$transformModifier$1$1(ZoomState zoomState, boolean z10, Function1 function1, m0 m0Var, Function1 function2, Function1 function3) {
        this.$zoomState = zoomState;
        this.$consume = z10;
        this.$onGestureStart = function1;
        this.$coroutineScope = m0Var;
        this.$onGesture = function2;
        this.$onGestureEnd = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(Function1 function1, ZoomState zoomState, PointerInputChange it) {
        y.i(it, "it");
        if (function1 != null) {
            function1.invoke(ZoomModifierKt.getZoomData(zoomState));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$1(m0 m0Var, Function1 function1, ZoomState zoomState, Offset offset, Offset offset2, float f10, float f11, PointerInputChange pointerInputChange, List list) {
        y.i(pointerInputChange, "<unused var>");
        y.i(list, "<unused var>");
        pe.k.d(m0Var, null, null, new ZoomModifierKt$zoom$2$transformModifier$1$1$2$1(zoomState, offset, offset2, f10, f11, null), 3, null);
        if (function1 != null) {
            function1.invoke(ZoomModifierKt.getZoomData(zoomState));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$2(Function1 function1, ZoomState zoomState, PointerInputChange it) {
        y.i(it, "it");
        if (function1 != null) {
            function1.invoke(ZoomModifierKt.getZoomData(zoomState));
        }
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        this.$zoomState.m10348setSizeozmzZPI$views_release(pointerInputScope.getBoundsSize());
        boolean z10 = this.$consume;
        final Function1 function1 = this.$onGestureStart;
        final ZoomState zoomState = this.$zoomState;
        Function1 function2 = new Function1() { // from class: cu.z17.views.zoomables.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ZoomModifierKt$zoom$2$transformModifier$1$1.invoke$lambda$0(function1, zoomState, (PointerInputChange) obj);
            }
        };
        final m0 m0Var = this.$coroutineScope;
        final Function1 function3 = this.$onGesture;
        final ZoomState zoomState2 = this.$zoomState;
        lb.q qVar = new lb.q() { // from class: cu.z17.views.zoomables.l
            @Override // lb.q
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ZoomModifierKt$zoom$2$transformModifier$1$1.invoke$lambda$1(m0Var, function3, zoomState2, (Offset) obj, (Offset) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue(), (PointerInputChange) obj5, (List) obj6);
            }
        };
        final Function1 function4 = this.$onGestureEnd;
        final ZoomState zoomState3 = this.$zoomState;
        Object objDetectTransformGestures$default = TransformGestureKt.detectTransformGestures$default(pointerInputScope, false, z10, null, function2, qVar, new Function1() { // from class: cu.z17.views.zoomables.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ZoomModifierKt$zoom$2$transformModifier$1$1.invoke$lambda$2(function4, zoomState3, (PointerInputChange) obj);
            }
        }, eVar, 5, null);
        return objDetectTransformGestures$default == bb.b.g() ? objDetectTransformGestures$default : k0.f43947a;
    }
}
