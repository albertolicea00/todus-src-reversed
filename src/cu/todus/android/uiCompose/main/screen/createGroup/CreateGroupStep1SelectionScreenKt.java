package cu.todus.android.uiCompose.main.screen.createGroup;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u000b\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupViewModel;", "viewModel", "Lua/k0;", "CreateGroupStep1SelectionScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/createGroup/CreateGroupViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "showFloatingActionBtn", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CreateGroupStep1SelectionScreenKt {
    /* JADX WARN: Code duplicated, block: B:100:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:60:0x0100  */
    /* JADX WARN: Code duplicated, block: B:63:0x010c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0110  */
    /* JADX WARN: Code duplicated, block: B:67:0x014c  */
    /* JADX WARN: Code duplicated, block: B:70:0x016a  */
    /* JADX WARN: Code duplicated, block: B:73:0x019b  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:90:0x0279  */
    /* JADX WARN: Code duplicated, block: B:95:0x0298  */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CreateGroupStep1SelectionScreen(final NavHostController navHostController, final String params, CreateGroupViewModel createGroupViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final CreateGroupViewModel createGroupViewModel2;
        Composer composer2;
        ?? r10;
        Composer composer3;
        lb.a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        CreateGroupParams createGroupParams;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final SnapshotStateList snapshotStateList;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final MutableState mutableState;
        Object objRememberedValue6;
        Object objRememberedValue7;
        final CreateGroupViewModel createGroupViewModel3;
        boolean zChangedInstance;
        Object objRememberedValue8;
        boolean zChangedInstance2;
        Object createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(1711138817);
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
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    r10 = 0;
                    composer3 = composerStartRestartGroup;
                    createGroupViewModel2 = (CreateGroupViewModel) ViewModelKt.viewModel(kotlin.jvm.internal.z0.b(CreateGroupViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i12 &= -897;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1711138817, i12, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen (CreateGroupStep1SelectionScreen.kt:59)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r10);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r10));
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                objRememberedValue = composer3.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (CreateGroupParams) createGroupViewModel2.getGson().j(params, CreateGroupParams.class);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                createGroupParams = (CreateGroupParams) objRememberedValue;
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(createGroupViewModel2.friendsOnDbNoHeaders((String) mutableState2.getValue()), null, composer3, r10, 1);
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(r10, r10, composer3, r10, 3);
                final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(r10, r10, composer3, r10, 3);
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer3, r10, 3);
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt.mutableStateListOf();
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue3;
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                mutableState = (MutableState) objRememberedValue5;
                objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.b0
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$7$0(snapshotStateList));
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                State state = (State) objRememberedValue6;
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue7;
                createGroupViewModel3 = createGroupViewModel2;
                Composer composer4 = composer3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1859966637, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.c0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10(mutableState3, navHostController, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), false, false, CreateGroupStep1SelectionScreen$lambda$0$8(state), ComposableLambdaKt.rememberComposableLambda(1914840447, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$11(navHostController, createGroupViewModel2, snapshotStateList, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(1743026577, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12(mutableState, createGroupViewModel3, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, snapshotStateList, lazyListStateRememberLazyListState2, mutableState4, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer4, 805331382, 352);
                composer2 = composer4;
                Object value = mutableState4.getValue();
                zChangedInstance = composer2.changedInstance(createGroupViewModel3);
                objRememberedValue8 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$4$1(createGroupViewModel3, null);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                EffectsKt.LaunchedEffect(value, (Function2) objRememberedValue8, composer2, 0);
                ua.k0 k0Var = ua.k0.f43947a;
                zChangedInstance2 = composer2.changedInstance(createGroupViewModel3);
                Object objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue9 == companion.getEmpty()) {
                    createGroupViewModel2 = createGroupViewModel3;
                    createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1(snapshotStateList, createGroupParams, createGroupViewModel2, mutableState, null);
                    composer2.updateRememberedValue(createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1);
                } else {
                    createGroupViewModel2 = createGroupViewModel3;
                    createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1 = objRememberedValue9;
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1, composer2, 6);
                composer2.endNode();
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
            r10 = 0;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1711138817, i12, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen (CreateGroupStep1SelectionScreen.kt:59)");
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r10);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, r10));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion4);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            constructor = companion5.getConstructor();
            if (!defpackage.r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer3);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            objRememberedValue = composer3.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (CreateGroupParams) createGroupViewModel2.getGson().j(params, CreateGroupParams.class);
                composer3.updateRememberedValue(objRememberedValue);
            }
            createGroupParams = (CreateGroupParams) objRememberedValue;
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue2;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(createGroupViewModel2.friendsOnDbNoHeaders((String) mutableState5.getValue()), null, composer3, r10, 1);
            final LazyListState lazyListStateRememberLazyListState3 = LazyListStateKt.rememberLazyListState(r10, r10, composer3, r10, 3);
            final LazyListState lazyListStateRememberLazyListState4 = LazyListStateKt.rememberLazyListState(r10, r10, composer3, r10, 3);
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composer3, r10, 3);
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.mutableStateListOf();
                composer3.updateRememberedValue(objRememberedValue3);
            }
            snapshotStateList = (SnapshotStateList) objRememberedValue3;
            objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue5);
            }
            mutableState = (MutableState) objRememberedValue5;
            objRememberedValue6 = composer3.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$7$0(snapshotStateList));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue6);
            }
            State state2 = (State) objRememberedValue6;
            objRememberedValue7 = composer3.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.v.e(PermissionNeedIt.CONTACT), 1, null), null, 2, null);
                composer3.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue7;
            createGroupViewModel3 = createGroupViewModel2;
            Composer composer5 = composer3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-1859966637, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10(mutableState6, navHostController, mutableState5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), false, false, CreateGroupStep1SelectionScreen$lambda$0$8(state2), ComposableLambdaKt.rememberComposableLambda(1914840447, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$11(navHostController, createGroupViewModel2, snapshotStateList, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(1743026577, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12(mutableState, createGroupViewModel3, lazyListStateRememberLazyListState3, lazyPagingItemsCollectAsLazyPagingItems2, snapshotStateList, lazyListStateRememberLazyListState4, mutableState7, navHostController, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer5, 805331382, 352);
            composer2 = composer5;
            Object value2 = mutableState7.getValue();
            zChangedInstance = composer2.changedInstance(createGroupViewModel3);
            objRememberedValue8 = composer2.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue8 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$4$1(createGroupViewModel3, null);
                composer2.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$4$1(createGroupViewModel3, null);
                composer2.updateRememberedValue(objRememberedValue8);
            }
            EffectsKt.LaunchedEffect(value2, (Function2) objRememberedValue8, composer2, 0);
            ua.k0 k0Var2 = ua.k0.f43947a;
            zChangedInstance2 = composer2.changedInstance(createGroupViewModel3);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (zChangedInstance2) {
                createGroupViewModel2 = createGroupViewModel3;
                createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1(snapshotStateList, createGroupParams, createGroupViewModel2, mutableState, null);
                composer2.updateRememberedValue(createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1);
            } else {
                createGroupViewModel2 = createGroupViewModel3;
                createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1 = new CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1(snapshotStateList, createGroupParams, createGroupViewModel2, mutableState, null);
                composer2.updateRememberedValue(createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$5$1, composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        final CreateGroupViewModel createGroupViewModel4 = createGroupViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$1(navHostController, params, createGroupViewModel4, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10(final MutableState mutableState, final NavHostController navHostController, final MutableState mutableState2, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1859966637, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen.<anonymous>.<anonymous> (CreateGroupStep1SelectionScreen.kt:106)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.startReplaceGroup(-892946980);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.n
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10$0$0(mutableState2, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10$1$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                SearchContactTopBarKt.SearchContactTopBar(navHostController, aVar, (Function1) objRememberedValue2, composer, 432);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-892612304);
                Function2 function2M9924getLambda$1337285110$app_productionPFast = ComposableSingletons$CreateGroupStep1SelectionScreenKt.INSTANCE.m9924getLambda$1337285110$app_productionPFast();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(693337727, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10$2(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.q
                        @Override // lb.a
                        public final Object invoke() {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10$3$0(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9924getLambda$1337285110$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue3, null, 0L, 0L, 0.0f, composer, 3078, 0, 1942);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue("");
        mutableState2.setValue(Boolean.FALSE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10$1$0(MutableState mutableState, String f10) {
        kotlin.jvm.internal.y.i(f10, "f");
        mutableState.setValue(f10);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10$2(final MutableState mutableState, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(693337727, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen.<anonymous>.<anonymous>.<anonymous> (CreateGroupStep1SelectionScreen.kt:121)");
            }
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.v
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$10$2$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$CreateGroupStep1SelectionScreenKt.INSTANCE.m9925getLambda$240721379$app_productionPFast(), composer, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10$2$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$10$3$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$11(final NavHostController navHostController, final CreateGroupViewModel createGroupViewModel, final SnapshotStateList snapshotStateList, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1914840447, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen.<anonymous>.<anonymous> (CreateGroupStep1SelectionScreen.kt:139)");
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(createGroupViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.m
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$11$0$0(navHostController, createGroupViewModel, snapshotStateList);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$CreateGroupStep1SelectionScreenKt.INSTANCE.getLambda$689225661$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$11$0$0(NavHostController navHostController, CreateGroupViewModel createGroupViewModel, SnapshotStateList snapshotStateList) {
        NavLinks navLinks = NavLinks.INSTANCE;
        v5.f gson = createGroupViewModel.getGson();
        ArrayList arrayList = new ArrayList(va.x.y(snapshotStateList, 10));
        Iterator<T> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Friend) it.next()).getId());
        }
        String strT = gson.t(new CreateGroupParams("", arrayList));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goCreateGroupStep2(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12(MutableState mutableState, CreateGroupViewModel createGroupViewModel, LazyListState lazyListState, LazyPagingItems lazyPagingItems, final SnapshotStateList snapshotStateList, final LazyListState lazyListState2, final MutableState mutableState2, final NavHostController navHostController, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1743026577, i11, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen.<anonymous>.<anonymous> (CreateGroupStep1SelectionScreen.kt:161)");
            }
            if (CreateGroupStep1SelectionScreen$lambda$0$5(mutableState)) {
                composer.startReplaceGroup(11420326);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion3.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(BoxScopeInstance.INSTANCE.align(companion, companion2.getCenter()), 0.0f, 0.0f, 0L, composer, 0, 14);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(11300406);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, it);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion4.getConstructor();
                if (!defpackage.r.a(composer.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                Modifier modifierA = androidx.compose.foundation.layout.x.a(ColumnScopeInstance.INSTANCE, it, 1.0f, false, 2, null);
                String nameWithDomain = createGroupViewModel.owner().getNameWithDomain();
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion5 = Composer.INSTANCE;
                if (objRememberedValue == companion5.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0(snapshotStateList, (Friend) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion5.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$1$0((Friend) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function1 function2 = (Function1) objRememberedValue2;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(140850682, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$2(lazyListState2, mutableState2, navHostController, snapshotStateList, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion5.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.x
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$3$0(snapshotStateList, (Friend) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                UserCommonListKt.UserCommonList(modifierA, lazyListState, lazyPagingItems, function1, function2, composableLambdaRememberComposableLambda, nameWithDomain, (Function1) objRememberedValue3, null, composer, (LazyPagingItems.$stable << 6) | 12807168, 256);
                composer.endNode();
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0(SnapshotStateList snapshotStateList, final Friend s10) {
        Object next;
        kotlin.jvm.internal.y.i(s10, "s");
        Iterator<T> it = snapshotStateList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.y.d(((Friend) next).getId(), s10.getId()));
        if (next != null) {
            final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0$1(s10, (Friend) obj));
                }
            };
            Collection.EL.removeIf(snapshotStateList, new Predicate() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.z
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
                    return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0$2(function1, obj);
                }
            });
        } else {
            snapshotStateList.add(0, s10);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0$1(Friend friend, Friend it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getId(), friend.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep1SelectionScreen$lambda$0$12$0$0$0$2(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$1$0(Friend it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$2(LazyListState lazyListState, final MutableState mutableState, final NavHostController navHostController, final SnapshotStateList snapshotStateList, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(140850682, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateGroupStep1SelectionScreen.kt:180)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
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
            String strStringResource = StringResources_androidKt.stringResource(R.string.selected, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            float f10 = 20;
            float f11 = 5;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11)), strStringResource, materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0(snapshotStateList, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyRow(null, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 805306368, 509);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11)), StringResources_androidKt.stringResource(R.string.friends, composer, 0), materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.s
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar = (lb.a) objRememberedValue2;
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion3.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$2$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, aVar, permissionsRequesterState, (Function1) objRememberedValue3, null, composer, 3072, 17);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0(final SnapshotStateList snapshotStateList, LazyListScope LazyRow) {
        kotlin.jvm.internal.y.i(LazyRow, "$this$LazyRow");
        ComposableSingletons$CreateGroupStep1SelectionScreenKt composableSingletons$CreateGroupStep1SelectionScreenKt = ComposableSingletons$CreateGroupStep1SelectionScreenKt.INSTANCE;
        LazyListScope.CC.m(LazyRow, null, null, composableSingletons$CreateGroupStep1SelectionScreenKt.m9923getLambda$1179961497$app_productionPFast(), 3, null);
        final List list = snapshotStateList.toList();
        final Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateGroupStep1SelectionScreenKt.CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$0((Friend) obj);
            }
        };
        final CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$1 createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Friend friend) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Friend) obj);
            }
        };
        LazyRow.items(list.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return function1.invoke(list.get(i10));
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return createGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$$inlined$items$default$4
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return ua.k0.f43947a;
            }

            @Composable
            public final void invoke(LazyItemScope lazyItemScope, int i10, Composer composer, int i11) {
                int i12;
                if ((i11 & 6) == 0) {
                    i12 = i11 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i12 = i11;
                }
                if ((i11 & 48) == 0) {
                    i12 |= composer.changed(i10) ? 32 : 16;
                }
                if (!composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i12, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final Friend friend = (Friend) list.get(i10);
                composer.startReplaceGroup(864195060);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(lazyItemScope, Modifier.INSTANCE, null, null, null, 2, null);
                String name = friend.getName();
                String thumbnailPicture = friend.getThumbnailPicture();
                boolean zChanged = composer.changed(friend);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final SnapshotStateList snapshotStateList2 = snapshotStateList;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$3$1$3$1$1$1$2$1$1
                        @Override // lb.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m9927invoke();
                            return ua.k0.f43947a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m9927invoke() {
                            SnapshotStateList<Friend> snapshotStateList3 = snapshotStateList2;
                            final Friend friend2 = friend;
                            final Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$CreateGroupStep1SelectionScreen$1$3$1$3$1$1$1$2$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(Friend it) {
                                    kotlin.jvm.internal.y.i(it, "it");
                                    return Boolean.valueOf(kotlin.jvm.internal.y.d(it.getId(), friend2.getId()));
                                }
                            };
                            Collection.EL.removeIf(snapshotStateList3, new Predicate(function2) { // from class: cu.todus.android.uiCompose.main.screen.createGroup.CreateGroupStep1SelectionScreenKt$sam$java_util_function_Predicate$0
                                private final /* synthetic */ Function1 function;

                                {
                                    kotlin.jvm.internal.y.i(function2, "function");
                                    this.function = function2;
                                }

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
                                public final /* synthetic */ boolean test(Object obj) {
                                    return ((Boolean) this.function.invoke(obj)).booleanValue();
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                AvatarNameItemKt.AvatarNameItem(modifierC, name, thumbnailPicture, (lb.a) objRememberedValue, composer, 0, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.CC.m(LazyRow, null, null, composableSingletons$CreateGroupStep1SelectionScreenKt.getLambda$369711966$app_productionPFast(), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$0$0$0(Friend selected) {
        kotlin.jvm.internal.y.i(selected, "selected");
        return selected.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$1$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.CONTACTS_PERMISSION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$0$12$0$2$0$2$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[RETURN] */
    public static final String CreateGroupStep1SelectionScreen$lambda$0$12$0$3$0(SnapshotStateList snapshotStateList, Friend friend) {
        Object obj;
        Object next;
        Iterator<T> it = snapshotStateList.iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
            }
            if (obj != null) {
                return "✅";
            }
            return "";
        } while (!kotlin.jvm.internal.y.d(((Friend) next).getId(), friend != null ? friend.getId() : null));
        obj = next;
        if (obj != null) {
            return "✅";
        }
        return "";
    }

    private static final boolean CreateGroupStep1SelectionScreen$lambda$0$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateGroupStep1SelectionScreen$lambda$0$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateGroupStep1SelectionScreen$lambda$0$7$0(SnapshotStateList snapshotStateList) {
        return !snapshotStateList.isEmpty();
    }

    private static final boolean CreateGroupStep1SelectionScreen$lambda$0$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CreateGroupStep1SelectionScreen$lambda$1(NavHostController navHostController, String str, CreateGroupViewModel createGroupViewModel, int i10, int i11, Composer composer, int i12) {
        CreateGroupStep1SelectionScreen(navHostController, str, createGroupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
