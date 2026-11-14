package cu.todus.android.uiCompose.main.screen.searchUser;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/searchUser/SearchUserViewModel;", "viewModel", "Lua/k0;", "SearchUserScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/searchUser/SearchUserViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SearchUserScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SearchUserScreen(final NavHostController navHostController, final String params, SearchUserViewModel searchUserViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        SearchUserViewModel searchUserViewModel2;
        y.i(navHostController, "navHostController");
        y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(16821597);
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
                searchUserViewModel2 = searchUserViewModel;
                int i13 = composerStartRestartGroup.changedInstance(searchUserViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                searchUserViewModel2 = searchUserViewModel;
            }
            i12 |= i13;
        } else {
            searchUserViewModel2 = searchUserViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
            } else if ((i11 & 4) != 0) {
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                searchUserViewModel2 = (SearchUserViewModel) ViewModelKt.viewModel(z0.b(SearchUserViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                i12 &= -897;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(16821597, i12, -1, "cu.todus.android.uiCompose.main.screen.searchUser.SearchUserScreen (SearchUserScreen.kt:24)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (SearchUserParams) searchUserViewModel2.getGson().j(params, SearchUserParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SearchUserParams searchUserParams = (SearchUserParams) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState = (MutableState) objRememberedValue2;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (SearchUserScreen$lambda$2(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(1851368784);
                LoadingScreenKt.LoadingWall(composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(1557869951);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(searchUserViewModel2) | composerStartRestartGroup.changedInstance(navHostController);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new SearchUserScreenKt$SearchUserScreen$2$1(searchUserViewModel2, searchUserParams, navHostController, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue3, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final SearchUserViewModel searchUserViewModel3 = searchUserViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.searchUser.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchUserScreenKt.SearchUserScreen$lambda$6(navHostController, params, searchUserViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean SearchUserScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SearchUserScreen$lambda$6(NavHostController navHostController, String str, SearchUserViewModel searchUserViewModel, int i10, int i11, Composer composer, int i12) {
        SearchUserScreen(navHostController, str, searchUserViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
