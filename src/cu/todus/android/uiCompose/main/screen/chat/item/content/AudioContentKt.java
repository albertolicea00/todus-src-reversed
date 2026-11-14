package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MusicNoteKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.di.MediaModule;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\n2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001ak\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aC\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\n2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 ²\u0006\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "ownerId", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "", "isSecret", "onMsgEntityClick", "AudioContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "senderId", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lcu/todus/android/data/db/pojo/content/AudioContent;", "content", "Lcu/todus/android/media/player/MediaPlayerData;", "actualPlayingState", "index", "SendOrReceiveAudio", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Attachment;Lcu/todus/android/data/db/pojo/content/AudioContent;Lkotlin/jvm/functions/Function2;Lcu/todus/android/media/player/MediaPlayerData;IZLandroidx/compose/runtime/Composer;I)V", "fileExist", "isPlaying", "AudioShowIn", "(ZIZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Ll0/j;", "recordingAnimationComposition", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AudioContentKt {
    /* JADX WARN: Code duplicated, block: B:103:0x023a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0242  */
    /* JADX WARN: Code duplicated, block: B:109:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:110:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:113:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:118:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:121:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x0245 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x00da  */
    /* JADX WARN: Code duplicated, block: B:67:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x012b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0137  */
    /* JADX WARN: Code duplicated, block: B:83:0x013b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0177  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:97:0x021d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AudioContent(final MessageWithPartnerWithReactions msg, final String str, final Function2 function2, final Function2 onLongClick, final boolean z10, Function2 function3, Composer composer, final int i10, final int i11) {
        Function2 function4;
        boolean z11;
        final Function2 function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 function6;
        boolean z12;
        boolean z13;
        boolean z14;
        Object objRememberedValue;
        lb.a constructor;
        MediaModule mediaModuleRememberedValue;
        int i12;
        State stateCollectAsStateWithLifecycle;
        lb.a constructor2;
        ArrayList arrayList;
        int i13;
        Function2 function7;
        Object objRememberedValue2;
        String ownerId = str;
        Function2 onClick = function2;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(213311529);
        int i14 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onLongClick) ? 2048 : 1024;
        }
        boolean z15 = z10;
        if ((i10 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(z15) ? 16384 : 8192;
        }
        int i15 = i11 & 32;
        if (i15 == 0) {
            if ((196608 & i10) == 0) {
                function4 = function3;
                i14 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
            }
            if ((74899 & i14) != 74898) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i14 & 1)) {
                if (i15 != 0) {
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AudioContentKt.AudioContent$lambda$0$0((MessageAction) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function6 = (Function2) objRememberedValue2;
                } else {
                    function6 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(213311529, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.AudioContent (AudioContent.kt:58)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                if ((i14 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i14 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z12 | z13;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z14 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new AudioContentKt$AudioContent$2$1(onLongClick, onClick);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, onClick, (PointerInputEventHandler) objRememberedValue);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
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
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                mediaModuleRememberedValue = composerStartRestartGroup.rememberedValue();
                if (mediaModuleRememberedValue == Composer.INSTANCE.getEmpty()) {
                    mediaModuleRememberedValue = MediaModule.INSTANCE.getInstance();
                    composerStartRestartGroup.updateRememberedValue(mediaModuleRememberedValue);
                }
                te.p0 actualPlaying = ((MediaModule) mediaModuleRememberedValue).getActualPlaying();
                i12 = 0;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(actualPlaying, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(-661271061);
                List<Attachment> attachments = msg.getAttachments();
                arrayList = new ArrayList();
                for (Object obj : attachments) {
                    if (((Attachment) obj).getContent() instanceof AudioContent) {
                        arrayList.add(obj);
                    }
                }
                for (Object obj2 : arrayList) {
                    int i16 = i12 + 1;
                    if (i12 < 0) {
                        va.w.x();
                    }
                    Attachment attachment = (Attachment) obj2;
                    String userSender = msg.getMessage().getUserSender();
                    String id2 = msg.getMessage().getId();
                    Content content = attachment.getContent();
                    kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.AudioContent");
                    int i17 = i14;
                    Composer composer2 = composerStartRestartGroup;
                    SendOrReceiveAudio(userSender, ownerId, id2, attachment, (AudioContent) content, onClick, AudioContent$lambda$2$1(stateCollectAsStateWithLifecycle), i12, z15, composer2, (i17 & 112) | ((i17 << 9) & 458752) | ((i17 << 12) & 234881024));
                    ownerId = str;
                    onClick = function2;
                    z15 = z10;
                    composerStartRestartGroup = composer2;
                    i12 = i16;
                    i14 = i17;
                }
                i13 = i14;
                composerStartRestartGroup.endReplaceGroup();
                if (le.d0.q0(msg.getMessage().getContent())) {
                    function7 = function6;
                    composerStartRestartGroup.startReplaceGroup(976231221);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(975983283);
                    function7 = function6;
                    TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, function2, onLongClick, 0, function7, composerStartRestartGroup, i13 & 466816, 18);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return AudioContentKt.AudioContent$lambda$3(msg, str, function2, onLongClick, z10, function5, i10, i11, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function4 = function3;
        if ((74899 & i14) != 74898) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i14 & 1)) {
            if (i15 != 0) {
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return AudioContentKt.AudioContent$lambda$0$0((MessageAction) obj3, (String) obj4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function6 = (Function2) objRememberedValue2;
            } else {
                function6 = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(213311529, i14, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.AudioContent (AudioContent.kt:58)");
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            if ((i14 & 7168) == 2048) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((i14 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = z12 | z13;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z14) {
                objRememberedValue = new AudioContentKt$AudioContent$2$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AudioContentKt$AudioContent$2$1(onLongClick, onClick);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(companion4, onClick, (PointerInputEventHandler) objRememberedValue);
            Alignment.Companion companion5 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput2);
            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
            constructor = companion6.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion6.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion6.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion6.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            mediaModuleRememberedValue = composerStartRestartGroup.rememberedValue();
            if (mediaModuleRememberedValue == Composer.INSTANCE.getEmpty()) {
                mediaModuleRememberedValue = MediaModule.INSTANCE.getInstance();
                composerStartRestartGroup.updateRememberedValue(mediaModuleRememberedValue);
            }
            te.p0 actualPlaying2 = ((MediaModule) mediaModuleRememberedValue).getActualPlaying();
            i12 = 0;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(actualPlaying2, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion5.getStart(), composerStartRestartGroup, 0);
            int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            constructor2 = companion6.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion6.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion6.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion6.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion6.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-661271061);
            List<Attachment> attachments2 = msg.getAttachments();
            arrayList = new ArrayList();
            while (r3.hasNext()) {
                if (((Attachment) obj).getContent() instanceof AudioContent) {
                    arrayList.add(obj);
                }
            }
            while (r15.hasNext()) {
                int i18 = i12 + 1;
                if (i12 < 0) {
                    va.w.x();
                }
                Attachment attachment2 = (Attachment) obj2;
                String userSender2 = msg.getMessage().getUserSender();
                String id3 = msg.getMessage().getId();
                Content content2 = attachment2.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.AudioContent");
                int i19 = i14;
                Composer composer3 = composerStartRestartGroup;
                SendOrReceiveAudio(userSender2, ownerId, id3, attachment2, (AudioContent) content2, onClick, AudioContent$lambda$2$1(stateCollectAsStateWithLifecycle), i12, z15, composer3, (i19 & 112) | ((i19 << 9) & 458752) | ((i19 << 12) & 234881024));
                ownerId = str;
                onClick = function2;
                z15 = z10;
                composerStartRestartGroup = composer3;
                i12 = i18;
                i14 = i19;
            }
            i13 = i14;
            composerStartRestartGroup.endReplaceGroup();
            if (le.d0.q0(msg.getMessage().getContent())) {
                composerStartRestartGroup.startReplaceGroup(975983283);
                function7 = function6;
                TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, function2, onLongClick, 0, function7, composerStartRestartGroup, i13 & 466816, 18);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                function7 = function6;
                composerStartRestartGroup.startReplaceGroup(976231221);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return AudioContentKt.AudioContent$lambda$3(msg, str, function2, onLongClick, z10, function5, i10, i11, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AudioContent$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    private static final MediaPlayerData AudioContent$lambda$2$1(State<MediaPlayerData> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AudioContent$lambda$3(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, Function2 function2, Function2 function3, boolean z10, Function2 function4, int i10, int i11, Composer composer, int i12) {
        AudioContent(messageWithPartnerWithReactions, str, function2, function3, z10, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x007a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x0102  */
    /* JADX WARN: Code duplicated, block: B:73:0x010e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0112  */
    /* JADX WARN: Code duplicated, block: B:77:0x0145  */
    /* JADX WARN: Code duplicated, block: B:79:0x0156  */
    /* JADX WARN: Code duplicated, block: B:80:0x018c  */
    /* JADX WARN: Code duplicated, block: B:83:0x01da  */
    /* JADX WARN: Code duplicated, block: B:84:0x0239  */
    /* JADX WARN: Code duplicated, block: B:86:0x0244  */
    /* JADX WARN: Code duplicated, block: B:88:0x024e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0254  */
    /* JADX WARN: Code duplicated, block: B:92:0x0292  */
    /* JADX WARN: Code duplicated, block: B:95:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:97:0x02aa  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AudioShowIn(final boolean z10, final int i10, boolean z11, final Function2 onClick, Composer composer, final int i11, final int i12) {
        int i13;
        boolean z12;
        boolean z13;
        final boolean z14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z15;
        Modifier.Companion companion;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        Object objRememberedValue;
        lb.a constructor;
        int i14;
        float fFloatValue;
        MaterialTheme materialTheme;
        int i15;
        boolean z21;
        int i16;
        Icons.Outlined outlined;
        ImageVector musicNote;
        MediaModule.Companion companion2;
        int i17;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-767703421);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        int i18 = i12 & 4;
        if (i18 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z12 = z11;
                i13 |= composerStartRestartGroup.changed(z12) ? 256 : 128;
            }
            if ((i11 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i17 = 2048;
                } else {
                    i17 = 1024;
                }
                i13 |= i17;
            }
            if ((i13 & 1171) != 1170) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                if (i18 != 0) {
                    z15 = false;
                } else {
                    z15 = z12;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-767703421, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.AudioShowIn (AudioContent.kt:226)");
                }
                companion = Modifier.INSTANCE;
                if ((i13 & 14) == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((i13 & 896) == 256) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                boolean z22 = z16 | z17;
                if ((i13 & 7168) == 2048) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean z23 = z22 | z18;
                if ((i13 & 112) == 32) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                z20 = z23 | z19;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z20 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f
                        @Override // lb.a
                        public final Object invoke() {
                            return AudioContentKt.AudioShowIn$lambda$0$0(z10, z15, onClick, i10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z15) {
                    companion2 = MediaModule.INSTANCE;
                    if (companion2.getInstance().getActualPlayingDuration() > 0.0f) {
                        composerStartRestartGroup.startReplaceGroup(1631335848);
                        i14 = 1;
                        fFloatValue = ((Number) FlowExtKt.collectAsStateWithLifecycle(companion2.getInstance().getActualPlayingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7).getValue()).floatValue() / companion2.getInstance().getActualPlayingDuration();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        i14 = 1;
                        composerStartRestartGroup.startReplaceGroup(-968043775);
                        composerStartRestartGroup.endReplaceGroup();
                        fFloatValue = 0.0f;
                    }
                } else {
                    i14 = 1;
                    composerStartRestartGroup.startReplaceGroup(-968043775);
                    composerStartRestartGroup.endReplaceGroup();
                    fFloatValue = 0.0f;
                }
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, i14, null), Dp.m8823constructorimpl(2));
                materialTheme = MaterialTheme.INSTANCE;
                i15 = MaterialTheme.$stable;
                z21 = z15;
                i16 = i14;
                ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(fFloatValue, modifierM1725padding3ABfNKs, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), 0.0f, 0L, 0, composerStartRestartGroup, 48, 56);
                composerStartRestartGroup = composerStartRestartGroup;
                if (z21) {
                    composerStartRestartGroup.startReplaceGroup(-967776460);
                    p0.e.a(AudioShowIn$lambda$1$0(p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.audio_wave)), null, null, null, null, null, composerStartRestartGroup, 0, 62)), SizeKt.fillMaxSize$default(companion, 0.0f, i16, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composerStartRestartGroup, 1572912, 0, 0, 4194236);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-967391099);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-967342925);
                    outlined = Icons.Outlined.INSTANCE;
                    if (z21) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        musicNote = StopKt.getStop(outlined);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        musicNote = MusicNoteKt.getMusicNote(outlined);
                    }
                    Composer composer2 = composerStartRestartGroup;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), musicNote, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), 0, 2, null), null, "icon audio", 0, null, null, composer2, 196614, 468);
                    composerStartRestartGroup = composer2;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(-967038939);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z21;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AudioContentKt.AudioShowIn$lambda$2(z10, i10, z14, onClick, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z12 = z11;
        if ((i11 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i13 |= i17;
        }
        if ((i13 & 1171) != 1170) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
            if (i18 != 0) {
                z15 = false;
            } else {
                z15 = z12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-767703421, i13, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.AudioShowIn (AudioContent.kt:226)");
            }
            companion = Modifier.INSTANCE;
            if ((i13 & 14) == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((i13 & 896) == 256) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean z24 = z16 | z17;
            if ((i13 & 7168) == 2048) {
                z18 = true;
            } else {
                z18 = false;
            }
            boolean z25 = z24 | z18;
            if ((i13 & 112) == 32) {
                z19 = true;
            } else {
                z19 = false;
            }
            z20 = z25 | z19;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z20) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioContentKt.AudioShowIn$lambda$0$0(z10, z15, onClick, i10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f
                    @Override // lb.a
                    public final Object invoke() {
                        return AudioContentKt.AudioShowIn$lambda$0$0(z10, z15, onClick, i10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default2 = ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default2);
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
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (z15) {
                companion2 = MediaModule.INSTANCE;
                if (companion2.getInstance().getActualPlayingDuration() > 0.0f) {
                    composerStartRestartGroup.startReplaceGroup(1631335848);
                    i14 = 1;
                    fFloatValue = ((Number) FlowExtKt.collectAsStateWithLifecycle(companion2.getInstance().getActualPlayingTime(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 0, 7).getValue()).floatValue() / companion2.getInstance().getActualPlayingDuration();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i14 = 1;
                    composerStartRestartGroup.startReplaceGroup(-968043775);
                    composerStartRestartGroup.endReplaceGroup();
                    fFloatValue = 0.0f;
                }
            } else {
                i14 = 1;
                composerStartRestartGroup.startReplaceGroup(-968043775);
                composerStartRestartGroup.endReplaceGroup();
                fFloatValue = 0.0f;
            }
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, i14, null), Dp.m8823constructorimpl(2));
            materialTheme = MaterialTheme.INSTANCE;
            i15 = MaterialTheme.$stable;
            z21 = z15;
            i16 = i14;
            ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(fFloatValue, modifierM1725padding3ABfNKs2, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), 0.0f, 0L, 0, composerStartRestartGroup, 48, 56);
            composerStartRestartGroup = composerStartRestartGroup;
            if (z21) {
                composerStartRestartGroup.startReplaceGroup(-967776460);
                p0.e.a(AudioShowIn$lambda$1$0(p0.r.q(p0.n.a.a(p0.n.a.b(R.raw.audio_wave)), null, null, null, null, null, composerStartRestartGroup, 0, 62)), SizeKt.fillMaxSize$default(companion, 0.0f, i16, null), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composerStartRestartGroup, 1572912, 0, 0, 4194236);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-967391099);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-967342925);
                outlined = Icons.Outlined.INSTANCE;
                if (z21) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    musicNote = StopKt.getStop(outlined);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    musicNote = MusicNoteKt.getMusicNote(outlined);
                }
                Composer composer3 = composerStartRestartGroup;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(30)), musicNote, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), 0, 2, null), null, "icon audio", 0, null, null, composer3, 196614, 468);
                composerStartRestartGroup = composer3;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(-967038939);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z14 = z21;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z14 = z12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioContentKt.AudioShowIn$lambda$2(z10, i10, z14, onClick, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AudioShowIn$lambda$0$0(boolean z10, boolean z11, Function2 function2, int i10) {
        if (!z10) {
            function2.invoke(MessageAction.REGULAR_CLICK, 0);
        } else if (z11) {
            function2.invoke(MessageAction.STOP_AUDIO_FILE, Integer.valueOf(i10));
        } else {
            function2.invoke(MessageAction.PLAY_AUDIO_FILE, Integer.valueOf(i10));
        }
        return ua.k0.f43947a;
    }

    private static final l0.j AudioShowIn$lambda$1$0(p0.l lVar) {
        return (l0.j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 AudioShowIn$lambda$2(boolean z10, int i10, boolean z11, Function2 function2, int i11, int i12, Composer composer, int i13) {
        AudioShowIn(z10, i10, z11, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendOrReceiveAudio(final String senderId, final String ownerId, final String msgId, final Attachment attachment, final AudioContent content, final Function2 onClick, final MediaPlayerData mediaPlayerData, final int i10, final boolean z10, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        kotlin.jvm.internal.y.i(senderId, "senderId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(content, "content");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1093694429);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(senderId) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(attachment) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(mediaPlayerData) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 8388608 : 4194304;
        }
        if ((100663296 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i12) != 38347922, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1093694429, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveAudio (AudioContent.kt:113)");
            }
            int i13 = i12;
            if (!kotlin.jvm.internal.y.d(senderId, ownerId) || attachment.getState() == 4 || attachment.getState() == 5) {
                composerStartRestartGroup.startReplaceGroup(630863337);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f10 = 5;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth(SizeKt.m1755height3ABfNKs(companion, Dp.m8823constructorimpl(80)), 0.7f), 0.0f, Dp.m8823constructorimpl(f10), 1, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Horizontal start = arrangement.getStart();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composerStartRestartGroup, 0);
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(AspectRatioKt.aspectRatio$default(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(70)), 1.0f, false, 2, null), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10114getOrange10d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                PathsVolatileState.Companion companion4 = PathsVolatileState.INSTANCE;
                DownloadableKt.Downloadable(modifierM1204backgroundbw27NRU, companion4.getInstance().autoDownloadAudios(), DownloadableSize.MINI, attachment.getId(), content.getFolderPath(companion4.getInstance().publicAudios() && !z10).getSecond(), 3, content, null, false, null, ComposableLambdaKt.rememberComposableLambda(-277793731, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.b
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return AudioContentKt.SendOrReceiveAudio$lambda$1$0(mediaPlayerData, content, i10, onClick, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (3670016 & (i13 << 6)) | 196992, 6, 896);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion2.getStart(), composerStartRestartGroup, 6);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, content.getName(), null, 0L, 2, 0, composer2, 24576, 45);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.humanDuration(content.getDuration() * ((long) 1000)), MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), 0L, 0, 0, composer2, 0, 57);
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(629313337);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                float f11 = 5;
                Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth(SizeKt.m1755height3ABfNKs(companion5, Dp.m8823constructorimpl(80)), 0.7f), 0.0f, Dp.m8823constructorimpl(f11), 1, null);
                Arrangement arrangement2 = Arrangement.INSTANCE;
                Arrangement.Horizontal start2 = arrangement2.getStart();
                Alignment.Companion companion6 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, companion6.getTop(), composerStartRestartGroup, 0);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default2);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                lb.a constructor3 = companion7.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion7.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(AspectRatioKt.aspectRatio$default(SizeKt.m1774width3ABfNKs(companion5, Dp.m8823constructorimpl(70)), 1.0f, false, 2, null), Color.m5865copywmQWz5c$default(Other.INSTANCE.m10114getOrange10d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                UploadableSize uploadableSize = UploadableSize.REGULAR;
                String id2 = attachment.getId();
                Content content2 = attachment.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.AudioContent");
                UploadableKt.Uploadable(modifierM1204backgroundbw27NRU2, true, uploadableSize, msgId, id2, 3, (AudioContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(1387640589, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.a
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return AudioContentKt.SendOrReceiveAudio$lambda$0$0(mediaPlayerData, content, i10, onClick, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 197040 | ((i13 << 3) & 7168), 6, 896);
                Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null), Dp.m8823constructorimpl(f11));
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getCenter(), companion6.getStart(), composerStartRestartGroup, 6);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs2);
                lb.a constructor4 = companion7.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                composer2 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, content.getName(), null, 0L, 2, 0, composer2, 24576, 45);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.humanDuration(content.getDuration() * ((long) 1000)), MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), 0L, 0, 0, composer2, 0, 57);
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioContentKt.SendOrReceiveAudio$lambda$2(senderId, ownerId, msgId, attachment, content, onClick, mediaPlayerData, i10, z10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveAudio$lambda$0$0(MediaPlayerData mediaPlayerData, AudioContent audioContent, int i10, Function2 function2, Object unused$var$, boolean z10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1387640589, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveAudio.<anonymous>.<anonymous> (AudioContent.kt:138)");
        }
        AudioShowIn(z10, i10, kotlin.jvm.internal.y.d(mediaPlayerData != null ? mediaPlayerData.getMediaId() : null, audioContent.getUrl()), function2, composer, (i11 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveAudio$lambda$1$0(MediaPlayerData mediaPlayerData, AudioContent audioContent, int i10, Function2 function2, Object unused$var$, boolean z10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-277793731, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveAudio.<anonymous>.<anonymous> (AudioContent.kt:192)");
        }
        AudioShowIn(z10, i10, kotlin.jvm.internal.y.d(mediaPlayerData != null ? mediaPlayerData.getMediaId() : null, audioContent.getUrl()), function2, composer, (i11 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SendOrReceiveAudio$lambda$2(String str, String str2, String str3, Attachment attachment, AudioContent audioContent, Function2 function2, MediaPlayerData mediaPlayerData, int i10, boolean z10, int i11, Composer composer, int i12) {
        SendOrReceiveAudio(str, str2, str3, attachment, audioContent, function2, mediaPlayerData, i10, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }
}
