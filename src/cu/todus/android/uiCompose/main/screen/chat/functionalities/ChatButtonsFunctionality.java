package cu.todus.android.uiCompose.main.screen.chat.functionalities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.ButtonTemplate;
import cu.todus.android.di.MainModule;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.xmpp.extension.button.ExtensionButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008f\u0001\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000e2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/functionalities/ChatButtonsFunctionality;", "", "<init>", "()V", "Lcu/todus/android/data/db/pojo/content/ButtonContent;", "buttonContent", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lua/k0;", "sendMessage", "navigateTo", "setOnTyping", "Lkotlin/Function3;", "Lcu/todus/android/data/db/pojo/content/ButtonTemplate;", "", "setPlaceholderData", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "saveNewShortCut", "handleClick", "(Lcu/todus/android/data/db/pojo/content/ButtonContent;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChatButtonsFunctionality {
    public static final int $stable = 0;
    public static final ChatButtonsFunctionality INSTANCE = new ChatButtonsFunctionality();

    private ChatButtonsFunctionality() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 handleClick$lambda$0(BotShortcut it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    public final void handleClick(ButtonContent buttonContent, Context context, Function1 sendMessage, Function1 navigateTo, Function1 setOnTyping, Function3 setPlaceholderData, Function1 saveNewShortCut) {
        y.i(buttonContent, "buttonContent");
        y.i(context, "context");
        y.i(sendMessage, "sendMessage");
        y.i(navigateTo, "navigateTo");
        y.i(setOnTyping, "setOnTyping");
        y.i(setPlaceholderData, "setPlaceholderData");
        y.i(saveNewShortCut, "saveNewShortCut");
        String msgCmd = buttonContent.getMsgCmd();
        switch (msgCmd.hashCode()) {
            case -2135445703:
                if (msgCmd.equals(ExtensionButton.CMD_PLACEHOLDER_SEND)) {
                    ButtonTemplate buttonTemplate = (ButtonTemplate) MainModule.INSTANCE.getInstance().getGson().j(buttonContent.getMsgContent(), ButtonTemplate.class);
                    Object btnTitle = buttonContent.getBtnTitle();
                    y.f(buttonTemplate);
                    setPlaceholderData.invoke(btnTitle, buttonTemplate, Boolean.valueOf(buttonTemplate.getAutoSend()));
                    break;
                }
                break;
            case -1402474231:
                if (msgCmd.equals(ExtensionButton.CMD_ADD_SHORTCUT)) {
                    break;
                }
                break;
            case -1347954281:
                if (msgCmd.equals(ExtensionButton.CMD_COPY_TO_CLIPBOARD)) {
                    Object systemService = context.getSystemService("clipboard");
                    y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("msg", buttonContent.getMsgContent()));
                    break;
                }
                break;
            case -1290183356:
                if (msgCmd.equals(ExtensionButton.CMD_OPEN_WEB)) {
                    IntentUtil.INSTANCE.showWeb(context, buttonContent.getMsgContent());
                    break;
                }
                break;
            case -609315080:
                msgCmd.equals(ExtensionButton.CMD_PLACEHOLDER_CONTACT_SEND);
                break;
            case 353132014:
                if (msgCmd.equals(ExtensionButton.CMD_PLACEHOLDER)) {
                    setOnTyping.invoke(buttonContent.getMsgContent());
                    break;
                }
                break;
            case 774581338:
                if (msgCmd.equals(ExtensionButton.CMD_OPEN_APP_SCREEN)) {
                    navigateTo.invoke(buttonContent.getMsgContent());
                    break;
                }
                break;
            case 1926899880:
                if (msgCmd.equals(ExtensionButton.CMD_TYPE_SEND)) {
                    sendMessage.invoke(buttonContent.getMsgContent());
                    break;
                }
                break;
        }
    }
}
