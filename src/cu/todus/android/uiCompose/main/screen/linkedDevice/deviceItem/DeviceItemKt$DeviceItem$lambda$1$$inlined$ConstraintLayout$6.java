package cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.label.Z17LabelKt;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lua/k0;", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$6$2", "<anonymous>"}, k = 3, mv = {2, 3, 0})
public final class DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$6 extends e0 implements Function2 {
    final /* synthetic */ LinkedDevice $lD$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$6(LinkedDevice linkedDevice) {
        super(2);
        this.$lD$inlined = linkedDevice;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnnecessaryLambdaCreation"})
    public final void invoke(Composer composer, int i10) {
        if ((i10 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1131308473, i10, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous>.<anonymous> (ConstraintLayout.kt:841)");
        }
        composer.startReplaceGroup(779844140);
        Modifier.Companion companion = Modifier.INSTANCE;
        DeviceItemKt.DeviceIcon(PaddingKt.m1727paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "icon"), Dp.m8823constructorimpl(20), 0.0f, 2, null), this.$lD$inlined.getDevice(), composer, 6, 0);
        Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, LinkedDevice.COLUMN_DEVICE);
        String device = this.$lD$inlined.getDevice();
        Locale ROOT = Locale.ROOT;
        y.h(ROOT, "ROOT");
        String upperCase = device.toUpperCase(ROOT);
        y.h(upperCase, "toUpperCase(...)");
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i11 = MaterialTheme.$stable;
        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierLayoutId, upperCase, materialTheme.getTypography(composer, i11).getLabelMedium(), 0L, 0, 0, composer, 6, 56);
        Z17LabelKt.m10262Z17LabelfWhpE4E(LayoutIdKt.layoutId(companion, "date"), DateFormatter.INSTANCE.prettyFormatter(new Date(this.$lD$inlined.getDate())), materialTheme.getTypography(composer, i11).getLabelSmall(), 0L, 0, 0, composer, 6, 56);
        DeviceItemKt.State(LayoutIdKt.layoutId(companion, "state"), this.$lD$inlined, composer, 6, 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
