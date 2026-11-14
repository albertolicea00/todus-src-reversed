package cu.todus.android.uiCompose.main.screen.statusPreview;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import androidx.paging.PagingSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import pe.d1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n0\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\rJ\u001d\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\rJ+\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00072\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000f0!¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b'\u0010\rJ\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\u0011J#\u0010)\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R#\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b>\u0010<R\u0014\u0010?\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108¨\u0006@"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/StatusPreviewViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "startId", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "otherStatus2", "(Ljava/lang/String;)Lte/h;", "id", "Lua/k0;", "seenStatus", "(Ljava/lang/String;)V", Status.COLUMN_REPLIED_ID, "statusId", "text", "Lkotlin/Function0;", "onCompleted", "respondToReplied", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llb/a;)V", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "reactionsFromStatus", AppMeasurementSdk.ConditionalUserProperty.VALUE, "sendReaction", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "checkActualReaction", "uid", "Lkotlin/Function1;", "Lcu/todus/android/data/xmpp/FollowState;", "onComplete", "getFollowState", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "getViewCount", "deleteAsUnwanted", "replyStatus", "(Ljava/lang/String;Llb/a;)V", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Landroidx/paging/PagingConfig;", "statusPagingConfig", "Landroidx/paging/PagingConfig;", "ownerStatus", "Lte/h;", "getOwnerStatus", "()Lte/h;", "otherStatus", "getOtherStatus", "reactionsPagingConfig", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusPreviewViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.h otherStatus;
    private final te.h ownerStatus;
    private final PagingConfig reactionsPagingConfig;
    private final PagingConfig statusPagingConfig;
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$deleteAsUnwanted$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$deleteAsUnwanted$1", f = "StatusPreviewViewModel.kt", l = {137}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $statusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$statusId = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusPreviewViewModel.this.new AnonymousClass1(this.$statusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusPreviewViewModel.this.statusRepository;
                String str = this.$statusId;
                this.label = 1;
                if (statusRepository.deleteLocalById(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$getFollowState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$getFollowState$1", f = "StatusPreviewViewModel.kt", l = {123}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13241 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$getFollowState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$getFollowState$1$1", f = "StatusPreviewViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02581 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onComplete;
            final /* synthetic */ FollowState $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02581(Function1 function1, FollowState followState, ab.e<? super C02581> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$response = followState;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02581(this.$onComplete, this.$response, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke(this.$response);
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02581) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13241(String str, Function1 function1, ab.e<? super C13241> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusPreviewViewModel.this.new C13241(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13241) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = StatusPreviewViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.followState(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            FollowState followState = (FollowState) obj;
            if (followState != null) {
                pe.k.d(ViewModelKt.getViewModelScope(StatusPreviewViewModel.this), d1.c(), null, new C02581(this.$onComplete, followState, null), 2, null);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$replyStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$replyStatus$1", f = "StatusPreviewViewModel.kt", l = {143}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13251 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onCompleted;
        final /* synthetic */ String $statusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13251(String str, lb.a aVar, ab.e<? super C13251> eVar) {
            super(1, eVar);
            this.$statusId = str;
            this.$onCompleted = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusPreviewViewModel.this.new C13251(this.$statusId, this.$onCompleted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13251) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusPreviewViewModel.this.statusRepository;
                String str = this.$statusId;
                this.label = 1;
                if (statusRepository.replyStatus(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            this.$onCompleted.invoke();
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$respondToReplied$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$respondToReplied$1", f = "StatusPreviewViewModel.kt", l = {81, 87, 94}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13261 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onCompleted;
        final /* synthetic */ String $repliedId;
        final /* synthetic */ String $statusId;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ StatusPreviewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13261(String str, StatusPreviewViewModel statusPreviewViewModel, String str2, String str3, lb.a aVar, ab.e<? super C13261> eVar) {
            super(1, eVar);
            this.$repliedId = str;
            this.this$0 = statusPreviewViewModel;
            this.$text = str2;
            this.$statusId = str3;
            this.$onCompleted = aVar;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C13261(this.$repliedId, this.this$0, this.$text, this.$statusId, this.$onCompleted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13261) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
        
            if (pe.w0.b(2000, r14) == r12) goto L21;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r12 = bb.b.g()
                int r0 = r14.label
                r13 = 3
                r1 = 2
                r2 = 1
                if (r0 == 0) goto L21
                if (r0 == r2) goto L1d
                if (r0 == r1) goto L1d
                if (r0 != r13) goto L15
                ua.v.b(r15)
                goto L75
            L15:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1d:
                ua.v.b(r15)
                goto L6a
            L21:
                ua.v.b(r15)
                cu.todus.android.xmpp.XMPPUtils r0 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r3 = r14.$repliedId
                boolean r0 = r0.isChannel(r3)
                if (r0 == 0) goto L4c
                cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel r0 = r14.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel.access$getMainRepository$p(r0)
                java.lang.String r1 = r14.$text
                java.lang.String r3 = r14.$repliedId
                java.lang.String r4 = r14.$statusId
                r14.label = r2
                r2 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r10 = 242(0xf2, float:3.39E-43)
                r11 = 0
                r9 = r14
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessageToChannel$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r0 != r12) goto L6a
                goto L74
            L4c:
                cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel r0 = r14.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel.access$getMainRepository$p(r0)
                java.lang.String r2 = r14.$text
                java.lang.String r3 = r14.$repliedId
                java.lang.String r4 = r14.$statusId
                r14.label = r1
                r1 = r2
                r2 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 114(0x72, float:1.6E-43)
                r10 = 0
                r8 = r14
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessage$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r0 != r12) goto L6a
                goto L74
            L6a:
                r14.label = r13
                r0 = 2000(0x7d0, double:9.88E-321)
                java.lang.Object r0 = pe.w0.b(r0, r14)
                if (r0 != r12) goto L75
            L74:
                return r12
            L75:
                lb.a r0 = r14.$onCompleted
                r0.invoke()
                ua.k0 r0 = ua.k0.f43947a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel.C13261.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$seenStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$seenStatus$1", f = "StatusPreviewViewModel.kt", l = {56}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13271 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$seenStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$seenStatus$1$1", f = "StatusPreviewViewModel.kt", l = {58, 59, 60, RectListKt.BitOffsetForFocusable, 64, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, MdtaMetadataEntry.TYPE_INDICATOR_INT32}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", Status.COLUMN_CREATOR_ID, Status.COLUMN_REPLIED_ID, "Lua/k0;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02591 extends cb.m implements Function3 {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ StatusPreviewViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02591(StatusPreviewViewModel statusPreviewViewModel, ab.e<? super C02591> eVar) {
                super(3, eVar);
                this.this$0 = statusPreviewViewModel;
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00a4  */
            /* JADX WARN: Code duplicated, block: B:30:0x00ac  */
            /* JADX WARN: Code duplicated, block: B:33:0x00c8  */
            /* JADX WARN: Code duplicated, block: B:35:0x00ce  */
            /* JADX WARN: Code duplicated, block: B:38:0x00ea  */
            /* JADX WARN: Code duplicated, block: B:40:0x00f0  */
            /* JADX WARN: Code duplicated, block: B:43:0x010c  */
            /* JADX WARN: Code duplicated, block: B:45:0x0112  */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00c5, code lost:
            
                if (r5.reloadChannel(r0, r4) == r2) goto L47;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
            
                if (r5.reloadGroup(r0, r4) == r2) goto L47;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
            
                if (r5.reloadCard(r0, r4) == r2) goto L47;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
            
                if (r5.reloadUser(r0, r4) == r2) goto L47;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    Method dump skipped, instruction units count: 328
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel.C13271.C02591.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(String str, String str2, ab.e<? super ua.k0> eVar) {
                C02591 c02591 = new C02591(this.this$0, eVar);
                c02591.L$0 = str;
                c02591.L$1 = str2;
                return c02591.invokeSuspend(ua.k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13271(String str, ab.e<? super C13271> eVar) {
            super(1, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusPreviewViewModel.this.new C13271(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13271) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusPreviewViewModel.this.statusRepository;
                String str = this.$id;
                C02591 c02591 = new C02591(StatusPreviewViewModel.this, null);
                this.label = 1;
                if (statusRepository.setAsSeen(str, c02591, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$sendReaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$sendReaction$1", f = "StatusPreviewViewModel.kt", l = {115}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13281 extends cb.m implements Function1 {
        final /* synthetic */ String $statusId;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13281(String str, String str2, ab.e<? super C13281> eVar) {
            super(1, eVar);
            this.$statusId = str;
            this.$value = str2;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return StatusPreviewViewModel.this.new C13281(this.$statusId, this.$value, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13281) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StatusRepository statusRepository = StatusPreviewViewModel.this.statusRepository;
                String str = this.$statusId;
                String str2 = this.$value;
                this.label = 1;
                if (statusRepository.sendReaction(str, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    public StatusPreviewViewModel() {
        PagingConfig pagingConfig = new PagingConfig(10, 10, true, 20, Integer.MAX_VALUE, 0, 32, null);
        this.statusPagingConfig = pagingConfig;
        int i10 = 2;
        kotlin.jvm.internal.p pVar = null;
        Object obj = null;
        this.ownerStatus = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, obj, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.t0
            @Override // lb.a
            public final Object invoke() {
                return StatusPreviewViewModel.ownerStatus$lambda$0(this.f28002c);
            }
        }, i10, pVar).getFlow(), ViewModelKt.getViewModelScope(this));
        this.otherStatus = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, obj, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.u0
            @Override // lb.a
            public final Object invoke() {
                return StatusPreviewViewModel.otherStatus$lambda$0(this.f28005c);
            }
        }, i10, pVar).getFlow(), ViewModelKt.getViewModelScope(this));
        this.reactionsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource otherStatus$lambda$0(StatusPreviewViewModel statusPreviewViewModel) {
        return statusPreviewViewModel.statusRepository.otherStatusInverted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource otherStatus2$lambda$0(String str) {
        return new StatusPreviewPagingSource(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource ownerStatus$lambda$0(StatusPreviewViewModel statusPreviewViewModel) {
        return statusPreviewViewModel.statusRepository.ownerStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource reactionsFromStatus$lambda$0(StatusPreviewViewModel statusPreviewViewModel, String str) {
        return statusPreviewViewModel.mainRepository.getReactionsByEntityId(str);
    }

    public final te.h checkActualReaction(String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        return this.statusRepository.checkReaction(statusId);
    }

    public final void deleteAsUnwanted(String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(statusId, null), 3, null);
    }

    public final void getFollowState(String uid, Function1 onComplete) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13241(uid, onComplete, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final te.h getOtherStatus() {
        return this.otherStatus;
    }

    public final te.h getOwnerStatus() {
        return this.ownerStatus;
    }

    public final te.h getViewCount(String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        return this.statusRepository.getViewsCount(statusId);
    }

    public final te.h otherStatus2(final String startId) {
        kotlin.jvm.internal.y.i(startId, "startId");
        final te.h flow = new Pager(this.statusPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.v0
            @Override // lb.a
            public final Object invoke() {
                return StatusPreviewViewModel.otherStatus2$lambda$0(startId);
            }
        }, 2, null).getFlow();
        return CachedPagingDataKt.cachedIn(new te.h() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$otherStatus2$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$otherStatus2$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$otherStatus2$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewViewModel$otherStatus2$$inlined$map$1$2", f = "StatusPreviewViewModel.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        ua.v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new StatusPreviewViewModel$otherStatus2$2$1(null));
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return ua.k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = flow.collect(new AnonymousClass2(iVar), eVar);
                return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final te.h reactionsFromStatus(final String statusId) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        return CachedPagingDataKt.cachedIn(new Pager(this.reactionsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.w0
            @Override // lb.a
            public final Object invoke() {
                return StatusPreviewViewModel.reactionsFromStatus$lambda$0(this.f28010c, statusId);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void replyStatus(String statusId, lb.a onCompleted) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        kotlin.jvm.internal.y.i(onCompleted, "onCompleted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13251(statusId, onCompleted, null), 3, null);
    }

    public final void respondToReplied(String repliedId, String statusId, String text, lb.a onCompleted) {
        kotlin.jvm.internal.y.i(repliedId, "repliedId");
        kotlin.jvm.internal.y.i(statusId, "statusId");
        kotlin.jvm.internal.y.i(text, "text");
        kotlin.jvm.internal.y.i(onCompleted, "onCompleted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13261(repliedId, this, text, statusId, onCompleted, null), 3, null);
    }

    public final void seenStatus(String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13271(id2, null), 3, null);
    }

    public final void sendReaction(String statusId, String value) {
        kotlin.jvm.internal.y.i(statusId, "statusId");
        kotlin.jvm.internal.y.i(value, "value");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13281(statusId, value, null), 3, null);
    }
}
