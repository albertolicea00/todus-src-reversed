package cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.BlockKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.LockOpenKt;
import androidx.compose.material.icons.outlined.PhoneKt;
import androidx.compose.material.icons.outlined.TagFacesKt;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
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
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.RichTitleDescBtnKt;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018²\u0006\u000e\u0010\u0014\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewP2P/PreviewP2PViewModel;", "viewModel", "", "showTopBar", "Lua/k0;", "PreviewP2PScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewP2P/PreviewP2PViewModel;ZLandroidx/compose/runtime/Composer;II)V", "", "image", "contentString", "titleString", "Lkotlin/Function0;", "onClick", "onCall", "RowNumberDataButton", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "isLoading", "showChangeSecretState", "Lcu/z17/views/permission/PermissionsRequesterState;", "callPermissionsState", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewP2PScreenKt {
    /* JADX WARN: Code duplicated, block: B:71:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:74:0x0143  */
    /* JADX WARN: Code duplicated, block: B:77:0x0158  */
    /* JADX WARN: Code duplicated, block: B:80:0x016d  */
    /* JADX WARN: Code duplicated, block: B:83:0x018c  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:87:0x021f  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [androidx.compose.material.DrawerState, androidx.compose.material.SnackbarHostState] */
    /* JADX WARN: Type inference failed for: r11v6 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewP2PScreen(final NavHostController navHostController, final String uid, PreviewP2PViewModel previewP2PViewModel, boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        PreviewP2PViewModel previewP2PViewModel2;
        boolean z11;
        final PreviewP2PViewModel previewP2PViewModel3;
        final boolean z12;
        int i13;
        PreviewP2PViewModel previewP2PViewModel4;
        PreviewP2PViewModel previewP2PViewModel5;
        boolean z13;
        final Context context;
        Composer composer2;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        int i14;
        ?? r11;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-43798257);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(uid) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) == 0) {
                previewP2PViewModel2 = previewP2PViewModel;
                int i15 = composerStartRestartGroup.changedInstance(previewP2PViewModel2) ? 256 : 128;
                i12 |= i15;
            } else {
                previewP2PViewModel2 = previewP2PViewModel;
            }
            i12 |= i15;
        } else {
            previewP2PViewModel2 = previewP2PViewModel;
        }
        int i16 = i11 & 8;
        if (i16 != 0) {
            i12 |= 3072;
            z11 = z10;
        } else {
            z11 = z10;
            if ((i10 & 3072) == 0) {
                i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    int i17 = i12;
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(PreviewP2PViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    previewP2PViewModel4 = (PreviewP2PViewModel) viewModel;
                    i13 = i17 & (-897);
                } else {
                    i13 = i12;
                    previewP2PViewModel4 = previewP2PViewModel2;
                }
                previewP2PViewModel5 = previewP2PViewModel4;
                i12 = i13;
                if (i16 != 0) {
                    z13 = true;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-43798257, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreen (PreviewP2PScreen.kt:80)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getPreviewPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final int i18 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsBlocked(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                objRememberedValue = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    Object systemService = context.getSystemService("clipboard");
                    kotlin.jvm.internal.y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    objRememberedValue3 = (ClipboardManager) systemService;
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                final ClipboardManager clipboardManager = (ClipboardManager) objRememberedValue3;
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    i14 = 3;
                    r11 = 0;
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO, PermissionNeedIt.CALLS), 1, null), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    i14 = 3;
                    r11 = 0;
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue4;
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(r11, r11, composer2, 0, i14);
                previewP2PViewModel3 = previewP2PViewModel5;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(482804059, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewP2PScreenKt.PreviewP2PScreen$lambda$10(navHostController, stateCollectAsStateWithLifecycle, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1580964633, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11(stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle2, previewP2PViewModel3, uid, context, mutableState, i18, navHostController, stateCollectAsStateWithLifecycle3, clipboardManager, stateCollectAsStateWithLifecycle4, mutableState3, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                composerStartRestartGroup = composer2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, !z13, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306758, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z12 = z13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
                previewP2PViewModel5 = previewP2PViewModel2;
            }
            z13 = z11;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43798257, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreen (PreviewP2PScreen.kt:80)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getPreviewPartner(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final int i19 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(previewP2PViewModel5.getIsBlocked(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            objRememberedValue = composer2.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue;
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                Object systemService2 = context.getSystemService("clipboard");
                kotlin.jvm.internal.y.g(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
                objRememberedValue3 = (ClipboardManager) systemService2;
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final ClipboardManager clipboardManager2 = (ClipboardManager) objRememberedValue3;
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                i14 = 3;
                r11 = 0;
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO, PermissionNeedIt.CALLS), 1, null), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                i14 = 3;
                r11 = 0;
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue4;
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(r11, r11, composer2, 0, i14);
            previewP2PViewModel3 = previewP2PViewModel5;
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(482804059, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$10(navHostController, stateCollectAsStateWithLifecycle5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1580964633, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11(stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle6, previewP2PViewModel3, uid, context, mutableState4, i19, navHostController, stateCollectAsStateWithLifecycle7, clipboardManager2, stateCollectAsStateWithLifecycle8, mutableState6, mutableState5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            composerStartRestartGroup = composer2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda3, !z13, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, composableLambdaRememberComposableLambda4, composerStartRestartGroup, 805306758, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z12 = z13;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            previewP2PViewModel3 = previewP2PViewModel2;
            z12 = z11;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$12(navHostController, uid, previewP2PViewModel3, z12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PreviewP2PScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewP2PScreen$lambda$10(NavHostController navHostController, final State state, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(482804059, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreen.<anonymous> (PreviewP2PScreen.kt:123)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(-1208554194, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$10$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, false, null, false, navHostController, null, null, 0L, 0L, 0.0f, composer, 6, 0, 2014);
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
    public static final k0 PreviewP2PScreen$lambda$10$0(State state, Composer composer, int i10) {
        String name;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1208554194, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreen.<anonymous>.<anonymous> (PreviewP2PScreen.kt:125)");
            }
            Partner partner = (Partner) state.getValue();
            if (partner == null || (name = partner.getName()) == null) {
                name = "";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, name, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 PreviewP2PScreen$lambda$11(State state, State state2, final PreviewP2PViewModel previewP2PViewModel, final String str, Context context, final MutableState mutableState, int i10, final NavHostController navHostController, State state3, final ClipboardManager clipboardManager, State state4, final MutableState mutableState2, final MutableState mutableState3, Modifier m10, Composer composer, int i11) {
        int i12;
        final Context context2;
        MaterialTheme materialTheme;
        String phone;
        Composer composer2 = composer;
        kotlin.jvm.internal.y.i(m10, "m");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer2.changed(m10) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer2.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580964633, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PScreen.<anonymous> (PreviewP2PScreen.kt:134)");
            }
            if (state.getValue() == null || PreviewP2PScreen$lambda$1(mutableState)) {
                str = str;
                context2 = context;
                composer2.startReplaceGroup(-93926556);
                LoadingScreenKt.LoadingWall(composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-93642038);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(m10), 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer2, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierVerticalScroll$default);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 2));
                Object value = state.getValue();
                kotlin.jvm.internal.y.f(value);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1755height3ABfNKs, ((Partner) value).getPicture(), Integer.valueOf(R.drawable.profile), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composer, 24576, 488);
                Composer composer3 = composer;
                float f10 = 0;
                float f11 = 20;
                Modifier modifierClip = ClipKt.clip(OffsetKt.m1684offsetVpY3zN4(IntrinsicKt.height(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), IntrinsicSize.Max), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f11))), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, materialTheme2.getColorScheme(composer3, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl(f11));
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composer3, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1725padding3ABfNKs);
                lb.a constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                final Partner partner = (Partner) state.getValue();
                if (partner == null) {
                    composer3.startReplaceGroup(-1400250872);
                    composer3.endReplaceGroup();
                    context2 = context;
                    i13 = i13;
                    materialTheme = materialTheme2;
                } else {
                    composer3.startReplaceGroup(-1400250871);
                    Contact contact = partner.getContact();
                    if (contact == null || (phone = contact.getPhone()) == null || phone.length() <= 0) {
                        context2 = context;
                        composer3.startReplaceGroup(-859151076);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-860500320);
                        ImageVector phone2 = PhoneKt.getPhone(Icons.Outlined.INSTANCE);
                        String str2 = "+" + partner.getContact().getPhone();
                        String strStringResource = StringResources_androidKt.stringResource(R.string.phone_number, composer3, 0);
                        boolean zChanged = composer3.changed(partner) | composer3.changedInstance(clipboardManager);
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.i
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$0$0(partner, clipboardManager);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        lb.a aVar = (lb.a) objRememberedValue;
                        context2 = context;
                        boolean zChangedInstance = composer3.changedInstance(previewP2PViewModel) | composer3.changed(partner) | composer3.changedInstance(context2);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.j
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$1$0(previewP2PViewModel, partner, mutableState2, context2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        RowNumberDataButton(phone2, str2, strStringResource, aVar, (lb.a) objRememberedValue2, composer, 0);
                        composer3 = composer;
                        composer3.endReplaceGroup();
                    }
                    int i14 = R.drawable.icon_monocrome;
                    String str3 = "@" + partner.getUser().getToDusId();
                    long primary = materialTheme2.getColorScheme(composer3, i13).getPrimary();
                    Integer numValueOf = Integer.valueOf(i14);
                    boolean zChanged2 = composer3.changed(partner) | composer3.changedInstance(clipboardManager);
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.k
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$2$0(partner, clipboardManager);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    materialTheme = materialTheme2;
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(numValueOf, str3, null, primary, (lb.a) objRememberedValue3, composer3, 0, 4);
                    Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                    ImageVector info = InfoKt.getInfo(outlined);
                    composer3.startReplaceGroup(-45103426);
                    String bio = partner.getBio();
                    if (d0.q0(bio)) {
                        bio = StringResources_androidKt.stringResource(R.string.i_use_todus, composer3, 0);
                    }
                    String str4 = bio;
                    composer3.endReplaceGroup();
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.bio, composer3, 0);
                    Object objRememberedValue4 = composer3.rememberedValue();
                    Composer.Companion companion4 = Composer.INSTANCE;
                    if (objRememberedValue4 == companion4.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.l
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    RichTitleDescBtnKt.RichTitleDescBtn(info, strStringResource2, str4, (lb.a) objRememberedValue4, composer3, 3072);
                    ImageVector block = BlockKt.getBlock(outlined);
                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.blocked_contacts_cant_send_msg, composer3, 0);
                    String strStringResource4 = StringResources_androidKt.stringResource(((Boolean) state4.getValue()).booleanValue() ? R.string.unblock : R.string.block, composer3, 0);
                    boolean zChangedInstance2 = composer3.changedInstance(previewP2PViewModel) | composer3.changed(str);
                    Object objRememberedValue5 = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == companion4.getEmpty()) {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.m
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$5$0(previewP2PViewModel, str, mutableState);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(block, strStringResource4, strStringResource3, 0L, (lb.a) objRememberedValue5, composer3, 0, 8);
                    k0 k0Var = k0.f43947a;
                    composer3.endReplaceGroup();
                }
                DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1726paddingVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(5)), 0.0f, materialTheme.getColorScheme(composer3, i13).getTertiary(), composer, 6, 2);
                ImageVector lockOpen = ((Boolean) state2.getValue()).booleanValue() ? LockOpenKt.getLockOpen(Icons.Outlined.INSTANCE) : LockKt.getLock(Icons.Outlined.INSTANCE);
                String strStringResource5 = StringResources_androidKt.stringResource(((Boolean) state2.getValue()).booleanValue() ? R.string.pull_out_secret : R.string.make_it_secret, composer, 0);
                String strStringResource6 = StringResources_androidKt.stringResource(((Boolean) state2.getValue()).booleanValue() ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer, 0);
                Object objRememberedValue6 = composer.rememberedValue();
                Composer.Companion companion5 = Composer.INSTANCE;
                if (objRememberedValue6 == companion5.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.n
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$1$0(mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(lockOpen, strStringResource5, strStringResource6, 0L, (lb.a) objRememberedValue6, composer, 24576, 8);
                Icons.Outlined outlined2 = Icons.Outlined.INSTANCE;
                ImageVector folder = FolderKt.getFolder(outlined2);
                String strStringResource7 = StringResources_androidKt.stringResource(R.string.folder, composer, 0);
                String strStringResource8 = StringResources_androidKt.stringResource(R.string.find_the_chat_attachments, composer, 0);
                boolean zChangedInstance3 = composer.changedInstance(navHostController) | composer.changed(str);
                Object objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue7 == companion5.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.p
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$2$0(navHostController, str);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(folder, strStringResource7, strStringResource8, 0L, (lb.a) objRememberedValue7, composer, 0, 8);
                ImageVector tagFaces = TagFacesKt.getTagFaces(outlined2);
                String strStringResource9 = StringResources_androidKt.stringResource(R.string.social_profile, composer, 0);
                String strStringResource10 = StringResources_androidKt.stringResource(R.string.search_the_media_shared, composer, 0);
                boolean zChangedInstance4 = composer.changedInstance(navHostController) | composer.changed(str);
                Object objRememberedValue8 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue8 == companion5.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.q
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$3$0(navHostController, str);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(tagFaces, strStringResource9, strStringResource10, 0L, (lb.a) objRememberedValue8, composer, 0, 8);
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(16), 0.0f, 2, null);
                boolean z10 = !((Boolean) state3.getValue()).booleanValue();
                boolean zChangedInstance5 = composer.changedInstance(previewP2PViewModel) | composer.changed(str);
                Object objRememberedValue9 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue9 == companion5.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$4$0(previewP2PViewModel, str, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default, z10, (Function1) objRememberedValue9, ComposableSingletons$PreviewP2PScreenKt.INSTANCE.getLambda$2010895254$app_productionPFast(), StringResources_androidKt.stringResource(R.string.notifications, composer, 0), null, null, composer, 3078, 96);
                composer.endNode();
                composer.endNode();
                String strStringResource11 = StringResources_androidKt.stringResource(((Boolean) state2.getValue()).booleanValue() ? R.string.pull_out_secret : R.string.make_it_secret, composer, 0);
                String strStringResource12 = StringResources_androidKt.stringResource(((Boolean) state2.getValue()).booleanValue() ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer, 0);
                String strStringResource13 = StringResources_androidKt.stringResource(R.string.ok, composer, 0);
                String strStringResource14 = StringResources_androidKt.stringResource(R.string.no, composer, 0);
                boolean zPreviewP2PScreen$lambda$4 = PreviewP2PScreen$lambda$4(mutableState3);
                Object objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == companion5.getEmpty()) {
                    objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.z
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$1$0(mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                lb.a aVar2 = (lb.a) objRememberedValue10;
                boolean zChangedInstance6 = composer.changedInstance(previewP2PViewModel) | composer.changed(str);
                Object objRememberedValue11 = composer.rememberedValue();
                if (zChangedInstance6 || objRememberedValue11 == companion5.getEmpty()) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.e
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$2$0(previewP2PViewModel, str, mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                Z17DialogsKt.Z17DialogWithActions(zPreviewP2PScreen$lambda$4, aVar2, (lb.a) objRememberedValue11, null, strStringResource11, strStringResource12, strStringResource13, strStringResource14, composer, 48, 8);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            PermissionsRequesterState permissionsRequesterStatePreviewP2PScreen$lambda$8 = PreviewP2PScreen$lambda$8(mutableState2);
            Object objRememberedValue12 = composer2.rememberedValue();
            Composer.Companion companion6 = Composer.INSTANCE;
            if (objRememberedValue12 == companion6.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$3$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue12);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, null, permissionsRequesterStatePreviewP2PScreen$lambda$8, (Function1) objRememberedValue12, ComposableSingletons$PreviewP2PScreenKt.INSTANCE.m9920getLambda$404446855$app_productionPFast(), composer, 27648, 3);
            PermissionsRequesterState permissionsRequesterStatePreviewP2PScreen$lambda$9 = PreviewP2PScreen$lambda$8(mutableState2);
            String packageName = context2.getPackageName();
            kotlin.jvm.internal.y.h(packageName, "getPackageName(...)");
            Object objRememberedValue13 = composer.rememberedValue();
            if (objRememberedValue13 == companion6.getEmpty()) {
                objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.g
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$4$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue13);
            }
            lb.a aVar3 = (lb.a) objRememberedValue13;
            Object objRememberedValue14 = composer.rememberedValue();
            if (objRememberedValue14 == companion6.getEmpty()) {
                objRememberedValue14 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$5$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue14);
            }
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterStatePreviewP2PScreen$lambda$9, aVar3, (Function1) objRememberedValue14, packageName, composer, 432);
            k0 k0Var2 = k0.f43947a;
            boolean zChangedInstance7 = composer.changedInstance(previewP2PViewModel) | composer.changed(str);
            Object objRememberedValue15 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue15 == companion6.getEmpty()) {
                objRememberedValue15 = new PreviewP2PScreenKt$PreviewP2PScreen$2$7$1(previewP2PViewModel, str, null);
                composer.updateRememberedValue(objRememberedValue15);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue15, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$0$0(Partner partner, ClipboardManager clipboardManager) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText(TemplateContent.NUMBER_TYPE, "+" + partner.getContact().getPhone()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$1$0(PreviewP2PViewModel previewP2PViewModel, Partner partner, MutableState mutableState, final Context context) {
        if (kotlin.jvm.internal.y.d(PreviewP2PScreen$lambda$8(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            previewP2PViewModel.startCall(partner.getId(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.r
                @Override // lb.a
                public final Object invoke() {
                    return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$1$0$0(context);
                }
            });
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(PreviewP2PScreen$lambda$8(mutableState), null, true, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$1$0$0(Context context) {
        CallActivity.Companion.openCallActivity$default(CallActivity.INSTANCE, context, null, 2, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$2$0(Partner partner, ClipboardManager clipboardManager) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText(ExtensionMention.ELEMENT, "@" + partner.getUser().getToDusId()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$5$0(PreviewP2PViewModel previewP2PViewModel, String str, final MutableState mutableState) {
        PreviewP2PScreen$lambda$2(mutableState, true);
        previewP2PViewModel.changeBlockState(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.d
            @Override // lb.a
            public final Object invoke() {
                return PreviewP2PScreenKt.PreviewP2PScreen$lambda$11$0$0$0$5$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$0$5$0$0(MutableState mutableState) {
        PreviewP2PScreen$lambda$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$1$0(MutableState mutableState) {
        PreviewP2PScreen$lambda$5(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$2$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goChatResources(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$3$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$0$0$4$0(PreviewP2PViewModel previewP2PViewModel, String str, boolean z10) {
        previewP2PViewModel.changeMuteValue(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$1$0(MutableState mutableState) {
        PreviewP2PScreen$lambda$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$2$0(PreviewP2PViewModel previewP2PViewModel, String str, MutableState mutableState) {
        previewP2PViewModel.changeSecretState(str);
        PreviewP2PScreen$lambda$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$3$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(PreviewP2PScreen$lambda$8(mutableState), result, false, null, 6, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$4$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(PreviewP2PScreen$lambda$8(mutableState), null, false, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$11$5$0(MutableState mutableState, PermissionsResult result) {
        kotlin.jvm.internal.y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(PreviewP2PScreen$lambda$8(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(PreviewP2PScreen$lambda$8(mutableState), null, false, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewP2PScreen$lambda$12(NavHostController navHostController, String str, PreviewP2PViewModel previewP2PViewModel, boolean z10, int i10, int i11, Composer composer, int i12) {
        PreviewP2PScreen(navHostController, str, previewP2PViewModel, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final void PreviewP2PScreen$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewP2PScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewP2PScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final PermissionsRequesterState PreviewP2PScreen$lambda$8(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    public static final void RowNumberDataButton(final Object image, final String contentString, final String titleString, final lb.a onClick, final lb.a onCall, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(image, "image");
        kotlin.jvm.internal.y.i(contentString, "contentString");
        kotlin.jvm.internal.y.i(titleString, "titleString");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onCall, "onCall");
        Composer composerStartRestartGroup = composer.startRestartGroup(-965132784);
        if ((i10 & 48) == 0) {
            i11 = (composerStartRestartGroup.changed(contentString) ? 32 : 16) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(titleString) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1169) != 1168, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-965132784, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.RowNumberDataButton (PreviewP2PScreen.kt:358)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(0));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, companion2.getCenterVertically(), composerStartRestartGroup, 54);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean z10 = (i11 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.o
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewP2PScreenKt.RowNumberDataButton$lambda$0$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.s
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, ComposableSingletons$PreviewP2PScreenKt.INSTANCE.m9921getLambda$922307594$app_productionPFast(), composerStartRestartGroup, 1572870, 62);
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(16));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, contentString, materialTheme.getTypography(composerStartRestartGroup, i12).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, i11 & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, titleString, null, materialTheme.getColorScheme(composerStartRestartGroup, i12).getTertiary(), 0, 0, composerStartRestartGroup, (i11 >> 3) & 112, 53);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewP2PScreenKt.RowNumberDataButton$lambda$1(image, contentString, titleString, onClick, onCall, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RowNumberDataButton$lambda$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 RowNumberDataButton$lambda$1(Object obj, String str, String str2, lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        RowNumberDataButton(obj, str, str2, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
