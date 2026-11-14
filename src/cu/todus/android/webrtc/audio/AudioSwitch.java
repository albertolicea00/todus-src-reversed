package cu.todus.android.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.constants.Service;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import ua.n;
import ua.o;
import ua.r;
import va.g0;
import va.n0;
import va.o0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 92\u00020\u0001:\u0003:;9B9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ3\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00062\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u001b\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u001d\u0010!\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b!\u0010\u0019J\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u0012J3\u0010&\u001a\u00020\u00102$\u0010%\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00100#j\u0002`$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0010¢\u0006\u0004\b(\u0010\u0012J\r\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010)R8\u0010*\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010#j\u0004\u0018\u0001`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\b01j\b\u0012\u0004\u0012\u00020\b`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitch;", "", "Landroid/content/Context;", "context", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioFocusChangeListener", "", "Ljava/lang/Class;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "preferredDeviceList", "Lcu/todus/android/webrtc/audio/AudioManagerAdapter;", "audioManager", "<init>", "(Landroid/content/Context;Landroid/media/AudioManager$OnAudioFocusChangeListener;Ljava/util/List;Lcu/todus/android/webrtc/audio/AudioManagerAdapter;)V", "getPreferredDeviceList", "(Ljava/util/List;)Ljava/util/List;", "Lua/k0;", "deactivate", "()V", "audioDevice", "selectDevice", "(Lcu/todus/android/webrtc/audio/AudioDevice;)V", Service.Endpoint.LINKED_DEVICES_LIST, "", "hasNoDuplicates", "(Ljava/util/List;)Z", "activate", "", "bluetoothHeadsetName", "enumerateDevices", "(Ljava/lang/String;)V", "addAvailableAudioDevices", "audioDevices", "userSelectedDevicePresent", "closeListeners", "Lkotlin/Function2;", "Lcu/todus/android/webrtc/audio/AudioDeviceChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, TtmlNode.START, "(Lkotlin/jvm/functions/Function2;)V", "stop", "Lcu/todus/android/webrtc/audio/AudioManagerAdapter;", "audioDeviceChangeListener", "Lkotlin/jvm/functions/Function2;", "selectedDevice", "Lcu/todus/android/webrtc/audio/AudioDevice;", "userSelectedDevice", "wiredHeadsetAvailable", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mutableAudioDevices", "Ljava/util/ArrayList;", "Ljava/util/List;", "Lcu/todus/android/webrtc/audio/AudioSwitch$State;", "state", "Lcu/todus/android/webrtc/audio/AudioSwitch$State;", "Companion", "State", "AudioDeviceState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioSwitch {
    private Function2 audioDeviceChangeListener;
    private final AudioManagerAdapter audioManager;
    private final ArrayList<AudioDevice> mutableAudioDevices;
    private final List<Class<? extends AudioDevice>> preferredDeviceList;
    private AudioDevice selectedDevice;
    private State state;
    private AudioDevice userSelectedDevice;
    private boolean wiredHeadsetAvailable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final n defaultPreferredDeviceList$delegate = o.a(new lb.a() { // from class: cu.todus.android.webrtc.audio.a
        @Override // lb.a
        public final Object invoke() {
            return AudioSwitch.defaultPreferredDeviceList_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitch$AudioDeviceState;", "", "audioDeviceList", "", "Lcu/todus/android/webrtc/audio/AudioDevice;", "selectedAudioDevice", "<init>", "(Ljava/util/List;Lcu/todus/android/webrtc/audio/AudioDevice;)V", "getAudioDeviceList", "()Ljava/util/List;", "getSelectedAudioDevice", "()Lcu/todus/android/webrtc/audio/AudioDevice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AudioDeviceState {
        public static final int $stable = 8;
        private final List<AudioDevice> audioDeviceList;
        private final AudioDevice selectedAudioDevice;

        /* JADX WARN: Multi-variable type inference failed */
        public AudioDeviceState(List<? extends AudioDevice> audioDeviceList, AudioDevice audioDevice) {
            y.i(audioDeviceList, "audioDeviceList");
            this.audioDeviceList = audioDeviceList;
            this.selectedAudioDevice = audioDevice;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AudioDeviceState copy$default(AudioDeviceState audioDeviceState, List list, AudioDevice audioDevice, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = audioDeviceState.audioDeviceList;
            }
            if ((i10 & 2) != 0) {
                audioDevice = audioDeviceState.selectedAudioDevice;
            }
            return audioDeviceState.copy(list, audioDevice);
        }

        public final List<AudioDevice> component1() {
            return this.audioDeviceList;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AudioDevice getSelectedAudioDevice() {
            return this.selectedAudioDevice;
        }

        public final AudioDeviceState copy(List<? extends AudioDevice> audioDeviceList, AudioDevice selectedAudioDevice) {
            y.i(audioDeviceList, "audioDeviceList");
            return new AudioDeviceState(audioDeviceList, selectedAudioDevice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioDeviceState)) {
                return false;
            }
            AudioDeviceState audioDeviceState = (AudioDeviceState) other;
            return y.d(this.audioDeviceList, audioDeviceState.audioDeviceList) && y.d(this.selectedAudioDevice, audioDeviceState.selectedAudioDevice);
        }

        public final List<AudioDevice> getAudioDeviceList() {
            return this.audioDeviceList;
        }

        public final AudioDevice getSelectedAudioDevice() {
            return this.selectedAudioDevice;
        }

        public int hashCode() {
            int iHashCode = this.audioDeviceList.hashCode() * 31;
            AudioDevice audioDevice = this.selectedAudioDevice;
            return iHashCode + (audioDevice == null ? 0 : audioDevice.hashCode());
        }

        public String toString() {
            return "AudioDeviceState(audioDeviceList=" + this.audioDeviceList + ", selectedAudioDevice=" + this.selectedAudioDevice + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitch$Companion;", "", "<init>", "()V", "", "Ljava/lang/Class;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "defaultPreferredDeviceList$delegate", "Lua/n;", "getDefaultPreferredDeviceList", "()Ljava/util/List;", "defaultPreferredDeviceList", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Class<? extends AudioDevice>> getDefaultPreferredDeviceList() {
            return (List) AudioSwitch.defaultPreferredDeviceList$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioSwitch$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "ACTIVATED", "STOPPED", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum State {
        STARTED,
        ACTIVATED,
        STOPPED;

        private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

        public static db.a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.ACTIVATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudioSwitch(Context context, AudioManager.OnAudioFocusChangeListener audioFocusChangeListener, List<? extends Class<? extends AudioDevice>> preferredDeviceList, AudioManagerAdapter audioManager) {
        y.i(context, "context");
        y.i(audioFocusChangeListener, "audioFocusChangeListener");
        y.i(preferredDeviceList, "preferredDeviceList");
        y.i(audioManager, "audioManager");
        this.audioManager = audioManager;
        this.mutableAudioDevices = new ArrayList<>();
        this.state = State.STOPPED;
        this.preferredDeviceList = getPreferredDeviceList(preferredDeviceList);
    }

    private final void addAvailableAudioDevices(String bluetoothHeadsetName) {
        this.mutableAudioDevices.clear();
        Iterator<T> it = this.preferredDeviceList.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            cls.getSimpleName();
            if (!y.d(cls, AudioDevice.BluetoothHeadset.class)) {
                if (y.d(cls, AudioDevice.WiredHeadset.class)) {
                    if (this.wiredHeadsetAvailable) {
                        this.mutableAudioDevices.add(new AudioDevice.WiredHeadset(null, 1, null));
                    }
                } else if (y.d(cls, AudioDevice.Earpiece.class)) {
                    if (this.audioManager.hasEarpiece() && !this.wiredHeadsetAvailable) {
                        this.mutableAudioDevices.add(new AudioDevice.Earpiece(null, 1, null));
                    }
                } else if (y.d(cls, AudioDevice.Speakerphone.class) && this.audioManager.hasSpeakerphone()) {
                    this.mutableAudioDevices.add(new AudioDevice.Speakerphone(null, 1, null));
                }
            }
        }
    }

    private final void closeListeners() {
        this.audioDeviceChangeListener = null;
        this.state = State.STOPPED;
    }

    private final void deactivate() {
        Objects.toString(this.state);
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new r();
                }
            } else {
                this.audioManager.restoreAudioState();
                this.state = State.STARTED;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List defaultPreferredDeviceList_delegate$lambda$0() {
        return w.q(AudioDevice.BluetoothHeadset.class, AudioDevice.WiredHeadset.class, AudioDevice.Earpiece.class, AudioDevice.Speakerphone.class);
    }

    private final void enumerateDevices(String bluetoothHeadsetName) {
        Function2 function2;
        ArrayList<AudioDevice> arrayList = this.mutableAudioDevices;
        ArrayList arrayList2 = new ArrayList(x.y(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((AudioDevice) it.next());
        }
        AudioDeviceState audioDeviceState = new AudioDeviceState(arrayList2, this.selectedDevice);
        addAvailableAudioDevices(bluetoothHeadsetName);
        AudioDevice audioDevice = null;
        if (!userSelectedDevicePresent(this.mutableAudioDevices)) {
            this.userSelectedDevice = null;
        }
        AudioDevice audioDevice2 = this.userSelectedDevice;
        if (audioDevice2 != null) {
            audioDevice = audioDevice2;
        } else if (this.mutableAudioDevices.size() > 0) {
            audioDevice = (AudioDevice) g0.w0(this.mutableAudioDevices);
        }
        this.selectedDevice = audioDevice;
        Objects.toString(audioDevice);
        if (this.state == State.ACTIVATED) {
            activate();
        }
        if (y.d(new AudioDeviceState(this.mutableAudioDevices, this.selectedDevice), audioDeviceState) || (function2 = this.audioDeviceChangeListener) == null) {
            return;
        }
        function2.invoke(this.mutableAudioDevices, this.selectedDevice);
    }

    public static /* synthetic */ void enumerateDevices$default(AudioSwitch audioSwitch, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        audioSwitch.enumerateDevices(str);
    }

    private final List<Class<? extends AudioDevice>> getPreferredDeviceList(List<? extends Class<? extends AudioDevice>> preferredDeviceList) {
        if (!hasNoDuplicates(preferredDeviceList)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!preferredDeviceList.isEmpty()) {
            Companion companion = INSTANCE;
            if (!y.d(preferredDeviceList, companion.getDefaultPreferredDeviceList())) {
                List<Class<? extends AudioDevice>> listR1 = g0.r1(companion.getDefaultPreferredDeviceList());
                listR1.removeAll(preferredDeviceList);
                int i10 = 0;
                for (Object obj : preferredDeviceList) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        w.x();
                    }
                    listR1.add(i10, (Class) obj);
                    i10 = i11;
                }
                return listR1;
            }
        }
        return INSTANCE.getDefaultPreferredDeviceList();
    }

    private final boolean hasNoDuplicates(final List<? extends Class<? extends AudioDevice>> list) {
        Map mapA = o0.a(new n0() { // from class: cu.todus.android.webrtc.audio.AudioSwitch$hasNoDuplicates$$inlined$groupingBy$1
            @Override // va.n0
            public Class<? extends AudioDevice> keyOf(Class<? extends AudioDevice> element) {
                return element;
            }

            @Override // va.n0
            public Iterator<Class<? extends AudioDevice>> sourceIterator() {
                return list.iterator();
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapA.entrySet()) {
            if (((Number) entry.getValue()).intValue() > 1) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.isEmpty();
    }

    private final void selectDevice(AudioDevice audioDevice) {
        Objects.toString(audioDevice);
        if (y.d(this.selectedDevice, audioDevice)) {
            return;
        }
        this.userSelectedDevice = audioDevice;
        enumerateDevices$default(this, null, 1, null);
    }

    private final boolean userSelectedDevicePresent(List<? extends AudioDevice> audioDevices) {
        Object next;
        AudioDevice audioDevice = this.userSelectedDevice;
        if (audioDevice == null) {
            return false;
        }
        if (!(audioDevice instanceof AudioDevice.BluetoothHeadset)) {
            return audioDevices.contains(audioDevice);
        }
        Iterator<T> it = audioDevices.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((AudioDevice) next) instanceof AudioDevice.BluetoothHeadset));
        AudioDevice audioDevice2 = (AudioDevice) next;
        if (audioDevice2 == null) {
            return false;
        }
        this.userSelectedDevice = audioDevice2;
        return true;
    }

    public final void activate() {
        Objects.toString(this.state);
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException();
        }
        if (i10 == 2) {
            AudioDevice audioDevice = this.selectedDevice;
            if (audioDevice != null) {
                activate(audioDevice);
                return;
            }
            return;
        }
        if (i10 != 3) {
            throw new r();
        }
        this.audioManager.cacheAudioState();
        this.audioManager.mute(false);
        this.audioManager.setAudioFocus();
        AudioDevice audioDevice2 = this.selectedDevice;
        if (audioDevice2 != null) {
            activate(audioDevice2);
        }
        this.state = State.ACTIVATED;
    }

    public final void start(Function2 listener) {
        y.i(listener, "listener");
        Objects.toString(this.state);
        this.audioDeviceChangeListener = listener;
        if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] == 1) {
            enumerateDevices$default(this, null, 1, null);
            this.state = State.STARTED;
        }
    }

    public final void stop() {
        Objects.toString(this.state);
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                deactivate();
                closeListeners();
            } else {
                if (i10 != 3) {
                    throw new r();
                }
                closeListeners();
            }
        }
    }

    public /* synthetic */ AudioSwitch(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, List list, AudioManagerAdapter audioManagerAdapter, int i10, p pVar) {
        Context context2;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2;
        if ((i10 & 8) != 0) {
            Object systemService = context.getSystemService("audio");
            y.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            context2 = context;
            onAudioFocusChangeListener2 = onAudioFocusChangeListener;
            audioManagerAdapter = new AudioManagerAdapterImpl(context2, (AudioManager) systemService, null, onAudioFocusChangeListener2, 4, null);
        } else {
            context2 = context;
            onAudioFocusChangeListener2 = onAudioFocusChangeListener;
        }
        this(context2, onAudioFocusChangeListener2, list, audioManagerAdapter);
    }

    private final void activate(AudioDevice audioDevice) {
        Objects.toString(audioDevice);
        if (audioDevice instanceof AudioDevice.BluetoothHeadset) {
            this.audioManager.enableSpeakerphone(false);
            return;
        }
        if (!(audioDevice instanceof AudioDevice.Earpiece) && !(audioDevice instanceof AudioDevice.WiredHeadset)) {
            if (!(audioDevice instanceof AudioDevice.Speakerphone)) {
                throw new r();
            }
            this.audioManager.enableSpeakerphone(true);
            return;
        }
        this.audioManager.enableSpeakerphone(false);
    }
}
