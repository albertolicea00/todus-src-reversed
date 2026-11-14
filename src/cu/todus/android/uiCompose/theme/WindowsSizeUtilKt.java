package cu.todus.android.uiCompose.theme;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.window.core.layout.WindowSizeClass;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"rememberWindowSizeClass", "Lcu/todus/android/uiCompose/theme/WindowSize;", "(Landroidx/compose/runtime/Composer;I)Lcu/todus/android/uiCompose/theme/WindowSize;", "getWindowSizeClass", "windowDpSize", "Landroidx/compose/ui/unit/Dp;", "getWindowSizeClass-0680j_4", "(F)Lcu/todus/android/uiCompose/theme/WindowSize;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WindowsSizeUtilKt {
    /* JADX INFO: renamed from: getWindowSizeClass-0680j_4, reason: not valid java name */
    public static final WindowSize m10122getWindowSizeClass0680j_4(float f10) {
        if (Dp.m8822compareTo0680j_4(f10, Dp.m8823constructorimpl(0)) < 0) {
            throw new IllegalArgumentException("Dp value cannot be negative");
        }
        if (Dp.m8822compareTo0680j_4(f10, Dp.m8823constructorimpl(600)) < 0) {
            return WindowSize.Compact;
        }
        return Dp.m8822compareTo0680j_4(f10, Dp.m8823constructorimpl((float) WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)) < 0 ? WindowSize.Medium : WindowSize.Expanded;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final WindowSize rememberWindowSizeClass(Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-483983844, i10, -1, "cu.todus.android.uiCompose.theme.rememberWindowSizeClass (WindowsSizeUtil.kt:24)");
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m8821boximpl(Dp.m8823constructorimpl(0)), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(16)), null, false, ComposableLambdaKt.rememberComposableLambda(-515711738, true, new Function3() { // from class: z8.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WindowsSizeUtilKt.rememberWindowSizeClass$lambda$3(mutableState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3078, 6);
        WindowSize windowSizeM10122getWindowSizeClass0680j_4 = m10122getWindowSizeClass0680j_4(rememberWindowSizeClass$lambda$1(mutableState));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return windowSizeM10122getWindowSizeClass0680j_4;
    }

    private static final float rememberWindowSizeClass$lambda$1(MutableState<Dp> mutableState) {
        return mutableState.getValue().m8837unboximpl();
    }

    private static final void rememberWindowSizeClass$lambda$2(MutableState<Dp> mutableState, float f10) {
        mutableState.setValue(Dp.m8821boximpl(f10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 rememberWindowSizeClass$lambda$3(MutableState mutableState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i10) {
        y.i(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-515711738, i10, -1, "cu.todus.android.uiCompose.theme.rememberWindowSizeClass.<anonymous> (WindowsSizeUtil.kt:29)");
            }
            rememberWindowSizeClass$lambda$2(mutableState, BoxWithConstraints.mo1635getMaxWidthD9Ej5fM());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }
}
