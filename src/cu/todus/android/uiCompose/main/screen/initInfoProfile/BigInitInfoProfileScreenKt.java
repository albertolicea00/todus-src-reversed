package cu.todus.android.uiCompose.main.screen.initInfoProfile;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\n²\u0006\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\nX\u008a\u0084\u0002²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/initInfoProfile/InitInfoProfileViewModel;", "viewModel", "Lua/k0;", "BigInitInfoProfileScreen", "(Lcu/todus/android/uiCompose/main/screen/initInfoProfile/InitInfoProfileViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/preferences/Owner;", "infoProfileState", "", "openCamera", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigInitInfoProfileScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BigInitInfoProfileScreen(InitInfoProfileViewModel initInfoProfileViewModel, Composer composer, final int i10, final int i11) {
        final InitInfoProfileViewModel initInfoProfileViewModel2;
        int i12;
        final InitInfoProfileViewModel initInfoProfileViewModel3;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(512009267);
        if ((i10 & 6) == 0) {
            if ((i11 & 1) == 0) {
                initInfoProfileViewModel2 = initInfoProfileViewModel;
                if (composerStartRestartGroup.changedInstance(initInfoProfileViewModel2)) {
                    i13 = 4;
                }
                i12 = i13 | i10;
            } else {
                initInfoProfileViewModel2 = initInfoProfileViewModel;
            }
            i13 = 2;
            i12 = i13 | i10;
        } else {
            initInfoProfileViewModel2 = initInfoProfileViewModel;
            i12 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 3) != 2, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 1) != 0) {
                    i12 &= -15;
                }
            } else if ((i11 & 1) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                initInfoProfileViewModel2 = (InitInfoProfileViewModel) ViewModelKt.viewModel(z0.b(InitInfoProfileViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(512009267, i12, -1, "cu.todus.android.uiCompose.main.screen.initInfoProfile.BigInitInfoProfileScreen (BigInitInfoProfileScreen.kt:57)");
            }
            initInfoProfileViewModel3 = initInfoProfileViewModel2;
            SurfaceKt.m3707SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-217628424, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0(initInfoProfileViewModel2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            initInfoProfileViewModel3 = initInfoProfileViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$1(initInfoProfileViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BigInitInfoProfileScreen$lambda$0(final InitInfoProfileViewModel initInfoProfileViewModel, Composer composer, int i10) {
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        Composer composer2 = composer;
        if (composer2.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-217628424, i10, -1, "cu.todus.android.uiCompose.main.screen.initInfoProfile.BigInitInfoProfileScreen.<anonymous> (BigInitInfoProfileScreen.kt:61)");
            }
            int i11 = ((Configuration) composer2.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(initInfoProfileViewModel.getOwner(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer2, 48, 14);
            final c1.a aVarC = c1.d.c(Build.VERSION.SDK_INT >= 33 ? va.w.q("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES") : va.w.q("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"), null, composer2, 0, 2);
            final FocusManager focusManager = (FocusManager) composer2.consume(CompositionLocalsKt.getLocalFocusManager());
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue2;
            Owner ownerBigInitInfoProfileScreen$lambda$0$0 = BigInitInfoProfileScreen$lambda$0$0(stateCollectAsStateWithLifecycle);
            if (ownerBigInitInfoProfileScreen$lambda$0$0 == null) {
                composer2.startReplaceGroup(2033234103);
                composer2.endReplaceGroup();
                mutableState3 = mutableState6;
            } else {
                composer2.startReplaceGroup(2033234104);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ownerBigInitInfoProfileScreen$lambda$0$0.getAlias(), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState7 = (MutableState) objRememberedValue3;
                Object objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState8 = (MutableState) objRememberedValue4;
                Object objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ownerBigInitInfoProfileScreen$lambda$0$0.getPhotoUrl(), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState9 = (MutableState) objRememberedValue5;
                int i12 = R.drawable.trama_bg;
                ContentScale crop = ContentScale.INSTANCE.getCrop();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Integer.valueOf(i12), null, null, crop, null, 0, null, null, composer2, 24582, 492);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getSpaceBetween(), centerHorizontally, composer2, 54);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierVerticalScroll$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion4.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                Modifier modifierA = androidx.compose.foundation.layout.x.a(ColumnScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierA);
                lb.a constructor2 = companion4.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Object value = mutableState9.getValue();
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(150));
                float fM8823constructorimpl = Dp.m8823constructorimpl(4);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierBorder = BorderKt.border(modifierM1769size3ABfNKs, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl, materialTheme.getColorScheme(composer2, i13).getBackground()), RoundedCornerShapeKt.getCircleShape());
                boolean zChangedInstance = composer2.changedInstance(focusManager) | composer2.changed(aVarC);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == companion.getEmpty()) {
                    mutableState = mutableState5;
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.g
                        @Override // lb.a
                        public final Object invoke() {
                            return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$3$0$0$0(focusManager, aVarC, mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    mutableState = mutableState5;
                }
                MutableState mutableState10 = mutableState;
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierBorder, false, null, null, null, (lb.a) objRememberedValue6, 15, null), value, Integer.valueOf(R.drawable.profile), null, null, 0, null, true, null, null, false, 0, composer, 12582912, 0, 3960);
                composer.endNode();
                float f10 = 40;
                float f11 = 20;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1755height3ABfNKs(SizeKt.m1775widthInVpY3zN4(companion2, Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(600)), Dp.m8823constructorimpl(i11 - (i11 / 3))), materialTheme.getColorScheme(composer, i13).getBackground(), RoundedCornerShapeKt.m2017RoundedCornerShapea9UjIt4$default(Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 12, null)), Dp.m8823constructorimpl(f11));
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getSpaceBetween(), companion3.getStart(), composer, 6);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
                lb.a constructor3 = companion4.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getCenterHorizontally(), composer, 48);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion2);
                lb.a constructor4 = companion4.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
                Z17LabelKt.m10262Z17LabelfWhpE4E(WindowInsetsPadding_androidKt.safeContentPadding(companion2), StringResources_androidKt.stringResource(R.string.profile, composer, 0), materialTheme.getTypography(composer, i13).getTitleLarge(), 0L, 0, 0, composer, 0, 56);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1728paddingqDBjuR0(companion2, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11)), StringResources_androidKt.stringResource(R.string.profile_initialize, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i13).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), 0L, 0, 0, composer, 6, 56);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                int iM8505getTextPjHm6EE = KeyboardType.INSTANCE.m8505getTextPjHm6EE();
                String str = (String) mutableState8.getValue();
                String str2 = (String) mutableState7.getValue();
                String strStringResource = StringResources_androidKt.stringResource(R.string.put_name_here, composer, 0);
                Object objRememberedValue7 = composer.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    mutableState2 = mutableState7;
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$3$1$0$0$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                } else {
                    mutableState2 = mutableState7;
                }
                final MutableState mutableState11 = mutableState2;
                Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierFillMaxWidth$default, str2, 0, 0, strStringResource, str, (Function1) objRememberedValue7, null, null, 50, iM8505getTextPjHm6EE, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879238, 6, 1046924);
                composer2 = composer;
                composer2.endNode();
                boolean z10 = d0.q1((String) mutableState11.getValue()).toString().length() > 0;
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.next, composer2, 0);
                boolean zChangedInstance2 = composer2.changedInstance(initInfoProfileViewModel);
                Object objRememberedValue8 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue8 == companion.getEmpty()) {
                    mutableState3 = mutableState6;
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.i
                        @Override // lb.a
                        public final Object invoke() {
                            return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$3$1$1$0(mutableState11, initInfoProfileViewModel, mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                } else {
                    mutableState3 = mutableState6;
                }
                Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue8, strStringResource2, null, true, z10, composer2, 24576, 9);
                composer2.endNode();
                composer2.endNode();
                if (BigInitInfoProfileScreen$lambda$0$2(mutableState10)) {
                    composer2.startReplaceGroup(1314511043);
                    Object objRememberedValue9 = composer2.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        mutableState4 = mutableState10;
                        objRememberedValue9 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.j
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$4$0(mutableState4, (List) obj, (String) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        mutableState4 = mutableState10;
                    }
                    Function2 function2 = (Function2) objRememberedValue9;
                    boolean zChangedInstance3 = composer2.changedInstance(initInfoProfileViewModel);
                    Object objRememberedValue10 = composer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue10 == companion.getEmpty()) {
                        objRememberedValue10 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$5$0(mutableState4, mutableState9, initInfoProfileViewModel, mutableState3, (List) obj, (String) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    Function2 function3 = (Function2) objRememberedValue10;
                    Object objRememberedValue11 = composer2.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.b
                            @Override // lb.a
                            public final Object invoke() {
                                return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$6$0(mutableState4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar = (lb.a) objRememberedValue11;
                    Object objRememberedValue12 = composer2.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.f
                            @Override // lb.a
                            public final Object invoke() {
                                return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$7$0(mutableState4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue12);
                    }
                    CameraKt.Camera(null, null, false, false, false, false, 0L, function2, function3, null, aVar, (lb.a) objRememberedValue12, composer2, 12586368, 54, 627);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1315396124);
                    composer2.endReplaceGroup();
                }
                k0 k0Var = k0.f43947a;
                composer2.endReplaceGroup();
            }
            if (BigInitInfoProfileScreen$lambda$0$5(mutableState3)) {
                composer2.startReplaceGroup(1312683589);
                LoadingScreenKt.LoadingWall(composer2, 0);
            } else {
                composer2.startReplaceGroup(2038498090);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final Owner BigInitInfoProfileScreen$lambda$0$0(State<Owner> state) {
        return state.getValue();
    }

    private static final boolean BigInitInfoProfileScreen$lambda$0$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigInitInfoProfileScreen$lambda$0$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean BigInitInfoProfileScreen$lambda$0$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BigInitInfoProfileScreen$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$3$0$0$0(FocusManager focusManager, c1.a aVar, MutableState mutableState) {
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        if (aVar.a()) {
            BigInitInfoProfileScreen$lambda$0$3(mutableState, true);
        } else {
            aVar.b();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$3$1$0$0$0(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$3$1$1$0(MutableState mutableState, InitInfoProfileViewModel initInfoProfileViewModel, final MutableState mutableState2) {
        if (d0.q1((String) mutableState.getValue()).toString().length() > 0) {
            BigInitInfoProfileScreen$lambda$0$6(mutableState2, true);
            initInfoProfileViewModel.updateDisplayName((String) mutableState.getValue(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.a
                @Override // lb.a
                public final Object invoke() {
                    return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$3$1$1$0$0(mutableState2);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$3$1$1$0$0(MutableState mutableState) {
        BigInitInfoProfileScreen$lambda$0$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$4$0(MutableState mutableState, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        BigInitInfoProfileScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$5$0(MutableState mutableState, MutableState mutableState2, InitInfoProfileViewModel initInfoProfileViewModel, final MutableState mutableState3, List files, String content) {
        Uri uriFromFile;
        y.i(files, "files");
        y.i(content, "content");
        BigInitInfoProfileScreen$lambda$0$3(mutableState, false);
        File file = (File) g0.y0(files);
        if (file != null && (uriFromFile = Uri.fromFile(file)) != null) {
            BigInitInfoProfileScreen$lambda$0$6(mutableState3, true);
            mutableState2.setValue(uriFromFile);
            initInfoProfileViewModel.updateProfilePicture(uriFromFile, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.c
                @Override // lb.a
                public final Object invoke() {
                    return BigInitInfoProfileScreenKt.BigInitInfoProfileScreen$lambda$0$7$5$0$0$0(mutableState3);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$5$0$0$0(MutableState mutableState) {
        BigInitInfoProfileScreen$lambda$0$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$6$0(MutableState mutableState) {
        BigInitInfoProfileScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$0$7$7$0(MutableState mutableState) {
        BigInitInfoProfileScreen$lambda$0$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigInitInfoProfileScreen$lambda$1(InitInfoProfileViewModel initInfoProfileViewModel, int i10, int i11, Composer composer, int i12) {
        BigInitInfoProfileScreen(initInfoProfileViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
