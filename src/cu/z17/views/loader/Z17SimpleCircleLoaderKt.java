package cu.z17.views.loader;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a7\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/unit/Dp;", "strokeWidth", "size", "Landroidx/compose/ui/graphics/Color;", "color", "Lua/k0;", "Z17SimpleCircleLoader-Zi-j2fk", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/runtime/Composer;II)V", "Z17SimpleCircleLoader", "", "progress", "Z17CircleProgressLoader--gZXFtk", "(Landroidx/compose/ui/Modifier;FFFJLandroidx/compose/runtime/Composer;II)V", "Z17CircleProgressLoader", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17SimpleCircleLoaderKt {
    /* JADX WARN: Code duplicated, block: B:33:0x005a  */
    /* JADX WARN: Code duplicated, block: B:35:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0075  */
    /* JADX WARN: Code duplicated, block: B:46:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x0122  */
    /* JADX WARN: Code duplicated, block: B:87:0x012a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0139  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17CircleProgressLoader--gZXFtk, reason: not valid java name */
    public static final void m10264Z17CircleProgressLoadergZXFtk(Modifier modifier, final float f10, float f11, float f12, long j10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        float f13;
        int i13;
        float fM8823constructorimpl;
        int i14;
        long j11;
        boolean z10;
        Composer composer2;
        final Modifier modifier3;
        final float f14;
        final float f15;
        final long j12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        float fM8823constructorimpl2;
        float f16;
        float f17;
        long primary;
        Composer composerStartRestartGroup = composer.startRestartGroup(746469850);
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
            i12 |= composerStartRestartGroup.changed(f10) ? 32 : 16;
        }
        int i16 = i11 & 4;
        if (i16 == 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                f13 = f11;
                i12 |= composerStartRestartGroup.changed(f13) ? 256 : 128;
            }
            i13 = i11 & 8;
            if (i13 != 0) {
                if ((i10 & 3072) == 0) {
                    fM8823constructorimpl = f12;
                    if (composerStartRestartGroup.changed(fM8823constructorimpl)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                if ((i10 & 24576) == 0) {
                    if ((i11 & 16) == 0) {
                        j11 = j10;
                        int i17 = composerStartRestartGroup.changed(j11) ? 16384 : 8192;
                        i12 |= i17;
                    } else {
                        j11 = j10;
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                if ((i12 & 9363) != 9362) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i16 != 0) {
                            fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                        } else {
                            fM8823constructorimpl2 = f13;
                        }
                        if (i13 != 0) {
                            fM8823constructorimpl = Dp.m8823constructorimpl(30);
                        }
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                            f16 = fM8823constructorimpl2;
                            f17 = fM8823constructorimpl;
                            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        } else {
                            f16 = fM8823constructorimpl2;
                            f17 = fM8823constructorimpl;
                            primary = j11;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                        }
                        modifier4 = modifier2;
                        f17 = fM8823constructorimpl;
                        primary = j11;
                        f16 = f13;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(746469850, i12, -1, "cu.z17.views.loader.Z17CircleProgressLoader (Z17SimpleCircleLoader.kt:32)");
                    }
                    composer2 = composerStartRestartGroup;
                    ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(f10, SizeKt.m1769size3ABfNKs(modifier4, f17), primary, f16, 0L, 0, composer2, ((i12 >> 3) & 14) | ((i12 >> 6) & 896) | ((i12 << 3) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    f15 = f17;
                    j12 = primary;
                    f14 = f16;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f14 = f13;
                    f15 = fM8823constructorimpl;
                    j12 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17SimpleCircleLoaderKt.Z17CircleProgressLoader__gZXFtk$lambda$1(modifier3, f10, f14, f15, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 3072;
            fM8823constructorimpl = f12;
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    j11 = j10;
                    if (composerStartRestartGroup.changed(j11)) {
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f13;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(30);
                    }
                    if ((i11 & 16) != 0) {
                        i12 &= -57345;
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = j11;
                    }
                } else {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f13;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(30);
                    }
                    if ((i11 & 16) != 0) {
                        i12 &= -57345;
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(746469850, i12, -1, "cu.z17.views.loader.Z17CircleProgressLoader (Z17SimpleCircleLoader.kt:32)");
                }
                composer2 = composerStartRestartGroup;
                ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(f10, SizeKt.m1769size3ABfNKs(modifier4, f17), primary, f16, 0L, 0, composer2, ((i12 >> 3) & 14) | ((i12 >> 6) & 896) | ((i12 << 3) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                f15 = f17;
                j12 = primary;
                f14 = f16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f14 = f13;
                f15 = fM8823constructorimpl;
                j12 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17SimpleCircleLoaderKt.Z17CircleProgressLoader__gZXFtk$lambda$1(modifier3, f10, f14, f15, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        f13 = f11;
        i13 = i11 & 8;
        if (i13 != 0) {
            if ((i10 & 3072) == 0) {
                fM8823constructorimpl = f12;
                if (composerStartRestartGroup.changed(fM8823constructorimpl)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    j11 = j10;
                    if (composerStartRestartGroup.changed(j11)) {
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            if ((i12 & 9363) != 9362) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f13;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(30);
                    }
                    if ((i11 & 16) != 0) {
                        i12 &= -57345;
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = j11;
                    }
                } else {
                    if (i15 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f13;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(30);
                    }
                    if ((i11 & 16) != 0) {
                        i12 &= -57345;
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f16 = fM8823constructorimpl2;
                        f17 = fM8823constructorimpl;
                        primary = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(746469850, i12, -1, "cu.z17.views.loader.Z17CircleProgressLoader (Z17SimpleCircleLoader.kt:32)");
                }
                composer2 = composerStartRestartGroup;
                ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(f10, SizeKt.m1769size3ABfNKs(modifier4, f17), primary, f16, 0L, 0, composer2, ((i12 >> 3) & 14) | ((i12 >> 6) & 896) | ((i12 << 3) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                f15 = f17;
                j12 = primary;
                f14 = f16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f14 = f13;
                f15 = fM8823constructorimpl;
                j12 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17SimpleCircleLoaderKt.Z17CircleProgressLoader__gZXFtk$lambda$1(modifier3, f10, f14, f15, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        fM8823constructorimpl = f12;
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                j11 = j10;
                if (composerStartRestartGroup.changed(j11)) {
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            i12 |= i17;
        } else {
            j11 = j10;
        }
        if ((i12 & 9363) != 9362) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                } else {
                    fM8823constructorimpl2 = f13;
                }
                if (i13 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(30);
                }
                if ((i11 & 16) != 0) {
                    i12 &= -57345;
                    f16 = fM8823constructorimpl2;
                    f17 = fM8823constructorimpl;
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                } else {
                    f16 = fM8823constructorimpl2;
                    f17 = fM8823constructorimpl;
                    primary = j11;
                }
            } else {
                if (i15 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                } else {
                    fM8823constructorimpl2 = f13;
                }
                if (i13 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(30);
                }
                if ((i11 & 16) != 0) {
                    i12 &= -57345;
                    f16 = fM8823constructorimpl2;
                    f17 = fM8823constructorimpl;
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                } else {
                    f16 = fM8823constructorimpl2;
                    f17 = fM8823constructorimpl;
                    primary = j11;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(746469850, i12, -1, "cu.z17.views.loader.Z17CircleProgressLoader (Z17SimpleCircleLoader.kt:32)");
            }
            composer2 = composerStartRestartGroup;
            ProgressIndicatorKt.m2698CircularProgressIndicatorDUhRLBM(f10, SizeKt.m1769size3ABfNKs(modifier4, f17), primary, f16, 0L, 0, composer2, ((i12 >> 3) & 14) | ((i12 >> 6) & 896) | ((i12 << 3) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f15 = f17;
            j12 = primary;
            f14 = f16;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f14 = f13;
            f15 = fM8823constructorimpl;
            j12 = j11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17SimpleCircleLoaderKt.Z17CircleProgressLoader__gZXFtk$lambda$1(modifier3, f10, f14, f15, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17CircleProgressLoader__gZXFtk$lambda$1(Modifier modifier, float f10, float f11, float f12, long j10, int i10, int i11, Composer composer, int i12) {
        m10264Z17CircleProgressLoadergZXFtk(modifier, f10, f11, f12, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:78:0x0108  */
    /* JADX WARN: Code duplicated, block: B:80:0x010f  */
    /* JADX WARN: Code duplicated, block: B:83:0x011c  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Z17SimpleCircleLoader-Zi-j2fk, reason: not valid java name */
    public static final void m10265Z17SimpleCircleLoaderZij2fk(Modifier modifier, float f10, float f11, long j10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        float f12;
        int i13;
        float fM8823constructorimpl;
        int i14;
        long j11;
        boolean z10;
        final Modifier modifier3;
        final float f13;
        final float f14;
        final long j12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM8823constructorimpl2;
        float f15;
        float f16;
        long primary;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1369686929);
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
        int i16 = i11 & 2;
        if (i16 == 0) {
            if ((i10 & 48) == 0) {
                f12 = f10;
                i12 |= composerStartRestartGroup.changed(f12) ? 32 : 16;
            }
            i13 = i11 & 4;
            if (i13 != 0) {
                if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    fM8823constructorimpl = f11;
                    if (composerStartRestartGroup.changed(fM8823constructorimpl)) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                    i12 |= i14;
                }
                if ((i10 & 3072) == 0) {
                    if ((i11 & 8) == 0) {
                        j11 = j10;
                        int i17 = composerStartRestartGroup.changed(j11) ? 2048 : 1024;
                        i12 |= i17;
                    } else {
                        j11 = j10;
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                if ((i12 & 1171) != 1170) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i16 != 0) {
                            fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                        } else {
                            fM8823constructorimpl2 = f12;
                        }
                        if (i13 != 0) {
                            fM8823constructorimpl = Dp.m8823constructorimpl(40);
                        }
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                            f15 = fM8823constructorimpl2;
                            f16 = fM8823constructorimpl;
                            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        } else {
                            f15 = fM8823constructorimpl2;
                            f16 = fM8823constructorimpl;
                            primary = j11;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 8) != 0) {
                            i12 &= -7169;
                        }
                        modifier3 = modifier2;
                        f16 = fM8823constructorimpl;
                        primary = j11;
                        f15 = f12;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1369686929, i12, -1, "cu.z17.views.loader.Z17SimpleCircleLoader (Z17SimpleCircleLoader.kt:17)");
                    }
                    ProgressIndicatorKt.m2699CircularProgressIndicatorLxG7B9w(SizeKt.m1769size3ABfNKs(modifier3, f16), primary, f15, 0L, 0, composerStartRestartGroup, ((i12 >> 6) & 112) | ((i12 << 3) & 896), 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f14 = f16;
                    j12 = primary;
                    f13 = f15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f13 = f12;
                    f14 = fM8823constructorimpl;
                    j12 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17SimpleCircleLoaderKt.Z17SimpleCircleLoader_Zi_j2fk$lambda$0(modifier3, f13, f14, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            fM8823constructorimpl = f11;
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    j11 = j10;
                    if (composerStartRestartGroup.changed(j11)) {
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            if ((i12 & 1171) != 1170) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f12;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(40);
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = j11;
                    }
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f12;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(40);
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1369686929, i12, -1, "cu.z17.views.loader.Z17SimpleCircleLoader (Z17SimpleCircleLoader.kt:17)");
                }
                ProgressIndicatorKt.m2699CircularProgressIndicatorLxG7B9w(SizeKt.m1769size3ABfNKs(modifier3, f16), primary, f15, 0L, 0, composerStartRestartGroup, ((i12 >> 6) & 112) | ((i12 << 3) & 896), 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f14 = f16;
                j12 = primary;
                f13 = f15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f13 = f12;
                f14 = fM8823constructorimpl;
                j12 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17SimpleCircleLoaderKt.Z17SimpleCircleLoader_Zi_j2fk$lambda$0(modifier3, f13, f14, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        f12 = f10;
        i13 = i11 & 4;
        if (i13 != 0) {
            if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                fM8823constructorimpl = f11;
                if (composerStartRestartGroup.changed(fM8823constructorimpl)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i12 |= i14;
            }
            if ((i10 & 3072) == 0) {
                if ((i11 & 8) == 0) {
                    j11 = j10;
                    if (composerStartRestartGroup.changed(j11)) {
                    }
                    i12 |= i17;
                } else {
                    j11 = j10;
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            if ((i12 & 1171) != 1170) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i15 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f12;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(40);
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = j11;
                    }
                } else {
                    if (i15 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i16 != 0) {
                        fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                    } else {
                        fM8823constructorimpl2 = f12;
                    }
                    if (i13 != 0) {
                        fM8823constructorimpl = Dp.m8823constructorimpl(40);
                    }
                    if ((i11 & 8) != 0) {
                        i12 &= -7169;
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    } else {
                        f15 = fM8823constructorimpl2;
                        f16 = fM8823constructorimpl;
                        primary = j11;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1369686929, i12, -1, "cu.z17.views.loader.Z17SimpleCircleLoader (Z17SimpleCircleLoader.kt:17)");
                }
                ProgressIndicatorKt.m2699CircularProgressIndicatorLxG7B9w(SizeKt.m1769size3ABfNKs(modifier3, f16), primary, f15, 0L, 0, composerStartRestartGroup, ((i12 >> 6) & 112) | ((i12 << 3) & 896), 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f14 = f16;
                j12 = primary;
                f13 = f15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f13 = f12;
                f14 = fM8823constructorimpl;
                j12 = j11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17SimpleCircleLoaderKt.Z17SimpleCircleLoader_Zi_j2fk$lambda$0(modifier3, f13, f14, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        fM8823constructorimpl = f11;
        if ((i10 & 3072) == 0) {
            if ((i11 & 8) == 0) {
                j11 = j10;
                if (composerStartRestartGroup.changed(j11)) {
                }
                i12 |= i17;
            } else {
                j11 = j10;
            }
            i12 |= i17;
        } else {
            j11 = j10;
        }
        if ((i12 & 1171) != 1170) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i15 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                } else {
                    fM8823constructorimpl2 = f12;
                }
                if (i13 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(40);
                }
                if ((i11 & 8) != 0) {
                    i12 &= -7169;
                    f15 = fM8823constructorimpl2;
                    f16 = fM8823constructorimpl;
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                } else {
                    f15 = fM8823constructorimpl2;
                    f16 = fM8823constructorimpl;
                    primary = j11;
                }
            } else {
                if (i15 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i16 != 0) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(5);
                } else {
                    fM8823constructorimpl2 = f12;
                }
                if (i13 != 0) {
                    fM8823constructorimpl = Dp.m8823constructorimpl(40);
                }
                if ((i11 & 8) != 0) {
                    i12 &= -7169;
                    f15 = fM8823constructorimpl2;
                    f16 = fM8823constructorimpl;
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                } else {
                    f15 = fM8823constructorimpl2;
                    f16 = fM8823constructorimpl;
                    primary = j11;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1369686929, i12, -1, "cu.z17.views.loader.Z17SimpleCircleLoader (Z17SimpleCircleLoader.kt:17)");
            }
            ProgressIndicatorKt.m2699CircularProgressIndicatorLxG7B9w(SizeKt.m1769size3ABfNKs(modifier3, f16), primary, f15, 0L, 0, composerStartRestartGroup, ((i12 >> 6) & 112) | ((i12 << 3) & 896), 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f14 = f16;
            j12 = primary;
            f13 = f15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            f13 = f12;
            f14 = fM8823constructorimpl;
            j12 = j11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: m9.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17SimpleCircleLoaderKt.Z17SimpleCircleLoader_Zi_j2fk$lambda$0(modifier3, f13, f14, j12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17SimpleCircleLoader_Zi_j2fk$lambda$0(Modifier modifier, float f10, float f11, long j10, int i10, int i11, Composer composer, int i12) {
        m10265Z17SimpleCircleLoaderZij2fk(modifier, f10, f11, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
