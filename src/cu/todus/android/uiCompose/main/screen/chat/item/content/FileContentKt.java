package cu.todus.android.uiCompose.main.screen.chat.item.content;

import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AttachFileKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\r\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a{\u0010\u0016\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a]\u0010\u001b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "ownerId", "", "isSecret", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "onMsgEntityClick", "FileContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "senderId", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lcu/todus/android/data/db/pojo/content/FileContent;", "content", "index", "SendOrReceiveFile", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Attachment;Lcu/todus/android/data/db/pojo/content/FileContent;ZILandroidx/compose/runtime/Composer;I)V", "fileExist", "Landroid/net/Uri;", "uri", "FileShowIn", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroid/net/Uri;ILandroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileContentKt {
    /* JADX WARN: Code duplicated, block: B:100:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x0107  */
    /* JADX WARN: Code duplicated, block: B:71:0x0113  */
    /* JADX WARN: Code duplicated, block: B:72:0x0117  */
    /* JADX WARN: Code duplicated, block: B:76:0x0160  */
    /* JADX WARN: Code duplicated, block: B:82:0x017e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0186  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:89:0x020b  */
    /* JADX WARN: Code duplicated, block: B:92:0x021e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0223  */
    /* JADX WARN: Code duplicated, block: B:97:0x022d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FileContent(final MessageWithPartnerWithReactions msg, final String str, final boolean z10, final Function2 function2, final Function2 function3, Function2 function4, Composer composer, final int i10, final int i11) {
        boolean z11;
        Function2 function5;
        int i12;
        boolean z12;
        final Function2 function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 function7;
        lb.a constructor;
        ArrayList arrayList;
        int i13;
        Function2 function8;
        Object objRememberedValue;
        String ownerId = str;
        Function2 onClick = function2;
        Function2 onLongClick = function3;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-456690425);
        int i14 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(msg) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            z11 = z10;
            i14 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        } else {
            z11 = z10;
        }
        if ((i10 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onLongClick) ? 16384 : 8192;
        }
        int i15 = i11 & 32;
        if (i15 == 0) {
            if ((196608 & i10) == 0) {
                function5 = function4;
                i14 |= composerStartRestartGroup.changedInstance(function5) ? 131072 : 65536;
            }
            i12 = i14;
            if ((74899 & i12) != 74898) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.b0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FileContentKt.FileContent$lambda$0$0((MessageAction) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function7 = (Function2) objRememberedValue;
                } else {
                    function7 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-456690425, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.FileContent (FileContent.kt:45)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(-1003403859);
                List<Attachment> attachments = msg.getAttachments();
                arrayList = new ArrayList();
                for (Object obj : attachments) {
                    if (((Attachment) obj).getContent() instanceof FileContent) {
                        arrayList.add(obj);
                    }
                }
                i13 = 0;
                for (Object obj2 : arrayList) {
                    int i16 = i13 + 1;
                    if (i13 < 0) {
                        va.w.x();
                    }
                    Attachment attachment = (Attachment) obj2;
                    String userSender = msg.getMessage().getUserSender();
                    String id2 = msg.getMessage().getId();
                    Content content = attachment.getContent();
                    kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                    Composer composer2 = composerStartRestartGroup;
                    SendOrReceiveFile(onClick, onLongClick, userSender, ownerId, id2, attachment, (FileContent) content, z11, i13, composer2, ((i12 << 15) & 29360128) | ((i12 << 6) & 7168) | ((i12 >> 9) & 126));
                    ownerId = str;
                    z11 = z10;
                    onClick = function2;
                    onLongClick = function3;
                    composerStartRestartGroup = composer2;
                    i13 = i16;
                }
                composerStartRestartGroup.endReplaceGroup();
                if (le.d0.q0(msg.getMessage().getContent())) {
                    function8 = function7;
                    composerStartRestartGroup.startReplaceGroup(-1040046095);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1040267125);
                    function8 = function7;
                    TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, function2, function3, 0, function8, composerStartRestartGroup, ((i12 >> 3) & 8064) | (458752 & i12), 18);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FileContentKt.FileContent$lambda$2(msg, str, z10, function2, function3, function6, i10, i11, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function4;
        i12 = i14;
        if ((74899 & i12) != 74898) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i15 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return FileContentKt.FileContent$lambda$0$0((MessageAction) obj3, (String) obj4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function7 = (Function2) objRememberedValue;
            } else {
                function7 = function5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-456690425, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.FileContent (FileContent.kt:45)");
            }
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
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
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-1003403859);
            List<Attachment> attachments2 = msg.getAttachments();
            arrayList = new ArrayList();
            while (r5.hasNext()) {
                if (((Attachment) obj).getContent() instanceof FileContent) {
                    arrayList.add(obj);
                }
            }
            i13 = 0;
            while (r15.hasNext()) {
                int i17 = i13 + 1;
                if (i13 < 0) {
                    va.w.x();
                }
                Attachment attachment2 = (Attachment) obj2;
                String userSender2 = msg.getMessage().getUserSender();
                String id3 = msg.getMessage().getId();
                Content content2 = attachment2.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                Composer composer3 = composerStartRestartGroup;
                SendOrReceiveFile(onClick, onLongClick, userSender2, ownerId, id3, attachment2, (FileContent) content2, z11, i13, composer3, ((i12 << 15) & 29360128) | ((i12 << 6) & 7168) | ((i12 >> 9) & 126));
                ownerId = str;
                z11 = z10;
                onClick = function2;
                onLongClick = function3;
                composerStartRestartGroup = composer3;
                i13 = i17;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (le.d0.q0(msg.getMessage().getContent())) {
                composerStartRestartGroup.startReplaceGroup(-1040267125);
                function8 = function7;
                TextContentKt.m9893TextContentOadGlvw(msg.getMessage().getContent(), 0L, function2, function3, 0, function8, composerStartRestartGroup, ((i12 >> 3) & 8064) | (458752 & i12), 18);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                function8 = function7;
                composerStartRestartGroup.startReplaceGroup(-1040046095);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function6 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return FileContentKt.FileContent$lambda$2(msg, str, z10, function2, function3, function6, i10, i11, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FileContent$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FileContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, boolean z10, Function2 function2, Function2 function3, Function2 function4, int i10, int i11, Composer composer, int i12) {
        FileContent(messageWithPartnerWithReactions, str, z10, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @Composable
    public static final void FileShowIn(final Function2 onClick, final Function2 onLongClick, final boolean z10, final Uri uri, final int i10, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1049545983);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(uri) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1049545983, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.FileShowIn (FileContent.kt:221)");
            }
            if (!z10 || uri == null) {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-336565149);
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-337304344);
                ImageVector attachFile = AttachFileKt.getAttachFile(Icons.Outlined.INSTANCE);
                Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30));
                boolean z11 = ((i12 & 14) == 4) | ((i12 & 112) == 32) | ((i12 & 57344) == 16384);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FileContentKt$FileShowIn$1$1(onLongClick, onClick, i10);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SuspendingPointerInputFilterKt.pointerInput(modifierM1769size3ABfNKs, onClick, (PointerInputEventHandler) objRememberedValue), attachFile, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "icon file", 0, null, null, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 468);
                composer2 = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileContentKt.FileShowIn$lambda$1(onClick, onLongClick, z10, uri, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 FileShowIn$lambda$1(Function2 function2, Function2 function3, boolean z10, Uri uri, int i10, int i11, Composer composer, int i12) {
        FileShowIn(function2, function3, z10, uri, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SendOrReceiveFile(final Function2 function2, final Function2 onLongClick, final String senderId, final String ownerId, final String msgId, final Attachment attachment, final FileContent content, final boolean z10, final int i10, Composer composer, final int i11) {
        int i12;
        Composer composer2;
        final Function2 onClick = function2;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        kotlin.jvm.internal.y.i(senderId, "senderId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1833985604);
        if ((i11 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onLongClick) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(senderId) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(ownerId) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(msgId) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(attachment) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(content) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 8388608 : 4194304;
        }
        if ((100663296 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i12) != 38347922, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1833985604, i12, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveFile (FileContent.kt:83)");
            }
            int i13 = i12;
            if (!kotlin.jvm.internal.y.d(senderId, ownerId) || attachment.getState() == 4 || attachment.getState() == 5) {
                composerStartRestartGroup.startReplaceGroup(-1523491816);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f10 = 75;
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth(companion, 0.6f), Dp.m8823constructorimpl(f10)), 0.0f, Dp.m8823constructorimpl(5), 1, null);
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
                float f11 = 10;
                Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1774width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(f10)), 0.0f, 0.0f, Dp.m8823constructorimpl(f11), 0.0f, 11, null);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i14 = MaterialTheme.$stable;
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i14).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11)));
                PathsVolatileState.Companion companion4 = PathsVolatileState.INSTANCE;
                onClick = function2;
                DownloadableKt.Downloadable(modifierM1204backgroundbw27NRU, companion4.getInstance().autoDownloadFiles(), DownloadableSize.MINI, attachment.getId(), content.getFolderPath(companion4.getInstance().publicFiles() && !z10).getSecond(), 5, content, null, true, null, ComposableLambdaKt.rememberComposableLambda(2070080860, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.e0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return FileContentKt.SendOrReceiveFile$lambda$1$0(onClick, onLongClick, content, i10, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 3670016) | 100860288, 6, 640);
                composer2 = composerStartRestartGroup;
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null);
                boolean z11 = (i13 & 112) == 32;
                Object objRememberedValue = composer2.rememberedValue();
                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FileContentKt$SendOrReceiveFile$2$2$1(onLongClick);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxHeight$default, onClick, (PointerInputEventHandler) objRememberedValue);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion2.getStart(), composer2, 6);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierPointerInput);
                lb.a constructor2 = companion3.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion3.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion3.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, content.getName(), null, 0L, 2, 0, composer2, 24576, 45);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.convertToByteSize(content.getSize()), materialTheme.getTypography(composer2, i14).getLabelSmall(), 0L, 0, 0, composer2, 0, 57);
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(14301276);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                float f12 = 75;
                Modifier modifierM1727paddingVpY3zN4$default2 = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth(companion5, 0.6f), Dp.m8823constructorimpl(f12)), 0.0f, Dp.m8823constructorimpl(5), 1, null);
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
                float f13 = 10;
                Modifier modifierM1729paddingqDBjuR0$default2 = PaddingKt.m1729paddingqDBjuR0$default(SizeKt.m1774width3ABfNKs(SizeKt.fillMaxHeight$default(companion5, 0.0f, 1, null), Dp.m8823constructorimpl(f12)), 0.0f, 0.0f, Dp.m8823constructorimpl(f13), 0.0f, 11, null);
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i15 = MaterialTheme.$stable;
                Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(modifierM1729paddingqDBjuR0$default2, Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i15).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f13)));
                UploadableSize uploadableSize = UploadableSize.MINI;
                String id2 = attachment.getId();
                Content content2 = attachment.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.FileContent");
                UploadableKt.Uploadable(modifierM1204backgroundbw27NRU2, true, uploadableSize, msgId, id2, 5, (FileContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(-1274478452, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.d0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return FileContentKt.SendOrReceiveFile$lambda$0$0(function2, onLongClick, content, i10, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 7168) | 197040, 6, 896);
                composer2 = composerStartRestartGroup;
                Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(companion5, 0.0f, 1, null);
                boolean z12 = (i13 & 112) == 32;
                Object objRememberedValue2 = composer2.rememberedValue();
                if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FileContentKt$SendOrReceiveFile$1$2$1(onLongClick);
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxHeight$default2, function2, (PointerInputEventHandler) objRememberedValue2);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getCenter(), companion6.getStart(), composer2, 6);
                int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierPointerInput2);
                lb.a constructor4 = companion7.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyColumnMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion7.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion7.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, content.getName(), null, 0L, 2, 0, composer2, 24576, 45);
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.convertToByteSize(content.getSize()), materialTheme2.getTypography(composer2, i15).getLabelSmall(), 0L, 0, 0, composer2, 0, 57);
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
                onClick = function2;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileContentKt.SendOrReceiveFile$lambda$2(onClick, onLongClick, senderId, ownerId, msgId, attachment, content, z10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveFile$lambda$0$0(Function2 function2, Function2 function3, FileContent fileContent, int i10, Object unused$var$, boolean z10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1274478452, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveFile.<anonymous>.<anonymous> (FileContent.kt:114)");
        }
        FileShowIn(function2, function3, z10, Uri.parse(fileContent.getPath()), i10, composer, (i11 << 3) & 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveFile$lambda$1$0(Function2 function2, Function2 function3, FileContent fileContent, int i10, Object unused$var$, boolean z10, Composer composer, int i11) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2070080860, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveFile.<anonymous>.<anonymous> (FileContent.kt:180)");
        }
        FileShowIn(function2, function3, z10, Uri.parse(fileContent.getPath()), i10, composer, (i11 << 3) & 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SendOrReceiveFile$lambda$2(Function2 function2, Function2 function3, String str, String str2, String str3, Attachment attachment, FileContent fileContent, boolean z10, int i10, int i11, Composer composer, int i12) {
        SendOrReceiveFile(function2, function3, str, str2, str3, attachment, fileContent, z10, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1));
        return ua.k0.f43947a;
    }
}
