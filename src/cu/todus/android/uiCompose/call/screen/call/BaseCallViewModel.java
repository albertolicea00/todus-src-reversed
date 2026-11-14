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
import j$.util.Objects;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0003J\u0015\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b&\u0010%J\u0015\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0004¢\u0006\u0004\b*\u0010\u0003R\u001a\u0010,\u001a\u00020+8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000\u00148\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0016¨\u00066"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/BaseCallViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "stringRes", "Lua/k0;", "postError", "(I)V", "Lte/b0;", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerCallMediaState", "()Lte/b0;", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/webrtc/CallState;", "callList", "()Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "Lte/p0;", "currentCallState", "()Lte/p0;", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "()Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "Lte/h;", "", "isRinging", "()Lte/h;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "permissionsAccepted", "(Z)V", "endCall", "", "uid", "acceptCall", "(Ljava/lang/String;)V", "rejectCall", "newValue", "updateOwnerCallMediaState", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;)V", "startStateObserver", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "getMainRepository", "()Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "_callSystemState", "Lte/b0;", "callSystemState", "Lte/p0;", "getCallSystemState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BaseCallViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _callSystemState;
    private final p0 callSystemState;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$acceptCall$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$acceptCall$1", f = "CallViewModel.kt", l = {180}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(BaseCallViewModel baseCallViewModel) throws SinglediException {
            baseCallViewModel.postError(R.string.cannot_answer_now);
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(BaseCallViewModel baseCallViewModel) throws SinglediException {
            baseCallViewModel.postError(R.string.network_error);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return BaseCallViewModel.this.new AnonymousClass1(this.$uid, eVar);
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
                MainRepository mainRepository = BaseCallViewModel.this.getMainRepository();
                String str = this.$uid;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.a
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                final BaseCallViewModel baseCallViewModel = BaseCallViewModel.this;
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.b
                    @Override // lb.a
                    public final Object invoke() {
                        return BaseCallViewModel.AnonymousClass1.invokeSuspend$lambda$1(baseCallViewModel);
                    }
                };
                final BaseCallViewModel baseCallViewModel2 = BaseCallViewModel.this;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.call.screen.call.c
                    @Override // lb.a
                    public final Object invoke() {
                        return BaseCallViewModel.AnonymousClass1.invokeSuspend$lambda$2(baseCallViewModel2);
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$rejectCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$rejectCall$1", f = "CallViewModel.kt", l = {191}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11911 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11911(String str, ab.e<? super C11911> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return BaseCallViewModel.this.new C11911(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11911) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = BaseCallViewModel.this.getMainRepository();
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$startStateObserver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$startStateObserver$1", f = "CallViewModel.kt", l = {214}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C11921 extends cb.m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$startStateObserver$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel$startStateObserver$1$1", f = "CallViewModel.kt", l = {216}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;", "it", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/uiCompose/call/screen/call/CallSystemState;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02101 extends cb.m implements Function2 {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BaseCallViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02101(BaseCallViewModel baseCallViewModel, ab.e<? super C02101> eVar) {
                super(2, eVar);
                this.this$0 = baseCallViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02101 c02101 = new C02101(this.this$0, eVar);
                c02101.L$0 = obj;
                return c02101;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CallSystemState callSystemState, ab.e<? super k0> eVar) {
                return ((C02101) create(callSystemState, eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                CallSystemState callSystemState = (CallSystemState) this.L$0;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    Objects.toString(callSystemState);
                    p0 p0VarCurrentCallState = this.this$0.currentCallState();
                    if (p0VarCurrentCallState == null) {
                        return k0.f43947a;
                    }
                    final BaseCallViewModel baseCallViewModel = this.this$0;
                    te.i iVar = new te.i() { // from class: cu.todus.android.uiCompose.call.screen.call.BaseCallViewModel.startStateObserver.1.1.1
                        @Override // te.i
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                            return emit((CallState) obj2, (ab.e<? super k0>) eVar);
                        }

                        public final Object emit(CallState callState, ab.e<? super k0> eVar) {
                            CallSystemState callSystemState2;
                            Objects.toString(callState);
                            if ((callState != null && callState.getCallIsStarted()) || (callState != null && callState.getOwnerIsCalling())) {
                                if (callState != null) {
                                    cb.b.a(callState.getCallIsStarted());
                                }
                                if (callState != null) {
                                    cb.b.a(callState.getOwnerIsCalling());
                                }
                                callSystemState2 = CallSystemState.IN_CALL;
                            } else if (callState == null || callState.getCallIsStarted() || baseCallViewModel.callList().getSize() <= 0) {
                                callSystemState2 = ((callState == null || callState.getCallIsStarted() || baseCallViewModel.callList().getSize() != 0) && callState == null && baseCallViewModel.callList().getSize() > 0) ? CallSystemState.CALL_LIST : CallSystemState.EMPTY;
                            } else {
                                callSystemState2 = CallSystemState.CALL_LIST;
                            }
                            if (baseCallViewModel._callSystemState.getValue() != callSystemState2) {
                                Objects.toString(baseCallViewModel._callSystemState.getValue());
                                Objects.toString(callSystemState2);
                                baseCallViewModel._callSystemState.setValue(callSystemState2);
                            }
                            return k0.f43947a;
                        }
                    };
                    this.L$0 = cb.l.a(callSystemState);
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

        public C11921(ab.e<? super C11921> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return BaseCallViewModel.this.new C11921(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                p0 callSystemState = BaseCallViewModel.this.getCallSystemState();
                C02101 c02101 = new C02101(BaseCallViewModel.this, null);
                this.label = 1;
                if (te.j.k(callSystemState, c02101, this) == objG) {
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
            return ((C11921) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public BaseCallViewModel() {
        b0 b0VarA = r0.a(CallSystemState.STARTING);
        this._callSystemState = b0VarA;
        this.callSystemState = te.j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postError(int stringRes) throws SinglediException {
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String strO = a0.O(string, "-", "", false, 4, null);
        Cause cause = Cause.ERROR;
        String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(stringRes);
        y.h(string2, "getString(...)");
        singletonInitializer.addNewNotification(new InsideNotificationState(strO, cause, string2));
    }

    public final void acceptCall(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(uid, null), 3, null);
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

    public final MainRepository getMainRepository() {
        return this.mainRepository;
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
        this._callSystemState.setValue(value ? CallSystemState.STARTING : CallSystemState.WAITING_PERMISSIONS);
    }

    public final void rejectCall(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11911(uid, null), 3, null);
    }

    public final WebRtcSessionManagerImpl sessionManager() {
        return this.mainRepository.sessionManager();
    }

    public final void startStateObserver() {
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C11921(null), 3, null);
    }

    public final void updateOwnerCallMediaState(CallMediaState newValue) {
        y.i(newValue, "newValue");
        this.mainRepository.changeOwnerCallMediaState(newValue);
    }
}
