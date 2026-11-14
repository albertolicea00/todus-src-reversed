package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/attachmentPreview/AttachmentPreviewViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "", "ids", "Lte/h;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachmentList", "(Ljava/util/List;)Lte/h;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "getMainRepository", "()Lcu/todus/android/repositories/MainRepository;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AttachmentPreviewViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();

    public final te.h attachmentList(List<String> ids) {
        kotlin.jvm.internal.y.i(ids, "ids");
        return this.mainRepository.getAttachmentsFlow(ids);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final MainRepository getMainRepository() {
        return this.mainRepository;
    }
}
