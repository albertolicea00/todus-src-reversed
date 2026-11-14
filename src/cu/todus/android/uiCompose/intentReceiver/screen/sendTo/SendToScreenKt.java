package cu.todus.android.uiCompose.intentReceiver.screen.sendTo;

import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
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
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
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
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.db.pojo.UserCommon;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.intentReceiver.screen.presend.PresentParams;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.main.screen.statusEditor.StatusEditorParams;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ForwardChipKt;
import cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.SearchContactTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.multipleList.MultipleListKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.g0;
import va.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\n\u001a\u0004\u0018\u00010\t8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u00020\u000f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;", "viewModel", "Lua/k0;", "SendToScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "ownerLastStatus", "Lkotlin/Function0;", "onClick", "SendDirectStatus", "(Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;Lcu/todus/android/uiCompose/intentReceiver/screen/sendTo/SendToViewModel;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", "isLoading", "showFloatingActionBtn", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SendToScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendDirectStatus(final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final SendToViewModel viewModel, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        Modifier.Companion companion;
        int i12;
        int i13;
        Composer composer3;
        kotlin.jvm.internal.y.i(viewModel, "viewModel");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1336159761);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(statusWithPartnersOrRooms) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(viewModel) : composerStartRestartGroup.changedInstance(viewModel) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1336159761, i11, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendDirectStatus (SendToScreen.kt:414)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            boolean z10 = (i11 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.p
                    @Override // lb.a
                    public final Object invoke() {
                        return SendToScreenKt.SendDirectStatus$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            float f10 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null), 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            Brush.Companion companion3 = Brush.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.background$default(modifierM1725padding3ABfNKs, Brush.Companion.m5827verticalGradient8A3gB4$default(companion3, va.w.q(Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i14).getInversePrimary()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i14).getInversePrimary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)), 0.0f, 4, null), Dp.m8823constructorimpl(f10));
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (statusWithPartnersOrRooms != null) {
                composerStartRestartGroup.startReplaceGroup(1770821218);
                Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion2, Dp.m8823constructorimpl(50)), Dp.m8823constructorimpl(2), materialTheme.getColorScheme(composerStartRestartGroup, i14).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs3);
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer3 = composerStartRestartGroup;
                i13 = 0;
                i12 = i14;
                companion = companion2;
                StatusItemKt.StatusItem(ClipKt.clip(companion2, RoundedCornerShapeKt.getCircleShape()), statusWithPartnersOrRooms.getStatus().getContent(), true, false, false, false, 100, kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getStatus().getCreatorId(), statusWithPartnersOrRooms.getStatus().getRepliedId()) && kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getStatus().getRepliedId(), viewModel.owner().getNameWithDomain()), null, composer3, 1573248, 312);
                composer3.endNode();
                composer3.endReplaceGroup();
            } else {
                companion = companion2;
                i12 = i14;
                i13 = 0;
                composerStartRestartGroup.startReplaceGroup(1770846939);
                Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(50)), Dp.m8823constructorimpl(f10), materialTheme.getColorScheme(composerStartRestartGroup, i12).getPrimary(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), viewModel.owner().getPhotoUrl(), Integer.valueOf(R.drawable.profile), null, null, 0, null, false, null, null, false, 0, composerStartRestartGroup, 0, 0, 4088);
                composer3 = composerStartRestartGroup;
                composer3.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composer3, 6);
            Composer composer4 = composer3;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.direct_post, composer3, i13), materialTheme.getTypography(composer3, i12).getTitleSmall(), 0L, 0, 0, composer4, 0, 57);
            composer2 = composer4;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SendToScreenKt.SendDirectStatus$lambda$2(statusWithPartnersOrRooms, viewModel, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendDirectStatus$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendDirectStatus$lambda$2(StatusWithPartnersOrRooms statusWithPartnersOrRooms, SendToViewModel sendToViewModel, lb.a aVar, int i10, Composer composer, int i11) {
        SendDirectStatus(statusWithPartnersOrRooms, sendToViewModel, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:64:0x0106  */
    /* JADX WARN: Code duplicated, block: B:67:0x0119  */
    /* JADX WARN: Code duplicated, block: B:70:0x0158  */
    /* JADX WARN: Code duplicated, block: B:73:0x016d  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:82:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:85:0x0242  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendToScreen(final NavHostController navHostController, final String params, SendToViewModel sendToViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final SendToViewModel sendToViewModel2;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        final SendToParams sendToParams;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final SnapshotStateMap snapshotStateMap;
        Object objRememberedValue6;
        final MutableState mutableState;
        Object objRememberedValue7;
        int i14;
        SendToViewModel sendToViewModel3 = sendToViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(321512747);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(params) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i14 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(sendToViewModel3) : composerStartRestartGroup.changedInstance(sendToViewModel3)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
            }
            i12 |= i14;
        }
        int i15 = i12;
        if (composerStartRestartGroup.shouldExecute((i15 & 147) != 146, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i15 &= -897;
                    i13 = 1;
                    sendToViewModel3 = (SendToViewModel) ViewModelKt.viewModel(z0.b(SendToViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(321512747, i15, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen (SendToScreen.kt:81)");
                }
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (SendToParams) sendToViewModel3.getGson().j(params, SendToParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                sendToParams = (SendToParams) objRememberedValue;
                if (sendToParams.getToSend().isEmpty()) {
                    navHostController.navigateUp();
                }
                ScaffoldState scaffoldStateRememberScaffoldState = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.recent((String) mutableState2.getValue()), null, composerStartRestartGroup, 0, i13);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems2 = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.groupsAndChannels((String) mutableState2.getValue()), null, composerStartRestartGroup, 0, i13);
                final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems3 = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.friendsOnDbNoHeaders((String) mutableState2.getValue()), null, composerStartRestartGroup, 0, i13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue4;
                final SendToViewModel sendToViewModel4 = sendToViewModel3;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(sendToViewModel3.ownerLastStatus(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.mutableStateMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                snapshotStateMap = (SnapshotStateMap) objRememberedValue5;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState = (MutableState) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.d
                        @Override // lb.a
                        public final Object invoke() {
                            return Boolean.valueOf(SendToScreenKt.SendToScreen$lambda$9$0(snapshotStateMap, mutableState));
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final State state = (State) objRememberedValue7;
                boolean zSendToScreen$lambda$10 = SendToScreen$lambda$10(state);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1228602487, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.o
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SendToScreenKt.SendToScreen$lambda$11(mutableState3, navHostController, context, mutableState2, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-803199325, true, new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SendToScreenKt.SendToScreen$lambda$12(context, navHostController, sendToViewModel4, sendToParams, mutableState, snapshotStateMap, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-106608715, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SendToScreenKt.SendToScreen$lambda$13(sendToViewModel4, mutableState4, lazyPagingItemsCollectAsLazyPagingItems, lazyPagingItemsCollectAsLazyPagingItems2, lazyPagingItemsCollectAsLazyPagingItems3, snapshotStateMap, state, context, navHostController, stateCollectAsStateWithLifecycle, sendToParams, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup = composerStartRestartGroup;
                Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda, false, false, zSendToScreen$lambda$10, composableLambdaRememberComposableLambda2, null, 0L, scaffoldStateRememberScaffoldState, null, composableLambdaRememberComposableLambda3, composerStartRestartGroup, 805331382, 352);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sendToViewModel2 = sendToViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i15 &= -897;
                }
            }
            i13 = 1;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(321512747, i15, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen (SendToScreen.kt:81)");
            }
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (SendToParams) sendToViewModel3.getGson().j(params, SendToParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            sendToParams = (SendToParams) objRememberedValue;
            if (sendToParams.getToSend().isEmpty()) {
                navHostController.navigateUp();
            }
            ScaffoldState scaffoldStateRememberScaffoldState2 = ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue2;
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems4 = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.recent((String) mutableState5.getValue()), null, composerStartRestartGroup, 0, i13);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems5 = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.groupsAndChannels((String) mutableState5.getValue()), null, composerStartRestartGroup, 0, i13);
            final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems6 = LazyPagingItemsKt.collectAsLazyPagingItems(sendToViewModel3.friendsOnDbNoHeaders((String) mutableState5.getValue()), null, composerStartRestartGroup, 0, i13);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue4;
            final SendToViewModel sendToViewModel5 = sendToViewModel3;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(sendToViewModel3.ownerLastStatus(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.mutableStateMapOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            snapshotStateMap = (SnapshotStateMap) objRememberedValue5;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            mutableState = (MutableState) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.d
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(SendToScreenKt.SendToScreen$lambda$9$0(snapshotStateMap, mutableState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final State state2 = (State) objRememberedValue7;
            boolean zSendToScreen$lambda$11 = SendToScreen$lambda$10(state2);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1228602487, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SendToScreenKt.SendToScreen$lambda$11(mutableState6, navHostController, context2, mutableState5, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-803199325, true, new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SendToScreenKt.SendToScreen$lambda$12(context2, navHostController, sendToViewModel5, sendToParams, mutableState, snapshotStateMap, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-106608715, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SendToScreenKt.SendToScreen$lambda$13(sendToViewModel5, mutableState7, lazyPagingItemsCollectAsLazyPagingItems4, lazyPagingItemsCollectAsLazyPagingItems5, lazyPagingItemsCollectAsLazyPagingItems6, snapshotStateMap, state2, context2, navHostController, stateCollectAsStateWithLifecycle2, sendToParams, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup = composerStartRestartGroup;
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(composableLambdaRememberComposableLambda4, false, false, zSendToScreen$lambda$11, composableLambdaRememberComposableLambda5, null, 0L, scaffoldStateRememberScaffoldState2, null, composableLambdaRememberComposableLambda6, composerStartRestartGroup, 805331382, 352);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sendToViewModel2 = sendToViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            sendToViewModel2 = sendToViewModel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SendToScreenKt.SendToScreen$lambda$14(navHostController, params, sendToViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean SendToScreen$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$11(final MutableState mutableState, NavHostController navHostController, final Context context, final MutableState mutableState2, TopAppBarScrollBehavior it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1228602487, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous> (SendToScreen.kt:129)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.startReplaceGroup(-414557902);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.i
                        @Override // lb.a
                        public final Object invoke() {
                            return SendToScreenKt.SendToScreen$lambda$11$0$0(mutableState2, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar = (lb.a) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SendToScreenKt.SendToScreen$lambda$11$1$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                SearchContactTopBarKt.SearchContactTopBar(navHostController, aVar, (Function1) objRememberedValue2, composer, 432);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-414142688);
                Function2 function2M9833getLambda$1470238034$app_productionPFast = ComposableSingletons$SendToScreenKt.INSTANCE.m9833getLambda$1470238034$app_productionPFast();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1006632867, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.k
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SendToScreenKt.SendToScreen$lambda$11$2(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                boolean zChangedInstance = composer.changedInstance(context);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.l
                        @Override // lb.a
                        public final Object invoke() {
                            return SendToScreenKt.SendToScreen$lambda$11$3$0(context);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9833getLambda$1470238034$app_productionPFast, null, false, composableLambdaRememberComposableLambda, false, navHostController, (lb.a) objRememberedValue3, null, 0L, 0L, Dp.m8823constructorimpl(0), composer, 3078, 6, 918);
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
    public static final k0 SendToScreen$lambda$11$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue("");
        mutableState2.setValue(Boolean.FALSE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$11$1$0(MutableState mutableState, String f10) {
        kotlin.jvm.internal.y.i(f10, "f");
        mutableState.setValue(f10);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$11$2(final MutableState mutableState, RowScope Z17TopBar, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17TopBar, "$this$Z17TopBar");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1006632867, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous>.<anonymous> (SendToScreen.kt:149)");
            }
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.v
                    @Override // lb.a
                    public final Object invoke() {
                        return SendToScreenKt.SendToScreen$lambda$11$2$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, null, ComposableSingletons$SendToScreenKt.INSTANCE.getLambda$424332865$app_productionPFast(), composer, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$11$2$0$0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$11$3$0(Context context) {
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$12(final Context context, final NavHostController navHostController, final SendToViewModel sendToViewModel, final SendToParams sendToParams, final MutableState mutableState, final SnapshotStateMap snapshotStateMap, final MutableState mutableState2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-803199325, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous> (SendToScreen.kt:180)");
            }
            boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(navHostController) | composer.changedInstance(sendToViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.n
                    @Override // lb.a
                    public final Object invoke() {
                        return SendToScreenKt.SendToScreen$lambda$12$0$0(sendToParams, context, mutableState, snapshotStateMap, navHostController, sendToViewModel, mutableState2);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            FloatingActionButtonKt.m3252FloatingActionButtonXz6DiA((lb.a) objRememberedValue, null, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, null, null, ComposableSingletons$SendToScreenKt.INSTANCE.m9834getLambda$2112570399$app_productionPFast(), composer, 12582912, 118);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$12$0$0(SendToParams sendToParams, final Context context, final MutableState mutableState, final SnapshotStateMap snapshotStateMap, NavHostController navHostController, SendToViewModel sendToViewModel, final MutableState mutableState2) {
        File file;
        Object next;
        Object next2;
        List<String> listO1;
        List listO2;
        String toSend;
        List<String> listO3;
        Iterator<T> it = sendToParams.getToSend().iterator();
        do {
            file = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Send) next).getType() != 2);
        Send send = (Send) next;
        Iterator<T> it2 = sendToParams.getToSend().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (((Send) next2).getType() != 4);
        Send send2 = (Send) next2;
        if (send == null && send2 == null) {
            SendToScreen$lambda$5(mutableState2, true);
            if (mutableState.getValue() != null) {
                Object value = mutableState.getValue();
                kotlin.jvm.internal.y.f(value);
                listO3 = va.v.e(((RoomItemView) value).getRoom().getId());
            } else {
                ArrayList arrayList = new ArrayList(snapshotStateMap.size());
                Iterator it3 = snapshotStateMap.entrySet().iterator();
                while (it3.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it3.next()).getKey());
                }
                listO3 = g0.o1(arrayList);
            }
            sendToViewModel.sendTo(listO3, sendToParams.getToSend(), context, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.h
                @Override // lb.a
                public final Object invoke() {
                    return SendToScreenKt.SendToScreen$lambda$12$0$0$6(snapshotStateMap, mutableState, context, mutableState2);
                }
            });
        } else {
            try {
                MediaUtil mediaUtil = MediaUtil.INSTANCE;
                if (send == null || (toSend = send.getToSend()) == null) {
                    toSend = send2 != null ? send2.getToSend() : "/";
                }
                Uri uri = Uri.parse(toSend);
                kotlin.jvm.internal.y.h(uri, "parse(...)");
                String path = mediaUtil.getPath(context, uri);
                kotlin.jvm.internal.y.f(path);
                file = new File(path);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (file != null) {
                if (mutableState.getValue() != null) {
                    Object value2 = mutableState.getValue();
                    kotlin.jvm.internal.y.f(value2);
                    listO2 = va.v.e(((RoomItemView) value2).getRoom().getId());
                } else {
                    ArrayList arrayList2 = new ArrayList(snapshotStateMap.size());
                    Iterator it4 = snapshotStateMap.entrySet().iterator();
                    while (it4.hasNext()) {
                        arrayList2.add((String) ((Map.Entry) it4.next()).getKey());
                    }
                    listO2 = g0.o1(arrayList2);
                }
                int i10 = send != null ? 1 : 2;
                String path2 = file.getPath();
                kotlin.jvm.internal.y.h(path2, "getPath(...)");
                PresentParams presentParams = new PresentParams(listO2, i10, path2);
                NavLinks navLinks = NavLinks.INSTANCE;
                String strT = sendToViewModel.getGson().t(presentParams);
                kotlin.jvm.internal.y.h(strT, "toJson(...)");
                NavController.navigate$default((NavController) navHostController, navLinks.goPresent(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            } else {
                SendToScreen$lambda$5(mutableState2, true);
                if (mutableState.getValue() != null) {
                    Object value3 = mutableState.getValue();
                    kotlin.jvm.internal.y.f(value3);
                    listO1 = va.v.e(((RoomItemView) value3).getRoom().getId());
                } else {
                    ArrayList arrayList3 = new ArrayList(snapshotStateMap.size());
                    Iterator it5 = snapshotStateMap.entrySet().iterator();
                    while (it5.hasNext()) {
                        arrayList3.add((String) ((Map.Entry) it5.next()).getKey());
                    }
                    listO1 = g0.o1(arrayList3);
                }
                sendToViewModel.sendTo(listO1, sendToParams.getToSend(), context, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.g
                    @Override // lb.a
                    public final Object invoke() {
                        return SendToScreenKt.SendToScreen$lambda$12$0$0$4(snapshotStateMap, mutableState, context, mutableState2);
                    }
                });
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$12$0$0$4(SnapshotStateMap snapshotStateMap, MutableState mutableState, Context context, MutableState mutableState2) {
        SendToScreen$lambda$5(mutableState2, false);
        snapshotStateMap.clear();
        mutableState.setValue(null);
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$12$0$0$6(SnapshotStateMap snapshotStateMap, MutableState mutableState, Context context, MutableState mutableState2) {
        SendToScreen$lambda$5(mutableState2, false);
        snapshotStateMap.clear();
        mutableState.setValue(null);
        Z17InlineUtilsKt.findActivity(context).finish();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$13(final SendToViewModel sendToViewModel, MutableState mutableState, LazyPagingItems lazyPagingItems, LazyPagingItems lazyPagingItems2, LazyPagingItems lazyPagingItems3, final SnapshotStateMap snapshotStateMap, State state, final Context context, final NavHostController navHostController, final State state2, final SendToParams sendToParams, Modifier it, Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.y.i(it, "it");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(it) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-106608715, i11, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous> (SendToScreen.kt:269)");
            }
            if (SendToScreen$lambda$4(mutableState)) {
                composer.startReplaceGroup(628435202);
                LoadingScreenKt.LoadingWall(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(628246881);
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getBottomEnd(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, it);
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
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getStart(), composer, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion3);
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
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, !SendToScreen$lambda$10(state), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1756632282, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.x
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SendToScreenKt.SendToScreen$lambda$13$0$0$0(sendToViewModel, context, navHostController, state2, sendToParams, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1572870, 30);
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, SendToScreen$lambda$10(state), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1114627599, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.y
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SendToScreenKt.SendToScreen$lambda$13$0$0$1(snapshotStateMap, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1572870, 30);
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion4 = Composer.INSTANCE;
                if (objRememberedValue == companion4.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SendToScreenKt.SendToScreen$lambda$13$0$0$2$0(snapshotStateMap, (UserCommon) obj, (RoomItemView) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function2 function2 = (Function2) objRememberedValue;
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion4.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SendToScreenKt.SendToScreen$lambda$13$0$0$3$0(snapshotStateMap, (UserCommon) obj, (RoomItemView) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function2 function3 = (Function2) objRememberedValue2;
                boolean zIsEmpty = true ^ snapshotStateMap.isEmpty();
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion4.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(SendToScreenKt.SendToScreen$lambda$13$0$0$4$0(snapshotStateMap, (String) obj));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function1 = (Function1) objRememberedValue3;
                String nameWithDomain = sendToViewModel.owner().getNameWithDomain();
                int i12 = LazyPagingItems.$stable;
                MultipleListKt.MultipleList(companion3, lazyPagingItems, lazyPagingItems2, lazyPagingItems3, function2, function3, zIsEmpty, function1, nameWithDomain, composer, (i12 << 3) | 12804102 | (i12 << 6) | (i12 << 9));
                composer.endNode();
                composer.endNode();
                composer.endReplaceGroup();
            }
            k0 k0Var = k0.f43947a;
            boolean zChangedInstance = composer.changedInstance(sendToViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new SendToScreenKt$SendToScreen$3$2$1(sendToViewModel, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composer, 6);
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
    public static final k0 SendToScreen$lambda$13$0$0$0(final SendToViewModel sendToViewModel, final Context context, final NavHostController navHostController, State state, final SendToParams sendToParams, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1756632282, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SendToScreen.kt:277)");
        }
        StatusWithPartnersOrRooms statusWithPartnersOrRoomsSendToScreen$lambda$6 = SendToScreen$lambda$6(state);
        boolean zChangedInstance = composer.changedInstance(context) | composer.changedInstance(navHostController) | composer.changedInstance(sendToViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.r
                @Override // lb.a
                public final Object invoke() {
                    return SendToScreenKt.SendToScreen$lambda$13$0$0$0$0$0(sendToParams, context, navHostController, sendToViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        SendDirectStatus(statusWithPartnersOrRoomsSendToScreen$lambda$6, sendToViewModel, (lb.a) objRememberedValue, composer, SendToViewModel.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fd  */
    public static final k0 SendToScreen$lambda$13$0$0$0$0$0(SendToParams sendToParams, Context context, NavHostController navHostController, SendToViewModel sendToViewModel) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        File file;
        String path;
        String toSend;
        String mimeType;
        Iterator<T> it = sendToParams.getToSend().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Send) next).getType() != 2);
        Send send = (Send) next;
        Iterator<T> it2 = sendToParams.getToSend().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (((Send) next2).getType() != 4);
        Send send2 = (Send) next2;
        Iterator<T> it3 = sendToParams.getToSend().iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (((Send) next3).getType() != 6);
        Send send3 = (Send) next3;
        Iterator<T> it4 = sendToParams.getToSend().iterator();
        do {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
        } while (((Send) next4).getType() != 1);
        Send send4 = (Send) next4;
        if (send == null && send2 == null && send3 == null) {
            path = null;
        } else {
            try {
                MediaUtil mediaUtil = MediaUtil.INSTANCE;
                if (send == null || (toSend = send.getToSend()) == null) {
                    if (send2 != null) {
                        toSend = send2.getToSend();
                    } else {
                        toSend = send3 != null ? send3.getToSend() : null;
                        if (toSend == null) {
                            toSend = "/";
                        }
                    }
                }
                Uri uri = Uri.parse(toSend);
                kotlin.jvm.internal.y.h(uri, "parse(...)");
                String path2 = mediaUtil.getPath(context, uri);
                kotlin.jvm.internal.y.f(path2);
                file = new File(path2);
            } catch (Exception e10) {
                e10.printStackTrace();
                file = null;
            }
            if (file != null) {
                path = file.getPath();
            } else {
                path = null;
            }
        }
        if (send == null && send2 == null && send3 != null) {
            MediaUtil mediaUtil2 = MediaUtil.INSTANCE;
            Uri uri2 = Uri.parse(send3.getToSend());
            kotlin.jvm.internal.y.h(uri2, "parse(...)");
            mimeType = mediaUtil2.getMimeType(context, uri2);
        } else {
            mimeType = null;
        }
        String str = Status.IMG_TYPE;
        if (mimeType == null || !MediaUtil.INSTANCE.isImageType(mimeType)) {
            if (mimeType != null && MediaUtil.INSTANCE.isVideoType(mimeType)) {
                str = Status.VIDEO_TYPE;
            } else if (send == null) {
                if (send2 != null) {
                    str = Status.VIDEO_TYPE;
                } else {
                    str = Status.TEXT_TYPE;
                }
            }
        }
        StatusEditorParams statusEditorParams = new StatusEditorParams(str, send4 != null ? send4.getToSend() : null, path);
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = sendToViewModel.getGson().t(statusEditorParams);
        kotlin.jvm.internal.y.h(strT, "toJson(...)");
        NavController.navigate$default((NavController) navHostController, navLinks.goStatusEditor(strT), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$13$0$0$1(final SnapshotStateMap snapshotStateMap, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1114627599, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SendToScreen.kt:338)");
        }
        FlowLayoutKt.FlowRow(PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(20), 0.0f, 2, null), null, null, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(210821578, true, new Function3() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.w
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SendToScreenKt.SendToScreen$lambda$13$0$0$1$0(snapshotStateMap, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 1572870, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 SendToScreen$lambda$13$0$0$1$0(final SnapshotStateMap snapshotStateMap, FlowRowScope FlowRow, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(FlowRow, "$this$FlowRow");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(210821578, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.SendToScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SendToScreen.kt:342)");
            }
            Iterator it = snapshotStateMap.entrySet().iterator();
            while (it.hasNext()) {
                final Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getValue();
                boolean zChangedInstance = composer.changedInstance(entry);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.m
                        @Override // lb.a
                        public final Object invoke() {
                            return SendToScreenKt.SendToScreen$lambda$13$0$0$1$0$0$0$0(snapshotStateMap, entry);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ForwardChipKt.ForwardChip(str, (lb.a) objRememberedValue, composer, 0);
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
    public static final k0 SendToScreen$lambda$13$0$0$1$0$0$0$0(SnapshotStateMap snapshotStateMap, Map.Entry entry) {
        snapshotStateMap.remove(entry.getKey());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$13$0$0$2$0(SnapshotStateMap snapshotStateMap, UserCommon userCommon, RoomItemView roomItemView) {
        if (userCommon != null) {
            if (snapshotStateMap.containsKey(userCommon.getId())) {
                snapshotStateMap.remove(userCommon.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(userCommon.getId(), userCommon.getName());
            }
        }
        if (roomItemView != null) {
            if (snapshotStateMap.containsKey(roomItemView.getId())) {
                snapshotStateMap.remove(roomItemView.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(roomItemView.getId(), roomItemView.getName());
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$13$0$0$3$0(SnapshotStateMap snapshotStateMap, UserCommon userCommon, RoomItemView roomItemView) {
        if (userCommon != null) {
            if (snapshotStateMap.containsKey(userCommon.getId())) {
                snapshotStateMap.remove(userCommon.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(userCommon.getId(), userCommon.getName());
            }
        }
        if (roomItemView != null) {
            if (snapshotStateMap.containsKey(roomItemView.getId())) {
                snapshotStateMap.remove(roomItemView.getId());
            } else if (snapshotStateMap.size() < 5) {
                snapshotStateMap.put(roomItemView.getId(), roomItemView.getName());
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SendToScreen$lambda$13$0$0$4$0(SnapshotStateMap snapshotStateMap, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return snapshotStateMap.containsKey(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SendToScreen$lambda$14(NavHostController navHostController, String str, SendToViewModel sendToViewModel, int i10, int i11, Composer composer, int i12) {
        SendToScreen(navHostController, str, sendToViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final boolean SendToScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SendToScreen$lambda$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final StatusWithPartnersOrRooms SendToScreen$lambda$6(State<StatusWithPartnersOrRooms> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SendToScreen$lambda$9$0(SnapshotStateMap snapshotStateMap, MutableState mutableState) {
        return (y0.C(snapshotStateMap).isEmpty() && mutableState.getValue() == null) ? false : true;
    }
}
