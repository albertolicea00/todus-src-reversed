package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropStateImplKt;
import cu.z17.views.imageEditor.sections.cropper.components.util.ZoomLevel;
import cu.z17.views.imageEditor.sections.cropper.components.util.ZoomUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.CropModifierKt$crop$2$tapModifier$1$1$1$1", f = "CropModifier.kt", l = {TypedValues.TYPE_TARGET}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class CropModifierKt$crop$2$tapModifier$1$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ Offset $offset;
    final /* synthetic */ Function1 $onGestureEnd;
    final /* synthetic */ MutableState<ZoomLevel> $zoomLevel$delegate;
    final /* synthetic */ Function1 $zoomOnDoubleTap;
    float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropModifierKt$crop$2$tapModifier$1$1$1$1(Function1 function1, CropState cropState, Offset offset, MutableState<ZoomLevel> mutableState, Function1 function2, ab.e<? super CropModifierKt$crop$2$tapModifier$1$1$1$1> eVar) {
        super(2, eVar);
        this.$zoomOnDoubleTap = function1;
        this.$cropState = cropState;
        this.$offset = offset;
        this.$zoomLevel$delegate = mutableState;
        this.$onGestureEnd = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(Function1 function1, CropState cropState) {
        if (function1 != null) {
            function1.invoke(CropStateImplKt.getCropData(cropState));
        }
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CropModifierKt$crop$2$tapModifier$1$1$1$1(this.$zoomOnDoubleTap, this.$cropState, this.$offset, this.$zoomLevel$delegate, this.$onGestureEnd, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            MutableState<ZoomLevel> mutableState = this.$zoomLevel$delegate;
            mutableState.setValue(ZoomUtilKt.getNextZoomLevel(CropModifierKt.crop$lambda$10$lambda$3(mutableState)));
            float fFloatValue = ((Number) this.$zoomOnDoubleTap.invoke(CropModifierKt.crop$lambda$10$lambda$3(this.$zoomLevel$delegate))).floatValue();
            CropState cropState = this.$cropState;
            long jM5636unboximpl = this.$offset.m5636unboximpl();
            final Function1 function1 = this.$onGestureEnd;
            final CropState cropState2 = this.$cropState;
            lb.a aVar = new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.h
                @Override // lb.a
                public final Object invoke() {
                    return CropModifierKt$crop$2$tapModifier$1$1$1$1.invokeSuspend$lambda$0(function1, cropState2);
                }
            };
            this.F$0 = fFloatValue;
            this.label = 1;
            if (cropState.mo10214onDoubleTapM_7yMNQ$views_release(jM5636unboximpl, fFloatValue, aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CropModifierKt$crop$2$tapModifier$1$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
