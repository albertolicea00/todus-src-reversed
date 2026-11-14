package cu.z17.views.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.data.rest.entity.NewEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a]\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a[\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/graphics/Bitmap;", NewEntity.NEWS_CONFIG_SOURCE, "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "description", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "", "size", "", "blurRadio", "Lua/k0;", "Z17BlurImage-42YmkrA", "(Landroidx/compose/ui/Modifier;Landroid/graphics/Bitmap;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILjava/lang/Integer;FLandroidx/compose/runtime/Composer;II)V", "Z17BlurImage", "LegacyBlurImage-42YmkrA", "LegacyBlurImage", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17BlurImageKt {
    /* JADX WARN: Code duplicated, block: B:102:0x0160  */
    /* JADX WARN: Code duplicated, block: B:104:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0052  */
    /* JADX WARN: Code duplicated, block: B:32:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00db  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:97:0x014a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0152  */
    @Composable
    /* JADX INFO: renamed from: LegacyBlurImage-42YmkrA, reason: not valid java name */
    private static final void m10275LegacyBlurImage42YmkrA(final Modifier modifier, final Bitmap bitmap, ColorFilter colorFilter, ContentScale contentScale, String str, final int i10, Integer num, final float f10, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        ColorFilter colorFilter2;
        int i14;
        ContentScale contentScale2;
        int i15;
        int i16;
        String str2;
        int i17;
        int i18;
        boolean z10;
        final ColorFilter colorFilter3;
        final ContentScale contentScale3;
        final String str3;
        final Integer num2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ColorFilter colorFilter4;
        ContentScale fit;
        String str4;
        Integer num3;
        Context context;
        int i19;
        int i20;
        Composer composerStartRestartGroup = composer.startRestartGroup(1790430612);
        if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(bitmap) ? 32 : 16;
        }
        int i21 = i12 & 4;
        if (i21 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 256 : 128;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i11 & 3072) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
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
                    if ((196608 & i11) == 0) {
                        i18 = i10;
                        if (composerStartRestartGroup.changed(i18)) {
                            i20 = 131072;
                        } else {
                            i20 = 65536;
                        }
                        i13 |= i20;
                    } else {
                        i18 = i10;
                    }
                    if ((12582912 & i11) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i19 = 8388608;
                        } else {
                            i19 = 4194304;
                        }
                        i13 |= i19;
                    }
                    if ((4269203 & i13) != 4269202) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        if (i21 != 0) {
                            colorFilter4 = null;
                        } else {
                            colorFilter4 = colorFilter2;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str4 = "";
                        } else {
                            str4 = str2;
                        }
                        if ((i12 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                            try {
                                RenderScript renderScriptCreate = RenderScript.create(context);
                                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
                                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
                                scriptIntrinsicBlurCreate.setRadius(f10);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
                                allocationCreateFromBitmap.copyTo(bitmap);
                                renderScriptCreate.destroy();
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                            composerStartRestartGroup.updateRememberedValue(null);
                        }
                        int i22 = i13 & 126;
                        int i23 = i13 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i22 | (i23 & 7168) | (57344 & i23) | (458752 & i23) | (i23 & 3670016), 388);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorFilter3 = colorFilter4;
                        contentScale3 = fit;
                        str3 = str4;
                        num2 = num3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        colorFilter3 = colorFilter2;
                        contentScale3 = contentScale2;
                        str3 = str2;
                        num2 = num;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                str2 = str;
                if ((196608 & i11) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                        i20 = 131072;
                    } else {
                        i20 = 65536;
                    }
                    i13 |= i20;
                } else {
                    i18 = i10;
                }
                if ((12582912 & i11) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((4269203 & i13) != 4269202) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i21 != 0) {
                        colorFilter4 = null;
                    } else {
                        colorFilter4 = colorFilter2;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                        RenderScript renderScriptCreate2 = RenderScript.create(context);
                        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate2, bitmap);
                        ScriptIntrinsicBlur scriptIntrinsicBlurCreate2 = ScriptIntrinsicBlur.create(renderScriptCreate2, allocationCreateFromBitmap2.getElement());
                        scriptIntrinsicBlurCreate2.setRadius(f10);
                        scriptIntrinsicBlurCreate2.setInput(allocationCreateFromBitmap2);
                        scriptIntrinsicBlurCreate2.forEach(allocationCreateFromBitmap2);
                        allocationCreateFromBitmap2.copyTo(bitmap);
                        renderScriptCreate2.destroy();
                        composerStartRestartGroup.updateRememberedValue(null);
                    }
                    int i24 = i13 & 126;
                    int i25 = i13 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i24 | (i25 & 7168) | (57344 & i25) | (458752 & i25) | (i25 & 3670016), 388);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter3 = colorFilter4;
                    contentScale3 = fit;
                    str3 = str4;
                    num2 = num3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str3 = str2;
                    num2 = num;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            contentScale2 = contentScale;
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
                if ((196608 & i11) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                        i20 = 131072;
                    } else {
                        i20 = 65536;
                    }
                    i13 |= i20;
                } else {
                    i18 = i10;
                }
                if ((12582912 & i11) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((4269203 & i13) != 4269202) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i21 != 0) {
                        colorFilter4 = null;
                    } else {
                        colorFilter4 = colorFilter2;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                        RenderScript renderScriptCreate3 = RenderScript.create(context);
                        Allocation allocationCreateFromBitmap3 = Allocation.createFromBitmap(renderScriptCreate3, bitmap);
                        ScriptIntrinsicBlur scriptIntrinsicBlurCreate3 = ScriptIntrinsicBlur.create(renderScriptCreate3, allocationCreateFromBitmap3.getElement());
                        scriptIntrinsicBlurCreate3.setRadius(f10);
                        scriptIntrinsicBlurCreate3.setInput(allocationCreateFromBitmap3);
                        scriptIntrinsicBlurCreate3.forEach(allocationCreateFromBitmap3);
                        allocationCreateFromBitmap3.copyTo(bitmap);
                        renderScriptCreate3.destroy();
                        composerStartRestartGroup.updateRememberedValue(null);
                    }
                    int i26 = i13 & 126;
                    int i27 = i13 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i26 | (i27 & 7168) | (57344 & i27) | (458752 & i27) | (i27 & 3670016), 388);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter3 = colorFilter4;
                    contentScale3 = fit;
                    str3 = str4;
                    num2 = num3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str3 = str2;
                    num2 = num;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            if ((196608 & i11) == 0) {
                i18 = i10;
                if (composerStartRestartGroup.changed(i18)) {
                    i20 = 131072;
                } else {
                    i20 = 65536;
                }
                i13 |= i20;
            } else {
                i18 = i10;
            }
            if ((12582912 & i11) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((4269203 & i13) != 4269202) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i21 != 0) {
                    colorFilter4 = null;
                } else {
                    colorFilter4 = colorFilter2;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i16 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i12 & 64) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                    RenderScript renderScriptCreate4 = RenderScript.create(context);
                    Allocation allocationCreateFromBitmap4 = Allocation.createFromBitmap(renderScriptCreate4, bitmap);
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate4 = ScriptIntrinsicBlur.create(renderScriptCreate4, allocationCreateFromBitmap4.getElement());
                    scriptIntrinsicBlurCreate4.setRadius(f10);
                    scriptIntrinsicBlurCreate4.setInput(allocationCreateFromBitmap4);
                    scriptIntrinsicBlurCreate4.forEach(allocationCreateFromBitmap4);
                    allocationCreateFromBitmap4.copyTo(bitmap);
                    renderScriptCreate4.destroy();
                    composerStartRestartGroup.updateRememberedValue(null);
                }
                int i28 = i13 & 126;
                int i29 = i13 << 3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i28 | (i29 & 7168) | (57344 & i29) | (458752 & i29) | (i29 & 3670016), 388);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter3 = colorFilter4;
                contentScale3 = fit;
                str3 = str4;
                num2 = num3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str3 = str2;
                num2 = num;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        colorFilter2 = colorFilter;
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i11 & 3072) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
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
                if ((196608 & i11) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                        i20 = 131072;
                    } else {
                        i20 = 65536;
                    }
                    i13 |= i20;
                } else {
                    i18 = i10;
                }
                if ((12582912 & i11) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i13 |= i19;
                }
                if ((4269203 & i13) != 4269202) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i21 != 0) {
                        colorFilter4 = null;
                    } else {
                        colorFilter4 = colorFilter2;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                        RenderScript renderScriptCreate5 = RenderScript.create(context);
                        Allocation allocationCreateFromBitmap5 = Allocation.createFromBitmap(renderScriptCreate5, bitmap);
                        ScriptIntrinsicBlur scriptIntrinsicBlurCreate5 = ScriptIntrinsicBlur.create(renderScriptCreate5, allocationCreateFromBitmap5.getElement());
                        scriptIntrinsicBlurCreate5.setRadius(f10);
                        scriptIntrinsicBlurCreate5.setInput(allocationCreateFromBitmap5);
                        scriptIntrinsicBlurCreate5.forEach(allocationCreateFromBitmap5);
                        allocationCreateFromBitmap5.copyTo(bitmap);
                        renderScriptCreate5.destroy();
                        composerStartRestartGroup.updateRememberedValue(null);
                    }
                    int i210 = i13 & 126;
                    int i211 = i13 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i210 | (i211 & 7168) | (57344 & i211) | (458752 & i211) | (i211 & 3670016), 388);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter3 = colorFilter4;
                    contentScale3 = fit;
                    str3 = str4;
                    num2 = num3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str3 = str2;
                    num2 = num;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            if ((196608 & i11) == 0) {
                i18 = i10;
                if (composerStartRestartGroup.changed(i18)) {
                    i20 = 131072;
                } else {
                    i20 = 65536;
                }
                i13 |= i20;
            } else {
                i18 = i10;
            }
            if ((12582912 & i11) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((4269203 & i13) != 4269202) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i21 != 0) {
                    colorFilter4 = null;
                } else {
                    colorFilter4 = colorFilter2;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i16 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i12 & 64) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                    RenderScript renderScriptCreate6 = RenderScript.create(context);
                    Allocation allocationCreateFromBitmap6 = Allocation.createFromBitmap(renderScriptCreate6, bitmap);
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate6 = ScriptIntrinsicBlur.create(renderScriptCreate6, allocationCreateFromBitmap6.getElement());
                    scriptIntrinsicBlurCreate6.setRadius(f10);
                    scriptIntrinsicBlurCreate6.setInput(allocationCreateFromBitmap6);
                    scriptIntrinsicBlurCreate6.forEach(allocationCreateFromBitmap6);
                    allocationCreateFromBitmap6.copyTo(bitmap);
                    renderScriptCreate6.destroy();
                    composerStartRestartGroup.updateRememberedValue(null);
                }
                int i212 = i13 & 126;
                int i213 = i13 << 3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i212 | (i213 & 7168) | (57344 & i213) | (458752 & i213) | (i213 & 3670016), 388);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter3 = colorFilter4;
                contentScale3 = fit;
                str3 = str4;
                num2 = num3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str3 = str2;
                num2 = num;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        contentScale2 = contentScale;
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
            if ((196608 & i11) == 0) {
                i18 = i10;
                if (composerStartRestartGroup.changed(i18)) {
                    i20 = 131072;
                } else {
                    i20 = 65536;
                }
                i13 |= i20;
            } else {
                i18 = i10;
            }
            if ((12582912 & i11) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i13 |= i19;
            }
            if ((4269203 & i13) != 4269202) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i21 != 0) {
                    colorFilter4 = null;
                } else {
                    colorFilter4 = colorFilter2;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i16 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i12 & 64) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                    RenderScript renderScriptCreate7 = RenderScript.create(context);
                    Allocation allocationCreateFromBitmap7 = Allocation.createFromBitmap(renderScriptCreate7, bitmap);
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate7 = ScriptIntrinsicBlur.create(renderScriptCreate7, allocationCreateFromBitmap7.getElement());
                    scriptIntrinsicBlurCreate7.setRadius(f10);
                    scriptIntrinsicBlurCreate7.setInput(allocationCreateFromBitmap7);
                    scriptIntrinsicBlurCreate7.forEach(allocationCreateFromBitmap7);
                    allocationCreateFromBitmap7.copyTo(bitmap);
                    renderScriptCreate7.destroy();
                    composerStartRestartGroup.updateRememberedValue(null);
                }
                int i214 = i13 & 126;
                int i215 = i13 << 3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i214 | (i215 & 7168) | (57344 & i215) | (458752 & i215) | (i215 & 3670016), 388);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter3 = colorFilter4;
                contentScale3 = fit;
                str3 = str4;
                num2 = num3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str3 = str2;
                num2 = num;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        str2 = str;
        if ((196608 & i11) == 0) {
            i18 = i10;
            if (composerStartRestartGroup.changed(i18)) {
                i20 = 131072;
            } else {
                i20 = 65536;
            }
            i13 |= i20;
        } else {
            i18 = i10;
        }
        if ((12582912 & i11) == 0) {
            if (composerStartRestartGroup.changed(f10)) {
                i19 = 8388608;
            } else {
                i19 = 4194304;
            }
            i13 |= i19;
        }
        if ((4269203 & i13) != 4269202) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i21 != 0) {
                colorFilter4 = null;
            } else {
                colorFilter4 = colorFilter2;
            }
            if (i14 != 0) {
                fit = ContentScale.INSTANCE.getFit();
            } else {
                fit = contentScale2;
            }
            if (i16 != 0) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if ((i12 & 64) != 0) {
                num3 = null;
            } else {
                num3 = num;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1790430612, i13, -1, "cu.z17.views.picture.LegacyBlurImage (Z17BlurImage.kt:61)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            if (composerStartRestartGroup.rememberedValue() == Composer.INSTANCE.getEmpty()) {
                RenderScript renderScriptCreate8 = RenderScript.create(context);
                Allocation allocationCreateFromBitmap8 = Allocation.createFromBitmap(renderScriptCreate8, bitmap);
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate8 = ScriptIntrinsicBlur.create(renderScriptCreate8, allocationCreateFromBitmap8.getElement());
                scriptIntrinsicBlurCreate8.setRadius(f10);
                scriptIntrinsicBlurCreate8.setInput(allocationCreateFromBitmap8);
                scriptIntrinsicBlurCreate8.forEach(allocationCreateFromBitmap8);
                allocationCreateFromBitmap8.copyTo(bitmap);
                renderScriptCreate8.destroy();
                composerStartRestartGroup.updateRememberedValue(null);
            }
            int i216 = i13 & 126;
            int i217 = i13 << 3;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifier2, bitmap, null, colorFilter4, fit, str4, i18, null, null, composerStartRestartGroup, i216 | (i217 & 7168) | (57344 & i217) | (458752 & i217) | (i217 & 3670016), 388);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorFilter3 = colorFilter4;
            contentScale3 = fit;
            str3 = str4;
            num2 = num3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            colorFilter3 = colorFilter2;
            contentScale3 = contentScale2;
            str3 = str2;
            num2 = num;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17BlurImageKt.LegacyBlurImage_42YmkrA$lambda$3(modifier, bitmap, colorFilter3, contentScale3, str3, i10, num2, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 LegacyBlurImage_42YmkrA$lambda$3(Modifier modifier, Bitmap bitmap, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Integer num, float f10, int i11, int i12, Composer composer, int i13) {
        m10275LegacyBlurImage42YmkrA(modifier, bitmap, colorFilter, contentScale, str, i10, num, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0121  */
    /* JADX WARN: Code duplicated, block: B:104:0x012c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x0166  */
    /* JADX WARN: Code duplicated, block: B:114:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x010e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0111  */
    /* JADX WARN: Code duplicated, block: B:99:0x011a  */
    @Composable
    /* JADX INFO: renamed from: Z17BlurImage-42YmkrA, reason: not valid java name */
    public static final void m10276Z17BlurImage42YmkrA(Modifier modifier, final Bitmap source, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Integer num, final float f10, Composer composer, final int i11, final int i12) {
        int i13;
        ColorFilter colorFilter2;
        int i14;
        ContentScale fit;
        int i15;
        int i16;
        String str2;
        int i17;
        int iM5965getHighfv9h1I;
        int i18;
        Integer num2;
        int i19;
        boolean z10;
        Modifier modifier2;
        final ColorFilter colorFilter3;
        final ContentScale contentScale2;
        final String str3;
        final int i20;
        final Integer num3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i21;
        int i22;
        y.i(modifier, "modifier");
        y.i(source, "source");
        Composer composerStartRestartGroup = composer.startRestartGroup(1613130447);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(source) ? 32 : 16;
        }
        int i23 = i12 & 4;
        if (i23 == 0) {
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 256 : 128;
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
                    if ((196608 & i11) == 0) {
                        if ((i12 & 32) == 0) {
                            iM5965getHighfv9h1I = i10;
                            int i24 = composerStartRestartGroup.changed(iM5965getHighfv9h1I) ? 131072 : 65536;
                            i13 |= i24;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        i13 |= i24;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    i18 = i12 & 64;
                    if (i18 != 0) {
                        if ((1572864 & i11) == 0) {
                            num2 = num;
                            if (composerStartRestartGroup.changed(num2)) {
                                i19 = 1048576;
                            } else {
                                i19 = 524288;
                            }
                            i13 |= i19;
                        }
                        if ((i11 & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(f10)) {
                                i22 = 8388608;
                            } else {
                                i22 = 4194304;
                            }
                            i13 |= i22;
                        }
                        if ((i13 & 4793491) != 4793490) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i23 != 0) {
                                    colorFilter2 = null;
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i16 != 0) {
                                    str2 = "";
                                }
                                if ((i12 & 32) != 0) {
                                    i13 &= -458753;
                                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                }
                                if (i18 != 0) {
                                    num2 = null;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i12 & 32) != 0) {
                                    i13 &= -458753;
                                }
                            }
                            i21 = i13;
                            colorFilter3 = colorFilter2;
                            str3 = str2;
                            i20 = iM5965getHighfv9h1I;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                            }
                            if (Build.VERSION.SDK_INT < 31) {
                                composerStartRestartGroup.startReplaceGroup(380429902);
                                ContentScale contentScale3 = fit;
                                m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale3, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                                modifier2 = modifier;
                                i20 = i20;
                                str3 = str3;
                                contentScale2 = contentScale3;
                                colorFilter3 = colorFilter3;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                modifier2 = modifier;
                                contentScale2 = fit;
                                composerStartRestartGroup.startReplaceGroup(380756952);
                                int i25 = i21 & 112;
                                int i26 = i21 << 3;
                                Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i25 | (i26 & 7168) | (57344 & i26) | (458752 & i26) | (i26 & 3670016), 388);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            modifier2 = modifier;
                            composerStartRestartGroup.skipToGroupEnd();
                            colorFilter3 = colorFilter2;
                            contentScale2 = fit;
                            str3 = str2;
                            i20 = iM5965getHighfv9h1I;
                        }
                        num3 = num2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier3, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 1572864;
                    num2 = num;
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 4793491) != 4793490) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        } else {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        }
                        i21 = i13;
                        colorFilter3 = colorFilter2;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                        }
                        if (Build.VERSION.SDK_INT < 31) {
                            composerStartRestartGroup.startReplaceGroup(380429902);
                            ContentScale contentScale4 = fit;
                            m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale4, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                            modifier2 = modifier;
                            i20 = i20;
                            str3 = str3;
                            contentScale2 = contentScale4;
                            colorFilter3 = colorFilter3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            modifier2 = modifier;
                            contentScale2 = fit;
                            composerStartRestartGroup.startReplaceGroup(380756952);
                            int i27 = i21 & 112;
                            int i28 = i21 << 3;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i27 | (i28 & 7168) | (57344 & i28) | (458752 & i28) | (i28 & 3670016), 388);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        modifier2 = modifier;
                        composerStartRestartGroup.skipToGroupEnd();
                        colorFilter3 = colorFilter2;
                        contentScale2 = fit;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                    }
                    num3 = num2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier4 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier4, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 24576;
                str2 = str;
                if ((196608 & i11) == 0) {
                    if ((i12 & 32) == 0) {
                        iM5965getHighfv9h1I = i10;
                        if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                        }
                        i13 |= i24;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i18 = i12 & 64;
                if (i18 != 0) {
                    if ((1572864 & i11) == 0) {
                        num2 = num;
                        if (composerStartRestartGroup.changed(num2)) {
                            i19 = 1048576;
                        } else {
                            i19 = 524288;
                        }
                        i13 |= i19;
                    }
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 4793491) != 4793490) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        } else {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        }
                        i21 = i13;
                        colorFilter3 = colorFilter2;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                        }
                        if (Build.VERSION.SDK_INT < 31) {
                            composerStartRestartGroup.startReplaceGroup(380429902);
                            ContentScale contentScale5 = fit;
                            m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale5, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                            modifier2 = modifier;
                            i20 = i20;
                            str3 = str3;
                            contentScale2 = contentScale5;
                            colorFilter3 = colorFilter3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            modifier2 = modifier;
                            contentScale2 = fit;
                            composerStartRestartGroup.startReplaceGroup(380756952);
                            int i29 = i21 & 112;
                            int i210 = i21 << 3;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i29 | (i210 & 7168) | (57344 & i210) | (458752 & i210) | (i210 & 3670016), 388);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        modifier2 = modifier;
                        composerStartRestartGroup.skipToGroupEnd();
                        colorFilter3 = colorFilter2;
                        contentScale2 = fit;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                    }
                    num3 = num2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier5 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier5, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                num2 = num;
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale6 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale6, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale6;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i211 = i21 & 112;
                        int i212 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i211 | (i212 & 7168) | (57344 & i212) | (458752 & i212) | (i212 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier6 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier6, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((196608 & i11) == 0) {
                    if ((i12 & 32) == 0) {
                        iM5965getHighfv9h1I = i10;
                        if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                        }
                        i13 |= i24;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i18 = i12 & 64;
                if (i18 != 0) {
                    if ((1572864 & i11) == 0) {
                        num2 = num;
                        if (composerStartRestartGroup.changed(num2)) {
                            i19 = 1048576;
                        } else {
                            i19 = 524288;
                        }
                        i13 |= i19;
                    }
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 4793491) != 4793490) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        } else {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        }
                        i21 = i13;
                        colorFilter3 = colorFilter2;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                        }
                        if (Build.VERSION.SDK_INT < 31) {
                            composerStartRestartGroup.startReplaceGroup(380429902);
                            ContentScale contentScale7 = fit;
                            m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale7, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                            modifier2 = modifier;
                            i20 = i20;
                            str3 = str3;
                            contentScale2 = contentScale7;
                            colorFilter3 = colorFilter3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            modifier2 = modifier;
                            contentScale2 = fit;
                            composerStartRestartGroup.startReplaceGroup(380756952);
                            int i213 = i21 & 112;
                            int i214 = i21 << 3;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i213 | (i214 & 7168) | (57344 & i214) | (458752 & i214) | (i214 & 3670016), 388);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        modifier2 = modifier;
                        composerStartRestartGroup.skipToGroupEnd();
                        colorFilter3 = colorFilter2;
                        contentScale2 = fit;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                    }
                    num3 = num2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier7 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier7, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                num2 = num;
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale8 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale8, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale8;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i215 = i21 & 112;
                        int i216 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i215 | (i216 & 7168) | (57344 & i216) | (458752 & i216) | (i216 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier8, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            if ((196608 & i11) == 0) {
                if ((i12 & 32) == 0) {
                    iM5965getHighfv9h1I = i10;
                    if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i13 |= i24;
            } else {
                iM5965getHighfv9h1I = i10;
            }
            i18 = i12 & 64;
            if (i18 != 0) {
                if ((1572864 & i11) == 0) {
                    num2 = num;
                    if (composerStartRestartGroup.changed(num2)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale9 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale9, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale9;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i217 = i21 & 112;
                        int i218 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i217 | (i218 & 7168) | (57344 & i218) | (458752 & i218) | (i218 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier9 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier9, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            num2 = num;
            if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i13 |= i22;
            }
            if ((i13 & 4793491) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                } else {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                }
                i21 = i13;
                colorFilter3 = colorFilter2;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                }
                if (Build.VERSION.SDK_INT < 31) {
                    composerStartRestartGroup.startReplaceGroup(380429902);
                    ContentScale contentScale10 = fit;
                    m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale10, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                    modifier2 = modifier;
                    i20 = i20;
                    str3 = str3;
                    contentScale2 = contentScale10;
                    colorFilter3 = colorFilter3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier2 = modifier;
                    contentScale2 = fit;
                    composerStartRestartGroup.startReplaceGroup(380756952);
                    int i219 = i21 & 112;
                    int i2110 = i21 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i219 | (i2110 & 7168) | (57344 & i2110) | (458752 & i2110) | (i2110 & 3670016), 388);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale2 = fit;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
            }
            num3 = num2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier10 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier10, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        colorFilter2 = colorFilter;
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
                if ((196608 & i11) == 0) {
                    if ((i12 & 32) == 0) {
                        iM5965getHighfv9h1I = i10;
                        if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                        }
                        i13 |= i24;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i18 = i12 & 64;
                if (i18 != 0) {
                    if ((1572864 & i11) == 0) {
                        num2 = num;
                        if (composerStartRestartGroup.changed(num2)) {
                            i19 = 1048576;
                        } else {
                            i19 = 524288;
                        }
                        i13 |= i19;
                    }
                    if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f10)) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 4793491) != 4793490) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        } else {
                            if (i23 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            }
                            if (i16 != 0) {
                                str2 = "";
                            }
                            if ((i12 & 32) != 0) {
                                i13 &= -458753;
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            }
                            if (i18 != 0) {
                                num2 = null;
                            }
                        }
                        i21 = i13;
                        colorFilter3 = colorFilter2;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                        }
                        if (Build.VERSION.SDK_INT < 31) {
                            composerStartRestartGroup.startReplaceGroup(380429902);
                            ContentScale contentScale11 = fit;
                            m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale11, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                            modifier2 = modifier;
                            i20 = i20;
                            str3 = str3;
                            contentScale2 = contentScale11;
                            colorFilter3 = colorFilter3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            modifier2 = modifier;
                            contentScale2 = fit;
                            composerStartRestartGroup.startReplaceGroup(380756952);
                            int i2111 = i21 & 112;
                            int i2112 = i21 << 3;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i2111 | (i2112 & 7168) | (57344 & i2112) | (458752 & i2112) | (i2112 & 3670016), 388);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        modifier2 = modifier;
                        composerStartRestartGroup.skipToGroupEnd();
                        colorFilter3 = colorFilter2;
                        contentScale2 = fit;
                        str3 = str2;
                        i20 = iM5965getHighfv9h1I;
                    }
                    num3 = num2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier11 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier11, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 1572864;
                num2 = num;
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale12 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale12, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale12;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i2113 = i21 & 112;
                        int i2114 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i2113 | (i2114 & 7168) | (57344 & i2114) | (458752 & i2114) | (i2114 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier12 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier12, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            str2 = str;
            if ((196608 & i11) == 0) {
                if ((i12 & 32) == 0) {
                    iM5965getHighfv9h1I = i10;
                    if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i13 |= i24;
            } else {
                iM5965getHighfv9h1I = i10;
            }
            i18 = i12 & 64;
            if (i18 != 0) {
                if ((1572864 & i11) == 0) {
                    num2 = num;
                    if (composerStartRestartGroup.changed(num2)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale13 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale13, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale13;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i2115 = i21 & 112;
                        int i2116 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i2115 | (i2116 & 7168) | (57344 & i2116) | (458752 & i2116) | (i2116 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier13 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier13, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            num2 = num;
            if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i13 |= i22;
            }
            if ((i13 & 4793491) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                } else {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                }
                i21 = i13;
                colorFilter3 = colorFilter2;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                }
                if (Build.VERSION.SDK_INT < 31) {
                    composerStartRestartGroup.startReplaceGroup(380429902);
                    ContentScale contentScale14 = fit;
                    m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale14, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                    modifier2 = modifier;
                    i20 = i20;
                    str3 = str3;
                    contentScale2 = contentScale14;
                    colorFilter3 = colorFilter3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier2 = modifier;
                    contentScale2 = fit;
                    composerStartRestartGroup.startReplaceGroup(380756952);
                    int i2117 = i21 & 112;
                    int i2118 = i21 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i2117 | (i2118 & 7168) | (57344 & i2118) | (458752 & i2118) | (i2118 & 3670016), 388);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale2 = fit;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
            }
            num3 = num2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier14 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier14, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((196608 & i11) == 0) {
                if ((i12 & 32) == 0) {
                    iM5965getHighfv9h1I = i10;
                    if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                    }
                    i13 |= i24;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                i13 |= i24;
            } else {
                iM5965getHighfv9h1I = i10;
            }
            i18 = i12 & 64;
            if (i18 != 0) {
                if ((1572864 & i11) == 0) {
                    num2 = num;
                    if (composerStartRestartGroup.changed(num2)) {
                        i19 = 1048576;
                    } else {
                        i19 = 524288;
                    }
                    i13 |= i19;
                }
                if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f10)) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                    i13 |= i22;
                }
                if ((i13 & 4793491) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    } else {
                        if (i23 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        }
                        if (i16 != 0) {
                            str2 = "";
                        }
                        if ((i12 & 32) != 0) {
                            i13 &= -458753;
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        }
                        if (i18 != 0) {
                            num2 = null;
                        }
                    }
                    i21 = i13;
                    colorFilter3 = colorFilter2;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                    }
                    if (Build.VERSION.SDK_INT < 31) {
                        composerStartRestartGroup.startReplaceGroup(380429902);
                        ContentScale contentScale15 = fit;
                        m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale15, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                        modifier2 = modifier;
                        i20 = i20;
                        str3 = str3;
                        contentScale2 = contentScale15;
                        colorFilter3 = colorFilter3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = modifier;
                        contentScale2 = fit;
                        composerStartRestartGroup.startReplaceGroup(380756952);
                        int i2119 = i21 & 112;
                        int i21110 = i21 << 3;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i2119 | (i21110 & 7168) | (57344 & i21110) | (458752 & i21110) | (i21110 & 3670016), 388);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    modifier2 = modifier;
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    contentScale2 = fit;
                    str3 = str2;
                    i20 = iM5965getHighfv9h1I;
                }
                num3 = num2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier15 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier15, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 1572864;
            num2 = num;
            if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i13 |= i22;
            }
            if ((i13 & 4793491) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                } else {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                }
                i21 = i13;
                colorFilter3 = colorFilter2;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                }
                if (Build.VERSION.SDK_INT < 31) {
                    composerStartRestartGroup.startReplaceGroup(380429902);
                    ContentScale contentScale16 = fit;
                    m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale16, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                    modifier2 = modifier;
                    i20 = i20;
                    str3 = str3;
                    contentScale2 = contentScale16;
                    colorFilter3 = colorFilter3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier2 = modifier;
                    contentScale2 = fit;
                    composerStartRestartGroup.startReplaceGroup(380756952);
                    int i21111 = i21 & 112;
                    int i21112 = i21 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i21111 | (i21112 & 7168) | (57344 & i21112) | (458752 & i21112) | (i21112 & 3670016), 388);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale2 = fit;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
            }
            num3 = num2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier16 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier16, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        str2 = str;
        if ((196608 & i11) == 0) {
            if ((i12 & 32) == 0) {
                iM5965getHighfv9h1I = i10;
                if (composerStartRestartGroup.changed(iM5965getHighfv9h1I)) {
                }
                i13 |= i24;
            } else {
                iM5965getHighfv9h1I = i10;
            }
            i13 |= i24;
        } else {
            iM5965getHighfv9h1I = i10;
        }
        i18 = i12 & 64;
        if (i18 != 0) {
            if ((1572864 & i11) == 0) {
                num2 = num;
                if (composerStartRestartGroup.changed(num2)) {
                    i19 = 1048576;
                } else {
                    i19 = 524288;
                }
                i13 |= i19;
            }
            if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f10)) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
                i13 |= i22;
            }
            if ((i13 & 4793491) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                } else {
                    if (i23 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    }
                    if (i16 != 0) {
                        str2 = "";
                    }
                    if ((i12 & 32) != 0) {
                        i13 &= -458753;
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    }
                    if (i18 != 0) {
                        num2 = null;
                    }
                }
                i21 = i13;
                colorFilter3 = colorFilter2;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
                }
                if (Build.VERSION.SDK_INT < 31) {
                    composerStartRestartGroup.startReplaceGroup(380429902);
                    ContentScale contentScale17 = fit;
                    m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale17, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                    modifier2 = modifier;
                    i20 = i20;
                    str3 = str3;
                    contentScale2 = contentScale17;
                    colorFilter3 = colorFilter3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier2 = modifier;
                    contentScale2 = fit;
                    composerStartRestartGroup.startReplaceGroup(380756952);
                    int i21113 = i21 & 112;
                    int i21114 = i21 << 3;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i21113 | (i21114 & 7168) | (57344 & i21114) | (458752 & i21114) | (i21114 & 3670016), 388);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                modifier2 = modifier;
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                contentScale2 = fit;
                str3 = str2;
                i20 = iM5965getHighfv9h1I;
            }
            num3 = num2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier17 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier17, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 1572864;
        num2 = num;
        if ((i11 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f10)) {
                i22 = 8388608;
            } else {
                i22 = 4194304;
            }
            i13 |= i22;
        }
        if ((i13 & 4793491) != 4793490) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if (i23 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                }
                if (i16 != 0) {
                    str2 = "";
                }
                if ((i12 & 32) != 0) {
                    i13 &= -458753;
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                }
                if (i18 != 0) {
                    num2 = null;
                }
            } else {
                if (i23 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                }
                if (i16 != 0) {
                    str2 = "";
                }
                if ((i12 & 32) != 0) {
                    i13 &= -458753;
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                }
                if (i18 != 0) {
                    num2 = null;
                }
            }
            i21 = i13;
            colorFilter3 = colorFilter2;
            str3 = str2;
            i20 = iM5965getHighfv9h1I;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1613130447, i21, -1, "cu.z17.views.picture.Z17BlurImage (Z17BlurImage.kt:27)");
            }
            if (Build.VERSION.SDK_INT < 31) {
                composerStartRestartGroup.startReplaceGroup(380429902);
                ContentScale contentScale18 = fit;
                m10275LegacyBlurImage42YmkrA(modifier, source, colorFilter3, contentScale18, str3, i20, num2, f10, composerStartRestartGroup, i21 & 33554430, 0);
                modifier2 = modifier;
                i20 = i20;
                str3 = str3;
                contentScale2 = contentScale18;
                colorFilter3 = colorFilter3;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier2 = modifier;
                contentScale2 = fit;
                composerStartRestartGroup.startReplaceGroup(380756952);
                int i21115 = i21 & 112;
                int i21116 = i21 << 3;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(BlurKt.m5428blurF8QBwvs$default(modifier2, Dp.m8823constructorimpl(f10), null, 2, null), source, null, colorFilter3, contentScale2, str3, i20, null, null, composerStartRestartGroup, i21115 | (i21116 & 7168) | (57344 & i21116) | (458752 & i21116) | (i21116 & 3670016), 388);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
            colorFilter3 = colorFilter2;
            contentScale2 = fit;
            str3 = str2;
            i20 = iM5965getHighfv9h1I;
        }
        num3 = num2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier18 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17BlurImageKt.Z17BlurImage_42YmkrA$lambda$0(modifier18, source, colorFilter3, contentScale2, str3, i20, num3, f10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BlurImage_42YmkrA$lambda$0(Modifier modifier, Bitmap bitmap, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Integer num, float f10, int i11, int i12, Composer composer, int i13) {
        m10276Z17BlurImage42YmkrA(modifier, bitmap, colorFilter, contentScale, str, i10, num, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
