package cu.todus.android.uiCompose.main.screen.updateRequired;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.SystemUpdateKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.location.LocationRequestCompat;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.utils.UpdateInfo;
import cu.todus.android.utils.versionupdate.DownloadState;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f²\u0006\f\u0010\u000e\u001a\u00020\r8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/updateRequired/UpdateViewModel;", "viewModel", "Lcu/todus/android/utils/UpdateInfo;", "updateInfo", "Lkotlin/Function2;", "", "", "Lua/k0;", "onUpdate", "Lkotlin/Function0;", "onDismiss", "UpdateDialog", "(Lcu/todus/android/uiCompose/main/screen/updateRequired/UpdateViewModel;Lcu/todus/android/utils/UpdateInfo;Lkotlin/jvm/functions/Function2;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lcu/todus/android/utils/versionupdate/DownloadState;", "downloadState", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UpdateDialogKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void UpdateDialog(final UpdateViewModel viewModel, final UpdateInfo updateInfo, final Function2 onUpdate, final lb.a onDismiss, Composer composer, final int i10) {
        int i11;
        y.i(viewModel, "viewModel");
        y.i(updateInfo, "updateInfo");
        y.i(onUpdate, "onUpdate");
        y.i(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(1227818763);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(updateInfo) ? 32 : 16;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1043) != 1042, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1227818763, i11, -1, "cu.todus.android.uiCompose.main.screen.updateRequired.UpdateDialog (UpdateDialog.kt:35)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(viewModel.getDownloadState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            int i12 = i11;
            final long remoteVersionCode = updateInfo.getRemoteVersionCode();
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(viewModel) | composerStartRestartGroup.changed(remoteVersionCode);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new UpdateDialogKt$UpdateDialog$1$1(viewModel, remoteVersionCode, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue, composerStartRestartGroup, 6);
            AndroidDialog_androidKt.Dialog(onDismiss, new DialogProperties(true, false, false, 4, (p) null), ComposableLambdaKt.rememberComposableLambda(1164935778, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpdateDialogKt.UpdateDialog$lambda$2(updateInfo, viewModel, onDismiss, remoteVersionCode, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 9) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpdateDialogKt.UpdateDialog$lambda$3(viewModel, updateInfo, onUpdate, onDismiss, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final DownloadState UpdateDialog$lambda$0(State<? extends DownloadState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 UpdateDialog$lambda$2(final UpdateInfo updateInfo, final UpdateViewModel updateViewModel, final lb.a aVar, final long j10, State state, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164935778, i10, -1, "cu.todus.android.uiCompose.main.screen.updateRequired.UpdateDialog.<anonymous> (UpdateDialog.kt:47)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierFillMaxWidth$default, materialTheme.getColorScheme(composer, i11).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(20)));
            float f10 = 24;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifierM1204backgroundbw27NRU, Dp.m8823constructorimpl(f10));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(56)), SystemUpdateKt.getSystemUpdate(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer, i11).getPrimary(), 0, 2, null), null, DiscoverItems.Item.UPDATE_ACTION, 0, null, null, composer, 196614, 468);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(16)), composer, 6);
            TextStyle titleMedium = materialTheme.getTypography(composer, i11).getTitleMedium();
            FontWeight bold = FontWeight.INSTANCE.getBold();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Nueva actualización disponible", TextStyle.m8271copyp1EtxEg$default(titleMedium, 0L, 0L, bold, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null), 0L, 0, 0, composer, 48, 57);
            float f11 = 8;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Versión " + updateInfo.getRemoteVersionName() + " ya está disponible.\nTu versión actual es 2.1.2.", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodySmall(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getOnBackground(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Actualiza para obtener las últimas mejoras y correcciones.", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodySmall(), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer, i11).getOnBackground(), 0.55f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), 0L, 0, 0, composer, 48, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            final DownloadState downloadStateUpdateDialog$lambda$0 = UpdateDialog$lambda$0(state);
            if (downloadStateUpdateDialog$lambda$0 instanceof DownloadState.Progress) {
                composer.startReplaceGroup(1774268677);
                Alignment.Horizontal centerHorizontally2 = companion2.getCenterHorizontally();
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally2, composer, 48);
                int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
                lb.a constructor2 = companion3.getConstructor();
                if (!r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                boolean zChanged = composer.changed(downloadStateUpdateDialog$lambda$0);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.f
                        @Override // lb.a
                        public final Object invoke() {
                            return Float.valueOf(UpdateDialogKt.UpdateDialog$lambda$2$0$0$0$0(downloadStateUpdateDialog$lambda$0));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ProgressIndicatorKt.m3508CircularProgressIndicatorIyT6zlY((lb.a) objRememberedValue, SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(40)), 0L, 0.0f, 0L, 0, 0.0f, composer, 48, 124);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
                DownloadState.Progress progress = (DownloadState.Progress) downloadStateUpdateDialog$lambda$0;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, progress.getPercent() + "% (" + progress.getCurrentMb() + " / " + progress.getTotalMb() + " MB)", materialTheme.getTypography(composer, i11).getBodySmall(), 0L, 0, 0, composer, 0, 57);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl((float) 12)), composer, 6);
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                boolean zChangedInstance = composer.changedInstance(updateViewModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.g
                        @Override // lb.a
                        public final Object invoke() {
                            return UpdateDialogKt.UpdateDialog$lambda$2$0$0$1$0(updateViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Z17ButtonsKt.Z17SecondaryDialogButton(modifierFillMaxWidth$default3, (lb.a) objRememberedValue2, "Cancelar descarga", null, true, false, false, composer, 24966, LocationRequestCompat.QUALITY_LOW_POWER);
                composer.endNode();
                composer.endReplaceGroup();
            } else if (downloadStateUpdateDialog$lambda$0 instanceof DownloadState.Success) {
                composer.startReplaceGroup(1775373486);
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                boolean zChangedInstance2 = composer.changedInstance(updateViewModel) | composer.changed(aVar);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.h
                        @Override // lb.a
                        public final Object invoke() {
                            return UpdateDialogKt.UpdateDialog$lambda$2$0$1$0(updateViewModel, aVar);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default4, (lb.a) objRememberedValue3, "Instalar ahora", null, true, false, composer, 24966, 40);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
                Z17ButtonsKt.Z17SecondaryDialogButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), aVar, "Más tarde", null, true, false, false, composer, 24966, LocationRequestCompat.QUALITY_LOW_POWER);
                composer.endReplaceGroup();
            } else if (downloadStateUpdateDialog$lambda$0 instanceof DownloadState.Error) {
                composer.startReplaceGroup(1776123469);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, "Error en la descarga", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodySmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), materialTheme.getColorScheme(composer, i11).getError(), 0, 0, composer, 48, 49);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(12)), composer, 6);
                Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                boolean zChangedInstance3 = composer.changedInstance(updateViewModel) | composer.changed(updateInfo) | composer.changed(j10);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.i
                        @Override // lb.a
                        public final Object invoke() {
                            return UpdateDialogKt.UpdateDialog$lambda$2$0$2$0(updateViewModel, updateInfo, j10);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default5, (lb.a) objRememberedValue4, "Reintentar", null, true, false, composer, 24966, 40);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
                Z17ButtonsKt.Z17SecondaryDialogButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), aVar, "Más tarde", null, true, false, false, composer, 24966, LocationRequestCompat.QUALITY_LOW_POWER);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1777214173);
                Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                boolean zChangedInstance4 = composer.changedInstance(updateViewModel) | composer.changed(updateInfo) | composer.changed(j10);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.updateRequired.j
                        @Override // lb.a
                        public final Object invoke() {
                            return UpdateDialogKt.UpdateDialog$lambda$2$0$3$0(updateViewModel, updateInfo, j10);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Z17ButtonsKt.Z17PrimaryButton(modifierFillMaxWidth$default6, (lb.a) objRememberedValue5, "Actualizar ahora", null, true, false, composer, 24966, 40);
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composer, 6);
                Z17ButtonsKt.Z17SecondaryDialogButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), aVar, "Más tarde", null, true, false, false, composer, 24966, LocationRequestCompat.QUALITY_LOW_POWER);
                composer.endReplaceGroup();
            }
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float UpdateDialog$lambda$2$0$0$0$0(DownloadState downloadState) {
        return ((DownloadState.Progress) downloadState).getPercent() / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateDialog$lambda$2$0$0$1$0(UpdateViewModel updateViewModel) {
        updateViewModel.cancelDownload();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateDialog$lambda$2$0$1$0(UpdateViewModel updateViewModel, lb.a aVar) {
        updateViewModel.installApk();
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateDialog$lambda$2$0$2$0(UpdateViewModel updateViewModel, UpdateInfo updateInfo, long j10) {
        updateViewModel.startDownload(updateInfo.getApkUrl(), j10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateDialog$lambda$2$0$3$0(UpdateViewModel updateViewModel, UpdateInfo updateInfo, long j10) {
        updateViewModel.startDownloadIfNeeded(updateInfo.getApkUrl(), j10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 UpdateDialog$lambda$3(UpdateViewModel updateViewModel, UpdateInfo updateInfo, Function2 function2, lb.a aVar, int i10, Composer composer, int i11) {
        UpdateDialog(updateViewModel, updateInfo, function2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
