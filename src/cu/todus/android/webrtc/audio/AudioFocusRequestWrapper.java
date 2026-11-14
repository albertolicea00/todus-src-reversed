package cu.todus.android.webrtc.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioFocusRequestWrapper;", "", "<init>", "()V", "buildRequest", "Landroid/media/AudioFocusRequest;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioFocusRequestWrapper {
    public static final int $stable = 0;

    @SuppressLint({"NewApi"})
    public final AudioFocusRequest buildRequest(AudioManager.OnAudioFocusChangeListener audioFocusChangeListener) {
        y.i(audioFocusChangeListener, "audioFocusChangeListener");
        AudioFocusRequest audioFocusRequestBuild = androidx.media3.common.audio.f.a(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(1).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(audioFocusChangeListener).build();
        y.h(audioFocusRequestBuild, "build(...)");
        return audioFocusRequestBuild;
    }
}
