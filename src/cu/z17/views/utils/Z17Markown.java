package cu.z17.views.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.z17.singledi.SingletonInitializer;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcu/z17/views/utils/Z17Markown;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/content/Context;", "", "scale", "F", "Laa/e;", "markwon", "Laa/e;", "getMarkwon", "()Laa/e;", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17Markown {
    private final Context context;
    private final aa.e markwon;
    private final float scale;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/z17/views/utils/Z17Markown$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/utils/Z17Markown;", "<init>", "()V", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<Z17Markown> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public Z17Markown(Context context) {
        y.i(context, "context");
        this.context = context;
        float f10 = context.getResources().getDisplayMetrics().density;
        this.scale = f10;
        aa.e eVarBuild = aa.e.a(context).a(fa.a.l()).a(ga.c.l(context)).a(ha.e.m()).a(ra.a.o(true)).a(qa.l.l()).a(ea.i.r((f10 * 18.0f) + 0.5f, new ea.i.d() { // from class: cu.z17.views.utils.r
            @Override // ea.i.d
            public final void a(ea.i.c cVar) {
                Z17Markown.markwon$lambda$1(cVar);
            }
        })).build();
        y.h(eVarBuild, "build(...)");
        this.markwon = eVarBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markwon$lambda$1(ea.i.c builder) {
        y.i(builder, "builder");
        builder.k(false);
        builder.g(true);
        builder.j(Executors.newCachedThreadPool());
        builder.i(new ea.i.f() { // from class: cu.z17.views.utils.q
            @Override // ea.i.f
            public final Drawable a(String str, Throwable th2) {
                return Z17Markown.markwon$lambda$1$lambda$0(str, th2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable markwon$lambda$1$lambda$0(String latex, Throwable error) {
        y.i(latex, "latex");
        y.i(error, "error");
        return null;
    }

    public final aa.e getMarkwon() {
        return this.markwon;
    }
}
