package cu.todus.android.webrtc.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.l;
import cb.m;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.call.AudioCallActivity;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.uiCompose.call.CallParams;
import cu.todus.android.uiCompose.call.VideoCallActivity;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.k;
import pe.m0;
import pe.n0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcu/todus/android/webrtc/notification/CallIntentReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "", "uid", "", "isVideoCall", "Lua/k0;", "acceptCallProcessNew", "(Landroid/content/Context;Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_ANSWER = "answer_call";
    public static final String ACTION_ANSWER_WITH_TYPE = "answer_call_with_type";
    public static final String ACTION_HANG_UP = "answer_hang_up";
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.webrtc.notification.CallIntentReceiver$acceptCallProcessNew$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.notification.CallIntentReceiver", f = "CallIntentReceiver.kt", l = {60}, m = "acceptCallProcessNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallIntentReceiver.this.acceptCallProcessNew(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.notification.CallIntentReceiver$onReceive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.notification.CallIntentReceiver$onReceive$1", f = "CallIntentReceiver.kt", l = {21, 31, 33}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13431 extends m implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ CallIntentReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13431(Intent intent, CallIntentReceiver callIntentReceiver, Context context, ab.e<? super C13431> eVar) {
            super(2, eVar);
            this.$intent = intent;
            this.this$0 = callIntentReceiver;
            this.$context = context;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C13431(this.$intent, this.this$0, this.$context, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        
            if (r13.rejectCallProcess(r1, r12) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
        
            if (r2.acceptCallProcessNew(r4, r1, r13, r12) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
        
            if (r6.acceptCallProcess(r7, r8, r9, r10, r12) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r12.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1e
            L12:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1a:
                java.lang.Object r0 = r12.L$0
                java.lang.String r0 = (java.lang.String) r0
            L1e:
                ua.v.b(r13)
                goto Lba
            L23:
                ua.v.b(r13)
                android.content.Intent r13 = r12.$intent
                java.lang.String r13 = r13.getAction()
                java.lang.String r1 = "answer_hang_up"
                boolean r13 = kotlin.jvm.internal.y.d(r13, r1)
                java.lang.String r1 = ""
                java.lang.String r5 = "uid"
                if (r13 == 0) goto L55
                cu.todus.android.repositories.MainRepository$Companion r13 = cu.todus.android.repositories.MainRepository.INSTANCE
                java.lang.Object r13 = r13.getInstanceOrNull()
                cu.todus.android.repositories.MainRepository r13 = (cu.todus.android.repositories.MainRepository) r13
                if (r13 == 0) goto Lba
                android.content.Intent r2 = r12.$intent
                java.lang.String r2 = r2.getStringExtra(r5)
                if (r2 != 0) goto L4b
                goto L4c
            L4b:
                r1 = r2
            L4c:
                r12.label = r4
                java.lang.Object r13 = r13.rejectCallProcess(r1, r12)
                if (r13 != r0) goto Lba
                goto Lb9
            L55:
                android.content.Intent r13 = r12.$intent
                java.lang.String r13 = r13.getAction()
                java.lang.String r4 = "answer_call_with_type"
                boolean r13 = kotlin.jvm.internal.y.d(r13, r4)
                if (r13 == 0) goto L8b
                android.content.Intent r13 = r12.$intent
                java.lang.String r13 = r13.getStringExtra(r5)
                if (r13 != 0) goto L6c
                goto L6d
            L6c:
                r1 = r13
            L6d:
                android.content.Intent r13 = r12.$intent
                java.lang.String r2 = "isVideoCall"
                r4 = 0
                boolean r13 = r13.getBooleanExtra(r2, r4)
                cu.todus.android.webrtc.notification.CallIntentReceiver r2 = r12.this$0
                android.content.Context r4 = r12.$context
                java.lang.Object r5 = cb.l.a(r1)
                r12.L$0 = r5
                r12.Z$0 = r13
                r12.label = r3
                java.lang.Object r13 = cu.todus.android.webrtc.notification.CallIntentReceiver.access$acceptCallProcessNew(r2, r4, r1, r13, r12)
                if (r13 != r0) goto Lba
                goto Lb9
            L8b:
                cu.todus.android.repositories.MainRepository$Companion r13 = cu.todus.android.repositories.MainRepository.INSTANCE
                java.lang.Object r13 = r13.getInstanceOrNull()
                r6 = r13
                cu.todus.android.repositories.MainRepository r6 = (cu.todus.android.repositories.MainRepository) r6
                if (r6 == 0) goto Lba
                android.content.Intent r13 = r12.$intent
                java.lang.String r13 = r13.getStringExtra(r5)
                if (r13 != 0) goto La0
                r7 = r1
                goto La1
            La0:
                r7 = r13
            La1:
                cu.todus.android.webrtc.notification.d r8 = new cu.todus.android.webrtc.notification.d
                r8.<init>()
                cu.todus.android.webrtc.notification.e r9 = new cu.todus.android.webrtc.notification.e
                r9.<init>()
                cu.todus.android.webrtc.notification.f r10 = new cu.todus.android.webrtc.notification.f
                r10.<init>()
                r12.label = r2
                r11 = r12
                java.lang.Object r13 = r6.acceptCallProcess(r7, r8, r9, r10, r11)
                if (r13 != r0) goto Lba
            Lb9:
                return r0
            Lba:
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.notification.CallIntentReceiver.C13431.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13431) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object acceptCallProcessNew(final Context context, final String str, final boolean z10, ab.e<? super k0> eVar) {
        AnonymousClass1 anonymousClass1;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass2.label;
        try {
            if (i11 == 0) {
                v.b(obj);
                MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
                if (instanceOrNull != null) {
                    lb.a aVar = new lb.a() { // from class: cu.todus.android.webrtc.notification.a
                        @Override // lb.a
                        public final Object invoke() {
                            return CallIntentReceiver.acceptCallProcessNew$lambda$0(z10, context, str);
                        }
                    };
                    lb.a aVar2 = new lb.a() { // from class: cu.todus.android.webrtc.notification.b
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    lb.a aVar3 = new lb.a() { // from class: cu.todus.android.webrtc.notification.c
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    anonymousClass2.L$0 = l.a(context);
                    anonymousClass2.L$1 = l.a(str);
                    anonymousClass2.Z$0 = z10;
                    anonymousClass2.label = 1;
                    if (instanceOrNull.acceptCallProcess(str, aVar, aVar2, aVar3, anonymousClass2) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 acceptCallProcessNew$lambda$0(boolean z10, Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) (z10 ? VideoCallActivity.class : AudioCallActivity.class));
        Bundle bundle = new Bundle();
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CallParams(str, false, 2, null));
        y.h(strT, "toJson(...)");
        bundle.putString(CallActivity.CALL_PARAMS_KEY, navLinks.encode(strT));
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        return k0.f43947a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        y.i(context, "context");
        y.i(intent, "intent");
        k.d(n0.a(d1.c()), null, null, new C13431(intent, this, context, null), 3, null);
    }
}
