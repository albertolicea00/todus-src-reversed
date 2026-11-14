package cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupAdminsParams;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.PreviewGroupViewModel;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.SelfMembershipKt;
import cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreenKt;
import cu.z17.views.check.Z17CheckKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000e²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;", "viewModel", "Lua/k0;", "PreviewGroupAdminsScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewGroup/PreviewGroupViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "isAdmin", "deleteDialogOpen", UserRoomJoin.COLUMN_AFFILIATION, "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewGroupAdminsScreenKt {
    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:64:0x010a  */
    /* JADX WARN: Code duplicated, block: B:67:0x011f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0148  */
    /* JADX WARN: Code duplicated, block: B:73:0x015d  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewGroupAdminsScreen(final NavHostController navHostController, final String params, PreviewGroupViewModel previewGroupViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        PreviewGroupViewModel previewGroupViewModel2;
        Composer composer2;
        final PreviewGroupViewModel previewGroupViewModel3;
        boolean z10;
        Composer composer3;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        final PreviewGroupAdminsParams previewGroupAdminsParams;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(1903796751);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                previewGroupViewModel2 = previewGroupViewModel;
                int i14 = composerStartRestartGroup.changedInstance(previewGroupViewModel2) ? 256 : 128;
                i12 |= i14;
            } else {
                previewGroupViewModel2 = previewGroupViewModel;
            }
            i12 |= i14;
        } else {
            previewGroupViewModel2 = previewGroupViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    z10 = 1;
                    composer3 = composerStartRestartGroup;
                    previewGroupViewModel2 = (PreviewGroupViewModel) ViewModelKt.viewModel(z0.b(PreviewGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                PreviewGroupViewModel previewGroupViewModel4 = previewGroupViewModel2;
                i13 = i12;
                previewGroupViewModel3 = previewGroupViewModel4;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1903796751, i13, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreen (PreviewGroupAdminsScreen.kt:48)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer3, 0, 3);
                final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, z10);
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (PreviewGroupAdminsParams) previewGroupViewModel3.getGson().j(params, PreviewGroupAdminsParams.class);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                previewGroupAdminsParams = (PreviewGroupAdminsParams) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(y.d(previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getAffiliation(), "admin")), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getAffiliation(), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue5;
                Composer composer4 = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1371287973, z10, new Function3() { // from class: x7.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$13(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-845771239, z10, new Function3() { // from class: x7.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14(scrollStateRememberScrollState, previewGroupAdminsParams, previewGroupViewModel3, navHostController, mutableState4, mutableState3, mutableState2, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer4, 805306806, 376);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            }
            composer3 = composerStartRestartGroup;
            z10 = 1;
            PreviewGroupViewModel previewGroupViewModel5 = previewGroupViewModel2;
            i13 = i12;
            previewGroupViewModel3 = previewGroupViewModel5;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1903796751, i13, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreen (PreviewGroupAdminsScreen.kt:48)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composer3, 0, 3);
            final ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composer3, 0, z10);
            objRememberedValue = composer3.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (PreviewGroupAdminsParams) previewGroupViewModel3.getGson().j(params, PreviewGroupAdminsParams.class);
                composer3.updateRememberedValue(objRememberedValue);
            }
            previewGroupAdminsParams = (PreviewGroupAdminsParams) objRememberedValue;
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(y.d(previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getAffiliation(), "admin")), null, 2, null);
                composer3.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getAffiliation(), null, 2, null);
                composer3.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue5;
            Composer composer5 = composer3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1371287973, z10, new Function3() { // from class: x7.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$13(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-845771239, z10, new Function3() { // from class: x7.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14(scrollStateRememberScrollState2, previewGroupAdminsParams, previewGroupViewModel3, navHostController, mutableState8, mutableState7, mutableState6, mutableState5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer5, 805306806, 376);
            composer2 = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            previewGroupViewModel3 = previewGroupViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: x7.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$15(navHostController, params, previewGroupViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String PreviewGroupAdminsScreen$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewGroupAdminsScreen$lambda$13(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1371287973, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreen.<anonymous> (PreviewGroupAdminsScreen.kt:78)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$PreviewGroupAdminsScreenKt.INSTANCE.m9919getLambda$1225641682$app_productionPFast(), it, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 2012);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewGroupAdminsScreen$lambda$14(ScrollState scrollState, final PreviewGroupAdminsParams previewGroupAdminsParams, final PreviewGroupViewModel previewGroupViewModel, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Modifier it, Composer composer, int i10) {
        int i11;
        final MutableState mutableState5;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-845771239, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreen.<anonymous> (PreviewGroupAdminsScreen.kt:90)");
            }
            float f10 = 20;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1727paddingVpY3zN4$default(it, Dp.m8823constructorimpl(f10), 0.0f, 2, null), scrollState, false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f11 = 10;
            SelfMembershipKt.GroupMembershipCard(PaddingKt.m1727paddingVpY3zN4$default(companion3, 0.0f, Dp.m8823constructorimpl(f11), 1, null), PreviewGroupAdminsScreen$lambda$11(mutableState), previewGroupAdminsParams.getGroupMember().getName(), previewGroupAdminsParams.getGroupMember().getPicture(), composer, 6);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, !y.d(PreviewGroupAdminsScreen$lambda$11(mutableState), "admin"), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1927693707, true, new Function3() { // from class: x7.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$0(mutableState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f10)), composer, 6);
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion3, 0.0f, Dp.m8823constructorimpl(8), 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composer, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1727paddingVpY3zN4$default);
            a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean zPreviewGroupAdminsScreen$lambda$5 = PreviewGroupAdminsScreen$lambda$5(mutableState3);
            boolean zChangedInstance = composer.changedInstance(previewGroupViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: x7.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$1$0$0(previewGroupViewModel, previewGroupAdminsParams, mutableState4, mutableState3, mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue = function1;
            }
            Z17CheckKt.Z17Check(null, zPreviewGroupAdminsScreen$lambda$5, (Function1) objRememberedValue, composer, 0, 1);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer, 6);
            Modifier modifierA = e3.a(rowScopeInstance, companion3, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composer, 0);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierA);
            a constructor3 = companion2.getConstructor();
            if (!r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            String strStringResource = StringResources_androidKt.stringResource(R.string.admin, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.group_admin_access_description, composer, 0), materialTheme.getTypography(composer, i12).getBodySmall(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(30)), composer, 6);
            composer.endNode();
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.expel, composer, 0);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.delete_user_from_group, new Object[]{previewGroupAdminsParams.getGroupMember().getName()}, composer, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.no, composer, 0);
            boolean zPreviewGroupAdminsScreen$lambda$8 = PreviewGroupAdminsScreen$lambda$8(mutableState2);
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue2 == companion4.getEmpty()) {
                mutableState5 = mutableState2;
                objRememberedValue2 = new a() { // from class: x7.n
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$1$0(mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState5 = mutableState2;
            }
            a aVar = (a) objRememberedValue2;
            boolean zChangedInstance2 = composer.changedInstance(previewGroupViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion4.getEmpty()) {
                a aVar2 = new a() { // from class: x7.o
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$2$0(previewGroupViewModel, previewGroupAdminsParams, mutableState4, navHostController, mutableState5);
                    }
                };
                composer.updateRememberedValue(aVar2);
                objRememberedValue3 = aVar2;
            }
            a aVar3 = (a) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new a() { // from class: x7.c
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$3$0(mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Z17DialogsKt.Z17DialogWithActionsCustom(zPreviewGroupAdminsScreen$lambda$8, aVar, aVar3, (a) objRememberedValue4, strStringResource2, strStringResource3, strStringResource4, strStringResource5, composer, 3120, 0);
            if (PreviewGroupAdminsScreen$lambda$2(mutableState4)) {
                composer.startReplaceGroup(-1037189850);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(-2088101783);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$0(final MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1927693707, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewGroup.adminRights.PreviewGroupAdminsScreen.<anonymous>.<anonymous>.<anonymous> (PreviewGroupAdminsScreen.kt:104)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: x7.k
                @Override // lb.a
                public final Object invoke() {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$0$0$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (a) objRememberedValue, 15, null), Dp.m8823constructorimpl(2));
        float fM8823constructorimpl = Dp.m8823constructorimpl(1);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(BorderKt.m1216borderxT4_qwU(modifierM1725padding3ABfNKs, fM8823constructorimpl, materialTheme.getColorScheme(composer, i11).getOnSurface(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), 0.0f, Dp.m8823constructorimpl(10), 1, null), StringResources_androidKt.stringResource(R.string.expel, composer, 0), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), materialTheme.getColorScheme(composer, i11).getOnBackground(), 0, 0, composer, 0, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$0$0$0(MutableState mutableState) {
        PreviewGroupAdminsScreen$lambda$9(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$1$0$0(PreviewGroupViewModel previewGroupViewModel, PreviewGroupAdminsParams previewGroupAdminsParams, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, boolean z10) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, true);
        if (z10) {
            previewGroupViewModel.promoteToGroupAdmin(previewGroupAdminsParams.getGroupId(), previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getUserId(), new a() { // from class: x7.b
                @Override // lb.a
                public final Object invoke() {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$1$0$0$0(mutableState, mutableState2, mutableState3);
                }
            }, new a() { // from class: x7.g
                @Override // lb.a
                public final Object invoke() {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$1$0$0$1(mutableState);
                }
            });
        } else {
            previewGroupViewModel.demoteFromGroupAdmin(previewGroupAdminsParams.getGroupId(), previewGroupAdminsParams.getGroupMember().getUserRoomJoin().getUserId(), new a() { // from class: x7.h
                @Override // lb.a
                public final Object invoke() {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$1$0$0$2(mutableState, mutableState2, mutableState3);
                }
            }, new a() { // from class: x7.i
                @Override // lb.a
                public final Object invoke() {
                    return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$0$1$0$0$3(mutableState);
                }
            });
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$1$0$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, false);
        PreviewGroupAdminsScreen$lambda$6(mutableState2, true);
        mutableState3.setValue("admin");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$1$0$0$1(MutableState mutableState) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$1$0$0$2(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, false);
        PreviewGroupAdminsScreen$lambda$6(mutableState2, false);
        mutableState3.setValue(UserRoomJoin.AFFILIATION_MEMBER);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$0$1$0$0$3(MutableState mutableState) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$1$0(MutableState mutableState) {
        PreviewGroupAdminsScreen$lambda$9(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$2$0(PreviewGroupViewModel previewGroupViewModel, PreviewGroupAdminsParams previewGroupAdminsParams, final MutableState mutableState, final NavHostController navHostController, final MutableState mutableState2) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, true);
        previewGroupViewModel.expelMember(previewGroupAdminsParams.getGroupId(), previewGroupAdminsParams.getGroupMember().getId(), new a() { // from class: x7.j
            @Override // lb.a
            public final Object invoke() {
                return PreviewGroupAdminsScreenKt.PreviewGroupAdminsScreen$lambda$14$2$0$0(navHostController, mutableState, mutableState2);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$2$0$0(NavHostController navHostController, MutableState mutableState, MutableState mutableState2) {
        PreviewGroupAdminsScreen$lambda$3(mutableState, false);
        PreviewGroupAdminsScreen$lambda$9(mutableState2, false);
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$14$3$0(MutableState mutableState) {
        PreviewGroupAdminsScreen$lambda$9(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewGroupAdminsScreen$lambda$15(NavHostController navHostController, String str, PreviewGroupViewModel previewGroupViewModel, int i10, int i11, Composer composer, int i12) {
        PreviewGroupAdminsScreen(navHostController, str, previewGroupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean PreviewGroupAdminsScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupAdminsScreen$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupAdminsScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupAdminsScreen$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewGroupAdminsScreen$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewGroupAdminsScreen$lambda$9(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }
}
