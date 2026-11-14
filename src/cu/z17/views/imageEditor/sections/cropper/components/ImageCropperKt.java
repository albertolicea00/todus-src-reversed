package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.imageEditor.sections.cropper.components.crop.CropAgent;
import cu.z17.views.imageEditor.sections.cropper.components.draw.ImageDrawCanvasKt;
import cu.z17.views.imageEditor.sections.cropper.components.draw.OverlayKt;
import cu.z17.views.imageEditor.sections.cropper.components.image.ImageScope;
import cu.z17.views.imageEditor.sections.cropper.components.image.ImageScopeKt;
import cu.z17.views.imageEditor.sections.cropper.components.image.ImageWithConstraintsKt;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropDefaults;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropProperties;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropStyle;
import cu.z17.views.imageEditor.sections.cropper.components.settings.CropType;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropStateKt;
import cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a§\u0001\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00132(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a§\u0001\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015H\u0003¢\u0006\u0004\b+\u0010,\u001a\u0097\u0001\u00100\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00172&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015H\u0003¢\u0006\u0004\b.\u0010/\u001a[\u00107\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00132\b\u00104\u001a\u0004\u0018\u000103H\u0003¢\u0006\u0004\b5\u00106\u001aE\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u00109\u001a\u0002082\u0006\u0010&\u001a\u00020%2\u0006\u0010:\u001a\u00020\fH\u0003¢\u0006\u0004\b=\u0010>¨\u0006@²\u0006\f\u0010?\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u00020\u000e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "", "contentDescription", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;", "cropStyle", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "cropProperties", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "", "crop", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lkotlin/Function0;", "Lua/k0;", "onCropStart", "Lkotlin/Function1;", "onCropSuccess", "Lkotlin/Function4;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Rect;", "", "onDrawGrid", "ImageCropper-7Wsh9oA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;IZJLlb/a;Lkotlin/jvm/functions/Function1;Llb/o;Landroidx/compose/runtime/Composer;III)V", "ImageCropper", "visible", "Landroidx/compose/ui/unit/Dp;", "containerWidth", "containerHeight", "", "imageWidthPx", "imageHeightPx", "handleSize", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;", "cropType", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "cropOutline", "overlayRect", "transparentColor", "ImageCropper-2nfD5hs", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/ImageBitmap;FFIIFLcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;Landroidx/compose/ui/geometry/Rect;JJLlb/o;Landroidx/compose/runtime/Composer;II)V", "rectOverlay", "ImageCropperImpl-QKFv1zo", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;FFIILcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;FLcu/z17/views/imageEditor/sections/cropper/components/settings/CropStyle;JLandroidx/compose/ui/geometry/Rect;Llb/o;Landroidx/compose/runtime/Composer;II)V", "ImageCropperImpl", "scaledImageBitmap", "cropRect", "Landroidx/compose/ui/unit/IntSize;", "requiredSize", "Crop-MFTNTCQ", "(ZLandroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/geometry/Rect;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;Llb/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/unit/IntSize;Landroidx/compose/runtime/Composer;I)V", "Crop", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "fixedAspectRatio", "", "", "getResetKeys", "(Landroidx/compose/ui/graphics/ImageBitmap;IILandroidx/compose/ui/layout/ContentScale;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;ZLandroidx/compose/runtime/Composer;I)[Ljava/lang/Object;", "isHandleTouched", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageCropperKt {
    @Composable
    /* JADX INFO: renamed from: Crop-MFTNTCQ, reason: not valid java name */
    private static final void m10149CropMFTNTCQ(final boolean z10, final ImageBitmap imageBitmap, final Rect rect, final CropOutline cropOutline, final lb.a aVar, final Function1 function1, final IntSize intSize, Composer composer, final int i10) {
        boolean z11;
        int i11;
        Rect rect2;
        lb.a aVar2;
        IntSize intSize2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-333605246);
        if ((i10 & 6) == 0) {
            z11 = z10;
            i11 = (composerStartRestartGroup.changed(z11) ? 4 : 2) | i10;
        } else {
            z11 = z10;
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            rect2 = rect;
            i11 |= composerStartRestartGroup.changed(rect2) ? 256 : 128;
        } else {
            rect2 = rect;
        }
        if ((i10 & 3072) == 0) {
            i11 |= (i10 & 4096) == 0 ? composerStartRestartGroup.changed(cropOutline) : composerStartRestartGroup.changedInstance(cropOutline) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            aVar2 = aVar;
            i11 |= composerStartRestartGroup.changedInstance(aVar2) ? 16384 : 8192;
        } else {
            aVar2 = aVar;
        }
        if ((196608 & i10) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            intSize2 = intSize;
            i11 |= composerStartRestartGroup.changed(intSize2) ? 1048576 : 524288;
        } else {
            intSize2 = intSize;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 599187) != 599186, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333605246, i11, -1, "cu.z17.views.imageEditor.sections.cropper.components.Crop (ImageCropper.kt:318)");
            }
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new CropAgent();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CropAgent cropAgent = (CropAgent) objRememberedValue;
            Boolean boolValueOf = Boolean.valueOf(z11);
            int i13 = i11 & 14;
            boolean zChangedInstance = ((i11 & 896) == 256) | (i13 == 4) | composerStartRestartGroup.changedInstance(cropAgent) | composerStartRestartGroup.changedInstance(imageBitmap) | ((i11 & 7168) == 2048 || ((i11 & 4096) != 0 && composerStartRestartGroup.changedInstance(cropOutline))) | composerStartRestartGroup.changed(layoutDirection.ordinal()) | composerStartRestartGroup.changed(density) | ((3670016 & i11) == 1048576) | ((57344 & i11) == 16384) | ((458752 & i11) == 131072);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                lb.a aVar3 = aVar2;
                IntSize intSize3 = intSize2;
                i12 = i13;
                ImageCropperKt$Crop$1$1 imageCropperKt$Crop$1$1 = new ImageCropperKt$Crop$1$1(z10, cropAgent, imageBitmap, rect2, cropOutline, layoutDirection, density, intSize3, aVar3, function1, null);
                composerStartRestartGroup.updateRememberedValue(imageCropperKt$Crop$1$1);
                objRememberedValue2 = imageCropperKt$Crop$1$1;
            } else {
                i12 = i13;
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue2, composerStartRestartGroup, i12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageCropperKt.Crop_MFTNTCQ$lambda$20(z10, imageBitmap, rect, cropOutline, aVar, function1, intSize, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Crop_MFTNTCQ$lambda$20(boolean z10, ImageBitmap imageBitmap, Rect rect, CropOutline cropOutline, lb.a aVar, Function1 function1, IntSize intSize, int i10, Composer composer, int i11) {
        m10149CropMFTNTCQ(z10, imageBitmap, rect, cropOutline, aVar, function1, intSize, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageCropper-2nfD5hs, reason: not valid java name */
    private static final void m10150ImageCropper2nfD5hs(final Modifier modifier, final boolean z10, final ImageBitmap imageBitmap, final float f10, final float f11, final int i10, final int i11, final float f12, final CropType cropType, final CropOutline cropOutline, final CropStyle cropStyle, final Rect rect, final long j10, final long j11, final lb.o oVar, Composer composer, final int i12, final int i13) {
        int i14;
        ImageBitmap imageBitmap2;
        float f13;
        CropStyle cropStyle2;
        int i15;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1033170381);
        if ((i12 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            imageBitmap2 = imageBitmap;
            i14 |= composerStartRestartGroup.changedInstance(imageBitmap2) ? 256 : 128;
        } else {
            imageBitmap2 = imageBitmap;
        }
        if ((i12 & 3072) == 0) {
            f13 = f10;
            i14 |= composerStartRestartGroup.changed(f13) ? 2048 : 1024;
        } else {
            f13 = f10;
        }
        if ((i12 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
        }
        if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 131072 : 65536;
        }
        if ((i12 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 1048576 : 524288;
        }
        if ((i12 & 12582912) == 0) {
            i14 |= composerStartRestartGroup.changed(f12) ? 8388608 : 4194304;
        }
        if ((i12 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changed(cropType.ordinal()) ? 67108864 : 33554432;
        }
        if ((805306368 & i12) == 0) {
            i14 |= (1073741824 & i12) == 0 ? composerStartRestartGroup.changed(cropOutline) : composerStartRestartGroup.changedInstance(cropOutline) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i13 & 6) == 0) {
            cropStyle2 = cropStyle;
            i15 = i13 | (composerStartRestartGroup.changed(cropStyle2) ? 4 : 2);
        } else {
            cropStyle2 = cropStyle;
            i15 = i13;
        }
        if ((i13 & 48) == 0) {
            i15 |= composerStartRestartGroup.changed(rect) ? 32 : 16;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i15 |= composerStartRestartGroup.changed(j10) ? 256 : 128;
        }
        if ((i13 & 3072) == 0) {
            i15 |= composerStartRestartGroup.changed(j11) ? 2048 : 1024;
        }
        if ((i13 & 24576) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(oVar) ? 16384 : 8192;
        }
        int i16 = i15;
        if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i16 & 9363) == 9362) ? false : true, i14 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1033170381, i14, i16, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropper (ImageCropper.kt:208)");
            }
            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j11, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1205backgroundbw27NRU$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final ImageBitmap imageBitmap3 = imageBitmap2;
            final CropStyle cropStyle3 = cropStyle2;
            final float f14 = f13;
            composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(z10, (Modifier) null, EnterExitTransitionKt.m1026scaleInL8ZKhE$default(AnimationSpecKt.tween$default(XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 0, null, 6, null), 0.0f, 0L, 6, null), (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1480027311, true, new Function3() { // from class: cu.z17.views.imageEditor.sections.cropper.components.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ImageCropperKt.ImageCropper_2nfD5hs$lambda$14$lambda$13(modifier, imageBitmap3, f14, f11, i10, i11, cropType, cropOutline, f12, cropStyle3, j10, rect, oVar, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, ((i14 >> 3) & 14) | 196992, 26);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageCropperKt.ImageCropper_2nfD5hs$lambda$15(modifier, z10, imageBitmap, f10, f11, i10, i11, f12, cropType, cropOutline, cropStyle, rect, j10, j11, oVar, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:144:0x01da  */
    /* JADX WARN: Code duplicated, block: B:147:0x0230  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageCropper-7Wsh9oA, reason: not valid java name */
    public static final void m10151ImageCropper7Wsh9oA(Modifier modifier, final ImageBitmap imageBitmap, final String str, CropStyle cropStyle, final CropProperties cropProperties, int i10, boolean z10, long j10, final lb.a onCropStart, final Function1 onCropSuccess, lb.o oVar, Composer composer, final int i11, final int i12, final int i13) {
        int i14;
        CropStyle cropStyle2;
        int i15;
        final boolean z11;
        final long jM5892getBlack0d7_KjU;
        int i16;
        final Modifier modifier2;
        final long j11;
        final int i17;
        final boolean z12;
        final CropStyle cropStyle3;
        final lb.o oVar2;
        final CropStyle cropStyleM10194styleLTESvPY$default;
        int iM6367getDefaultFilterQualityfv9h1I;
        Modifier modifier3;
        int i18;
        final lb.o oVar3;
        y.i(imageBitmap, "imageBitmap");
        y.i(cropProperties, "cropProperties");
        y.i(onCropStart, "onCropStart");
        y.i(onCropSuccess, "onCropSuccess");
        Composer composerStartRestartGroup = composer.startRestartGroup(356466856);
        int i19 = i13 & 1;
        if (i19 != 0) {
            i14 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i14 = i11;
        }
        if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(imageBitmap) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            if ((i13 & 8) == 0) {
                cropStyle2 = cropStyle;
                int i20 = composerStartRestartGroup.changed(cropStyle2) ? 2048 : 1024;
                i14 |= i20;
            } else {
                cropStyle2 = cropStyle;
            }
            i14 |= i20;
        } else {
            cropStyle2 = cropStyle;
        }
        if ((i11 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(cropProperties) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            if ((i13 & 32) == 0) {
                i15 = i10;
                int i21 = composerStartRestartGroup.changed(i15) ? 131072 : 65536;
                i14 |= i21;
            } else {
                i15 = i10;
            }
            i14 |= i21;
        } else {
            i15 = i10;
        }
        int i22 = i13 & 64;
        if (i22 != 0) {
            i14 |= 1572864;
            z11 = z10;
        } else {
            z11 = z10;
            if ((i11 & 1572864) == 0) {
                i14 |= composerStartRestartGroup.changed(z11) ? 1048576 : 524288;
            }
        }
        int i23 = i13 & 128;
        if (i23 != 0) {
            i14 |= 12582912;
            jM5892getBlack0d7_KjU = j10;
        } else {
            jM5892getBlack0d7_KjU = j10;
            if ((i11 & 12582912) == 0) {
                i14 |= composerStartRestartGroup.changed(jM5892getBlack0d7_KjU) ? 8388608 : 4194304;
            }
        }
        if ((i11 & 100663296) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onCropStart) ? 67108864 : 33554432;
        }
        if ((i11 & 805306368) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(onCropSuccess) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i24 = i13 & 1024;
        if (i24 != 0) {
            i16 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i16 = i12 | (composerStartRestartGroup.changedInstance(oVar) ? 4 : 2);
        } else {
            i16 = i12;
        }
        if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i16 & 3) == 2) ? false : true, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier4 = i19 != 0 ? Modifier.INSTANCE : modifier;
                if ((i13 & 8) != 0) {
                    cropStyleM10194styleLTESvPY$default = CropDefaults.m10194styleLTESvPY$default(CropDefaults.INSTANCE, false, false, 0.0f, 0L, 0L, 0L, 63, null);
                    i14 &= -7169;
                } else {
                    cropStyleM10194styleLTESvPY$default = cropStyle2;
                }
                if ((i13 & 32) != 0) {
                    iM6367getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6367getDefaultFilterQualityfv9h1I();
                    i14 = (-458753) & i14;
                } else {
                    iM6367getDefaultFilterQualityfv9h1I = i15;
                }
                if (i22 != 0) {
                    z11 = false;
                }
                if (i23 != 0) {
                    jM5892getBlack0d7_KjU = Color.INSTANCE.m5892getBlack0d7_KjU();
                }
                if (i24 != 0) {
                    modifier3 = modifier4;
                    i18 = i14;
                    oVar3 = null;
                } else {
                    modifier3 = modifier4;
                    i18 = i14;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(356466856, i18, i16, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropper (ImageCropper.kt:55)");
                }
                int i25 = i18;
                CropStyle cropStyle4 = cropStyleM10194styleLTESvPY$default;
                boolean z13 = z11;
                long j12 = jM5892getBlack0d7_KjU;
                lb.o oVar4 = oVar3;
                int i26 = i25 << 6;
                int i27 = iM6367getDefaultFilterQualityfv9h1I;
                ImageWithConstraintsKt.m10180ImageWithConstraintsnWU5RSE(ClipKt.clipToBounds(modifier3), imageBitmap, null, cropProperties.getContentScale(), str, 0.0f, null, i27, false, ComposableLambdaKt.rememberComposableLambda(-1127776554, true, new Function3() { // from class: cu.z17.views.imageEditor.sections.cropper.components.t
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageCropperKt.ImageCropper_7Wsh9oA$lambda$11(imageBitmap, cropProperties, cropStyleM10194styleLTESvPY$default, z11, onCropStart, onCropSuccess, jM5892getBlack0d7_KjU, oVar3, (ImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i25 & 112) | 905969664 | (57344 & i26) | (i26 & 29360128), 100);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i17 = i27;
                modifier2 = modifier3;
                cropStyle3 = cropStyle4;
                z12 = z13;
                j11 = j12;
                oVar2 = oVar4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i13 & 8) != 0) {
                    i14 &= -7169;
                }
                if ((i13 & 32) != 0) {
                    i14 &= -458753;
                }
                i18 = i14;
                cropStyleM10194styleLTESvPY$default = cropStyle2;
                iM6367getDefaultFilterQualityfv9h1I = i15;
                modifier3 = modifier;
            }
            oVar3 = oVar;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(356466856, i18, i16, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropper (ImageCropper.kt:55)");
            }
            int i28 = i18;
            CropStyle cropStyle5 = cropStyleM10194styleLTESvPY$default;
            boolean z14 = z11;
            long j13 = jM5892getBlack0d7_KjU;
            lb.o oVar5 = oVar3;
            int i29 = i28 << 6;
            int i210 = iM6367getDefaultFilterQualityfv9h1I;
            ImageWithConstraintsKt.m10180ImageWithConstraintsnWU5RSE(ClipKt.clipToBounds(modifier3), imageBitmap, null, cropProperties.getContentScale(), str, 0.0f, null, i210, false, ComposableLambdaKt.rememberComposableLambda(-1127776554, true, new Function3() { // from class: cu.z17.views.imageEditor.sections.cropper.components.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ImageCropperKt.ImageCropper_7Wsh9oA$lambda$11(imageBitmap, cropProperties, cropStyleM10194styleLTESvPY$default, z11, onCropStart, onCropSuccess, jM5892getBlack0d7_KjU, oVar3, (ImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i28 & 112) | 905969664 | (57344 & i29) | (i29 & 29360128), 100);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i17 = i210;
            modifier2 = modifier3;
            cropStyle3 = cropStyle5;
            z12 = z14;
            j11 = j13;
            oVar2 = oVar5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            j11 = jM5892getBlack0d7_KjU;
            i17 = i15;
            z12 = z11;
            cropStyle3 = cropStyle2;
            oVar2 = oVar;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageCropperKt.ImageCropper_7Wsh9oA$lambda$12(modifier2, imageBitmap, str, cropStyle3, cropProperties, i17, z12, j11, onCropStart, onCropSuccess, oVar2, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ImageCropperImpl-QKFv1zo, reason: not valid java name */
    private static final void m10152ImageCropperImplQKFv1zo(final Modifier modifier, final ImageBitmap imageBitmap, final float f10, final float f11, final int i10, final int i11, CropType cropType, final CropOutline cropOutline, final float f12, final CropStyle cropStyle, final long j10, final Rect rect, final lb.o oVar, Composer composer, final int i12, final int i13) {
        int i14;
        ImageBitmap imageBitmap2;
        int i15;
        int i16;
        CropType cropType2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(421360270);
        if ((i12 & 6) == 0) {
            i14 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        if ((i12 & 48) == 0) {
            imageBitmap2 = imageBitmap;
            i14 |= composerStartRestartGroup.changedInstance(imageBitmap2) ? 32 : 16;
        } else {
            imageBitmap2 = imageBitmap;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(f11) ? 2048 : 1024;
        }
        if ((i12 & 24576) == 0) {
            i15 = i10;
            i14 |= composerStartRestartGroup.changed(i15) ? 16384 : 8192;
        } else {
            i15 = i10;
        }
        if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changed(i11) ? 131072 : 65536;
        }
        if ((i12 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changed(cropType.ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & i12) == 0) {
            i14 |= (16777216 & i12) == 0 ? composerStartRestartGroup.changed(cropOutline) : composerStartRestartGroup.changedInstance(cropOutline) ? 8388608 : 4194304;
        }
        if ((100663296 & i12) == 0) {
            i14 |= composerStartRestartGroup.changed(f12) ? 67108864 : 33554432;
        }
        if ((i12 & 805306368) == 0) {
            i14 |= composerStartRestartGroup.changed(cropStyle) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i13 & 6) == 0) {
            i16 = i13 | (composerStartRestartGroup.changed(j10) ? 4 : 2);
        } else {
            i16 = i13;
        }
        if ((i13 & 48) == 0) {
            i16 |= composerStartRestartGroup.changed(rect) ? 32 : 16;
        }
        if ((i13 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i16 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        int i17 = i16;
        if (composerStartRestartGroup.shouldExecute(((i14 & 306783379) == 306783378 && (i17 & 147) == 146) ? false : true, i14 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421360270, i14, i17, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperImpl (ImageCropper.kt:271)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            int i18 = i14;
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i19 = i18 >> 6;
            ImageDrawCanvasKt.ImageDrawCanvas(modifier, imageBitmap2, i15, i11, composerStartRestartGroup, (i18 & 126) | (i19 & 896) | (i19 & 7168));
            composer2 = composerStartRestartGroup;
            cropType2 = cropType;
            OverlayKt.m10153DrawingOverlayMWhGqBo(SizeKt.m1771sizeVpY3zN4(companion, f10, f11), cropStyle.getDrawOverlay(), rect, cropOutline, cropStyle.getDrawGrid(), j10, cropStyle.m10211getOverlayColor0d7_KjU(), cropStyle.m10210getHandleColor0d7_KjU(), cropStyle.m10212getStrokeWidthD9Ej5fM(), cropType2 == CropType.Dynamic, f12, oVar, composer2, ((i17 << 3) & 896) | ((i18 >> 12) & 7168) | ((i17 << 15) & 458752), ((i18 >> 24) & 14) | ((i17 >> 3) & 112));
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            cropType2 = cropType;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final CropType cropType3 = cropType2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.cropper.components.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageCropperKt.ImageCropperImpl_QKFv1zo$lambda$17(modifier, imageBitmap, f10, f11, i10, i11, cropType3, cropOutline, f12, cropStyle, j10, rect, oVar, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageCropperImpl_QKFv1zo$lambda$17(Modifier modifier, ImageBitmap imageBitmap, float f10, float f11, int i10, int i11, CropType cropType, CropOutline cropOutline, float f12, CropStyle cropStyle, long j10, Rect rect, lb.o oVar, int i12, int i13, Composer composer, int i14) {
        m10152ImageCropperImplQKFv1zo(modifier, imageBitmap, f10, f11, i10, i11, cropType, cropOutline, f12, cropStyle, j10, rect, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), RecomposeScopeImplKt.updateChangedFlags(i13));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ImageCropper_2nfD5hs$lambda$14$lambda$13(Modifier modifier, ImageBitmap imageBitmap, float f10, float f11, int i10, int i11, CropType cropType, CropOutline cropOutline, float f12, CropStyle cropStyle, long j10, Rect rect, lb.o oVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i12) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1480027311, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropper.<anonymous>.<anonymous> (ImageCropper.kt:220)");
        }
        m10152ImageCropperImplQKFv1zo(modifier, imageBitmap, f10, f11, i10, i11, cropType, cropOutline, f12, cropStyle, j10, rect, oVar, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageCropper_2nfD5hs$lambda$15(Modifier modifier, boolean z10, ImageBitmap imageBitmap, float f10, float f11, int i10, int i11, float f12, CropType cropType, CropOutline cropOutline, CropStyle cropStyle, Rect rect, long j10, long j11, lb.o oVar, int i12, int i13, Composer composer, int i14) {
        m10150ImageCropper2nfD5hs(modifier, z10, imageBitmap, f10, f11, i10, i11, f12, cropType, cropOutline, cropStyle, rect, j10, j11, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), RecomposeScopeImplKt.updateChangedFlags(i13));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ImageCropper_7Wsh9oA$lambda$11(ImageBitmap imageBitmap, CropProperties cropProperties, CropStyle cropStyle, boolean z10, lb.a aVar, Function1 function1, long j10, lb.o oVar, ImageScope ImageWithConstraints, Composer composer, int i10) {
        int i11;
        y.i(ImageWithConstraints, "$this$ImageWithConstraints");
        if ((i10 & 6) == 0) {
            i11 = i10 | (composer.changed(ImageWithConstraints) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if (composer.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1127776554, i11, -1, "cu.z17.views.imageEditor.sections.cropper.components.ImageCropper.<anonymous> (ImageCropper.kt:68)");
            }
            ImageBitmap imageBitmapM10177getScaledImageBitmappBklqvs = ImageScopeKt.m10177getScaledImageBitmappBklqvs(ImageWithConstraints.mo10167getImageWidthD9Ej5fM(), ImageWithConstraints.mo10166getImageHeightD9Ej5fM(), ImageWithConstraints.getRect(), imageBitmap, cropProperties.getContentScale(), composer, 0);
            int iM8788getMaxWidthimpl = Constraints.m8788getMaxWidthimpl(ImageWithConstraints.mo10165getConstraintsmsEJaDk());
            int iM8787getMaxHeightimpl = Constraints.m8787getMaxHeightimpl(ImageWithConstraints.mo10165getConstraintsmsEJaDk());
            int width = imageBitmapM10177getScaledImageBitmappBklqvs.getWidth();
            int height = imageBitmapM10177getScaledImageBitmappBklqvs.getHeight();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            int iMo1339roundToPx0680j_4 = density.mo1339roundToPx0680j_4(ImageWithConstraints.mo10167getImageWidthD9Ej5fM());
            int iMo1339roundToPx0680j_5 = density.mo1339roundToPx0680j_4(ImageWithConstraints.mo10166getImageHeightD9Ej5fM());
            float fMo1342toDpu2uoSUM = density.mo1342toDpu2uoSUM(iM8788getMaxWidthimpl);
            float fMo1342toDpu2uoSUM2 = density.mo1342toDpu2uoSUM(iM8787getMaxHeightimpl);
            CropType cropType = cropProperties.getCropType();
            ContentScale contentScale = cropProperties.getContentScale();
            boolean fixedAspectRatio = cropProperties.getFixedAspectRatio();
            CropOutline cropOutline = cropProperties.getCropOutlineProperty().getCropOutline();
            Object[] resetKeys = getResetKeys(imageBitmapM10177getScaledImageBitmappBklqvs, iMo1339roundToPx0680j_4, iMo1339roundToPx0680j_5, contentScale, cropType, fixedAspectRatio, composer, 0);
            final CropState cropStateM10216rememberCropStatevKe4d9Q = CropStateKt.m10216rememberCropStatevKe4d9Q(IntSize.m8985constructorimpl((((long) width) << 32) | (((long) height) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), IntSize.m8985constructorimpl((((long) iM8788getMaxWidthimpl) << 32) | (((long) iM8787getMaxHeightimpl) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), IntSize.m8985constructorimpl((((long) iMo1339roundToPx0680j_4) << 32) | (((long) iMo1339roundToPx0680j_5) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), cropProperties, Arrays.copyOf(resetKeys, resetKeys.length), composer, 0);
            boolean zChanged = composer.changed(cropStateM10216rememberCropStatevKe4d9Q);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new lb.a() { // from class: cu.z17.views.imageEditor.sections.cropper.components.v
                    @Override // lb.a
                    public final Object invoke() {
                        return Boolean.valueOf(ImageCropperKt.ImageCropper_7Wsh9oA$lambda$11$lambda$2$lambda$1(cropStateM10216rememberCropStatevKe4d9Q));
                    }
                });
                composer.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            boolean zChanged2 = composer.changed(cropStyle.m10209getBackgroundColor0d7_KjU());
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = Color.m5856boximpl(Color.m5865copywmQWz5c$default(cropStyle.m10209getBackgroundColor0d7_KjU(), Color.m5868getAlphaimpl(cropStyle.m10209getBackgroundColor0d7_KjU()) * 0.7f, 0.0f, 0.0f, 0.0f, 14, null));
                composer.updateRememberedValue(objRememberedValue2);
            }
            long jM5876unboximpl = ((Color) objRememberedValue2).m5876unboximpl();
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);
            if (!ImageCropper_7Wsh9oA$lambda$11$lambda$3(state)) {
                jM5876unboximpl = cropStyle.m10209getBackgroundColor0d7_KjU();
            }
            State<Color> stateM1076animateColorAsStateeuL9pac = SingleValueAnimationKt.m1076animateColorAsStateeuL9pac(jM5876unboximpl, tweenSpecTween$default, "ca", null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
            m10149CropMFTNTCQ(z10, imageBitmapM10177getScaledImageBitmappBklqvs, cropStateM10216rememberCropStatevKe4d9Q.getCropRect(), cropOutline, aVar, function1, cropProperties.m10202getRequiredSizebOM6tXw(), composer, 0);
            Modifier modifierCrop$default = CropModifierKt.crop$default(SizeKt.m1771sizeVpY3zN4(Modifier.INSTANCE, fMo1342toDpu2uoSUM, fMo1342toDpu2uoSUM2), Arrays.copyOf(resetKeys, resetKeys.length), cropStateM10216rememberCropStatevKe4d9Q, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
            boolean zChanged3 = composer.changed(cropStateM10216rememberCropStatevKe4d9Q) | composer.changed(cropProperties);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ImageCropperKt$ImageCropper$1$2$1(cropStateM10216rememberCropStatevKe4d9Q, cropProperties, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(cropProperties, (Function2) objRememberedValue3, composer, 0);
            Object objRememberedValue4 = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState = (MutableState) objRememberedValue4;
            k0 k0Var = k0.f43947a;
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new ImageCropperKt$ImageCropper$1$3$1(mutableState, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue5, composer, 6);
            m10150ImageCropper2nfD5hs(modifierCrop$default, ImageCropper_7Wsh9oA$lambda$11$lambda$8(mutableState), imageBitmap, fMo1342toDpu2uoSUM, fMo1342toDpu2uoSUM2, iMo1339roundToPx0680j_4, iMo1339roundToPx0680j_5, cropProperties.getHandleSize(), cropType, cropOutline, cropStyle, cropStateM10216rememberCropStatevKe4d9Q.getOverlayRect(), ImageCropper_7Wsh9oA$lambda$11$lambda$5(stateM1076animateColorAsStateeuL9pac), j10, oVar, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ImageCropper_7Wsh9oA$lambda$11$lambda$2$lambda$1(CropState cropState) {
        return (cropState instanceof DynamicCropState) && TouchRegionKt.handlesTouched(cropState.getTouchRegion());
    }

    private static final boolean ImageCropper_7Wsh9oA$lambda$11$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final long ImageCropper_7Wsh9oA$lambda$11$lambda$5(State<Color> state) {
        return state.getValue().m5876unboximpl();
    }

    private static final boolean ImageCropper_7Wsh9oA$lambda$11$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImageCropper_7Wsh9oA$lambda$11$lambda$9(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ImageCropper_7Wsh9oA$lambda$12(Modifier modifier, ImageBitmap imageBitmap, String str, CropStyle cropStyle, CropProperties cropProperties, int i10, boolean z10, long j10, lb.a aVar, Function1 function1, lb.o oVar, int i11, int i12, int i13, Composer composer, int i14) {
        m10151ImageCropper7Wsh9oA(modifier, imageBitmap, str, cropStyle, cropProperties, i10, z10, j10, aVar, function1, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), RecomposeScopeImplKt.updateChangedFlags(i12), i13);
        return k0.f43947a;
    }

    @Composable
    private static final Object[] getResetKeys(ImageBitmap imageBitmap, int i10, int i11, ContentScale contentScale, CropType cropType, boolean z10, Composer composer, int i12) {
        Object obj;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-676867052, i12, -1, "cu.z17.views.imageEditor.sections.cropper.components.getResetKeys (ImageCropper.kt:369)");
        }
        boolean zChanged = ((((458752 & i12) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(z10)) || (i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(imageBitmap) | ((((i12 & 112) ^ 48) > 32 && composer.changed(i10)) || (i12 & 48) == 32) | ((((i12 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i11)) || (i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i12 & 7168) ^ 3072) > 2048 && composer.changed(contentScale)) || (i12 & 3072) == 2048) | ((((57344 & i12) ^ 24576) > 16384 && composer.changed(cropType.ordinal())) || (i12 & 24576) == 16384);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            obj = objRememberedValue;
            Object[] objArr = {imageBitmap, Integer.valueOf(i10), Integer.valueOf(i11), contentScale, cropType, Boolean.valueOf(z10)};
            composer.updateRememberedValue(objArr);
            obj = objArr;
        }
        obj = objRememberedValue;
        Object[] objArr2 = (Object[]) obj;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return objArr2;
    }
}
