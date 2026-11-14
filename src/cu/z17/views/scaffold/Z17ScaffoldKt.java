package cu.z17.views.scaffold;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¸\u0001\u0010\u0016\u001a\u00020\u00022\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\u00032\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0002\b\u00032\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "topBar", "", "noToolbar", "isNestedActive", "showFloatingActionBtn", "Lkotlin/Function0;", "floatingActionButton", "Landroidx/compose/foundation/layout/ColumnScope;", "drawerContent", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Landroidx/compose/material/ScaffoldState;", "scaffoldState", "bottomBar", "Landroidx/compose/ui/Modifier;", "content", "Z17BaseScaffold-ueL0Wzs", "(Lkotlin/jvm/functions/Function3;ZZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JLandroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Z17BaseScaffold", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17ScaffoldKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0130  */
    /* JADX WARN: Code duplicated, block: B:102:0x013a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0156 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0158  */
    /* JADX WARN: Code duplicated, block: B:112:0x0161  */
    /* JADX WARN: Code duplicated, block: B:114:0x0164  */
    /* JADX WARN: Code duplicated, block: B:115:0x016b  */
    /* JADX WARN: Code duplicated, block: B:117:0x016f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x0184  */
    /* JADX WARN: Code duplicated, block: B:124:0x018f  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:130:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:133:0x01de  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:137:0x0201  */
    /* JADX WARN: Code duplicated, block: B:139:0x020f  */
    /* JADX WARN: Code duplicated, block: B:142:0x024f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0257  */
    /* JADX WARN: Code duplicated, block: B:145:0x0262  */
    /* JADX WARN: Code duplicated, block: B:147:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:153:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:157:0x0355  */
    /* JADX WARN: Code duplicated, block: B:159:0x0360  */
    /* JADX WARN: Code duplicated, block: B:162:0x0373  */
    /* JADX WARN: Code duplicated, block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x009a  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00de  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:84:0x0100  */
    /* JADX WARN: Code duplicated, block: B:85:0x0103  */
    /* JADX WARN: Code duplicated, block: B:89:0x010d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x0116  */
    /* JADX WARN: Code duplicated, block: B:96:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x0127  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Z17BaseScaffold-ueL0Wzs, reason: not valid java name */
    public static final void m10301Z17BaseScaffoldueL0Wzs(Function3 function3, final boolean z10, final boolean z11, boolean z12, Function2 function2, Function3 function4, long j10, final ScaffoldState scaffoldState, Function2 function5, final Function3 content, Composer composer, final int i10, final int i11) {
        Function3 lambda$1574519439$views_release;
        int i12;
        final boolean z13;
        int i13;
        int i14;
        int i15;
        Function3 function6;
        int i16;
        long background;
        int i17;
        int i18;
        boolean z14;
        Composer composer2;
        final Function2 function7;
        final Function2 function8;
        final Function3 function9;
        final boolean z15;
        final long j11;
        final Function3 function10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 lambda$1427295215$views_release;
        Function2 function11;
        final Function2 function12;
        int currentCompositeKeyHash;
        a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        Modifier modifierNestedScroll$default;
        int i19;
        final TopAppBarScrollBehavior topAppBarScrollBehaviorEnterAlwaysScrollBehavior;
        Function3 function13;
        Function2 lambda$311076088$views_release;
        boolean z16;
        Function2 function14;
        Modifier modifierNestedScroll$default2;
        int i20;
        int i21;
        int i22;
        y.i(scaffoldState, "scaffoldState");
        y.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-929509013);
        int i23 = i11 & 1;
        if (i23 != 0) {
            i12 = i10 | 6;
            lambda$1574519439$views_release = function3;
        } else if ((i10 & 6) == 0) {
            lambda$1574519439$views_release = function3;
            i12 = (composerStartRestartGroup.changedInstance(lambda$1574519439$views_release) ? 4 : 2) | i10;
        } else {
            lambda$1574519439$views_release = function3;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        int i24 = i11 & 8;
        if (i24 == 0) {
            if ((i10 & 3072) == 0) {
                z13 = z12;
                i12 |= composerStartRestartGroup.changed(z13) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                i15 = i11 & 32;
                if (i15 != 0) {
                    i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function4;
                } else {
                    function6 = function4;
                    if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i16 = 131072;
                        } else {
                            i16 = 65536;
                        }
                        i12 |= i16;
                    }
                }
                if ((i10 & 1572864) == 0) {
                    background = j10;
                    if ((i11 & 64) == 0 || !composerStartRestartGroup.changed(background)) {
                        i22 = 524288;
                    } else {
                        i22 = 1048576;
                    }
                    i12 |= i22;
                } else {
                    background = j10;
                }
                if ((i10 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(scaffoldState)) {
                        i21 = 8388608;
                    } else {
                        i21 = 4194304;
                    }
                    i12 |= i21;
                }
                i17 = i11 & 256;
                if (i17 != 0) {
                    if ((i10 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i18 = 67108864;
                        } else {
                            i18 = 33554432;
                        }
                        i12 |= i18;
                    }
                    if ((i10 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i20 = 268435456;
                        }
                        i12 |= i20;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i23 != 0) {
                                lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                            }
                            if (i24 != 0) {
                                z13 = true;
                            }
                            if (i13 != 0) {
                                lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                            } else {
                                lambda$1427295215$views_release = function2;
                            }
                            if (i15 != 0) {
                                function6 = null;
                            }
                            if ((i11 & 64) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i12 &= -3670017;
                            }
                            if (i17 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            function12 = lambda$1427295215$views_release;
                            function9 = lambda$1574519439$views_release;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i11 & 64) != 0) {
                                i12 &= -3670017;
                            }
                            function11 = function5;
                            background = background;
                            function9 = lambda$1574519439$views_release;
                            i12 = i12;
                            z13 = z13;
                            function6 = function6;
                            function12 = function2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        constructor = companion2.getConstructor();
                        if (!r.a(composerStartRestartGroup.getApplier())) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        modifierNestedScroll$default = companion;
                        i19 = i12;
                        topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(866438972);
                            if (z11) {
                                modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                            } else {
                                modifierNestedScroll$default2 = modifierNestedScroll$default;
                            }
                            z16 = z13;
                            composer2 = composerStartRestartGroup;
                            function13 = function6;
                            function14 = function12;
                            ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                            composer2.endReplaceGroup();
                        } else {
                            final boolean z17 = z13;
                            final Function2 function15 = function12;
                            function13 = function6;
                            composerStartRestartGroup.startReplaceGroup(867360137);
                            if (z11) {
                                modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                            }
                            long background2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            if (function11 == null) {
                                lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                            } else {
                                lambda$311076088$views_release = function11;
                            }
                            composer2 = composerStartRestartGroup;
                            z16 = z17;
                            Modifier modifier = modifierNestedScroll$default;
                            function14 = function15;
                            ScaffoldKt.m2720Scaffold27mzLpw(modifier, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z17, function15, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background2, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                            composer2.endReplaceGroup();
                        }
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z15 = z16;
                        function7 = function14;
                        function10 = function13;
                        j11 = background;
                        function8 = function11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function2;
                        function8 = function5;
                        function9 = lambda$1574519439$views_release;
                        z15 = z13;
                        j11 = background;
                        function10 = function6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 100663296;
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i12 |= i20;
                }
                if ((i12 & 306783379) != 306783378) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    } else {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                    }
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    constructor = companion4.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    modifierNestedScroll$default = companion3;
                    i19 = i12;
                    topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(866438972);
                        if (z11) {
                            modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        } else {
                            modifierNestedScroll$default2 = modifierNestedScroll$default;
                        }
                        z16 = z13;
                        composer2 = composerStartRestartGroup;
                        function13 = function6;
                        function14 = function12;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                        composer2.endReplaceGroup();
                    } else {
                        final boolean z18 = z13;
                        final Function2 function16 = function12;
                        function13 = function6;
                        composerStartRestartGroup.startReplaceGroup(867360137);
                        if (z11) {
                            modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        }
                        long background3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        if (function11 == null) {
                            lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                        } else {
                            lambda$311076088$views_release = function11;
                        }
                        composer2 = composerStartRestartGroup;
                        z16 = z18;
                        Modifier modifier2 = modifierNestedScroll$default;
                        function14 = function16;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifier2, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z18, function16, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background3, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                        composer2.endReplaceGroup();
                    }
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z16;
                    function7 = function14;
                    function10 = function13;
                    j11 = background;
                    function8 = function11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function2;
                    function8 = function5;
                    function9 = lambda$1574519439$views_release;
                    z15 = z13;
                    j11 = background;
                    function10 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            i15 = i11 & 32;
            if (i15 != 0) {
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function4;
            } else {
                function6 = function4;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
            }
            if ((i10 & 1572864) == 0) {
                background = j10;
                if ((i11 & 64) == 0) {
                    i22 = 524288;
                } else {
                    i22 = 524288;
                }
                i12 |= i22;
            } else {
                background = j10;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(scaffoldState)) {
                    i21 = 8388608;
                } else {
                    i21 = 4194304;
                }
                i12 |= i21;
            }
            i17 = i11 & 256;
            if (i17 != 0) {
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i12 |= i18;
                }
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i12 |= i20;
                }
                if ((i12 & 306783379) != 306783378) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    } else {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                    }
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    constructor = companion6.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion6.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion6.getSetModifier());
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    modifierNestedScroll$default = companion5;
                    i19 = i12;
                    topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(866438972);
                        if (z11) {
                            modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        } else {
                            modifierNestedScroll$default2 = modifierNestedScroll$default;
                        }
                        z16 = z13;
                        composer2 = composerStartRestartGroup;
                        function13 = function6;
                        function14 = function12;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                        composer2.endReplaceGroup();
                    } else {
                        final boolean z19 = z13;
                        final Function2 function17 = function12;
                        function13 = function6;
                        composerStartRestartGroup.startReplaceGroup(867360137);
                        if (z11) {
                            modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        }
                        long background4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        if (function11 == null) {
                            lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                        } else {
                            lambda$311076088$views_release = function11;
                        }
                        composer2 = composerStartRestartGroup;
                        z16 = z19;
                        Modifier modifier3 = modifierNestedScroll$default;
                        function14 = function17;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifier3, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z19, function17, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background4, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                        composer2.endReplaceGroup();
                    }
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z16;
                    function7 = function14;
                    function10 = function13;
                    j11 = background;
                    function8 = function11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function2;
                    function8 = function5;
                    function9 = lambda$1574519439$views_release;
                    z15 = z13;
                    j11 = background;
                    function10 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 100663296;
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i20 = 268435456;
                }
                i12 |= i20;
            }
            if ((i12 & 306783379) != 306783378) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                } else {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                }
                Modifier.Companion companion7 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion7);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                constructor = companion8.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion8.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion8.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion8.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                modifierNestedScroll$default = companion7;
                i19 = i12;
                topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(866438972);
                    if (z11) {
                        modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    } else {
                        modifierNestedScroll$default2 = modifierNestedScroll$default;
                    }
                    z16 = z13;
                    composer2 = composerStartRestartGroup;
                    function13 = function6;
                    function14 = function12;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                    composer2.endReplaceGroup();
                } else {
                    final boolean z110 = z13;
                    final Function2 function18 = function12;
                    function13 = function6;
                    composerStartRestartGroup.startReplaceGroup(867360137);
                    if (z11) {
                        modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    }
                    long background5 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    if (function11 == null) {
                        lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                    } else {
                        lambda$311076088$views_release = function11;
                    }
                    composer2 = composerStartRestartGroup;
                    z16 = z110;
                    Modifier modifier4 = modifierNestedScroll$default;
                    function14 = function18;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifier4, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z110, function18, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background5, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z16;
                function7 = function14;
                function10 = function13;
                j11 = background;
                function8 = function11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function2;
                function8 = function5;
                function9 = lambda$1574519439$views_release;
                z15 = z13;
                j11 = background;
                function10 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        z13 = z12;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            i15 = i11 & 32;
            if (i15 != 0) {
                i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function4;
            } else {
                function6 = function4;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i16 = 131072;
                    } else {
                        i16 = 65536;
                    }
                    i12 |= i16;
                }
            }
            if ((i10 & 1572864) == 0) {
                background = j10;
                if ((i11 & 64) == 0) {
                    i22 = 524288;
                } else {
                    i22 = 524288;
                }
                i12 |= i22;
            } else {
                background = j10;
            }
            if ((i10 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(scaffoldState)) {
                    i21 = 8388608;
                } else {
                    i21 = 4194304;
                }
                i12 |= i21;
            }
            i17 = i11 & 256;
            if (i17 != 0) {
                if ((i10 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i12 |= i18;
                }
                if ((i10 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i12 |= i20;
                }
                if ((i12 & 306783379) != 306783378) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    } else {
                        if (i23 != 0) {
                            lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                        }
                        if (i24 != 0) {
                            z13 = true;
                        }
                        if (i13 != 0) {
                            lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                        } else {
                            lambda$1427295215$views_release = function2;
                        }
                        if (i15 != 0) {
                            function6 = null;
                        }
                        if ((i11 & 64) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i12 &= -3670017;
                        }
                        if (i17 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        function12 = lambda$1427295215$views_release;
                        function9 = lambda$1574519439$views_release;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                    }
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion9);
                    ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                    constructor = companion10.getConstructor();
                    if (!r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, companion10.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap5, companion10.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier5, companion10.getSetModifier());
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    modifierNestedScroll$default = companion9;
                    i19 = i12;
                    topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(866438972);
                        if (z11) {
                            modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        } else {
                            modifierNestedScroll$default2 = modifierNestedScroll$default;
                        }
                        z16 = z13;
                        composer2 = composerStartRestartGroup;
                        function13 = function6;
                        function14 = function12;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                        composer2.endReplaceGroup();
                    } else {
                        final boolean z111 = z13;
                        final Function2 function19 = function12;
                        function13 = function6;
                        composerStartRestartGroup.startReplaceGroup(867360137);
                        if (z11) {
                            modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        }
                        long background6 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        if (function11 == null) {
                            lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                        } else {
                            lambda$311076088$views_release = function11;
                        }
                        composer2 = composerStartRestartGroup;
                        z16 = z111;
                        Modifier modifier5 = modifierNestedScroll$default;
                        function14 = function19;
                        ScaffoldKt.m2720Scaffold27mzLpw(modifier5, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z111, function19, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background6, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                        composer2.endReplaceGroup();
                    }
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z15 = z16;
                    function7 = function14;
                    function10 = function13;
                    j11 = background;
                    function8 = function11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function2;
                    function8 = function5;
                    function9 = lambda$1574519439$views_release;
                    z15 = z13;
                    j11 = background;
                    function10 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 100663296;
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i20 = 268435456;
                }
                i12 |= i20;
            }
            if ((i12 & 306783379) != 306783378) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                } else {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                }
                Modifier.Companion companion11 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion11);
                ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                constructor = companion12.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, companion12.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap6, companion12.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier6, companion12.getSetModifier());
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                modifierNestedScroll$default = companion11;
                i19 = i12;
                topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(866438972);
                    if (z11) {
                        modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    } else {
                        modifierNestedScroll$default2 = modifierNestedScroll$default;
                    }
                    z16 = z13;
                    composer2 = composerStartRestartGroup;
                    function13 = function6;
                    function14 = function12;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                    composer2.endReplaceGroup();
                } else {
                    final boolean z112 = z13;
                    final Function2 function110 = function12;
                    function13 = function6;
                    composerStartRestartGroup.startReplaceGroup(867360137);
                    if (z11) {
                        modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    }
                    long background7 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    if (function11 == null) {
                        lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                    } else {
                        lambda$311076088$views_release = function11;
                    }
                    composer2 = composerStartRestartGroup;
                    z16 = z112;
                    Modifier modifier6 = modifierNestedScroll$default;
                    function14 = function110;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifier6, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z112, function110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background7, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z16;
                function7 = function14;
                function10 = function13;
                j11 = background;
                function8 = function11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function2;
                function8 = function5;
                function9 = lambda$1574519439$views_release;
                z15 = z13;
                j11 = background;
                function10 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        i15 = i11 & 32;
        if (i15 != 0) {
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function4;
        } else {
            function6 = function4;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i16 = 131072;
                } else {
                    i16 = 65536;
                }
                i12 |= i16;
            }
        }
        if ((i10 & 1572864) == 0) {
            background = j10;
            if ((i11 & 64) == 0) {
                i22 = 524288;
            } else {
                i22 = 524288;
            }
            i12 |= i22;
        } else {
            background = j10;
        }
        if ((i10 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(scaffoldState)) {
                i21 = 8388608;
            } else {
                i21 = 4194304;
            }
            i12 |= i21;
        }
        i17 = i11 & 256;
        if (i17 != 0) {
            if ((i10 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i12 |= i18;
            }
            if ((i10 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i20 = 268435456;
                }
                i12 |= i20;
            }
            if ((i12 & 306783379) != 306783378) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                } else {
                    if (i23 != 0) {
                        lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                    }
                    if (i24 != 0) {
                        z13 = true;
                    }
                    if (i13 != 0) {
                        lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                    } else {
                        lambda$1427295215$views_release = function2;
                    }
                    if (i15 != 0) {
                        function6 = null;
                    }
                    if ((i11 & 64) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i12 &= -3670017;
                    }
                    if (i17 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    function12 = lambda$1427295215$views_release;
                    function9 = lambda$1574519439$views_release;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
                }
                Modifier.Companion companion13 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion13);
                ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                constructor = companion14.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, companion14.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion14.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion14.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion14.getSetModifier());
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                modifierNestedScroll$default = companion13;
                i19 = i12;
                topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(866438972);
                    if (z11) {
                        modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    } else {
                        modifierNestedScroll$default2 = modifierNestedScroll$default;
                    }
                    z16 = z13;
                    composer2 = composerStartRestartGroup;
                    function13 = function6;
                    function14 = function12;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                    composer2.endReplaceGroup();
                } else {
                    final boolean z113 = z13;
                    final Function2 function111 = function12;
                    function13 = function6;
                    composerStartRestartGroup.startReplaceGroup(867360137);
                    if (z11) {
                        modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    }
                    long background8 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    if (function11 == null) {
                        lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                    } else {
                        lambda$311076088$views_release = function11;
                    }
                    composer2 = composerStartRestartGroup;
                    z16 = z113;
                    Modifier modifier7 = modifierNestedScroll$default;
                    function14 = function111;
                    ScaffoldKt.m2720Scaffold27mzLpw(modifier7, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z113, function111, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background8, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z15 = z16;
                function7 = function14;
                function10 = function13;
                j11 = background;
                function8 = function11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function2;
                function8 = function5;
                function9 = lambda$1574519439$views_release;
                z15 = z13;
                j11 = background;
                function10 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 100663296;
        if ((i10 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i20 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i20 = 268435456;
            }
            i12 |= i20;
        }
        if ((i12 & 306783379) != 306783378) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z14, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i23 != 0) {
                    lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                }
                if (i24 != 0) {
                    z13 = true;
                }
                if (i13 != 0) {
                    lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                } else {
                    lambda$1427295215$views_release = function2;
                }
                if (i15 != 0) {
                    function6 = null;
                }
                if ((i11 & 64) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i12 &= -3670017;
                }
                if (i17 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                function12 = lambda$1427295215$views_release;
                function9 = lambda$1574519439$views_release;
            } else {
                if (i23 != 0) {
                    lambda$1574519439$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1574519439$views_release();
                }
                if (i24 != 0) {
                    z13 = true;
                }
                if (i13 != 0) {
                    lambda$1427295215$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$1427295215$views_release();
                } else {
                    lambda$1427295215$views_release = function2;
                }
                if (i15 != 0) {
                    function6 = null;
                }
                if ((i11 & 64) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i12 &= -3670017;
                }
                if (i17 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                function12 = lambda$1427295215$views_release;
                function9 = lambda$1574519439$views_release;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-929509013, i12, -1, "cu.z17.views.scaffold.Z17BaseScaffold (Z17Scaffold.kt:34)");
            }
            Modifier.Companion companion15 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion15);
            ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
            constructor = companion16.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, companion16.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap8, companion16.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion16.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier8, companion16.getSetModifier());
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            modifierNestedScroll$default = companion15;
            i19 = i12;
            topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7), null, null, null, composerStartRestartGroup, TopAppBarDefaults.$stable << 12, 14);
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(866438972);
                if (z11) {
                    modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                } else {
                    modifierNestedScroll$default2 = modifierNestedScroll$default;
                }
                z16 = z13;
                composer2 = composerStartRestartGroup;
                function13 = function6;
                function14 = function12;
                ScaffoldKt.m2720Scaffold27mzLpw(modifierNestedScroll$default2, scaffoldState, null, null, null, ComposableLambdaKt.rememberComposableLambda(-112252766, true, new Function2() { // from class: p9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(z13, function12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(-1939234708, true, new Function3() { // from class: p9.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805502976 | ((i19 << 9) & 234881024), ((i19 >> 3) & 458752) | 12582912, 93404);
                composer2.endReplaceGroup();
            } else {
                final boolean z114 = z13;
                final Function2 function112 = function12;
                function13 = function6;
                composerStartRestartGroup.startReplaceGroup(867360137);
                if (z11) {
                    modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierNestedScroll$default, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                }
                long background9 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                if (function11 == null) {
                    lambda$311076088$views_release = ComposableSingletons$Z17ScaffoldKt.INSTANCE.getLambda$311076088$views_release();
                } else {
                    lambda$311076088$views_release = function11;
                }
                composer2 = composerStartRestartGroup;
                z16 = z114;
                Modifier modifier8 = modifierNestedScroll$default;
                function14 = function112;
                ScaffoldKt.m2720Scaffold27mzLpw(modifier8, scaffoldState, ComposableLambdaKt.rememberComposableLambda(-1095737060, true, new Function2() { // from class: p9.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(function9, topAppBarScrollBehaviorEnterAlwaysScrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), lambda$311076088$views_release, null, ComposableLambdaKt.rememberComposableLambda(1487263545, true, new Function2() { // from class: p9.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(z114, function112, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0, false, function13, true, null, 0.0f, background9, 0L, 0L, background, 0L, ComposableLambdaKt.rememberComposableLambda(1185921411, true, new Function3() { // from class: p9.j
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i19 >> 18) & 112) | 805503360 | (234881024 & (i19 << 9)), ((i19 >> 3) & 458752) | 12582912, 93392);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z15 = z16;
            function7 = function14;
            function10 = function13;
            j11 = background;
            function8 = function11;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function7 = function2;
            function8 = function5;
            function9 = lambda$1574519439$views_release;
            z15 = z13;
            j11 = background;
            function10 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: p9.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$8(function9, z10, z11, z15, function7, function10, j11, scaffoldState, function8, content, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1(boolean z10, final Function2 function2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112252766, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous> (Z17Scaffold.kt:43)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(386199754, true, new Function3() { // from class: p9.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1$lambda$0(function2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$1$lambda$0(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(386199754, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous>.<anonymous> (Z17Scaffold.kt:48)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$2(Function3 function3, PaddingValues it, Composer composer, int i10) {
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1939234708, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous> (Z17Scaffold.kt:56)");
            }
            function3.invoke(WindowInsetsPaddingKt.consumeWindowInsets(PaddingKt.padding(Modifier.INSTANCE, it), it), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$3(Function3 function3, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1095737060, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous> (Z17Scaffold.kt:65)");
            }
            function3.invoke(topAppBarScrollBehavior, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5(boolean z10, final Function2 function2, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487263545, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous> (Z17Scaffold.kt:71)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1711245665, true, new Function3() { // from class: p9.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Z17ScaffoldKt.Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5$lambda$4(function2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$5$lambda$4(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1711245665, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous>.<anonymous> (Z17Scaffold.kt:76)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$7$lambda$6(Function3 function3, PaddingValues it, Composer composer, int i10) {
        y.i(it, "it");
        if ((i10 & 6) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if (composer.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1185921411, i10, -1, "cu.z17.views.scaffold.Z17BaseScaffold.<anonymous>.<anonymous> (Z17Scaffold.kt:85)");
            }
            function3.invoke(WindowInsetsPaddingKt.consumeWindowInsets(PaddingKt.padding(Modifier.INSTANCE, it), it), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BaseScaffold_ueL0Wzs$lambda$8(Function3 function3, boolean z10, boolean z11, boolean z12, Function2 function2, Function3 function4, long j10, ScaffoldState scaffoldState, Function2 function5, Function3 function6, int i10, int i11, Composer composer, int i12) {
        m10301Z17BaseScaffoldueL0Wzs(function3, z10, z11, z12, function2, function4, j10, scaffoldState, function5, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
