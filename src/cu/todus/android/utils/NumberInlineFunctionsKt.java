package cu.todus.android.utils;

import androidx.camera.video.AudioStats;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0003\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0005\u001a!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0013\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0005\"\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "", "convertToByteSize", "(J)Ljava/lang/String;", "", "(I)Ljava/lang/String;", "", "(D)Ljava/lang/String;", "", "(F)Ljava/lang/String;", "convertToHumanTime", "humanDuration", "prefix", "", "toNumberWithPrefix", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lpb/d;", "Lrb/f;", ValidateElement.RangeValidateElement.METHOD, "nextInt", "(Lpb/d;Lrb/f;)I", "likeCounterFormat", "", "sizeName", "[Ljava/lang/String;", "getSizeName", "()[Ljava/lang/String;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NumberInlineFunctionsKt {
    private static final String[] sizeName = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};

    public static final String convertToByteSize(long j10) {
        if (j10 <= 0) {
            return "0 B";
        }
        double d10 = j10;
        int iFloor = (int) Math.floor(Math.log10(d10) / Math.log10(1024.0d));
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{Integer.valueOf(nb.c.c(d10 / Math.pow(1024.0d, iFloor))), sizeName[iFloor]}, 2));
        y.h(str, "format(...)");
        return str;
    }

    public static final String convertToHumanTime(long j10) {
        long j11 = 60;
        long j12 = j10 / j11;
        long j13 = j12 / j11;
        if (j13 > 0) {
            return j13 + "h " + (j12 % j11) + "m " + (j10 % j11) + "s";
        }
        if (j12 <= 0) {
            return j10 + "s";
        }
        return j12 + "m " + (j10 % j11) + "s";
    }

    public static final String[] getSizeName() {
        return sizeName;
    }

    public static final String humanDuration(long j10) {
        if (j10 <= 0) {
            return "00:00";
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j10);
        long seconds = timeUnit.toSeconds(j10) % ((long) 60);
        return (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    public static final String likeCounterFormat(int i10) {
        if (i10 < 1000) {
            return String.valueOf(i10);
        }
        if (i10 < 1000000) {
            e1 e1Var = e1.f36604a;
            String str = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((double) i10) / 1000.0d)}, 1));
            y.h(str, "format(...)");
            return a0.O(str, ".0", "", false, 4, null) + "K";
        }
        e1 e1Var2 = e1.f36604a;
        String str2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((double) i10) / 1000000.0d)}, 1));
        y.h(str2, "format(...)");
        return a0.O(str2, ".0", "", false, 4, null) + "M";
    }

    public static final int nextInt(pb.d dVar, rb.f range) {
        y.i(dVar, "<this>");
        y.i(range, "range");
        return range.c() + dVar.g((range.d() - range.c()) + 1);
    }

    public static final List<String> toNumberWithPrefix(String str, String prefix) {
        y.i(str, "<this>");
        y.i(prefix, "prefix");
        if (d0.a0(str, "+", false, 2, null)) {
            return v.e(a0.O(a0.O(d0.q1(a0.O(str, "+", "", false, 4, null)).toString(), " ", "", false, 4, null), "-", "", false, 4, null));
        }
        String strO = a0.O(d0.q1(a0.O(str, "+", "", false, 4, null)).toString(), " ", "", false, 4, null);
        if (a0.U(str, prefix, false, 2, null)) {
            return w.q(strO, prefix + strO);
        }
        return w.q(prefix + strO, strO);
    }

    public static /* synthetic */ List toNumberWithPrefix$default(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "53";
        }
        return toNumberWithPrefix(str, str2);
    }

    public static final String humanDuration(int i10) {
        return humanDuration(i10);
    }

    public static final String convertToByteSize(int i10) {
        if (i10 <= 0) {
            return "0 B";
        }
        double d10 = i10;
        int iFloor = (int) Math.floor(Math.log10(d10) / Math.log10(1024.0d));
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{Integer.valueOf(nb.c.c(d10 / Math.pow(1024.0d, iFloor))), sizeName[iFloor]}, 2));
        y.h(str, "format(...)");
        return str;
    }

    public static final String convertToByteSize(double d10) {
        if (d10 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return "0 B";
        }
        int iFloor = (int) Math.floor(Math.log10(d10) / Math.log10(1024.0d));
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{Integer.valueOf(nb.c.c(d10 / Math.pow(1024.0d, iFloor))), sizeName[iFloor]}, 2));
        y.h(str, "format(...)");
        return str;
    }

    public static final String convertToByteSize(float f10) {
        if (f10 <= 0.0f) {
            return "0 B";
        }
        double d10 = f10;
        int iFloor = (int) Math.floor(Math.log10(d10) / Math.log10(1024.0d));
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{Integer.valueOf(nb.c.c(d10 / Math.pow(1024.0d, iFloor))), sizeName[iFloor]}, 2));
        y.h(str, "format(...)");
        return str;
    }
}
