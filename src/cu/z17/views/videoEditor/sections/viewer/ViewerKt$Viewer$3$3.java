package cu.z17.views.videoEditor.sections.viewer;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.ForwardingPlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaSession;
import cb.m;
import cu.z17.views.videoPlayer.uri.VideoPlayerMediaItem;
import cu.z17.views.videoPlayer.uri.VideoPlayerMediaItemConverterKt;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import le.d0;
import pe.m0;
import ua.k0;
import ua.v;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoEditor.sections.viewer.ViewerKt$Viewer$3$3", f = "Viewer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ViewerKt$Viewer$3$3 extends m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ rb.b $cutPoints;
    final /* synthetic */ y0 $mediaSession;
    final /* synthetic */ ExoPlayer $player;
    final /* synthetic */ Uri $source;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewerKt$Viewer$3$3(y0 y0Var, Context context, ExoPlayer exoPlayer, Uri uri, rb.b bVar, ab.e<? super ViewerKt$Viewer$3$3> eVar) {
        super(2, eVar);
        this.$mediaSession = y0Var;
        this.$context = context;
        this.$player = exoPlayer;
        this.$source = uri;
        this.$cutPoints = bVar;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ViewerKt$Viewer$3$3(this.$mediaSession, this.$context, this.$player, this.$source, this.$cutPoints, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        MediaSession mediaSession = (MediaSession) this.$mediaSession.f36634c;
        if (mediaSession != null) {
            mediaSession.release();
        }
        y0 y0Var = this.$mediaSession;
        MediaSession.Builder builder = new MediaSession.Builder(this.$context, new ForwardingPlayer(this.$player));
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        y.h(lowerCase, "toLowerCase(...)");
        y0Var.f36634c = builder.setId("VideoPlayerMediaSession_" + g0.w0(d0.S0(lowerCase, new String[]{"-"}, false, 0, 6, null))).build();
        VideoPlayerMediaItem.StorageMediaItem storageMediaItem = new VideoPlayerMediaItem.StorageMediaItem(this.$source, null, null, 6, null);
        Context context = this.$context;
        rb.b bVar = this.$cutPoints;
        Uri uri = VideoPlayerMediaItemConverterKt.toUri(storageMediaItem, context);
        MediaItem.ClippingConfiguration clippingConfigurationBuild = ((Number) bVar.getEndInclusive()).floatValue() - ((Number) bVar.getStart()).floatValue() >= 3.0f ? new MediaItem.ClippingConfiguration.Builder().setStartPositionMs((long) ((Number) bVar.getStart()).floatValue()).setEndPositionMs((long) ((Number) bVar.getEndInclusive()).floatValue()).build() : null;
        MediaItem.Builder builder2 = new MediaItem.Builder();
        builder2.setUri(uri);
        builder2.setMediaMetadata(storageMediaItem.getMediaMetadata());
        builder2.setMimeType(storageMediaItem.getMimeType());
        if (clippingConfigurationBuild != null) {
            builder2.setClippingConfiguration(clippingConfigurationBuild);
        }
        this.$player.setMediaItems(va.v.e(builder2.build()));
        this.$player.prepare();
        this.$player.setPlayWhenReady(false);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ViewerKt$Viewer$3$3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
