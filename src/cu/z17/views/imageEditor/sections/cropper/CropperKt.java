package cu.z17.views.imageEditor.sections.cropper;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.x;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
import cu.z17.views.imageEditor.sections.cropper.CropperKt;
import cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatiosKt;
import cu.z17.views.imageEditor.sections.cropper.components.model.OutlineType;
import cu.z17.views.imageEditor.sections.cropper.components.model.RectCropShape;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropDefaults;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropOutlineProperty;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropStyle;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropType;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a9\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "Lkotlin/Function1;", "Lua/k0;", "onCropSuccess", "Lkotlin/Function0;", "onCancel", "Cropper", "(Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", "crop", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropperKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Cropper(final ImageBitmap imageBitmap, final Function1 onCropSuccess, a onCancel, Composer composer, final int i10) {
        int i11;
        final a aVar;
        y.i(imageBitmap, "imageBitmap");
        y.i(onCropSuccess, "onCropSuccess");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(2069729900);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCropSuccess) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2069729900, i11, -1, "cu.z17.views.imageEditor.sections.cropper.Cropper (Cropper.kt:27)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
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
            float fMo1345toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo1345toPx0680j_4(Dp.m8823constructorimpl(20));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierA = x.a(ColumnScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            CropDefaults cropDefaults = CropDefaults.INSTANCE;
            CropStyle cropStyleM10194styleLTESvPY$default = CropDefaults.m10194styleLTESvPY$default(cropDefaults, false, false, 0.0f, 0L, 0L, 0L, 63, null);
            CropProperties cropPropertiesM10195properties7YnJbbk = cropDefaults.m10195properties7YnJbbk((15341 & 1) != 0 ? CropType.Dynamic : null, fMo1345toPx0680j_4, (15341 & 4) != 0 ? 10.0f : 0.0f, (15341 & 8) != 0 ? ContentScale.INSTANCE.getFit() : null, new CropOutlineProperty(OutlineType.Rect, new RectCropShape(0, "Rect")), (15341 & 32) != 0 ? AspectRatiosKt.getAspectRatios().get(2).getAspectRatio() : null, (15341 & 64) != 0 ? 0.9f : 0.0f, (15341 & 128) != 0, (15341 & 256) != 0 ? false : false, (15341 & 512) != 0, (15341 & 1024) != 0 ? false : false, (15341 & 2048) != 0 ? false : false, (15341 & 4096) != 0 ? null : null, (15341 & 8192) != 0 ? null : null);
            boolean zCropper$lambda$13$lambda$2 = Cropper$lambda$13$lambda$2(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new a() { // from class: f9.f
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            a aVar2 = (a) objRememberedValue2;
            boolean z10 = (i11 & 112) == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: f9.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CropperKt.Cropper$lambda$13$lambda$12$lambda$7$lambda$6(onCropSuccess, mutableState, (ImageBitmap) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            int i12 = i11;
            ImageCropperKt.m10151ImageCropper7Wsh9oA(modifierA, imageBitmap, "Image Cropper", cropStyleM10194styleLTESvPY$default, cropPropertiesM10195properties7YnJbbk, 0, zCropper$lambda$13$lambda$2, 0L, aVar2, (Function1) objRememberedValue3, null, composerStartRestartGroup, ((i11 << 3) & 112) | 100663680, 0, 1184);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new a() { // from class: f9.h
                    @Override // lb.a
                    public final Object invoke() {
                        return CropperKt.Cropper$lambda$13$lambda$12$lambda$9$lambda$8(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            aVar = onCancel;
            CropperBottomBarKt.CropperBottomBar((a) objRememberedValue4, aVar, composerStartRestartGroup, ((i12 >> 3) & 112) | 6);
            boolean z11 = (i12 & 896) == 256;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new a() { // from class: f9.i
                    @Override // lb.a
                    public final Object invoke() {
                        return CropperKt.Cropper$lambda$13$lambda$12$lambda$11$lambda$10(aVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            BackHandlerKt.BackHandler(false, (a) objRememberedValue5, composerStartRestartGroup, 0, 1);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            aVar = onCancel;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: f9.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CropperKt.Cropper$lambda$14(imageBitmap, onCropSuccess, aVar, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Cropper$lambda$13$lambda$12$lambda$11$lambda$10(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Cropper$lambda$13$lambda$12$lambda$7$lambda$6(Function1 function1, MutableState mutableState, ImageBitmap it) {
        y.i(it, "it");
        function1.invoke(it);
        Cropper$lambda$13$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Cropper$lambda$13$lambda$12$lambda$9$lambda$8(MutableState mutableState) {
        Cropper$lambda$13$lambda$3(mutableState, true);
        return k0.f43947a;
    }

    private static final boolean Cropper$lambda$13$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Cropper$lambda$13$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Cropper$lambda$14(ImageBitmap imageBitmap, Function1 function1, a aVar, int i10, Composer composer, int i11) {
        Cropper(imageBitmap, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
