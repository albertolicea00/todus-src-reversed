package cu.todus.android.uiCompose.call.screen.audio;

import android.util.Log;
import androidx.compose.runtime.State;
import cu.todus.android.di.MediaModule;
import cu.todus.android.uiCompose.call.screen.call.AudioCallViewModel;
import cu.todus.android.uiCompose.call.screen.call.CallSystemState;
import cu.todus.android.webrtc.ProximitySensorManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.call.screen.audio.AudioCallScreenKt$AudioCallScreen$1$1", f = "AudioCallScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class AudioCallScreenKt$AudioCallScreen$1$1 extends cb.m implements Function2 {
    final /* synthetic */ ProximitySensorManager $proximitySensorManager;
    final /* synthetic */ State<CallSystemState> $state$delegate;
    final /* synthetic */ AudioCallViewModel $viewModel;
    int label;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallSystemState.values().length];
            try {
                iArr[CallSystemState.IN_CALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallSystemState.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CallSystemState.CALL_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AudioCallScreenKt$AudioCallScreen$1$1(AudioCallViewModel audioCallViewModel, ProximitySensorManager proximitySensorManager, State<? extends CallSystemState> state, ab.e<? super AudioCallScreenKt$AudioCallScreen$1$1> eVar) {
        super(2, eVar);
        this.$viewModel = audioCallViewModel;
        this.$proximitySensorManager = proximitySensorManager;
        this.$state$delegate = state;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new AudioCallScreenKt$AudioCallScreen$1$1(this.$viewModel, this.$proximitySensorManager, this.$state$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        int iW;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        int i10 = WhenMappings.$EnumSwitchMapping$0[AudioCallScreenKt.AudioCallScreen$lambda$0(this.$state$delegate).ordinal()];
        if (i10 == 1) {
            this.$viewModel.disableSpeaker();
            try {
                MediaModule.INSTANCE.getInstance().resetSpeakerStateForAudioCall();
            } catch (Exception e10) {
                cb.b.d(Log.e("AudioCallScreen", "Error resetting MediaModule speaker state", e10));
            }
            if (this.$proximitySensorManager.hasProximitySensor()) {
                this.$proximitySensorManager.startListening();
                iW = Log.d("AudioCallScreen", "🟢 Proximity sensor STARTED (AudioCall)");
            } else {
                iW = Log.w("AudioCallScreen", "⚠️ Device has NO proximity sensor");
            }
            cb.b.d(iW);
        } else if (i10 == 2 || i10 == 3) {
            this.$viewModel.stopRingContinuousNew();
            this.$proximitySensorManager.stopListening();
            try {
                MediaModule.INSTANCE.getInstance().enableAutoSpeakerControl();
                k0 k0Var = k0.f43947a;
            } catch (Exception e11) {
                cb.b.d(Log.e("AudioCallScreen", "Error re-enabling auto-speaker control", e11));
            }
        } else {
            this.$proximitySensorManager.stopListening();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((AudioCallScreenKt$AudioCallScreen$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
