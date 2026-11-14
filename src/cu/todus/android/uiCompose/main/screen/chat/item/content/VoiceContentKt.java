package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.StopKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.di.MediaModule;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001ac\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a9\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e²\u0006\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "ownerId", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "", "isSecret", "VoiceContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;I)V", "senderId", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lcu/todus/android/data/db/pojo/content/VoiceContent;", "content", "Lcu/todus/android/media/player/MediaPlayerData;", "actualPlayingState", "SendOrReceiveVoice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Attachment;Lcu/todus/android/data/db/pojo/content/VoiceContent;Lcu/todus/android/media/player/MediaPlayerData;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;I)V", "fileExist", "isPlaying", "VoiceShowIn", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Ll0/j;", "recordingAnimationComposition", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class VoiceContentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendOrReceiveVoice(final String senderId, final String ownerId, final String msgId, final Attachment attachment, final VoiceContent content, final MediaPlayerData mediaPlayerData, final Function2 onClick, final boolean z10, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(senderId, "senderId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(content, "content");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1402488116);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(senderId) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(attachment) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(mediaPlayerData) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 1048576 : 524288;
        }
        if ((12582912 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i11) != 4793490, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402488116, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveVoice (VoiceContent.kt:102)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (!kotlin.jvm.internal.y.d(senderId, ownerId) || attachment.getState() == 4 || attachment.getState() == 5) {
                composerStartRestartGroup.startReplaceGroup(-914088920);
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1774width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(70)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                PathsVolatileState.Companion companion3 = PathsVolatileState.INSTANCE;
                DownloadableKt.Downloadable(modifierM1204backgroundbw27NRU, companion3.getInstance().autoDownloadVoice(), DownloadableSize.MINI, attachment.getId(), content.getFolderPath(companion3.getInstance().publicVoice() && !z10).getSecond(), 4, content, null, false, null, ComposableLambdaKt.rememberComposableLambda(-2000602958, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.g3
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return VoiceContentKt.SendOrReceiveVoice$lambda$0$1(mediaPlayerData, content, onClick, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (3670016 & (i11 << 6)) | 196992, 6, 896);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-914937793);
                Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1774width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(70)), Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                UploadableSize uploadableSize = UploadableSize.MINI;
                String id2 = attachment.getId();
                Content content2 = attachment.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VoiceContent");
                UploadableKt.Uploadable(modifierM1204backgroundbw27NRU2, true, uploadableSize, msgId, id2, 4, (VoiceContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(72166082, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f3
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return VoiceContentKt.SendOrReceiveVoice$lambda$0$0(mediaPlayerData, content, onClick, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 << 3) & 7168) | 197040, 6, 896);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.h3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceContentKt.SendOrReceiveVoice$lambda$1(senderId, ownerId, msgId, attachment, content, mediaPlayerData, onClick, z10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveVoice$lambda$0$0(MediaPlayerData mediaPlayerData, VoiceContent voiceContent, Function2 function2, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(72166082, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveVoice.<anonymous>.<anonymous> (VoiceContent.kt:122)");
        }
        VoiceShowIn(z10, kotlin.jvm.internal.y.d(mediaPlayerData != null ? mediaPlayerData.getMediaId() : null, voiceContent.getUrl()), function2, composer, (i10 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveVoice$lambda$0$1(MediaPlayerData mediaPlayerData, VoiceContent voiceContent, Function2 function2, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2000602958, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveVoice.<anonymous>.<anonymous> (VoiceContent.kt:147)");
        }
        VoiceShowIn(z10, kotlin.jvm.internal.y.d(mediaPlayerData != null ? mediaPlayerData.getMediaId() : null, voiceContent.getUrl()), function2, composer, (i10 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SendOrReceiveVoice$lambda$1(String str, String str2, String str3, Attachment attachment, VoiceContent voiceContent, MediaPlayerData mediaPlayerData, Function2 function2, boolean z10, int i10, Composer composer, int i11) {
        SendOrReceiveVoice(str, str2, str3, attachment, voiceContent, mediaPlayerData, function2, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VoiceContent(final MessageWithPartnerWithReactions messageWithPartnerWithReactions, final String str, final Function2 function2, final Function2 onLongClick, final boolean z10, Composer composer, final int i10) {
        int i11;
        MessageWithPartnerWithReactions msg = messageWithPartnerWithReactions;
        String ownerId = str;
        Function2 onClick = function2;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1968832823);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onLongClick) ? 2048 : 1024;
        }
        boolean z11 = z10;
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 16384 : 8192;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968832823, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.VoiceContent (VoiceContent.kt:51)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z12 = ((i12 & 7168) == 2048) | ((i12 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new VoiceContentKt$VoiceContent$1$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, onLongClick, (PointerInputEventHandler) objRememberedValue);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(MediaModule.INSTANCE.getInstance().getActualPlaying(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(70));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getTop(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1755height3ABfNKs);
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
            String userSender = msg.getMessage().getUserSender();
            Iterator<T> it = msg.getAttachments().iterator();
            while (true) {
                String str2 = "Collection contains no element matching the predicate.";
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                Attachment attachment = (Attachment) it.next();
                if (attachment.getContent().getType() == 4 && (attachment.getContent() instanceof VoiceContent)) {
                    String id2 = msg.getMessage().getId();
                    Iterator<T> it2 = msg.getAttachments().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            throw new NoSuchElementException(str2);
                        }
                        Attachment attachment2 = (Attachment) it2.next();
                        if (attachment2.getContent().getType() == 4 && (attachment2.getContent() instanceof VoiceContent)) {
                            Content content = attachment2.getContent();
                            kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VoiceContent");
                            String str3 = str2;
                            Function2 function3 = onClick;
                            String str4 = ownerId;
                            String str5 = userSender;
                            SendOrReceiveVoice(str5, str4, id2, attachment, (VoiceContent) content, VoiceContent$lambda$1$0(stateCollectAsStateWithLifecycle), function3, z11, composerStartRestartGroup, ((i12 << 9) & 29360128) | (i12 & 112) | ((i12 << 12) & 3670016));
                            composerStartRestartGroup = composerStartRestartGroup;
                            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(rowScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), Dp.m8823constructorimpl(5));
                            Iterator<T> it3 = messageWithPartnerWithReactions.getAttachments().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    throw new NoSuchElementException(str3);
                                }
                                Attachment attachment3 = (Attachment) it3.next();
                                if (attachment3.getContent().getType() == 4 && (attachment3.getContent() instanceof VoiceContent)) {
                                    Content content2 = attachment3.getContent();
                                    kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.VoiceContent");
                                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1725padding3ABfNKs, NumberInlineFunctionsKt.humanDuration(((VoiceContent) content2).getDuration() * ((long) 1000)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
                                    composerStartRestartGroup.endNode();
                                    composerStartRestartGroup.endNode();
                                    if (!ComposerKt.isTraceInProgress()) {
                                        break;
                                    }
                                    ComposerKt.traceEventEnd();
                                    break;
                                }
                            }
                        } else {
                            attachment = attachment;
                            stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                            onClick = function2;
                            z11 = z10;
                            str2 = str2;
                            id2 = id2;
                            userSender = userSender;
                            ownerId = str;
                        }
                    }
                }
                msg = messageWithPartnerWithReactions;
                onClick = function2;
                z11 = z10;
                userSender = userSender;
                stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                ownerId = str;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.e3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceContentKt.VoiceContent$lambda$2(messageWithPartnerWithReactions, str, function2, onLongClick, z10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final MediaPlayerData VoiceContent$lambda$1$0(State<MediaPlayerData> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VoiceContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, Function2 function2, Function2 function3, boolean z10, int i10, Composer composer, int i11) {
        VoiceContent(messageWithPartnerWithReactions, str, function2, function3, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0162  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VoiceShowIn(final boolean z10, final boolean z11, final Function2 onClick, Composer composer, final int i10) {
        int i11;
        float fFloatValue;
        Object objValueOf;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-278352954);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278352954, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.VoiceShowIn (VoiceContent.kt:162)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z12 = ((i11 & 14) == 4) | ((i11 & 112) == 32) | ((i11 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.i3
                    @Override // lb.a
                    public final Object invoke() {
                        return VoiceContentKt.VoiceShowIn$lambda$0$0(z10, z11, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z11) {
                MediaModule.Companion companion3 = MediaModule.INSTANCE;
                if (companion3.getInstance().getActualPlayingDuration() > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(1050559275);
                    State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(companion3.getInstance().getActualPlayingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                    composerStartRestartGroup = composerStartRestartGroup;
                    fFloatValue = ((Number) stateCollectAsStateWithLifecycle.getValue()).floatValue() / companion3.getInstance().getActualPlayingDuration();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1792248354);
                    composerStartRestartGroup.endReplaceGroup();
                    fFloatValue = 0.0f;
                }
            } else {
                composerStartRestartGroup.startReplaceGroup(-1792248354);
                composerStartRestartGroup.endReplaceGroup();
                fFloatValue = 0.0f;
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(2));
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            Composer composer2 = composerStartRestartGroup;
            ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(fFloatValue, modifierM1725padding3ABfNKs, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), 0.0f, 0L, 0, composer2, 48, 56);
            composerStartRestartGroup = composer2;
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(-1791980512);
                p0.e.a(VoiceShowIn$lambda$1$0(p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.audio_wave)), null, null, null, null, null, composerStartRestartGroup, 0, 62)), SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composerStartRestartGroup, 1572912, 0, 0, 4194236);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1791578814);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-1791530361);
                if (z11) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    objValueOf = StopKt.getStop(Icons.Outlined.INSTANCE);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    objValueOf = Integer.valueOf(R.drawable.voice);
                }
                Composer composer3 = composerStartRestartGroup;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), objValueOf, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground(), 0, 2, null), null, "icon voice", 0, null, null, composer3, 196614, 468);
                composerStartRestartGroup = composer3;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(-1791217726);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.j3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceContentKt.VoiceShowIn$lambda$2(z10, z11, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VoiceShowIn$lambda$0$0(boolean z10, boolean z11, Function2 function2) {
        if (!z10) {
            function2.invoke(MessageAction.REGULAR_CLICK, 0);
        } else if (z11) {
            function2.invoke(MessageAction.STOP_AUDIO_FILE, 0);
        } else {
            function2.invoke(MessageAction.PLAY_AUDIO_FILE, 0);
        }
        return ua.k0.f43947a;
    }

    private static final l0.j VoiceShowIn$lambda$1$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 VoiceShowIn$lambda$2(boolean z10, boolean z11, Function2 function2, int i10, Composer composer, int i11) {
        VoiceShowIn(z10, z11, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
