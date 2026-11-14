package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class CropModifierKt$crop$2$touchModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ Function1 $onDown;
    final /* synthetic */ Function1 $onMove;
    final /* synthetic */ Function1 $onUp;

    public CropModifierKt$crop$2$touchModifier$1$1(m0 m0Var, CropState cropState, Function1 function1, Function1 function2, Function1 function3) {
        this.$coroutineScope = m0Var;
        this.$cropState = cropState;
        this.$onDown = function1;
        this.$onMove = function2;
        this.$onUp = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(m0 m0Var, CropState cropState, Function1 function1, PointerInputChange it) {
        y.i(it, "it");
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$touchModifier$1$1$1$1(cropState, it, function1, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$1(m0 m0Var, CropState cropState, Function1 function1, List it) {
        y.i(it, "it");
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$touchModifier$1$1$2$1(cropState, it, function1, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$2(m0 m0Var, CropState cropState, Function1 function1, PointerInputChange it) {
        y.i(it, "it");
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$touchModifier$1$1$3$1(cropState, it, function1, null), 3, null);
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final m0 m0Var = this.$coroutineScope;
        final CropState cropState = this.$cropState;
        final Function1 function1 = this.$onDown;
        Function1 function2 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$touchModifier$1$1.invoke$lambda$0(m0Var, cropState, function1, (PointerInputChange) obj);
            }
        };
        final m0 m0Var2 = this.$coroutineScope;
        final CropState cropState2 = this.$cropState;
        final Function1 function3 = this.$onMove;
        Function1 function4 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$touchModifier$1$1.invoke$lambda$1(m0Var2, cropState2, function3, (List) obj);
            }
        };
        final m0 m0Var3 = this.$coroutineScope;
        final CropState cropState3 = this.$cropState;
        final Function1 function5 = this.$onUp;
        Object objDetectMotionEventsAsList$default = AwaitPointerMotionEventKt.detectMotionEventsAsList$default(pointerInputScope, function2, function4, new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$touchModifier$1$1.invoke$lambda$2(m0Var3, cropState3, function5, (PointerInputChange) obj);
            }
        }, 0L, false, null, eVar, 56, null);
        return objDetectMotionEventsAsList$default == bb.b.g() ? objDetectMotionEventsAsList$default : k0.f43947a;
    }
}
