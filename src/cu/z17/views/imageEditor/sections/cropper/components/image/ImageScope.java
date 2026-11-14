package cu.z17.views.imageEditor.sections.cropper.components.image;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.IntRect;
import cu.todus.android.webrtc.sessions.ConstraintsKeys;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Stable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/image/ImageScope;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", ConstraintsKeys.KEY_MIN_WIDTH, "Landroidx/compose/ui/unit/Dp;", "getMinWidth-D9Ej5fM", "()F", ConstraintsKeys.KEY_MAX_WIDTH, "getMaxWidth-D9Ej5fM", ConstraintsKeys.KEY_MIN_HEIGHT, "getMinHeight-D9Ej5fM", ConstraintsKeys.KEY_MAX_HEIGHT, "getMaxHeight-D9Ej5fM", "imageWidth", "getImageWidth-D9Ej5fM", "imageHeight", "getImageHeight-D9Ej5fM", "rect", "Landroidx/compose/ui/unit/IntRect;", "getRect", "()Landroidx/compose/ui/unit/IntRect;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImageScope {
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    long mo10165getConstraintsmsEJaDk();

    /* JADX INFO: renamed from: getImageHeight-D9Ej5fM, reason: not valid java name */
    float mo10166getImageHeightD9Ej5fM();

    /* JADX INFO: renamed from: getImageWidth-D9Ej5fM, reason: not valid java name */
    float mo10167getImageWidthD9Ej5fM();

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    float mo10168getMaxHeightD9Ej5fM();

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    float mo10169getMaxWidthD9Ej5fM();

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    float mo10170getMinHeightD9Ej5fM();

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    float mo10171getMinWidthD9Ej5fM();

    IntRect getRect();
}
