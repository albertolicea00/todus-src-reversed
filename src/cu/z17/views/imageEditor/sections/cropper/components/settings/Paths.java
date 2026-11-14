package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/Paths;", "", "<init>", "()V", "Favorite", "Landroidx/compose/ui/graphics/Path;", "getFavorite", "()Landroidx/compose/ui/graphics/Path;", "Star", "getStar", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Paths {
    public static final int $stable;
    public static final Paths INSTANCE = new Paths();
    private static final Path Star;

    static {
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(12.0f, 17.27f);
        Path.lineTo(18.18f, 21.0f);
        Path.relativeLineTo(-1.64f, -7.03f);
        Path.lineTo(22.0f, 9.24f);
        Path.relativeLineTo(-7.19f, -0.61f);
        Path.lineTo(12.0f, 2.0f);
        Path.lineTo(9.19f, 8.63f);
        Path.lineTo(2.0f, 9.24f);
        Path.relativeLineTo(5.46f, 4.73f);
        Path.lineTo(5.82f, 21.0f);
        Path.close();
        Star = Path;
        $stable = 8;
    }

    private Paths() {
    }

    public final Path getFavorite() {
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(12.0f, 21.35f);
        Path.relativeLineTo(-1.45f, -1.32f);
        Path.cubicTo(5.4f, 15.36f, 2.0f, 12.28f, 2.0f, 8.5f);
        Path.cubicTo(2.0f, 5.42f, 4.42f, 3.0f, 7.5f, 3.0f);
        Path.relativeCubicTo(1.74f, 0.0f, 3.41f, 0.81f, 4.5f, 2.09f);
        Path.cubicTo(13.09f, 3.81f, 14.76f, 3.0f, 16.5f, 3.0f);
        Path.cubicTo(19.58f, 3.0f, 22.0f, 5.42f, 22.0f, 8.5f);
        Path.relativeCubicTo(0.0f, 3.78f, -3.4f, 6.86f, -8.55f, 11.54f);
        Path.lineTo(12.0f, 21.35f);
        Path.close();
        return Path;
    }

    public final Path getStar() {
        return Star;
    }
}
