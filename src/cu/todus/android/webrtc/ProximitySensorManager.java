package cu.todus.android.webrtc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R \u0010)\u001a\b\u0018\u00010(R\u00020\"8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010\bR \u0010,\u001a\b\u0018\u00010(R\u00020\"8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b,\u0010*\u0012\u0004\b-\u0010\b¨\u0006."}, d2 = {"Lcu/todus/android/webrtc/ProximitySensorManager;", "Landroid/hardware/SensorEventListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lua/k0;", "startListening", "()V", "stopListening", "Landroid/view/Window;", "window", "forceScreenAlwaysOn", "(Landroid/view/Window;)V", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "cleanup", "", "hasProximitySensor", "()Z", "Landroid/content/Context;", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/SensorManager;", "proximitySensor", "Landroid/hardware/Sensor;", "Landroid/os/PowerManager;", "powerManager", "Landroid/os/PowerManager;", "isListening", "Z", "forceScreenOn", "Landroid/os/PowerManager$WakeLock;", "proximityWakeLock", "Landroid/os/PowerManager$WakeLock;", "getProximityWakeLock$annotations", "screenOnWakeLock", "getScreenOnWakeLock$annotations", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProximitySensorManager implements SensorEventListener {
    public static final int $stable = 8;
    private final Context context;
    private boolean forceScreenOn;
    private boolean isListening;
    private final PowerManager powerManager;
    private final Sensor proximitySensor;
    private final PowerManager.WakeLock proximityWakeLock;
    private final PowerManager.WakeLock screenOnWakeLock;
    private final SensorManager sensorManager;

    public ProximitySensorManager(Context context) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        y.i(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("sensor");
        y.g(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorManager = sensorManager;
        this.proximitySensor = sensorManager.getDefaultSensor(8);
        Object systemService2 = context.getSystemService("power");
        y.g(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService2;
        this.powerManager = powerManager;
        PowerManager.WakeLock wakeLock = null;
        if (powerManager.isWakeLockLevelSupported(32)) {
            wakeLockNewWakeLock = powerManager.newWakeLock(32, "ProximitySensorManager::ProximityScreenOff");
            wakeLockNewWakeLock.setReferenceCounted(false);
        } else {
            Log.w("ProximitySensorManager", "⚠️ PROXIMITY_SCREEN_OFF_WAKE_LOCK not supported on this device");
            wakeLockNewWakeLock = null;
        }
        this.proximityWakeLock = wakeLockNewWakeLock;
        try {
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(268435482, "ProximitySensorManager::ScreenAlwaysOn");
            wakeLockNewWakeLock2.setReferenceCounted(false);
            wakeLock = wakeLockNewWakeLock2;
        } catch (Exception e10) {
            Log.w("ProximitySensorManager", "⚠️ Could not create FULL_WAKE_LOCK: " + e10.getMessage());
        }
        this.screenOnWakeLock = wakeLock;
        try {
            PowerManager.WakeLock wakeLock2 = this.proximityWakeLock;
            if (wakeLock2 != null && wakeLock2.isHeld()) {
                this.proximityWakeLock.release();
            }
        } catch (Exception e11) {
            Log.w("ProximitySensorManager", "⚠️ Could not release stale proximity wake lock: " + e11.getMessage());
        }
        this.sensorManager.unregisterListener(this);
    }

    public static /* synthetic */ void cleanup$default(ProximitySensorManager proximitySensorManager, Window window, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            window = null;
        }
        proximitySensorManager.cleanup(window);
    }

    public static /* synthetic */ void forceScreenAlwaysOn$default(ProximitySensorManager proximitySensorManager, Window window, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            window = null;
        }
        proximitySensorManager.forceScreenAlwaysOn(window);
    }

    public final void cleanup(Window window) {
        stopListening();
        try {
            PowerManager.WakeLock wakeLock = this.screenOnWakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.screenOnWakeLock.release();
            }
        } catch (Exception e10) {
            Log.e("ProximitySensorManager", "❌ Error releasing screen on wake lock: " + e10.getMessage(), e10);
        }
        if (window != null) {
            try {
                window.clearFlags(2097280);
            } catch (Exception e11) {
                Log.e("ProximitySensorManager", "❌ Error clearing WindowManager flags: " + e11.getMessage(), e11);
            }
        }
        this.forceScreenOn = false;
    }

    public final void forceScreenAlwaysOn(Window window) {
        this.forceScreenOn = true;
        this.sensorManager.unregisterListener(this);
        this.isListening = false;
        PowerManager.WakeLock wakeLock = this.screenOnWakeLock;
        if (wakeLock != null && !wakeLock.isHeld()) {
            try {
                this.screenOnWakeLock.acquire(900000L);
            } catch (Exception e10) {
                Log.e("ProximitySensorManager", "Error acquiring screen on wake lock: " + e10.getMessage(), e10);
            }
        }
        if (window != null) {
            try {
                window.addFlags(2097280);
            } catch (Exception e11) {
                Log.e("ProximitySensorManager", "❌ Error adding WindowManager flags: " + e11.getMessage(), e11);
            }
        }
    }

    public final boolean hasProximitySensor() {
        return this.proximitySensor != null;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        y.i(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        y.i(event, "event");
        if (event.sensor.getType() != 8 || this.forceScreenOn) {
            return;
        }
        float f10 = event.values[0];
        float maximumRange = event.sensor.getMaximumRange() * 0.85f;
        y.h(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1)), "format(...)");
        y.h(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(maximumRange)}, 1)), "format(...)");
    }

    public final void startListening() {
        if (this.proximitySensor == null) {
            Log.w("ProximitySensorManager", "⚠️ Device does not have a proximity sensor");
            return;
        }
        if (this.forceScreenOn) {
            Log.w("ProximitySensorManager", "❌ Cannot start listening – forceScreenOn active (video call mode)");
            return;
        }
        if (this.isListening) {
            return;
        }
        this.isListening = true;
        PowerManager.WakeLock wakeLock = this.proximityWakeLock;
        if (wakeLock != null && !wakeLock.isHeld()) {
            try {
                this.proximityWakeLock.acquire(3600000L);
            } catch (Exception e10) {
                Log.e("ProximitySensorManager", "Error acquiring proximity wake lock: " + e10.getMessage(), e10);
            }
        }
        this.sensorManager.registerListener(this, this.proximitySensor, 3);
        this.proximitySensor.getMaximumRange();
    }

    public final void stopListening() {
        if (this.isListening) {
            this.isListening = false;
            this.sensorManager.unregisterListener(this);
            try {
                PowerManager.WakeLock wakeLock = this.proximityWakeLock;
                if (wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
                this.proximityWakeLock.release();
            } catch (Exception e10) {
                Log.e("ProximitySensorManager", "❌ Error releasing proximity wake lock: " + e10.getMessage(), e10);
            }
        }
    }

    private static /* synthetic */ void getProximityWakeLock$annotations() {
    }

    private static /* synthetic */ void getScreenOnWakeLock$annotations() {
    }
}
