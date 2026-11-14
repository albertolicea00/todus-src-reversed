package cu.todus.android.rest;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.HeadersChecker;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.repositories.AuthRepository;
import cu.todus.android.repositories.MainRepository;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import nf.e0;
import nf.g0;
import nf.i0;
import nf.z;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcu/todus/android/rest/TokenAuthenticator;", "Lnf/b;", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "", "requestToken", "<init>", "(Llb/a;)V", "Lnf/i0;", "route", "Lnf/g0;", SaslStreamElements.Response.ELEMENT, "Lnf/e0;", "authenticate", "(Lnf/i0;Lnf/g0;)Lnf/e0;", "Llb/a;", "getRequestToken", "()Llb/a;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TokenAuthenticator implements nf.b {
    public static final int $stable = 0;
    public static final String AUTHORIZATION = "Authorization";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final lb.a requestToken;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcu/todus/android/rest/TokenAuthenticator$Companion;", "", "<init>", "()V", "", "serviceName", "", "bearer", "Lnf/z;", "headerWithAuth", "(Ljava/lang/String;Z)Lnf/z;", "token", "", "headerForImage", "(Ljava/lang/String;ZLjava/lang/String;)Ljava/util/Map;", "header", "(Ljava/lang/String;)Lnf/z;", "getMapHeaders", "(Ljava/lang/String;)Ljava/util/Map;", "Lcu/todus/android/data/db/pojo/content/LocationContent;", "locationContent", "getMapUrl", "(Lcu/todus/android/data/db/pojo/content/LocationContent;)Ljava/lang/String;", "AUTHORIZATION", "Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public static /* synthetic */ z header$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "ToDus";
            }
            return companion.header(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final g0 header$lambda$0(String str, z.a chain) {
            y.i(chain, "chain");
            return chain.a(chain.b().i().l("User-Agent", "ToDus 2.1.2 " + str).b());
        }

        public static /* synthetic */ Map headerForImage$default(Companion companion, String str, boolean z10, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return companion.headerForImage(str, z10, str2);
        }

        public static /* synthetic */ z headerWithAuth$default(Companion companion, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "ToDus";
            }
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            return companion.headerWithAuth(str, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final g0 headerWithAuth$lambda$0(String str, z.a chain) {
            MainRepository instanceOrNull;
            y.i(chain, "chain");
            e0 e0VarB = chain.b();
            e0.a aVarL = e0VarB.i().l("User-Agent", "ToDus 2.1.2 " + str);
            if (HeadersChecker.INSTANCE.needHeaders(e0VarB.l().toString()) && (instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull()) != null) {
                Pair<Boolean, String> authToken = instanceOrNull.getAuthToken();
                boolean zBooleanValue = authToken.component1().booleanValue();
                authToken.component2();
                if (!zBooleanValue) {
                    AuthRepository.INSTANCE.getInstance().newToken().getSecond();
                }
            }
            return chain.a(aVarL.b());
        }

        public final Map<String, String> getMapHeaders(String token) {
            y.i(token, "token");
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put(TokenAuthenticator.AUTHORIZATION, "Bearer " + token);
            return map;
        }

        public final String getMapUrl(LocationContent locationContent) {
            y.i(locationContent, "locationContent");
            double lat = locationContent.getLat();
            return "https://map.todus.cu/styles/basic-preview/static/" + locationContent.getLon() + "," + lat + "," + ((int) locationContent.getZoom()) + "/" + XMPPTCPConnection.PacketWriter.QUEUE_SIZE + "x" + XMPPTCPConnection.PacketWriter.QUEUE_SIZE + ".png";
        }

        public final z header(final String serviceName) {
            y.i(serviceName, "serviceName");
            return new z() { // from class: cu.todus.android.rest.b
                @Override // nf.z
                public final g0 a(z.a aVar) {
                    return TokenAuthenticator.Companion.header$lambda$0(serviceName, aVar);
                }
            };
        }

        public final Map<String, String> headerForImage(String serviceName, boolean bearer, String token) {
            y.i(serviceName, "serviceName");
            y.i(token, "token");
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("User-Agent", "ToDus 2.1.2 " + serviceName);
            if (!bearer) {
                map.put(TokenAuthenticator.AUTHORIZATION, token);
                return map;
            }
            map.put(TokenAuthenticator.AUTHORIZATION, "Bearer " + token);
            return map;
        }

        public final z headerWithAuth(final String serviceName, boolean bearer) {
            y.i(serviceName, "serviceName");
            return new z() { // from class: cu.todus.android.rest.c
                @Override // nf.z
                public final g0 a(z.a aVar) {
                    return TokenAuthenticator.Companion.headerWithAuth$lambda$0(serviceName, aVar);
                }
            };
        }

        private Companion() {
        }
    }

    public TokenAuthenticator(lb.a requestToken) {
        y.i(requestToken, "requestToken");
        this.requestToken = requestToken;
    }

    @Override // nf.b
    public e0 authenticate(i0 route, g0 response) {
        y.i(response, "response");
        Pair pair = (Pair) this.requestToken.invoke();
        boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
        String str = (String) pair.component2();
        if (zBooleanValue) {
            return response.Q().i().l(AUTHORIZATION, str).b();
        }
        return null;
    }

    public final lb.a getRequestToken() {
        return this.requestToken;
    }
}
