package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

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
import androidx.compose.ui.layout.ContentScale;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableKt;
import cu.todus.android.uiCompose.shared.downloadable.DownloadableSize;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.uiCompose.shared.uploadable.UploadableSize;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.zoomables.ZoomModifierKt;
import cu.z17.views.zoomables.ZoomStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a)\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "", "fromOwner", "", Room.COLUMN_LAST_MSG, "isSecret", "Lua/k0;", "ImagePreview", "(Lcu/todus/android/data/db/entity/toDus/Attachment;ZLjava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "fileExist", "Landroid/net/Uri;", "uri", "Lcu/todus/android/data/db/pojo/content/ImageContent;", "content", "PreviewZoomableImageShowIn", "(ZLandroid/net/Uri;Lcu/todus/android/data/db/pojo/content/ImageContent;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ImagePreviewKt {
    @Composable
    public static final void ImagePreview(final Attachment attachment, final boolean z10, final String msgId, final boolean z11, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(attachment, "attachment");
        kotlin.jvm.internal.y.i(msgId, "msgId");
        Composer composerStartRestartGroup = composer.startRestartGroup(683101482);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(attachment) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(msgId) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(683101482, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ImagePreview (ImagePreview.kt:26)");
            }
            if (!z10 || attachment.getState() == 4 || attachment.getState() == 5) {
                composerStartRestartGroup.startReplaceGroup(722024308);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                DownloadableSize downloadableSize = DownloadableSize.BIG;
                String id2 = attachment.getId();
                Content content = attachment.getContent();
                kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ImageContent");
                DownloadableKt.Downloadable(modifierFillMaxSize$default, false, downloadableSize, id2, ((ImageContent) content).getFolderPath(!z11).getSecond(), 1, (ImageContent) attachment.getContent(), null, false, null, ComposableLambdaKt.rememberComposableLambda(619759982, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.d0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return ImagePreviewKt.ImagePreview$lambda$1(attachment, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 197046, 6, 896);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(721456853);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                UploadableSize uploadableSize = UploadableSize.BIG;
                String id3 = attachment.getId();
                Content content2 = attachment.getContent();
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ImageContent");
                UploadableKt.Uploadable(modifierFillMaxSize$default2, true, uploadableSize, msgId, id3, 1, (ImageContent) content2, null, false, null, ComposableLambdaKt.rememberComposableLambda(-669387906, true, new lb.o() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.c0
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return ImagePreviewKt.ImagePreview$lambda$0(attachment, obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 << 3) & 7168) | 197046, 6, 896);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagePreviewKt.ImagePreview$lambda$2(attachment, z10, msgId, z11, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 ImagePreview$lambda$0(Attachment attachment, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669387906, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ImagePreview.<anonymous> (ImagePreview.kt:39)");
        }
        PreviewZoomableImageShowIn(z10, Uri.parse(((ImageContent) attachment.getContent()).getPath()), (ImageContent) attachment.getContent(), composer, (i10 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final ua.k0 ImagePreview$lambda$1(Attachment attachment, Object unused$var$, boolean z10, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(unused$var$, "$unused$var$");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(619759982, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.ImagePreview.<anonymous> (ImagePreview.kt:57)");
        }
        PreviewZoomableImageShowIn(z10 && !le.d0.q0(((ImageContent) attachment.getContent()).getPath()), Uri.parse(((ImageContent) attachment.getContent()).getPath()), (ImageContent) attachment.getContent(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ImagePreview$lambda$2(Attachment attachment, boolean z10, String str, boolean z11, int i10, Composer composer, int i11) {
        ImagePreview(attachment, z10, str, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @Composable
    public static final void PreviewZoomableImageShowIn(final boolean z10, final Uri uri, final ImageContent content, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-841013935);
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
                ComposerKt.traceEventStart(-841013935, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.PreviewZoomableImageShowIn (ImagePreview.kt:71)");
            }
            if (!z10 || uri == null) {
                composerStartRestartGroup.startReplaceGroup(-2101408541);
                if (URLUtil.isHttpsUrl(content.getThumbnail())) {
                    composerStartRestartGroup.startReplaceGroup(-2101111127);
                    composer2 = composerStartRestartGroup;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), content.getThumbnail(), null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composer2, 24582, 492);
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2101350819);
                    composer2 = composerStartRestartGroup;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, content.getThumbnail(), composer2, 24630, WebmConstants.MkvEbmlElement.VOID);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2101745232);
                composer2 = composerStartRestartGroup;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(ZoomModifierKt.zoom$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), (Object) null, ZoomStateKt.rememberZoomState(0.0f, 0.0f, 0.0f, 0.0f, false, false, false, true, (Object) null, composer2, 14155776, 319), true, 1, (Object) null), uri, null, null, ContentScale.INSTANCE.getFit(), null, 0, null, null, composerStartRestartGroup, (i11 & 112) | 24576, 492);
                composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.attachmentPreview.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagePreviewKt.PreviewZoomableImageShowIn$lambda$0(z10, uri, content, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PreviewZoomableImageShowIn$lambda$0(boolean z10, Uri uri, ImageContent imageContent, int i10, Composer composer, int i11) {
        PreviewZoomableImageShowIn(z10, uri, imageContent, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
