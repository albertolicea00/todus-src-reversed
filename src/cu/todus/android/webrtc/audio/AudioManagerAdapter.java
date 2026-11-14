package cu.todus.android.webrtc.audio;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioManagerAdapter;", "", "", "hasEarpiece", "()Z", "hasSpeakerphone", "Lua/k0;", "setAudioFocus", "()V", "enable", "enableBluetoothSco", "(Z)V", "enableSpeakerphone", "mute", "cacheAudioState", "restoreAudioState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AudioManagerAdapter {
    void cacheAudioState();

    void enableBluetoothSco(boolean enable);

    void enableSpeakerphone(boolean enable);

    boolean hasEarpiece();

    boolean hasSpeakerphone();

    void mute(boolean mute);

    void restoreAudioState();

    void setAudioFocus();
}
