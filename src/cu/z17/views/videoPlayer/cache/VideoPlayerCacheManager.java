package cu.z17.views.videoPlayer.cache;

import android.content.Context;
import androidx.annotation.OptIn;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import cu.z17.singledi.SingletonInitializer;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@OptIn(markerClass = {UnstableApi.class})
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcu/z17/views/videoPlayer/cache/VideoPlayerCacheManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cacheInstance", "Landroidx/media3/datasource/cache/Cache;", "getCacheInstance", "()Landroidx/media3/datasource/cache/Cache;", "setCacheInstance", "(Landroidx/media3/datasource/cache/Cache;)V", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayerCacheManager {
    private static final long CACHE_SIZE = 52428800;
    private Cache cacheInstance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcu/z17/views/videoPlayer/cache/VideoPlayerCacheManager$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/videoPlayer/cache/VideoPlayerCacheManager;", "<init>", "()V", "CACHE_SIZE", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<VideoPlayerCacheManager> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public VideoPlayerCacheManager(Context context) {
        SimpleCache simpleCache;
        y.i(context, "context");
        try {
            simpleCache = new SimpleCache(new File(context.getCacheDir(), "video"), new LeastRecentlyUsedCacheEvictor(CACHE_SIZE), new StandaloneDatabaseProvider(context));
        } catch (Exception e10) {
            e10.printStackTrace();
            simpleCache = null;
        }
        this.cacheInstance = simpleCache;
    }

    public final Cache getCacheInstance() {
        return this.cacheInstance;
    }

    public final void setCacheInstance(Cache cache) {
        this.cacheInstance = cache;
    }
}
