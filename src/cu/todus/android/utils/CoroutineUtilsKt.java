package cu.todus.android.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cu.todus.android.notification.SystemNotificationExecutor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.o0;
import pe.w0;
import re.u;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u0010\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u001aM\u0010\u0014\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u0018\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a(\u0010\u001d\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lpe/m0;", "Lpe/k0;", "context", "Lpe/o0;", TtmlNode.START, "Lkotlin/Function1;", "Lab/e;", "Lua/k0;", "", "func", "Lpe/a2;", "launchWithContext", "(Lpe/m0;Lpe/k0;Lpe/o0;Lkotlin/jvm/functions/Function1;)Lpe/a2;", "", "repeatMillis", SystemNotificationExecutor.ACTION, "launchPeriodic", "(Lpe/m0;Lpe/k0;JLkotlin/jvm/functions/Function1;)Lpe/a2;", "startPoint", "step", "launchThrottling", "(Lpe/m0;Lpe/k0;JJLkotlin/jvm/functions/Function1;)Lpe/a2;", DelayInformation.ELEMENT, "Lkotlin/Function0;", "launchUntil", "(Lpe/m0;Lpe/k0;JLlb/a;)Lpe/a2;", ExifInterface.LONGITUDE_EAST, "Lre/u;", "element", "sendWithPrecautions", "(Lre/u;Ljava/lang/Object;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CoroutineUtilsKt {

    /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$launchPeriodic$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt$launchPeriodic$1", f = "CoroutineUtils.kt", l = {33, 34}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ Function1 $action;
        final /* synthetic */ long $repeatMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j10, Function1 function1, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$repeatMillis = j10;
            this.$action = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$repeatMillis, this.$action, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        /* JADX WARN: Code duplicated, block: B:13:0x0028  */
        /* JADX WARN: Code duplicated, block: B:16:0x0035  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003f -> B:11:0x0022). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                pe.m0 r0 = (pe.m0) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L1f
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1f
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                ua.v.b(r8)
                goto L35
            L1f:
                ua.v.b(r8)
            L22:
                boolean r8 = pe.n0.g(r0)
                if (r8 == 0) goto L42
                long r5 = r7.$repeatMillis
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = pe.w0.b(r5, r7)
                if (r8 != r1) goto L35
                goto L41
            L35:
                kotlin.jvm.functions.Function1 r8 = r7.$action
                r7.L$0 = r0
                r7.label = r3
                java.lang.Object r8 = r8.invoke(r7)
                if (r8 != r1) goto L22
            L41:
                return r1
            L42:
                ua.k0 r8 = ua.k0.f43947a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.utils.CoroutineUtilsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$launchThrottling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt$launchThrottling$1", f = "CoroutineUtils.kt", l = {48, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13371 extends cb.m implements Function2 {
        final /* synthetic */ Function1 $action;
        final /* synthetic */ long $startPoint;
        final /* synthetic */ long $step;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13371(long j10, Function1 function1, long j11, ab.e<? super C13371> eVar) {
            super(2, eVar);
            this.$startPoint = j10;
            this.$action = function1;
            this.$step = j11;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13371 c13371 = new C13371(this.$startPoint, this.$action, this.$step, eVar);
            c13371.L$0 = obj;
            return c13371;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0031  */
        /* JADX WARN: Code duplicated, block: B:16:0x003e A[PHI: r5
          0x003e: PHI (r5v1 long) = (r5v2 long), (r5v5 long) binds: [B:14:0x003b, B:9:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:20:0x0051  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
        
            if (r10.invoke(r9) == r1) goto L18;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004a -> B:19:0x004d). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                pe.m0 r0 = (pe.m0) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r9.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                long r5 = r9.J$0
                ua.v.b(r10)
                goto L4d
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L20:
                long r5 = r9.J$0
                ua.v.b(r10)
                goto L3e
            L26:
                ua.v.b(r10)
                long r5 = r9.$startPoint
            L2b:
                boolean r10 = pe.n0.g(r0)
                if (r10 == 0) goto L51
                r9.L$0 = r0
                r9.J$0 = r5
                r9.label = r4
                java.lang.Object r10 = pe.w0.b(r5, r9)
                if (r10 != r1) goto L3e
                goto L4c
            L3e:
                kotlin.jvm.functions.Function1 r10 = r9.$action
                r9.L$0 = r0
                r9.J$0 = r5
                r9.label = r3
                java.lang.Object r10 = r10.invoke(r9)
                if (r10 != r1) goto L4d
            L4c:
                return r1
            L4d:
                long r7 = r9.$step
                long r5 = r5 + r7
                goto L2b
            L51:
                ua.k0 r10 = ua.k0.f43947a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.utils.CoroutineUtilsKt.C13371.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13371) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$launchUntil$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt$launchUntil$1", f = "CoroutineUtils.kt", l = {60}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13381 extends cb.m implements Function2 {
        final /* synthetic */ lb.a $action;
        final /* synthetic */ long $delay;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13381(long j10, lb.a aVar, ab.e<? super C13381> eVar) {
            super(2, eVar);
            this.$delay = j10;
            this.$action = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C13381(this.$delay, this.$action, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                long j10 = this.$delay;
                this.label = 1;
                if (w0.b(j10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            this.$action.invoke();
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13381) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$launchWithContext$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt$launchWithContext$1", f = "CoroutineUtils.kt", l = {21}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13391 extends cb.m implements Function2 {
        final /* synthetic */ pe.k0 $context;
        final /* synthetic */ Function1 $func;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$launchWithContext$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt$launchWithContext$1$1", f = "CoroutineUtils.kt", l = {22}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02611 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $func;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02611(Function1 function1, ab.e<? super C02611> eVar) {
                super(2, eVar);
                this.$func = function1;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02611(this.$func, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    Function1 function1 = this.$func;
                    this.label = 1;
                    if (function1.invoke(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02611) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13391(pe.k0 k0Var, Function1 function1, ab.e<? super C13391> eVar) {
            super(2, eVar);
            this.$context = k0Var;
            this.$func = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C13391(this.$context, this.$func, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                ab.i iVarPlus = this.$context.plus(e2.b(null, 1, null));
                C02611 c02611 = new C02611(this.$func, null);
                this.label = 1;
                if (pe.i.g(iVarPlus, c02611, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13391) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.CoroutineUtilsKt$sendWithPrecautions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.CoroutineUtilsKt", f = "CoroutineUtils.kt", l = {69}, m = "sendWithPrecautions", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13401<E> extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13401(ab.e<? super C13401> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineUtilsKt.sendWithPrecautions(null, null, this);
        }
    }

    public static final a2 launchPeriodic(m0 m0Var, pe.k0 context, long j10, Function1 action) {
        y.i(m0Var, "<this>");
        y.i(context, "context");
        y.i(action, "action");
        return pe.k.d(m0Var, context.plus(e2.b(null, 1, null)), null, new AnonymousClass1(j10, action, null), 2, null);
    }

    public static /* synthetic */ a2 launchPeriodic$default(m0 m0Var, pe.k0 k0Var, long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k0Var = d1.b();
        }
        if ((i10 & 2) != 0) {
            j10 = 4000;
        }
        return launchPeriodic(m0Var, k0Var, j10, function1);
    }

    public static final a2 launchThrottling(m0 m0Var, pe.k0 context, long j10, long j11, Function1 action) {
        y.i(m0Var, "<this>");
        y.i(context, "context");
        y.i(action, "action");
        return pe.k.d(m0Var, context.plus(e2.b(null, 1, null)), null, new C13371(j10, action, j11, null), 2, null);
    }

    public static /* synthetic */ a2 launchThrottling$default(m0 m0Var, pe.k0 k0Var, long j10, long j11, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k0Var = d1.b();
        }
        if ((i10 & 2) != 0) {
            j10 = 4000;
        }
        if ((i10 & 4) != 0) {
            j11 = 500;
        }
        return launchThrottling(m0Var, k0Var, j10, j11, function1);
    }

    public static final a2 launchUntil(m0 m0Var, pe.k0 context, long j10, lb.a action) {
        y.i(m0Var, "<this>");
        y.i(context, "context");
        y.i(action, "action");
        return pe.k.d(m0Var, context.plus(e2.b(null, 1, null)), null, new C13381(j10, action, null), 2, null);
    }

    public static /* synthetic */ a2 launchUntil$default(m0 m0Var, pe.k0 k0Var, long j10, lb.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k0Var = d1.b();
        }
        return launchUntil(m0Var, k0Var, j10, aVar);
    }

    public static final a2 launchWithContext(m0 m0Var, pe.k0 context, o0 start, Function1 func) {
        y.i(m0Var, "<this>");
        y.i(context, "context");
        y.i(start, "start");
        y.i(func, "func");
        return pe.i.c(m0Var, context.plus(e2.b(null, 1, null)), start, new C13391(context, func, null));
    }

    public static /* synthetic */ a2 launchWithContext$default(m0 m0Var, pe.k0 k0Var, o0 o0Var, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k0Var = d1.b();
        }
        if ((i10 & 2) != 0) {
            o0Var = o0.DEFAULT;
        }
        return launchWithContext(m0Var, k0Var, o0Var, function1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <E> Object sendWithPrecautions(u uVar, E e10, ab.e<? super k0> eVar) {
        C13401 c13401;
        if (eVar instanceof C13401) {
            c13401 = (C13401) eVar;
            int i10 = c13401.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13401.label = i10 - Integer.MIN_VALUE;
            } else {
                c13401 = new C13401(eVar);
            }
        } else {
            c13401 = new C13401(eVar);
        }
        Object obj = c13401.result;
        Object objG = bb.b.g();
        int i11 = c13401.label;
        try {
            if (i11 == 0) {
                v.b(obj);
                if (!uVar.getChannel().isClosedForSend()) {
                    c13401.L$0 = cb.l.a(uVar);
                    c13401.L$1 = cb.l.a(e10);
                    c13401.label = 1;
                    if (uVar.send(e10, c13401) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return k0.f43947a;
    }
}
