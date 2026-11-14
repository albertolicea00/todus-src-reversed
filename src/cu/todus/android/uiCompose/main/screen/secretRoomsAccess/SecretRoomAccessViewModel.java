package cu.todus.android.uiCompose.main.screen.secretRoomsAccess;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import pe.w0;
import te.b0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001b¨\u0006 "}, d2 = {"Lcu/todus/android/uiCompose/main/screen/secretRoomsAccess/SecretRoomAccessViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lua/k0;", "loadingReady", "", "clean", "Lkotlin/Function0;", "onComplete", "navigateSecret", "(ZLlb/a;)V", "", "code", "cleanCode", "setReady", "(Ljava/lang/String;Ljava/lang/String;)V", "resetConfigs", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lte/b0;", "isReady", "Lte/b0;", "()Lte/b0;", "actualCode", "getActualCode", "actualCleanCode", "getActualCleanCode", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SecretRoomAccessViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final PreferencesModule preferences = PreferencesModule.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final b0 isReady = r0.a(null);
    private final b0 actualCode = r0.a("");
    private final b0 actualCleanCode = r0.a("");

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$loadingReady$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$loadingReady$1", f = "SecretRoomAccessViewModel.kt", l = {25}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$loadingReady$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$loadingReady$1$1", f = "SecretRoomAccessViewModel.kt", l = {26, 29, 30}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(Z)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02461 extends cb.m implements Function2 {
            Object L$0;
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ SecretRoomAccessViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02461(SecretRoomAccessViewModel secretRoomAccessViewModel, ab.e<? super C02461> eVar) {
                super(2, eVar);
                this.this$0 = secretRoomAccessViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02461 c02461 = new C02461(this.this$0, eVar);
                c02461.Z$0 = ((Boolean) obj).booleanValue();
                return c02461;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (ab.e<? super k0>) obj2);
            }

            /* JADX WARN: Code duplicated, block: B:21:0x0081  */
            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                b0 actualCode;
                b0 actualCleanCode;
                Object secretClean;
                b0 b0Var;
                boolean z10 = this.Z$0;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    this.Z$0 = z10;
                    this.label = 1;
                    if (w0.b(500L, this) != objG) {
                    }
                    return objG;
                }
                if (i10 == 1) {
                    v.b(obj);
                } else {
                    if (i10 == 2) {
                        actualCode = (b0) this.L$0;
                        v.b(obj);
                        actualCode.setValue(obj);
                        actualCleanCode = this.this$0.getActualCleanCode();
                        PreferencesModule preferencesModule = this.this$0.preferences;
                        this.L$0 = actualCleanCode;
                        this.Z$0 = z10;
                        this.label = 3;
                        secretClean = preferencesModule.getSecretClean(this);
                        if (secretClean != objG) {
                            b0Var = actualCleanCode;
                            obj = secretClean;
                        }
                        return objG;
                    }
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b0Var = (b0) this.L$0;
                    v.b(obj);
                }
                b0Var.setValue(obj);
                return k0.f43947a;
                this.this$0.getIsReady().setValue(cb.b.a(z10));
                actualCode = this.this$0.getActualCode();
                PreferencesModule preferencesModule2 = this.this$0.preferences;
                this.L$0 = actualCode;
                this.Z$0 = z10;
                this.label = 2;
                obj = preferencesModule2.getSecretCode(this);
                if (obj != objG) {
                    actualCode.setValue(obj);
                    actualCleanCode = this.this$0.getActualCleanCode();
                    PreferencesModule preferencesModule3 = this.this$0.preferences;
                    this.L$0 = actualCleanCode;
                    this.Z$0 = z10;
                    this.label = 3;
                    secretClean = preferencesModule3.getSecretClean(this);
                    if (secretClean != objG) {
                        b0Var = actualCleanCode;
                        obj = secretClean;
                        b0Var.setValue(obj);
                        return k0.f43947a;
                    }
                }
                return objG;
            }

            public final Object invoke(boolean z10, ab.e<? super k0> eVar) {
                return ((C02461) create(Boolean.valueOf(z10), eVar)).invokeSuspend(k0.f43947a);
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return SecretRoomAccessViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                te.h secretReady = SecretRoomAccessViewModel.this.preferences.getSecretReady();
                C02461 c02461 = new C02461(SecretRoomAccessViewModel.this, null);
                this.label = 1;
                if (te.j.k(secretReady, c02461, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1", f = "SecretRoomAccessViewModel.kt", l = {38, 41}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13071 extends cb.m implements Function1 {
        final /* synthetic */ boolean $clean;
        final /* synthetic */ lb.a $onComplete;
        int label;
        final /* synthetic */ SecretRoomAccessViewModel this$0;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1$1", f = "SecretRoomAccessViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02471 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02471(lb.a aVar, ab.e<? super C02471> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02471(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02471) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13071(boolean z10, SecretRoomAccessViewModel secretRoomAccessViewModel, lb.a aVar, ab.e<? super C13071> eVar) {
            super(1, eVar);
            this.$clean = z10;
            this.this$0 = secretRoomAccessViewModel;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C13071(this.$clean, this.this$0, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13071) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        
            if (pe.w0.b(1500, r6) == r0) goto L17;
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
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r7)
                goto L3f
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                ua.v.b(r7)
                goto L34
            L1e:
                ua.v.b(r7)
                boolean r7 = r6.$clean
                if (r7 == 0) goto L34
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r7 = r6.this$0
                cu.todus.android.repositories.RoomsRepository r7 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getRoomsRepository$p(r7)
                r6.label = r3
                java.lang.Object r7 = r7.cleanSecretRooms(r6)
                if (r7 != r0) goto L34
                goto L3e
            L34:
                r6.label = r2
                r1 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r7 = pe.w0.b(r1, r6)
                if (r7 != r0) goto L3f
            L3e:
                return r0
            L3f:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r7 = r6.this$0
                pe.m0 r0 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r7)
                pe.k2 r1 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1$1 r3 = new cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$navigateSecret$1$1
                lb.a r7 = r6.$onComplete
                r2 = 0
                r3.<init>(r7, r2)
                r4 = 2
                r5 = 0
                pe.i.d(r0, r1, r2, r3, r4, r5)
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.C13071.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$resetConfigs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$resetConfigs$1", f = "SecretRoomAccessViewModel.kt", l = {RectListKt.BitOffsetForFocusable, 63, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, MdtaMetadataEntry.TYPE_INDICATOR_INT32, 69}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13081 extends cb.m implements Function2 {
        int label;

        public C13081(ab.e<? super C13081> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return SecretRoomAccessViewModel.this.new C13081(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0061  */
        /* JADX WARN: Code duplicated, block: B:28:0x0070  */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
        
            if (r9.setSecretReady(false, r8) == r0) goto L30;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r8.label
                java.lang.String r2 = ""
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                if (r1 == 0) goto L35
                if (r1 == r7) goto L31
                if (r1 == r6) goto L2d
                if (r1 == r5) goto L29
                if (r1 == r4) goto L25
                if (r1 != r3) goto L1d
                ua.v.b(r9)
                goto L80
            L1d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L25:
                ua.v.b(r9)
                goto L70
            L29:
                ua.v.b(r9)
                goto L61
            L2d:
                ua.v.b(r9)
                goto L52
            L31:
                ua.v.b(r9)
                goto L47
            L35:
                ua.v.b(r9)
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.repositories.RoomsRepository r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getRoomsRepository$p(r9)
                r8.label = r7
                java.lang.Object r9 = r9.cleanSecretRooms(r8)
                if (r9 != r0) goto L47
                goto L7f
            L47:
                r8.label = r6
                r6 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r9 = pe.w0.b(r6, r8)
                if (r9 != r0) goto L52
                goto L7f
            L52:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r9)
                r8.label = r5
                java.lang.Object r9 = r9.setSecretCode(r2, r8)
                if (r9 != r0) goto L61
                goto L7f
            L61:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r9)
                r8.label = r4
                java.lang.Object r9 = r9.setSecretClean(r2, r8)
                if (r9 != r0) goto L70
                goto L7f
            L70:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r9 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r9)
                r8.label = r3
                r1 = 0
                java.lang.Object r9 = r9.setSecretReady(r1, r8)
                if (r9 != r0) goto L80
            L7f:
                return r0
            L80:
                ua.k0 r9 = ua.k0.f43947a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.C13081.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13081) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$setReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel$setReady$1", f = "SecretRoomAccessViewModel.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13091 extends cb.m implements Function1 {
        final /* synthetic */ String $cleanCode;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13091(String str, String str2, ab.e<? super C13091> eVar) {
            super(1, eVar);
            this.$code = str;
            this.$cleanCode = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return SecretRoomAccessViewModel.this.new C13091(this.$code, this.$cleanCode, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13091) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        
            if (r6.setSecretReady(true, r5) == r0) goto L20;
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ua.v.b(r6)
                goto L59
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                ua.v.b(r6)
                goto L4a
            L21:
                ua.v.b(r6)
                goto L39
            L25:
                ua.v.b(r6)
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r6)
                java.lang.String r1 = r5.$code
                r5.label = r4
                java.lang.Object r6 = r6.setSecretCode(r1, r5)
                if (r6 != r0) goto L39
                goto L58
            L39:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r6)
                java.lang.String r1 = r5.$cleanCode
                r5.label = r3
                java.lang.Object r6 = r6.setSecretClean(r1, r5)
                if (r6 != r0) goto L4a
                goto L58
            L4a:
                cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.this
                cu.todus.android.di.PreferencesModule r6 = cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.access$getPreferences$p(r6)
                r5.label = r2
                java.lang.Object r6 = r6.setSecretReady(r4, r5)
                if (r6 != r0) goto L59
            L58:
                return r0
            L59:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.SecretRoomAccessViewModel.C13091.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final b0 getActualCleanCode() {
        return this.actualCleanCode;
    }

    public final b0 getActualCode() {
        return this.actualCode;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final b0 getIsReady() {
        return this.isReady;
    }

    public final void loadingReady() {
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void navigateSecret(boolean clean, lb.a onComplete) {
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13071(clean, this, onComplete, null), 3, null);
    }

    public final void resetConfigs() {
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C13081(null), 3, null);
    }

    public final void setReady(String code, String cleanCode) {
        y.i(code, "code");
        y.i(cleanCode, "cleanCode");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13091(code, cleanCode, null), 3, null);
    }
}
