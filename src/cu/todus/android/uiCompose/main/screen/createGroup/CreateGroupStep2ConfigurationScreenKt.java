package cu.todus.android.uiCompose.main.screen.createGroup;

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
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.camera.CameraKt;
import cu.todus.android.utils.ColorGenerator;
import cu.z17.views.inputText.Z17InputTextKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000f²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\f\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupViewModel;", "viewModel", "Lua/k0;", "CreateGroupStep2ConfigurationScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "openCamera", "showFloatingActionBtn", "Ll0/j;", "emptyAnimation", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CreateGroupStep2ConfigurationScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CreateGroupStep2ConfigurationScreen(final NavHostController navHostController, final String params, CreateGroupViewModel createGroupViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final CreateGroupViewModel createGroupViewModel2;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(477131169);
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
                createGroupViewModel2 = createGroupViewModel;
                int i13 = composerStartRestartGroup.changedInstance(createGroupViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                createGroupViewModel2 = createGroupViewModel;
            }
            i12 |= i13;
        } else {
            createGroupViewModel2 = createGroupViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            } else if ((i11 & 4) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                i14 &= -897;
                createGroupViewModel2 = (CreateGroupViewModel) ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(CreateGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(477131169, i14, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreen (CreateGroupStep2ConfigurationScreen.kt:70)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (CreateGroupParams) createGroupViewModel2.getGson().j(params, CreateGroupParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CreateGroupParams createGroupParams = (CreateGroupParams) objRememberedValue;
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue2;
            final LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            final c1.a aVarC = c1.d.c(Build.VERSION.SDK_INT >= 33 ? va.w.q("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES") : va.w.q("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"), null, composerStartRestartGroup, 0, 2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.w0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$12$0(mutableState2, mutableState3, mutableState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            boolean zCreateGroupStep2ConfigurationScreen$lambda$13 = CreateGroupStep2ConfigurationScreen$lambda$13((State) objRememberedValue7);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(913613805, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.x0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$14(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            final CreateGroupViewModel createGroupViewModel3 = createGroupViewModel2;
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1344347879, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.y0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$15(createGroupViewModel3, navHostController, mutableState2, snapshotStateList, mutableState4, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-97979733, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.z0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16(createGroupViewModel3, mutableState, lazyGridStateRememberLazyGridState, navHostController, mutableState4, aVarC, mutableState2, mutableState3, snapshotStateList, createGroupParams, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, zCreateGroupStep2ConfigurationScreen$lambda$13, composableLambdaRememberComposableLambda2, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda3, composerStartRestartGroup, 805331382, 352);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            createGroupViewModel2 = createGroupViewModel3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$17(navHostController, params, createGroupViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CreateGroupStep2ConfigurationScreen$createGroup(CreateGroupViewModel createGroupViewModel, MutableState<String> mutableState, SnapshotStateList<Friend> snapshotStateList, MutableState<Object> mutableState2, final MutableState<Boolean> mutableState3, final NavHostController navHostController) {
        CreateGroupStep2ConfigurationScreen$lambda$4(mutableState3, true);
        createGroupViewModel.createGroup(mutableState.getValue(), snapshotStateList.toList(), (Uri) mutableState2.getValue(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.r0
            @Override // lb.a
            public final Object invoke() {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$createGroup$lambda$10(navHostController, mutableState3);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.s0
            @Override // lb.a
            public final Object invoke() {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$createGroup$lambda$11(mutableState3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$createGroup$lambda$10(NavHostController navHostController, MutableState mutableState) {
        CreateGroupStep2ConfigurationScreen$lambda$4(mutableState, false);
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$createGroup$lambda$10$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$createGroup$lambda$10$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$createGroup$lambda$11(MutableState mutableState) {
        CreateGroupStep2ConfigurationScreen$lambda$4(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep2ConfigurationScreen$lambda$12$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        return (le.d0.q0((CharSequence) mutableState.getValue()) || CreateGroupStep2ConfigurationScreen$lambda$7(mutableState2) || CreateGroupStep2ConfigurationScreen$lambda$3(mutableState3)) ? false : true;
    }

    private static final boolean CreateGroupStep2ConfigurationScreen$lambda$13(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$14(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(913613805, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreen.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:140)");
            }
            Function2 lambda$798189632$app_productionPFast = ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.INSTANCE.getLambda$798189632$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.n0
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$14$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$798189632$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$14$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$15(final CreateGroupViewModel createGroupViewModel, final NavHostController navHostController, final MutableState mutableState, final SnapshotStateList snapshotStateList, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344347879, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreen.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:152)");
            }
            boolean zChangedInstance = composer.changedInstance(createGroupViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.t0
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$15$0$0(createGroupViewModel, mutableState, snapshotStateList, mutableState2, mutableState3, navHostController);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.INSTANCE.m9926getLambda$1565787689$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$15$0$0(CreateGroupViewModel createGroupViewModel, MutableState mutableState, SnapshotStateList snapshotStateList, MutableState mutableState2, MutableState mutableState3, NavHostController navHostController) {
        CreateGroupStep2ConfigurationScreen$createGroup(createGroupViewModel, mutableState, snapshotStateList, mutableState2, mutableState3, navHostController);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0172  */
    /* JADX WARN: Code duplicated, block: B:43:0x017a  */
    /* JADX WARN: Code duplicated, block: B:45:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:47:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:49:0x0224  */
    /* JADX WARN: Code duplicated, block: B:53:0x026a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16(CreateGroupViewModel createGroupViewModel, MutableState mutableState, LazyGridState lazyGridState, final NavHostController navHostController, final MutableState mutableState2, final c1.a aVar, final MutableState mutableState3, final MutableState mutableState4, final SnapshotStateList snapshotStateList, CreateGroupParams createGroupParams, Modifier it, Composer composer, int i10) {
        int i11;
        boolean zChanged;
        Object objRememberedValue;
        Modifier.Companion companion;
        Composer composer2;
        boolean zChanged2;
        Object objRememberedValue2;
        Composer composer3 = composer;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer3.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer3.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-97979733, i11, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreen.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:166)");
            }
            if (CreateGroupStep2ConfigurationScreen$lambda$3(mutableState)) {
                composer3.startReplaceGroup(330895256);
                LoadingScreenKt.LoadingWall(composer3, 0);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1663694106);
                float f10 = 20;
                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1725padding3ABfNKs(it, Dp.m8823constructorimpl(f10)));
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
                p0.l lVarQ = p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.group_image_placeholder)), null, null, null, null, null, composer3, 0, 62);
                if (mutableState2.getValue() != null && (mutableState2.getValue() instanceof String)) {
                    Object value = mutableState2.getValue();
                    kotlin.jvm.internal.y.g(value, "null cannot be cast to non-null type kotlin.String");
                    if (!le.d0.q0((String) value)) {
                        composer3.startReplaceGroup(1940709019);
                        float f11 = 5;
                        Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f11), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f11));
                        zChanged2 = composer3.changed(aVar);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        companion = companion4;
                        Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    } else if (mutableState2.getValue() instanceof Uri) {
                        composer3.startReplaceGroup(1940709019);
                        float f12 = 5;
                        Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f12), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f12));
                        zChanged2 = composer3.changed(aVar);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        companion = companion4;
                        Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs2, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(1941939502);
                        float f13 = 5;
                        Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f13));
                        zChanged = composer3.changed(aVar);
                        objRememberedValue = composer3.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.g0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$2$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.g0
                                @Override // lb.a
                                public final Object invoke() {
                                    return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$2$0(aVar, mutableState4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        companion = companion4;
                        p0.e.a(CreateGroupStep2ConfigurationScreen$lambda$16$0$0$0(lVarQ), ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs3, false, null, null, null, (lb.a) objRememberedValue, 15, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    }
                } else if (mutableState2.getValue() instanceof Uri) {
                    composer3.startReplaceGroup(1940709019);
                    float f14 = 5;
                    Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f14), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f14));
                    zChanged2 = composer3.changed(aVar);
                    objRememberedValue2 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.f0
                            @Override // lb.a
                            public final Object invoke() {
                                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(aVar, mutableState4);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    companion = companion4;
                    Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs4, false, null, null, null, (lb.a) objRememberedValue2, 15, null), mutableState2.getValue(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(mutableState3.getValue()))), null, null, 0, null, true, null, (String) mutableState3.getValue(), true, 0, composer, 12582912, 6, 2424);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(1941939502);
                    float f15 = 5;
                    Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(f15), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f15));
                    zChanged = composer3.changed(aVar);
                    objRememberedValue = composer3.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.g0
                            @Override // lb.a
                            public final Object invoke() {
                                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$2$0(aVar, mutableState4);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    companion = companion4;
                    p0.e.a(CreateGroupStep2ConfigurationScreen$lambda$16$0$0$0(lVarQ), ClickableKt.m1240clickableoSLSa3U$default(modifierM1725padding3ABfNKs5, false, null, null, null, (lb.a) objRememberedValue, 15, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572864, 0, 0, 4194236);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer2, 6);
                Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
                String str = (String) mutableState3.getValue();
                String strStringResource = StringResources_androidKt.stringResource(R.string.group_name, composer2, 0);
                Object objRememberedValue3 = composer2.rememberedValue();
                Composer.Companion companion5 = Composer.INSTANCE;
                if (objRememberedValue3 == companion5.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$0$3$0(mutableState3, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Z17InputTextKt.m10251Z17InputTextf9_u2OI(modifierA, str, 0, 0, strStringResource, null, (Function1) objRememberedValue3, null, null, 100, 0, 0L, 0L, 0L, 0L, 0L, null, false, null, false, composer, 806879232, 0, 1047980);
                composer.endNode();
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(15), 1, null), StringResources_androidKt.stringResource(R.string.selected, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
                GridCells.Adaptive adaptive = new GridCells.Adaptive(Dp.m8823constructorimpl(80), null);
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion5.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0(snapshotStateList, navHostController, (LazyGridScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                LazyGridDslKt.LazyVerticalGrid(adaptive, null, lazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue4, composer, 0, 0, 1018);
                composer3 = composer;
                composer3.endNode();
                composer3.endReplaceGroup();
            }
            if (CreateGroupStep2ConfigurationScreen$lambda$7(mutableState4)) {
                composer3.startReplaceGroup(1667878052);
                Object objRememberedValue5 = composer3.rememberedValue();
                Composer.Companion companion6 = Composer.INSTANCE;
                if (objRememberedValue5 == companion6.getEmpty()) {
                    objRememberedValue5 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.j0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$1$0(mutableState4, (List) obj, (String) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function2 function2 = (Function2) objRememberedValue5;
                Object objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion6.getEmpty()) {
                    objRememberedValue6 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.k0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$2$0(mutableState4, mutableState2, (List) obj, (String) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                Function2 function3 = (Function2) objRememberedValue6;
                Object objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion6.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.l0
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$3$0(mutableState4);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar2 = (lb.a) objRememberedValue7;
                Object objRememberedValue8 = composer3.rememberedValue();
                if (objRememberedValue8 == companion6.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.m0
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$4$0(mutableState4);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                CameraKt.Camera(null, null, false, false, false, false, 0L, function2, function3, null, aVar2, (lb.a) objRememberedValue8, composer, 113274240, 54, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE);
                composer3 = composer;
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1668542103);
                composer3.endReplaceGroup();
            }
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChangedInstance2 = composer3.changedInstance(createGroupViewModel);
            Object objRememberedValue9 = composer3.rememberedValue();
            if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new CreateGroupStep2ConfigurationScreenKt$CreateGroupStep2ConfigurationScreen$3$6$1(snapshotStateList, createGroupParams, createGroupViewModel, mutableState, null);
                composer3.updateRememberedValue(objRememberedValue9);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue9, composer3, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer3.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final l0.j CreateGroupStep2ConfigurationScreen$lambda$16$0$0$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$0$1$0(c1.a aVar, MutableState mutableState) {
        if (aVar.a()) {
            CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, true);
        } else {
            aVar.b();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$0$2$0(c1.a aVar, MutableState mutableState) {
        if (aVar.a()) {
            CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, true);
        } else {
            aVar.b();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$0$3$0(MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0(final SnapshotStateList snapshotStateList, final NavHostController navHostController, LazyGridScope LazyVerticalGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.CC.b(LazyVerticalGrid, snapshotStateList.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$0(snapshotStateList, ((Integer) obj).intValue());
            }
        }, null, null, ComposableLambdaKt.composableLambdaInstance(-168816427, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.q0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1(snapshotStateList, navHostController, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 12, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$0(SnapshotStateList snapshotStateList, int i10) {
        return ((Friend) snapshotStateList.get(i10)).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1(final SnapshotStateList snapshotStateList, final NavHostController navHostController, LazyGridItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = (composer.changed(items) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-168816427, i12, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep2ConfigurationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:244)");
            }
            final Friend friend = (Friend) snapshotStateList.get(i10);
            Modifier modifierA = androidx.compose.foundation.lazy.grid.s.a(items, Modifier.INSTANCE, null, null, null, 2, null);
            String name = friend.getName();
            String thumbnailPicture = friend.getThumbnailPicture();
            boolean zChanged = composer.changed(friend) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.v0
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0(snapshotStateList, navHostController, friend);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            AvatarNameItemKt.AvatarNameItem(modifierA, name, thumbnailPicture, (lb.a) objRememberedValue, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0(SnapshotStateList snapshotStateList, NavHostController navHostController, final Friend friend) {
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0$0(friend, (Friend) obj));
            }
        };
        Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.p0
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate$CC.$default$and(this, predicate);
            }

            public /* synthetic */ Predicate negate() {
                return Predicate$CC.$default$negate(this);
            }

            @Override // java.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate$CC.$default$or(this, predicate);
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CreateGroupStep2ConfigurationScreenKt.CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0$1(function1, obj);
            }
        });
        if (snapshotStateList.isEmpty()) {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0$0(Friend friend, Friend it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getId(), friend.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep2ConfigurationScreen$lambda$16$0$1$0$1$0$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$1$0(MutableState mutableState, List files, String content) {
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$2$0(MutableState mutableState, MutableState mutableState2, List files, String content) {
        Uri uriFromFile;
        kotlin.jvm.internal.y.i(files, "files");
        kotlin.jvm.internal.y.i(content, "content");
        CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, false);
        File file = (File) va.g0.y0(files);
        if (file != null && (uriFromFile = Uri.fromFile(file)) != null) {
            mutableState2.setValue(uriFromFile);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$3$0(MutableState mutableState) {
        CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$16$4$0(MutableState mutableState) {
        CreateGroupStep2ConfigurationScreen$lambda$8(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep2ConfigurationScreen$lambda$17(NavHostController navHostController, String str, CreateGroupViewModel createGroupViewModel, int i10, int i11, Composer composer, int i12) {
        CreateGroupStep2ConfigurationScreen(navHostController, str, createGroupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final boolean CreateGroupStep2ConfigurationScreen$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateGroupStep2ConfigurationScreen$lambda$4(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean CreateGroupStep2ConfigurationScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CreateGroupStep2ConfigurationScreen$lambda$8(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }
}
