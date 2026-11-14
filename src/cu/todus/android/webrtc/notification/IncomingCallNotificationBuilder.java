package cu.todus.android.webrtc.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.HtmlCompat;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import androidx.media3.exoplayer.offline.l;
import cu.todus.android.R;
import cu.todus.android.image.ImageLoader;
import cu.todus.android.notification.SystemNotificationExecutor;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.uiCompose.call.CallParams;
import cu.todus.android.uiCompose.main.MainActivity;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.utils.ColorGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\r\u0010\fJ1\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\fJ/\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcu/todus/android/webrtc/notification/IncomingCallNotificationBuilder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "id", "name", "image", "Landroid/app/Notification;", "incomingCallNotificationView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Notification;", "incomingCallNotificationView12", "", "isVideoCall", "incomingCallNotificationViewNew", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/app/Notification;", "incomingCallNotificationView12New", "Lua/k0;", "createNotificationChannel", "()V", "build", "buildNew", "Landroid/content/Context;", "", "vibrationPattern", "[J", "Landroid/net/Uri;", "soundUri", "Landroid/net/Uri;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IncomingCallNotificationBuilder {
    private static final int INCOMING_CALL_ANSWER_REQUEST_ID = 2200;
    public static final int INCOMING_CALL_HANG_UP_REQUEST_ID = 1100;
    public static final int INCOMING_CALL_REQUEST_ID = 11;
    public static final String NOTIFICATION_CALL_CHANEL_ID = "INCOMING_CALL_NOTIFICATION_CHANEL_ID";
    private final Context context;
    private Uri soundUri;
    private final long[] vibrationPattern;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcu/todus/android/webrtc/notification/IncomingCallNotificationBuilder$Companion;", "", "<init>", "()V", "NOTIFICATION_CALL_CHANEL_ID", "", "INCOMING_CALL_REQUEST_ID", "", "INCOMING_CALL_HANG_UP_REQUEST_ID", "INCOMING_CALL_ANSWER_REQUEST_ID", "getActionTextNew", "Landroid/text/Spanned;", "context", "Landroid/content/Context;", "isVideoCall", "", "getActionText", "stringRes", "colorRes", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final Spanned getActionText(Context context, @StringRes int stringRes, @ColorRes int colorRes) {
            y.i(context, "context");
            SpannableString spannableString = new SpannableString(context.getText(stringRes));
            if (Build.VERSION.SDK_INT >= 25) {
                spannableString.setSpan(new ForegroundColorSpan(context.getColor(colorRes)), 0, spannableString.length(), 0);
            }
            Spanned spannedFromHtml = HtmlCompat.fromHtml("<font color=\"" + ContextCompat.getColor(context, colorRes) + "\">" + context.getString(stringRes) + "</font>", 0);
            y.h(spannedFromHtml, "fromHtml(...)");
            return spannedFromHtml;
        }

        public final Spanned getActionTextNew(Context context, boolean isVideoCall) {
            y.i(context, "context");
            return getActionText(context, isVideoCall ? R.string.accept_video_call : R.string.accept_audio_call, R.color.green);
        }

        private Companion() {
        }
    }

    public IncomingCallNotificationBuilder(Context context) {
        y.i(context, "context");
        this.context = context;
        this.vibrationPattern = new long[]{1000, 1000};
        this.soundUri = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
    }

    public static /* synthetic */ Notification buildNew$default(IncomingCallNotificationBuilder incomingCallNotificationBuilder, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return incomingCallNotificationBuilder.buildNew(str, str2, str3, z10);
    }

    private final Notification incomingCallNotificationView(String id2, String name, String image) {
        Intent intent = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent.putExtra("uid", id2);
        intent.setAction(CallIntentReceiver.ACTION_HANG_UP);
        Context context = this.context;
        SystemNotificationExecutor.Companion companion = SystemNotificationExecutor.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, INCOMING_CALL_HANG_UP_REQUEST_ID, intent, companion.retrieveFlags());
        Companion companion2 = INSTANCE;
        NotificationCompat.Action action = new NotificationCompat.Action((IconCompat) null, companion2.getActionText(this.context, R.string.hang_up, R.color.colorPrimary), broadcast);
        Intent intent2 = new Intent(this.context, (Class<?>) CallActivity.class);
        Bundle bundle = new Bundle();
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CallParams(id2, false, 2, null));
        y.h(strT, "toJson(...)");
        bundle.putString(CallActivity.CALL_PARAMS_KEY, navLinks.encode(strT));
        intent2.putExtras(bundle);
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder((IconCompat) null, companion2.getActionText(this.context, R.string.answer, R.color.green), PendingIntent.getActivity(this.context, 0, intent2, 67108864)).build();
        y.h(actionBuild, "build(...)");
        Bitmap circleImage$default = ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, image, name, ColorGenerator.INSTANCE.getMATERIAL().getColor(name), false, 16, null);
        IconCompat iconCompatCreateWithBitmap = IconCompat.createWithBitmap(circleImage$default);
        y.h(iconCompatCreateWithBitmap, "createWithBitmap(...)");
        PendingIntent activity = PendingIntent.getActivity(this.context, 11, new Intent(this.context, (Class<?>) MainActivity.class), companion.retrieveFlags());
        Person personBuild = new Person.Builder().setIcon(iconCompatCreateWithBitmap).setName(name).setImportant(true).build();
        y.h(personBuild, "build(...)");
        Notification notificationBuild = new NotificationCompat.Builder(this.context, NOTIFICATION_CALL_CHANEL_ID).setSmallIcon(R.drawable.icon).setPriority(1).setOngoing(true).setCategory("call").setContentIntent(activity).setSound(this.soundUri).setVibrate(this.vibrationPattern).setDefaults(4).setCategory("call").addAction(action).addAction(actionBuild).setContentTitle(this.context.getString(R.string.call_from)).setContentText(name).setLargeIcon(circleImage$default).addPerson(personBuild).build();
        y.h(notificationBuild, "build(...)");
        notificationBuild.flags = 4;
        return notificationBuild;
    }

    @RequiresApi(31)
    private final Notification incomingCallNotificationView12(String id2, String name, String image) {
        Intent intent = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent.putExtra("uid", id2);
        intent.setAction(CallIntentReceiver.ACTION_HANG_UP);
        Context context = this.context;
        SystemNotificationExecutor.Companion companion = SystemNotificationExecutor.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, INCOMING_CALL_HANG_UP_REQUEST_ID, intent, companion.retrieveFlags());
        PendingIntent activity = PendingIntent.getActivity(this.context, INCOMING_CALL_ANSWER_REQUEST_ID, new Intent(this.context, (Class<?>) CallActivity.class), companion.retrieveFlags());
        Icon iconCreateWithBitmap = Icon.createWithBitmap(ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, image, name, ColorGenerator.INSTANCE.getMATERIAL().getColor(name), false, 16, null));
        y.h(iconCreateWithBitmap, "createWithBitmap(...)");
        android.app.Person personBuild = g.a().setIcon(iconCreateWithBitmap).setName(name).setImportant(true).build();
        y.h(personBuild, "build(...)");
        Notification.CallStyle callStyleForIncomingCall = Notification.CallStyle.forIncomingCall(personBuild, broadcast, activity);
        y.h(callStyleForIncomingCall, "forIncomingCall(...)");
        PendingIntent activity2 = PendingIntent.getActivity(this.context, 0, new Intent(this.context, (Class<?>) CallActivity.class), 167772160);
        h.a();
        Notification.Builder fullScreenIntent = l.a(this.context, NOTIFICATION_CALL_CHANEL_ID).setContentIntent(activity2).setSmallIcon(R.drawable.icon).setContentTitle(this.context.getString(R.string.call)).setStyle(callStyleForIncomingCall).addPerson(personBuild).setCategory("call").setFullScreenIntent(activity2, true);
        y.h(fullScreenIntent, "setFullScreenIntent(...)");
        Notification notificationBuild = fullScreenIntent.build();
        y.h(notificationBuild, "build(...)");
        return notificationBuild;
    }

    @RequiresApi(31)
    private final Notification incomingCallNotificationView12New(String id2, String name, String image, boolean isVideoCall) {
        Intent intent = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent.putExtra("uid", id2);
        intent.setAction(CallIntentReceiver.ACTION_HANG_UP);
        Context context = this.context;
        SystemNotificationExecutor.Companion companion = SystemNotificationExecutor.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, INCOMING_CALL_HANG_UP_REQUEST_ID, intent, companion.retrieveFlags());
        Companion companion2 = INSTANCE;
        Notification.Action action = new Notification.Action(0, companion2.getActionText(this.context, R.string.hang_up, R.color.colorPrimary), broadcast);
        Intent intent2 = new Intent(this.context, (Class<?>) CallActivity.class);
        Bundle bundle = new Bundle();
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CallParams(id2, isVideoCall));
        y.h(strT, "toJson(...)");
        bundle.putString(CallActivity.CALL_PARAMS_KEY, navLinks.encode(strT));
        intent2.putExtras(bundle);
        Intent intent3 = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent3.putExtra("uid", id2);
        intent3.putExtra("isVideoCall", isVideoCall);
        intent3.setAction(CallIntentReceiver.ACTION_ANSWER_WITH_TYPE);
        Notification.Action action2 = new Notification.Action(0, companion2.getActionTextNew(this.context, isVideoCall), PendingIntent.getBroadcast(this.context, id2.hashCode() + 3000, intent3, companion.retrieveFlags()));
        Bitmap circleImage$default = ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, image, name, ColorGenerator.INSTANCE.getMATERIAL().getColor(name), false, 16, null);
        Icon iconCreateWithBitmap = Icon.createWithBitmap(circleImage$default);
        y.h(iconCreateWithBitmap, "createWithBitmap(...)");
        PendingIntent activity = PendingIntent.getActivity(this.context, 11, new Intent(this.context, (Class<?>) MainActivity.class), companion.retrieveFlags());
        android.app.Person personBuild = g.a().setIcon(iconCreateWithBitmap).setName(name).setImportant(true).build();
        y.h(personBuild, "build(...)");
        String string = isVideoCall ? this.context.getString(R.string.video_call_from) : this.context.getString(R.string.call_from);
        y.f(string);
        h.a();
        Notification.Builder builderAddPerson = l.a(this.context, NOTIFICATION_CALL_CHANEL_ID).setSmallIcon(R.drawable.icon).setContentIntent(activity).setSound(this.soundUri).setVibrate(this.vibrationPattern).setCategory("call").addAction(action).addAction(action2).setContentTitle(string).setContentText(name).setLargeIcon(circleImage$default).addPerson(personBuild);
        y.h(builderAddPerson, "addPerson(...)");
        Notification notificationBuild = builderAddPerson.build();
        y.h(notificationBuild, "build(...)");
        return notificationBuild;
    }

    public static /* synthetic */ Notification incomingCallNotificationView12New$default(IncomingCallNotificationBuilder incomingCallNotificationBuilder, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return incomingCallNotificationBuilder.incomingCallNotificationView12New(str, str2, str3, z10);
    }

    private final Notification incomingCallNotificationViewNew(String id2, String name, String image, boolean isVideoCall) {
        Intent intent = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent.putExtra("uid", id2);
        intent.setAction(CallIntentReceiver.ACTION_HANG_UP);
        Context context = this.context;
        SystemNotificationExecutor.Companion companion = SystemNotificationExecutor.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, INCOMING_CALL_HANG_UP_REQUEST_ID, intent, companion.retrieveFlags());
        Companion companion2 = INSTANCE;
        NotificationCompat.Action action = new NotificationCompat.Action((IconCompat) null, companion2.getActionText(this.context, R.string.hang_up, R.color.colorPrimary), broadcast);
        Intent intent2 = new Intent(this.context, (Class<?>) CallActivity.class);
        Bundle bundle = new Bundle();
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CallParams(id2, isVideoCall));
        y.h(strT, "toJson(...)");
        bundle.putString(CallActivity.CALL_PARAMS_KEY, navLinks.encode(strT));
        intent2.putExtras(bundle);
        Intent intent3 = new Intent(this.context, (Class<?>) CallIntentReceiver.class);
        intent3.putExtra("uid", id2);
        intent3.putExtra("isVideoCall", isVideoCall);
        intent3.setAction(CallIntentReceiver.ACTION_ANSWER_WITH_TYPE);
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder((IconCompat) null, companion2.getActionTextNew(this.context, isVideoCall), PendingIntent.getBroadcast(this.context, id2.hashCode() + 3000, intent3, companion.retrieveFlags())).build();
        y.h(actionBuild, "build(...)");
        Bitmap circleImage$default = ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, image, name, ColorGenerator.INSTANCE.getMATERIAL().getColor(name), false, 16, null);
        IconCompat iconCompatCreateWithBitmap = IconCompat.createWithBitmap(circleImage$default);
        y.h(iconCompatCreateWithBitmap, "createWithBitmap(...)");
        PendingIntent activity = PendingIntent.getActivity(this.context, 11, new Intent(this.context, (Class<?>) MainActivity.class), companion.retrieveFlags());
        Person personBuild = new Person.Builder().setIcon(iconCompatCreateWithBitmap).setName(name).setImportant(true).build();
        y.h(personBuild, "build(...)");
        String string = isVideoCall ? this.context.getString(R.string.video_call_from) : this.context.getString(R.string.call_from);
        y.f(string);
        Notification notificationBuild = new NotificationCompat.Builder(this.context, NOTIFICATION_CALL_CHANEL_ID).setSmallIcon(R.drawable.icon).setPriority(1).setOngoing(true).setCategory("call").setContentIntent(activity).setSound(this.soundUri).setVibrate(this.vibrationPattern).setDefaults(4).setCategory("call").addAction(action).addAction(actionBuild).setContentTitle(string).setContentText(name).setLargeIcon(circleImage$default).addPerson(personBuild).build();
        y.h(notificationBuild, "build(...)");
        notificationBuild.flags = 4;
        return notificationBuild;
    }

    public static /* synthetic */ Notification incomingCallNotificationViewNew$default(IncomingCallNotificationBuilder incomingCallNotificationBuilder, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return incomingCallNotificationBuilder.incomingCallNotificationViewNew(str, str2, str3, z10);
    }

    public final Notification build(String id2, String name, String image) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        return Build.VERSION.SDK_INT >= 31 ? incomingCallNotificationView12(id2, name, image) : incomingCallNotificationView(id2, name, image);
    }

    public final Notification buildNew(String id2, String name, String image, boolean isVideoCall) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        return Build.VERSION.SDK_INT >= 31 ? incomingCallNotificationView12New(id2, name, image, isVideoCall) : incomingCallNotificationViewNew(id2, name, image, isVideoCall);
    }

    @RequiresApi(26)
    public final void createNotificationChannel() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.context, 1);
        k.a();
        NotificationChannel notificationChannelA = j.a(NOTIFICATION_CALL_CHANEL_ID, this.context.getString(R.string.call), 4);
        notificationChannelA.setDescription(this.context.getString(R.string.call_notification));
        notificationChannelA.setVibrationPattern(new long[]{1000, 1000});
        notificationChannelA.enableVibration(true);
        notificationChannelA.setSound(actualDefaultRingtoneUri, new AudioAttributes.Builder().setUsage(6).build());
        notificationChannelA.enableLights(true);
        notificationChannelA.setShowBadge(true);
        notificationChannelA.setLockscreenVisibility(1);
        notificationChannelA.setImportance(4);
        NotificationManager notificationManager = (NotificationManager) this.context.getSystemService(NotificationManager.class);
        y.f(notificationManager);
        notificationManager.createNotificationChannel(notificationChannelA);
    }
}
