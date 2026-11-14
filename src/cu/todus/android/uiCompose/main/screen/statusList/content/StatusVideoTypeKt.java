package cu.todus.android.uiCompose.main.screen.statusList.content;

import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.PauseKt;
import androidx.compose.material.icons.outlined.PlayArrowKt;
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
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import c3.h0;
import cu.todus.android.R;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.videoPlayer.PlayerState;
import cu.z17.views.videoPlayer.RepeatMode;
import cu.z17.views.videoPlayer.Z17HLSVideoPlayerKt;
import cu.z17.views.videoPlayer.Z17VideoPlayerKt;
import cu.z17.views.videoPlayer.uri.HLSMediaItem;
import cu.z17.views.videoPlayer.uri.VideoPlayerMediaItem;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;
import va.g0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u001aO\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u007f\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b \u0010!¨\u0006$²\u0006\u000e\u0010\"\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00178\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010#\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;", "statusContent", "", "isMiniature", "isPlaying", "isFromOwner", "clearVideo", "hasSound", "", "squareMaxSize", "", "statusId", "Lua/k0;", "StatusVideoContentItem", "(Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;ZZZZZILjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "path", "streamUrl", "", "background", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "Landroidx/media3/common/Player;", "player", "Lkotlin/Function2;", "updatePlayerState", "Lkotlin/Function1;", "", "onCurrentTimeChanged", "StatusVideoPlayer", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcu/z17/views/videoPlayer/PlayerState;Landroidx/media3/common/Player;ZLjava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "StatusPreviewVideoContentItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;Landroidx/compose/runtime/Composer;I)V", "showIndicator", "firstLoaderCompleted", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StatusVideoTypeKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusPreviewVideoContentItem(final Modifier modifier, final StatusVideoContent statusContent, Composer composer, final int i10) {
        int i11;
        y.i(modifier, "modifier");
        y.i(statusContent, "statusContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1382238633);
        if ((i10 & 6) == 0) {
            i11 = i10 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(statusContent) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1382238633, i11, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusPreviewVideoContentItem (StatusVideoType.kt:281)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                h0 otherArr = Other.INSTANCE.getOtherArr();
                y.h(otherArr, "<get-otherArr>(...)");
                Object objX0 = g0.X0(otherArr, pb.d.f40576c);
                y.h(objX0, "random(...)");
                objRememberedValue = Color.m5856boximpl(Color.m5865copywmQWz5c$default(((Color) objX0).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            long jM5876unboximpl = ((Color) objRememberedValue).m5876unboximpl();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), statusContent.getThumbnail(), Color.m5856boximpl(jM5876unboximpl), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, 24966, 488);
            float f10 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), companion.getCenterVertically(), composerStartRestartGroup, 54);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            lb.a constructor2 = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(24));
            Integer numValueOf = Integer.valueOf(R.drawable.reel_icon);
            ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
            Color.Companion companion5 = Color.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, numValueOf, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, companion5.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            float f11 = 3;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(f11)), companion5.m5892getBlack0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11)), NumberInlineFunctionsKt.convertToHumanTime(statusContent.getDuration()), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), companion5.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 48);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusVideoTypeKt.StatusPreviewVideoContentItem$lambda$1(modifier, statusContent, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusPreviewVideoContentItem$lambda$1(Modifier modifier, StatusVideoContent statusVideoContent, int i10, Composer composer, int i11) {
        StatusPreviewVideoContentItem(modifier, statusVideoContent, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void StatusVideoContentItem(final StatusVideoContent statusContent, final boolean z10, final boolean z11, final boolean z12, final boolean z13, final boolean z14, final int i10, final String statusId, Composer composer, final int i11) {
        int i12;
        int i13;
        SnapshotMutationPolicy snapshotMutationPolicy;
        y.i(statusContent, "statusContent");
        y.i(statusId, "statusId");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2139955194);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(statusContent) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z12) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(z13) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(z14) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(statusId) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i12) != 4793490, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139955194, i12, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoContentItem (StatusVideoType.kt:60)");
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1205337682);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f10 = i10;
                Modifier modifierM1774width3ABfNKs = SizeKt.m1774width3ABfNKs(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(f10)), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1774width3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), statusContent.getThumbnail(), null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, 24582, 492);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1204849060);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion3 = Composer.INSTANCE;
                if (objRememberedValue == companion3.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState = (MutableState) objRememberedValue;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion3.getEmpty()) {
                    i13 = 2;
                    snapshotMutationPolicy = null;
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    i13 = 2;
                    snapshotMutationPolicy = null;
                }
                MutableState mutableState2 = (MutableState) objRememberedValue2;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion3.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, i13, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState3 = (MutableState) objRememberedValue3;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion3.getEmpty()) {
                    h0 otherArr = Other.INSTANCE.getOtherArr();
                    y.h(otherArr, "<get-otherArr>(...)");
                    Object objX0 = g0.X0(otherArr, pb.d.f40576c);
                    y.h(objX0, "random(...)");
                    objRememberedValue4 = Color.m5856boximpl(Color.m5865copywmQWz5c$default(((Color) objX0).m5876unboximpl(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                long jM5876unboximpl = ((Color) objRememberedValue4).m5876unboximpl();
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                lb.a constructor2 = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
                String path = !z12 ? "" : statusContent.getPath();
                String streamUrl = statusContent.getStreamUrl();
                String thumbnail = statusContent.getThumbnail();
                boolean zQ0 = d0.q0(thumbnail);
                Object objM5856boximpl = thumbnail;
                if (zQ0) {
                    objM5856boximpl = Color.m5856boximpl(jM5876unboximpl);
                }
                PlayerState playerStateStatusVideoContentItem$lambda$5 = StatusVideoContentItem$lambda$5(mutableState2);
                Player playerStatusVideoContentItem$lambda$8 = StatusVideoContentItem$lambda$8(mutableState3);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion3.getEmpty()) {
                    objRememberedValue5 = new StatusVideoTypeKt$StatusVideoContentItem$2$2$1(mutableState2, mutableState3);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function2 function2 = (Function2) ((sb.h) objRememberedValue5);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                String str = path;
                if (objRememberedValue6 == companion3.getEmpty()) {
                    objRememberedValue6 = new StatusVideoTypeKt$StatusVideoContentItem$2$3$1(mutableState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                int i14 = i12;
                StatusVideoPlayer(modifierFillMaxSize$default, str, streamUrl, objM5856boximpl, playerStateStatusVideoContentItem$lambda$5, playerStatusVideoContentItem$lambda$8, z14, statusId, function2, (Function1) ((sb.h) objRememberedValue6), composerStartRestartGroup, ((i12 << 3) & 3670016) | 905969670 | (i12 & 29360128));
                composerStartRestartGroup = composerStartRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(StatusVideoContentItem$lambda$2(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1138842616, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return StatusVideoTypeKt.StatusVideoContentItem$lambda$11$3(z11, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                Boolean boolValueOf = Boolean.valueOf(z11);
                Player playerStatusVideoContentItem$lambda$9 = StatusVideoContentItem$lambda$8(mutableState3);
                boolean z15 = (i14 & 896) == 256;
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z15 || objRememberedValue7 == companion3.getEmpty()) {
                    objRememberedValue7 = new StatusVideoTypeKt$StatusVideoContentItem$2$5$1(z11, mutableState2, mutableState3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                int i15 = (i14 >> 6) & 14;
                EffectsKt.LaunchedEffect(boolValueOf, playerStatusVideoContentItem$lambda$9, (Function2) objRememberedValue7, composerStartRestartGroup, i15);
                Boolean boolValueOf2 = Boolean.valueOf(StatusVideoContentItem$lambda$5(mutableState2).isPlaying());
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion3.getEmpty()) {
                    objRememberedValue8 = new StatusVideoTypeKt$StatusVideoContentItem$2$6$1(mutableState2, mutableState3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2) objRememberedValue8, composerStartRestartGroup, 0);
                Boolean boolValueOf3 = Boolean.valueOf(z11);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue9 == companion3.getEmpty()) {
                    objRememberedValue9 = new StatusVideoTypeKt$StatusVideoContentItem$2$7$1(mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                EffectsKt.LaunchedEffect(boolValueOf3, (Function2) objRememberedValue9, composerStartRestartGroup, i15);
                Boolean boolValueOf4 = Boolean.valueOf(z13);
                boolean z16 = (57344 & i14) == 16384;
                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (z16 || objRememberedValue10 == companion3.getEmpty()) {
                    objRememberedValue10 = new StatusVideoTypeKt$StatusVideoContentItem$2$8$1(z13, mutableState3, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                EffectsKt.LaunchedEffect(boolValueOf4, (Function2) objRememberedValue10, composerStartRestartGroup, (i14 >> 12) & 14);
                composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusVideoTypeKt.StatusVideoContentItem$lambda$12(statusContent, z10, z11, z12, z13, z14, i10, statusId, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 StatusVideoContentItem$lambda$11$3(boolean z10, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138842616, i10, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoContentItem.<anonymous>.<anonymous> (StatusVideoType.kt:122)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        Color.Companion companion2 = Color.INSTANCE;
        Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion3.getConstructor();
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
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(70));
        Icons.Outlined outlined = Icons.Outlined.INSTANCE;
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, z10 ? PlayArrowKt.getPlayArrow(outlined) : PauseKt.getPause(outlined), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.m5865copywmQWz5c$default(companion2.m5903getWhite0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusVideoContentItem$lambda$12(StatusVideoContent statusVideoContent, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, String str, int i11, Composer composer, int i12) {
        StatusVideoContentItem(statusVideoContent, z10, z11, z12, z13, z14, i10, str, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return k0.f43947a;
    }

    private static final boolean StatusVideoContentItem$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusVideoContentItem$lambda$3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerState StatusVideoContentItem$lambda$5(MutableState<PlayerState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Player StatusVideoContentItem$lambda$8(MutableState<Player> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusVideoContentItem$onCurrentTimeChanged(MutableState<PlayerState> mutableState, long j10) {
        PlayerState playerStateStatusVideoContentItem$lambda$5 = StatusVideoContentItem$lambda$5(mutableState);
        mutableState.setValue(playerStateStatusVideoContentItem$lambda$5.copy((3583 & 1) != 0 ? playerStateStatusVideoContentItem$lambda$5.isFullscreen : false, (3583 & 2) != 0 ? playerStateStatusVideoContentItem$lambda$5.isPlaying : false, (3583 & 4) != 0 ? playerStateStatusVideoContentItem$lambda$5.isLoading : false, (3583 & 8) != 0 ? playerStateStatusVideoContentItem$lambda$5.isPIP : false, (3583 & 16) != 0 ? playerStateStatusVideoContentItem$lambda$5.playbackState : 0, (3583 & 32) != 0 ? playerStateStatusVideoContentItem$lambda$5.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStateStatusVideoContentItem$lambda$5.currentPosition : j10, (3583 & 128) != 0 ? playerStateStatusVideoContentItem$lambda$5.totalDuration : 0L, (3583 & 256) != 0 ? playerStateStatusVideoContentItem$lambda$5.tripleTrackSave : null, (3583 & 512) != 0 ? playerStateStatusVideoContentItem$lambda$5.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStateStatusVideoContentItem$lambda$5.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStateStatusVideoContentItem$lambda$5.selectedSubsTrack : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusVideoContentItem$updatePlayerState(MutableState<PlayerState> mutableState, MutableState<Player> mutableState2, PlayerState playerState, Player player) {
        mutableState.setValue(playerState);
        mutableState2.setValue(player);
    }

    @Composable
    public static final void StatusVideoPlayer(final Modifier modifier, final String path, final String streamUrl, final Object background, PlayerState playerState, Player player, final boolean z10, final String statusId, final Function2 updatePlayerState, final Function1 onCurrentTimeChanged, Composer composer, final int i10) {
        int i11;
        PlayerState playerState2;
        final Player player2;
        boolean z11;
        y.i(modifier, "modifier");
        y.i(path, "path");
        y.i(streamUrl, "streamUrl");
        y.i(background, "background");
        y.i(playerState, "playerState");
        y.i(statusId, "statusId");
        y.i(updatePlayerState, "updatePlayerState");
        y.i(onCurrentTimeChanged, "onCurrentTimeChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(1815908279);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(path) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(streamUrl) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(background) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(playerState) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(player) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i11 |= composerStartRestartGroup.changed(statusId) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(updatePlayerState) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCurrentTimeChanged) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i11) != 306783378, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1815908279, i11, -1, "cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoPlayer (StatusVideoType.kt:190)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (objRememberedValue == companion2.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
            ContentScale.Companion companion4 = ContentScale.INSTANCE;
            int i12 = ((i11 >> 6) & 112) | 24582;
            int i13 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default, background, null, null, companion4.getCrop(), null, 0, null, null, composerStartRestartGroup, i12, 492);
            BoxKt.Box(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Color.m5865copywmQWz5c$default(Color.INSTANCE.m5903getWhite0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 6);
            if (d0.q0(path)) {
                composerStartRestartGroup.startReplaceGroup(748082540);
                Z17HLSVideoPlayerKt.Z17HLSVideoPlayer(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), new HLSMediaItem(streamUrl, null, null, null, statusId, 14, null), true, false, false, false, null, 0L, 0L, RepeatMode.ONE, z10 ? 1.0f : 0.0f, onCurrentTimeChanged, false, true, true, null, playerState, updatePlayerState, null, null, 1, 0, composerStartRestartGroup, (HLSMediaItem.$stable << 3) | 805506438, ((i13 >> 24) & 112) | 28032 | ((i13 << 6) & 3670016) | ((i13 >> 3) & 29360128), 54, 819664);
                playerState2 = playerState;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(747164320);
                Z17VideoPlayerKt.Z17VideoPlayer(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), v.e(new VideoPlayerMediaItem.StorageMediaItem(Uri.parse(path), null, null, 6, null)), true, false, false, false, null, 0L, 0L, RepeatMode.ONE, z10 ? 1.0f : 0.0f, onCurrentTimeChanged, false, false, true, null, playerState, updatePlayerState, null, null, 1, 0, composerStartRestartGroup, (VideoPlayerMediaItem.StorageMediaItem.$stable << 3) | 805506438, ((i13 >> 24) & 112) | 28032 | ((i13 << 6) & 3670016) | ((i13 >> 3) & 29360128), 54, 819664);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
                playerState2 = playerState;
            }
            if (StatusVideoPlayer$lambda$0$1(mutableState)) {
                z11 = true;
                composerStartRestartGroup.startReplaceGroup(749152133);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(748949362);
                z11 = true;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), background, null, null, companion4.getCrop(), null, 0, null, null, composerStartRestartGroup, i12, 492);
                composerStartRestartGroup.endReplaceGroup();
            }
            Long lValueOf = Long.valueOf(playerState2.getCurrentPosition());
            Boolean boolValueOf = Boolean.valueOf(playerState2.isLoading());
            boolean z12 = (i13 & 57344) == 16384 ? z11 : false;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue2 == companion2.getEmpty()) {
                objRememberedValue2 = new StatusVideoTypeKt$StatusVideoPlayer$1$1$1(playerState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(lValueOf, boolValueOf, (Function2) objRememberedValue2, composerStartRestartGroup, 0);
            k0 k0Var = k0.f43947a;
            player2 = player;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(player2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion2.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatusVideoTypeKt.StatusVideoPlayer$lambda$0$4$0(player2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(k0Var, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            playerState2 = playerState;
            player2 = player;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PlayerState playerState3 = playerState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatusVideoTypeKt.StatusVideoPlayer$lambda$1(modifier, path, streamUrl, background, playerState3, player2, z10, statusId, updatePlayerState, onCurrentTimeChanged, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StatusVideoPlayer$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatusVideoPlayer$lambda$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult StatusVideoPlayer$lambda$0$4$0(final Player player, DisposableEffectScope DisposableEffect) {
        y.i(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoTypeKt$StatusVideoPlayer$lambda$0$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Player player2 = player;
                if (player2 != null) {
                    player2.stop();
                }
                Player player3 = player;
                if (player3 != null) {
                    player3.release();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 StatusVideoPlayer$lambda$1(Modifier modifier, String str, String str2, Object obj, PlayerState playerState, Player player, boolean z10, String str3, Function2 function2, Function1 function1, int i10, Composer composer, int i11) {
        StatusVideoPlayer(modifier, str, str2, obj, playerState, player, z10, str3, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
