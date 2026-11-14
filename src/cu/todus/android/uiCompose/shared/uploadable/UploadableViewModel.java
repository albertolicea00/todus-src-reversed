package cu.todus.android.uiCompose.shared.uploadable;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.k;
import pe.m0;
import te.p0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcu/todus/android/uiCompose/shared/uploadable/UploadableViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "", "attachmentId", Room.COLUMN_LAST_MSG, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lua/k0;", "upload", "()V", "autoUpload", "cancelUpload", "Ljava/lang/String;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lte/p0;", "", "Lcu/todus/android/s3/S3State;", Status.COLUMN_UPLOAD_STATE, "Lte/p0;", "getUploadState", "()Lte/p0;", "Lte/h;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lte/h;", "getAttachment", "()Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UploadableViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.h attachment;
    private final String attachmentId;
    private final MainRepository mainRepository;
    private final String msgId;
    private final p0 uploadState;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$autoUpload$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$autoUpload$1", f = "UploadableViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return UploadableViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            UploadableViewModel.this.mainRepository.getUploadDataSource().enqueueUpload(UploadableViewModel.this.msgId);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$cancelUpload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$cancelUpload$1", f = "UploadableViewModel.kt", l = {39}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13351 extends m implements Function1 {
        int label;

        public C13351(ab.e<? super C13351> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return UploadableViewModel.this.new C13351(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13351) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                UploadableViewModel.this.mainRepository.getUploadDataSource().cancelUpload(UploadableViewModel.this.msgId);
                MainRepository mainRepository = UploadableViewModel.this.mainRepository;
                String str = UploadableViewModel.this.attachmentId;
                this.label = 1;
                if (mainRepository.updateAttachmentState(str, 3, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$upload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.shared.uploadable.UploadableViewModel$upload$1", f = "UploadableViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13361 extends m implements Function2 {
        int label;

        public C13361(ab.e<? super C13361> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return UploadableViewModel.this.new C13361(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            UploadableViewModel.this.mainRepository.getUploadDataSource().enqueueUpload(UploadableViewModel.this.msgId);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13361) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public UploadableViewModel(String attachmentId, String msgId) throws SinglediException {
        y.i(attachmentId, "attachmentId");
        y.i(msgId, "msgId");
        this.attachmentId = attachmentId;
        this.msgId = msgId;
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        this.mainRepository = singletonInitializer;
        this.uploadState = singletonInitializer.getUploadDataSource().getUploadQueue();
        this.attachment = singletonInitializer.getAttachmentByIdFlow(attachmentId);
    }

    public final void autoUpload() {
        k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void cancelUpload() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13351(null), 3, null);
    }

    public final te.h getAttachment() {
        return this.attachment;
    }

    public final p0 getUploadState() {
        return this.uploadState;
    }

    public final void upload() {
        k.d(ViewModelKt.getViewModelScope(this), null, null, new C13361(null), 3, null);
    }
}
