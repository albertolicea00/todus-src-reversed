package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ExitToAppKt;
import androidx.compose.material.icons.outlined.AdminPanelSettingsKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.LinkKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.LockOpenKt;
import androidx.compose.material.icons.outlined.RefreshKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.p000activity.compose.BackHandlerKt;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.di.MainModule;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.RichTitleDescBtnKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.form.FormItemRequest;
import cu.z17.views.form.FormItemType;
import cu.z17.views.form.UtilRegex;
import cu.z17.views.form.Z17FormKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import kotlin.jvm.internal.z0;
import pe.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u0017²\u0006\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\nX\u008a\u0084\u0002²\u0006\f\u0010\u000f\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u00020\u00068\nX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0013\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;", "viewModel", "", "showTopBar", "Lua/k0;", "PreviewChannelScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewChannel/PreviewChannelViewModel;ZLandroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/entity/toDus/Room;", "preview", "", "rights", "isSecret", Room.COLUMN_MUTED, "linkState", "isLoading", "showShareLinkDialog", "showLeaveActionDialog", "showChangeSecretState", "editorModeActive", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewChannelScreenKt {
    /* JADX WARN: Code duplicated, block: B:106:0x025d  */
    /* JADX WARN: Code duplicated, block: B:109:0x02af  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:75:0x0153  */
    /* JADX WARN: Code duplicated, block: B:78:0x0168  */
    /* JADX WARN: Code duplicated, block: B:81:0x0191  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:96:0x021e  */
    /* JADX WARN: Code duplicated, block: B:99:0x023b  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewChannelScreen(final NavHostController navHostController, final String uid, PreviewChannelViewModel previewChannelViewModel, boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        PreviewChannelViewModel previewChannelViewModel2;
        boolean z11;
        final PreviewChannelViewModel previewChannelViewModel3;
        final boolean z12;
        PreviewChannelViewModel previewChannelViewModel4;
        PreviewChannelViewModel previewChannelViewModel5;
        boolean z13;
        Composer composer2;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        Object objRememberedValue9;
        boolean z14;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1083536389);
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
                previewChannelViewModel2 = previewChannelViewModel;
                int i13 = composerStartRestartGroup.changedInstance(previewChannelViewModel2) ? 256 : 128;
                i12 |= i13;
            } else {
                previewChannelViewModel2 = previewChannelViewModel;
            }
            i12 |= i13;
        } else {
            previewChannelViewModel2 = previewChannelViewModel;
        }
        int i14 = i11 & 8;
        if (i14 != 0) {
            i12 |= 3072;
            z11 = z10;
        } else {
            z11 = z10;
            if ((i10 & 3072) == 0) {
                i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            }
        }
        int i15 = i12;
        int i16 = 0;
        if (composerStartRestartGroup.shouldExecute((i15 & 1171) != 1170, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    PreviewChannelViewModelFactory previewChannelViewModelFactory = new PreviewChannelViewModelFactory(uid);
                    int i17 = i15 & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(z0.b(PreviewChannelViewModel.class), current, uid, previewChannelViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i17 << 3) & 896, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    previewChannelViewModel4 = (PreviewChannelViewModel) viewModel;
                    i15 &= -897;
                } else {
                    previewChannelViewModel4 = previewChannelViewModel2;
                }
                previewChannelViewModel5 = previewChannelViewModel4;
                if (i14 != 0) {
                    z13 = true;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1083536389, i15, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen (PreviewChannelScreen.kt:107)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final int i18 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getPreviewChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getRightsChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getLinkChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                objRememberedValue = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                final ClipboardManager clipboardManager = (ClipboardManager) composer2.consume(CompositionLocalsKt.getLocalClipboardManager());
                final String strStringResource = StringResources_androidKt.stringResource(R.string.invitation_link, composer2, i16);
                objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                final pe.m0 m0Var = (pe.m0) objRememberedValue5;
                objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue6;
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new ArrayList();
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                final List list = (List) objRememberedValue7;
                final String strStringResource2 = StringResources_androidKt.stringResource(R.string.image, composer2, i16);
                final String strStringResource3 = StringResources_androidKt.stringResource(R.string.delete_image, composer2, i16);
                final String strStringResource4 = StringResources_androidKt.stringResource(R.string.name, composer2, i16);
                final String strStringResource5 = StringResources_androidKt.stringResource(R.string.information, composer2, i16);
                final y0 y0Var = new y0();
                objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = "";
                    composer2.updateRememberedValue("");
                }
                y0Var.f36634c = (String) objRememberedValue8;
                final u0 u0Var = new u0();
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = Boolean.FALSE;
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                u0Var.f36629c = ((Boolean) objRememberedValue9).booleanValue();
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
                if (z13 || PreviewChannelScreen$lambda$18(mutableState5)) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1063533497, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.z
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$25(navHostController, list, stateCollectAsStateWithLifecycle, mutableState5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                final PreviewChannelViewModel previewChannelViewModel6 = previewChannelViewModel5;
                Function3 function3 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26(previewChannelViewModel6, uid, navHostController, list, stateCollectAsStateWithLifecycle, mutableState, mutableState5, context, m0Var, y0Var, u0Var, strStringResource2, strStringResource3, strStringResource4, strStringResource5, i18, stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle3, mutableState4, stateCollectAsStateWithLifecycle2, mutableState2, mutableState3, stateCollectAsStateWithLifecycle4, strStringResource, clipboardManager, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                composerStartRestartGroup = composer2;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, z14, false, false, null, null, 0L, scaffoldStateRememberScaffoldState, null, ComposableLambdaKt.rememberComposableLambda(-36625915, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306758, 376);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                previewChannelViewModel3 = previewChannelViewModel6;
                z12 = z13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i15 &= -897;
                }
                previewChannelViewModel5 = previewChannelViewModel2;
                i16 = 0;
            }
            z13 = z11;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1083536389, i15, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen (PreviewChannelScreen.kt:107)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final int i19 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getPreviewChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getRightsChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle10 = FlowExtKt.collectAsStateWithLifecycle(previewChannelViewModel5.getLinkChannel(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            objRememberedValue = composer2.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue;
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue2;
            final ClipboardManager clipboardManager2 = (ClipboardManager) composer2.consume(CompositionLocalsKt.getLocalClipboardManager());
            final String strStringResource6 = StringResources_androidKt.stringResource(R.string.invitation_link, composer2, i16);
            objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composer2);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final pe.m0 m0Var2 = (pe.m0) objRememberedValue5;
            objRememberedValue6 = composer2.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue6;
            objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new ArrayList();
                composer2.updateRememberedValue(objRememberedValue7);
            }
            final List list2 = (List) objRememberedValue7;
            final String strStringResource7 = StringResources_androidKt.stringResource(R.string.image, composer2, i16);
            final String strStringResource8 = StringResources_androidKt.stringResource(R.string.delete_image, composer2, i16);
            final String strStringResource9 = StringResources_androidKt.stringResource(R.string.name, composer2, i16);
            final String strStringResource10 = StringResources_androidKt.stringResource(R.string.information, composer2, i16);
            final y0 y0Var2 = new y0();
            objRememberedValue8 = composer2.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = "";
                composer2.updateRememberedValue("");
            }
            y0Var2.f36634c = (String) objRememberedValue8;
            final u0 u0Var2 = new u0();
            objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = Boolean.FALSE;
                composer2.updateRememberedValue(objRememberedValue9);
            }
            u0Var2.f36629c = ((Boolean) objRememberedValue9).booleanValue();
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composer2, 0, 3);
            if (z13) {
                z14 = true;
            } else {
                z14 = true;
            }
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1063533497, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.z
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$25(navHostController, list2, stateCollectAsStateWithLifecycle6, mutableState10, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            final PreviewChannelViewModel previewChannelViewModel7 = previewChannelViewModel5;
            Function3 function4 = new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26(previewChannelViewModel7, uid, navHostController, list2, stateCollectAsStateWithLifecycle6, mutableState6, mutableState10, context2, m0Var2, y0Var2, u0Var2, strStringResource7, strStringResource8, strStringResource9, strStringResource10, i19, stateCollectAsStateWithLifecycle10, stateCollectAsStateWithLifecycle8, mutableState9, stateCollectAsStateWithLifecycle7, mutableState7, mutableState8, stateCollectAsStateWithLifecycle9, strStringResource6, clipboardManager2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            composerStartRestartGroup = composer2;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda2, z14, false, false, null, null, 0L, scaffoldStateRememberScaffoldState2, null, ComposableLambdaKt.rememberComposableLambda(-36625915, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805306758, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            previewChannelViewModel3 = previewChannelViewModel7;
            z12 = z13;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            previewChannelViewModel3 = previewChannelViewModel2;
            z12 = z11;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$27(navHostController, uid, previewChannelViewModel3, z12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PreviewChannelScreen$activateEditorMode(pe.m0 m0Var, y0 y0Var, List<FormItemRequest> list, String str, String str2, String str3, String str4, State<Room> state, MutableState<Boolean> mutableState) {
        pe.k.d(m0Var, null, null, new PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1(y0Var, list, str, str2, str3, str4, state, mutableState, null), 3, null);
    }

    private static final void PreviewChannelScreen$desactivateEditorMode(List<FormItemRequest> list, MutableState<Boolean> mutableState) {
        PreviewChannelScreen$lambda$19(mutableState, false);
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room PreviewChannelScreen$lambda$0(State<Room> state) {
        return state.getValue();
    }

    private static final List<String> PreviewChannelScreen$lambda$1(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final void PreviewChannelScreen$lambda$10(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelScreen$lambda$13(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelScreen$lambda$16(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelScreen$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewChannelScreen$lambda$19(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewChannelScreen$lambda$25(final NavHostController navHostController, final List list, final State state, final MutableState mutableState, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1063533497, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen.<anonymous> (PreviewChannelScreen.kt:315)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2003326438, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$25$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(list) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.j0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$25$1$0(navHostController, mutableState, list);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
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
    public static final ua.k0 PreviewChannelScreen$lambda$25$0(State state, Composer composer, int i10) {
        String onlyName;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2003326438, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen.<anonymous>.<anonymous> (PreviewChannelScreen.kt:317)");
            }
            Room roomPreviewChannelScreen$lambda$0 = PreviewChannelScreen$lambda$0(state);
            if (roomPreviewChannelScreen$lambda$0 == null || (onlyName = roomPreviewChannelScreen$lambda$0.getOnlyName()) == null) {
                onlyName = "";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, onlyName, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$25$1$0(NavHostController navHostController, MutableState mutableState, List list) {
        if (PreviewChannelScreen$lambda$18(mutableState)) {
            PreviewChannelScreen$desactivateEditorMode(list, mutableState);
        } else {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewChannelScreen$lambda$26(PreviewChannelViewModel previewChannelViewModel, String str, final NavHostController navHostController, final List list, final State state, final MutableState mutableState, final MutableState mutableState2, final Context context, final pe.m0 m0Var, final y0 y0Var, final u0 u0Var, final String str2, final String str3, final String str4, final String str5, int i10, final State state2, State state3, final MutableState mutableState3, State state4, MutableState mutableState4, MutableState mutableState5, State state5, final String str6, final ClipboardManager clipboardManager, Modifier m10, Composer composer, int i11) {
        int i12;
        final NavHostController navHostController2;
        final MutableState mutableState6;
        final MutableState mutableState7;
        final MutableState mutableState8;
        int i13;
        final MutableState mutableState9;
        String onlyName;
        Composer composer2;
        Object obj;
        final PreviewChannelViewModel previewChannelViewModel2 = previewChannelViewModel;
        final String str7 = str;
        Composer composer3 = composer;
        kotlin.jvm.internal.y.i(m10, "m");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer3.changed(m10) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer3.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-36625915, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen.<anonymous> (PreviewChannelScreen.kt:333)");
            }
            if (PreviewChannelScreen$lambda$0(state) == null || PreviewChannelScreen$lambda$6(mutableState)) {
                navHostController2 = navHostController;
                mutableState6 = mutableState;
                mutableState7 = mutableState4;
                mutableState8 = mutableState5;
                composer3.startReplaceGroup(-200890824);
                i13 = 0;
                LoadingScreenKt.LoadingWall(composer3, 0);
                composer3.endReplaceGroup();
            } else {
                if (PreviewChannelScreen$lambda$18(mutableState2)) {
                    composer3.startReplaceGroup(-200725935);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(m10, 0.0f, 1, null);
                    Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer3, 0);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    lb.a constructor = companion2.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Object objRememberedValue = composer3.rememberedValue();
                    Composer.Companion companion3 = Composer.INSTANCE;
                    if (objRememberedValue == companion3.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.o
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$0$0(mutableState2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierAlign = columnScopeInstance.align(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(8)), companion.getEnd());
                    ComposableSingletons$PreviewChannelScreenKt composableSingletons$PreviewChannelScreenKt = ComposableSingletons$PreviewChannelScreenKt.INSTANCE;
                    IconButtonKt.IconButton((lb.a) objRememberedValue, modifierAlign, false, null, null, null, composableSingletons$PreviewChannelScreenKt.getLambda$702545133$app_productionPFast(), composer, 1572870, 60);
                    Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1727paddingVpY3zN4$default(m10, Dp.m8823constructorimpl(20), 0.0f, 2, null));
                    Function3 lambda$2067900210$app_productionPFast = composableSingletons$PreviewChannelScreenKt.getLambda$2067900210$app_productionPFast();
                    boolean zChanged = composer.changed(state) | composer.changedInstance(previewChannelViewModel2) | composer.changed(str7) | composer.changedInstance(list);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion3.getEmpty()) {
                        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$1$0(previewChannelViewModel2, str7, mutableState, state, list, mutableState2, (HashMap) obj2);
                            }
                        };
                        composer.updateRememberedValue(function1);
                        objRememberedValue2 = function1;
                    }
                    Function1 function2 = (Function1) objRememberedValue2;
                    Function1 function3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$2(m0Var, y0Var, u0Var, list, str2, str3, str4, str5, mutableState, state, (HashMap) obj2);
                        }
                    };
                    boolean zChangedInstance = composer.changedInstance(context);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == companion3.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.v
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$3$0(context, (String) obj2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Z17FormKt.Z17Form(modifierImePadding, list, lambda$2067900210$app_productionPFast, function2, function3, (Function1) objRememberedValue3, null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 64);
                    composer3 = composer;
                    composer3.endNode();
                    composer3.endReplaceGroup();
                    previewChannelViewModel2 = previewChannelViewModel;
                    str7 = str;
                    navHostController2 = navHostController;
                    mutableState6 = mutableState;
                    mutableState7 = mutableState4;
                    mutableState8 = mutableState5;
                } else {
                    composer3.startReplaceGroup(-197362745);
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(m10, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, null, false, 14, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Vertical top2 = arrangement.getTop();
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion4.getStart(), composer3, 0);
                    int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    lb.a constructor2 = companion5.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 2));
                    Room roomPreviewChannelScreen$lambda$0 = PreviewChannelScreen$lambda$0(state);
                    String picture = roomPreviewChannelScreen$lambda$0 != null ? roomPreviewChannelScreen$lambda$0.getPicture() : null;
                    ContentScale crop = ContentScale.INSTANCE.getCrop();
                    ColorGenerator material = ColorGenerator.INSTANCE.getMATERIAL();
                    Room roomPreviewChannelScreen$lambda$1 = PreviewChannelScreen$lambda$0(state);
                    if (roomPreviewChannelScreen$lambda$1 == null || (onlyName = roomPreviewChannelScreen$lambda$1.getOnlyName()) == null) {
                        onlyName = "";
                    }
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1755height3ABfNKs, picture, Color.m5856boximpl(ColorKt.Color(material.getColor(onlyName))), null, crop, null, 0, null, null, composer, 24576, 488);
                    composer3 = composer;
                    float f10 = 0;
                    float f11 = 20;
                    Modifier modifierClip = ClipKt.clip(OffsetKt.m1684offsetVpY3zN4(companion6, Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f11))), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i14 = MaterialTheme.$stable;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, materialTheme.getColorScheme(composer3, i14).getBackground(), null, 2, null), Dp.m8823constructorimpl(f11));
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer3, 0);
                    int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1725padding3ABfNKs);
                    lb.a constructor3 = companion5.getConstructor();
                    if (!defpackage.r.a(composer3.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer3);
                    Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy3, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                    Room roomPreviewChannelScreen$lambda$2 = PreviewChannelScreen$lambda$0(state);
                    if (roomPreviewChannelScreen$lambda$2 == null) {
                        composer3.startReplaceGroup(932430156);
                        composer3.endReplaceGroup();
                        previewChannelViewModel2 = previewChannelViewModel;
                        navHostController2 = navHostController;
                        mutableState6 = mutableState;
                        mutableState7 = mutableState4;
                        mutableState8 = mutableState5;
                        str7 = str;
                    } else {
                        composer3.startReplaceGroup(932430157);
                        SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion6, Dp.m8823constructorimpl(f11)), composer3, 6);
                        Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                        ImageVector info = InfoKt.getInfo(outlined);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.information, composer3, 0);
                        String onlySubject = roomPreviewChannelScreen$lambda$2.getOnlySubject();
                        Object objRememberedValue4 = composer3.rememberedValue();
                        Composer.Companion companion7 = Composer.INSTANCE;
                        if (objRememberedValue4 == companion7.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.w
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        RichTitleDescBtnKt.RichTitleDescBtn(info, strStringResource, onlySubject, (lb.a) objRememberedValue4, composer3, 3072);
                        ImageVector lockOpen = PreviewChannelScreen$lambda$2(state3) ? LockOpenKt.getLockOpen(outlined) : LockKt.getLock(outlined);
                        String strStringResource2 = StringResources_androidKt.stringResource(PreviewChannelScreen$lambda$2(state3) ? R.string.pull_out_secret : R.string.make_it_secret, composer3, 0);
                        String strStringResource3 = StringResources_androidKt.stringResource(PreviewChannelScreen$lambda$2(state3) ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer3, 0);
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (objRememberedValue5 == companion7.getEmpty()) {
                            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$1$0(mutableState3);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        lb.a aVar = (lb.a) objRememberedValue5;
                        mutableState7 = mutableState4;
                        mutableState8 = mutableState5;
                        previewChannelViewModel2 = previewChannelViewModel;
                        str7 = str;
                        mutableState6 = mutableState;
                        RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(lockOpen, strStringResource2, strStringResource3, 0L, aVar, composer, 24576, 8);
                        if (PreviewChannelScreen$lambda$1(state4).contains("ci")) {
                            composer.startReplaceGroup(981548201);
                            composer2 = composer;
                            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(EditKt.getEdit(outlined), StringResources_androidKt.stringResource(R.string.edit, composer, 0), StringResources_androidKt.stringResource(R.string.edit_channel_properties, composer, 0), 0L, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.y
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$2(m0Var, y0Var, list, str2, str3, str4, str5, state, mutableState2);
                                }
                            }, composer2, 0, 8);
                            composer2.endReplaceGroup();
                        } else {
                            composer2 = composer;
                            composer2.startReplaceGroup(363561433);
                            composer2.endReplaceGroup();
                        }
                        if (PreviewChannelScreen$lambda$1(state4).contains("iwl")) {
                            composer2.startReplaceGroup(981562175);
                            ImageVector link = LinkKt.getLink(outlined);
                            String strStringResource4 = StringResources_androidKt.stringResource(R.string.channel_invitation_link, composer2, 0);
                            String strPreviewChannelScreen$lambda$4 = PreviewChannelScreen$lambda$4(state2);
                            boolean zChanged2 = composer2.changed(state2);
                            Object objRememberedValue6 = composer2.rememberedValue();
                            if (zChanged2 || objRememberedValue6 == companion7.getEmpty()) {
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.l0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$3$0(state2, mutableState7);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            }
                            obj = "iwl";
                            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(link, strStringResource4, strPreviewChannelScreen$lambda$4, 0L, (lb.a) objRememberedValue6, composer2, 0, 8);
                            composer2.endReplaceGroup();
                        } else {
                            obj = "iwl";
                            composer2.startReplaceGroup(364077273);
                            composer2.endReplaceGroup();
                        }
                        if (PreviewChannelScreen$lambda$1(state4).contains(obj)) {
                            composer2.startReplaceGroup(981578992);
                            ImageVector refresh = RefreshKt.getRefresh(outlined);
                            String strStringResource5 = StringResources_androidKt.stringResource(R.string.channel_invitation_link, composer2, 0);
                            String strStringResource6 = StringResources_androidKt.stringResource(R.string.change_link_for_add_members_to_channel, composer2, 0);
                            boolean zChangedInstance2 = composer2.changedInstance(previewChannelViewModel2) | composer2.changed(str7);
                            Object objRememberedValue7 = composer2.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue7 == companion7.getEmpty()) {
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$4$0(previewChannelViewModel2, str7, mutableState6);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(refresh, strStringResource5, strStringResource6, 0L, (lb.a) objRememberedValue7, composer2, 0, 8);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(364768697);
                            composer2.endReplaceGroup();
                        }
                        if (PreviewChannelScreen$lambda$1(state4).contains("aa")) {
                            composer2.startReplaceGroup(981601060);
                            ImageVector adminPanelSettings = AdminPanelSettingsKt.getAdminPanelSettings(outlined);
                            String strStringResource7 = StringResources_androidKt.stringResource(R.string.admin_subscribers, composer2, 0);
                            String strStringResource8 = StringResources_androidKt.stringResource(R.string.admin_subscribers_desc, composer2, 0);
                            boolean zChangedInstance3 = composer2.changedInstance(navHostController) | composer2.changed(str7);
                            Object objRememberedValue8 = composer2.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue8 == companion7.getEmpty()) {
                                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.g
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$5$0(navHostController, str7);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            }
                            navHostController2 = navHostController;
                            RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(adminPanelSettings, strStringResource7, strStringResource8, 0L, (lb.a) objRememberedValue8, composer2, 0, 8);
                            composer2.endReplaceGroup();
                        } else {
                            navHostController2 = navHostController;
                            composer2.startReplaceGroup(365256761);
                            composer2.endReplaceGroup();
                        }
                        ImageVector exitToApp = ExitToAppKt.getExitToApp(Icons.AutoMirrored.Outlined.INSTANCE);
                        String strStringResource9 = StringResources_androidKt.stringResource(R.string.exit_channel, composer2, 0);
                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.stop_interact_channel, composer2, 0);
                        Object objRememberedValue9 = composer2.rememberedValue();
                        if (objRememberedValue9 == companion7.getEmpty()) {
                            objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.h
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$6$0(mutableState8);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(exitToApp, strStringResource9, strStringResource10, 0L, (lb.a) objRememberedValue9, composer2, 24576, 8);
                        DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1726paddingVpY3zN4(companion6, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(5)), 0.0f, materialTheme.getColorScheme(composer2, i14).getTertiary(), composer2, 6, 2);
                        ImageVector folder = FolderKt.getFolder(outlined);
                        String strStringResource11 = StringResources_androidKt.stringResource(R.string.folder, composer2, 0);
                        String strStringResource12 = StringResources_androidKt.stringResource(R.string.find_the_chat_attachments, composer2, 0);
                        boolean zChangedInstance4 = composer2.changedInstance(navHostController2) | composer2.changed(str7);
                        Object objRememberedValue10 = composer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue10 == companion7.getEmpty()) {
                            objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.i
                                @Override // lb.a
                                public final Object invoke() {
                                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$7$0(navHostController2, str7);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue10);
                        }
                        RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(folder, strStringResource11, strStringResource12, 0L, (lb.a) objRememberedValue10, composer2, 0, 8);
                        Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion6, Dp.m8823constructorimpl(16), 0.0f, 2, null);
                        boolean z10 = !PreviewChannelScreen$lambda$3(state5);
                        boolean zChangedInstance5 = composer2.changedInstance(previewChannelViewModel2) | composer2.changed(str7);
                        Object objRememberedValue11 = composer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue11 == companion7.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.j
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$8$0(previewChannelViewModel2, str7, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default, z10, (Function1) objRememberedValue11, ComposableSingletons$PreviewChannelScreenKt.INSTANCE.m9914getLambda$1866655172$app_productionPFast(), StringResources_androidKt.stringResource(R.string.notifications, composer2, 0), null, null, composer, 3078, 96);
                        composer3 = composer;
                        ua.k0 k0Var = ua.k0.f43947a;
                        composer3.endReplaceGroup();
                    }
                    composer3.endNode();
                    composer3.endNode();
                    composer3.endReplaceGroup();
                }
                i13 = 0;
            }
            String strStringResource13 = StringResources_androidKt.stringResource(PreviewChannelScreen$lambda$2(state3) ? R.string.pull_out_secret : R.string.make_it_secret, composer3, i13);
            String strStringResource14 = StringResources_androidKt.stringResource(PreviewChannelScreen$lambda$2(state3) ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer3, i13);
            String strStringResource15 = StringResources_androidKt.stringResource(R.string.ok, composer3, i13);
            String strStringResource16 = StringResources_androidKt.stringResource(R.string.no, composer3, i13);
            boolean zPreviewChannelScreen$lambda$15 = PreviewChannelScreen$lambda$15(mutableState3);
            Object objRememberedValue12 = composer3.rememberedValue();
            Composer.Companion companion8 = Composer.INSTANCE;
            if (objRememberedValue12 == companion8.getEmpty()) {
                mutableState9 = mutableState3;
                objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.k
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$2$0(mutableState9);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue12);
            } else {
                mutableState9 = mutableState3;
            }
            lb.a aVar2 = (lb.a) objRememberedValue12;
            boolean zChangedInstance6 = composer3.changedInstance(previewChannelViewModel2) | composer3.changed(str7);
            Object objRememberedValue13 = composer3.rememberedValue();
            if (zChangedInstance6 || objRememberedValue13 == companion8.getEmpty()) {
                objRememberedValue13 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.l
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$3$0(previewChannelViewModel2, str7, mutableState9);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue13);
            }
            Composer composer4 = composer3;
            Z17DialogsKt.Z17DialogWithActions(zPreviewChannelScreen$lambda$15, aVar2, (lb.a) objRememberedValue13, null, strStringResource13, strStringResource14, strStringResource15, strStringResource16, composer4, 48, 8);
            boolean zPreviewChannelScreen$lambda$9 = PreviewChannelScreen$lambda$9(mutableState7);
            Object objRememberedValue14 = composer4.rememberedValue();
            if (objRememberedValue14 == companion8.getEmpty()) {
                objRememberedValue14 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.m
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$4$0(mutableState7);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue14);
            }
            final NavHostController navHostController3 = navHostController2;
            Z17DialogsKt.Z17CustomDialog(zPreviewChannelScreen$lambda$9, (lb.a) objRememberedValue14, ComposableLambdaKt.rememberComposableLambda(-2029129609, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$5(state2, navHostController3, context, str6, clipboardManager, (lb.a) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer4, 54), composer4, 432);
            String strStringResource17 = StringResources_androidKt.stringResource(R.string.leave_channel_question, composer4, 0);
            String strStringResource18 = StringResources_androidKt.stringResource(R.string.this_action_will_eliminate_all, composer4, 0);
            String strStringResource19 = StringResources_androidKt.stringResource(R.string.leave_channel, composer4, 0);
            String strStringResource20 = StringResources_androidKt.stringResource(R.string.no, composer4, 0);
            boolean zPreviewChannelScreen$lambda$12 = PreviewChannelScreen$lambda$12(mutableState8);
            Object objRememberedValue15 = composer4.rememberedValue();
            if (objRememberedValue15 == companion8.getEmpty()) {
                objRememberedValue15 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.q
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$6$0(mutableState8);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue15);
            }
            lb.a aVar3 = (lb.a) objRememberedValue15;
            boolean zChangedInstance7 = composer4.changedInstance(previewChannelViewModel2) | composer4.changed(str7) | composer4.changedInstance(navHostController2);
            Object objRememberedValue16 = composer4.rememberedValue();
            if (zChangedInstance7 || objRememberedValue16 == companion8.getEmpty()) {
                objRememberedValue16 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.r
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$7$0(previewChannelViewModel2, str7, navHostController2);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue16);
            }
            Z17DialogsKt.Z17DialogWithActions(zPreviewChannelScreen$lambda$12, aVar3, (lb.a) objRememberedValue16, null, strStringResource17, strStringResource18, strStringResource19, strStringResource20, composer4, 48, 8);
            boolean zChangedInstance8 = composer4.changedInstance(list) | composer4.changedInstance(navHostController2);
            Object objRememberedValue17 = composer4.rememberedValue();
            if (zChangedInstance8 || objRememberedValue17 == companion8.getEmpty()) {
                objRememberedValue17 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.s
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$8$0(navHostController2, mutableState2, list);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue17);
            }
            BackHandlerKt.BackHandler(false, (lb.a) objRememberedValue17, composer4, 0, 1);
            ua.k0 k0Var2 = ua.k0.f43947a;
            boolean zChangedInstance9 = composer4.changedInstance(previewChannelViewModel2) | composer4.changed(str7);
            Object objRememberedValue18 = composer4.rememberedValue();
            if (zChangedInstance9 || objRememberedValue18 == companion8.getEmpty()) {
                objRememberedValue18 = new PreviewChannelScreenKt$PreviewChannelScreen$2$10$1(previewChannelViewModel2, str7, mutableState6, null);
                composer4.updateRememberedValue(objRememberedValue18);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue18, composer4, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer3.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$0$0$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$19(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    public static final ua.k0 PreviewChannelScreen$lambda$26$0$1$0(PreviewChannelViewModel previewChannelViewModel, String str, final MutableState mutableState, State state, final List list, final MutableState mutableState2, HashMap result) {
        kotlin.jvm.internal.y.i(result, "result");
        PreviewChannelScreen$lambda$7(mutableState, true);
        String str2 = (String) result.get("delete_image");
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        boolean zD = kotlin.jvm.internal.y.d(str2, "0");
        Object obj = result.get("image");
        Room roomPreviewChannelScreen$lambda$0 = PreviewChannelScreen$lambda$0(state);
        kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$0);
        boolean z10 = (kotlin.jvm.internal.y.d(obj, roomPreviewChannelScreen$lambda$0.getPicture()) || result.get("image") == null) ? false : true;
        String name = (String) result.get("name");
        if (name == null) {
            Room roomPreviewChannelScreen$lambda$1 = PreviewChannelScreen$lambda$0(state);
            kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$1);
            name = roomPreviewChannelScreen$lambda$1.getName();
        } else {
            if (le.d0.q0(name)) {
                Room roomPreviewChannelScreen$lambda$2 = PreviewChannelScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$2);
                name = roomPreviewChannelScreen$lambda$2.getName();
            }
            if (name == null) {
                Room roomPreviewChannelScreen$lambda$3 = PreviewChannelScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$3);
                name = roomPreviewChannelScreen$lambda$3.getName();
            }
        }
        String str4 = name;
        String subject = (String) result.get(TtmlNode.TAG_INFORMATION);
        if (subject == null) {
            Room roomPreviewChannelScreen$lambda$4 = PreviewChannelScreen$lambda$0(state);
            kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$4);
            subject = roomPreviewChannelScreen$lambda$4.getSubject();
        } else {
            if (le.d0.q0(subject)) {
                Room roomPreviewChannelScreen$lambda$5 = PreviewChannelScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$5);
                subject = roomPreviewChannelScreen$lambda$5.getSubject();
            }
            if (subject == null) {
                Room roomPreviewChannelScreen$lambda$6 = PreviewChannelScreen$lambda$0(state);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$6);
                subject = roomPreviewChannelScreen$lambda$6.getSubject();
            }
        }
        String str5 = subject;
        if (z10) {
            Object obj2 = result.get("image");
            kotlin.jvm.internal.y.f(obj2);
            str3 = (String) obj2;
        }
        previewChannelViewModel.updateChannel(str, str4, str5, str3, zD, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.d0
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$1$0$2(list, mutableState2, mutableState);
            }
        }, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.e0
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$0$1$0$3(mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$0$1$0$2(List list, MutableState mutableState, MutableState mutableState2) {
        PreviewChannelScreen$desactivateEditorMode(list, mutableState);
        PreviewChannelScreen$lambda$7(mutableState2, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$0$1$0$3(MutableState mutableState) {
        PreviewChannelScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$0$2(pe.m0 m0Var, y0 y0Var, u0 u0Var, List list, String str, String str2, String str3, String str4, MutableState mutableState, State state, HashMap updatedResult) {
        kotlin.jvm.internal.y.i(updatedResult, "updatedResult");
        CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new PreviewChannelScreenKt$PreviewChannelScreen$2$1$3$1(updatedResult, y0Var, u0Var, list, str, str2, str3, str4, mutableState, state, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PreviewChannelScreen$lambda$26$0$3$0(Context context, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        String path = MediaUtil.INSTANCE.getPath(context, Uri.fromFile(new File(it)));
        return path == null ? "" : path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$1$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$16(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$2(pe.m0 m0Var, y0 y0Var, List list, String str, String str2, String str3, String str4, State state, MutableState mutableState) {
        PreviewChannelScreen$activateEditorMode(m0Var, y0Var, list, str, str2, str3, str4, state, mutableState);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$3$0(State state, MutableState mutableState) {
        if (!le.d0.q0(PreviewChannelScreen$lambda$4(state))) {
            PreviewChannelScreen$lambda$10(mutableState, true);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$4$0(PreviewChannelViewModel previewChannelViewModel, String str, final MutableState mutableState) {
        PreviewChannelScreen$lambda$7(mutableState, true);
        previewChannelViewModel.createChannelLink(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.e
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$1$0$0$4$0$0(mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$4$0$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$5$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPreviewSubscribers(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$6$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$13(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$7$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goChatResources(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$1$0$0$8$0(PreviewChannelViewModel previewChannelViewModel, String str, boolean z10) {
        previewChannelViewModel.changeMuteValue(str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$2$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$16(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$3$0(PreviewChannelViewModel previewChannelViewModel, String str, MutableState mutableState) {
        previewChannelViewModel.changeSecretState(str);
        PreviewChannelScreen$lambda$16(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$4$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$10(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PreviewChannelScreen$lambda$26$5(final State state, final NavHostController navHostController, final Context context, final String str, final ClipboardManager clipboardManager, final lb.a close, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(close, "close");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(close) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2029129609, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreen.<anonymous>.<anonymous> (PreviewChannelScreen.kt:590)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(15));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
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
            String strStringResource = StringResources_androidKt.stringResource(R.string.channel_invitation_link, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            float f10 = 50;
            Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            int i13 = i11 & 14;
            boolean zChanged = composer.changed(state) | composer.changedInstance(navHostController) | (i13 == 4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$5$0$0$0(close, navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.share_link_todus, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default2 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChangedInstance = composer.changedInstance(context) | composer.changed(str) | composer.changed(state) | (i13 == 4);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$5$0$2$0(close, context, str, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default2, false, null, null, null, (lb.a) objRememberedValue2, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.share_link_other_apps, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default3 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChanged2 = composer.changed(state) | composer.changedInstance(clipboardManager) | (i13 == 4);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$5$0$4$0(clipboardManager, close, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1240clickableoSLSa3U$default3 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default3, false, null, null, null, (lb.a) objRememberedValue3, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default3);
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
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.copy_link, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            Modifier modifierM1754defaultMinSizeVpY3zN4$default4 = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changed(state);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$5$0$6$0(navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM1240clickableoSLSa3U$default4 = ClickableKt.m1240clickableoSLSa3U$default(modifierM1754defaultMinSizeVpY3zN4$default4, false, null, null, null, (lb.a) objRememberedValue4, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int iA5 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM1240clickableoSLSa3U$default4);
            lb.a constructor5 = companion3.getConstructor();
            if (!defpackage.r.a(composer.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer);
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.show_qr, composer, 0), materialTheme.getTypography(composer, i12).getBodyLarge(), 0L, 0, 0, composer, 0, 57);
            composer.endNode();
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
    public static final ua.k0 PreviewChannelScreen$lambda$26$5$0$0$0(lb.a aVar, NavHostController navHostController, State state) {
        PreviewChannelScreen$shareThroughToDus(navHostController, state);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$5$0$2$0(lb.a aVar, Context context, String str, State state) {
        PreviewChannelScreen$shareThroughOtherApps(context, str, state);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$5$0$4$0(ClipboardManager clipboardManager, lb.a aVar, State state) {
        ClipData clipDataNewPlainText = ClipData.newPlainText("link", PreviewChannelScreen$lambda$4(state));
        kotlin.jvm.internal.y.f(clipDataNewPlainText);
        clipboardManager.setClip(AndroidClipboardManager_androidKt.toClipEntry(clipDataNewPlainText));
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$5$0$6$0(NavHostController navHostController, State state) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goQrViewer(PreviewChannelScreen$lambda$4(state)), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$6$0(MutableState mutableState) {
        PreviewChannelScreen$lambda$13(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$7$0(PreviewChannelViewModel previewChannelViewModel, String str, final NavHostController navHostController) {
        previewChannelViewModel.leaveAndDeleteChannel(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.p
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$7$0$0(navHostController);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$7$0$0(NavHostController navHostController) {
        navHostController.navigate(NavLinks.HOME, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewChannelScreenKt.PreviewChannelScreen$lambda$26$7$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$7$0$0$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$26$8$0(NavHostController navHostController, MutableState mutableState, List list) {
        if (PreviewChannelScreen$lambda$18(mutableState)) {
            PreviewChannelScreen$desactivateEditorMode(list, mutableState);
        } else {
            navHostController.navigateUp();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewChannelScreen$lambda$27(NavHostController navHostController, String str, PreviewChannelViewModel previewChannelViewModel, boolean z10, int i10, int i11, Composer composer, int i12) {
        PreviewChannelScreen(navHostController, str, previewChannelViewModel, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    private static final boolean PreviewChannelScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String PreviewChannelScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    private static final boolean PreviewChannelScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewChannelScreen$lambda$7(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean PreviewChannelScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PreviewChannelScreen$shareThroughOtherApps(Context context, String str, State<String> state) {
        IntentUtil.INSTANCE.shareText(context, str, PreviewChannelScreen$lambda$4(state));
    }

    private static final void PreviewChannelScreen$shareThroughToDus(NavHostController navHostController, State<String> state) {
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, PreviewChannelScreen$lambda$4(state))));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = MainModule.INSTANCE.getInstance().getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0136  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public static final Object PreviewChannelScreen$updateStateForDeleteImage(List<FormItemRequest> list, String str, y0 y0Var, String str2, String str3, String str4, MutableState<Boolean> mutableState, State<Room> state, HashMap<String, String> map, ab.e<? super ua.k0> eVar) {
        PreviewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1 previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1;
        boolean zD;
        y0 y0Var2;
        String str5;
        String str6;
        State<Room> state2;
        List<FormItemRequest> list2;
        String str7;
        String str8;
        String str9;
        MutableState<Boolean> mutableState2 = mutableState;
        HashMap<String, String> map2 = map;
        if (eVar instanceof PreviewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1) {
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1 = (PreviewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1) eVar;
            int i10 = previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.label = i10 - Integer.MIN_VALUE;
            } else {
                previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1 = new PreviewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1(eVar);
            }
        } else {
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1 = new PreviewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1(eVar);
        }
        Object obj = previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.result;
        Object objG = bb.b.g();
        int i11 = previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.label;
        if (i11 == 0) {
            ua.v.b(obj);
            String str10 = map2.get("delete_image");
            if (str10 == null) {
                str10 = "";
            }
            zD = kotlin.jvm.internal.y.d(str10, "0");
            list.clear();
            PreviewChannelScreen$lambda$7(mutableState2, true);
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$0 = list;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$1 = str;
            y0Var2 = y0Var;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$2 = y0Var2;
            str5 = str2;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$3 = str5;
            str6 = str3;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$4 = str6;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$5 = str4;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$6 = mutableState2;
            state2 = state;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$7 = state2;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$8 = map2;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.Z$0 = zD;
            previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.label = 1;
            if (w0.b(10L, previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1) == objG) {
                return objG;
            }
            list2 = list;
            str7 = str;
            str8 = str4;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z10 = previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.Z$0;
            map2 = (HashMap) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$8;
            State<Room> state3 = (State) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$7;
            MutableState<Boolean> mutableState3 = (MutableState) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$6;
            str8 = (String) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$5;
            String str11 = (String) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$4;
            str5 = (String) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$3;
            y0 y0Var3 = (y0) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$2;
            String str12 = (String) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$1;
            list2 = (List) previewChannelScreenKt$PreviewChannelScreen$updateStateForDeleteImage$1.L$0;
            ua.v.b(obj);
            str6 = str11;
            y0Var2 = y0Var3;
            zD = z10;
            state2 = state3;
            mutableState2 = mutableState3;
            str7 = str12;
        }
        FormItemRequest formItemRequest = new FormItemRequest("image", FormItemType.LARGE_IMAGE, str7, "", zD ? "" : (String) y0Var2.f36634c, "", "", 0, 0.0f, null, null, 1920, null);
        FormItemType formItemType = FormItemType.MULTIPLE_SELECTION;
        String str13 = map2.get("delete_image");
        if (str13 != null) {
            if (le.d0.q0(str13)) {
                str13 = r8;
            }
            str9 = str13;
        } else {
            str9 = r8;
        }
        FormItemRequest formItemRequest2 = new FormItemRequest("delete_image", formItemType, "", "", str9, "", "", 0, 0.0f, va.v.e(str5), null, 1408, null);
        FormItemType formItemType2 = FormItemType.TEXT;
        String name = map2.get("name");
        if (name == null) {
            Room roomPreviewChannelScreen$lambda$0 = PreviewChannelScreen$lambda$0(state2);
            kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$0);
            name = roomPreviewChannelScreen$lambda$0.getName();
        } else {
            if (le.d0.q0(name)) {
                Room roomPreviewChannelScreen$lambda$1 = PreviewChannelScreen$lambda$0(state2);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$1);
                name = roomPreviewChannelScreen$lambda$1.getName();
            }
            if (name == null) {
                Room roomPreviewChannelScreen$lambda$2 = PreviewChannelScreen$lambda$0(state2);
                kotlin.jvm.internal.y.f(roomPreviewChannelScreen$lambda$2);
                name = roomPreviewChannelScreen$lambda$2.getName();
            }
        }
        FormItemRequest formItemRequest3 = new FormItemRequest("name", formItemType2, str6, "", name, UtilRegex.CANNOT_BE_EMPTY, "", 150, 0.0f, null, null, 1792, null);
        FormItemType formItemType3 = FormItemType.LARGE_TEXT;
        String str14 = map2.get(TtmlNode.TAG_INFORMATION);
        list2.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest3, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType3, str8, "", str14 == null ? r8 : str14, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
        PreviewChannelScreen$lambda$7(mutableState2, false);
        return ua.k0.f43947a;
    }
}
