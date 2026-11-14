package cu.todus.android.uiCompose.main.screen.chatResources;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatResources/ChatResourcesViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "uid", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "images", "(Ljava/lang/String;)Lte/h;", "videos", "links", "", "msgIds", "Lua/k0;", "share", "(Ljava/util/List;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Landroidx/paging/PagingConfig;", "pagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChatResourcesViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final PagingConfig pagingConfig = new PagingConfig(20, 20, true, 10, Integer.MAX_VALUE, 0, 32, null);

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesViewModel$share$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatResources.ChatResourcesViewModel$share$1", f = "ChatResourcesViewModel.kt", l = {45}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $msgIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$msgIds = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatResourcesViewModel.this.new AnonymousClass1(this.$msgIds, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = ChatResourcesViewModel.this.mainRepository;
                List<String> list = this.$msgIds;
                this.label = 1;
                if (mainRepository.shareMsgs(list, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource images$lambda$0(ChatResourcesViewModel chatResourcesViewModel, String str) {
        return chatResourcesViewModel.mainRepository.getImagesAttachmentsByRoomId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource links$lambda$0(ChatResourcesViewModel chatResourcesViewModel, String str) {
        return chatResourcesViewModel.mainRepository.getLinksAttachmentsByRoomId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource videos$lambda$0(ChatResourcesViewModel chatResourcesViewModel, String str) {
        return chatResourcesViewModel.mainRepository.getVideosAttachmentsByRoomId(str);
    }

    public final te.h images(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.d0
            @Override // lb.a
            public final Object invoke() {
                return ChatResourcesViewModel.images$lambda$0(this.f26053c, uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final te.h links(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.c0
            @Override // lb.a
            public final Object invoke() {
                return ChatResourcesViewModel.links$lambda$0(this.f26049c, uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void share(List<String> msgIds) {
        kotlin.jvm.internal.y.i(msgIds, "msgIds");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(msgIds, null), 3, null);
    }

    public final te.h videos(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatResources.b0
            @Override // lb.a
            public final Object invoke() {
                return ChatResourcesViewModel.videos$lambda$0(this.f26045c, uid);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
