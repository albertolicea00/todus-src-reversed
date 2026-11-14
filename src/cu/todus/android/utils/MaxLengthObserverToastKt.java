package cu.todus.android.utils;

import android.content.Context;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "input", "", "maxLength", "Landroid/content/Context;", "context", "Lua/k0;", "MaxLengthObserver", "(Landroidx/compose/foundation/text/input/TextFieldState;ILandroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MaxLengthObserverToastKt {
    @Composable
    public static final void MaxLengthObserver(final TextFieldState input, final int i10, Context context, Composer composer, final int i11, final int i12) {
        int i13;
        y.i(input, "input");
        Composer composerStartRestartGroup = composer.startRestartGroup(-178516964);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(input) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= ((i12 & 4) == 0 && composerStartRestartGroup.changedInstance(context)) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i12 & 4) != 0) {
                    i13 &= -897;
                }
            } else if ((i12 & 4) != 0) {
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                i13 &= -897;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-178516964, i13, -1, "cu.todus.android.utils.MaxLengthObserver (MaxLengthObserverToast.kt:15)");
            }
            int i14 = i13 & 14;
            boolean zChangedInstance = (i14 == 4) | ((i13 & 112) == 32) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MaxLengthObserverToastKt$MaxLengthObserver$1$1(input, i10, context, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(input, (Function2) objRememberedValue, composerStartRestartGroup, i14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Context context2 = context;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.utils.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaxLengthObserverToastKt.MaxLengthObserver$lambda$1(input, i10, context2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 MaxLengthObserver$lambda$1(TextFieldState textFieldState, int i10, Context context, int i11, int i12, Composer composer, int i13) {
        MaxLengthObserver(textFieldState, i10, context, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
