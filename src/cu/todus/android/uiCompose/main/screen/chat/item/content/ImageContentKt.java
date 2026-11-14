package cu.todus.android.uiCompose.main.screen.chat.item.content;

import android.net.Uri;
import android.webkit.URLUtil;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\n2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u008b\u0001\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "ownerId", "Lkotlin/Function2;", "Lcu/todus/android/uiCompose/main/screen/chat/item/MessageAction;", "", "Lua/k0;", "onClick", "onLongClick", "", "isSecret", "onMsgEntityClick", "ImageContent", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "senderId", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lcu/todus/android/data/db/pojo/content/ImageContent;", "content", "index", "Landroidx/compose/ui/unit/Dp;", "width", "height", "SendOrReceiveImage-dqcolps", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Attachment;Lcu/todus/android/data/db/pojo/content/ImageContent;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IFFZLandroidx/compose/runtime/Composer;II)V", "SendOrReceiveImage", "fileExist", "Landroid/net/Uri;", "uri", "ImageShowIn", "(ZLandroid/net/Uri;Lcu/todus/android/data/db/pojo/content/ImageContent;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ImageContentKt {
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v17 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    public static final void ImageContent(cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions r50, java.lang.String r51, kotlin.jvm.functions.Function2 r52, kotlin.jvm.functions.Function2 r53, boolean r54, kotlin.jvm.functions.Function2 r55, androidx.compose.runtime.Composer r56, int r57, int r58) {
        /*
            Method dump skipped, instruction units count: 1563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.item.content.ImageContentKt.ImageContent(cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageContent$lambda$0$0(MessageAction messageAction, String str) {
        kotlin.jvm.internal.y.i(messageAction, "<unused var>");
        kotlin.jvm.internal.y.i(str, "<unused var>");
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageContent$lambda$2(MessageWithPartnerWithReactions messageWithPartnerWithReactions, String str, Function2 function2, Function2 function3, boolean z10, Function2 function4, int i10, int i11, Composer composer, int i12) {
        ImageContent(messageWithPartnerWithReactions, str, function2, function3, z10, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @Composable
    public static final void ImageShowIn(final boolean z10, final Uri uri, final ImageContent content, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(236179588);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(uri) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(236179588, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.ImageShowIn (ImageContent.kt:215)");
            }
            if (!z10 || uri == null) {
                composerStartRestartGroup.startReplaceGroup(869950821);
                if (URLUtil.isHttpsUrl(content.getThumbnail())) {
                    composerStartRestartGroup.startReplaceGroup(870248235);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), content.getThumbnail(), null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composerStartRestartGroup, 24582, 492);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(870009194);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, content.getThumbnail(), composerStartRestartGroup, 24630, WebmConstants.MkvEbmlElement.VOID);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(869808903);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), uri, null, null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, (i11 & 112) | 24582, 492);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageContentKt.ImageShowIn$lambda$0(z10, uri, content, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImageShowIn$lambda$0(boolean z10, Uri uri, ImageContent imageContent, int i10, Composer composer, int i11) {
        ImageShowIn(z10, uri, imageContent, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:146:0x02c2  */
    @Composable
    /* JADX INFO: renamed from: SendOrReceiveImage-dqcolps, reason: not valid java name */
    public static final void m9891SendOrReceiveImagedqcolps(final String senderId, final String ownerId, final String msgId, final Attachment attachment, final ImageContent content, final Function2 onClick, Function2 onLongClick, final int i10, final float f10, float f11, final boolean z10, Composer composer, final int i11, final int i12) {
        int i13;
        int i14;
        Function2 function2;
        int i15;
        Function2 function3;
        float f12 = f11;
        kotlin.jvm.internal.y.i(senderId, "senderId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(content, "content");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(onLongClick, "onLongClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125670879);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(senderId) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(ownerId) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(attachment) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClick) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onLongClick) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 8388608 : 4194304;
        }
        if ((100663296 & i11) == 0) {
            i13 |= composerStartRestartGroup.changed(f10) ? 67108864 : 33554432;
        }
        if ((805306368 & i11) == 0) {
            i13 |= composerStartRestartGroup.changed(f12) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i12 & 6) == 0) {
            i14 = i12 | (composerStartRestartGroup.changed(z10) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if (composerStartRestartGroup.shouldExecute(((i13 & 306783379) == 306783378 && (i14 & 3) == 2) ? false : true, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125670879, i13, i14, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveImage (ImageContent.kt:149)");
            }
            if (kotlin.jvm.internal.y.d(senderId, ownerId)) {
                i15 = 29360128;
                if (attachment.getState() != 4 && attachment.getState() != 5) {
                    composerStartRestartGroup.startReplaceGroup(243953742);
                    Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, Dp.m8823constructorimpl(2), null, false, 0L, 0L, 30, null), f10), f12);
                    boolean z11 = ((i13 & 3670016) == 1048576) | ((i13 & 458752) == 131072) | ((i13 & 29360128) == 8388608);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ImageContentKt$SendOrReceiveImage$1$1(onLongClick, onClick, i10);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM1755height3ABfNKs, onClick, (PointerInputEventHandler) objRememberedValue);
                    UploadableSize uploadableSize = UploadableSize.REGULAR;
                    String id2 = attachment.getId();
                    Content content2 = attachment.getContent();
                    kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ImageContent");
                    function2 = onLongClick;
                    f12 = f12;
                    UploadableKt.Uploadable(modifierPointerInput, true, uploadableSize, msgId, id2, 1, (ImageContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(1857718645, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.q0
                        @Override // lb.o
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return ImageContentKt.SendOrReceiveImage_dqcolps$lambda$1(content, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 << 3) & 7168) | 197040, 6, 896);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                i15 = 29360128;
            }
            composerStartRestartGroup.startReplaceGroup(244857299);
            Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(SizeKt.m1774width3ABfNKs(ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, Dp.m8823constructorimpl(2), null, false, 0L, 0L, 30, null), f10), f12);
            boolean z12 = ((i13 & 3670016) == 1048576) | ((i13 & 458752) == 131072) | ((i13 & i15) == 8388608);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                function3 = onClick;
                objRememberedValue2 = new ImageContentKt$SendOrReceiveImage$3$1(onLongClick, function3, i10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function3 = onClick;
            }
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierM1755height3ABfNKs2, function3, (PointerInputEventHandler) objRememberedValue2);
            PathsVolatileState.Companion companion = PathsVolatileState.INSTANCE;
            DownloadableKt.Downloadable(modifierPointerInput2, companion.getInstance().autoDownloadImages(), DownloadableSize.REGULAR, attachment.getId(), content.getFolderPath(companion.getInstance().publicImages() && !z10).getSecond(), 1, content, null, false, null, ComposableLambdaKt.rememberComposableLambda(-1405222043, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.r0
                @Override // lb.o
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ImageContentKt.SendOrReceiveImage_dqcolps$lambda$3(content, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 << 6) & 3670016) | 196992, 6, 896);
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function2 = onLongClick;
            f12 = f12;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f13 = f12;
            final Function2 function4 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageContentKt.SendOrReceiveImage_dqcolps$lambda$4(senderId, ownerId, msgId, attachment, content, onClick, function4, i10, f10, f13, z10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveImage_dqcolps$lambda$1(ImageContent imageContent, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1857718645, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveImage.<anonymous> (ImageContent.kt:172)");
        }
        ImageShowIn(true, Uri.parse(imageContent.getPath()), imageContent, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 SendOrReceiveImage_dqcolps$lambda$3(ImageContent imageContent, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1405222043, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.item.content.SendOrReceiveImage.<anonymous> (ImageContent.kt:201)");
        }
        ImageShowIn(z10 && !le.d0.q0(imageContent.getPath()), Uri.parse(imageContent.getPath()), imageContent, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 SendOrReceiveImage_dqcolps$lambda$4(String str, String str2, String str3, Attachment attachment, ImageContent imageContent, Function2 function2, Function2 function3, int i10, float f10, float f11, boolean z10, int i11, int i12, Composer composer, int i13) {
        m9891SendOrReceiveImagedqcolps(str, str2, str3, attachment, imageContent, function2, function3, i10, f10, f11, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), RecomposeScopeImplKt.updateChangedFlags(i12));
        return ua.k0.f43947a;
    }
}
