package cu.todus.android.constants;

/**
 * Service environment definitions, XMPP domain configuration, and REST endpoint paths.
 *
 * @obfuscated_class cu.todus.android.constants.Service
 */
public final class Service {

    public static final Service INSTANCE = new Service();

    private Service() {
    }

    public enum ApplicationEnvironment {
        LOCAL,
        PROD_2,
        PROD,
        F5
    }

    public static final class Config {
        public static final String STICKERS_OFFICIAL = "stickers.todus.cu";
        public static final String SERVER_DOMAIN = "im.todus.cu";
        public static final String SERVER_NAME_CHANNELS = "ch";
        public static final String SERVER_NAME_MUC = "muclight";
        public static final String MUC_LIGHT_SERVICE_NAME = "muclight.im.todus.cu";
        public static final String CHANNEL_SERVICE_NAME = "ch.im.todus.cu";
        public static final int MAX_MSG_TEXT_SIZE = 8192;
        public static final int MAX_MESSAGE_LENGTH = 65536;
        public static final int COUNTER_VISIBLE_THRESHOLD = 200;
        public static final String STATUS_NAMESPACE = "status";
        public static final String STATUS_RECEPTOR = "status@status.im.todus.cu";
        public static final String REACTION_NAMESPACE = "reaction";

        private Config() {
        }
    }

    public static final class Endpoint {
        public static final String GET_INFO = "card/info/{uid}";
        public static final String GET_INFO_OR_ERROR = "info/{uid}";
        public static final String SUBSCRIBE = "card/subscribe/{uid}";
        public static final String UN_SUBSCRIBE = "card/unsubscribe/{uid}";
        public static final String USERS_RESERVE = "v2/auth/users.reserve";
        public static final String USERS_REGISTER = "v2/auth/users.register";
        public static final String TOKEN = "v2/auth/token";
        public static final String CHECK = "v2/auth/check";
        public static final String LINK_INFO = "v3/preview";
        public static final String UPDATE_PROFILE = "v2/todus/users.me";
        public static final String LATEST = "todus/release/rel/latest";
        public static final String LATEST_BETA = "todus/release/bet/latest";
        public static final String REPORT = "v1/report";
        public static final String LOGOUT_LINKED_DEVICE = "logout";
        public static final String LINKED_DEVICES_LIST = "list";
        public static final String PACKS = "v1/stickers/packs/{limit}/{offset}";
        public static final String PACK_INFO = "v1/stickers/info/{pack_name}";
        public static final String VERSION = "version";
        public static final String SHOP = "{todus_id}/{limit}/{offset}";
        public static final String MY_SHOP = "shop/{limit}/{offset}";
        public static final String GET_PRODUCT = "product/{todus_id}/{id}";
        public static final String ADD_PRODUCT = "product";
        public static final String UPDATE_PRODUCT = "product/{id}";
        public static final String DELETE_PRODUCT = "product/{id}";
        public static final String SHARE_PRODUCT = "share/product/{id}";
        public static final String SHARE_CATALOG = "share/product/{id}";
        public static final String REQUEST_PRODUCT = "request/product/{id}";
        public static final String SEARCH_TAGS = "search/tags/{todus_id}";
        public static final String SEARCH_PRODUCT_BY_TAG = "search/products/tag/{todus_id}/{tag}/{limit}/{offset}";

        private Endpoint() {
        }
    }

    public boolean isToDusUrl(String value) {
        return value != null && value.contains("chat.todus.cu");
    }

    public String provideAuthUrl(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.F5
                ? "https://auth-test.todus.cu/"
                : "https://auth.todus.cu/";
    }

    public String provideCatalogueUrl(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.LOCAL
                ? "http://10.37.41.159:8086/catalog/"
                : "https://todus.cu/catalog/";
    }

    public String provideChatUrl(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.F5
                ? "https://chat-test.todus.cu/"
                : "https://chat.todus.cu/";
    }

    public String provideClientUrl(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.F5
                ? "https://client-test.todus.cu/"
                : "https://client.todus.cu/";
    }

    public int provideIMPort(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.PROD_2 ? 5443 : 1756;
    }

    public String provideIMUrl(ApplicationEnvironment environment) {
        switch (environment) {
            case LOCAL:
                return "10.37.41.107";
            case F5:
                return "im-test.todus.cu";
            case PROD_2:
            case PROD:
            default:
                return Config.SERVER_DOMAIN;
        }
    }

    public String provideLinkedDeviceUrl(ApplicationEnvironment environment) {
        return "http://10.37.41.190:8086/";
    }

    public String provideS3Url(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.F5
                ? "https://s3-test.todus.cu/"
                : "https://s3.todus.cu/";
    }

    public String provideStickersUrl(ApplicationEnvironment environment) {
        return environment == ApplicationEnvironment.F5
                ? "https://stickers-test.todus.cu/"
                : "https://stickers.todus.cu/";
    }
}
