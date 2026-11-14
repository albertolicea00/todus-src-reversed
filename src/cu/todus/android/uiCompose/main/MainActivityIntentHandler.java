package cu.todus.android.uiCompose.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import cu.todus.android.notification.SystemNotificationExecutor;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcu/todus/android/uiCompose/main/MainActivityIntentHandler;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "", "Lua/k0;", "navigateTo", "actionClick", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "processExtras", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;Lab/e;)Ljava/lang/Object;", MainActivityIntentHandler.ACTION_SSL_TIME_ERROR, "Ljava/lang/String;", MainActivityIntentHandler.ACTION_BANNED_USER, "INTENT_TAG", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainActivityIntentHandler {
    public static final int $stable = 0;
    public static final String ACTION_BANNED_USER = "ACTION_BANNED_USER";
    public static final String ACTION_SSL_TIME_ERROR = "ACTION_SSL_TIME_ERROR";
    public static final MainActivityIntentHandler INSTANCE = new MainActivityIntentHandler();
    private static final String INTENT_TAG = "RECEIVING_INTENT";

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.MainActivityIntentHandler$processExtras$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.MainActivityIntentHandler", f = "MainActivityIntentHandler.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 137}, m = "processExtras", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivityIntentHandler.this.processExtras(null, null, this);
        }
    }

    private MainActivityIntentHandler() {
    }

    private final void actionClick(Intent intent, Function1 navigateTo) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey(SystemNotificationExecutor.ACTION) && (string = extras.getString(SystemNotificationExecutor.ACTION)) != null && string.hashCode() == 187677646 && string.equals(SystemNotificationExecutor.OPEN_CHAT)) {
            String string2 = extras.getString("id");
            if (string2 == null) {
                string2 = "";
            }
            int i10 = extras.getInt(SystemNotificationExecutor.ROOM_TYPE);
            ChatParams chatParams = new ChatParams(string2, i10, null, 0, 12, null);
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = new v5.f().t(chatParams);
            y.h(strT, "toJson(...)");
            navigateTo.invoke(navLinks.goChat(i10, strT));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cb, code lost:
    
        if (r1.setAppState(r11, r2) == r4) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processExtras(android.content.Intent r21, kotlin.jvm.functions.Function1 r22, ab.e<? super ua.k0> r23) throws cu.z17.singledi.SinglediException {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.MainActivityIntentHandler.processExtras(android.content.Intent, kotlin.jvm.functions.Function1, ab.e):java.lang.Object");
    }
}
