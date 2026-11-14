package cu.z17.views.imageEditor.sections.rotater;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.x;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aA\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0013²\u0006\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00008\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroid/graphics/Bitmap;", "imageBitmap", "", "degrees", "Lkotlin/Function1;", "Lua/k0;", "onImageRotated", "Lkotlin/Function0;", "onCancel", "Rotate", "(Landroid/graphics/Bitmap;FLkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "rotate", "(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;", "ROTATION_0", "F", "ROTATION_90", "ROTATION_180", "ROTATION_270", "currentImage", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RotaterKt {
    public static final float ROTATION_0 = 0.0f;
    public static final float ROTATION_180 = 180.0f;
    public static final float ROTATION_270 = 270.0f;
    public static final float ROTATION_90 = 90.0f;

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Rotate(final Bitmap imageBitmap, float f10, final Function1 onImageRotated, final lb.a onCancel, Composer composer, final int i10) {
        int i11;
        float f11;
        y.i(imageBitmap, "imageBitmap");
        y.i(onImageRotated, "onImageRotated");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1389157009);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(f10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onImageRotated) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1389157009, i11, -1, "cu.z17.views.imageEditor.sections.rotater.Rotate (Rotater.kt:23)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            int i12 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(x.a(ColumnScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null), Rotate$lambda$1(mutableState), Color.m5856boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground()), null, null, null, 0, null, null, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(imageBitmap) | ((i12 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.rotater.f
                    @Override // lb.a
                    public final Object invoke() {
                        return RotaterKt.Rotate$lambda$8$lambda$4$lambda$3(onImageRotated, imageBitmap, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            boolean z10 = (i12 & 7168) == 2048;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.rotater.g
                    @Override // lb.a
                    public final Object invoke() {
                        return RotaterKt.Rotate$lambda$8$lambda$6$lambda$5(onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            RotaterBottomBarKt.RotaterBottomBar(aVar, (lb.a) objRememberedValue3, composerStartRestartGroup, 0);
            Float fValueOf = Float.valueOf(f10);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(imageBitmap) | ((i12 & 112) == 32);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                f11 = f10;
                objRememberedValue4 = new RotaterKt$Rotate$1$3$1(imageBitmap, f11, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                f11 = f10;
            }
            EffectsKt.LaunchedEffect(fValueOf, (Function2) objRememberedValue4, composerStartRestartGroup, (i12 >> 3) & 14);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            f11 = f10;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f12 = f11;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.rotater.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RotaterKt.Rotate$lambda$9(imageBitmap, f12, onImageRotated, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Bitmap Rotate$lambda$1(MutableState<Bitmap> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Rotate$lambda$8$lambda$4$lambda$3(Function1 function1, Bitmap bitmap, MutableState mutableState) {
        Bitmap bitmapRotate$lambda$1 = Rotate$lambda$1(mutableState);
        if (bitmapRotate$lambda$1 != null) {
            bitmap = bitmapRotate$lambda$1;
        }
        function1.invoke(bitmap);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Rotate$lambda$8$lambda$6$lambda$5(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Rotate$lambda$9(Bitmap bitmap, float f10, Function1 function1, lb.a aVar, int i10, Composer composer, int i11) {
        Rotate(bitmap, f10, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    public static final Bitmap rotate(Bitmap bitmap, float f10) {
        y.i(bitmap, "<this>");
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }
}
