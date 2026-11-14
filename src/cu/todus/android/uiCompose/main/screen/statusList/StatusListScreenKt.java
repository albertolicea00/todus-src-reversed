package cu.todus.android.uiCompose.main.screen.statusList;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.FollowPartner;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorParams;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.modal.ModalKt;
import cu.todus.android.uiCompose.shared.pagerStateIndicator.PagerStateIndicatorKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0089\u0001\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a²\u0006\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u00078\nX\u008a\u0084\u0002²\u0006\u0010\u0010\n\u001a\u0004\u0018\u00010\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/statusList/StatusListViewModel;", "viewModel", "Lua/k0;", "StatusListScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/statusList/StatusListViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "lastStatus", "Lcu/todus/android/data/xmpp/FollowState;", "profileState", "", "ownerPicture", "ownerName", "ownerToDusId", "", "isFromOwner", "Lkotlin/Function0;", "goNewStatus", "onFollowersClick", "onFollowingClick", "navigateUp", "onMoreOptionsCLicked", "YourStatusItem", "(Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;Lcu/todus/android/data/xmpp/FollowState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLlb/a;Llb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "ownerLastStatus", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusListScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:53:0x010d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusListScreen(final NavHostController navHostController, StatusListViewModel statusListViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        int i13;
        int i14;
        final StatusListViewModel statusListViewModel2 = statusListViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-877824130);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i14 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(statusListViewModel2) : composerStartRestartGroup.changedInstance(statusListViewModel2)) {
                    i14 = 32;
                } else {
                    i14 = 16;
                }
            }
            i12 |= i14;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i13 = 0;
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(StatusListViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    statusListViewModel2 = (StatusListViewModel) viewModel;
                    i12 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-877824130, i12, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen (StatusListScreen.kt:92)");
                }
                final LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(i13, i13, composerStartRestartGroup, i13, 3);
                ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue, null, null, true, composerStartRestartGroup, 3078, 6);
                final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState2 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue, null, null, true, composerStartRestartGroup, 3078, 6);
                final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState3 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue, null, null, false, composerStartRestartGroup, 6, 14);
                final StatusListViewModel statusListViewModel3 = statusListViewModel2;
                Composer composer2 = composerStartRestartGroup;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(null, true, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3), null, ComposableLambdaKt.rememberComposableLambda(-1168729164, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.n0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return StatusListScreenKt.StatusListScreen$lambda$0(statusListViewModel3, lazyStaggeredGridStateRememberLazyStaggeredGridState, navHostController, modalBottomSheetStateRememberModalBottomSheetState, modalBottomSheetStateRememberModalBottomSheetState2, modalBottomSheetStateRememberModalBottomSheetState3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306800, 377);
                composerStartRestartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                statusListViewModel2 = statusListViewModel3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
            }
            i13 = 0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-877824130, i12, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen (StatusListScreen.kt:92)");
            }
            final LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(i13, i13, composerStartRestartGroup, i13, 3);
            ModalBottomSheetValue modalBottomSheetValue2 = ModalBottomSheetValue.Hidden;
            final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState4 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue2, null, null, true, composerStartRestartGroup, 3078, 6);
            final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState5 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue2, null, null, true, composerStartRestartGroup, 3078, 6);
            final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState6 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue2, null, null, false, composerStartRestartGroup, 6, 14);
            final StatusListViewModel statusListViewModel4 = statusListViewModel2;
            Composer composer3 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(null, true, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, i13, 3), null, ComposableLambdaKt.rememberComposableLambda(-1168729164, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.n0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatusListScreenKt.StatusListScreen$lambda$0(statusListViewModel4, lazyStaggeredGridStateRememberLazyStaggeredGridState2, navHostController, modalBottomSheetStateRememberModalBottomSheetState4, modalBottomSheetStateRememberModalBottomSheetState5, modalBottomSheetStateRememberModalBottomSheetState6, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, 805306800, 377);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            statusListViewModel2 = statusListViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusListScreenKt.StatusListScreen$lambda$1(navHostController, statusListViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0(final StatusListViewModel statusListViewModel, LazyStaggeredGridState lazyStaggeredGridState, final NavHostController navHostController, final ModalBottomSheetState modalBottomSheetState, final ModalBottomSheetState modalBottomSheetState2, final ModalBottomSheetState modalBottomSheetState3, final Modifier it, Composer composer, int i10) {
        int i11;
        StaggeredGridCells.Fixed fixed;
        final pe.m0 m0Var;
        final MutableState mutableState;
        boolean z10;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1168729164, i11, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous> (StatusListScreen.kt:107)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            pe.m0 m0Var2 = (pe.m0) objRememberedValue;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(statusListViewModel.ownerLastStatus(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(statusListViewModel.getOtherStatus(), null, composer, 0, 1);
            final int i12 = ((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
            final int i13 = ((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            StaggeredGridCells.Fixed fixed2 = new StaggeredGridCells.Fixed(2);
            float f10 = 4;
            float fM8823constructorimpl = Dp.m8823constructorimpl(f10);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f10));
            PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
            boolean zChanged = composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(statusListViewModel) | composer.changedInstance(navHostController) | composer.changedInstance(m0Var2) | composer.changedInstance(modalBottomSheetState) | composer.changedInstance(modalBottomSheetState2) | composer.changedInstance(modalBottomSheetState3) | composer.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | composer.changed(i12) | composer.changed(i13);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                fixed = fixed2;
                m0Var = m0Var2;
                mutableState = mutableState2;
                z10 = true;
                Object obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0(lazyPagingItemsCollectAsLazyPagingItems, statusListViewModel, navHostController, m0Var, modalBottomSheetState, modalBottomSheetState2, modalBottomSheetState3, stateCollectAsStateWithLifecycle, mutableState, i12, i13, (LazyStaggeredGridScope) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            } else {
                fixed = fixed2;
                m0Var = m0Var2;
                mutableState = mutableState2;
                z10 = true;
            }
            LazyStaggeredGridDslKt.m1921LazyVerticalStaggeredGrid6qCrX9Q(fixed, modifierFillMaxSize$default, lazyStaggeredGridState, paddingValuesM1718PaddingValues0680j_4, false, fM8823constructorimpl, horizontalOrVerticalM1613spacedBy0680j_4, null, false, null, (Function1) objRememberedValue3, composer, 1772592, 0, 912);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(581564565, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StatusListScreenKt.StatusListScreen$lambda$0$5(modalBottomSheetState, statusListViewModel, it, m0Var, navHostController, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54);
            int i14 = ModalBottomSheetState.$stable;
            ModalKt.Modal(modalBottomSheetState, composableLambdaRememberComposableLambda, composer, i14 | 48);
            ModalKt.Modal(modalBottomSheetState2, ComposableLambdaKt.rememberComposableLambda(-1360988980, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StatusListScreenKt.StatusListScreen$lambda$0$6(modalBottomSheetState2, statusListViewModel, it, m0Var, navHostController, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, i14 | 48);
            ModalKt.Modal(modalBottomSheetState3, ComposableLambdaKt.rememberComposableLambda(-197407795, z10, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StatusListScreenKt.StatusListScreen$lambda$0$7(navHostController, statusListViewModel, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, i14 | 48);
            boolean zChangedInstance = composer.changedInstance(statusListViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$8$0(statusListViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.SideEffect((lb.a) objRememberedValue4, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(statusListViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$9$0(statusListViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.SideEffect((lb.a) objRememberedValue5, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    private static final StatusWithPartnersOrRooms StatusListScreen$lambda$0$0(State<StatusWithPartnersOrRooms> state) {
        return state.getValue();
    }

    private static final FollowState StatusListScreen$lambda$0$2(MutableState<FollowState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0(final LazyPagingItems lazyPagingItems, final StatusListViewModel statusListViewModel, final NavHostController navHostController, final pe.m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final ModalBottomSheetState modalBottomSheetState2, final ModalBottomSheetState modalBottomSheetState3, final State state, final MutableState mutableState, final int i10, final int i11, LazyStaggeredGridScope LazyVerticalStaggeredGrid) {
        kotlin.jvm.internal.y.i(LazyVerticalStaggeredGrid, "$this$LazyVerticalStaggeredGrid");
        StaggeredGridItemSpan.Companion companion = StaggeredGridItemSpan.INSTANCE;
        LazyStaggeredGridScope.CC.a(LazyVerticalStaggeredGrid, null, null, companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(-1966862294, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.l
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0(statusListViewModel, navHostController, m0Var, modalBottomSheetState, modalBottomSheetState2, modalBottomSheetState3, state, mutableState, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyStaggeredGridScope.CC.b(LazyVerticalStaggeredGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$1((StatusWithPartnersOrRooms) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$2((StatusWithPartnersOrRooms) obj);
            }
        }), null, ComposableLambdaKt.composableLambdaInstance(249760227, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusList.l0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$3(lazyPagingItems, statusListViewModel, navHostController, i10, i11, (LazyStaggeredGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 8, null);
        LazyStaggeredGridScope.CC.a(LazyVerticalStaggeredGrid, null, null, companion.getFullLine(), ComposableLambdaKt.composableLambdaInstance(-185113773, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.m0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$4(lazyPagingItems, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        ComposableSingletons$StatusListScreenKt composableSingletons$StatusListScreenKt = ComposableSingletons$StatusListScreenKt.INSTANCE;
        LazyStaggeredGridScope.CC.a(LazyVerticalStaggeredGrid, null, null, null, composableSingletons$StatusListScreenKt.getLambda$2107542194$app_productionPFast(), 7, null);
        LazyStaggeredGridScope.CC.a(LazyVerticalStaggeredGrid, null, null, null, composableSingletons$StatusListScreenKt.getLambda$105230865$app_productionPFast(), 7, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00a5  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0(final StatusListViewModel statusListViewModel, final NavHostController navHostController, final pe.m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final ModalBottomSheetState modalBottomSheetState2, final ModalBottomSheetState modalBottomSheetState3, State state, MutableState mutableState, LazyStaggeredGridItemScope item, Composer composer, int i10) {
        boolean z10;
        Status status;
        Status status2;
        Status status3;
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1966862294, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusListScreen.kt:129)");
            }
            StatusWithPartnersOrRooms statusWithPartnersOrRoomsStatusListScreen$lambda$0$0 = StatusListScreen$lambda$0$0(state);
            FollowState followStateStatusListScreen$lambda$0$2 = StatusListScreen$lambda$0$2(mutableState);
            String photoUrl = statusListViewModel.owner().getPhotoUrl();
            String alias = statusListViewModel.owner().getAlias();
            String toDusId = statusListViewModel.owner().getToDusId();
            StatusWithPartnersOrRooms statusWithPartnersOrRoomsStatusListScreen$lambda$0$1 = StatusListScreen$lambda$0$0(state);
            String repliedId = null;
            String creatorId = (statusWithPartnersOrRoomsStatusListScreen$lambda$0$1 == null || (status3 = statusWithPartnersOrRoomsStatusListScreen$lambda$0$1.getStatus()) == null) ? null : status3.getCreatorId();
            StatusWithPartnersOrRooms statusWithPartnersOrRoomsStatusListScreen$lambda$0$2 = StatusListScreen$lambda$0$0(state);
            if (kotlin.jvm.internal.y.d(creatorId, (statusWithPartnersOrRoomsStatusListScreen$lambda$0$2 == null || (status2 = statusWithPartnersOrRoomsStatusListScreen$lambda$0$2.getStatus()) == null) ? null : status2.getRepliedId())) {
                StatusWithPartnersOrRooms statusWithPartnersOrRoomsStatusListScreen$lambda$0$3 = StatusListScreen$lambda$0$0(state);
                if (statusWithPartnersOrRoomsStatusListScreen$lambda$0$3 != null && (status = statusWithPartnersOrRoomsStatusListScreen$lambda$0$3.getStatus()) != null) {
                    repliedId = status.getRepliedId();
                }
                if (kotlin.jvm.internal.y.d(repliedId, statusListViewModel.owner().getNameWithDomain())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(statusListViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0$0$0(navHostController, statusListViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar = (lb.a) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0$1$0(m0Var, modalBottomSheetState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar2 = (lb.a) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.i0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0$2$0(m0Var, modalBottomSheetState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            lb.a aVar3 = (lb.a) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(navHostController);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.j0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0$3$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            lb.a aVar4 = (lb.a) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState3);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.k0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$4$0$0$4$0(m0Var, modalBottomSheetState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            YourStatusItem(statusWithPartnersOrRoomsStatusListScreen$lambda$0$0, followStateStatusListScreen$lambda$0$2, photoUrl, alias, toDusId, z10, aVar, aVar2, aVar3, aVar4, (lb.a) objRememberedValue5, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0$0$0(NavHostController navHostController, StatusListViewModel statusListViewModel) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = statusListViewModel.getGson().t(new StatusEditorParams(null, null, null, 7, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0$1$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new StatusListScreenKt$StatusListScreen$1$1$1$1$2$1$1(modalBottomSheetState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0$2$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new StatusListScreenKt$StatusListScreen$1$1$1$1$3$1$1(modalBottomSheetState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0$3$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$0$4$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new StatusListScreenKt$StatusListScreen$1$1$1$1$5$1$1(modalBottomSheetState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StatusListScreen$lambda$0$4$0$1(StatusWithPartnersOrRooms s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getStatus().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StatusListScreen$lambda$0$4$0$2(StatusWithPartnersOrRooms s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getStatus().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$4$0$3(LazyPagingItems lazyPagingItems, final StatusListViewModel statusListViewModel, final NavHostController navHostController, int i10, int i11, LazyStaggeredGridItemScope items, int i12, Composer composer, int i13) {
        int i14;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i13 & 6) == 0) {
            i14 = i13 | (composer.changed(items) ? 4 : 2);
        } else {
            i14 = i13;
        }
        if ((i13 & 48) == 0) {
            i14 |= composer.changed(i12) ? 32 : 16;
        }
        if (composer.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(249760227, i14, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusListScreen.kt:172)");
            }
            final StatusWithPartnersOrRooms statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) lazyPagingItems.get(i12);
            if (statusWithPartnersOrRooms != null) {
                composer.startReplaceGroup(1723700396);
                Modifier modifierA = androidx.compose.foundation.lazy.staggeredgrid.o.a(items, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(5), 7, null), null, null, null, 2, null);
                boolean zChangedInstance = composer.changedInstance(statusListViewModel) | composer.changed(statusWithPartnersOrRooms) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.r
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusListScreenKt.StatusListScreen$lambda$0$4$0$3$0$0(statusListViewModel, statusWithPartnersOrRooms, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                StatusItemKt.StatusFeedItem(ClickableKt.m1240clickableoSLSa3U$default(modifierA, false, null, null, null, (lb.a) objRememberedValue, 15, null), statusWithPartnersOrRooms, i10, i11, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1724926105);
                StatusItemKt.StatusPreviewItemPlaceholder(composer, 0);
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
    public static final ua.k0 StatusListScreen$lambda$0$4$0$3$0$0(final StatusListViewModel statusListViewModel, final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final NavHostController navHostController) {
        statusListViewModel.getStatusPosition(statusWithPartnersOrRooms.getStatus().getId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusListScreenKt.StatusListScreen$lambda$0$4$0$3$0$0$0(navHostController, statusListViewModel, statusWithPartnersOrRooms, (Pair) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$4$0$3$0$0$0(NavHostController navHostController, StatusListViewModel statusListViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms, Pair it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = statusListViewModel.getGson().t(new StatusPreviewParams(((Boolean) it.getFirst()).booleanValue(), ((Number) it.getSecond()).intValue(), statusWithPartnersOrRooms.getStatus().getId()));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$4$0$4(LazyPagingItems lazyPagingItems, LazyStaggeredGridItemScope item, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-185113773, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusListScreen.kt:204)");
            }
            PagerStateIndicatorKt.PagerStateIndicator(null, null, null, null, lazyPagingItems, composer, LazyPagingItems.$stable << 12, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$5(final ModalBottomSheetState modalBottomSheetState, StatusListViewModel statusListViewModel, Modifier modifier, final pe.m0 m0Var, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(581564565, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous> (StatusListScreen.kt:217)");
            }
            if (modalBottomSheetState.getCurrentValue() == ModalBottomSheetValue.Expanded) {
                composer.startReplaceGroup(537802878);
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
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
                LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(statusListViewModel.followers(statusListViewModel.owner().getNameWithDomain()), null, composer, 0, 1);
                ModalKt.ModalIndicator(composer, 0);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(20)), StringResources_androidKt.stringResource(R.string.followers, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 6, 56);
                boolean zChangedInstance = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusListScreenKt.StatusListScreen$lambda$0$5$0$0$0(m0Var, modalBottomSheetState, navHostController, (FollowPartner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusListScreenKt.StatusListScreen$lambda$0$5$0$1$0((FollowPartner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                UserCommonListKt.UserCommonList(modifier, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, function1, (Function1) objRememberedValue2, null, statusListViewModel.owner().getNameWithDomain(), null, null, composer, (LazyPagingItems.$stable << 6) | 24576, TypedValues.CycleType.TYPE_PATH_ROTATE);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(537843590);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composer, 0, 15);
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
    public static final ua.k0 StatusListScreen$lambda$0$5$0$0$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState, NavHostController navHostController, FollowPartner it) {
        kotlin.jvm.internal.y.i(it, "it");
        pe.k.d(m0Var, null, null, new StatusListScreenKt$StatusListScreen$1$2$1$1$1$1(modalBottomSheetState, m0Var, navHostController, it, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$5$0$1$0(FollowPartner it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$6(final ModalBottomSheetState modalBottomSheetState, StatusListViewModel statusListViewModel, Modifier modifier, final pe.m0 m0Var, final NavHostController navHostController, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1360988980, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous> (StatusListScreen.kt:259)");
            }
            if (modalBottomSheetState.getCurrentValue() == ModalBottomSheetValue.Expanded) {
                composer.startReplaceGroup(2054619893);
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
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
                LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(statusListViewModel.following(statusListViewModel.owner().getNameWithDomain()), null, composer, 0, 1);
                ModalKt.ModalIndicator(composer, 0);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(20)), StringResources_androidKt.stringResource(R.string.following, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 6, 56);
                boolean zChangedInstance = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusListScreenKt.StatusListScreen$lambda$0$6$0$0$0(m0Var, modalBottomSheetState, navHostController, (FollowPartner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusListScreenKt.StatusListScreen$lambda$0$6$0$1$0((FollowPartner) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                UserCommonListKt.UserCommonList(modifier, lazyListStateRememberLazyListState, lazyPagingItemsCollectAsLazyPagingItems, function1, (Function1) objRememberedValue2, null, statusListViewModel.owner().getNameWithDomain(), null, null, composer, (LazyPagingItems.$stable << 6) | 24576, TypedValues.CycleType.TYPE_PATH_ROTATE);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2054660605);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composer, 0, 15);
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
    public static final ua.k0 StatusListScreen$lambda$0$6$0$0$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState, NavHostController navHostController, FollowPartner it) {
        kotlin.jvm.internal.y.i(it, "it");
        pe.k.d(m0Var, null, null, new StatusListScreenKt$StatusListScreen$1$3$1$1$1$1(modalBottomSheetState, m0Var, navHostController, it, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$6$0$1$0(FollowPartner it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusListScreen$lambda$0$7(final NavHostController navHostController, final StatusListViewModel statusListViewModel, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-197407795, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.StatusListScreen.<anonymous>.<anonymous> (StatusListScreen.kt:301)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(f10));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ModalKt.ModalIndicator(composer, 0);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.share_content_through, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            DividerKt.m2630DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer, 0, 15);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            float f11 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            lb.a constructor2 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
            Color.Companion companion4 = Color.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, companion4.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), " 1 ", null, companion4.m5903getWhite0d7_KjU(), 0, 0, composer, 3120, 52);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.select_type_of_content, composer, 0), null, 0L, 0, 0, composer, 0, 61);
            composer.endNode();
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), " | ", null, 0L, 0, 0, composer, 48, 60);
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs2);
            lb.a constructor3 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), companion4.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), " 2 ", null, companion4.m5903getWhite0d7_KjU(), 0, 0, composer, 3120, 52);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.config_interest_data, composer, 0), null, 0L, 0, 0, composer, 0, 61);
            composer.endNode();
            Z17LabelKt.m10262Z17LabelfWhpE4E(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), " | ", null, 0L, 0, 0, composer, 48, 60);
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f11));
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer, 48);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs3);
            lb.a constructor4 = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), companion4.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), " 3 ", null, companion4.m5903getWhite0d7_KjU(), 0, 0, composer, 3120, 52);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.hit_share_btn, composer, 0), null, 0L, 0, 0, composer, 0, 61);
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(15)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.get_started, composer, 0);
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(statusListViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.q
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.StatusListScreen$lambda$0$7$0$3$0(navHostController, statusListViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17PrimaryButton(null, (lb.a) objRememberedValue, strStringResource, null, true, false, composer, 24576, 41);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
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
    public static final ua.k0 StatusListScreen$lambda$0$7$0$3$0(NavHostController navHostController, StatusListViewModel statusListViewModel) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = statusListViewModel.getGson().t(new StatusEditorParams(null, null, null, 7, null));
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$8$0(StatusListViewModel statusListViewModel) {
        statusListViewModel.updateClosed();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$9$0(StatusListViewModel statusListViewModel, final MutableState mutableState) {
        statusListViewModel.getFollowState(statusListViewModel.owner().getNameWithDomain(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusListScreenKt.StatusListScreen$lambda$0$9$0$0(mutableState, (FollowState) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$0$9$0$0(MutableState mutableState, FollowState followState) {
        mutableState.setValue(followState);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusListScreen$lambda$1(NavHostController navHostController, StatusListViewModel statusListViewModel, int i10, int i11, Composer composer, int i12) {
        StatusListScreen(navHostController, statusListViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void YourStatusItem(final StatusWithPartnersOrRooms statusWithPartnersOrRooms, FollowState followState, final String ownerPicture, final String ownerName, String ownerToDusId, final boolean z10, final lb.a goNewStatus, final lb.a onFollowersClick, final lb.a onFollowingClick, final lb.a navigateUp, final lb.a onMoreOptionsCLicked, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z11;
        int i13;
        final FollowState followState2;
        String str;
        int i14;
        MaterialTheme materialTheme;
        Modifier.Companion companion;
        float f10;
        float f11;
        int i15;
        int i16;
        kotlin.jvm.internal.y.i(ownerPicture, "ownerPicture");
        kotlin.jvm.internal.y.i(ownerName, "ownerName");
        kotlin.jvm.internal.y.i(ownerToDusId, "ownerToDusId");
        kotlin.jvm.internal.y.i(goNewStatus, "goNewStatus");
        kotlin.jvm.internal.y.i(onFollowersClick, "onFollowersClick");
        kotlin.jvm.internal.y.i(onFollowingClick, "onFollowingClick");
        kotlin.jvm.internal.y.i(navigateUp, "navigateUp");
        kotlin.jvm.internal.y.i(onMoreOptionsCLicked, "onMoreOptionsCLicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(1555410046);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(statusWithPartnersOrRooms) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(followState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerPicture) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerName) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerToDusId) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            z11 = z10;
            i12 |= composerStartRestartGroup.changed(z11) ? 131072 : 65536;
        } else {
            z11 = z10;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(goNewStatus) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onFollowersClick) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onFollowingClick) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(navigateUp) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i13 = i11 | (composerStartRestartGroup.changedInstance(onMoreOptionsCLicked) ? 4 : 2);
        } else {
            i13 = i11;
        }
        if (composerStartRestartGroup.shouldExecute(((i12 & 306783379) == 306783378 && (i13 & 3) == 2) ? false : true, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1555410046, i12, i13, "cu.todus.android.uiCompose.main.screen.statusList.YourStatusItem (StatusListScreen.kt:416)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            int i17 = i13;
            float f12 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(f12));
            Brush.Companion companion3 = Brush.INSTANCE;
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i18 = MaterialTheme.$stable;
            float f13 = 10;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierM1725padding3ABfNKs, Brush.Companion.m5827verticalGradient8A3gB4$default(companion3, va.w.q(Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i18).getInversePrimary()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i18).getInversePrimary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)), 0.0f, 4, null), Dp.m8823constructorimpl(f13));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            lb.a constructor2 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            lb.a constructor3 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(40));
            ComposableSingletons$StatusListScreenKt composableSingletons$StatusListScreenKt = ComposableSingletons$StatusListScreenKt.INSTANCE;
            IconButtonKt.IconButton(navigateUp, modifierM1769size3ABfNKs, false, null, null, null, composableSingletons$StatusListScreenKt.m9990getLambda$1181519748$app_productionPFast(), composerStartRestartGroup, ((i12 >> 27) & 14) | 1572912, 60);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.explore_status, composerStartRestartGroup, 0), materialTheme2.getTypography(composerStartRestartGroup, i18).getTitleSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion2, Dp.m8823constructorimpl(f12)), composerStartRestartGroup, 6);
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(f13), 0.0f, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            lb.a constructor4 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
            if (statusWithPartnersOrRooms != null) {
                composerStartRestartGroup.startReplaceGroup(1009612273);
                boolean z12 = (i12 & 3670016) == 1048576;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.r0
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusListScreenKt.YourStatusItem$lambda$0$0$1$0$0(goNewStatus);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float f14 = 8;
                Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(2), materialTheme2.getColorScheme(composerStartRestartGroup, i18).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f14)));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1216borderxT4_qwU);
                lb.a constructor5 = companion5.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion5.getSetModifier());
                StatusItemKt.StatusItem(ClipKt.clip(companion2, RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f14))), statusWithPartnersOrRooms.getStatus().getContent(), true, false, false, false, 80, z11, null, composerStartRestartGroup, ((i12 << 6) & 29360128) | 1573248, 312);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                companion = companion2;
                materialTheme = materialTheme2;
                f10 = f13;
                f11 = f12;
                i15 = i12;
                i14 = i18;
                i16 = 0;
            } else {
                composerStartRestartGroup.startReplaceGroup(1009640984);
                boolean z13 = (i12 & 3670016) == 1048576;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.m
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusListScreenKt.YourStatusItem$lambda$0$0$1$2$0(goNewStatus);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                float f15 = 8;
                i14 = i18;
                materialTheme = materialTheme2;
                companion = companion2;
                f10 = f13;
                f11 = f12;
                i15 = i12;
                i16 = 0;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(ClipKt.clip(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue2, 15, null), Dp.m8823constructorimpl(80)), Dp.m8823constructorimpl(2), materialTheme2.getColorScheme(composerStartRestartGroup, i18).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f15))), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f15))), ownerPicture, Integer.valueOf(R.drawable.profile), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, ((i12 >> 3) & 112) | 24576, 488);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierA = e3.a(rowScopeInstance, PaddingKt.m1726paddingVpY3zN4(companion, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(f11)), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composerStartRestartGroup, i16);
            int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i16));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierA);
            lb.a constructor6 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion5.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, ownerName, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getTitleMedium(), 0L, TextUnitKt.getSp(18), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), 0L, 0, 0, composerStartRestartGroup, (i15 >> 6) & 112, 57);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("@");
            str = ownerToDusId;
            sb2.append(str);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, sb2.toString(), materialTheme.getTypography(composerStartRestartGroup, i14).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            followState2 = followState;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, followState != null ? 1 : i16, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1685957789, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatusListScreenKt.YourStatusItem$lambda$0$0$1$3$0(onFollowersClick, onFollowingClick, followState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1600518, 18);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f11)), composerStartRestartGroup, 6);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(f10), 0.0f, 2, null), StringResources_androidKt.stringResource(R.string.share_for_get_badges, composerStartRestartGroup, i16), materialTheme.getTypography(composerStartRestartGroup, i14).getLabelSmall(), 0L, 0, 0, composerStartRestartGroup, 6, 56);
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
            int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i16));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs3);
            lb.a constructor7 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor7);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyRowMeasurePolicy3, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion5.getSetModifier());
            int i19 = (i15 & 3670016) == 1048576 ? 1 : i16;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (i19 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusListScreenKt.YourStatusItem$lambda$0$0$2$0$0(goNewStatus);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(e3.a(rowScopeInstance, ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null), 1.0f, false, 2, null), materialTheme.getColorScheme(composerStartRestartGroup, i14).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(50))), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion4.getCenterVertically(), composerStartRestartGroup, 54);
            int iA8 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i16));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs4);
            lb.a constructor8 = companion5.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor8);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl8 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl8, measurePolicyRowMeasurePolicy4, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl8, currentCompositionLocalMap8, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl8, Integer.valueOf(iA8), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl8, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl8, modifierMaterializeModifier8, companion5.getSetModifier());
            ImageVector add = AddKt.getAdd(Icons.Outlined.INSTANCE);
            Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24));
            ColorFilter.Companion companion6 = ColorFilter.INSTANCE;
            Color.Companion companion7 = Color.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs2, add, null, ColorFilter.Companion.m5907tintxETnrds$default(companion6, companion7.m5903getWhite0d7_KjU(), 0, 2, null), null, "go status list", 0, null, null, composerStartRestartGroup, 199686, 468);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.new_status, composerStartRestartGroup, i16), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), companion7.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 49);
            composerStartRestartGroup.endNode();
            IconButtonKt.IconButton(onMoreOptionsCLicked, BorderKt.m1216borderxT4_qwU(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl((float) 0.2d), Color.m5865copywmQWz5c$default(companion7.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), false, null, null, null, composableSingletons$StatusListScreenKt.getLambda$215954804$app_productionPFast(), composerStartRestartGroup, (i17 & 14) | 1572864, 60);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            followState2 = followState;
            str = ownerToDusId;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = str;
            final FollowState followState3 = followState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusListScreenKt.YourStatusItem$lambda$1(statusWithPartnersOrRooms, followState3, ownerPicture, ownerName, str2, z10, goNewStatus, onFollowersClick, onFollowingClick, navigateUp, onMoreOptionsCLicked, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$0$0$1$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$0$0$1$2$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 YourStatusItem$lambda$0$0$1$3$0(final lb.a aVar, final lb.a aVar2, FollowState followState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1685957789, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.YourStatusItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusListScreen.kt:524)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(10), 0.0f, 0.0f, 13, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Horizontal start = arrangement.getStart();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer, 0);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1729paddingqDBjuR0$default);
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier modifierA = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.v
                @Override // lb.a
                public final Object invoke() {
                    return StatusListScreenKt.YourStatusItem$lambda$0$0$1$3$0$0$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierA, false, null, null, null, (lb.a) objRememberedValue, 15, null);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default);
        lb.a constructor2 = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        String strLikeCounterFormat = NumberInlineFunctionsKt.likeCounterFormat(followState != null ? followState.getFollowersCount() : 0);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, strLikeCounterFormat, materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String strStringResource = StringResources_androidKt.stringResource(R.string.followers, composer, 0);
        Locale locale = Locale.ROOT;
        String lowerCase = strStringResource.toLowerCase(locale);
        kotlin.jvm.internal.y.h(lowerCase, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase, materialTheme.getTypography(composer, i11).getLabelSmall(), 0L, 0, 0, composer, 0, 57);
        composer.endNode();
        SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(15)), composer, 6);
        Modifier modifierA2 = e3.a(rowScopeInstance, companion, 1.0f, false, 2, null);
        boolean zChanged2 = composer.changed(aVar2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusList.x
                @Override // lb.a
                public final Object invoke() {
                    return StatusListScreenKt.YourStatusItem$lambda$0$0$1$3$0$0$2$0(aVar2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifierA2, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default2);
        lb.a constructor3 = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.likeCounterFormat(followState != null ? followState.getFollowingCount() : 0), materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String lowerCase2 = StringResources_androidKt.stringResource(R.string.following, composer, 0).toLowerCase(locale);
        kotlin.jvm.internal.y.h(lowerCase2, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase2, materialTheme.getTypography(composer, i11).getLabelSmall(), 0L, 0, 0, composer, 0, 57);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$0$0$1$3$0$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$0$0$1$3$0$0$2$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$0$0$2$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 YourStatusItem$lambda$1(StatusWithPartnersOrRooms statusWithPartnersOrRooms, FollowState followState, String str, String str2, String str3, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, lb.a aVar4, lb.a aVar5, int i10, int i11, Composer composer, int i12) {
        YourStatusItem(statusWithPartnersOrRooms, followState, str, str2, str3, z10, aVar, aVar2, aVar3, aVar4, aVar5, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11));
        return ua.k0.f43947a;
    }
}
