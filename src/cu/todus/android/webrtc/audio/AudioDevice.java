package cu.todus.android.webrtc.audio;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioDevice;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "BluetoothHeadset", "WiredHeadset", "Earpiece", "Speakerphone", "Lcu/todus/android/webrtc/audio/AudioDevice$BluetoothHeadset;", "Lcu/todus/android/webrtc/audio/AudioDevice$Earpiece;", "Lcu/todus/android/webrtc/audio/AudioDevice$Speakerphone;", "Lcu/todus/android/webrtc/audio/AudioDevice$WiredHeadset;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AudioDevice {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioDevice$BluetoothHeadset;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BluetoothHeadset extends AudioDevice {
        public static final int $stable = 0;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public BluetoothHeadset() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BluetoothHeadset copy$default(BluetoothHeadset bluetoothHeadset, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bluetoothHeadset.name;
            }
            return bluetoothHeadset.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final BluetoothHeadset copy(String name) {
            y.i(name, "name");
            return new BluetoothHeadset(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BluetoothHeadset) && y.d(this.name, ((BluetoothHeadset) other).name);
        }

        @Override // cu.todus.android.webrtc.audio.AudioDevice
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "BluetoothHeadset(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BluetoothHeadset(String name) {
            super(null);
            y.i(name, "name");
            this.name = name;
        }

        public /* synthetic */ BluetoothHeadset(String str, int i10, p pVar) {
            this((i10 & 1) != 0 ? "Bluetooth" : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioDevice$Earpiece;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Earpiece extends AudioDevice {
        public static final int $stable = 0;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public Earpiece() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Earpiece copy$default(Earpiece earpiece, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = earpiece.name;
            }
            return earpiece.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Earpiece copy(String name) {
            y.i(name, "name");
            return new Earpiece(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Earpiece) && y.d(this.name, ((Earpiece) other).name);
        }

        @Override // cu.todus.android.webrtc.audio.AudioDevice
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Earpiece(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Earpiece(String name) {
            super(null);
            y.i(name, "name");
            this.name = name;
        }

        public /* synthetic */ Earpiece(String str, int i10, p pVar) {
            this((i10 & 1) != 0 ? "Earpiece" : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioDevice$Speakerphone;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Speakerphone extends AudioDevice {
        public static final int $stable = 0;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public Speakerphone() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Speakerphone copy$default(Speakerphone speakerphone, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = speakerphone.name;
            }
            return speakerphone.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Speakerphone copy(String name) {
            y.i(name, "name");
            return new Speakerphone(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Speakerphone) && y.d(this.name, ((Speakerphone) other).name);
        }

        @Override // cu.todus.android.webrtc.audio.AudioDevice
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Speakerphone(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Speakerphone(String name) {
            super(null);
            y.i(name, "name");
            this.name = name;
        }

        public /* synthetic */ Speakerphone(String str, int i10, p pVar) {
            this((i10 & 1) != 0 ? "Speakerphone" : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/todus/android/webrtc/audio/AudioDevice$WiredHeadset;", "Lcu/todus/android/webrtc/audio/AudioDevice;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WiredHeadset extends AudioDevice {
        public static final int $stable = 0;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public WiredHeadset() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ WiredHeadset copy$default(WiredHeadset wiredHeadset, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = wiredHeadset.name;
            }
            return wiredHeadset.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final WiredHeadset copy(String name) {
            y.i(name, "name");
            return new WiredHeadset(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WiredHeadset) && y.d(this.name, ((WiredHeadset) other).name);
        }

        @Override // cu.todus.android.webrtc.audio.AudioDevice
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "WiredHeadset(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WiredHeadset(String name) {
            super(null);
            y.i(name, "name");
            this.name = name;
        }

        public /* synthetic */ WiredHeadset(String str, int i10, p pVar) {
            this((i10 & 1) != 0 ? "Wired Headset" : str);
        }
    }

    public /* synthetic */ AudioDevice(p pVar) {
        this();
    }

    public abstract String getName();

    private AudioDevice() {
    }
}
