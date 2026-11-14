package cu.z17.views.zoomables;

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
import androidx.compose.ui.platform.InspectorInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0081\u0001\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0089\u0001\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u008d\u0001\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u0015\u001a/\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0016\u001a7\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0017\u001a;\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0018\"\u0018\u0010\u001b\u001a\u00020\t*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e²\u0006\u000e\u0010\u001d\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u001c8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "key", "", "consume", "clip", "Lcu/z17/views/zoomables/ZoomState;", "zoomState", "Lkotlin/Function1;", "Lcu/z17/views/zoomables/ZoomData;", "Lua/k0;", "onGestureStart", "onGesture", "onGestureEnd", "zoom", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;ZZLcu/z17/views/zoomables/ZoomState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "key1", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;ZZLcu/z17/views/zoomables/ZoomState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "", "keys", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;ZZLcu/z17/views/zoomables/ZoomState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lcu/z17/views/zoomables/ZoomState;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lcu/z17/views/zoomables/ZoomState;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Lcu/z17/views/zoomables/ZoomState;Z)Landroidx/compose/ui/Modifier;", "getZoomData", "(Lcu/z17/views/zoomables/ZoomState;)Lcu/z17/views/zoomables/ZoomData;", "zoomData", "Lcu/z17/views/zoomables/ZoomLevel;", "zoomLevel", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ZoomModifierKt {
    public static final ZoomData getZoomData(ZoomState zoomState) {
        y.i(zoomState, "<this>");
        return new ZoomData(zoomState.getZoom(), zoomState.m10345getPanF1C5BW0(), zoomState.getRotation(), null);
    }

    public static final Modifier zoom(Modifier modifier, final Object obj, final boolean z10, final boolean z11, final ZoomState zoomState, final Function1 function1, final Function1 function2, final Function1 function3) {
        y.i(modifier, "<this>");
        y.i(zoomState, "zoomState");
        return ComposedModifierKt.composed(modifier, new Function1() { // from class: cu.z17.views.zoomables.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ZoomModifierKt.zoom$lambda$0(obj, z11, z10, zoomState, function1, function2, function3, (InspectorInfo) obj2);
            }
        }, new Function3() { // from class: cu.z17.views.zoomables.g
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return ZoomModifierKt.zoom$lambda$8(zoomState, z11, obj, z10, function1, function2, function3, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object obj, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = k0.f43947a;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        if ((i10 & 16) != 0) {
            function1 = null;
        }
        if ((i10 & 32) != 0) {
            function2 = null;
        }
        return zoom(modifier, obj, z10, z11, zoomState, function1, function2, (i10 & 64) != 0 ? null : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$0(Object obj, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, InspectorInfo composed) {
        y.i(composed, "$this$composed");
        composed.setName("zoom");
        composed.getProperties().set("key", obj);
        composed.getProperties().set("clip", Boolean.valueOf(z10));
        composed.getProperties().set("consume", Boolean.valueOf(z11));
        composed.getProperties().set("zoomState", zoomState);
        composed.getProperties().set("onGestureStart", function1);
        composed.getProperties().set("onGesture", function2);
        composed.getProperties().set("onGestureEnd", function3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier zoom$lambda$17(final ZoomState zoomState, boolean z10, Object obj, Object obj2, boolean z11, Function1 function1, Function1 function2, Function1 function3, Modifier composed, Composer composer, int i10) {
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(-695937674);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-695937674, i10, -1, "cu.z17.views.zoomables.zoom.<anonymous> (ZoomModifier.kt:164)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        m0 m0Var = (m0) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ZoomLevel.Min, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean z12 = z10 || (zoomState.getLimitPan() && !zoomState.getRotatable());
        Modifier modifierClipToBounds = Modifier.INSTANCE;
        boolean zChanged = composer.changed(zoomState) | composer.changed(z11) | composer.changed(function1) | composer.changedInstance(m0Var) | composer.changed(function2) | composer.changed(function3);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
            Object zoomModifierKt$zoom$4$transformModifier$1$1 = new ZoomModifierKt$zoom$4$transformModifier$1$1(zoomState, z11, function1, m0Var, function2, function3);
            composer.updateRememberedValue(zoomModifierKt$zoom$4$transformModifier$1$1);
            objRememberedValue3 = zoomModifierKt$zoom$4$transformModifier$1$1;
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, obj, obj2, (PointerInputEventHandler) objRememberedValue3);
        boolean zChanged2 = composer.changed(zoomState) | composer.changedInstance(m0Var);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new ZoomModifierKt$zoom$4$tapModifier$1$1(zoomState, m0Var, mutableState);
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, obj, obj2, (PointerInputEventHandler) objRememberedValue4);
        boolean zChanged3 = composer.changed(zoomState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: cu.z17.views.zoomables.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return ZoomModifierKt.zoom$lambda$17$lambda$16$lambda$15(zoomState, (GraphicsLayerScope) obj3);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierClipToBounds, (Function1) objRememberedValue5);
        if (z12) {
            modifierClipToBounds = ClipKt.clipToBounds(modifierClipToBounds);
        }
        Modifier modifierThen = composed.then(modifierClipToBounds.then(modifierPointerInput).then(modifierPointerInput2).then(modifierGraphicsLayer));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZoomLevel zoom$lambda$17$lambda$11(MutableState<ZoomLevel> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$17$lambda$16$lambda$15(ZoomState zoomState, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        ZoomUtilKt.update(graphicsLayer, zoomState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$18(Object[] objArr, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, InspectorInfo composed) {
        y.i(composed, "$this$composed");
        composed.setName("zoom");
        composed.getProperties().set("keys", objArr);
        composed.getProperties().set("clip", Boolean.valueOf(z10));
        composed.getProperties().set("consume", Boolean.valueOf(z11));
        composed.getProperties().set("zoomState", zoomState);
        composed.getProperties().set("onGestureStart", function1);
        composed.getProperties().set("onGesture", function2);
        composed.getProperties().set("onGestureEnd", function3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier zoom$lambda$26(final ZoomState zoomState, boolean z10, Object[] objArr, boolean z11, Function1 function1, Function1 function2, Function1 function3, Modifier composed, Composer composer, int i10) {
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(1366726089);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1366726089, i10, -1, "cu.z17.views.zoomables.zoom.<anonymous> (ZoomModifier.kt:282)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        m0 m0Var = (m0) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ZoomLevel.Min, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean z12 = z10 || (zoomState.getLimitPan() && !zoomState.getRotatable());
        Modifier modifierClipToBounds = Modifier.INSTANCE;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        boolean zChanged = composer.changed(zoomState) | composer.changed(z11) | composer.changed(function1) | composer.changedInstance(m0Var) | composer.changed(function2) | composer.changed(function3);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
            Object zoomModifierKt$zoom$6$transformModifier$1$1 = new ZoomModifierKt$zoom$6$transformModifier$1$1(zoomState, z11, function1, m0Var, function2, function3);
            composer.updateRememberedValue(zoomModifierKt$zoom$6$transformModifier$1$1);
            objRememberedValue3 = zoomModifierKt$zoom$6$transformModifier$1$1;
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, objArrCopyOf, (PointerInputEventHandler) objRememberedValue3);
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, objArr.length);
        boolean zChanged2 = composer.changed(zoomState) | composer.changedInstance(m0Var);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new ZoomModifierKt$zoom$6$tapModifier$1$1(zoomState, m0Var, mutableState);
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, objArrCopyOf2, (PointerInputEventHandler) objRememberedValue4);
        boolean zChanged3 = composer.changed(zoomState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: cu.z17.views.zoomables.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ZoomModifierKt.zoom$lambda$26$lambda$25$lambda$24(zoomState, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierClipToBounds, (Function1) objRememberedValue5);
        if (z12) {
            modifierClipToBounds = ClipKt.clipToBounds(modifierClipToBounds);
        }
        Modifier modifierThen = composed.then(modifierClipToBounds.then(modifierPointerInput).then(modifierPointerInput2).then(modifierGraphicsLayer));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZoomLevel zoom$lambda$26$lambda$20(MutableState<ZoomLevel> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$26$lambda$25$lambda$24(ZoomState zoomState, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        ZoomUtilKt.update(graphicsLayer, zoomState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier zoom$lambda$8(final ZoomState zoomState, boolean z10, Object obj, boolean z11, Function1 function1, Function1 function2, Function1 function3, Modifier composed, Composer composer, int i10) {
        Object zoomModifierKt$zoom$2$transformModifier$1$1;
        y.i(composed, "$this$composed");
        composer.startReplaceGroup(-1990502506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990502506, i10, -1, "cu.z17.views.zoomables.zoom.<anonymous> (ZoomModifier.kt:44)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        m0 m0Var = (m0) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ZoomLevel.Min, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean z12 = z10 || (zoomState.getLimitPan() && !zoomState.getRotatable());
        Modifier modifierClipToBounds = Modifier.INSTANCE;
        boolean zChanged = composer.changed(zoomState) | composer.changed(z11) | composer.changed(function1) | composer.changedInstance(m0Var) | composer.changed(function2) | composer.changed(function3);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
            zoomModifierKt$zoom$2$transformModifier$1$1 = new ZoomModifierKt$zoom$2$transformModifier$1$1(zoomState, z11, function1, m0Var, function2, function3);
            composer.updateRememberedValue(zoomModifierKt$zoom$2$transformModifier$1$1);
        } else {
            zoomModifierKt$zoom$2$transformModifier$1$1 = objRememberedValue3;
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, obj, (PointerInputEventHandler) zoomModifierKt$zoom$2$transformModifier$1$1);
        boolean zChanged2 = composer.changed(zoomState) | composer.changedInstance(m0Var);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new ZoomModifierKt$zoom$2$tapModifier$1$1(zoomState, m0Var, mutableState);
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierClipToBounds, obj, (PointerInputEventHandler) objRememberedValue4);
        boolean zChanged3 = composer.changed(zoomState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: cu.z17.views.zoomables.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ZoomModifierKt.zoom$lambda$8$lambda$7$lambda$6(zoomState, (GraphicsLayerScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierClipToBounds, (Function1) objRememberedValue5);
        if (z12) {
            modifierClipToBounds = ClipKt.clipToBounds(modifierClipToBounds);
        }
        Modifier modifierThen = composed.then(modifierClipToBounds.then(modifierPointerInput).then(modifierPointerInput2).then(modifierGraphicsLayer));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZoomLevel zoom$lambda$8$lambda$2(MutableState<ZoomLevel> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$8$lambda$7$lambda$6(ZoomState zoomState, GraphicsLayerScope graphicsLayer) {
        y.i(graphicsLayer, "$this$graphicsLayer");
        ZoomUtilKt.update(graphicsLayer, zoomState);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 zoom$lambda$9(Object obj, Object obj2, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, InspectorInfo composed) {
        y.i(composed, "$this$composed");
        composed.setName("zoom");
        composed.getProperties().set("key1", obj);
        composed.getProperties().set("key2", obj2);
        composed.getProperties().set("clip", Boolean.valueOf(z10));
        composed.getProperties().set("consume", Boolean.valueOf(z11));
        composed.getProperties().set("zoomState", zoomState);
        composed.getProperties().set("onGestureStart", function1);
        composed.getProperties().set("onGesture", function2);
        composed.getProperties().set("onGestureEnd", function3);
        return k0.f43947a;
    }

    public static final Modifier zoom(Modifier modifier, final Object obj, final Object obj2, final boolean z10, final boolean z11, final ZoomState zoomState, final Function1 function1, final Function1 function2, final Function1 function3) {
        y.i(modifier, "<this>");
        y.i(zoomState, "zoomState");
        return ComposedModifierKt.composed(modifier, new Function1() { // from class: cu.z17.views.zoomables.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return ZoomModifierKt.zoom$lambda$9(obj, obj2, z11, z10, zoomState, function1, function2, function3, (InspectorInfo) obj3);
            }
        }, new Function3() { // from class: cu.z17.views.zoomables.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return ZoomModifierKt.zoom$lambda$17(zoomState, z11, obj, obj2, z10, function1, function2, function3, (Modifier) obj3, (Composer) obj4, ((Integer) obj5).intValue());
            }
        });
    }

    public static final Modifier zoom(Modifier modifier, final Object[] keys, final boolean z10, final boolean z11, final ZoomState zoomState, final Function1 function1, final Function1 function2, final Function1 function3) {
        y.i(modifier, "<this>");
        y.i(keys, "keys");
        y.i(zoomState, "zoomState");
        return ComposedModifierKt.composed(modifier, new Function1() { // from class: cu.z17.views.zoomables.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ZoomModifierKt.zoom$lambda$18(keys, z11, z10, zoomState, function1, function2, function3, (InspectorInfo) obj);
            }
        }, new Function3() { // from class: cu.z17.views.zoomables.e
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ZoomModifierKt.zoom$lambda$26(zoomState, z11, keys, z10, function1, function2, function3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object obj, Object obj2, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        if ((i10 & 32) != 0) {
            function1 = null;
        }
        if ((i10 & 64) != 0) {
            function2 = null;
        }
        if ((i10 & 128) != 0) {
            function3 = null;
        }
        return zoom(modifier, obj, obj2, z10, z11, zoomState, function1, function2, function3);
    }

    public static final Modifier zoom(Modifier modifier, Object obj, ZoomState zoomState, boolean z10) {
        y.i(modifier, "<this>");
        y.i(zoomState, "zoomState");
        return zoom(modifier, obj, true, z10, zoomState, (Function1) null, (Function1) null, (Function1) null);
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object[] objArr, boolean z10, boolean z11, ZoomState zoomState, Function1 function1, Function1 function2, Function1 function3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        if ((i10 & 16) != 0) {
            function1 = null;
        }
        if ((i10 & 32) != 0) {
            function2 = null;
        }
        if ((i10 & 64) != 0) {
            function3 = null;
        }
        return zoom(modifier, objArr, z10, z11, zoomState, function1, function2, function3);
    }

    public static final Modifier zoom(Modifier modifier, Object obj, Object obj2, ZoomState zoomState, boolean z10) {
        y.i(modifier, "<this>");
        y.i(zoomState, "zoomState");
        return zoom(modifier, obj, obj2, true, z10, zoomState, null, null, null);
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object obj, ZoomState zoomState, boolean z10, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = k0.f43947a;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return zoom(modifier, obj, zoomState, z10);
    }

    public static final Modifier zoom(Modifier modifier, Object[] keys, ZoomState zoomState, boolean z10) {
        y.i(modifier, "<this>");
        y.i(keys, "keys");
        y.i(zoomState, "zoomState");
        return zoom(modifier, Arrays.copyOf(keys, keys.length), true, z10, zoomState, (Function1) null, (Function1) null, (Function1) null);
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object obj, Object obj2, ZoomState zoomState, boolean z10, int i10, Object obj3) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return zoom(modifier, obj, obj2, zoomState, z10);
    }

    public static /* synthetic */ Modifier zoom$default(Modifier modifier, Object[] objArr, ZoomState zoomState, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return zoom(modifier, objArr, zoomState, z10);
    }
}
