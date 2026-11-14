package cu.z17.views.textToggle;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.e3;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.textToggle.Z17TextToggleKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aj\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "state", "Lkotlin/Function1;", "Lua/k0;", "onChange", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leading", "", "label", "Landroidx/compose/ui/text/TextStyle;", "labelStyle", "Landroidx/compose/material3/SwitchColors;", "switchColors", "Z17TextToggle", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17TextToggleKt {
    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0130  */
    /* JADX WARN: Code duplicated, block: B:104:0x018a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0199  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:118:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:120:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:123:0x020b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0217  */
    /* JADX WARN: Code duplicated, block: B:127:0x021b  */
    /* JADX WARN: Code duplicated, block: B:130:0x023a  */
    /* JADX WARN: Code duplicated, block: B:132:0x0248  */
    /* JADX WARN: Code duplicated, block: B:135:0x0261  */
    /* JADX WARN: Code duplicated, block: B:137:0x026b  */
    /* JADX WARN: Code duplicated, block: B:140:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:142:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:145:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0109  */
    /* JADX WARN: Code duplicated, block: B:90:0x010c  */
    /* JADX WARN: Code duplicated, block: B:92:0x010f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x011c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Z17TextToggle(Modifier modifier, final boolean z10, final Function1 onChange, Function2 function2, String str, TextStyle textStyle, SwitchColors switchColors, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        Function2 function3;
        int i13;
        String str2;
        int i14;
        TextStyle textStyle2;
        SwitchColors switchColors2;
        boolean z11;
        final Modifier modifier3;
        Composer composer2;
        final SwitchColors switchColors3;
        final Function2 function4;
        final String str3;
        final TextStyle textStyle3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function2 function5;
        String str4;
        TextStyle bodyLarge;
        Composer composer3;
        int i15;
        Modifier modifier5;
        Function2 function6;
        SwitchColors switchColorsM3737colorsV1nXRL4;
        boolean z12;
        boolean z13;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int i16;
        y.i(onChange, "onChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-670745967);
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
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onChange) ? 256 : 128;
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
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((196608 & i10) == 0) {
                    if ((i11 & 32) == 0) {
                        textStyle2 = textStyle;
                        int i19 = composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        i12 |= i19;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i12 |= i19;
                } else {
                    textStyle2 = textStyle;
                }
                if ((i10 & 1572864) == 0) {
                    switchColors2 = switchColors;
                    if ((i11 & 64) == 0 || !composerStartRestartGroup.changed(switchColors2)) {
                        i16 = 524288;
                    } else {
                        i16 = 1048576;
                    }
                    i12 |= i16;
                } else {
                    switchColors2 = switchColors;
                }
                if ((i12 & 599187) != 599186) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i18 != 0) {
                            function5 = null;
                        } else {
                            function5 = function3;
                        }
                        if (i13 != 0) {
                            str4 = "";
                        } else {
                            str4 = str2;
                        }
                        if ((i11 & 32) != 0) {
                            bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                            i12 &= -458753;
                        } else {
                            bodyLarge = textStyle2;
                        }
                        if ((i11 & 64) != 0) {
                            SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
                            Color.Companion companion = Color.INSTANCE;
                            long jM5903getWhite0d7_KjU = companion.m5903getWhite0d7_KjU();
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i20 = MaterialTheme.$stable;
                            long primary = materialTheme.getColorScheme(composerStartRestartGroup, i20).getPrimary();
                            long onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i20).getOnBackground();
                            i15 = 256;
                            switchColorsM3737colorsV1nXRL4 = switchDefaults.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU, primary, 0L, 0L, materialTheme.getColorScheme(composerStartRestartGroup, i20).getOnBackground(), companion.m5901getTransparent0d7_KjU(), onBackground, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                            composer3 = composerStartRestartGroup;
                            i12 &= -3670017;
                            modifier5 = modifier4;
                            function6 = function5;
                        } else {
                            composer3 = composerStartRestartGroup;
                            i15 = 256;
                            modifier5 = modifier4;
                            function6 = function5;
                            switchColorsM3737colorsV1nXRL4 = switchColors2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                        }
                        if ((i11 & 64) != 0) {
                            i12 &= -3670017;
                        }
                        modifier5 = modifier2;
                        switchColorsM3737colorsV1nXRL4 = switchColors2;
                        function6 = function3;
                        str4 = str2;
                        bodyLarge = textStyle2;
                        composer3 = composerStartRestartGroup;
                        i15 = 256;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-670745967, i12, -1, "cu.z17.views.textToggle.Z17TextToggle (Z17TextToggle.kt:33)");
                    }
                    if ((i12 & 896) == i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12 | ((i12 & 112) == 32);
                    objRememberedValue = composer3.rememberedValue();
                    if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new a() { // from class: s9.a
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (a) objRememberedValue, 7, null);
                    Modifier modifier6 = modifier5;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composer3, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM1238clickableXHw0xAI$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    constructor = companion2.getConstructor();
                    if (!r.a(composer3.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (function6 == null) {
                        composer3.startReplaceGroup(-337299193);
                    } else {
                        composer3.startReplaceGroup(-337299192);
                        function6.invoke(composer3, Integer.valueOf((i12 >> 9) & 14));
                    }
                    composer3.endReplaceGroup();
                    TextStyle textStyle4 = bodyLarge;
                    Composer composer4 = composer3;
                    String str5 = str4;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str5, textStyle4, 0L, 0, 0, composer4, (i12 >> 9) & 1008, 56);
                    SwitchColors switchColors4 = switchColorsM3737colorsV1nXRL4;
                    Function2 function7 = function6;
                    SwitchKt.Switch(z10, onChange, null, null, false, switchColors4, null, composer4, (i12 >> 3) & 458878, 92);
                    composer4.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composer4;
                    function4 = function7;
                    textStyle3 = textStyle4;
                    modifier3 = modifier6;
                    switchColors3 = switchColors4;
                    str3 = str5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    switchColors3 = switchColors2;
                    function4 = function3;
                    str3 = str2;
                    textStyle3 = textStyle2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s9.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TextToggleKt.Z17TextToggle$lambda$4(modifier3, z10, onChange, function4, str3, textStyle3, switchColors3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            str2 = str;
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                    }
                    i12 |= i19;
                } else {
                    textStyle2 = textStyle;
                }
                i12 |= i19;
            } else {
                textStyle2 = textStyle;
            }
            if ((i10 & 1572864) == 0) {
                switchColors2 = switchColors;
                if ((i11 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            } else {
                switchColors2 = switchColors;
            }
            if ((i12 & 599187) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i13 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i11 & 32) != 0) {
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        i12 &= -458753;
                    } else {
                        bodyLarge = textStyle2;
                    }
                    if ((i11 & 64) != 0) {
                        SwitchDefaults switchDefaults2 = SwitchDefaults.INSTANCE;
                        Color.Companion companion3 = Color.INSTANCE;
                        long jM5903getWhite0d7_KjU2 = companion3.m5903getWhite0d7_KjU();
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        int i21 = MaterialTheme.$stable;
                        long primary2 = materialTheme2.getColorScheme(composerStartRestartGroup, i21).getPrimary();
                        long onBackground2 = materialTheme2.getColorScheme(composerStartRestartGroup, i21).getOnBackground();
                        i15 = 256;
                        switchColorsM3737colorsV1nXRL4 = switchDefaults2.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU2, primary2, 0L, 0L, materialTheme2.getColorScheme(composerStartRestartGroup, i21).getOnBackground(), companion3.m5901getTransparent0d7_KjU(), onBackground2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                        composer3 = composerStartRestartGroup;
                        i12 &= -3670017;
                        modifier5 = modifier4;
                        function6 = function5;
                    } else {
                        composer3 = composerStartRestartGroup;
                        i15 = 256;
                        modifier5 = modifier4;
                        function6 = function5;
                        switchColorsM3737colorsV1nXRL4 = switchColors2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i13 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i11 & 32) != 0) {
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        i12 &= -458753;
                    } else {
                        bodyLarge = textStyle2;
                    }
                    if ((i11 & 64) != 0) {
                        SwitchDefaults switchDefaults3 = SwitchDefaults.INSTANCE;
                        Color.Companion companion4 = Color.INSTANCE;
                        long jM5903getWhite0d7_KjU3 = companion4.m5903getWhite0d7_KjU();
                        MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                        int i22 = MaterialTheme.$stable;
                        long primary3 = materialTheme3.getColorScheme(composerStartRestartGroup, i22).getPrimary();
                        long onBackground3 = materialTheme3.getColorScheme(composerStartRestartGroup, i22).getOnBackground();
                        i15 = 256;
                        switchColorsM3737colorsV1nXRL4 = switchDefaults3.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU3, primary3, 0L, 0L, materialTheme3.getColorScheme(composerStartRestartGroup, i22).getOnBackground(), companion4.m5901getTransparent0d7_KjU(), onBackground3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                        composer3 = composerStartRestartGroup;
                        i12 &= -3670017;
                        modifier5 = modifier4;
                        function6 = function5;
                    } else {
                        composer3 = composerStartRestartGroup;
                        i15 = 256;
                        modifier5 = modifier4;
                        function6 = function5;
                        switchColorsM3737colorsV1nXRL4 = switchColors2;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-670745967, i12, -1, "cu.z17.views.textToggle.Z17TextToggle (Z17TextToggle.kt:33)");
                }
                if ((i12 & 896) == i15) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = z12 | ((i12 & 112) == 32);
                objRememberedValue = composer3.rememberedValue();
                if (z13) {
                    objRememberedValue = new a() { // from class: s9.a
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new a() { // from class: s9.a
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (a) objRememberedValue, 7, null);
                Modifier modifier7 = modifier5;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composer3, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1238clickableXHw0xAI$default2);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
                if (!r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion5.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if (function6 == null) {
                    composer3.startReplaceGroup(-337299193);
                } else {
                    composer3.startReplaceGroup(-337299192);
                    function6.invoke(composer3, Integer.valueOf((i12 >> 9) & 14));
                }
                composer3.endReplaceGroup();
                TextStyle textStyle5 = bodyLarge;
                Composer composer5 = composer3;
                String str6 = str4;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str6, textStyle5, 0L, 0, 0, composer5, (i12 >> 9) & 1008, 56);
                SwitchColors switchColors5 = switchColorsM3737colorsV1nXRL4;
                Function2 function8 = function6;
                SwitchKt.Switch(z10, onChange, null, null, false, switchColors5, null, composer5, (i12 >> 3) & 458878, 92);
                composer5.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composer5;
                function4 = function8;
                textStyle3 = textStyle5;
                modifier3 = modifier7;
                switchColors3 = switchColors5;
                str3 = str6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                switchColors3 = switchColors2;
                function4 = function3;
                str3 = str2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s9.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TextToggleKt.Z17TextToggle$lambda$4(modifier3, z10, onChange, function4, str3, textStyle3, switchColors3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        function3 = function2;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                    }
                    i12 |= i19;
                } else {
                    textStyle2 = textStyle;
                }
                i12 |= i19;
            } else {
                textStyle2 = textStyle;
            }
            if ((i10 & 1572864) == 0) {
                switchColors2 = switchColors;
                if ((i11 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            } else {
                switchColors2 = switchColors;
            }
            if ((i12 & 599187) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i13 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i11 & 32) != 0) {
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        i12 &= -458753;
                    } else {
                        bodyLarge = textStyle2;
                    }
                    if ((i11 & 64) != 0) {
                        SwitchDefaults switchDefaults4 = SwitchDefaults.INSTANCE;
                        Color.Companion companion6 = Color.INSTANCE;
                        long jM5903getWhite0d7_KjU4 = companion6.m5903getWhite0d7_KjU();
                        MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                        int i23 = MaterialTheme.$stable;
                        long primary4 = materialTheme4.getColorScheme(composerStartRestartGroup, i23).getPrimary();
                        long onBackground4 = materialTheme4.getColorScheme(composerStartRestartGroup, i23).getOnBackground();
                        i15 = 256;
                        switchColorsM3737colorsV1nXRL4 = switchDefaults4.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU4, primary4, 0L, 0L, materialTheme4.getColorScheme(composerStartRestartGroup, i23).getOnBackground(), companion6.m5901getTransparent0d7_KjU(), onBackground4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                        composer3 = composerStartRestartGroup;
                        i12 &= -3670017;
                        modifier5 = modifier4;
                        function6 = function5;
                    } else {
                        composer3 = composerStartRestartGroup;
                        i15 = 256;
                        modifier5 = modifier4;
                        function6 = function5;
                        switchColorsM3737colorsV1nXRL4 = switchColors2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i18 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i13 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i11 & 32) != 0) {
                        bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        i12 &= -458753;
                    } else {
                        bodyLarge = textStyle2;
                    }
                    if ((i11 & 64) != 0) {
                        SwitchDefaults switchDefaults5 = SwitchDefaults.INSTANCE;
                        Color.Companion companion7 = Color.INSTANCE;
                        long jM5903getWhite0d7_KjU5 = companion7.m5903getWhite0d7_KjU();
                        MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                        int i24 = MaterialTheme.$stable;
                        long primary5 = materialTheme5.getColorScheme(composerStartRestartGroup, i24).getPrimary();
                        long onBackground5 = materialTheme5.getColorScheme(composerStartRestartGroup, i24).getOnBackground();
                        i15 = 256;
                        switchColorsM3737colorsV1nXRL4 = switchDefaults5.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU5, primary5, 0L, 0L, materialTheme5.getColorScheme(composerStartRestartGroup, i24).getOnBackground(), companion7.m5901getTransparent0d7_KjU(), onBackground5, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                        composer3 = composerStartRestartGroup;
                        i12 &= -3670017;
                        modifier5 = modifier4;
                        function6 = function5;
                    } else {
                        composer3 = composerStartRestartGroup;
                        i15 = 256;
                        modifier5 = modifier4;
                        function6 = function5;
                        switchColorsM3737colorsV1nXRL4 = switchColors2;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-670745967, i12, -1, "cu.z17.views.textToggle.Z17TextToggle (Z17TextToggle.kt:33)");
                }
                if ((i12 & 896) == i15) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = z12 | ((i12 & 112) == 32);
                objRememberedValue = composer3.rememberedValue();
                if (z13) {
                    objRememberedValue = new a() { // from class: s9.a
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new a() { // from class: s9.a
                        @Override // lb.a
                        public final Object invoke() {
                            return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1238clickableXHw0xAI$default3 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (a) objRememberedValue, 7, null);
                Modifier modifier8 = modifier5;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composer3, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1238clickableXHw0xAI$default3);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                constructor = companion8.getConstructor();
                if (!r.a(composer3.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                if (function6 == null) {
                    composer3.startReplaceGroup(-337299193);
                } else {
                    composer3.startReplaceGroup(-337299192);
                    function6.invoke(composer3, Integer.valueOf((i12 >> 9) & 14));
                }
                composer3.endReplaceGroup();
                TextStyle textStyle6 = bodyLarge;
                Composer composer6 = composer3;
                String str7 = str4;
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str7, textStyle6, 0L, 0, 0, composer6, (i12 >> 9) & 1008, 56);
                SwitchColors switchColors6 = switchColorsM3737colorsV1nXRL4;
                Function2 function9 = function6;
                SwitchKt.Switch(z10, onChange, null, null, false, switchColors6, null, composer6, (i12 >> 3) & 458878, 92);
                composer6.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composer6;
                function4 = function9;
                textStyle3 = textStyle6;
                modifier3 = modifier8;
                switchColors3 = switchColors6;
                str3 = str7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                switchColors3 = switchColors2;
                function4 = function3;
                str3 = str2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s9.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TextToggleKt.Z17TextToggle$lambda$4(modifier3, z10, onChange, function4, str3, textStyle3, switchColors3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        str2 = str;
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                }
                i12 |= i19;
            } else {
                textStyle2 = textStyle;
            }
            i12 |= i19;
        } else {
            textStyle2 = textStyle;
        }
        if ((i10 & 1572864) == 0) {
            switchColors2 = switchColors;
            if ((i11 & 64) == 0) {
                i16 = 524288;
            } else {
                i16 = 524288;
            }
            i12 |= i16;
        } else {
            switchColors2 = switchColors;
        }
        if ((i12 & 599187) != 599186) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i13 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i11 & 32) != 0) {
                    bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    i12 &= -458753;
                } else {
                    bodyLarge = textStyle2;
                }
                if ((i11 & 64) != 0) {
                    SwitchDefaults switchDefaults6 = SwitchDefaults.INSTANCE;
                    Color.Companion companion9 = Color.INSTANCE;
                    long jM5903getWhite0d7_KjU6 = companion9.m5903getWhite0d7_KjU();
                    MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                    int i25 = MaterialTheme.$stable;
                    long primary6 = materialTheme6.getColorScheme(composerStartRestartGroup, i25).getPrimary();
                    long onBackground6 = materialTheme6.getColorScheme(composerStartRestartGroup, i25).getOnBackground();
                    i15 = 256;
                    switchColorsM3737colorsV1nXRL4 = switchDefaults6.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU6, primary6, 0L, 0L, materialTheme6.getColorScheme(composerStartRestartGroup, i25).getOnBackground(), companion9.m5901getTransparent0d7_KjU(), onBackground6, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                    composer3 = composerStartRestartGroup;
                    i12 &= -3670017;
                    modifier5 = modifier4;
                    function6 = function5;
                } else {
                    composer3 = composerStartRestartGroup;
                    i15 = 256;
                    modifier5 = modifier4;
                    function6 = function5;
                    switchColorsM3737colorsV1nXRL4 = switchColors2;
                }
            } else {
                if (i17 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i18 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i13 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i11 & 32) != 0) {
                    bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    i12 &= -458753;
                } else {
                    bodyLarge = textStyle2;
                }
                if ((i11 & 64) != 0) {
                    SwitchDefaults switchDefaults7 = SwitchDefaults.INSTANCE;
                    Color.Companion companion10 = Color.INSTANCE;
                    long jM5903getWhite0d7_KjU7 = companion10.m5903getWhite0d7_KjU();
                    MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                    int i26 = MaterialTheme.$stable;
                    long primary7 = materialTheme7.getColorScheme(composerStartRestartGroup, i26).getPrimary();
                    long onBackground7 = materialTheme7.getColorScheme(composerStartRestartGroup, i26).getOnBackground();
                    i15 = 256;
                    switchColorsM3737colorsV1nXRL4 = switchDefaults7.m3737colorsV1nXRL4(jM5903getWhite0d7_KjU7, primary7, 0L, 0L, materialTheme7.getColorScheme(composerStartRestartGroup, i26).getOnBackground(), companion10.m5901getTransparent0d7_KjU(), onBackground7, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196614, SwitchDefaults.$stable << 18, 65420);
                    composer3 = composerStartRestartGroup;
                    i12 &= -3670017;
                    modifier5 = modifier4;
                    function6 = function5;
                } else {
                    composer3 = composerStartRestartGroup;
                    i15 = 256;
                    modifier5 = modifier4;
                    function6 = function5;
                    switchColorsM3737colorsV1nXRL4 = switchColors2;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-670745967, i12, -1, "cu.z17.views.textToggle.Z17TextToggle (Z17TextToggle.kt:33)");
            }
            if ((i12 & 896) == i15) {
                z12 = true;
            } else {
                z12 = false;
            }
            z13 = z12 | ((i12 & 112) == 32);
            objRememberedValue = composer3.rememberedValue();
            if (z13) {
                objRememberedValue = new a() { // from class: s9.a
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new a() { // from class: s9.a
                    @Override // lb.a
                    public final Object invoke() {
                        return Z17TextToggleKt.Z17TextToggle$lambda$1$lambda$0(onChange, z10);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1238clickableXHw0xAI$default4 = ClickableKt.m1238clickableXHw0xAI$default(modifier5, false, null, null, (a) objRememberedValue, 7, null);
            Modifier modifier9 = modifier5;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), composer3, 54);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierM1238clickableXHw0xAI$default4);
            ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
            constructor = companion11.getConstructor();
            if (!r.a(composer3.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composer3);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy4, companion11.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion11.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion11.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion11.getSetModifier());
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            if (function6 == null) {
                composer3.startReplaceGroup(-337299193);
            } else {
                composer3.startReplaceGroup(-337299192);
                function6.invoke(composer3, Integer.valueOf((i12 >> 9) & 14));
            }
            composer3.endReplaceGroup();
            TextStyle textStyle7 = bodyLarge;
            Composer composer7 = composer3;
            String str8 = str4;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(e3.a(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8823constructorimpl(10), 0.0f, 2, null), str8, textStyle7, 0L, 0, 0, composer7, (i12 >> 9) & 1008, 56);
            SwitchColors switchColors7 = switchColorsM3737colorsV1nXRL4;
            Function2 function10 = function6;
            SwitchKt.Switch(z10, onChange, null, null, false, switchColors7, null, composer7, (i12 >> 3) & 458878, 92);
            composer7.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composer7;
            function4 = function10;
            textStyle3 = textStyle7;
            modifier3 = modifier9;
            switchColors3 = switchColors7;
            str3 = str8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            switchColors3 = switchColors2;
            function4 = function3;
            str3 = str2;
            textStyle3 = textStyle2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: s9.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17TextToggleKt.Z17TextToggle$lambda$4(modifier3, z10, onChange, function4, str3, textStyle3, switchColors3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TextToggle$lambda$1$lambda$0(Function1 function1, boolean z10) {
        function1.invoke(Boolean.valueOf(!z10));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TextToggle$lambda$4(Modifier modifier, boolean z10, Function1 function1, Function2 function2, String str, TextStyle textStyle, SwitchColors switchColors, int i10, int i11, Composer composer, int i12) {
        Z17TextToggle(modifier, z10, function1, function2, str, textStyle, switchColors, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
