package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.e0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/InspectorInfo;", "Lua/k0;", "invoke", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1", "<anonymous>"}, k = 3, mv = {2, 2, 0})
public final class CropModifierKt$crop$$inlined$debugInspectorInfo$1 extends e0 implements Function1 {
    final /* synthetic */ Object[] $keys$inlined;
    final /* synthetic */ Function1 $onGesture$inlined;
    final /* synthetic */ Function1 $onGestureEnd$inlined;
    final /* synthetic */ Function1 $onGestureStart$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropModifierKt$crop$$inlined$debugInspectorInfo$1(Object[] objArr, Function1 function1, Function1 function2, Function1 function3) {
        super(1);
        this.$keys$inlined = objArr;
        this.$onGestureStart$inlined = function1;
        this.$onGesture$inlined = function2;
        this.$onGestureEnd$inlined = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return k0.f43947a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("crop");
        inspectorInfo.getProperties().set("keys", this.$keys$inlined);
        inspectorInfo.getProperties().set("onDown", this.$onGestureStart$inlined);
        inspectorInfo.getProperties().set("onMove", this.$onGesture$inlined);
        inspectorInfo.getProperties().set("onUp", this.$onGestureEnd$inlined);
    }
}
