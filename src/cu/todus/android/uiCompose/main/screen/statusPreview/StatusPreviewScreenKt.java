package cu.todus.android.uiCompose.main.screen.statusPreview;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
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
import androidx.paging.compose.LazyFoundationExtensionsKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.uiCompose.main.screen.chat.details.MsgDetailsDialogKt;
import cu.todus.android.uiCompose.main.screen.statusList.StatusItemKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicatorData;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicatorKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBarKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailData;
import cu.todus.android.uiCompose.main.screen.statusPreview.authorsDetail.AuthorsDetailDialogKt;
import cu.todus.android.uiCompose.main.screen.statusPreview.topBar.StatusPreviewTopBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.modal.ModalKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u0011\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aA\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006*²\u0006\u000e\u0010\u001d\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010 \u001a\u0004\u0018\u00010\u001f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\"\u001a\u00020!8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010#\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010$\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010&\u001a\u0004\u0018\u00010%8\nX\u008a\u0084\u0002²\u0006\f\u0010'\u001a\u00020\u00158\nX\u008a\u0084\u0002²\u0006\u000e\u0010)\u001a\u0004\u0018\u00010(8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "", "params", "Lcu/todus/android/uiCompose/main/screen/statusPreview/StatusPreviewViewModel;", "viewModel", "Lua/k0;", "StatusPreviewScreen", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/statusPreview/StatusPreviewViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/paging/compose/LazyPagingItems;", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "reactions", "ViewsList", "(Landroidx/paging/compose/LazyPagingItems;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function0;", "onVolumeUp", "onVolumeDown", "VolumeButtonsHandler", "(Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "", "show", "", "icon", "label", "onClick", "StatusActionInMoreMenu", "(Landroidx/compose/ui/Modifier;ZLjava/lang/Object;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;II)V", "hasSound", "canScroll", "Lcu/todus/android/uiCompose/main/screen/statusPreview/authorsDetail/AuthorsDetailData;", "authorsDetail", "Lcu/todus/android/uiCompose/main/screen/statusPreview/actionIndicator/ActionIndicatorData;", "actionIndicator", "canPlay", "showAllDescription", "", "viewsCount", "isCurrentPage", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "actualReaction", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusPreviewScreenKt {
    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0095  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x013a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0146  */
    /* JADX WARN: Code duplicated, block: B:76:0x014a  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:83:0x0207  */
    /* JADX WARN: Code duplicated, block: B:86:0x0212  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    @Composable
    public static final void StatusActionInMoreMenu(Modifier modifier, boolean z10, final Object icon, final String label, final lb.a onClick, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        final Modifier modifier3;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z14;
        Modifier modifier5;
        boolean z15;
        Object objRememberedValue;
        lb.a constructor;
        int i14;
        int i15;
        int i16;
        kotlin.jvm.internal.y.i(icon, "icon");
        kotlin.jvm.internal.y.i(label, "label");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1302025486);
        int i17 = i11 & 1;
        if (i17 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        int i18 = i11 & 2;
        if (i18 == 0) {
            if ((i10 & 48) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
            }
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changedInstance(icon)) {
                    i16 = 256;
                } else {
                    i16 = 128;
                }
                i12 |= i16;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changed(label)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i12 |= i15;
            }
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i13 = i12;
            if ((i13 & 9363) != 9362) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1302025486, i13, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusActionInMoreMenu (StatusPreviewScreen.kt:596)");
                }
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(1411015042);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    z15 = (57344 & i13) == 16384;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.l0
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusPreviewScreenKt.StatusActionInMoreMenu$lambda$0$0(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    float f10 = 5;
                    Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(10));
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                    int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN4);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    constructor = companion.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null);
                    ColorFilter.Companion companion2 = ColorFilter.INSTANCE;
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i19 = MaterialTheme.$stable;
                    modifier5 = modifier4;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default, icon, null, ColorFilter.Companion.m5907tintxETnrds$default(companion2, materialTheme.getColorScheme(composerStartRestartGroup, i19).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i13 >> 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, label, materialTheme.getTypography(composerStartRestartGroup, i19).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, (i13 >> 6) & 112, 57);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(792366100);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.m0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatusPreviewScreenKt.StatusActionInMoreMenu$lambda$2(modifier3, z13, icon, label, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        z11 = z10;
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changedInstance(icon)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changed(label)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        if ((i10 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        i13 = i12;
        if ((i13 & 9363) != 9362) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i13 & 1)) {
            if (i17 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i18 != 0) {
                z14 = true;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1302025486, i13, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusActionInMoreMenu (StatusPreviewScreen.kt:596)");
            }
            if (z14) {
                composerStartRestartGroup.startReplaceGroup(1411015042);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                if ((57344 & i13) == 16384) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.l0
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusActionInMoreMenu$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.l0
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusActionInMoreMenu$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float f11 = 5;
                Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default2, false, null, null, null, (lb.a) objRememberedValue, 15, null), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(10));
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1726paddingVpY3zN5);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
                ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i110 = MaterialTheme.$stable;
                modifier5 = modifier4;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1729paddingqDBjuR0$default2, icon, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme2.getColorScheme(composerStartRestartGroup, i110).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i13 >> 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, label, materialTheme2.getTypography(composerStartRestartGroup, i110).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, (i13 >> 6) & 112, 57);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(792366100);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewScreenKt.StatusActionInMoreMenu$lambda$2(modifier3, z13, icon, label, onClick, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusActionInMoreMenu$lambda$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusActionInMoreMenu$lambda$2(Modifier modifier, boolean z10, Object obj, String str, lb.a aVar, int i10, int i11, Composer composer, int i12) {
        StatusActionInMoreMenu(modifier, z10, obj, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:106:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:110:0x034d  */
    /* JADX WARN: Code duplicated, block: B:115:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:120:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:123:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:125:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:128:0x0410  */
    /* JADX WARN: Code duplicated, block: B:130:0x0421  */
    /* JADX WARN: Code duplicated, block: B:133:0x0433  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x012e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0170  */
    /* JADX WARN: Code duplicated, block: B:73:0x017c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0180  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:84:0x0209  */
    /* JADX WARN: Code duplicated, block: B:89:0x0242  */
    /* JADX WARN: Code duplicated, block: B:92:0x026a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0275  */
    /* JADX WARN: Code duplicated, block: B:96:0x0284  */
    /* JADX WARN: Code duplicated, block: B:99:0x0299  */
    /* JADX WARN: Type inference failed for: r9v4, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, java.lang.String, kotlin.jvm.internal.p] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPreviewScreen(final NavHostController navHostController, final String params, StatusPreviewViewModel statusPreviewViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final StatusPreviewViewModel statusPreviewViewModel2;
        int i13;
        Object objRememberedValue;
        Composer.Companion companion;
        final StatusPreviewParams statusPreviewParams;
        Object objRememberedValue2;
        final Context context;
        Object objRememberedValue3;
        final MutableState mutableState;
        lb.a constructor;
        ab.i iVar;
        te.h otherStatus;
        final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems;
        boolean zChangedInstance;
        Object objRememberedValue4;
        boolean zChangedInstance2;
        Object objRememberedValue5;
        ?? r10;
        Object objRememberedValue6;
        int i14;
        Object objRememberedValue7;
        Object objRememberedValue8;
        lb.a constructor2;
        boolean zChangedInstance3;
        Object objRememberedValue9;
        boolean zChangedInstance4;
        Object objRememberedValue10;
        Object objRememberedValue11;
        Object objRememberedValue12;
        int i15;
        StatusPreviewViewModel statusPreviewViewModel3 = statusPreviewViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(params, "params");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1468039967);
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
                i15 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(statusPreviewViewModel3) : composerStartRestartGroup.changedInstance(statusPreviewViewModel3)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
            }
            i12 |= i15;
        }
        int i16 = i12;
        if (composerStartRestartGroup.shouldExecute((i16 & 147) != 146, i16 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i16 &= -897;
                    statusPreviewViewModel3 = (StatusPreviewViewModel) ViewModelKt.viewModel(z0.b(StatusPreviewViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                    i13 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1468039967, i16, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen (StatusPreviewScreen.kt:93)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = (StatusPreviewParams) statusPreviewViewModel3.getGson().j(params, StatusPreviewParams.class);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                statusPreviewParams = (StatusPreviewParams) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final pe.m0 m0Var = (pe.m0) objRememberedValue2;
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(companion2), 0.0f, i13, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                constructor = companion4.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (statusPreviewParams.getFromOwner()) {
                    composerStartRestartGroup.startReplaceGroup(-865660479);
                    otherStatus = statusPreviewViewModel3.getOwnerStatus();
                    iVar = null;
                } else {
                    iVar = null;
                    composerStartRestartGroup.startReplaceGroup(-865658751);
                    otherStatus = statusPreviewViewModel3.getOtherStatus();
                }
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(otherStatus, iVar, composerStartRestartGroup, 0, i13);
                composerStartRestartGroup.endReplaceGroup();
                final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(statusPreviewParams.getStartPoint(), 0, composerStartRestartGroup, 0, 2);
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion2, 0.0f, i13, iVar), Dp.m8823constructorimpl(20), 0.0f, 2, iVar);
                PaddingValues paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
                zChangedInstance = composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$0$0(lazyPagingItemsCollectAsLazyPagingItems, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                LazyDslKt.LazyColumn(modifierM1727paddingVpY3zN4$default, lazyListStateRememberLazyListState, paddingValuesM1718PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue4, composerStartRestartGroup, 390, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                int startPoint = statusPreviewParams.getStartPoint();
                zChangedInstance2 = composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(lazyPagingItemsCollectAsLazyPagingItems.getItemCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                r10 = iVar;
                final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(startPoint, 0.0f, (lb.a) objRememberedValue5, composerStartRestartGroup, 0, 2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    i14 = 2;
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, r10, 2, r10);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    i14 = 2;
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r10, i14, r10);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue7;
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ActionIndicatorData(0, r10, i14, r10), r10, i14, r10);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue8;
                Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, r10), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
                constructor2 = companion4.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                StatusPreviewViewModel statusPreviewViewModel4 = statusPreviewViewModel3;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
                composerStartRestartGroup.endNode();
                statusPreviewViewModel2 = statusPreviewViewModel4;
                PagerKt.m1963VerticalPager8jOkeI(pagerStateRememberPagerState, SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), null, null, lazyPagingItemsCollectAsLazyPagingItems.getItemCount() <= 6 ? lazyPagingItemsCollectAsLazyPagingItems.getItemCount() / 3 : 3, 0.0f, null, null, StatusPreviewScreen$lambda$4$3(mutableState2), true, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(351922134, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.i
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12(lazyPagingItemsCollectAsLazyPagingItems, pagerStateRememberPagerState, statusPreviewViewModel2, m0Var, lazyListStateRememberLazyListState, navHostController, statusPreviewParams, mutableState4, mutableState, mutableState3, softwareKeyboardController, mutableState2, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 24576, 15596);
                composerStartRestartGroup = composerStartRestartGroup;
                ua.k0 k0Var = ua.k0.f43947a;
                zChangedInstance3 = composerStartRestartGroup.changedInstance(context);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue9 == companion.getEmpty()) {
                    objRememberedValue9 = new StatusPreviewScreenKt$StatusPreviewScreen$1$4$1(context, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
                zChangedInstance4 = composerStartRestartGroup.changedInstance(context);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || objRememberedValue10 == companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$14$0(context, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue10, composerStartRestartGroup, 6);
                if (StatusPreviewScreen$lambda$2(mutableState)) {
                    composerStartRestartGroup.startReplaceGroup(-1048428933);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-865108497);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.k
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$15$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    lb.a aVar = (lb.a) objRememberedValue11;
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.l
                            @Override // lb.a
                            public final Object invoke() {
                                return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$16$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    VolumeButtonsHandler(aVar, (lb.a) objRememberedValue12, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i16 &= -897;
                }
            }
            i13 = 1;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1468039967, i16, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen (StatusPreviewScreen.kt:93)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = (StatusPreviewParams) statusPreviewViewModel3.getGson().j(params, StatusPreviewParams.class);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            statusPreviewParams = (StatusPreviewParams) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final pe.m0 m0Var2 = (pe.m0) objRememberedValue2;
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState = (MutableState) objRememberedValue3;
            Modifier.Companion companion5 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(companion5), 0.0f, i13, null);
            Alignment.Companion companion6 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getCenter(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            constructor = companion7.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (statusPreviewParams.getFromOwner()) {
                composerStartRestartGroup.startReplaceGroup(-865660479);
                otherStatus = statusPreviewViewModel3.getOwnerStatus();
                iVar = null;
            } else {
                iVar = null;
                composerStartRestartGroup.startReplaceGroup(-865658751);
                otherStatus = statusPreviewViewModel3.getOtherStatus();
            }
            lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(otherStatus, iVar, composerStartRestartGroup, 0, i13);
            composerStartRestartGroup.endReplaceGroup();
            final LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(statusPreviewParams.getStartPoint(), 0, composerStartRestartGroup, 0, 2);
            Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion5, 0.0f, i13, iVar), Dp.m8823constructorimpl(20), 0.0f, 2, iVar);
            PaddingValues paddingValuesM1718PaddingValues0680j_5 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(5));
            zChangedInstance = composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$0$0(lazyPagingItemsCollectAsLazyPagingItems, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$0$0(lazyPagingItemsCollectAsLazyPagingItems, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            LazyDslKt.LazyColumn(modifierM1727paddingVpY3zN4$default2, lazyListStateRememberLazyListState2, paddingValuesM1718PaddingValues0680j_5, false, null, null, null, false, null, (Function1) objRememberedValue4, composerStartRestartGroup, 390, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            int startPoint2 = statusPreviewParams.getStartPoint();
            zChangedInstance2 = composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(lazyPagingItemsCollectAsLazyPagingItems.getItemCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h
                    @Override // lb.a
                    public final Object invoke() {
                        return Integer.valueOf(lazyPagingItemsCollectAsLazyPagingItems.getItemCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            r10 = iVar;
            final PagerState pagerStateRememberPagerState2 = PagerStateKt.rememberPagerState(startPoint2, 0.0f, (lb.a) objRememberedValue5, composerStartRestartGroup, 0, 2);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                i14 = 2;
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, r10, 2, r10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                i14 = 2;
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue6;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r10, i14, r10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue7;
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ActionIndicatorData(0, r10, i14, r10), r10, i14, r10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue8;
            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion5, 0.0f, 1, r10), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getCenter(), false);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default2);
            constructor2 = companion7.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
            StatusPreviewViewModel statusPreviewViewModel5 = statusPreviewViewModel3;
            Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(null, 0.0f, 0.0f, 0L, composerStartRestartGroup, 0, 15);
            composerStartRestartGroup.endNode();
            statusPreviewViewModel2 = statusPreviewViewModel5;
            PagerKt.m1963VerticalPager8jOkeI(pagerStateRememberPagerState2, SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null), null, null, lazyPagingItemsCollectAsLazyPagingItems.getItemCount() <= 6 ? lazyPagingItemsCollectAsLazyPagingItems.getItemCount() / 3 : 3, 0.0f, null, null, StatusPreviewScreen$lambda$4$3(mutableState5), true, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(351922134, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.i
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12(lazyPagingItemsCollectAsLazyPagingItems, pagerStateRememberPagerState2, statusPreviewViewModel2, m0Var2, lazyListStateRememberLazyListState2, navHostController, statusPreviewParams, mutableState7, mutableState, mutableState6, softwareKeyboardController2, mutableState5, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 24576, 15596);
            composerStartRestartGroup = composerStartRestartGroup;
            ua.k0 k0Var2 = ua.k0.f43947a;
            zChangedInstance3 = composerStartRestartGroup.changedInstance(context);
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue9 = new StatusPreviewScreenKt$StatusPreviewScreen$1$4$1(context, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new StatusPreviewScreenKt$StatusPreviewScreen$1$4$1(context, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue9, composerStartRestartGroup, 6);
            zChangedInstance4 = composerStartRestartGroup.changedInstance(context);
            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$14$0(context, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$14$0(context, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue10, composerStartRestartGroup, 6);
            if (StatusPreviewScreen$lambda$2(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-865108497);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue11 == companion.getEmpty()) {
                    objRememberedValue11 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.k
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$15$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                lb.a aVar2 = (lb.a) objRememberedValue11;
                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue12 == companion.getEmpty()) {
                    objRememberedValue12 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.l
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$16$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                VolumeButtonsHandler(aVar2, (lb.a) objRememberedValue12, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1048428933);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            statusPreviewViewModel2 = statusPreviewViewModel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$5(navHostController, params, statusPreviewViewModel2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean StatusPreviewScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StatusPreviewScreen$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$0$0(LazyPagingItems lazyPagingItems, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$0$0$0((StatusWithPartnersOrRooms) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$0$0$1((StatusWithPartnersOrRooms) obj);
            }
        }), ComposableSingletons$StatusPreviewScreenKt.INSTANCE.getLambda$1043551877$app_productionPFast());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StatusPreviewScreen$lambda$4$0$0$0(StatusWithPartnersOrRooms s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        return s10.getStatus().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StatusPreviewScreen$lambda$4$0$0$1(StatusWithPartnersOrRooms i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:76:0x040c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0428  */
    /* JADX WARN: Code duplicated, block: B:86:0x0445  */
    /* JADX WARN: Code duplicated, block: B:89:0x0464  */
    /* JADX WARN: Code duplicated, block: B:95:0x04ad  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusPreviewScreen$lambda$4$12(LazyPagingItems lazyPagingItems, final PagerState pagerState, final StatusPreviewViewModel statusPreviewViewModel, final pe.m0 m0Var, LazyListState lazyListState, final NavHostController navHostController, final StatusPreviewParams statusPreviewParams, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final SoftwareKeyboardController softwareKeyboardController, MutableState mutableState4, PagerScope VerticalPager, final int i10, Composer composer, int i11) {
        final PagerState pagerState2;
        int i12;
        Composer composer2;
        ModalBottomSheetState modalBottomSheetState;
        ModalBottomSheetState modalBottomSheetState2;
        boolean z10;
        final StatusWithPartnersOrRooms statusWithPartnersOrRooms;
        State state;
        MutableState mutableState5;
        StatusPreviewViewModel statusPreviewViewModel2;
        final NavHostController navHostController2;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        kotlin.jvm.internal.y.i(VerticalPager, "$this$VerticalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(351922134, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen.<anonymous>.<anonymous> (StatusPreviewScreen.kt:169)");
        }
        StatusWithPartnersOrRooms statusWithPartnersOrRooms2 = (StatusWithPartnersOrRooms) lazyPagingItems.get(i10);
        Object objRememberedValue5 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue5);
        }
        final MutableState mutableState6 = (MutableState) objRememberedValue5;
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
        final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue, null, null, true, composer, 3078, 6);
        Object objRememberedValue6 = composer.rememberedValue();
        if (objRememberedValue6 == companion.getEmpty()) {
            objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue6);
        }
        MutableState mutableState7 = (MutableState) objRememberedValue6;
        final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState2 = ModalBottomSheetKt.rememberModalBottomSheetState(modalBottomSheetValue, null, null, true, composer, 3078, 6);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion4.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        int i13 = 48;
        if (statusWithPartnersOrRooms2 != null) {
            composer.startReplaceGroup(-948803538);
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(statusPreviewViewModel.getViewCount(statusWithPartnersOrRooms2.getStatus().getId()), 0, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$1$0(pagerState, i10));
                    }
                });
                composer.updateRememberedValue(objRememberedValue7);
            }
            State state2 = (State) objRememberedValue7;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(statusPreviewViewModel.checkActualReaction(statusWithPartnersOrRooms2.getStatus().getId()), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            Integer numValueOf = Integer.valueOf(pagerState.getCurrentPage());
            Boolean boolValueOf = Boolean.valueOf(pagerState.isScrollInProgress());
            boolean zChanged = ((((i11 & 112) ^ 48) > 32 && composer.changed(i10)) || (i11 & 48) == 32) | composer.changed(pagerState) | composer.changed(statusWithPartnersOrRooms2) | composer.changedInstance(statusPreviewViewModel) | composer.changedInstance(m0Var) | composer.changed(lazyListState) | composer.changedInstance(lazyPagingItems);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged || objRememberedValue8 == companion.getEmpty()) {
                StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1 statusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1 = new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1(pagerState, statusWithPartnersOrRooms2, statusPreviewViewModel, m0Var, lazyPagingItems, state2, lazyListState, i10, mutableState7, mutableState, null);
                statusWithPartnersOrRooms = statusWithPartnersOrRooms2;
                state = state2;
                mutableState5 = mutableState7;
                composer.updateRememberedValue(statusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1);
                objRememberedValue8 = statusPreviewScreenKt$StatusPreviewScreen$1$3$1$1$1;
            } else {
                statusWithPartnersOrRooms = statusWithPartnersOrRooms2;
                mutableState5 = mutableState7;
                state = state2;
            }
            EffectsKt.LaunchedEffect(numValueOf, boolValueOf, (Function2) objRememberedValue8, composer, 0);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null);
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$5$0(statusPreviewParams);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            lb.a aVar = (lb.a) objRememberedValue9;
            boolean zChanged2 = composer.changed(statusWithPartnersOrRooms);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$6$0(statusWithPartnersOrRooms, mutableState6);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            Modifier modifierM1250combinedClickablehoGz1lA$default = ClickableKt.m1250combinedClickablehoGz1lA$default(modifierM1205backgroundbw27NRU$default, false, null, null, null, null, aVar, false, null, (lb.a) objRememberedValue10, 223, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1250combinedClickablehoGz1lA$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            final StatusWithPartnersOrRooms statusWithPartnersOrRooms3 = statusWithPartnersOrRooms;
            StatusItemKt.StatusItem(null, statusWithPartnersOrRooms.getStatus().getContent(), false, StatusPreviewScreen$lambda$4$12$1(mutableState6) && StatusPreviewScreen$lambda$4$12$6$2(state), StatusPreviewScreen$lambda$2(mutableState2), false, 0, kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getStatus().getCreatorId(), statusWithPartnersOrRooms.getStatus().getRepliedId()) && kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getStatus().getCreatorId(), statusPreviewViewModel.owner().getNameWithDomain()), statusWithPartnersOrRooms.getStatus().getId(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 97);
            AnimatedVisibilityKt.AnimatedVisibility(StatusPreviewScreen$lambda$4$12$6$2(state), boxScopeInstance.align(companion2, companion3.getTopCenter()), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(105205973, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$0(statusWithPartnersOrRooms3, statusPreviewViewModel, statusPreviewParams, navHostController, mutableState2, mutableState3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 16);
            Modifier modifierAlign = boxScopeInstance.align(companion2, companion3.getBottomCenter());
            final MutableState mutableState8 = mutableState5;
            z10 = true;
            composer2 = composer;
            modalBottomSheetState = modalBottomSheetStateRememberModalBottomSheetState;
            AnimatedVisibilityKt.AnimatedVisibility(StatusPreviewScreen$lambda$4$12$6$2(state), modifierAlign, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1052222668, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1(statusWithPartnersOrRooms3, statusPreviewParams, statusPreviewViewModel, softwareKeyboardController, m0Var, modalBottomSheetStateRememberModalBottomSheetState, navHostController, modalBottomSheetStateRememberModalBottomSheetState2, mutableState8, stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle2, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 200064, 16);
            composer2.endNode();
            if (StatusPreviewScreen$lambda$4$3(mutableState4)) {
                i12 = i10;
            } else {
                i12 = i10;
                if (pagerState.getCurrentPage() == i12) {
                    composer2.startReplaceGroup(1909386775);
                    pagerState2 = pagerState;
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState2;
                    navHostController2 = navHostController;
                    statusPreviewViewModel2 = statusPreviewViewModel;
                    i13 = 48;
                    ModalKt.Modal(modalBottomSheetState2, ComposableLambdaKt.rememberComposableLambda(-758533069, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.f0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$8(statusPreviewParams, statusPreviewViewModel, statusWithPartnersOrRooms3, m0Var, modalBottomSheetStateRememberModalBottomSheetState2, pagerState2, navHostController, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, ModalBottomSheetState.$stable | 48);
                    composer2.endReplaceGroup();
                }
                AuthorsDetailData authorsDetailDataStatusPreviewScreen$lambda$4$6 = StatusPreviewScreen$lambda$4$6(mutableState3);
                objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.g0
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$9$0(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                lb.a aVar2 = (lb.a) objRememberedValue;
                zChangedInstance = composer2.changedInstance(statusPreviewViewModel2);
                objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$7$1(statusPreviewViewModel2);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function2 function2 = (Function2) ((sb.h) objRememberedValue2);
                zChangedInstance2 = composer2.changedInstance(navHostController2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$11$0(navHostController2, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                AuthorsDetailDialogKt.AuthorsDetailDialog(authorsDetailDataStatusPreviewScreen$lambda$4$6, aVar2, function2, (Function1) objRememberedValue3, composer2, 48);
                ActionIndicatorData actionIndicatorDataStatusPreviewScreen$lambda$4$9 = StatusPreviewScreen$lambda$4$9(mutableState);
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.x
                        @Override // lb.a
                        public final Object invoke() {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$12$0(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ActionIndicatorKt.ActionIndicator(actionIndicatorDataStatusPreviewScreen$lambda$4$9, (lb.a) objRememberedValue4, composer2, i13);
                if (statusPreviewParams.getFromOwner() || StatusPreviewScreen$lambda$4$3(mutableState4)) {
                    composer2.startReplaceGroup(-935298202);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-935595151);
                    final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(statusPreviewViewModel2.reactionsFromStatus(statusWithPartnersOrRooms3.getStatus().getId()), null, composer2, 0, 1);
                    ModalKt.Modal(modalBottomSheetState, ComposableLambdaKt.rememberComposableLambda(-201652374, true, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$13(lazyPagingItemsCollectAsLazyPagingItems, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, ModalBottomSheetState.$stable | i13);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            }
            pagerState2 = pagerState;
            statusPreviewViewModel2 = statusPreviewViewModel;
            navHostController2 = navHostController;
            modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState2;
            i13 = 48;
            composer2.startReplaceGroup(-936435034);
            composer2.endReplaceGroup();
            AuthorsDetailData authorsDetailDataStatusPreviewScreen$lambda$4$7 = StatusPreviewScreen$lambda$4$6(mutableState3);
            objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.g0
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$9$0(mutableState3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            lb.a aVar3 = (lb.a) objRememberedValue;
            zChangedInstance = composer2.changedInstance(statusPreviewViewModel2);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue2 = new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$7$1(statusPreviewViewModel2);
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$7$1(statusPreviewViewModel2);
                composer2.updateRememberedValue(objRememberedValue2);
            }
            Function2 function3 = (Function2) ((sb.h) objRememberedValue2);
            zChangedInstance2 = composer2.changedInstance(navHostController2);
            objRememberedValue3 = composer2.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$11$0(navHostController2, (String) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$11$0(navHostController2, (String) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            AuthorsDetailDialogKt.AuthorsDetailDialog(authorsDetailDataStatusPreviewScreen$lambda$4$7, aVar3, function3, (Function1) objRememberedValue3, composer2, 48);
            ActionIndicatorData actionIndicatorDataStatusPreviewScreen$lambda$4$10 = StatusPreviewScreen$lambda$4$9(mutableState);
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.x
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$12$0(mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ActionIndicatorKt.ActionIndicator(actionIndicatorDataStatusPreviewScreen$lambda$4$10, (lb.a) objRememberedValue4, composer2, i13);
            if (statusPreviewParams.getFromOwner()) {
                composer2.startReplaceGroup(-935298202);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-935298202);
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
        } else {
            pagerState2 = pagerState;
            i12 = i10;
            composer2 = composer;
            modalBottomSheetState = modalBottomSheetStateRememberModalBottomSheetState;
            modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState2;
            z10 = true;
            composer2.startReplaceGroup(-935280346);
            composer2.endReplaceGroup();
        }
        composer2.endNode();
        ModalBottomSheetValue currentValue = modalBottomSheetState.getCurrentValue();
        ModalBottomSheetValue currentValue2 = modalBottomSheetState2.getCurrentValue();
        boolean zChanged3 = composer2.changed(pagerState2) | (((((i11 & 112) ^ i13) <= 32 || !composer2.changed(i12)) && (i11 & 48) != 32) ? false : z10) | composer2.changedInstance(modalBottomSheetState) | composer2.changedInstance(modalBottomSheetState2);
        Object objRememberedValue11 = composer2.rememberedValue();
        if (zChanged3 || objRememberedValue11 == companion.getEmpty()) {
            objRememberedValue11 = new StatusPreviewScreenKt$StatusPreviewScreen$1$3$2$1(pagerState2, i12, modalBottomSheetState, modalBottomSheetState2, mutableState4, null);
            composer2.updateRememberedValue(objRememberedValue11);
        }
        EffectsKt.LaunchedEffect(currentValue, currentValue2, (Function2) objRememberedValue11, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    private static final boolean StatusPreviewScreen$lambda$4$12$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StatusPreviewScreen$lambda$4$12$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final boolean StatusPreviewScreen$lambda$4$12$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusPreviewScreen$lambda$4$12$5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final Integer StatusPreviewScreen$lambda$4$12$6$0(State<Integer> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StatusPreviewScreen$lambda$4$12$6$1$0(PagerState pagerState, int i10) {
        return pagerState.getCurrentPage() == i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$11$0(NavHostController navHostController, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(it), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$12$0(MutableState mutableState) {
        mutableState.setValue(new ActionIndicatorData(0, null, 2, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$13(LazyPagingItems lazyPagingItems, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-201652374, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusPreviewScreen.kt:467)");
            }
            ViewsList(lazyPagingItems, composer, LazyPagingItems.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StatusPreviewScreen$lambda$4$12$6$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final Reaction StatusPreviewScreen$lambda$4$12$6$3(State<Reaction> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$5$0(StatusPreviewParams statusPreviewParams) {
        statusPreviewParams.getFromOwner();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$6$0(StatusWithPartnersOrRooms statusWithPartnersOrRooms, MutableState mutableState) {
        if (kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getStatus().getType(), Status.VIDEO_TYPE)) {
            StatusPreviewScreen$lambda$4$12$2(mutableState, !StatusPreviewScreen$lambda$4$12$1(mutableState));
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$0(final StatusWithPartnersOrRooms statusWithPartnersOrRooms, StatusPreviewViewModel statusPreviewViewModel, StatusPreviewParams statusPreviewParams, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(105205973, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusPreviewScreen.kt:267)");
        }
        String creatorId = statusWithPartnersOrRooms.getCreatorId();
        String photoUrl = kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getCreatorId(), statusPreviewViewModel.owner().getNameWithDomain()) ? statusPreviewViewModel.owner().getPhotoUrl() : statusWithPartnersOrRooms.getCreatorThumbnail();
        String alias = kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getCreatorId(), statusPreviewViewModel.owner().getNameWithDomain()) ? statusPreviewViewModel.owner().getAlias() : statusWithPartnersOrRooms.getCreatorName();
        String str = photoUrl;
        String repliedId = statusWithPartnersOrRooms.getRepliedId();
        String photoUrl2 = kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getRepliedId(), statusPreviewViewModel.owner().getNameWithDomain()) ? statusPreviewViewModel.owner().getPhotoUrl() : statusWithPartnersOrRooms.getRepliedThumbnail();
        String alias2 = kotlin.jvm.internal.y.d(statusWithPartnersOrRooms.getRepliedId(), statusPreviewViewModel.owner().getNameWithDomain()) ? statusPreviewViewModel.owner().getAlias() : statusWithPartnersOrRooms.getRepliedName();
        long createdAt = statusWithPartnersOrRooms.getStatus().getCreatedAt();
        boolean fromOwner = statusPreviewParams.getFromOwner();
        boolean zStatusPreviewScreen$lambda$2 = StatusPreviewScreen$lambda$2(mutableState);
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.s0
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$0$0$0(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        lb.a aVar = (lb.a) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.d
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$0$1$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        lb.a aVar2 = (lb.a) objRememberedValue2;
        boolean zChanged = composer.changed(statusWithPartnersOrRooms);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.e
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$0$2$0(statusWithPartnersOrRooms, mutableState2);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        StatusPreviewTopBarKt.StatusPreviewTopBar(creatorId, alias, str, repliedId, alias2, photoUrl2, createdAt, 0, 0, fromOwner, aVar, zStatusPreviewScreen$lambda$2, aVar2, (lb.a) objRememberedValue3, composer, 113246208, RendererCapabilities.DECODER_SUPPORT_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$0$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$0$1$0(MutableState mutableState) {
        StatusPreviewScreen$lambda$3(mutableState, !StatusPreviewScreen$lambda$2(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$0$2$0(StatusWithPartnersOrRooms statusWithPartnersOrRooms, MutableState mutableState) {
        mutableState.setValue(AuthorsDetailData.INSTANCE.convert(statusWithPartnersOrRooms));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1(final StatusWithPartnersOrRooms statusWithPartnersOrRooms, StatusPreviewParams statusPreviewParams, final StatusPreviewViewModel statusPreviewViewModel, final SoftwareKeyboardController softwareKeyboardController, final pe.m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final NavHostController navHostController, final ModalBottomSheetState modalBottomSheetState2, MutableState mutableState, State state, State state2, final MutableState mutableState2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        final MutableState mutableState3;
        Modifier modifierBackground$default;
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052222668, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusPreviewScreen.kt:314)");
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
        Modifier.Companion companion3 = companion;
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        String textContent = statusWithPartnersOrRooms.getStatus().getTextContent();
        if (textContent == null) {
            composer.startReplaceGroup(1263280951);
            composer.endReplaceGroup();
            companion3 = companion3;
        } else {
            composer.startReplaceGroup(1263280952);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState;
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.r
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$0$0$0(mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState3 = mutableState;
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            if (StatusPreviewScreen$lambda$4$12$4(mutableState3)) {
                composer.startReplaceGroup(-611955101);
                modifierBackground$default = BackgroundKt.m1205backgroundbw27NRU$default(companion3, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-611943546);
                modifierBackground$default = BackgroundKt.background$default(companion3, Brush.Companion.m5827verticalGradient8A3gB4$default(Brush.INSTANCE, va.w.q(Color.m5856boximpl(Color.INSTANCE.m5901getTransparent0d7_KjU()), Color.m5856boximpl(Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null))), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                composer.endReplaceGroup();
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(PaddingKt.m1726paddingVpY3zN4(modifierM1240clickableoSLSa3U$default.then(modifierBackground$default), Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(5)), 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), textContent, null, 0L, StatusPreviewScreen$lambda$4$12$4(mutableState3) ? Integer.MAX_VALUE : 3, 0, composer, 0, 44);
            composer.endReplaceGroup();
        }
        boolean fromOwner = statusPreviewParams.getFromOwner();
        boolean canRespond = statusWithPartnersOrRooms.getStatus().getCanRespond();
        Integer numStatusPreviewScreen$lambda$4$12$6$0 = StatusPreviewScreen$lambda$4$12$6$0(state);
        int iIntValue = numStatusPreviewScreen$lambda$4$12$6$0 != null ? numStatusPreviewScreen$lambda$4$12$6$0.intValue() : statusWithPartnersOrRooms.getStatus().getViewCount();
        Reaction reactionStatusPreviewScreen$lambda$4$12$6$3 = StatusPreviewScreen$lambda$4$12$6$3(state2);
        boolean zChangedInstance = composer.changedInstance(statusPreviewViewModel) | composer.changed(statusWithPartnersOrRooms);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$1$0(statusPreviewViewModel, statusWithPartnersOrRooms, mutableState2, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        boolean zChanged = composer.changed(softwareKeyboardController) | composer.changedInstance(statusPreviewViewModel) | composer.changed(statusWithPartnersOrRooms);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$2$0(softwareKeyboardController, statusPreviewViewModel, statusWithPartnersOrRooms, mutableState2, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1 function2 = (Function1) objRememberedValue3;
        boolean zChangedInstance2 = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.u
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$3$0(m0Var, modalBottomSheetState);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        lb.a aVar = (lb.a) objRememberedValue4;
        boolean zChangedInstance3 = composer.changedInstance(navHostController);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.v
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$4$0(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        lb.a aVar2 = (lb.a) objRememberedValue5;
        boolean zChangedInstance4 = composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState2);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.w
                @Override // lb.a
                public final Object invoke() {
                    return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$7$1$0$5$0(m0Var, modalBottomSheetState2);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        StatusActionsBarKt.StatusActionsBar(companion3, fromOwner, canRespond, iIntValue, reactionStatusPreviewScreen$lambda$4$12$6$3, function1, function2, aVar, aVar2, (lb.a) objRememberedValue6, composer, 6);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$0$0$0(MutableState mutableState) {
        StatusPreviewScreen$lambda$4$12$5(mutableState, !StatusPreviewScreen$lambda$4$12$4(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$1$0(StatusPreviewViewModel statusPreviewViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(StatusPreviewScreen$lambda$4$9(mutableState).copy(2, it));
        statusPreviewViewModel.sendReaction(statusWithPartnersOrRooms.getStatus().getId(), it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$2$0(SoftwareKeyboardController softwareKeyboardController, StatusPreviewViewModel statusPreviewViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms, MutableState mutableState, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        statusPreviewViewModel.respondToReplied(statusWithPartnersOrRooms.getStatus().getRepliedId(), statusWithPartnersOrRooms.getStatus().getId(), it, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.q
            @Override // lb.a
            public final Object invoke() {
                return ua.k0.f43947a;
            }
        });
        mutableState.setValue(ActionIndicatorData.copy$default(StatusPreviewScreen$lambda$4$9(mutableState), 1, null, 2, null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$3$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$4$2$1$4$1$1(modalBottomSheetState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$4$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, NavLinks.REACT_SELECTION, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$7$1$0$5$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState) {
        pe.k.d(m0Var, null, null, new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$4$2$1$6$1$1(modalBottomSheetState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$8(StatusPreviewParams statusPreviewParams, final StatusPreviewViewModel statusPreviewViewModel, final StatusWithPartnersOrRooms statusWithPartnersOrRooms, final pe.m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final PagerState pagerState, final NavHostController navHostController, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-758533069, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StatusPreviewScreen.kt:397)");
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(20));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ModalKt.ModalIndicator(composer, 0);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            boolean z10 = !statusPreviewParams.getFromOwner();
            Integer numValueOf = Integer.valueOf(R.drawable.reply_status);
            String strStringResource = StringResources_androidKt.stringResource(R.string.share, composer, 0);
            boolean zChangedInstance = composer.changedInstance(statusPreviewViewModel) | composer.changed(statusWithPartnersOrRooms) | composer.changedInstance(m0Var) | composer.changedInstance(modalBottomSheetState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.o
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$8$0$0$0(statusPreviewViewModel, statusWithPartnersOrRooms, m0Var, modalBottomSheetState, mutableState);
                    }
                };
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            StatusActionInMoreMenu(null, z10, numValueOf, strStringResource, (lb.a) objRememberedValue, composer, 0, 1);
            DividerKt.m3177HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            boolean z11 = !statusPreviewParams.getFromOwner();
            Integer numValueOf2 = Integer.valueOf(R.drawable.unwanted);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.dont_want_to_see_this, composer, 0);
            boolean zChangedInstance2 = composer.changedInstance(r3) | composer.changed(pagerState) | composer.changedInstance(navHostController) | composer.changedInstance(r1) | composer.changed(r2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.p
                    @Override // lb.a
                    public final Object invoke() {
                        return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$8$0$1$0(m0Var, pagerState, navHostController, statusPreviewViewModel, statusWithPartnersOrRooms);
                    }
                };
                composer.updateRememberedValue(aVar2);
                objRememberedValue2 = aVar2;
            }
            StatusActionInMoreMenu(null, z11, numValueOf2, strStringResource2, (lb.a) objRememberedValue2, composer, 0, 1);
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
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$8$0$0$0(StatusPreviewViewModel statusPreviewViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms, final pe.m0 m0Var, final ModalBottomSheetState modalBottomSheetState, final MutableState mutableState) {
        statusPreviewViewModel.replyStatus(statusWithPartnersOrRooms.getStatus().getId(), new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.f
            @Override // lb.a
            public final Object invoke() {
                return StatusPreviewScreenKt.StatusPreviewScreen$lambda$4$12$6$8$0$0$0$0(m0Var, modalBottomSheetState, mutableState);
            }
        });
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$8$0$0$0$0(pe.m0 m0Var, ModalBottomSheetState modalBottomSheetState, MutableState mutableState) {
        pe.k.d(m0Var, null, null, new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$5$1$1$1$1$1(modalBottomSheetState, mutableState, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$8$0$1$0(pe.m0 m0Var, PagerState pagerState, NavHostController navHostController, StatusPreviewViewModel statusPreviewViewModel, StatusWithPartnersOrRooms statusWithPartnersOrRooms) {
        pe.k.d(m0Var, null, null, new StatusPreviewScreenKt$StatusPreviewScreen$1$3$1$5$1$2$1$1(pagerState, navHostController, statusPreviewViewModel, statusWithPartnersOrRooms, null), 3, null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$12$6$9$0(MutableState mutableState) {
        mutableState.setValue(null);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult StatusPreviewScreen$lambda$4$14$0(final Context context, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$StatusPreviewScreen$lambda$4$14$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Z17InlineUtilsKt.findActivity(context).getWindow().clearFlags(128);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$15$0(MutableState mutableState) {
        StatusPreviewScreen$lambda$3(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$4$16$0(MutableState mutableState) {
        StatusPreviewScreen$lambda$3(mutableState, true);
        return ua.k0.f43947a;
    }

    private static final boolean StatusPreviewScreen$lambda$4$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusPreviewScreen$lambda$4$4(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final AuthorsDetailData StatusPreviewScreen$lambda$4$6(MutableState<AuthorsDetailData> mutableState) {
        return mutableState.getValue();
    }

    private static final ActionIndicatorData StatusPreviewScreen$lambda$4$9(MutableState<ActionIndicatorData> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 StatusPreviewScreen$lambda$5(NavHostController navHostController, String str, StatusPreviewViewModel statusPreviewViewModel, int i10, int i11, Composer composer, int i12) {
        StatusPreviewScreen(navHostController, str, statusPreviewViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ViewsList(final LazyPagingItems<ReactionWithPartner> reactions, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(reactions, "reactions");
        Composer composerStartRestartGroup = composer.startRestartGroup(2098192103);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(reactions) : composerStartRestartGroup.changedInstance(reactions) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        boolean z10 = true;
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2098192103, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.ViewsList (StatusPreviewScreen.kt:505)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            if ((i11 & 14) != 4 && ((i11 & 8) == 0 || !composerStartRestartGroup.changedInstance(reactions))) {
                z10 = false;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.ViewsList$lambda$0$0(reactions, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierM1205backgroundbw27NRU$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewScreenKt.ViewsList$lambda$1(reactions, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ViewsList$lambda$0$0(final LazyPagingItems lazyPagingItems, LazyListScope LazyColumn) {
        kotlin.jvm.internal.y.i(LazyColumn, "$this$LazyColumn");
        LazyListScope.CC.m(LazyColumn, null, null, ComposableSingletons$StatusPreviewScreenKt.INSTANCE.m9991getLambda$1774548100$app_productionPFast(), 3, null);
        LazyColumn.items(lazyPagingItems.getItemCount(), LazyFoundationExtensionsKt.itemKey(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusPreviewScreenKt.ViewsList$lambda$0$0$0((ReactionWithPartner) obj);
            }
        }), LazyFoundationExtensionsKt.itemContentType(lazyPagingItems, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusPreviewScreenKt.ViewsList$lambda$0$0$1((ReactionWithPartner) obj);
            }
        }), ComposableLambdaKt.composableLambdaInstance(-1078248571, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.p0
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StatusPreviewScreenKt.ViewsList$lambda$0$0$2(lazyPagingItems, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ViewsList$lambda$0$0$0(ReactionWithPartner r10) {
        kotlin.jvm.internal.y.i(r10, "r");
        return r10.getReaction().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ViewsList$lambda$0$0$1(ReactionWithPartner i10) {
        kotlin.jvm.internal.y.i(i10, "i");
        return "item";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 ViewsList$lambda$0$0$2(LazyPagingItems lazyPagingItems, LazyItemScope items, int i10, Composer composer, int i11) {
        int i12;
        kotlin.jvm.internal.y.i(items, "$this$items");
        if ((i11 & 6) == 0) {
            i12 = (composer.changed(items) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1078248571, i12, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.ViewsList.<anonymous>.<anonymous>.<anonymous> (StatusPreviewScreen.kt:535)");
            }
            ReactionWithPartner reactionWithPartner = (ReactionWithPartner) lazyPagingItems.get(i10);
            if (reactionWithPartner != null) {
                composer.startReplaceGroup(-42657733);
                Modifier modifierC = androidx.compose.foundation.lazy.g.c(items, PaddingKt.m1726paddingVpY3zN4(Modifier.INSTANCE, Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(2)), null, null, null, 2, null);
                String picture = reactionWithPartner.getPicture();
                String name = reactionWithPartner.getName();
                long createdAt = reactionWithPartner.getReaction().getCreatedAt();
                String reactionContent = reactionWithPartner.getReaction().getReactionContent();
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.j0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                MsgDetailsDialogKt.MsgReactionItem(modifierC, picture, name, createdAt, reactionContent, (lb.a) objRememberedValue, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-42180643);
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
    public static final ua.k0 ViewsList$lambda$1(LazyPagingItems lazyPagingItems, int i10, Composer composer, int i11) {
        ViewsList(lazyPagingItems, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @Composable
    public static final void VolumeButtonsHandler(final lb.a onVolumeUp, final lb.a onVolumeDown, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(onVolumeUp, "onVolumeUp");
        kotlin.jvm.internal.y.i(onVolumeDown, "onVolumeDown");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1034218306);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onVolumeUp) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onVolumeDown) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1034218306, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.VolumeButtonsHandler (StatusPreviewScreen.kt:558)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            boolean zChangedInstance = ((i11 & 14) == 4) | ((i11 & 112) == 32) | composerStartRestartGroup.changedInstance(view);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusPreviewScreenKt.VolumeButtonsHandler$lambda$0$0(view, onVolumeUp, onVolumeDown, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(context, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusPreviewScreenKt.VolumeButtonsHandler$lambda$1(onVolumeUp, onVolumeDown, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VolumeButtonsHandler$lambda$0$0(final View view, final lb.a aVar, final lb.a aVar2, DisposableEffectScope DisposableEffect) {
        kotlin.jvm.internal.y.i(DisposableEffect, "$this$DisposableEffect");
        final ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat = new ViewCompat.OnUnhandledKeyEventListenerCompat() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.y
            @Override // androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat
            public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                return StatusPreviewScreenKt.VolumeButtonsHandler$lambda$0$0$0(aVar, aVar2, view2, keyEvent);
            }
        };
        ViewCompat.addOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewScreenKt$VolumeButtonsHandler$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ViewCompat.removeOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VolumeButtonsHandler$lambda$0$0$0(lb.a aVar, lb.a aVar2, View view, KeyEvent event) {
        kotlin.jvm.internal.y.i(view, "<unused var>");
        kotlin.jvm.internal.y.i(event, "event");
        int keyCode = event.getKeyCode();
        if (keyCode == 24) {
            aVar.invoke();
            return true;
        }
        if (keyCode != 25) {
            return false;
        }
        aVar2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VolumeButtonsHandler$lambda$1(lb.a aVar, lb.a aVar2, int i10, Composer composer, int i11) {
        VolumeButtonsHandler(aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
