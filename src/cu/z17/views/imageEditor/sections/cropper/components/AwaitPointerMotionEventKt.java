package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y;
import pe.m0;
import pe.n0;
import pe.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001az\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Lua/k0;", "onDown", "", "onMove", "onUp", "", "delayAfterDownInMillis", "", "requireUnconsumed", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "detectMotionEventsAsList", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;JZLandroidx/compose/ui/input/pointer/PointerEventPass;Lab/e;)Ljava/lang/Object;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AwaitPointerMotionEventKt {

    /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5", f = "AwaitPointerMotionEvent.kt", l = {TsExtractor.TS_SYNC_BYTE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass5 extends cb.m implements Function2 {
        final /* synthetic */ long $delayAfterDownInMillis;
        final /* synthetic */ Function1 $onDown;
        final /* synthetic */ Function1 $onMove;
        final /* synthetic */ Function1 $onUp;
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ boolean $requireUnconsumed;
        final /* synthetic */ PointerInputScope $this_detectMotionEventsAsList;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5$1", f = "AwaitPointerMotionEvent.kt", l = {73, 94}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lua/k0;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {2, 2, 0})
        public static final class AnonymousClass1 extends cb.k implements Function2 {
            final /* synthetic */ m0 $$this$coroutineScope;
            final /* synthetic */ long $delayAfterDownInMillis;
            final /* synthetic */ Function1 $onDown;
            final /* synthetic */ Function1 $onMove;
            final /* synthetic */ Function1 $onUp;
            final /* synthetic */ PointerEventPass $pass;
            final /* synthetic */ boolean $requireUnconsumed;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            /* JADX INFO: renamed from: cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt$detectMotionEventsAsList$5$1$1", f = "AwaitPointerMotionEvent.kt", l = {88}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
            public static final class C02801 extends cb.m implements Function2 {
                final /* synthetic */ long $delayAfterDownInMillis;
                final /* synthetic */ u0 $waitedAfterDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02801(long j10, u0 u0Var, ab.e<? super C02801> eVar) {
                    super(2, eVar);
                    this.$delayAfterDownInMillis = j10;
                    this.$waitedAfterDown = u0Var;
                }

                @Override // cb.a
                public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                    return new C02801(this.$delayAfterDownInMillis, this.$waitedAfterDown, eVar);
                }

                @Override // cb.a
                public final Object invokeSuspend(Object obj) {
                    Object objG = bb.b.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        ua.v.b(obj);
                        long j10 = this.$delayAfterDownInMillis;
                        this.label = 1;
                        if (w0.b(j10, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj);
                    }
                    this.$waitedAfterDown.f36629c = true;
                    return k0.f43947a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                    return ((C02801) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(boolean z10, PointerEventPass pointerEventPass, Function1 function1, m0 m0Var, Function1 function2, Function1 function3, long j10, ab.e<? super AnonymousClass1> eVar) {
                super(2, eVar);
                this.$requireUnconsumed = z10;
                this.$pass = pointerEventPass;
                this.$onDown = function1;
                this.$$this$coroutineScope = m0Var;
                this.$onMove = function2;
                this.$onUp = function3;
                this.$delayAfterDownInMillis = j10;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requireUnconsumed, this.$pass, this.$onDown, this.$$this$coroutineScope, this.$onMove, this.$onUp, this.$delayAfterDownInMillis, eVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, ab.e<? super k0> eVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, eVar)).invokeSuspend(k0.f43947a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
            
                if (r14 == r1) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0087, code lost:
            
                if (r14 == r1) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:
            
                return r1;
             */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0087 -> B:17:0x008a). Please report as a decompilation issue!!! */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    Method dump skipped, instruction units count: 259
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.AwaitPointerMotionEventKt.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(PointerInputScope pointerInputScope, boolean z10, PointerEventPass pointerEventPass, Function1 function1, Function1 function2, Function1 function3, long j10, ab.e<? super AnonymousClass5> eVar) {
            super(2, eVar);
            this.$this_detectMotionEventsAsList = pointerInputScope;
            this.$requireUnconsumed = z10;
            this.$pass = pointerEventPass;
            this.$onDown = function1;
            this.$onMove = function2;
            this.$onUp = function3;
            this.$delayAfterDownInMillis = j10;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$this_detectMotionEventsAsList, this.$requireUnconsumed, this.$pass, this.$onDown, this.$onMove, this.$onUp, this.$delayAfterDownInMillis, eVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            m0 m0Var = (m0) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PointerInputScope pointerInputScope = this.$this_detectMotionEventsAsList;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requireUnconsumed, this.$pass, this.$onDown, m0Var, this.$onMove, this.$onUp, this.$delayAfterDownInMillis, null);
                this.L$0 = cb.l.a(m0Var);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == objG) {
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
            return ((AnonymousClass5) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public static final Object detectMotionEventsAsList(PointerInputScope pointerInputScope, Function1 function1, Function1 function2, Function1 function3, long j10, boolean z10, PointerEventPass pointerEventPass, ab.e<? super k0> eVar) {
        Object objE = n0.e(new AnonymousClass5(pointerInputScope, z10, pointerEventPass, function1, function2, function3, j10, null), eVar);
        return objE == bb.b.g() ? objE : k0.f43947a;
    }

    public static /* synthetic */ Object detectMotionEventsAsList$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function2, Function1 function3, long j10, boolean z10, PointerEventPass pointerEventPass, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AwaitPointerMotionEventKt.detectMotionEventsAsList$lambda$0((PointerInputChange) obj2);
                }
            };
        }
        if ((i10 & 2) != 0) {
            function2 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AwaitPointerMotionEventKt.detectMotionEventsAsList$lambda$1((List) obj2);
                }
            };
        }
        if ((i10 & 4) != 0) {
            function3 = new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AwaitPointerMotionEventKt.detectMotionEventsAsList$lambda$2((PointerInputChange) obj2);
                }
            };
        }
        if ((i10 & 8) != 0) {
            j10 = 0;
        }
        if ((i10 & 16) != 0) {
            z10 = true;
        }
        if ((i10 & 32) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        boolean z11 = z10;
        long j11 = j10;
        Function1 function4 = function3;
        return detectMotionEventsAsList(pointerInputScope, function1, function2, function4, j11, z11, pointerEventPass, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 detectMotionEventsAsList$lambda$0(PointerInputChange it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 detectMotionEventsAsList$lambda$1(List it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 detectMotionEventsAsList$lambda$2(PointerInputChange it) {
        y.i(it, "it");
        return k0.f43947a;
    }
}
