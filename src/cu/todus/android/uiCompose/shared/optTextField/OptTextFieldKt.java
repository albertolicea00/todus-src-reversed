package cu.todus.android.uiCompose.shared.optTextField;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.uiCompose.shared.optTextField.OptTextFieldKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "otpText", "", Room.COLUMN_SECRET, "Lkotlin/Function1;", "Lua/k0;", "onOtpTextChange", "OtpTextField", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OptTextFieldKt {
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:60:0x0169  */
    /* JADX WARN: Code duplicated, block: B:62:0x0171  */
    /* JADX WARN: Code duplicated, block: B:65:0x017e  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OtpTextField(Modifier modifier, final String otpText, boolean z10, final Function1 onOtpTextChange, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        boolean z12;
        Composer composer2;
        final Modifier modifier3;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z14;
        VisualTransformation formattedTransformation;
        int i13;
        y.i(otpText, "otpText");
        y.i(onOtpTextChange, "onOtpTextChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1276331312);
        int i14 = i11 & 1;
        if (i14 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(otpText) ? 32 : 16;
        }
        int i15 = i11 & 4;
        if (i15 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onOtpTextChange)) {
                    i13 = 2048;
                } else {
                    i13 = 1024;
                }
                i12 |= i13;
            }
            if ((i12 & 1171) != 1170) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i14 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i15 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1276331312, i12, -1, "cu.todus.android.uiCompose.shared.optTextField.OtpTextField (OptTextField.kt:24)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8502getNumberPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (p) null);
                if (z14) {
                    formattedTransformation = new SecretFormattedTransformation();
                } else {
                    formattedTransformation = new FormattedTransformation();
                }
                VisualTransformation visualTransformation = formattedTransformation;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i16 = MaterialTheme.$stable;
                int i17 = ((i12 >> 3) & 14) | ((i12 >> 6) & 112);
                composer2 = composerStartRestartGroup;
                Modifier modifier5 = modifier4;
                OutlinedTextFieldKt.OutlinedTextField(otpText, onOtpTextChange, modifierFillMaxWidth$default, false, false, TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i16).getTitleSmall(), 0L, 0L, null, null, null, null, null, TextUnitKt.getSp(10), null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744319, null), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, visualTransformation, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) materialTheme.getShapes(composerStartRestartGroup, i16).getExtraLarge(), (TextFieldColors) null, composer2, i17, 12779520, 0, 6111192);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s8.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OptTextFieldKt.OtpTextField$lambda$0(modifier3, otpText, z13, onOtpTextChange, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z11 = z10;
        if ((i10 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onOtpTextChange)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if ((i12 & 1171) != 1170) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i14 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i15 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1276331312, i12, -1, "cu.todus.android.uiCompose.shared.optTextField.OtpTextField (OptTextField.kt:24)");
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8502getNumberPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (p) null);
            if (z14) {
                formattedTransformation = new SecretFormattedTransformation();
            } else {
                formattedTransformation = new FormattedTransformation();
            }
            VisualTransformation visualTransformation2 = formattedTransformation;
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i18 = MaterialTheme.$stable;
            int i19 = ((i12 >> 3) & 14) | ((i12 >> 6) & 112);
            composer2 = composerStartRestartGroup;
            Modifier modifier6 = modifier4;
            OutlinedTextFieldKt.OutlinedTextField(otpText, onOtpTextChange, modifierFillMaxWidth$default2, false, false, TextStyle.m8271copyp1EtxEg$default(materialTheme2.getTypography(composerStartRestartGroup, i18).getTitleSmall(), 0L, 0L, null, null, null, null, null, TextUnitKt.getSp(10), null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8692getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744319, null), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, visualTransformation2, keyboardOptions2, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) materialTheme2.getShapes(composerStartRestartGroup, i18).getExtraLarge(), (TextFieldColors) null, composer2, i19, 12779520, 0, 6111192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s8.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OptTextFieldKt.OtpTextField$lambda$0(modifier3, otpText, z13, onOtpTextChange, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 OtpTextField$lambda$0(Modifier modifier, String str, boolean z10, Function1 function1, int i10, int i11, Composer composer, int i12) {
        OtpTextField(modifier, str, z10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
