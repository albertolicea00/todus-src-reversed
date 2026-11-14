package cu.todus.android.uiCompose.main.screen.chat.component.group;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.group.BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1", f = "BigChatGroupScreen.kt", l = {699, TypedValues.TransitionType.TYPE_FROM, 709, 711}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $fastScroll;
    final /* synthetic */ LazyListState $listState;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1(boolean z10, LazyListState lazyListState, ab.e<? super BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1> eVar) {
        super(2, eVar);
        this.$fastScroll = z10;
        this.$listState = lazyListState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1(this.$fastScroll, this.$listState, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:29:0x0071->B:39:?, LOOP_END, SYNTHETIC] */
    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        int i10;
        LazyListState lazyListState;
        TweenSpec tweenSpecTween$default;
        Object objG = bb.b.g();
        int i11 = this.label;
        if (i11 == 0) {
            ua.v.b(obj);
            i10 = this.$fastScroll ? 5 : 25;
            this.I$0 = i10;
            this.label = 1;
            if (pe.w0.b(200L, this) != objG) {
            }
            return objG;
        }
        if (i11 == 1 || i11 == 2) {
            i10 = this.I$0;
            ua.v.b(obj);
        } else {
            if (i11 != 3 && i11 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = this.I$0;
            ua.v.b(obj);
        }
        while (this.$listState.getCanScrollBackward()) {
            lazyListState = this.$listState;
            tweenSpecTween$default = AnimationSpecKt.tween$default(i10, 0, EasingKt.getLinearEasing(), 2, null);
            this.I$0 = i10;
            this.label = 4;
            if (ScrollExtensionsKt.animateScrollBy(lazyListState, -200.0f, tweenSpecTween$default, this) == objG) {
                return objG;
            }
        }
        return ua.k0.f43947a;
        while (this.$listState.getCanScrollBackward()) {
            LazyListState lazyListState2 = this.$listState;
            TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(i10, 0, EasingKt.getLinearEasing(), 2, null);
            this.I$0 = i10;
            this.label = 2;
            if (ScrollExtensionsKt.animateScrollBy(lazyListState2, -200.0f, tweenSpecTween$default2, this) == objG) {
                return objG;
            }
        }
        this.I$0 = i10;
        this.label = 3;
        if (pe.w0.b(400L, this) != objG) {
            while (this.$listState.getCanScrollBackward()) {
                lazyListState = this.$listState;
                tweenSpecTween$default = AnimationSpecKt.tween$default(i10, 0, EasingKt.getLinearEasing(), 2, null);
                this.I$0 = i10;
                this.label = 4;
                if (ScrollExtensionsKt.animateScrollBy(lazyListState, -200.0f, tweenSpecTween$default, this) == objG) {
                }
            }
            return ua.k0.f43947a;
        }
        return objG;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$1$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
