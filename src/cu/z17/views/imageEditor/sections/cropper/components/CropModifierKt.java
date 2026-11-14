package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.util.ZoomLevel;
import cu.z17.views.imageEditor.sections.cropper.components.util.ZoomUtilKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a×\u0001\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0001\"\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013\"$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018²\u0006\u000e\u0010\u0017\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "", "keys", "Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;", "cropState", "Lkotlin/Function1;", "Lcu/z17/views/imageEditor/sections/cropper/components/util/ZoomLevel;", "", "zoomOnDoubleTap", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropData;", "Lua/k0;", "onDown", "onMove", "onUp", "onGestureStart", "onGesture", "onGestureEnd", "crop", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "getDefaultOnDoubleTap", "(Lcu/z17/views/imageEditor/sections/cropper/components/state/CropState;)Lkotlin/jvm/functions/Function1;", "DefaultOnDoubleTap", "zoomLevel", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropModifierKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ZoomLevel.values().length];
            try {
                iArr[ZoomLevel.Min.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZoomLevel.Mid.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ZoomLevel.Max.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _get_DefaultOnDoubleTap_$lambda$11(CropState cropState, ZoomLevel zoomLevel) {
        y.i(zoomLevel, "zoomLevel");
        int i10 = WhenMappings.$EnumSwitchMapping$0[zoomLevel.ordinal()];
        if (i10 == 1) {
            return 1.0f;
        }
        if (i10 == 2) {
            return rb.k.n(3.0f, cropState.getZoomMin(), cropState.getZoomMax());
        }
        if (i10 == 3) {
            return rb.k.d(5.0f, cropState.getZoomMax());
        }
        throw new ua.r();
    }

    public static final Modifier crop(Modifier modifier, final Object[] keys, final CropState cropState, final Function1 zoomOnDoubleTap, final Function1 function1, final Function1 function2, final Function1 function3, Function1 function4, Function1 function5, Function1 function6) {
        final Function1 function7;
        final Function1 function8;
        final Function1 function9;
        Function1 noInspectorInfo;
        y.i(modifier, "<this>");
        y.i(keys, "keys");
        y.i(cropState, "cropState");
        y.i(zoomOnDoubleTap, "zoomOnDoubleTap");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function7 = function4;
            function8 = function5;
            function9 = function6;
            noInspectorInfo = new CropModifierKt$crop$$inlined$debugInspectorInfo$1(keys, function7, function8, function9);
        } else {
            function7 = function4;
            function8 = function5;
            function9 = function6;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new Function3() { // from class: cu.z17.views.imageEditor.sections.cropper.components.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CropModifierKt.crop$lambda$10(cropState, keys, function7, function8, function9, zoomOnDoubleTap, function1, function2, function3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    public static /* synthetic */ Modifier crop$default(Modifier modifier, Object[] objArr, CropState cropState, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, Function1 function7, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function1 = getDefaultOnDoubleTap(cropState);
        }
        return crop(modifier, objArr, cropState, function1, (i10 & 8) != 0 ? null : function2, (i10 & 16) != 0 ? null : function3, (i10 & 32) != 0 ? null : function4, (i10 & 64) != 0 ? null : function5, (i10 & 128) != 0 ? null : function6, (i10 & 256) != 0 ? null : function7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier crop$lambda$10(final CropState cropState, Object[] objArr, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, Function1 function7, Modifier composed, Composer composer, int i10) {
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(1776156421);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1776156421, i10, -1, "cu.z17.views.imageEditor.sections.cropper.components.crop.<anonymous> (CropModifier.kt:54)");
        }
        boolean zChanged = composer.changed(cropState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CropModifierKt$crop$2$1$1(cropState, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        EffectsKt.LaunchedEffect(cropState, (Function2) objRememberedValue, composer, 0);
        Object objRememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
            composer.updateRememberedValue(objRememberedValue2);
        }
        m0 m0Var = (m0) objRememberedValue2;
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ZoomLevel.Min, null, 2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        MutableState mutableState = (MutableState) objRememberedValue3;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        boolean zChanged2 = composer.changed(function1) | composer.changed(cropState) | composer.changedInstance(m0Var) | composer.changed(function2) | composer.changed(function3);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
            Object cropModifierKt$crop$2$transformModifier$1$1 = new CropModifierKt$crop$2$transformModifier$1$1(function1, cropState, m0Var, function2, function3);
            m0Var = m0Var;
            composer.updateRememberedValue(cropModifierKt$crop$2$transformModifier$1$1);
            objRememberedValue4 = cropModifierKt$crop$2$transformModifier$1$1;
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, objArrCopyOf, (PointerInputEventHandler) objRememberedValue4);
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, objArr.length);
        boolean zChangedInstance = composer.changedInstance(m0Var) | composer.changed(function4) | composer.changed(cropState) | composer.changed(function3);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
            Object cropModifierKt$crop$2$tapModifier$1$1 = new CropModifierKt$crop$2$tapModifier$1$1(m0Var, function4, cropState, mutableState, function3);
            composer.updateRememberedValue(cropModifierKt$crop$2$tapModifier$1$1);
            objRememberedValue5 = cropModifierKt$crop$2$tapModifier$1$1;
        }
        Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, objArrCopyOf2, (PointerInputEventHandler) objRememberedValue5);
        Object[] objArrCopyOf3 = Arrays.copyOf(objArr, objArr.length);
        boolean zChangedInstance2 = composer.changedInstance(m0Var) | composer.changed(cropState) | composer.changed(function5) | composer.changed(function6) | composer.changed(function7);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue6 == companion.getEmpty()) {
            Object cropModifierKt$crop$2$touchModifier$1$1 = new CropModifierKt$crop$2$touchModifier$1$1(m0Var, cropState, function5, function6, function7);
            composer.updateRememberedValue(cropModifierKt$crop$2$touchModifier$1$1);
            objRememberedValue6 = cropModifierKt$crop$2$touchModifier$1$1;
        }
        Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, objArrCopyOf3, (PointerInputEventHandler) objRememberedValue6);
        boolean zChanged3 = composer.changed(cropState);
        Object objRememberedValue7 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue7 == companion.getEmpty()) {
            objRememberedValue7 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CropModifierKt.crop$lambda$10$lambda$9$lambda$8(cropState, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        }
        Modifier modifierThen = composed.then(ClipKt.clipToBounds(composed).then(modifierPointerInput2).then(modifierPointerInput).then(modifierPointerInput3).then(GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue7)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZoomLevel crop$lambda$10$lambda$3(MutableState<ZoomLevel> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 crop$lambda$10$lambda$9$lambda$8(CropState cropState, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        ZoomUtilKt.update(graphicsLayer, cropState);
        return k0.f43947a;
    }

    public static final Function1 getDefaultOnDoubleTap(final CropState cropState) {
        y.i(cropState, "<this>");
        return new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(CropModifierKt._get_DefaultOnDoubleTap_$lambda$11(cropState, (ZoomLevel) obj));
            }
        };
    }
}
