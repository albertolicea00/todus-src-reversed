package cu.z17.views.videoEditor.sections.filter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.audio.ChannelMixingAudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.OpusUtil;
import androidx.media3.effect.BaseGlShaderProgram;
import androidx.media3.effect.BitmapOverlay;
import androidx.media3.effect.Contrast;
import androidx.media3.effect.DrawableOverlay;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.HslAdjustment;
import androidx.media3.effect.OverlayEffect;
import androidx.media3.effect.OverlaySettings;
import androidx.media3.effect.Presentation;
import androidx.media3.effect.RgbAdjustment;
import androidx.media3.effect.RgbFilter;
import androidx.media3.effect.RgbMatrix;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.effect.SingleColorLut;
import androidx.media3.effect.TextOverlay;
import androidx.media3.effect.k4;
import androidx.media3.effect.s2;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.DefaultEncoderFactory;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.EditedMediaItemSequence;
import androidx.media3.transformer.Effects;
import androidx.media3.transformer.ExportException;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import androidx.media3.transformer.c3;
import androidx.tracing.Trace;
import c3.h0;
import cu.z17.views.videoEditor.sections.filter.TransformerUtility;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010,\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\"R\u0014\u0010-\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u0010.\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\"R\u0014\u0010/\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\"R\u0014\u00100\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\"R\u0014\u00101\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010\"R\u0014\u00102\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\"R\u0014\u00103\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010\"R\u0014\u00104\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\"R\u0014\u00105\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010\"R\u0014\u00106\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010\"R\u0014\u00107\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010\"R\u0014\u00108\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010\"R\u0014\u00109\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010\"R\u0014\u0010:\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010\"R\u0014\u0010;\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010\"R\u0014\u0010<\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010\"R\u0014\u0010=\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010\"R\u0014\u0010>\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010\"R\u0014\u0010?\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010\"R\u0014\u0010@\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010\"R\u0014\u0010A\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010\"R\u0014\u0010B\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010\"R\u0014\u0010C\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010\"R\u0014\u0010E\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010H\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010FR\u0014\u0010I\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010FR\u0014\u0010J\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010FR\u0014\u0010K\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010FR\u0014\u0010L\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010FR\u0014\u0010M\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010FR\u0014\u0010N\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010FR\u0014\u0010O\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010FR\u0014\u0010P\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010FR\u0014\u0010Q\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010FR\u0014\u0010R\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010FR\u0014\u0010S\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010FR\u0014\u0010T\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010FR\u0014\u0010U\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010FR\u0014\u0010V\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010FR\u0014\u0010W\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010FR\u0014\u0010X\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010FR\u0014\u0010Y\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010FR\u0014\u0010Z\u001a\u00020D8\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010F¨\u0006["}, d2 = {"Lcu/z17/views/videoEditor/sections/filter/TransformerUtility;", "", "<init>", "()V", "Landroid/os/Bundle;", "bundle", "Landroid/net/Uri;", "uri", "Landroidx/media3/common/MediaItem;", "createMediaItem", "(Landroid/os/Bundle;Landroid/net/Uri;)Landroidx/media3/common/MediaItem;", "Landroid/content/Context;", "context", "Landroidx/media3/transformer/Transformer;", "createTransformer", "(Landroid/os/Bundle;Landroid/content/Context;)Landroidx/media3/transformer/Transformer;", "mediaItem", "Landroidx/media3/transformer/Composition;", "createComposition", "(Landroidx/media3/common/MediaItem;Landroid/os/Bundle;Landroid/content/Context;)Landroidx/media3/transformer/Composition;", "Lc3/h0;", "Landroidx/media3/common/audio/AudioProcessor;", "createAudioProcessorsFromBundle", "(Landroid/os/Bundle;)Lc3/h0;", "Landroidx/media3/common/Effect;", "createVideoEffectsFromBundle", "(Landroid/os/Bundle;Landroid/content/Context;)Lc3/h0;", "", "selectedEffects", "Landroidx/media3/effect/OverlayEffect;", "createOverlayEffectFromBundle", "(Landroid/os/Bundle;[ZLandroid/content/Context;)Landroidx/media3/effect/OverlayEffect;", "", "SHOULD_REMOVE_AUDIO", "Ljava/lang/String;", "SHOULD_REMOVE_VIDEO", "SHOULD_FLATTEN_FOR_SLOW_MOTION", "FORCE_AUDIO_TRACK", "AUDIO_MIME_TYPE", "VIDEO_MIME_TYPE", "RESOLUTION_HEIGHT", "SCALE_X", "SCALE_Y", "ROTATE_DEGREES", "TRIM_START_MS", "TRIM_END_MS", "ENABLE_FALLBACK", "ABORT_SLOW_EXPORT", "HDR_MODE", "AUDIO_EFFECTS_SELECTIONS", "VIDEO_EFFECTS_SELECTIONS", "PERIODIC_VIGNETTE_CENTER_X", "PERIODIC_VIGNETTE_CENTER_Y", "PERIODIC_VIGNETTE_INNER_RADIUS", "PERIODIC_VIGNETTE_OUTER_RADIUS", "COLOR_FILTER_SELECTION", "CONTRAST_VALUE", "RGB_ADJUSTMENT_RED_SCALE", "RGB_ADJUSTMENT_GREEN_SCALE", "RGB_ADJUSTMENT_BLUE_SCALE", "HSL_ADJUSTMENTS_HUE", "HSL_ADJUSTMENTS_SATURATION", "HSL_ADJUSTMENTS_LIGHTNESS", "BITMAP_OVERLAY_URI", "BITMAP_OVERLAY_ALPHA", "TEXT_OVERLAY_TEXT", "TEXT_OVERLAY_TEXT_COLOR", "TEXT_OVERLAY_ALPHA", "", "DIZZY_CROP_INDEX", "I", "EDGE_DETECTOR_INDEX", "COLOR_FILTERS_INDEX", "MAP_WHITE_TO_GREEN_LUT_INDEX", "RGB_ADJUSTMENTS_INDEX", "HSL_ADJUSTMENT_INDEX", "CONTRAST_INDEX", "PERIODIC_VIGNETTE_INDEX", "SPIN_3D_INDEX", "ZOOM_IN_INDEX", "OVERLAY_LOGO_AND_TIMER_INDEX", "BITMAP_OVERLAY_INDEX", "TEXT_OVERLAY_INDEX", "HIGH_PITCHED_INDEX", "SAMPLE_RATE_INDEX", "SKIP_SILENCE_INDEX", "CHANNEL_MIXING_INDEX", "VOLUME_SCALING_INDEX", "COLOR_FILTER_GRAYSCALE", "COLOR_FILTER_INVERTED", "COLOR_FILTER_SEPIA", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransformerUtility {
    public static final int $stable = 0;
    public static final String ABORT_SLOW_EXPORT = "abort_slow_export";
    public static final String AUDIO_EFFECTS_SELECTIONS = "audio_effects_selections";
    public static final String AUDIO_MIME_TYPE = "audio_mime_type";
    public static final String BITMAP_OVERLAY_ALPHA = "bitmap_overlay_alpha";
    public static final int BITMAP_OVERLAY_INDEX = 11;
    public static final String BITMAP_OVERLAY_URI = "bitmap_overlay_uri";
    public static final int CHANNEL_MIXING_INDEX = 3;
    public static final int COLOR_FILTERS_INDEX = 2;
    public static final int COLOR_FILTER_GRAYSCALE = 0;
    public static final int COLOR_FILTER_INVERTED = 1;
    public static final String COLOR_FILTER_SELECTION = "color_filter_selection";
    public static final int COLOR_FILTER_SEPIA = 2;
    public static final int CONTRAST_INDEX = 6;
    public static final String CONTRAST_VALUE = "contrast_value";
    public static final int DIZZY_CROP_INDEX = 0;
    public static final int EDGE_DETECTOR_INDEX = 1;
    public static final String ENABLE_FALLBACK = "enable_fallback";
    public static final String FORCE_AUDIO_TRACK = "force_audio_track";
    public static final String HDR_MODE = "hdr_mode";
    public static final int HIGH_PITCHED_INDEX = 0;
    public static final String HSL_ADJUSTMENTS_HUE = "hsl_adjustments_hue";
    public static final String HSL_ADJUSTMENTS_LIGHTNESS = "hsl_adjustments_lightness";
    public static final String HSL_ADJUSTMENTS_SATURATION = "hsl_adjustments_saturation";
    public static final int HSL_ADJUSTMENT_INDEX = 5;
    public static final TransformerUtility INSTANCE = new TransformerUtility();
    public static final int MAP_WHITE_TO_GREEN_LUT_INDEX = 3;
    public static final int OVERLAY_LOGO_AND_TIMER_INDEX = 10;
    public static final String PERIODIC_VIGNETTE_CENTER_X = "periodic_vignette_center_x";
    public static final String PERIODIC_VIGNETTE_CENTER_Y = "periodic_vignette_center_y";
    public static final int PERIODIC_VIGNETTE_INDEX = 7;
    public static final String PERIODIC_VIGNETTE_INNER_RADIUS = "periodic_vignette_inner_radius";
    public static final String PERIODIC_VIGNETTE_OUTER_RADIUS = "periodic_vignette_outer_radius";
    public static final String RESOLUTION_HEIGHT = "resolution_height";
    public static final int RGB_ADJUSTMENTS_INDEX = 4;
    public static final String RGB_ADJUSTMENT_BLUE_SCALE = "rgb_adjustment_blue_scale";
    public static final String RGB_ADJUSTMENT_GREEN_SCALE = "rgb_adjustment_green_scale";
    public static final String RGB_ADJUSTMENT_RED_SCALE = "rgb_adjustment_red_scale";
    public static final String ROTATE_DEGREES = "rotate_degrees";
    public static final int SAMPLE_RATE_INDEX = 1;
    public static final String SCALE_X = "scale_x";
    public static final String SCALE_Y = "scale_y";
    public static final String SHOULD_FLATTEN_FOR_SLOW_MOTION = "should_flatten_for_slow_motion";
    public static final String SHOULD_REMOVE_AUDIO = "should_remove_audio";
    public static final String SHOULD_REMOVE_VIDEO = "should_remove_video";
    public static final int SKIP_SILENCE_INDEX = 2;
    public static final int SPIN_3D_INDEX = 8;
    public static final String TEXT_OVERLAY_ALPHA = "text_overlay_alpha";
    public static final int TEXT_OVERLAY_INDEX = 12;
    public static final String TEXT_OVERLAY_TEXT = "text_overlay_text";
    public static final String TEXT_OVERLAY_TEXT_COLOR = "text_overlay_text_color";
    public static final String TRIM_END_MS = "trim_end_ms";
    public static final String TRIM_START_MS = "trim_start_ms";
    public static final String VIDEO_EFFECTS_SELECTIONS = "video_effects_selections";
    public static final String VIDEO_MIME_TYPE = "video_mime_type";
    public static final int VOLUME_SCALING_INDEX = 4;
    public static final int ZOOM_IN_INDEX = 9;

    private TransformerUtility() {
    }

    private final h0 createAudioProcessorsFromBundle(Bundle bundle) {
        ChannelMixingMatrix channelMixingMatrixCreate;
        boolean[] booleanArray = bundle.getBooleanArray(AUDIO_EFFECTS_SELECTIONS);
        if (booleanArray == null) {
            h0 h0VarZ = h0.z();
            y.h(h0VarZ, "of(...)");
            return h0VarZ;
        }
        h0.a aVar = new h0.a();
        if (booleanArray[0] || booleanArray[1]) {
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            if (booleanArray[0]) {
                sonicAudioProcessor.setPitch(2.0f);
            }
            if (booleanArray[1]) {
                sonicAudioProcessor.setOutputSampleRateHz(OpusUtil.SAMPLE_RATE);
            }
            aVar.a(sonicAudioProcessor);
        }
        if (booleanArray[2]) {
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            silenceSkippingAudioProcessor.setEnabled(true);
            aVar.a(silenceSkippingAudioProcessor);
        }
        boolean z10 = booleanArray[3];
        boolean z11 = booleanArray[4];
        if (z10 || z11) {
            ChannelMixingAudioProcessor channelMixingAudioProcessor = new ChannelMixingAudioProcessor();
            for (int i10 = 1; i10 < 7; i10++) {
                if (z10) {
                    float[] fArr = new float[i10];
                    Arrays.fill(fArr, 1.0f / i10);
                    channelMixingMatrixCreate = new ChannelMixingMatrix(i10, 1, fArr);
                } else {
                    channelMixingMatrixCreate = ChannelMixingMatrix.create(i10, i10);
                    y.f(channelMixingMatrixCreate);
                }
                if (z11) {
                    channelMixingMatrixCreate = channelMixingMatrixCreate.scaleBy(0.5f);
                }
                channelMixingAudioProcessor.putChannelMixingMatrix(channelMixingMatrixCreate);
            }
            aVar.a(channelMixingAudioProcessor);
        }
        h0 h0VarM = aVar.m();
        y.h(h0VarM, "build(...)");
        return h0VarM;
    }

    private final Composition createComposition(MediaItem mediaItem, Bundle bundle, Context context) {
        EditedMediaItem.Builder builder = new EditedMediaItem.Builder(mediaItem);
        builder.setDurationUs(DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US).setFrameRate(30);
        if (bundle != null) {
            builder.setRemoveAudio(bundle.getBoolean(SHOULD_REMOVE_AUDIO)).setRemoveVideo(bundle.getBoolean(SHOULD_REMOVE_VIDEO)).setFlattenForSlowMotion(bundle.getBoolean(SHOULD_FLATTEN_FOR_SLOW_MOTION)).setEffects(new Effects(createAudioProcessorsFromBundle(bundle), createVideoEffectsFromBundle(bundle, context)));
        }
        Composition.Builder builder2 = new Composition.Builder(new EditedMediaItemSequence(builder.build(), new EditedMediaItem[0]), new EditedMediaItemSequence[0]);
        if (bundle != null) {
            builder2.setHdrMode(bundle.getInt(HDR_MODE)).experimentalSetForceAudioTrack(bundle.getBoolean(FORCE_AUDIO_TRACK));
        }
        Composition compositionBuild = builder2.build();
        y.h(compositionBuild, "build(...)");
        return compositionBuild;
    }

    private final MediaItem createMediaItem(Bundle bundle, Uri uri) {
        MediaItem.Builder uri2 = new MediaItem.Builder().setUri(uri);
        y.h(uri2, "setUri(...)");
        if (bundle != null) {
            long j10 = bundle.getLong(TRIM_START_MS, C.TIME_UNSET);
            long j11 = bundle.getLong(TRIM_END_MS, C.TIME_UNSET);
            if (j10 != C.TIME_UNSET && j11 != C.TIME_UNSET) {
                uri2.setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(j10).setEndPositionMs(j11).build());
            }
        }
        MediaItem mediaItemBuild = uri2.build();
        y.h(mediaItemBuild, "build(...)");
        return mediaItemBuild;
    }

    private final OverlayEffect createOverlayEffectFromBundle(Bundle bundle, boolean[] selectedEffects, Context context) {
        h0.a aVar = new h0.a();
        if (selectedEffects[10]) {
            OverlaySettings overlaySettingsBuild = new OverlaySettings.Builder().setOverlayFrameAnchor(1.0f, 1.0f).setBackgroundFrameAnchor(-0.95f, -0.95f).build();
            y.h(overlaySettingsBuild, "build(...)");
            try {
                Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
                y.f(applicationIcon);
                applicationIcon.setBounds(0, 0, applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight());
                DrawableOverlay drawableOverlayCreateStaticDrawableOverlay = DrawableOverlay.createStaticDrawableOverlay(applicationIcon, overlaySettingsBuild);
                y.h(drawableOverlayCreateStaticDrawableOverlay, "createStaticDrawableOverlay(...)");
                aVar.j(drawableOverlayCreateStaticDrawableOverlay, new TimerOverlay());
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (selectedEffects[11]) {
            OverlaySettings overlaySettingsBuild2 = new OverlaySettings.Builder().setAlphaScale(bundle.getFloat(BITMAP_OVERLAY_ALPHA, 1.0f)).build();
            y.h(overlaySettingsBuild2, "build(...)");
            BitmapOverlay bitmapOverlayCreateStaticBitmapOverlay = BitmapOverlay.createStaticBitmapOverlay(context, Uri.parse((String) Assertions.checkNotNull(bundle.getString(BITMAP_OVERLAY_URI))), overlaySettingsBuild2);
            y.h(bitmapOverlayCreateStaticBitmapOverlay, "createStaticBitmapOverlay(...)");
            aVar.a(bitmapOverlayCreateStaticBitmapOverlay);
        }
        if (selectedEffects[12]) {
            OverlaySettings overlaySettingsBuild3 = new OverlaySettings.Builder().setAlphaScale(bundle.getFloat(TEXT_OVERLAY_ALPHA, 1.0f)).build();
            y.h(overlaySettingsBuild3, "build(...)");
            SpannableString spannableString = new SpannableString((CharSequence) Assertions.checkNotNull(bundle.getString(TEXT_OVERLAY_TEXT)));
            spannableString.setSpan(new ForegroundColorSpan(bundle.getInt(TEXT_OVERLAY_TEXT_COLOR)), 0, spannableString.length(), 33);
            TextOverlay textOverlayCreateStaticTextOverlay = TextOverlay.createStaticTextOverlay(spannableString, overlaySettingsBuild3);
            y.h(textOverlayCreateStaticTextOverlay, "createStaticTextOverlay(...)");
            aVar.a(textOverlayCreateStaticTextOverlay);
        }
        h0 h0VarM = aVar.m();
        if (h0VarM.isEmpty()) {
            return null;
        }
        return new OverlayEffect(h0VarM);
    }

    private final Transformer createTransformer(Bundle bundle, Context context) {
        Transformer.Builder builder = new Transformer.Builder(context);
        if (bundle != null) {
            String string = bundle.getString(AUDIO_MIME_TYPE);
            if (string != null) {
                builder.setAudioMimeType(string);
            }
            String string2 = bundle.getString(VIDEO_MIME_TYPE);
            if (string2 != null) {
                builder.setVideoMimeType(string2);
            }
            builder.setEncoderFactory(new DefaultEncoderFactory.Builder(context).setEnableFallback(bundle.getBoolean(ENABLE_FALLBACK)).build());
        }
        Transformer transformerBuild = builder.addListener(new Transformer.Listener() { // from class: cu.z17.views.videoEditor.sections.filter.TransformerUtility.createTransformer.1
            @Override // androidx.media3.transformer.Transformer.Listener
            public void onCompleted(Composition composition, ExportResult exportResult) {
                y.i(composition, "composition");
                y.i(exportResult, "exportResult");
            }

            @Override // androidx.media3.transformer.Transformer.Listener
            public void onError(Composition composition, ExportResult exportResult, ExportException exportException) {
                y.i(composition, "composition");
                y.i(exportResult, "exportResult");
                y.i(exportException, "exportException");
            }

            @Override // androidx.media3.transformer.Transformer.Listener
            public /* synthetic */ void onFallbackApplied(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2) {
                c3.c(this, composition, transformationRequest, transformationRequest2);
            }
        }).build();
        y.h(transformerBuild, "build(...)");
        return transformerBuild;
    }

    private final h0 createVideoEffectsFromBundle(final Bundle bundle, Context context) {
        boolean[] booleanArray = bundle.getBooleanArray(VIDEO_EFFECTS_SELECTIONS);
        if (booleanArray == null) {
            h0 h0VarZ = h0.z();
            y.h(h0VarZ, "of(...)");
            return h0VarZ;
        }
        h0.a aVar = new h0.a();
        int i10 = 0;
        if (booleanArray[0]) {
            aVar.a(MatrixTransformationFactory.INSTANCE.createDizzyCropEffect());
        }
        if (booleanArray[1]) {
            try {
                Class<?> cls = Class.forName("androidx.media3.demo.transformer.MediaPipeShaderProgram");
                Class<?> cls2 = Boolean.TYPE;
                final Constructor<?> constructor = cls.getConstructor(Context.class, cls2, String.class, cls2, String.class, String.class);
                aVar.a(new GlEffect() { // from class: u9.e
                    @Override // androidx.media3.common.Effect
                    public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                        return androidx.media3.common.f.a(this, j10);
                    }

                    @Override // androidx.media3.effect.GlEffect
                    public /* synthetic */ boolean isNoOp(int i11, int i12) {
                        return s2.a(this, i11, i12);
                    }

                    @Override // androidx.media3.effect.GlEffect
                    public final GlShaderProgram toGlShaderProgram(Context context2, boolean z10) {
                        return TransformerUtility.createVideoEffectsFromBundle$lambda$0(constructor, context2, z10);
                    }
                });
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (booleanArray[2]) {
            int i11 = bundle.getInt(COLOR_FILTER_SELECTION);
            if (i11 == 0) {
                aVar.a(RgbFilter.createGrayscaleFilter());
            } else if (i11 == 1) {
                aVar.a(RgbFilter.createInvertedFilter());
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Unexpected color filter " + bundle.getInt(COLOR_FILTER_SELECTION));
                }
                final float[] fArr = {0.393f, 0.349f, 0.272f, 0.0f, 0.769f, 0.686f, 0.534f, 0.0f, 0.189f, 0.168f, 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                aVar.a(new RgbMatrix() { // from class: u9.f
                    @Override // androidx.media3.common.Effect
                    public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                        return androidx.media3.common.f.a(this, j10);
                    }

                    @Override // androidx.media3.effect.RgbMatrix
                    public final float[] getMatrix(long j10, boolean z10) {
                        return TransformerUtility.createVideoEffectsFromBundle$lambda$1(fArr, j10, z10);
                    }

                    @Override // androidx.media3.effect.GlEffect
                    public /* synthetic */ boolean isNoOp(int i12, int i13) {
                        return s2.a(this, i12, i13);
                    }

                    @Override // androidx.media3.effect.RgbMatrix, androidx.media3.effect.GlEffect
                    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context2, boolean z10) {
                        return k4.a(this, context2, z10);
                    }

                    @Override // androidx.media3.effect.RgbMatrix, androidx.media3.effect.GlEffect
                    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context2, boolean z10) {
                        return toGlShaderProgram(context2, z10);
                    }
                });
            }
        }
        if (booleanArray[3]) {
            int[][][] iArr = new int[3][][];
            for (int i12 = 0; i12 < 3; i12++) {
                int[][] iArr2 = new int[3][];
                for (int i13 = 0; i13 < 3; i13++) {
                    iArr2[i13] = new int[3];
                }
                iArr[i12] = iArr2;
            }
            int i14 = 0;
            while (i14 < 3) {
                int i15 = i10;
                while (i15 < 3) {
                    for (int i16 = i10; i16 < 3; i16++) {
                        iArr[i14][i15][i16] = Color.rgb(i14 * Trace.MAX_TRACE_LABEL_LENGTH, i15 * Trace.MAX_TRACE_LABEL_LENGTH, i16 * Trace.MAX_TRACE_LABEL_LENGTH);
                    }
                    i15++;
                    i10 = 0;
                }
                i14++;
                i10 = 0;
            }
            iArr[2][2][2] = -16711936;
            aVar.a(SingleColorLut.createFromCube(iArr));
        }
        if (booleanArray[4]) {
            aVar.a(new RgbAdjustment.Builder().setRedScale(bundle.getFloat(RGB_ADJUSTMENT_RED_SCALE)).setGreenScale(bundle.getFloat(RGB_ADJUSTMENT_GREEN_SCALE)).setBlueScale(bundle.getFloat(RGB_ADJUSTMENT_BLUE_SCALE)).build());
        }
        if (booleanArray[5]) {
            aVar.a(new HslAdjustment.Builder().adjustHue(bundle.getFloat(HSL_ADJUSTMENTS_HUE)).adjustSaturation(bundle.getFloat(HSL_ADJUSTMENTS_SATURATION)).adjustLightness(bundle.getFloat(HSL_ADJUSTMENTS_LIGHTNESS)).build());
        }
        if (booleanArray[6]) {
            aVar.a(new Contrast(bundle.getFloat(CONTRAST_VALUE)));
        }
        if (booleanArray[7]) {
            aVar.a(new GlEffect() { // from class: u9.g
                @Override // androidx.media3.common.Effect
                public /* synthetic */ long getDurationAfterEffectApplied(long j10) {
                    return androidx.media3.common.f.a(this, j10);
                }

                @Override // androidx.media3.effect.GlEffect
                public /* synthetic */ boolean isNoOp(int i17, int i18) {
                    return s2.a(this, i17, i18);
                }

                @Override // androidx.media3.effect.GlEffect
                public final GlShaderProgram toGlShaderProgram(Context context2, boolean z10) {
                    return TransformerUtility.createVideoEffectsFromBundle$lambda$2(bundle, context2, z10);
                }
            });
        }
        if (booleanArray[8]) {
            aVar.a(MatrixTransformationFactory.INSTANCE.createSpin3dEffect());
        }
        if (booleanArray[9]) {
            aVar.a(MatrixTransformationFactory.INSTANCE.createZoomInTransition());
        }
        OverlayEffect overlayEffectCreateOverlayEffectFromBundle = createOverlayEffectFromBundle(bundle, booleanArray, context);
        if (overlayEffectCreateOverlayEffectFromBundle != null) {
            aVar.a(overlayEffectCreateOverlayEffectFromBundle);
        }
        float f10 = bundle.getFloat(SCALE_X, 1.0f);
        float f11 = bundle.getFloat(SCALE_Y, 1.0f);
        float f12 = bundle.getFloat(ROTATE_DEGREES, 0.0f);
        if (f10 != 1.0f || f11 != 1.0f || f12 != 0.0f) {
            aVar.a(new ScaleAndRotateTransformation.Builder().setScale(f10, f11).setRotationDegrees(f12).build());
        }
        int i17 = bundle.getInt(RESOLUTION_HEIGHT, -1);
        if (i17 != -1) {
            aVar.a(Presentation.createForHeight(i17));
        }
        h0 h0VarM = aVar.m();
        y.h(h0VarM, "build(...)");
        return h0VarM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GlShaderProgram createVideoEffectsFromBundle$lambda$0(Constructor constructor, Context context, boolean z10) {
        try {
            Object objNewInstance = constructor.newInstance(context, Boolean.valueOf(z10), "edge_detector_mediapipe_graph.binarypb", Boolean.TRUE, "input_video", "output_video");
            y.g(objNewInstance, "null cannot be cast to non-null type androidx.media3.effect.GlShaderProgram");
            return (GlShaderProgram) objNewInstance;
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new RuntimeException("Failed to load MediaPipeShaderProgram", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GlShaderProgram createVideoEffectsFromBundle$lambda$2(Bundle bundle, Context context, boolean z10) {
        return new PeriodicVignetteShaderProgram(context, z10, bundle.getFloat(PERIODIC_VIGNETTE_CENTER_X), bundle.getFloat(PERIODIC_VIGNETTE_CENTER_Y), bundle.getFloat(PERIODIC_VIGNETTE_INNER_RADIUS), bundle.getFloat(PERIODIC_VIGNETTE_OUTER_RADIUS), bundle.getFloat(PERIODIC_VIGNETTE_OUTER_RADIUS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] createVideoEffectsFromBundle$lambda$1(float[] fArr, long j10, boolean z10) {
        return fArr;
    }
}
