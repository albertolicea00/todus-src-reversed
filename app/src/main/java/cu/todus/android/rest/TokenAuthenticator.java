package cu.todus.android.rest;

import java.util.HashMap;
import java.util.Map;

import cu.todus.android.data.db.pojo.content.LocationContent;

/**
 * OkHttp authenticator and header/URL helper for Bearer token refresh and
 * {@code User-Agent: ToDus 2.1.2 <serviceName>} injection.
 *
 * @obfuscated_class cu.todus.android.rest.TokenAuthenticator
 */
public final class TokenAuthenticator {

    public static final String AUTHORIZATION = "Authorization";

    private TokenAuthenticator() {
    }

    public static Map<String, String> getMapHeaders(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put(AUTHORIZATION, "Bearer " + token);
        return map;
    }

    public static String getMapUrl(LocationContent locationContent) {
        return "https://map.todus.cu/styles/basic-preview/static/"
                + locationContent.getLon() + "," + locationContent.getLat()
                + "," + ((int) locationContent.getZoom()) + "/512x512.png";
    }
}
