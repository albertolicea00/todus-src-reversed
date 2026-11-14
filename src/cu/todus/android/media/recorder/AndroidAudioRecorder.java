package cu.todus.android.media.recorder;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.CountDownTimer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.compress.packet.Compress;
import te.b0;
import te.r0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcu/todus/android/media/recorder/AndroidAudioRecorder;", "Lcu/todus/android/media/recorder/AudioRecorder;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/media/MediaRecorder;", "createRecorder", "()Landroid/media/MediaRecorder;", "", "length", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Compress.ELEMENT, "(I)Ljava/util/ArrayList;", "Ljava/io/File;", "outputFile", "Lua/k0;", TtmlNode.START, "(Ljava/io/File;)V", "stop", "()Ljava/io/File;", "Landroid/content/Context;", "recorder", "Landroid/media/MediaRecorder;", "actualFile", "Ljava/io/File;", "amplitudeArray", "Ljava/util/ArrayList;", "Lte/b0;", "", "elapsedTime", "Lte/b0;", "getElapsedTime", "()Lte/b0;", "setElapsedTime", "(Lte/b0;)V", "Landroid/os/CountDownTimer;", "timer", "Landroid/os/CountDownTimer;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AndroidAudioRecorder implements AudioRecorder {
    public static final int $stable = 8;
    private File actualFile;
    private ArrayList<Integer> amplitudeArray;
    private final Context context;
    private b0 elapsedTime;
    private MediaRecorder recorder;
    private CountDownTimer timer;

    public AndroidAudioRecorder(Context context) {
        y.i(context, "context");
        this.context = context;
        this.amplitudeArray = new ArrayList<>();
        this.elapsedTime = r0.a(0L);
    }

    private final MediaRecorder createRecorder() {
        if (Build.VERSION.SDK_INT < 31) {
            return new MediaRecorder();
        }
        b.a();
        return a.a(this.context);
    }

    public final ArrayList<Integer> compress(int length) {
        if (length == 0) {
            return new ArrayList<>();
        }
        int size = this.amplitudeArray.size() / length;
        int i10 = size / (4 >= size ? size - 1 : 4);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (i10 < 2) {
            i10 = 2;
        }
        int size2 = this.amplitudeArray.size();
        int iIntValue = 0;
        for (int i11 = 0; i11 < size2; i11++) {
            if (i11 % i10 == 0) {
                arrayList.add(Integer.valueOf(iIntValue / i10));
                iIntValue = 0;
            } else {
                Integer num = (Integer) g0.z0(this.amplitudeArray, i11);
                iIntValue += num != null ? num.intValue() : 0;
            }
        }
        return arrayList;
    }

    public final b0 getElapsedTime() {
        return this.elapsedTime;
    }

    public final void setElapsedTime(b0 b0Var) {
        y.i(b0Var, "<set-?>");
        this.elapsedTime = b0Var;
    }

    @Override // cu.todus.android.media.recorder.AudioRecorder
    public void start(File outputFile) {
        y.i(outputFile, "outputFile");
        this.actualFile = outputFile;
        MediaRecorder mediaRecorderCreateRecorder = createRecorder();
        mediaRecorderCreateRecorder.setAudioSource(1);
        mediaRecorderCreateRecorder.setOutputFormat(1);
        mediaRecorderCreateRecorder.setAudioEncoder(2);
        mediaRecorderCreateRecorder.setOutputFile(new FileOutputStream(this.actualFile).getFD());
        mediaRecorderCreateRecorder.prepare();
        mediaRecorderCreateRecorder.start();
        CountDownTimer countDownTimer = new CountDownTimer() { // from class: cu.todus.android.media.recorder.AndroidAudioRecorder$start$1$1
            {
                super(Long.MAX_VALUE, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                b0 elapsedTime = this.this$0.getElapsedTime();
                elapsedTime.setValue(Long.valueOf(((Number) elapsedTime.getValue()).longValue() + ((long) 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.timer = countDownTimer;
        countDownTimer.start();
        this.recorder = mediaRecorderCreateRecorder;
    }

    @Override // cu.todus.android.media.recorder.AudioRecorder
    public File stop() {
        try {
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.elapsedTime.setValue(0L);
            MediaRecorder mediaRecorder = this.recorder;
            if (mediaRecorder != null) {
                mediaRecorder.stop();
            }
            MediaRecorder mediaRecorder2 = this.recorder;
            if (mediaRecorder2 != null) {
                mediaRecorder2.reset();
            }
            this.recorder = null;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return this.actualFile;
    }
}
