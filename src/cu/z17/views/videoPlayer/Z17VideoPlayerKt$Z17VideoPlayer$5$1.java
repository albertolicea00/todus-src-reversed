package cu.z17.views.videoPlayer;

import androidx.compose.runtime.MutableLongState;
import androidx.media3.exoplayer.ExoPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoPlayer.Z17VideoPlayerKt$Z17VideoPlayer$5$1", f = "Z17VideoPlayer.kt", l = {170}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17VideoPlayerKt$Z17VideoPlayer$5$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableLongState $currentTime$delegate;
    final /* synthetic */ Function1 $onCurrentTimeChanged;
    final /* synthetic */ ExoPlayer $player;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17VideoPlayerKt$Z17VideoPlayer$5$1(ExoPlayer exoPlayer, Function1 function1, MutableLongState mutableLongState, ab.e<? super Z17VideoPlayerKt$Z17VideoPlayer$5$1> eVar) {
        super(2, eVar);
        this.$player = exoPlayer;
        this.$onCurrentTimeChanged = function1;
        this.$currentTime$delegate = mutableLongState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17VideoPlayerKt$Z17VideoPlayer$5$1(this.$player, this.$onCurrentTimeChanged, this.$currentTime$delegate, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:12:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // cb.a
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            ua.v.b(r8)
            goto L25
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            ua.v.b(r8)
        L1a:
            r7.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = pe.w0.b(r3, r7)
            if (r8 != r0) goto L25
            return r0
        L25:
            androidx.compose.runtime.MutableLongState r8 = r7.$currentTime$delegate
            long r3 = cu.z17.views.videoPlayer.Z17VideoPlayerKt.access$Z17VideoPlayer$lambda$9(r8)
            androidx.media3.exoplayer.ExoPlayer r8 = r7.$player
            long r5 = r8.getCurrentPosition()
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L47
            kotlin.jvm.functions.Function1 r8 = r7.$onCurrentTimeChanged
            androidx.compose.runtime.MutableLongState r1 = r7.$currentTime$delegate
            long r3 = cu.z17.views.videoPlayer.Z17VideoPlayerKt.access$Z17VideoPlayer$lambda$9(r1)
            r5 = 1
            long r3 = r3 + r5
            java.lang.Long r1 = cb.b.e(r3)
            r8.invoke(r1)
        L47:
            androidx.compose.runtime.MutableLongState r8 = r7.$currentTime$delegate
            androidx.media3.exoplayer.ExoPlayer r1 = r7.$player
            long r3 = r1.getCurrentPosition()
            cu.z17.views.videoPlayer.Z17VideoPlayerKt.access$Z17VideoPlayer$lambda$10(r8, r3)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.videoPlayer.Z17VideoPlayerKt$Z17VideoPlayer$5$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17VideoPlayerKt$Z17VideoPlayer$5$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
