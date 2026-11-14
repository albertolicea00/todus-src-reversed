package cu.todus.android.uiCompose.navigation;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.xmpp.XMPPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bJ\n\u0002\u0010\b\n\u0002\b'\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010X\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010Z\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u000e\u0010]\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u000e\u0010_\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010`\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010a\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010b\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010c\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010d\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010e\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010f\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0005J\u000e\u0010i\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010j\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0005J\u000e\u0010k\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010l\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010m\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010n\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010o\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010p\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010q\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010r\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010s\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010t\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010u\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010v\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcu/todus/android/uiCompose/navigation/NavLinks;", "", "<init>", "()V", "WELCOME", "", "VERIFY", "REGISTER", "INIT_INFO_PROFILE", "CONTACTS_PERMISSION", "BANNED_USER", "FIRST_OPEN", "HOME", "LINKED_DEVICE", "CHAT_P2P", "CHAT_GROUP", "CHAT_CHANNEL", "CHAT_CARD", "FORWARD_TO", "OPEN_WITH", "PREVIEW_P2P", "PREVIEW_CARD", "MAP", "PREVIEW_GROUP", "PREVIEW_CHANNEL", "PREVIEW_ADMINS_CHANNEL", "DATE_EDITOR", "CREATE_GROUP_STEP1_SELECTION", "CREATE_GROUP_STEP2_CONFIGURATION", "SEND_TO", "JOIN_ROOM", "PUB_EDITOR", "CREATE_CHANNEL", "QR_READER", "QR_VIEWER", "SETTING", "SECRET_ROOMS", "SECRET_ROOM_ACCESS", "MUTED_ROOMS", "BLOCKED", "EDIT_PROFILE", "SEARCH", "DATA_PREFERENCES", "MANAGE_STICKERS", "PREVIEW_SUBSCRIBERS", "NEAR", "ABOUT", "NEWS", "CATALOGUE_CHECK_IN", "MY_CATALOGUE", "CATALOGUE", "CATALOGUE_FORM", "EDIT_TODUS_ID", "PRODUCT_PREVIEW", "THEME_SELECTOR", "STATUS_EDITOR", "STATUS_LIST", "PRIVACY", "STATUS_PREVIEW", "PLAYER", "BATTERY_PREFERENCE", "REACT_SELECTION", "STREAMING_CONFIG", "STREAMING", "PREVIEW_ADMINS_GROUP", "MANAGE_BACKUP", "LOGOUT", "CHAT_RESOURCES", "LOADING", "SOCIAL_PROFILE", "REQUEST_ROOMS", "PRESENT", "CALL", "CATALOGUE_WEB", "SEARCH_USER", "encode", AppMeasurementSdk.ConditionalUserProperty.VALUE, "decode", "goChat", "type", "", "params", "goPreview", "uid", "goChatP2P", "goChatGroup", "goChatChannel", "goChatCard", "goPreviewP2P", "goMap", "goForwardTo", "goPreviewGroup", "goPreviewChannel", "goPreviewAdminChannel", "goPreviewCard", "goDateEditor", "goCreateGroupStep1", "goCreateGroupStep2", "goSendTo", "goJoinRoom", "goQrViewer", "goPreviewSubscribers", "goPubEditor", "goCatalogueCheckIn", User.COLUMN_TODUS_ID, "goCatalogueForm", "goCatalogue", "goProductPreview", "goStatusPreview", "goManageStickers", "goStreamingConfig", "goStreaming", "goPreviewAdminGroup", "goChatResources", "goSocialProfile", "goStatusEditor", "goPresent", "goCatalogueWeb", "goSearchUser", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NavLinks {
    public static final int $stable = 0;
    public static final String ABOUT = "about";
    public static final String BANNED_USER = "banned_user";
    public static final String BATTERY_PREFERENCE = "battery_preference";
    public static final String BLOCKED = "blocked";
    public static final String CALL = "call";
    public static final String CATALOGUE = "catalogue/{params}";
    public static final String CATALOGUE_CHECK_IN = "catalogue_check_in/{params}";
    public static final String CATALOGUE_FORM = "catalogue_form/{params}";
    public static final String CATALOGUE_WEB = "catalogue_web/{params}";
    public static final String CHAT_CARD = "chat_card/{params}";
    public static final String CHAT_CHANNEL = "chat_channel/{params}";
    public static final String CHAT_GROUP = "chat_group/{params}";
    public static final String CHAT_P2P = "chat_p2p/{params}";
    public static final String CHAT_RESOURCES = "chat_resources/{params}";
    public static final String CONTACTS_PERMISSION = "contacts_permission";
    public static final String CREATE_CHANNEL = "create_channel";
    public static final String CREATE_GROUP_STEP1_SELECTION = "create_group_step1_selection/{params}";
    public static final String CREATE_GROUP_STEP2_CONFIGURATION = "create_group_step2_configuration/{params}";
    public static final String DATA_PREFERENCES = "data_preferences";
    public static final String DATE_EDITOR = "date_editor/{params}";
    public static final String EDIT_PROFILE = "edit_profile";
    public static final String EDIT_TODUS_ID = "edit_todus_id";
    public static final String FIRST_OPEN = "first_open";
    public static final String FORWARD_TO = "forward_to/{params}";
    public static final String HOME = "home";
    public static final String INIT_INFO_PROFILE = "init_info_profile";
    public static final NavLinks INSTANCE = new NavLinks();
    public static final String JOIN_ROOM = "join_room/{params}";
    public static final String LINKED_DEVICE = "linked_device";
    public static final String LOADING = "loading";
    public static final String LOGOUT = "logout";
    public static final String MANAGE_BACKUP = "manage_backup";
    public static final String MANAGE_STICKERS = "manage_stickers/{params}";
    public static final String MAP = "map/{params}";
    public static final String MUTED_ROOMS = "muted_rooms";
    public static final String MY_CATALOGUE = "my_catalogue";
    public static final String NEAR = "near";
    public static final String NEWS = "news";
    public static final String OPEN_WITH = "open_with";
    public static final String PLAYER = "player";
    public static final String PRESENT = "present/{params}";
    public static final String PREVIEW_ADMINS_CHANNEL = "preview_admins_channel/{params}";
    public static final String PREVIEW_ADMINS_GROUP = "preview_admins_group/{params}";
    public static final String PREVIEW_CARD = "preview_card/{params}";
    public static final String PREVIEW_CHANNEL = "preview_channel/{params}";
    public static final String PREVIEW_GROUP = "preview_group/{params}";
    public static final String PREVIEW_P2P = "preview_p2p/{params}";
    public static final String PREVIEW_SUBSCRIBERS = "preview_subscribers/{params}";
    public static final String PRIVACY = "privacy";
    public static final String PRODUCT_PREVIEW = "product_preview/{params}";
    public static final String PUB_EDITOR = "pub_editor/{params}";
    public static final String QR_READER = "qr_reader";
    public static final String QR_VIEWER = "qr_viewer/{params}";
    public static final String REACT_SELECTION = "react_selection";
    public static final String REGISTER = "register";
    public static final String REQUEST_ROOMS = "request_rooms";
    public static final String SEARCH = "search";
    public static final String SEARCH_USER = "search_user/{params}";
    public static final String SECRET_ROOMS = "secret_rooms"; // pragma: allowlist secret
    public static final String SECRET_ROOM_ACCESS = "secret_room_access"; // pragma: allowlist secret
    public static final String SEND_TO = "send_to/{params}";
    public static final String SETTING = "setting";
    public static final String SOCIAL_PROFILE = "social_profile/{params}";
    public static final String STATUS_EDITOR = "status_editor/{params}";
    public static final String STATUS_LIST = "status_list";
    public static final String STATUS_PREVIEW = "status_preview/{params}";
    public static final String STREAMING = "streaming/{params}";
    public static final String STREAMING_CONFIG = "streaming_config/{params}";
    public static final String THEME_SELECTOR = "theme_selector";
    public static final String VERIFY = "verify";
    public static final String WELCOME = "welcome";

    private NavLinks() {
    }

    private final String goChatCard(String params) {
        return "chat_card/" + encode(params);
    }

    private final String goChatChannel(String params) {
        return "chat_channel/" + encode(params);
    }

    private final String goChatGroup(String params) {
        return "chat_group/" + encode(params);
    }

    private final String goChatP2P(String params) {
        return "chat_p2p/" + encode(params);
    }

    private final String goPreviewCard(String uid) {
        return "preview_card/" + encode(uid);
    }

    private final String goPreviewChannel(String uid) {
        return "preview_channel/" + encode(uid);
    }

    private final String goPreviewGroup(String uid) {
        return "preview_group/" + encode(uid);
    }

    private final String goPreviewP2P(String uid) {
        return "preview_p2p/" + encode(uid);
    }

    public final String decode(String value) {
        y.i(value, "value");
        String strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, value, 0, 2, null);
        return strDecodedMessage$default == null ? "" : strDecodedMessage$default;
    }

    public final String encode(String value) {
        y.i(value, "value");
        return Base64Util.encodedMessage$default(Base64Util.INSTANCE, value, 0, 2, (Object) null);
    }

    public final String goCatalogue(String toDusId) {
        y.i(toDusId, "toDusId");
        return "catalogue/" + encode(toDusId);
    }

    public final String goCatalogueCheckIn(String toDusId) {
        y.i(toDusId, "toDusId");
        return "catalogue_check_in/" + encode(toDusId);
    }

    public final String goCatalogueForm(String params) {
        y.i(params, "params");
        return "catalogue_form/" + encode(params);
    }

    public final String goCatalogueWeb(String params) {
        y.i(params, "params");
        return "catalogue_web/" + encode(params);
    }

    public final String goChat(int type, String params) {
        y.i(params, "params");
        if (type == 1) {
            return goChatGroup(params);
        }
        if (type != 2) {
            return type != 3 ? goChatP2P(params) : goChatCard(params);
        }
        return goChatChannel(params);
    }

    public final String goChatResources(String uid) {
        y.i(uid, "uid");
        return "chat_resources/" + encode(uid);
    }

    public final String goCreateGroupStep1(String params) {
        y.i(params, "params");
        return "create_group_step1_selection/" + encode(params);
    }

    public final String goCreateGroupStep2(String params) {
        y.i(params, "params");
        return "create_group_step2_configuration/" + encode(params);
    }

    public final String goDateEditor(String params) {
        y.i(params, "params");
        return "date_editor/" + encode(params);
    }

    public final String goForwardTo(String params) {
        y.i(params, "params");
        return "forward_to/" + encode(params);
    }

    public final String goJoinRoom(String uid) {
        y.i(uid, "uid");
        return "join_room/" + encode(uid);
    }

    public final String goManageStickers(String params) {
        y.i(params, "params");
        return "manage_stickers/" + encode(params);
    }

    public final String goMap(String params) {
        y.i(params, "params");
        return "map/" + encode(params);
    }

    public final String goPresent(String params) {
        y.i(params, "params");
        return "present/" + encode(params);
    }

    public final String goPreview(String uid) {
        y.i(uid, "uid");
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        if (xMPPUtils.isMUC(uid)) {
            return goPreviewGroup(uid);
        }
        if (xMPPUtils.isCard(uid)) {
            return goPreviewCard(uid);
        }
        return xMPPUtils.isChannel(uid) ? goPreviewChannel(uid) : goPreviewP2P(uid);
    }

    public final String goPreviewAdminChannel(String params) {
        y.i(params, "params");
        return "preview_admins_channel/" + encode(params);
    }

    public final String goPreviewAdminGroup(String params) {
        y.i(params, "params");
        return "preview_admins_group/" + encode(params);
    }

    public final String goPreviewSubscribers(String uid) {
        y.i(uid, "uid");
        return "preview_subscribers/" + encode(uid);
    }

    public final String goProductPreview(String params) {
        y.i(params, "params");
        return "product_preview/" + encode(params);
    }

    public final String goPubEditor(String uid) {
        y.i(uid, "uid");
        return "pub_editor/" + encode(uid);
    }

    public final String goQrViewer(String params) {
        y.i(params, "params");
        return "qr_viewer/" + encode(params);
    }

    public final String goSearchUser(String params) {
        y.i(params, "params");
        return "search_user/" + encode(params);
    }

    public final String goSendTo(String params) {
        y.i(params, "params");
        return "send_to/" + encode(params);
    }

    public final String goSocialProfile(String uid) {
        y.i(uid, "uid");
        return "social_profile/" + encode(uid);
    }

    public final String goStatusEditor(String params) {
        y.i(params, "params");
        return "status_editor/" + encode(params);
    }

    public final String goStatusPreview(String params) {
        y.i(params, "params");
        return "status_preview/" + encode(params);
    }

    public final String goStreaming(String params) {
        y.i(params, "params");
        return "streaming/" + encode(params);
    }

    public final String goStreamingConfig(String params) {
        y.i(params, "params");
        return "streaming_config/" + encode(params);
    }
}
