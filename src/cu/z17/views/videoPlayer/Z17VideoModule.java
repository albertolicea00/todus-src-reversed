package cu.z17.views.videoPlayer;

import android.content.Context;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.NoOpCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.upstream.experimental.ExperimentalBandwidthMeter;
import cu.z17.singledi.SingletonInitializer;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import le.a0;
import pe.d1;
import pe.m0;
import pe.n0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0*j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcu/z17/views/videoPlayer/Z17VideoModule;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "identifier", "getFolderId", "(Ljava/lang/String;)Ljava/lang/String;", "Landroidx/media3/datasource/cache/SimpleCache;", "getCacheDirectory", "(Ljava/lang/String;)Landroidx/media3/datasource/cache/SimpleCache;", "Lua/k0;", "clearFromRAMCache", "(Ljava/lang/String;)V", "deleteDISKCache", "Landroid/content/Context;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "", "initialBitrate", "J", "getInitialBitrate", "()J", "setInitialBitrate", "(J)V", "Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;", "bandwidthMeter", "Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;", "getBandwidthMeter", "()Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;", "Ljava/io/File;", "downloadContentDirectory", "Ljava/io/File;", "Landroidx/media3/database/StandaloneDatabaseProvider;", "standaloneDatabaseProvider", "Landroidx/media3/database/StandaloneDatabaseProvider;", "Landroidx/media3/datasource/cache/NoOpCacheEvictor;", "noOpCacheEvictor", "Landroidx/media3/datasource/cache/NoOpCacheEvictor;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cacheDB", "Ljava/util/HashMap;", "Landroidx/media3/exoplayer/DefaultRenderersFactory;", "rendererFactory", "Landroidx/media3/exoplayer/DefaultRenderersFactory;", "getRendererFactory", "()Landroidx/media3/exoplayer/DefaultRenderersFactory;", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17VideoModule {
    private static final String DOWNLOAD_CONTENT_DIRECTORY = "stream_videos_cache";

    @UnstableApi
    private final ExperimentalBandwidthMeter bandwidthMeter;
    private final HashMap<String, SimpleCache> cacheDB;
    private final Context context;
    private final m0 coroutineScope;
    private final File downloadContentDirectory;
    private long initialBitrate;

    @UnstableApi
    private final NoOpCacheEvictor noOpCacheEvictor;

    @UnstableApi
    private final DefaultRenderersFactory rendererFactory;

    @UnstableApi
    private final StandaloneDatabaseProvider standaloneDatabaseProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcu/z17/views/videoPlayer/Z17VideoModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/videoPlayer/Z17VideoModule;", "<init>", "()V", "DOWNLOAD_CONTENT_DIRECTORY", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<Z17VideoModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.videoPlayer.Z17VideoModule$deleteDISKCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.videoPlayer.Z17VideoModule$deleteDISKCache$1", f = "Z17VideoModule.kt", l = {80}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ File $videoFolder;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.videoPlayer.Z17VideoModule$deleteDISKCache$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.videoPlayer.Z17VideoModule$deleteDISKCache$1$1", f = "Z17VideoModule.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
        public static final class C02831 extends cb.m implements Function2 {
            final /* synthetic */ File $videoFolder;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02831(File file, ab.e<? super C02831> eVar) {
                super(2, eVar);
                this.$videoFolder = file;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02831(this.$videoFolder, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                hb.l.g(this.$videoFolder);
                this.$videoFolder.delete();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02831) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(File file, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$videoFolder = file;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$videoFolder, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                pe.k0 k0VarB = d1.b();
                C02831 c02831 = new C02831(this.$videoFolder, null);
                this.label = 1;
                if (pe.i.g(k0VarB, c02831, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public Z17VideoModule(Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        this.context = context;
        this.coroutineScope = n0.a(d1.b());
        this.initialBitrate = SilenceSkippingAudioProcessor.DEFAULT_MAX_SILENCE_TO_KEEP_DURATION_US;
        ExperimentalBandwidthMeter experimentalBandwidthMeterBuild = new ExperimentalBandwidthMeter.Builder(context).setResetOnNetworkTypeChange(true).setInitialBitrateEstimate(this.initialBitrate).build();
        kotlin.jvm.internal.y.h(experimentalBandwidthMeterBuild, "build(...)");
        this.bandwidthMeter = experimentalBandwidthMeterBuild;
        this.downloadContentDirectory = new File(context.getCacheDir(), DOWNLOAD_CONTENT_DIRECTORY);
        this.standaloneDatabaseProvider = new StandaloneDatabaseProvider(context);
        this.noOpCacheEvictor = new NoOpCacheEvictor();
        this.cacheDB = new HashMap<>();
        DefaultRenderersFactory enableDecoderFallback = new DefaultRenderersFactory(context).setEnableDecoderFallback(true);
        kotlin.jvm.internal.y.h(enableDecoderFallback, "setEnableDecoderFallback(...)");
        this.rendererFactory = enableDecoderFallback;
    }

    private final String getFolderId(String identifier) {
        return a0.O(String.valueOf(identifier.hashCode()), "-", "M", false, 4, null);
    }

    @OptIn(markerClass = {UnstableApi.class})
    public final void clearFromRAMCache(String identifier) {
        kotlin.jvm.internal.y.i(identifier, "identifier");
        String folderId = getFolderId(identifier);
        SimpleCache simpleCache = this.cacheDB.get(folderId);
        if (simpleCache != null) {
            simpleCache.release();
        }
        this.cacheDB.remove(folderId);
    }

    public final void deleteDISKCache(String identifier) {
        kotlin.jvm.internal.y.i(identifier, "identifier");
        pe.k.d(this.coroutineScope, null, null, new AnonymousClass1(new File(this.downloadContentDirectory, getFolderId(identifier)), null), 3, null);
    }

    public final ExperimentalBandwidthMeter getBandwidthMeter() {
        return this.bandwidthMeter;
    }

    @UnstableApi
    public final SimpleCache getCacheDirectory(String identifier) {
        kotlin.jvm.internal.y.i(identifier, "identifier");
        String folderId = getFolderId(identifier);
        SimpleCache simpleCache = this.cacheDB.get(folderId);
        if (simpleCache == null) {
            this.cacheDB.put(folderId, new SimpleCache(new File(this.downloadContentDirectory, folderId), this.noOpCacheEvictor, this.standaloneDatabaseProvider));
            simpleCache = this.cacheDB.get(folderId);
        }
        kotlin.jvm.internal.y.f(simpleCache);
        return simpleCache;
    }

    public final long getInitialBitrate() {
        return this.initialBitrate;
    }

    public final DefaultRenderersFactory getRendererFactory() {
        return this.rendererFactory;
    }

    public final void setInitialBitrate(long j10) {
        this.initialBitrate = j10;
    }
}
