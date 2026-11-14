package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropStateImplKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class CropModifierKt$crop$2$transformModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ Function1 $onGesture;
    final /* synthetic */ Function1 $onGestureEnd;
    final /* synthetic */ Function1 $onGestureStart;

    public CropModifierKt$crop$2$transformModifier$1$1(Function1 function1, CropState cropState, m0 m0Var, Function1 function2, Function1 function3) {
        this.$onGestureStart = function1;
        this.$cropState = cropState;
        this.$coroutineScope = m0Var;
        this.$onGesture = function2;
        this.$onGestureEnd = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(Function1 function1, CropState cropState, PointerInputChange it) {
        y.i(it, "it");
        if (function1 != null) {
            function1.invoke(CropStateImplKt.getCropData(cropState));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$1(m0 m0Var, Function1 function1, CropState cropState, Offset offset, Offset offset2, float f10, float f11, PointerInputChange mainPointer, List pointerList) {
        y.i(mainPointer, "mainPointer");
        y.i(pointerList, "pointerList");
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$transformModifier$1$1$2$1(cropState, offset, offset2, f10, f11, mainPointer, pointerList, null), 3, null);
        if (function1 != null) {
            function1.invoke(CropStateImplKt.getCropData(cropState));
        }
        mainPointer.consume();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$2(m0 m0Var, CropState cropState, Function1 function1, PointerInputChange it) {
        y.i(it, "it");
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$transformModifier$1$1$3$1(cropState, function1, null), 3, null);
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final Function1 function1 = this.$onGestureStart;
        final CropState cropState = this.$cropState;
        Function1 function2 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$transformModifier$1$1.invoke$lambda$0(function1, cropState, (PointerInputChange) obj);
            }
        };
        final m0 m0Var = this.$coroutineScope;
        final Function1 function3 = this.$onGesture;
        final CropState cropState2 = this.$cropState;
        lb.q qVar = new lb.q() { // from class: cu.z17.views.imageEditor.sections.cropper.components.m
            @Override // lb.q
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return CropModifierKt$crop$2$transformModifier$1$1.invoke$lambda$1(m0Var, function3, cropState2, (Offset) obj, (Offset) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue(), (PointerInputChange) obj5, (List) obj6);
            }
        };
        final m0 m0Var2 = this.$coroutineScope;
        final CropState cropState3 = this.$cropState;
        final Function1 function4 = this.$onGestureEnd;
        Object objDetectTransformGestures$default = TransformGestureKt.detectTransformGestures$default(pointerInputScope, false, false, null, function2, qVar, new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$transformModifier$1$1.invoke$lambda$2(m0Var2, cropState3, function4, (PointerInputChange) obj);
            }
        }, eVar, 5, null);
        return objDetectTransformGestures$default == bb.b.g() ? objDetectTransformGestures$default : k0.f43947a;
    }
}
