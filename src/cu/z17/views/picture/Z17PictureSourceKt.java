package cu.z17.views.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import androidx.annotation.MainThread;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import coil.compose.AsyncImageKt;
import coil.request.CachePolicy;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import coil.size.Scale;
import cu.z17.singledi.SinglediException;
import cu.z17.views.loader.Z17ShimmerLoaderKt;
import cu.z17.views.utils.Z17BasePictureHeaders;
import cu.z17.views.utils.Z17CoilDecoders;
import defpackage.r;
import j$.util.Objects;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import nf.x;
import pe.d1;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001aA\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001ac\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aQ\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aO\u0010\"\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b \u0010!\"\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/net/Uri;", "uri", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "description", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "Landroid/content/Context;", "context", "Lua/k0;", "PictureFromUri-EHKIwbg", "(Landroidx/compose/ui/Modifier;Landroid/net/Uri;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILandroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "PictureFromUri", "url", "", "placeholder", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "", "customHeaders", "PictureFromUrl-Px-5SB0", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "PictureFromUrl", "blurHash", "PictureWithBlurHash-6tVf_Uk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILjava/lang/String;Landroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "PictureWithBlurHash", "Landroid/graphics/Bitmap;", "bitmap", "PictureFromBitmap-6tVf_Uk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILandroid/graphics/Bitmap;Landroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "PictureFromBitmap", "", "Landroidx/compose/ui/graphics/Color;", "ShimmerColorShades", "Ljava/util/List;", "getShimmerColorShades", "()Ljava/util/List;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PictureSourceKt {
    private static final List<Color> ShimmerColorShades;

    static {
        Color.Companion companion = Color.INSTANCE;
        ShimmerColorShades = w.q(Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion.m5898getLightGray0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion.m5898getLightGray0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5856boximpl(Color.m5865copywmQWz5c$default(companion.m5898getLightGray0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null)));
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x0099  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea A[PHI: r4 r6 r9
      0x00ea: PHI (r4v8 androidx.compose.ui.Modifier) = (r4v4 androidx.compose.ui.Modifier), (r4v10 androidx.compose.ui.Modifier) binds: [B:86:0x00f8, B:78:0x00e9] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r6v19 int) = (r6v13 int), (r6v20 int) binds: [B:86:0x00f8, B:78:0x00e9] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r9v8 androidx.compose.ui.graphics.ColorFilter) = (r9v5 androidx.compose.ui.graphics.ColorFilter), (r9v2 androidx.compose.ui.graphics.ColorFilter) binds: [B:86:0x00f8, B:78:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x010e  */
    /* JADX WARN: Code duplicated, block: B:93:0x019d  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b1  */
    @Composable
    /* JADX INFO: renamed from: PictureFromBitmap-6tVf_Uk, reason: not valid java name */
    public static final void m10279PictureFromBitmap6tVf_Uk(Modifier modifier, ColorFilter colorFilter, final ContentScale contentScale, final String description, final int i10, final Bitmap bitmap, Context context, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        ColorFilter colorFilter2;
        int i14;
        Context context2;
        boolean z10;
        final Modifier modifier3;
        final Context context3;
        final ColorFilter colorFilter3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Context context4;
        int i15;
        int i16;
        int i17;
        int i18;
        y.i(contentScale, "contentScale");
        y.i(description, "description");
        y.i(bitmap, "bitmap");
        Composer composerStartRestartGroup = composer.startRestartGroup(954864871);
        int i19 = i12 & 1;
        if (i19 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        int i20 = i12 & 2;
        if (i20 == 0) {
            if ((i11 & 48) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 32 : 16;
            }
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(contentScale)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i13 |= i18;
            }
            if ((i11 & 3072) == 0) {
                if (composerStartRestartGroup.changed(description)) {
                    i17 = 2048;
                } else {
                    i17 = 1024;
                }
                i13 |= i17;
            }
            if ((i11 & 24576) == 0) {
                i14 = i10;
                if (composerStartRestartGroup.changed(i14)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i13 |= i16;
            } else {
                i14 = i10;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changedInstance(bitmap)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i13 |= i15;
            }
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    context2 = context;
                    int i21 = composerStartRestartGroup.changedInstance(context2) ? 1048576 : 524288;
                    i13 |= i21;
                } else {
                    context2 = context;
                }
                i13 |= i21;
            } else {
                context2 = context;
            }
            if ((599187 & i13) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i20 != 0) {
                        colorFilter2 = null;
                    }
                    if ((i12 & 64) != 0) {
                        context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i13 &= -3670017;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(954864871, i13, -1, "cu.z17.views.picture.PictureFromBitmap (Z17PictureSource.kt:204)");
                    }
                    ImageRequest.Builder builder = new ImageRequest.Builder(context4);
                    builder.data(bitmap);
                    builder.memoryCacheKey(String.valueOf(bitmap.hashCode()));
                    builder.diskCacheKey(String.valueOf(bitmap.hashCode()));
                    builder.memoryCachePolicy(CachePolicy.DISABLED);
                    builder.diskCachePolicy(CachePolicy.ENABLED);
                    builder.dispatcher(d1.b());
                    builder.interceptorDispatcher(d1.b());
                    builder.crossfade(true);
                    builder.dispatcher(d1.b());
                    builder.interceptorDispatcher(d1.b());
                    Modifier modifier5 = modifier4;
                    Context context5 = context4;
                    AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier5, null, null, null, contentScale, 0.0f, colorFilter2, i14, false, null, composerStartRestartGroup, ((i13 >> 6) & 112) | ((i13 << 9) & 7168) | ((i13 << 15) & 29360128) | ((i13 << 24) & C.ENCODING_PCM_DOUBLE), (i13 >> 12) & 14, 6512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    context3 = context5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i12 & 64) != 0) {
                        i13 &= -3670017;
                    }
                    modifier4 = modifier2;
                }
                context4 = context2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(954864871, i13, -1, "cu.z17.views.picture.PictureFromBitmap (Z17PictureSource.kt:204)");
                }
                ImageRequest.Builder builder2 = new ImageRequest.Builder(context4);
                builder2.data(bitmap);
                builder2.memoryCacheKey(String.valueOf(bitmap.hashCode()));
                builder2.diskCacheKey(String.valueOf(bitmap.hashCode()));
                builder2.memoryCachePolicy(CachePolicy.DISABLED);
                builder2.diskCachePolicy(CachePolicy.ENABLED);
                builder2.dispatcher(d1.b());
                builder2.interceptorDispatcher(d1.b());
                builder2.crossfade(true);
                builder2.dispatcher(d1.b());
                builder2.interceptorDispatcher(d1.b());
                Modifier modifier6 = modifier4;
                Context context6 = context4;
                AsyncImageKt.m9746AsyncImageQgsmV_s(builder2.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier6, null, null, null, contentScale, 0.0f, colorFilter2, i14, false, null, composerStartRestartGroup, ((i13 >> 6) & 112) | ((i13 << 9) & 7168) | ((i13 << 15) & 29360128) | ((i13 << 24) & C.ENCODING_PCM_DOUBLE), (i13 >> 12) & 14, 6512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                context3 = context6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                context3 = context2;
            }
            colorFilter3 = colorFilter2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PictureSourceKt.PictureFromBitmap_6tVf_Uk$lambda$11(modifier3, colorFilter3, contentScale, description, i10, bitmap, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 48;
        colorFilter2 = colorFilter;
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(contentScale)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i13 |= i18;
        }
        if ((i11 & 3072) == 0) {
            if (composerStartRestartGroup.changed(description)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i13 |= i17;
        }
        if ((i11 & 24576) == 0) {
            i14 = i10;
            if (composerStartRestartGroup.changed(i14)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i13 |= i16;
        } else {
            i14 = i10;
        }
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changedInstance(bitmap)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i13 |= i15;
        }
        if ((1572864 & i11) == 0) {
            if ((i12 & 64) == 0) {
                context2 = context;
                if (composerStartRestartGroup.changedInstance(context2)) {
                }
                i13 |= i21;
            } else {
                context2 = context;
            }
            i13 |= i21;
        } else {
            context2 = context;
        }
        if ((599187 & i13) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    colorFilter2 = null;
                }
                if ((i12 & 64) != 0) {
                    context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i13 &= -3670017;
                } else {
                    context4 = context2;
                }
            } else {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i20 != 0) {
                    colorFilter2 = null;
                }
                if ((i12 & 64) != 0) {
                    context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i13 &= -3670017;
                } else {
                    context4 = context2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(954864871, i13, -1, "cu.z17.views.picture.PictureFromBitmap (Z17PictureSource.kt:204)");
            }
            ImageRequest.Builder builder3 = new ImageRequest.Builder(context4);
            builder3.data(bitmap);
            builder3.memoryCacheKey(String.valueOf(bitmap.hashCode()));
            builder3.diskCacheKey(String.valueOf(bitmap.hashCode()));
            builder3.memoryCachePolicy(CachePolicy.DISABLED);
            builder3.diskCachePolicy(CachePolicy.ENABLED);
            builder3.dispatcher(d1.b());
            builder3.interceptorDispatcher(d1.b());
            builder3.crossfade(true);
            builder3.dispatcher(d1.b());
            builder3.interceptorDispatcher(d1.b());
            Modifier modifier7 = modifier4;
            Context context7 = context4;
            AsyncImageKt.m9746AsyncImageQgsmV_s(builder3.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier7, null, null, null, contentScale, 0.0f, colorFilter2, i14, false, null, composerStartRestartGroup, ((i13 >> 6) & 112) | ((i13 << 9) & 7168) | ((i13 << 15) & 29360128) | ((i13 << 24) & C.ENCODING_PCM_DOUBLE), (i13 >> 12) & 14, 6512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
            context3 = context7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            context3 = context2;
        }
        colorFilter3 = colorFilter2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PictureSourceKt.PictureFromBitmap_6tVf_Uk$lambda$11(modifier3, colorFilter3, contentScale, description, i10, bitmap, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PictureFromBitmap_6tVf_Uk$lambda$11(Modifier modifier, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Bitmap bitmap, Context context, int i11, int i12, Composer composer, int i13) {
        m10279PictureFromBitmap6tVf_Uk(modifier, colorFilter, contentScale, str, i10, bitmap, context, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    @Composable
    /* JADX INFO: renamed from: PictureFromUri-EHKIwbg, reason: not valid java name */
    public static final void m10280PictureFromUriEHKIwbg(final Modifier modifier, final Uri uri, final ContentScale contentScale, final String description, final int i10, Context context, Composer composer, final int i11, final int i12) {
        int i13;
        final Context context2;
        y.i(modifier, "modifier");
        y.i(uri, "uri");
        y.i(contentScale, "contentScale");
        y.i(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(-557860358);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(uri) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(contentScale) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(description) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            if ((i12 & 32) == 0) {
                context2 = context;
                int i14 = composerStartRestartGroup.changedInstance(context2) ? 131072 : 65536;
                i13 |= i14;
            } else {
                context2 = context;
            }
            i13 |= i14;
        } else {
            context2 = context;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i13) != 74898, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i12 & 32) != 0) {
                    i13 &= -458753;
                }
            } else if ((i12 & 32) != 0) {
                context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                i13 &= -458753;
            }
            Context context3 = context2;
            int i15 = i13;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557860358, i15, -1, "cu.z17.views.picture.PictureFromUri (Z17PictureSource.kt:43)");
            }
            ImageRequest.Builder builder = new ImageRequest.Builder(context3);
            builder.data(uri);
            builder.memoryCacheKey(uri.getPath());
            builder.diskCacheKey(uri.getPath());
            builder.memoryCachePolicy(CachePolicy.DISABLED);
            builder.diskCachePolicy(CachePolicy.ENABLED);
            builder.dispatcher(d1.b());
            builder.interceptorDispatcher(d1.b());
            builder.crossfade(true);
            builder.size(1920, 1080);
            builder.scale(Scale.FILL);
            builder.dispatcher(d1.b());
            builder.interceptorDispatcher(d1.b());
            AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier, null, null, null, contentScale, 0.0f, null, i10, false, null, composerStartRestartGroup, ((i15 >> 6) & 112) | ((i15 << 9) & 7168) | ((i15 << 15) & 29360128), (i15 >> 12) & 14, 7024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            context2 = context3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PictureSourceKt.PictureFromUri_EHKIwbg$lambda$1(modifier, uri, contentScale, description, i10, context2, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PictureFromUri_EHKIwbg$lambda$1(Modifier modifier, Uri uri, ContentScale contentScale, String str, int i10, Context context, int i11, int i12, Composer composer, int i13) {
        m10280PictureFromUriEHKIwbg(modifier, uri, contentScale, str, i10, context, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:103:0x01cc A[Catch: SinglediException -> 0x01dd, TRY_LEAVE, TryCatch #0 {SinglediException -> 0x01dd, blocks: (B:101:0x01be, B:103:0x01cc), top: B:116:0x01be }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0224  */
    /* JADX WARN: Code duplicated, block: B:111:0x022b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0236  */
    /* JADX WARN: Code duplicated, block: B:116:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:46:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x0099  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0147  */
    /* JADX WARN: Code duplicated, block: B:89:0x0154  */
    /* JADX WARN: Code duplicated, block: B:92:0x0169  */
    /* JADX WARN: Code duplicated, block: B:95:0x019d  */
    @Composable
    /* JADX INFO: renamed from: PictureFromUrl-Px-5SB0, reason: not valid java name */
    public static final void m10281PictureFromUrlPx5SB0(final Modifier modifier, final String url, final Object placeholder, ColorFilter colorFilter, final ContentScale contentScale, final String description, final int i10, Map<String, String> map, Composer composer, final int i11, final int i12) {
        int i13;
        ColorFilter colorFilter2;
        int i14;
        Map<String, String> map2;
        int i15;
        boolean z10;
        final ColorFilter colorFilter3;
        final Map<String, String> map3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ColorFilter colorFilter4;
        Map<String, String> map4;
        ImageRequest.Builder builder;
        Z17CoilDecoders instanceOrNull;
        Function1 needsHeader;
        Z17BasePictureHeaders.Companion companion;
        int i16;
        int i17;
        int i18;
        y.i(modifier, "modifier");
        y.i(url, "url");
        y.i(placeholder, "placeholder");
        y.i(contentScale, "contentScale");
        y.i(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(585219192);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(url) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(placeholder) ? 256 : 128;
        }
        int i19 = i12 & 8;
        if (i19 == 0) {
            if ((i11 & 3072) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 2048 : 1024;
            }
            if ((i11 & 24576) == 0) {
                if (composerStartRestartGroup.changed(contentScale)) {
                    i18 = 16384;
                } else {
                    i18 = 8192;
                }
                i13 |= i18;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changed(description)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i13 |= i17;
            }
            if ((1572864 & i11) != 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i13 |= i16;
            }
            i14 = i12 & 128;
            if (i14 != 0) {
                if ((12582912 & i11) == 0) {
                    map2 = map;
                    if (composerStartRestartGroup.changedInstance(map2)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i13 |= i15;
                }
                if ((4793491 & i13) != 4793490) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    if (i19 != 0) {
                        colorFilter4 = null;
                    } else {
                        colorFilter4 = colorFilter2;
                    }
                    if (i14 != 0) {
                        map4 = null;
                    } else {
                        map4 = map2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(585219192, i13, -1, "cu.z17.views.picture.PictureFromUrl (Z17PictureSource.kt:78)");
                    }
                    builder = new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                    builder.data(url);
                    builder.memoryCacheKey(url);
                    builder.diskCacheKey(url);
                    builder.memoryCachePolicy(CachePolicy.DISABLED);
                    builder.diskCachePolicy(CachePolicy.ENABLED);
                    builder.dispatcher(d1.b());
                    builder.interceptorDispatcher(d1.b());
                    builder.crossfade(true);
                    builder.size(1920, 1080);
                    builder.scale(Scale.FILL);
                    builder.listener(new ImageRequest.Listener() { // from class: cu.z17.views.picture.Z17PictureSourceKt$PictureFromUrl$1$1
                        @Override // coil.request.ImageRequest.Listener
                        @MainThread
                        public void onCancel(ImageRequest imageRequest) {
                            coil.request.a.a(this, imageRequest);
                        }

                        @Override // coil.request.ImageRequest.Listener
                        public void onError(ImageRequest request, ErrorResult result) {
                            y.i(request, "request");
                            y.i(result, "result");
                            Object data = request.getData();
                            Throwable throwable = result.getThrowable();
                            Objects.toString(data);
                            Objects.toString(throwable);
                        }

                        @Override // coil.request.ImageRequest.Listener
                        @MainThread
                        public void onStart(ImageRequest imageRequest) {
                            coil.request.a.c(this, imageRequest);
                        }

                        @Override // coil.request.ImageRequest.Listener
                        @MainThread
                        public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                            coil.request.a.d(this, imageRequest, successResult);
                        }
                    });
                    if (placeholder instanceof Drawable) {
                        Drawable drawable = (Drawable) placeholder;
                        builder.placeholder(drawable);
                        builder.error(drawable);
                    }
                    if (placeholder instanceof Integer) {
                        Number number = (Number) placeholder;
                        builder.placeholder(number.intValue());
                        builder.error(number.intValue());
                    }
                    if (placeholder instanceof Color) {
                        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
                        shapeDrawable.setIntrinsicWidth(200);
                        shapeDrawable.setIntrinsicHeight(200);
                        shapeDrawable.getPaint().setColor(Color.m5873hashCodeimpl(((Color) placeholder).m5876unboximpl()));
                        builder.placeholder(shapeDrawable);
                        builder.error(shapeDrawable);
                    }
                    instanceOrNull = Z17CoilDecoders.INSTANCE.getInstanceOrNull();
                    if (instanceOrNull != null && (needsHeader = instanceOrNull.getNeedsHeader()) != null && ((Boolean) needsHeader.invoke(url)).booleanValue()) {
                        if (map4 != null) {
                            x xVarFromMapToHeaders = Z17BasePictureHeaders.INSTANCE.fromMapToHeaders(map4);
                            y.f(xVarFromMapToHeaders);
                            builder.headers(xVarFromMapToHeaders);
                        } else {
                            try {
                                companion = Z17BasePictureHeaders.INSTANCE;
                                if (companion.getInstance().thereAreHeaders()) {
                                    x _hVar = companion.getInstance().get_h();
                                    y.f(_hVar);
                                    builder.headers(_hVar);
                                }
                            } catch (SinglediException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    int i20 = i13 << 9;
                    Map<String, String> map5 = map4;
                    AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier, null, null, null, contentScale, 0.0f, colorFilter4, i10, false, null, composerStartRestartGroup, ((i13 << 18) & C.ENCODING_PCM_DOUBLE) | ((i13 >> 12) & 112) | (i20 & 7168) | (i20 & 29360128), (i13 >> 18) & 14, 6512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter3 = colorFilter4;
                    map3 = map5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorFilter3 = colorFilter2;
                    map3 = map2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PictureSourceKt.PictureFromUrl_Px_5SB0$lambda$3(modifier, url, placeholder, colorFilter3, contentScale, description, i10, map3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 12582912;
            map2 = map;
            if ((4793491 & i13) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i19 != 0) {
                    colorFilter4 = null;
                } else {
                    colorFilter4 = colorFilter2;
                }
                if (i14 != 0) {
                    map4 = null;
                } else {
                    map4 = map2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(585219192, i13, -1, "cu.z17.views.picture.PictureFromUrl (Z17PictureSource.kt:78)");
                }
                builder = new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                builder.data(url);
                builder.memoryCacheKey(url);
                builder.diskCacheKey(url);
                builder.memoryCachePolicy(CachePolicy.DISABLED);
                builder.diskCachePolicy(CachePolicy.ENABLED);
                builder.dispatcher(d1.b());
                builder.interceptorDispatcher(d1.b());
                builder.crossfade(true);
                builder.size(1920, 1080);
                builder.scale(Scale.FILL);
                builder.listener(new ImageRequest.Listener() { // from class: cu.z17.views.picture.Z17PictureSourceKt$PictureFromUrl$1$1
                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onCancel(ImageRequest imageRequest) {
                        coil.request.a.a(this, imageRequest);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    public void onError(ImageRequest request, ErrorResult result) {
                        y.i(request, "request");
                        y.i(result, "result");
                        Object data = request.getData();
                        Throwable throwable = result.getThrowable();
                        Objects.toString(data);
                        Objects.toString(throwable);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onStart(ImageRequest imageRequest) {
                        coil.request.a.c(this, imageRequest);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                        coil.request.a.d(this, imageRequest, successResult);
                    }
                });
                if (placeholder instanceof Drawable) {
                    Drawable drawable2 = (Drawable) placeholder;
                    builder.placeholder(drawable2);
                    builder.error(drawable2);
                }
                if (placeholder instanceof Integer) {
                    Number number2 = (Number) placeholder;
                    builder.placeholder(number2.intValue());
                    builder.error(number2.intValue());
                }
                if (placeholder instanceof Color) {
                    ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
                    shapeDrawable2.setIntrinsicWidth(200);
                    shapeDrawable2.setIntrinsicHeight(200);
                    shapeDrawable2.getPaint().setColor(Color.m5873hashCodeimpl(((Color) placeholder).m5876unboximpl()));
                    builder.placeholder(shapeDrawable2);
                    builder.error(shapeDrawable2);
                }
                instanceOrNull = Z17CoilDecoders.INSTANCE.getInstanceOrNull();
                if (instanceOrNull != null) {
                    if (map4 != null) {
                        x xVarFromMapToHeaders2 = Z17BasePictureHeaders.INSTANCE.fromMapToHeaders(map4);
                        y.f(xVarFromMapToHeaders2);
                        builder.headers(xVarFromMapToHeaders2);
                    } else {
                        companion = Z17BasePictureHeaders.INSTANCE;
                        if (companion.getInstance().thereAreHeaders()) {
                            x _hVar2 = companion.getInstance().get_h();
                            y.f(_hVar2);
                            builder.headers(_hVar2);
                        }
                    }
                }
                int i21 = i13 << 9;
                Map<String, String> map6 = map4;
                AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier, null, null, null, contentScale, 0.0f, colorFilter4, i10, false, null, composerStartRestartGroup, ((i13 << 18) & C.ENCODING_PCM_DOUBLE) | ((i13 >> 12) & 112) | (i21 & 7168) | (i21 & 29360128), (i13 >> 18) & 14, 6512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter3 = colorFilter4;
                map3 = map6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                map3 = map2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PictureSourceKt.PictureFromUrl_Px_5SB0$lambda$3(modifier, url, placeholder, colorFilter3, contentScale, description, i10, map3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        colorFilter2 = colorFilter;
        if ((i11 & 24576) == 0) {
            if (composerStartRestartGroup.changed(contentScale)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i13 |= i18;
        }
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changed(description)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i13 |= i17;
        }
        if ((1572864 & i11) != 0) {
            if (composerStartRestartGroup.changed(i10)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i13 |= i16;
        }
        i14 = i12 & 128;
        if (i14 != 0) {
            if ((12582912 & i11) == 0) {
                map2 = map;
                if (composerStartRestartGroup.changedInstance(map2)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i13 |= i15;
            }
            if ((4793491 & i13) != 4793490) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                if (i19 != 0) {
                    colorFilter4 = null;
                } else {
                    colorFilter4 = colorFilter2;
                }
                if (i14 != 0) {
                    map4 = null;
                } else {
                    map4 = map2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(585219192, i13, -1, "cu.z17.views.picture.PictureFromUrl (Z17PictureSource.kt:78)");
                }
                builder = new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                builder.data(url);
                builder.memoryCacheKey(url);
                builder.diskCacheKey(url);
                builder.memoryCachePolicy(CachePolicy.DISABLED);
                builder.diskCachePolicy(CachePolicy.ENABLED);
                builder.dispatcher(d1.b());
                builder.interceptorDispatcher(d1.b());
                builder.crossfade(true);
                builder.size(1920, 1080);
                builder.scale(Scale.FILL);
                builder.listener(new ImageRequest.Listener() { // from class: cu.z17.views.picture.Z17PictureSourceKt$PictureFromUrl$1$1
                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onCancel(ImageRequest imageRequest) {
                        coil.request.a.a(this, imageRequest);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    public void onError(ImageRequest request, ErrorResult result) {
                        y.i(request, "request");
                        y.i(result, "result");
                        Object data = request.getData();
                        Throwable throwable = result.getThrowable();
                        Objects.toString(data);
                        Objects.toString(throwable);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onStart(ImageRequest imageRequest) {
                        coil.request.a.c(this, imageRequest);
                    }

                    @Override // coil.request.ImageRequest.Listener
                    @MainThread
                    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                        coil.request.a.d(this, imageRequest, successResult);
                    }
                });
                if (placeholder instanceof Drawable) {
                    Drawable drawable3 = (Drawable) placeholder;
                    builder.placeholder(drawable3);
                    builder.error(drawable3);
                }
                if (placeholder instanceof Integer) {
                    Number number3 = (Number) placeholder;
                    builder.placeholder(number3.intValue());
                    builder.error(number3.intValue());
                }
                if (placeholder instanceof Color) {
                    ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RectShape());
                    shapeDrawable3.setIntrinsicWidth(200);
                    shapeDrawable3.setIntrinsicHeight(200);
                    shapeDrawable3.getPaint().setColor(Color.m5873hashCodeimpl(((Color) placeholder).m5876unboximpl()));
                    builder.placeholder(shapeDrawable3);
                    builder.error(shapeDrawable3);
                }
                instanceOrNull = Z17CoilDecoders.INSTANCE.getInstanceOrNull();
                if (instanceOrNull != null) {
                    if (map4 != null) {
                        x xVarFromMapToHeaders3 = Z17BasePictureHeaders.INSTANCE.fromMapToHeaders(map4);
                        y.f(xVarFromMapToHeaders3);
                        builder.headers(xVarFromMapToHeaders3);
                    } else {
                        companion = Z17BasePictureHeaders.INSTANCE;
                        if (companion.getInstance().thereAreHeaders()) {
                            x _hVar3 = companion.getInstance().get_h();
                            y.f(_hVar3);
                            builder.headers(_hVar3);
                        }
                    }
                }
                int i22 = i13 << 9;
                Map<String, String> map7 = map4;
                AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier, null, null, null, contentScale, 0.0f, colorFilter4, i10, false, null, composerStartRestartGroup, ((i13 << 18) & C.ENCODING_PCM_DOUBLE) | ((i13 >> 12) & 112) | (i22 & 7168) | (i22 & 29360128), (i13 >> 18) & 14, 6512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter3 = colorFilter4;
                map3 = map7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                colorFilter3 = colorFilter2;
                map3 = map2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PictureSourceKt.PictureFromUrl_Px_5SB0$lambda$3(modifier, url, placeholder, colorFilter3, contentScale, description, i10, map3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 12582912;
        map2 = map;
        if ((4793491 & i13) != 4793490) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            if (i19 != 0) {
                colorFilter4 = null;
            } else {
                colorFilter4 = colorFilter2;
            }
            if (i14 != 0) {
                map4 = null;
            } else {
                map4 = map2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585219192, i13, -1, "cu.z17.views.picture.PictureFromUrl (Z17PictureSource.kt:78)");
            }
            builder = new ImageRequest.Builder((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
            builder.data(url);
            builder.memoryCacheKey(url);
            builder.diskCacheKey(url);
            builder.memoryCachePolicy(CachePolicy.DISABLED);
            builder.diskCachePolicy(CachePolicy.ENABLED);
            builder.dispatcher(d1.b());
            builder.interceptorDispatcher(d1.b());
            builder.crossfade(true);
            builder.size(1920, 1080);
            builder.scale(Scale.FILL);
            builder.listener(new ImageRequest.Listener() { // from class: cu.z17.views.picture.Z17PictureSourceKt$PictureFromUrl$1$1
                @Override // coil.request.ImageRequest.Listener
                @MainThread
                public void onCancel(ImageRequest imageRequest) {
                    coil.request.a.a(this, imageRequest);
                }

                @Override // coil.request.ImageRequest.Listener
                public void onError(ImageRequest request, ErrorResult result) {
                    y.i(request, "request");
                    y.i(result, "result");
                    Object data = request.getData();
                    Throwable throwable = result.getThrowable();
                    Objects.toString(data);
                    Objects.toString(throwable);
                }

                @Override // coil.request.ImageRequest.Listener
                @MainThread
                public void onStart(ImageRequest imageRequest) {
                    coil.request.a.c(this, imageRequest);
                }

                @Override // coil.request.ImageRequest.Listener
                @MainThread
                public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                    coil.request.a.d(this, imageRequest, successResult);
                }
            });
            if (placeholder instanceof Drawable) {
                Drawable drawable4 = (Drawable) placeholder;
                builder.placeholder(drawable4);
                builder.error(drawable4);
            }
            if (placeholder instanceof Integer) {
                Number number4 = (Number) placeholder;
                builder.placeholder(number4.intValue());
                builder.error(number4.intValue());
            }
            if (placeholder instanceof Color) {
                ShapeDrawable shapeDrawable4 = new ShapeDrawable(new RectShape());
                shapeDrawable4.setIntrinsicWidth(200);
                shapeDrawable4.setIntrinsicHeight(200);
                shapeDrawable4.getPaint().setColor(Color.m5873hashCodeimpl(((Color) placeholder).m5876unboximpl()));
                builder.placeholder(shapeDrawable4);
                builder.error(shapeDrawable4);
            }
            instanceOrNull = Z17CoilDecoders.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                if (map4 != null) {
                    x xVarFromMapToHeaders4 = Z17BasePictureHeaders.INSTANCE.fromMapToHeaders(map4);
                    y.f(xVarFromMapToHeaders4);
                    builder.headers(xVarFromMapToHeaders4);
                } else {
                    companion = Z17BasePictureHeaders.INSTANCE;
                    if (companion.getInstance().thereAreHeaders()) {
                        x _hVar4 = companion.getInstance().get_h();
                        y.f(_hVar4);
                        builder.headers(_hVar4);
                    }
                }
            }
            int i23 = i13 << 9;
            Map<String, String> map8 = map4;
            AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), description, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier, null, null, null, contentScale, 0.0f, colorFilter4, i10, false, null, composerStartRestartGroup, ((i13 << 18) & C.ENCODING_PCM_DOUBLE) | ((i13 >> 12) & 112) | (i23 & 7168) | (i23 & 29360128), (i13 >> 18) & 14, 6512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorFilter3 = colorFilter4;
            map3 = map8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            colorFilter3 = colorFilter2;
            map3 = map2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PictureSourceKt.PictureFromUrl_Px_5SB0$lambda$3(modifier, url, placeholder, colorFilter3, contentScale, description, i10, map3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PictureFromUrl_Px_5SB0$lambda$3(Modifier modifier, String str, Object obj, ColorFilter colorFilter, ContentScale contentScale, String str2, int i10, Map map, int i11, int i12, Composer composer, int i13) {
        m10281PictureFromUrlPx5SB0(modifier, str, obj, colorFilter, contentScale, str2, i10, map, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0143  */
    /* JADX WARN: Code duplicated, block: B:104:0x0153  */
    /* JADX WARN: Code duplicated, block: B:106:0x017f  */
    /* JADX WARN: Code duplicated, block: B:109:0x018b  */
    /* JADX WARN: Code duplicated, block: B:110:0x018f  */
    /* JADX WARN: Code duplicated, block: B:113:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:119:0x0202  */
    /* JADX WARN: Code duplicated, block: B:120:0x0217  */
    /* JADX WARN: Code duplicated, block: B:124:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:125:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:128:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:132:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:135:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:138:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:141:0x0305  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x010b  */
    /* JADX WARN: Code duplicated, block: B:90:0x010e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0111  */
    /* JADX WARN: Code duplicated, block: B:94:0x0116  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126  */
    /* JADX WARN: Code duplicated, block: B:98:0x0131  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: PictureWithBlurHash-6tVf_Uk, reason: not valid java name */
    public static final void m10282PictureWithBlurHash6tVf_Uk(Modifier modifier, ColorFilter colorFilter, final ContentScale contentScale, String str, final int i10, String blurHash, Context context, Composer composer, final int i11, final int i12) {
        int i13;
        ColorFilter colorFilter2;
        int i14;
        String str2;
        int i15;
        Context context2;
        int i16;
        boolean z10;
        final String str3;
        final Modifier modifier2;
        final String str4;
        final Context context3;
        final ColorFilter colorFilter3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        String str5;
        String str6;
        Context context4;
        int i17;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Bitmap bitmap;
        boolean z11;
        MutableState mutableState2;
        boolean z12;
        boolean z13;
        Object objRememberedValue2;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int i18;
        int i19;
        int i20;
        y.i(contentScale, "contentScale");
        y.i(blurHash, "blurHash");
        Composer composerStartRestartGroup = composer.startRestartGroup(-723213949);
        int i21 = i12 & 1;
        if (i21 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i22 = i12 & 2;
        if (i22 == 0) {
            if ((i11 & 48) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 32 : 16;
            }
            if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if (composerStartRestartGroup.changed(contentScale)) {
                    i20 = 256;
                } else {
                    i20 = 128;
                }
                i13 |= i20;
            }
            i14 = i12 & 8;
            if (i14 != 0) {
                if ((i11 & 3072) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i13 |= i15;
                }
                if ((i11 & 24576) != 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i19 = 16384;
                    } else {
                        i19 = 8192;
                    }
                    i13 |= i19;
                }
                if ((196608 & i11) == 0) {
                    if (composerStartRestartGroup.changed(blurHash)) {
                        i18 = 131072;
                    } else {
                        i18 = 65536;
                    }
                    i13 |= i18;
                }
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        context2 = context;
                        int i23 = composerStartRestartGroup.changedInstance(context2) ? 1048576 : 524288;
                        i13 |= i23;
                    } else {
                        context2 = context;
                    }
                    i13 |= i23;
                } else {
                    context2 = context;
                }
                i16 = i13;
                if ((i13 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i22 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            str5 = "";
                        } else {
                            str5 = str2;
                        }
                        if ((i12 & 64) != 0) {
                            str6 = str5;
                            context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            i17 = i16 & (-3670017);
                        } else {
                            str6 = str5;
                            context4 = context2;
                            i17 = i16;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i12 & 64) != 0) {
                            i17 = i16 & (-3670017);
                            str6 = str2;
                            context4 = context2;
                            modifier3 = modifier;
                        } else {
                            modifier3 = modifier;
                            str6 = str2;
                            context4 = context2;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-723213949, i17, -1, "cu.z17.views.picture.PictureWithBlurHash (Z17PictureSource.kt:150)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    if (mutableState.getValue() == null) {
                        composerStartRestartGroup.startReplaceGroup(-1710415350);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState2 = mutableState;
                        context4 = context4;
                        i17 = i17;
                        z11 = false;
                        z12 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1710202442);
                        bitmap = (Bitmap) mutableState.getValue();
                        if (bitmap == null) {
                            composerStartRestartGroup.startReplaceGroup(-1710179565);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableState2 = mutableState;
                            z11 = false;
                            z12 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1710179564);
                            ImageRequest.Builder builder = new ImageRequest.Builder(context4);
                            builder.data(bitmap);
                            builder.memoryCacheKey(blurHash);
                            builder.diskCacheKey(blurHash);
                            builder.memoryCachePolicy(CachePolicy.DISABLED);
                            builder.diskCachePolicy(CachePolicy.ENABLED);
                            builder.dispatcher(d1.b());
                            builder.interceptorDispatcher(d1.b());
                            builder.crossfade(true);
                            builder.size(1920, 1080);
                            builder.scale(Scale.FILL);
                            builder.dispatcher(d1.b()).interceptorDispatcher(d1.b());
                            z11 = false;
                            mutableState2 = mutableState;
                            z12 = true;
                            AsyncImageKt.m9746AsyncImageQgsmV_s(builder.build(), str6, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier3, null, null, null, contentScale, 0.0f, colorFilter2, i10, false, null, composerStartRestartGroup, ((i17 << 9) & 7168) | ((i17 >> 6) & 112) | ((i17 << 15) & 29360128) | ((i17 << 24) & C.ENCODING_PCM_DOUBLE), (i17 >> 12) & 14, 6512);
                            composerStartRestartGroup.endReplaceGroup();
                            k0 k0Var = k0.f43947a;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    k0 k0Var2 = k0.f43947a;
                    if ((i17 & 458752) == 131072) {
                        z13 = z12;
                    } else {
                        z13 = z11;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z13 || objRememberedValue2 == companion.getEmpty()) {
                        str3 = blurHash;
                        objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        str3 = blurHash;
                    }
                    EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str6;
                    modifier2 = modifier3;
                    context3 = context4;
                } else {
                    str3 = blurHash;
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    str4 = str2;
                    context3 = context2;
                }
                colorFilter3 = colorFilter2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17PictureSourceKt.PictureWithBlurHash_6tVf_Uk$lambda$9(modifier2, colorFilter3, contentScale, str4, i10, str3, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            str2 = str;
            if ((i11 & 24576) != 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i19 = 16384;
                } else {
                    i19 = 8192;
                }
                i13 |= i19;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changed(blurHash)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i13 |= i18;
            }
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    context2 = context;
                    if (composerStartRestartGroup.changedInstance(context2)) {
                    }
                    i13 |= i23;
                } else {
                    context2 = context;
                }
                i13 |= i23;
            } else {
                context2 = context;
            }
            i16 = i13;
            if ((i13 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i22 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        str5 = "";
                    } else {
                        str5 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        str6 = str5;
                        context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 = i16 & (-3670017);
                    } else {
                        str6 = str5;
                        context4 = context2;
                        i17 = i16;
                    }
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i22 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        str5 = "";
                    } else {
                        str5 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        str6 = str5;
                        context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 = i16 & (-3670017);
                    } else {
                        str6 = str5;
                        context4 = context2;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-723213949, i17, -1, "cu.z17.views.picture.PictureWithBlurHash (Z17PictureSource.kt:150)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                if (mutableState.getValue() == null) {
                    composerStartRestartGroup.startReplaceGroup(-1710415350);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    constructor = companion3.getConstructor();
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
                    Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState;
                    context4 = context4;
                    i17 = i17;
                    z11 = false;
                    z12 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1710202442);
                    bitmap = (Bitmap) mutableState.getValue();
                    if (bitmap == null) {
                        composerStartRestartGroup.startReplaceGroup(-1710179565);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState2 = mutableState;
                        z11 = false;
                        z12 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1710179564);
                        ImageRequest.Builder builder2 = new ImageRequest.Builder(context4);
                        builder2.data(bitmap);
                        builder2.memoryCacheKey(blurHash);
                        builder2.diskCacheKey(blurHash);
                        builder2.memoryCachePolicy(CachePolicy.DISABLED);
                        builder2.diskCachePolicy(CachePolicy.ENABLED);
                        builder2.dispatcher(d1.b());
                        builder2.interceptorDispatcher(d1.b());
                        builder2.crossfade(true);
                        builder2.size(1920, 1080);
                        builder2.scale(Scale.FILL);
                        builder2.dispatcher(d1.b()).interceptorDispatcher(d1.b());
                        z11 = false;
                        mutableState2 = mutableState;
                        z12 = true;
                        AsyncImageKt.m9746AsyncImageQgsmV_s(builder2.build(), str6, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier3, null, null, null, contentScale, 0.0f, colorFilter2, i10, false, null, composerStartRestartGroup, ((i17 << 9) & 7168) | ((i17 >> 6) & 112) | ((i17 << 15) & 29360128) | ((i17 << 24) & C.ENCODING_PCM_DOUBLE), (i17 >> 12) & 14, 6512);
                        composerStartRestartGroup.endReplaceGroup();
                        k0 k0Var3 = k0.f43947a;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                k0 k0Var4 = k0.f43947a;
                if ((i17 & 458752) == 131072) {
                    z13 = z12;
                } else {
                    z13 = z11;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    str3 = blurHash;
                    objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    str3 = blurHash;
                    objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(k0Var4, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str6;
                modifier2 = modifier3;
                context3 = context4;
            } else {
                str3 = blurHash;
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                str4 = str2;
                context3 = context2;
            }
            colorFilter3 = colorFilter2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PictureSourceKt.PictureWithBlurHash_6tVf_Uk$lambda$9(modifier2, colorFilter3, contentScale, str4, i10, str3, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 48;
        colorFilter2 = colorFilter;
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if (composerStartRestartGroup.changed(contentScale)) {
                i20 = 256;
            } else {
                i20 = 128;
            }
            i13 |= i20;
        }
        i14 = i12 & 8;
        if (i14 != 0) {
            if ((i11 & 3072) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i13 |= i15;
            }
            if ((i11 & 24576) != 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i19 = 16384;
                } else {
                    i19 = 8192;
                }
                i13 |= i19;
            }
            if ((196608 & i11) == 0) {
                if (composerStartRestartGroup.changed(blurHash)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i13 |= i18;
            }
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    context2 = context;
                    if (composerStartRestartGroup.changedInstance(context2)) {
                    }
                    i13 |= i23;
                } else {
                    context2 = context;
                }
                i13 |= i23;
            } else {
                context2 = context;
            }
            i16 = i13;
            if ((i13 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if (i21 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i22 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        str5 = "";
                    } else {
                        str5 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        str6 = str5;
                        context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 = i16 & (-3670017);
                    } else {
                        str6 = str5;
                        context4 = context2;
                        i17 = i16;
                    }
                } else {
                    if (i21 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i22 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        str5 = "";
                    } else {
                        str5 = str2;
                    }
                    if ((i12 & 64) != 0) {
                        str6 = str5;
                        context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        i17 = i16 & (-3670017);
                    } else {
                        str6 = str5;
                        context4 = context2;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-723213949, i17, -1, "cu.z17.views.picture.PictureWithBlurHash (Z17PictureSource.kt:150)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                if (mutableState.getValue() == null) {
                    composerStartRestartGroup.startReplaceGroup(-1710415350);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState;
                    context4 = context4;
                    i17 = i17;
                    z11 = false;
                    z12 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1710202442);
                    bitmap = (Bitmap) mutableState.getValue();
                    if (bitmap == null) {
                        composerStartRestartGroup.startReplaceGroup(-1710179565);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState2 = mutableState;
                        z11 = false;
                        z12 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1710179564);
                        ImageRequest.Builder builder3 = new ImageRequest.Builder(context4);
                        builder3.data(bitmap);
                        builder3.memoryCacheKey(blurHash);
                        builder3.diskCacheKey(blurHash);
                        builder3.memoryCachePolicy(CachePolicy.DISABLED);
                        builder3.diskCachePolicy(CachePolicy.ENABLED);
                        builder3.dispatcher(d1.b());
                        builder3.interceptorDispatcher(d1.b());
                        builder3.crossfade(true);
                        builder3.size(1920, 1080);
                        builder3.scale(Scale.FILL);
                        builder3.dispatcher(d1.b()).interceptorDispatcher(d1.b());
                        z11 = false;
                        mutableState2 = mutableState;
                        z12 = true;
                        AsyncImageKt.m9746AsyncImageQgsmV_s(builder3.build(), str6, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier3, null, null, null, contentScale, 0.0f, colorFilter2, i10, false, null, composerStartRestartGroup, ((i17 << 9) & 7168) | ((i17 >> 6) & 112) | ((i17 << 15) & 29360128) | ((i17 << 24) & C.ENCODING_PCM_DOUBLE), (i17 >> 12) & 14, 6512);
                        composerStartRestartGroup.endReplaceGroup();
                        k0 k0Var5 = k0.f43947a;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                k0 k0Var6 = k0.f43947a;
                if ((i17 & 458752) == 131072) {
                    z13 = z12;
                } else {
                    z13 = z11;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    str3 = blurHash;
                    objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    str3 = blurHash;
                    objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(k0Var6, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str6;
                modifier2 = modifier3;
                context3 = context4;
            } else {
                str3 = blurHash;
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                str4 = str2;
                context3 = context2;
            }
            colorFilter3 = colorFilter2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17PictureSourceKt.PictureWithBlurHash_6tVf_Uk$lambda$9(modifier2, colorFilter3, contentScale, str4, i10, str3, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        str2 = str;
        if ((i11 & 24576) != 0) {
            if (composerStartRestartGroup.changed(i10)) {
                i19 = 16384;
            } else {
                i19 = 8192;
            }
            i13 |= i19;
        }
        if ((196608 & i11) == 0) {
            if (composerStartRestartGroup.changed(blurHash)) {
                i18 = 131072;
            } else {
                i18 = 65536;
            }
            i13 |= i18;
        }
        if ((1572864 & i11) == 0) {
            if ((i12 & 64) == 0) {
                context2 = context;
                if (composerStartRestartGroup.changedInstance(context2)) {
                }
                i13 |= i23;
            } else {
                context2 = context;
            }
            i13 |= i23;
        } else {
            context2 = context;
        }
        i16 = i13;
        if ((i13 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i16 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if (i21 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i22 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                if ((i12 & 64) != 0) {
                    str6 = str5;
                    context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i17 = i16 & (-3670017);
                } else {
                    str6 = str5;
                    context4 = context2;
                    i17 = i16;
                }
            } else {
                if (i21 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i22 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                if ((i12 & 64) != 0) {
                    str6 = str5;
                    context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    i17 = i16 & (-3670017);
                } else {
                    str6 = str5;
                    context4 = context2;
                    i17 = i16;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723213949, i17, -1, "cu.z17.views.picture.PictureWithBlurHash (Z17PictureSource.kt:150)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            if (mutableState.getValue() == null) {
                composerStartRestartGroup.startReplaceGroup(-1710415350);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                Z17ShimmerLoaderKt.Z17Shimmer(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                mutableState2 = mutableState;
                context4 = context4;
                i17 = i17;
                z11 = false;
                z12 = true;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1710202442);
                bitmap = (Bitmap) mutableState.getValue();
                if (bitmap == null) {
                    composerStartRestartGroup.startReplaceGroup(-1710179565);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState;
                    z11 = false;
                    z12 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1710179564);
                    ImageRequest.Builder builder4 = new ImageRequest.Builder(context4);
                    builder4.data(bitmap);
                    builder4.memoryCacheKey(blurHash);
                    builder4.diskCacheKey(blurHash);
                    builder4.memoryCachePolicy(CachePolicy.DISABLED);
                    builder4.diskCachePolicy(CachePolicy.ENABLED);
                    builder4.dispatcher(d1.b());
                    builder4.interceptorDispatcher(d1.b());
                    builder4.crossfade(true);
                    builder4.size(1920, 1080);
                    builder4.scale(Scale.FILL);
                    builder4.dispatcher(d1.b()).interceptorDispatcher(d1.b());
                    z11 = false;
                    mutableState2 = mutableState;
                    z12 = true;
                    AsyncImageKt.m9746AsyncImageQgsmV_s(builder4.build(), str6, Z17CoilDecoders.INSTANCE.getInstance().getImageLoader(), modifier3, null, null, null, contentScale, 0.0f, colorFilter2, i10, false, null, composerStartRestartGroup, ((i17 << 9) & 7168) | ((i17 >> 6) & 112) | ((i17 << 15) & 29360128) | ((i17 << 24) & C.ENCODING_PCM_DOUBLE), (i17 >> 12) & 14, 6512);
                    composerStartRestartGroup.endReplaceGroup();
                    k0 k0Var7 = k0.f43947a;
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            k0 k0Var8 = k0.f43947a;
            if ((i17 & 458752) == 131072) {
                z13 = z12;
            } else {
                z13 = z11;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13) {
                str3 = blurHash;
                objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                str3 = blurHash;
                objRememberedValue2 = new Z17PictureSourceKt$PictureWithBlurHash$3$1(mutableState2, str3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var8, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str6;
            modifier2 = modifier3;
            context3 = context4;
        } else {
            str3 = blurHash;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            str4 = str2;
            context3 = context2;
        }
        colorFilter3 = colorFilter2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17PictureSourceKt.PictureWithBlurHash_6tVf_Uk$lambda$9(modifier2, colorFilter3, contentScale, str4, i10, str3, context3, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PictureWithBlurHash_6tVf_Uk$lambda$9(Modifier modifier, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, String str2, Context context, int i11, int i12, Composer composer, int i13) {
        m10282PictureWithBlurHash6tVf_Uk(modifier, colorFilter, contentScale, str, i10, str2, context, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    public static final List<Color> getShimmerColorShades() {
        return ShimmerColorShades;
    }
}
