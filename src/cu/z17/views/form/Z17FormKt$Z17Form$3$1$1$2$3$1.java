package cu.z17.views.form;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class Z17FormKt$Z17Form$3$1$1$2$3$1 extends kotlin.jvm.internal.v implements lb.a {
    final /* synthetic */ MutableState<ua.y> $cameraDisplaying$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17FormKt$Z17Form$3$1$1$2$3$1(MutableState<ua.y> mutableState) {
        super(0, kotlin.jvm.internal.y.a.class, "clearImage", "Z17Form$lambda$38$clearImage(Landroidx/compose/runtime/MutableState;)Ljava/lang/String;", 0);
        this.$cameraDisplaying$delegate = mutableState;
    }

    @Override // lb.a
    public final String invoke() {
        return Z17FormKt.Z17Form$lambda$38$clearImage(this.$cameraDisplaying$delegate);
    }
}
