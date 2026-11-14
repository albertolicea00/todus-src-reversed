package cu.z17.views.videosAlbum.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.z17.views.utils.Z17MutableListFlow;
import cu.z17.views.videosAlbum.data.VideoAlbum;
import cu.z17.views.videosAlbum.data.VideoRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcu/z17/views/videosAlbum/ui/VideoAlbumViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcu/z17/views/videosAlbum/data/VideoRepository;", "videoRepository", "<init>", "(Lcu/z17/views/videosAlbum/data/VideoRepository;)V", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "getVideos", "()Lte/h;", "Lcu/z17/views/videosAlbum/data/VideoRepository;", "Lcu/z17/views/utils/Z17MutableListFlow;", "selectedList", "Lcu/z17/views/utils/Z17MutableListFlow;", "getSelectedList", "()Lcu/z17/views/utils/Z17MutableListFlow;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoAlbumViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Z17MutableListFlow<VideoAlbum> selectedList;
    private final VideoRepository videoRepository;

    public VideoAlbumViewModel(VideoRepository videoRepository) {
        y.i(videoRepository, "videoRepository");
        this.videoRepository = videoRepository;
        this.selectedList = new Z17MutableListFlow<>(w.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource getVideos$lambda$0(VideoAlbumViewModel videoAlbumViewModel) {
        return videoAlbumViewModel.videoRepository.getVideoPagingSource();
    }

    public final Z17MutableListFlow<VideoAlbum> getSelectedList() {
        return this.selectedList;
    }

    public final te.h getVideos() {
        return CachedPagingDataKt.cachedIn(new Pager(new PagingConfig(50, 0, true, 50, 0, 0, 50, null), null, new lb.a() { // from class: cu.z17.views.videosAlbum.ui.a
            @Override // lb.a
            public final Object invoke() {
                return VideoAlbumViewModel.getVideos$lambda$0(this.f30336c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
