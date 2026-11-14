package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/db/pojo/content/VoiceContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", TypedValues.TransitionType.S_DURATION, "", "waveSample", "", "path", "url", "size", "hash", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDuration", "()J", "getWaveSample", "()Ljava/lang/String;", "rebuild", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceContent extends FileContent {
    public static final int $stable = 0;
    private final long duration;
    private final String waveSample;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceContent(long j10, String waveSample, String path, String url, long j11, String hash) {
        super(null, path, url, j11, hash, 4, 1, null);
        y.i(waveSample, "waveSample");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.duration = j10;
        this.waveSample = waveSample;
    }

    public static /* synthetic */ VoiceContent rebuild$default(VoiceContent voiceContent, long j10, String str, String str2, String str3, long j11, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = voiceContent.duration;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = voiceContent.waveSample;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = voiceContent.getPath();
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = voiceContent.getUrl();
        }
        return voiceContent.rebuild(j12, str5, str6, str3, (i10 & 16) != 0 ? voiceContent.getSize() : j11, (i10 & 32) != 0 ? voiceContent.getHash() : str4);
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VoiceContent) && super.equals(other) && this.duration == ((VoiceContent) other).duration;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getWaveSample() {
        return this.waveSample;
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public int hashCode() {
        return (super.hashCode() * 31) + l.a(this.duration);
    }

    public final VoiceContent rebuild(long duration, String waveSample, String path, String url, long size, String hash) {
        y.i(waveSample, "waveSample");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new VoiceContent(duration, waveSample, path, url, size, hash);
    }

    public /* synthetic */ VoiceContent(long j10, String str, String str2, String str3, long j11, String str4, int i10, p pVar) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? "" : str3, j11, (i10 & 32) != 0 ? "" : str4);
    }
}
