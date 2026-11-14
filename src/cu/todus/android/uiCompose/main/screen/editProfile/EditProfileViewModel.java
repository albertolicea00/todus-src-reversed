package cu.todus.android.uiCompose.main.screen.editProfile;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import org.jivesoftware.smackx.mam.element.MamElements;
import pe.d1;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcu/todus/android/uiCompose/main/screen/editProfile/EditProfileViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lua/k0;", "loadOwnerData", "", "newDisplayName", "newBio", "Lkotlin/Function0;", "onComplete", "updateDisplayNameAndBio", "(Ljava/lang/String;Ljava/lang/String;Llb/a;)V", "Landroid/net/Uri;", "uri", "updateProfileImage", "(Landroid/net/Uri;Llb/a;)V", "deleteProfileImage", "(Llb/a;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lte/b0;", "Lcu/todus/android/data/preferences/Owner;", "_ownerData", "Lte/b0;", "Lte/p0;", "ownerData", "Lte/p0;", "getOwnerData", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EditProfileViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _ownerData;
    private final MainRepository mainRepository;
    private final p0 ownerData;
    private final PreferencesModule preferences;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$deleteProfileImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$deleteProfileImage$1", f = "EditProfileViewModel.kt", l = {77}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$deleteProfileImage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$deleteProfileImage$1$1", f = "EditProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02391 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02391(lb.a aVar, ab.e<? super C02391> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02391(this.$onComplete, eVar);
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
                return ((C02391) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return EditProfileViewModel.this.new AnonymousClass1(this.$onComplete, eVar);
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
                v.b(obj);
                MainRepository mainRepository = EditProfileViewModel.this.mainRepository;
                this.label = 1;
                if (mainRepository.removeProfileImage(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(EditProfileViewModel.this), d1.c(), null, new C02391(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$loadOwnerData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$loadOwnerData$1", f = "EditProfileViewModel.kt", l = {29}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12821 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$loadOwnerData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$loadOwnerData$1$1", f = "EditProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/preferences/Owner;", MamElements.MamResultExtension.ELEMENT, "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/preferences/Owner;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02401 extends cb.m implements Function2 {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ EditProfileViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02401(EditProfileViewModel editProfileViewModel, ab.e<? super C02401> eVar) {
                super(2, eVar);
                this.this$0 = editProfileViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02401 c02401 = new C02401(this.this$0, eVar);
                c02401.L$0 = obj;
                return c02401;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Owner owner, ab.e<? super k0> eVar) {
                return ((C02401) create(owner, eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Owner owner = (Owner) this.L$0;
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                if (owner != null) {
                    this.this$0._ownerData.setValue(owner);
                }
                return k0.f43947a;
            }
        }

        public C12821(ab.e<? super C12821> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return EditProfileViewModel.this.new C12821(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                te.h hVarOwnerFlow = EditProfileViewModel.this.preferences.ownerFlow();
                C02401 c02401 = new C02401(EditProfileViewModel.this, null);
                this.label = 1;
                if (te.j.k(hVarOwnerFlow, c02401, this) == objG) {
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
            return ((C12821) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateDisplayNameAndBio$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateDisplayNameAndBio$1", f = "EditProfileViewModel.kt", l = {39, 40}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12831 extends cb.m implements Function1 {
        final /* synthetic */ String $newBio;
        final /* synthetic */ String $newDisplayName;
        final /* synthetic */ lb.a $onComplete;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateDisplayNameAndBio$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateDisplayNameAndBio$1$1", f = "EditProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02411 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02411(lb.a aVar, ab.e<? super C02411> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02411(this.$onComplete, eVar);
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
                return ((C02411) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12831(String str, String str2, lb.a aVar, ab.e<? super C12831> eVar) {
            super(1, eVar);
            this.$newDisplayName = str;
            this.$newBio = str2;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return EditProfileViewModel.this.new C12831(this.$newDisplayName, this.$newBio, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12831) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            boolean z10;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = EditProfileViewModel.this.mainRepository;
                String str = this.$newDisplayName;
                this.label = 1;
                obj = mainRepository.updateAlias(str, this);
                if (obj != objG) {
                }
                return objG;
            }
            if (i10 == 1) {
                v.b(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z10 = this.Z$0;
                v.b(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (z10 && zBooleanValue) {
                MainRepository mainRepository2 = EditProfileViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.you_profile_has_been_edited);
                y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            }
            pe.k.d(ViewModelKt.getViewModelScope(EditProfileViewModel.this), d1.c(), null, new C02411(this.$onComplete, null), 2, null);
            return k0.f43947a;
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            MainRepository mainRepository3 = EditProfileViewModel.this.mainRepository;
            String str2 = this.$newBio;
            this.Z$0 = zBooleanValue2;
            this.label = 2;
            Object objUpdateBio = mainRepository3.updateBio(str2, this);
            if (objUpdateBio != objG) {
                z10 = zBooleanValue2;
                obj = objUpdateBio;
                boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                if (z10) {
                    MainRepository mainRepository4 = EditProfileViewModel.this.mainRepository;
                    String string3 = UUID.randomUUID().toString();
                    y.h(string3, "toString(...)");
                    String strO2 = a0.O(string3, "-", "", false, 4, null);
                    Cause cause2 = Cause.CORRECT;
                    String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.you_profile_has_been_edited);
                    y.h(string4, "getString(...)");
                    mainRepository4.addNewNotification(new InsideNotificationState(strO2, cause2, string4));
                }
                pe.k.d(ViewModelKt.getViewModelScope(EditProfileViewModel.this), d1.c(), null, new C02411(this.$onComplete, null), 2, null);
                return k0.f43947a;
            }
            return objG;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateProfileImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateProfileImage$1", f = "EditProfileViewModel.kt", l = {58}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12841 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateProfileImage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.editProfile.EditProfileViewModel$updateProfileImage$1$1", f = "EditProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02421 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02421(lb.a aVar, ab.e<? super C02421> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02421(this.$onComplete, eVar);
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
                return ((C02421) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12841(Uri uri, lb.a aVar, ab.e<? super C12841> eVar) {
            super(1, eVar);
            this.$uri = uri;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return EditProfileViewModel.this.new C12841(this.$uri, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12841) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = EditProfileViewModel.this.mainRepository;
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
                v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                MainRepository mainRepository2 = EditProfileViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.you_profile_has_been_edited);
                y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            }
            pe.k.d(ViewModelKt.getViewModelScope(EditProfileViewModel.this), d1.c(), null, new C02421(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    public EditProfileViewModel() throws SinglediException {
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        this.mainRepository = singletonInitializer;
        this.preferences = PreferencesModule.INSTANCE.getInstance();
        b0 b0VarA = r0.a(singletonInitializer.getOwner().invoke());
        this._ownerData = b0VarA;
        this.ownerData = te.j.b(b0VarA);
    }

    public final void deleteProfileImage(lb.a onComplete) {
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(onComplete, null), 3, null);
    }

    public final p0 getOwnerData() {
        return this.ownerData;
    }

    public final void loadOwnerData() {
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12821(null), 3, null);
    }

    public final void updateDisplayNameAndBio(String newDisplayName, String newBio, lb.a onComplete) {
        y.i(newDisplayName, "newDisplayName");
        y.i(newBio, "newBio");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12831(newDisplayName, newBio, onComplete, null), 3, null);
    }

    public final void updateProfileImage(Uri uri, lb.a onComplete) {
        y.i(uri, "uri");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12841(uri, onComplete, null), 3, null);
    }
}
