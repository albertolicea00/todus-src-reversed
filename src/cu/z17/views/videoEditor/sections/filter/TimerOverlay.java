package cu.z17.views.videoEditor.sections.filter;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.OverlaySettings;
import androidx.media3.effect.TextOverlay;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/z17/views/videoEditor/sections/filter/TimerOverlay;", "Landroidx/media3/effect/TextOverlay;", "<init>", "()V", "overlaySettings", "Landroidx/media3/effect/OverlaySettings;", "getText", "Landroid/text/SpannableString;", "presentationTimeUs", "", "getOverlaySettings", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimerOverlay extends TextOverlay {
    public static final int $stable = 8;
    private final OverlaySettings overlaySettings;

    public TimerOverlay() {
        OverlaySettings overlaySettingsBuild = new OverlaySettings.Builder().setOverlayFrameAnchor(1.0f, 1.0f).setBackgroundFrameAnchor(-0.7f, -0.95f).build();
        y.h(overlaySettingsBuild, "build(...)");
        this.overlaySettings = overlaySettingsBuild;
    }

    public OverlaySettings getOverlaySettings(long presentationTimeUs) {
        return this.overlaySettings;
    }

    @Override // androidx.media3.effect.TextOverlay
    public SpannableString getText(long presentationTimeUs) {
        e1 e1Var = e1.f36604a;
        String str = String.format(Locale.US, "%.02f", Arrays.copyOf(new Object[]{Float.valueOf(presentationTimeUs / 1000000.0f)}, 1));
        y.h(str, "format(...)");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
        return spannableString;
    }
}
