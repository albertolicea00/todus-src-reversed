package cu.todus.android.uiCompose.main.screen.chat.component.card;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$4$2$2$1$1", f = "ChatCardScreen.kt", l = {TypedValues.TransitionType.TYPE_FROM, TypedValues.TransitionType.TYPE_INTERPOLATOR, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ChatCardScreenKt$ChatCardScreen$4$2$2$1$1 extends cb.m implements Function2 {
    final /* synthetic */ int $it;
    final /* synthetic */ LazyListState $listState;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCardScreenKt$ChatCardScreen$4$2$2$1$1(LazyListState lazyListState, int i10, ab.e<? super ChatCardScreenKt$ChatCardScreen$4$2$2$1$1> eVar) {
        super(2, eVar);
        this.$listState = lazyListState;
        this.$it = i10;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new ChatCardScreenKt$ChatCardScreen$4$2$2$1$1(this.$listState, this.$it, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
    
        if (r4.intValue() < r10.$it) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r11, 200.0f, r8, r10) == r0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0150, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r11, -200.0f, r8, r10) == r0) goto L56;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d5 -> B:38:0x00d9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0150 -> B:57:0x0153). Please report as a decompilation issue!!! */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.card.ChatCardScreenKt$ChatCardScreen$4$2$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((ChatCardScreenKt$ChatCardScreen$4$2$2$1$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
