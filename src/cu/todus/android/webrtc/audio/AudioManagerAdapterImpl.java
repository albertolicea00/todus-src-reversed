package cu.todus.android.webrtc.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0019\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioManagerAdapterImpl;", "Lcu/todus/android/webrtc/audio/AudioManagerAdapter;", "Landroid/content/Context;", "context", "Landroid/media/AudioManager;", "audioManager", "Lcu/todus/android/webrtc/audio/AudioFocusRequestWrapper;", "audioFocusRequest", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioFocusChangeListener", "<init>", "(Landroid/content/Context;Landroid/media/AudioManager;Lcu/todus/android/webrtc/audio/AudioFocusRequestWrapper;Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "", "hasEarpiece", "()Z", "hasSpeakerphone", "Lua/k0;", "setAudioFocus", "()V", "enable", "enableBluetoothSco", "(Z)V", "enableSpeakerphone", "mute", "cacheAudioState", "restoreAudioState", "Landroid/content/Context;", "Landroid/media/AudioManager;", "Lcu/todus/android/webrtc/audio/AudioFocusRequestWrapper;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "", "savedAudioMode", "I", "savedIsMicrophoneMuted", "Z", "savedSpeakerphoneEnabled", "Landroid/media/AudioFocusRequest;", "audioRequest", "Landroid/media/AudioFocusRequest;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioManagerAdapterImpl implements AudioManagerAdapter {
    public static final int $stable = 8;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final AudioFocusRequestWrapper audioFocusRequest;
    private final AudioManager audioManager;
    private AudioFocusRequest audioRequest;
    private final Context context;
    private int savedAudioMode;
    private boolean savedIsMicrophoneMuted;
    private boolean savedSpeakerphoneEnabled;

    public AudioManagerAdapterImpl(Context context, AudioManager audioManager, AudioFocusRequestWrapper audioFocusRequest, AudioManager.OnAudioFocusChangeListener audioFocusChangeListener) {
        y.i(context, "context");
        y.i(audioManager, "audioManager");
        y.i(audioFocusRequest, "audioFocusRequest");
        y.i(audioFocusChangeListener, "audioFocusChangeListener");
        this.context = context;
        this.audioManager = audioManager;
        this.audioFocusRequest = audioFocusRequest;
        this.audioFocusChangeListener = audioFocusChangeListener;
        Objects.toString(audioFocusChangeListener);
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    public void cacheAudioState() {
        this.savedAudioMode = this.audioManager.getMode();
        this.savedIsMicrophoneMuted = this.audioManager.isMicrophoneMute();
        this.savedSpeakerphoneEnabled = this.audioManager.isSpeakerphoneOn();
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    public void enableBluetoothSco(boolean enable) {
        AudioManager audioManager = this.audioManager;
        if (enable) {
            audioManager.startBluetoothSco();
        } else {
            audioManager.stopBluetoothSco();
        }
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    public void enableSpeakerphone(boolean enable) {
        this.audioManager.setSpeakerphoneOn(enable);
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    public boolean hasEarpiece() {
        return this.context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    @SuppressLint({"NewApi"})
    public boolean hasSpeakerphone() {
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.audio.output")) {
            return true;
        }
        AudioDeviceInfo[] devices = this.audioManager.getDevices(2);
        y.f(devices);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    public void mute(boolean mute) {
        this.audioManager.setMicrophoneMute(mute);
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    @SuppressLint({"NewApi"})
    public void restoreAudioState() {
        this.audioManager.setMode(this.savedAudioMode);
        mute(this.savedIsMicrophoneMuted);
        enableSpeakerphone(this.savedSpeakerphoneEnabled);
        if (Build.VERSION.SDK_INT < 26) {
            Objects.toString(this.audioFocusChangeListener);
            this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
            return;
        }
        AudioFocusRequest audioFocusRequest = this.audioRequest;
        if (audioFocusRequest != null) {
            audioFocusRequest.toString();
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    @Override // cu.todus.android.webrtc.audio.AudioManagerAdapter
    @SuppressLint({"NewApi"})
    public void setAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequestBuildRequest = this.audioFocusRequest.buildRequest(this.audioFocusChangeListener);
            this.audioRequest = audioFocusRequestBuildRequest;
            if (audioFocusRequestBuildRequest != null) {
                this.audioManager.requestAudioFocus(audioFocusRequestBuildRequest);
            }
        } else {
            this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 0, 2);
        }
        this.audioManager.setMode(3);
    }

    public /* synthetic */ AudioManagerAdapterImpl(Context context, AudioManager audioManager, AudioFocusRequestWrapper audioFocusRequestWrapper, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i10, p pVar) {
        this(context, audioManager, (i10 & 4) != 0 ? new AudioFocusRequestWrapper() : audioFocusRequestWrapper, onAudioFocusChangeListener);
    }
}
