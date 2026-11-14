package cu.todus.android.uiCompose.main.screen.chatPreview.previewCard;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ExitToAppKt;
import androidx.compose.material.icons.outlined.DeleteOutlineKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.LockKt;
import androidx.compose.material.icons.outlined.LockOpenKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material.icons.outlined.TagFacesKt;
import androidx.compose.material3.DividerKt;
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
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
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
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.RichTitleDescBtnKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.IntentUtil;
import cu.z17.views.dialogs.Z17DialogsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import le.a0;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f²\u0006\u000e\u0010\u000b\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "uid", "Lcu/todus/android/uiCompose/main/screen/chatPreview/previewCard/PreviewCardViewModel;", "viewModel", "", "showTopBar", "Lua/k0;", "PreviewCardScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chatPreview/previewCard/PreviewCardViewModel;ZLandroidx/compose/runtime/Composer;II)V", "isLoading", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreviewCardScreenKt {
    /* JADX WARN: Code duplicated, block: B:107:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:108:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:113:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:116:0x0322  */
    /* JADX WARN: Code duplicated, block: B:127:0x0341  */
    /* JADX WARN: Code duplicated, block: B:128:0x0343  */
    /* JADX WARN: Code duplicated, block: B:133:0x0351  */
    /* JADX WARN: Code duplicated, block: B:136:0x037f  */
    /* JADX WARN: Code duplicated, block: B:147:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:152:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:155:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:157:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:160:0x0400  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:72:0x0102  */
    /* JADX WARN: Code duplicated, block: B:75:0x012d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0144  */
    /* JADX WARN: Code duplicated, block: B:81:0x015b  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:93:0x0209  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a5  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PreviewCardScreen(final NavHostController navHostController, String uid, PreviewCardViewModel previewCardViewModel, boolean z10, Composer composer, final int i10, final int i11) {
        int i12;
        boolean z11;
        boolean z12;
        final String str;
        Composer composer2;
        final boolean z13;
        final PreviewCardViewModel previewCardViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z14;
        int i13;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        Object objRememberedValue3;
        final MutableState mutableState3;
        final State stateCollectAsStateWithLifecycle;
        Composer composer3;
        Object objRememberedValue4;
        final MutableState mutableState4;
        final PreviewCardViewModel previewCardViewModel3;
        Object objRememberedValue5;
        int i14;
        boolean z15;
        boolean z16;
        Object objRememberedValue6;
        Object objRememberedValue7;
        boolean z17;
        boolean z18;
        Object objRememberedValue8;
        Object objRememberedValue9;
        boolean z19;
        boolean z20;
        Object objRememberedValue10;
        int i15;
        PreviewCardViewModel previewCardViewModel4 = previewCardViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(uid, "uid");
        Composer composerStartRestartGroup = composer.startRestartGroup(1052055071);
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
                i15 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(previewCardViewModel4) : composerStartRestartGroup.changedInstance(previewCardViewModel4)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
            }
            i12 |= i15;
        }
        int i16 = i11 & 8;
        if (i16 == 0) {
            if ((i10 & 3072) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
            }
            if ((i12 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i11 & 4) != 0) {
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        int i17 = i12;
                        ViewModel viewModel = ViewModelKt.viewModel(z0.b(PreviewCardViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        PreviewCardViewModel previewCardViewModel5 = (PreviewCardViewModel) viewModel;
                        i12 = i17 & (-897);
                        previewCardViewModel4 = previewCardViewModel5;
                    }
                    if (i16 != 0) {
                        i13 = i12;
                        z14 = true;
                    } else {
                        z14 = z10;
                        i13 = i12;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i11 & 4) != 0) {
                        i12 &= -897;
                    }
                    i13 = i12;
                    z14 = z11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1052055071, i13, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen (PreviewCardScreen.kt:83)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getPreviewCard(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState3 = (MutableState) objRememberedValue3;
                final ClipboardManager clipboardManager = (ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
                final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                final String strStringResource = StringResources_androidKt.stringResource(R.string.invitation_link, composerStartRestartGroup, 0);
                final int i18 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getLeavingCard(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                composer3 = composerStartRestartGroup;
                if (((FlowsState) stateCollectAsStateWithLifecycle.getValue()).getStatus() == Status.SUCCESS || !kotlin.jvm.internal.y.d(((FlowsState) stateCollectAsStateWithLifecycle.getValue()).getData(), Boolean.TRUE)) {
                    composer3.startReplaceGroup(1397704611);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(1707653526);
                    Object objRememberedValue11 = composer3.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$3$0((NavOptionsBuilder) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    navHostController.navigate(NavLinks.HOME, (Function1) objRememberedValue11);
                    composer3.endReplaceGroup();
                }
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                mutableState4 = (MutableState) objRememberedValue4;
                previewCardViewModel3 = previewCardViewModel4;
                str = uid;
                int i19 = i13;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1612669035, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$7(navHostController, stateCollectAsStateWithLifecycle2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), !z14, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composer3, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1041558313, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$8(stateCollectAsStateWithLifecycle2, stateCollectAsStateWithLifecycle, mutableState4, i18, stateCollectAsStateWithLifecycle3, previewCardViewModel3, str, navHostController, stateCollectAsStateWithLifecycle4, mutableState2, mutableState3, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer3, 805306758, 376);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.stop_follow_question, composer3, 0);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.this_action_will_eliminate_all_on_card, composer3, 0);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.ok, composer3, 0);
                String strStringResource5 = StringResources_androidKt.stringResource(R.string.no, composer3, 0);
                boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.i
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewCardScreenKt.PreviewCardScreen$lambda$9$0(mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar = (lb.a) objRememberedValue5;
                int i20 = (i19 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                boolean z21 = (i20 <= 256 && composer3.changedInstance(previewCardViewModel3)) || (i19 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                i14 = i19 & 112;
                if (i14 == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = z21 | z15;
                objRememberedValue6 = composer3.rememberedValue();
                if (z16 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.j
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewCardScreenKt.PreviewCardScreen$lambda$10$0(previewCardViewModel3, str);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                Z17DialogsKt.Z17DialogWithActions(zBooleanValue, aVar, (lb.a) objRememberedValue6, null, strStringResource2, strStringResource3, strStringResource4, strStringResource5, composer3, 48, 8);
                String strStringResource6 = StringResources_androidKt.stringResource(R.string.clear_history_question, composer3, 0);
                String strStringResource7 = StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer3, 0);
                String strStringResource8 = StringResources_androidKt.stringResource(R.string.ok, composer3, 0);
                String strStringResource9 = StringResources_androidKt.stringResource(R.string.no, composer3, 0);
                boolean zBooleanValue2 = ((Boolean) mutableState2.getValue()).booleanValue();
                objRememberedValue7 = composer3.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.k
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewCardScreenKt.PreviewCardScreen$lambda$11$0(mutableState2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                lb.a aVar2 = (lb.a) objRememberedValue7;
                boolean z22 = (i20 <= 256 && composer3.changedInstance(previewCardViewModel3)) || (i19 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                if (i14 == 32) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = z17 | z22;
                objRememberedValue8 = composer3.rememberedValue();
                if (z18 || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.l
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewCardScreenKt.PreviewCardScreen$lambda$12$0(previewCardViewModel3, str, mutableState4);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                Z17DialogsKt.Z17DialogWithActions(zBooleanValue2, aVar2, (lb.a) objRememberedValue8, null, strStringResource6, strStringResource7, strStringResource8, strStringResource9, composer3, 48, 8);
                composer2 = composer3;
                boolean zBooleanValue3 = ((Boolean) mutableState3.getValue()).booleanValue();
                objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.n
                        @Override // lb.a
                        public final Object invoke() {
                            return PreviewCardScreenKt.PreviewCardScreen$lambda$13$0(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                z19 = false;
                Z17DialogsKt.Z17CustomDialog(zBooleanValue3, (lb.a) objRememberedValue9, ComposableLambdaKt.rememberComposableLambda(1464006765, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$14(navHostController, previewCardViewModel3, stateCollectAsStateWithLifecycle2, context, strStringResource, clipboardManager, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 432);
                k0 k0Var = k0.f43947a;
                boolean z23 = (i20 <= 256 && composer2.changedInstance(previewCardViewModel3)) || (i19 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                if (i14 == 32) {
                    z19 = true;
                }
                z20 = z23 | z19;
                objRememberedValue10 = composer2.rememberedValue();
                if (z20 || objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new PreviewCardScreenKt$PreviewCardScreen$10$1(previewCardViewModel3, str, mutableState4, null);
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue10, composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                previewCardViewModel2 = previewCardViewModel3;
                z13 = z14;
            } else {
                str = uid;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z13 = z10;
                previewCardViewModel2 = previewCardViewModel4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final String str2 = str;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$16(navHostController, str2, previewCardViewModel2, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z11 = z10;
        if ((i12 & 1171) != 1170) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if ((i11 & 4) != 0) {
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    int i110 = i12;
                    ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(PreviewCardViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    PreviewCardViewModel previewCardViewModel6 = (PreviewCardViewModel) viewModel2;
                    i12 = i110 & (-897);
                    previewCardViewModel4 = previewCardViewModel6;
                }
                if (i16 != 0) {
                    i13 = i12;
                    z14 = true;
                } else {
                    z14 = z10;
                    i13 = i12;
                }
            } else {
                if ((i11 & 4) != 0) {
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    int i111 = i12;
                    ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(PreviewCardViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    PreviewCardViewModel previewCardViewModel7 = (PreviewCardViewModel) viewModel3;
                    i12 = i111 & (-897);
                    previewCardViewModel4 = previewCardViewModel7;
                }
                if (i16 != 0) {
                    i13 = i12;
                    z14 = true;
                } else {
                    z14 = z10;
                    i13 = i12;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1052055071, i13, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen (PreviewCardScreen.kt:83)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getPreviewCard(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState3 = (MutableState) objRememberedValue3;
            final ClipboardManager clipboardManager2 = (ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
            final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getIsSecret(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getIsMuted(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            final String strStringResource10 = StringResources_androidKt.stringResource(R.string.invitation_link, composerStartRestartGroup, 0);
            final int i112 = ((Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(previewCardViewModel4.getLeavingCard(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            composer3 = composerStartRestartGroup;
            if (((FlowsState) stateCollectAsStateWithLifecycle.getValue()).getStatus() == Status.SUCCESS) {
                composer3.startReplaceGroup(1397704611);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1397704611);
                composer3.endReplaceGroup();
            }
            objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue4);
            }
            mutableState4 = (MutableState) objRememberedValue4;
            previewCardViewModel3 = previewCardViewModel4;
            str = uid;
            int i113 = i13;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1612669035, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewCardScreenKt.PreviewCardScreen$lambda$7(navHostController, stateCollectAsStateWithLifecycle5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), !z14, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composer3, 0, 3), null, ComposableLambdaKt.rememberComposableLambda(1041558313, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewCardScreenKt.PreviewCardScreen$lambda$8(stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle, mutableState4, i112, stateCollectAsStateWithLifecycle6, previewCardViewModel3, str, navHostController, stateCollectAsStateWithLifecycle7, mutableState2, mutableState3, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer3, 805306758, 376);
            String strStringResource11 = StringResources_androidKt.stringResource(R.string.stop_follow_question, composer3, 0);
            String strStringResource12 = StringResources_androidKt.stringResource(R.string.this_action_will_eliminate_all_on_card, composer3, 0);
            String strStringResource13 = StringResources_androidKt.stringResource(R.string.ok, composer3, 0);
            String strStringResource14 = StringResources_androidKt.stringResource(R.string.no, composer3, 0);
            boolean zBooleanValue4 = ((Boolean) mutableState.getValue()).booleanValue();
            objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.i
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$9$0(mutableState);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar3 = (lb.a) objRememberedValue5;
            int i21 = (i113 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
            if (i21 <= 256) {
            }
            i14 = i113 & 112;
            if (i14 == 32) {
                z15 = true;
            } else {
                z15 = false;
            }
            z16 = z21 | z15;
            objRememberedValue6 = composer3.rememberedValue();
            if (z16) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.j
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$10$0(previewCardViewModel3, str);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.j
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$10$0(previewCardViewModel3, str);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue4, aVar3, (lb.a) objRememberedValue6, null, strStringResource11, strStringResource12, strStringResource13, strStringResource14, composer3, 48, 8);
            String strStringResource15 = StringResources_androidKt.stringResource(R.string.clear_history_question, composer3, 0);
            String strStringResource16 = StringResources_androidKt.stringResource(R.string.this_action_cant_be_undone, composer3, 0);
            String strStringResource17 = StringResources_androidKt.stringResource(R.string.ok, composer3, 0);
            String strStringResource18 = StringResources_androidKt.stringResource(R.string.no, composer3, 0);
            boolean zBooleanValue5 = ((Boolean) mutableState2.getValue()).booleanValue();
            objRememberedValue7 = composer3.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.k
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$11$0(mutableState2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue7);
            }
            lb.a aVar4 = (lb.a) objRememberedValue7;
            if (i21 <= 256) {
            }
            if (i14 == 32) {
                z17 = true;
            } else {
                z17 = false;
            }
            z18 = z17 | z22;
            objRememberedValue8 = composer3.rememberedValue();
            if (z18) {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.l
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$12$0(previewCardViewModel3, str, mutableState4);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.l
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$12$0(previewCardViewModel3, str, mutableState4);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue8);
            }
            Z17DialogsKt.Z17DialogWithActions(zBooleanValue5, aVar4, (lb.a) objRememberedValue8, null, strStringResource15, strStringResource16, strStringResource17, strStringResource18, composer3, 48, 8);
            composer2 = composer3;
            boolean zBooleanValue6 = ((Boolean) mutableState3.getValue()).booleanValue();
            objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.n
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$13$0(mutableState3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            z19 = false;
            Z17DialogsKt.Z17CustomDialog(zBooleanValue6, (lb.a) objRememberedValue9, ComposableLambdaKt.rememberComposableLambda(1464006765, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviewCardScreenKt.PreviewCardScreen$lambda$14(navHostController, previewCardViewModel3, stateCollectAsStateWithLifecycle5, context2, strStringResource10, clipboardManager2, (lb.a) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 432);
            k0 k0Var2 = k0.f43947a;
            if (i21 <= 256) {
            }
            if (i14 == 32) {
                z19 = true;
            }
            z20 = z23 | z19;
            objRememberedValue10 = composer2.rememberedValue();
            if (z20) {
                objRememberedValue10 = new PreviewCardScreenKt$PreviewCardScreen$10$1(previewCardViewModel3, str, mutableState4, null);
                composer2.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new PreviewCardScreenKt$PreviewCardScreen$10$1(previewCardViewModel3, str, mutableState4, null);
                composer2.updateRememberedValue(objRememberedValue10);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue10, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            previewCardViewModel2 = previewCardViewModel3;
            z13 = z14;
        } else {
            str = uid;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z13 = z10;
            previewCardViewModel2 = previewCardViewModel4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str3 = str;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewCardScreenKt.PreviewCardScreen$lambda$16(navHostController, str3, previewCardViewModel2, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$10$0(PreviewCardViewModel previewCardViewModel, String str) {
        previewCardViewModel.leaveAndDeleteCard(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$11$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$12$0(PreviewCardViewModel previewCardViewModel, String str, final MutableState mutableState) {
        PreviewCardScreen$lambda$6(mutableState, true);
        previewCardViewModel.clearHistory(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.b
            @Override // lb.a
            public final Object invoke() {
                return PreviewCardScreenKt.PreviewCardScreen$lambda$12$0$0(mutableState);
            }
        });
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$12$0$0(MutableState mutableState) {
        PreviewCardScreen$lambda$6(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$13$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewCardScreen$lambda$14(final NavHostController navHostController, final PreviewCardViewModel previewCardViewModel, final State state, final Context context, final String str, final ClipboardManager clipboardManager, final lb.a close, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(close, "close");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changedInstance(close) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464006765, i11, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen.<anonymous> (PreviewCardScreen.kt:327)");
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
            String strStringResource = StringResources_androidKt.stringResource(R.string.invitation_link, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, strStringResource, materialTheme.getTypography(composer, i12).getTitleMedium(), 0L, 0, 0, composer, 0, 57);
            float f10 = 50;
            Modifier modifierM1754defaultMinSizeVpY3zN4$default = SizeKt.m1754defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
            int i13 = i11 & 14;
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(previewCardViewModel) | composer.changed(state) | (i13 == 4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.m
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$14$0$0$0(state, close, navHostController, previewCardViewModel);
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
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changed(str) | composer.changed(state) | (i13 == 4);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.r
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$14$0$2$0(state, close, context, str);
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
            boolean zChanged = composer.changed(state) | composer.changedInstance(clipboardManager) | (i13 == 4);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.s
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$14$0$4$0(state, clipboardManager, close);
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
            boolean zChangedInstance3 = composer.changedInstance(navHostController) | composer.changed(state);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.t
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewCardScreenKt.PreviewCardScreen$lambda$14$0$6$0(navHostController, state);
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
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$14$0$0$0(State state, lb.a aVar, NavHostController navHostController, PreviewCardViewModel previewCardViewModel) {
        String id2;
        Room room = (Room) state.getValue();
        PreviewCardScreen$shareThroughToDus(navHostController, previewCardViewModel, "https://chat.todus.cu/card/" + ((room == null || (id2 = room.getId()) == null) ? null : a0.O(id2, "@im.todus.cu", "", false, 4, null)));
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$14$0$2$0(State state, lb.a aVar, Context context, String str) {
        String id2;
        Room room = (Room) state.getValue();
        PreviewCardScreen$shareThroughOtherApps(context, str, "https://chat.todus.cu/card/" + ((room == null || (id2 = room.getId()) == null) ? null : a0.O(id2, "@im.todus.cu", "", false, 4, null)));
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$14$0$4$0(State state, ClipboardManager clipboardManager, lb.a aVar) {
        String id2;
        Room room = (Room) state.getValue();
        ClipData clipDataNewPlainText = ClipData.newPlainText("link", "https://chat.todus.cu/card/" + ((room == null || (id2 = room.getId()) == null) ? null : a0.O(id2, "@im.todus.cu", "", false, 4, null)));
        kotlin.jvm.internal.y.f(clipDataNewPlainText);
        clipboardManager.setClip(AndroidClipboardManager_androidKt.toClipEntry(clipDataNewPlainText));
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$14$0$6$0(NavHostController navHostController, State state) {
        String id2;
        NavLinks navLinks = NavLinks.INSTANCE;
        Room room = (Room) state.getValue();
        NavController.navigate$default((NavController) navHostController, navLinks.goQrViewer("https://chat.todus.cu/card/" + ((room == null || (id2 = room.getId()) == null) ? null : a0.O(id2, "@im.todus.cu", "", false, 4, null))), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$16(NavHostController navHostController, String str, PreviewCardViewModel previewCardViewModel, boolean z10, int i10, int i11, Composer composer, int i12) {
        PreviewCardScreen(navHostController, str, previewCardViewModel, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$3$0(NavOptionsBuilder navigate) {
        kotlin.jvm.internal.y.i(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
        return k0.f43947a;
    }

    private static final boolean PreviewCardScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewCardScreen$lambda$6(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PreviewCardScreen$lambda$7(NavHostController navHostController, final State state, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1612669035, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen.<anonymous> (PreviewCardScreen.kt:140)");
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(ComposableLambdaKt.rememberComposableLambda(-956355906, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewCardScreenKt.PreviewCardScreen$lambda$7$0(state, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 PreviewCardScreen$lambda$7$0(State state, Composer composer, int i10) {
        String onlyName;
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-956355906, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen.<anonymous>.<anonymous> (PreviewCardScreen.kt:142)");
            }
            Room room = (Room) state.getValue();
            if (room == null || (onlyName = room.getOnlyName()) == null) {
                onlyName = "";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, onlyName, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 PreviewCardScreen$lambda$8(State state, State state2, MutableState mutableState, int i10, State state3, final PreviewCardViewModel previewCardViewModel, final String str, final NavHostController navHostController, State state4, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Modifier m10, Composer composer, int i11) {
        int i12;
        String onlyName;
        kotlin.jvm.internal.y.i(m10, "m");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(m10) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1041558313, i12, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardScreen.<anonymous> (PreviewCardScreen.kt:151)");
            }
            if (state.getValue() == null || PreviewCardScreen$lambda$5(mutableState) || ((FlowsState) state2.getValue()).getStatus() == Status.LOADING) {
                composer.startReplaceGroup(-2074909676);
                LoadingScreenKt.LoadingWall(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2074676401);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(m10, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(i10 / 2));
                Object value = state.getValue();
                kotlin.jvm.internal.y.f(value);
                String picture = ((Room) value).getPicture();
                ContentScale crop = ContentScale.INSTANCE.getCrop();
                ColorGenerator material = ColorGenerator.INSTANCE.getMATERIAL();
                Room room = (Room) state.getValue();
                if (room == null || (onlyName = room.getOnlyName()) == null) {
                    onlyName = "";
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1755height3ABfNKs, picture, Color.m5856boximpl(ColorKt.Color(material.getColor(onlyName))), null, crop, null, 0, null, null, composer, 24576, 488);
                Composer composer2 = composer;
                float f10 = 0;
                float f11 = 20;
                Modifier modifierClip = ClipKt.clip(OffsetKt.m1684offsetVpY3zN4(IntrinsicKt.height(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), IntrinsicSize.Max), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(-Dp.m8823constructorimpl(f11))), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)));
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i13 = MaterialTheme.$stable;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierClip, materialTheme.getColorScheme(composer2, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl(f11));
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composer2, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
                lb.a constructor2 = companion2.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                Room room2 = (Room) state.getValue();
                if (room2 == null) {
                    composer2.startReplaceGroup(-1743072159);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1743072158);
                    SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), composer2, 6);
                    Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                    ImageVector info = InfoKt.getInfo(outlined);
                    String strStringResource = StringResources_androidKt.stringResource(R.string.information, composer2, 0);
                    composer2.startReplaceGroup(-1995884723);
                    String onlySubject = room2.getOnlySubject();
                    if (d0.q0(onlySubject)) {
                        onlySubject = StringResources_androidKt.stringResource(R.string.todus_card, composer2, 0);
                    }
                    composer2.endReplaceGroup();
                    Object objRememberedValue = composer2.rememberedValue();
                    Composer.Companion companion4 = Composer.INSTANCE;
                    if (objRememberedValue == companion4.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.u
                            @Override // lb.a
                            public final Object invoke() {
                                return k0.f43947a;
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    RichTitleDescBtnKt.RichTitleDescBtn(info, strStringResource, onlySubject, (lb.a) objRememberedValue, composer2, 3072);
                    ImageVector deleteOutline = DeleteOutlineKt.getDeleteOutline(outlined);
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.clear_history, composer2, 0);
                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.clear_history_of_msgs, composer2, 0);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == companion4.getEmpty()) {
                        objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.v
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$2$0(mutableState2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(deleteOutline, strStringResource2, strStringResource3, 0L, (lb.a) objRememberedValue2, composer2, 24576, 8);
                    ImageVector lockOpen = ((Boolean) state3.getValue()).booleanValue() ? LockOpenKt.getLockOpen(outlined) : LockKt.getLock(outlined);
                    String strStringResource4 = StringResources_androidKt.stringResource(((Boolean) state3.getValue()).booleanValue() ? R.string.pull_out_secret : R.string.make_it_secret, composer2, 0);
                    String strStringResource5 = StringResources_androidKt.stringResource(((Boolean) state3.getValue()).booleanValue() ? R.string.pull_out_secret_text : R.string.make_it_secret_text, composer2, 0);
                    boolean zChangedInstance = composer2.changedInstance(previewCardViewModel) | composer2.changed(str);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == companion4.getEmpty()) {
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.w
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$3$0(previewCardViewModel, str);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(lockOpen, strStringResource4, strStringResource5, 0L, (lb.a) objRememberedValue3, composer2, 0, 8);
                    ImageVector share = ShareKt.getShare(outlined);
                    String strStringResource6 = StringResources_androidKt.stringResource(R.string.share, composer2, 0);
                    String str2 = "https://chat.todus.cu/card/" + a0.O(room2.getId(), "@im.todus.cu", "", false, 4, null);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion4.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.x
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$4$0(mutableState3);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(share, strStringResource6, str2, 0L, (lb.a) objRememberedValue4, composer2, 24576, 8);
                    ImageVector exitToApp = ExitToAppKt.getExitToApp(Icons.AutoMirrored.Outlined.INSTANCE);
                    String strStringResource7 = StringResources_androidKt.stringResource(R.string.unsubscribe, composer2, 0);
                    String strStringResource8 = StringResources_androidKt.stringResource(R.string.stop_interact_card, composer2, 0);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == companion4.getEmpty()) {
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.y
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$5$0(mutableState4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(exitToApp, strStringResource7, strStringResource8, 0L, (lb.a) objRememberedValue5, composer2, 24576, 8);
                    DividerKt.m3177HorizontalDivider9IZ8Weo(PaddingKt.m1726paddingVpY3zN4(companion3, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(5)), 0.0f, materialTheme.getColorScheme(composer2, i13).getTertiary(), composer, 6, 2);
                    ImageVector folder = FolderKt.getFolder(outlined);
                    String strStringResource9 = StringResources_androidKt.stringResource(R.string.folder, composer, 0);
                    String strStringResource10 = StringResources_androidKt.stringResource(R.string.find_the_chat_attachments, composer, 0);
                    boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changed(str);
                    Object objRememberedValue6 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue6 == companion4.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.c
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$6$0(navHostController, str);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue6);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(folder, strStringResource9, strStringResource10, 0L, (lb.a) objRememberedValue6, composer, 0, 8);
                    ImageVector tagFaces = TagFacesKt.getTagFaces(outlined);
                    String strStringResource11 = StringResources_androidKt.stringResource(R.string.social_profile, composer, 0);
                    String strStringResource12 = StringResources_androidKt.stringResource(R.string.search_the_media_shared, composer, 0);
                    boolean zChangedInstance3 = composer.changedInstance(navHostController) | composer.changed(str);
                    Object objRememberedValue7 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue7 == companion4.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.d
                            @Override // lb.a
                            public final Object invoke() {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$7$0(navHostController, str);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue7);
                    }
                    RichTitleDescBtnKt.m10077TitleDescBtnuDo3WH8(tagFaces, strStringResource11, strStringResource12, 0L, (lb.a) objRememberedValue7, composer, 0, 8);
                    composer2 = composer;
                    Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(16), 0.0f, 2, null);
                    boolean z10 = !((Boolean) state4.getValue()).booleanValue();
                    boolean zChangedInstance4 = composer2.changedInstance(previewCardViewModel) | composer2.changed(str);
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue8 == companion4.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PreviewCardScreenKt.PreviewCardScreen$lambda$8$0$0$0$8$0(previewCardViewModel, str, ((Boolean) obj).booleanValue());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    Z17TextToggleKt.Z17TextToggle(modifierM1727paddingVpY3zN4$default, z10, (Function1) objRememberedValue8, ComposableSingletons$PreviewCardScreenKt.INSTANCE.m9913getLambda$188596768$app_productionPFast(), StringResources_androidKt.stringResource(R.string.notifications, composer2, 0), null, null, composer2, 3078, 96);
                    k0 k0Var = k0.f43947a;
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
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
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$2$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$3$0(PreviewCardViewModel previewCardViewModel, String str) {
        previewCardViewModel.changeSecretState(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$4$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$5$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$6$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goChatResources(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$7$0(NavHostController navHostController, String str) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$8$0$0$0$8$0(PreviewCardViewModel previewCardViewModel, String str, boolean z10) {
        previewCardViewModel.changeMuteValue(str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PreviewCardScreen$lambda$9$0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    private static final void PreviewCardScreen$shareThroughOtherApps(Context context, String str, String str2) {
        IntentUtil.INSTANCE.shareText(context, str, str2);
    }

    private static final void PreviewCardScreen$shareThroughToDus(NavHostController navHostController, PreviewCardViewModel previewCardViewModel, String str) {
        SendToParams sendToParams = new SendToParams(va.w.g(new Send(9, str)));
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = previewCardViewModel.getGson().t(sendToParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goForwardTo(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }
}
