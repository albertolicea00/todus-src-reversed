package cu.todus.android.uiCompose.call.screen.call;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import cu.z17.singledi.SinglediException;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#¢\u0006\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00138\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0015¨\u00064"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/CallViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lte/b0;", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerCallMediaState", "()Lte/b0;", "newValue", "Lua/k0;", "updateOwnerCallMediaState", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;)V", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/webrtc/CallState;", "callList", "()Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "Lte/p0;", "currentCallState", "()Lte/p0;", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "()Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "endCall", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "permissionsAccepted", "(Z)V", "", "uid", "acceptCall", "(Ljava/lang/String;)V", "rejectCall", "Lte/h;", "isRinging", "()Lte/h;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "_callSystemState", "Lte/b0;", "callSystemState", "Lte/p0;", "getCallSystemState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _callSystemState;
    private final p0 callSystemState;
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.CallViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.CallViewModel$1", f = "CallViewModel.kt", l = {87}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.CallViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.CallViewModel$1$1", f = "CallViewModel.kt", l = {88}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "it", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02121 extends cb.m implements Function2 {
            int label;
            final /* synthetic */ CallViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02121(CallViewModel callViewModel, ab.e<? super C02121> eVar) {
                super(2, eVar);
                this.this$0 = callViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02121(this.this$0, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CallSystemState callSystemState, ab.e<? super k0> eVar) {
                return ((C02121) create(callSystemState, eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    p0 p0VarCurrentCallState = this.this$0.currentCallState();
                    if (p0VarCurrentCallState == null) {
                        return k0.f43947a;
                    }
                    final CallViewModel callViewModel = this.this$0;
                    te.i iVar = new te.i() { // from class: cu.todus.android.uiCompose.call.screen.call.CallViewModel.1.1.1
                        @Override // te.i
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                            return emit((CallState) obj2, (ab.e<? super k0>) eVar);
                        }

                        public final Object emit(CallState callState, ab.e<? super k0> eVar) {
                            if ((callState != null && callState.getCallIsStarted()) || (callState != null && callState.getOwnerIsCalling())) {
                                Object value = callViewModel._callSystemState.getValue();
                                CallSystemState callSystemState = CallSystemState.IN_CALL;
                                if (value != callSystemState) {
                                    callViewModel._callSystemState.setValue(callSystemState);
                                }
                            } else if (callState != null && !callState.getCallIsStarted() && callViewModel.callList().getSize() > 0) {
                                Object value2 = callViewModel._callSystemState.getValue();
                                CallSystemState callSystemState2 = CallSystemState.CALL_LIST;
                                if (value2 != callSystemState2) {
                                    callViewModel._callSystemState.setValue(callSystemState2);
                                }
                            } else if (callState != null && !callState.getCallIsStarted() && callViewModel.callList().getSize() == 0) {
                                Object value3 = callViewModel._callSystemState.getValue();
                                CallSystemState callSystemState3 = CallSystemState.EMPTY;
                                if (value3 != callSystemState3) {
                                    callViewModel._callSystemState.setValue(callSystemState3);
                                }
                            } else if (callState == null && callViewModel.callList().getSize() > 0) {
                                Object value4 = callViewModel._callSystemState.getValue();
                                CallSystemState callSystemState4 = CallSystemState.CALL_LIST;
                                if (value4 != callSystemState4) {
                                    callViewModel._callSystemState.setValue(callSystemState4);
                                }
                            } else if (callState == null && callViewModel.callList().getSize() == 0 && callViewModel._callSystemState.getValue() != CallSystemState.CALL_LIST) {
                                callViewModel._callSystemState.setValue(CallSystemState.EMPTY);
                            }
                            String.valueOf(callViewModel._callSystemState.getValue());
                            return k0.f43947a;
                        }
                    };
                    this.label = 1;
                    if (p0VarCurrentCallState.collect(iVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                throw new ua.j();
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return CallViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                p0 callSystemState = CallViewModel.this.getCallSystemState();
                C02121 c02121 = new C02121(CallViewModel.this, null);
                this.label = 1;
                if (te.j.k(callSystemState, c02121, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.CallViewModel$acceptCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.CallViewModel$acceptCall$1", f = "CallViewModel.kt", l = {52}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11931 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11931(String str, ab.e<? super C11931> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1() throws SinglediException {
            MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.cannot_answer_now);
            y.h(string2, "getString(...)");
            singletonInitializer.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2() throws SinglediException {
            MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
            y.h(string2, "getString(...)");
            singletonInitializer.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CallViewModel.this.new C11931(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11931) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = CallViewModel.this.mainRepository;
                String str = this.$uid;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.s
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.t
                    @Override // lb.a
                    public final Object invoke() {
                        return CallViewModel.C11931.invokeSuspend$lambda$1();
                    }
                };
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.u
                    @Override // lb.a
                    public final Object invoke() {
                        return CallViewModel.C11931.invokeSuspend$lambda$2();
                    }
                };
                this.label = 1;
                if (mainRepository.acceptCallProcess(str, aVar, aVar2, aVar3, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.CallViewModel$rejectCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.CallViewModel$rejectCall$1", f = "CallViewModel.kt", l = {79}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11941 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11941(String str, ab.e<? super C11941> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CallViewModel.this.new C11941(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11941) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = CallViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.rejectCallProcess(str, this) == objG) {
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

    public CallViewModel() {
        b0 b0VarA = r0.a(CallSystemState.STARTING);
        this._callSystemState = b0VarA;
        this.callSystemState = te.j.b(b0VarA);
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void acceptCall(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11931(uid, null), 3, null);
    }

    public final Z17MutableListFlow<CallState> callList() {
        return this.mainRepository.requestingCalls();
    }

    public final p0 currentCallState() {
        return this.mainRepository.currentCallState();
    }

    public final void endCall() {
        String with;
        CallState callState;
        MainRepository mainRepository = this.mainRepository;
        p0 p0VarCurrentCallState = currentCallState();
        if (p0VarCurrentCallState == null || (callState = (CallState) p0VarCurrentCallState.getValue()) == null || (with = callState.getWith()) == null) {
            with = "";
        }
        mainRepository.endCall(with);
    }

    public final p0 getCallSystemState() {
        return this.callSystemState;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final te.h isRinging() {
        return this.mainRepository.getIsRinging();
    }

    public final b0 ownerCallMediaState() {
        return this.mainRepository.ownerCallMediaState();
    }

    public final void permissionsAccepted(boolean value) {
        if (value) {
            this._callSystemState.setValue(CallSystemState.STARTING);
        } else {
            this._callSystemState.setValue(CallSystemState.WAITING_PERMISSIONS);
        }
    }

    public final void rejectCall(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11941(uid, null), 3, null);
    }

    public final WebRtcSessionManagerImpl sessionManager() {
        return this.mainRepository.sessionManager();
    }

    public final void updateOwnerCallMediaState(CallMediaState newValue) {
        y.i(newValue, "newValue");
        this.mainRepository.changeOwnerCallMediaState(newValue);
    }
}
