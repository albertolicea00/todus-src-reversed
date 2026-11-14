package cu.todus.android.uiCompose.main.screen.socialProfile;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImplKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewParams;
import cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailData;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0010²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/socialProfile/SocialProfileViewModel;", "viewModel", "Lua/k0;", "SocialProfileScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/socialProfile/SocialProfileViewModel;Landroidx/compose/runtime/Composer;II)V", "", "isLoading", "Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;", "profileDetail", "Lcu/todus/android/data/xmpp/FollowState;", "profileState", "loadingProfileStateChange", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SocialProfileScreenKt {
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    /* JADX WARN: Code duplicated, block: B:70:0x0125  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SocialProfileScreen(final NavHostController navHostController, final String uid, SocialProfileViewModel socialProfileViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        final SocialProfileViewModel socialProfileViewModel2;
        boolean z10;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        int i13;
        SocialProfileViewModel socialProfileViewModel3 = socialProfileViewModel;
        y.i(navHostController, "navHostController");
        y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1995385631);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i13 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(socialProfileViewModel3) : composerStartRestartGroup.changedInstance(socialProfileViewModel3)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i14 &= -897;
                    z10 = 1;
                    socialProfileViewModel3 = (SocialProfileViewModel) ViewModelKt.viewModel(z0.b(SocialProfileViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1995385631, i14, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen (SocialProfileScreen.kt:76)");
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue4;
                final int i15 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
                final int i16 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(socialProfileViewModel3.profileStatus(uid), null, composerStartRestartGroup, 0, z10);
                final LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final SocialProfileViewModel socialProfileViewModel4 = socialProfileViewModel3;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(440348973, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$12(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-32478997, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13(lazyStaggeredGridStateRememberLazyStaggeredGridState, socialProfileViewModel4, context, lazyPagingItemsCollectAsLazyPagingItems, navHostController, i15, i16, uid, mutableState, mutableState2, mutableState3, mutableState4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                socialProfileViewModel2 = socialProfileViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i14 &= -897;
                }
            }
            z10 = 1;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1995385631, i14, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen (SocialProfileScreen.kt:76)");
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue4;
            final int i17 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp;
            final int i18 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(socialProfileViewModel3.profileStatus(uid), null, composerStartRestartGroup, 0, z10);
            final LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final SocialProfileViewModel socialProfileViewModel5 = socialProfileViewModel3;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(440348973, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$12(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-32478997, z10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$13(lazyStaggeredGridStateRememberLazyStaggeredGridState2, socialProfileViewModel5, context2, lazyPagingItemsCollectAsLazyPagingItems2, navHostController, i17, i18, uid, mutableState5, mutableState6, mutableState7, mutableState8, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306806, 376);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            socialProfileViewModel2 = socialProfileViewModel5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            socialProfileViewModel2 = socialProfileViewModel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$14(navHostController, uid, socialProfileViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean SocialProfileScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final boolean SocialProfileScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SocialProfileScreen$lambda$11(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SocialProfileScreen$lambda$12(NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(440348973, i10, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous> (SocialProfileScreen.kt:109)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableSingletons$SocialProfileScreenKt.INSTANCE.m9984getLambda$1890213888$app_productionPFast(), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 SocialProfileScreen$lambda$13(LazyStaggeredGridState lazyStaggeredGridState, final SocialProfileViewModel socialProfileViewModel, final Context context, final LazyPagingItems lazyPagingItems, final NavHostController navHostController, final int i10, final int i11, String str, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Modifier it, Composer composer, int i12) {
        int i13;
        SocialProfileViewModel socialProfileViewModel2;
        y.i(it, "it");
        if ((i12 & 6) == 0) {
            i13 = i12 | (composer.changed(it) ? 4 : 2);
        } else {
            i13 = i12;
        }
        if (composer.shouldExecute((i13 & 19) != 18, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-32478997, i13, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous> (SocialProfileScreen.kt:120)");
            }
            if (SocialProfileScreen$lambda$1(mutableState)) {
                composer.startReplaceGroup(-1147544232);
                LoadingScreenKt.LoadingWall(composer, 0);
                composer.endReplaceGroup();
                socialProfileViewModel2 = socialProfileViewModel;
            } else if (SocialProfileScreen$lambda$4(mutableState2) != null) {
                composer.startReplaceGroup(-1213498903);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(it, 0.0f, 1, null);
                StaggeredGridCells.Fixed fixed = new StaggeredGridCells.Fixed(2);
                float f10 = 4;
                float fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f10));
                PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
                boolean zChangedInstance = composer.changedInstance(socialProfileViewModel) | composer.changedInstance(context) | composer.changedInstance(lazyPagingItems) | composer.changedInstance(navHostController) | composer.changed(i10) | composer.changed(i11);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0(lazyPagingItems, mutableState2, mutableState3, socialProfileViewModel, context, mutableState4, navHostController, i10, i11, (LazyStaggeredGridScope) obj);
                        }
                    };
                    composer.updateRememberedValue(function1);
                    objRememberedValue = function1;
                }
                socialProfileViewModel2 = socialProfileViewModel;
                LazyStaggeredGridDslKt.m1921LazyVerticalStaggeredGrid6qCrX9Q(fixed, modifierFillMaxSize$default, lazyStaggeredGridState, paddingValuesM1718PaddingValues0680j_4, false, fM8823constructorimpl, horizontalOrVerticalM1613spacedBy0680j_4, null, false, null, (Function1) objRememberedValue, composer, 1772544, 0, 912);
                composer.endReplaceGroup();
            } else {
                socialProfileViewModel2 = socialProfileViewModel;
                composer.startReplaceGroup(-1195916137);
                composer.endReplaceGroup();
            }
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance2 = composer.changedInstance(socialProfileViewModel2) | composer.changed(str) | composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                SocialProfileScreenKt$SocialProfileScreen$2$2$1 socialProfileScreenKt$SocialProfileScreen$2$2$1 = new SocialProfileScreenKt$SocialProfileScreen$2$2$1(socialProfileViewModel2, str, mutableState2, mutableState, navHostController, mutableState3, null);
                composer.updateRememberedValue(socialProfileScreenKt$SocialProfileScreen$2$2$1);
                objRememberedValue2 = socialProfileScreenKt$SocialProfileScreen$2$2$1;
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0(final LazyPagingItems lazyPagingItems, final MutableState mutableState, final MutableState mutableState2, final SocialProfileViewModel socialProfileViewModel, final Context context, final MutableState mutableState3, final NavHostController navHostController, final int i10, final int i11, LazyStaggeredGridScope LazyVerticalStaggeredGrid) {
        y.i(LazyVerticalStaggeredGrid, "$this$LazyVerticalStaggeredGrid");
        LazyStaggeredGridScope.CC.a(LazyVerticalStaggeredGrid, null, null, StaggeredGridItemSpan.INSTANCE.getFullLine(), ComposableLambdaKt.composableLambdaInstance(576745137, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.s
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0(mutableState, mutableState2, socialProfileViewModel, context, mutableState3, (LazyStaggeredGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyStaggeredGridScope.CC.b(LazyVerticalStaggeredGrid, lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$1((StatusWithPartnersOrRooms) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$2((StatusWithPartnersOrRooms) obj);
            }
        }), null, ComposableLambdaKt.composableLambdaInstance(-209682984, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.e
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$3(lazyPagingItems, socialProfileViewModel, navHostController, i10, i11, (LazyStaggeredGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 8, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SocialProfileScreen$lambda$13$0$0$0(final MutableState mutableState, final MutableState mutableState2, final SocialProfileViewModel socialProfileViewModel, final Context context, final MutableState mutableState3, LazyStaggeredGridItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576745137, i10, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialProfileScreen.kt:131)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(ComposerImplKt.nodeKey));
            ColorGenerator.Companion companion4 = ColorGenerator.INSTANCE;
            ColorGenerator material = companion4.getMATERIAL();
            AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$4 = SocialProfileScreen$lambda$4(mutableState);
            y.f(authorsDetailDataSocialProfileScreen$lambda$4);
            BoxKt.Box(SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1755height3ABfNKs, ColorKt.Color(material.getColor(authorsDetailDataSocialProfileScreen$lambda$4.getCreatorName())), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(0))), Dp.m8823constructorimpl(10)), 0.0f, 1, null), composer, 0);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), 0.0f, Dp.m8823constructorimpl(50), 0.0f, 0.0f, 13, null), Dp.m8823constructorimpl(150));
            AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$5 = SocialProfileScreen$lambda$4(mutableState);
            y.f(authorsDetailDataSocialProfileScreen$lambda$5);
            String creatorImage = authorsDetailDataSocialProfileScreen$lambda$5.getCreatorImage();
            ColorGenerator material2 = companion4.getMATERIAL();
            AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$6 = SocialProfileScreen$lambda$4(mutableState);
            y.f(authorsDetailDataSocialProfileScreen$lambda$6);
            Color colorM5856boximpl = Color.m5856boximpl(Z17InlineUtilsKt.m10307darkerDxMtmZc(ColorKt.Color(material2.getColor(authorsDetailDataSocialProfileScreen$lambda$6.getCreatorName())), 0.2f));
            AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$4(mutableState);
            y.f(authorsDetailDataSocialProfileScreen$lambda$7);
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(modifierM1769size3ABfNKs, creatorImage, colorM5856boximpl, null, null, 0, null, false, null, authorsDetailDataSocialProfileScreen$lambda$7.getCreatorName(), true, 0, composer, 0, 6, 2552);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, SocialProfileScreen$lambda$7(mutableState2) != null, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(715759911, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0(socialProfileViewModel, context, mutableState, mutableState3, mutableState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            float f10 = 15;
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composer, 54);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
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
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$8 = SocialProfileScreen$lambda$4(mutableState);
            y.f(authorsDetailDataSocialProfileScreen$lambda$8);
            String creatorName = authorsDetailDataSocialProfileScreen$lambda$8.getCreatorName();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, creatorName, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composer, i11).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 0, 25, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
            FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState2);
            if (followStateSocialProfileScreen$lambda$7 == null || !followStateSocialProfileScreen$lambda$7.isFollowingU()) {
                composer.startReplaceGroup(940268807);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-800960057);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.is_following_u, composer, 0), materialTheme.getTypography(composer, i11).getLabelSmall(), 0L, 0, 0, composer, 0, 57);
                composer.endReplaceGroup();
            }
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(5)), composer, 6);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, SocialProfileScreen$lambda$7(mutableState2) != null, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-975817584, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$2(mutableState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1600518, 18);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer, 6);
            composer.endNode();
            composer.endNode();
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0(final SocialProfileViewModel socialProfileViewModel, final Context context, final MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        final MutableState mutableState4;
        String strStringResource;
        Composer composer2 = composer;
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(715759911, i10, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialProfileScreen.kt:167)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composer2, 54);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion2.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        String nameWithDomain = socialProfileViewModel.getOwner().getNameWithDomain();
        AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$4 = SocialProfileScreen$lambda$4(mutableState);
        if (y.d(nameWithDomain, authorsDetailDataSocialProfileScreen$lambda$4 != null ? authorsDetailDataSocialProfileScreen$lambda$4.getRepliedId() : null)) {
            composer2.startReplaceGroup(-1893670640);
            BoxKt.Box(companion, composer2, 6);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1893811594);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            float f10 = 5;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(BorderKt.m1216borderxT4_qwU(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer2, i11).getBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(1), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer2, i11).getOnBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(6), Dp.m8823constructorimpl(3));
            boolean zChangedInstance = composer2.changedInstance(socialProfileViewModel);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState4 = mutableState3;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.k
                    @Override // lb.a
                    public final Object invoke() {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0(socialProfileViewModel, mutableState2, mutableState4, mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                mutableState4 = mutableState3;
            }
            lb.a aVar = (lb.a) objRememberedValue;
            FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState4);
            if (followStateSocialProfileScreen$lambda$7 == null || !followStateSocialProfileScreen$lambda$7.isFollowed()) {
                composer2.startReplaceGroup(-1893676729);
                strStringResource = StringResources_androidKt.stringResource(R.string.follow, composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1893679671);
                strStringResource = StringResources_androidKt.stringResource(R.string.unfollow, composer2, 0);
                composer2.endReplaceGroup();
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(modifierM1726paddingVpY3zN4, aVar, strStringResource, null, false, true, false, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 88);
            composer2 = composer;
            composer2.endReplaceGroup();
        }
        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24));
        boolean zChangedInstance2 = composer2.changedInstance(context);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.l
                @Override // lb.a
                public final Object invoke() {
                    return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$1$0(context, mutableState);
                }
            };
            composer2.updateRememberedValue(objRememberedValue2);
        }
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs, false, null, null, null, (lb.a) objRememberedValue2, 15, null), ShareKt.getShare(Icons.Outlined.INSTANCE), null, null, null, null, 0, null, null, composer2, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0(SocialProfileViewModel socialProfileViewModel, final MutableState mutableState, final MutableState mutableState2, MutableState mutableState3) {
        if (!SocialProfileScreen$lambda$10(mutableState)) {
            SocialProfileScreen$lambda$11(mutableState, true);
            FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState2);
            if (followStateSocialProfileScreen$lambda$7 == null || !followStateSocialProfileScreen$lambda$7.isFollowed()) {
                AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$4 = SocialProfileScreen$lambda$4(mutableState3);
                y.f(authorsDetailDataSocialProfileScreen$lambda$4);
                socialProfileViewModel.follow(authorsDetailDataSocialProfileScreen$lambda$4.getCreatorId(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.h
                    @Override // lb.a
                    public final Object invoke() {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$2(mutableState2, mutableState);
                    }
                }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.i
                    @Override // lb.a
                    public final Object invoke() {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$3(mutableState);
                    }
                });
            } else {
                AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$5 = SocialProfileScreen$lambda$4(mutableState3);
                y.f(authorsDetailDataSocialProfileScreen$lambda$5);
                socialProfileViewModel.unFollow(authorsDetailDataSocialProfileScreen$lambda$5.getCreatorId(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.f
                    @Override // lb.a
                    public final Object invoke() {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$0(mutableState2, mutableState);
                    }
                }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.g
                    @Override // lb.a
                    public final Object invoke() {
                        return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$1(mutableState);
                    }
                });
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$0(MutableState mutableState, MutableState mutableState2) {
        FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState);
        mutableState.setValue(followStateSocialProfileScreen$lambda$7 != null ? FollowState.copy$default(followStateSocialProfileScreen$lambda$7, false, false, 0, 0, 14, null) : null);
        SocialProfileScreen$lambda$11(mutableState2, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$1(MutableState mutableState) {
        SocialProfileScreen$lambda$11(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$2(MutableState mutableState, MutableState mutableState2) {
        FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState);
        mutableState.setValue(followStateSocialProfileScreen$lambda$7 != null ? FollowState.copy$default(followStateSocialProfileScreen$lambda$7, true, false, 0, 0, 14, null) : null);
        SocialProfileScreen$lambda$11(mutableState2, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$0$0$3(MutableState mutableState) {
        SocialProfileScreen$lambda$11(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$0$0$1$0(Context context, MutableState mutableState) {
        IntentUtil intentUtil = IntentUtil.INSTANCE;
        AuthorsDetailData authorsDetailDataSocialProfileScreen$lambda$4 = SocialProfileScreen$lambda$4(mutableState);
        intentUtil.shareText(context, "Perfil Social", "https://chat.todus.cu/social-profile/" + (authorsDetailDataSocialProfileScreen$lambda$4 != null ? authorsDetailDataSocialProfileScreen$lambda$4.getCreatorToDusId() : null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SocialProfileScreen$lambda$13$0$0$0$0$0$0$2(MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-975817584, i10, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialProfileScreen.kt:352)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.HorizontalOrVertical center = arrangement.getCenter();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, companion2.getTop(), composer, 6);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
        int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
        FollowState followStateSocialProfileScreen$lambda$7 = SocialProfileScreen$lambda$7(mutableState);
        String strLikeCounterFormat = NumberInlineFunctionsKt.likeCounterFormat(followStateSocialProfileScreen$lambda$7 != null ? followStateSocialProfileScreen$lambda$7.getFollowersCount() : 0);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, strLikeCounterFormat, materialTheme.getTypography(composer, i11).getTitleSmall(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String strStringResource = StringResources_androidKt.stringResource(R.string.followers, composer, 0);
        Locale locale = Locale.ROOT;
        String lowerCase = strStringResource.toLowerCase(locale);
        y.h(lowerCase, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase, null, 0L, 0, 0, composer, 0, 61);
        composer.endNode();
        SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(15)), composer, 6);
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer, 48);
        int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
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
        FollowState followStateSocialProfileScreen$lambda$8 = SocialProfileScreen$lambda$7(mutableState);
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.likeCounterFormat(followStateSocialProfileScreen$lambda$8 != null ? followStateSocialProfileScreen$lambda$8.getFollowingCount() : 0), materialTheme.getTypography(composer, i11).getTitleSmall(), 0L, 0, 10, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
        String lowerCase2 = StringResources_androidKt.stringResource(R.string.following, composer, 0).toLowerCase(locale);
        y.h(lowerCase2, "toLowerCase(...)");
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, lowerCase2, null, 0L, 0, 0, composer, 0, 61);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SocialProfileScreen$lambda$13$0$0$1(StatusWithPartnersOrRooms s10) {
        y.i(s10, "s");
        return s10.getStatus().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SocialProfileScreen$lambda$13$0$0$2(StatusWithPartnersOrRooms s10) {
        y.i(s10, "s");
        return s10.getStatus().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SocialProfileScreen$lambda$13$0$0$3(LazyPagingItems lazyPagingItems, final SocialProfileViewModel socialProfileViewModel, final NavHostController navHostController, int i10, int i11, LazyStaggeredGridItemScope items, int i12, Composer composer, int i13) {
        int i14;
        y.i(items, "$this$items");
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
                ComposerKt.traceEventStart(-209682984, i14, -1, "cu.todus.android.uiCompose.main.screen.socialProfile.SocialProfileScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialProfileScreen.kt:398)");
            }
            final StatusWithPartnersOrRooms statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) lazyPagingItems.get(i12);
            if (statusWithPartnersOrRooms != null) {
                composer.startReplaceGroup(-1783180615);
                Modifier modifierA = androidx.compose.foundation.lazy.staggeredgrid.o.a(items, PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(5), 7, null), null, null, null, 2, null);
                boolean zChangedInstance = composer.changedInstance(socialProfileViewModel) | composer.changed(statusWithPartnersOrRooms) | composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.r
                        @Override // lb.a
                        public final Object invoke() {
                            return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$3$0$0(socialProfileViewModel, statusWithPartnersOrRooms, navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                StatusItemKt.StatusFeedItem(ClickableKt.m1240clickableoSLSa3U$default(modifierA, false, null, null, null, (lb.a) objRememberedValue, 15, null), statusWithPartnersOrRooms, i10, i11, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1781864324);
                StatusItemKt.StatusPreviewItemPlaceholder(composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$3$0$0(final SocialProfileViewModel socialProfileViewModel, final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final NavHostController navHostController) {
        socialProfileViewModel.getStatusPosition(statusWithPartnersOrRooms.getStatus().getId(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.socialProfile.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialProfileScreenKt.SocialProfileScreen$lambda$13$0$0$3$0$0$0(navHostController, socialProfileViewModel, statusWithPartnersOrRooms, ((Integer) obj).intValue());
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$13$0$0$3$0$0$0(NavHostController navHostController, SocialProfileViewModel socialProfileViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms, int i10) {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = socialProfileViewModel.getGson().t(new StatusPreviewParams(false, i10, statusWithPartnersOrRooms.getStatus().getId()));
        y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusPreview(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SocialProfileScreen$lambda$14(NavHostController navHostController, String str, SocialProfileViewModel socialProfileViewModel, int i10, int i11, Composer composer, int i12) {
        SocialProfileScreen(navHostController, str, socialProfileViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SocialProfileScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final AuthorsDetailData SocialProfileScreen$lambda$4(MutableState<AuthorsDetailData> mutableState) {
        return mutableState.getValue();
    }

    private static final FollowState SocialProfileScreen$lambda$7(MutableState<FollowState> mutableState) {
        return mutableState.getValue();
    }
}
