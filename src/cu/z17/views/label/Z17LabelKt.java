package cu.z17.views.label;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a_\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aI\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/AnnotatedString;", "text", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "inlineContent", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/graphics/Color;", "color", "", "maxLines", "maxLength", "Lua/k0;", "Z17Label-3f6hBDE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Ljava/util/Map;Landroidx/compose/ui/text/TextStyle;JIILandroidx/compose/runtime/Composer;II)V", "Z17Label", "Z17Label-fWhpE4E", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JIILandroidx/compose/runtime/Composer;II)V", "shadowColor", "Z17LabelWithShadow-DoPahcc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JIIJLandroidx/compose/runtime/Composer;II)V", "Z17LabelWithShadow", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17LabelKt {
    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0133  */
    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:110:0x0151  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:114:0x015d  */
    /* JADX WARN: Code duplicated, block: B:117:0x016e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0191  */
    /* JADX WARN: Code duplicated, block: B:124:0x019b  */
    /* JADX WARN: Code duplicated, block: B:125:0x019e  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:134:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:137:0x020d  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:93:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0115  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17Label-3f6hBDE, reason: not valid java name */
    public static final void m10261Z17Label3f6hBDE(Modifier modifier, final AnnotatedString text, Map<String, InlineTextContent> map, TextStyle textStyle, long j10, int i10, int i11, Composer composer, final int i12, final int i13) {
        int i14;
        Map<String, InlineTextContent> map2;
        TextStyle textStyle2;
        long onBackground;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z10;
        Composer composer2;
        final Modifier modifier2;
        final Map<String, InlineTextContent> map3;
        final TextStyle textStyle3;
        final long j11;
        final int i21;
        final int i22;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Map<String, InlineTextContent> mapI;
        TextStyle bodyMedium;
        Modifier modifier4;
        int i23;
        long j12;
        Map<String, InlineTextContent> map4;
        TextStyle textStyle4;
        int i24;
        int i25;
        CharSequence charSequence;
        int i26;
        int iM8749getClipgIe3tQ8;
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(208165045);
        int i27 = i13 & 1;
        if (i27 != 0) {
            i14 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        int i28 = i13 & 4;
        if (i28 == 0) {
            if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                map2 = map;
                i14 |= composerStartRestartGroup.changedInstance(map2) ? 256 : 128;
            }
            if ((i12 & 3072) == 0) {
                if ((i13 & 8) == 0) {
                    textStyle2 = textStyle;
                    int i29 = composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                    i14 |= i29;
                } else {
                    textStyle2 = textStyle;
                }
                i14 |= i29;
            } else {
                textStyle2 = textStyle;
            }
            if ((i12 & 24576) == 0) {
                if ((i13 & 16) == 0) {
                    onBackground = j10;
                    int i30 = composerStartRestartGroup.changed(onBackground) ? 16384 : 8192;
                    i14 |= i30;
                } else {
                    onBackground = j10;
                }
                i14 |= i30;
            } else {
                onBackground = j10;
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
                    if ((1572864 & i12) == 0) {
                        i19 = i11;
                        if (composerStartRestartGroup.changed(i19)) {
                            i20 = 1048576;
                        } else {
                            i20 = 524288;
                        }
                        i14 |= i20;
                    }
                    if ((i14 & 599187) != 599186) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i12 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i27 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i28 != 0) {
                                mapI = w0.i();
                            } else {
                                mapI = map2;
                            }
                            if ((i13 & 8) != 0) {
                                bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                                i14 &= -7169;
                            } else {
                                bodyMedium = textStyle2;
                            }
                            if ((i13 & 16) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i14 &= -57345;
                            }
                            if (i15 != 0) {
                                i16 = -1;
                            }
                            modifier4 = modifier3;
                            i23 = i16;
                            j12 = onBackground;
                            map4 = mapI;
                            textStyle4 = bodyMedium;
                            i24 = i14;
                            if (i18 != 0) {
                                i25 = -1;
                            } else {
                                i25 = i19;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i13 & 8) != 0) {
                                i14 &= -7169;
                            }
                            if ((i13 & 16) != 0) {
                                i14 &= -57345;
                            }
                            i24 = i14;
                            map4 = map2;
                            textStyle4 = textStyle2;
                            i23 = i16;
                            i25 = i19;
                            j12 = onBackground;
                            modifier4 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                        }
                        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                        if (i25 != -1 || text.length() < i25) {
                            charSequence = text;
                        } else {
                            charSequence = text.subSequence(0, i25 - 1).toString() + "...";
                        }
                        builder.append(charSequence);
                        AnnotatedString annotatedString = builder.toAnnotatedString();
                        if (i23 != -1) {
                            i26 = i23;
                        } else {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i23 != -1) {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                        } else {
                            iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                        }
                        composer2 = composerStartRestartGroup;
                        TextKt.m3849TextIbK3jfQ(annotatedString, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i21 = i23;
                        i22 = i25;
                        modifier2 = modifier4;
                        j11 = j12;
                        map3 = map4;
                        textStyle3 = textStyle4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        map3 = map2;
                        textStyle3 = textStyle2;
                        j11 = onBackground;
                        i21 = i16;
                        i22 = i19;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i14 |= 1572864;
                i19 = i11;
                if ((i14 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                    }
                    AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
                    if (i25 != -1) {
                        charSequence = text;
                    } else {
                        charSequence = text;
                    }
                    builder2.append(charSequence);
                    AnnotatedString annotatedString2 = builder2.toAnnotatedString();
                    if (i23 != -1) {
                        i26 = i23;
                    } else {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i23 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m3849TextIbK3jfQ(annotatedString2, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i21 = i23;
                    i22 = i25;
                    modifier2 = modifier4;
                    j11 = j12;
                    map3 = map4;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    map3 = map2;
                    textStyle3 = textStyle2;
                    j11 = onBackground;
                    i21 = i16;
                    i22 = i19;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i16 = i10;
            i18 = i13 & 64;
            if (i18 != 0) {
                if ((1572864 & i12) == 0) {
                    i19 = i11;
                    if (composerStartRestartGroup.changed(i19)) {
                        i20 = 1048576;
                    } else {
                        i20 = 524288;
                    }
                    i14 |= i20;
                }
                if ((i14 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                    }
                    AnnotatedString.Builder builder3 = new AnnotatedString.Builder(0, 1, null);
                    if (i25 != -1) {
                        charSequence = text;
                    } else {
                        charSequence = text;
                    }
                    builder3.append(charSequence);
                    AnnotatedString annotatedString3 = builder3.toAnnotatedString();
                    if (i23 != -1) {
                        i26 = i23;
                    } else {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i23 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m3849TextIbK3jfQ(annotatedString3, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i21 = i23;
                    i22 = i25;
                    modifier2 = modifier4;
                    j11 = j12;
                    map3 = map4;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    map3 = map2;
                    textStyle3 = textStyle2;
                    j11 = onBackground;
                    i21 = i16;
                    i22 = i19;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 1572864;
            i19 = i11;
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                } else {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                }
                AnnotatedString.Builder builder4 = new AnnotatedString.Builder(0, 1, null);
                if (i25 != -1) {
                    charSequence = text;
                } else {
                    charSequence = text;
                }
                builder4.append(charSequence);
                AnnotatedString annotatedString4 = builder4.toAnnotatedString();
                if (i23 != -1) {
                    i26 = i23;
                } else {
                    i26 = Integer.MAX_VALUE;
                }
                if (i23 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m3849TextIbK3jfQ(annotatedString4, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i21 = i23;
                i22 = i25;
                modifier2 = modifier4;
                j11 = j12;
                map3 = map4;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                map3 = map2;
                textStyle3 = textStyle2;
                j11 = onBackground;
                i21 = i16;
                i22 = i19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        map2 = map;
        if ((i12 & 3072) == 0) {
            if ((i13 & 8) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                }
                i14 |= i29;
            } else {
                textStyle2 = textStyle;
            }
            i14 |= i29;
        } else {
            textStyle2 = textStyle;
        }
        if ((i12 & 24576) == 0) {
            if ((i13 & 16) == 0) {
                onBackground = j10;
                if (composerStartRestartGroup.changed(onBackground)) {
                }
                i14 |= i30;
            } else {
                onBackground = j10;
            }
            i14 |= i30;
        } else {
            onBackground = j10;
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
                if ((1572864 & i12) == 0) {
                    i19 = i11;
                    if (composerStartRestartGroup.changed(i19)) {
                        i20 = 1048576;
                    } else {
                        i20 = 524288;
                    }
                    i14 |= i20;
                }
                if ((i14 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i28 != 0) {
                            mapI = w0.i();
                        } else {
                            mapI = map2;
                        }
                        if ((i13 & 8) != 0) {
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                            i14 &= -7169;
                        } else {
                            bodyMedium = textStyle2;
                        }
                        if ((i13 & 16) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -57345;
                        }
                        if (i15 != 0) {
                            i16 = -1;
                        }
                        modifier4 = modifier3;
                        i23 = i16;
                        j12 = onBackground;
                        map4 = mapI;
                        textStyle4 = bodyMedium;
                        i24 = i14;
                        if (i18 != 0) {
                            i25 = -1;
                        } else {
                            i25 = i19;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                    }
                    AnnotatedString.Builder builder5 = new AnnotatedString.Builder(0, 1, null);
                    if (i25 != -1) {
                        charSequence = text;
                    } else {
                        charSequence = text;
                    }
                    builder5.append(charSequence);
                    AnnotatedString annotatedString5 = builder5.toAnnotatedString();
                    if (i23 != -1) {
                        i26 = i23;
                    } else {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i23 != -1) {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m3849TextIbK3jfQ(annotatedString5, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i21 = i23;
                    i22 = i25;
                    modifier2 = modifier4;
                    j11 = j12;
                    map3 = map4;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    map3 = map2;
                    textStyle3 = textStyle2;
                    j11 = onBackground;
                    i21 = i16;
                    i22 = i19;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= 1572864;
            i19 = i11;
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                } else {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                }
                AnnotatedString.Builder builder6 = new AnnotatedString.Builder(0, 1, null);
                if (i25 != -1) {
                    charSequence = text;
                } else {
                    charSequence = text;
                }
                builder6.append(charSequence);
                AnnotatedString annotatedString6 = builder6.toAnnotatedString();
                if (i23 != -1) {
                    i26 = i23;
                } else {
                    i26 = Integer.MAX_VALUE;
                }
                if (i23 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m3849TextIbK3jfQ(annotatedString6, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i21 = i23;
                i22 = i25;
                modifier2 = modifier4;
                j11 = j12;
                map3 = map4;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                map3 = map2;
                textStyle3 = textStyle2;
                j11 = onBackground;
                i21 = i16;
                i22 = i19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i16 = i10;
        i18 = i13 & 64;
        if (i18 != 0) {
            if ((1572864 & i12) == 0) {
                i19 = i11;
                if (composerStartRestartGroup.changed(i19)) {
                    i20 = 1048576;
                } else {
                    i20 = 524288;
                }
                i14 |= i20;
            }
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                } else {
                    if (i27 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i28 != 0) {
                        mapI = w0.i();
                    } else {
                        mapI = map2;
                    }
                    if ((i13 & 8) != 0) {
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        i14 &= -7169;
                    } else {
                        bodyMedium = textStyle2;
                    }
                    if ((i13 & 16) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -57345;
                    }
                    if (i15 != 0) {
                        i16 = -1;
                    }
                    modifier4 = modifier3;
                    i23 = i16;
                    j12 = onBackground;
                    map4 = mapI;
                    textStyle4 = bodyMedium;
                    i24 = i14;
                    if (i18 != 0) {
                        i25 = -1;
                    } else {
                        i25 = i19;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
                }
                AnnotatedString.Builder builder7 = new AnnotatedString.Builder(0, 1, null);
                if (i25 != -1) {
                    charSequence = text;
                } else {
                    charSequence = text;
                }
                builder7.append(charSequence);
                AnnotatedString annotatedString7 = builder7.toAnnotatedString();
                if (i23 != -1) {
                    i26 = i23;
                } else {
                    i26 = Integer.MAX_VALUE;
                }
                if (i23 != -1) {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m3849TextIbK3jfQ(annotatedString7, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i21 = i23;
                i22 = i25;
                modifier2 = modifier4;
                j11 = j12;
                map3 = map4;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                map3 = map2;
                textStyle3 = textStyle2;
                j11 = onBackground;
                i21 = i16;
                i22 = i19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 1572864;
        i19 = i11;
        if ((i14 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i12 & 1) != 0) {
                if (i27 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i28 != 0) {
                    mapI = w0.i();
                } else {
                    mapI = map2;
                }
                if ((i13 & 8) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i14 &= -7169;
                } else {
                    bodyMedium = textStyle2;
                }
                if ((i13 & 16) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -57345;
                }
                if (i15 != 0) {
                    i16 = -1;
                }
                modifier4 = modifier3;
                i23 = i16;
                j12 = onBackground;
                map4 = mapI;
                textStyle4 = bodyMedium;
                i24 = i14;
                if (i18 != 0) {
                    i25 = -1;
                } else {
                    i25 = i19;
                }
            } else {
                if (i27 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i28 != 0) {
                    mapI = w0.i();
                } else {
                    mapI = map2;
                }
                if ((i13 & 8) != 0) {
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    i14 &= -7169;
                } else {
                    bodyMedium = textStyle2;
                }
                if ((i13 & 16) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -57345;
                }
                if (i15 != 0) {
                    i16 = -1;
                }
                modifier4 = modifier3;
                i23 = i16;
                j12 = onBackground;
                map4 = mapI;
                textStyle4 = bodyMedium;
                i24 = i14;
                if (i18 != 0) {
                    i25 = -1;
                } else {
                    i25 = i19;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(208165045, i24, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:27)");
            }
            AnnotatedString.Builder builder8 = new AnnotatedString.Builder(0, 1, null);
            if (i25 != -1) {
                charSequence = text;
            } else {
                charSequence = text;
            }
            builder8.append(charSequence);
            AnnotatedString annotatedString8 = builder8.toAnnotatedString();
            if (i23 != -1) {
                i26 = i23;
            } else {
                i26 = Integer.MAX_VALUE;
            }
            if (i23 != -1) {
                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8750getEllipsisgIe3tQ8();
            } else {
                iM8749getClipgIe3tQ8 = TextOverflow.INSTANCE.m8749getClipgIe3tQ8();
            }
            composer2 = composerStartRestartGroup;
            TextKt.m3849TextIbK3jfQ(annotatedString8, modifier4, j12, 0L, null, null, null, 0L, null, null, 0L, iM8749getClipgIe3tQ8, false, i26, 0, map4, null, textStyle4, composer2, ((i24 << 3) & 112) | ((i24 >> 6) & 896), ((i24 << 9) & 458752) | ((i24 << 12) & 29360128), 88056);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i21 = i23;
            i22 = i25;
            modifier2 = modifier4;
            j11 = j12;
            map3 = map4;
            textStyle3 = textStyle4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            map3 = map2;
            textStyle3 = textStyle2;
            j11 = onBackground;
            i21 = i16;
            i22 = i19;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17LabelKt.Z17Label_3f6hBDE$lambda$1(modifier2, text, map3, textStyle3, j11, i21, i22, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0137  */
    /* JADX WARN: Code duplicated, block: B:105:0x015c  */
    /* JADX WARN: Code duplicated, block: B:107:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0162  */
    /* JADX WARN: Code duplicated, block: B:111:0x016b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0172  */
    /* JADX WARN: Code duplicated, block: B:116:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:118:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:90:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:96:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17Label-fWhpE4E, reason: not valid java name */
    public static final void m10262Z17LabelfWhpE4E(Modifier modifier, final String text, TextStyle textStyle, long j10, int i10, int i11, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        TextStyle bodyMedium;
        long onBackground;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z10;
        Composer composer2;
        final Modifier modifier3;
        final TextStyle textStyle2;
        final long j11;
        final int i19;
        final int i20;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long j12;
        Modifier modifier5;
        int i21;
        long j13;
        TextStyle textStyle3;
        int i22;
        String str;
        int i23;
        TextOverflow.Companion companion;
        int iM8749getClipgIe3tQ8;
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1520385343);
        int i24 = i13 & 1;
        if (i24 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i13 & 4) == 0) {
                bodyMedium = textStyle;
                int i25 = composerStartRestartGroup.changed(bodyMedium) ? 256 : 128;
                i14 |= i25;
            } else {
                bodyMedium = textStyle;
            }
            i14 |= i25;
        } else {
            bodyMedium = textStyle;
        }
        if ((i12 & 3072) == 0) {
            onBackground = j10;
            i14 |= ((i13 & 8) == 0 && composerStartRestartGroup.changed(onBackground)) ? 2048 : 1024;
        } else {
            onBackground = j10;
        }
        int i26 = i13 & 16;
        if (i26 == 0) {
            if ((i12 & 24576) == 0) {
                i15 = i10;
                i14 |= composerStartRestartGroup.changed(i15) ? 16384 : 8192;
            }
            i16 = i13 & 32;
            if (i16 != 0) {
                if ((196608 & i12) == 0) {
                    i17 = i11;
                    if (composerStartRestartGroup.changed(i17)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i14 |= i18;
                }
                if ((74899 & i14) != 74898) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i24 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i13 & 4) != 0) {
                            i14 &= -897;
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        }
                        if ((i13 & 8) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -7169;
                        }
                        if (i26 != 0) {
                            i15 = -1;
                        }
                        j12 = onBackground;
                        modifier5 = modifier4;
                        i21 = i15;
                        if (i16 != 0) {
                            j13 = j12;
                            textStyle3 = bodyMedium;
                            i22 = -1;
                        } else {
                            j13 = j12;
                            textStyle3 = bodyMedium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1520385343, i14, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:56)");
                        }
                        if (i22 != -1 || text.length() < i22) {
                            str = text;
                        } else {
                            String strSubstring = text.substring(0, i22 - 1);
                            kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
                            str = strSubstring + "...";
                        }
                        if (i21 != -1) {
                            i23 = i21;
                        } else {
                            i23 = Integer.MAX_VALUE;
                        }
                        companion = TextOverflow.INSTANCE;
                        if (i21 != -1) {
                            iM8749getClipgIe3tQ8 = companion.m8750getEllipsisgIe3tQ8();
                        } else {
                            iM8749getClipgIe3tQ8 = companion.m8749getClipgIe3tQ8();
                        }
                        composer2 = composerStartRestartGroup;
                        TextKt.m3848Text4IGK_g(str, modifier5, j13, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM8749getClipgIe3tQ8, false, i23, 0, (Function1) null, textStyle3, composer2, ((i14 << 3) & 112) | ((i14 >> 3) & 896), (i14 << 12) & 3670016, 55288);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i19 = i21;
                        i20 = i22;
                        modifier3 = modifier5;
                        j11 = j13;
                        textStyle2 = textStyle3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i13 & 4) != 0) {
                            i14 &= -897;
                        }
                        if ((i13 & 8) != 0) {
                            i14 &= -7169;
                        }
                        textStyle3 = bodyMedium;
                        i21 = i15;
                        j13 = onBackground;
                        modifier5 = modifier2;
                    }
                    i22 = i17;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1520385343, i14, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:56)");
                    }
                    if (i22 != -1) {
                        str = text;
                    } else {
                        str = text;
                    }
                    if (i21 != -1) {
                        i23 = i21;
                    } else {
                        i23 = Integer.MAX_VALUE;
                    }
                    companion = TextOverflow.INSTANCE;
                    if (i21 != -1) {
                        iM8749getClipgIe3tQ8 = companion.m8750getEllipsisgIe3tQ8();
                    } else {
                        iM8749getClipgIe3tQ8 = companion.m8749getClipgIe3tQ8();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m3848Text4IGK_g(str, modifier5, j13, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM8749getClipgIe3tQ8, false, i23, 0, (Function1) null, textStyle3, composer2, ((i14 << 3) & 112) | ((i14 >> 3) & 896), (i14 << 12) & 3670016, 55288);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = i21;
                    i20 = i22;
                    modifier3 = modifier5;
                    j11 = j13;
                    textStyle2 = textStyle3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    textStyle2 = bodyMedium;
                    j11 = onBackground;
                    i19 = i15;
                    i20 = i17;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.a0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17LabelKt.Z17Label_fWhpE4E$lambda$2(modifier3, text, textStyle2, j11, i19, i20, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i17 = i11;
            if ((74899 & i14) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    j12 = onBackground;
                    modifier5 = modifier4;
                    i21 = i15;
                    if (i16 != 0) {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = -1;
                    } else {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = i17;
                    }
                } else {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    j12 = onBackground;
                    modifier5 = modifier4;
                    i21 = i15;
                    if (i16 != 0) {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = -1;
                    } else {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = i17;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1520385343, i14, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:56)");
                }
                if (i22 != -1) {
                    str = text;
                } else {
                    str = text;
                }
                if (i21 != -1) {
                    i23 = i21;
                } else {
                    i23 = Integer.MAX_VALUE;
                }
                companion = TextOverflow.INSTANCE;
                if (i21 != -1) {
                    iM8749getClipgIe3tQ8 = companion.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = companion.m8749getClipgIe3tQ8();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m3848Text4IGK_g(str, modifier5, j13, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM8749getClipgIe3tQ8, false, i23, 0, (Function1) null, textStyle3, composer2, ((i14 << 3) & 112) | ((i14 >> 3) & 896), (i14 << 12) & 3670016, 55288);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i21;
                i20 = i22;
                modifier3 = modifier5;
                j11 = j13;
                textStyle2 = textStyle3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                textStyle2 = bodyMedium;
                j11 = onBackground;
                i19 = i15;
                i20 = i17;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.a0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17Label_fWhpE4E$lambda$2(modifier3, text, textStyle2, j11, i19, i20, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 24576;
        i15 = i10;
        i16 = i13 & 32;
        if (i16 != 0) {
            if ((196608 & i12) == 0) {
                i17 = i11;
                if (composerStartRestartGroup.changed(i17)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i14 |= i18;
            }
            if ((74899 & i14) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    j12 = onBackground;
                    modifier5 = modifier4;
                    i21 = i15;
                    if (i16 != 0) {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = -1;
                    } else {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = i17;
                    }
                } else {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    j12 = onBackground;
                    modifier5 = modifier4;
                    i21 = i15;
                    if (i16 != 0) {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = -1;
                    } else {
                        j13 = j12;
                        textStyle3 = bodyMedium;
                        i22 = i17;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1520385343, i14, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:56)");
                }
                if (i22 != -1) {
                    str = text;
                } else {
                    str = text;
                }
                if (i21 != -1) {
                    i23 = i21;
                } else {
                    i23 = Integer.MAX_VALUE;
                }
                companion = TextOverflow.INSTANCE;
                if (i21 != -1) {
                    iM8749getClipgIe3tQ8 = companion.m8750getEllipsisgIe3tQ8();
                } else {
                    iM8749getClipgIe3tQ8 = companion.m8749getClipgIe3tQ8();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m3848Text4IGK_g(str, modifier5, j13, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM8749getClipgIe3tQ8, false, i23, 0, (Function1) null, textStyle3, composer2, ((i14 << 3) & 112) | ((i14 >> 3) & 896), (i14 << 12) & 3670016, 55288);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = i21;
                i20 = i22;
                modifier3 = modifier5;
                j11 = j13;
                textStyle2 = textStyle3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                textStyle2 = bodyMedium;
                j11 = onBackground;
                i19 = i15;
                i20 = i17;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.a0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17Label_fWhpE4E$lambda$2(modifier3, text, textStyle2, j11, i19, i20, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i17 = i11;
        if ((74899 & i14) != 74898) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i12 & 1) != 0) {
                if (i24 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i13 & 4) != 0) {
                    i14 &= -897;
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                }
                if ((i13 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -7169;
                }
                if (i26 != 0) {
                    i15 = -1;
                }
                j12 = onBackground;
                modifier5 = modifier4;
                i21 = i15;
                if (i16 != 0) {
                    j13 = j12;
                    textStyle3 = bodyMedium;
                    i22 = -1;
                } else {
                    j13 = j12;
                    textStyle3 = bodyMedium;
                    i22 = i17;
                }
            } else {
                if (i24 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i13 & 4) != 0) {
                    i14 &= -897;
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                }
                if ((i13 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -7169;
                }
                if (i26 != 0) {
                    i15 = -1;
                }
                j12 = onBackground;
                modifier5 = modifier4;
                i21 = i15;
                if (i16 != 0) {
                    j13 = j12;
                    textStyle3 = bodyMedium;
                    i22 = -1;
                } else {
                    j13 = j12;
                    textStyle3 = bodyMedium;
                    i22 = i17;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1520385343, i14, -1, "cu.z17.views.label.Z17Label (Z17Label.kt:56)");
            }
            if (i22 != -1) {
                str = text;
            } else {
                str = text;
            }
            if (i21 != -1) {
                i23 = i21;
            } else {
                i23 = Integer.MAX_VALUE;
            }
            companion = TextOverflow.INSTANCE;
            if (i21 != -1) {
                iM8749getClipgIe3tQ8 = companion.m8750getEllipsisgIe3tQ8();
            } else {
                iM8749getClipgIe3tQ8 = companion.m8749getClipgIe3tQ8();
            }
            composer2 = composerStartRestartGroup;
            TextKt.m3848Text4IGK_g(str, modifier5, j13, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM8749getClipgIe3tQ8, false, i23, 0, (Function1) null, textStyle3, composer2, ((i14 << 3) & 112) | ((i14 >> 3) & 896), (i14 << 12) & 3670016, 55288);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i19 = i21;
            i20 = i22;
            modifier3 = modifier5;
            j11 = j13;
            textStyle2 = textStyle3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            textStyle2 = bodyMedium;
            j11 = onBackground;
            i19 = i15;
            i20 = i17;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17LabelKt.Z17Label_fWhpE4E$lambda$2(modifier3, text, textStyle2, j11, i19, i20, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0117  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:105:0x013c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0142  */
    /* JADX WARN: Code duplicated, block: B:109:0x0145  */
    /* JADX WARN: Code duplicated, block: B:112:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0167  */
    /* JADX WARN: Code duplicated, block: B:119:0x0195  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:128:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:131:0x024e  */
    /* JADX WARN: Code duplicated, block: B:133:0x025a  */
    /* JADX WARN: Code duplicated, block: B:136:0x026b  */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:96:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x010f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0112  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17LabelWithShadow-DoPahcc, reason: not valid java name */
    public static final void m10263Z17LabelWithShadowDoPahcc(Modifier modifier, final String text, TextStyle textStyle, long j10, int i10, int i11, long j11, Composer composer, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        TextStyle bodyMedium;
        int i15;
        int i16;
        int i17;
        int i18;
        long onBackground;
        boolean z10;
        final Modifier modifier3;
        final TextStyle textStyle2;
        final int i19;
        final int i20;
        final long j12;
        final long j13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long onBackground2;
        Modifier modifier5;
        int i21;
        int i22;
        int i23;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        kotlin.jvm.internal.y.i(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-672916254);
        int i24 = i13 & 1;
        if (i24 != 0) {
            i14 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i13 & 4) == 0) {
                bodyMedium = textStyle;
                int i25 = composerStartRestartGroup.changed(bodyMedium) ? 256 : 128;
                i14 |= i25;
            } else {
                bodyMedium = textStyle;
            }
            i14 |= i25;
        } else {
            bodyMedium = textStyle;
        }
        if ((i12 & 3072) == 0) {
            i14 |= ((i13 & 8) == 0 && composerStartRestartGroup.changed(j10)) ? 2048 : 1024;
        }
        int i26 = i13 & 16;
        if (i26 == 0) {
            if ((i12 & 24576) == 0) {
                i15 = i10;
                i14 |= composerStartRestartGroup.changed(i15) ? 16384 : 8192;
            }
            i16 = i13 & 32;
            if (i16 != 0) {
                if ((196608 & i12) == 0) {
                    i17 = i11;
                    if (composerStartRestartGroup.changed(i17)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i14 |= i18;
                }
                if ((1572864 & i12) == 0) {
                    if ((i13 & 64) == 0) {
                        onBackground = j11;
                        int i27 = composerStartRestartGroup.changed(onBackground) ? 1048576 : 524288;
                        i14 |= i27;
                    } else {
                        onBackground = j11;
                    }
                    i14 |= i27;
                } else {
                    onBackground = j11;
                }
                if ((i14 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i24 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i13 & 4) != 0) {
                            i14 &= -897;
                            bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        }
                        if ((i13 & 8) != 0) {
                            onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -7169;
                        } else {
                            onBackground2 = j10;
                        }
                        if (i26 != 0) {
                            i15 = -1;
                        }
                        if (i16 != 0) {
                            i17 = -1;
                        }
                        if ((i13 & 64) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i14 &= -3670017;
                        }
                        int i28 = i15;
                        modifier5 = modifier4;
                        i21 = i28;
                        i22 = i14;
                        i23 = i17;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i13 & 4) != 0) {
                            i14 &= -897;
                        }
                        if ((i13 & 8) != 0) {
                            i14 &= -7169;
                        }
                        if ((i13 & 64) != 0) {
                            i14 &= -3670017;
                        }
                        onBackground2 = j10;
                        i22 = i14;
                        i21 = i15;
                        i23 = i17;
                        modifier5 = modifier2;
                    }
                    long j14 = onBackground;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-672916254, i22, -1, "cu.z17.views.label.Z17LabelWithShadow (Z17Label.kt:81)");
                    }
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    constructor = companion.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !kotlin.jvm.internal.y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    float f10 = (float) 0.7d;
                    int i29 = (i22 & 112) | 6 | (i22 & 896);
                    int i30 = i22 & 57344;
                    int i31 = i22 & 458752;
                    TextStyle textStyle3 = bodyMedium;
                    int i32 = i21;
                    m10262Z17LabelfWhpE4E(AlphaKt.alpha(OffsetKt.m1684offsetVpY3zN4(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m8823constructorimpl(f10), Dp.m8823constructorimpl(f10)), 0.75f), text, textStyle3, j14, i32, i23, composerStartRestartGroup, i29 | ((i22 >> 9) & 7168) | i30 | i31, 0);
                    long j15 = onBackground2;
                    m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), text, textStyle3, j15, i32, i23, composerStartRestartGroup, i29 | (i22 & 7168) | i30 | i31, 0);
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    j12 = j14;
                    i20 = i23;
                    i19 = i32;
                    j13 = j15;
                    textStyle2 = textStyle3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    textStyle2 = bodyMedium;
                    i19 = i15;
                    i20 = i17;
                    j12 = onBackground;
                    j13 = j10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17LabelKt.Z17LabelWithShadow_DoPahcc$lambda$4(modifier3, text, textStyle2, j13, i19, i20, j12, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i17 = i11;
            if ((1572864 & i12) == 0) {
                if ((i13 & 64) == 0) {
                    onBackground = j11;
                    if (composerStartRestartGroup.changed(onBackground)) {
                    }
                    i14 |= i27;
                } else {
                    onBackground = j11;
                }
                i14 |= i27;
            } else {
                onBackground = j11;
            }
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    } else {
                        onBackground2 = j10;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    if (i16 != 0) {
                        i17 = -1;
                    }
                    if ((i13 & 64) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -3670017;
                    }
                    int i210 = i15;
                    modifier5 = modifier4;
                    i21 = i210;
                    i22 = i14;
                    i23 = i17;
                } else {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    } else {
                        onBackground2 = j10;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    if (i16 != 0) {
                        i17 = -1;
                    }
                    if ((i13 & 64) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -3670017;
                    }
                    int i211 = i15;
                    modifier5 = modifier4;
                    i21 = i211;
                    i22 = i14;
                    i23 = i17;
                }
                long j16 = onBackground;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-672916254, i22, -1, "cu.z17.views.label.Z17LabelWithShadow (Z17Label.kt:81)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                float f11 = (float) 0.7d;
                int i212 = (i22 & 112) | 6 | (i22 & 896);
                int i33 = i22 & 57344;
                int i34 = i22 & 458752;
                TextStyle textStyle4 = bodyMedium;
                int i35 = i21;
                m10262Z17LabelfWhpE4E(AlphaKt.alpha(OffsetKt.m1684offsetVpY3zN4(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f11)), 0.75f), text, textStyle4, j16, i35, i23, composerStartRestartGroup, i212 | ((i22 >> 9) & 7168) | i33 | i34, 0);
                long j17 = onBackground2;
                m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), text, textStyle4, j17, i35, i23, composerStartRestartGroup, i212 | (i22 & 7168) | i33 | i34, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j12 = j16;
                i20 = i23;
                i19 = i35;
                j13 = j17;
                textStyle2 = textStyle4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                textStyle2 = bodyMedium;
                i19 = i15;
                i20 = i17;
                j12 = onBackground;
                j13 = j10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17LabelWithShadow_DoPahcc$lambda$4(modifier3, text, textStyle2, j13, i19, i20, j12, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= 24576;
        i15 = i10;
        i16 = i13 & 32;
        if (i16 != 0) {
            if ((196608 & i12) == 0) {
                i17 = i11;
                if (composerStartRestartGroup.changed(i17)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i14 |= i18;
            }
            if ((1572864 & i12) == 0) {
                if ((i13 & 64) == 0) {
                    onBackground = j11;
                    if (composerStartRestartGroup.changed(onBackground)) {
                    }
                    i14 |= i27;
                } else {
                    onBackground = j11;
                }
                i14 |= i27;
            } else {
                onBackground = j11;
            }
            if ((i14 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    } else {
                        onBackground2 = j10;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    if (i16 != 0) {
                        i17 = -1;
                    }
                    if ((i13 & 64) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -3670017;
                    }
                    int i213 = i15;
                    modifier5 = modifier4;
                    i21 = i213;
                    i22 = i14;
                    i23 = i17;
                } else {
                    if (i24 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i13 & 4) != 0) {
                        i14 &= -897;
                        bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                    }
                    if ((i13 & 8) != 0) {
                        onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -7169;
                    } else {
                        onBackground2 = j10;
                    }
                    if (i26 != 0) {
                        i15 = -1;
                    }
                    if (i16 != 0) {
                        i17 = -1;
                    }
                    if ((i13 & 64) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i14 &= -3670017;
                    }
                    int i214 = i15;
                    modifier5 = modifier4;
                    i21 = i214;
                    i22 = i14;
                    i23 = i17;
                }
                long j18 = onBackground;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-672916254, i22, -1, "cu.z17.views.label.Z17LabelWithShadow (Z17Label.kt:81)");
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion6 = Modifier.INSTANCE;
                float f12 = (float) 0.7d;
                int i215 = (i22 & 112) | 6 | (i22 & 896);
                int i36 = i22 & 57344;
                int i37 = i22 & 458752;
                TextStyle textStyle5 = bodyMedium;
                int i38 = i21;
                m10262Z17LabelfWhpE4E(AlphaKt.alpha(OffsetKt.m1684offsetVpY3zN4(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f12)), 0.75f), text, textStyle5, j18, i38, i23, composerStartRestartGroup, i215 | ((i22 >> 9) & 7168) | i36 | i37, 0);
                long j19 = onBackground2;
                m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), text, textStyle5, j19, i38, i23, composerStartRestartGroup, i215 | (i22 & 7168) | i36 | i37, 0);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j12 = j18;
                i20 = i23;
                i19 = i38;
                j13 = j19;
                textStyle2 = textStyle5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                textStyle2 = bodyMedium;
                i19 = i15;
                i20 = i17;
                j12 = onBackground;
                j13 = j10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17LabelKt.Z17LabelWithShadow_DoPahcc$lambda$4(modifier3, text, textStyle2, j13, i19, i20, j12, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i17 = i11;
        if ((1572864 & i12) == 0) {
            if ((i13 & 64) == 0) {
                onBackground = j11;
                if (composerStartRestartGroup.changed(onBackground)) {
                }
                i14 |= i27;
            } else {
                onBackground = j11;
            }
            i14 |= i27;
        } else {
            onBackground = j11;
        }
        if ((i14 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i12 & 1) != 0) {
                if (i24 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i13 & 4) != 0) {
                    i14 &= -897;
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                }
                if ((i13 & 8) != 0) {
                    onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -7169;
                } else {
                    onBackground2 = j10;
                }
                if (i26 != 0) {
                    i15 = -1;
                }
                if (i16 != 0) {
                    i17 = -1;
                }
                if ((i13 & 64) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -3670017;
                }
                int i216 = i15;
                modifier5 = modifier4;
                i21 = i216;
                i22 = i14;
                i23 = i17;
            } else {
                if (i24 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i13 & 4) != 0) {
                    i14 &= -897;
                    bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                }
                if ((i13 & 8) != 0) {
                    onBackground2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -7169;
                } else {
                    onBackground2 = j10;
                }
                if (i26 != 0) {
                    i15 = -1;
                }
                if (i16 != 0) {
                    i17 = -1;
                }
                if ((i13 & 64) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i14 &= -3670017;
                }
                int i217 = i15;
                modifier5 = modifier4;
                i21 = i217;
                i22 = i14;
                i23 = i17;
            }
            long j110 = onBackground;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-672916254, i22, -1, "cu.z17.views.label.Z17LabelWithShadow (Z17Label.kt:81)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
            ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
            constructor = companion7.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion7.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion7.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion7.getSetModifier());
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion8 = Modifier.INSTANCE;
            float f13 = (float) 0.7d;
            int i218 = (i22 & 112) | 6 | (i22 & 896);
            int i39 = i22 & 57344;
            int i310 = i22 & 458752;
            TextStyle textStyle6 = bodyMedium;
            int i311 = i21;
            m10262Z17LabelfWhpE4E(AlphaKt.alpha(OffsetKt.m1684offsetVpY3zN4(SizeKt.fillMaxWidth$default(companion8, 0.0f, 1, null), Dp.m8823constructorimpl(f13), Dp.m8823constructorimpl(f13)), 0.75f), text, textStyle6, j110, i311, i23, composerStartRestartGroup, i218 | ((i22 >> 9) & 7168) | i39 | i310, 0);
            long j111 = onBackground2;
            m10262Z17LabelfWhpE4E(SizeKt.fillMaxWidth$default(companion8, 0.0f, 1, null), text, textStyle6, j111, i311, i23, composerStartRestartGroup, i218 | (i22 & 7168) | i39 | i310, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            j12 = j110;
            i20 = i23;
            i19 = i311;
            j13 = j111;
            textStyle2 = textStyle6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            textStyle2 = bodyMedium;
            i19 = i15;
            i20 = i17;
            j12 = onBackground;
            j13 = j10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.label.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17LabelKt.Z17LabelWithShadow_DoPahcc$lambda$4(modifier3, text, textStyle2, j13, i19, i20, j12, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17LabelWithShadow_DoPahcc$lambda$4(Modifier modifier, String str, TextStyle textStyle, long j10, int i10, int i11, long j11, int i12, int i13, Composer composer, int i14) {
        m10263Z17LabelWithShadowDoPahcc(modifier, str, textStyle, j10, i10, i11, j11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Label_3f6hBDE$lambda$1(Modifier modifier, AnnotatedString annotatedString, Map map, TextStyle textStyle, long j10, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        m10261Z17Label3f6hBDE(modifier, annotatedString, map, textStyle, j10, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 Z17Label_fWhpE4E$lambda$2(Modifier modifier, String str, TextStyle textStyle, long j10, int i10, int i11, int i12, int i13, Composer composer, int i14) {
        m10262Z17LabelfWhpE4E(modifier, str, textStyle, j10, i10, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), i13);
        return ua.k0.f43947a;
    }
}
