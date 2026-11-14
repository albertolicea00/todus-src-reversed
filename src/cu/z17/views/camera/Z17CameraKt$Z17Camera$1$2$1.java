package cu.z17.views.camera;

import android.content.Context;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.State;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@cb.f(c = "cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1", f = "Z17Camera.kt", l = {WebmConstants.MkvEbmlElement.FLAG_INTERLACED}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17CameraKt$Z17Camera$1$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableFloatState $actualRotation$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableLongState $currentRecordTime$delegate;
    final /* synthetic */ State<RecordingState> $recordState$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Z17CameraKt$Z17Camera$1$2$1(Context context, MutableFloatState mutableFloatState, State<? extends RecordingState> state, MutableLongState mutableLongState, ab.e<? super Z17CameraKt$Z17Camera$1$2$1> eVar) {
        super(2, eVar);
        this.$context = context;
        this.$actualRotation$delegate = mutableFloatState;
        this.$recordState$delegate = state;
        this.$currentRecordTime$delegate = mutableLongState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17CameraKt$Z17Camera$1$2$1(this.$context, this.$actualRotation$delegate, this.$recordState$delegate, this.$currentRecordTime$delegate, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0039 -> B:12:0x003c). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            java.lang.Object r1 = r7.L$0
            cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1$orientationEventListener$1 r1 = (cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1$orientationEventListener$1) r1
            ua.v.b(r8)
            goto L3c
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            ua.v.b(r8)
            cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1$orientationEventListener$1 r8 = new cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1$orientationEventListener$1
            android.content.Context r1 = r7.$context
            androidx.compose.runtime.MutableFloatState r3 = r7.$actualRotation$delegate
            r8.<init>(r1)
            r8.enable()
            r1 = r8
        L2b:
            java.lang.Object r8 = cb.l.a(r1)
            r7.L$0 = r8
            r7.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = pe.w0.b(r3, r7)
            if (r8 != r0) goto L3c
            return r0
        L3c:
            androidx.compose.runtime.State<cu.z17.views.camera.RecordingState> r8 = r7.$recordState$delegate
            cu.z17.views.camera.RecordingState r8 = cu.z17.views.camera.Z17CameraKt.access$Z17Camera$lambda$47$lambda$18(r8)
            cu.z17.views.camera.RecordingState r3 = cu.z17.views.camera.RecordingState.RECORDING
            if (r8 != r3) goto L2b
            androidx.compose.runtime.MutableLongState r8 = r7.$currentRecordTime$delegate
            long r3 = cu.z17.views.camera.Z17CameraKt.access$Z17Camera$lambda$47$lambda$5(r8)
            r5 = 1
            long r3 = r3 + r5
            cu.z17.views.camera.Z17CameraKt.access$Z17Camera$lambda$47$lambda$6(r8, r3)
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.camera.Z17CameraKt$Z17Camera$1$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17CameraKt$Z17Camera$1$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
