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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/db/pojo/content/AudioContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "name", "", TypedValues.TransitionType.S_DURATION, "", "path", "url", "size", "hash", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDuration", "()J", "rebuild", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AudioContent extends FileContent {
    public static final int $stable = 0;
    private final long duration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioContent(String name, long j10, String path, String url, long j11, String hash) {
        super(name, path, url, j11, hash, 3);
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.duration = j10;
    }

    public static /* synthetic */ AudioContent rebuild$default(AudioContent audioContent, long j10, String str, String str2, String str3, long j11, String str4, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rebuild");
        }
        if ((i10 & 1) != 0) {
            j10 = audioContent.duration;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = audioContent.getName();
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = audioContent.getPath();
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = audioContent.getUrl();
        }
        return audioContent.rebuild(j12, str5, str6, str3, (i10 & 16) != 0 ? audioContent.getSize() : j11, (i10 & 32) != 0 ? audioContent.getHash() : str4);
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AudioContent) && super.equals(other) && this.duration == ((AudioContent) other).duration;
    }

    public final long getDuration() {
        return this.duration;
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public int hashCode() {
        return (super.hashCode() * 31) + l.a(this.duration);
    }

    public final AudioContent rebuild(long duration, String name, String path, String url, long size, String hash) {
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new AudioContent(name, duration, path, url, size, hash);
    }

    public /* synthetic */ AudioContent(String str, long j10, String str2, String str3, long j11, String str4, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? "" : str3, j11, (i10 & 32) != 0 ? "" : str4);
    }
}
