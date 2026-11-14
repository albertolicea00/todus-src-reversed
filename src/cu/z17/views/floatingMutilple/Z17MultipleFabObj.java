package cu.z17.views.floatingMutilple;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import cu.todus.android.notification.SystemNotificationExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import lb.a;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcu/z17/views/floatingMutilple/Z17MultipleFabObj;", "", "", "id", "label", "icon", "Landroidx/compose/ui/graphics/Color;", "buttonColor", "iconColor", "Lkotlin/Function0;", "Lua/k0;", SystemNotificationExecutor.ACTION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Llb/a;Lkotlin/jvm/internal/p;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getLabel", "Ljava/lang/Object;", "getIcon", "()Ljava/lang/Object;", "Landroidx/compose/ui/graphics/Color;", "getButtonColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getIconColor-QN2ZGVo", "Llb/a;", "getAction", "()Llb/a;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17MultipleFabObj {
    public static final int $stable = 8;
    private final a action;
    private final Color buttonColor;
    private final Object icon;
    private final Color iconColor;
    private final String id;
    private final String label;

    public /* synthetic */ Z17MultipleFabObj(String str, String str2, Object obj, Color color, Color color2, a aVar, p pVar) {
        this(str, str2, obj, color, color2, aVar);
    }

    public final a getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: getButtonColor-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getButtonColor() {
        return this.buttonColor;
    }

    public final Object getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: getIconColor-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getIconColor() {
        return this.iconColor;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    private Z17MultipleFabObj(String id2, String label, Object icon, Color color, Color color2, a action) {
        y.i(id2, "id");
        y.i(label, "label");
        y.i(icon, "icon");
        y.i(action, "action");
        this.id = id2;
        this.label = label;
        this.icon = icon;
        this.buttonColor = color;
        this.iconColor = color2;
        this.action = action;
    }

    public /* synthetic */ Z17MultipleFabObj(String str, String str2, Object obj, Color color, Color color2, a aVar, int i10, p pVar) {
        this(str, str2, obj, (i10 & 8) != 0 ? null : color, (i10 & 16) != 0 ? null : color2, aVar, null);
    }
}
