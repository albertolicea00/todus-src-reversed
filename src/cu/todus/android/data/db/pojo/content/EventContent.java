package cu.todus.android.data.db.pojo.content;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/pojo/content/EventContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "title", "", ExtensionEvent.TAG_ICS, TtmlNode.START, "", TtmlNode.END, "allDay", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJZ)V", "getTitle", "()Ljava/lang/String;", "getIcs", "getStart", "()J", "getEnd", "getAllDay", "()Z", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EventContent extends Content {
    public static final int $stable = 0;
    private final boolean allDay;
    private final long end;
    private final String ics;
    private final long start;
    private final String title;

    public EventContent() {
        this(null, null, 0L, 0L, false, 31, null);
    }

    public static /* synthetic */ EventContent copy$default(EventContent eventContent, String str, String str2, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = eventContent.title;
        }
        if ((i10 & 2) != 0) {
            str2 = eventContent.ics;
        }
        if ((i10 & 4) != 0) {
            j10 = eventContent.start;
        }
        if ((i10 & 8) != 0) {
            j11 = eventContent.end;
        }
        if ((i10 & 16) != 0) {
            z10 = eventContent.allDay;
        }
        boolean z11 = z10;
        long j12 = j11;
        return eventContent.copy(str, str2, j10, j12, z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIcs() {
        return this.ics;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAllDay() {
        return this.allDay;
    }

    public final EventContent copy(String title, String ics, long start, long end, boolean allDay) {
        y.i(title, "title");
        y.i(ics, "ics");
        return new EventContent(title, ics, start, end, allDay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventContent)) {
            return false;
        }
        EventContent eventContent = (EventContent) other;
        return y.d(this.title, eventContent.title) && y.d(this.ics, eventContent.ics) && this.start == eventContent.start && this.end == eventContent.end && this.allDay == eventContent.allDay;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final long getEnd() {
        return this.end;
    }

    public final String getIcs() {
        return this.ics;
    }

    public final long getStart() {
        return this.start;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.ics.hashCode()) * 31) + l.a(this.start)) * 31) + l.a(this.end)) * 31) + r.a(this.allDay);
    }

    public String toString() {
        return "EventContent(title=" + this.title + ", ics=" + this.ics + ", start=" + this.start + ", end=" + this.end + ", allDay=" + this.allDay + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventContent(String title, String ics, long j10, long j11, boolean z10) {
        super(8);
        y.i(title, "title");
        y.i(ics, "ics");
        this.title = title;
        this.ics = ics;
        this.start = j10;
        this.end = j11;
        this.allDay = z10;
    }

    public /* synthetic */ EventContent(String str, String str2, long j10, long j11, boolean z10, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? 0L : j10, (i10 & 8) != 0 ? 0L : j11, (i10 & 16) != 0 ? false : z10);
    }
}
