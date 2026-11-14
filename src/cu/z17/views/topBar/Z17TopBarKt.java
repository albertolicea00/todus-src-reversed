package cu.z17.views.topBar;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowBackIosKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009f\u0001\u0010\u0018\u001a\u00020\u00012\u0013\b\u0002\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "title", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "scrollBehavior", "", "showActions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "actions", "showNavigation", "Landroidx/navigation/NavHostController;", "navHostController", "navigationClick", "Landroidx/compose/ui/graphics/vector/ImageVector;", "navigationIcon", "Landroidx/compose/ui/graphics/Color;", "navigationIconColor", "containerColor", "Landroidx/compose/ui/unit/Dp;", "elevation", "Z17TopBar-dW-2gCk", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TopAppBarScrollBehavior;ZLkotlin/jvm/functions/Function3;ZLandroidx/navigation/NavHostController;Llb/a;Landroidx/compose/ui/graphics/vector/ImageVector;JJFLandroidx/compose/runtime/Composer;III)V", "Z17TopBar", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17TopBarKt {
    /* JADX WARN: Code duplicated, block: B:100:0x011c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x0129  */
    /* JADX WARN: Code duplicated, block: B:108:0x0131  */
    /* JADX WARN: Code duplicated, block: B:109:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x013e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0148  */
    /* JADX WARN: Code duplicated, block: B:114:0x014b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0152  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x016b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0174  */
    /* JADX WARN: Code duplicated, block: B:128:0x0187  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x01be  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:156:0x01db  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:161:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:165:0x0201  */
    /* JADX WARN: Code duplicated, block: B:168:0x0207  */
    /* JADX WARN: Code duplicated, block: B:169:0x0210  */
    /* JADX WARN: Code duplicated, block: B:172:0x0216  */
    /* JADX WARN: Code duplicated, block: B:173:0x0227  */
    /* JADX WARN: Code duplicated, block: B:176:0x022f  */
    /* JADX WARN: Code duplicated, block: B:177:0x023f  */
    /* JADX WARN: Code duplicated, block: B:179:0x0243  */
    /* JADX WARN: Code duplicated, block: B:180:0x0253  */
    /* JADX WARN: Code duplicated, block: B:183:0x0266  */
    /* JADX WARN: Code duplicated, block: B:186:0x0281  */
    /* JADX WARN: Code duplicated, block: B:187:0x0284  */
    /* JADX WARN: Code duplicated, block: B:190:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:192:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:195:0x0319  */
    /* JADX WARN: Code duplicated, block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x0100  */
    /* JADX WARN: Code duplicated, block: B:92:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x010b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_]]")
    /* JADX INFO: renamed from: Z17TopBar-dW-2gCk, reason: not valid java name */
    public static final void m10304Z17TopBardW2gCk(Function2 function2, TopAppBarScrollBehavior topAppBarScrollBehavior, boolean z10, Function3 function3, boolean z11, final NavHostController navHostController, a aVar, ImageVector imageVector, long j10, long j11, float f10, Composer composer, final int i10, final int i11, final int i12) {
        Function2 function4;
        int i13;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        int i14;
        boolean z12;
        int i15;
        int i16;
        Function3 function3M10302getLambda$1566705363$views_release;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z13;
        final boolean z14;
        final ImageVector imageVector2;
        final float f11;
        final Function2 function5;
        final TopAppBarScrollBehavior topAppBarScrollBehavior3;
        final boolean z15;
        final Function3 function6;
        final a aVar2;
        final long j12;
        final long j13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 lambda$1069247008$views_release;
        TopAppBarScrollBehavior topAppBarScrollBehavior4;
        boolean z16;
        a aVar3;
        ImageVector arrowBackIos;
        long onBackground;
        long background;
        long j14;
        long j15;
        int i24;
        float fM8823constructorimpl;
        boolean zChangedInstance;
        Object objRememberedValue;
        Function3 function3M10303getLambda$337125894$views_release;
        int i25;
        int i26;
        int i27;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1191839252);
        int i28 = i12 & 1;
        if (i28 != 0) {
            i13 = i10 | 6;
            function4 = function2;
        } else if ((i10 & 6) == 0) {
            function4 = function2;
            i13 = (composerStartRestartGroup.changedInstance(function4) ? 4 : 2) | i10;
        } else {
            function4 = function2;
            i13 = i10;
        }
        int i29 = i12 & 2;
        if (i29 == 0) {
            if ((i10 & 48) == 0) {
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                i13 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 32 : 16;
            }
            i14 = i12 & 4;
            if (i14 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z12 = z10;
                    if (composerStartRestartGroup.changed(z12)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i13 |= i15;
                }
                i16 = i12 & 8;
                if (i16 != 0) {
                    if ((i10 & 3072) == 0) {
                        function3M10302getLambda$1566705363$views_release = function3;
                        if (composerStartRestartGroup.changedInstance(function3M10302getLambda$1566705363$views_release)) {
                            i17 = 2048;
                        } else {
                            i17 = 1024;
                        }
                        i13 |= i17;
                    }
                    i18 = i12 & 16;
                    if (i18 != 0) {
                        if ((i10 & 24576) == 0) {
                            if (composerStartRestartGroup.changed(z11)) {
                                i19 = 16384;
                            } else {
                                i19 = 8192;
                            }
                            i13 |= i19;
                        }
                        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(navHostController)) {
                                i27 = 131072;
                            } else {
                                i27 = 65536;
                            }
                            i13 |= i27;
                        }
                        if ((i10 & 1572864) != 0) {
                            if ((i12 & 64) == 0 || !composerStartRestartGroup.changedInstance(aVar)) {
                                i26 = 524288;
                            } else {
                                i26 = 1048576;
                            }
                            i13 |= i26;
                        }
                        if ((i10 & 12582912) != 0) {
                            i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                        }
                        if ((i10 & 100663296) == 0) {
                            if ((i12 & 256) == 0) {
                                i20 = i28;
                                int i30 = composerStartRestartGroup.changed(j10) ? 67108864 : 33554432;
                                i13 |= i30;
                            } else {
                                i20 = i28;
                            }
                            i13 |= i30;
                        } else {
                            i20 = i28;
                        }
                        if ((i10 & 805306368) != 0) {
                            if ((i12 & 512) == 0 || !composerStartRestartGroup.changed(j11)) {
                                i25 = 268435456;
                            } else {
                                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                            }
                            i13 |= i25;
                        }
                        i21 = i12 & 1024;
                        if (i21 != 0) {
                            i22 = i11 | 6;
                        } else if ((i11 & 6) == 0) {
                            if (composerStartRestartGroup.changed(f10)) {
                                i23 = 4;
                            } else {
                                i23 = 2;
                            }
                            i22 = i11 | i23;
                        } else {
                            i22 = i11;
                        }
                        if ((i13 & 306783379) == 306783378 || (i22 & 3) != 2) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i20 != 0) {
                                    lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                                } else {
                                    lambda$1069247008$views_release = function4;
                                }
                                if (i29 != 0) {
                                    topAppBarScrollBehavior4 = null;
                                } else {
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                                }
                                if (i14 != 0) {
                                    z12 = true;
                                }
                                if (i16 != 0) {
                                    function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                                }
                                if (i18 != 0) {
                                    z16 = true;
                                } else {
                                    z16 = z11;
                                }
                                if ((i12 & 64) != 0) {
                                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new a() { // from class: t9.e
                                            @Override // lb.a
                                            public final Object invoke() {
                                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    aVar3 = (a) objRememberedValue;
                                    i13 &= -3670017;
                                } else {
                                    aVar3 = aVar;
                                }
                                if ((i12 & 128) != 0) {
                                    arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                    i13 &= -29360129;
                                } else {
                                    arrowBackIos = imageVector;
                                }
                                if ((i12 & 256) != 0) {
                                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                    i13 &= -234881025;
                                } else {
                                    onBackground = j10;
                                }
                                if ((i12 & 512) != 0) {
                                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                    i13 &= -1879048193;
                                } else {
                                    background = j11;
                                }
                                if (i21 != 0) {
                                    j14 = background;
                                    j15 = onBackground;
                                    i24 = 1191839252;
                                    fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                    function6 = function3M10302getLambda$1566705363$views_release;
                                } else {
                                    function6 = function3M10302getLambda$1566705363$views_release;
                                    j14 = background;
                                    j15 = onBackground;
                                    i24 = 1191839252;
                                    fM8823constructorimpl = f10;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i12 & 64) != 0) {
                                    i13 &= -3670017;
                                }
                                if ((i12 & 128) != 0) {
                                    i13 &= -29360129;
                                }
                                if ((i12 & 256) != 0) {
                                    i13 &= -234881025;
                                }
                                if ((i12 & 512) != 0) {
                                    i13 &= -1879048193;
                                }
                                z16 = z11;
                                arrowBackIos = imageVector;
                                j15 = j10;
                                j14 = j11;
                                fM8823constructorimpl = f10;
                                lambda$1069247008$views_release = function4;
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                                function6 = function3M10302getLambda$1566705363$views_release;
                                i24 = 1191839252;
                                aVar3 = aVar;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                            }
                            Modifier modifierM5480shadows4CzXII$default = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                            f11 = fM8823constructorimpl;
                            if (z12) {
                                function3M10303getLambda$337125894$views_release = function6;
                            } else {
                                function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                            }
                            long j16 = j14;
                            final boolean z17 = z16;
                            final a aVar4 = aVar3;
                            final ImageVector imageVector3 = arrowBackIos;
                            final long j17 = j15;
                            Function2 function7 = lambda$1069247008$views_release;
                            TopAppBarScrollBehavior topAppBarScrollBehavior5 = topAppBarScrollBehavior4;
                            AppBarKt.m2868TopAppBarGHTll3U(function7, modifierM5480shadows4CzXII$default, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z17, aVar4, imageVector3, j17, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior5, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z14 = z16;
                            aVar2 = aVar3;
                            imageVector2 = arrowBackIos;
                            z15 = z12;
                            function5 = function7;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior5;
                            j13 = j16;
                            j12 = j17;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z14 = z11;
                            imageVector2 = imageVector;
                            f11 = f10;
                            function5 = function4;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            z15 = z12;
                            function6 = function3M10302getLambda$1566705363$views_release;
                            aVar2 = aVar;
                            j12 = j10;
                            j13 = j11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 24576;
                    if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(navHostController)) {
                            i27 = 131072;
                        } else {
                            i27 = 65536;
                        }
                        i13 |= i27;
                    }
                    if ((i10 & 1572864) != 0) {
                        if ((i12 & 64) == 0) {
                            i26 = 524288;
                        } else {
                            i26 = 524288;
                        }
                        i13 |= i26;
                    }
                    if ((i10 & 12582912) != 0) {
                        i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                    }
                    if ((i10 & 100663296) == 0) {
                        if ((i12 & 256) == 0) {
                            i20 = i28;
                            if (composerStartRestartGroup.changed(j10)) {
                            }
                            i13 |= i30;
                        } else {
                            i20 = i28;
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    if ((i10 & 805306368) != 0) {
                        if ((i12 & 512) == 0) {
                            i25 = 268435456;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    i21 = i12 & 1024;
                    if (i21 != 0) {
                        i22 = i11 | 6;
                    } else if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i11 | i23;
                    } else {
                        i22 = i11;
                    }
                    if ((i13 & 306783379) == 306783378) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0) {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        } else {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                        }
                        Modifier modifierM5480shadows4CzXII$default2 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                        f11 = fM8823constructorimpl;
                        if (z12) {
                            function3M10303getLambda$337125894$views_release = function6;
                        } else {
                            function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                        }
                        long j18 = j14;
                        final boolean z18 = z16;
                        final a aVar5 = aVar3;
                        final ImageVector imageVector4 = arrowBackIos;
                        final long j19 = j15;
                        Function2 function8 = lambda$1069247008$views_release;
                        TopAppBarScrollBehavior topAppBarScrollBehavior6 = topAppBarScrollBehavior4;
                        AppBarKt.m2868TopAppBarGHTll3U(function8, modifierM5480shadows4CzXII$default2, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z18, aVar5, imageVector4, j19, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior6, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z14 = z16;
                        aVar2 = aVar3;
                        imageVector2 = arrowBackIos;
                        z15 = z12;
                        function5 = function8;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior6;
                        j13 = j18;
                        j12 = j19;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z14 = z11;
                        imageVector2 = imageVector;
                        f11 = f10;
                        function5 = function4;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        z15 = z12;
                        function6 = function3M10302getLambda$1566705363$views_release;
                        aVar2 = aVar;
                        j12 = j10;
                        j13 = j11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                function3M10302getLambda$1566705363$views_release = function3;
                i18 = i12 & 16;
                if (i18 != 0) {
                    if ((i10 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z11)) {
                            i19 = 16384;
                        } else {
                            i19 = 8192;
                        }
                        i13 |= i19;
                    }
                    if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(navHostController)) {
                            i27 = 131072;
                        } else {
                            i27 = 65536;
                        }
                        i13 |= i27;
                    }
                    if ((i10 & 1572864) != 0) {
                        if ((i12 & 64) == 0) {
                            i26 = 524288;
                        } else {
                            i26 = 524288;
                        }
                        i13 |= i26;
                    }
                    if ((i10 & 12582912) != 0) {
                        i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                    }
                    if ((i10 & 100663296) == 0) {
                        if ((i12 & 256) == 0) {
                            i20 = i28;
                            if (composerStartRestartGroup.changed(j10)) {
                            }
                            i13 |= i30;
                        } else {
                            i20 = i28;
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    if ((i10 & 805306368) != 0) {
                        if ((i12 & 512) == 0) {
                            i25 = 268435456;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    i21 = i12 & 1024;
                    if (i21 != 0) {
                        i22 = i11 | 6;
                    } else if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i11 | i23;
                    } else {
                        i22 = i11;
                    }
                    if ((i13 & 306783379) == 306783378) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0) {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        } else {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                        }
                        Modifier modifierM5480shadows4CzXII$default3 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                        f11 = fM8823constructorimpl;
                        if (z12) {
                            function3M10303getLambda$337125894$views_release = function6;
                        } else {
                            function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                        }
                        long j110 = j14;
                        final boolean z19 = z16;
                        final a aVar6 = aVar3;
                        final ImageVector imageVector5 = arrowBackIos;
                        final long j111 = j15;
                        Function2 function9 = lambda$1069247008$views_release;
                        TopAppBarScrollBehavior topAppBarScrollBehavior7 = topAppBarScrollBehavior4;
                        AppBarKt.m2868TopAppBarGHTll3U(function9, modifierM5480shadows4CzXII$default3, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z19, aVar6, imageVector5, j111, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior7, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z14 = z16;
                        aVar2 = aVar3;
                        imageVector2 = arrowBackIos;
                        z15 = z12;
                        function5 = function9;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior7;
                        j13 = j110;
                        j12 = j111;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z14 = z11;
                        imageVector2 = imageVector;
                        f11 = f10;
                        function5 = function4;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        z15 = z12;
                        function6 = function3M10302getLambda$1566705363$views_release;
                        aVar2 = aVar;
                        j12 = j10;
                        j13 = j11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default4 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j112 = j14;
                    final boolean z110 = z16;
                    final a aVar7 = aVar3;
                    final ImageVector imageVector6 = arrowBackIos;
                    final long j113 = j15;
                    Function2 function10 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior8 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function10, modifierM5480shadows4CzXII$default4, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z110, aVar7, imageVector6, j113, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior8, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function10;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior8;
                    j13 = j112;
                    j12 = j113;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            z12 = z10;
            i16 = i12 & 8;
            if (i16 != 0) {
                if ((i10 & 3072) == 0) {
                    function3M10302getLambda$1566705363$views_release = function3;
                    if (composerStartRestartGroup.changedInstance(function3M10302getLambda$1566705363$views_release)) {
                        i17 = 2048;
                    } else {
                        i17 = 1024;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 16;
                if (i18 != 0) {
                    if ((i10 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z11)) {
                            i19 = 16384;
                        } else {
                            i19 = 8192;
                        }
                        i13 |= i19;
                    }
                    if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(navHostController)) {
                            i27 = 131072;
                        } else {
                            i27 = 65536;
                        }
                        i13 |= i27;
                    }
                    if ((i10 & 1572864) != 0) {
                        if ((i12 & 64) == 0) {
                            i26 = 524288;
                        } else {
                            i26 = 524288;
                        }
                        i13 |= i26;
                    }
                    if ((i10 & 12582912) != 0) {
                        i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                    }
                    if ((i10 & 100663296) == 0) {
                        if ((i12 & 256) == 0) {
                            i20 = i28;
                            if (composerStartRestartGroup.changed(j10)) {
                            }
                            i13 |= i30;
                        } else {
                            i20 = i28;
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    if ((i10 & 805306368) != 0) {
                        if ((i12 & 512) == 0) {
                            i25 = 268435456;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    i21 = i12 & 1024;
                    if (i21 != 0) {
                        i22 = i11 | 6;
                    } else if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i11 | i23;
                    } else {
                        i22 = i11;
                    }
                    if ((i13 & 306783379) == 306783378) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0) {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        } else {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                        }
                        Modifier modifierM5480shadows4CzXII$default5 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                        f11 = fM8823constructorimpl;
                        if (z12) {
                            function3M10303getLambda$337125894$views_release = function6;
                        } else {
                            function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                        }
                        long j114 = j14;
                        final boolean z111 = z16;
                        final a aVar8 = aVar3;
                        final ImageVector imageVector7 = arrowBackIos;
                        final long j115 = j15;
                        Function2 function11 = lambda$1069247008$views_release;
                        TopAppBarScrollBehavior topAppBarScrollBehavior9 = topAppBarScrollBehavior4;
                        AppBarKt.m2868TopAppBarGHTll3U(function11, modifierM5480shadows4CzXII$default5, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z111, aVar8, imageVector7, j115, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior9, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z14 = z16;
                        aVar2 = aVar3;
                        imageVector2 = arrowBackIos;
                        z15 = z12;
                        function5 = function11;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior9;
                        j13 = j114;
                        j12 = j115;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z14 = z11;
                        imageVector2 = imageVector;
                        f11 = f10;
                        function5 = function4;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        z15 = z12;
                        function6 = function3M10302getLambda$1566705363$views_release;
                        aVar2 = aVar;
                        j12 = j10;
                        j13 = j11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default6 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j116 = j14;
                    final boolean z112 = z16;
                    final a aVar9 = aVar3;
                    final ImageVector imageVector8 = arrowBackIos;
                    final long j117 = j15;
                    Function2 function12 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior10 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function12, modifierM5480shadows4CzXII$default6, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z112, aVar9, imageVector8, j117, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior10, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function12;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior10;
                    j13 = j116;
                    j12 = j117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            function3M10302getLambda$1566705363$views_release = function3;
            i18 = i12 & 16;
            if (i18 != 0) {
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i19 = 16384;
                    } else {
                        i19 = 8192;
                    }
                    i13 |= i19;
                }
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default7 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j118 = j14;
                    final boolean z113 = z16;
                    final a aVar10 = aVar3;
                    final ImageVector imageVector9 = arrowBackIos;
                    final long j119 = j15;
                    Function2 function13 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior11 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function13, modifierM5480shadows4CzXII$default7, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z113, aVar10, imageVector9, j119, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior11, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function13;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior11;
                    j13 = j118;
                    j12 = j119;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(navHostController)) {
                    i27 = 131072;
                } else {
                    i27 = 65536;
                }
                i13 |= i27;
            }
            if ((i10 & 1572864) != 0) {
                if ((i12 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i13 |= i26;
            }
            if ((i10 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) == 0) {
                if ((i12 & 256) == 0) {
                    i20 = i28;
                    if (composerStartRestartGroup.changed(j10)) {
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                i13 |= i30;
            } else {
                i20 = i28;
            }
            if ((i10 & 805306368) != 0) {
                if ((i12 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i21 = i12 & 1024;
            if (i21 != 0) {
                i22 = i11 | 6;
            } else if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i11 | i23;
            } else {
                i22 = i11;
            }
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                } else {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                }
                Modifier modifierM5480shadows4CzXII$default8 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                f11 = fM8823constructorimpl;
                if (z12) {
                    function3M10303getLambda$337125894$views_release = function6;
                } else {
                    function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                }
                long j1110 = j14;
                final boolean z114 = z16;
                final a aVar11 = aVar3;
                final ImageVector imageVector10 = arrowBackIos;
                final long j1111 = j15;
                Function2 function14 = lambda$1069247008$views_release;
                TopAppBarScrollBehavior topAppBarScrollBehavior12 = topAppBarScrollBehavior4;
                AppBarKt.m2868TopAppBarGHTll3U(function14, modifierM5480shadows4CzXII$default8, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z114, aVar11, imageVector10, j1111, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior12, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z16;
                aVar2 = aVar3;
                imageVector2 = arrowBackIos;
                z15 = z12;
                function5 = function14;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior12;
                j13 = j1110;
                j12 = j1111;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z11;
                imageVector2 = imageVector;
                f11 = f10;
                function5 = function4;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z15 = z12;
                function6 = function3M10302getLambda$1566705363$views_release;
                aVar2 = aVar;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 48;
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        i14 = i12 & 4;
        if (i14 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z12 = z10;
                if (composerStartRestartGroup.changed(z12)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i13 |= i15;
            }
            i16 = i12 & 8;
            if (i16 != 0) {
                if ((i10 & 3072) == 0) {
                    function3M10302getLambda$1566705363$views_release = function3;
                    if (composerStartRestartGroup.changedInstance(function3M10302getLambda$1566705363$views_release)) {
                        i17 = 2048;
                    } else {
                        i17 = 1024;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 16;
                if (i18 != 0) {
                    if ((i10 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z11)) {
                            i19 = 16384;
                        } else {
                            i19 = 8192;
                        }
                        i13 |= i19;
                    }
                    if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(navHostController)) {
                            i27 = 131072;
                        } else {
                            i27 = 65536;
                        }
                        i13 |= i27;
                    }
                    if ((i10 & 1572864) != 0) {
                        if ((i12 & 64) == 0) {
                            i26 = 524288;
                        } else {
                            i26 = 524288;
                        }
                        i13 |= i26;
                    }
                    if ((i10 & 12582912) != 0) {
                        i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                    }
                    if ((i10 & 100663296) == 0) {
                        if ((i12 & 256) == 0) {
                            i20 = i28;
                            if (composerStartRestartGroup.changed(j10)) {
                            }
                            i13 |= i30;
                        } else {
                            i20 = i28;
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    if ((i10 & 805306368) != 0) {
                        if ((i12 & 512) == 0) {
                            i25 = 268435456;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    i21 = i12 & 1024;
                    if (i21 != 0) {
                        i22 = i11 | 6;
                    } else if ((i11 & 6) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i11 | i23;
                    } else {
                        i22 = i11;
                    }
                    if ((i13 & 306783379) == 306783378) {
                        z13 = true;
                    } else {
                        z13 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i10 & 1) != 0) {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        } else {
                            if (i20 != 0) {
                                lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                            } else {
                                lambda$1069247008$views_release = function4;
                            }
                            if (i29 != 0) {
                                topAppBarScrollBehavior4 = null;
                            } else {
                                topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                            }
                            if (i14 != 0) {
                                z12 = true;
                            }
                            if (i16 != 0) {
                                function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                            }
                            if (i18 != 0) {
                                z16 = true;
                            } else {
                                z16 = z11;
                            }
                            if ((i12 & 64) != 0) {
                                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new a() { // from class: t9.e
                                        @Override // lb.a
                                        public final Object invoke() {
                                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                aVar3 = (a) objRememberedValue;
                                i13 &= -3670017;
                            } else {
                                aVar3 = aVar;
                            }
                            if ((i12 & 128) != 0) {
                                arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                                i13 &= -29360129;
                            } else {
                                arrowBackIos = imageVector;
                            }
                            if ((i12 & 256) != 0) {
                                onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                                i13 &= -234881025;
                            } else {
                                onBackground = j10;
                            }
                            if ((i12 & 512) != 0) {
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                                i13 &= -1879048193;
                            } else {
                                background = j11;
                            }
                            if (i21 != 0) {
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = Dp.m8823constructorimpl(1);
                                function6 = function3M10302getLambda$1566705363$views_release;
                            } else {
                                function6 = function3M10302getLambda$1566705363$views_release;
                                j14 = background;
                                j15 = onBackground;
                                i24 = 1191839252;
                                fM8823constructorimpl = f10;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                        }
                        Modifier modifierM5480shadows4CzXII$default9 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                        f11 = fM8823constructorimpl;
                        if (z12) {
                            function3M10303getLambda$337125894$views_release = function6;
                        } else {
                            function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                        }
                        long j1112 = j14;
                        final boolean z115 = z16;
                        final a aVar12 = aVar3;
                        final ImageVector imageVector11 = arrowBackIos;
                        final long j1113 = j15;
                        Function2 function15 = lambda$1069247008$views_release;
                        TopAppBarScrollBehavior topAppBarScrollBehavior13 = topAppBarScrollBehavior4;
                        AppBarKt.m2868TopAppBarGHTll3U(function15, modifierM5480shadows4CzXII$default9, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z115, aVar12, imageVector11, j1113, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior13, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z14 = z16;
                        aVar2 = aVar3;
                        imageVector2 = arrowBackIos;
                        z15 = z12;
                        function5 = function15;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior13;
                        j13 = j1112;
                        j12 = j1113;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z14 = z11;
                        imageVector2 = imageVector;
                        f11 = f10;
                        function5 = function4;
                        topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        z15 = z12;
                        function6 = function3M10302getLambda$1566705363$views_release;
                        aVar2 = aVar;
                        j12 = j10;
                        j13 = j11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default10 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j1114 = j14;
                    final boolean z116 = z16;
                    final a aVar13 = aVar3;
                    final ImageVector imageVector12 = arrowBackIos;
                    final long j1115 = j15;
                    Function2 function16 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior14 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function16, modifierM5480shadows4CzXII$default10, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z116, aVar13, imageVector12, j1115, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior14, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function16;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior14;
                    j13 = j1114;
                    j12 = j1115;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            function3M10302getLambda$1566705363$views_release = function3;
            i18 = i12 & 16;
            if (i18 != 0) {
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i19 = 16384;
                    } else {
                        i19 = 8192;
                    }
                    i13 |= i19;
                }
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default11 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j1116 = j14;
                    final boolean z117 = z16;
                    final a aVar14 = aVar3;
                    final ImageVector imageVector13 = arrowBackIos;
                    final long j1117 = j15;
                    Function2 function17 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior15 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function17, modifierM5480shadows4CzXII$default11, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z117, aVar14, imageVector13, j1117, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior15, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function17;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior15;
                    j13 = j1116;
                    j12 = j1117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(navHostController)) {
                    i27 = 131072;
                } else {
                    i27 = 65536;
                }
                i13 |= i27;
            }
            if ((i10 & 1572864) != 0) {
                if ((i12 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i13 |= i26;
            }
            if ((i10 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) == 0) {
                if ((i12 & 256) == 0) {
                    i20 = i28;
                    if (composerStartRestartGroup.changed(j10)) {
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                i13 |= i30;
            } else {
                i20 = i28;
            }
            if ((i10 & 805306368) != 0) {
                if ((i12 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i21 = i12 & 1024;
            if (i21 != 0) {
                i22 = i11 | 6;
            } else if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i11 | i23;
            } else {
                i22 = i11;
            }
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                } else {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                }
                Modifier modifierM5480shadows4CzXII$default12 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                f11 = fM8823constructorimpl;
                if (z12) {
                    function3M10303getLambda$337125894$views_release = function6;
                } else {
                    function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                }
                long j1118 = j14;
                final boolean z118 = z16;
                final a aVar15 = aVar3;
                final ImageVector imageVector14 = arrowBackIos;
                final long j1119 = j15;
                Function2 function18 = lambda$1069247008$views_release;
                TopAppBarScrollBehavior topAppBarScrollBehavior16 = topAppBarScrollBehavior4;
                AppBarKt.m2868TopAppBarGHTll3U(function18, modifierM5480shadows4CzXII$default12, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z118, aVar15, imageVector14, j1119, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior16, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z16;
                aVar2 = aVar3;
                imageVector2 = arrowBackIos;
                z15 = z12;
                function5 = function18;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior16;
                j13 = j1118;
                j12 = j1119;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z11;
                imageVector2 = imageVector;
                f11 = f10;
                function5 = function4;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z15 = z12;
                function6 = function3M10302getLambda$1566705363$views_release;
                aVar2 = aVar;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        z12 = z10;
        i16 = i12 & 8;
        if (i16 != 0) {
            if ((i10 & 3072) == 0) {
                function3M10302getLambda$1566705363$views_release = function3;
                if (composerStartRestartGroup.changedInstance(function3M10302getLambda$1566705363$views_release)) {
                    i17 = 2048;
                } else {
                    i17 = 1024;
                }
                i13 |= i17;
            }
            i18 = i12 & 16;
            if (i18 != 0) {
                if ((i10 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i19 = 16384;
                    } else {
                        i19 = 8192;
                    }
                    i13 |= i19;
                }
                if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(navHostController)) {
                        i27 = 131072;
                    } else {
                        i27 = 65536;
                    }
                    i13 |= i27;
                }
                if ((i10 & 1572864) != 0) {
                    if ((i12 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i13 |= i26;
                }
                if ((i10 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
                }
                if ((i10 & 100663296) == 0) {
                    if ((i12 & 256) == 0) {
                        i20 = i28;
                        if (composerStartRestartGroup.changed(j10)) {
                        }
                        i13 |= i30;
                    } else {
                        i20 = i28;
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                if ((i10 & 805306368) != 0) {
                    if ((i12 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                i21 = i12 & 1024;
                if (i21 != 0) {
                    i22 = i11 | 6;
                } else if ((i11 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i11 | i23;
                } else {
                    i22 = i11;
                }
                if ((i13 & 306783379) == 306783378) {
                    z13 = true;
                } else {
                    z13 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0) {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    } else {
                        if (i20 != 0) {
                            lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                        } else {
                            lambda$1069247008$views_release = function4;
                        }
                        if (i29 != 0) {
                            topAppBarScrollBehavior4 = null;
                        } else {
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        if (i14 != 0) {
                            z12 = true;
                        }
                        if (i16 != 0) {
                            function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                        }
                        if (i18 != 0) {
                            z16 = true;
                        } else {
                            z16 = z11;
                        }
                        if ((i12 & 64) != 0) {
                            zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new a() { // from class: t9.e
                                    @Override // lb.a
                                    public final Object invoke() {
                                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            aVar3 = (a) objRememberedValue;
                            i13 &= -3670017;
                        } else {
                            aVar3 = aVar;
                        }
                        if ((i12 & 128) != 0) {
                            arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                            i13 &= -29360129;
                        } else {
                            arrowBackIos = imageVector;
                        }
                        if ((i12 & 256) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                            i13 &= -234881025;
                        } else {
                            onBackground = j10;
                        }
                        if ((i12 & 512) != 0) {
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                            i13 &= -1879048193;
                        } else {
                            background = j11;
                        }
                        if (i21 != 0) {
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = Dp.m8823constructorimpl(1);
                            function6 = function3M10302getLambda$1566705363$views_release;
                        } else {
                            function6 = function3M10302getLambda$1566705363$views_release;
                            j14 = background;
                            j15 = onBackground;
                            i24 = 1191839252;
                            fM8823constructorimpl = f10;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                    }
                    Modifier modifierM5480shadows4CzXII$default13 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                    f11 = fM8823constructorimpl;
                    if (z12) {
                        function3M10303getLambda$337125894$views_release = function6;
                    } else {
                        function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                    }
                    long j11110 = j14;
                    final boolean z119 = z16;
                    final a aVar16 = aVar3;
                    final ImageVector imageVector15 = arrowBackIos;
                    final long j11111 = j15;
                    Function2 function19 = lambda$1069247008$views_release;
                    TopAppBarScrollBehavior topAppBarScrollBehavior17 = topAppBarScrollBehavior4;
                    AppBarKt.m2868TopAppBarGHTll3U(function19, modifierM5480shadows4CzXII$default13, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z119, aVar16, imageVector15, j11111, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior17, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    aVar2 = aVar3;
                    imageVector2 = arrowBackIos;
                    z15 = z12;
                    function5 = function19;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior17;
                    j13 = j11110;
                    j12 = j11111;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z14 = z11;
                    imageVector2 = imageVector;
                    f11 = f10;
                    function5 = function4;
                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    z15 = z12;
                    function6 = function3M10302getLambda$1566705363$views_release;
                    aVar2 = aVar;
                    j12 = j10;
                    j13 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(navHostController)) {
                    i27 = 131072;
                } else {
                    i27 = 65536;
                }
                i13 |= i27;
            }
            if ((i10 & 1572864) != 0) {
                if ((i12 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i13 |= i26;
            }
            if ((i10 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) == 0) {
                if ((i12 & 256) == 0) {
                    i20 = i28;
                    if (composerStartRestartGroup.changed(j10)) {
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                i13 |= i30;
            } else {
                i20 = i28;
            }
            if ((i10 & 805306368) != 0) {
                if ((i12 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i21 = i12 & 1024;
            if (i21 != 0) {
                i22 = i11 | 6;
            } else if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i11 | i23;
            } else {
                i22 = i11;
            }
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                } else {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                }
                Modifier modifierM5480shadows4CzXII$default14 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                f11 = fM8823constructorimpl;
                if (z12) {
                    function3M10303getLambda$337125894$views_release = function6;
                } else {
                    function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                }
                long j11112 = j14;
                final boolean z1110 = z16;
                final a aVar17 = aVar3;
                final ImageVector imageVector16 = arrowBackIos;
                final long j11113 = j15;
                Function2 function110 = lambda$1069247008$views_release;
                TopAppBarScrollBehavior topAppBarScrollBehavior18 = topAppBarScrollBehavior4;
                AppBarKt.m2868TopAppBarGHTll3U(function110, modifierM5480shadows4CzXII$default14, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z1110, aVar17, imageVector16, j11113, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior18, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z16;
                aVar2 = aVar3;
                imageVector2 = arrowBackIos;
                z15 = z12;
                function5 = function110;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior18;
                j13 = j11112;
                j12 = j11113;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z11;
                imageVector2 = imageVector;
                f11 = f10;
                function5 = function4;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z15 = z12;
                function6 = function3M10302getLambda$1566705363$views_release;
                aVar2 = aVar;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        function3M10302getLambda$1566705363$views_release = function3;
        i18 = i12 & 16;
        if (i18 != 0) {
            if ((i10 & 24576) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i19 = 16384;
                } else {
                    i19 = 8192;
                }
                i13 |= i19;
            }
            if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(navHostController)) {
                    i27 = 131072;
                } else {
                    i27 = 65536;
                }
                i13 |= i27;
            }
            if ((i10 & 1572864) != 0) {
                if ((i12 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i13 |= i26;
            }
            if ((i10 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
            }
            if ((i10 & 100663296) == 0) {
                if ((i12 & 256) == 0) {
                    i20 = i28;
                    if (composerStartRestartGroup.changed(j10)) {
                    }
                    i13 |= i30;
                } else {
                    i20 = i28;
                }
                i13 |= i30;
            } else {
                i20 = i28;
            }
            if ((i10 & 805306368) != 0) {
                if ((i12 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            i21 = i12 & 1024;
            if (i21 != 0) {
                i22 = i11 | 6;
            } else if ((i11 & 6) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i11 | i23;
            } else {
                i22 = i11;
            }
            if ((i13 & 306783379) == 306783378) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                } else {
                    if (i20 != 0) {
                        lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                    } else {
                        lambda$1069247008$views_release = function4;
                    }
                    if (i29 != 0) {
                        topAppBarScrollBehavior4 = null;
                    } else {
                        topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                    }
                    if (i14 != 0) {
                        z12 = true;
                    }
                    if (i16 != 0) {
                        function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                    }
                    if (i18 != 0) {
                        z16 = true;
                    } else {
                        z16 = z11;
                    }
                    if ((i12 & 64) != 0) {
                        zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new a() { // from class: t9.e
                                @Override // lb.a
                                public final Object invoke() {
                                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aVar3 = (a) objRememberedValue;
                        i13 &= -3670017;
                    } else {
                        aVar3 = aVar;
                    }
                    if ((i12 & 128) != 0) {
                        arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                        i13 &= -29360129;
                    } else {
                        arrowBackIos = imageVector;
                    }
                    if ((i12 & 256) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                        i13 &= -234881025;
                    } else {
                        onBackground = j10;
                    }
                    if ((i12 & 512) != 0) {
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        i13 &= -1879048193;
                    } else {
                        background = j11;
                    }
                    if (i21 != 0) {
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = Dp.m8823constructorimpl(1);
                        function6 = function3M10302getLambda$1566705363$views_release;
                    } else {
                        function6 = function3M10302getLambda$1566705363$views_release;
                        j14 = background;
                        j15 = onBackground;
                        i24 = 1191839252;
                        fM8823constructorimpl = f10;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
                }
                Modifier modifierM5480shadows4CzXII$default15 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
                f11 = fM8823constructorimpl;
                if (z12) {
                    function3M10303getLambda$337125894$views_release = function6;
                } else {
                    function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
                }
                long j11114 = j14;
                final boolean z1111 = z16;
                final a aVar18 = aVar3;
                final ImageVector imageVector17 = arrowBackIos;
                final long j11115 = j15;
                Function2 function111 = lambda$1069247008$views_release;
                TopAppBarScrollBehavior topAppBarScrollBehavior19 = topAppBarScrollBehavior4;
                AppBarKt.m2868TopAppBarGHTll3U(function111, modifierM5480shadows4CzXII$default15, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z1111, aVar18, imageVector17, j11115, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior19, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z14 = z16;
                aVar2 = aVar3;
                imageVector2 = arrowBackIos;
                z15 = z12;
                function5 = function111;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior19;
                j13 = j11114;
                j12 = j11115;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z14 = z11;
                imageVector2 = imageVector;
                f11 = f10;
                function5 = function4;
                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                z15 = z12;
                function6 = function3M10302getLambda$1566705363$views_release;
                aVar2 = aVar;
                j12 = j10;
                j13 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(navHostController)) {
                i27 = 131072;
            } else {
                i27 = 65536;
            }
            i13 |= i27;
        }
        if ((i10 & 1572864) != 0) {
            if ((i12 & 64) == 0) {
                i26 = 524288;
            } else {
                i26 = 524288;
            }
            i13 |= i26;
        }
        if ((i10 & 12582912) != 0) {
            i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(imageVector)) ? 4194304 : 8388608;
        }
        if ((i10 & 100663296) == 0) {
            if ((i12 & 256) == 0) {
                i20 = i28;
                if (composerStartRestartGroup.changed(j10)) {
                }
                i13 |= i30;
            } else {
                i20 = i28;
            }
            i13 |= i30;
        } else {
            i20 = i28;
        }
        if ((i10 & 805306368) != 0) {
            if ((i12 & 512) == 0) {
                i25 = 268435456;
            } else {
                i25 = 268435456;
            }
            i13 |= i25;
        }
        i21 = i12 & 1024;
        if (i21 != 0) {
            i22 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            if (composerStartRestartGroup.changed(f10)) {
                i23 = 4;
            } else {
                i23 = 2;
            }
            i22 = i11 | i23;
        } else {
            i22 = i11;
        }
        if ((i13 & 306783379) == 306783378) {
            z13 = true;
        } else {
            z13 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z13, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i20 != 0) {
                    lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                } else {
                    lambda$1069247008$views_release = function4;
                }
                if (i29 != 0) {
                    topAppBarScrollBehavior4 = null;
                } else {
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                }
                if (i14 != 0) {
                    z12 = true;
                }
                if (i16 != 0) {
                    function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                }
                if (i18 != 0) {
                    z16 = true;
                } else {
                    z16 = z11;
                }
                if ((i12 & 64) != 0) {
                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue = new a() { // from class: t9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new a() { // from class: t9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar3 = (a) objRememberedValue;
                    i13 &= -3670017;
                } else {
                    aVar3 = aVar;
                }
                if ((i12 & 128) != 0) {
                    arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                    i13 &= -29360129;
                } else {
                    arrowBackIos = imageVector;
                }
                if ((i12 & 256) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i13 &= -234881025;
                } else {
                    onBackground = j10;
                }
                if ((i12 & 512) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i13 &= -1879048193;
                } else {
                    background = j11;
                }
                if (i21 != 0) {
                    j14 = background;
                    j15 = onBackground;
                    i24 = 1191839252;
                    fM8823constructorimpl = Dp.m8823constructorimpl(1);
                    function6 = function3M10302getLambda$1566705363$views_release;
                } else {
                    function6 = function3M10302getLambda$1566705363$views_release;
                    j14 = background;
                    j15 = onBackground;
                    i24 = 1191839252;
                    fM8823constructorimpl = f10;
                }
            } else {
                if (i20 != 0) {
                    lambda$1069247008$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.getLambda$1069247008$views_release();
                } else {
                    lambda$1069247008$views_release = function4;
                }
                if (i29 != 0) {
                    topAppBarScrollBehavior4 = null;
                } else {
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                }
                if (i14 != 0) {
                    z12 = true;
                }
                if (i16 != 0) {
                    function3M10302getLambda$1566705363$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10302getLambda$1566705363$views_release();
                }
                if (i18 != 0) {
                    z16 = true;
                } else {
                    z16 = z11;
                }
                if ((i12 & 64) != 0) {
                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue = new a() { // from class: t9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new a() { // from class: t9.e
                            @Override // lb.a
                            public final Object invoke() {
                                return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$1$lambda$0(navHostController);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aVar3 = (a) objRememberedValue;
                    i13 &= -3670017;
                } else {
                    aVar3 = aVar;
                }
                if ((i12 & 128) != 0) {
                    arrowBackIos = ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE);
                    i13 &= -29360129;
                } else {
                    arrowBackIos = imageVector;
                }
                if ((i12 & 256) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground();
                    i13 &= -234881025;
                } else {
                    onBackground = j10;
                }
                if ((i12 & 512) != 0) {
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                    i13 &= -1879048193;
                } else {
                    background = j11;
                }
                if (i21 != 0) {
                    j14 = background;
                    j15 = onBackground;
                    i24 = 1191839252;
                    fM8823constructorimpl = Dp.m8823constructorimpl(1);
                    function6 = function3M10302getLambda$1566705363$views_release;
                } else {
                    function6 = function3M10302getLambda$1566705363$views_release;
                    j14 = background;
                    j15 = onBackground;
                    i24 = 1191839252;
                    fM8823constructorimpl = f10;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i24, i13, i22, "cu.z17.views.topBar.Z17TopBar (Z17TopBar.kt:36)");
            }
            Modifier modifierM5480shadows4CzXII$default16 = ShadowKt.m5480shadows4CzXII$default(Modifier.INSTANCE, fM8823constructorimpl, null, false, 0L, 0L, 30, null);
            f11 = fM8823constructorimpl;
            if (z12) {
                function3M10303getLambda$337125894$views_release = function6;
            } else {
                function3M10303getLambda$337125894$views_release = ComposableSingletons$Z17TopBarKt.INSTANCE.m10303getLambda$337125894$views_release();
            }
            long j11116 = j14;
            final boolean z1112 = z16;
            final a aVar19 = aVar3;
            final ImageVector imageVector18 = arrowBackIos;
            final long j11117 = j15;
            Function2 function112 = lambda$1069247008$views_release;
            TopAppBarScrollBehavior topAppBarScrollBehavior110 = topAppBarScrollBehavior4;
            AppBarKt.m2868TopAppBarGHTll3U(function112, modifierM5480shadows4CzXII$default16, ComposableLambdaKt.rememberComposableLambda(-124904306, true, new Function2() { // from class: t9.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3(z1112, aVar19, imageVector18, j11117, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), function3M10303getLambda$337125894$views_release, 0.0f, null, TopAppBarDefaults.INSTANCE.m4066topAppBarColorszjMxDiM(j14, j14, 0L, 0L, 0L, composerStartRestartGroup, ((i13 >> 27) & 14) | ((i13 >> 24) & 112) | (TopAppBarDefaults.$stable << 15), 28), topAppBarScrollBehavior110, composerStartRestartGroup, (i13 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 18) & 29360128), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z14 = z16;
            aVar2 = aVar3;
            imageVector2 = arrowBackIos;
            z15 = z12;
            function5 = function112;
            topAppBarScrollBehavior3 = topAppBarScrollBehavior110;
            j13 = j11116;
            j12 = j11117;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z14 = z11;
            imageVector2 = imageVector;
            f11 = f10;
            function5 = function4;
            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
            z15 = z12;
            function6 = function3M10302getLambda$1566705363$views_release;
            aVar2 = aVar;
            j12 = j10;
            j13 = j11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: t9.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$4(function5, topAppBarScrollBehavior3, z15, function6, z14, navHostController, aVar2, imageVector2, j12, j13, f11, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TopBar_dW_2gCk$lambda$1$lambda$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17TopBar_dW_2gCk$lambda$3(boolean z10, a aVar, final ImageVector imageVector, final long j10, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-124904306, i10, -1, "cu.z17.views.topBar.Z17TopBar.<anonymous> (Z17TopBar.kt:46)");
            }
            if (z10) {
                composer.startReplaceGroup(-1582455332);
                IconButtonKt.IconButton(aVar, PaddingKt.m1727paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8823constructorimpl(5), 0.0f, 2, null), false, null, null, ComposableLambdaKt.rememberComposableLambda(-598792298, true, new Function2() { // from class: t9.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17TopBarKt.Z17TopBar_dW_2gCk$lambda$3$lambda$2(imageVector, j10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 196656, 28);
            } else {
                composer.startReplaceGroup(-1584271436);
            }
            composer.endReplaceGroup();
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
    public static final k0 Z17TopBar_dW_2gCk$lambda$3$lambda$2(ImageVector imageVector, long j10, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-598792298, i10, -1, "cu.z17.views.topBar.Z17TopBar.<anonymous>.<anonymous> (Z17TopBar.kt:52)");
            }
            IconKt.m3298Iconww6aTOc(imageVector, "", (Modifier) null, j10, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17TopBar_dW_2gCk$lambda$4(Function2 function2, TopAppBarScrollBehavior topAppBarScrollBehavior, boolean z10, Function3 function3, boolean z11, NavHostController navHostController, a aVar, ImageVector imageVector, long j10, long j11, float f10, int i10, int i11, int i12, Composer composer, int i13) {
        m10304Z17TopBardW2gCk(function2, topAppBarScrollBehavior, z10, function3, z11, navHostController, aVar, imageVector, j10, j11, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return k0.f43947a;
    }
}
