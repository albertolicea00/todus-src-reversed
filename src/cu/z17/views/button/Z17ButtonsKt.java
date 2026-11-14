package cu.z17.views.button;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import androidx.room.FtsOptions;
import cu.todus.android.webrtc.sessions.ConstraintsKeys;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008a\u0001\u0010\u0019\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001aX\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0013\b\u0002\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 \u001aX\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0013\b\u0002\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b!\u0010 \u001ab\u0010#\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0013\b\u0002\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b#\u0010$\u001ab\u0010%\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0013\b\u0002\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010$\u001aN\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0013\b\u0002\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0011\u0010(\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b(\u0010)\u001a\u0011\u0010*\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b*\u0010)\u001a5\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u001b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b.\u0010/¨\u00065²\u0006\u000e\u00101\u001a\u0002008\n@\nX\u008a\u008e\u0002²\u0006\f\u00103\u001a\u0002028\nX\u008a\u0084\u0002²\u0006\f\u00104\u001a\u0002028\nX\u008a\u0084\u0002²\u0006\u000e\u00101\u001a\u0002008\n@\nX\u008a\u008e\u0002²\u0006\f\u00103\u001a\u0002028\nX\u008a\u0084\u0002²\u0006\f\u00104\u001a\u0002028\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "Lua/k0;", "onClick", "", "enabled", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/ButtonColors;", "colors", "Landroidx/compose/material3/ButtonElevation;", "elevation", "Landroidx/compose/foundation/BorderStroke;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Landroidx/compose/ui/focus/FocusManager;", "focusManager", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "content", "Z17BaseButton", "(Landroidx/compose/ui/Modifier;Llb/a;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/focus/FocusManager;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Z17BaseDialogButton", "(Llb/a;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/focus/FocusManager;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "", "text", "leading", ConstraintsKeys.KEY_MAX_WIDTH, "Z17PrimaryButton", "(Landroidx/compose/ui/Modifier;Llb/a;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/runtime/Composer;II)V", "Z17SecondaryButton", FtsOptions.TOKENIZER_SIMPLE, "Z17PrimaryDialogButton", "(Landroidx/compose/ui/Modifier;Llb/a;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/runtime/Composer;II)V", "Z17SecondaryDialogButton", "Z17SnackbarButton", "(Landroidx/compose/ui/Modifier;Llb/a;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;II)V", "bounceClick", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "invertedBounceClick", "", "image", "title", "Z17TitleDescBtn", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Lcu/z17/views/button/ButtonState;", "buttonState", "", "scale", "alphaC", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17ButtonsKt {
    /* JADX WARN: Code duplicated, block: B:100:0x011b  */
    /* JADX WARN: Code duplicated, block: B:101:0x011e  */
    /* JADX WARN: Code duplicated, block: B:105:0x012f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:109:0x013b  */
    /* JADX WARN: Code duplicated, block: B:111:0x014b  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0182  */
    /* JADX WARN: Code duplicated, block: B:133:0x018a  */
    /* JADX WARN: Code duplicated, block: B:134:0x0196  */
    /* JADX WARN: Code duplicated, block: B:137:0x019b  */
    /* JADX WARN: Code duplicated, block: B:138:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:142:0x0207  */
    /* JADX WARN: Code duplicated, block: B:144:0x020d  */
    /* JADX WARN: Code duplicated, block: B:145:0x020f  */
    /* JADX WARN: Code duplicated, block: B:147:0x0213  */
    /* JADX WARN: Code duplicated, block: B:148:0x021d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0223  */
    /* JADX WARN: Code duplicated, block: B:152:0x023a  */
    /* JADX WARN: Code duplicated, block: B:155:0x024f  */
    /* JADX WARN: Code duplicated, block: B:158:0x0262  */
    /* JADX WARN: Code duplicated, block: B:159:0x0265  */
    /* JADX WARN: Code duplicated, block: B:162:0x026e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0276  */
    /* JADX WARN: Code duplicated, block: B:167:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:169:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:172:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x010d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0115  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17BaseButton(Modifier modifier, final lb.a onClick, boolean z10, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, FocusManager focusManager, final Function3 content, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        boolean z11;
        Shape shape2;
        ButtonColors buttonColors2;
        int i13;
        BorderStroke borderStroke2;
        int i14;
        int i15;
        int i16;
        boolean z12;
        Composer composer2;
        ButtonElevation buttonElevation2;
        final BorderStroke borderStroke3;
        PaddingValues paddingValues2;
        Modifier modifier3;
        final boolean z13;
        Shape shape3;
        final ButtonColors buttonColors3;
        final FocusManager focusManager2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shapeM2015RoundedCornerShape0680j_4;
        Composer composer3;
        int i17;
        ButtonColors buttonColorsM2902buttonColorsro_MJ88;
        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs;
        BorderStroke borderStroke4;
        PaddingValues paddingValuesM1718PaddingValues0680j_4;
        boolean z14;
        BorderStroke borderStroke5;
        int i18;
        ButtonColors buttonColors4;
        final FocusManager focusManager3;
        boolean z15;
        boolean z16;
        Object objRememberedValue;
        int i19;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-781113525);
        int i20 = i11 & 1;
        if (i20 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i21 = i11 & 4;
        if (i21 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z11 = z10;
                i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    shape2 = shape;
                    int i22 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                    i12 |= i22;
                } else {
                    shape2 = shape;
                }
                i12 |= i22;
            } else {
                shape2 = shape;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    buttonColors2 = buttonColors;
                    int i23 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                    i12 |= i23;
                } else {
                    buttonColors2 = buttonColors;
                }
                i12 |= i23;
            } else {
                buttonColors2 = buttonColors;
            }
            if ((196608 & i10) != 0) {
                i12 |= ((i11 & 32) == 0 || !composerStartRestartGroup.changed(buttonElevation)) ? 65536 : 131072;
            }
            i13 = i11 & 64;
            if (i13 != 0) {
                if ((1572864 & i10) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 128;
                if (i15 != 0) {
                    i12 |= 12582912;
                } else if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i12 |= i16;
                }
                if ((i10 & 100663296) != 0) {
                    i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
                }
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i19 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i19 = 268435456;
                    }
                    i12 |= i19;
                }
                if ((i12 & 306783379) != 306783378) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i21 != 0) {
                            z11 = true;
                        }
                        if ((i11 & 8) != 0) {
                            shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                            i12 &= -7169;
                        } else {
                            shapeM2015RoundedCornerShape0680j_4 = shape2;
                        }
                        if ((i11 & 16) != 0) {
                            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i24 = MaterialTheme.$stable;
                            composer3 = composerStartRestartGroup;
                            i17 = i12 & (-57345);
                            buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults.m2902buttonColorsro_MJ88(materialTheme.getColorScheme(composerStartRestartGroup, i24).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i24).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                        } else {
                            composer3 = composerStartRestartGroup;
                            i17 = i12;
                            buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                        }
                        if ((i11 & 32) != 0) {
                            Composer composer4 = composer3;
                            buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer4, (ButtonDefaults.$stable << 15) | 6, 30);
                            composerStartRestartGroup = composer4;
                            i17 &= -458753;
                        } else {
                            composerStartRestartGroup = composer3;
                            buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i13 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i15 != 0) {
                            paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                        } else {
                            paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                        }
                        if ((i11 & 256) != 0) {
                            i18 = i17 & (-234881025);
                            ButtonColors buttonColors5 = buttonColorsM2902buttonColorsro_MJ88;
                            shape3 = shapeM2015RoundedCornerShape0680j_4;
                            focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                            buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                            buttonColors4 = buttonColors5;
                            paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                            modifier3 = modifier2;
                            z14 = z11;
                            borderStroke5 = borderStroke4;
                        } else {
                            paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                            modifier3 = modifier2;
                            z14 = z11;
                            buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                            borderStroke5 = borderStroke4;
                            i18 = i17;
                            buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                            shape3 = shapeM2015RoundedCornerShape0680j_4;
                            focusManager3 = focusManager;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                        }
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                        }
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                        }
                        if ((i11 & 256) != 0) {
                            i12 &= -234881025;
                        }
                        buttonElevation2 = buttonElevation;
                        paddingValues2 = paddingValues;
                        focusManager3 = focusManager;
                        modifier3 = modifier2;
                        i18 = i12;
                        z14 = z11;
                        shape3 = shape2;
                        buttonColors4 = buttonColors2;
                        borderStroke5 = borderStroke2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-781113525, i18, -1, "cu.z17.views.button.Z17BaseButton (Z17Buttons.kt:57)");
                    }
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager3);
                    if ((i18 & 112) == 32) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z16 = zChangedInstance | z15;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ButtonKt.Button((lb.a) objRememberedValue, modifier3, z14, shape3, buttonColors4, buttonElevation2, borderStroke5, paddingValues2, null, content, composerStartRestartGroup, ((i18 << 3) & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z13 = z14;
                    buttonColors3 = buttonColors4;
                    borderStroke3 = borderStroke5;
                    focusManager2 = focusManager3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    buttonElevation2 = buttonElevation;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z13 = z11;
                    shape3 = shape2;
                    buttonColors3 = buttonColors2;
                    focusManager2 = focusManager;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Shape shape4 = shape3;
                    final ButtonElevation buttonElevation3 = buttonElevation2;
                    final PaddingValues paddingValues3 = paddingValues2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17BaseButton$lambda$2(modifier4, onClick, z13, shape4, buttonColors3, buttonElevation3, borderStroke3, paddingValues3, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 1572864;
            borderStroke2 = borderStroke;
            i15 = i11 & 128;
            if (i15 != 0) {
                i12 |= 12582912;
            } else if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i12 |= i16;
            }
            if ((i10 & 100663296) != 0) {
                i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i19 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i19 = 268435456;
                }
                i12 |= i19;
            }
            if ((i12 & 306783379) != 306783378) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i21 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                        i12 &= -7169;
                    } else {
                        shapeM2015RoundedCornerShape0680j_4 = shape2;
                    }
                    if ((i11 & 16) != 0) {
                        ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        int i25 = MaterialTheme.$stable;
                        composer3 = composerStartRestartGroup;
                        i17 = i12 & (-57345);
                        buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults2.m2902buttonColorsro_MJ88(materialTheme2.getColorScheme(composerStartRestartGroup, i25).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i25).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i17 = i12;
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                    }
                    if ((i11 & 32) != 0) {
                        Composer composer5 = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer5, (ButtonDefaults.$stable << 15) | 6, 30);
                        composerStartRestartGroup = composer5;
                        i17 &= -458753;
                    } else {
                        composerStartRestartGroup = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i13 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i15 != 0) {
                        paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                    } else {
                        paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        i18 = i17 & (-234881025);
                        ButtonColors buttonColors6 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        buttonColors4 = buttonColors6;
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        borderStroke5 = borderStroke4;
                    } else {
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        borderStroke5 = borderStroke4;
                        i18 = i17;
                        buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = focusManager;
                    }
                } else {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i21 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                        i12 &= -7169;
                    } else {
                        shapeM2015RoundedCornerShape0680j_4 = shape2;
                    }
                    if ((i11 & 16) != 0) {
                        ButtonDefaults buttonDefaults3 = ButtonDefaults.INSTANCE;
                        MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                        int i26 = MaterialTheme.$stable;
                        composer3 = composerStartRestartGroup;
                        i17 = i12 & (-57345);
                        buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults3.m2902buttonColorsro_MJ88(materialTheme3.getColorScheme(composerStartRestartGroup, i26).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme3.getColorScheme(composerStartRestartGroup, i26).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i17 = i12;
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                    }
                    if ((i11 & 32) != 0) {
                        Composer composer6 = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer6, (ButtonDefaults.$stable << 15) | 6, 30);
                        composerStartRestartGroup = composer6;
                        i17 &= -458753;
                    } else {
                        composerStartRestartGroup = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i13 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i15 != 0) {
                        paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                    } else {
                        paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        i18 = i17 & (-234881025);
                        ButtonColors buttonColors7 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        buttonColors4 = buttonColors7;
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        borderStroke5 = borderStroke4;
                    } else {
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        borderStroke5 = borderStroke4;
                        i18 = i17;
                        buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = focusManager;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-781113525, i18, -1, "cu.z17.views.button.Z17BaseButton (Z17Buttons.kt:57)");
                }
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(focusManager3);
                if ((i18 & 112) == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = zChangedInstance2 | z15;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonKt.Button((lb.a) objRememberedValue, modifier3, z14, shape3, buttonColors4, buttonElevation2, borderStroke5, paddingValues2, null, content, composerStartRestartGroup, ((i18 << 3) & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                buttonColors3 = buttonColors4;
                borderStroke3 = borderStroke5;
                focusManager2 = focusManager3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                buttonElevation2 = buttonElevation;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z13 = z11;
                shape3 = shape2;
                buttonColors3 = buttonColors2;
                focusManager2 = focusManager;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier3;
                final Shape shape5 = shape3;
                final ButtonElevation buttonElevation4 = buttonElevation2;
                final PaddingValues paddingValues4 = paddingValues2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17BaseButton$lambda$2(modifier5, onClick, z13, shape5, buttonColors3, buttonElevation4, borderStroke3, paddingValues4, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z11 = z10;
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i12 |= i22;
            } else {
                shape2 = shape;
            }
            i12 |= i22;
        } else {
            shape2 = shape;
        }
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                buttonColors2 = buttonColors;
                if (composerStartRestartGroup.changed(buttonColors2)) {
                }
                i12 |= i23;
            } else {
                buttonColors2 = buttonColors;
            }
            i12 |= i23;
        } else {
            buttonColors2 = buttonColors;
        }
        if ((196608 & i10) != 0) {
            i12 |= ((i11 & 32) == 0 || !composerStartRestartGroup.changed(buttonElevation)) ? 65536 : 131072;
        }
        i13 = i11 & 64;
        if (i13 != 0) {
            if ((1572864 & i10) == 0) {
                borderStroke2 = borderStroke;
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i12 |= i14;
            }
            i15 = i11 & 128;
            if (i15 != 0) {
                i12 |= 12582912;
            } else if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i12 |= i16;
            }
            if ((i10 & 100663296) != 0) {
                i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i19 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i19 = 268435456;
                }
                i12 |= i19;
            }
            if ((i12 & 306783379) != 306783378) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i21 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                        i12 &= -7169;
                    } else {
                        shapeM2015RoundedCornerShape0680j_4 = shape2;
                    }
                    if ((i11 & 16) != 0) {
                        ButtonDefaults buttonDefaults4 = ButtonDefaults.INSTANCE;
                        MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                        int i27 = MaterialTheme.$stable;
                        composer3 = composerStartRestartGroup;
                        i17 = i12 & (-57345);
                        buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults4.m2902buttonColorsro_MJ88(materialTheme4.getColorScheme(composerStartRestartGroup, i27).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme4.getColorScheme(composerStartRestartGroup, i27).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i17 = i12;
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                    }
                    if ((i11 & 32) != 0) {
                        Composer composer7 = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer7, (ButtonDefaults.$stable << 15) | 6, 30);
                        composerStartRestartGroup = composer7;
                        i17 &= -458753;
                    } else {
                        composerStartRestartGroup = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i13 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i15 != 0) {
                        paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                    } else {
                        paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        i18 = i17 & (-234881025);
                        ButtonColors buttonColors8 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        buttonColors4 = buttonColors8;
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        borderStroke5 = borderStroke4;
                    } else {
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        borderStroke5 = borderStroke4;
                        i18 = i17;
                        buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = focusManager;
                    }
                } else {
                    if (i20 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i21 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                        i12 &= -7169;
                    } else {
                        shapeM2015RoundedCornerShape0680j_4 = shape2;
                    }
                    if ((i11 & 16) != 0) {
                        ButtonDefaults buttonDefaults5 = ButtonDefaults.INSTANCE;
                        MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                        int i28 = MaterialTheme.$stable;
                        composer3 = composerStartRestartGroup;
                        i17 = i12 & (-57345);
                        buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults5.m2902buttonColorsro_MJ88(materialTheme5.getColorScheme(composerStartRestartGroup, i28).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme5.getColorScheme(composerStartRestartGroup, i28).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i17 = i12;
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                    }
                    if ((i11 & 32) != 0) {
                        Composer composer8 = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer8, (ButtonDefaults.$stable << 15) | 6, 30);
                        composerStartRestartGroup = composer8;
                        i17 &= -458753;
                    } else {
                        composerStartRestartGroup = composer3;
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i13 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i15 != 0) {
                        paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                    } else {
                        paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        i18 = i17 & (-234881025);
                        ButtonColors buttonColors9 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        buttonColors4 = buttonColors9;
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        borderStroke5 = borderStroke4;
                    } else {
                        paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                        modifier3 = modifier2;
                        z14 = z11;
                        buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                        borderStroke5 = borderStroke4;
                        i18 = i17;
                        buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        focusManager3 = focusManager;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-781113525, i18, -1, "cu.z17.views.button.Z17BaseButton (Z17Buttons.kt:57)");
                }
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(focusManager3);
                if ((i18 & 112) == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = zChangedInstance3 | z15;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonKt.Button((lb.a) objRememberedValue, modifier3, z14, shape3, buttonColors4, buttonElevation2, borderStroke5, paddingValues2, null, content, composerStartRestartGroup, ((i18 << 3) & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z13 = z14;
                buttonColors3 = buttonColors4;
                borderStroke3 = borderStroke5;
                focusManager2 = focusManager3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                buttonElevation2 = buttonElevation;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z13 = z11;
                shape3 = shape2;
                buttonColors3 = buttonColors2;
                focusManager2 = focusManager;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier3;
                final Shape shape6 = shape3;
                final ButtonElevation buttonElevation5 = buttonElevation2;
                final PaddingValues paddingValues5 = paddingValues2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17BaseButton$lambda$2(modifier6, onClick, z13, shape6, buttonColors3, buttonElevation5, borderStroke3, paddingValues5, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 1572864;
        borderStroke2 = borderStroke;
        i15 = i11 & 128;
        if (i15 != 0) {
            i12 |= 12582912;
        } else if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i16 = 8388608;
            } else {
                i16 = 4194304;
            }
            i12 |= i16;
        }
        if ((i10 & 100663296) != 0) {
            i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
        }
        if ((i10 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i19 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i19 = 268435456;
            }
            i12 |= i19;
        }
        if ((i12 & 306783379) != 306783378) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i20 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i21 != 0) {
                    z11 = true;
                }
                if ((i11 & 8) != 0) {
                    shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    i12 &= -7169;
                } else {
                    shapeM2015RoundedCornerShape0680j_4 = shape2;
                }
                if ((i11 & 16) != 0) {
                    ButtonDefaults buttonDefaults6 = ButtonDefaults.INSTANCE;
                    MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                    int i29 = MaterialTheme.$stable;
                    composer3 = composerStartRestartGroup;
                    i17 = i12 & (-57345);
                    buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults6.m2902buttonColorsro_MJ88(materialTheme6.getColorScheme(composerStartRestartGroup, i29).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme6.getColorScheme(composerStartRestartGroup, i29).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                } else {
                    composer3 = composerStartRestartGroup;
                    i17 = i12;
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                }
                if ((i11 & 32) != 0) {
                    Composer composer9 = composer3;
                    buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer9, (ButtonDefaults.$stable << 15) | 6, 30);
                    composerStartRestartGroup = composer9;
                    i17 &= -458753;
                } else {
                    composerStartRestartGroup = composer3;
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                }
                if (i13 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if (i15 != 0) {
                    paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                } else {
                    paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                }
                if ((i11 & 256) != 0) {
                    i18 = i17 & (-234881025);
                    ButtonColors buttonColors10 = buttonColorsM2902buttonColorsro_MJ88;
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                    buttonColors4 = buttonColors10;
                    paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                    modifier3 = modifier2;
                    z14 = z11;
                    borderStroke5 = borderStroke4;
                } else {
                    paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                    modifier3 = modifier2;
                    z14 = z11;
                    buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                    borderStroke5 = borderStroke4;
                    i18 = i17;
                    buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    focusManager3 = focusManager;
                }
            } else {
                if (i20 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i21 != 0) {
                    z11 = true;
                }
                if ((i11 & 8) != 0) {
                    shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    i12 &= -7169;
                } else {
                    shapeM2015RoundedCornerShape0680j_4 = shape2;
                }
                if ((i11 & 16) != 0) {
                    ButtonDefaults buttonDefaults7 = ButtonDefaults.INSTANCE;
                    MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                    int i210 = MaterialTheme.$stable;
                    composer3 = composerStartRestartGroup;
                    i17 = i12 & (-57345);
                    buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults7.m2902buttonColorsro_MJ88(materialTheme7.getColorScheme(composerStartRestartGroup, i210).getPrimary(), 0L, Color.m5865copywmQWz5c$default(materialTheme7.getColorScheme(composerStartRestartGroup, i210).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, ButtonDefaults.$stable << 12, 10);
                } else {
                    composer3 = composerStartRestartGroup;
                    i17 = i12;
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors2;
                }
                if ((i11 & 32) != 0) {
                    Composer composer10 = composer3;
                    buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl((float) r14), 0.0f, 0.0f, 0.0f, 0.0f, composer10, (ButtonDefaults.$stable << 15) | 6, 30);
                    composerStartRestartGroup = composer10;
                    i17 &= -458753;
                } else {
                    composerStartRestartGroup = composer3;
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                }
                if (i13 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if (i15 != 0) {
                    paddingValuesM1718PaddingValues0680j_4 = PaddingKt.m1718PaddingValues0680j_4(Dp.m8823constructorimpl(15));
                } else {
                    paddingValuesM1718PaddingValues0680j_4 = paddingValues;
                }
                if ((i11 & 256) != 0) {
                    i18 = i17 & (-234881025);
                    ButtonColors buttonColors11 = buttonColorsM2902buttonColorsro_MJ88;
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                    buttonColors4 = buttonColors11;
                    paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                    modifier3 = modifier2;
                    z14 = z11;
                    borderStroke5 = borderStroke4;
                } else {
                    paddingValues2 = paddingValuesM1718PaddingValues0680j_4;
                    modifier3 = modifier2;
                    z14 = z11;
                    buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                    borderStroke5 = borderStroke4;
                    i18 = i17;
                    buttonColors4 = buttonColorsM2902buttonColorsro_MJ88;
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    focusManager3 = focusManager;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-781113525, i18, -1, "cu.z17.views.button.Z17BaseButton (Z17Buttons.kt:57)");
            }
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(focusManager3);
            if ((i18 & 112) == 32) {
                z15 = true;
            } else {
                z15 = false;
            }
            z16 = zChangedInstance4 | z15;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z16) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.i
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17ButtonsKt.Z17BaseButton$lambda$1$lambda$0(focusManager3, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ButtonKt.Button((lb.a) objRememberedValue, modifier3, z14, shape3, buttonColors4, buttonElevation2, borderStroke5, paddingValues2, null, content, composerStartRestartGroup, ((i18 << 3) & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 256);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z13 = z14;
            buttonColors3 = buttonColors4;
            borderStroke3 = borderStroke5;
            focusManager2 = focusManager3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            buttonElevation2 = buttonElevation;
            borderStroke3 = borderStroke;
            paddingValues2 = paddingValues;
            modifier3 = modifier2;
            z13 = z11;
            shape3 = shape2;
            buttonColors3 = buttonColors2;
            focusManager2 = focusManager;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Shape shape7 = shape3;
            final ButtonElevation buttonElevation6 = buttonElevation2;
            final PaddingValues paddingValues6 = paddingValues2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17BaseButton$lambda$2(modifier7, onClick, z13, shape7, buttonColors3, buttonElevation6, borderStroke3, paddingValues6, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BaseButton$lambda$1$lambda$0(FocusManager focusManager, lb.a aVar) {
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BaseButton$lambda$2(Modifier modifier, lb.a aVar, boolean z10, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, FocusManager focusManager, Function3 function3, int i10, int i11, Composer composer, int i12) {
        Z17BaseButton(modifier, aVar, z10, shape, buttonColors, buttonElevation, borderStroke, paddingValues, focusManager, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011a  */
    /* JADX WARN: Code duplicated, block: B:102:0x011d  */
    /* JADX WARN: Code duplicated, block: B:106:0x012e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0131  */
    /* JADX WARN: Code duplicated, block: B:110:0x013a  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0185  */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:137:0x0192  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01df  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:147:0x0203  */
    /* JADX WARN: Code duplicated, block: B:148:0x0205  */
    /* JADX WARN: Code duplicated, block: B:151:0x020b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0228  */
    /* JADX WARN: Code duplicated, block: B:155:0x0230  */
    /* JADX WARN: Code duplicated, block: B:156:0x0248  */
    /* JADX WARN: Code duplicated, block: B:159:0x025c  */
    /* JADX WARN: Code duplicated, block: B:163:0x026f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0279  */
    /* JADX WARN: Code duplicated, block: B:168:0x0281  */
    /* JADX WARN: Code duplicated, block: B:171:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:173:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:176:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x010c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0114  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17BaseDialogButton(final lb.a onClick, Modifier modifier, boolean z10, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, FocusManager focusManager, final Function3 content, Composer composer, final int i10, final int i11) {
        int i12;
        Modifier modifier2;
        int i13;
        boolean z11;
        int i14;
        Shape shapeM2015RoundedCornerShape0680j_4;
        ButtonColors buttonColorsM2902buttonColorsro_MJ88;
        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs;
        int i15;
        int i16;
        boolean z12;
        Composer composer2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final boolean z13;
        final Shape shape2;
        final ButtonColors buttonColors2;
        final ButtonElevation buttonElevation2;
        final PaddingValues paddingValues2;
        final FocusManager focusManager2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        BorderStroke borderStroke3;
        PaddingValues paddingValuesM1721PaddingValuesa9UjIt4;
        Shape shape3;
        ButtonElevation buttonElevation3;
        PaddingValues paddingValues3;
        int i17;
        Modifier modifier4;
        ButtonColors buttonColors3;
        boolean z14;
        BorderStroke borderStroke4;
        final FocusManager focusManager3;
        boolean zChangedInstance;
        Object objRememberedValue;
        int i18;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1459834549);
        if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        int i19 = i11 & 2;
        if (i19 == 0) {
            if ((i10 & 48) == 0) {
                modifier2 = modifier;
                i12 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i13 = i11 & 4;
            if (i13 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z11 = z10;
                    if (composerStartRestartGroup.changed(z11)) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                    i12 |= i14;
                }
                if ((i10 & 3072) == 0) {
                    if ((i11 & 8) == 0) {
                        shapeM2015RoundedCornerShape0680j_4 = shape;
                        int i20 = composerStartRestartGroup.changed(shapeM2015RoundedCornerShape0680j_4) ? 2048 : 1024;
                        i12 |= i20;
                    } else {
                        shapeM2015RoundedCornerShape0680j_4 = shape;
                    }
                    i12 |= i20;
                } else {
                    shapeM2015RoundedCornerShape0680j_4 = shape;
                }
                if ((i10 & 24576) == 0) {
                    if ((i11 & 16) == 0) {
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                        int i21 = composerStartRestartGroup.changed(buttonColorsM2902buttonColorsro_MJ88) ? 16384 : 8192;
                        i12 |= i21;
                    } else {
                        buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                    }
                    i12 |= i21;
                } else {
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                }
                if ((196608 & i10) == 0) {
                    if ((i11 & 32) == 0) {
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                        int i22 = composerStartRestartGroup.changed(buttonElevationM2903buttonElevationR_JCAzs) ? 131072 : 65536;
                        i12 |= i22;
                    } else {
                        buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    }
                    i12 |= i22;
                } else {
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                }
                i15 = i11 & 64;
                if (i15 != 0) {
                    i12 |= 1572864;
                } else if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i12 |= i16;
                }
                if ((i10 & 12582912) != 0) {
                    i12 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) != 0) {
                    i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
                }
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i18 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i18 = 268435456;
                    }
                    i12 |= i18;
                }
                if ((i12 & 306783379) != 306783378) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            z11 = true;
                        }
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                            shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                        }
                        if ((i11 & 16) != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            i12 &= -57345;
                            buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                        }
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                            buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                        }
                        if (i15 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i11 & 128) != 0) {
                            float f10 = 10;
                            float f11 = 15;
                            paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10));
                            i12 &= -29360129;
                        } else {
                            paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                        }
                        if ((i11 & 256) != 0) {
                            boolean z15 = z11;
                            borderStroke4 = borderStroke3;
                            focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                            shape3 = shapeM2015RoundedCornerShape0680j_4;
                            paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                            i17 = i12 & (-234881025);
                            modifier4 = modifier2;
                            buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                            z14 = z15;
                            buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        } else {
                            shape3 = shapeM2015RoundedCornerShape0680j_4;
                            buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                            paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                            i17 = i12;
                            modifier4 = modifier2;
                            buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                            z14 = z11;
                            borderStroke4 = borderStroke3;
                            focusManager3 = focusManager;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                        }
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                        }
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                        }
                        if ((i11 & 128) != 0) {
                            i12 &= -29360129;
                        }
                        if ((i11 & 256) != 0) {
                            i12 &= -234881025;
                        }
                        focusManager3 = focusManager;
                        i17 = i12;
                        modifier4 = modifier2;
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        paddingValues3 = paddingValues;
                        z14 = z11;
                        borderStroke4 = borderStroke;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1459834549, i17, -1, "cu.z17.views.button.Z17BaseDialogButton (Z17Buttons.kt:90)");
                    }
                    zChangedInstance = composerStartRestartGroup.changedInstance(focusManager3) | ((i17 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ButtonKt.Button((lb.a) objRememberedValue, modifier4, z14, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, null, content, composerStartRestartGroup, i17 & 1912602608, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z13 = z14;
                    shape2 = shape3;
                    buttonColors2 = buttonColors3;
                    buttonElevation2 = buttonElevation3;
                    borderStroke2 = borderStroke4;
                    paddingValues2 = paddingValues3;
                    focusManager2 = focusManager3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z13 = z11;
                    shape2 = shapeM2015RoundedCornerShape0680j_4;
                    buttonColors2 = buttonColorsM2902buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                    paddingValues2 = paddingValues;
                    focusManager2 = focusManager;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17BaseDialogButton$lambda$5(onClick, modifier3, z13, shape2, buttonColors2, buttonElevation2, borderStroke2, paddingValues2, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            z11 = z10;
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    shapeM2015RoundedCornerShape0680j_4 = shape;
                    if (composerStartRestartGroup.changed(shapeM2015RoundedCornerShape0680j_4)) {
                    }
                    i12 |= i20;
                } else {
                    shapeM2015RoundedCornerShape0680j_4 = shape;
                }
                i12 |= i20;
            } else {
                shapeM2015RoundedCornerShape0680j_4 = shape;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                    if (composerStartRestartGroup.changed(buttonColorsM2902buttonColorsro_MJ88)) {
                    }
                    i12 |= i21;
                } else {
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                }
                i12 |= i21;
            } else {
                buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
            }
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM2903buttonElevationR_JCAzs)) {
                    }
                    i12 |= i22;
                } else {
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                }
                i12 |= i22;
            } else {
                buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
            }
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
            } else if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            if ((i10 & 12582912) != 0) {
                i12 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) != 0) {
                i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i18 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i18 = 268435456;
                }
                i12 |= i18;
            }
            if ((i12 & 306783379) != 306783378) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    }
                    if ((i11 & 16) != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        i12 &= -57345;
                        buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                    }
                    if (i15 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i11 & 128) != 0) {
                        float f12 = 10;
                        float f13 = 15;
                        paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f12));
                        i12 &= -29360129;
                    } else {
                        paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        boolean z16 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12 & (-234881025);
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z16;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    } else {
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12;
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = focusManager;
                    }
                } else {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    }
                    if ((i11 & 16) != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        i12 &= -57345;
                        buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                    }
                    if (i15 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i11 & 128) != 0) {
                        float f14 = 10;
                        float f15 = 15;
                        paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f14), Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f14));
                        i12 &= -29360129;
                    } else {
                        paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        boolean z17 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12 & (-234881025);
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z17;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    } else {
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12;
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = focusManager;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1459834549, i17, -1, "cu.z17.views.button.Z17BaseDialogButton (Z17Buttons.kt:90)");
                }
                zChangedInstance = composerStartRestartGroup.changedInstance(focusManager3) | ((i17 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonKt.Button((lb.a) objRememberedValue, modifier4, z14, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, null, content, composerStartRestartGroup, i17 & 1912602608, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z13 = z14;
                shape2 = shape3;
                buttonColors2 = buttonColors3;
                buttonElevation2 = buttonElevation3;
                borderStroke2 = borderStroke4;
                paddingValues2 = paddingValues3;
                focusManager2 = focusManager3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z13 = z11;
                shape2 = shapeM2015RoundedCornerShape0680j_4;
                buttonColors2 = buttonColorsM2902buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                paddingValues2 = paddingValues;
                focusManager2 = focusManager;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17BaseDialogButton$lambda$5(onClick, modifier3, z13, shape2, buttonColors2, buttonElevation2, borderStroke2, paddingValues2, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        modifier2 = modifier;
        i13 = i11 & 4;
        if (i13 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z11 = z10;
                if (composerStartRestartGroup.changed(z11)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    shapeM2015RoundedCornerShape0680j_4 = shape;
                    if (composerStartRestartGroup.changed(shapeM2015RoundedCornerShape0680j_4)) {
                    }
                    i12 |= i20;
                } else {
                    shapeM2015RoundedCornerShape0680j_4 = shape;
                }
                i12 |= i20;
            } else {
                shapeM2015RoundedCornerShape0680j_4 = shape;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                    if (composerStartRestartGroup.changed(buttonColorsM2902buttonColorsro_MJ88)) {
                    }
                    i12 |= i21;
                } else {
                    buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                }
                i12 |= i21;
            } else {
                buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
            }
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM2903buttonElevationR_JCAzs)) {
                    }
                    i12 |= i22;
                } else {
                    buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                }
                i12 |= i22;
            } else {
                buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
            }
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
            } else if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
            if ((i10 & 12582912) != 0) {
                i12 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) != 0) {
                i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i18 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i18 = 268435456;
                }
                i12 |= i18;
            }
            if ((i12 & 306783379) != 306783378) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    }
                    if ((i11 & 16) != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        i12 &= -57345;
                        buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                    }
                    if (i15 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i11 & 128) != 0) {
                        float f16 = 10;
                        float f17 = 15;
                        paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f17), Dp.m8823constructorimpl(f16), Dp.m8823constructorimpl(f17), Dp.m8823constructorimpl(f16));
                        i12 &= -29360129;
                    } else {
                        paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        boolean z18 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12 & (-234881025);
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z18;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    } else {
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12;
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = focusManager;
                    }
                } else {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        z11 = true;
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                    }
                    if ((i11 & 16) != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        i12 &= -57345;
                        buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    if ((i11 & 32) != 0) {
                        i12 &= -458753;
                        buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                    }
                    if (i15 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i11 & 128) != 0) {
                        float f18 = 10;
                        float f19 = 15;
                        paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f19), Dp.m8823constructorimpl(f18), Dp.m8823constructorimpl(f19), Dp.m8823constructorimpl(f18));
                        i12 &= -29360129;
                    } else {
                        paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                    }
                    if ((i11 & 256) != 0) {
                        boolean z19 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12 & (-234881025);
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z19;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    } else {
                        shape3 = shapeM2015RoundedCornerShape0680j_4;
                        buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                        paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                        i17 = i12;
                        modifier4 = modifier2;
                        buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                        z14 = z11;
                        borderStroke4 = borderStroke3;
                        focusManager3 = focusManager;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1459834549, i17, -1, "cu.z17.views.button.Z17BaseDialogButton (Z17Buttons.kt:90)");
                }
                zChangedInstance = composerStartRestartGroup.changedInstance(focusManager3) | ((i17 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonKt.Button((lb.a) objRememberedValue, modifier4, z14, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, null, content, composerStartRestartGroup, i17 & 1912602608, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z13 = z14;
                shape2 = shape3;
                buttonColors2 = buttonColors3;
                buttonElevation2 = buttonElevation3;
                borderStroke2 = borderStroke4;
                paddingValues2 = paddingValues3;
                focusManager2 = focusManager3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z13 = z11;
                shape2 = shapeM2015RoundedCornerShape0680j_4;
                buttonColors2 = buttonColorsM2902buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
                paddingValues2 = paddingValues;
                focusManager2 = focusManager;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17BaseDialogButton$lambda$5(onClick, modifier3, z13, shape2, buttonColors2, buttonElevation2, borderStroke2, paddingValues2, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z11 = z10;
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                shapeM2015RoundedCornerShape0680j_4 = shape;
                if (composerStartRestartGroup.changed(shapeM2015RoundedCornerShape0680j_4)) {
                }
                i12 |= i20;
            } else {
                shapeM2015RoundedCornerShape0680j_4 = shape;
            }
            i12 |= i20;
        } else {
            shapeM2015RoundedCornerShape0680j_4 = shape;
        }
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
                if (composerStartRestartGroup.changed(buttonColorsM2902buttonColorsro_MJ88)) {
                }
                i12 |= i21;
            } else {
                buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
            }
            i12 |= i21;
        } else {
            buttonColorsM2902buttonColorsro_MJ88 = buttonColors;
        }
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevationM2903buttonElevationR_JCAzs)) {
                }
                i12 |= i22;
            } else {
                buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
            }
            i12 |= i22;
        } else {
            buttonElevationM2903buttonElevationR_JCAzs = buttonElevation;
        }
        i15 = i11 & 64;
        if (i15 != 0) {
            i12 |= 1572864;
        } else if ((i10 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        }
        if ((i10 & 12582912) != 0) {
            i12 |= ((i11 & 128) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 4194304 : 8388608;
        }
        if ((i10 & 100663296) != 0) {
            i12 |= ((i11 & 256) == 0 || !composerStartRestartGroup.changedInstance(focusManager)) ? 33554432 : 67108864;
        }
        if ((i10 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i18 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i18 = 268435456;
            }
            i12 |= i18;
        }
        if ((i12 & 306783379) != 306783378) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i19 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    z11 = true;
                }
                if ((i11 & 8) != 0) {
                    i12 &= -7169;
                    shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                }
                if ((i11 & 16) != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    i12 &= -57345;
                    buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                    buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                }
                if (i15 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if ((i11 & 128) != 0) {
                    float f110 = 10;
                    float f111 = 15;
                    paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f111), Dp.m8823constructorimpl(f110), Dp.m8823constructorimpl(f111), Dp.m8823constructorimpl(f110));
                    i12 &= -29360129;
                } else {
                    paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                }
                if ((i11 & 256) != 0) {
                    boolean z110 = z11;
                    borderStroke4 = borderStroke3;
                    focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                    i17 = i12 & (-234881025);
                    modifier4 = modifier2;
                    buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                    z14 = z110;
                    buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                } else {
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                    i17 = i12;
                    modifier4 = modifier2;
                    buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                    z14 = z11;
                    borderStroke4 = borderStroke3;
                    focusManager3 = focusManager;
                }
            } else {
                if (i19 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    z11 = true;
                }
                if ((i11 & 8) != 0) {
                    i12 &= -7169;
                    shapeM2015RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15));
                }
                if ((i11 & 16) != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    i12 &= -57345;
                    buttonColorsM2902buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2902buttonColorsro_MJ88(0L, 0L, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 11);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                if ((i11 & 32) != 0) {
                    i12 &= -458753;
                    buttonElevationM2903buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m2903buttonElevationR_JCAzs(Dp.m8823constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (ButtonDefaults.$stable << 15) | 6, 30);
                }
                if (i15 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if ((i11 & 128) != 0) {
                    float f112 = 10;
                    float f113 = 15;
                    paddingValuesM1721PaddingValuesa9UjIt4 = PaddingKt.m1721PaddingValuesa9UjIt4(Dp.m8823constructorimpl(f113), Dp.m8823constructorimpl(f112), Dp.m8823constructorimpl(f113), Dp.m8823constructorimpl(f112));
                    i12 &= -29360129;
                } else {
                    paddingValuesM1721PaddingValuesa9UjIt4 = paddingValues;
                }
                if ((i11 & 256) != 0) {
                    boolean z111 = z11;
                    borderStroke4 = borderStroke3;
                    focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                    i17 = i12 & (-234881025);
                    modifier4 = modifier2;
                    buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                    z14 = z111;
                    buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                } else {
                    shape3 = shapeM2015RoundedCornerShape0680j_4;
                    buttonElevation3 = buttonElevationM2903buttonElevationR_JCAzs;
                    paddingValues3 = paddingValuesM1721PaddingValuesa9UjIt4;
                    i17 = i12;
                    modifier4 = modifier2;
                    buttonColors3 = buttonColorsM2902buttonColorsro_MJ88;
                    z14 = z11;
                    borderStroke4 = borderStroke3;
                    focusManager3 = focusManager;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459834549, i17, -1, "cu.z17.views.button.Z17BaseDialogButton (Z17Buttons.kt:90)");
            }
            zChangedInstance = composerStartRestartGroup.changedInstance(focusManager3) | ((i17 & 14) == 4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.g
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17ButtonsKt.Z17BaseDialogButton$lambda$4$lambda$3(focusManager3, onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ButtonKt.Button((lb.a) objRememberedValue, modifier4, z14, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, null, content, composerStartRestartGroup, i17 & 1912602608, 256);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z13 = z14;
            shape2 = shape3;
            buttonColors2 = buttonColors3;
            buttonElevation2 = buttonElevation3;
            borderStroke2 = borderStroke4;
            paddingValues2 = paddingValues3;
            focusManager2 = focusManager3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            borderStroke2 = borderStroke;
            modifier3 = modifier2;
            z13 = z11;
            shape2 = shapeM2015RoundedCornerShape0680j_4;
            buttonColors2 = buttonColorsM2902buttonColorsro_MJ88;
            buttonElevation2 = buttonElevationM2903buttonElevationR_JCAzs;
            paddingValues2 = paddingValues;
            focusManager2 = focusManager;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17BaseDialogButton$lambda$5(onClick, modifier3, z13, shape2, buttonColors2, buttonElevation2, borderStroke2, paddingValues2, focusManager2, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BaseDialogButton$lambda$4$lambda$3(FocusManager focusManager, lb.a aVar) {
        androidx.compose.ui.focus.c.a(focusManager, false, 1, null);
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BaseDialogButton$lambda$5(lb.a aVar, Modifier modifier, boolean z10, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, FocusManager focusManager, Function3 function3, int i10, int i11, Composer composer, int i12) {
        Z17BaseDialogButton(aVar, modifier, z10, shape, buttonColors, buttonElevation, borderStroke, paddingValues, focusManager, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x0125  */
    /* JADX WARN: Code duplicated, block: B:87:0x012f  */
    /* JADX WARN: Code duplicated, block: B:90:0x013c  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17PrimaryButton(Modifier modifier, final lb.a onClick, final String text, Function2 function2, boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Function2 function3;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        int i16;
        boolean z14;
        final Modifier modifier3;
        final Function2 function4;
        final boolean z15;
        final boolean z16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Function2 function2M10132getLambda$1680480724$views_release;
        boolean z17;
        Modifier modifierFillMaxWidth$default;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1962348134);
        int i17 = i11 & 1;
        if (i17 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        int i18 = i11 & 8;
        if (i18 == 0) {
            if ((i10 & 3072) == 0) {
                function3 = function2;
                i12 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    z12 = z10;
                    if (composerStartRestartGroup.changed(z12)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    if ((196608 & i10) == 0) {
                        z13 = z11;
                        if (composerStartRestartGroup.changed(z13)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                    if ((74899 & i12) != 74898) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                        if (i17 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i18 != 0) {
                            function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                        } else {
                            function2M10132getLambda$1680480724$views_release = function3;
                        }
                        z17 = i13 == 0 ? z12 : false;
                        if (i15 != 0) {
                            z13 = true;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                        }
                        if (z17) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier4;
                        }
                        Function2 function5 = function2M10132getLambda$1680480724$views_release;
                        boolean z18 = z13;
                        Z17BaseButton(modifierFillMaxWidth$default, onClick, z18, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z16 = z18;
                        modifier3 = modifier4;
                        z15 = z17;
                        function4 = function5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function4 = function3;
                        z15 = z12;
                        z16 = z13;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z13 = z11;
                if ((74899 & i12) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                    } else {
                        function2M10132getLambda$1680480724$views_release = function3;
                    }
                    if (i13 == 0) {
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    Function2 function6 = function2M10132getLambda$1680480724$views_release;
                    boolean z19 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z19, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z19;
                    modifier3 = modifier4;
                    z15 = z17;
                    function4 = function6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z12 = z10;
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z13 = z11;
                    if (composerStartRestartGroup.changed(z13)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                if ((74899 & i12) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                    } else {
                        function2M10132getLambda$1680480724$views_release = function3;
                    }
                    if (i13 == 0) {
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    Function2 function7 = function2M10132getLambda$1680480724$views_release;
                    boolean z110 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z110, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z110;
                    modifier3 = modifier4;
                    z15 = z17;
                    function4 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z13 = z11;
            if ((74899 & i12) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                } else {
                    function2M10132getLambda$1680480724$views_release = function3;
                }
                if (i13 == 0) {
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                Function2 function8 = function2M10132getLambda$1680480724$views_release;
                boolean z111 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z111, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z111;
                modifier3 = modifier4;
                z15 = z17;
                function4 = function8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function3 = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                z12 = z10;
                if (composerStartRestartGroup.changed(z12)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z13 = z11;
                    if (composerStartRestartGroup.changed(z13)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                if ((74899 & i12) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                    } else {
                        function2M10132getLambda$1680480724$views_release = function3;
                    }
                    if (i13 == 0) {
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    Function2 function9 = function2M10132getLambda$1680480724$views_release;
                    boolean z112 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z112, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z112;
                    modifier3 = modifier4;
                    z15 = z17;
                    function4 = function9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z13 = z11;
            if ((74899 & i12) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                } else {
                    function2M10132getLambda$1680480724$views_release = function3;
                }
                if (i13 == 0) {
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                Function2 function10 = function2M10132getLambda$1680480724$views_release;
                boolean z113 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z113, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z113;
                modifier3 = modifier4;
                z15 = z17;
                function4 = function10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z12 = z10;
        i15 = i11 & 32;
        if (i15 != 0) {
            if ((196608 & i10) == 0) {
                z13 = z11;
                if (composerStartRestartGroup.changed(z13)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            if ((74899 & i12) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
                } else {
                    function2M10132getLambda$1680480724$views_release = function3;
                }
                if (i13 == 0) {
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                Function2 function11 = function2M10132getLambda$1680480724$views_release;
                boolean z114 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z114, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z114;
                modifier3 = modifier4;
                z15 = z17;
                function4 = function11;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z13 = z11;
        if ((74899 & i12) != 74898) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
            if (i17 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i18 != 0) {
                function2M10132getLambda$1680480724$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10132getLambda$1680480724$views_release();
            } else {
                function2M10132getLambda$1680480724$views_release = function3;
            }
            if (i13 == 0) {
            }
            if (i15 != 0) {
                z13 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1962348134, i12, -1, "cu.z17.views.button.Z17PrimaryButton (Z17Buttons.kt:116)");
            }
            if (z17) {
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
            } else {
                modifierFillMaxWidth$default = modifier4;
            }
            Function2 function12 = function2M10132getLambda$1680480724$views_release;
            boolean z115 = z13;
            Z17BaseButton(modifierFillMaxWidth$default, onClick, z115, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1033698527, true, new Function3() { // from class: cu.z17.views.button.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ButtonsKt.Z17PrimaryButton$lambda$6(function2M10132getLambda$1680480724$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i12 & 112) | 805306368 | ((i12 >> 9) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z16 = z115;
            modifier3 = modifier4;
            z15 = z17;
            function4 = function12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function4 = function3;
            z15 = z12;
            z16 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17PrimaryButton$lambda$7(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17PrimaryButton$lambda$6(Function2 function2, String str, RowScope Z17BaseButton, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17BaseButton, "$this$Z17BaseButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1033698527, i10, -1, "cu.z17.views.button.Z17PrimaryButton.<anonymous> (Z17Buttons.kt:122)");
            }
            function2.invoke(composer, 0);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PrimaryButton$lambda$7(Modifier modifier, lb.a aVar, String str, Function2 function2, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        Z17PrimaryButton(modifier, aVar, str, function2, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0132  */
    /* JADX WARN: Code duplicated, block: B:102:0x017e  */
    /* JADX WARN: Code duplicated, block: B:104:0x018b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0192  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:112:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x010b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0116  */
    /* JADX WARN: Code duplicated, block: B:95:0x0122  */
    /* JADX WARN: Code duplicated, block: B:98:0x012a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17PrimaryDialogButton(Modifier modifier, final lb.a onClick, final String text, Function2 function2, boolean z10, boolean z11, boolean z12, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Function2 lambda$1724683376$views_release;
        int i13;
        boolean z13;
        int i14;
        int i15;
        boolean z14;
        int i16;
        int i17;
        final boolean z15;
        int i18;
        boolean z16;
        final Modifier modifier3;
        final Function2 function3;
        final boolean z17;
        final boolean z18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z19;
        boolean z20;
        Modifier modifier5;
        Modifier modifierFillMaxWidth$default;
        Function2 function4;
        boolean z21;
        boolean z22;
        Object objRememberedValue;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-696398038);
        int i19 = i11 & 1;
        if (i19 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        int i20 = i11 & 8;
        if (i20 == 0) {
            if ((i10 & 3072) == 0) {
                lambda$1724683376$views_release = function2;
                i12 |= composerStartRestartGroup.changedInstance(lambda$1724683376$views_release) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    z13 = z10;
                    if (composerStartRestartGroup.changed(z13)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    if ((196608 & i10) == 0) {
                        z14 = z11;
                        if (composerStartRestartGroup.changed(z14)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                    i17 = i11 & 64;
                    if (i17 != 0) {
                        i12 |= 1572864;
                        z15 = z12;
                    } else {
                        z15 = z12;
                        if ((i10 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(z15)) {
                                i18 = 1048576;
                            } else {
                                i18 = 524288;
                            }
                            i12 |= i18;
                        }
                    }
                    if ((i12 & 599187) != 599186) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i20 != 0) {
                            lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                        }
                        if (i13 != 0) {
                            z19 = false;
                        } else {
                            z19 = z13;
                        }
                        if (i15 != 0) {
                            z14 = false;
                        }
                        if (i17 != 0) {
                            z20 = true;
                        } else {
                            z20 = z15;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                        }
                        if (z14) {
                            composerStartRestartGroup.startReplaceGroup(-1701636460);
                            z22 = (i12 & 112) == 32;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z22 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                            modifier5 = modifier4;
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i21 = MaterialTheme.$stable;
                            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default, text, materialTheme.getTypography(composerStartRestartGroup, i21).getBodyMedium(), materialTheme.getColorScheme(composerStartRestartGroup, i21).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                            composerStartRestartGroup.endReplaceGroup();
                            z21 = z20;
                            function4 = lambda$1724683376$views_release;
                        } else {
                            final Function2 function5 = lambda$1724683376$views_release;
                            modifier5 = modifier4;
                            composerStartRestartGroup.startReplaceGroup(-1701389917);
                            if (z19) {
                                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                            } else {
                                modifierFillMaxWidth$default = modifier5;
                            }
                            function4 = function5;
                            z21 = z20;
                            Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function5, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z15 = z21;
                        modifier3 = modifier5;
                        function3 = function4;
                        z17 = z19;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function3 = lambda$1724683376$views_release;
                        z17 = z13;
                    }
                    z18 = z14;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z14 = z11;
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z14 = false;
                    }
                    if (i17 != 0) {
                        z20 = true;
                    } else {
                        z20 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                    }
                    if (z14) {
                        composerStartRestartGroup.startReplaceGroup(-1701636460);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z22) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                        modifier5 = modifier4;
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        int i22 = MaterialTheme.$stable;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default2, text, materialTheme2.getTypography(composerStartRestartGroup, i22).getBodyMedium(), materialTheme2.getColorScheme(composerStartRestartGroup, i22).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z21 = z20;
                        function4 = lambda$1724683376$views_release;
                    } else {
                        final Function2 function6 = lambda$1724683376$views_release;
                        modifier5 = modifier4;
                        composerStartRestartGroup.startReplaceGroup(-1701389917);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier5;
                        }
                        function4 = function6;
                        z21 = z20;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function6, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z21;
                    modifier3 = modifier5;
                    function3 = function4;
                    z17 = z19;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = lambda$1724683376$views_release;
                    z17 = z13;
                }
                z18 = z14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z13 = z10;
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z14 = z11;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z14 = false;
                    }
                    if (i17 != 0) {
                        z20 = true;
                    } else {
                        z20 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                    }
                    if (z14) {
                        composerStartRestartGroup.startReplaceGroup(-1701636460);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z22) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default3 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                        modifier5 = modifier4;
                        MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                        int i23 = MaterialTheme.$stable;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default3, text, materialTheme3.getTypography(composerStartRestartGroup, i23).getBodyMedium(), materialTheme3.getColorScheme(composerStartRestartGroup, i23).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z21 = z20;
                        function4 = lambda$1724683376$views_release;
                    } else {
                        final Function2 function7 = lambda$1724683376$views_release;
                        modifier5 = modifier4;
                        composerStartRestartGroup.startReplaceGroup(-1701389917);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier5;
                        }
                        function4 = function7;
                        z21 = z20;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function7, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z21;
                    modifier3 = modifier5;
                    function3 = function4;
                    z17 = z19;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = lambda$1724683376$views_release;
                    z17 = z13;
                }
                z18 = z14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z14 = z11;
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z14 = false;
                }
                if (i17 != 0) {
                    z20 = true;
                } else {
                    z20 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                }
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(-1701636460);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z22) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default4 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                    modifier5 = modifier4;
                    MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                    int i24 = MaterialTheme.$stable;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default4, text, materialTheme4.getTypography(composerStartRestartGroup, i24).getBodyMedium(), materialTheme4.getColorScheme(composerStartRestartGroup, i24).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z21 = z20;
                    function4 = lambda$1724683376$views_release;
                } else {
                    final Function2 function8 = lambda$1724683376$views_release;
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1701389917);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier5;
                    }
                    function4 = function8;
                    z21 = z20;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function8, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z21;
                modifier3 = modifier5;
                function3 = function4;
                z17 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = lambda$1724683376$views_release;
                z17 = z13;
            }
            z18 = z14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        lambda$1724683376$views_release = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                z13 = z10;
                if (composerStartRestartGroup.changed(z13)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z14 = z11;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z14 = false;
                    }
                    if (i17 != 0) {
                        z20 = true;
                    } else {
                        z20 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                    }
                    if (z14) {
                        composerStartRestartGroup.startReplaceGroup(-1701636460);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z22) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default5 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                        modifier5 = modifier4;
                        MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                        int i25 = MaterialTheme.$stable;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default5, text, materialTheme5.getTypography(composerStartRestartGroup, i25).getBodyMedium(), materialTheme5.getColorScheme(composerStartRestartGroup, i25).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z21 = z20;
                        function4 = lambda$1724683376$views_release;
                    } else {
                        final Function2 function9 = lambda$1724683376$views_release;
                        modifier5 = modifier4;
                        composerStartRestartGroup.startReplaceGroup(-1701389917);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier5;
                        }
                        function4 = function9;
                        z21 = z20;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function9, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z21;
                    modifier3 = modifier5;
                    function3 = function4;
                    z17 = z19;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = lambda$1724683376$views_release;
                    z17 = z13;
                }
                z18 = z14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z14 = z11;
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z14 = false;
                }
                if (i17 != 0) {
                    z20 = true;
                } else {
                    z20 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                }
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(-1701636460);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z22) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default6 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                    modifier5 = modifier4;
                    MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                    int i26 = MaterialTheme.$stable;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default6, text, materialTheme6.getTypography(composerStartRestartGroup, i26).getBodyMedium(), materialTheme6.getColorScheme(composerStartRestartGroup, i26).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z21 = z20;
                    function4 = lambda$1724683376$views_release;
                } else {
                    final Function2 function10 = lambda$1724683376$views_release;
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1701389917);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier5;
                    }
                    function4 = function10;
                    z21 = z20;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function10, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z21;
                modifier3 = modifier5;
                function3 = function4;
                z17 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = lambda$1724683376$views_release;
                z17 = z13;
            }
            z18 = z14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z13 = z10;
        i15 = i11 & 32;
        if (i15 != 0) {
            if ((196608 & i10) == 0) {
                z14 = z11;
                if (composerStartRestartGroup.changed(z14)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z14 = false;
                }
                if (i17 != 0) {
                    z20 = true;
                } else {
                    z20 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
                }
                if (z14) {
                    composerStartRestartGroup.startReplaceGroup(-1701636460);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z22) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default7 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                    modifier5 = modifier4;
                    MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                    int i27 = MaterialTheme.$stable;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default7, text, materialTheme7.getTypography(composerStartRestartGroup, i27).getBodyMedium(), materialTheme7.getColorScheme(composerStartRestartGroup, i27).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z21 = z20;
                    function4 = lambda$1724683376$views_release;
                } else {
                    final Function2 function11 = lambda$1724683376$views_release;
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1701389917);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier5;
                    }
                    function4 = function11;
                    z21 = z20;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function11, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z21;
                modifier3 = modifier5;
                function3 = function4;
                z17 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = lambda$1724683376$views_release;
                z17 = z13;
            }
            z18 = z14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z14 = z11;
        i17 = i11 & 64;
        if (i17 != 0) {
            i12 |= 1572864;
            z15 = z12;
        } else {
            z15 = z12;
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z15)) {
                    i18 = 1048576;
                } else {
                    i18 = 524288;
                }
                i12 |= i18;
            }
        }
        if ((i12 & 599187) != 599186) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
            if (i19 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i20 != 0) {
                lambda$1724683376$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$1724683376$views_release();
            }
            if (i13 != 0) {
                z19 = false;
            } else {
                z19 = z13;
            }
            if (i15 != 0) {
                z14 = false;
            }
            if (i17 != 0) {
                z20 = true;
            } else {
                z20 = z15;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-696398038, i12, -1, "cu.z17.views.button.Z17PrimaryDialogButton (Z17Buttons.kt:170)");
            }
            if (z14) {
                composerStartRestartGroup.startReplaceGroup(-1701636460);
                if ((i12 & 112) == 32) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z22) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.x
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$11$lambda$10(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default8 = ClickableKt.m1238clickableXHw0xAI$default(modifier4, false, null, null, (lb.a) objRememberedValue, 7, null);
                modifier5 = modifier4;
                MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
                int i28 = MaterialTheme.$stable;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default8, text, materialTheme8.getTypography(composerStartRestartGroup, i28).getBodyMedium(), materialTheme8.getColorScheme(composerStartRestartGroup, i28).getPrimary(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                composerStartRestartGroup.endReplaceGroup();
                z21 = z20;
                function4 = lambda$1724683376$views_release;
            } else {
                final Function2 function12 = lambda$1724683376$views_release;
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-1701389917);
                if (z19) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier5;
                }
                function4 = function12;
                z21 = z20;
                Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z21, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1166952873, true, new Function3() { // from class: cu.z17.views.button.y
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$12(function12, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 3) & 14) | 805306368 | ((i12 >> 12) & 896), TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z15 = z21;
            modifier3 = modifier5;
            function3 = function4;
            z17 = z19;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function3 = lambda$1724683376$views_release;
            z17 = z13;
        }
        z18 = z14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17PrimaryDialogButton$lambda$13(modifier3, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PrimaryDialogButton$lambda$11$lambda$10(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17PrimaryDialogButton$lambda$12(Function2 function2, String str, RowScope Z17BaseDialogButton, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17BaseDialogButton, "$this$Z17BaseDialogButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1166952873, i10, -1, "cu.z17.views.button.Z17PrimaryDialogButton.<anonymous> (Z17Buttons.kt:184)");
            }
            function2.invoke(composer, 0);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PrimaryDialogButton$lambda$13(Modifier modifier, lb.a aVar, String str, Function2 function2, boolean z10, boolean z11, boolean z12, int i10, int i11, Composer composer, int i12) {
        Z17PrimaryDialogButton(modifier, aVar, str, function2, z10, z11, z12, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x0181  */
    /* JADX WARN: Code duplicated, block: B:89:0x018c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0199  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17SecondaryButton(Modifier modifier, final lb.a onClick, final String text, Function2 function2, boolean z10, boolean z11, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Function2 function3;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        int i16;
        int i17;
        boolean z14;
        final Modifier modifier3;
        final Function2 function4;
        final boolean z15;
        final boolean z16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function2 function2M10131getLambda$1322145890$views_release;
        boolean z17;
        Modifier modifierFillMaxWidth$default;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-961959592);
        int i18 = i11 & 1;
        if (i18 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        int i19 = i11 & 8;
        if (i19 == 0) {
            if ((i10 & 3072) == 0) {
                function3 = function2;
                i12 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    z12 = z10;
                    if (composerStartRestartGroup.changed(z12)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    if ((196608 & i10) == 0) {
                        z13 = z11;
                        if (composerStartRestartGroup.changed(z13)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                    i17 = i12;
                    if ((74899 & i17) != 74898) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                        if (i18 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i19 != 0) {
                            function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                        } else {
                            function2M10131getLambda$1322145890$views_release = function3;
                        }
                        if (i13 != 0) {
                            z17 = false;
                        } else {
                            z17 = z12;
                        }
                        if (i15 != 0) {
                            z13 = true;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                        }
                        if (z17) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier4;
                        }
                        final Function2 function5 = function2M10131getLambda$1322145890$views_release;
                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                        float f10 = 1;
                        float fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                        int i20 = ButtonDefaults.$stable;
                        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs = buttonDefaults.m2903buttonElevationR_JCAzs(fM8823constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i20 << 15) | 6, 30);
                        float fM8823constructorimpl2 = Dp.m8823constructorimpl(f10);
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i21 = MaterialTheme.$stable;
                        Modifier modifier5 = modifier4;
                        boolean z18 = z13;
                        Z17BaseButton(modifierFillMaxWidth$default, onClick, z18, null, buttonDefaults.m2902buttonColorsro_MJ88(materialTheme.getColorScheme(composerStartRestartGroup, i21).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i20 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl2, materialTheme.getColorScheme(composerStartRestartGroup, i21).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function5, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z16 = z18;
                        function4 = function5;
                        z15 = z17;
                        modifier3 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function4 = function3;
                        z15 = z12;
                        z16 = z13;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z13 = z11;
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                    if (i18 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i19 != 0) {
                        function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                    } else {
                        function2M10131getLambda$1322145890$views_release = function3;
                    }
                    if (i13 != 0) {
                        z17 = false;
                    } else {
                        z17 = z12;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    final Function2 function6 = function2M10131getLambda$1322145890$views_release;
                    ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
                    float f11 = 1;
                    float fM8823constructorimpl3 = Dp.m8823constructorimpl(f11);
                    int i22 = ButtonDefaults.$stable;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs2 = buttonDefaults2.m2903buttonElevationR_JCAzs(fM8823constructorimpl3, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i22 << 15) | 6, 30);
                    float fM8823constructorimpl4 = Dp.m8823constructorimpl(f11);
                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                    int i23 = MaterialTheme.$stable;
                    Modifier modifier6 = modifier4;
                    boolean z19 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z19, null, buttonDefaults2.m2902buttonColorsro_MJ88(materialTheme2.getColorScheme(composerStartRestartGroup, i23).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i22 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs2, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl4, materialTheme2.getColorScheme(composerStartRestartGroup, i23).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function6, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z19;
                    function4 = function6;
                    z15 = z17;
                    modifier3 = modifier6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z12 = z10;
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z13 = z11;
                    if (composerStartRestartGroup.changed(z13)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                    if (i18 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i19 != 0) {
                        function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                    } else {
                        function2M10131getLambda$1322145890$views_release = function3;
                    }
                    if (i13 != 0) {
                        z17 = false;
                    } else {
                        z17 = z12;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    final Function2 function7 = function2M10131getLambda$1322145890$views_release;
                    ButtonDefaults buttonDefaults3 = ButtonDefaults.INSTANCE;
                    float f12 = 1;
                    float fM8823constructorimpl5 = Dp.m8823constructorimpl(f12);
                    int i24 = ButtonDefaults.$stable;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs3 = buttonDefaults3.m2903buttonElevationR_JCAzs(fM8823constructorimpl5, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i24 << 15) | 6, 30);
                    float fM8823constructorimpl6 = Dp.m8823constructorimpl(f12);
                    MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                    int i25 = MaterialTheme.$stable;
                    Modifier modifier7 = modifier4;
                    boolean z110 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z110, null, buttonDefaults3.m2902buttonColorsro_MJ88(materialTheme3.getColorScheme(composerStartRestartGroup, i25).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i24 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs3, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl6, materialTheme3.getColorScheme(composerStartRestartGroup, i25).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function7, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z110;
                    function4 = function7;
                    z15 = z17;
                    modifier3 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z13 = z11;
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                if (i18 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i19 != 0) {
                    function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                } else {
                    function2M10131getLambda$1322145890$views_release = function3;
                }
                if (i13 != 0) {
                    z17 = false;
                } else {
                    z17 = z12;
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                final Function2 function8 = function2M10131getLambda$1322145890$views_release;
                ButtonDefaults buttonDefaults4 = ButtonDefaults.INSTANCE;
                float f13 = 1;
                float fM8823constructorimpl7 = Dp.m8823constructorimpl(f13);
                int i26 = ButtonDefaults.$stable;
                ButtonElevation buttonElevationM2903buttonElevationR_JCAzs4 = buttonDefaults4.m2903buttonElevationR_JCAzs(fM8823constructorimpl7, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i26 << 15) | 6, 30);
                float fM8823constructorimpl8 = Dp.m8823constructorimpl(f13);
                MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                int i27 = MaterialTheme.$stable;
                Modifier modifier8 = modifier4;
                boolean z111 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z111, null, buttonDefaults4.m2902buttonColorsro_MJ88(materialTheme4.getColorScheme(composerStartRestartGroup, i27).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i26 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs4, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl8, materialTheme4.getColorScheme(composerStartRestartGroup, i27).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function8, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z111;
                function4 = function8;
                z15 = z17;
                modifier3 = modifier8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function3 = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                z12 = z10;
                if (composerStartRestartGroup.changed(z12)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z13 = z11;
                    if (composerStartRestartGroup.changed(z13)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i12;
                if ((74899 & i17) != 74898) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                    if (i18 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i19 != 0) {
                        function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                    } else {
                        function2M10131getLambda$1322145890$views_release = function3;
                    }
                    if (i13 != 0) {
                        z17 = false;
                    } else {
                        z17 = z12;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                    }
                    if (z17) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    final Function2 function9 = function2M10131getLambda$1322145890$views_release;
                    ButtonDefaults buttonDefaults5 = ButtonDefaults.INSTANCE;
                    float f14 = 1;
                    float fM8823constructorimpl9 = Dp.m8823constructorimpl(f14);
                    int i28 = ButtonDefaults.$stable;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs5 = buttonDefaults5.m2903buttonElevationR_JCAzs(fM8823constructorimpl9, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i28 << 15) | 6, 30);
                    float fM8823constructorimpl10 = Dp.m8823constructorimpl(f14);
                    MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                    int i29 = MaterialTheme.$stable;
                    Modifier modifier9 = modifier4;
                    boolean z112 = z13;
                    Z17BaseButton(modifierFillMaxWidth$default, onClick, z112, null, buttonDefaults5.m2902buttonColorsro_MJ88(materialTheme5.getColorScheme(composerStartRestartGroup, i29).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i28 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs5, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl10, materialTheme5.getColorScheme(composerStartRestartGroup, i29).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function9, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z16 = z112;
                    function4 = function9;
                    z15 = z17;
                    modifier3 = modifier9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z15 = z12;
                    z16 = z13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z13 = z11;
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                if (i18 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i19 != 0) {
                    function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                } else {
                    function2M10131getLambda$1322145890$views_release = function3;
                }
                if (i13 != 0) {
                    z17 = false;
                } else {
                    z17 = z12;
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                final Function2 function10 = function2M10131getLambda$1322145890$views_release;
                ButtonDefaults buttonDefaults6 = ButtonDefaults.INSTANCE;
                float f15 = 1;
                float fM8823constructorimpl11 = Dp.m8823constructorimpl(f15);
                int i210 = ButtonDefaults.$stable;
                ButtonElevation buttonElevationM2903buttonElevationR_JCAzs6 = buttonDefaults6.m2903buttonElevationR_JCAzs(fM8823constructorimpl11, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i210 << 15) | 6, 30);
                float fM8823constructorimpl12 = Dp.m8823constructorimpl(f15);
                MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                int i211 = MaterialTheme.$stable;
                Modifier modifier10 = modifier4;
                boolean z113 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z113, null, buttonDefaults6.m2902buttonColorsro_MJ88(materialTheme6.getColorScheme(composerStartRestartGroup, i211).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i210 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs6, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl12, materialTheme6.getColorScheme(composerStartRestartGroup, i211).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function10, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z113;
                function4 = function10;
                z15 = z17;
                modifier3 = modifier10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z12 = z10;
        i15 = i11 & 32;
        if (i15 != 0) {
            if ((196608 & i10) == 0) {
                z13 = z11;
                if (composerStartRestartGroup.changed(z13)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            i17 = i12;
            if ((74899 & i17) != 74898) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
                if (i18 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i19 != 0) {
                    function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
                } else {
                    function2M10131getLambda$1322145890$views_release = function3;
                }
                if (i13 != 0) {
                    z17 = false;
                } else {
                    z17 = z12;
                }
                if (i15 != 0) {
                    z13 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
                }
                if (z17) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                final Function2 function11 = function2M10131getLambda$1322145890$views_release;
                ButtonDefaults buttonDefaults7 = ButtonDefaults.INSTANCE;
                float f16 = 1;
                float fM8823constructorimpl13 = Dp.m8823constructorimpl(f16);
                int i212 = ButtonDefaults.$stable;
                ButtonElevation buttonElevationM2903buttonElevationR_JCAzs7 = buttonDefaults7.m2903buttonElevationR_JCAzs(fM8823constructorimpl13, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i212 << 15) | 6, 30);
                float fM8823constructorimpl14 = Dp.m8823constructorimpl(f16);
                MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                int i213 = MaterialTheme.$stable;
                Modifier modifier11 = modifier4;
                boolean z114 = z13;
                Z17BaseButton(modifierFillMaxWidth$default, onClick, z114, null, buttonDefaults7.m2902buttonColorsro_MJ88(materialTheme7.getColorScheme(composerStartRestartGroup, i213).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i212 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs7, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl14, materialTheme7.getColorScheme(composerStartRestartGroup, i213).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function11, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z16 = z114;
                function4 = function11;
                z15 = z17;
                modifier3 = modifier11;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z15 = z12;
                z16 = z13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z13 = z11;
        i17 = i12;
        if ((74899 & i17) != 74898) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i17 & 1)) {
            if (i18 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i19 != 0) {
                function2M10131getLambda$1322145890$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10131getLambda$1322145890$views_release();
            } else {
                function2M10131getLambda$1322145890$views_release = function3;
            }
            if (i13 != 0) {
                z17 = false;
            } else {
                z17 = z12;
            }
            if (i15 != 0) {
                z13 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-961959592, i17, -1, "cu.z17.views.button.Z17SecondaryButton (Z17Buttons.kt:142)");
            }
            if (z17) {
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
            } else {
                modifierFillMaxWidth$default = modifier4;
            }
            final Function2 function12 = function2M10131getLambda$1322145890$views_release;
            ButtonDefaults buttonDefaults8 = ButtonDefaults.INSTANCE;
            float f17 = 1;
            float fM8823constructorimpl15 = Dp.m8823constructorimpl(f17);
            int i214 = ButtonDefaults.$stable;
            ButtonElevation buttonElevationM2903buttonElevationR_JCAzs8 = buttonDefaults8.m2903buttonElevationR_JCAzs(fM8823constructorimpl15, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i214 << 15) | 6, 30);
            float fM8823constructorimpl16 = Dp.m8823constructorimpl(f17);
            MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
            int i215 = MaterialTheme.$stable;
            Modifier modifier12 = modifier4;
            boolean z115 = z13;
            Z17BaseButton(modifierFillMaxWidth$default, onClick, z115, null, buttonDefaults8.m2902buttonColorsro_MJ88(materialTheme8.getColorScheme(composerStartRestartGroup, i215).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i214 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs8, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl16, materialTheme8.getColorScheme(composerStartRestartGroup, i215).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-41034351, true, new Function3() { // from class: cu.z17.views.button.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ButtonsKt.Z17SecondaryButton$lambda$8(function12, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | 805306368 | ((i17 >> 9) & 896), 392);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z16 = z115;
            function4 = function12;
            z15 = z17;
            modifier3 = modifier12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function4 = function3;
            z15 = z12;
            z16 = z13;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17SecondaryButton$lambda$9(modifier3, onClick, text, function4, z15, z16, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17SecondaryButton$lambda$8(Function2 function2, String str, RowScope Z17BaseButton, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17BaseButton, "$this$Z17BaseButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-41034351, i10, -1, "cu.z17.views.button.Z17SecondaryButton.<anonymous> (Z17Buttons.kt:151)");
            }
            function2.invoke(composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme.getTypography(composer, i11).getTitleSmall(), materialTheme.getColorScheme(composer, i11).getOnBackground(), 0, 0, composer, 0, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17SecondaryButton$lambda$9(Modifier modifier, lb.a aVar, String str, Function2 function2, boolean z10, boolean z11, int i10, int i11, Composer composer, int i12) {
        Z17SecondaryButton(modifier, aVar, str, function2, z10, z11, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0133  */
    /* JADX WARN: Code duplicated, block: B:103:0x017e  */
    /* JADX WARN: Code duplicated, block: B:105:0x018b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0194  */
    /* JADX WARN: Code duplicated, block: B:110:0x021f  */
    /* JADX WARN: Code duplicated, block: B:112:0x022b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0239  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:89:0x0105  */
    /* JADX WARN: Code duplicated, block: B:92:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0117  */
    /* JADX WARN: Code duplicated, block: B:96:0x0123  */
    /* JADX WARN: Code duplicated, block: B:99:0x012b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17SecondaryDialogButton(Modifier modifier, final lb.a onClick, final String text, Function2 function2, boolean z10, boolean z11, boolean z12, Composer composer, final int i10, final int i11) {
        int i12;
        Function2 function2M10133getLambda$273160606$views_release;
        int i13;
        boolean z13;
        int i14;
        int i15;
        boolean z14;
        int i16;
        int i17;
        final boolean z15;
        int i18;
        boolean z16;
        final Modifier modifier2;
        final Function2 function3;
        final boolean z17;
        final boolean z18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        boolean z19;
        boolean z20;
        boolean z21;
        Modifier modifier4;
        Modifier modifierFillMaxWidth$default;
        Function2 function4;
        boolean z22;
        boolean z23;
        Object objRememberedValue;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(939874972);
        int i19 = i11 & 1;
        if (i19 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        int i20 = i11 & 8;
        if (i20 == 0) {
            if ((i10 & 3072) == 0) {
                function2M10133getLambda$273160606$views_release = function2;
                i12 |= composerStartRestartGroup.changedInstance(function2M10133getLambda$273160606$views_release) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    z13 = z10;
                    if (composerStartRestartGroup.changed(z13)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    if ((196608 & i10) == 0) {
                        z14 = z11;
                        if (composerStartRestartGroup.changed(z14)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                    i17 = i11 & 64;
                    if (i17 != 0) {
                        i12 |= 1572864;
                        z15 = z12;
                    } else {
                        z15 = z12;
                        if ((i10 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(z15)) {
                                i18 = 1048576;
                            } else {
                                i18 = 524288;
                            }
                            i12 |= i18;
                        }
                    }
                    if ((i12 & 599187) != 599186) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                        if (i19 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i20 != 0) {
                            function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                        }
                        if (i13 != 0) {
                            z19 = false;
                        } else {
                            z19 = z13;
                        }
                        if (i15 != 0) {
                            z20 = false;
                        } else {
                            z20 = z14;
                        }
                        if (i17 != 0) {
                            z21 = true;
                        } else {
                            z21 = z15;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                        }
                        if (z20) {
                            composerStartRestartGroup.startReplaceGroup(923764285);
                            z23 = (i12 & 112) == 32;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z23 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i21 = MaterialTheme.$stable;
                            function4 = function2M10133getLambda$273160606$views_release;
                            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default, text, materialTheme.getTypography(composerStartRestartGroup, i21).getBodyMedium(), materialTheme.getColorScheme(composerStartRestartGroup, i21).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                            composerStartRestartGroup.endReplaceGroup();
                            z22 = z21;
                        } else {
                            final Function2 function5 = function2M10133getLambda$273160606$views_release;
                            modifier4 = modifier3;
                            composerStartRestartGroup.startReplaceGroup(924022980);
                            if (z19) {
                                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                            } else {
                                modifierFillMaxWidth$default = modifier4;
                            }
                            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                            float f10 = 1;
                            float fM8823constructorimpl = Dp.m8823constructorimpl(f10);
                            int i22 = ButtonDefaults.$stable;
                            int i23 = i12;
                            ButtonElevation buttonElevationM2903buttonElevationR_JCAzs = buttonDefaults.m2903buttonElevationR_JCAzs(fM8823constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i22 << 15) | 6, 30);
                            float fM8823constructorimpl2 = Dp.m8823constructorimpl(f10);
                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                            int i24 = MaterialTheme.$stable;
                            modifier3 = modifier4;
                            function4 = function5;
                            z22 = z21;
                            Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults.m2902buttonColorsro_MJ88(materialTheme2.getColorScheme(composerStartRestartGroup, i24).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i22 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl2, materialTheme2.getColorScheme(composerStartRestartGroup, i24).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function5, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i23 >> 3) & 14) | 805306368 | ((i23 >> 12) & 896), 392);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z15 = z22;
                        function3 = function4;
                        modifier2 = modifier3;
                        z17 = z19;
                        z18 = z20;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function3 = function2M10133getLambda$273160606$views_release;
                        z17 = z13;
                        z18 = z14;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z14 = z11;
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i20 != 0) {
                        function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z20 = false;
                    } else {
                        z20 = z14;
                    }
                    if (i17 != 0) {
                        z21 = true;
                    } else {
                        z21 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                    }
                    if (z20) {
                        composerStartRestartGroup.startReplaceGroup(923764285);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z23) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                        MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                        int i25 = MaterialTheme.$stable;
                        function4 = function2M10133getLambda$273160606$views_release;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default2, text, materialTheme3.getTypography(composerStartRestartGroup, i25).getBodyMedium(), materialTheme3.getColorScheme(composerStartRestartGroup, i25).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z22 = z21;
                    } else {
                        final Function2 function6 = function2M10133getLambda$273160606$views_release;
                        modifier4 = modifier3;
                        composerStartRestartGroup.startReplaceGroup(924022980);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier4;
                        }
                        ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
                        float f11 = 1;
                        float fM8823constructorimpl3 = Dp.m8823constructorimpl(f11);
                        int i26 = ButtonDefaults.$stable;
                        int i27 = i12;
                        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs2 = buttonDefaults2.m2903buttonElevationR_JCAzs(fM8823constructorimpl3, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i26 << 15) | 6, 30);
                        float fM8823constructorimpl4 = Dp.m8823constructorimpl(f11);
                        MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                        int i28 = MaterialTheme.$stable;
                        modifier3 = modifier4;
                        function4 = function6;
                        z22 = z21;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults2.m2902buttonColorsro_MJ88(materialTheme4.getColorScheme(composerStartRestartGroup, i28).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i26 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs2, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl4, materialTheme4.getColorScheme(composerStartRestartGroup, i28).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function6, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i27 >> 3) & 14) | 805306368 | ((i27 >> 12) & 896), 392);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z22;
                    function3 = function4;
                    modifier2 = modifier3;
                    z17 = z19;
                    z18 = z20;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function3 = function2M10133getLambda$273160606$views_release;
                    z17 = z13;
                    z18 = z14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z13 = z10;
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z14 = z11;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i20 != 0) {
                        function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z20 = false;
                    } else {
                        z20 = z14;
                    }
                    if (i17 != 0) {
                        z21 = true;
                    } else {
                        z21 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                    }
                    if (z20) {
                        composerStartRestartGroup.startReplaceGroup(923764285);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z23) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default3 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                        MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                        int i29 = MaterialTheme.$stable;
                        function4 = function2M10133getLambda$273160606$views_release;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default3, text, materialTheme5.getTypography(composerStartRestartGroup, i29).getBodyMedium(), materialTheme5.getColorScheme(composerStartRestartGroup, i29).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z22 = z21;
                    } else {
                        final Function2 function7 = function2M10133getLambda$273160606$views_release;
                        modifier4 = modifier3;
                        composerStartRestartGroup.startReplaceGroup(924022980);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier4;
                        }
                        ButtonDefaults buttonDefaults3 = ButtonDefaults.INSTANCE;
                        float f12 = 1;
                        float fM8823constructorimpl5 = Dp.m8823constructorimpl(f12);
                        int i210 = ButtonDefaults.$stable;
                        int i211 = i12;
                        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs3 = buttonDefaults3.m2903buttonElevationR_JCAzs(fM8823constructorimpl5, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i210 << 15) | 6, 30);
                        float fM8823constructorimpl6 = Dp.m8823constructorimpl(f12);
                        MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                        int i212 = MaterialTheme.$stable;
                        modifier3 = modifier4;
                        function4 = function7;
                        z22 = z21;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults3.m2902buttonColorsro_MJ88(materialTheme6.getColorScheme(composerStartRestartGroup, i212).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i210 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs3, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl6, materialTheme6.getColorScheme(composerStartRestartGroup, i212).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function7, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i211 >> 3) & 14) | 805306368 | ((i211 >> 12) & 896), 392);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z22;
                    function3 = function4;
                    modifier2 = modifier3;
                    z17 = z19;
                    z18 = z20;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function3 = function2M10133getLambda$273160606$views_release;
                    z17 = z13;
                    z18 = z14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z14 = z11;
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i20 != 0) {
                    function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z20 = false;
                } else {
                    z20 = z14;
                }
                if (i17 != 0) {
                    z21 = true;
                } else {
                    z21 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                }
                if (z20) {
                    composerStartRestartGroup.startReplaceGroup(923764285);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default4 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                    MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                    int i213 = MaterialTheme.$stable;
                    function4 = function2M10133getLambda$273160606$views_release;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default4, text, materialTheme7.getTypography(composerStartRestartGroup, i213).getBodyMedium(), materialTheme7.getColorScheme(composerStartRestartGroup, i213).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z22 = z21;
                } else {
                    final Function2 function8 = function2M10133getLambda$273160606$views_release;
                    modifier4 = modifier3;
                    composerStartRestartGroup.startReplaceGroup(924022980);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    ButtonDefaults buttonDefaults4 = ButtonDefaults.INSTANCE;
                    float f13 = 1;
                    float fM8823constructorimpl7 = Dp.m8823constructorimpl(f13);
                    int i214 = ButtonDefaults.$stable;
                    int i215 = i12;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs4 = buttonDefaults4.m2903buttonElevationR_JCAzs(fM8823constructorimpl7, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i214 << 15) | 6, 30);
                    float fM8823constructorimpl8 = Dp.m8823constructorimpl(f13);
                    MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
                    int i216 = MaterialTheme.$stable;
                    modifier3 = modifier4;
                    function4 = function8;
                    z22 = z21;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults4.m2902buttonColorsro_MJ88(materialTheme8.getColorScheme(composerStartRestartGroup, i216).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i214 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs4, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl8, materialTheme8.getColorScheme(composerStartRestartGroup, i216).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function8, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i215 >> 3) & 14) | 805306368 | ((i215 >> 12) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z22;
                function3 = function4;
                modifier2 = modifier3;
                z17 = z19;
                z18 = z20;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function3 = function2M10133getLambda$273160606$views_release;
                z17 = z13;
                z18 = z14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function2M10133getLambda$273160606$views_release = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                z13 = z10;
                if (composerStartRestartGroup.changed(z13)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                if ((196608 & i10) == 0) {
                    z14 = z11;
                    if (composerStartRestartGroup.changed(z14)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
                i17 = i11 & 64;
                if (i17 != 0) {
                    i12 |= 1572864;
                    z15 = z12;
                } else {
                    z15 = z12;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z15)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i12 |= i18;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                    if (i19 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i20 != 0) {
                        function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                    }
                    if (i13 != 0) {
                        z19 = false;
                    } else {
                        z19 = z13;
                    }
                    if (i15 != 0) {
                        z20 = false;
                    } else {
                        z20 = z14;
                    }
                    if (i17 != 0) {
                        z21 = true;
                    } else {
                        z21 = z15;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                    }
                    if (z20) {
                        composerStartRestartGroup.startReplaceGroup(923764285);
                        if ((i12 & 112) == 32) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z23) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM1238clickableXHw0xAI$default5 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                        MaterialTheme materialTheme9 = MaterialTheme.INSTANCE;
                        int i217 = MaterialTheme.$stable;
                        function4 = function2M10133getLambda$273160606$views_release;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default5, text, materialTheme9.getTypography(composerStartRestartGroup, i217).getBodyMedium(), materialTheme9.getColorScheme(composerStartRestartGroup, i217).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                        composerStartRestartGroup.endReplaceGroup();
                        z22 = z21;
                    } else {
                        final Function2 function9 = function2M10133getLambda$273160606$views_release;
                        modifier4 = modifier3;
                        composerStartRestartGroup.startReplaceGroup(924022980);
                        if (z19) {
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                        } else {
                            modifierFillMaxWidth$default = modifier4;
                        }
                        ButtonDefaults buttonDefaults5 = ButtonDefaults.INSTANCE;
                        float f14 = 1;
                        float fM8823constructorimpl9 = Dp.m8823constructorimpl(f14);
                        int i218 = ButtonDefaults.$stable;
                        int i219 = i12;
                        ButtonElevation buttonElevationM2903buttonElevationR_JCAzs5 = buttonDefaults5.m2903buttonElevationR_JCAzs(fM8823constructorimpl9, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i218 << 15) | 6, 30);
                        float fM8823constructorimpl10 = Dp.m8823constructorimpl(f14);
                        MaterialTheme materialTheme10 = MaterialTheme.INSTANCE;
                        int i2110 = MaterialTheme.$stable;
                        modifier3 = modifier4;
                        function4 = function9;
                        z22 = z21;
                        Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults5.m2902buttonColorsro_MJ88(materialTheme10.getColorScheme(composerStartRestartGroup, i2110).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i218 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs5, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl10, materialTheme10.getColorScheme(composerStartRestartGroup, i2110).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function9, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i219 >> 3) & 14) | 805306368 | ((i219 >> 12) & 896), 392);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z22;
                    function3 = function4;
                    modifier2 = modifier3;
                    z17 = z19;
                    z18 = z20;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function3 = function2M10133getLambda$273160606$views_release;
                    z17 = z13;
                    z18 = z14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z14 = z11;
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i20 != 0) {
                    function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z20 = false;
                } else {
                    z20 = z14;
                }
                if (i17 != 0) {
                    z21 = true;
                } else {
                    z21 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                }
                if (z20) {
                    composerStartRestartGroup.startReplaceGroup(923764285);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default6 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                    MaterialTheme materialTheme11 = MaterialTheme.INSTANCE;
                    int i2111 = MaterialTheme.$stable;
                    function4 = function2M10133getLambda$273160606$views_release;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default6, text, materialTheme11.getTypography(composerStartRestartGroup, i2111).getBodyMedium(), materialTheme11.getColorScheme(composerStartRestartGroup, i2111).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z22 = z21;
                } else {
                    final Function2 function10 = function2M10133getLambda$273160606$views_release;
                    modifier4 = modifier3;
                    composerStartRestartGroup.startReplaceGroup(924022980);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    ButtonDefaults buttonDefaults6 = ButtonDefaults.INSTANCE;
                    float f15 = 1;
                    float fM8823constructorimpl11 = Dp.m8823constructorimpl(f15);
                    int i2112 = ButtonDefaults.$stable;
                    int i2113 = i12;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs6 = buttonDefaults6.m2903buttonElevationR_JCAzs(fM8823constructorimpl11, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i2112 << 15) | 6, 30);
                    float fM8823constructorimpl12 = Dp.m8823constructorimpl(f15);
                    MaterialTheme materialTheme12 = MaterialTheme.INSTANCE;
                    int i2114 = MaterialTheme.$stable;
                    modifier3 = modifier4;
                    function4 = function10;
                    z22 = z21;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults6.m2902buttonColorsro_MJ88(materialTheme12.getColorScheme(composerStartRestartGroup, i2114).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i2112 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs6, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl12, materialTheme12.getColorScheme(composerStartRestartGroup, i2114).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function10, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2113 >> 3) & 14) | 805306368 | ((i2113 >> 12) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z22;
                function3 = function4;
                modifier2 = modifier3;
                z17 = z19;
                z18 = z20;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function3 = function2M10133getLambda$273160606$views_release;
                z17 = z13;
                z18 = z14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z13 = z10;
        i15 = i11 & 32;
        if (i15 != 0) {
            if ((196608 & i10) == 0) {
                z14 = z11;
                if (composerStartRestartGroup.changed(z14)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
            i17 = i11 & 64;
            if (i17 != 0) {
                i12 |= 1572864;
                z15 = z12;
            } else {
                z15 = z12;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z15)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i12 |= i18;
                }
            }
            if ((i12 & 599187) != 599186) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
                if (i19 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i20 != 0) {
                    function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
                }
                if (i13 != 0) {
                    z19 = false;
                } else {
                    z19 = z13;
                }
                if (i15 != 0) {
                    z20 = false;
                } else {
                    z20 = z14;
                }
                if (i17 != 0) {
                    z21 = true;
                } else {
                    z21 = z15;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
                }
                if (z20) {
                    composerStartRestartGroup.startReplaceGroup(923764285);
                    if ((i12 & 112) == 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z23) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default7 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                    MaterialTheme materialTheme13 = MaterialTheme.INSTANCE;
                    int i2115 = MaterialTheme.$stable;
                    function4 = function2M10133getLambda$273160606$views_release;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default7, text, materialTheme13.getTypography(composerStartRestartGroup, i2115).getBodyMedium(), materialTheme13.getColorScheme(composerStartRestartGroup, i2115).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                    composerStartRestartGroup.endReplaceGroup();
                    z22 = z21;
                } else {
                    final Function2 function11 = function2M10133getLambda$273160606$views_release;
                    modifier4 = modifier3;
                    composerStartRestartGroup.startReplaceGroup(924022980);
                    if (z19) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    ButtonDefaults buttonDefaults7 = ButtonDefaults.INSTANCE;
                    float f16 = 1;
                    float fM8823constructorimpl13 = Dp.m8823constructorimpl(f16);
                    int i2116 = ButtonDefaults.$stable;
                    int i2117 = i12;
                    ButtonElevation buttonElevationM2903buttonElevationR_JCAzs7 = buttonDefaults7.m2903buttonElevationR_JCAzs(fM8823constructorimpl13, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i2116 << 15) | 6, 30);
                    float fM8823constructorimpl14 = Dp.m8823constructorimpl(f16);
                    MaterialTheme materialTheme14 = MaterialTheme.INSTANCE;
                    int i2118 = MaterialTheme.$stable;
                    modifier3 = modifier4;
                    function4 = function11;
                    z22 = z21;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults7.m2902buttonColorsro_MJ88(materialTheme14.getColorScheme(composerStartRestartGroup, i2118).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i2116 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs7, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl14, materialTheme14.getColorScheme(composerStartRestartGroup, i2118).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function11, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2117 >> 3) & 14) | 805306368 | ((i2117 >> 12) & 896), 392);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z22;
                function3 = function4;
                modifier2 = modifier3;
                z17 = z19;
                z18 = z20;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function3 = function2M10133getLambda$273160606$views_release;
                z17 = z13;
                z18 = z14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z14 = z11;
        i17 = i11 & 64;
        if (i17 != 0) {
            i12 |= 1572864;
            z15 = z12;
        } else {
            z15 = z12;
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z15)) {
                    i18 = 1048576;
                } else {
                    i18 = 524288;
                }
                i12 |= i18;
            }
        }
        if ((i12 & 599187) != 599186) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z16, i12 & 1)) {
            if (i19 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (i20 != 0) {
                function2M10133getLambda$273160606$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.m10133getLambda$273160606$views_release();
            }
            if (i13 != 0) {
                z19 = false;
            } else {
                z19 = z13;
            }
            if (i15 != 0) {
                z20 = false;
            } else {
                z20 = z14;
            }
            if (i17 != 0) {
                z21 = true;
            } else {
                z21 = z15;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(939874972, i12, -1, "cu.z17.views.button.Z17SecondaryDialogButton (Z17Buttons.kt:205)");
            }
            if (z20) {
                composerStartRestartGroup.startReplaceGroup(923764285);
                if ((i12 & 112) == 32) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z23) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.button.a0
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$15$lambda$14(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default8 = ClickableKt.m1238clickableXHw0xAI$default(modifier3, false, null, null, (lb.a) objRememberedValue, 7, null);
                MaterialTheme materialTheme15 = MaterialTheme.INSTANCE;
                int i2119 = MaterialTheme.$stable;
                function4 = function2M10133getLambda$273160606$views_release;
                Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1238clickableXHw0xAI$default8, text, materialTheme15.getTypography(composerStartRestartGroup, i2119).getBodyMedium(), materialTheme15.getColorScheme(composerStartRestartGroup, i2119).getOnBackground(), 0, 0, composerStartRestartGroup, (i12 >> 3) & 112, 48);
                composerStartRestartGroup.endReplaceGroup();
                z22 = z21;
            } else {
                final Function2 function12 = function2M10133getLambda$273160606$views_release;
                modifier4 = modifier3;
                composerStartRestartGroup.startReplaceGroup(924022980);
                if (z19) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                ButtonDefaults buttonDefaults8 = ButtonDefaults.INSTANCE;
                float f17 = 1;
                float fM8823constructorimpl15 = Dp.m8823constructorimpl(f17);
                int i21110 = ButtonDefaults.$stable;
                int i21111 = i12;
                ButtonElevation buttonElevationM2903buttonElevationR_JCAzs8 = buttonDefaults8.m2903buttonElevationR_JCAzs(fM8823constructorimpl15, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i21110 << 15) | 6, 30);
                float fM8823constructorimpl16 = Dp.m8823constructorimpl(f17);
                MaterialTheme materialTheme16 = MaterialTheme.INSTANCE;
                int i21112 = MaterialTheme.$stable;
                modifier3 = modifier4;
                function4 = function12;
                z22 = z21;
                Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, z22, null, buttonDefaults8.m2902buttonColorsro_MJ88(materialTheme16.getColorScheme(composerStartRestartGroup, i21112).getBackground(), 0L, 0L, 0L, composerStartRestartGroup, i21110 << 12, 14), buttonElevationM2903buttonElevationR_JCAzs8, BorderStrokeKt.m1231BorderStrokecXLIe8U(fM8823constructorimpl16, materialTheme16.getColorScheme(composerStartRestartGroup, i21112).getOnSurface()), null, null, ComposableLambdaKt.rememberComposableLambda(-291755383, true, new Function3() { // from class: cu.z17.views.button.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$16(function12, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i21111 >> 3) & 14) | 805306368 | ((i21111 >> 12) & 896), 392);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z15 = z22;
            function3 = function4;
            modifier2 = modifier3;
            z17 = z19;
            z18 = z20;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function3 = function2M10133getLambda$273160606$views_release;
            z17 = z13;
            z18 = z14;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17SecondaryDialogButton$lambda$17(modifier2, onClick, text, function3, z17, z18, z15, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17SecondaryDialogButton$lambda$15$lambda$14(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17SecondaryDialogButton$lambda$16(Function2 function2, String str, RowScope Z17BaseDialogButton, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17BaseDialogButton, "$this$Z17BaseDialogButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291755383, i10, -1, "cu.z17.views.button.Z17SecondaryDialogButton.<anonymous> (Z17Buttons.kt:223)");
            }
            function2.invoke(composer, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i11 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, materialTheme.getTypography(composer, i11).getBodySmall(), materialTheme.getColorScheme(composer, i11).getOnBackground(), 0, 0, composer, 0, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17SecondaryDialogButton$lambda$17(Modifier modifier, lb.a aVar, String str, Function2 function2, boolean z10, boolean z11, boolean z12, int i10, int i11, Composer composer, int i12) {
        Z17SecondaryDialogButton(modifier, aVar, str, function2, z10, z11, z12, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:74:0x0108  */
    /* JADX WARN: Code duplicated, block: B:77:0x0114  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17SnackbarButton(Modifier modifier, final lb.a onClick, final String text, Function2 function2, boolean z10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Function2 function3;
        int i13;
        boolean z11;
        int i14;
        boolean z12;
        final Modifier modifier3;
        final Function2 function4;
        final boolean z13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Function2 lambda$2061174379$views_release;
        boolean z14;
        Modifier modifierFillMaxWidth$default;
        kotlin.jvm.internal.y.i(onClick, "onClick");
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(945376113);
        int i15 = i11 & 1;
        if (i15 != 0) {
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
            i12 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        int i16 = i11 & 8;
        if (i16 == 0) {
            if ((i10 & 3072) == 0) {
                function3 = function2;
                i12 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    z11 = z10;
                    if (composerStartRestartGroup.changed(z11)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((i12 & 9363) != 9362) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        lambda$2061174379$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$2061174379$views_release();
                    } else {
                        lambda$2061174379$views_release = function3;
                    }
                    if (i13 != 0) {
                        z14 = false;
                    } else {
                        z14 = z11;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(945376113, i12, -1, "cu.z17.views.button.Z17SnackbarButton (Z17Buttons.kt:240)");
                    }
                    if (z14) {
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                    } else {
                        modifierFillMaxWidth$default = modifier4;
                    }
                    int i17 = ((i12 >> 3) & 14) | 805306368;
                    Modifier modifier5 = modifier4;
                    Function2 function5 = lambda$2061174379$views_release;
                    Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-342935680, true, new Function3() { // from class: cu.z17.views.button.t
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ButtonsKt.Z17SnackbarButton$lambda$18(lambda$2061174379$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i17, TypedValues.PositionType.TYPE_CURVE_FIT);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    z13 = z14;
                    function4 = function5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    z13 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.u
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ButtonsKt.Z17SnackbarButton$lambda$19(modifier3, onClick, text, function4, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            z11 = z10;
            if ((i12 & 9363) != 9362) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    lambda$2061174379$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$2061174379$views_release();
                } else {
                    lambda$2061174379$views_release = function3;
                }
                if (i13 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(945376113, i12, -1, "cu.z17.views.button.Z17SnackbarButton (Z17Buttons.kt:240)");
                }
                if (z14) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                int i18 = ((i12 >> 3) & 14) | 805306368;
                Modifier modifier6 = modifier4;
                Function2 function6 = lambda$2061174379$views_release;
                Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-342935680, true, new Function3() { // from class: cu.z17.views.button.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SnackbarButton$lambda$18(lambda$2061174379$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i18, TypedValues.PositionType.TYPE_CURVE_FIT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                z13 = z14;
                function4 = function6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SnackbarButton$lambda$19(modifier3, onClick, text, function4, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function3 = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                z11 = z10;
                if (composerStartRestartGroup.changed(z11)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((i12 & 9363) != 9362) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    lambda$2061174379$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$2061174379$views_release();
                } else {
                    lambda$2061174379$views_release = function3;
                }
                if (i13 != 0) {
                    z14 = false;
                } else {
                    z14 = z11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(945376113, i12, -1, "cu.z17.views.button.Z17SnackbarButton (Z17Buttons.kt:240)");
                }
                if (z14) {
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                } else {
                    modifierFillMaxWidth$default = modifier4;
                }
                int i19 = ((i12 >> 3) & 14) | 805306368;
                Modifier modifier7 = modifier4;
                Function2 function7 = lambda$2061174379$views_release;
                Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-342935680, true, new Function3() { // from class: cu.z17.views.button.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ButtonsKt.Z17SnackbarButton$lambda$18(lambda$2061174379$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i19, TypedValues.PositionType.TYPE_CURVE_FIT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                z13 = z14;
                function4 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                z13 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ButtonsKt.Z17SnackbarButton$lambda$19(modifier3, onClick, text, function4, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        z11 = z10;
        if ((i12 & 9363) != 9362) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i12 & 1)) {
            if (i15 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i16 != 0) {
                lambda$2061174379$views_release = ComposableSingletons$Z17ButtonsKt.INSTANCE.getLambda$2061174379$views_release();
            } else {
                lambda$2061174379$views_release = function3;
            }
            if (i13 != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945376113, i12, -1, "cu.z17.views.button.Z17SnackbarButton (Z17Buttons.kt:240)");
            }
            if (z14) {
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
            } else {
                modifierFillMaxWidth$default = modifier4;
            }
            int i110 = ((i12 >> 3) & 14) | 805306368;
            Modifier modifier8 = modifier4;
            Function2 function8 = lambda$2061174379$views_release;
            Z17BaseDialogButton(onClick, modifierFillMaxWidth$default, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-342935680, true, new Function3() { // from class: cu.z17.views.button.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ButtonsKt.Z17SnackbarButton$lambda$18(lambda$2061174379$views_release, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i110, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier8;
            z13 = z14;
            function4 = function8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function4 = function3;
            z13 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17SnackbarButton$lambda$19(modifier3, onClick, text, function4, z13, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17SnackbarButton$lambda$18(Function2 function2, String str, RowScope Z17BaseDialogButton, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Z17BaseDialogButton, "$this$Z17BaseDialogButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-342935680, i10, -1, "cu.z17.views.button.Z17SnackbarButton.<anonymous> (Z17Buttons.kt:244)");
            }
            function2.invoke(composer, 0);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, str, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17SnackbarButton$lambda$19(Modifier modifier, lb.a aVar, String str, Function2 function2, boolean z10, int i10, int i11, Composer composer, int i12) {
        Z17SnackbarButton(modifier, aVar, str, function2, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @Composable
    public static final void Z17TitleDescBtn(final Object image, final String title, final String content, final lb.a onClick, Composer composer, final int i10) {
        int i11;
        kotlin.jvm.internal.y.i(image, "image");
        kotlin.jvm.internal.y.i(title, "title");
        kotlin.jvm.internal.y.i(content, "content");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-880658864);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(image) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(title) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 1171) != 1170, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880658864, i11, -1, "cu.z17.views.button.Z17TitleDescBtn (Z17Buttons.kt:323)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z10 = (i11 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.button.k
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17ButtonsKt.Z17TitleDescBtn$lambda$45$lambda$44(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(ClickableKt.m1238clickableXHw0xAI$default(companion, false, null, null, (lb.a) objRememberedValue, 7, null), 0.0f, 1, null), Dp.m8823constructorimpl(20), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            lb.a constructor2 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl2.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5176constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5176constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), Dp.m8823constructorimpl(24));
            ColorFilter.Companion companion4 = ColorFilter.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i12 = MaterialTheme.$stable;
            int i13 = i11;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, image, null, ColorFilter.Companion.m5907tintxETnrds$default(companion4, materialTheme.getColorScheme(composerStartRestartGroup, i12).getOnBackground(), 0, 2, null), null, null, 0, null, null, composerStartRestartGroup, ((i11 << 3) & 112) | 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(16));
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            lb.a constructor3 = companion3.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM5176constructorimpl3.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5176constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5176constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, title, materialTheme.getTypography(composerStartRestartGroup, i12).getBodyLarge(), 0L, 0, 0, composerStartRestartGroup, i13 & 112, 57);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, content, null, materialTheme.getColorScheme(composerStartRestartGroup, i12).getTertiary(), 0, 0, composerStartRestartGroup, (i13 >> 3) & 112, 53);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.button.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ButtonsKt.Z17TitleDescBtn$lambda$49(image, title, content, onClick, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TitleDescBtn$lambda$45$lambda$44(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TitleDescBtn$lambda$49(Object obj, String str, String str2, lb.a aVar, int i10, Composer composer, int i11) {
        Z17TitleDescBtn(obj, str, str2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    public static final Modifier bounceClick(Modifier modifier) {
        kotlin.jvm.internal.y.i(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: cu.z17.views.button.n
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Z17ButtonsKt.bounceClick$lambda$31((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier bounceClick$lambda$31(Modifier composed, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(composed, "$this$composed");
        composer.startReplaceGroup(1874235633);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1874235633, i10, -1, "cu.z17.views.button.bounceClick.<anonymous> (Z17Buttons.kt:257)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ButtonState.Idle, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ButtonState buttonStateBounceClick$lambda$31$lambda$21 = bounceClick$lambda$31$lambda$21(mutableState);
        ButtonState buttonState = ButtonState.Pressed;
        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(buttonStateBounceClick$lambda$31$lambda$21 == buttonState ? 0.9f : 1.0f, null, 0.0f, "anb", null, composer, 3072, 22);
        final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(bounceClick$lambda$31$lambda$21(mutableState) == buttonState ? 0.8f : 1.0f, null, 0.0f, "anb1", null, composer, 3072, 22);
        boolean zChanged = composer.changed(stateAnimateFloatAsState) | composer.changed(stateAnimateFloatAsState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.z17.views.button.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ButtonsKt.bounceClick$lambda$31$lambda$26$lambda$25(stateAnimateFloatAsState, stateAnimateFloatAsState2, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(composed, (Function1) objRememberedValue2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue3);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue3;
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.button.p
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierM1236clickableO2vRcR0$default = ClickableKt.m1236clickableO2vRcR0$default(modifierGraphicsLayer, mutableInteractionSource, null, false, null, null, (lb.a) objRememberedValue4, 28, null);
        ButtonState buttonStateBounceClick$lambda$31$lambda$22 = bounceClick$lambda$31$lambda$21(mutableState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new PointerInputEventHandler() { // from class: cu.z17.views.button.Z17ButtonsKt$bounceClick$1$4$1

                /* JADX INFO: renamed from: cu.z17.views.button.Z17ButtonsKt$bounceClick$1$4$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @cb.f(c = "cu.z17.views.button.Z17ButtonsKt$bounceClick$1$4$1$1", f = "Z17Buttons.kt", l = {280, 283}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lua/k0;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass1 extends cb.k implements Function2 {
                    final /* synthetic */ MutableState<ButtonState> $buttonState$delegate;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(MutableState<ButtonState> mutableState, ab.e<? super AnonymousClass1> eVar) {
                        super(2, eVar);
                        this.$buttonState$delegate = mutableState;
                    }

                    @Override // cb.a
                    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$buttonState$delegate, eVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, ab.e<? super k0> eVar) {
                        return ((AnonymousClass1) create(awaitPointerEventScope, eVar)).invokeSuspend(k0.f43947a);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        MutableState<ButtonState> mutableState;
                        ButtonState buttonState;
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        Object objG = bb.b.g();
                        int i10 = this.label;
                        if (i10 == 0) {
                            ua.v.b(obj);
                            MutableState<ButtonState> mutableState2 = this.$buttonState$delegate;
                            if (Z17ButtonsKt.bounceClick$lambda$31$lambda$21(mutableState2) == ButtonState.Pressed) {
                                this.L$0 = cb.l.a(awaitPointerEventScope);
                                this.L$1 = mutableState2;
                                this.label = 1;
                                if (TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null) != objG) {
                                    mutableState = mutableState2;
                                    buttonState = ButtonState.Idle;
                                }
                            } else {
                                this.L$0 = cb.l.a(awaitPointerEventScope);
                                this.L$1 = mutableState2;
                                this.label = 2;
                                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null) != objG) {
                                    mutableState = mutableState2;
                                    buttonState = ButtonState.Pressed;
                                }
                            }
                            return objG;
                        }
                        if (i10 == 1) {
                            mutableState = (MutableState) this.L$1;
                            ua.v.b(obj);
                            buttonState = ButtonState.Idle;
                        } else {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutableState = (MutableState) this.L$1;
                            ua.v.b(obj);
                            buttonState = ButtonState.Pressed;
                        }
                        mutableState.setValue(buttonState);
                        return k0.f43947a;
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
                    Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(mutableState, null), eVar);
                    return objAwaitPointerEventScope == bb.b.g() ? objAwaitPointerEventScope : k0.f43947a;
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM1236clickableO2vRcR0$default, buttonStateBounceClick$lambda$31$lambda$22, (PointerInputEventHandler) objRememberedValue5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ButtonState bounceClick$lambda$31$lambda$21(MutableState<ButtonState> mutableState) {
        return mutableState.getValue();
    }

    private static final float bounceClick$lambda$31$lambda$23(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float bounceClick$lambda$31$lambda$24(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 bounceClick$lambda$31$lambda$26$lambda$25(State state, State state2, GraphicsLayerScope graphicsLayer) {
        kotlin.jvm.internal.y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(bounceClick$lambda$31$lambda$23(state));
        graphicsLayer.setScaleY(bounceClick$lambda$31$lambda$23(state));
        graphicsLayer.setAlpha(bounceClick$lambda$31$lambda$24(state2));
        return k0.f43947a;
    }

    public static final Modifier invertedBounceClick(Modifier modifier) {
        kotlin.jvm.internal.y.i(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: cu.z17.views.button.m
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Z17ButtonsKt.invertedBounceClick$lambda$43((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier invertedBounceClick$lambda$43(Modifier composed, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(composed, "$this$composed");
        composer.startReplaceGroup(-686462202);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-686462202, i10, -1, "cu.z17.views.button.invertedBounceClick.<anonymous> (Z17Buttons.kt:290)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ButtonState.Idle, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ButtonState buttonStateInvertedBounceClick$lambda$43$lambda$33 = invertedBounceClick$lambda$43$lambda$33(mutableState);
        ButtonState buttonState = ButtonState.Pressed;
        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(buttonStateInvertedBounceClick$lambda$43$lambda$33 == buttonState ? 1.4f : 1.0f, null, 0.0f, "anb", null, composer, 3072, 22);
        final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(invertedBounceClick$lambda$43$lambda$33(mutableState) == buttonState ? 1.2f : 1.0f, null, 0.0f, "anb1", null, composer, 3072, 22);
        boolean zChanged = composer.changed(stateAnimateFloatAsState) | composer.changed(stateAnimateFloatAsState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.z17.views.button.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Z17ButtonsKt.invertedBounceClick$lambda$43$lambda$38$lambda$37(stateAnimateFloatAsState, stateAnimateFloatAsState2, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(composed, (Function1) objRememberedValue2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue3);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue3;
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.button.s
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierM1236clickableO2vRcR0$default = ClickableKt.m1236clickableO2vRcR0$default(modifierGraphicsLayer, mutableInteractionSource, null, false, null, null, (lb.a) objRememberedValue4, 28, null);
        ButtonState buttonStateInvertedBounceClick$lambda$43$lambda$34 = invertedBounceClick$lambda$43$lambda$33(mutableState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new PointerInputEventHandler() { // from class: cu.z17.views.button.Z17ButtonsKt$invertedBounceClick$1$4$1

                /* JADX INFO: renamed from: cu.z17.views.button.Z17ButtonsKt$invertedBounceClick$1$4$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                @cb.f(c = "cu.z17.views.button.Z17ButtonsKt$invertedBounceClick$1$4$1$1", f = "Z17Buttons.kt", l = {313, TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lua/k0;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {2, 2, 0})
                public static final class AnonymousClass1 extends cb.k implements Function2 {
                    final /* synthetic */ MutableState<ButtonState> $buttonState$delegate;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(MutableState<ButtonState> mutableState, ab.e<? super AnonymousClass1> eVar) {
                        super(2, eVar);
                        this.$buttonState$delegate = mutableState;
                    }

                    @Override // cb.a
                    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$buttonState$delegate, eVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, ab.e<? super k0> eVar) {
                        return ((AnonymousClass1) create(awaitPointerEventScope, eVar)).invokeSuspend(k0.f43947a);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        MutableState<ButtonState> mutableState;
                        ButtonState buttonState;
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        Object objG = bb.b.g();
                        int i10 = this.label;
                        if (i10 == 0) {
                            ua.v.b(obj);
                            MutableState<ButtonState> mutableState2 = this.$buttonState$delegate;
                            if (Z17ButtonsKt.invertedBounceClick$lambda$43$lambda$33(mutableState2) == ButtonState.Pressed) {
                                this.L$0 = cb.l.a(awaitPointerEventScope);
                                this.L$1 = mutableState2;
                                this.label = 1;
                                if (TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null) != objG) {
                                    mutableState = mutableState2;
                                    buttonState = ButtonState.Idle;
                                }
                            } else {
                                this.L$0 = cb.l.a(awaitPointerEventScope);
                                this.L$1 = mutableState2;
                                this.label = 2;
                                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null) != objG) {
                                    mutableState = mutableState2;
                                    buttonState = ButtonState.Pressed;
                                }
                            }
                            return objG;
                        }
                        if (i10 == 1) {
                            mutableState = (MutableState) this.L$1;
                            ua.v.b(obj);
                            buttonState = ButtonState.Idle;
                        } else {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutableState = (MutableState) this.L$1;
                            ua.v.b(obj);
                            buttonState = ButtonState.Pressed;
                        }
                        mutableState.setValue(buttonState);
                        return k0.f43947a;
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
                    Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(mutableState, null), eVar);
                    return objAwaitPointerEventScope == bb.b.g() ? objAwaitPointerEventScope : k0.f43947a;
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM1236clickableO2vRcR0$default, buttonStateInvertedBounceClick$lambda$43$lambda$34, (PointerInputEventHandler) objRememberedValue5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ButtonState invertedBounceClick$lambda$43$lambda$33(MutableState<ButtonState> mutableState) {
        return mutableState.getValue();
    }

    private static final float invertedBounceClick$lambda$43$lambda$35(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invertedBounceClick$lambda$43$lambda$36(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invertedBounceClick$lambda$43$lambda$38$lambda$37(State state, State state2, GraphicsLayerScope graphicsLayer) {
        kotlin.jvm.internal.y.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(invertedBounceClick$lambda$43$lambda$35(state));
        graphicsLayer.setScaleY(invertedBounceClick$lambda$43$lambda$35(state));
        graphicsLayer.setAlpha(invertedBounceClick$lambda$43$lambda$36(state2));
        return k0.f43947a;
    }
}
