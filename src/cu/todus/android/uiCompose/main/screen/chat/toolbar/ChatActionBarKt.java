package cu.todus.android.uiCompose.main.screen.chat.toolbar;

import ab.i;
import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArrowBackIosKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.ContactsKt;
import androidx.compose.material.icons.outlined.EmojiEmotionsKt;
import androidx.compose.material.icons.outlined.HideImageKt;
import androidx.compose.material.icons.outlined.ImagesearchRollerKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.RefreshKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBarKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.ConnectionIndicatorKt;
import cu.todus.android.uiCompose.shared.TypingIndicatorKt;
import cu.todus.android.uiCompose.shared.callToolbar.CallToolbarKt;
import cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbarKt;
import cu.todus.android.uiCompose.shared.playerToolbar.PlayerToolbarKt;
import cu.todus.android.uiCompose.shared.refreshConnection.RefreshConnectionKt;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.DateFormatter;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.utils.TextUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.todus.android.xmpp.iq.privacy.PrivacyGetIQ;
import cu.z17.singledi.SinglediException;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.picture.Z17PictureAvatarKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.topBar.Z17TopBarKt;
import defpackage.l;
import defpackage.r;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0010\u001aÑ\u0002\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0017\u001a\u00020\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0019\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\"\u0010#\u001aw\u0010,\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b,\u0010-\u001a\u0017\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0007¢\u0006\u0004\b0\u00101\u001a-\u00105\u001a\u00020\u000b2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b5\u00106\u001a\u008d\u0001\u0010@\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020.072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b@\u0010A\u001a5\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\b2\u0006\u00104\u001a\u00020$2\u0006\u00103\u001a\u0002022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\bC\u0010D¨\u0006G²\u0006\u000e\u0010E\u001a\u00020\b8\n@\nX\u008a\u008e\u0002²\u0006\u0018\u00108\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020.078\nX\u008a\u0084\u0002²\u0006\u000e\u0010F\u001a\u00020\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "chatScreenState", "", "selectionCount", "", "canEdit", "Lkotlin/Function0;", "Lua/k0;", "onEdit", "canPin", "onPin", "canDelete", "onDelete", "canReply", "onReply", "canForward", "onForward", "canRequestInfo", "onRequestInfo", "canReload", "onReload", "canShare", "onShare", "onCopy", "onCancel", "selectNewBackground", "removeBackground", "onCall", "onAudioCall", "onVideoCall", "ChatActionBar", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;IZLlb/a;ZLlb/a;ZLlb/a;ZLlb/a;ZLlb/a;ZLlb/a;ZLlb/a;ZLlb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;IIII)V", "", "id", "name", "image", "subscribed", "type", "isAdmin", "onClick", "BarTitle", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLlb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "", PrivacyGetIQ.PRIVACY_PROFILE_LAST, "LastIndicator", "(JLandroidx/compose/runtime/Composer;I)V", "", "icon", "label", "PopupMenuItem", "(Ljava/lang/Object;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "", "lastState", "onClose", "goChatPreview", "onOpenInContacts", "onOpenCatalogue", "onSelectNewBackground", "onRemoveBackground", "goSocialProfile", "ActionsPopup", "(Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;Ljava/util/Map;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "show", "ActionPopupItem", "(ZLjava/lang/String;Ljava/lang/Object;Llb/a;Landroidx/compose/runtime/Composer;I)V", "showProfileOptions", "openPopup", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChatActionBarKt {
    @Composable
    public static final void ActionPopupItem(final boolean z10, final String label, final Object icon, final a onClick, Composer composer, final int i10) {
        int i11;
        y.i(label, "label");
        y.i(icon, "icon");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1787913401);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(icon) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1787913401, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ActionPopupItem (ChatActionBar.kt:775)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-197855211);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1727paddingVpY3zN4$default(companion, Dp.m8823constructorimpl(10), 0.0f, 2, null), 0.0f, 1, null);
                boolean z11 = (i12 & 7168) == 2048;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: u7.f0
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ActionPopupItem$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (a) objRememberedValue, 15, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                IconButtonKt.IconButton(onClick, PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(20), 0.0f, 11, null), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-703817884, true, new Function2() { // from class: u7.g0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatActionBarKt.ActionPopupItem$lambda$1$0(icon, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 9) & 14) | 1572912, 60);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, label, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 0, 0, composerStartRestartGroup, i12 & 112, 57);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1837792741);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.ActionPopupItem$lambda$2(z10, label, icon, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionPopupItem$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ActionPopupItem$lambda$1$0(Object obj, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703817884, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ActionPopupItem.<anonymous>.<anonymous> (ChatActionBar.kt:791)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), obj, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionPopupItem$lambda$2(boolean z10, String str, Object obj, a aVar, int i10, Composer composer, int i11) {
        ActionPopupItem(z10, str, obj, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ActionsPopup(final ChatScreenState chatScreenState, Map<String, Long> lastState, a aVar, final a goChatPreview, final a onOpenInContacts, final a onOpenCatalogue, a aVar2, a onRemoveBackground, a goSocialProfile, Composer composer, final int i10) {
        int i11;
        int i12;
        final a aVar3;
        final a aVar4;
        Map<String, Long> map;
        final a onClose = aVar;
        final a onSelectNewBackground = aVar2;
        y.i(chatScreenState, "chatScreenState");
        y.i(lastState, "lastState");
        y.i(onClose, "onClose");
        y.i(goChatPreview, "goChatPreview");
        y.i(onOpenInContacts, "onOpenInContacts");
        y.i(onOpenCatalogue, "onOpenCatalogue");
        y.i(onSelectNewBackground, "onSelectNewBackground");
        y.i(onRemoveBackground, "onRemoveBackground");
        y.i(goSocialProfile, "goSocialProfile");
        Composer composerStartRestartGroup = composer.startRestartGroup(873772463);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(chatScreenState) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(lastState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClose) ? 256 : 128;
        }
        int i13 = i11;
        if ((i10 & 3072) == 0) {
            i12 = i13 | (composerStartRestartGroup.changedInstance(goChatPreview) ? 2048 : 1024);
        } else {
            i12 = i13;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onOpenInContacts) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onOpenCatalogue) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSelectNewBackground) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onRemoveBackground) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(goSocialProfile) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 38347923) != 38347922, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(873772463, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ActionsPopup (ChatActionBar.kt:583)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            float f11 = 15;
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1725padding3ABfNKs, materialTheme.getColorScheme(composerStartRestartGroup, i14).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(f10));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composerStartRestartGroup, 54);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            a constructor2 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
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
            ComposableSingletons$ChatActionBarKt composableSingletons$ChatActionBarKt = ComposableSingletons$ChatActionBarKt.INSTANCE;
            int i15 = i12;
            onClose = aVar;
            IconButtonKt.IconButton(onClose, null, false, null, null, null, composableSingletons$ChatActionBarKt.m9911getLambda$386385369$app_productionPFast(), composerStartRestartGroup, ((i12 >> 6) & 14) | 1572864, 62);
            TextStyle titleSmall = materialTheme.getTypography(composerStartRestartGroup, i14).getTitleSmall();
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8352FontYpTlLL0$default(R.font.dosis_semibold, null, 0, 0, 14, null));
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(companion, "toDus", TextStyle.m8271copyp1EtxEg$default(titleSmall, 0L, 0L, null, null, null, FontFamily, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744415, null), materialTheme.getColorScheme(composerStartRestartGroup, i14).getPrimary(), 0, 0, composerStartRestartGroup, 54, 48);
            Modifier modifierAlpha = AlphaKt.alpha(companion, 0.0f);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue == companion5.getEmpty()) {
                objRememberedValue = new a() { // from class: u7.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return ua.k0.f43947a;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            IconButtonKt.IconButton((a) objRememberedValue, modifierAlpha, false, null, null, null, composableSingletons$ChatActionBarKt.getLambda$1592888862$app_productionPFast(), composerStartRestartGroup, 1572918, 60);
            composerStartRestartGroup.endNode();
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f11))), Dp.m8823constructorimpl(5));
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs3);
            a constructor3 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            a constructor4 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 11, null), Dp.m8823constructorimpl(40)), chatScreenState.getImage(), Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(chatScreenState.getName()))), null, null, 0, null, false, null, chatScreenState.getName(), true, 0, composerStartRestartGroup, 6, 6, 2552);
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            a constructor5 = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyColumnMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, chatScreenState.getName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, 24576, 41);
            if (chatScreenState.getType() != 0 || chatScreenState.getNumber().length() <= 0) {
                composerStartRestartGroup.startReplaceGroup(-1699525843);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1699753321);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, "+" + chatScreenState.getNumber(), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), 0L, 1, 0, composerStartRestartGroup, 24576, 41);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 13, null), 0.0f, 1, null), TextUtilsKt.removeHtmlTags(chatScreenState.getDescription()), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getLabelSmall(), 0L, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), 0L, 3, 0, composerStartRestartGroup, 24582, 40);
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 13, null);
            int i16 = i15 & 896;
            boolean z10 = ((i15 & 7168) == 2048) | (i16 == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion5.getEmpty()) {
                objRememberedValue2 = new a() { // from class: u7.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$1$1$0(onClose, goChatPreview);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Z17ButtonsKt.Z17SecondaryDialogButton(modifierM1729paddingqDBjuR0$default, (a) objRememberedValue2, StringResources_androidKt.stringResource(R.string.detail_info, composerStartRestartGroup, 0), null, true, false, false, composerStartRestartGroup, 24582, LocationRequestCompat.QUALITY_LOW_POWER);
            composerStartRestartGroup.endNode();
            boolean zContains = w.q(0, 3).contains(Integer.valueOf(chatScreenState.getType()));
            String strStringResource = StringResources_androidKt.stringResource(R.string.social_profile, composerStartRestartGroup, 0);
            Icons.Outlined outlined = Icons.Outlined.INSTANCE;
            ImageVector emojiEmotions = EmojiEmotionsKt.getEmojiEmotions(outlined);
            boolean z11 = (i16 == 256) | ((234881024 & i15) == 67108864);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue3 == companion5.getEmpty()) {
                aVar4 = goSocialProfile;
                objRememberedValue3 = new a() { // from class: u7.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$2$0(onClose, aVar4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                aVar4 = goSocialProfile;
            }
            ActionPopupItem(zContains, strStringResource, emojiEmotions, (a) objRememberedValue3, composerStartRestartGroup, 0);
            boolean z12 = chatScreenState.getType() == 0 && chatScreenState.getNumber().length() > 0;
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.open_in_contact_book, composerStartRestartGroup, 0);
            ImageVector contacts = ContactsKt.getContacts(outlined);
            boolean z13 = ((57344 & i15) == 16384) | (i16 == 256);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = new a() { // from class: u7.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$3$0(onClose, onOpenInContacts);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ActionPopupItem(z12, strStringResource2, contacts, (a) objRememberedValue4, composerStartRestartGroup, 0);
            boolean z14 = chatScreenState.getType() == 0;
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.view_catalogue, composerStartRestartGroup, 0);
            Integer numValueOf = Integer.valueOf(R.drawable.business);
            boolean z15 = (i16 == 256) | ((458752 & i15) == 131072);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z15 || objRememberedValue5 == companion5.getEmpty()) {
                objRememberedValue5 = new a() { // from class: u7.e0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$4$0(onClose, onOpenCatalogue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ActionPopupItem(z14, strStringResource3, numValueOf, (a) objRememberedValue5, composerStartRestartGroup, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.select_background, composerStartRestartGroup, 0);
            ImageVector imagesearchRoller = ImagesearchRollerKt.getImagesearchRoller(outlined);
            boolean z16 = (i16 == 256) | ((3670016 & i15) == 1048576);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z16 || objRememberedValue6 == companion5.getEmpty()) {
                onSelectNewBackground = aVar2;
                objRememberedValue6 = new a() { // from class: u7.x
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$5$0(onClose, onSelectNewBackground);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                onSelectNewBackground = aVar2;
            }
            ActionPopupItem(true, strStringResource4, imagesearchRoller, (a) objRememberedValue6, composerStartRestartGroup, 6);
            boolean z17 = !d0.q0(chatScreenState.getBackgroundPath());
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.remove_background, composerStartRestartGroup, 0);
            ImageVector hideImage = HideImageKt.getHideImage(outlined);
            boolean z18 = ((29360128 & i15) == 8388608) | (i16 == 256);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z18 || objRememberedValue7 == companion5.getEmpty()) {
                aVar3 = onRemoveBackground;
                objRememberedValue7 = new a() { // from class: u7.y
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ActionsPopup$lambda$0$6$0(onClose, aVar3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                aVar3 = onRemoveBackground;
            }
            ActionPopupItem(z17, strStringResource5, hideImage, (a) objRememberedValue7, composerStartRestartGroup, 0);
            if (chatScreenState.getType() == 0) {
                composerStartRestartGroup.startReplaceGroup(204053483);
                map = lastState;
                Long l10 = map.get(chatScreenState.getId());
                LastIndicator(l10 != null ? l10.longValue() : -1L, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                map = lastState;
                composerStartRestartGroup.startReplaceGroup(699322049);
                Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(companion, 0.0f, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 13, null), 0.0f, 1, null), "", TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getLabelSmall(), 0L, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion4.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744445, null), 0L, 0, 0, composerStartRestartGroup, 54, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            aVar3 = onRemoveBackground;
            aVar4 = goSocialProfile;
            map = lastState;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Map<String, Long> map2 = map;
            final a aVar5 = onSelectNewBackground;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.ActionsPopup$lambda$1(chatScreenState, map2, onClose, goChatPreview, onOpenInContacts, onOpenCatalogue, aVar5, aVar3, aVar4, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$1$1$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$2$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$3$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$4$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$5$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$0$6$0(a aVar, a aVar2) {
        aVar.invoke();
        aVar2.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionsPopup$lambda$1(ChatScreenState chatScreenState, Map map, a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, int i10, Composer composer, int i11) {
        ActionsPopup(chatScreenState, map, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BarTitle(final Modifier modifier, final String id2, final String name, final String image, final boolean z10, final int i10, boolean z11, final a onClick, a aVar, a aVar2, Composer composer, final int i11, final int i12) {
        int i13;
        int i14;
        final boolean z12;
        final a aVar3;
        Composer composer2;
        final a aVar4;
        a aVar5;
        a aVar6;
        int i15;
        Long l10;
        y.i(modifier, "modifier");
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2122692037);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(id2) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(name) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(image) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        int i16 = i13;
        if ((196608 & i11) == 0) {
            i14 = i16 | (composerStartRestartGroup.changed(i10) ? 131072 : 65536);
        } else {
            i14 = i16;
        }
        if ((i11 & 12582912) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onClick) ? 8388608 : 4194304;
        }
        int i17 = i12 & 256;
        if (i17 != 0) {
            i14 |= 100663296;
        } else if ((i11 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(aVar) ? 67108864 : 33554432;
        }
        int i18 = i12 & 512;
        if (i18 != 0) {
            i14 |= 805306368;
        } else if ((i11 & 805306368) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(aVar2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i14 & 306259091) != 306259090, i14 & 1)) {
            boolean z13 = (i12 & 64) != 0 ? false : z11;
            if (i17 != 0) {
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: u7.t0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aVar5 = (a) objRememberedValue;
            } else {
                aVar5 = aVar;
            }
            if (i18 != 0) {
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: u7.u0
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                aVar6 = (a) objRememberedValue2;
            } else {
                aVar6 = aVar2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2122692037, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.BarTitle (ChatActionBar.kt:413)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            float f10 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1613spacedBy0680j_4 = Arrangement.INSTANCE.m1613spacedBy0680j_4(Dp.m8823constructorimpl(f10));
            float f11 = 10;
            final a aVar7 = aVar6;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(modifier, Dp.m8823constructorimpl(f11), 0.0f, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1613spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            AppVolatileState.Companion companion3 = AppVolatileState.INSTANCE;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(companion3.getInstance().getUsersTyping(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(companion3.getInstance().getUsersLast(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i19 = MaterialTheme.$stable;
            TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i19).getBodyMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierM1685offsetVpY3zN4$default = OffsetKt.m1685offsetVpY3zN4$default(rowScopeInstance.weight(companion4, 1.0f, true), Dp.m8823constructorimpl(50), 0.0f, 2, null);
            int i20 = 458752 & i14;
            int i21 = 29360128 & i14;
            int i22 = i14 & 57344;
            boolean z14 = (i20 == 131072) | (i21 == 8388608) | (i22 == 16384);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z14 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new a() { // from class: u7.v0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.BarTitle$lambda$2$0$0(i10, onClick, z10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            int i23 = i14;
            final a aVar8 = aVar5;
            Z17LabelKt.m10262Z17LabelfWhpE4E(ClickableKt.m1240clickableoSLSa3U$default(modifierM1685offsetVpY3zN4$default, false, null, null, null, (a) objRememberedValue3, 15, null), name, textStyleM8271copyp1EtxEg$default, 0L, 1, 15, composerStartRestartGroup, ((i14 >> 3) & 112) | 221184, 8);
            if (XMPPUtils.INSTANCE.isUser(id2)) {
                composerStartRestartGroup.startReplaceGroup(1423749623);
                float f12 = 0;
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion4, Dp.m8823constructorimpl(f12));
                boolean z15 = (i23 & 234881024) == 67108864;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: u7.w0
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.BarTitle$lambda$2$1$0(aVar8);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                a aVar9 = (a) objRememberedValue4;
                ComposableSingletons$ChatActionBarKt composableSingletons$ChatActionBarKt = ComposableSingletons$ChatActionBarKt.INSTANCE;
                IconButtonKt.IconButton(aVar9, modifierM1725padding3ABfNKs, false, null, null, null, composableSingletons$ChatActionBarKt.getLambda$963334178$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(companion4, Dp.m8823constructorimpl(f12));
                boolean z16 = (i23 & C.ENCODING_PCM_DOUBLE) == 536870912;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z16 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new a() { // from class: u7.x0
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.BarTitle$lambda$2$2$0(aVar7);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                IconButtonKt.IconButton((a) objRememberedValue5, modifierM1725padding3ABfNKs2, false, null, null, null, composableSingletons$ChatActionBarKt.getLambda$936113433$app_productionPFast(), composerStartRestartGroup, 1572912, 60);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1424643353);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(companion4, Dp.m8823constructorimpl(f10), 0.0f, 0.0f, 0.0f, 14, null);
            boolean z17 = (i21 == 8388608) | (i20 == 131072) | (i22 == 16384);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z17 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new a() { // from class: u7.y0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.BarTitle$lambda$2$3$0(i10, onClick, z10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierM1729paddingqDBjuR0$default, false, null, null, null, (a) objRememberedValue6, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getBottomEnd(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
            a constructor2 = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(40)), image, Color.m5856boximpl(ColorKt.Color(ColorGenerator.INSTANCE.getMATERIAL().getColor(name))), null, null, 0, null, false, null, name, true, 0, composerStartRestartGroup, ((i23 >> 6) & 112) | 6 | ((i23 << 21) & C.ENCODING_PCM_DOUBLE), 6, 2552);
            Composer composer3 = composerStartRestartGroup;
            if (i10 == 0) {
                composer3.startReplaceGroup(-1456801558);
                composer3.startReplaceGroup(-1432466001);
                Map map = (Map) stateCollectAsStateWithLifecycle2.getValue();
                if (map.containsKey(id2) && (l10 = (Long) map.get(id2)) != null && l10.longValue() == 0) {
                    composer3.startReplaceGroup(-824416500);
                    ConnectionIndicatorKt.ConnectingStateIndicator(true, composer3, 6);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(212965314);
                    composer3.endReplaceGroup();
                }
                k0 k0Var = k0.f43947a;
                composer3.endReplaceGroup();
                if (((Map) stateCollectAsStateWithLifecycle.getValue()).containsKey(id2)) {
                    composer3.startReplaceGroup(1137380952);
                    TypingIndicatorKt.TypingIndicator(composer3, 0);
                } else {
                    composer3.startReplaceGroup(899087483);
                }
                composer3.endReplaceGroup();
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-1456443787);
                if (i10 != 1) {
                    i15 = i10 != 3 ? R.drawable.channel_image_type : R.drawable.verified;
                } else {
                    i15 = R.drawable.group_image_type;
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(companion4, Dp.m8823constructorimpl(f11)), materialTheme.getColorScheme(composer3, i19).getBackground(), RoundedCornerShapeKt.getCircleShape()), Integer.valueOf(i15), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer3, i19).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer3, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
                composer3 = composer3;
                composer3.endReplaceGroup();
            }
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composer3;
            aVar4 = aVar7;
            aVar3 = aVar8;
            z12 = z13;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z12 = z11;
            aVar3 = aVar;
            composer2 = composerStartRestartGroup;
            aVar4 = aVar2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.BarTitle$lambda$3(modifier, id2, name, image, z10, i10, z12, onClick, aVar3, aVar4, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BarTitle$lambda$2$0$0(int i10, a aVar, boolean z10) {
        if (i10 != 3 || z10) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BarTitle$lambda$2$1$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BarTitle$lambda$2$2$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BarTitle$lambda$2$3$0(int i10, a aVar, boolean z10) {
        if (i10 != 3 || z10) {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BarTitle$lambda$3(Modifier modifier, String str, String str2, String str3, boolean z10, int i10, boolean z11, a aVar, a aVar2, a aVar3, int i11, int i12, Composer composer, int i13) {
        BarTitle(modifier, str, str2, str3, z10, i10, z11, aVar, aVar2, aVar3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:120:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:125:0x01da  */
    /* JADX WARN: Code duplicated, block: B:127:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:130:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:137:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:139:0x0202  */
    /* JADX WARN: Code duplicated, block: B:143:0x020c  */
    /* JADX WARN: Code duplicated, block: B:144:0x0211  */
    /* JADX WARN: Code duplicated, block: B:146:0x0217  */
    /* JADX WARN: Code duplicated, block: B:148:0x021d  */
    /* JADX WARN: Code duplicated, block: B:149:0x0220  */
    /* JADX WARN: Code duplicated, block: B:153:0x0228  */
    /* JADX WARN: Code duplicated, block: B:155:0x022e  */
    /* JADX WARN: Code duplicated, block: B:159:0x023a  */
    /* JADX WARN: Code duplicated, block: B:161:0x0240  */
    /* JADX WARN: Code duplicated, block: B:162:0x0243  */
    /* JADX WARN: Code duplicated, block: B:164:0x0248  */
    /* JADX WARN: Code duplicated, block: B:167:0x024e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0254  */
    /* JADX WARN: Code duplicated, block: B:173:0x025c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0262  */
    /* JADX WARN: Code duplicated, block: B:179:0x026a  */
    /* JADX WARN: Code duplicated, block: B:181:0x0272  */
    /* JADX WARN: Code duplicated, block: B:183:0x0277  */
    /* JADX WARN: Code duplicated, block: B:186:0x027d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0282  */
    /* JADX WARN: Code duplicated, block: B:189:0x0288  */
    /* JADX WARN: Code duplicated, block: B:191:0x028e  */
    /* JADX WARN: Code duplicated, block: B:195:0x0296  */
    /* JADX WARN: Code duplicated, block: B:197:0x029d  */
    /* JADX WARN: Code duplicated, block: B:199:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:201:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:211:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:214:0x02d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:215:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:216:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:218:0x02da  */
    /* JADX WARN: Code duplicated, block: B:219:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:221:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:223:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:225:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:227:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:228:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:231:0x0304  */
    /* JADX WARN: Code duplicated, block: B:233:0x0310  */
    /* JADX WARN: Code duplicated, block: B:235:0x031e  */
    /* JADX WARN: Code duplicated, block: B:237:0x0322  */
    /* JADX WARN: Code duplicated, block: B:239:0x032e  */
    /* JADX WARN: Code duplicated, block: B:241:0x0339  */
    /* JADX WARN: Code duplicated, block: B:243:0x033d  */
    /* JADX WARN: Code duplicated, block: B:245:0x034b  */
    /* JADX WARN: Code duplicated, block: B:247:0x0358  */
    /* JADX WARN: Code duplicated, block: B:250:0x0362  */
    /* JADX WARN: Code duplicated, block: B:253:0x039d  */
    /* JADX WARN: Code duplicated, block: B:256:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:257:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:260:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:263:0x040e  */
    /* JADX WARN: Code duplicated, block: B:266:0x0455  */
    /* JADX WARN: Code duplicated, block: B:269:0x0484  */
    /* JADX WARN: Code duplicated, block: B:271:0x048c  */
    /* JADX WARN: Code duplicated, block: B:274:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:276:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:279:0x0504  */
    /* JADX WARN: Code duplicated, block: B:280:0x0506  */
    /* JADX WARN: Code duplicated, block: B:287:0x0518  */
    /* JADX WARN: Code duplicated, block: B:296:0x059f  */
    /* JADX WARN: Code duplicated, block: B:299:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:301:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:304:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:306:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ChatActionBar(final Modifier modifier, final NavHostController navHostController, final ChatScreenState chatScreenState, final int i10, final boolean z10, final a onEdit, final boolean z11, final a onPin, final boolean z12, final a onDelete, final boolean z13, final a onReply, final boolean z14, final a onForward, boolean z15, final a onRequestInfo, boolean z16, a aVar, boolean z17, final a onShare, final a onCopy, final a onCancel, final a selectNewBackground, final a removeBackground, a aVar2, a aVar3, a aVar4, Composer composer, final int i11, final int i12, final int i13, final int i14) throws SinglediException {
        int i15;
        final int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        boolean z18;
        Composer composer2;
        boolean z19;
        final boolean z20;
        final a aVar5;
        boolean z21;
        final a aVar6;
        final a aVar7;
        final a aVar8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z22;
        final boolean z23;
        a aVar9;
        final boolean z24;
        a aVar10;
        final a aVar11;
        final a aVar12;
        a constructor;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Icons.Outlined outlined;
        ImageVector close;
        final int i29;
        boolean z25;
        boolean z26;
        boolean z27;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        int i30;
        int i31;
        y.i(modifier, "modifier");
        y.i(navHostController, "navHostController");
        y.i(onEdit, "onEdit");
        y.i(onPin, "onPin");
        y.i(onDelete, "onDelete");
        y.i(onReply, "onReply");
        y.i(onForward, "onForward");
        y.i(onRequestInfo, "onRequestInfo");
        y.i(onShare, "onShare");
        y.i(onCopy, "onCopy");
        y.i(onCancel, "onCancel");
        y.i(selectNewBackground, "selectNewBackground");
        y.i(removeBackground, "removeBackground");
        Composer composerStartRestartGroup = composer.startRestartGroup(1912784474);
        if ((i11 & 6) == 0) {
            i15 = i11 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i15 = i11;
        }
        if ((i11 & 48) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(navHostController) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i15 |= composerStartRestartGroup.changed(chatScreenState) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i16 = i10;
            i15 |= composerStartRestartGroup.changed(i16) ? 2048 : 1024;
        } else {
            i16 = i10;
        }
        if ((i11 & 24576) == 0) {
            i15 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onEdit) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i15 |= composerStartRestartGroup.changed(z11) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onPin) ? 8388608 : 4194304;
        }
        if ((i11 & 100663296) == 0) {
            i15 |= composerStartRestartGroup.changed(z12) ? 67108864 : 33554432;
        }
        if ((i11 & 805306368) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(onDelete) ? 536870912 : 268435456;
        }
        int i32 = i15;
        if ((i12 & 6) == 0) {
            i17 = i12 | (composerStartRestartGroup.changed(z13) ? 4 : 2);
        } else {
            i17 = i12;
        }
        if ((i12 & 48) == 0) {
            i17 |= composerStartRestartGroup.changedInstance(onReply) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i17 |= composerStartRestartGroup.changed(z14) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i17 |= composerStartRestartGroup.changedInstance(onForward) ? 2048 : 1024;
        }
        int i33 = i17;
        int i34 = i14 & 16384;
        if (i34 == 0) {
            i18 = i33;
            if ((i12 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changed(z15) ? 16384 : 8192;
            }
            if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onRequestInfo)) {
                    i31 = 131072;
                } else {
                    i31 = 65536;
                }
                i18 |= i31;
            }
            i19 = i14 & 65536;
            if (i19 != 0) {
                i18 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z16)) {
                    i20 = 1048576;
                } else {
                    i20 = 524288;
                }
                i18 |= i20;
            }
            i21 = i14 & 131072;
            if (i21 != 0) {
                i18 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(aVar) ? 8388608 : 4194304;
            }
            i22 = i14 & 262144;
            if (i22 != 0) {
                i18 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z17)) {
                    i23 = 67108864;
                } else {
                    i23 = 33554432;
                }
                i18 |= i23;
            }
            if ((i12 & 805306368) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(onShare) ? 536870912 : 268435456;
            }
            i24 = i18;
            if ((i13 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onCopy)) {
                    i30 = 4;
                } else {
                    i30 = 2;
                }
                i25 = i13 | i30;
            } else {
                i25 = i13;
            }
            if ((i13 & 48) == 0) {
                i25 |= composerStartRestartGroup.changedInstance(onCancel) ? 32 : 16;
            }
            if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i25 |= composerStartRestartGroup.changedInstance(selectNewBackground) ? 256 : 128;
            }
            if ((i13 & 3072) != 0) {
                i25 |= composerStartRestartGroup.changedInstance(removeBackground) ? 2048 : 1024;
            }
            i26 = i14 & 33554432;
            if (i26 != 0) {
                i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i13 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i25 |= composerStartRestartGroup.changedInstance(aVar3) ? 131072 : 65536;
            }
            i27 = i14 & 67108864;
            if (i27 != 0) {
                i25 |= 1572864;
            } else if ((i13 & 1572864) == 0) {
                i25 |= composerStartRestartGroup.changedInstance(aVar4) ? 1048576 : 524288;
            }
            i28 = i25;
            if ((i32 & 306783379) != 306783378 && (i24 & 306783379) == 306783378 && (i28 & 590995) == 590994) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z18, i32 & 1)) {
                if (i34 != 0) {
                    z22 = true;
                } else {
                    z22 = z15;
                }
                if (i19 != 0) {
                    z23 = false;
                } else {
                    z23 = z16;
                }
                if (i21 != 0) {
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new a() { // from class: u7.j
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    aVar9 = (a) objRememberedValue8;
                } else {
                    aVar9 = aVar;
                }
                if (i22 != 0) {
                    z24 = true;
                } else {
                    z24 = z17;
                }
                if ((16777216 & i14) != 0) {
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new a() { // from class: u7.m
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    aVar10 = (a) objRememberedValue7;
                } else {
                    aVar10 = aVar2;
                }
                if (i26 != 0) {
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new a() { // from class: u7.n
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    aVar11 = (a) objRememberedValue6;
                } else {
                    aVar11 = aVar3;
                }
                if (i27 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new a() { // from class: u7.o
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    aVar12 = (a) objRememberedValue5;
                } else {
                    aVar12 = aVar4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1912784474, i32, i24, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar (ChatActionBar.kt:133)");
                }
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                final a aVar13 = aVar9;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, v.e(PermissionNeedIt.CALLS), 1, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getUsersLast(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue3;
                long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0.95f, 0.0f, 0.0f, 0.0f, 14, null);
                outlined = Icons.Outlined.INSTANCE;
                if (i16 == 0) {
                    close = ArrowBackIosKt.getArrowBackIos(outlined);
                } else {
                    close = CloseKt.getClose(outlined);
                }
                ImageVector imageVector = close;
                float fM8823constructorimpl = Dp.m8823constructorimpl(4);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1084002525, true, new Function2() { // from class: u7.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$8(i16, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                final boolean z28 = z22;
                Function3 function3 = new Function3() { // from class: u7.q
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9(i16, chatScreenState, aVar11, aVar12, z10, z11, z14, z12, z23, z28, z13, z24, mutableState, onEdit, onCopy, onPin, onForward, onDelete, mutableState2, aVar13, onReply, onRequestInfo, onShare, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                i29 = i16;
                a aVar14 = aVar11;
                a aVar15 = aVar12;
                boolean z29 = z23;
                z19 = z28;
                z21 = z24;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1262895784, true, function3, composerStartRestartGroup, 54);
                if ((i32 & 7168) == 2048) {
                    z25 = true;
                } else {
                    z25 = false;
                }
                boolean zChangedInstance = z25 | composerStartRestartGroup.changedInstance(navHostController);
                if ((i28 & 112) == 32) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                z27 = zChangedInstance | z26;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z27 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: u7.r
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$10$0(i29, navHostController, onCancel);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composer2 = composerStartRestartGroup;
                Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda, null, false, composableLambdaRememberComposableLambda2, false, navHostController, (a) objRememberedValue4, imageVector, 0L, jM5865copywmQWz5c$default, fM8823constructorimpl, composer2, ((i32 << 12) & 458752) | 3078, 6, 278);
                PlayerToolbarKt.PlayerToolbar(composer2, 0);
                InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
                CallToolbarKt.CallToolbar(null, composer2, 0, 1);
                RefreshConnectionKt.RefreshConnection(composer2, 0);
                if (chatScreenState == null && ChatActionBar$lambda$4$1(mutableState)) {
                    composer2.startReplaceGroup(-1391784513);
                    Object objRememberedValue9 = composer2.rememberedValue();
                    if (objRememberedValue9 == companion.getEmpty()) {
                        objRememberedValue9 = new a() { // from class: u7.s
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatActionBarKt.ChatActionBar$lambda$4$11$0(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    AndroidDialog_androidKt.Dialog((a) objRememberedValue9, null, ComposableLambdaKt.rememberComposableLambda(715257602, true, new Function2() { // from class: u7.t
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatActionBarKt.ChatActionBar$lambda$4$12(chatScreenState, navHostController, context, selectNewBackground, removeBackground, stateCollectAsStateWithLifecycle, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, 390, 2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-194463950);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar8 = aVar15;
                aVar5 = aVar13;
                z20 = z29;
                aVar6 = aVar10;
                aVar7 = aVar14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z19 = z15;
                z20 = z16;
                aVar5 = aVar;
                z21 = z17;
                aVar6 = aVar2;
                aVar7 = aVar3;
                aVar8 = aVar4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z30 = z19;
                final boolean z31 = z21;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChatActionBarKt.ChatActionBar$lambda$5(modifier, navHostController, chatScreenState, i10, z10, onEdit, z11, onPin, z12, onDelete, z13, onReply, z14, onForward, z30, onRequestInfo, z20, aVar5, z31, onShare, onCopy, onCancel, selectNewBackground, removeBackground, aVar6, aVar7, aVar8, i11, i12, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i18 = i33 | 24576;
        if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(onRequestInfo)) {
                i31 = 131072;
            } else {
                i31 = 65536;
            }
            i18 |= i31;
        }
        i19 = i14 & 65536;
        if (i19 != 0) {
            i18 |= 1572864;
        } else if ((i12 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z16)) {
                i20 = 1048576;
            } else {
                i20 = 524288;
            }
            i18 |= i20;
        }
        i21 = i14 & 131072;
        if (i21 != 0) {
            i18 |= 12582912;
        } else if ((i12 & 12582912) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(aVar) ? 8388608 : 4194304;
        }
        i22 = i14 & 262144;
        if (i22 != 0) {
            i18 |= 100663296;
        } else if ((i12 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(z17)) {
                i23 = 67108864;
            } else {
                i23 = 33554432;
            }
            i18 |= i23;
        }
        if ((i12 & 805306368) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(onShare) ? 536870912 : 268435456;
        }
        i24 = i18;
        if ((i13 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(onCopy)) {
                i30 = 4;
            } else {
                i30 = 2;
            }
            i25 = i13 | i30;
        } else {
            i25 = i13;
        }
        if ((i13 & 48) == 0) {
            i25 |= composerStartRestartGroup.changedInstance(onCancel) ? 32 : 16;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i25 |= composerStartRestartGroup.changedInstance(selectNewBackground) ? 256 : 128;
        }
        if ((i13 & 3072) != 0) {
            i25 |= composerStartRestartGroup.changedInstance(removeBackground) ? 2048 : 1024;
        }
        i26 = i14 & 33554432;
        if (i26 != 0) {
            i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i13 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i25 |= composerStartRestartGroup.changedInstance(aVar3) ? 131072 : 65536;
        }
        i27 = i14 & 67108864;
        if (i27 != 0) {
            i25 |= 1572864;
        } else if ((i13 & 1572864) == 0) {
            i25 |= composerStartRestartGroup.changedInstance(aVar4) ? 1048576 : 524288;
        }
        i28 = i25;
        if ((i32 & 306783379) != 306783378) {
            z18 = true;
        } else {
            z18 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z18, i32 & 1)) {
            if (i34 != 0) {
                z22 = true;
            } else {
                z22 = z15;
            }
            if (i19 != 0) {
                z23 = false;
            } else {
                z23 = z16;
            }
            if (i21 != 0) {
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new a() { // from class: u7.j
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                aVar9 = (a) objRememberedValue8;
            } else {
                aVar9 = aVar;
            }
            if (i22 != 0) {
                z24 = true;
            } else {
                z24 = z17;
            }
            if ((16777216 & i14) != 0) {
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new a() { // from class: u7.m
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                aVar10 = (a) objRememberedValue7;
            } else {
                aVar10 = aVar2;
            }
            if (i26 != 0) {
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new a() { // from class: u7.n
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                aVar11 = (a) objRememberedValue6;
            } else {
                aVar11 = aVar3;
            }
            if (i27 != 0) {
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new a() { // from class: u7.o
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                aVar12 = (a) objRememberedValue5;
            } else {
                aVar12 = aVar4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1912784474, i32, i24, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar (ChatActionBar.kt:133)");
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            constructor = companion3.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            final a aVar16 = aVar9;
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue;
            final Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, v.e(PermissionNeedIt.CALLS), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getUsersLast(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            long jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0.95f, 0.0f, 0.0f, 0.0f, 14, null);
            outlined = Icons.Outlined.INSTANCE;
            if (i16 == 0) {
                close = ArrowBackIosKt.getArrowBackIos(outlined);
            } else {
                close = CloseKt.getClose(outlined);
            }
            ImageVector imageVector2 = close;
            float fM8823constructorimpl2 = Dp.m8823constructorimpl(4);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1084002525, true, new Function2() { // from class: u7.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.ChatActionBar$lambda$4$8(i16, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final boolean z210 = z22;
            Function3 function4 = new Function3() { // from class: u7.q
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9(i16, chatScreenState, aVar11, aVar12, z10, z11, z14, z12, z23, z210, z13, z24, mutableState3, onEdit, onCopy, onPin, onForward, onDelete, mutableState4, aVar16, onReply, onRequestInfo, onShare, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            i29 = i16;
            a aVar17 = aVar11;
            a aVar18 = aVar12;
            boolean z211 = z23;
            z19 = z210;
            z21 = z24;
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1262895784, true, function4, composerStartRestartGroup, 54);
            if ((i32 & 7168) == 2048) {
                z25 = true;
            } else {
                z25 = false;
            }
            boolean zChangedInstance2 = z25 | composerStartRestartGroup.changedInstance(navHostController);
            if ((i28 & 112) == 32) {
                z26 = true;
            } else {
                z26 = false;
            }
            z27 = zChangedInstance2 | z26;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z27) {
                objRememberedValue4 = new a() { // from class: u7.r
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$10$0(i29, navHostController, onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new a() { // from class: u7.r
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$10$0(i29, navHostController, onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composer2 = composerStartRestartGroup;
            Z17TopBarKt.m10304Z17TopBardW2gCk(composableLambdaRememberComposableLambda3, null, false, composableLambdaRememberComposableLambda4, false, navHostController, (a) objRememberedValue4, imageVector2, 0L, jM5865copywmQWz5c$default2, fM8823constructorimpl2, composer2, ((i32 << 12) & 458752) | 3078, 6, 278);
            PlayerToolbarKt.PlayerToolbar(composer2, 0);
            InCallToolbarKt.InCallToolbar(null, composer2, 0, 1);
            CallToolbarKt.CallToolbar(null, composer2, 0, 1);
            RefreshConnectionKt.RefreshConnection(composer2, 0);
            if (chatScreenState == null) {
                composer2.startReplaceGroup(-194463950);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-194463950);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar8 = aVar18;
            aVar5 = aVar16;
            z20 = z211;
            aVar6 = aVar10;
            aVar7 = aVar17;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z19 = z15;
            z20 = z16;
            aVar5 = aVar;
            z21 = z17;
            aVar6 = aVar2;
            aVar7 = aVar3;
            aVar8 = aVar4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z32 = z19;
            final boolean z33 = z21;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.ChatActionBar$lambda$5(modifier, navHostController, chatScreenState, i10, z10, onEdit, z11, onPin, z12, onDelete, z13, onReply, z14, onForward, z32, onRequestInfo, z20, aVar5, z33, onShare, onCopy, onCancel, selectNewBackground, removeBackground, aVar6, aVar7, aVar8, i11, i12, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ChatActionBar$lambda$4$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$10$0(int i10, NavHostController navHostController, a aVar) {
        if (i10 == 0) {
            navHostController.navigateUp();
        } else {
            aVar.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$11$0(MutableState mutableState) {
        ChatActionBar$lambda$4$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$12(final ChatScreenState chatScreenState, final NavHostController navHostController, final Context context, final a aVar, final a aVar2, State state, final MutableState mutableState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(715257602, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous> (ChatActionBar.kt:370)");
            }
            Map<String, Long> mapChatActionBar$lambda$4$4 = ChatActionBar$lambda$4$4(state);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new a() { // from class: u7.j0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            a aVar3 = (a) objRememberedValue;
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changed(chatScreenState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a() { // from class: u7.k0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$1$0(navHostController, chatScreenState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            a aVar4 = (a) objRememberedValue2;
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changed(chatScreenState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a() { // from class: u7.l0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$2$0(context, chatScreenState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            a aVar5 = (a) objRememberedValue3;
            boolean zChangedInstance3 = composer.changedInstance(navHostController) | composer.changed(chatScreenState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new a() { // from class: u7.m0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$3$0(navHostController, chatScreenState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            a aVar6 = (a) objRememberedValue4;
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new a() { // from class: u7.n0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$4$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            a aVar7 = (a) objRememberedValue5;
            boolean zChanged2 = composer.changed(aVar2);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new a() { // from class: u7.o0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$5$0(aVar2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            a aVar8 = (a) objRememberedValue6;
            boolean zChangedInstance4 = composer.changedInstance(navHostController) | composer.changed(chatScreenState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new a() { // from class: u7.p0
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.ChatActionBar$lambda$4$12$6$0(navHostController, chatScreenState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ActionsPopup(chatScreenState, mapChatActionBar$lambda$4$4, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, (a) objRememberedValue7, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$0$0(MutableState mutableState) {
        ChatActionBar$lambda$4$2(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$1$0(NavHostController navHostController, ChatScreenState chatScreenState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goPreview(chatScreenState.getId()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$2$0(Context context, ChatScreenState chatScreenState) {
        IntentUtil.INSTANCE.openContactCard(context, chatScreenState.getNumber());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$3$0(NavHostController navHostController, ChatScreenState chatScreenState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goCatalogueCheckIn(chatScreenState.getToDusId()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$4$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$5$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$12$6$0(NavHostController navHostController, ChatScreenState chatScreenState) {
        NavController.navigate$default((NavController) navHostController, NavLinks.INSTANCE.goSocialProfile(chatScreenState.getId()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return k0.f43947a;
    }

    private static final void ChatActionBar$lambda$4$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    private static final Map<String, Long> ChatActionBar$lambda$4$4(State<? extends Map<String, Long>> state) {
        return state.getValue();
    }

    private static final boolean ChatActionBar$lambda$4$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChatActionBar$lambda$4$7(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$8(int i10, Composer composer, int i11) {
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1084002525, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous> (ChatActionBar.kt:159)");
            }
            if (i10 > 0) {
                composer.startReplaceGroup(1950628544);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, String.valueOf(i10), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(340093599);
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
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9(final int i10, final ChatScreenState chatScreenState, a aVar, a aVar2, boolean z10, boolean z11, boolean z12, boolean z13, final boolean z14, final boolean z15, final boolean z16, final boolean z17, final MutableState mutableState, final a aVar3, final a aVar4, final a aVar5, final a aVar6, final a aVar7, final MutableState mutableState2, final a aVar8, final a aVar9, final a aVar10, final a aVar11, RowScope Z17TopBar, Composer composer, int i11) {
        int i12;
        Composer composer2;
        y.i(Z17TopBar, "$this$Z17TopBar");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(Z17TopBar) ? 4 : 2);
        } else {
            i12 = i11;
        }
        boolean z18 = false;
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262895784, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous> (ChatActionBar.kt:166)");
            }
            if (i10 == 0 && chatScreenState != null) {
                composer.startReplaceGroup(985311979);
                Modifier modifierA = e3.a(Z17TopBar, Modifier.INSTANCE, 1.0f, false, 2, null);
                String id2 = chatScreenState.getId();
                String name = chatScreenState.getName();
                String image = chatScreenState.getImage();
                boolean subscribed = chatScreenState.getSubscribed();
                int type = chatScreenState.getType();
                if (chatScreenState.getType() == 2 && chatScreenState.getRights().contains("pm")) {
                    z18 = true;
                }
                boolean zChanged = composer.changed(chatScreenState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: u7.l
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$0$0(chatScreenState, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                BarTitle(modifierA, id2, name, image, subscribed, type, z18, (a) objRememberedValue, aVar, aVar2, composer, 0, 0);
                composer.endReplaceGroup();
            } else if (i10 > 0) {
                composer.startReplaceGroup(986522312);
                int i13 = i12 & 14;
                int i14 = i13 | 1572864;
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, z10, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-373581388, true, new Function3() { // from class: u7.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$1(aVar3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i14, 30);
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3) ComposableLambdaKt.rememberComposableLambda(-1243426581, true, new Function3() { // from class: u7.h0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$2(aVar4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i13 | 1572912, 30);
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, z11, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1885740756, true, new Function3() { // from class: u7.s0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$3(aVar5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i14, 30);
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, z12, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1766912365, true, new Function3() { // from class: u7.a1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$4(aVar6, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i14, 30);
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, z13, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1124598190, true, new Function3() { // from class: u7.b1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$5(aVar7, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i14, 30);
                AnimatedVisibilityKt.AnimatedVisibility(Z17TopBar, i10 == 1 && (z14 || z15 || z16 || z17), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(482284015, true, new Function3() { // from class: u7.c1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChatActionBarKt.ChatActionBar$lambda$4$9$6(mutableState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, i14, 30);
                if (ChatActionBar$lambda$4$6(mutableState2)) {
                    composer.startReplaceGroup(990525280);
                    Alignment topEnd = Alignment.INSTANCE.getTopEnd();
                    long jM8941constructorimpl = IntOffset.m8941constructorimpl((((long) (-20)) << 32) | (((long) 100) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new a() { // from class: u7.d1
                            @Override // lb.a
                            public final Object invoke() {
                                return ChatActionBarKt.ChatActionBar$lambda$4$9$7$0(mutableState2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    AndroidPopup_androidKt.m9081PopupK5zGePQ(topEnd, jM8941constructorimpl, (a) objRememberedValue2, null, ComposableLambdaKt.rememberComposableLambda(-309129932, true, new Function2() { // from class: u7.e1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$8(z14, aVar8, i10, z16, aVar9, z15, aVar10, z17, aVar11, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer, 54), composer, 25014, 8);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composer;
                    composer2.startReplaceGroup(993579338);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(993597194);
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
    public static final k0 ChatActionBar$lambda$4$9$0$0(ChatScreenState chatScreenState, MutableState mutableState) {
        if (chatScreenState.getType() != 3 || chatScreenState.getSubscribed()) {
            ChatActionBar$lambda$4$2(mutableState, true);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$1(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-373581388, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:189)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.h
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$1$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.getLambda$1639235026$app_productionPFast(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$1$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$2(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1243426581, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:204)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.r0
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$2$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.getLambda$337864073$app_productionPFast(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$2$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$3(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885740756, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:220)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.i
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$3$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.m9910getLambda$304450102$app_productionPFast(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$3$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$4(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1766912365, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:235)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.f
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$4$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.m9912getLambda$946764277$app_productionPFast(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$4$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$5(final a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1124598190, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:251)");
        }
        boolean zChanged = composer.changed(aVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.q0
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$5$0$0(aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.m9909getLambda$1589078452$app_productionPFast(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$5$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$6(final MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(482284015, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:267)");
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: u7.a
                @Override // lb.a
                public final Object invoke() {
                    return ChatActionBarKt.ChatActionBar$lambda$4$9$6$0$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        IconButtonKt.IconButton((a) objRememberedValue, null, false, null, null, null, ComposableSingletons$ChatActionBarKt.INSTANCE.getLambda$2063574669$app_productionPFast(), composer, 1572870, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$6$0$0(MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$7$0(MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ChatActionBar$lambda$4$9$8(boolean z10, final a aVar, int i10, boolean z11, final a aVar2, boolean z12, final a aVar3, boolean z13, final a aVar4, final MutableState mutableState, Composer composer, int i11) {
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-309129932, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.ChatActionBar.<anonymous>.<anonymous>.<anonymous> (ChatActionBar.kt:290)");
            }
            float f10 = 15;
            Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(BackgroundKt.m1204backgroundbw27NRU(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(2), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)), false, 0L, 0L, 28, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM5480shadows4CzXII$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
            if (!r.a(composer.getApplier())) {
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
            if (z10) {
                composer.startReplaceGroup(-802730750);
                ImageVector refresh = RefreshKt.getRefresh(Icons.Outlined.INSTANCE);
                String strStringResource = StringResources_androidKt.stringResource(R.string.update, composer, 0);
                boolean zChanged = composer.changed(aVar);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a() { // from class: u7.b
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$8$0$0$0(aVar, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                PopupMenuItem(refresh, strStringResource, (a) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(885554148);
                composer.endReplaceGroup();
            }
            if (i10 == 1 && z11) {
                composer.startReplaceGroup(-802712544);
                Integer numValueOf = Integer.valueOf(R.drawable.reply_arrow);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.reply, composer, 0);
                boolean zChanged2 = composer.changed(aVar2);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new a() { // from class: u7.c
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$8$0$1$0(aVar2, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                PopupMenuItem(numValueOf, strStringResource2, (a) objRememberedValue2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(886116612);
                composer.endReplaceGroup();
            }
            if (i10 == 1 && z12) {
                composer.startReplaceGroup(-802694011);
                ImageVector info = InfoKt.getInfo(Icons.Outlined.INSTANCE);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.details, composer, 0);
                boolean zChanged3 = composer.changed(aVar3);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new a() { // from class: u7.d
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$8$0$2$0(aVar3, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                PopupMenuItem(info, strStringResource3, (a) objRememberedValue3, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(886695940);
                composer.endReplaceGroup();
            }
            if (i10 == 1 && z13) {
                composer.startReplaceGroup(-802675746);
                ImageVector share = ShareKt.getShare(Icons.Outlined.INSTANCE);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.share, composer, 0);
                boolean zChanged4 = composer.changed(aVar4);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new a() { // from class: u7.e
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatActionBarKt.ChatActionBar$lambda$4$9$8$0$3$0(aVar4, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                PopupMenuItem(share, strStringResource4, (a) objRememberedValue4, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(887255428);
                composer.endReplaceGroup();
            }
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
    public static final k0 ChatActionBar$lambda$4$9$8$0$0$0(a aVar, MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, false);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$8$0$1$0(a aVar, MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, false);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$8$0$2$0(a aVar, MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, false);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$4$9$8$0$3$0(a aVar, MutableState mutableState) {
        ChatActionBar$lambda$4$7(mutableState, false);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ChatActionBar$lambda$5(Modifier modifier, NavHostController navHostController, ChatScreenState chatScreenState, int i10, boolean z10, a aVar, boolean z11, a aVar2, boolean z12, a aVar3, boolean z13, a aVar4, boolean z14, a aVar5, boolean z15, a aVar6, boolean z16, a aVar7, boolean z17, a aVar8, a aVar9, a aVar10, a aVar11, a aVar12, a aVar13, a aVar14, a aVar15, int i11, int i12, int i13, int i14, Composer composer, int i15) throws SinglediException {
        ChatActionBar(modifier, navHostController, chatScreenState, i10, z10, aVar, z11, aVar2, z12, aVar3, z13, aVar4, z14, aVar5, z15, aVar6, z16, aVar7, z17, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), RecomposeScopeImplKt.updateChangedFlags(i12), RecomposeScopeImplKt.updateChangedFlags(i13), i14);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LastIndicator(final long j10, Composer composer, final int i10) {
        int i11;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(1641948764);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1641948764, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.LastIndicator (ChatActionBar.kt:522)");
            }
            if (j10 >= 0) {
                composerStartRestartGroup.startReplaceGroup(-86843167);
                if (j10 != 0) {
                    composerStartRestartGroup.startReplaceGroup(-86819669);
                    composerStartRestartGroup.endReplaceGroup();
                    strStringResource = DateFormatter.INSTANCE.prettyFormatter(j10);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1659769408);
                    strStringResource = StringResources_androidKt.stringResource(R.string.online, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-86708751);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = "...";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(PaddingKt.m1729paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8823constructorimpl(10), 0.0f, 0.0f, 13, null), 0.0f, 1, null), strStringResource, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), 0L, TextUnitKt.getSp(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744445, null), 0L, 0, 0, composerStartRestartGroup, 6, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatActionBarKt.LastIndicator$lambda$0(j10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LastIndicator$lambda$0(long j10, int i10, Composer composer, int i11) {
        LastIndicator(j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @Composable
    public static final void PopupMenuItem(Object icon, String label, final a onClick, Composer composer, final int i10) {
        int i11;
        final Object obj;
        Composer composer2;
        final String str;
        y.i(icon, "icon");
        y.i(label, "label");
        y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(431410880);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(icon) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431410880, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.toolbar.PopupMenuItem (ChatActionBar.kt:547)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 0.4f);
            boolean z10 = (i12 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: u7.u
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatActionBarKt.PopupMenuItem$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifierFillMaxWidth, false, null, null, null, (a) objRememberedValue, 15, null);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(modifierM1240clickableoSLSa3U$default, materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground(), null, 2, null), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(24)), icon, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i12 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            obj = icon;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            str = label;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, null, 0L, 1, 0, composerStartRestartGroup, (i12 & 112) | 24576, 45);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            obj = icon;
            composer2 = composerStartRestartGroup;
            str = label;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: u7.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChatActionBarKt.PopupMenuItem$lambda$2(obj, str, onClick, i10, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PopupMenuItem$lambda$0$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PopupMenuItem$lambda$2(Object obj, String str, a aVar, int i10, Composer composer, int i11) {
        PopupMenuItem(obj, str, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
