package cu.z17.views.imageEditor.sections.cropper.components.image;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraintsKt;
import cu.z17.views.imageEditor.sections.cropper.components.util.ImageContentScaleUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import rb.k;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u0086\u0001\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008a\u0001\u0010%\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0004\b#\u0010$\u001aO\u0010*\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "contentDescription", "", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "", "drawImage", "Lkotlin/Function1;", "Lcu/z17/views/imageEditor/sections/cropper/components/image/ImageScope;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "content", "ImageWithConstraints-nWU5RSE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ImageWithConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/IntRect;", "bitmapRect", "imageWidth", "imageHeight", "", "boxWidth", "boxHeight", "ImageLayout-QnyEGeY", "(JLandroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/unit/IntRect;FFIIFLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ImageLayout", "width", "height", "ImageImpl-Ay9G7rc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;IIFLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "ImageImpl", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageWithConstraintsKt {
    /* JADX WARN: Code duplicated, block: B:101:0x013e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0141  */
    /* JADX WARN: Code duplicated, block: B:105:0x014a  */
    /* JADX WARN: Code duplicated, block: B:106:0x014d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0158  */
    /* JADX WARN: Code duplicated, block: B:111:0x015e  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x017c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0198  */
    /* JADX WARN: Code duplicated, block: B:126:0x019f  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x007e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0081  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de A[PHI: r1 r12 r15
      0x00de: PHI (r1v23 int) = (r1v11 int), (r1v11 int), (r1v24 int) binds: [B:86:0x00ec, B:77:0x00db, B:78:0x00dd] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r12v9 float) = (r12v3 float), (r12v2 float), (r12v2 float) binds: [B:86:0x00ec, B:77:0x00db, B:78:0x00dd] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r15v11 androidx.compose.ui.graphics.ColorFilter) = 
      (r15v4 androidx.compose.ui.graphics.ColorFilter)
      (r15v3 androidx.compose.ui.graphics.ColorFilter)
      (r15v3 androidx.compose.ui.graphics.ColorFilter)
     binds: [B:86:0x00ec, B:77:0x00db, B:78:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:93:0x0118  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0122  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageImpl-Ay9G7rc, reason: not valid java name */
    private static final void m10178ImageImplAy9G7rc(final Modifier modifier, final ImageBitmap imageBitmap, final int i10, final int i11, float f10, ColorFilter colorFilter, int i12, Composer composer, final int i13, final int i14) {
        int i15;
        int i16;
        float f11;
        int i17;
        ColorFilter colorFilter2;
        int i18;
        int i19;
        boolean z10;
        boolean z11;
        final float f12;
        final int i20;
        final ColorFilter colorFilter3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final int iM6367getDefaultFilterQualityfv9h1I;
        final ColorFilter colorFilter4;
        final int width;
        final int height;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Object objRememberedValue;
        final float f13;
        int i21;
        Composer composerStartRestartGroup = composer.startRestartGroup(442366073);
        if ((i13 & 6) == 0) {
            i15 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i13;
        } else {
            i15 = i13;
        }
        if ((i13 & 48) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i16 = i10;
            i15 |= composerStartRestartGroup.changed(i16) ? 256 : 128;
        } else {
            i16 = i10;
        }
        if ((i13 & 3072) == 0) {
            i15 |= composerStartRestartGroup.changed(i11) ? 2048 : 1024;
        }
        int i22 = i14 & 16;
        if (i22 == 0) {
            if ((i13 & 24576) == 0) {
                f11 = f10;
                i15 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
            }
            i17 = i14 & 32;
            if (i17 != 0) {
                if ((196608 & i13) == 0) {
                    colorFilter2 = colorFilter;
                    if (composerStartRestartGroup.changed(colorFilter2)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i15 |= i18;
                }
                if ((i13 & 1572864) == 0) {
                    i19 = i12;
                    if ((i14 & 64) == 0 || !composerStartRestartGroup.changed(i19)) {
                        i21 = 524288;
                    } else {
                        i21 = 1048576;
                    }
                    i15 |= i21;
                } else {
                    i19 = i12;
                }
                z10 = true;
                if ((i15 & 599187) != 599186) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i13 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i22 != 0) {
                            f11 = 1.0f;
                        }
                        if (i17 != 0) {
                            colorFilter2 = null;
                        }
                        if ((i14 & 64) != 0) {
                            i15 &= -3670017;
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        }
                        colorFilter4 = colorFilter2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(442366073, i15, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageImpl (ImageWithConstraints.kt:200)");
                        }
                        width = imageBitmap.getWidth();
                        height = imageBitmap.getHeight();
                        Modifier modifierClipToBounds = ClipKt.clipToBounds(modifier);
                        if ((i15 & 7168) == 2048) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if ((i15 & 896) == 256) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance = z12 | z13 | composerStartRestartGroup.changedInstance(imageBitmap) | composerStartRestartGroup.changed(width) | composerStartRestartGroup.changed(height);
                        if ((57344 & i15) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z17 = zChangedInstance | z14;
                        if ((458752 & i15) == 131072) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z18 = z17 | z15;
                        if ((((3670016 & i15) ^ 1572864) > 1048576 || !composerStartRestartGroup.changed(iM6367getDefaultFilterQualityfv9h1I)) && (i15 & 1572864) != 1048576) {
                        }
                        z16 = z18 | z10;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            final int i23 = i16;
                            f13 = f11;
                            Function1 function1 = new Function1() { // from class: h9.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i23, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1);
                            objRememberedValue = function1;
                        } else {
                            f13 = f11;
                        }
                        CanvasKt.Canvas(modifierClipToBounds, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f12 = f13;
                        colorFilter3 = colorFilter4;
                        i20 = iM6367getDefaultFilterQualityfv9h1I;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i14 & 64) != 0) {
                            i15 &= -3670017;
                        }
                    }
                    iM6367getDefaultFilterQualityfv9h1I = i19;
                    colorFilter4 = colorFilter2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(442366073, i15, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageImpl (ImageWithConstraints.kt:200)");
                    }
                    width = imageBitmap.getWidth();
                    height = imageBitmap.getHeight();
                    Modifier modifierClipToBounds2 = ClipKt.clipToBounds(modifier);
                    if ((i15 & 7168) == 2048) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if ((i15 & 896) == 256) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance2 = z12 | z13 | composerStartRestartGroup.changedInstance(imageBitmap) | composerStartRestartGroup.changed(width) | composerStartRestartGroup.changed(height);
                    if ((57344 & i15) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z19 = zChangedInstance2 | z14;
                    if ((458752 & i15) == 131072) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z110 = z19 | z15;
                    z10 = ((3670016 & i15) ^ 1572864) > 1048576 ? false : false;
                    z16 = z110 | z10;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        final int i24 = i16;
                        f13 = f11;
                        Function1 function2 = new Function1() { // from class: h9.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i24, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function2);
                        objRememberedValue = function2;
                    } else {
                        final int i25 = i16;
                        f13 = f11;
                        Function1 function3 = new Function1() { // from class: h9.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i25, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function3);
                        objRememberedValue = function3;
                    }
                    CanvasKt.Canvas(modifierClipToBounds2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f12 = f13;
                    colorFilter3 = colorFilter4;
                    i20 = iM6367getDefaultFilterQualityfv9h1I;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f12 = f11;
                    i20 = i19;
                    colorFilter3 = colorFilter2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$9(modifier, imageBitmap, i10, i11, f12, colorFilter3, i20, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            colorFilter2 = colorFilter;
            if ((i13 & 1572864) == 0) {
                i19 = i12;
                if ((i14 & 64) == 0) {
                    i21 = 524288;
                } else {
                    i21 = 524288;
                }
                i15 |= i21;
            } else {
                i19 = i12;
            }
            z10 = true;
            if ((i15 & 599187) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i13 & 1) != 0) {
                    if (i22 != 0) {
                        f11 = 1.0f;
                    }
                    if (i17 != 0) {
                        colorFilter2 = null;
                    }
                    if ((i14 & 64) != 0) {
                        i15 &= -3670017;
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i19;
                    }
                } else {
                    if (i22 != 0) {
                        f11 = 1.0f;
                    }
                    if (i17 != 0) {
                        colorFilter2 = null;
                    }
                    if ((i14 & 64) != 0) {
                        i15 &= -3670017;
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i19;
                    }
                }
                colorFilter4 = colorFilter2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(442366073, i15, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageImpl (ImageWithConstraints.kt:200)");
                }
                width = imageBitmap.getWidth();
                height = imageBitmap.getHeight();
                Modifier modifierClipToBounds3 = ClipKt.clipToBounds(modifier);
                if ((i15 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i15 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance3 = z12 | z13 | composerStartRestartGroup.changedInstance(imageBitmap) | composerStartRestartGroup.changed(width) | composerStartRestartGroup.changed(height);
                if ((57344 & i15) == 16384) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z111 = zChangedInstance3 | z14;
                if ((458752 & i15) == 131072) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z112 = z111 | z15;
                if (((3670016 & i15) ^ 1572864) > 1048576) {
                }
                z16 = z112 | z10;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    final int i26 = i16;
                    f13 = f11;
                    Function1 function4 = new Function1() { // from class: h9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i26, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function4);
                    objRememberedValue = function4;
                } else {
                    final int i27 = i16;
                    f13 = f11;
                    Function1 function5 = new Function1() { // from class: h9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i27, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function5);
                    objRememberedValue = function5;
                }
                CanvasKt.Canvas(modifierClipToBounds3, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                colorFilter3 = colorFilter4;
                i20 = iM6367getDefaultFilterQualityfv9h1I;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f11;
                i20 = i19;
                colorFilter3 = colorFilter2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$9(modifier, imageBitmap, i10, i11, f12, colorFilter3, i20, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i15 |= 24576;
        f11 = f10;
        i17 = i14 & 32;
        if (i17 != 0) {
            if ((196608 & i13) == 0) {
                colorFilter2 = colorFilter;
                if (composerStartRestartGroup.changed(colorFilter2)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i15 |= i18;
            }
            if ((i13 & 1572864) == 0) {
                i19 = i12;
                if ((i14 & 64) == 0) {
                    i21 = 524288;
                } else {
                    i21 = 524288;
                }
                i15 |= i21;
            } else {
                i19 = i12;
            }
            z10 = true;
            if ((i15 & 599187) != 599186) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i13 & 1) != 0) {
                    if (i22 != 0) {
                        f11 = 1.0f;
                    }
                    if (i17 != 0) {
                        colorFilter2 = null;
                    }
                    if ((i14 & 64) != 0) {
                        i15 &= -3670017;
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i19;
                    }
                } else {
                    if (i22 != 0) {
                        f11 = 1.0f;
                    }
                    if (i17 != 0) {
                        colorFilter2 = null;
                    }
                    if ((i14 & 64) != 0) {
                        i15 &= -3670017;
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i19;
                    }
                }
                colorFilter4 = colorFilter2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(442366073, i15, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageImpl (ImageWithConstraints.kt:200)");
                }
                width = imageBitmap.getWidth();
                height = imageBitmap.getHeight();
                Modifier modifierClipToBounds4 = ClipKt.clipToBounds(modifier);
                if ((i15 & 7168) == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i15 & 896) == 256) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance4 = z12 | z13 | composerStartRestartGroup.changedInstance(imageBitmap) | composerStartRestartGroup.changed(width) | composerStartRestartGroup.changed(height);
                if ((57344 & i15) == 16384) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z113 = zChangedInstance4 | z14;
                if ((458752 & i15) == 131072) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z114 = z113 | z15;
                if (((3670016 & i15) ^ 1572864) > 1048576) {
                }
                z16 = z114 | z10;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    final int i28 = i16;
                    f13 = f11;
                    Function1 function6 = new Function1() { // from class: h9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i28, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function6);
                    objRememberedValue = function6;
                } else {
                    final int i29 = i16;
                    f13 = f11;
                    Function1 function7 = new Function1() { // from class: h9.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i29, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function7);
                    objRememberedValue = function7;
                }
                CanvasKt.Canvas(modifierClipToBounds4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                colorFilter3 = colorFilter4;
                i20 = iM6367getDefaultFilterQualityfv9h1I;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f11;
                i20 = i19;
                colorFilter3 = colorFilter2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$9(modifier, imageBitmap, i10, i11, f12, colorFilter3, i20, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        colorFilter2 = colorFilter;
        if ((i13 & 1572864) == 0) {
            i19 = i12;
            if ((i14 & 64) == 0) {
                i21 = 524288;
            } else {
                i21 = 524288;
            }
            i15 |= i21;
        } else {
            i19 = i12;
        }
        z10 = true;
        if ((i15 & 599187) != 599186) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i13 & 1) != 0) {
                if (i22 != 0) {
                    f11 = 1.0f;
                }
                if (i17 != 0) {
                    colorFilter2 = null;
                }
                if ((i14 & 64) != 0) {
                    i15 &= -3670017;
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i19;
                }
            } else {
                if (i22 != 0) {
                    f11 = 1.0f;
                }
                if (i17 != 0) {
                    colorFilter2 = null;
                }
                if ((i14 & 64) != 0) {
                    i15 &= -3670017;
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i19;
                }
            }
            colorFilter4 = colorFilter2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442366073, i15, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageImpl (ImageWithConstraints.kt:200)");
            }
            width = imageBitmap.getWidth();
            height = imageBitmap.getHeight();
            Modifier modifierClipToBounds5 = ClipKt.clipToBounds(modifier);
            if ((i15 & 7168) == 2048) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((i15 & 896) == 256) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean zChangedInstance5 = z12 | z13 | composerStartRestartGroup.changedInstance(imageBitmap) | composerStartRestartGroup.changed(width) | composerStartRestartGroup.changed(height);
            if ((57344 & i15) == 16384) {
                z14 = true;
            } else {
                z14 = false;
            }
            boolean z115 = zChangedInstance5 | z14;
            if ((458752 & i15) == 131072) {
                z15 = true;
            } else {
                z15 = false;
            }
            boolean z116 = z115 | z15;
            if (((3670016 & i15) ^ 1572864) > 1048576) {
            }
            z16 = z116 | z10;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z16) {
                final int i210 = i16;
                f13 = f11;
                Function1 function8 = new Function1() { // from class: h9.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i210, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function8);
                objRememberedValue = function8;
            } else {
                final int i211 = i16;
                f13 = f11;
                Function1 function9 = new Function1() { // from class: h9.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$8$lambda$7(i11, i211, imageBitmap, width, height, f13, colorFilter4, iM6367getDefaultFilterQualityfv9h1I, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function9);
                objRememberedValue = function9;
            }
            CanvasKt.Canvas(modifierClipToBounds5, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f12 = f13;
            colorFilter3 = colorFilter4;
            i20 = iM6367getDefaultFilterQualityfv9h1I;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f12 = f11;
            i20 = i19;
            colorFilter3 = colorFilter2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageWithConstraintsKt.ImageImpl_Ay9G7rc$lambda$9(modifier, imageBitmap, i10, i11, f12, colorFilter3, i20, i13, i14, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageImpl_Ay9G7rc$lambda$8$lambda$7(int i10, int i11, ImageBitmap imageBitmap, int i12, int i13, float f10, ColorFilter colorFilter, int i14, DrawScope Canvas) throws Throwable {
        float f11;
        float f12;
        y.i(Canvas, "$this$Canvas");
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (Canvas.mo6334getSizeNHjbRc() >> 32));
        float fIntBitsToFloat = ((-i10) + ((int) Float.intBitsToFloat((int) (Canvas.mo6334getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) / 2.0f;
        float f13 = ((-i11) + iIntBitsToFloat) / 2.0f;
        Canvas.getDrawContext().getTransform().translate(f13, fIntBitsToFloat);
        try {
            f12 = fIntBitsToFloat;
            f11 = f13;
            try {
                DrawScope.CC.B(Canvas, imageBitmap, 0L, IntSize.m8985constructorimpl((((long) i12) << 32) | (((long) i13) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0L, IntSize.m8985constructorimpl((((long) i11) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) i10))), f10, null, colorFilter, 0, i14, 330, null);
                Canvas.getDrawContext().getTransform().translate(-f11, -f12);
                return k0.f43947a;
            } catch (Throwable th2) {
                th = th2;
                Canvas.getDrawContext().getTransform().translate(-f11, -f12);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            f11 = f13;
            f12 = fIntBitsToFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageImpl_Ay9G7rc$lambda$9(Modifier modifier, ImageBitmap imageBitmap, int i10, int i11, float f10, ColorFilter colorFilter, int i12, int i13, int i14, Composer composer, int i15) {
        m10178ImageImplAy9G7rc(modifier, imageBitmap, i10, i11, f10, colorFilter, i12, composer, RecomposeScopeImplKt.updateChangedFlags(i13 | 1), i14);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0129  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:121:0x0171 A[PHI: r3 r4 r9 r15
      0x0171: PHI (r3v34 float) = (r3v22 float), (r3v39 float) binds: [B:133:0x01a0, B:120:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r4v11 androidx.compose.ui.graphics.ColorFilter) = (r4v8 androidx.compose.ui.graphics.ColorFilter), (r4v14 androidx.compose.ui.graphics.ColorFilter) binds: [B:133:0x01a0, B:120:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r9v16 int) = (r9v11 int), (r9v18 int) binds: [B:133:0x01a0, B:120:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r15v11 int) = (r15v4 int), (r15v13 int) binds: [B:133:0x01a0, B:120:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:123:0x017e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x0180  */
    /* JADX WARN: Code duplicated, block: B:126:0x0185  */
    /* JADX WARN: Code duplicated, block: B:127:0x0187  */
    /* JADX WARN: Code duplicated, block: B:130:0x018d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0196  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:143:0x0229  */
    /* JADX WARN: Code duplicated, block: B:146:0x0246  */
    /* JADX WARN: Code duplicated, block: B:148:0x0252  */
    /* JADX WARN: Code duplicated, block: B:151:0x0263  */
    /* JADX WARN: Code duplicated, block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00df  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x0110  */
    /* JADX WARN: Code duplicated, block: B:94:0x0113  */
    /* JADX WARN: Code duplicated, block: B:96:0x0118  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ImageLayout-QnyEGeY, reason: not valid java name */
    private static final void m10179ImageLayoutQnyEGeY(final long j10, final ImageBitmap imageBitmap, final IntRect intRect, final float f10, final float f11, final int i10, final int i11, float f12, ColorFilter colorFilter, int i12, boolean z10, final Function3 function3, Composer composer, final int i13, final int i14, final int i15) {
        int i16;
        ImageBitmap imageBitmap2;
        float f13;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z11;
        Composer composer2;
        final ColorFilter colorFilter2;
        final int i22;
        final boolean z12;
        final float f14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ColorFilter colorFilter3;
        int iM6367getDefaultFilterQualityfv9h1I;
        int i23;
        ColorFilter colorFilter4;
        float f15;
        int i24;
        boolean z13;
        float fMo1341toDpu2uoSUM;
        float fMo1341toDpu2uoSUM2;
        int i25;
        float f16;
        ColorFilter colorFilter5;
        int i26;
        Composer composerStartRestartGroup = composer.startRestartGroup(1281393859);
        if ((i13 & 6) == 0) {
            i16 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i13;
        } else {
            i16 = i13;
        }
        if ((i13 & 48) == 0) {
            imageBitmap2 = imageBitmap;
            i16 |= composerStartRestartGroup.changedInstance(imageBitmap2) ? 32 : 16;
        } else {
            imageBitmap2 = imageBitmap;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i16 |= composerStartRestartGroup.changed(intRect) ? 256 : 128;
        }
        if ((i13 & 3072) == 0) {
            i16 |= composerStartRestartGroup.changed(f10) ? 2048 : 1024;
        }
        if ((i13 & 24576) == 0) {
            i16 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
        }
        if ((196608 & i13) == 0) {
            i16 |= composerStartRestartGroup.changed(i10) ? 131072 : 65536;
        }
        if ((1572864 & i13) == 0) {
            i16 |= composerStartRestartGroup.changed(i11) ? 1048576 : 524288;
        }
        int i27 = i15 & 128;
        if (i27 != 0) {
            i16 |= 12582912;
            f13 = f12;
        } else {
            f13 = f12;
            if ((i13 & 12582912) == 0) {
                i16 |= composerStartRestartGroup.changed(f13) ? 8388608 : 4194304;
            }
        }
        int i28 = i15 & 256;
        if (i28 == 0) {
            if ((i13 & 100663296) == 0) {
                i16 |= composerStartRestartGroup.changed(colorFilter) ? 67108864 : 33554432;
            }
            if ((i13 & 805306368) != 0) {
                i16 |= ((i15 & 512) == 0 || !composerStartRestartGroup.changed(i12)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i17 = i15 & 1024;
            if (i17 != 0) {
                i18 = i14 | 6;
            } else if ((i14 & 6) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i14 | i19;
            } else {
                i18 = i14;
            }
            if ((i14 & 48) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            i20 = i18;
            i21 = i16;
            if ((i21 & 306783379) == 306783378 || (i20 & 19) != 18) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i21 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i13 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i27 != 0) {
                        f13 = 1.0f;
                    }
                    if (i28 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i15 & 512) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i23 = i21 & (-1879048193);
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i12;
                        i23 = i21;
                    }
                    int i29 = i23;
                    colorFilter4 = colorFilter3;
                    f15 = f13;
                    i24 = i29;
                    if (i17 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i15 & 512) != 0) {
                        float f17 = f13;
                        i24 = i21 & (-1879048193);
                        f15 = f17;
                        colorFilter4 = colorFilter;
                        iM6367getDefaultFilterQualityfv9h1I = i12;
                        z13 = z10;
                    } else {
                        colorFilter4 = colorFilter;
                        iM6367getDefaultFilterQualityfv9h1I = i12;
                        z13 = z10;
                        f15 = f13;
                        i24 = i21;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1281393859, i24, i20, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageLayout (ImageWithConstraints.kt:149)");
                }
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                fMo1341toDpu2uoSUM = density.mo1341toDpu2uoSUM(k.i(f10, i10));
                fMo1341toDpu2uoSUM2 = density.mo1341toDpu2uoSUM(k.i(f11, i11));
                i25 = i24;
                ImageScopeImpl imageScopeImpl = new ImageScopeImpl(density, j10, fMo1341toDpu2uoSUM, fMo1341toDpu2uoSUM2, intRect, null);
                if (z13) {
                    composerStartRestartGroup.startReplaceGroup(336544749);
                    int i30 = i25 & 112;
                    int i31 = i25 >> 9;
                    f16 = f15;
                    colorFilter5 = colorFilter4;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    m10178ImageImplAy9G7rc(SizeKt.m1771sizeVpY3zN4(Modifier.INSTANCE, fMo1341toDpu2uoSUM, fMo1341toDpu2uoSUM2), imageBitmap2, (int) f10, (int) f11, f16, colorFilter5, i26, composerStartRestartGroup, i30 | (i31 & 57344) | (i31 & 458752) | (i31 & 3670016), 0);
                    composer2 = composerStartRestartGroup;
                } else {
                    f16 = f15;
                    composer2 = composerStartRestartGroup;
                    colorFilter5 = colorFilter4;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    composer2.startReplaceGroup(329090303);
                }
                composer2.endReplaceGroup();
                function3.invoke(imageScopeImpl, composer2, Integer.valueOf(i20 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f14 = f16;
                colorFilter2 = colorFilter5;
                i22 = i26;
                z12 = z13;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                colorFilter2 = colorFilter;
                i22 = i12;
                z12 = z10;
                f14 = f13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageLayout_QnyEGeY$lambda$5(j10, imageBitmap, intRect, f10, f11, i10, i11, f14, colorFilter2, i22, z12, function3, i13, i14, i15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i16 |= 100663296;
        if ((i13 & 805306368) != 0) {
            i16 |= ((i15 & 512) == 0 || !composerStartRestartGroup.changed(i12)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        i17 = i15 & 1024;
        if (i17 != 0) {
            i18 = i14 | 6;
        } else if ((i14 & 6) == 0) {
            if (composerStartRestartGroup.changed(z10)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i18 = i14 | i19;
        } else {
            i18 = i14;
        }
        if ((i14 & 48) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        i20 = i18;
        i21 = i16;
        if ((i21 & 306783379) == 306783378) {
            z11 = true;
        } else {
            z11 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i21 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i13 & 1) != 0) {
                if (i27 != 0) {
                    f13 = 1.0f;
                }
                if (i28 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if ((i15 & 512) != 0) {
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    i23 = i21 & (-1879048193);
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i12;
                    i23 = i21;
                }
                int i210 = i23;
                colorFilter4 = colorFilter3;
                f15 = f13;
                i24 = i210;
                if (i17 != 0) {
                    z13 = true;
                } else {
                    z13 = z10;
                }
            } else {
                if (i27 != 0) {
                    f13 = 1.0f;
                }
                if (i28 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if ((i15 & 512) != 0) {
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    i23 = i21 & (-1879048193);
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i12;
                    i23 = i21;
                }
                int i211 = i23;
                colorFilter4 = colorFilter3;
                f15 = f13;
                i24 = i211;
                if (i17 != 0) {
                    z13 = true;
                } else {
                    z13 = z10;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1281393859, i24, i20, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageLayout (ImageWithConstraints.kt:149)");
            }
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            fMo1341toDpu2uoSUM = density2.mo1341toDpu2uoSUM(k.i(f10, i10));
            fMo1341toDpu2uoSUM2 = density2.mo1341toDpu2uoSUM(k.i(f11, i11));
            i25 = i24;
            ImageScopeImpl imageScopeImpl2 = new ImageScopeImpl(density2, j10, fMo1341toDpu2uoSUM, fMo1341toDpu2uoSUM2, intRect, null);
            if (z13) {
                composerStartRestartGroup.startReplaceGroup(336544749);
                int i32 = i25 & 112;
                int i33 = i25 >> 9;
                f16 = f15;
                colorFilter5 = colorFilter4;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                m10178ImageImplAy9G7rc(SizeKt.m1771sizeVpY3zN4(Modifier.INSTANCE, fMo1341toDpu2uoSUM, fMo1341toDpu2uoSUM2), imageBitmap2, (int) f10, (int) f11, f16, colorFilter5, i26, composerStartRestartGroup, i32 | (i33 & 57344) | (i33 & 458752) | (i33 & 3670016), 0);
                composer2 = composerStartRestartGroup;
            } else {
                f16 = f15;
                composer2 = composerStartRestartGroup;
                colorFilter5 = colorFilter4;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                composer2.startReplaceGroup(329090303);
            }
            composer2.endReplaceGroup();
            function3.invoke(imageScopeImpl2, composer2, Integer.valueOf(i20 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f14 = f16;
            colorFilter2 = colorFilter5;
            i22 = i26;
            z12 = z13;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            colorFilter2 = colorFilter;
            i22 = i12;
            z12 = z10;
            f14 = f13;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageWithConstraintsKt.ImageLayout_QnyEGeY$lambda$5(j10, imageBitmap, intRect, f10, f11, i10, i11, f14, colorFilter2, i22, z12, function3, i13, i14, i15, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageLayout_QnyEGeY$lambda$5(long j10, ImageBitmap imageBitmap, IntRect intRect, float f10, float f11, int i10, int i11, float f12, ColorFilter colorFilter, int i12, boolean z10, Function3 function3, int i13, int i14, int i15, Composer composer, int i16) {
        m10179ImageLayoutQnyEGeY(j10, imageBitmap, intRect, f10, f11, i10, i11, f12, colorFilter, i12, z10, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i13 | 1), RecomposeScopeImplKt.updateChangedFlags(i14), i15);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:103:0x012a  */
    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x013d  */
    /* JADX WARN: Code duplicated, block: B:109:0x013f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0148  */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:121:0x0168 A[PHI: r0 r4 r5 r6 r7 r8 r9 r13 r14
      0x0168: PHI (r0v35 androidx.compose.ui.graphics.ColorFilter) = (r0v17 androidx.compose.ui.graphics.ColorFilter), (r0v38 androidx.compose.ui.graphics.ColorFilter) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r4v10 androidx.compose.ui.Modifier) = (r4v6 androidx.compose.ui.Modifier), (r4v3 androidx.compose.ui.Modifier) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r5v32 int) = (r5v25 int), (r5v33 int) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r6v11 int) = (r6v6 int), (r6v12 int) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r7v9 androidx.compose.ui.Alignment) = (r7v5 androidx.compose.ui.Alignment), (r7v2 androidx.compose.ui.Alignment) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r8v12 boolean) = (r8v8 boolean), (r8v13 boolean) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r9v9 androidx.compose.ui.layout.ContentScale) = (r9v5 androidx.compose.ui.layout.ContentScale), (r9v2 androidx.compose.ui.layout.ContentScale) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r13v6 float) = (r13v3 float), (r13v1 float) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r14v6 java.lang.String) = (r14v3 java.lang.String), (r14v2 java.lang.String) binds: [B:142:0x01a5, B:120:0x0162] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x016b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x016d  */
    /* JADX WARN: Code duplicated, block: B:125:0x0172  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0184  */
    /* JADX WARN: Code duplicated, block: B:131:0x0187  */
    /* JADX WARN: Code duplicated, block: B:133:0x018c  */
    /* JADX WARN: Code duplicated, block: B:134:0x018e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0194  */
    /* JADX WARN: Code duplicated, block: B:138:0x019d  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:154:0x01da  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:158:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:161:0x0250  */
    /* JADX WARN: Code duplicated, block: B:163:0x025c  */
    /* JADX WARN: Code duplicated, block: B:166:0x0273  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:93:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0115  */
    /* JADX WARN: Code duplicated, block: B:99:0x011c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ImageWithConstraints-nWU5RSE, reason: not valid java name */
    public static final void m10180ImageWithConstraintsnWU5RSE(Modifier modifier, final ImageBitmap imageBitmap, Alignment alignment, ContentScale contentScale, String str, float f10, ColorFilter colorFilter, int i10, boolean z10, Function3 function3, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        Alignment center;
        int i14;
        ContentScale fit;
        int i15;
        int i16;
        final String str2;
        int i17;
        int i18;
        float f11;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z11;
        Composer composer2;
        final int i26;
        final Function3 function3M10164getLambda$1210636210$views_release;
        final Modifier modifier3;
        final Alignment alignment2;
        final ContentScale contentScale2;
        final ColorFilter colorFilter2;
        final boolean z12;
        final float f12;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final ColorFilter colorFilter3;
        int iM6367getDefaultFilterQualityfv9h1I;
        boolean z13;
        Modifier modifierSemantics$default;
        boolean z14;
        Object objRememberedValue;
        y.i(imageBitmap, "imageBitmap");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1317633406);
        int i27 = i12 & 1;
        if (i27 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        int i28 = i12 & 4;
        if (i28 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                center = alignment;
                i13 |= composerStartRestartGroup.changed(center) ? 256 : 128;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i11 & 3072) == 0) {
                    fit = contentScale;
                    if (composerStartRestartGroup.changed(fit)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i13 |= i15;
                }
                i16 = i12 & 16;
                if (i16 != 0) {
                    if ((i11 & 24576) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i17 = 16384;
                        } else {
                            i17 = 8192;
                        }
                        i13 |= i17;
                    }
                    i18 = i12 & 32;
                    if (i18 != 0) {
                        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f11 = f10;
                    } else {
                        f11 = f10;
                        if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(f11)) {
                                i19 = 131072;
                            } else {
                                i19 = 65536;
                            }
                            i13 |= i19;
                        }
                    }
                    i20 = i12 & 64;
                    if (i20 != 0) {
                        i13 |= 1572864;
                    } else if ((i11 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(colorFilter)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i13 |= i21;
                    }
                    if ((i11 & 12582912) != 0) {
                        i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
                    }
                    i22 = i12 & 256;
                    if (i22 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(z10)) {
                                i23 = 67108864;
                            } else {
                                i23 = 33554432;
                            }
                            i13 |= i23;
                        }
                        i24 = i12 & 512;
                        if (i24 != 0) {
                            if ((i11 & 805306368) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i25 = 268435456;
                                }
                                i13 |= i25;
                            }
                            if ((i13 & 306783379) != 306783378) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i27 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i28 != 0) {
                                        center = Alignment.INSTANCE.getCenter();
                                    }
                                    if (i14 != 0) {
                                        fit = ContentScale.INSTANCE.getFit();
                                    }
                                    if (i16 != 0) {
                                        str2 = null;
                                    }
                                    if (i18 != 0) {
                                        f11 = 1.0f;
                                    }
                                    if (i20 != 0) {
                                        colorFilter3 = null;
                                    } else {
                                        colorFilter3 = colorFilter;
                                    }
                                    if ((i12 & 128) != 0) {
                                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                        i13 &= -29360129;
                                    } else {
                                        iM6367getDefaultFilterQualityfv9h1I = i10;
                                    }
                                    if (i22 != 0) {
                                        z13 = true;
                                    } else {
                                        z13 = z10;
                                    }
                                    if (i24 != 0) {
                                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                                    }
                                    if (str2 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        if ((57344 & i13) == 16384) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (z14 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function1() { // from class: h9.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                                        composerStartRestartGroup.endReplaceGroup();
                                        modifierSemantics$default = Modifier.INSTANCE;
                                    }
                                    final int i29 = iM6367getDefaultFilterQualityfv9h1I;
                                    final boolean z15 = z13;
                                    final ContentScale contentScale3 = fit;
                                    final Function3 function4 = function3M10164getLambda$1210636210$views_release;
                                    final float f13 = f11;
                                    ColorFilter colorFilter4 = colorFilter3;
                                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale3, f13, colorFilter3, i29, z15, function4, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                                    composer2 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    alignment2 = center;
                                    contentScale2 = fit;
                                    colorFilter2 = colorFilter4;
                                    z12 = z13;
                                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                                    str3 = str2;
                                    f12 = f11;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i12 & 128) != 0) {
                                        i13 &= -29360129;
                                    }
                                    colorFilter3 = colorFilter;
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                    z13 = z10;
                                }
                                function3M10164getLambda$1210636210$views_release = function3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                                }
                                if (str2 != null) {
                                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    if ((57344 & i13) == 16384) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (z14) {
                                        objRememberedValue = new Function1() { // from class: h9.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        objRememberedValue = new Function1() { // from class: h9.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                                    composerStartRestartGroup.endReplaceGroup();
                                    modifierSemantics$default = Modifier.INSTANCE;
                                }
                                final int i210 = iM6367getDefaultFilterQualityfv9h1I;
                                final boolean z16 = z13;
                                final ContentScale contentScale4 = fit;
                                final Function3 function5 = function3M10164getLambda$1210636210$views_release;
                                final float f14 = f11;
                                ColorFilter colorFilter5 = colorFilter3;
                                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale4, f14, colorFilter3, i210, z16, function5, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                alignment2 = center;
                                contentScale2 = fit;
                                colorFilter2 = colorFilter5;
                                z12 = z13;
                                i26 = iM6367getDefaultFilterQualityfv9h1I;
                                str3 = str2;
                                f12 = f11;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                i26 = i10;
                                function3M10164getLambda$1210636210$views_release = function3;
                                modifier3 = modifier2;
                                alignment2 = center;
                                contentScale2 = fit;
                                colorFilter2 = colorFilter;
                                z12 = z10;
                                f12 = f11;
                                str3 = str2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i13 |= 805306368;
                        if ((i13 & 306783379) != 306783378) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            } else {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                            }
                            if (str2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1910153930);
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                if ((57344 & i13) == 16384) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z14) {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1910014616);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            final int i211 = iM6367getDefaultFilterQualityfv9h1I;
                            final boolean z17 = z13;
                            final ContentScale contentScale5 = fit;
                            final Function3 function6 = function3M10164getLambda$1210636210$views_release;
                            final float f15 = f11;
                            ColorFilter colorFilter6 = colorFilter3;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale5, f15, colorFilter3, i211, z17, function6, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter6;
                            z12 = z13;
                            i26 = iM6367getDefaultFilterQualityfv9h1I;
                            str3 = str2;
                            f12 = f11;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i10;
                            function3M10164getLambda$1210636210$views_release = function3;
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter;
                            z12 = z10;
                            f12 = f11;
                            str3 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    i24 = i12 & 512;
                    if (i24 != 0) {
                        if ((i11 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i25 = 268435456;
                            }
                            i13 |= i25;
                        }
                        if ((i13 & 306783379) != 306783378) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            } else {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                            }
                            if (str2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1910153930);
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                if ((57344 & i13) == 16384) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z14) {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion4, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1910014616);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            final int i212 = iM6367getDefaultFilterQualityfv9h1I;
                            final boolean z18 = z13;
                            final ContentScale contentScale6 = fit;
                            final Function3 function7 = function3M10164getLambda$1210636210$views_release;
                            final float f16 = f11;
                            ColorFilter colorFilter7 = colorFilter3;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale6, f16, colorFilter3, i212, z18, function7, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter7;
                            z12 = z13;
                            i26 = iM6367getDefaultFilterQualityfv9h1I;
                            str3 = str2;
                            f12 = f11;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i10;
                            function3M10164getLambda$1210636210$views_release = function3;
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter;
                            z12 = z10;
                            f12 = f11;
                            str3 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion5 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion5, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i213 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z19 = z13;
                        final ContentScale contentScale7 = fit;
                        final Function3 function8 = function3M10164getLambda$1210636210$views_release;
                        final float f17 = f11;
                        ColorFilter colorFilter8 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale7, f17, colorFilter3, i213, z19, function8, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter8;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                str2 = str;
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f10;
                } else {
                    f11 = f10;
                    if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i19 = 131072;
                        } else {
                            i19 = 65536;
                        }
                        i13 |= i19;
                    }
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i11 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z10)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    i24 = i12 & 512;
                    if (i24 != 0) {
                        if ((i11 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i25 = 268435456;
                            }
                            i13 |= i25;
                        }
                        if ((i13 & 306783379) != 306783378) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            } else {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                            }
                            if (str2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1910153930);
                                Modifier.Companion companion6 = Modifier.INSTANCE;
                                if ((57344 & i13) == 16384) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z14) {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion6, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1910014616);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            final int i214 = iM6367getDefaultFilterQualityfv9h1I;
                            final boolean z110 = z13;
                            final ContentScale contentScale8 = fit;
                            final Function3 function9 = function3M10164getLambda$1210636210$views_release;
                            final float f18 = f11;
                            ColorFilter colorFilter9 = colorFilter3;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale8, f18, colorFilter3, i214, z110, function9, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter9;
                            z12 = z13;
                            i26 = iM6367getDefaultFilterQualityfv9h1I;
                            str3 = str2;
                            f12 = f11;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i10;
                            function3M10164getLambda$1210636210$views_release = function3;
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter;
                            z12 = z10;
                            f12 = f11;
                            str3 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion7 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion7, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i215 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z111 = z13;
                        final ContentScale contentScale9 = fit;
                        final Function3 function10 = function3M10164getLambda$1210636210$views_release;
                        final float f19 = f11;
                        ColorFilter colorFilter10 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale9, f19, colorFilter3, i215, z111, function10, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter10;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion8 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion8, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i216 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z112 = z13;
                        final ContentScale contentScale10 = fit;
                        final Function3 function11 = function3M10164getLambda$1210636210$views_release;
                        final float f110 = f11;
                        ColorFilter colorFilter11 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale10, f110, colorFilter3, i216, z112, function11, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter11;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion9 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion9, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i217 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z113 = z13;
                    final ContentScale contentScale11 = fit;
                    final Function3 function12 = function3M10164getLambda$1210636210$views_release;
                    final float f111 = f11;
                    ColorFilter colorFilter12 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale11, f111, colorFilter3, i217, z113, function12, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter12;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            fit = contentScale;
            i16 = i12 & 16;
            if (i16 != 0) {
                if ((i11 & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f10;
                } else {
                    f11 = f10;
                    if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i19 = 131072;
                        } else {
                            i19 = 65536;
                        }
                        i13 |= i19;
                    }
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i11 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z10)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    i24 = i12 & 512;
                    if (i24 != 0) {
                        if ((i11 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i25 = 268435456;
                            }
                            i13 |= i25;
                        }
                        if ((i13 & 306783379) != 306783378) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            } else {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                            }
                            if (str2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1910153930);
                                Modifier.Companion companion10 = Modifier.INSTANCE;
                                if ((57344 & i13) == 16384) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z14) {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion10, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1910014616);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            final int i218 = iM6367getDefaultFilterQualityfv9h1I;
                            final boolean z114 = z13;
                            final ContentScale contentScale12 = fit;
                            final Function3 function13 = function3M10164getLambda$1210636210$views_release;
                            final float f112 = f11;
                            ColorFilter colorFilter13 = colorFilter3;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale12, f112, colorFilter3, i218, z114, function13, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter13;
                            z12 = z13;
                            i26 = iM6367getDefaultFilterQualityfv9h1I;
                            str3 = str2;
                            f12 = f11;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i10;
                            function3M10164getLambda$1210636210$views_release = function3;
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter;
                            z12 = z10;
                            f12 = f11;
                            str3 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion11 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion11, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i219 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z115 = z13;
                        final ContentScale contentScale13 = fit;
                        final Function3 function14 = function3M10164getLambda$1210636210$views_release;
                        final float f113 = f11;
                        ColorFilter colorFilter14 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale13, f113, colorFilter3, i219, z115, function14, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter14;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion12 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion12, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i2110 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z116 = z13;
                        final ContentScale contentScale14 = fit;
                        final Function3 function15 = function3M10164getLambda$1210636210$views_release;
                        final float f114 = f11;
                        ColorFilter colorFilter15 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale14, f114, colorFilter3, i2110, z116, function15, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter15;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion13 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion13, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i2111 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z117 = z13;
                    final ContentScale contentScale15 = fit;
                    final Function3 function16 = function3M10164getLambda$1210636210$views_release;
                    final float f115 = f11;
                    ColorFilter colorFilter16 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale15, f115, colorFilter3, i2111, z117, function16, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter16;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f10;
            } else {
                f11 = f10;
                if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((i11 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
            }
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z10)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion14 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion14, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i2112 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z118 = z13;
                        final ContentScale contentScale16 = fit;
                        final Function3 function17 = function3M10164getLambda$1210636210$views_release;
                        final float f116 = f11;
                        ColorFilter colorFilter17 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale16, f116, colorFilter3, i2112, z118, function17, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter17;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion15 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion15, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i2113 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z119 = z13;
                    final ContentScale contentScale17 = fit;
                    final Function3 function18 = function3M10164getLambda$1210636210$views_release;
                    final float f117 = f11;
                    ColorFilter colorFilter18 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale17, f117, colorFilter3, i2113, z119, function18, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter18;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            i24 = i12 & 512;
            if (i24 != 0) {
                if ((i11 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion16 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion16, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i2114 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z1110 = z13;
                    final ContentScale contentScale18 = fit;
                    final Function3 function19 = function3M10164getLambda$1210636210$views_release;
                    final float f118 = f11;
                    ColorFilter colorFilter19 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale18, f118, colorFilter3, i2114, z1110, function19, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter19;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i13 & 306783379) != 306783378) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                } else {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                }
                if (str2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                    Modifier.Companion companion17 = Modifier.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion17, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierSemantics$default = Modifier.INSTANCE;
                }
                final int i2115 = iM6367getDefaultFilterQualityfv9h1I;
                final boolean z1111 = z13;
                final ContentScale contentScale19 = fit;
                final Function3 function110 = function3M10164getLambda$1210636210$views_release;
                final float f119 = f11;
                ColorFilter colorFilter110 = colorFilter3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale19, f119, colorFilter3, i2115, z1111, function110, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter110;
                z12 = z13;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                str3 = str2;
                f12 = f11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i26 = i10;
                function3M10164getLambda$1210636210$views_release = function3;
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter;
                z12 = z10;
                f12 = f11;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        center = alignment;
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i11 & 3072) == 0) {
                fit = contentScale;
                if (composerStartRestartGroup.changed(fit)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i13 |= i15;
            }
            i16 = i12 & 16;
            if (i16 != 0) {
                if ((i11 & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i13 |= i17;
                }
                i18 = i12 & 32;
                if (i18 != 0) {
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f10;
                } else {
                    f11 = f10;
                    if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i19 = 131072;
                        } else {
                            i19 = 65536;
                        }
                        i13 |= i19;
                    }
                }
                i20 = i12 & 64;
                if (i20 != 0) {
                    i13 |= 1572864;
                } else if ((i11 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i13 |= i21;
                }
                if ((i11 & 12582912) != 0) {
                    i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
                }
                i22 = i12 & 256;
                if (i22 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z10)) {
                            i23 = 67108864;
                        } else {
                            i23 = 33554432;
                        }
                        i13 |= i23;
                    }
                    i24 = i12 & 512;
                    if (i24 != 0) {
                        if ((i11 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i25 = 268435456;
                            }
                            i13 |= i25;
                        }
                        if ((i13 & 306783379) != 306783378) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            } else {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i28 != 0) {
                                    center = Alignment.INSTANCE.getCenter();
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = null;
                                }
                                if (i18 != 0) {
                                    f11 = 1.0f;
                                }
                                if (i20 != 0) {
                                    colorFilter3 = null;
                                } else {
                                    colorFilter3 = colorFilter;
                                }
                                if ((i12 & 128) != 0) {
                                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                    i13 &= -29360129;
                                } else {
                                    iM6367getDefaultFilterQualityfv9h1I = i10;
                                }
                                if (i22 != 0) {
                                    z13 = true;
                                } else {
                                    z13 = z10;
                                }
                                if (i24 != 0) {
                                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                                } else {
                                    function3M10164getLambda$1210636210$views_release = function3;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                            }
                            if (str2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1910153930);
                                Modifier.Companion companion18 = Modifier.INSTANCE;
                                if ((57344 & i13) == 16384) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z14) {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function1() { // from class: h9.d
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion18, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1910014616);
                                composerStartRestartGroup.endReplaceGroup();
                                modifierSemantics$default = Modifier.INSTANCE;
                            }
                            final int i2116 = iM6367getDefaultFilterQualityfv9h1I;
                            final boolean z1112 = z13;
                            final ContentScale contentScale110 = fit;
                            final Function3 function111 = function3M10164getLambda$1210636210$views_release;
                            final float f1110 = f11;
                            ColorFilter colorFilter111 = colorFilter3;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale110, f1110, colorFilter3, i2116, z1112, function111, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter111;
                            z12 = z13;
                            i26 = iM6367getDefaultFilterQualityfv9h1I;
                            str3 = str2;
                            f12 = f11;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i10;
                            function3M10164getLambda$1210636210$views_release = function3;
                            modifier3 = modifier2;
                            alignment2 = center;
                            contentScale2 = fit;
                            colorFilter2 = colorFilter;
                            z12 = z10;
                            f12 = f11;
                            str3 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 805306368;
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion19 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion19, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i2117 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z1113 = z13;
                        final ContentScale contentScale111 = fit;
                        final Function3 function112 = function3M10164getLambda$1210636210$views_release;
                        final float f1111 = f11;
                        ColorFilter colorFilter112 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale111, f1111, colorFilter3, i2117, z1113, function112, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter112;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion110 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion110, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i2118 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z1114 = z13;
                        final ContentScale contentScale112 = fit;
                        final Function3 function113 = function3M10164getLambda$1210636210$views_release;
                        final float f1112 = f11;
                        ColorFilter colorFilter113 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale112, f1112, colorFilter3, i2118, z1114, function113, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter113;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion111 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion111, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i2119 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z1115 = z13;
                    final ContentScale contentScale113 = fit;
                    final Function3 function114 = function3M10164getLambda$1210636210$views_release;
                    final float f1113 = f11;
                    ColorFilter colorFilter114 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale113, f1113, colorFilter3, i2119, z1115, function114, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter114;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f10;
            } else {
                f11 = f10;
                if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((i11 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
            }
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z10)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion112 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion112, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i21110 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z1116 = z13;
                        final ContentScale contentScale114 = fit;
                        final Function3 function115 = function3M10164getLambda$1210636210$views_release;
                        final float f1114 = f11;
                        ColorFilter colorFilter115 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale114, f1114, colorFilter3, i21110, z1116, function115, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter115;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion113 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion113, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i21111 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z1117 = z13;
                    final ContentScale contentScale115 = fit;
                    final Function3 function116 = function3M10164getLambda$1210636210$views_release;
                    final float f1115 = f11;
                    ColorFilter colorFilter116 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale115, f1115, colorFilter3, i21111, z1117, function116, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter116;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            i24 = i12 & 512;
            if (i24 != 0) {
                if ((i11 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion114 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion114, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i21112 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z1118 = z13;
                    final ContentScale contentScale116 = fit;
                    final Function3 function117 = function3M10164getLambda$1210636210$views_release;
                    final float f1116 = f11;
                    ColorFilter colorFilter117 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale116, f1116, colorFilter3, i21112, z1118, function117, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter117;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i13 & 306783379) != 306783378) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                } else {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                }
                if (str2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                    Modifier.Companion companion115 = Modifier.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion115, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierSemantics$default = Modifier.INSTANCE;
                }
                final int i21113 = iM6367getDefaultFilterQualityfv9h1I;
                final boolean z1119 = z13;
                final ContentScale contentScale117 = fit;
                final Function3 function118 = function3M10164getLambda$1210636210$views_release;
                final float f1117 = f11;
                ColorFilter colorFilter118 = colorFilter3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale117, f1117, colorFilter3, i21113, z1119, function118, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter118;
                z12 = z13;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                str3 = str2;
                f12 = f11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i26 = i10;
                function3M10164getLambda$1210636210$views_release = function3;
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter;
                z12 = z10;
                f12 = f11;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        fit = contentScale;
        i16 = i12 & 16;
        if (i16 != 0) {
            if ((i11 & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i13 |= i17;
            }
            i18 = i12 & 32;
            if (i18 != 0) {
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f10;
            } else {
                f11 = f10;
                if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i13 |= i19;
                }
            }
            i20 = i12 & 64;
            if (i20 != 0) {
                i13 |= 1572864;
            } else if ((i11 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i13 |= i21;
            }
            if ((i11 & 12582912) != 0) {
                i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
            }
            i22 = i12 & 256;
            if (i22 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z10)) {
                        i23 = 67108864;
                    } else {
                        i23 = 33554432;
                    }
                    i13 |= i23;
                }
                i24 = i12 & 512;
                if (i24 != 0) {
                    if ((i11 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i25 = 268435456;
                        }
                        i13 |= i25;
                    }
                    if ((i13 & 306783379) != 306783378) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        } else {
                            if (i27 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i28 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = null;
                            }
                            if (i18 != 0) {
                                f11 = 1.0f;
                            }
                            if (i20 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if ((i12 & 128) != 0) {
                                iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                                i13 &= -29360129;
                            } else {
                                iM6367getDefaultFilterQualityfv9h1I = i10;
                            }
                            if (i22 != 0) {
                                z13 = true;
                            } else {
                                z13 = z10;
                            }
                            if (i24 != 0) {
                                function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                            } else {
                                function3M10164getLambda$1210636210$views_release = function3;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1910153930);
                            Modifier.Companion companion116 = Modifier.INSTANCE;
                            if ((57344 & i13) == 16384) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z14) {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: h9.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            modifierSemantics$default = SemanticsModifierKt.semantics$default(companion116, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1910014616);
                            composerStartRestartGroup.endReplaceGroup();
                            modifierSemantics$default = Modifier.INSTANCE;
                        }
                        final int i21114 = iM6367getDefaultFilterQualityfv9h1I;
                        final boolean z11110 = z13;
                        final ContentScale contentScale118 = fit;
                        final Function3 function119 = function3M10164getLambda$1210636210$views_release;
                        final float f1118 = f11;
                        ColorFilter colorFilter119 = colorFilter3;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale118, f1118, colorFilter3, i21114, z11110, function119, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter119;
                        z12 = z13;
                        i26 = iM6367getDefaultFilterQualityfv9h1I;
                        str3 = str2;
                        f12 = f11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i26 = i10;
                        function3M10164getLambda$1210636210$views_release = function3;
                        modifier3 = modifier2;
                        alignment2 = center;
                        contentScale2 = fit;
                        colorFilter2 = colorFilter;
                        z12 = z10;
                        f12 = f11;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 805306368;
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion117 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion117, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i21115 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z11111 = z13;
                    final ContentScale contentScale119 = fit;
                    final Function3 function1110 = function3M10164getLambda$1210636210$views_release;
                    final float f1119 = f11;
                    ColorFilter colorFilter1110 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale119, f1119, colorFilter3, i21115, z11111, function1110, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter1110;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            i24 = i12 & 512;
            if (i24 != 0) {
                if ((i11 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion118 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion118, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i21116 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z11112 = z13;
                    final ContentScale contentScale1110 = fit;
                    final Function3 function1111 = function3M10164getLambda$1210636210$views_release;
                    final float f11110 = f11;
                    ColorFilter colorFilter1111 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1110, f11110, colorFilter3, i21116, z11112, function1111, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter1111;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i13 & 306783379) != 306783378) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                } else {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                }
                if (str2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                    Modifier.Companion companion119 = Modifier.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion119, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierSemantics$default = Modifier.INSTANCE;
                }
                final int i21117 = iM6367getDefaultFilterQualityfv9h1I;
                final boolean z11113 = z13;
                final ContentScale contentScale1111 = fit;
                final Function3 function1112 = function3M10164getLambda$1210636210$views_release;
                final float f11111 = f11;
                ColorFilter colorFilter1112 = colorFilter3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1111, f11111, colorFilter3, i21117, z11113, function1112, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter1112;
                z12 = z13;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                str3 = str2;
                f12 = f11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i26 = i10;
                function3M10164getLambda$1210636210$views_release = function3;
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter;
                z12 = z10;
                f12 = f11;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        str2 = str;
        i18 = i12 & 32;
        if (i18 != 0) {
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f11 = f10;
        } else {
            f11 = f10;
            if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(f11)) {
                    i19 = 131072;
                } else {
                    i19 = 65536;
                }
                i13 |= i19;
            }
        }
        i20 = i12 & 64;
        if (i20 != 0) {
            i13 |= 1572864;
        } else if ((i11 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(colorFilter)) {
                i21 = 1048576;
            } else {
                i21 = 524288;
            }
            i13 |= i21;
        }
        if ((i11 & 12582912) != 0) {
            i13 |= ((i12 & 128) == 0 || !composerStartRestartGroup.changed(i10)) ? 4194304 : 8388608;
        }
        i22 = i12 & 256;
        if (i22 != 0) {
            if ((i11 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i23 = 67108864;
                } else {
                    i23 = 33554432;
                }
                i13 |= i23;
            }
            i24 = i12 & 512;
            if (i24 != 0) {
                if ((i11 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i25 = 268435456;
                    }
                    i13 |= i25;
                }
                if ((i13 & 306783379) != 306783378) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    } else {
                        if (i27 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i28 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = null;
                        }
                        if (i18 != 0) {
                            f11 = 1.0f;
                        }
                        if (i20 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if ((i12 & 128) != 0) {
                            iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                            i13 &= -29360129;
                        } else {
                            iM6367getDefaultFilterQualityfv9h1I = i10;
                        }
                        if (i22 != 0) {
                            z13 = true;
                        } else {
                            z13 = z10;
                        }
                        if (i24 != 0) {
                            function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                        } else {
                            function3M10164getLambda$1210636210$views_release = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                    }
                    if (str2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1910153930);
                        Modifier.Companion companion1110 = Modifier.INSTANCE;
                        if ((57344 & i13) == 16384) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z14) {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: h9.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        modifierSemantics$default = SemanticsModifierKt.semantics$default(companion1110, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1910014616);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierSemantics$default = Modifier.INSTANCE;
                    }
                    final int i21118 = iM6367getDefaultFilterQualityfv9h1I;
                    final boolean z11114 = z13;
                    final ContentScale contentScale1112 = fit;
                    final Function3 function1113 = function3M10164getLambda$1210636210$views_release;
                    final float f11112 = f11;
                    ColorFilter colorFilter1113 = colorFilter3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1112, f11112, colorFilter3, i21118, z11114, function1113, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter1113;
                    z12 = z13;
                    i26 = iM6367getDefaultFilterQualityfv9h1I;
                    str3 = str2;
                    f12 = f11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i26 = i10;
                    function3M10164getLambda$1210636210$views_release = function3;
                    modifier3 = modifier2;
                    alignment2 = center;
                    contentScale2 = fit;
                    colorFilter2 = colorFilter;
                    z12 = z10;
                    f12 = f11;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 805306368;
            if ((i13 & 306783379) != 306783378) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                } else {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                }
                if (str2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                    Modifier.Companion companion1111 = Modifier.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion1111, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierSemantics$default = Modifier.INSTANCE;
                }
                final int i21119 = iM6367getDefaultFilterQualityfv9h1I;
                final boolean z11115 = z13;
                final ContentScale contentScale1113 = fit;
                final Function3 function1114 = function3M10164getLambda$1210636210$views_release;
                final float f11113 = f11;
                ColorFilter colorFilter1114 = colorFilter3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1113, f11113, colorFilter3, i21119, z11115, function1114, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter1114;
                z12 = z13;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                str3 = str2;
                f12 = f11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i26 = i10;
                function3M10164getLambda$1210636210$views_release = function3;
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter;
                z12 = z10;
                f12 = f11;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 100663296;
        i24 = i12 & 512;
        if (i24 != 0) {
            if ((i11 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i25 = 268435456;
                }
                i13 |= i25;
            }
            if ((i13 & 306783379) != 306783378) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                } else {
                    if (i27 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i28 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = null;
                    }
                    if (i18 != 0) {
                        f11 = 1.0f;
                    }
                    if (i20 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if ((i12 & 128) != 0) {
                        iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                        i13 &= -29360129;
                    } else {
                        iM6367getDefaultFilterQualityfv9h1I = i10;
                    }
                    if (i22 != 0) {
                        z13 = true;
                    } else {
                        z13 = z10;
                    }
                    if (i24 != 0) {
                        function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                    } else {
                        function3M10164getLambda$1210636210$views_release = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
                }
                if (str2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1910153930);
                    Modifier.Companion companion1112 = Modifier.INSTANCE;
                    if ((57344 & i13) == 16384) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: h9.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(companion1112, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1910014616);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierSemantics$default = Modifier.INSTANCE;
                }
                final int i211110 = iM6367getDefaultFilterQualityfv9h1I;
                final boolean z11116 = z13;
                final ContentScale contentScale1114 = fit;
                final Function3 function1115 = function3M10164getLambda$1210636210$views_release;
                final float f11114 = f11;
                ColorFilter colorFilter1115 = colorFilter3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1114, f11114, colorFilter3, i211110, z11116, function1115, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter1115;
                z12 = z13;
                i26 = iM6367getDefaultFilterQualityfv9h1I;
                str3 = str2;
                f12 = f11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i26 = i10;
                function3M10164getLambda$1210636210$views_release = function3;
                modifier3 = modifier2;
                alignment2 = center;
                contentScale2 = fit;
                colorFilter2 = colorFilter;
                z12 = z10;
                f12 = f11;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 805306368;
        if ((i13 & 306783379) != 306783378) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z11, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if (i27 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i28 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                }
                if (i16 != 0) {
                    str2 = null;
                }
                if (i18 != 0) {
                    f11 = 1.0f;
                }
                if (i20 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if ((i12 & 128) != 0) {
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    i13 &= -29360129;
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i10;
                }
                if (i22 != 0) {
                    z13 = true;
                } else {
                    z13 = z10;
                }
                if (i24 != 0) {
                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                } else {
                    function3M10164getLambda$1210636210$views_release = function3;
                }
            } else {
                if (i27 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i28 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                }
                if (i16 != 0) {
                    str2 = null;
                }
                if (i18 != 0) {
                    f11 = 1.0f;
                }
                if (i20 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if ((i12 & 128) != 0) {
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    i13 &= -29360129;
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i10;
                }
                if (i22 != 0) {
                    z13 = true;
                } else {
                    z13 = z10;
                }
                if (i24 != 0) {
                    function3M10164getLambda$1210636210$views_release = ComposableSingletons$ImageWithConstraintsKt.INSTANCE.m10164getLambda$1210636210$views_release();
                } else {
                    function3M10164getLambda$1210636210$views_release = function3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1317633406, i13, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints (ImageWithConstraints.kt:76)");
            }
            if (str2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1910153930);
                Modifier.Companion companion1113 = Modifier.INSTANCE;
                if ((57344 & i13) == 16384) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue = new Function1() { // from class: h9.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: h9.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(str2, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                modifierSemantics$default = SemanticsModifierKt.semantics$default(companion1113, false, (Function1) objRememberedValue, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1910014616);
                composerStartRestartGroup.endReplaceGroup();
                modifierSemantics$default = Modifier.INSTANCE;
            }
            final int i211111 = iM6367getDefaultFilterQualityfv9h1I;
            final boolean z11117 = z13;
            final ContentScale contentScale1115 = fit;
            final Function3 function1116 = function3M10164getLambda$1210636210$views_release;
            final float f11115 = f11;
            ColorFilter colorFilter1116 = colorFilter3;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2.then(modifierSemantics$default), center, false, ComposableLambdaKt.rememberComposableLambda(491535468, true, new Function3() { // from class: h9.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$2(imageBitmap, contentScale1115, f11115, colorFilter3, i211111, z11117, function1116, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 3) & 112) | 3072, 4);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            alignment2 = center;
            contentScale2 = fit;
            colorFilter2 = colorFilter1116;
            z12 = z13;
            i26 = iM6367getDefaultFilterQualityfv9h1I;
            str3 = str2;
            f12 = f11;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            i26 = i10;
            function3M10164getLambda$1210636210$views_release = function3;
            modifier3 = modifier2;
            alignment2 = center;
            contentScale2 = fit;
            colorFilter2 = colorFilter;
            z12 = z10;
            f12 = f11;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: h9.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageWithConstraintsKt.ImageWithConstraints_nWU5RSE$lambda$3(modifier3, imageBitmap, alignment2, contentScale2, str3, f12, colorFilter2, i26, z12, function3M10164getLambda$1210636210$views_release, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageWithConstraints_nWU5RSE$lambda$1$lambda$0(String str, SemanticsPropertyReceiver semantics) {
        y.i(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.m7792setRolekuIjeqM(semantics, Role.INSTANCE.m7777getImageo7Vup1c());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ImageWithConstraints_nWU5RSE$lambda$2(ImageBitmap imageBitmap, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10, boolean z10, Function3 function3, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i11) {
        int i12;
        y.i(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(491535468, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraints.<anonymous> (ImageWithConstraints.kt:93)");
            }
            int width = imageBitmap.getWidth();
            int height = imageBitmap.getHeight();
            long parentSize = ImageContentScaleUtilKt.getParentSize(BoxWithConstraints, width, height);
            int i13 = (int) (parentSize >> 32);
            int i14 = (int) (parentSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            float f11 = width;
            float f12 = height;
            long jMo7193computeScaleFactorH7hwNQA = contentScale.mo7193computeScaleFactorH7hwNQA(Size.m5686constructorimpl((((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f12)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m5686constructorimpl((((long) Float.floatToRawIntBits(i14)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(i13)) << 32)));
            float fIntBitsToFloat = f11 * Float.intBitsToFloat((int) (jMo7193computeScaleFactorH7hwNQA >> 32));
            float fIntBitsToFloat2 = f12 * Float.intBitsToFloat((int) (jMo7193computeScaleFactorH7hwNQA & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            m10179ImageLayoutQnyEGeY(BoxWithConstraints.mo1633getConstraintsmsEJaDk(), imageBitmap, ImageContentScaleUtilKt.getScaledBitmapRect(i13, i14, fIntBitsToFloat, fIntBitsToFloat2, width, height), fIntBitsToFloat, fIntBitsToFloat2, i13, i14, f10, colorFilter, i10, z10, function3, composer, 0, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageWithConstraints_nWU5RSE$lambda$3(Modifier modifier, ImageBitmap imageBitmap, Alignment alignment, ContentScale contentScale, String str, float f10, ColorFilter colorFilter, int i10, boolean z10, Function3 function3, int i11, int i12, Composer composer, int i13) {
        m10180ImageWithConstraintsnWU5RSE(modifier, imageBitmap, alignment, contentScale, str, f10, colorFilter, i10, z10, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
