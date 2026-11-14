package cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.notification.SystemNotificationExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/actionIndicator/ActionIndicatorData;", "", SystemNotificationExecutor.ACTION, "", "reactionValue", "", "<init>", "(ILjava/lang/String;)V", "getAction", "()I", "getReactionValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ActionIndicatorData {
    public static final int $stable = 0;
    private final int action;
    private final String reactionValue;

    public ActionIndicatorData(int i10, String reactionValue) {
        y.i(reactionValue, "reactionValue");
        this.action = i10;
        this.reactionValue = reactionValue;
    }

    public static /* synthetic */ ActionIndicatorData copy$default(ActionIndicatorData actionIndicatorData, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = actionIndicatorData.action;
        }
        if ((i11 & 2) != 0) {
            str = actionIndicatorData.reactionValue;
        }
        return actionIndicatorData.copy(i10, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReactionValue() {
        return this.reactionValue;
    }

    public final ActionIndicatorData copy(int action, String reactionValue) {
        y.i(reactionValue, "reactionValue");
        return new ActionIndicatorData(action, reactionValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionIndicatorData)) {
            return false;
        }
        ActionIndicatorData actionIndicatorData = (ActionIndicatorData) other;
        return this.action == actionIndicatorData.action && y.d(this.reactionValue, actionIndicatorData.reactionValue);
    }

    public final int getAction() {
        return this.action;
    }

    public final String getReactionValue() {
        return this.reactionValue;
    }

    public int hashCode() {
        return (this.action * 31) + this.reactionValue.hashCode();
    }

    public String toString() {
        return "ActionIndicatorData(action=" + this.action + ", reactionValue=" + this.reactionValue + ")";
    }

    public /* synthetic */ ActionIndicatorData(int i10, String str, int i11, p pVar) {
        this(i10, (i11 & 2) != 0 ? "" : str);
    }
}
