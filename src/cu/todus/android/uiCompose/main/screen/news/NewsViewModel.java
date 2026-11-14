package cu.todus.android.uiCompose.main.screen.news;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.mucks.DefaultNews;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.List;
import kotlin.Metadata;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/news/NewsViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "mucks", "", "Lcu/todus/android/data/rest/entity/NewEntity;", "getMucks", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NewsViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final List<NewEntity> mucks = g0.Y0(new DefaultNews().getNews());

    public final List<NewEntity> getMucks() {
        return this.mucks;
    }
}
