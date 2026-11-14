package cu.todus.android.uiCompose.call.screen.call.components.controls;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/VideoCallControlAction;", "", "Landroidx/compose/ui/graphics/painter/Painter;", "icon", "Landroidx/compose/ui/graphics/Color;", "iconTint", "background", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "callAction", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;JJLcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;Lkotlin/jvm/internal/p;)V", "component1", "()Landroidx/compose/ui/graphics/painter/Painter;", "component2-0d7_KjU", "()J", "component2", "component3-0d7_KjU", "component3", "component4", "()Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "copy-IbeAmgk", "(Landroidx/compose/ui/graphics/painter/Painter;JJLcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;)Lcu/todus/android/uiCompose/call/screen/call/components/controls/VideoCallControlAction;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "getIcon", "J", "getIconTint-0d7_KjU", "getBackground-0d7_KjU", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "getCallAction", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class VideoCallControlAction {
    public static final int $stable = Painter.$stable;
    private final long background;
    private final CallAction callAction;
    private final Painter icon;
    private final long iconTint;

    public /* synthetic */ VideoCallControlAction(Painter painter, long j10, long j11, CallAction callAction, p pVar) {
        this(painter, j10, j11, callAction);
    }

    /* JADX INFO: renamed from: copy-IbeAmgk$default, reason: not valid java name */
    public static /* synthetic */ VideoCallControlAction m9811copyIbeAmgk$default(VideoCallControlAction videoCallControlAction, Painter painter, long j10, long j11, CallAction callAction, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            painter = videoCallControlAction.icon;
        }
        if ((i10 & 2) != 0) {
            j10 = videoCallControlAction.iconTint;
        }
        if ((i10 & 4) != 0) {
            j11 = videoCallControlAction.background;
        }
        if ((i10 & 8) != 0) {
            callAction = videoCallControlAction.callAction;
        }
        CallAction callAction2 = callAction;
        return videoCallControlAction.m9814copyIbeAmgk(painter, j10, j11, callAction2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Painter getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getIconTint() {
        return this.iconTint;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CallAction getCallAction() {
        return this.callAction;
    }

    /* JADX INFO: renamed from: copy-IbeAmgk, reason: not valid java name */
    public final VideoCallControlAction m9814copyIbeAmgk(Painter icon, long iconTint, long background, CallAction callAction) {
        y.i(icon, "icon");
        y.i(callAction, "callAction");
        return new VideoCallControlAction(icon, iconTint, background, callAction, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallControlAction)) {
            return false;
        }
        VideoCallControlAction videoCallControlAction = (VideoCallControlAction) other;
        return y.d(this.icon, videoCallControlAction.icon) && Color.m5867equalsimpl0(this.iconTint, videoCallControlAction.iconTint) && Color.m5867equalsimpl0(this.background, videoCallControlAction.background) && y.d(this.callAction, videoCallControlAction.callAction);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m9815getBackground0d7_KjU() {
        return this.background;
    }

    public final CallAction getCallAction() {
        return this.callAction;
    }

    public final Painter getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: getIconTint-0d7_KjU, reason: not valid java name */
    public final long m9816getIconTint0d7_KjU() {
        return this.iconTint;
    }

    public int hashCode() {
        return (((((this.icon.hashCode() * 31) + Color.m5873hashCodeimpl(this.iconTint)) * 31) + Color.m5873hashCodeimpl(this.background)) * 31) + this.callAction.hashCode();
    }

    public String toString() {
        return "VideoCallControlAction(icon=" + this.icon + ", iconTint=" + Color.m5874toStringimpl(this.iconTint) + ", background=" + Color.m5874toStringimpl(this.background) + ", callAction=" + this.callAction + ")";
    }

    private VideoCallControlAction(Painter icon, long j10, long j11, CallAction callAction) {
        y.i(icon, "icon");
        y.i(callAction, "callAction");
        this.icon = icon;
        this.iconTint = j10;
        this.background = j11;
        this.callAction = callAction;
    }
}
