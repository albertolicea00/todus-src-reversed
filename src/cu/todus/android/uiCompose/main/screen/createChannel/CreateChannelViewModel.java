package cu.todus.android.uiCompose.main.screen.createChannel;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.R;
import cu.todus.android.di.MainModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/createChannel/CreateChannelViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "channelName", "Landroid/net/Uri;", "imageUri", "Lkotlin/Function0;", "Lua/k0;", "onCreated", "onComplete", "createChannel", "(Ljava/lang/String;Landroid/net/Uri;Llb/a;Llb/a;)V", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "getMainRepository", "()Lcu/todus/android/repositories/MainRepository;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CreateChannelViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1", f = "CreateChannelViewModel.kt", l = {30}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $channelName;
        final /* synthetic */ Uri $imageUri;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onCreated;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1$1", f = "CreateChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02371 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onCreated;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02371(lb.a aVar, ab.e<? super C02371> eVar) {
                super(2, eVar);
                this.$onCreated = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02371(this.$onCreated, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onCreated.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02371) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.createChannel.CreateChannelViewModel$createChannel$1$3", f = "CreateChannelViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onComplete, eVar);
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
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Uri uri, lb.a aVar, lb.a aVar2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$channelName = str;
            this.$imageUri = uri;
            this.$onCreated = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(CreateChannelViewModel createChannelViewModel, String str, Uri uri, lb.a aVar, lb.a aVar2) {
            createChannelViewModel.createChannel(str, uri, aVar, aVar2);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CreateChannelViewModel.this.new AnonymousClass1(this.$channelName, this.$imageUri, this.$onCreated, this.$onComplete, eVar);
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
                MainRepository mainRepository = CreateChannelViewModel.this.getMainRepository();
                String str = this.$channelName;
                Uri uri = this.$imageUri;
                this.label = 1;
                obj = mainRepository.createChannel(str, uri, this);
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
                pe.k.d(ViewModelKt.getViewModelScope(CreateChannelViewModel.this), d1.c(), null, new C02371(this.$onCreated, null), 2, null);
                MainRepository mainRepository2 = CreateChannelViewModel.this.getMainRepository();
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CONGRATS;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.channel_has_not_been_created);
                y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
            } else {
                Function1 setError = CreateChannelViewModel.this.getMainRepository().getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.you_channel_has_been_created);
                y.h(string3, "getString(...)");
                final CreateChannelViewModel createChannelViewModel = CreateChannelViewModel.this;
                final String str2 = this.$channelName;
                final Uri uri2 = this.$imageUri;
                final lb.a aVar = this.$onCreated;
                final lb.a aVar2 = this.$onComplete;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.createChannel.t
                    @Override // lb.a
                    public final Object invoke() {
                        return CreateChannelViewModel.AnonymousClass1.invokeSuspend$lambda$0(createChannelViewModel, str2, uri2, aVar, aVar2);
                    }
                }, true));
            }
            pe.k.d(ViewModelKt.getViewModelScope(CreateChannelViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    public final void createChannel(String channelName, Uri imageUri, lb.a onCreated, lb.a onComplete) {
        y.i(channelName, "channelName");
        y.i(onCreated, "onCreated");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(channelName, imageUri, onCreated, onComplete, null), 3, null);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final MainRepository getMainRepository() {
        return this.mainRepository;
    }
}
