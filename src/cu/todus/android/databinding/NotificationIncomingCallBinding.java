package cu.todus.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cu.todus.android.R;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public final class NotificationIncomingCallBinding implements ViewBinding {

    @NonNull
    public final Button answerCallButton;

    @NonNull
    public final ImageView callerPhoto;

    @NonNull
    public final Button hangUpButton;

    @NonNull
    public final TextView incomingCallNotificationContentText;

    @NonNull
    public final LinearLayout incomingCallNotificationFooter;

    @NonNull
    public final LinearLayout incomingCallNotificationHeader;

    @NonNull
    public final TextView incomingCallNotificationTitle;

    @NonNull
    private final RelativeLayout rootView;

    private NotificationIncomingCallBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull Button button2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.answerCallButton = button;
        this.callerPhoto = imageView;
        this.hangUpButton = button2;
        this.incomingCallNotificationContentText = textView;
        this.incomingCallNotificationFooter = linearLayout;
        this.incomingCallNotificationHeader = linearLayout2;
        this.incomingCallNotificationTitle = textView2;
    }

    @NonNull
    public static NotificationIncomingCallBinding bind(@NonNull View view) {
        int i10 = R.id.answer_call_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i10);
        if (button != null) {
            i10 = R.id.caller_photo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.hang_up_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i10);
                if (button2 != null) {
                    i10 = R.id.incoming_call_notification_content_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.incoming_call_notification_footer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.incoming_call_notification_header;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.incoming_call_notification_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView2 != null) {
                                    return new NotificationIncomingCallBinding((RelativeLayout) view, button, imageView, button2, textView, linearLayout, linearLayout2, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static NotificationIncomingCallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NotificationIncomingCallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.notification_incoming_call, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
