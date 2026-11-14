package cu.z17.views.videosAlbum.data;

import ab.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import bb.b;
import cb.f;
import cb.m;
import cu.z17.views.utils.galleryUtility.GalleryVideo;
import cu.z17.views.utils.galleryUtility.interactor.GalleryPicker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.z;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcu/z17/views/videosAlbum/data/VideoRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "galleryPicker", "Lcu/z17/views/utils/galleryUtility/interactor/GalleryPicker;", "getVideoPagingSource", "Landroidx/paging/PagingSource;", "", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "getThumbnail", "Landroid/graphics/Bitmap;", "id", "", "(Ljava/lang/Long;)Landroid/graphics/Bitmap;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoRepository {
    public static final int $stable = 8;
    private final Context context;
    private final GalleryPicker galleryPicker;

    /* JADX INFO: renamed from: cu.z17.views.videosAlbum.data.VideoRepository$getVideoPagingSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.videosAlbum.data.VideoRepository$getVideoPagingSource$1", f = "VideoRepository.kt", l = {23}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "limit", "", "offset"}, k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, int i11, e<? super List<VideoAlbum>> eVar) {
            AnonymousClass1 anonymousClass1 = VideoRepository.this.new AnonymousClass1(eVar);
            anonymousClass1.I$0 = i10;
            anonymousClass1.I$1 = i11;
            return anonymousClass1.invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = b.g();
            int i12 = this.label;
            if (i12 == 0) {
                v.b(obj);
                GalleryPicker galleryPicker = VideoRepository.this.galleryPicker;
                this.I$0 = i10;
                this.I$1 = i11;
                this.label = 1;
                obj = galleryPicker.getVideos(i10, i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            VideoRepository videoRepository = VideoRepository.this;
            ArrayList arrayList = new ArrayList();
            for (GalleryVideo galleryVideo : (Iterable) obj) {
                VideoAlbum videoAlbum = null;
                try {
                    Uri uri = Uri.parse(galleryVideo.getDATA());
                    y.h(uri, "parse(...)");
                    String date_added = galleryVideo.getDATE_ADDED();
                    Long lX = date_added != null ? z.x(date_added) : null;
                    String display_name = galleryVideo.getDISPLAY_NAME();
                    String id2 = galleryVideo.getID();
                    Long lX2 = id2 != null ? z.x(id2) : null;
                    String album_name = galleryVideo.getALBUM_NAME();
                    String duration = galleryVideo.getDURATION();
                    Long lX3 = duration != null ? z.x(duration) : null;
                    String id3 = galleryVideo.getID();
                    videoAlbum = new VideoAlbum(uri, lX, display_name, lX2, album_name, lX3, videoRepository.getThumbnail(id3 != null ? z.x(id3) : null));
                } catch (Exception unused) {
                }
                if (videoAlbum != null) {
                    arrayList.add(videoAlbum);
                }
            }
            return arrayList;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (e<? super List<VideoAlbum>>) obj3);
        }
    }

    public VideoRepository(Context context) {
        y.i(context, "context");
        this.context = context;
        this.galleryPicker = new GalleryPicker(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getThumbnail(Long id2) {
        if (id2 == null) {
            return null;
        }
        return MediaStore.Video.Thumbnails.getThumbnail(this.context.getContentResolver(), id2.longValue(), 1, null);
    }

    public final PagingSource<Integer, VideoAlbum> getVideoPagingSource() {
        return new VideoAlbumDataSource(new AnonymousClass1(null));
    }
}
