package cu.z17.views.imageEditor.sections.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.ClearKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.zoomables.ZoomData;
import cu.z17.views.zoomables.ZoomModifierKt;
import cu.z17.views.zoomables.ZoomState;
import cu.z17.views.zoomables.ZoomStateKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import pe.m0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a9\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aI\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u001b²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00178\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00198\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "Lkotlin/Function1;", "Lua/k0;", "onTextSuccess", "Lkotlin/Function0;", "onCancel", "Text", "(Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroid/graphics/Bitmap;", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "", "textColor", "", "Landroidx/compose/ui/graphics/Color;", "colors", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onGloballyPositioned", "Text2", "(Landroid/graphics/Bitmap;Landroidx/compose/ui/focus/FocusRequester;ILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "", "isEditing", "Landroidx/compose/ui/geometry/Rect;", "capturingViewBounds", "", "textValue", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Text(final ImageBitmap imageBitmap, Function1 function1, final lb.a onCancel, Composer composer, final int i10) {
        Composer composer2;
        int i11;
        FocusRequester focusRequester;
        final FocusRequester focusRequester2;
        char c10;
        int i12;
        ab.e eVar;
        final MutableIntState mutableIntState;
        long background;
        final Function1 onTextSuccess = function1;
        y.i(imageBitmap, "imageBitmap");
        y.i(onTextSuccess, "onTextSuccess");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1867609742);
        int i13 = (i10 & 6) == 0 ? (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onTextSuccess) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onCancel) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1867609742, i13, -1, "cu.z17.views.imageEditor.sections.text.Text (Text.kt:72)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            FocusRequester focusRequester3 = (FocusRequester) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                Color.Companion companion5 = Color.INSTANCE;
                i11 = 0;
                objRememberedValue2 = w.q(Color.m5856boximpl(companion5.m5903getWhite0d7_KjU()), Color.m5856boximpl(companion5.m5892getBlack0d7_KjU()), Color.m5856boximpl(ColorKt.Color(4294940672L)), Color.m5856boximpl(ColorKt.Color(4291176488L)), Color.m5856boximpl(ColorKt.Color(4283215696L)), Color.m5856boximpl(ColorKt.Color(4288423856L)));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                i11 = 0;
            }
            List list = (List) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(i11);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue4;
            int i14 = i11;
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(i14, composerStartRestartGroup, i14, 1);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue5;
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final m0 m0Var = (m0) objRememberedValue6;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion4.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue7 = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue7;
            Modifier modifierA = x.a(columnScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting() || !y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion4.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text$lambda$33$lambda$22$lambda$17$lambda$11$lambda$10(mutableState3, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            MutableIntState mutableIntState3 = mutableIntState2;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue8), 0.0f, 1, null), AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), null, null, null, null, 0, null, null, composerStartRestartGroup, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            ZoomState zoomStateRememberZoomState = ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, true, true, (Object) null, composerStartRestartGroup, 14155776, 319);
            boolean zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue9 == companion4.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text$lambda$33$lambda$22$lambda$17$lambda$13$lambda$12(softwareKeyboardController, (ZoomData) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Modifier modifierZoom$default = ZoomModifierKt.zoom$default(modifierFillMaxSize$default2, (Object) null, false, false, zoomStateRememberZoomState, (Function1) objRememberedValue9, (Function1) null, (Function1) null, 99, (Object) null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierZoom$default);
            lb.a constructor4 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl4.getInserting() || !y.d(composerM5176constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM5176constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM5176constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(companion, focusRequester3);
            boolean z10 = !Text$lambda$33$lambda$5(mutableState2);
            String str = (String) mutableState.getValue();
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), ((Color) list.get(mutableIntState3.getIntValue())).m5876unboximpl(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == companion4.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text$lambda$33$lambda$22$lambda$17$lambda$16$lambda$15$lambda$14(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Z17InputTextKt.m10252Z17InputTextFlatjjL0WB4(modifierFocusRequester, str, 0, 0, null, null, (Function1) objRememberedValue10, null, null, 0, 0, 0L, textStyleM8271copyp1EtxEg$default, z10, circleShape, false, composerStartRestartGroup, 1572864, 0, 36796);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (Text$lambda$33$lambda$5(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(2100535776);
                Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getBottomCenter());
                float f10 = 10;
                Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(modifierAlign, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 7, null), 0.0f, 1, null), scrollStateRememberScrollState, false, null, false, 14, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), composerStartRestartGroup, 6);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
                lb.a constructor5 = companion3.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl5.getInserting() || !y.d(composerM5176constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    composerM5176constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composerM5176constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(1965118078);
                final int i15 = 0;
                for (Object obj : list) {
                    int i16 = i15 + 1;
                    if (i15 < 0) {
                        w.x();
                    }
                    long jM5876unboximpl = ((Color) obj).m5876unboximpl();
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    boolean zChanged2 = composerStartRestartGroup.changed(i15);
                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        mutableIntState = mutableIntState3;
                        objRememberedValue11 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.text.k
                            @Override // lb.a
                            public final Object invoke() {
                                return TextKt.Text$lambda$33$lambda$22$lambda$21$lambda$20$lambda$19$lambda$18(mutableIntState, i15);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    } else {
                        mutableIntState = mutableIntState3;
                    }
                    float f11 = f10;
                    FocusRequester focusRequester4 = focusRequester3;
                    Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(PaddingKt.m1727paddingVpY3zN4$default(ClickableKt.m1238clickableXHw0xAI$default(companion6, false, null, null, (lb.a) objRememberedValue11, 7, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null), Dp.m8823constructorimpl(30)), jM5876unboximpl, RoundedCornerShapeKt.getCircleShape());
                    float fM8823constructorimpl = Dp.m8823constructorimpl(1);
                    if (mutableIntState.getIntValue() == i15) {
                        composerStartRestartGroup.startReplaceGroup(935794205);
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(935795611);
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    BoxKt.Box(BorderKt.m1216borderxT4_qwU(modifierM1204backgroundbw27NRU, fM8823constructorimpl, background, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                    i15 = i16;
                    mutableIntState3 = mutableIntState;
                    f10 = f11;
                    focusRequester3 = focusRequester4;
                }
                focusRequester = focusRequester3;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
            } else {
                focusRequester = focusRequester3;
                composerStartRestartGroup.startReplaceGroup(684556884);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            Modifier.Companion companion7 = Modifier.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i17 = MaterialTheme.$stable;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m1205backgroundbw27NRU$default(companion7, materialTheme.getColorScheme(composerStartRestartGroup, i17).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(30), 7, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Companion companion8 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center, companion8.getTop(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
            lb.a constructor6 = companion9.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy2, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion9.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash6 = companion9.getSetCompositeKeyHash();
            if (composerM5176constructorimpl6.getInserting() || !y.d(composerM5176constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                composerM5176constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                composerM5176constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion9.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            float f12 = 1;
            float f13 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(companion7, Dp.m8823constructorimpl(f12), materialTheme.getColorScheme(composerStartRestartGroup, i17).getOnBackground(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f13));
            int i18 = i13 & 896;
            boolean z11 = i18 == 256;
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.text.l
                    @Override // lb.a
                    public final Object invoke() {
                        return TextKt.Text$lambda$33$lambda$29$lambda$24$lambda$23(onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1725padding3ABfNKs, false, null, null, (lb.a) objRememberedValue12, 7, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion8.getCenter(), false);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default);
            lb.a constructor7 = companion9.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor7);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy4, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion9.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash7 = companion9.getSetCompositeKeyHash();
            if (composerM5176constructorimpl7.getInserting() || !y.d(composerM5176constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM5176constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM5176constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion9.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            float f14 = 25;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion7, Dp.m8823constructorimpl(f14));
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector clear = ClearKt.getClear(outlined);
            ColorFilter.Companion companion10 = ColorFilter.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, clear, null, ColorFilter.Companion.m5907tintxETnrds$default(companion10, materialTheme.getColorScheme(composerStartRestartGroup, i17).getPrimary(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion7, Dp.m8823constructorimpl(f13)), composerStartRestartGroup, 6);
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(companion7, Dp.m8823constructorimpl(f12), materialTheme.getColorScheme(composerStartRestartGroup, i17).getOnBackground(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f13));
            boolean zChangedInstance = ((i13 & 112) == 32) | composerStartRestartGroup.changedInstance(m0Var) | composerStartRestartGroup.changed(softwareKeyboardController) | composerStartRestartGroup.changedInstance(view) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                focusRequester2 = focusRequester;
                c10 = 256;
                i12 = 6;
                eVar = null;
                onTextSuccess = function1;
                lb.a aVar = new lb.a() { // from class: cu.z17.views.imageEditor.sections.text.m
                    @Override // lb.a
                    public final Object invoke() {
                        return TextKt.Text$lambda$33$lambda$29$lambda$27$lambda$26(m0Var, focusRequester2, softwareKeyboardController, mutableState2, mutableState3, view, context, onTextSuccess);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(aVar);
                objRememberedValue13 = aVar;
            } else {
                onTextSuccess = function1;
                focusRequester2 = focusRequester;
                c10 = 256;
                i12 = 6;
                eVar = null;
            }
            int i19 = i12;
            ab.e eVar2 = eVar;
            Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifierM1725padding3ABfNKs2, false, null, null, (lb.a) objRememberedValue13, 7, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion8.getCenter(), false);
            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1238clickableXHw0xAI$default2);
            lb.a constructor8 = companion9.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor8);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy5, companion9.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion9.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash8 = companion9.getSetCompositeKeyHash();
            if (composerM5176constructorimpl8.getInserting() || !y.d(composerM5176constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                composerM5176constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                composerM5176constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
            }
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion9.getSetModifier());
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion7, Dp.m8823constructorimpl(f14)), CheckKt.getCheck(outlined), null, ColorFilter.Companion.m5907tintxETnrds$default(companion10, materialTheme.getColorScheme(composerStartRestartGroup, i17).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            composer2.endNode();
            k0 k0Var = k0.f43947a;
            Object objRememberedValue14 = composer2.rememberedValue();
            Composer.Companion companion11 = Composer.INSTANCE;
            if (objRememberedValue14 == companion11.getEmpty()) {
                objRememberedValue14 = new TextKt$Text$1$3$1(focusRequester2, eVar2);
                composer2.updateRememberedValue(objRememberedValue14);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue14, composer2, i19);
            boolean z12 = i18 == 256;
            Object objRememberedValue15 = composer2.rememberedValue();
            if (z12 || objRememberedValue15 == companion11.getEmpty()) {
                objRememberedValue15 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.text.n
                    @Override // lb.a
                    public final Object invoke() {
                        return TextKt.Text$lambda$33$lambda$32$lambda$31(onCancel);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue15);
            }
            BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue15, composer2, 0, 1);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.text.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TextKt.Text$lambda$34(imageBitmap, onTextSuccess, onCancel, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void Text$lambda$33$getAndSaveView(m0 m0Var, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, MutableState<Boolean> mutableState, MutableState<Rect> mutableState2, View view, Context context, Function1 function1) {
        pe.k.d(m0Var, null, null, new TextKt$Text$1$getAndSaveView$1(focusRequester, softwareKeyboardController, mutableState, mutableState2, view, context, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$22$lambda$17$lambda$11$lambda$10(MutableState mutableState, LayoutCoordinates it) {
        y.i(it, "it");
        mutableState.setValue(LayoutCoordinatesKt.boundsInRoot(it));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$22$lambda$17$lambda$13$lambda$12(SoftwareKeyboardController softwareKeyboardController, ZoomData it) {
        y.i(it, "it");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$22$lambda$17$lambda$16$lambda$15$lambda$14(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$22$lambda$21$lambda$20$lambda$19$lambda$18(MutableIntState mutableIntState, int i10) {
        mutableIntState.setIntValue(i10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$29$lambda$24$lambda$23(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$29$lambda$27$lambda$26(m0 m0Var, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState, MutableState mutableState2, View view, Context context, Function1 function1) {
        Text$lambda$33$getAndSaveView(m0Var, focusRequester, softwareKeyboardController, mutableState, mutableState2, view, context, function1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$33$lambda$32$lambda$31(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    private static final boolean Text$lambda$33$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Text$lambda$33$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect Text$lambda$33$lambda$8(MutableState<Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text$lambda$34(ImageBitmap imageBitmap, Function1 function1, lb.a aVar, int i10, Composer composer, int i11) {
        Text(imageBitmap, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Text2(final Bitmap imageBitmap, final FocusRequester focusRequester, int i10, List<Color> list, final Function1 onGloballyPositioned, Composer composer, final int i11) {
        int i12;
        final int i13;
        List<Color> colors = list;
        y.i(imageBitmap, "imageBitmap");
        y.i(focusRequester, "focusRequester");
        y.i(colors, "colors");
        y.i(onGloballyPositioned, "onGloballyPositioned");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1051818108);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(colors) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onGloballyPositioned) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1051818108, i12, -1, "cu.z17.views.imageEditor.sections.text.Text2 (Text.kt:296)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new Picture();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            boolean z10 = (57344 & i12) == 16384;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text2$lambda$47$lambda$40$lambda$39(onGloballyPositioned, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            int i14 = i12;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default2, (Function1) objRememberedValue3), imageBitmap, null, null, null, null, 0, null, null, composerStartRestartGroup, (i12 << 3) & 112, TypedValues.PositionType.TYPE_CURVE_FIT);
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            ZoomState zoomStateRememberZoomState = ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, true, true, (Object) null, composerStartRestartGroup, 14155776, 319);
            boolean zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text2$lambda$47$lambda$42$lambda$41(softwareKeyboardController, (ZoomData) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierZoom$default = ZoomModifierKt.zoom$default(modifierFillMaxSize$default3, (Object) null, false, false, zoomStateRememberZoomState, (Function1) objRememberedValue4, (Function1) null, (Function1) null, 99, (Object) null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierZoom$default);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(companion, focusRequester);
            String strText2$lambda$47$lambda$36 = Text2$lambda$47$lambda$36(mutableState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.z17.views.imageEditor.sections.text.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextKt.Text2$lambda$47$lambda$45$lambda$44$lambda$43(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            i13 = i10;
            colors = list;
            Z17InputTextKt.m10252Z17InputTextFlatjjL0WB4(modifierFocusRequester, strText2$lambda$47$lambda$36, 0, 0, null, null, (Function1) objRememberedValue5, null, null, 0, 0, 0L, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), colors.get(i13).m5876unboximpl(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), false, RoundedCornerShapeKt.getCircleShape(), false, composerStartRestartGroup, 1572864, 0, 44988);
            composerStartRestartGroup.endNode();
            k0 k0Var = k0.f43947a;
            boolean z11 = (i14 & 112) == 32;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = new TextKt$Text2$1$4$1(focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue6, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            i13 = i10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List<Color> list2 = colors;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.text.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextKt.Text2$lambda$48(imageBitmap, focusRequester, i13, list2, onGloballyPositioned, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String Text2$lambda$47$lambda$36(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text2$lambda$47$lambda$40$lambda$39(Function1 function1, LayoutCoordinates it) {
        y.i(it, "it");
        function1.invoke(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text2$lambda$47$lambda$42$lambda$41(SoftwareKeyboardController softwareKeyboardController, ZoomData it) {
        y.i(it, "it");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text2$lambda$47$lambda$45$lambda$44$lambda$43(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Text2$lambda$48(Bitmap bitmap, FocusRequester focusRequester, int i10, List list, Function1 function1, int i11, Composer composer, int i12) {
        Text2(bitmap, focusRequester, i10, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }
}
