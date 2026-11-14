package cu.todus.android.constants;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import db.a;
import db.b;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import ua.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005¨\u0006\u0017"}, d2 = {"Lcu/todus/android/constants/Service;", "", "<init>", "()V", "provideAuthUrl", "", "environment", "Lcu/todus/android/constants/Service$ApplicationEnvironment;", "provideClientUrl", "provideChatUrl", "provideIMUrl", "provideIMPort", "", "provideS3Url", "provideStickersUrl", "provideCatalogueUrl", "provideLinkedDeviceUrl", "isToDusUrl", "", TypedValues.Custom.S_STRING, "ApplicationEnvironment", "Config", "Endpoint", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Service {
    public static final int $stable = 0;
    public static final Service INSTANCE = new Service();

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/constants/Service$ApplicationEnvironment;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "PROD_2", "PROD", "F5", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum ApplicationEnvironment {
        LOCAL,
        PROD_2,
        PROD,
        F5;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcu/todus/android/constants/Service$Config;", "", "<init>", "()V", "STICKERS_OFFICIAL", "", "SERVER_DOMAIN", "SERVER_NAME_CHANNELS", "SERVER_NAME_MUC", "MUC_LIGHT_SERVICE_NAME", "CHANNEL_SERVICE_NAME", "MAX_MSG_TEXT_SIZE", "", "MAX_MESSAGE_LENGTH", "COUNTER_VISIBLE_THRESHOLD", "STATUS_NAMESPACE", "STATUS_RECEPTOR", "REACTION_NAMESPACE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        public static final int $stable = 0;
        public static final String CHANNEL_SERVICE_NAME = "ch.im.todus.cu";
        public static final int COUNTER_VISIBLE_THRESHOLD = 200;
        public static final Config INSTANCE = new Config();
        public static final int MAX_MESSAGE_LENGTH = 65536;
        public static final int MAX_MSG_TEXT_SIZE = 8192;
        public static final String MUC_LIGHT_SERVICE_NAME = "muclight.im.todus.cu";
        public static final String REACTION_NAMESPACE = "reaction";
        public static final String SERVER_DOMAIN = "im.todus.cu";
        public static final String SERVER_NAME_CHANNELS = "ch";
        public static final String SERVER_NAME_MUC = "muclight";
        public static final String STATUS_NAMESPACE = "status";
        public static final String STATUS_RECEPTOR = "status@status.im.todus.cu";
        public static final String STICKERS_OFFICIAL = "stickers.todus.cu";

        private Config() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcu/todus/android/constants/Service$Endpoint;", "", "<init>", "()V", "GET_INFO", "", "GET_INFO_OR_ERROR", "SUBSCRIBE", "UN_SUBSCRIBE", "USERS_RESERVE", "USERS_REGISTER", "TOKEN", "CHECK", "LINK_INFO", "UPDATE_PROFILE", "LATEST", "LATEST_BETA", "REPORT", "LOGOUT_LINKED_DEVICE", "LINKED_DEVICES_LIST", "PACKS", "PACK_INFO", "VERSION", "SHOP", "MY_SHOP", "GET_PRODUCT", "ADD_PRODUCT", "UPDATE_PRODUCT", "DELETE_PRODUCT", "SHARE_PRODUCT", "SHARE_CATALOG", "REQUEST_PRODUCT", "SEARCH_TAGS", "SEARCH_PRODUCT_BY_TAG", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Endpoint {
        public static final int $stable = 0;
        public static final String ADD_PRODUCT = "product";
        public static final String CHECK = "v2/auth/check";
        public static final String DELETE_PRODUCT = "product/{id}";
        public static final String GET_INFO = "card/info/{uid}";
        public static final String GET_INFO_OR_ERROR = "info/{uid}";
        public static final String GET_PRODUCT = "product/{todus_id}/{id}";
        public static final Endpoint INSTANCE = new Endpoint();
        public static final String LATEST = "todus/release/rel/latest";
        public static final String LATEST_BETA = "todus/release/bet/latest";
        public static final String LINKED_DEVICES_LIST = "list";
        public static final String LINK_INFO = "v3/preview";
        public static final String LOGOUT_LINKED_DEVICE = "logout";
        public static final String MY_SHOP = "shop/{limit}/{offset}";
        public static final String PACKS = "v1/stickers/packs/{limit}/{offset}";
        public static final String PACK_INFO = "v1/stickers/info/{pack_name}";
        public static final String REPORT = "v1/report";
        public static final String REQUEST_PRODUCT = "request/product/{id}";
        public static final String SEARCH_PRODUCT_BY_TAG = "search/products/tag/{todus_id}/{tag}/{limit}/{offset}";
        public static final String SEARCH_TAGS = "search/tags/{todus_id}";
        public static final String SHARE_CATALOG = "share/product/{id}";
        public static final String SHARE_PRODUCT = "share/product/{id}";
        public static final String SHOP = "{todus_id}/{limit}/{offset}";
        public static final String SUBSCRIBE = "card/subscribe/{uid}";
        public static final String TOKEN = "v2/auth/token";
        public static final String UN_SUBSCRIBE = "card/unsubscribe/{uid}";
        public static final String UPDATE_PRODUCT = "product/{id}";
        public static final String UPDATE_PROFILE = "v2/todus/users.me";
        public static final String USERS_REGISTER = "v2/auth/users.register";
        public static final String USERS_RESERVE = "v2/auth/users.reserve";
        public static final String VERSION = "version";

        private Endpoint() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApplicationEnvironment.values().length];
            try {
                iArr[ApplicationEnvironment.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApplicationEnvironment.PROD_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ApplicationEnvironment.PROD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ApplicationEnvironment.F5.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Service() {
    }

    public final boolean isToDusUrl(String string) {
        y.i(string, "string");
        return d0.a0(string, "chat.todus.cu", false, 2, null);
    }

    public final String provideAuthUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return "https://auth.todus.cu/";
        }
        if (i10 == 4) {
            return "https://auth-test.todus.cu/";
        }
        throw new r();
    }

    public final String provideCatalogueUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1) {
            return "http://10.37.41.159:8086/catalog/";
        }
        if (i10 == 2 || i10 == 3 || i10 == 4) {
            return "https://todus.cu/catalog/";
        }
        throw new r();
    }

    public final String provideChatUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return "https://chat.todus.cu/";
        }
        if (i10 == 4) {
            return "https://chat-test.todus.cu/";
        }
        throw new r();
    }

    public final String provideClientUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return "https://client.todus.cu/";
        }
        if (i10 == 4) {
            return "https://client-test.todus.cu/";
        }
        throw new r();
    }

    public final int provideIMPort(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1) {
            return 1756;
        }
        if (i10 == 2) {
            return 5443;
        }
        if (i10 == 3 || i10 == 4) {
            return 1756;
        }
        throw new r();
    }

    public final String provideIMUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1) {
            return "10.37.41.107";
        }
        if (i10 == 2 || i10 == 3) {
            return Config.SERVER_DOMAIN;
        }
        if (i10 == 4) {
            return "im-test.todus.cu";
        }
        throw new r();
    }

    public final String provideLinkedDeviceUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return "http://10.37.41.190:8086/";
        }
        throw new r();
    }

    public final String provideS3Url(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return "https://s3.todus.cu/";
        }
        if (i10 == 4) {
            return "https://s3-test.todus.cu/";
        }
        throw new r();
    }

    public final String provideStickersUrl(ApplicationEnvironment environment) {
        y.i(environment, "environment");
        int i10 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return "https://stickers.todus.cu/";
        }
        if (i10 == 4) {
            return "https://stickers-test.todus.cu/";
        }
        throw new r();
    }
}
