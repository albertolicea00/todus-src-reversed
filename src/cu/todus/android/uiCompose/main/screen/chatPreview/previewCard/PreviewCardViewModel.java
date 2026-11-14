package cu.todus.android.uiCompose.main.screen.chatPreview.previewCard;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b)\u0010'R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010#R\u001f\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0$8\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010'R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0.0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010#R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0.0$8\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010'¨\u00062"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chatPreview/previewCard/PreviewCardViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "", "uid", "Lkotlin/Function0;", "Lua/k0;", "onLoaded", "loadPreviewCard", "(Ljava/lang/String;Llb/a;)V", "leaveAndDeleteCard", "(Ljava/lang/String;)V", "roomId", "onComplete", "clearHistory", "changeSecretState", "changeMuteValue", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "", "_isSecret", "Lte/b0;", "Lte/p0;", "isSecret", "Lte/p0;", "()Lte/p0;", "_isMuted", Room.COLUMN_MUTED, "Lcu/todus/android/data/db/entity/toDus/Room;", "_previewCard", "previewCard", "getPreviewCard", "Lcu/todus/android/data/wrapper/FlowsState;", "_leavingCard", "leavingCard", "getLeavingCard", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewCardViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _isMuted;
    private final b0 _isSecret;
    private final b0 _leavingCard;
    private final b0 _previewCard;
    private final p0 isMuted;
    private final p0 isSecret;
    private final p0 leavingCard;
    private final p0 previewCard;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$changeMuteValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$changeMuteValue$1", f = "PreviewCardViewModel.kt", l = {92}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewCardViewModel.this.new AnonymousClass1(this.$roomId, eVar);
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
                RoomsRepository roomsRepository = PreviewCardViewModel.this.roomsRepository;
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$changeSecretState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$changeSecretState$1", f = "PreviewCardViewModel.kt", l = {86}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12511 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12511(String str, ab.e<? super C12511> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewCardViewModel.this.new C12511(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12511) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RoomsRepository roomsRepository = PreviewCardViewModel.this.roomsRepository;
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1", f = "PreviewCardViewModel.kt", l = {74, 76}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12521 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $roomId;
        Object L$0;
        int label;
        final /* synthetic */ PreviewCardViewModel this$0;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1$1", f = "PreviewCardViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02251 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02251(lb.a aVar, ab.e<? super C02251> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02251(this.$onComplete, eVar);
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
                return ((C02251) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12521(String str, PreviewCardViewModel previewCardViewModel, lb.a aVar, ab.e<? super C12521> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.this$0 = previewCardViewModel;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12521(this.$roomId, this.this$0, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12521) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        
            if (pe.w0.b(300, r6) == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r6.L$0
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                ua.v.b(r7)
                goto L59
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                ua.v.b(r7)
                goto L48
            L26:
                ua.v.b(r7)
                java.lang.String r7 = r6.$roomId
                java.lang.String[] r7 = new java.lang.String[]{r7}
                java.util.ArrayList r1 = va.w.g(r7)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel r7 = r6.this$0
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.access$getMainRepository$p(r7)
                java.lang.Object r4 = cb.l.a(r1)
                r6.L$0 = r4
                r6.label = r3
                java.lang.Object r7 = r7.clearHistoryFromRooms(r1, r6)
                if (r7 != r0) goto L48
                goto L58
            L48:
                java.lang.Object r7 = cb.l.a(r1)
                r6.L$0 = r7
                r6.label = r2
                r1 = 300(0x12c, double:1.48E-321)
                java.lang.Object r7 = pe.w0.b(r1, r6)
                if (r7 != r0) goto L59
            L58:
                return r0
            L59:
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel r7 = r6.this$0
                pe.m0 r0 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r7)
                pe.k2 r1 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1$1 r3 = new cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$clearHistory$1$1
                lb.a r7 = r6.$onComplete
                r2 = 0
                r3.<init>(r7, r2)
                r4 = 2
                r5 = 0
                pe.i.d(r0, r1, r2, r3, r4, r5)
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.C12521.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$leaveAndDeleteCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$leaveAndDeleteCard$1", f = "PreviewCardViewModel.kt", l = {RectListKt.BitOffsetForGesturable, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12531 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12531(String str, ab.e<? super C12531> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return PreviewCardViewModel.this.new C12531(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12531) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0064, code lost:
        
            if (pe.w0.b(300, r5) == r0) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r6)
                goto L67
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                ua.v.b(r6)
                goto L41
            L1e:
                ua.v.b(r6)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel r6 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.this
                te.b0 r6 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.access$get_leavingCard$p(r6)
                cu.todus.android.data.wrapper.FlowsState$Companion r1 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                cu.todus.android.data.wrapper.FlowsState r1 = r1.loading()
                r6.setValue(r1)
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel r6 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.this
                cu.todus.android.repositories.MainRepository r6 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.access$getMainRepository$p(r6)
                java.lang.String r1 = r5.$uid
                r5.label = r3
                java.lang.Object r6 = r6.unsubscribeCard(r1, r5)
                if (r6 != r0) goto L41
                goto L66
            L41:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.this
                te.b0 r1 = cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.access$get_leavingCard$p(r1)
                cu.todus.android.data.wrapper.FlowsState$Companion r3 = cu.todus.android.data.wrapper.FlowsState.INSTANCE
                java.lang.Boolean r4 = cb.b.a(r6)
                cu.todus.android.data.wrapper.FlowsState r3 = r3.success(r4)
                r1.setValue(r3)
                r5.Z$0 = r6
                r5.label = r2
                r1 = 300(0x12c, double:1.48E-321)
                java.lang.Object r6 = pe.w0.b(r1, r5)
                if (r6 != r0) goto L67
            L66:
                return r0
            L67:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.C12531.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$loadPreviewCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$loadPreviewCard$1", f = "PreviewCardViewModel.kt", l = {39}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12541 extends cb.m implements Function2 {
        final /* synthetic */ lb.a $onLoaded;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12541(String str, lb.a aVar, ab.e<? super C12541> eVar) {
            super(2, eVar);
            this.$uid = str;
            this.$onLoaded = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return PreviewCardViewModel.this.new C12541(this.$uid, this.$onLoaded, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h roomByIdFlow = PreviewCardViewModel.this.mainRepository.getRoomByIdFlow(this.$uid);
                final PreviewCardViewModel previewCardViewModel = PreviewCardViewModel.this;
                final lb.a aVar = this.$onLoaded;
                te.i iVar = new te.i() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel.loadPreviewCard.1.1
                    @Override // te.i
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                        return emit((Room) obj2, (ab.e<? super k0>) eVar);
                    }

                    public final Object emit(Room room, ab.e<? super k0> eVar) {
                        previewCardViewModel._previewCard.setValue(room);
                        previewCardViewModel._isSecret.setValue(cb.b.a(room != null ? room.getSecret() : false));
                        previewCardViewModel._isMuted.setValue(cb.b.a(room != null ? room.isMuted() : false));
                        aVar.invoke();
                        return k0.f43947a;
                    }
                };
                this.label = 1;
                if (roomByIdFlow.collect(iVar, this) == objG) {
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
            return ((C12541) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$loadPreviewCard$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewCard.PreviewCardViewModel$loadPreviewCard$2", f = "PreviewCardViewModel.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m = "invokeSuspend", v = 2)
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
            return PreviewCardViewModel.this.new AnonymousClass2(this.$uid, eVar);
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
                MainRepository mainRepository = PreviewCardViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.reloadCard(str, this) == objG) {
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

    public PreviewCardViewModel() {
        Boolean bool = Boolean.FALSE;
        b0 b0VarA = r0.a(bool);
        this._isSecret = b0VarA;
        this.isSecret = te.j.b(b0VarA);
        b0 b0VarA2 = r0.a(bool);
        this._isMuted = b0VarA2;
        this.isMuted = te.j.b(b0VarA2);
        b0 b0VarA3 = r0.a(null);
        this._previewCard = b0VarA3;
        this.previewCard = te.j.b(b0VarA3);
        b0 b0VarA4 = r0.a(FlowsState.INSTANCE.notRequested());
        this._leavingCard = b0VarA4;
        this.leavingCard = te.j.b(b0VarA4);
    }

    public final void changeMuteValue(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, null), 3, null);
    }

    public final void changeSecretState(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12511(uid, null), 3, null);
    }

    public final void clearHistory(String roomId, lb.a onComplete) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12521(roomId, this, onComplete, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final p0 getLeavingCard() {
        return this.leavingCard;
    }

    public final p0 getPreviewCard() {
        return this.previewCard;
    }

    /* JADX INFO: renamed from: isMuted, reason: from getter */
    public final p0 getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: isSecret, reason: from getter */
    public final p0 getIsSecret() {
        return this.isSecret;
    }

    public final void leaveAndDeleteCard(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12531(uid, null), 3, null);
    }

    public final void loadPreviewCard(String uid, lb.a onLoaded) {
        kotlin.jvm.internal.y.i(uid, "uid");
        kotlin.jvm.internal.y.i(onLoaded, "onLoaded");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12541(uid, onLoaded, null), 3, null);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(uid, null), 3, null);
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }
}
