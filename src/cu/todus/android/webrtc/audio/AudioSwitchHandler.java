package cu.todus.android.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import j$.util.Objects;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import ua.k0;
import ua.n;
import ua.o;
import ua.q;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR8\u0010\u000f\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0014\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitchHandler;", "Lcu/todus/android/webrtc/audio/AudioHandler;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lua/k0;", TtmlNode.START, "()V", "stop", "Landroid/content/Context;", "Lkotlin/Function2;", "", "Lcu/todus/android/webrtc/audio/AudioDevice;", "Lcu/todus/android/webrtc/audio/AudioDeviceChangeListener;", "audioDeviceChangeListener", "Lkotlin/jvm/functions/Function2;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Ljava/lang/Class;", "preferredDeviceList", "Ljava/util/List;", "Lcu/todus/android/webrtc/audio/AudioSwitch;", "audioSwitch", "Lcu/todus/android/webrtc/audio/AudioSwitch;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioSwitchHandler implements AudioHandler {
    public static final String TAG = "Call:toDus";
    private static final n defaultAudioDeviceChangeListener$delegate;
    private static final n defaultOnAudioFocusChangeListener$delegate;
    private static final n defaultPreferredDeviceList$delegate;
    private Function2 audioDeviceChangeListener;
    private AudioSwitch audioSwitch;
    private final Context context;
    private final Handler handler;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
    private List<? extends Class<? extends AudioDevice>> preferredDeviceList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR)\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitchHandler$Companion;", "", "<init>", "()V", "Lcu/todus/android/webrtc/audio/AudioSwitchHandler$Companion$DefaultOnAudioFocusChangeListener;", "defaultOnAudioFocusChangeListener$delegate", "Lua/n;", "getDefaultOnAudioFocusChangeListener", "()Lcu/todus/android/webrtc/audio/AudioSwitchHandler$Companion$DefaultOnAudioFocusChangeListener;", "defaultOnAudioFocusChangeListener", "cu/todus/android/webrtc/audio/AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1", "defaultAudioDeviceChangeListener$delegate", "getDefaultAudioDeviceChangeListener", "()Lcu/todus/android/webrtc/audio/AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1;", "defaultAudioDeviceChangeListener", "", "Ljava/lang/Class;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "defaultPreferredDeviceList$delegate", "getDefaultPreferredDeviceList", "()Ljava/util/List;", "defaultPreferredDeviceList", "", "TAG", "Ljava/lang/String;", "DefaultOnAudioFocusChangeListener", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1 getDefaultAudioDeviceChangeListener() {
            return (AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1) AudioSwitchHandler.defaultAudioDeviceChangeListener$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DefaultOnAudioFocusChangeListener getDefaultOnAudioFocusChangeListener() {
            return (DefaultOnAudioFocusChangeListener) AudioSwitchHandler.defaultOnAudioFocusChangeListener$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Class<? extends AudioDevice>> getDefaultPreferredDeviceList() {
            return (List) AudioSwitchHandler.defaultPreferredDeviceList$delegate.getValue();
        }

        private Companion() {
        }

        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitchHandler$Companion$DefaultOnAudioFocusChangeListener;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "<init>", "()V", "", "focusChange", "Lua/k0;", "onAudioFocusChange", "(I)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class DefaultOnAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int focusChange) {
            }
        }
    }

    static {
        q qVar = q.NONE;
        defaultOnAudioFocusChangeListener$delegate = o.b(qVar, new lb.a() { // from class: cu.todus.android.webrtc.audio.b
            @Override // lb.a
            public final Object invoke() {
                return AudioSwitchHandler.defaultOnAudioFocusChangeListener_delegate$lambda$0();
            }
        });
        defaultAudioDeviceChangeListener$delegate = o.b(qVar, new lb.a() { // from class: cu.todus.android.webrtc.audio.c
            @Override // lb.a
            public final Object invoke() {
                return AudioSwitchHandler.defaultAudioDeviceChangeListener_delegate$lambda$0();
            }
        });
        defaultPreferredDeviceList$delegate = o.b(qVar, new lb.a() { // from class: cu.todus.android.webrtc.audio.d
            @Override // lb.a
            public final Object invoke() {
                return AudioSwitchHandler.defaultPreferredDeviceList_delegate$lambda$0();
            }
        });
    }

    public AudioSwitchHandler(Context context) {
        y.i(context, "context");
        this.context = context;
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [cu.todus.android.webrtc.audio.AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1] */
    public static final AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1 defaultAudioDeviceChangeListener_delegate$lambda$0() {
        return new Function2() { // from class: cu.todus.android.webrtc.audio.AudioSwitchHandler$Companion$defaultAudioDeviceChangeListener$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((List<? extends AudioDevice>) obj, (AudioDevice) obj2);
                return k0.f43947a;
            }

            public void invoke(List<? extends AudioDevice> audioDevices, AudioDevice selectedAudioDevice) {
                y.i(audioDevices, "audioDevices");
                Objects.toString(selectedAudioDevice);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Companion.DefaultOnAudioFocusChangeListener defaultOnAudioFocusChangeListener_delegate$lambda$0() {
        return new Companion.DefaultOnAudioFocusChangeListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List defaultPreferredDeviceList_delegate$lambda$0() {
        return w.q(AudioDevice.BluetoothHeadset.class, AudioDevice.WiredHeadset.class, AudioDevice.Earpiece.class, AudioDevice.Speakerphone.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0(AudioSwitchHandler audioSwitchHandler) {
        Context context = audioSwitchHandler.context;
        AudioManager.OnAudioFocusChangeListener defaultOnAudioFocusChangeListener = audioSwitchHandler.onAudioFocusChangeListener;
        if (defaultOnAudioFocusChangeListener == null) {
            defaultOnAudioFocusChangeListener = INSTANCE.getDefaultOnAudioFocusChangeListener();
        }
        List<? extends Class<? extends AudioDevice>> defaultPreferredDeviceList = audioSwitchHandler.preferredDeviceList;
        if (defaultPreferredDeviceList == null) {
            defaultPreferredDeviceList = INSTANCE.getDefaultPreferredDeviceList();
        }
        AudioSwitch audioSwitch = new AudioSwitch(context, defaultOnAudioFocusChangeListener, defaultPreferredDeviceList, null, 8, null);
        audioSwitchHandler.audioSwitch = audioSwitch;
        Function2 defaultAudioDeviceChangeListener = audioSwitchHandler.audioDeviceChangeListener;
        if (defaultAudioDeviceChangeListener == null) {
            defaultAudioDeviceChangeListener = INSTANCE.getDefaultAudioDeviceChangeListener();
        }
        audioSwitch.start(defaultAudioDeviceChangeListener);
        audioSwitch.activate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$0(AudioSwitchHandler audioSwitchHandler) {
        AudioSwitch audioSwitch = audioSwitchHandler.audioSwitch;
        if (audioSwitch != null) {
            audioSwitch.stop();
        }
        audioSwitchHandler.audioSwitch = null;
    }

    @Override // cu.todus.android.webrtc.audio.AudioHandler
    public void start() {
        Objects.toString(this.audioSwitch);
        if (this.audioSwitch == null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler.post(new Runnable() { // from class: cu.todus.android.webrtc.audio.f
                @Override // java.lang.Runnable
                public final void run() {
                    AudioSwitchHandler.start$lambda$0(this.f28764c);
                }
            });
        }
    }

    @Override // cu.todus.android.webrtc.audio.AudioHandler
    public void stop() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.post(new Runnable() { // from class: cu.todus.android.webrtc.audio.e
            @Override // java.lang.Runnable
            public final void run() {
                AudioSwitchHandler.stop$lambda$0(this.f28763c);
            }
        });
    }
}
