package cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.mam.element.MamElements;
import pe.d1;
import pe.m0;
import te.p0;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ#\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b)\u0010'R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010#R\u001f\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0$8\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010'R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010#R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b/\u0010'¨\u00060"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewP2P/PreviewP2PViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "uid", "Lua/k0;", "loadPreviewUser", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "onComplete", "changeBlockState", "(Ljava/lang/String;Llb/a;)V", "changeSecretState", "roomId", "changeMuteValue", "onStarted", "startCall", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "", "_isSecret", "Lte/b0;", "Lte/p0;", "isSecret", "Lte/p0;", "()Lte/p0;", "_isMuted", Room.COLUMN_MUTED, "Lcu/todus/android/data/db/pojo/Partner;", "_previewPartner", "previewPartner", "getPreviewPartner", "_isBlocked", "isBlocked", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewP2PViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.b0 _isBlocked;
    private final te.b0 _isMuted;
    private final te.b0 _isSecret;
    private final te.b0 _previewPartner;
    private final p0 isBlocked;
    private final p0 isMuted;
    private final p0 isSecret;
    private final p0 previewPartner;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeBlockState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeBlockState$1", f = "PreviewP2PViewModel.kt", l = {63}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeBlockState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeBlockState$1$1", f = "PreviewP2PViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02351 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02351(lb.a aVar, ab.e<? super C02351> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02351(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02351) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new AnonymousClass1(this.$uid, this.$onComplete, eVar);
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
                MainRepository mainRepository = PreviewP2PViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.changeBlockState(str, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(PreviewP2PViewModel.this), d1.c(), null, new C02351(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeMuteValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeMuteValue$1", f = "PreviewP2PViewModel.kt", l = {80}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12771 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12771(String str, ab.e<? super C12771> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new C12771(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12771) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewP2PViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.changeMuteValue(str, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeSecretState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$changeSecretState$1", f = "PreviewP2PViewModel.kt", l = {74}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12781 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12781(String str, ab.e<? super C12781> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new C12781(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12781) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewP2PViewModel.this.roomsRepository;
                String str = this.$uid;
                this.label = 1;
                if (roomsRepository.changeSecretState(str, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$1", f = "PreviewP2PViewModel.kt", l = {45}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12791 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$1$1", f = "PreviewP2PViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/db/pojo/Partner;", MamElements.MamResultExtension.ELEMENT, "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/db/pojo/Partner;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02361 extends cb.m implements Function2 {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PreviewP2PViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02361(PreviewP2PViewModel previewP2PViewModel, ab.e<? super C02361> eVar) {
                super(2, eVar);
                this.this$0 = previewP2PViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02361 c02361 = new C02361(this.this$0, eVar);
                c02361.L$0 = obj;
                return c02361;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Partner partner, ab.e<? super k0> eVar) {
                return ((C02361) create(partner, eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                User user;
                Room room;
                Room room2;
                Partner partner = (Partner) this.L$0;
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                this.this$0._previewPartner.setValue(partner);
                boolean blocked = false;
                this.this$0._isSecret.setValue(cb.b.a((partner == null || (room2 = partner.getRoom()) == null) ? false : room2.getSecret()));
                this.this$0._isMuted.setValue(cb.b.a((partner == null || (room = partner.getRoom()) == null) ? false : room.isMuted()));
                te.b0 b0Var = this.this$0._isBlocked;
                if (partner != null && (user = partner.getUser()) != null) {
                    blocked = user.getBlocked();
                }
                b0Var.setValue(cb.b.a(blocked));
                return k0.f43947a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12791(String str, ab.e<? super C12791> eVar) {
            super(2, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new C12791(this.$uid, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h partnerByIdFlow = PreviewP2PViewModel.this.mainRepository.getPartnerByIdFlow(this.$uid);
                C02361 c02361 = new C02361(PreviewP2PViewModel.this, null);
                this.label = 1;
                if (te.j.k(partnerByIdFlow, c02361, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C12791) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$loadPreviewUser$2", f = "PreviewP2PViewModel.kt", l = {57}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new AnonymousClass2(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewP2PViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.reloadUser(str, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$startCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.PreviewP2PViewModel$startCall$1", f = "PreviewP2PViewModel.kt", l = {86}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12801 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onStarted;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12801(String str, lb.a aVar, ab.e<? super C12801> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onStarted = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(PreviewP2PViewModel previewP2PViewModel, lb.a aVar) {
            pe.k.d(ViewModelKt.getViewModelScope(previewP2PViewModel), d1.c(), null, new PreviewP2PViewModel$startCall$1$1$1(aVar, null), 2, null);
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(PreviewP2PViewModel previewP2PViewModel) {
            MainRepository mainRepository = previewP2PViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.y.h(string, "toString(...)");
            String strO = le.a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.u_are_busy_cannot_call);
            kotlin.jvm.internal.y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(PreviewP2PViewModel previewP2PViewModel) {
            MainRepository mainRepository = previewP2PViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.y.h(string, "toString(...)");
            String strO = le.a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
            kotlin.jvm.internal.y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewP2PViewModel.this.new C12801(this.$uid, this.$onStarted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12801) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = PreviewP2PViewModel.this.mainRepository;
                String str = this.$uid;
                final PreviewP2PViewModel previewP2PViewModel = PreviewP2PViewModel.this;
                final lb.a aVar = this.$onStarted;
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewP2PViewModel.C12801.invokeSuspend$lambda$0(previewP2PViewModel, aVar);
                    }
                };
                final PreviewP2PViewModel previewP2PViewModel2 = PreviewP2PViewModel.this;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.b0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewP2PViewModel.C12801.invokeSuspend$lambda$1(previewP2PViewModel2);
                    }
                };
                final PreviewP2PViewModel previewP2PViewModel3 = PreviewP2PViewModel.this;
                lb.a aVar4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewP2P.c0
                    @Override // lb.a
                    public final Object invoke() {
                        return PreviewP2PViewModel.C12801.invokeSuspend$lambda$2(previewP2PViewModel3);
                    }
                };
                this.label = 1;
                if (MainRepository.startCallProcess$default(mainRepository, str, false, aVar2, aVar3, aVar4, this, 2, null) == objG) {
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

    public PreviewP2PViewModel() {
        Boolean bool = Boolean.FALSE;
        te.b0 b0VarA = r0.a(bool);
        this._isSecret = b0VarA;
        this.isSecret = te.j.b(b0VarA);
        te.b0 b0VarA2 = r0.a(bool);
        this._isMuted = b0VarA2;
        this.isMuted = te.j.b(b0VarA2);
        te.b0 b0VarA3 = r0.a(null);
        this._previewPartner = b0VarA3;
        this.previewPartner = te.j.b(b0VarA3);
        te.b0 b0VarA4 = r0.a(bool);
        this._isBlocked = b0VarA4;
        this.isBlocked = te.j.b(b0VarA4);
    }

    public final void changeBlockState(String uid, lb.a onComplete) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(uid, onComplete, null), 3, null);
    }

    public final void changeMuteValue(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12771(roomId, null), 3, null);
    }

    public final void changeSecretState(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12781(uid, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final p0 getPreviewPartner() {
        return this.previewPartner;
    }

    /* JADX INFO: renamed from: isBlocked, reason: from getter */
    public final p0 getIsBlocked() {
        return this.isBlocked;
    }

    /* JADX INFO: renamed from: isMuted, reason: from getter */
    public final p0 getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: isSecret, reason: from getter */
    public final p0 getIsSecret() {
        return this.isSecret;
    }

    public final void loadPreviewUser(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12791(uid, null), 3, null);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(uid, null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void startCall(String uid, lb.a onStarted) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onStarted, "onStarted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12801(uid, onStarted, null), 3, null);
    }
}
