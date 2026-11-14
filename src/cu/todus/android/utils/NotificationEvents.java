package cu.todus.android.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.R;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0003R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcu/todus/android/utils/NotificationEvents;", "", "<init>", "()V", "", "getSystemVolumen", "()F", "Lua/k0;", "createSoundPool", "createNewSoundPool", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "playSendNotification", "playReceivedNotification", "Landroid/content/Context;", "Landroid/media/SoundPool;", "sounds", "Landroid/media/SoundPool;", "getSounds", "()Landroid/media/SoundPool;", "setSounds", "(Landroid/media/SoundPool;)V", "", "tocSound", "I", "chuitSound", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class NotificationEvents {
    private static int chuitSound;
    private static Context context;
    private static SoundPool sounds;
    private static int tocSound;
    public static final NotificationEvents INSTANCE = new NotificationEvents();
    public static final int $stable = 8;

    private NotificationEvents() {
    }

    private final void createNewSoundPool() {
        sounds = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).build();
    }

    private final void createSoundPool() {
        createNewSoundPool();
    }

    private final float getSystemVolumen() {
        Context context2 = context;
        AudioManager audioManager = (AudioManager) (context2 != null ? context2.getSystemService("audio") : null);
        y.f(audioManager);
        return audioManager.getStreamVolume(5) / audioManager.getStreamMaxVolume(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 init$lambda$0(Context context2) {
        context = context2;
        INSTANCE.createSoundPool();
        SoundPool soundPool = sounds;
        if (soundPool != null) {
            tocSound = soundPool.load(context2, R.raw.sound_out, 1);
            chuitSound = soundPool.load(context2, R.raw.sound_in, 1);
        }
        return k0.f43947a;
    }

    public final SoundPool getSounds() {
        return sounds;
    }

    public final void init(final Context context2) {
        y.i(context2, "context");
        za.a.b(false, false, null, null, 0, new lb.a() { // from class: cu.todus.android.utils.k
            @Override // lb.a
            public final Object invoke() {
                return NotificationEvents.init$lambda$0(context2);
            }
        }, 31, null);
    }

    public final void playReceivedNotification() {
        SoundPool soundPool = sounds;
        if (soundPool != null) {
            float systemVolumen = INSTANCE.getSystemVolumen();
            soundPool.play(chuitSound, systemVolumen, systemVolumen, 1, 0, 1.0f);
        }
    }

    public final void playSendNotification() {
        SoundPool soundPool = sounds;
        if (soundPool != null) {
            float systemVolumen = INSTANCE.getSystemVolumen();
            soundPool.play(tocSound, systemVolumen, systemVolumen, 1, 0, 1.0f);
        }
    }

    public final void setSounds(SoundPool soundPool) {
        sounds = soundPool;
    }
}
