package cu.todus.android.uiCompose.intentReceiver;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.RemoteInput;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.di.MainModule;
import cu.todus.android.domain.handlers.Send;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.SendToParams;
import cu.todus.android.uiCompose.navigation.NavLinks;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.a0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ+\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ+\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ+\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u000fJI\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u001d\u0010\rJ7\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lcu/todus/android/uiCompose/intentReceiver/IntentReceiverActivityIntentHandler;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "", "Lua/k0;", "navigateTo", "Lkotlin/Function0;", "cancel", "actionSend", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;Llb/a;)V", "actionSendText", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "actionSendFile", "actionSendAudio", "actionSendVideo", "actionSendImage", "Lcu/todus/android/uiCompose/main/screen/chat/component/SendToParams;", "params", "", "direct", "uid", "", "type", "goToSendTo", "(Lcu/todus/android/uiCompose/main/screen/chat/component/SendToParams;ZLjava/lang/String;ILkotlin/jvm/functions/Function1;)V", "actionSendMultiple", "processExtras", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntentReceiverActivityIntentHandler {
    public static final int $stable = 0;
    public static final IntentReceiverActivityIntentHandler INSTANCE = new IntentReceiverActivityIntentHandler();

    private IntentReceiverActivityIntentHandler() {
    }

    private final void actionSend(Intent intent, Function1 navigateTo, lb.a cancel) {
        String type = intent.getType();
        if (type != null ? a0.U(type, MediaUtil.TEXT, false, 2, null) : false) {
            actionSendText(intent, navigateTo);
            return;
        }
        String type2 = intent.getType();
        if (type2 != null ? a0.U(type2, MediaUtil.ALL_VIDEO, false, 2, null) : false) {
            actionSendVideo(intent, navigateTo);
            return;
        }
        String type3 = intent.getType();
        if (type3 != null ? a0.U(type3, MediaUtil.ALL_AUDIO, false, 2, null) : false) {
            actionSendAudio(intent, navigateTo);
            return;
        }
        String type4 = intent.getType();
        if (type4 != null ? a0.U(type4, MediaUtil.ALL_IMAGE, false, 2, null) : false) {
            actionSendImage(intent, navigateTo);
            return;
        }
        String type5 = intent.getType();
        if (type5 != null ? a0.U(type5, MediaUtil.ALL_FILES, false, 2, null) : false) {
            actionSendFile(intent, navigateTo);
        } else {
            cancel.invoke();
        }
    }

    private final void actionSendAudio(Intent intent, Function1 navigateTo) {
        String string;
        Bundle extras = intent.getExtras();
        boolean zContainsKey = extras != null ? extras.containsKey("uid") : false;
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string = extras2.getString("uid")) == null) {
            string = "";
        }
        String str = string;
        Bundle extras3 = intent.getExtras();
        int i10 = extras3 != null ? extras3.getInt("type") : -1;
        Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class) : (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            String string2 = uri.toString();
            y.h(string2, "toString(...)");
            goToSendTo(new SendToParams(w.g(new Send(5, string2))), zContainsKey, str, i10, navigateTo);
        }
    }

    private final void actionSendFile(Intent intent, Function1 navigateTo) {
        String string;
        Bundle extras = intent.getExtras();
        boolean zContainsKey = extras != null ? extras.containsKey("uid") : false;
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string = extras2.getString("uid")) == null) {
            string = "";
        }
        String str = string;
        Bundle extras3 = intent.getExtras();
        int i10 = extras3 != null ? extras3.getInt("type") : -1;
        Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class) : (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            String string2 = uri.toString();
            y.h(string2, "toString(...)");
            goToSendTo(new SendToParams(w.g(new Send(6, string2))), zContainsKey, str, i10, navigateTo);
        }
    }

    private final void actionSendImage(Intent intent, Function1 navigateTo) {
        String string;
        Bundle extras = intent.getExtras();
        boolean zContainsKey = extras != null ? extras.containsKey("uid") : false;
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string = extras2.getString("uid")) == null) {
            string = "";
        }
        String str = string;
        Bundle extras3 = intent.getExtras();
        int i10 = extras3 != null ? extras3.getInt("type") : -1;
        Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class) : (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            String string2 = uri.toString();
            y.h(string2, "toString(...)");
            goToSendTo(new SendToParams(w.g(new Send(2, string2))), zContainsKey, str, i10, navigateTo);
        }
    }

    private final void actionSendMultiple(Intent intent, Function1 navigateTo, lb.a cancel) {
        Uri uri;
        ArrayList arrayList = new ArrayList();
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (stringExtra != null) {
            arrayList.add(new Send(1, stringExtra));
        }
        try {
            uri = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class) : (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null) {
            ArrayList parcelableArrayListExtra = Build.VERSION.SDK_INT >= 33 ? intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class) : intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    String string = ((Uri) it.next()).toString();
                    y.h(string, "toString(...)");
                    arrayList.add(new Send(6, string));
                }
            }
        }
        if (uri != null) {
            String string2 = uri.toString();
            y.h(string2, "toString(...)");
            arrayList.add(new Send(6, string2));
        }
        if (arrayList.isEmpty()) {
            cancel.invoke();
            return;
        }
        SendToParams sendToParams = new SendToParams(arrayList);
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = MainModule.INSTANCE.getInstance().getGson().t(sendToParams);
        y.h(strT, "toJson(...)");
        navigateTo.invoke(navLinks.goSendTo(strT));
    }

    private final void actionSendText(Intent intent, Function1 navigateTo) {
        String string;
        String stringExtra;
        Bundle extras = intent.getExtras();
        boolean zContainsKey = extras != null ? extras.containsKey("uid") : false;
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string = extras2.getString("uid")) == null) {
            string = "";
        }
        String str = string;
        Bundle extras3 = intent.getExtras();
        int i10 = extras3 != null ? extras3.getInt("type") : -1;
        Bundle extras4 = intent.getExtras();
        if (extras4 == null || !extras4.containsKey(ChatParams.FROM_DIRECT_REPLY)) {
            stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        } else {
            Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
            stringExtra = String.valueOf(resultsFromIntent != null ? resultsFromIntent.getCharSequence("android.intent.extra.TEXT") : null);
        }
        if (stringExtra != null) {
            INSTANCE.goToSendTo(new SendToParams(w.g(new Send(1, stringExtra))), zContainsKey, str, i10, navigateTo);
        }
    }

    private final void actionSendVideo(Intent intent, Function1 navigateTo) {
        String string;
        Bundle extras = intent.getExtras();
        boolean zContainsKey = extras != null ? extras.containsKey("uid") : false;
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string = extras2.getString("uid")) == null) {
            string = "";
        }
        String str = string;
        Bundle extras3 = intent.getExtras();
        int i10 = extras3 != null ? extras3.getInt("type") : -1;
        Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class) : (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            String string2 = uri.toString();
            y.h(string2, "toString(...)");
            goToSendTo(new SendToParams(w.g(new Send(4, string2))), zContainsKey, str, i10, navigateTo);
        }
    }

    private final void goToSendTo(SendToParams params, boolean direct, String uid, int type, Function1 navigateTo) {
        v5.f gson = MainModule.INSTANCE.getInstance().getGson();
        if (direct) {
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = gson.t(new ChatParams(uid, type, params.getToSend(), 0, 8, null));
            y.h(strT, "toJson(...)");
            navigateTo.invoke(navLinks.goChat(type, strT));
            return;
        }
        NavLinks navLinks2 = NavLinks.INSTANCE;
        String strT2 = gson.t(params);
        y.h(strT2, "toJson(...)");
        navigateTo.invoke(navLinks2.goSendTo(strT2));
    }

    public static /* synthetic */ void goToSendTo$default(IntentReceiverActivityIntentHandler intentReceiverActivityIntentHandler, SendToParams sendToParams, boolean z10, String str, int i10, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i11 & 4) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        intentReceiverActivityIntentHandler.goToSendTo(sendToParams, z11, str2, i10, function1);
    }

    public final void processExtras(Intent intent, Function1 navigateTo, lb.a cancel) {
        y.i(intent, "intent");
        y.i(navigateTo, "navigateTo");
        y.i(cancel, "cancel");
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1173264947) {
                if (action.equals("android.intent.action.SEND")) {
                    actionSend(intent, navigateTo, cancel);
                }
            } else if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                actionSendMultiple(intent, navigateTo, cancel);
            }
        }
    }
}
