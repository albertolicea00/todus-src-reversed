package cu.z17.views.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.MainThread;
import androidx.compose.runtime.internal.StabilityInferred;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaders;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.p012decode.GifDecoder;
import coil.p012decode.ImageDecoderDecoder;
import coil.p012decode.VideoFrameDecoder;
import coil.request.CachePolicy;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Scale;
import cu.z17.singledi.SinglediException;
import cu.z17.singledi.SingletonInitializer;
import j$.util.Objects;
import java.io.File;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import nf.c0;
import nf.x;
import pe.d1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\t2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcu/z17/views/utils/Z17CoilDecoders;", "", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "trustFactor", "Lkotlin/Function1;", "", "", "needsHeader", "<init>", "(Landroid/content/Context;Lkotlin/Pair;Lkotlin/jvm/functions/Function1;)V", "url", "Lua/k0;", "clearCacheFor", "(Ljava/lang/String;)V", "", "customHeaders", "Landroid/graphics/Bitmap;", "getInCache", "(Ljava/lang/String;Ljava/util/Map;)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "Lkotlin/Pair;", "Lkotlin/jvm/functions/Function1;", "getNeedsHeader", "()Lkotlin/jvm/functions/Function1;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/ImageLoader;", "getImageLoader", "()Lcoil/ImageLoader;", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17CoilDecoders {
    private final Context context;
    private final ImageLoader imageLoader;
    private final Function1 needsHeader;
    private final Pair<SSLSocketFactory, X509TrustManager> trustFactor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/z17/views/utils/Z17CoilDecoders$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/utils/Z17CoilDecoders;", "<init>", "()V", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<Z17CoilDecoders> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Z17CoilDecoders(Context context, Pair<? extends SSLSocketFactory, ? extends X509TrustManager> pair, Function1 needsHeader) {
        y.i(context, "context");
        y.i(needsHeader, "needsHeader");
        this.context = context;
        this.trustFactor = pair;
        this.needsHeader = needsHeader;
        ImageLoader.Builder builderFetcherDispatcher = new ImageLoader.Builder(context).decoderDispatcher(d1.b()).fetcherDispatcher(d1.b());
        CachePolicy cachePolicy = CachePolicy.ENABLED;
        ImageLoader.Builder builderDiskCache = builderFetcherDispatcher.memoryCachePolicy(cachePolicy).diskCachePolicy(cachePolicy).memoryCache(new lb.a() { // from class: cu.z17.views.utils.e
            @Override // lb.a
            public final Object invoke() {
                return Z17CoilDecoders.imageLoader$lambda$1(this.f30097c);
            }
        }).diskCache(new lb.a() { // from class: cu.z17.views.utils.f
            @Override // lb.a
            public final Object invoke() {
                return Z17CoilDecoders.imageLoader$lambda$2(this.f30098c);
            }
        });
        int i10 = 1;
        ImageLoader.Builder builderCrossfade = builderDiskCache.crossfade(true);
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
        kotlin.jvm.internal.p pVar = null;
        boolean z10 = false;
        if (Build.VERSION.SDK_INT >= 28) {
            builder.add(new ImageDecoderDecoder.Factory(z10, i10, pVar));
        } else {
            builder.add(new GifDecoder.Factory(z10, i10, pVar));
        }
        builder.add(new VideoFrameDecoder.Factory());
        k0 k0Var = k0.f43947a;
        this.imageLoader = builderCrossfade.components(builder.build()).okHttpClient(new lb.a() { // from class: cu.z17.views.utils.g
            @Override // lb.a
            public final Object invoke() {
                return Z17CoilDecoders.imageLoader$lambda$7(this.f30099c);
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(String it) {
        y.i(it, "it");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bitmap getInCache$default(Z17CoilDecoders z17CoilDecoders, String str, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = null;
        }
        return z17CoilDecoders.getInCache(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemoryCache imageLoader$lambda$1(Z17CoilDecoders z17CoilDecoders) {
        return new MemoryCache.Builder(z17CoilDecoders.context).maxSizePercent(1.0d).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiskCache imageLoader$lambda$2(Z17CoilDecoders z17CoilDecoders) {
        return new DiskCache.Builder().directory(new File(z17CoilDecoders.context.getCacheDir().getPath(), "cache")).maxSizePercent(1.0d).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c0 imageLoader$lambda$7(Z17CoilDecoders z17CoilDecoders) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pair = z17CoilDecoders.trustFactor;
        if (pair != null) {
            aVarA.Q(pair.getFirst(), pair.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.z17.views.utils.i
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return Z17CoilDecoders.imageLoader$lambda$7$lambda$6$lambda$5$lambda$4(str, sSLSession);
                }
            });
        }
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean imageLoader$lambda$7$lambda$6$lambda$5$lambda$4(String str, SSLSession sSLSession) {
        return true;
    }

    public final void clearCacheFor(String url) {
        y.i(url, "url");
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        if (memoryCache != null) {
            memoryCache.remove(new MemoryCache.Key(url, null, 2, null));
        }
        DiskCache diskCache = this.imageLoader.getDiskCache();
        if (diskCache != null) {
            diskCache.remove(url);
        }
    }

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final Bitmap getInCache(String url, Map<String, String> customHeaders) {
        y.i(url, "url");
        ImageRequest.Builder builder = new ImageRequest.Builder(this.context);
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
        builder.listener(new ImageRequest.Listener() { // from class: cu.z17.views.utils.Z17CoilDecoders$getInCache$imageRequest$1$1
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
        if (((Boolean) this.needsHeader.invoke(url)).booleanValue()) {
            if (customHeaders != null) {
                x xVarFromMapToHeaders = Z17BasePictureHeaders.INSTANCE.fromMapToHeaders(customHeaders);
                y.f(xVarFromMapToHeaders);
                builder.headers(xVarFromMapToHeaders);
            } else {
                try {
                    Z17BasePictureHeaders.Companion companion = Z17BasePictureHeaders.INSTANCE;
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
        ImageRequest imageRequestBuild = builder.build();
        Z17CoilDecoders instanceOrNull = INSTANCE.getInstanceOrNull();
        ImageLoader imageLoader = instanceOrNull != null ? instanceOrNull.imageLoader : null;
        if (imageLoader == null) {
            return null;
        }
        try {
            ImageResult imageResultExecuteBlocking = ImageLoaders.executeBlocking(imageLoader, imageRequestBuild);
            y.g(imageResultExecuteBlocking, "null cannot be cast to non-null type coil.request.SuccessResult");
            Drawable drawable = ((SuccessResult) imageResultExecuteBlocking).getDrawable();
            y.g(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            return ((BitmapDrawable) drawable).getBitmap();
        } catch (Exception unused) {
            return null;
        }
    }

    public final Function1 getNeedsHeader() {
        return this.needsHeader;
    }

    public /* synthetic */ Z17CoilDecoders(Context context, Pair pair, Function1 function1, int i10, kotlin.jvm.internal.p pVar) {
        this(context, (i10 & 2) != 0 ? null : pair, (i10 & 4) != 0 ? new Function1() { // from class: cu.z17.views.utils.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Z17CoilDecoders._init_$lambda$0((String) obj));
            }
        } : function1);
    }
}
