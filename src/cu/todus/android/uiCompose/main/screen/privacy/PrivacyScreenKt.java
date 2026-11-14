package cu.todus.android.uiCompose.main.screen.privacy;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckCircleKt;
import androidx.compose.material.icons.outlined.RadioButtonUncheckedKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
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
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.uiCompose.main.screen.createGroup.AvatarNameItemKt;
import cu.todus.android.uiCompose.shared.userCommonList.UserCommonListKt;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0091\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006#²\u0006\u000e\u0010\u001b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001c\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002²\u0006\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010!\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020\u00128\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/privacy/PrivacyViewModel;", "viewModel", "Lua/k0;", "PrivacyScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/privacy/PrivacyViewModel;Landroidx/compose/runtime/Composer;II)V", "", "title", "selected", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/Friend;", "friends", "ownerId", "", "excluded", "Lcu/todus/android/data/db/pojo/Partner;", "excludedPartners", "", "canExcludeContacts", "Lkotlin/Function1;", "onSelected", "onExcluded", "Lkotlin/Function0;", "onRefresh", "PrivacySelector", "(Ljava/lang/String;Ljava/lang/String;Landroidx/paging/compose/LazyPagingItems;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;II)V", "privacyOfProfileInfo", "privacyOfProfileLast", "privacyOfProfilePhoto", "privacyOfAdd", "privacyOfAddExcluded", "privacyOfAddExcludedPartner", "isLoading", "showExcludeSelect", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PrivacyScreenKt {
    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:63:0x0114  */
    /* JADX WARN: Code duplicated, block: B:66:0x0129  */
    /* JADX WARN: Code duplicated, block: B:69:0x0142  */
    /* JADX WARN: Code duplicated, block: B:72:0x015b  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a4  */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PrivacyScreen(final NavHostController navHostController, PrivacyViewModel privacyViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        Composer composer2;
        ?? r10;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        int i13;
        final PrivacyViewModel privacyViewModel2 = privacyViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1686241420);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            if ((i11 & 2) != 0) {
                i13 = 16;
            } else {
                if ((i10 & 64) == 0 ? composerStartRestartGroup.changed(privacyViewModel2) : composerStartRestartGroup.changedInstance(privacyViewModel2)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
            }
            i12 |= i13;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 2) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i14 &= -113;
                    r10 = 1;
                    privacyViewModel2 = (PrivacyViewModel) ViewModelKt.viewModel(z0.b(PrivacyViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1686241420, i14, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreen (PrivacyScreen.kt:64)");
                }
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(privacyViewModel2.friendsOnDbNoHeaders(""), null, composerStartRestartGroup, 0, r10);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(va.w.n(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(va.w.n(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState7 = (MutableState) objRememberedValue7;
                final PrivacyViewModel privacyViewModel3 = privacyViewModel2;
                composer2 = composerStartRestartGroup;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-478348120, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.t0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$21(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1766016170, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22(privacyViewModel3, lazyPagingItemsCollectAsLazyPagingItems, mutableState, mutableState7, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306806, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i14 &= -113;
                }
            }
            r10 = 1;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686241420, i14, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreen (PrivacyScreen.kt:64)");
            }
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(privacyViewModel2.friendsOnDbNoHeaders(""), null, composerStartRestartGroup, 0, r10);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState11 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(va.w.n(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState12 = (MutableState) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(va.w.n(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState13 = (MutableState) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState14 = (MutableState) objRememberedValue7;
            final PrivacyViewModel privacyViewModel4 = privacyViewModel2;
            composer2 = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(-478348120, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyScreenKt.PrivacyScreen$lambda$21(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1766016170, r10, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrivacyScreenKt.PrivacyScreen$lambda$22(privacyViewModel4, lazyPagingItemsCollectAsLazyPagingItems2, mutableState8, mutableState14, mutableState9, mutableState10, mutableState11, mutableState12, mutableState13, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.privacy.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrivacyScreenKt.PrivacyScreen$lambda$23(navHostController, privacyViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String PrivacyScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PrivacyScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> PrivacyScreen$lambda$13(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Partner> PrivacyScreen$lambda$16(MutableState<List<Partner>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PrivacyScreen$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrivacyScreen$lambda$20(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PrivacyScreen$lambda$21(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-478348120, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreen.<anonymous> (PrivacyScreen.kt:100)");
            }
            Function2 lambda$1419631669$app_productionPFast = ComposableSingletons$PrivacyScreenKt.INSTANCE.getLambda$1419631669$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.l0
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacyScreen$lambda$21$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(lambda$1419631669$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$21$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PrivacyScreen$lambda$22(final PrivacyViewModel privacyViewModel, LazyPagingItems lazyPagingItems, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, Modifier it, Composer composer, int i10) {
        int i11;
        Object obj;
        final MutableState mutableState8;
        final MutableState mutableState9;
        final MutableState mutableState10;
        Object obj2;
        final MutableState mutableState11;
        final MutableState mutableState12;
        final MutableState mutableState13;
        Object obj3;
        final MutableState mutableState14;
        final MutableState mutableState15;
        final MutableState mutableState16;
        Object obj4;
        final PrivacyViewModel privacyViewModel2;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766016170, i11, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreen.<anonymous> (PrivacyScreen.kt:114)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(it, 0.0f, 1, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(20), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getStart(), composer, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            lb.a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(R.string.who_can_see_your_profile_info, composer, 0);
            String strPrivacyScreen$lambda$1 = PrivacyScreen$lambda$1(mutableState);
            String nameWithDomain = privacyViewModel.owner().getNameWithDomain();
            List listN = va.w.n();
            List listN2 = va.w.n();
            boolean zChangedInstance = composer.changedInstance(privacyViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState8 = mutableState3;
                mutableState9 = mutableState4;
                obj = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$0$0(privacyViewModel, mutableState2, mutableState8, mutableState9, mutableState, (String) obj5);
                    }
                };
                mutableState10 = mutableState;
                composer.updateRememberedValue(obj);
            } else {
                mutableState8 = mutableState3;
                mutableState9 = mutableState4;
                obj = objRememberedValue;
                mutableState10 = mutableState;
            }
            Function1 function1 = (Function1) obj;
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$1$0((String) obj5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance2 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$2$0(privacyViewModel, mutableState10, mutableState8, mutableState9);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            int i12 = LazyPagingItems.$stable;
            PrivacySelector(strStringResource, strPrivacyScreen$lambda$1, lazyPagingItems, nameWithDomain, listN, listN2, false, function1, function2, (lb.a) objRememberedValue3, composer, (i12 << 6) | 100884480, 64);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.choose_who_can_see_you_last_time, composer, 0);
            String strPrivacyScreen$lambda$4 = PrivacyScreen$lambda$4(mutableState3);
            String nameWithDomain2 = privacyViewModel.owner().getNameWithDomain();
            List listN3 = va.w.n();
            List listN4 = va.w.n();
            boolean zChangedInstance3 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == companion4.getEmpty()) {
                obj2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$3$0(privacyViewModel, mutableState2, mutableState, mutableState4, mutableState3, (String) obj5);
                    }
                };
                mutableState11 = mutableState;
                mutableState12 = mutableState4;
                mutableState13 = mutableState3;
                composer.updateRememberedValue(obj2);
            } else {
                mutableState13 = mutableState3;
                mutableState12 = mutableState4;
                obj2 = objRememberedValue4;
                mutableState11 = mutableState;
            }
            Function1 function3 = (Function1) obj2;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$4$0((String) obj5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function4 = (Function1) objRememberedValue5;
            boolean zChangedInstance4 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.i0
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$5$0(privacyViewModel, mutableState13, mutableState11, mutableState12);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            PrivacySelector(strStringResource2, strPrivacyScreen$lambda$4, lazyPagingItems, nameWithDomain2, listN3, listN4, false, function3, function4, (lb.a) objRememberedValue6, composer, (i12 << 6) | 100884480, 64);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.who_can_see_your_profile_photo, composer, 0);
            String strPrivacyScreen$lambda$7 = PrivacyScreen$lambda$7(mutableState4);
            String nameWithDomain3 = privacyViewModel.owner().getNameWithDomain();
            List listN5 = va.w.n();
            List listN6 = va.w.n();
            boolean zChangedInstance5 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue7 == companion4.getEmpty()) {
                obj3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$6$0(privacyViewModel, mutableState2, mutableState, mutableState3, mutableState4, (String) obj5);
                    }
                };
                mutableState14 = mutableState;
                mutableState15 = mutableState3;
                mutableState16 = mutableState4;
                composer.updateRememberedValue(obj3);
            } else {
                mutableState15 = mutableState3;
                mutableState16 = mutableState4;
                obj3 = objRememberedValue7;
                mutableState14 = mutableState;
            }
            Function1 function5 = (Function1) obj3;
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == companion4.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$7$0((String) obj5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function1 function6 = (Function1) objRememberedValue8;
            boolean zChangedInstance6 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue9 == companion4.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.x
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$8$0(privacyViewModel, mutableState16, mutableState14, mutableState15);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            PrivacySelector(strStringResource3, strPrivacyScreen$lambda$7, lazyPagingItems, nameWithDomain3, listN5, listN6, false, function5, function6, (lb.a) objRememberedValue9, composer, (i12 << 6) | 100884480, 64);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.who_can_add_me_to_channel_or_group, composer, 0);
            String strPrivacyScreen$lambda$10 = PrivacyScreen$lambda$10(mutableState5);
            String nameWithDomain4 = privacyViewModel.owner().getNameWithDomain();
            List<String> listPrivacyScreen$lambda$13 = PrivacyScreen$lambda$13(mutableState6);
            List<Partner> listPrivacyScreen$lambda$16 = PrivacyScreen$lambda$16(mutableState7);
            boolean zChangedInstance7 = composer.changedInstance(privacyViewModel);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue10 == companion4.getEmpty()) {
                privacyViewModel2 = privacyViewModel;
                obj4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$9$0(privacyViewModel2, mutableState2, mutableState5, mutableState6, mutableState7, (String) obj5);
                    }
                };
                composer.updateRememberedValue(obj4);
            } else {
                obj4 = objRememberedValue10;
                privacyViewModel2 = privacyViewModel;
            }
            Function1 function7 = (Function1) obj4;
            boolean zChangedInstance8 = composer.changedInstance(privacyViewModel2);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue11 == companion4.getEmpty()) {
                Function1 function8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$10$0(privacyViewModel2, mutableState2, mutableState6, mutableState5, mutableState7, (String) obj5);
                    }
                };
                composer.updateRememberedValue(function8);
                objRememberedValue11 = function8;
            }
            Function1 function9 = (Function1) objRememberedValue11;
            boolean zChangedInstance9 = composer.changedInstance(privacyViewModel2);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue12 == companion4.getEmpty()) {
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$11$0(privacyViewModel2, mutableState5, mutableState6, mutableState7);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            PrivacySelector(strStringResource4, strPrivacyScreen$lambda$10, lazyPagingItems, nameWithDomain4, listPrivacyScreen$lambda$13, listPrivacyScreen$lambda$16, true, function7, function9, (lb.a) objRememberedValue12, composer, (i12 << 6) | 1572864, 0);
            composer.endNode();
            if (PrivacyScreen$lambda$19(mutableState2)) {
                composer.startReplaceGroup(1258797372);
                Object objRememberedValue13 = composer.rememberedValue();
                if (objRememberedValue13 == companion4.getEmpty()) {
                    objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.c0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue13);
                }
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue13, 15, null), 0.0f, 1, null), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
                lb.a constructor3 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composer, 0, 15);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(368362674);
                composer.endReplaceGroup();
            }
            composer.endNode();
            ua.k0 k0Var = ua.k0.f43947a;
            boolean zChangedInstance10 = composer.changedInstance(privacyViewModel2);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChangedInstance10 || objRememberedValue14 == companion4.getEmpty()) {
                PrivacyScreenKt$PrivacyScreen$2$2$1 privacyScreenKt$PrivacyScreen$2$2$1 = new PrivacyScreenKt$PrivacyScreen$2$2$1(privacyViewModel2, mutableState, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, null);
                composer.updateRememberedValue(privacyScreenKt$PrivacyScreen$2$2$1);
                objRememberedValue14 = privacyScreenKt$PrivacyScreen$2$2$1;
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue14, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$0$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3, final MutableState mutableState4, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        PrivacyScreen$lambda$20(mutableState, true);
        privacyViewModel.changePrivacyOfProfile(it, PrivacyScreen$lambda$4(mutableState2), PrivacyScreen$lambda$7(mutableState3), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$0$0$0(mutableState4, mutableState, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$0$0$0(MutableState mutableState, MutableState mutableState2, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.f());
        PrivacyScreen$lambda$20(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$1$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$10$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, String excluded) {
        ArrayList arrayList;
        kotlin.jvm.internal.y.i(excluded, "excluded");
        PrivacyScreen$lambda$20(mutableState, true);
        if (PrivacyScreen$lambda$13(mutableState2).contains(excluded)) {
            List<String> listPrivacyScreen$lambda$13 = PrivacyScreen$lambda$13(mutableState2);
            arrayList = new ArrayList();
            for (Object obj : listPrivacyScreen$lambda$13) {
                if (!kotlin.jvm.internal.y.d((String) obj, excluded)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = new ArrayList();
            arrayList.addAll(PrivacyScreen$lambda$13(mutableState2));
            arrayList.add(excluded);
        }
        mutableState2.setValue(arrayList);
        privacyViewModel.changePrivacyOfAddSetExcludes(PrivacyScreen$lambda$13(mutableState2), new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$10$0$1(mutableState3, mutableState2, mutableState4, mutableState, (String) obj2, (List) obj3, (List) obj4);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$10$0$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, String value, List excludes, List excludedPartners) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(excludes, "excludes");
        kotlin.jvm.internal.y.i(excludedPartners, "excludedPartners");
        mutableState.setValue(value);
        mutableState2.setValue(excludes);
        mutableState3.setValue(excludedPartners);
        PrivacyScreen$lambda$20(mutableState4, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$11$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3) {
        mutableState.setValue("");
        mutableState2.setValue(va.w.n());
        privacyViewModel.getPrivacyOfAdd(new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.v
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$11$0$0(mutableState, mutableState2, mutableState3, (String) obj, (List) obj2, (List) obj3);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$11$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String value, List excludes, List excludedPartners) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(excludes, "excludes");
        kotlin.jvm.internal.y.i(excludedPartners, "excludedPartners");
        mutableState.setValue(value);
        mutableState2.setValue(excludes);
        mutableState3.setValue(excludedPartners);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$2$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3) {
        mutableState.setValue("");
        privacyViewModel.getProfilePrivacy(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$2$0$0(mutableState, mutableState2, mutableState3, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$2$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.f());
        mutableState2.setValue((String) it.g());
        mutableState3.setValue((String) it.h());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$3$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3, final MutableState mutableState4, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        PrivacyScreen$lambda$20(mutableState, true);
        privacyViewModel.changePrivacyOfProfile(PrivacyScreen$lambda$1(mutableState2), it, PrivacyScreen$lambda$7(mutableState3), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$3$0$0(mutableState4, mutableState, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$3$0$0(MutableState mutableState, MutableState mutableState2, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.g());
        PrivacyScreen$lambda$20(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$4$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$5$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3) {
        mutableState.setValue("");
        privacyViewModel.getProfilePrivacy(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$5$0$0(mutableState2, mutableState, mutableState3, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$5$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.f());
        mutableState2.setValue((String) it.g());
        mutableState3.setValue((String) it.h());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$6$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3, final MutableState mutableState4, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        PrivacyScreen$lambda$20(mutableState, true);
        privacyViewModel.changePrivacyOfProfile(PrivacyScreen$lambda$1(mutableState2), PrivacyScreen$lambda$4(mutableState3), it, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$6$0$0(mutableState4, mutableState, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$6$0$0(MutableState mutableState, MutableState mutableState2, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.h());
        PrivacyScreen$lambda$20(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$7$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$8$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3) {
        mutableState.setValue("");
        privacyViewModel.getProfilePrivacy(new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$8$0$0(mutableState2, mutableState3, mutableState, (ua.y) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$8$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ua.y it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue((String) it.f());
        mutableState2.setValue((String) it.g());
        mutableState3.setValue((String) it.h());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$9$0(PrivacyViewModel privacyViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        PrivacyScreen$lambda$20(mutableState, true);
        privacyViewModel.changePrivacyOfAdd(it, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.w
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PrivacyScreenKt.PrivacyScreen$lambda$22$0$0$9$0$0(mutableState2, mutableState3, mutableState4, mutableState, (String) obj, (List) obj2, (List) obj3);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$22$0$0$9$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, String value, List excludes, List excludedPartners) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(excludes, "excludes");
        kotlin.jvm.internal.y.i(excludedPartners, "excludedPartners");
        mutableState.setValue(value);
        mutableState2.setValue(excludes);
        mutableState3.setValue(excludedPartners);
        PrivacyScreen$lambda$20(mutableState4, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacyScreen$lambda$23(NavHostController navHostController, PrivacyViewModel privacyViewModel, int i10, int i11, Composer composer, int i12) {
        PrivacyScreen(navHostController, privacyViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final String PrivacyScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PrivacyScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:228:0x07ea  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PrivacySelector(final String title, final String selected, final LazyPagingItems<Friend> friends, final String ownerId, final List<String> excluded, final List<Partner> excludedPartners, boolean z10, final Function1 onSelected, final Function1 onExcluded, lb.a onRefresh, Composer composer, final int i10, final int i11) {
        int i12;
        final lb.a aVar;
        Composer composer2;
        final boolean z11;
        Object obj;
        kotlin.jvm.internal.y.i(title, "title");
        kotlin.jvm.internal.y.i(selected, "selected");
        kotlin.jvm.internal.y.i(friends, "friends");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(excluded, "excluded");
        kotlin.jvm.internal.y.i(excludedPartners, "excludedPartners");
        kotlin.jvm.internal.y.i(onSelected, "onSelected");
        kotlin.jvm.internal.y.i(onExcluded, "onExcluded");
        kotlin.jvm.internal.y.i(onRefresh, "onRefresh");
        Composer composerStartRestartGroup = composer.startRestartGroup(-768408065);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(selected) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(friends) : composerStartRestartGroup.changedInstance(friends) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerId) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(excluded) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(excludedPartners) ? 131072 : 65536;
        }
        int i13 = i11 & 64;
        if (i13 != 0) {
            i12 |= 1572864;
        } else if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelected) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onExcluded) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onRefresh) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 306783379) != 306783378, i12 & 1)) {
            boolean z12 = i13 != 0 ? false : z10;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768408065, i12, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacySelector (PrivacyScreen.kt:305)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue == companion4.getEmpty()) {
                obj = null;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                obj = null;
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            Object obj2 = obj;
            int i15 = i12;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i14).getLabelLarge(), 0L, 0, 0, composerStartRestartGroup, (i12 << 3) & 112, 57);
            SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            if (kotlin.jvm.internal.y.d(selected, "")) {
                composerStartRestartGroup.startReplaceGroup(-1814037108);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, obj2);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), composerStartRestartGroup, 6);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                aVar = onRefresh;
            } else {
                if (kotlin.jvm.internal.y.d(selected, "error")) {
                    composerStartRestartGroup.startReplaceGroup(-1813758635);
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, obj2);
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), composerStartRestartGroup, 6);
                    int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                    lb.a constructor3 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(3));
                    boolean z13 = (i15 & C.ENCODING_PCM_DOUBLE) == 536870912;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue2 == companion4.getEmpty()) {
                        aVar = onRefresh;
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.o0
                            @Override // lb.a
                            public final Object invoke() {
                                return PrivacyScreenKt.PrivacySelector$lambda$0$4$0$0(aVar);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        aVar = onRefresh;
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1725padding3ABfNKs, false, null, null, null, ComposableSingletons$PrivacyScreenKt.INSTANCE.m9951getLambda$421551034$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    aVar = onRefresh;
                    composerStartRestartGroup.startReplaceGroup(80072442);
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, obj2);
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                    lb.a constructor4 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
                    int i16 = i15 & 112;
                    int i17 = i15 & 29360128;
                    boolean z14 = (i17 == 8388608) | (i16 == 32);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue3 == companion4.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.p0
                            @Override // lb.a
                            public final Object invoke() {
                                return PrivacyScreenKt.PrivacySelector$lambda$0$5$0$0(selected, onSelected);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
                    lb.a constructor5 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    float f11 = 30;
                    Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f11));
                    float f12 = 3;
                    Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(modifierM1769size3ABfNKs, 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 11, null);
                    ImageVector checkCircle = kotlin.jvm.internal.y.d(selected, "none") ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE);
                    ColorFilter.Companion companion5 = ColorFilter.INSTANCE;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, checkCircle, null, ColorFilter.Companion.m5907tintxETnrds$default(companion5, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.nobody, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    composerStartRestartGroup.endNode();
                    boolean z15 = (i16 == 32) | (i17 == 8388608);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue4 == companion4.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.q0
                            @Override // lb.a
                            public final Object invoke() {
                                return PrivacyScreenKt.PrivacySelector$lambda$0$5$2$0(selected, onSelected);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue4, 15, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA6 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
                    lb.a constructor6 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyRowMeasurePolicy4, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion3.getSetModifier());
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f11)), 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 11, null), kotlin.jvm.internal.y.d(selected, "all") ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion5, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.all, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    composerStartRestartGroup.endNode();
                    boolean z16 = (i17 == 8388608) | (i16 == 32);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z16 || objRememberedValue5 == companion4.getEmpty()) {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.r0
                            @Override // lb.a
                            public final Object invoke() {
                                return PrivacyScreenKt.PrivacySelector$lambda$0$5$4$0(selected, onSelected);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Modifier modifierM1240clickableoSLSa3U$default3 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue5, 15, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA7 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default3);
                    lb.a constructor7 = companion3.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyRowMeasurePolicy5, companion3.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion3.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion3.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion3.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion3.getSetModifier());
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f11)), 0.0f, 0.0f, Dp.m8823constructorimpl(f12), 0.0f, 11, null), kotlin.jvm.internal.y.d(selected, "contacts") ? CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE) : RadioButtonUncheckedKt.getRadioButtonUnchecked(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(companion5, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.contacts, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
                    composerStartRestartGroup.endNode();
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z12 && kotlin.jvm.internal.y.d(selected, "contacts"), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(2068737626, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.f
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return PrivacyScreenKt.PrivacySelector$lambda$0$5$6(mutableState, excluded, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
                    composer2 = composerStartRestartGroup;
                    boolean zPrivacySelector$lambda$0$1 = PrivacySelector$lambda$0$1(mutableState);
                    Object objRememberedValue6 = composer2.rememberedValue();
                    if (objRememberedValue6 == companion4.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.q
                            @Override // lb.a
                            public final Object invoke() {
                                return PrivacyScreenKt.PrivacySelector$lambda$0$5$7$0(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    Z17DialogsKt.Z17CustomDialog(zPrivacySelector$lambda$0$1, (lb.a) objRememberedValue6, ComposableLambdaKt.rememberComposableLambda(-682124508, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.privacy.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return PrivacyScreenKt.PrivacySelector$lambda$0$5$8(excludedPartners, lazyListStateRememberLazyListState2, onExcluded, lazyListStateRememberLazyListState, friends, ownerId, excluded, (lb.a) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composer2, 54), composer2, 432);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z11 = z12;
            }
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z11 = z12;
        } else {
            aVar = onRefresh;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z11 = z10;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final lb.a aVar2 = aVar;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.privacy.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return PrivacyScreenKt.PrivacySelector$lambda$1(title, selected, friends, ownerId, excluded, excludedPartners, z11, onSelected, onExcluded, aVar2, i10, i11, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final boolean PrivacySelector$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrivacySelector$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$4$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$0$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, "none")) {
            function1.invoke("none");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$2$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, "all")) {
            function1.invoke("all");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$4$0(String str, Function1 function1) {
        if (!kotlin.jvm.internal.y.d(str, "contacts")) {
            function1.invoke("contacts");
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PrivacySelector$lambda$0$5$6(final MutableState mutableState, List list, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2068737626, i10, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacySelector.<anonymous>.<anonymous>.<anonymous> (PrivacyScreen.kt:415)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.p
                @Override // lb.a
                public final Object invoke() {
                    return PrivacyScreenKt.PrivacySelector$lambda$0$5$6$0$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer, 48);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default);
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1774width3ABfNKs(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), Dp.m8823constructorimpl(0)), 0.0f, 0.0f, Dp.m8823constructorimpl(3), 0.0f, 11, null);
        ImageVector checkCircle = CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE);
        ColorFilter.Companion companion3 = ColorFilter.INSTANCE;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, checkCircle, null, ColorFilter.Companion.m5907tintxETnrds$default(companion3, materialTheme.getColorScheme(composer, i11).getBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.exceptions, composer, 0) + "(" + list.size() + ")", materialTheme.getTypography(composer, i11).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$6$0$0(MutableState mutableState) {
        PrivacySelector$lambda$0$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$7$0(MutableState mutableState) {
        PrivacySelector$lambda$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PrivacySelector$lambda$0$5$8(final List list, LazyListState lazyListState, final Function1 function1, LazyListState lazyListState2, LazyPagingItems lazyPagingItems, String str, final List list2, final lb.a onClose, Composer composer, int i10) {
        int i11;
        int i12;
        int i13;
        kotlin.jvm.internal.y.i(onClose, "onClose");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(onClose) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-682124508, i11, -1, "cu.todus.android.uiCompose.main.screen.privacy.PrivacySelector.<anonymous>.<anonymous>.<anonymous> (PrivacyScreen.kt:441)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i14 = i11 & 14;
            boolean z10 = i14 == 4;
            Object objRememberedValue = composer.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.k
                    @Override // lb.a
                    public final Object invoke() {
                        return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$0$0(onClose);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, columnScopeInstance.align(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(20), 0.0f, 2, null), companion2.getEnd()), false, null, null, null, ComposableSingletons$PrivacyScreenKt.INSTANCE.getLambda$342309648$app_productionPFast(), composer, 1572864, 60);
            Composer composer2 = composer;
            if (list.isEmpty()) {
                i12 = i14;
                i13 = 4;
                composer2.startReplaceGroup(1866431604);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1048210928);
                Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(companion, 0.0f, Dp.m8823constructorimpl(100), 1, null);
                boolean zChangedInstance = composer2.changedInstance(list) | composer2.changed(function1) | (i14 == 4);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$1$0(list, function1, onClose, (LazyListScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                i12 = i14;
                i13 = 4;
                LazyDslKt.LazyRow(modifierM1754defaultMinSizeVpY3zN4$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(300));
            boolean zChanged = composer2.changed(function1) | (i12 == i13);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$2$0(function1, onClose, (Friend) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            Object objRememberedValue4 = composer2.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue4 == companion4.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$3$0((Friend) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            Function1 function3 = (Function1) objRememberedValue4;
            boolean zChangedInstance2 = composer2.changedInstance(list2);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion4.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$4$0(list2, (Friend) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            UserCommonListKt.UserCommonList(modifierM1755height3ABfNKs, lazyListState2, lazyPagingItems, function2, function3, null, str, (Function1) objRememberedValue5, null, composer2, (LazyPagingItems.$stable << 6) | 24582, 288);
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
    public static final ua.k0 PrivacySelector$lambda$0$5$8$0$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$8$0$1$0(final List list, final Function1 function1, final lb.a aVar, LazyListScope LazyRow) {
        kotlin.jvm.internal.y.i(LazyRow, "$this$LazyRow");
        ComposableSingletons$PrivacyScreenKt composableSingletons$PrivacyScreenKt = ComposableSingletons$PrivacyScreenKt.INSTANCE;
        LazyListScope.CC.m(LazyRow, null, null, composableSingletons$PrivacyScreenKt.m9949getLambda$1826065194$app_productionPFast(), 3, null);
        final Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacyScreenKt.PrivacySelector$lambda$0$5$8$0$1$0$0((Partner) obj);
            }
        };
        final PrivacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$1 privacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Partner partner) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Partner) obj);
            }
        };
        LazyRow.items(list.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return function2.invoke(list.get(i10));
            }
        }, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return privacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacySelector$lambda$0$5$8$0$1$0$$inlined$items$default$4
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
                final Partner partner = (Partner) list.get(i10);
                composer.startReplaceGroup(1120985903);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(lazyItemScope, Modifier.INSTANCE, null, null, null, 2, null);
                String name = partner.getName();
                String thumbnailPicture = partner.getThumbnailPicture();
                boolean zChanged = composer.changed(function1) | composer.changed(partner) | composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    final lb.a aVar2 = aVar;
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.privacy.PrivacyScreenKt$PrivacySelector$1$3$9$1$2$1$2$1$1
                        @Override // lb.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m9952invoke();
                            return ua.k0.f43947a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m9952invoke() {
                            function3.invoke(partner.getUser().getUsername());
                            aVar2.invoke();
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
        LazyListScope.CC.m(LazyRow, null, null, composableSingletons$PrivacyScreenKt.m9950getLambda$315878643$app_productionPFast(), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object PrivacySelector$lambda$0$5$8$0$1$0$0(Partner selected) {
        kotlin.jvm.internal.y.i(selected, "selected");
        return selected.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$8$0$2$0(Function1 function1, lb.a aVar, Friend userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        function1.invoke(userCommon.getContact().getPhone());
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$0$5$8$0$3$0(Friend userCommon) {
        kotlin.jvm.internal.y.i(userCommon, "userCommon");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PrivacySelector$lambda$0$5$8$0$4$0(List list, Friend friend) {
        Contact contact;
        return va.g0.j0(list, (friend == null || (contact = friend.getContact()) == null) ? null : contact.getPhone()) ? "✅" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PrivacySelector$lambda$1(String str, String str2, LazyPagingItems lazyPagingItems, String str3, List list, List list2, boolean z10, Function1 function1, Function1 function2, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        PrivacySelector(str, str2, lazyPagingItems, str3, list, list2, z10, function1, function2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }
}
