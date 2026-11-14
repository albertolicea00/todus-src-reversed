package cu.todus.android.uiCompose.main;

import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MediaModule;
import cu.todus.android.notification.INotificationFilter;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.xmpp.ConnectionState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.d0;
import pe.w0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00160\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcu/todus/android/uiCompose/main/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Lua/k0;", "forceStartConnection", "sendAppOpen", "sendAppClose", "Landroid/content/Intent;", "intent", "addNewIntent", "(Landroid/content/Intent;)V", "resetIntent", "stopMedia", "Lcu/todus/android/notification/INotificationFilter;", "previewsNotificationFilter", "Lcu/todus/android/notification/INotificationFilter;", "getPreviewsNotificationFilter", "()Lcu/todus/android/notification/INotificationFilter;", "setPreviewsNotificationFilter", "(Lcu/todus/android/notification/INotificationFilter;)V", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "_newIntent", "Lte/b0;", "Lte/p0;", "newIntent", "Lte/p0;", "getNewIntent", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainActivityViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _newIntent;
    private final p0 newIntent;
    private INotificationFilter previewsNotificationFilter;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.MainActivityViewModel$forceStartConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.MainActivityViewModel$forceStartConnection$1", f = "MainActivityViewModel.kt", l = {26}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    this.label = 1;
                    if (w0.b(1000L, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
                if (!d0.q0(((Owner) singletonInitializer.getOwner().invoke()).getToken()) && ((ConnectionState) singletonInitializer.getConnectionState().getValue()).isDisconnected()) {
                    singletonInitializer.forceReconnect();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.MainActivityViewModel$sendAppClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.MainActivityViewModel$sendAppClose$1", f = "MainActivityViewModel.kt", l = {52}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11951 extends cb.m implements Function1 {
        Object L$0;
        int label;

        public C11951(ab.e<? super C11951> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C11951(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11951) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
                    this.L$0 = cb.l.a(singletonInitializer);
                    this.label = 1;
                    if (singletonInitializer.sendAppClose(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.MainActivityViewModel$sendAppOpen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.MainActivityViewModel$sendAppOpen$1", f = "MainActivityViewModel.kt", l = {40}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11961 extends cb.m implements Function1 {
        Object L$0;
        int label;

        public C11961(ab.e<? super C11961> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C11961(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11961) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
                    this.L$0 = cb.l.a(singletonInitializer);
                    this.label = 1;
                    if (singletonInitializer.sendOnline(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return k0.f43947a;
        }
    }

    public MainActivityViewModel() {
        b0 b0VarA = r0.a(FlowsState.INSTANCE.notRequested());
        this._newIntent = b0VarA;
        this.newIntent = te.j.b(b0VarA);
    }

    public final void addNewIntent(Intent intent) {
        y.i(intent, "intent");
        this._newIntent.setValue(FlowsState.INSTANCE.success(intent));
    }

    public final void forceStartConnection() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final p0 getNewIntent() {
        return this.newIntent;
    }

    public final INotificationFilter getPreviewsNotificationFilter() {
        return this.previewsNotificationFilter;
    }

    public final void resetIntent() {
        this._newIntent.setValue(FlowsState.INSTANCE.notRequested());
    }

    public final void sendAppClose() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11951(null), 3, null);
    }

    public final void sendAppOpen() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11961(null), 3, null);
    }

    public final void setPreviewsNotificationFilter(INotificationFilter iNotificationFilter) {
        this.previewsNotificationFilter = iNotificationFilter;
    }

    public final void stopMedia() {
        MediaModule instanceOrNull = MediaModule.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.stopRecorder();
        }
        if (instanceOrNull != null) {
            instanceOrNull.stopPlaying();
        }
    }
}
