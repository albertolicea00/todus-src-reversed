package cu.todus.android.notification.service;

import ab.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import bb.b;
import cb.f;
import cb.l;
import cb.m;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.utils.CoroutineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u000e\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcu/todus/android/notification/service/DirectReplyIntent;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/content/Context;", "context", "Lua/k0;", "actionRead", "(Landroid/content/Intent;Landroid/content/Context;)V", "actionSendText", "p0", "p1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DirectReplyIntent extends BroadcastReceiver {
    public static final String ACTION_READ = "NOTIFICATION";
    public static final String NOTIFICATION = "NOTIFICATION";
    private final m0 coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.notification.service.DirectReplyIntent$actionRead$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.service.DirectReplyIntent$actionRead$1", f = "DirectReplyIntent.kt", l = {42}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Intent intent, Context context, e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$intent = intent;
            this.$context = context;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return new AnonymousClass1(this.$intent, this.$context, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String string;
            int i10;
            int i11;
            Object objG = b.g();
            int i12 = this.label;
            if (i12 == 0) {
                v.b(obj);
                MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
                Bundle extras = this.$intent.getExtras();
                ?? ContainsKey = extras != null ? extras.containsKey("uid") : 0;
                Bundle extras2 = this.$intent.getExtras();
                if (extras2 == null || (string = extras2.getString("uid")) == null) {
                    string = "";
                }
                Bundle extras3 = this.$intent.getExtras();
                int i13 = extras3 != null ? extras3.getInt("type") : -1;
                Bundle extras4 = this.$intent.getExtras();
                i10 = extras4 != null ? extras4.getInt("NOTIFICATION") : -1;
                if (instanceOrNull != null) {
                    this.L$0 = l.a(instanceOrNull);
                    this.L$1 = l.a(string);
                    this.I$0 = ContainsKey;
                    this.I$1 = i13;
                    this.I$2 = i10;
                    this.label = 1;
                    if (instanceOrNull.displayAllMessages(string, this) == objG) {
                        return objG;
                    }
                    i11 = i10;
                }
                NotificationManagerCompat.from(this.$context).cancel(i10);
                return k0.f43947a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = this.I$2;
            v.b(obj);
            i10 = i11;
            NotificationManagerCompat.from(this.$context).cancel(i10);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.service.DirectReplyIntent$actionSendText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.service.DirectReplyIntent$actionSendText$1", f = "DirectReplyIntent.kt", l = {63, 64}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10151 extends m implements Function1 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10151(Intent intent, Context context, e<? super C10151> eVar) {
            super(1, eVar);
            this.$intent = intent;
            this.$context = context;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return new C10151(this.$intent, this.$context, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((C10151) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:46:0x0111  */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String string;
            String str;
            String stringExtra;
            String str2;
            Context context;
            MainRepository instanceOrNull;
            int i10;
            int i11;
            String str3;
            MainRepository mainRepository;
            Context context2;
            int i12;
            int i13;
            String str4;
            String str5;
            int i14;
            Context context3;
            Object objG = b.g();
            int i15 = this.label;
            if (i15 != 0) {
                if (i15 == 1) {
                    i13 = this.I$1;
                    i12 = this.I$0;
                    instanceOrNull = (MainRepository) this.L$4;
                    str2 = (String) this.L$3;
                    context = (Context) this.L$2;
                    str4 = (String) this.L$1;
                    str = (String) this.L$0;
                    v.b(obj);
                } else {
                    if (i15 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i14 = this.I$0;
                    context3 = (Context) this.L$2;
                    v.b(obj);
                }
                i11 = i14;
                context2 = context3;
                NotificationManagerCompat.from(context2).cancel(i11);
                return k0.f43947a;
            }
            v.b(obj);
            Bundle extras = this.$intent.getExtras();
            if (extras == null || (string = extras.getString("uid")) == null) {
                string = "";
            }
            str = string;
            Bundle extras2 = this.$intent.getExtras();
            int i16 = extras2 != null ? extras2.getInt("NOTIFICATION") : -1;
            Bundle extras3 = this.$intent.getExtras();
            if (extras3 == null || !extras3.containsKey(ChatParams.FROM_DIRECT_REPLY)) {
                stringExtra = this.$intent.getStringExtra("android.intent.extra.TEXT");
            } else {
                Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(this.$intent);
                stringExtra = String.valueOf(resultsFromIntent != null ? resultsFromIntent.getCharSequence("android.intent.extra.TEXT") : null);
            }
            str2 = stringExtra;
            if (str2 != null) {
                context = this.$context;
                instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
                i10 = 0;
                if (instanceOrNull != null) {
                    this.L$0 = str;
                    this.L$1 = str2;
                    this.L$2 = context;
                    this.L$3 = l.a(str2);
                    this.L$4 = instanceOrNull;
                    this.I$0 = i16;
                    this.I$1 = 0;
                    this.label = 1;
                    if (instanceOrNull.displayAllMessages(str, this) != objG) {
                        i12 = i16;
                        i13 = 0;
                        str4 = str2;
                    }
                } else {
                    i11 = i16;
                    str3 = str2;
                    mainRepository = instanceOrNull;
                    context2 = context;
                    str5 = str;
                    if (mainRepository != null) {
                        this.L$0 = l.a(str5);
                        this.L$1 = l.a(str2);
                        this.L$2 = context2;
                        this.L$3 = l.a(str3);
                        this.L$4 = l.a(mainRepository);
                        this.I$0 = i11;
                        this.I$1 = i10;
                        this.label = 2;
                        if (MainRepository.sendMessage$default(mainRepository, str2, null, str5, null, null, false, null, this, 122, null) != objG) {
                            i14 = i11;
                            context3 = context2;
                            i11 = i14;
                            context2 = context3;
                        }
                    }
                    NotificationManagerCompat.from(context2).cancel(i11);
                }
                return objG;
            }
            return k0.f43947a;
            i11 = i12;
            str3 = str2;
            str2 = str4;
            i10 = i13;
            context2 = context;
            mainRepository = instanceOrNull;
            str5 = str;
            if (mainRepository != null) {
                this.L$0 = l.a(str5);
                this.L$1 = l.a(str2);
                this.L$2 = context2;
                this.L$3 = l.a(str3);
                this.L$4 = l.a(mainRepository);
                this.I$0 = i11;
                this.I$1 = i10;
                this.label = 2;
                if (MainRepository.sendMessage$default(mainRepository, str2, null, str5, null, null, false, null, this, 122, null) != objG) {
                    i14 = i11;
                    context3 = context2;
                    i11 = i14;
                    context2 = context3;
                }
                return objG;
            }
            NotificationManagerCompat.from(context2).cancel(i11);
            return k0.f43947a;
        }
    }

    private final void actionRead(Intent intent, Context context) {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new AnonymousClass1(intent, context, null), 3, null);
    }

    private final void actionSendText(Intent intent, Context context) {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C10151(intent, context, null), 3, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context p10, Intent p11) {
        if (p10 == null || p11 == null) {
            return;
        }
        if (y.d(p11.getAction(), "android.intent.action.SEND")) {
            actionSendText(p11, p10);
        } else if (y.d(p11.getAction(), "NOTIFICATION")) {
            actionRead(p11, p10);
        }
    }
}
