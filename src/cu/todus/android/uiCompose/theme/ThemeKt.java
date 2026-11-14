package cu.todus.android.uiCompose.theme;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.z17.views.utils.Z17InlineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"", "themeSelected", "", "bigSize", "Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "content", "ToDusAppTheme", "(IZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroid/view/Window;", "window", "isLightStatusBar", "statusBarColor", "setSystemUiLightStatusBar", "(Landroid/view/Window;ZI)V", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "Landroidx/compose/material3/ColorScheme;", "DarkColorScheme", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme;
    private static final ColorScheme LightColorScheme;

    static {
        Light light = Light.INSTANCE;
        long jM10105getPrimary0d7_KjU = light.m10105getPrimary0d7_KjU();
        long jM10106getSecondary0d7_KjU = light.m10106getSecondary0d7_KjU();
        long jM10107getSurface0d7_KjU = light.m10107getSurface0d7_KjU();
        long jM10103getOnSurface0d7_KjU = light.m10103getOnSurface0d7_KjU();
        long jM10100getBackground0d7_KjU = light.m10100getBackground0d7_KjU();
        long jM10102getOnBackground0d7_KjU = light.m10102getOnBackground0d7_KjU();
        LightColorScheme = ColorSchemeKt.m3053lightColorScheme_VG5OTI$default(jM10105getPrimary0d7_KjU, 0L, 0L, 0L, light.m10101getInversePrimary0d7_KjU(), jM10106getSecondary0d7_KjU, 0L, 0L, 0L, light.m10108getTertiary0d7_KjU(), light.m10104getOnTertiary0d7_KjU(), 0L, 0L, jM10100getBackground0d7_KjU, jM10102getOnBackground0d7_KjU, jM10107getSurface0d7_KjU, jM10103getOnSurface0d7_KjU, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -124466, 65535, null);
        Dark dark = Dark.INSTANCE;
        long jM10096getPrimary0d7_KjU = dark.m10096getPrimary0d7_KjU();
        long jM10097getSecondary0d7_KjU = dark.m10097getSecondary0d7_KjU();
        long jM10098getSurface0d7_KjU = dark.m10098getSurface0d7_KjU();
        long jM10094getOnSurface0d7_KjU = dark.m10094getOnSurface0d7_KjU();
        long jM10091getBackground0d7_KjU = dark.m10091getBackground0d7_KjU();
        long jM10093getOnBackground0d7_KjU = dark.m10093getOnBackground0d7_KjU();
        DarkColorScheme = ColorSchemeKt.m3047darkColorScheme_VG5OTI$default(jM10096getPrimary0d7_KjU, 0L, 0L, 0L, dark.m10092getInversePrimary0d7_KjU(), jM10097getSecondary0d7_KjU, 0L, 0L, 0L, dark.m10099getTertiary0d7_KjU(), dark.m10095getOnTertiary0d7_KjU(), 0L, 0L, jM10091getBackground0d7_KjU, jM10093getOnBackground0d7_KjU, jM10098getSurface0d7_KjU, jM10094getOnSurface0d7_KjU, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -124466, 65535, null);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ToDusAppTheme(final int i10, boolean z10, final Function2 content, Composer composer, final int i11, final int i12) {
        int i13;
        ColorScheme colorScheme;
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(995650413);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(i10) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i14 = i12 & 2;
        if (i14 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (i14 != 0) {
                z10 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(995650413, i13, -1, "cu.todus.android.uiCompose.theme.ToDusAppTheme (Theme.kt:48)");
            }
            final u0 u0Var = new u0();
            if (i10 == 0) {
                composerStartRestartGroup.startReplaceGroup(-957653540);
                if (DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)) {
                    u0Var.f36629c = true;
                    colorScheme = DarkColorScheme;
                } else {
                    colorScheme = LightColorScheme;
                }
                composerStartRestartGroup.endReplaceGroup();
            } else if (i10 == 1) {
                composerStartRestartGroup.startReplaceGroup(377664877);
                composerStartRestartGroup.endReplaceGroup();
                colorScheme = LightColorScheme;
            } else if (i10 != 2) {
                composerStartRestartGroup.startReplaceGroup(-957643908);
                if (DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)) {
                    u0Var.f36629c = true;
                    colorScheme = DarkColorScheme;
                } else {
                    colorScheme = LightColorScheme;
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(377720367);
                composerStartRestartGroup.endReplaceGroup();
                u0Var.f36629c = true;
                colorScheme = DarkColorScheme;
            }
            final ColorScheme colorScheme2 = colorScheme;
            View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = Z17InlineUtilsKt.findActivity(context).getWindow();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Window window = (Window) objRememberedValue;
            if (view.isInEditMode()) {
                composerStartRestartGroup.startReplaceGroup(378855029);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(378140045);
                EffectsKt.SideEffect(new a() { // from class: z8.a
                    @Override // lb.a
                    public final Object invoke() {
                        return ThemeKt.ToDusAppTheme$lambda$1(window, u0Var, colorScheme2);
                    }
                }, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            MaterialThemeKt.MaterialTheme(colorScheme2, null, z10 ? TypeKt.appTypographyBig(colorScheme2) : TypeKt.appTypography(colorScheme2), content, composerStartRestartGroup, (i13 << 3) & 7168, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final boolean z11 = z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: z8.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.ToDusAppTheme$lambda$2(i10, z11, content, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ToDusAppTheme$lambda$1(Window window, u0 u0Var, ColorScheme colorScheme) {
        if (window != null) {
            if (u0Var.f36629c) {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-8193));
            } else {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & 16);
            }
            setSystemUiLightStatusBar(window, !u0Var.f36629c, ColorKt.m5920toArgb8_81llA(colorScheme.getBackground()));
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ToDusAppTheme$lambda$2(int i10, boolean z10, Function2 function2, int i11, int i12, Composer composer, int i13) {
        ToDusAppTheme(i10, z10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    private static final void setSystemUiLightStatusBar(Window window, boolean z10, int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            int i11 = z10 ? 8 : 0;
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(i11, 8);
            }
        } else {
            window.getDecorView().setSystemUiVisibility(z10 ? window.getDecorView().getSystemUiVisibility() | 8192 : window.getDecorView().getSystemUiVisibility() & (-8193));
        }
        window.setStatusBarColor(i10);
        window.setNavigationBarColor(i10);
        WindowInsetsControllerCompat insetsController2 = WindowCompat.getInsetsController(window, window.getDecorView());
        insetsController2.setAppearanceLightStatusBars(z10);
        insetsController2.setAppearanceLightNavigationBars(z10);
    }
}
