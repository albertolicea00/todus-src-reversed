package cu.z17.views.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.EditedMediaItemSequence;
import androidx.media3.transformer.Effects;
import androidx.media3.transformer.ExportException;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import androidx.media3.transformer.c3;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import pe.n0;
import re.u;
import re.w;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J;\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 ¨\u0006\"²\u0006\f\u0010!\u001a\u00020\u00048\nX\u008a\u0084\u0002"}, d2 = {"Lcu/z17/views/utils/VideoUtils;", "", "<init>", "()V", "Landroid/graphics/Bitmap;", "bitmap", "Ljava/io/File;", ExtensionFile.ELEMENT, "", "size", "generateImageThumbnail", "(Landroid/graphics/Bitmap;Ljava/io/File;F)Landroid/graphics/Bitmap;", "", "imageFile", "", "getCameraPhotoOrientation", "(Ljava/lang/String;)I", "path", "", "time", "getThumbnailOnTime", "(Ljava/lang/String;JFLab/e;)Ljava/lang/Object;", "Landroid/net/Uri;", NewEntity.NEWS_CONFIG_SOURCE, "Landroid/content/Context;", "context", "videoPathToSave", "startMilliseconds", "endMilliseconds", "Lte/h;", "", "saveVideo", "(Landroid/net/Uri;Landroid/content/Context;Ljava/lang/String;JJ)Lte/h;", "bitmapCompressed", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoUtils {
    public static final int $stable = 0;
    public static final VideoUtils INSTANCE = new VideoUtils();

    /* JADX INFO: renamed from: cu.z17.views.utils.VideoUtils$getThumbnailOnTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.VideoUtils$getThumbnailOnTime$2", f = "VideoUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ String $path;
        final /* synthetic */ float $size;
        final /* synthetic */ long $time;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, long j10, float f10, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$path = str;
            this.$time = j10;
            this.$size = f10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass2(this.$path, this.$time, this.$size, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.$path);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.$time, 2);
                if (frameAtTime == null) {
                    return null;
                }
                mediaMetadataRetriever.release();
                return VideoUtils.INSTANCE.generateImageThumbnail(frameAtTime, new File(this.$path), this.$size);
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super Bitmap> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.utils.VideoUtils$saveVideo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.utils.VideoUtils$saveVideo$1", f = "VideoUtils.kt", l = {195}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $endMilliseconds;
        final /* synthetic */ Uri $source;
        final /* synthetic */ long $startMilliseconds;
        final /* synthetic */ String $videoPathToSave;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Uri uri, long j10, long j11, String str, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$context = context;
            this.$source = uri;
            this.$startMilliseconds = j10;
            this.$endMilliseconds = j11;
            this.$videoPathToSave = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(u uVar) {
            w.a.a(uVar.getChannel(), null, 1, null);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$source, this.$startMilliseconds, this.$endMilliseconds, this.$videoPathToSave, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final u uVar = (u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                final m0 m0VarA = n0.a(d1.b());
                Transformer transformerBuild = new Transformer.Builder(this.$context).addListener(new Transformer.Listener() { // from class: cu.z17.views.utils.VideoUtils$saveVideo$1$transformer$1
                    @Override // androidx.media3.transformer.Transformer.Listener
                    public void onCompleted(Composition composition, ExportResult exportResult) {
                        y.i(composition, "composition");
                        y.i(exportResult, "exportResult");
                        pe.k.d(m0VarA, null, null, new VideoUtils$saveVideo$1$transformer$1$onCompleted$1(uVar, null), 3, null);
                    }

                    @Override // androidx.media3.transformer.Transformer.Listener
                    public void onError(Composition composition, ExportResult exportResult, ExportException exportException) {
                        y.i(composition, "composition");
                        y.i(exportResult, "exportResult");
                        y.i(exportException, "exportException");
                        pe.k.d(m0VarA, null, null, new VideoUtils$saveVideo$1$transformer$1$onError$1(uVar, null), 3, null);
                    }

                    @Override // androidx.media3.transformer.Transformer.Listener
                    public /* synthetic */ void onFallbackApplied(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2) {
                        c3.c(this, composition, transformationRequest, transformationRequest2);
                    }
                }).build();
                y.h(transformerBuild, "build(...)");
                MediaItem mediaItemBuild = new MediaItem.Builder().setUri(this.$source).setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(this.$startMilliseconds).setEndPositionMs(this.$endMilliseconds).build()).build();
                y.h(mediaItemBuild, "build(...)");
                EditedMediaItem editedMediaItemBuild = new EditedMediaItem.Builder(mediaItemBuild).setFrameRate(30).setEffects(new Effects(va.w.n(), va.w.n())).build();
                y.h(editedMediaItemBuild, "build(...)");
                Composition compositionBuild = new Composition.Builder((List<EditedMediaItemSequence>) va.v.e(new EditedMediaItemSequence(va.v.e(editedMediaItemBuild)))).build();
                y.h(compositionBuild, "build(...)");
                transformerBuild.start(compositionBuild, this.$videoPathToSave);
                lb.a aVar = new lb.a() { // from class: cu.z17.views.utils.d
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.L$1 = cb.l.a(m0VarA);
                this.L$2 = cb.l.a(transformerBuild);
                this.L$3 = cb.l.a(mediaItemBuild);
                this.L$4 = cb.l.a(editedMediaItemBuild);
                this.L$5 = cb.l.a(compositionBuild);
                this.label = 1;
                if (re.s.a(uVar, aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    private VideoUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap generateImageThumbnail(final Bitmap bitmap, final File file, final float size) {
        return generateImageThumbnail$lambda$1(ua.o.a(new lb.a() { // from class: cu.z17.views.utils.c
            @Override // lb.a
            public final Object invoke() {
                return VideoUtils.generateImageThumbnail$lambda$0(bitmap, file, size);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap generateImageThumbnail$lambda$0(Bitmap bitmap, File file, float f10) {
        boolean z10;
        VideoUtils videoUtils = INSTANCE;
        String absolutePath = file.getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        int cameraPhotoOrientation = videoUtils.getCameraPhotoOrientation(absolutePath);
        Matrix matrix = new Matrix();
        matrix.postRotate(cameraPhotoOrientation);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        float width = bitmapCreateBitmap.getWidth();
        float height = bitmapCreateBitmap.getHeight();
        if (height > width) {
            z10 = true;
        } else {
            z10 = false;
            height = width;
            width = height;
        }
        float f11 = (width / height) * f10;
        if (f11 < f10 && z10) {
            f10 = f11;
            f11 = f10;
        }
        return ThumbnailUtils.extractThumbnail(bitmapCreateBitmap, (int) f10, (int) f11);
    }

    private static final Bitmap generateImageThumbnail$lambda$1(ua.n nVar) {
        Object value = nVar.getValue();
        y.h(value, "getValue(...)");
        return (Bitmap) value;
    }

    private final int getCameraPhotoOrientation(String imageFile) {
        try {
            int attributeInt = new ExifInterface(imageFile).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static /* synthetic */ Object getThumbnailOnTime$default(VideoUtils videoUtils, String str, long j10, float f10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f10 = 256.0f;
        }
        return videoUtils.getThumbnailOnTime(str, j10, f10, eVar);
    }

    public final Object getThumbnailOnTime(String str, long j10, float f10, ab.e<? super Bitmap> eVar) {
        return pe.i.g(d1.b(), new AnonymousClass2(str, j10, f10, null), eVar);
    }

    public final te.h saveVideo(Uri source, Context context, String videoPathToSave, long startMilliseconds, long endMilliseconds) {
        y.i(source, "source");
        y.i(context, "context");
        y.i(videoPathToSave, "videoPathToSave");
        return te.j.e(new AnonymousClass1(context, source, startMilliseconds, endMilliseconds, videoPathToSave, null));
    }
}
