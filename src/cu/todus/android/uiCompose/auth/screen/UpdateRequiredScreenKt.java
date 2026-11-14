package cu.todus.android.uiCompose.auth.screen;

import ab.i;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.BlockKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.uiCompose.main.screen.updateRequired.UpdateViewModel;
import cu.todus.android.utils.UpdateInfo;
import cu.todus.android.utils.versionupdate.DownloadState;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\f\u0010\n\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/updateRequired/UpdateViewModel;", "viewModel", "Lcu/todus/android/utils/UpdateInfo;", "updateInfo", "Lkotlin/Function0;", "Lua/k0;", "onRetry", "UpdateRequiredScreen", "(Lcu/todus/android/uiCompose/main/screen/updateRequired/UpdateViewModel;Lcu/todus/android/utils/UpdateInfo;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/utils/versionupdate/DownloadState;", "downloadState", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UpdateRequiredScreenKt {
    /* JADX WARN: Code duplicated, block: B:123:0x0667  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void UpdateRequiredScreen(UpdateViewModel viewModel, final UpdateInfo updateInfo, lb.a onRetry, Composer composer, final int i10) {
        int i11;
        final UpdateViewModel updateViewModel;
        Composer composer2;
        final lb.a aVar;
        State state;
        final long j10;
        int i12;
        final UpdateViewModel updateViewModel2;
        y.i(viewModel, "viewModel");
        y.i(onRetry, "onRetry");
        Composer composerStartRestartGroup = composer.startRestartGroup(1404038788);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(updateInfo) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onRetry) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404038788, i11, -1, "cu.todus.android.uiCompose.auth.screen.UpdateRequiredScreen (UpdateRequiredScreen.kt:35)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(viewModel.getDownloadState(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            String apkUrl = updateInfo != null ? updateInfo.getApkUrl() : null;
            if (apkUrl == null) {
                apkUrl = "";
            }
            boolean zQ0 = d0.q0(apkUrl);
            long remoteVersionCode = updateInfo != null ? updateInfo.getRemoteVersionCode() : 0L;
            boolean zChanged = ((i11 & 112) == 32) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(viewModel) | composerStartRestartGroup.changed(remoteVersionCode);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                state = stateCollectAsStateWithLifecycle;
                j10 = remoteVersionCode;
                i12 = 0;
                objRememberedValue = new UpdateRequiredScreenKt$UpdateRequiredScreen$1$1(updateInfo, viewModel, j10, state, null);
                updateViewModel2 = viewModel;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                updateViewModel2 = viewModel;
                state = stateCollectAsStateWithLifecycle;
                j10 = remoteVersionCode;
                i12 = 0;
            }
            int i13 = i11 >> 3;
            EffectsKt.LaunchedEffect(updateInfo, (Function2) objRememberedValue, composerStartRestartGroup, i13 & 14);
            DownloadState downloadStateUpdateRequiredScreen$lambda$0 = UpdateRequiredScreen$lambda$0(state);
            boolean zChanged2 = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(updateViewModel2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new UpdateRequiredScreenKt$UpdateRequiredScreen$2$1(updateViewModel2, state, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(downloadStateUpdateRequiredScreen$lambda$0, (Function2) objRememberedValue2, composerStartRestartGroup, i12);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.a
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            BackHandlerKt.BackHandler(r4, (lb.a) objRememberedValue3, composerStartRestartGroup, 54, i12);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            float f10 = 24;
            Modifier modifierSystemBarsPadding = WindowInsetsPadding_androidKt.systemBarsPadding(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme.getColorScheme(composerStartRestartGroup, i14).getBackground(), null, 2, null), Dp.m8823constructorimpl(f10)));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            State state2 = state;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), centerHorizontally, composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSystemBarsPadding);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            final String str = apkUrl;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(80)), BlockKt.getBlock(Icons.INSTANCE.getDefault()), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i14).getError(), 0, 2, null), null, "blocked", 0, null, null, composerStartRestartGroup, 196614, 468);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            TextStyle headlineSmall = materialTheme.getTypography(composerStartRestartGroup, i14).getHeadlineSmall();
            FontWeight.Companion companion5 = FontWeight.INSTANCE;
            FontWeight bold = companion5.getBold();
            TextAlign.Companion companion6 = TextAlign.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Actualización obligatoria", TextStyle.m8271copyp1EtxEg$default(headlineSmall, 0L, 0L, bold, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion6.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null), 0L, 0, 0, composerStartRestartGroup, 48, 57);
            float f11 = 12;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, !zQ0 ? "Tu versión (2.1.2) ya no es compatible.\nDebes actualizar para poder usar la aplicación." : "Tu versión (2.1.2) no es válida.\nContacta con soporte o reintenta la verificación.", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion6.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(32)), composer2, 6);
            final DownloadState downloadStateUpdateRequiredScreen$lambda$1 = UpdateRequiredScreen$lambda$0(state2);
            if (downloadStateUpdateRequiredScreen$lambda$1 instanceof DownloadState.Progress) {
                composer2.startReplaceGroup(-487869888);
                Alignment.Horizontal centerHorizontally2 = companion3.getCenterHorizontally();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally2, composer2, 48);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                lb.a constructor2 = companion4.getConstructor();
                if (!r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                boolean zChanged3 = composer2.changed(downloadStateUpdateRequiredScreen$lambda$1);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.b
                        @Override // lb.a
                        public final Object invoke() {
                            return Float.valueOf(UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$4$0$0$0(downloadStateUpdateRequiredScreen$lambda$1));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ProgressIndicatorKt.m3508CircularProgressIndicatorIyT6zlY((lb.a) objRememberedValue4, SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(48)), 0L, 0.0f, 0L, 0, 0.0f, composer2, 48, 124);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composer2, 6);
                DownloadState.Progress progress = (DownloadState.Progress) downloadStateUpdateRequiredScreen$lambda$1;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, progress.getPercent() + "% (" + progress.getCurrentMb() + " MB / " + progress.getTotalMb() + " MB)", materialTheme.getTypography(composer2, i14).getBodyMedium(), 0L, 0, 0, composer2, 0, 57);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl((float) 16)), composer2, 6);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                boolean zChangedInstance = composer2.changedInstance(updateViewModel2);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.c
                        @Override // lb.a
                        public final Object invoke() {
                            return UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$4$0$1$0(updateViewModel2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Z17ButtonsKt.Z17SecondaryButton(modifierFillMaxWidth$default2, (lb.a) objRememberedValue5, "Cancelar descarga", null, true, false, composer2, 24966, 40);
                composer2 = composer2;
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                if (downloadStateUpdateRequiredScreen$lambda$1 instanceof DownloadState.Success) {
                    composer2.startReplaceGroup(-486853119);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, "✓ Descarga completada", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer2, i14).getBodyLarge(), materialTheme.getColorScheme(composer2, i14).getPrimary(), 0L, companion5.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), 0L, 0, 0, composer2, 48, 57);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(16)), composer2, 6);
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    boolean zChangedInstance2 = composer2.changedInstance(updateViewModel2);
                    Object objRememberedValue6 = composer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.d
                            @Override // lb.a
                            public final Object invoke() {
                                return UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$4$1$0(updateViewModel2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default3, (lb.a) objRememberedValue6, "Instalar ahora", null, true, false, composer2, 24966, 40);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                } else if (downloadStateUpdateRequiredScreen$lambda$1 instanceof DownloadState.Error) {
                    composer2.startReplaceGroup(-486182496);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, "✗ Error en la descarga", materialTheme.getTypography(composer2, i14).getBodyMedium(), materialTheme.getColorScheme(composer2, i14).getError(), 0, 0, composer2, 48, 49);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(16)), composer2, 6);
                    Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    boolean zChangedInstance3 = composer2.changedInstance(updateViewModel2) | composer2.changed(str) | composer2.changed(j10);
                    Object objRememberedValue7 = composer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.e
                            @Override // lb.a
                            public final Object invoke() {
                                return UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$4$2$0(updateViewModel2, str, j10);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default4, (lb.a) objRememberedValue7, "Reintentar descarga", null, true, false, composer2, 24966, 40);
                    composer2 = composer2;
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composer2, 6);
                    updateViewModel = updateViewModel2;
                    aVar = onRetry;
                    Z17ButtonsKt.Z17SecondaryButton(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), aVar, "Verificar de nuevo", null, true, false, composer2, (i13 & 112) | 24966, 40);
                    composer2.endReplaceGroup();
                } else {
                    final UpdateViewModel updateViewModel3 = updateViewModel2;
                    composer2.startReplaceGroup(-485257921);
                    if (zQ0) {
                        composer2.startReplaceGroup(-484800268);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-485228874);
                        Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                        boolean zChangedInstance4 = composer2.changedInstance(updateViewModel3) | composer2.changed(str) | composer2.changed(j10);
                        Object objRememberedValue8 = composer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.auth.screen.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$4$3$0(updateViewModel3, str, j10);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default5, (lb.a) objRememberedValue8, "Descargar actualización", null, true, false, composer2, 24966, 40);
                        composer2 = composer2;
                        SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f11)), composer2, 6);
                        composer2.endReplaceGroup();
                    }
                    updateViewModel = viewModel;
                    aVar = onRetry;
                    Z17ButtonsKt.Z17SecondaryButton(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), aVar, "Reintentar", null, true, false, composer2, (i13 & 112) | 24966, 40);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            updateViewModel = updateViewModel2;
            aVar = onRetry;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            updateInfo = updateInfo;
            updateViewModel = viewModel;
            composer2 = composerStartRestartGroup;
            aVar = onRetry;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.auth.screen.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpdateRequiredScreenKt.UpdateRequiredScreen$lambda$5(updateViewModel, updateInfo, aVar, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadState UpdateRequiredScreen$lambda$0(State<? extends DownloadState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float UpdateRequiredScreen$lambda$4$0$0$0(DownloadState downloadState) {
        return ((DownloadState.Progress) downloadState).getPercent() / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateRequiredScreen$lambda$4$0$1$0(UpdateViewModel updateViewModel) {
        updateViewModel.cancelDownload();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateRequiredScreen$lambda$4$1$0(UpdateViewModel updateViewModel) {
        updateViewModel.installApk();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateRequiredScreen$lambda$4$2$0(UpdateViewModel updateViewModel, String str, long j10) {
        updateViewModel.startDownload(str, j10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateRequiredScreen$lambda$4$3$0(UpdateViewModel updateViewModel, String str, long j10) {
        updateViewModel.startDownload(str, j10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateRequiredScreen$lambda$5(UpdateViewModel updateViewModel, UpdateInfo updateInfo, lb.a aVar, int i10, Composer composer, int i11) {
        UpdateRequiredScreen(updateViewModel, updateInfo, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
