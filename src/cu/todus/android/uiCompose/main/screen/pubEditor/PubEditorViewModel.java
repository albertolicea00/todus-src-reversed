package cu.todus.android.uiCompose.main.screen.pubEditor;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/pubEditor/PubEditorViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "text", "roomId", "Lua/k0;", "sendMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PubEditorViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel$sendMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel$sendMessage$1", f = "PubEditorViewModel.kt", l = {26, 31}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ PubEditorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, PubEditorViewModel pubEditorViewModel, String str2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.this$0 = pubEditorViewModel;
            this.$text = str2;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new AnonymousClass1(this.$roomId, this.this$0, this.$text, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            if (cu.todus.android.repositories.MainRepository.sendMessageToChannel$default(r0, r1, null, r3, null, null, false, null, null, r15, 250, null) == r12) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
        
            if (cu.todus.android.repositories.MainRepository.sendMessage$default(r0, r2, null, r3, null, null, false, null, r15, 122, null) == r12) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        
            return r12;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                r15 = this;
                java.lang.Object r12 = bb.b.g()
                int r0 = r15.label
                r1 = 2
                r2 = 1
                if (r0 == 0) goto L1b
                if (r0 == r2) goto L17
                if (r0 != r1) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L17:
                ua.v.b(r16)
                goto L62
            L1b:
                ua.v.b(r16)
                cu.todus.android.xmpp.XMPPUtils r0 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r3 = r15.$roomId
                boolean r0 = r0.isChannel(r3)
                if (r0 == 0) goto L45
                cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel r0 = r15.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel.access$getMainRepository$p(r0)
                java.lang.String r1 = r15.$text
                java.lang.String r3 = r15.$roomId
                r15.label = r2
                r2 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r10 = 250(0xfa, float:3.5E-43)
                r11 = 0
                r9 = r15
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessageToChannel$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r0 != r12) goto L62
                goto L61
            L45:
                cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel r0 = r15.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel.access$getMainRepository$p(r0)
                java.lang.String r2 = r15.$text
                java.lang.String r3 = r15.$roomId
                r15.label = r1
                r1 = r2
                r2 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 122(0x7a, float:1.71E-43)
                r10 = 0
                r8 = r15
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessage$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r0 != r12) goto L62
            L61:
                return r12
            L62:
                cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel r0 = r15.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel.access$getMainRepository$p(r0)
                cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState r1 = new cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState
                java.util.UUID r2 = java.util.UUID.randomUUID()
                java.lang.String r9 = r2.toString()
                java.lang.String r2 = "toString(...)"
                kotlin.jvm.internal.y.h(r9, r2)
                r13 = 4
                r14 = 0
                java.lang.String r10 = "-"
                java.lang.String r11 = ""
                r12 = 0
                java.lang.String r2 = le.a0.O(r9, r10, r11, r12, r13, r14)
                cu.todus.android.uiCompose.shared.insideNotification.Cause r3 = cu.todus.android.uiCompose.shared.insideNotification.Cause.CORRECT
                cu.todus.android.di.MainModule$Companion r4 = cu.todus.android.di.MainModule.INSTANCE
                java.lang.Object r4 = r4.getInstance()
                cu.todus.android.di.MainModule r4 = (cu.todus.android.di.MainModule) r4
                android.content.Context r4 = r4.getAppContext()
                int r5 = cu.todus.android.R.string.message_published
                java.lang.String r4 = r4.getString(r5)
                java.lang.String r5 = "getString(...)"
                kotlin.jvm.internal.y.h(r4, r5)
                r1.<init>(r2, r3, r4)
                r0.addNewNotification(r1)
                ua.k0 r0 = ua.k0.f43947a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.pubEditor.PubEditorViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final void sendMessage(String text, String roomId) {
        kotlin.jvm.internal.y.i(text, "text");
        kotlin.jvm.internal.y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, this, text, null), 3, null);
    }
}
