package cu.todus.android.uiCompose.main.screen.usersDisplay.blocked;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.ContactsViewModel;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
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
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;", "viewModel", "Lua/k0;", "BlockedScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/usersDisplay/ContactsViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BlockedScreenKt {
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BlockedScreen(final NavHostController navHostController, ContactsViewModel contactsViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        ContactsViewModel contactsViewModel2;
        final ContactsViewModel contactsViewModel3;
        Composer composer2;
        ?? r15;
        final ContactsViewModel contactsViewModel4;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-828584761);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) == 0) {
                contactsViewModel2 = contactsViewModel;
                int i13 = composerStartRestartGroup.changedInstance(contactsViewModel2) ? 32 : 16;
                i12 |= i13;
            } else {
                contactsViewModel2 = contactsViewModel;
            }
            i12 |= i13;
        } else {
            contactsViewModel2 = contactsViewModel;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                    contactsViewModel4 = contactsViewModel2;
                    composer2 = composerStartRestartGroup;
                    r15 = 1;
                } else {
                    composer2 = composerStartRestartGroup;
                    r15 = 1;
                    contactsViewModel4 = contactsViewModel2;
                }
            } else if ((i11 & 2) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                composer2 = composerStartRestartGroup;
                r15 = 1;
                contactsViewModel4 = (ContactsViewModel) ViewModelKt.viewModel(z0.b(ContactsViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 0, 0);
                i14 &= -113;
            } else {
                composer2 = composerStartRestartGroup;
                r15 = 1;
                contactsViewModel4 = contactsViewModel2;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-828584761, i14, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.BlockedScreen (BlockedScreen.kt:41)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
            if (!r.a(composer2.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(contactsViewModel4.partnersBlocked(), null, composer2, 0, r15);
            ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
            Object objRememberedValue = composer2.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-557991883, r15, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockedScreenKt.BlockedScreen$lambda$0$3(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1852620489, r15, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockedScreenKt.BlockedScreen$lambda$0$4(lazyPagingItemsCollectAsLazyPagingItems, contactsViewModel4, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            composerStartRestartGroup = composer2;
            contactsViewModel3 = contactsViewModel4;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, true, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306806, 376);
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(contactsViewModel3);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new BlockedScreenKt$BlockedScreen$1$3$1(contactsViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            contactsViewModel3 = contactsViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedScreenKt.BlockedScreen$lambda$1(navHostController, contactsViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BlockedScreen$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BlockedScreen$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BlockedScreen$lambda$0$3(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        int i11;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557991883, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.BlockedScreen.<anonymous>.<anonymous> (BlockedScreen.kt:56)");
            }
            Function2 lambda$158826050$app_productionPFast = ComposableSingletons$BlockedScreenKt.INSTANCE.getLambda$158826050$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.c
                    @Override // lb.a
                    public final Object invoke() {
                        return BlockedScreenKt.BlockedScreen$lambda$0$3$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$158826050$app_productionPFast, it, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, ((i11 << 3) & 112) | 6, 0, 1948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BlockedScreen$lambda$0$3$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 BlockedScreen$lambda$0$4(LazyPagingItems lazyPagingItems, final ContactsViewModel contactsViewModel, MutableState mutableState, Modifier it, Composer composer, int i10) {
        int i11;
        final MutableState mutableState2;
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1852620489, i11, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.BlockedScreen.<anonymous>.<anonymous> (BlockedScreen.kt:70)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(it, 0.0f, 1, null);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockedScreenKt.BlockedScreen$lambda$0$4$0$0((Partner) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChangedInstance = composer.changedInstance(contactsViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockedScreenKt.BlockedScreen$lambda$0$4$1$0(contactsViewModel, mutableState2, (Partner) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState2 = mutableState;
            }
            UserCommonListKt.UserCommonList(modifierFillMaxHeight$default, lazyListStateRememberLazyListState, lazyPagingItems, function1, (Function1) objRememberedValue2, ComposableSingletons$BlockedScreenKt.INSTANCE.getLambda$1254985885$app_productionPFast(), contactsViewModel.owner().getNameWithDomain(), null, null, composer, (LazyPagingItems.$stable << 6) | 199680, RendererCapabilities.DECODER_SUPPORT_MASK);
            if (BlockedScreen$lambda$0$1(mutableState2)) {
                composer.startReplaceGroup(2043185636);
                LoadingScreenKt.LoadingWall(composer, 0);
            } else {
                composer.startReplaceGroup(-1085742229);
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
    public static final k0 BlockedScreen$lambda$0$4$0$0(Partner it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BlockedScreen$lambda$0$4$1$0(ContactsViewModel contactsViewModel, final MutableState mutableState, Partner userCommon) {
        y.i(userCommon, "userCommon");
        BlockedScreen$lambda$0$2(mutableState, true);
        contactsViewModel.unblock(userCommon.getId(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.blocked.d
            @Override // lb.a
            public final Object invoke() {
                return BlockedScreenKt.BlockedScreen$lambda$0$4$1$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BlockedScreen$lambda$0$4$1$0$0(MutableState mutableState) {
        BlockedScreen$lambda$0$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BlockedScreen$lambda$1(NavHostController navHostController, ContactsViewModel contactsViewModel, int i10, int i11, Composer composer, int i12) {
        BlockedScreen(navHostController, contactsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
