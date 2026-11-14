package cu.todus.android.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.exoplayer.Renderer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import pe.d1;
import pe.m0;
import pe.n0;
import re.s;
import re.u;
import re.w;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0005R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcu/todus/android/utils/SMSReceived;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "smsBody", "extractCode", "(Ljava/lang/String;)Ljava/lang/String;", "", "afterTime", "readFromInbox", "(J)Ljava/lang/String;", "Lua/k0;", "unRegister", "()V", "Lte/h;", "register", "()Lte/h;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "Landroid/content/IntentFilter;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "setIntentFilter", "(Landroid/content/IntentFilter;)V", "Landroid/content/BroadcastReceiver;", "mIntentReceiver", "Landroid/content/BroadcastReceiver;", "getMIntentReceiver", "()Landroid/content/BroadcastReceiver;", "setMIntentReceiver", "(Landroid/content/BroadcastReceiver;)V", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "getCoroutineScope", "()Lpe/m0;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SMSReceived {
    public static final String SENDER = "toDus";
    private Context context;
    private final m0 coroutineScope;
    private IntentFilter intentFilter;
    private BroadcastReceiver mIntentReceiver;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.utils.SMSReceived$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.SMSReceived$register$1", f = "SMSReceived.kt", l = {113}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(u uVar) {
            w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(SMSReceived sMSReceived) {
            sMSReceived.getContext().unregisterReceiver(sMSReceived.getMIntentReceiver());
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = SMSReceived.this.new AnonymousClass1(eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final u uVar = (u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                SMSReceived sMSReceived = SMSReceived.this;
                final SMSReceived sMSReceived2 = SMSReceived.this;
                sMSReceived.setMIntentReceiver(new BroadcastReceiver() { // from class: cu.todus.android.utils.SMSReceived.register.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            SmsMessage[] messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                            y.h(messagesFromIntent, "getMessagesFromIntent(...)");
                            int length = messagesFromIntent.length;
                            String str = "";
                            int i11 = 0;
                            String str2 = "";
                            while (i11 < length) {
                                SmsMessage smsMessage = messagesFromIntent[i11];
                                String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                                y.h(displayOriginatingAddress, "getDisplayOriginatingAddress(...)");
                                str2 = str2 + smsMessage.getMessageBody();
                                i11++;
                                str = displayOriginatingAddress;
                            }
                            if (y.d(str, "toDus")) {
                                String strExtractCode = sMSReceived2.extractCode(a0.O(str2, "\n", "", false, 4, null));
                                if (strExtractCode != null) {
                                    pe.k.d(sMSReceived2.getCoroutineScope(), null, null, new SMSReceived$register$1$1$onReceive$1(uVar, strExtractCode, null), 3, null);
                                }
                            }
                        }
                    }
                });
                if (Build.VERSION.SDK_INT >= 33) {
                    SMSReceived.this.getContext().registerReceiver(SMSReceived.this.getMIntentReceiver(), SMSReceived.this.getIntentFilter(), 2);
                } else {
                    SMSReceived.this.getContext().registerReceiver(SMSReceived.this.getMIntentReceiver(), SMSReceived.this.getIntentFilter());
                }
                final SMSReceived sMSReceived3 = SMSReceived.this;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.utils.l
                    @Override // lb.a
                    public final Object invoke() {
                        return SMSReceived.AnonymousClass1.invokeSuspend$lambda$0(sMSReceived3);
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.label = 1;
                if (s.a(uVar, aVar, this) == objG) {
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
        public final Object invoke(u uVar, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public SMSReceived(Context context) {
        y.i(context, "context");
        this.context = context;
        this.intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        this.coroutineScope = n0.a(d1.b());
    }

    public final String extractCode(String smsBody) {
        y.i(smsBody, "smsBody");
        Matcher matcher = Pattern.compile("\\[(\\d{6})]").matcher(smsBody);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final m0 getCoroutineScope() {
        return this.coroutineScope;
    }

    public final IntentFilter getIntentFilter() {
        return this.intentFilter;
    }

    public final BroadcastReceiver getMIntentReceiver() {
        return this.mIntentReceiver;
    }

    public final String readFromInbox(long afterTime) throws IllegalAccessException, IOException, InvocationTargetException {
        String string;
        String strExtractCode;
        Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, "date DESC");
        if (cursorQuery != null) {
            try {
                int columnIndex = cursorQuery.getColumnIndex("body");
                int columnIndex2 = cursorQuery.getColumnIndex("address");
                int columnIndex3 = cursorQuery.getColumnIndex("date");
                while (cursorQuery.moveToNext()) {
                    String string2 = cursorQuery.getString(columnIndex2);
                    if (string2 != null && (string = cursorQuery.getString(columnIndex)) != null) {
                        long j10 = cursorQuery.getLong(columnIndex3);
                        if (j10 < System.currentTimeMillis() - ((long) 300000) || j10 < afterTime - Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                            break;
                        }
                        if (y.d(string2, "toDus") && (strExtractCode = extractCode(string)) != null) {
                            hb.c.a(cursorQuery, null);
                            return strExtractCode;
                        }
                    }
                }
                k0 k0Var = k0.f43947a;
                hb.c.a(cursorQuery, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    hb.c.a(cursorQuery, th2);
                    throw th3;
                }
            }
        }
        return null;
    }

    public final te.h register() {
        return te.j.e(new AnonymousClass1(null));
    }

    public final void setContext(Context context) {
        y.i(context, "<set-?>");
        this.context = context;
    }

    public final void setIntentFilter(IntentFilter intentFilter) {
        y.i(intentFilter, "<set-?>");
        this.intentFilter = intentFilter;
    }

    public final void setMIntentReceiver(BroadcastReceiver broadcastReceiver) {
        this.mIntentReceiver = broadcastReceiver;
    }

    public final void unRegister() {
        BroadcastReceiver broadcastReceiver = this.mIntentReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
    }
}
