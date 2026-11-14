package cu.todus.android.uiCompose.main.screen.initInfoProfile;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0003R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/initInfoProfile/InitInfoProfileViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", User.COLUMN_ALIAS, "Lkotlin/Function0;", "Lua/k0;", "onComplete", "updateDisplayName", "(Ljava/lang/String;Llb/a;)V", "Landroid/net/Uri;", "uri", "updateProfilePicture", "(Landroid/net/Uri;Llb/a;)V", "removeImage", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lte/h;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lte/h;", "getOwner", "()Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InitInfoProfileViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final te.h owner;
    private final PreferencesModule preferences;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$removeImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$removeImage$1", f = "InitInfoProfileViewModel.kt", l = {83}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return InitInfoProfileViewModel.this.new AnonymousClass1(eVar);
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
                MainRepository mainRepository = InitInfoProfileViewModel.this.mainRepository;
                this.label = 1;
                obj = mainRepository.removeProfileImage(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            ((Boolean) obj).getClass();
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateDisplayName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateDisplayName$1", f = "InitInfoProfileViewModel.kt", l = {33, 37, 40, 41}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12861 extends cb.m implements Function1 {
        final /* synthetic */ String $alias;
        final /* synthetic */ lb.a $onComplete;
        int I$0;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateDisplayName$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateDisplayName$1$2", f = "InitInfoProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
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
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12861(String str, lb.a aVar, ab.e<? super C12861> eVar) {
            super(1, eVar);
            this.$alias = str;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(InitInfoProfileViewModel initInfoProfileViewModel, String str, lb.a aVar) {
            initInfoProfileViewModel.updateDisplayName(str, aVar);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return InitInfoProfileViewModel.this.new C12861(this.$alias, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12861) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0068  */
        /* JADX WARN: Code duplicated, block: B:26:0x007b A[PHI: r1 r15
          0x007b: PHI (r1v5 int) = (r1v2 int), (r1v15 int) binds: [B:24:0x0078, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]
          0x007b: PHI (r15v13 java.lang.Object) = (r15v10 java.lang.Object), (r15v0 java.lang.Object) binds: [B:24:0x0078, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:28:0x0083  */
        /* JADX WARN: Code duplicated, block: B:31:0x0096  */
        /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        
            if (pe.w0.b(1000, r14) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        
            if (r15.setAppState(r5, r14) == r0) goto L34;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:22:0x0066). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel.C12861.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateProfilePicture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateProfilePicture$1", f = "InitInfoProfileViewModel.kt", l = {RectListKt.BitOffsetForFocusable}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12871 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateProfilePicture$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.initInfoProfile.InitInfoProfileViewModel$updateProfilePicture$1$2", f = "InitInfoProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
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
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12871(Uri uri, lb.a aVar, ab.e<? super C12871> eVar) {
            super(1, eVar);
            this.$uri = uri;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(InitInfoProfileViewModel initInfoProfileViewModel, Uri uri, lb.a aVar) {
            initInfoProfileViewModel.updateProfilePicture(uri, aVar);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return InitInfoProfileViewModel.this.new C12871(this.$uri, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12871) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = InitInfoProfileViewModel.this.mainRepository;
                Uri uri = this.$uri;
                this.label = 1;
                obj = mainRepository.updateProfileImage(uri, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                Function1 setError = InitInfoProfileViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.image_has_not_been_uploaded);
                y.h(string, "getString(...)");
                final InitInfoProfileViewModel initInfoProfileViewModel = InitInfoProfileViewModel.this;
                final Uri uri2 = this.$uri;
                final lb.a aVar = this.$onComplete;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.initInfoProfile.x
                    @Override // lb.a
                    public final Object invoke() {
                        return InitInfoProfileViewModel.C12871.invokeSuspend$lambda$0(initInfoProfileViewModel, uri2, aVar);
                    }
                }, true));
            }
            pe.k.d(ViewModelKt.getViewModelScope(InitInfoProfileViewModel.this), d1.c(), null, new AnonymousClass2(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    public InitInfoProfileViewModel() throws SinglediException {
        PreferencesModule singletonInitializer = PreferencesModule.INSTANCE.getInstance();
        this.preferences = singletonInitializer;
        this.owner = singletonInitializer.ownerFlow();
    }

    public final te.h getOwner() {
        return this.owner;
    }

    public final void removeImage() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void updateDisplayName(String alias, lb.a onComplete) {
        y.i(alias, "alias");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12861(alias, onComplete, null), 3, null);
    }

    public final void updateProfilePicture(Uri uri, lb.a onComplete) {
        y.i(uri, "uri");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12871(uri, onComplete, null), 3, null);
    }
}
