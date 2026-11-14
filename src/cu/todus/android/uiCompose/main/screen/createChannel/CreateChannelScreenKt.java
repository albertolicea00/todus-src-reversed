package cu.todus.android.uiCompose.main.screen.createChannel;

import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.FloatingActionButtonKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\n\u001a\u00020\u00078\nX\u008a\u0084\u0002²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/createChannel/CreateChannelViewModel;", "viewModel", "Lua/k0;", "CreateChannelScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/createChannel/CreateChannelViewModel;Landroidx/compose/runtime/Composer;II)V", "", "openCamera", "isLoading", "showFloatingActionBtn", "Ll0/j;", "emptyAnimation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CreateChannelScreenKt {
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CreateChannelScreen(final NavHostController navHostController, CreateChannelViewModel createChannelViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        CreateChannelViewModel createChannelViewModel2;
        final CreateChannelViewModel createChannelViewModel3;
        int i13;
        int i14;
        boolean z10;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(165410006);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                createChannelViewModel2 = createChannelViewModel;
                int i15 = composerStartRestartGroup.changedInstance(createChannelViewModel2) ? 32 : 16;
                i12 |= i15;
            } else {
                createChannelViewModel2 = createChannelViewModel;
            }
            i12 |= i15;
        } else {
            createChannelViewModel2 = createChannelViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    CreateChannelViewModel createChannelViewModel4 = createChannelViewModel2;
                    i14 = i12 & (-113);
                    createChannelViewModel3 = createChannelViewModel4;
                    i13 = 0;
                    z10 = true;
                } else {
                    i13 = 0;
                    z10 = true;
                    CreateChannelViewModel createChannelViewModel5 = createChannelViewModel2;
                    i14 = i12;
                    createChannelViewModel3 = createChannelViewModel5;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                i13 = 0;
                CreateChannelViewModel createChannelViewModel6 = (CreateChannelViewModel) ViewModelKt.viewModel(z0.b(CreateChannelViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i14 = i12 & (-113);
                createChannelViewModel3 = createChannelViewModel6;
                z10 = true;
            } else {
                i13 = 0;
                z10 = true;
                CreateChannelViewModel createChannelViewModel7 = createChannelViewModel2;
                i14 = i12;
                createChannelViewModel3 = createChannelViewModel7;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165410006, i14, -1, "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelScreen (CreateChannelScreen.kt:60)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            final c1.a aVarC = c1.d.c(Build.VERSION.SDK_INT >= 33 ? w.q("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES") : w.q("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"), null, composerStartRestartGroup, i13, 2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.r
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(CreateChannelScreenKt.CreateChannelScreen$lambda$10$0(mutableState, mutableState2, mutableState3));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1304663562, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateChannelScreenKt.CreateChannelScreen$lambda$12(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, CreateChannelScreen$lambda$11((State) objRememberedValue5), ComposableLambdaKt.rememberComposableLambda(1835571294, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateChannelScreenKt.CreateChannelScreen$lambda$13(createChannelViewModel3, navHostController, mutableState, mutableState4, mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-7178228, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14(mutableState3, mutableState4, aVarC, mutableState, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805331382, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            createChannelViewModel3 = createChannelViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateChannelScreenKt.CreateChannelScreen$lambda$15(navHostController, createChannelViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CreateChannelScreen$createChannel(CreateChannelViewModel createChannelViewModel, MutableState<String> mutableState, MutableState<Object> mutableState2, final MutableState<Boolean> mutableState3, final NavHostController navHostController) {
        CreateChannelScreen$lambda$6(mutableState3, true);
        createChannelViewModel.createChannel(mutableState.getValue(), (Uri) mutableState2.getValue(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.g
            @Override // lb.a
            public final Object invoke() {
                return CreateChannelScreenKt.CreateChannelScreen$createChannel$lambda$8(navHostController, mutableState3);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.h
            @Override // lb.a
            public final Object invoke() {
                return CreateChannelScreenKt.CreateChannelScreen$createChannel$lambda$9(mutableState3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$createChannel$lambda$8(NavHostController navHostController, MutableState mutableState) {
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateChannelScreenKt.CreateChannelScreen$createChannel$lambda$8$0((NavOptionsBuilder) obj);
            }
        });
        CreateChannelScreen$lambda$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$createChannel$lambda$8$0(NavOptionsBuilder navigate) {
        y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$createChannel$lambda$9(MutableState mutableState) {
        CreateChannelScreen$lambda$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateChannelScreen$lambda$10$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        return (d0.q0((CharSequence) mutableState.getValue()) || CreateChannelScreen$lambda$2(mutableState2) || CreateChannelScreen$lambda$5(mutableState3)) ? false : true;
    }

    private static final boolean CreateChannelScreen$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CreateChannelScreen$lambda$12(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1304663562, i10, -1, "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelScreen.<anonymous> (CreateChannelScreen.kt:121)");
            }
            Function2 lambda$1083301527$app_productionPFast = ComposableSingletons$CreateChannelScreenKt.INSTANCE.getLambda$1083301527$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.j
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateChannelScreenKt.CreateChannelScreen$lambda$12$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1083301527$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$12$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CreateChannelScreen$lambda$13(final CreateChannelViewModel createChannelViewModel, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1835571294, i10, -1, "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelScreen.<anonymous> (CreateChannelScreen.kt:133)");
            }
            boolean zChangedInstance = composer.changedInstance(createChannelViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.q
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateChannelScreenKt.CreateChannelScreen$lambda$13$0$0(createChannelViewModel, mutableState, mutableState2, mutableState3, navHostController);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$CreateChannelScreenKt.INSTANCE.m9922getLambda$46469024$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$13$0$0(CreateChannelViewModel createChannelViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, NavHostController navHostController) {
        CreateChannelScreen$createChannel(createChannelViewModel, mutableState, mutableState2, mutableState3, navHostController);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0171  */
    /* JADX WARN: Code duplicated, block: B:43:0x0179  */
    /* JADX WARN: Code duplicated, block: B:45:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:49:0x021d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0263  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CreateChannelScreen$lambda$14(MutableState mutableState, final MutableState mutableState2, final c1.a aVar, final MutableState mutableState3, final MutableState mutableState4, Modifier it, Composer composer, int i10) {
        int i11;
        final MutableState mutableState5;
        float f10;
        boolean zChanged;
        Object objRememberedValue;
        Modifier.Companion companion;
        int i12;
        Composer composer2;
        boolean zChanged2;
        Object objRememberedValue2;
        Composer composer3 = composer;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer3.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer3.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-7178228, i11, -1, "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelScreen.<anonymous> (CreateChannelScreen.kt:147)");
            }
            if (CreateChannelScreen$lambda$5(mutableState)) {
                composer3.startReplaceGroup(1691758969);
                LoadingScreenKt.LoadingWall(composer3, 0);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1691661819);
                float f11 = 20;
                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1725padding3ABfNKs(it, Dp.m8823constructorimpl(f11)));
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer3, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierImePadding);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion3.getConstructor();
                if (!defpackage.r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer3, 48);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion4);
                lb.a constructor2 = companion3.getConstructor();
                if (!defpackage.r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.channel_image_placeholder)), null, null, null, null, null, composer3, 0, 62);
                if (mutableState2.getValue() != null && (mutableState2.getValue() instanceof String)) {
                    Object value = mutableState2.getValue();
                    y.g(value, "null cannot be cast to non-null type kotlin.String");
                    if (!d0.q0((String) value)) {
                        composer3.startReplaceGroup(-2697046);
                        float f12 = 5;
                        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f12), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f12));
                        zChanged2 = composer3.changed(aVar);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        f10 = f11;
                        Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                        i12 = 0;
                        companion = companion4;
                    } else if (mutableState2.getValue() instanceof Uri) {
                        composer3.startReplaceGroup(-2697046);
                        float f13 = 5;
                        Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f13));
                        zChanged2 = composer3.changed(aVar);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        f10 = f11;
                        Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs2, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                        i12 = 0;
                        companion = companion4;
                    } else {
                        f10 = f11;
                        composer3.startReplaceGroup(-1460797);
                        float f14 = 5;
                        Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f14), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f14));
                        zChanged = composer3.changed(aVar);
                        objRememberedValue = composer3.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$2$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.k
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$2$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        companion = companion4;
                        i12 = 0;
                        p0.e.a(CreateChannelScreen$lambda$14$0$0$0(lVarQ), ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs3, false, null, null, null, (lb.a) objRememberedValue, 15, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    }
                } else if (mutableState2.getValue() instanceof Uri) {
                    composer3.startReplaceGroup(-2697046);
                    float f15 = 5;
                    Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f15), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f15));
                    zChanged2 = composer3.changed(aVar);
                    objRememberedValue2 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.c
                            @Override // lb.a
                            public final Object invoke() {
                                return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$1$0(aVar, mutableState4);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    f10 = f11;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs4, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                    i12 = 0;
                    companion = companion4;
                } else {
                    f10 = f11;
                    composer3.startReplaceGroup(-1460797);
                    float f16 = 5;
                    Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f16), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f16));
                    zChanged = composer3.changed(aVar);
                    objRememberedValue = composer3.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.k
                            @Override // lb.a
                            public final Object invoke() {
                                return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$2$0(aVar, mutableState4);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    companion = companion4;
                    i12 = 0;
                    p0.e.a(CreateChannelScreen$lambda$14$0$0$0(lVarQ), ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs5, false, null, null, null, (lb.a) objRememberedValue, 15, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer2, 6);
                Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                String str = (String) mutableState3.getValue();
                String strStringResource = StringResources_androidKt.stringResource(R.string.channel_name, composer2, i12);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateChannelScreenKt.CreateChannelScreen$lambda$14$0$0$3$0(mutableState3, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Composer composer4 = composer2;
                Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierA, str, 0, 0, strStringResource, null, (Function1) objRememberedValue3, null, null, 100, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer4, 806879232, 0, 1047980);
                composer3 = composer4;
                composer3.endNode();
                composer3.endNode();
                composer3.endReplaceGroup();
            }
            if (CreateChannelScreen$lambda$2(mutableState4)) {
                composer3.startReplaceGroup(904980257);
                Object objRememberedValue4 = composer3.rememberedValue();
                Composer.Companion companion5 = Composer.INSTANCE;
                if (objRememberedValue4 == companion5.getEmpty()) {
                    mutableState5 = mutableState4;
                    objRememberedValue4 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateChannelScreenKt.CreateChannelScreen$lambda$14$1$0(mutableState5, (List) obj, (String) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    mutableState5 = mutableState4;
                }
                Function2 function2 = (Function2) objRememberedValue4;
                Object objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion5.getEmpty()) {
                    objRememberedValue5 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateChannelScreenKt.CreateChannelScreen$lambda$14$2$0(mutableState2, mutableState5, (List) obj, (String) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function2 function3 = (Function2) objRememberedValue5;
                Object objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion5.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.o
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateChannelScreenKt.CreateChannelScreen$lambda$14$3$0(mutableState5);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                lb.a aVar2 = (lb.a) objRememberedValue6;
                Object objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion5.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.p
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateChannelScreenKt.CreateChannelScreen$lambda$14$4$0(mutableState5);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                CameraKt.Camera(null, null, false, false, false, false, 0L, function2, function3, null, aVar2, (lb.a) objRememberedValue7, composer, 113274240, 54, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE);
                composer.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(905646230);
                composer3.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer3.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final l0.j CreateChannelScreen$lambda$14$0$0$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$0$0$1$0(c1.a aVar, MutableState mutableState) {
        if (aVar.a()) {
            CreateChannelScreen$lambda$3(mutableState, true);
        } else {
            aVar.b();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$0$0$2$0(c1.a aVar, MutableState mutableState) {
        if (aVar.a()) {
            CreateChannelScreen$lambda$3(mutableState, true);
        } else {
            aVar.b();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$0$0$3$0(MutableState mutableState, String it) {
        y.i(it, "it");
        mutableState.setValue(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$1$0(MutableState mutableState, List files, String content) {
        y.i(files, "files");
        y.i(content, "content");
        CreateChannelScreen$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$2$0(MutableState mutableState, MutableState mutableState2, List files, String content) {
        Uri uriFromFile;
        y.i(files, "files");
        y.i(content, "content");
        File file = (File) g0.y0(files);
        if (file != null && (uriFromFile = Uri.fromFile(file)) != null) {
            mutableState.setValue(uriFromFile);
        }
        CreateChannelScreen$lambda$3(mutableState2, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$3$0(MutableState mutableState) {
        CreateChannelScreen$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$14$4$0(MutableState mutableState) {
        CreateChannelScreen$lambda$3(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CreateChannelScreen$lambda$15(NavHostController navHostController, CreateChannelViewModel createChannelViewModel, int i10, int i11, Composer composer, int i12) {
        CreateChannelScreen(navHostController, createChannelViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean CreateChannelScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CreateChannelScreen$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean CreateChannelScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CreateChannelScreen$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }
}
