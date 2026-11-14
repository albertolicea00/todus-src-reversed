package cu.z17.views.picturesAlbum.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.w;
import cu.z17.views.picturesAlbum.data.ImageRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/z17/views/picturesAlbum/ui/AlbumViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "imageRepository", "Lcu/z17/views/picturesAlbum/data/ImageRepository;", "<init>", "(Lcu/z17/views/picturesAlbum/data/ImageRepository;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlbumViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final ImageRepository imageRepository;

    public AlbumViewModelFactory(ImageRepository imageRepository) {
        y.i(imageRepository, "imageRepository");
        this.imageRepository = imageRepository;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        return (T) w.b(this, cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(sb.d dVar, CreationExtras creationExtras) {
        return (T) w.c(this, dVar, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        y.i(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(AlbumViewModel.class)) {
            return new AlbumViewModel(this.imageRepository);
        }
        throw new IllegalArgumentException("ViewModel Not Found");
    }
}
