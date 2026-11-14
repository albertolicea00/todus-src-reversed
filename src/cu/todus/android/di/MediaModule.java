package cu.todus.android.di;

import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.media.player.MediaPlayerStatus;
import cu.todus.android.media.recorder.AndroidAudioRecorder;
import cu.todus.android.media.recorder.RecorderId;
import cu.z17.singledi.SingletonInitializer;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import te.b0;
import te.p0;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 s2\u00020\u0001:\u0001sB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b\"\u0010\u000bJ\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJ\u0015\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\t¢\u0006\u0004\b(\u0010\u000bJ\r\u0010)\u001a\u00020\t¢\u0006\u0004\b)\u0010\u000bJ\r\u0010*\u001a\u00020\t¢\u0006\u0004\b*\u0010\u000bJ\r\u0010+\u001a\u00020\t¢\u0006\u0004\b+\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,R\"\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001f\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020<038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00106R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020<078\u0006¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010;R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00106R\u001f\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016078\u0006¢\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010;R\"\u0010C\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010!R\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001e038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00106R(\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00109\u001a\u0004\bJ\u0010;\"\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Z\u001a\b\u0018\u00010YR\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u0004\u0018\u00010\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010_\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010'R\u0016\u0010d\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010e\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010`R\u0016\u0010f\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010`R\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020$038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u00106R\u001d\u0010k\u001a\b\u0012\u0004\u0012\u00020$078\u0006¢\u0006\f\n\u0004\bk\u00109\u001a\u0004\bk\u0010;R\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010`¨\u0006t"}, d2 = {"Lcu/todus/android/di/MediaModule;", "", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "providesAudioRecorder", "(Landroid/content/Context;)Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "Lua/k0;", "initializePlayer", "()V", "listenBTDevice", "checkForScreen", "playRingWithSilenceNew", "", "id", "Ljava/io/File;", "startRecorder", "(Ljava/lang/String;)Ljava/io/File;", "stopRecorder", "()Ljava/io/File;", "Lcu/todus/android/media/player/MediaPlayerData;", "mpd", "context", "startPlaying", "(Lcu/todus/android/media/player/MediaPlayerData;Landroid/content/Context;)V", "pausePlaying", "playPlaying", "stopPlaying", "", "position", "setMediaPlayerPosition", "(I)V", "resetSpeakerStateForAudioCall", "enableAutoSpeakerControl", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "setVideoCallActive", "(Z)V", "startRing", "stopRing", "startRingContinuousNew", "stopRingContinuousNew", "Landroid/content/Context;", "audioRecorder", "Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "getAudioRecorder", "()Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "setAudioRecorder", "(Lcu/todus/android/media/recorder/AndroidAudioRecorder;)V", "Lte/b0;", "Lcu/todus/android/media/recorder/RecorderId;", "_isRecording", "Lte/b0;", "Lte/p0;", "recording", "Lte/p0;", "getRecording", "()Lte/p0;", "Lcu/todus/android/media/player/MediaPlayerStatus;", "_playerStatus", "playerStatus", "getPlayerStatus", "_actualPlaying", "actualPlaying", "getActualPlaying", "actualPlayingDuration", "I", "getActualPlayingDuration", "()I", "setActualPlayingDuration", "_actualPlayingTime", "actualPlayingTime", "getActualPlayingTime", "setActualPlayingTime", "(Lte/p0;)V", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/SensorManager;", "Landroid/hardware/Sensor;", "proximitySensor", "Landroid/hardware/Sensor;", "Landroid/os/PowerManager;", "pm", "Landroid/os/PowerManager;", "Landroid/os/PowerManager$WakeLock;", "wl", "Landroid/os/PowerManager$WakeLock;", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "checkerActiveInCall", "Z", "getCheckerActiveInCall", "()Z", "setCheckerActiveInCall", "_isVideoCallActive", "isInSpeaker", "isAudioCallMode", "Landroid/bluetooth/BluetoothManager;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "_isHeadsetConnected", "isHeadsetConnected", "Landroid/media/ToneGenerator;", "dtmfGenerator", "Landroid/media/ToneGenerator;", "Landroid/os/Handler;", "ringHandlerNew", "Landroid/os/Handler;", "isRingingActiveNew", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaModule {
    private b0 _actualPlaying;
    private b0 _actualPlayingTime;
    private final b0 _isHeadsetConnected;
    private final b0 _isRecording;
    private boolean _isVideoCallActive;
    private final b0 _playerStatus;
    private final p0 actualPlaying;
    private int actualPlayingDuration;
    private p0 actualPlayingTime;
    private final Context appContext;
    private final AudioManager audioManager;
    private AndroidAudioRecorder audioRecorder;
    private final BluetoothManager bluetoothManager;
    private boolean checkerActiveInCall;
    private final ToneGenerator dtmfGenerator;
    private boolean isAudioCallMode;
    private final p0 isHeadsetConnected;
    private boolean isInSpeaker;
    private boolean isRingingActiveNew;
    private MediaPlayer mediaPlayer;
    private final p0 playerStatus;
    private final PowerManager pm;
    private Sensor proximitySensor;
    private final p0 recording;
    private final Handler ringHandlerNew;
    private SensorManager sensorManager;
    private final PowerManager.WakeLock wl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/di/MediaModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/di/MediaModule;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<MediaModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public MediaModule(Context appContext) {
        y.i(appContext, "appContext");
        this.appContext = appContext;
        this.audioRecorder = providesAudioRecorder(appContext);
        b0 b0VarA = r0.a(null);
        this._isRecording = b0VarA;
        this.recording = te.j.b(b0VarA);
        b0 b0VarA2 = r0.a(MediaPlayerStatus.STOP);
        this._playerStatus = b0VarA2;
        this.playerStatus = te.j.b(b0VarA2);
        b0 b0VarA3 = r0.a(null);
        this._actualPlaying = b0VarA3;
        this.actualPlaying = te.j.b(b0VarA3);
        b0 b0VarA4 = r0.a(0);
        this._actualPlayingTime = b0VarA4;
        this.actualPlayingTime = te.j.b(b0VarA4);
        SensorManager sensorManager = (SensorManager) appContext.getSystemService("sensor");
        this.sensorManager = sensorManager;
        this.proximitySensor = sensorManager != null ? sensorManager.getDefaultSensor(8) : null;
        PowerManager powerManager = (PowerManager) appContext.getSystemService("power");
        this.pm = powerManager;
        this.wl = powerManager != null ? powerManager.newWakeLock(32, "toDus:wakelocktag") : null;
        this.audioManager = (AudioManager) appContext.getSystemService("audio");
        this.isInSpeaker = true;
        Object systemService = appContext.getSystemService("bluetooth");
        y.g(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.bluetoothManager = (BluetoothManager) systemService;
        b0 b0VarA5 = r0.a(Boolean.FALSE);
        this._isHeadsetConnected = b0VarA5;
        this.isHeadsetConnected = te.j.b(b0VarA5);
        this.dtmfGenerator = new ToneGenerator(2, 100);
        this.ringHandlerNew = new Handler(Looper.getMainLooper());
        listenBTDevice();
        checkForScreen();
    }

    private final void checkForScreen() {
        SensorEventListener sensorEventListener = new SensorEventListener() { // from class: cu.todus.android.di.MediaModule$checkForScreen$listener$1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent event) {
                y.i(event, "event");
                if (event.sensor.getType() != 8 || this.this$0.isAudioCallMode || this.this$0._isVideoCallActive) {
                    return;
                }
                if (event.values[0] < event.sensor.getMaximumRange()) {
                    if ((this.this$0._actualPlaying.getValue() != null || this.this$0.getCheckerActiveInCall()) && this.this$0.isInSpeaker) {
                        PowerManager.WakeLock wakeLock = this.this$0.wl;
                        if (wakeLock != null && !wakeLock.isHeld()) {
                            this.this$0.wl.acquire(60000L);
                        }
                        AudioManager audioManager = this.this$0.audioManager;
                        if (audioManager != null && audioManager.isBluetoothScoOn()) {
                            this.this$0.audioManager.stopBluetoothSco();
                            this.this$0.audioManager.setBluetoothScoOn(false);
                        }
                        AudioManager audioManager2 = this.this$0.audioManager;
                        if (audioManager2 != null) {
                            audioManager2.setMode(3);
                        }
                        AudioManager audioManager3 = this.this$0.audioManager;
                        if (audioManager3 != null) {
                            audioManager3.setSpeakerphoneOn(false);
                        }
                        AudioManager audioManager4 = this.this$0.audioManager;
                        if (audioManager4 != null) {
                            audioManager4.setWiredHeadsetOn(true);
                        }
                        this.this$0.isInSpeaker = false;
                        return;
                    }
                    return;
                }
                if ((this.this$0._actualPlaying.getValue() != null || this.this$0.getCheckerActiveInCall()) && !this.this$0.isInSpeaker) {
                    PowerManager.WakeLock wakeLock2 = this.this$0.wl;
                    if (wakeLock2 != null && wakeLock2.isHeld()) {
                        this.this$0.wl.release();
                    }
                    if (((Boolean) this.this$0.getIsHeadsetConnected().getValue()).booleanValue()) {
                        AudioManager audioManager5 = this.this$0.audioManager;
                        if (audioManager5 != null) {
                            audioManager5.setMode(3);
                        }
                        AudioManager audioManager6 = this.this$0.audioManager;
                        if (audioManager6 != null) {
                            audioManager6.startBluetoothSco();
                        }
                        AudioManager audioManager7 = this.this$0.audioManager;
                        if (audioManager7 != null) {
                            audioManager7.setBluetoothScoOn(true);
                        }
                    } else {
                        AudioManager audioManager8 = this.this$0.audioManager;
                        if (audioManager8 != null) {
                            audioManager8.setMode(2);
                        }
                        AudioManager audioManager9 = this.this$0.audioManager;
                        if (audioManager9 != null && audioManager9.isBluetoothScoOn()) {
                            this.this$0.audioManager.stopBluetoothSco();
                            this.this$0.audioManager.setBluetoothScoOn(false);
                        }
                        AudioManager audioManager10 = this.this$0.audioManager;
                        if (audioManager10 != null) {
                            audioManager10.setWiredHeadsetOn(false);
                        }
                        AudioManager audioManager11 = this.this$0.audioManager;
                        if (audioManager11 != null) {
                            audioManager11.setSpeakerphoneOn(true);
                        }
                    }
                    this.this$0.isInSpeaker = true;
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(sensorEventListener, this.proximitySensor, 3);
        }
    }

    private final void initializePlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
        mediaPlayer.setLooping(false);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: cu.todus.android.di.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                MediaModule.initializePlayer$lambda$0$0(this.f20849a, mediaPlayer2);
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: cu.todus.android.di.d
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                MediaModule.initializePlayer$lambda$0$1(this.f20850a, mediaPlayer2);
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: cu.todus.android.di.MediaModule$initializePlayer$1$3
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer2 = this.this$0.mediaPlayer;
                if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                    b0 b0Var = this.this$0._actualPlayingTime;
                    MediaPlayer mediaPlayer3 = this.this$0.mediaPlayer;
                    b0Var.setValue(Integer.valueOf(mediaPlayer3 != null ? mediaPlayer3.getCurrentPosition() : 0));
                }
                handler.postDelayed(this, 1000L);
            }
        });
        this.mediaPlayer = mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializePlayer$lambda$0$0(MediaModule mediaModule, MediaPlayer mediaPlayer) {
        mediaModule._playerStatus.setValue(MediaPlayerStatus.STOP);
        mediaModule._actualPlaying.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializePlayer$lambda$0$1(MediaModule mediaModule, MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = mediaModule.mediaPlayer;
        mediaModule.actualPlayingDuration = mediaPlayer2 != null ? mediaPlayer2.getDuration() : 0;
        mediaModule.playPlaying();
        mediaModule._playerStatus.setValue(MediaPlayerStatus.PLAYING);
    }

    private final void listenBTDevice() {
        try {
            this.bluetoothManager.getAdapter().getProfileProxy(this.appContext, new BluetoothProfile.ServiceListener() { // from class: cu.todus.android.di.MediaModule.listenBTDevice.1
                @Override // android.bluetooth.BluetoothProfile.ServiceListener
                public void onServiceConnected(int profile, BluetoothProfile proxy) {
                    try {
                        b0 b0Var = MediaModule.this._isHeadsetConnected;
                        y.f(proxy);
                        b0Var.setValue(Boolean.valueOf(proxy.getConnectedDevices().size() > 0));
                        proxy.getConnectedDevices().size();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }

                @Override // android.bluetooth.BluetoothProfile.ServiceListener
                public void onServiceDisconnected(int profile) {
                    MediaModule.this._isHeadsetConnected.setValue(Boolean.FALSE);
                }
            }, 1);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playRingWithSilenceNew() {
        if (this.isRingingActiveNew) {
            try {
                this.dtmfGenerator.startTone(0, 2000);
                this.ringHandlerNew.postDelayed(new Runnable() { // from class: cu.todus.android.di.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaModule.playRingWithSilenceNew$lambda$0(this.f20847c);
                    }
                }, 2000L);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playRingWithSilenceNew$lambda$0(final MediaModule mediaModule) {
        if (mediaModule.isRingingActiveNew) {
            mediaModule.dtmfGenerator.stopTone();
            mediaModule.ringHandlerNew.postDelayed(new Runnable() { // from class: cu.todus.android.di.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20848c.playRingWithSilenceNew();
                }
            }, 5000L);
        }
    }

    private final AndroidAudioRecorder providesAudioRecorder(Context appContext) {
        return new AndroidAudioRecorder(appContext);
    }

    public final void enableAutoSpeakerControl() {
        this.isAudioCallMode = false;
        this.isInSpeaker = true;
    }

    public final p0 getActualPlaying() {
        return this.actualPlaying;
    }

    public final int getActualPlayingDuration() {
        return this.actualPlayingDuration;
    }

    public final p0 getActualPlayingTime() {
        return this.actualPlayingTime;
    }

    public final AndroidAudioRecorder getAudioRecorder() {
        return this.audioRecorder;
    }

    public final boolean getCheckerActiveInCall() {
        return this.checkerActiveInCall;
    }

    public final p0 getPlayerStatus() {
        return this.playerStatus;
    }

    public final p0 getRecording() {
        return this.recording;
    }

    /* JADX INFO: renamed from: isHeadsetConnected, reason: from getter */
    public final p0 getIsHeadsetConnected() {
        return this.isHeadsetConnected;
    }

    public final void pausePlaying() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying() && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.pause();
        }
        this._playerStatus.setValue(MediaPlayerStatus.PAUSED);
    }

    public final void playPlaying() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        this._playerStatus.setValue(MediaPlayerStatus.PLAYING);
    }

    public final void resetSpeakerStateForAudioCall() {
        this.isAudioCallMode = true;
        this.isInSpeaker = false;
        this._isVideoCallActive = false;
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setSpeakerphoneOn(false);
        }
    }

    public final void setActualPlayingDuration(int i10) {
        this.actualPlayingDuration = i10;
    }

    public final void setActualPlayingTime(p0 p0Var) {
        y.i(p0Var, "<set-?>");
        this.actualPlayingTime = p0Var;
    }

    public final void setAudioRecorder(AndroidAudioRecorder androidAudioRecorder) {
        y.i(androidAudioRecorder, "<set-?>");
        this.audioRecorder = androidAudioRecorder;
    }

    public final void setCheckerActiveInCall(boolean z10) {
        this.checkerActiveInCall = z10;
    }

    public final void setMediaPlayerPosition(int position) {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null || !mediaPlayer2.isPlaying() || position > this.actualPlayingDuration || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        mediaPlayer.seekTo(position);
    }

    public final void setVideoCallActive(boolean active) {
        this._isVideoCallActive = active;
    }

    public final void startPlaying(MediaPlayerData mpd, Context context) throws IOException {
        y.i(mpd, "mpd");
        y.i(context, "context");
        if (mpd.getUri() != null) {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = this.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.stop();
                }
                MediaPlayer mediaPlayer3 = this.mediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.release();
                }
            }
            this._actualPlayingTime.setValue(0);
            this._actualPlaying.setValue(mpd);
            initializePlayer();
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.setDataSource(context, mpd.getUri());
            }
            MediaPlayer mediaPlayer5 = this.mediaPlayer;
            if (mediaPlayer5 != null) {
                mediaPlayer5.prepareAsync();
            }
        }
    }

    public final File startRecorder(String id2) {
        y.i(id2, "id");
        this._isRecording.setValue(new RecorderId(id2));
        File newRecordFile = DirectoryPaths.INSTANCE.getInstance().getNewRecordFile();
        this.audioRecorder.start(newRecordFile);
        return newRecordFile;
    }

    public final void startRing() {
        this.dtmfGenerator.startTone(0, 1000);
    }

    public final void startRingContinuousNew() {
        stopRingContinuousNew();
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setMode(3);
        }
        this.isRingingActiveNew = true;
        playRingWithSilenceNew();
    }

    public final void stopPlaying() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying() && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.stop();
        }
        this._playerStatus.setValue(MediaPlayerStatus.STOP);
        this._actualPlaying.setValue(null);
    }

    public final File stopRecorder() {
        File fileStop = this.audioRecorder.stop();
        this._isRecording.setValue(null);
        return fileStop;
    }

    public final void stopRing() {
        this.dtmfGenerator.stopTone();
    }

    public final void stopRingContinuousNew() {
        this.isRingingActiveNew = false;
        this.ringHandlerNew.removeCallbacksAndMessages(null);
        try {
            this.dtmfGenerator.stopTone();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
