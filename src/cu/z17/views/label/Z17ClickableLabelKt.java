package cu.z17.views.label;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a}\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0083\u0001\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00152\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u001a2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0003¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/TextStyle;", "style", "", "text", "Lkotlin/Function2;", "Lcu/z17/views/label/Z17ClickableLabelClickType;", "Lua/k0;", "onClick", "Lkotlin/Function0;", "onLongClick", "", "maxLines", "maxLength", "Landroidx/compose/ui/graphics/Color;", "linkColor", "mentionColor", "Z17ClickableLabel-0nD-MI0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Llb/a;IIJJLandroidx/compose/runtime/Composer;II)V", "Z17ClickableLabel", "Landroidx/compose/ui/text/AnnotatedString;", "", "softWrap", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onTextLayout", "LongClickableText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;II)V", "LongClickableText", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17ClickableLabelKt {
    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:101:0x012b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0131  */
    /* JADX WARN: Code duplicated, block: B:105:0x0134  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x0145  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0154  */
    /* JADX WARN: Code duplicated, block: B:114:0x0159  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x0180  */
    /* JADX WARN: Code duplicated, block: B:124:0x018b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0193  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:154:0x0230  */
    /* JADX WARN: Code duplicated, block: B:156:0x023e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0253  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0060  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    /* JADX WARN: Code duplicated, block: B:40:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x007b  */
    /* JADX WARN: Code duplicated, block: B:49:0x007f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:93:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LongClickableText-VhcvRP8, reason: not valid java name */
    private static final void m10256LongClickableTextVhcvRP8(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z10, int i10, int i11, Function1 function1, final Function1 function2, lb.a aVar, Composer composer, final int i12, final int i13) {
        int i14;
        Modifier modifier2;
        int i15;
        TextStyle textStyle2;
        int i16;
        int i17;
        boolean z11;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z12;
        Composer composer2;
        final int i28;
        final lb.a aVar2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final boolean z13;
        final int i29;
        final Function1 function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i30;
        TextStyle textStyle4;
        boolean z14;
        int i31;
        int iM8749getClipgIe3tQ8;
        int i32;
        final Function1 function4;
        lb.a aVar3;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        boolean z15;
        boolean z16;
        boolean z17;
        Object objRememberedValue2;
        boolean z18;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        int i33;
        Composer composerStartRestartGroup = composer.startRestartGroup(1049302695);
        if ((i12 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        int i34 = i13 & 2;
        if (i34 == 0) {
            if ((i12 & 48) == 0) {
                modifier2 = modifier;
                i14 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i15 = i13 & 4;
            if (i15 != 0) {
                if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i16 = 256;
                    } else {
                        i16 = 128;
                    }
                    i14 |= i16;
                }
                i17 = i13 & 8;
                if (i17 != 0) {
                    if ((i12 & 3072) == 0) {
                        z11 = z10;
                        if (composerStartRestartGroup.changed(z11)) {
                            i18 = 2048;
                        } else {
                            i18 = 1024;
                        }
                        i14 |= i18;
                    }
                    i19 = i13 & 16;
                    if (i19 != 0) {
                        if ((i12 & 24576) == 0) {
                            i20 = i10;
                            if (composerStartRestartGroup.changed(i20)) {
                                i21 = 16384;
                            } else {
                                i21 = 8192;
                            }
                            i14 |= i21;
                        }
                        i22 = i13 & 32;
                        if (i22 != 0) {
                            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i11)) {
                                i23 = 131072;
                            } else {
                                i23 = 65536;
                            }
                            i14 |= i23;
                        }
                        i24 = i13 & 64;
                        if (i24 != 0) {
                            i14 |= 1572864;
                        } else if ((i12 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i25 = 1048576;
                            } else {
                                i25 = 524288;
                            }
                            i14 |= i25;
                        }
                        if ((i12 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i33 = 8388608;
                            } else {
                                i33 = 4194304;
                            }
                            i14 |= i33;
                        }
                        i26 = i13 & 256;
                        if (i26 != 0) {
                            i14 |= 100663296;
                        } else if ((i12 & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(aVar)) {
                                i27 = 67108864;
                            } else {
                                i27 = 33554432;
                            }
                            i14 |= i27;
                        }
                        if ((i14 & 38347923) != 38347922) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i15 != 0) {
                                textStyle4 = TextStyle.INSTANCE.getDefault();
                                i30 = i19;
                            } else {
                                i30 = i19;
                                textStyle4 = textStyle2;
                            }
                            if (i17 != 0) {
                                z14 = true;
                            } else {
                                z14 = z11;
                            }
                            if (i30 != 0) {
                                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                                i31 = i22;
                            } else {
                                i31 = i22;
                                iM8749getClipgIe3tQ8 = i20;
                            }
                            if (i31 != 0) {
                                i32 = Integer.MAX_VALUE;
                            } else {
                                i32 = i11;
                            }
                            if (i24 != 0) {
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function4 = (Function1) objRememberedValue5;
                            } else {
                                function4 = function1;
                            }
                            if (i26 != 0) {
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                aVar3 = (lb.a) objRememberedValue4;
                            } else {
                                aVar3 = aVar;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            if ((234881024 & i14) == 67108864) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            if ((29360128 & i14) == 8388608) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            z17 = z15 | z16;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z17 || objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function2, (PointerInputEventHandler) objRememberedValue2));
                            z18 = (i14 & 3670016) == 1048576;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (z18 || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composer2 = composerStartRestartGroup;
                            BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function3 = function4;
                            aVar2 = aVar3;
                            modifier3 = modifier2;
                            textStyle3 = textStyle4;
                            i29 = iM8749getClipgIe3tQ8;
                            z13 = z14;
                            i28 = i32;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i28 = i11;
                            aVar2 = aVar;
                            modifier3 = modifier2;
                            textStyle3 = textStyle2;
                            z13 = z11;
                            i29 = i20;
                            function3 = function1;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i14 |= 24576;
                    i20 = i10;
                    i22 = i13 & 32;
                    if (i22 != 0) {
                        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                        i14 |= i23;
                    }
                    i24 = i13 & 64;
                    if (i24 != 0) {
                        i14 |= 1572864;
                    } else if ((i12 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i25 = 1048576;
                        } else {
                            i25 = 524288;
                        }
                        i14 |= i25;
                    }
                    if ((i12 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i33 = 8388608;
                        } else {
                            i33 = 4194304;
                        }
                        i14 |= i33;
                    }
                    i26 = i13 & 256;
                    if (i26 != 0) {
                        i14 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i27 = 67108864;
                        } else {
                            i27 = 33554432;
                        }
                        i14 |= i27;
                    }
                    if ((i14 & 38347923) != 38347922) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i15 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                            i30 = i19;
                        } else {
                            i30 = i19;
                            textStyle4 = textStyle2;
                        }
                        if (i17 != 0) {
                            z14 = true;
                        } else {
                            z14 = z11;
                        }
                        if (i30 != 0) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                            i31 = i22;
                        } else {
                            i31 = i22;
                            iM8749getClipgIe3tQ8 = i20;
                        }
                        if (i31 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i11;
                        }
                        if (i24 != 0) {
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function4 = (Function1) objRememberedValue5;
                        } else {
                            function4 = function1;
                        }
                        if (i26 != 0) {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            aVar3 = (lb.a) objRememberedValue4;
                        } else {
                            aVar3 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        if ((234881024 & i14) == 67108864) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if ((29360128 & i14) == 8388608) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 = z15 | z16;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z17) {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion3, function2, (PointerInputEventHandler) objRememberedValue2));
                        if ((i14 & 3670016) == 1048576) {
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen2, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        aVar2 = aVar3;
                        modifier3 = modifier2;
                        textStyle3 = textStyle4;
                        i29 = iM8749getClipgIe3tQ8;
                        z13 = z14;
                        i28 = i32;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i28 = i11;
                        aVar2 = aVar;
                        modifier3 = modifier2;
                        textStyle3 = textStyle2;
                        z13 = z11;
                        i29 = i20;
                        function3 = function1;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 3072;
                z11 = z10;
                i19 = i13 & 16;
                if (i19 != 0) {
                    if ((i12 & 24576) == 0) {
                        i20 = i10;
                        if (composerStartRestartGroup.changed(i20)) {
                            i21 = 16384;
                        } else {
                            i21 = 8192;
                        }
                        i14 |= i21;
                    }
                    i22 = i13 & 32;
                    if (i22 != 0) {
                        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                        i14 |= i23;
                    }
                    i24 = i13 & 64;
                    if (i24 != 0) {
                        i14 |= 1572864;
                    } else if ((i12 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i25 = 1048576;
                        } else {
                            i25 = 524288;
                        }
                        i14 |= i25;
                    }
                    if ((i12 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i33 = 8388608;
                        } else {
                            i33 = 4194304;
                        }
                        i14 |= i33;
                    }
                    i26 = i13 & 256;
                    if (i26 != 0) {
                        i14 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i27 = 67108864;
                        } else {
                            i27 = 33554432;
                        }
                        i14 |= i27;
                    }
                    if ((i14 & 38347923) != 38347922) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i15 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                            i30 = i19;
                        } else {
                            i30 = i19;
                            textStyle4 = textStyle2;
                        }
                        if (i17 != 0) {
                            z14 = true;
                        } else {
                            z14 = z11;
                        }
                        if (i30 != 0) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                            i31 = i22;
                        } else {
                            i31 = i22;
                            iM8749getClipgIe3tQ8 = i20;
                        }
                        if (i31 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i11;
                        }
                        if (i24 != 0) {
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function4 = (Function1) objRememberedValue5;
                        } else {
                            function4 = function1;
                        }
                        if (i26 != 0) {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            aVar3 = (lb.a) objRememberedValue4;
                        } else {
                            aVar3 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        if ((234881024 & i14) == 67108864) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if ((29360128 & i14) == 8388608) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 = z15 | z16;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z17) {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierThen3 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion4, function2, (PointerInputEventHandler) objRememberedValue2));
                        if ((i14 & 3670016) == 1048576) {
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen3, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        aVar2 = aVar3;
                        modifier3 = modifier2;
                        textStyle3 = textStyle4;
                        i29 = iM8749getClipgIe3tQ8;
                        z13 = z14;
                        i28 = i32;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i28 = i11;
                        aVar2 = aVar;
                        modifier3 = modifier2;
                        textStyle3 = textStyle2;
                        z13 = z11;
                        i29 = i20;
                        function3 = function1;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 24576;
                i20 = i10;
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen4 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion5, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen4, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            textStyle2 = textStyle;
            i17 = i13 & 8;
            if (i17 != 0) {
                if ((i12 & 3072) == 0) {
                    z11 = z10;
                    if (composerStartRestartGroup.changed(z11)) {
                        i18 = 2048;
                    } else {
                        i18 = 1024;
                    }
                    i14 |= i18;
                }
                i19 = i13 & 16;
                if (i19 != 0) {
                    if ((i12 & 24576) == 0) {
                        i20 = i10;
                        if (composerStartRestartGroup.changed(i20)) {
                            i21 = 16384;
                        } else {
                            i21 = 8192;
                        }
                        i14 |= i21;
                    }
                    i22 = i13 & 32;
                    if (i22 != 0) {
                        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                        i14 |= i23;
                    }
                    i24 = i13 & 64;
                    if (i24 != 0) {
                        i14 |= 1572864;
                    } else if ((i12 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i25 = 1048576;
                        } else {
                            i25 = 524288;
                        }
                        i14 |= i25;
                    }
                    if ((i12 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i33 = 8388608;
                        } else {
                            i33 = 4194304;
                        }
                        i14 |= i33;
                    }
                    i26 = i13 & 256;
                    if (i26 != 0) {
                        i14 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i27 = 67108864;
                        } else {
                            i27 = 33554432;
                        }
                        i14 |= i27;
                    }
                    if ((i14 & 38347923) != 38347922) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i15 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                            i30 = i19;
                        } else {
                            i30 = i19;
                            textStyle4 = textStyle2;
                        }
                        if (i17 != 0) {
                            z14 = true;
                        } else {
                            z14 = z11;
                        }
                        if (i30 != 0) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                            i31 = i22;
                        } else {
                            i31 = i22;
                            iM8749getClipgIe3tQ8 = i20;
                        }
                        if (i31 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i11;
                        }
                        if (i24 != 0) {
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function4 = (Function1) objRememberedValue5;
                        } else {
                            function4 = function1;
                        }
                        if (i26 != 0) {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            aVar3 = (lb.a) objRememberedValue4;
                        } else {
                            aVar3 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        if ((234881024 & i14) == 67108864) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if ((29360128 & i14) == 8388608) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 = z15 | z16;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z17) {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierThen5 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion6, function2, (PointerInputEventHandler) objRememberedValue2));
                        if ((i14 & 3670016) == 1048576) {
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen5, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        aVar2 = aVar3;
                        modifier3 = modifier2;
                        textStyle3 = textStyle4;
                        i29 = iM8749getClipgIe3tQ8;
                        z13 = z14;
                        i28 = i32;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i28 = i11;
                        aVar2 = aVar;
                        modifier3 = modifier2;
                        textStyle3 = textStyle2;
                        z13 = z11;
                        i29 = i20;
                        function3 = function1;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 24576;
                i20 = i10;
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen6 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion7, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen6, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 3072;
            z11 = z10;
            i19 = i13 & 16;
            if (i19 != 0) {
                if ((i12 & 24576) == 0) {
                    i20 = i10;
                    if (composerStartRestartGroup.changed(i20)) {
                        i21 = 16384;
                    } else {
                        i21 = 8192;
                    }
                    i14 |= i21;
                }
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen7 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion8, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen7, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 24576;
            i20 = i10;
            i22 = i13 & 32;
            if (i22 != 0) {
                i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i14 |= i23;
            }
            i24 = i13 & 64;
            if (i24 != 0) {
                i14 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i25 = 1048576;
                } else {
                    i25 = 524288;
                }
                i14 |= i25;
            }
            if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i33 = 8388608;
                } else {
                    i33 = 4194304;
                }
                i14 |= i33;
            }
            i26 = i13 & 256;
            if (i26 != 0) {
                i14 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i27 = 67108864;
                } else {
                    i27 = 33554432;
                }
                i14 |= i27;
            }
            if ((i14 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i15 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                    i30 = i19;
                } else {
                    i30 = i19;
                    textStyle4 = textStyle2;
                }
                if (i17 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (i30 != 0) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    i31 = i22;
                } else {
                    i31 = i22;
                    iM8749getClipgIe3tQ8 = i20;
                }
                if (i31 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i11;
                }
                if (i24 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function4 = (Function1) objRememberedValue5;
                } else {
                    function4 = function1;
                }
                if (i26 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar3 = (lb.a) objRememberedValue4;
                } else {
                    aVar3 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion9 = Modifier.INSTANCE;
                if ((234881024 & i14) == 67108864) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((29360128 & i14) == 8388608) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z17) {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierThen8 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion9, function2, (PointerInputEventHandler) objRememberedValue2));
                if ((i14 & 3670016) == 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composer2 = composerStartRestartGroup;
                BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen8, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                aVar2 = aVar3;
                modifier3 = modifier2;
                textStyle3 = textStyle4;
                i29 = iM8749getClipgIe3tQ8;
                z13 = z14;
                i28 = i32;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i28 = i11;
                aVar2 = aVar;
                modifier3 = modifier2;
                textStyle3 = textStyle2;
                z13 = z11;
                i29 = i20;
                function3 = function1;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 48;
        modifier2 = modifier;
        i15 = i13 & 4;
        if (i15 != 0) {
            if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                    i16 = 256;
                } else {
                    i16 = 128;
                }
                i14 |= i16;
            }
            i17 = i13 & 8;
            if (i17 != 0) {
                if ((i12 & 3072) == 0) {
                    z11 = z10;
                    if (composerStartRestartGroup.changed(z11)) {
                        i18 = 2048;
                    } else {
                        i18 = 1024;
                    }
                    i14 |= i18;
                }
                i19 = i13 & 16;
                if (i19 != 0) {
                    if ((i12 & 24576) == 0) {
                        i20 = i10;
                        if (composerStartRestartGroup.changed(i20)) {
                            i21 = 16384;
                        } else {
                            i21 = 8192;
                        }
                        i14 |= i21;
                    }
                    i22 = i13 & 32;
                    if (i22 != 0) {
                        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                        i14 |= i23;
                    }
                    i24 = i13 & 64;
                    if (i24 != 0) {
                        i14 |= 1572864;
                    } else if ((i12 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i25 = 1048576;
                        } else {
                            i25 = 524288;
                        }
                        i14 |= i25;
                    }
                    if ((i12 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i33 = 8388608;
                        } else {
                            i33 = 4194304;
                        }
                        i14 |= i33;
                    }
                    i26 = i13 & 256;
                    if (i26 != 0) {
                        i14 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(aVar)) {
                            i27 = 67108864;
                        } else {
                            i27 = 33554432;
                        }
                        i14 |= i27;
                    }
                    if ((i14 & 38347923) != 38347922) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i15 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                            i30 = i19;
                        } else {
                            i30 = i19;
                            textStyle4 = textStyle2;
                        }
                        if (i17 != 0) {
                            z14 = true;
                        } else {
                            z14 = z11;
                        }
                        if (i30 != 0) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                            i31 = i22;
                        } else {
                            i31 = i22;
                            iM8749getClipgIe3tQ8 = i20;
                        }
                        if (i31 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i11;
                        }
                        if (i24 != 0) {
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function4 = (Function1) objRememberedValue5;
                        } else {
                            function4 = function1;
                        }
                        if (i26 != 0) {
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            aVar3 = (lb.a) objRememberedValue4;
                        } else {
                            aVar3 = aVar;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        Modifier.Companion companion10 = Modifier.INSTANCE;
                        if ((234881024 & i14) == 67108864) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if ((29360128 & i14) == 8388608) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 = z15 | z16;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z17) {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierThen9 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion10, function2, (PointerInputEventHandler) objRememberedValue2));
                        if ((i14 & 3670016) == 1048576) {
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen9, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        aVar2 = aVar3;
                        modifier3 = modifier2;
                        textStyle3 = textStyle4;
                        i29 = iM8749getClipgIe3tQ8;
                        z13 = z14;
                        i28 = i32;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i28 = i11;
                        aVar2 = aVar;
                        modifier3 = modifier2;
                        textStyle3 = textStyle2;
                        z13 = z11;
                        i29 = i20;
                        function3 = function1;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 24576;
                i20 = i10;
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen10 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen10, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 3072;
            z11 = z10;
            i19 = i13 & 16;
            if (i19 != 0) {
                if ((i12 & 24576) == 0) {
                    i20 = i10;
                    if (composerStartRestartGroup.changed(i20)) {
                        i21 = 16384;
                    } else {
                        i21 = 8192;
                    }
                    i14 |= i21;
                }
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion12 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen11 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion12, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen11, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 24576;
            i20 = i10;
            i22 = i13 & 32;
            if (i22 != 0) {
                i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i14 |= i23;
            }
            i24 = i13 & 64;
            if (i24 != 0) {
                i14 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i25 = 1048576;
                } else {
                    i25 = 524288;
                }
                i14 |= i25;
            }
            if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i33 = 8388608;
                } else {
                    i33 = 4194304;
                }
                i14 |= i33;
            }
            i26 = i13 & 256;
            if (i26 != 0) {
                i14 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i27 = 67108864;
                } else {
                    i27 = 33554432;
                }
                i14 |= i27;
            }
            if ((i14 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i15 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                    i30 = i19;
                } else {
                    i30 = i19;
                    textStyle4 = textStyle2;
                }
                if (i17 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (i30 != 0) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    i31 = i22;
                } else {
                    i31 = i22;
                    iM8749getClipgIe3tQ8 = i20;
                }
                if (i31 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i11;
                }
                if (i24 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function4 = (Function1) objRememberedValue5;
                } else {
                    function4 = function1;
                }
                if (i26 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar3 = (lb.a) objRememberedValue4;
                } else {
                    aVar3 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion13 = Modifier.INSTANCE;
                if ((234881024 & i14) == 67108864) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((29360128 & i14) == 8388608) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z17) {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierThen12 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion13, function2, (PointerInputEventHandler) objRememberedValue2));
                if ((i14 & 3670016) == 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composer2 = composerStartRestartGroup;
                BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen12, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                aVar2 = aVar3;
                modifier3 = modifier2;
                textStyle3 = textStyle4;
                i29 = iM8749getClipgIe3tQ8;
                z13 = z14;
                i28 = i32;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i28 = i11;
                aVar2 = aVar;
                modifier3 = modifier2;
                textStyle3 = textStyle2;
                z13 = z11;
                i29 = i20;
                function3 = function1;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        textStyle2 = textStyle;
        i17 = i13 & 8;
        if (i17 != 0) {
            if ((i12 & 3072) == 0) {
                z11 = z10;
                if (composerStartRestartGroup.changed(z11)) {
                    i18 = 2048;
                } else {
                    i18 = 1024;
                }
                i14 |= i18;
            }
            i19 = i13 & 16;
            if (i19 != 0) {
                if ((i12 & 24576) == 0) {
                    i20 = i10;
                    if (composerStartRestartGroup.changed(i20)) {
                        i21 = 16384;
                    } else {
                        i21 = 8192;
                    }
                    i14 |= i21;
                }
                i22 = i13 & 32;
                if (i22 != 0) {
                    i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i14 |= i23;
                }
                i24 = i13 & 64;
                if (i24 != 0) {
                    i14 |= 1572864;
                } else if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i25 = 1048576;
                    } else {
                        i25 = 524288;
                    }
                    i14 |= i25;
                }
                if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i33 = 8388608;
                    } else {
                        i33 = 4194304;
                    }
                    i14 |= i33;
                }
                i26 = i13 & 256;
                if (i26 != 0) {
                    i14 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(aVar)) {
                        i27 = 67108864;
                    } else {
                        i27 = 33554432;
                    }
                    i14 |= i27;
                }
                if ((i14 & 38347923) != 38347922) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i15 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                        i30 = i19;
                    } else {
                        i30 = i19;
                        textStyle4 = textStyle2;
                    }
                    if (i17 != 0) {
                        z14 = true;
                    } else {
                        z14 = z11;
                    }
                    if (i30 != 0) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        i31 = i22;
                    } else {
                        i31 = i22;
                        iM8749getClipgIe3tQ8 = i20;
                    }
                    if (i31 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i11;
                    }
                    if (i24 != 0) {
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function4 = (Function1) objRememberedValue5;
                    } else {
                        function4 = function1;
                    }
                    if (i26 != 0) {
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        aVar3 = (lb.a) objRememberedValue4;
                    } else {
                        aVar3 = aVar;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    Modifier.Companion companion14 = Modifier.INSTANCE;
                    if ((234881024 & i14) == 67108864) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((29360128 & i14) == 8388608) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z15 | z16;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z17) {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierThen13 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion14, function2, (PointerInputEventHandler) objRememberedValue2));
                    if ((i14 & 3670016) == 1048576) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen13, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    aVar2 = aVar3;
                    modifier3 = modifier2;
                    textStyle3 = textStyle4;
                    i29 = iM8749getClipgIe3tQ8;
                    z13 = z14;
                    i28 = i32;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i28 = i11;
                    aVar2 = aVar;
                    modifier3 = modifier2;
                    textStyle3 = textStyle2;
                    z13 = z11;
                    i29 = i20;
                    function3 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 24576;
            i20 = i10;
            i22 = i13 & 32;
            if (i22 != 0) {
                i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i14 |= i23;
            }
            i24 = i13 & 64;
            if (i24 != 0) {
                i14 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i25 = 1048576;
                } else {
                    i25 = 524288;
                }
                i14 |= i25;
            }
            if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i33 = 8388608;
                } else {
                    i33 = 4194304;
                }
                i14 |= i33;
            }
            i26 = i13 & 256;
            if (i26 != 0) {
                i14 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i27 = 67108864;
                } else {
                    i27 = 33554432;
                }
                i14 |= i27;
            }
            if ((i14 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i15 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                    i30 = i19;
                } else {
                    i30 = i19;
                    textStyle4 = textStyle2;
                }
                if (i17 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (i30 != 0) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    i31 = i22;
                } else {
                    i31 = i22;
                    iM8749getClipgIe3tQ8 = i20;
                }
                if (i31 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i11;
                }
                if (i24 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function4 = (Function1) objRememberedValue5;
                } else {
                    function4 = function1;
                }
                if (i26 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar3 = (lb.a) objRememberedValue4;
                } else {
                    aVar3 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion15 = Modifier.INSTANCE;
                if ((234881024 & i14) == 67108864) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((29360128 & i14) == 8388608) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z17) {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierThen14 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion15, function2, (PointerInputEventHandler) objRememberedValue2));
                if ((i14 & 3670016) == 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composer2 = composerStartRestartGroup;
                BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen14, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                aVar2 = aVar3;
                modifier3 = modifier2;
                textStyle3 = textStyle4;
                i29 = iM8749getClipgIe3tQ8;
                z13 = z14;
                i28 = i32;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i28 = i11;
                aVar2 = aVar;
                modifier3 = modifier2;
                textStyle3 = textStyle2;
                z13 = z11;
                i29 = i20;
                function3 = function1;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 3072;
        z11 = z10;
        i19 = i13 & 16;
        if (i19 != 0) {
            if ((i12 & 24576) == 0) {
                i20 = i10;
                if (composerStartRestartGroup.changed(i20)) {
                    i21 = 16384;
                } else {
                    i21 = 8192;
                }
                i14 |= i21;
            }
            i22 = i13 & 32;
            if (i22 != 0) {
                i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i14 |= i23;
            }
            i24 = i13 & 64;
            if (i24 != 0) {
                i14 |= 1572864;
            } else if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i25 = 1048576;
                } else {
                    i25 = 524288;
                }
                i14 |= i25;
            }
            if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i33 = 8388608;
                } else {
                    i33 = 4194304;
                }
                i14 |= i33;
            }
            i26 = i13 & 256;
            if (i26 != 0) {
                i14 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(aVar)) {
                    i27 = 67108864;
                } else {
                    i27 = 33554432;
                }
                i14 |= i27;
            }
            if ((i14 & 38347923) != 38347922) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i15 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                    i30 = i19;
                } else {
                    i30 = i19;
                    textStyle4 = textStyle2;
                }
                if (i17 != 0) {
                    z14 = true;
                } else {
                    z14 = z11;
                }
                if (i30 != 0) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    i31 = i22;
                } else {
                    i31 = i22;
                    iM8749getClipgIe3tQ8 = i20;
                }
                if (i31 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i11;
                }
                if (i24 != 0) {
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function4 = (Function1) objRememberedValue5;
                } else {
                    function4 = function1;
                }
                if (i26 != 0) {
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    aVar3 = (lb.a) objRememberedValue4;
                } else {
                    aVar3 = aVar;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                Modifier.Companion companion16 = Modifier.INSTANCE;
                if ((234881024 & i14) == 67108864) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((29360128 & i14) == 8388608) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z15 | z16;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z17) {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierThen15 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion16, function2, (PointerInputEventHandler) objRememberedValue2));
                if ((i14 & 3670016) == 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composer2 = composerStartRestartGroup;
                BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen15, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                aVar2 = aVar3;
                modifier3 = modifier2;
                textStyle3 = textStyle4;
                i29 = iM8749getClipgIe3tQ8;
                z13 = z14;
                i28 = i32;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i28 = i11;
                aVar2 = aVar;
                modifier3 = modifier2;
                textStyle3 = textStyle2;
                z13 = z11;
                i29 = i20;
                function3 = function1;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 24576;
        i20 = i10;
        i22 = i13 & 32;
        if (i22 != 0) {
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i11)) {
                i23 = 131072;
            } else {
                i23 = 65536;
            }
            i14 |= i23;
        }
        i24 = i13 & 64;
        if (i24 != 0) {
            i14 |= 1572864;
        } else if ((i12 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i25 = 1048576;
            } else {
                i25 = 524288;
            }
            i14 |= i25;
        }
        if ((i12 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i33 = 8388608;
            } else {
                i33 = 4194304;
            }
            i14 |= i33;
        }
        i26 = i13 & 256;
        if (i26 != 0) {
            i14 |= 100663296;
        } else if ((i12 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(aVar)) {
                i27 = 67108864;
            } else {
                i27 = 33554432;
            }
            i14 |= i27;
        }
        if ((i14 & 38347923) != 38347922) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i14 & 1)) {
            if (i34 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i15 != 0) {
                textStyle4 = TextStyle.INSTANCE.getDefault();
                i30 = i19;
            } else {
                i30 = i19;
                textStyle4 = textStyle2;
            }
            if (i17 != 0) {
                z14 = true;
            } else {
                z14 = z11;
            }
            if (i30 != 0) {
                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                i31 = i22;
            } else {
                i31 = i22;
                iM8749getClipgIe3tQ8 = i20;
            }
            if (i31 != 0) {
                i32 = Integer.MAX_VALUE;
            } else {
                i32 = i11;
            }
            if (i24 != 0) {
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: cu.z17.views.label.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$8$lambda$7((TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                function4 = (Function1) objRememberedValue5;
            } else {
                function4 = function1;
            }
            if (i26 != 0) {
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new lb.a() { // from class: cu.z17.views.label.c
                        @Override // lb.a
                        public final Object invoke() {
                            return ua.k0.f43947a;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                aVar3 = (lb.a) objRememberedValue4;
            } else {
                aVar3 = aVar;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1049302695, i14, -1, "cu.z17.views.label.LongClickableText (Z17ClickableLabel.kt:80)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion17 = Modifier.INSTANCE;
            if ((234881024 & i14) == 67108864) {
                z15 = true;
            } else {
                z15 = false;
            }
            if ((29360128 & i14) == 8388608) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 = z15 | z16;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z17) {
                objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(aVar3, mutableState, function2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierThen16 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion17, function2, (PointerInputEventHandler) objRememberedValue2));
            if ((i14 & 3670016) == 1048576) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z18) {
                objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: cu.z17.views.label.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$14$lambda$13(mutableState, function4, (TextLayoutResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composer2 = composerStartRestartGroup;
            BasicTextKt.m2035BasicTextCL7eQgs(annotatedString, modifierThen16, textStyle4, (Function1) objRememberedValue3, iM8749getClipgIe3tQ8, z14, i32, 0, null, null, null, composer2, (58254 & i14) | (458752 & (i14 << 6)) | ((i14 << 3) & 3670016), 0, 1920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            aVar2 = aVar3;
            modifier3 = modifier2;
            textStyle3 = textStyle4;
            i29 = iM8749getClipgIe3tQ8;
            z13 = z14;
            i28 = i32;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            i28 = i11;
            aVar2 = aVar;
            modifier3 = modifier2;
            textStyle3 = textStyle2;
            z13 = z11;
            i29 = i20;
            function3 = function1;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ClickableLabelKt.LongClickableText_VhcvRP8$lambda$15(annotatedString, modifier3, textStyle3, z13, i29, i28, function3, function2, aVar2, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LongClickableText_VhcvRP8$lambda$14$lambda$13(MutableState mutableState, Function1 function1, TextLayoutResult it) {
        kotlin.jvm.internal.y.i(it, "it");
        mutableState.setValue(it);
        function1.invoke(it);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LongClickableText_VhcvRP8$lambda$15(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z10, int i10, int i11, Function1 function1, Function1 function2, lb.a aVar, int i12, int i13, Composer composer, int i14) {
        m10256LongClickableTextVhcvRP8(annotatedString, modifier, textStyle, z10, i10, i11, function1, function2, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 LongClickableText_VhcvRP8$lambda$8$lambda$7(TextLayoutResult it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x014c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x014e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    /* JADX WARN: Code duplicated, block: B:113:0x0166  */
    /* JADX WARN: Code duplicated, block: B:115:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x0175  */
    /* JADX WARN: Code duplicated, block: B:119:0x0180  */
    /* JADX WARN: Code duplicated, block: B:121:0x0183  */
    /* JADX WARN: Code duplicated, block: B:123:0x0186  */
    /* JADX WARN: Code duplicated, block: B:125:0x0189  */
    /* JADX WARN: Code duplicated, block: B:126:0x0193  */
    /* JADX WARN: Code duplicated, block: B:128:0x0197  */
    /* JADX WARN: Code duplicated, block: B:129:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:141:0x021b  */
    /* JADX WARN: Code duplicated, block: B:142:0x021e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0225  */
    /* JADX WARN: Code duplicated, block: B:146:0x022e  */
    /* JADX WARN: Code duplicated, block: B:149:0x023f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0241  */
    /* JADX WARN: Code duplicated, block: B:153:0x0249  */
    /* JADX WARN: Code duplicated, block: B:155:0x0251  */
    /* JADX WARN: Code duplicated, block: B:158:0x0280  */
    /* JADX WARN: Code duplicated, block: B:160:0x028e  */
    /* JADX WARN: Code duplicated, block: B:163:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:89:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0124  */
    /* JADX WARN: Code duplicated, block: B:99:0x012c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17ClickableLabel-0nD-MI0, reason: not valid java name */
    public static final void m10257Z17ClickableLabel0nDMI0(Modifier modifier, TextStyle textStyle, final String text, final Function2 onClick, lb.a aVar, int i10, int i11, long j10, long j11, Composer composer, final int i12, final int i13) {
        int i14;
        TextStyle textStyle2;
        lb.a aVar2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z10;
        Composer composer2;
        final Modifier modifier2;
        final TextStyle textStyle3;
        final int i26;
        final lb.a aVar3;
        final int i27;
        final long j12;
        final long j13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        TextStyle bodyMedium;
        lb.a aVar4;
        long jColor;
        long j14;
        int i28;
        int i29;
        long jColor2;
        int i30;
        Object objRememberedValue;
        String str;
        final AnnotatedString annotatedStringM10255messageFormatterJy8F4Js;
        int i31;
        int iM8749getClipgIe3tQ8;
        boolean z11;
        boolean z12;
        Object objRememberedValue2;
        kotlin.jvm.internal.y.i(text, "text");
        kotlin.jvm.internal.y.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2017983148);
        int i32 = i13 & 1;
        if (i32 != 0) {
            i14 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            if ((i13 & 2) == 0) {
                textStyle2 = textStyle;
                int i33 = composerStartRestartGroup.changed(textStyle2) ? 32 : 16;
                i14 |= i33;
            } else {
                textStyle2 = textStyle;
            }
            i14 |= i33;
        } else {
            textStyle2 = textStyle;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        int i34 = i13 & 16;
        if (i34 == 0) {
            if ((i12 & 24576) == 0) {
                aVar2 = aVar;
                i14 |= composerStartRestartGroup.changedInstance(aVar2) ? 16384 : 8192;
            }
            i15 = i13 & 32;
            if (i15 != 0) {
                if ((196608 & i12) == 0) {
                    i16 = i10;
                    if (composerStartRestartGroup.changed(i16)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i14 |= i17;
                }
                i18 = i13 & 64;
                if (i18 != 0) {
                    i14 |= 1572864;
                    i19 = i11;
                } else {
                    i19 = i11;
                    if ((i12 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i19)) {
                            i20 = 1048576;
                        } else {
                            i20 = 524288;
                        }
                        i14 |= i20;
                    }
                }
                i21 = i13 & 128;
                if (i21 != 0) {
                    if ((i12 & 12582912) == 0) {
                        int i35 = i14;
                        if (composerStartRestartGroup.changed(j10)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i23 = i35 | i22;
                    }
                    i24 = i13 & 256;
                    if (i24 != 0) {
                        i23 |= 100663296;
                    } else if ((i12 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(j11)) {
                            i25 = 67108864;
                        } else {
                            i25 = 33554432;
                        }
                        i23 |= i25;
                    }
                    if ((i23 & 38347923) != 38347922) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i12 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i32 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier;
                            }
                            if ((i13 & 2) != 0) {
                                bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                                i23 &= -113;
                            } else {
                                bodyMedium = textStyle2;
                            }
                            if (i34 != 0) {
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return ua.k0.f43947a;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar4 = (lb.a) objRememberedValue;
                            } else {
                                aVar4 = aVar2;
                            }
                            if (i15 != 0) {
                                i16 = -1;
                            }
                            if (i18 != 0) {
                                i19 = -1;
                            }
                            if (i21 != 0) {
                                jColor = ColorKt.Color(4278225100L);
                            } else {
                                jColor = j10;
                            }
                            if (i24 != 0) {
                                j14 = jColor;
                                i28 = i16;
                                i29 = i23;
                                jColor2 = ColorKt.Color(4289867551L);
                                i30 = 2017983148;
                            } else {
                                j14 = jColor;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                            }
                            if (i19 != -1 || text.length() < i19) {
                                str = text;
                            } else {
                                String strSubstring = text.substring(0, i19 - 1);
                                kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
                                str = strSubstring + "...";
                            }
                            annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                            long j15 = j14;
                            long j16 = jColor2;
                            if (i28 != -1) {
                                i31 = i28;
                            } else {
                                i31 = Integer.MAX_VALUE;
                            }
                            if (i28 != -1) {
                                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                            } else {
                                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                            }
                            int i36 = iM8749getClipgIe3tQ8;
                            boolean zChanged = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                            if ((i29 & 7168) == 2048) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            z12 = zChanged | z11;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            Modifier modifier4 = modifier3;
                            TextStyle textStyle4 = bodyMedium;
                            m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier4, textStyle4, false, i36, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            aVar3 = aVar4;
                            i27 = i28;
                            i26 = i19;
                            modifier2 = modifier4;
                            textStyle3 = textStyle4;
                            j12 = j15;
                            j13 = j16;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i13 & 2) != 0) {
                                i23 &= -113;
                            }
                            modifier3 = modifier;
                            j14 = j10;
                            bodyMedium = textStyle2;
                            aVar4 = aVar2;
                        }
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                        }
                        if (i19 != -1) {
                            str = text;
                        } else {
                            str = text;
                        }
                        annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                        long j17 = j14;
                        long j18 = jColor2;
                        if (i28 != -1) {
                            i31 = i28;
                        } else {
                            i31 = Integer.MAX_VALUE;
                        }
                        if (i28 != -1) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                        } else {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        }
                        int i37 = iM8749getClipgIe3tQ8;
                        boolean zChanged2 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                        if ((i29 & 7168) == 2048) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        z12 = zChanged2 | z11;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z12) {
                            objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifier5 = modifier3;
                        TextStyle textStyle5 = bodyMedium;
                        m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier5, textStyle5, false, i37, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        aVar3 = aVar4;
                        i27 = i28;
                        i26 = i19;
                        modifier2 = modifier5;
                        textStyle3 = textStyle5;
                        j12 = j17;
                        j13 = j18;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        textStyle3 = textStyle2;
                        i26 = i19;
                        aVar3 = aVar2;
                        i27 = i16;
                        j12 = j10;
                        j13 = j11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 12582912;
                i23 = i14;
                i24 = i13 & 256;
                if (i24 != 0) {
                    i23 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(j11)) {
                        i25 = 67108864;
                    } else {
                        i25 = 33554432;
                    }
                    i23 |= i25;
                }
                if ((i23 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    } else {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                    }
                    if (i19 != -1) {
                        str = text;
                    } else {
                        str = text;
                    }
                    annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                    long j19 = j14;
                    long j110 = jColor2;
                    if (i28 != -1) {
                        i31 = i28;
                    } else {
                        i31 = Integer.MAX_VALUE;
                    }
                    if (i28 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    int i38 = iM8749getClipgIe3tQ8;
                    boolean zChanged3 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                    if ((i29 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = zChanged3 | z11;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifier6 = modifier3;
                    TextStyle textStyle6 = bodyMedium;
                    m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier6, textStyle6, false, i38, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar4;
                    i27 = i28;
                    i26 = i19;
                    modifier2 = modifier6;
                    textStyle3 = textStyle6;
                    j12 = j19;
                    j13 = j110;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    textStyle3 = textStyle2;
                    i26 = i19;
                    aVar3 = aVar2;
                    i27 = i16;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i16 = i10;
            i18 = i13 & 64;
            if (i18 != 0) {
                i14 |= 1572864;
                i19 = i11;
            } else {
                i19 = i11;
                if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i19)) {
                        i20 = 1048576;
                    } else {
                        i20 = 524288;
                    }
                    i14 |= i20;
                }
            }
            i21 = i13 & 128;
            if (i21 != 0) {
                if ((i12 & 12582912) == 0) {
                    int i39 = i14;
                    if (composerStartRestartGroup.changed(j10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i23 = i39 | i22;
                }
                i24 = i13 & 256;
                if (i24 != 0) {
                    i23 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(j11)) {
                        i25 = 67108864;
                    } else {
                        i25 = 33554432;
                    }
                    i23 |= i25;
                }
                if ((i23 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    } else {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                    }
                    if (i19 != -1) {
                        str = text;
                    } else {
                        str = text;
                    }
                    annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                    long j111 = j14;
                    long j112 = jColor2;
                    if (i28 != -1) {
                        i31 = i28;
                    } else {
                        i31 = Integer.MAX_VALUE;
                    }
                    if (i28 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    int i310 = iM8749getClipgIe3tQ8;
                    boolean zChanged4 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                    if ((i29 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = zChanged4 | z11;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifier7 = modifier3;
                    TextStyle textStyle7 = bodyMedium;
                    m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier7, textStyle7, false, i310, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar4;
                    i27 = i28;
                    i26 = i19;
                    modifier2 = modifier7;
                    textStyle3 = textStyle7;
                    j12 = j111;
                    j13 = j112;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    textStyle3 = textStyle2;
                    i26 = i19;
                    aVar3 = aVar2;
                    i27 = i16;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 12582912;
            i23 = i14;
            i24 = i13 & 256;
            if (i24 != 0) {
                i23 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(j11)) {
                    i25 = 67108864;
                } else {
                    i25 = 33554432;
                }
                i23 |= i25;
            }
            if ((i23 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                } else {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                }
                if (i19 != -1) {
                    str = text;
                } else {
                    str = text;
                }
                annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                long j113 = j14;
                long j114 = jColor2;
                if (i28 != -1) {
                    i31 = i28;
                } else {
                    i31 = Integer.MAX_VALUE;
                }
                if (i28 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                int i311 = iM8749getClipgIe3tQ8;
                boolean zChanged5 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                if ((i29 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChanged5 | z11;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifier8 = modifier3;
                TextStyle textStyle8 = bodyMedium;
                m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier8, textStyle8, false, i311, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar4;
                i27 = i28;
                i26 = i19;
                modifier2 = modifier8;
                textStyle3 = textStyle8;
                j12 = j113;
                j13 = j114;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                textStyle3 = textStyle2;
                i26 = i19;
                aVar3 = aVar2;
                i27 = i16;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 24576;
        aVar2 = aVar;
        i15 = i13 & 32;
        if (i15 != 0) {
            if ((196608 & i12) == 0) {
                i16 = i10;
                if (composerStartRestartGroup.changed(i16)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i14 |= i17;
            }
            i18 = i13 & 64;
            if (i18 != 0) {
                i14 |= 1572864;
                i19 = i11;
            } else {
                i19 = i11;
                if ((i12 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i19)) {
                        i20 = 1048576;
                    } else {
                        i20 = 524288;
                    }
                    i14 |= i20;
                }
            }
            i21 = i13 & 128;
            if (i21 != 0) {
                if ((i12 & 12582912) == 0) {
                    int i312 = i14;
                    if (composerStartRestartGroup.changed(j10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i23 = i312 | i22;
                }
                i24 = i13 & 256;
                if (i24 != 0) {
                    i23 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(j11)) {
                        i25 = 67108864;
                    } else {
                        i25 = 33554432;
                    }
                    i23 |= i25;
                }
                if ((i23 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    } else {
                        if (i32 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if ((i13 & 2) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i23 &= -113;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if (i34 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return ua.k0.f43947a;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar4 = (lb.a) objRememberedValue;
                        } else {
                            aVar4 = aVar2;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        if (i18 != 0) {
                            i19 = -1;
                        }
                        if (i21 != 0) {
                            jColor = ColorKt.Color(4278225100L);
                        } else {
                            jColor = j10;
                        }
                        if (i24 != 0) {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            jColor2 = ColorKt.Color(4289867551L);
                            i30 = 2017983148;
                        } else {
                            j14 = jColor;
                            i28 = i16;
                            i29 = i23;
                            i30 = 2017983148;
                            jColor2 = j11;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                    }
                    if (i19 != -1) {
                        str = text;
                    } else {
                        str = text;
                    }
                    annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                    long j115 = j14;
                    long j116 = jColor2;
                    if (i28 != -1) {
                        i31 = i28;
                    } else {
                        i31 = Integer.MAX_VALUE;
                    }
                    if (i28 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    int i313 = iM8749getClipgIe3tQ8;
                    boolean zChanged6 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                    if ((i29 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = zChanged6 | z11;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifier9 = modifier3;
                    TextStyle textStyle9 = bodyMedium;
                    m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier9, textStyle9, false, i313, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    aVar3 = aVar4;
                    i27 = i28;
                    i26 = i19;
                    modifier2 = modifier9;
                    textStyle3 = textStyle9;
                    j12 = j115;
                    j13 = j116;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    textStyle3 = textStyle2;
                    i26 = i19;
                    aVar3 = aVar2;
                    i27 = i16;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 12582912;
            i23 = i14;
            i24 = i13 & 256;
            if (i24 != 0) {
                i23 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(j11)) {
                    i25 = 67108864;
                } else {
                    i25 = 33554432;
                }
                i23 |= i25;
            }
            if ((i23 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                } else {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                }
                if (i19 != -1) {
                    str = text;
                } else {
                    str = text;
                }
                annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                long j117 = j14;
                long j118 = jColor2;
                if (i28 != -1) {
                    i31 = i28;
                } else {
                    i31 = Integer.MAX_VALUE;
                }
                if (i28 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                int i314 = iM8749getClipgIe3tQ8;
                boolean zChanged7 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                if ((i29 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChanged7 | z11;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifier10 = modifier3;
                TextStyle textStyle10 = bodyMedium;
                m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier10, textStyle10, false, i314, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar4;
                i27 = i28;
                i26 = i19;
                modifier2 = modifier10;
                textStyle3 = textStyle10;
                j12 = j117;
                j13 = j118;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                textStyle3 = textStyle2;
                i26 = i19;
                aVar3 = aVar2;
                i27 = i16;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i16 = i10;
        i18 = i13 & 64;
        if (i18 != 0) {
            i14 |= 1572864;
            i19 = i11;
        } else {
            i19 = i11;
            if ((i12 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i19)) {
                    i20 = 1048576;
                } else {
                    i20 = 524288;
                }
                i14 |= i20;
            }
        }
        i21 = i13 & 128;
        if (i21 != 0) {
            if ((i12 & 12582912) == 0) {
                int i315 = i14;
                if (composerStartRestartGroup.changed(j10)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i23 = i315 | i22;
            }
            i24 = i13 & 256;
            if (i24 != 0) {
                i23 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(j11)) {
                    i25 = 67108864;
                } else {
                    i25 = 33554432;
                }
                i23 |= i25;
            }
            if ((i23 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                } else {
                    if (i32 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if ((i13 & 2) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i23 &= -113;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if (i34 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                                @Override // lb.a
                                public final Object invoke() {
                                    return ua.k0.f43947a;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar4 = (lb.a) objRememberedValue;
                    } else {
                        aVar4 = aVar2;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    if (i18 != 0) {
                        i19 = -1;
                    }
                    if (i21 != 0) {
                        jColor = ColorKt.Color(4278225100L);
                    } else {
                        jColor = j10;
                    }
                    if (i24 != 0) {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        jColor2 = ColorKt.Color(4289867551L);
                        i30 = 2017983148;
                    } else {
                        j14 = jColor;
                        i28 = i16;
                        i29 = i23;
                        i30 = 2017983148;
                        jColor2 = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
                }
                if (i19 != -1) {
                    str = text;
                } else {
                    str = text;
                }
                annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
                long j119 = j14;
                long j1110 = jColor2;
                if (i28 != -1) {
                    i31 = i28;
                } else {
                    i31 = Integer.MAX_VALUE;
                }
                if (i28 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                int i316 = iM8749getClipgIe3tQ8;
                boolean zChanged8 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
                if ((i29 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = zChanged8 | z11;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifier11 = modifier3;
                TextStyle textStyle11 = bodyMedium;
                m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier11, textStyle11, false, i316, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aVar3 = aVar4;
                i27 = i28;
                i26 = i19;
                modifier2 = modifier11;
                textStyle3 = textStyle11;
                j12 = j119;
                j13 = j1110;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                textStyle3 = textStyle2;
                i26 = i19;
                aVar3 = aVar2;
                i27 = i16;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 12582912;
        i23 = i14;
        i24 = i13 & 256;
        if (i24 != 0) {
            i23 |= 100663296;
        } else if ((i12 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(j11)) {
                i25 = 67108864;
            } else {
                i25 = 33554432;
            }
            i23 |= i25;
        }
        if ((i23 & 38347923) != 38347922) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i23 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i12 & 1) != 0) {
                if (i32 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if ((i13 & 2) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i23 &= -113;
                } else {
                    bodyMedium = textStyle2;
                }
                if (i34 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (lb.a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (i15 != 0) {
                    i16 = -1;
                }
                if (i18 != 0) {
                    i19 = -1;
                }
                if (i21 != 0) {
                    jColor = ColorKt.Color(4278225100L);
                } else {
                    jColor = j10;
                }
                if (i24 != 0) {
                    j14 = jColor;
                    i28 = i16;
                    i29 = i23;
                    jColor2 = ColorKt.Color(4289867551L);
                    i30 = 2017983148;
                } else {
                    j14 = jColor;
                    i28 = i16;
                    i29 = i23;
                    i30 = 2017983148;
                    jColor2 = j11;
                }
            } else {
                if (i32 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if ((i13 & 2) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i23 &= -113;
                } else {
                    bodyMedium = textStyle2;
                }
                if (i34 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new lb.a() { // from class: cu.z17.views.label.f
                            @Override // lb.a
                            public final Object invoke() {
                                return ua.k0.f43947a;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar4 = (lb.a) objRememberedValue;
                } else {
                    aVar4 = aVar2;
                }
                if (i15 != 0) {
                    i16 = -1;
                }
                if (i18 != 0) {
                    i19 = -1;
                }
                if (i21 != 0) {
                    jColor = ColorKt.Color(4278225100L);
                } else {
                    jColor = j10;
                }
                if (i24 != 0) {
                    j14 = jColor;
                    i28 = i16;
                    i29 = i23;
                    jColor2 = ColorKt.Color(4289867551L);
                    i30 = 2017983148;
                } else {
                    j14 = jColor;
                    i28 = i16;
                    i29 = i23;
                    i30 = 2017983148;
                    jColor2 = j11;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i30, i29, -1, "cu.z17.views.label.Z17ClickableLabel (Z17ClickableLabel.kt:28)");
            }
            if (i19 != -1) {
                str = text;
            } else {
                str = text;
            }
            annotatedStringM10255messageFormatterJy8F4Js = MessageFormatterKt.m10255messageFormatterJy8F4Js(str, j14, jColor2, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), TextUnit.m9013getValueimpl(bodyMedium.m8289getFontSizeXSAIIZE()), composerStartRestartGroup, (i29 >> 18) & 1008, 0);
            long j1111 = j14;
            long j1112 = jColor2;
            if (i28 != -1) {
                i31 = i28;
            } else {
                i31 = Integer.MAX_VALUE;
            }
            if (i28 != -1) {
                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
            } else {
                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
            }
            int i317 = iM8749getClipgIe3tQ8;
            boolean zChanged9 = composerStartRestartGroup.changed(annotatedStringM10255messageFormatterJy8F4Js);
            if ((i29 & 7168) == 2048) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = zChanged9 | z11;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12) {
                objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: cu.z17.views.label.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(annotatedStringM10255messageFormatterJy8F4Js, onClick, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifier12 = modifier3;
            TextStyle textStyle12 = bodyMedium;
            m10256LongClickableTextVhcvRP8(annotatedStringM10255messageFormatterJy8F4Js, modifier12, textStyle12, false, i317, i31, null, (Function1) objRememberedValue2, aVar4, composerStartRestartGroup, ((i29 << 3) & 1008) | ((i29 << 12) & 234881024), 72);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aVar3 = aVar4;
            i27 = i28;
            i26 = i19;
            modifier2 = modifier12;
            textStyle3 = textStyle12;
            j12 = j1111;
            j13 = j1112;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            textStyle3 = textStyle2;
            i26 = i19;
            aVar3 = aVar2;
            i27 = i16;
            j12 = j10;
            j13 = j11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ClickableLabelKt.Z17ClickableLabel_0nD_MI0$lambda$6(modifier2, textStyle3, text, onClick, aVar3, i27, i26, j12, j13, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ClickableLabel_0nD_MI0$lambda$5$lambda$4(AnnotatedString annotatedString, Function2 function2, int i10) {
        Object next;
        AnnotatedString.Range range = (AnnotatedString.Range) va.g0.y0(annotatedString.getStringAnnotations(i10, i10));
        if (range == null) {
            function2.invoke(Z17ClickableLabelClickType.REGULAR, "");
            return ua.k0.f43947a;
        }
        Iterator<E> it = Z17ClickableLabelClickType.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.y.d(((Z17ClickableLabelClickType) next).name(), range.getTag()));
        Z17ClickableLabelClickType z17ClickableLabelClickType = (Z17ClickableLabelClickType) next;
        if (z17ClickableLabelClickType == null) {
            z17ClickableLabelClickType = Z17ClickableLabelClickType.REGULAR;
        }
        function2.invoke(z17ClickableLabelClickType, range.getItem());
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17ClickableLabel_0nD_MI0$lambda$6(Modifier modifier, TextStyle textStyle, String str, Function2 function2, lb.a aVar, int i10, int i11, long j10, long j11, int i12, int i13, Composer composer, int i14) {
        m10257Z17ClickableLabel0nDMI0(modifier, textStyle, str, function2, aVar, i10, i11, j10, j11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }
}
