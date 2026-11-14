package cu.todus.android.di;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import cu.todus.android.R;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.android.rest.TokenAuthenticator;
import cu.todus.android.rest.auth.AuthDataSource;
import cu.todus.android.rest.auth.AuthService;
import cu.todus.android.rest.catalogue.CatalogueDataSource;
import cu.todus.android.rest.catalogue.CatalogueService;
import cu.todus.android.rest.certified.CertifiedInfoDataSource;
import cu.todus.android.rest.certified.CertifiedInfoService;
import cu.todus.android.rest.client.ClientDataSource;
import cu.todus.android.rest.client.ClientService;
import cu.todus.android.rest.factory.NullOnEmptyConverterFactory;
import cu.todus.android.rest.factory.ProtobufConverterFactoryV2;
import cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource;
import cu.todus.android.rest.linkedDevice.LinkedDeviceService;
import cu.todus.android.rest.report.ReportDataSource;
import cu.todus.android.rest.report.ReportService;
import cu.todus.android.rest.sticker.StickerDataSource;
import cu.todus.android.rest.sticker.StickerService;
import cu.todus.android.rest.user.UserDataSource;
import cu.todus.android.rest.user.UserService;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.singledi.SingletonInitializer;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import le.d0;
import mi.b0;
import nf.c0;
import nf.g0;
import org.jivesoftware.smack.util.TLSUtils;
import ua.z;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\bZ\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Å\u00012\u00020\u0001:\u0002Å\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u0011J\u001f\u0010$\u001a\n \u000f*\u0004\u0018\u00010#0#2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010(J1\u0010)\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\b)\u0010!J\u001f\u0010*\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\u0011J\u001f\u0010,\u001a\n \u000f*\u0004\u0018\u00010+0+2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u00100J1\u00101\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\b1\u0010!J\u001f\u00102\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010\u0011J\u001f\u00104\u001a\n \u000f*\u0004\u0018\u000103032\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u0002062\u0006\u0010\u0016\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b7\u00108J1\u00109\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\b9\u0010!J\u001f\u0010:\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010\u0011J\u001f\u0010<\u001a\n \u000f*\u0004\u0018\u00010;0;2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010?\u001a\u00020>2\u0006\u0010\u0016\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b?\u0010@J1\u0010A\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\bA\u0010!J\u001f\u0010B\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010\u0011J\u001f\u0010D\u001a\n \u000f*\u0004\u0018\u00010C0C2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010G\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bG\u0010HJ1\u0010I\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\bI\u0010!J\u001f\u0010J\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010\u0011J\u001f\u0010L\u001a\n \u000f*\u0004\u0018\u00010K0K2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020N2\u0006\u0010\u0016\u001a\u00020K2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bO\u0010PJ1\u0010Q\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001cH\u0002¢\u0006\u0004\bQ\u0010!J\u001f\u0010R\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\bR\u0010\u0011J\u001f\u0010T\u001a\n \u000f*\u0004\u0018\u00010S0S2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010W\u001a\u00020V2\u0006\u0010\u0016\u001a\u00020S2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bW\u0010XJ/\u0010Z\u001a\u00020Y2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d0\u001c¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\\R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010]R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010d\u001a\u0004\u0018\u00010c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u0004\u0018\u00010c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010eR\u001f\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u001a8\u0002X\u0082D¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\"\u0010v\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010qR\u0016\u0010}\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b}\u0010sR\u0016\u0010~\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b~\u0010\u007fR)\u0010\u0080\u0001\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010qR\u0018\u0010\u0087\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010sR\u0019\u0010\u0088\u0001\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008a\u0001\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010qR\u0018\u0010\u0091\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010sR\u0019\u0010\u0092\u0001\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R)\u0010\u0094\u0001\u001a\u0002068\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010qR\u0018\u0010\u009b\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010sR\u0019\u0010\u009c\u0001\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R)\u0010\u009e\u0001\u001a\u00020>8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¤\u0001\u0010qR\u0018\u0010¥\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¥\u0001\u0010sR\u0019\u0010¦\u0001\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R)\u0010¨\u0001\u001a\u00020F8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0018\u0010®\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b®\u0001\u0010qR\u0018\u0010¯\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¯\u0001\u0010sR\u0019\u0010°\u0001\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R)\u0010²\u0001\u001a\u00020V8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¸\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¸\u0001\u0010qR\u0018\u0010¹\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¹\u0001\u0010sR\u0019\u0010º\u0001\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R)\u0010¼\u0001\u001a\u00020N8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Ã\u0001\u001a\u00030Â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006Æ\u0001"}, d2 = {"Lcu/todus/android/di/RetrofitModule;", "", "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "Landroid/content/Context;", "appContext", "Lcu/todus/android/data/preferences/RootEnvironment;", "environment", "<init>", "(Lcu/todus/android/rest/BaseDataSource;Landroid/content/Context;Lcu/todus/android/data/preferences/RootEnvironment;)V", "Lnf/c0;", "provideAuthOkHttp", "()Lnf/c0;", "okHttp", "Lmi/b0;", "kotlin.jvm.PlatformType", "provideAuthRetrofit", "(Lnf/c0;)Lmi/b0;", "retrofit", "Lcu/todus/android/rest/auth/AuthService;", "provideAuthService", "(Lmi/b0;)Lcu/todus/android/rest/auth/AuthService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/auth/AuthDataSource;", "provideAuthDataSource", "(Lcu/todus/android/rest/auth/AuthService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/auth/AuthDataSource;", "", "token", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "requestToken", "provideUserOkHttp", "(Ljava/lang/String;Llb/a;)Lnf/c0;", "provideUserRetrofit", "Lcu/todus/android/rest/user/UserService;", "provideUserService", "(Lmi/b0;)Lcu/todus/android/rest/user/UserService;", "Lcu/todus/android/rest/user/UserDataSource;", "provideUserDataSource", "(Lcu/todus/android/rest/user/UserService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/user/UserDataSource;", "provideClientOkHttp", "provideClientRetrofit", "Lcu/todus/android/rest/client/ClientService;", "provideClientService", "(Lmi/b0;)Lcu/todus/android/rest/client/ClientService;", "Lcu/todus/android/rest/client/ClientDataSource;", "provideClientDataSource", "(Lcu/todus/android/rest/client/ClientService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/client/ClientDataSource;", "provideCertifiedOkHttp", "provideCertifiedRetrofit", "Lcu/todus/android/rest/certified/CertifiedInfoService;", "provideCertifiedService", "(Lmi/b0;)Lcu/todus/android/rest/certified/CertifiedInfoService;", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "provideCertifiedDataSource", "(Lcu/todus/android/rest/certified/CertifiedInfoService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "provideReportOkHttp", "provideReportRetrofit", "Lcu/todus/android/rest/report/ReportService;", "provideReportService", "(Lmi/b0;)Lcu/todus/android/rest/report/ReportService;", "Lcu/todus/android/rest/report/ReportDataSource;", "provideReportDataSource", "(Lcu/todus/android/rest/report/ReportService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/report/ReportDataSource;", "provideLinkedOkHttp", "provideLinkedRetrofit", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", "provideLinkedService", "(Lmi/b0;)Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "provideLinkedDataSource", "(Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "provideStickerOkHttp", "provideStickerRetrofit", "Lcu/todus/android/rest/sticker/StickerService;", "provideStickerService", "(Lmi/b0;)Lcu/todus/android/rest/sticker/StickerService;", "Lcu/todus/android/rest/sticker/StickerDataSource;", "provideStickerDataSource", "(Lcu/todus/android/rest/sticker/StickerService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/sticker/StickerDataSource;", "provideCatalogueOkHttp", "provideCatalogueRetrofit", "Lcu/todus/android/rest/catalogue/CatalogueService;", "provideCatalogueService", "(Lmi/b0;)Lcu/todus/android/rest/catalogue/CatalogueService;", "Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "provideCatalogueDataSource", "(Lcu/todus/android/rest/catalogue/CatalogueService;Lcu/todus/android/rest/BaseDataSource;)Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "Lua/k0;", "initDependentsOfAuth", "(Ljava/lang/String;Llb/a;)V", "Lcu/todus/android/rest/BaseDataSource;", "Landroid/content/Context;", "Lcu/todus/android/data/preferences/RootEnvironment;", "Ljava/io/InputStream;", "rawCertificated", "Ljava/io/InputStream;", "rawCertificated2", "Ljava/security/cert/X509Certificate;", "certificated1", "Ljava/security/cert/X509Certificate;", "certificated2", "", "certPool", "Ljava/util/List;", "getCertPool", "()Ljava/util/List;", "fullInit", "Z", "AUTHORIZATION", "Ljava/lang/String;", "okHttpAuth", "Lnf/c0;", "retrofitAuth", "Lmi/b0;", "serviceAuth", "Lcu/todus/android/rest/auth/AuthService;", "authDataSource", "Lcu/todus/android/rest/auth/AuthDataSource;", "getAuthDataSource", "()Lcu/todus/android/rest/auth/AuthDataSource;", "setAuthDataSource", "(Lcu/todus/android/rest/auth/AuthDataSource;)V", "okHttpUser", "retrofitUser", "serviceUser", "Lcu/todus/android/rest/user/UserService;", "userDataSource", "Lcu/todus/android/rest/user/UserDataSource;", "getUserDataSource", "()Lcu/todus/android/rest/user/UserDataSource;", "setUserDataSource", "(Lcu/todus/android/rest/user/UserDataSource;)V", "okHttpClient", "retrofitClient", "serviceClient", "Lcu/todus/android/rest/client/ClientService;", "clientDataSource", "Lcu/todus/android/rest/client/ClientDataSource;", "getClientDataSource", "()Lcu/todus/android/rest/client/ClientDataSource;", "setClientDataSource", "(Lcu/todus/android/rest/client/ClientDataSource;)V", "okHttpCertified", "retrofitCertified", "serviceCertified", "Lcu/todus/android/rest/certified/CertifiedInfoService;", "certifiedInfoDataSource", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "getCertifiedInfoDataSource", "()Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "setCertifiedInfoDataSource", "(Lcu/todus/android/rest/certified/CertifiedInfoDataSource;)V", "okHttpReport", "retrofitReport", "serviceReport", "Lcu/todus/android/rest/report/ReportService;", "reportDataSource", "Lcu/todus/android/rest/report/ReportDataSource;", "getReportDataSource", "()Lcu/todus/android/rest/report/ReportDataSource;", "setReportDataSource", "(Lcu/todus/android/rest/report/ReportDataSource;)V", "okHttpLinked", "retrofitLinked", "serviceLinked", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceService;", "linkedDeviceDataSource", "Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "getLinkedDeviceDataSource", "()Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;", "setLinkedDeviceDataSource", "(Lcu/todus/android/rest/linkedDevice/LinkedDeviceDataSource;)V", "okHttpCatalogue", "retrofitCatalogue", "serviceCatalogue", "Lcu/todus/android/rest/catalogue/CatalogueService;", "catalogueDataSource", "Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "getCatalogueDataSource", "()Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "setCatalogueDataSource", "(Lcu/todus/android/rest/catalogue/CatalogueDataSource;)V", "okHttpSticker", "retrofitSticker", "serviceSticker", "Lcu/todus/android/rest/sticker/StickerService;", "stickerDataSource", "Lcu/todus/android/rest/sticker/StickerDataSource;", "getStickerDataSource", "()Lcu/todus/android/rest/sticker/StickerDataSource;", "setStickerDataSource", "(Lcu/todus/android/rest/sticker/StickerDataSource;)V", "Leg/a;", "httpLoggingInterceptor", "Leg/a;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RetrofitModule {
    private final String AUTHORIZATION;
    private final Context appContext;
    private AuthDataSource authDataSource;
    private final BaseDataSource baseDataSource;
    public CatalogueDataSource catalogueDataSource;
    private final List<X509Certificate> certPool;
    private final X509Certificate certificated1;
    private final X509Certificate certificated2;
    public CertifiedInfoDataSource certifiedInfoDataSource;
    public ClientDataSource clientDataSource;
    private final RootEnvironment environment;
    private boolean fullInit;
    private final eg.a httpLoggingInterceptor;
    public LinkedDeviceDataSource linkedDeviceDataSource;
    private c0 okHttpAuth;
    private c0 okHttpCatalogue;
    private c0 okHttpCertified;
    private c0 okHttpClient;
    private c0 okHttpLinked;
    private c0 okHttpReport;
    private c0 okHttpSticker;
    private c0 okHttpUser;
    private final InputStream rawCertificated;
    private final InputStream rawCertificated2;
    public ReportDataSource reportDataSource;
    private b0 retrofitAuth;
    private b0 retrofitCatalogue;
    private b0 retrofitCertified;
    private b0 retrofitClient;
    private b0 retrofitLinked;
    private b0 retrofitReport;
    private b0 retrofitSticker;
    private b0 retrofitUser;
    private AuthService serviceAuth;
    private CatalogueService serviceCatalogue;
    private CertifiedInfoService serviceCertified;
    private ClientService serviceClient;
    private LinkedDeviceService serviceLinked;
    private ReportService serviceReport;
    private StickerService serviceSticker;
    private UserService serviceUser;
    public StickerDataSource stickerDataSource;
    public UserDataSource userDataSource;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lcu/todus/android/di/RetrofitModule$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/di/RetrofitModule;", "<init>", "()V", "allowAllCertificated", "Lkotlin/Pair;", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<RetrofitModule> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final Pair<SSLSocketFactory, X509TrustManager> allowAllCertificated() {
            AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
            if (!(instanceOrNull != null ? instanceOrNull.getIsCertificateValid() : true)) {
                try {
                    X509TrustManager x509TrustManager = new X509TrustManager() { // from class: cu.todus.android.di.RetrofitModule$Companion$allowAllCertificated$trustManager$1
                        @Override // javax.net.ssl.X509TrustManager
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            RetrofitModule instanceOrNull2 = RetrofitModule.INSTANCE.getInstanceOrNull();
                            List<X509Certificate> certPool = instanceOrNull2 != null ? instanceOrNull2.getCertPool() : null;
                            int i10 = 0;
                            if (chain != null) {
                                int length = chain.length;
                                int i11 = 0;
                                while (i10 < length) {
                                    X509Certificate x509Certificate = chain[i10];
                                    if (certPool != null) {
                                        for (X509Certificate x509Certificate2 : certPool) {
                                            if (x509Certificate2 != null && y.d(x509Certificate, x509Certificate2)) {
                                                i11 = 1;
                                            }
                                        }
                                    }
                                    i10++;
                                }
                                i10 = i11;
                            }
                            if (i10 == 0) {
                                throw new CertificateException();
                            }
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            RetrofitModule instanceOrNull2 = RetrofitModule.INSTANCE.getInstanceOrNull();
                            List<X509Certificate> certPool = instanceOrNull2 != null ? instanceOrNull2.getCertPool() : null;
                            int i10 = 0;
                            if (chain != null) {
                                int length = chain.length;
                                int i11 = 0;
                                while (i10 < length) {
                                    X509Certificate x509Certificate = chain[i10];
                                    if (certPool != null) {
                                        for (X509Certificate x509Certificate2 : certPool) {
                                            if (x509Certificate2 != null && y.d(x509Certificate, x509Certificate2)) {
                                                i11 = 1;
                                            }
                                        }
                                    }
                                    i10++;
                                }
                                i10 = i11;
                            }
                            if (i10 == 0) {
                                throw new CertificateException();
                            }
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    };
                    SSLContext sSLContext = SSLContext.getInstance(TLSUtils.TLS);
                    sSLContext.init(null, new RetrofitModule$Companion$allowAllCertificated$trustManager$1[]{x509TrustManager}, new SecureRandom());
                    return z.a(sSLContext.getSocketFactory(), x509TrustManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    public RetrofitModule(BaseDataSource baseDataSource, Context appContext, RootEnvironment environment) {
        X509Certificate x509Certificate;
        X509Certificate x509Certificate2;
        y.i(baseDataSource, "baseDataSource");
        y.i(appContext, "appContext");
        y.i(environment, "environment");
        this.baseDataSource = baseDataSource;
        this.appContext = appContext;
        this.environment = environment;
        InputStream inputStreamOpenRawResource = appContext.getResources().openRawResource(R.raw.todus_cert_ago_2024);
        y.h(inputStreamOpenRawResource, "openRawResource(...)");
        this.rawCertificated = inputStreamOpenRawResource;
        InputStream inputStreamOpenRawResource2 = appContext.getResources().openRawResource(R.raw.todus_cert_may_2025);
        y.h(inputStreamOpenRawResource2, "openRawResource(...)");
        this.rawCertificated2 = inputStreamOpenRawResource2;
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStreamOpenRawResource);
            x509Certificate = certificateGenerateCertificate instanceof X509Certificate ? (X509Certificate) certificateGenerateCertificate : null;
        } catch (Exception unused) {
        }
        this.certificated1 = x509Certificate;
        try {
            Certificate certificateGenerateCertificate2 = CertificateFactory.getInstance("X.509").generateCertificate(this.rawCertificated2);
            x509Certificate2 = certificateGenerateCertificate2 instanceof X509Certificate ? (X509Certificate) certificateGenerateCertificate2 : null;
        } catch (Exception unused2) {
        }
        this.certificated2 = x509Certificate2;
        this.certPool = w.q(this.certificated1, x509Certificate2);
        this.AUTHORIZATION = TokenAuthenticator.AUTHORIZATION;
        eg.a aVar = new eg.a(null, 1, null);
        this.httpLoggingInterceptor = aVar;
        aVar.g(eg.a.b.BODY);
        c0 c0VarProvideAuthOkHttp = provideAuthOkHttp();
        this.okHttpAuth = c0VarProvideAuthOkHttp;
        b0 b0VarProvideAuthRetrofit = provideAuthRetrofit(c0VarProvideAuthOkHttp);
        y.h(b0VarProvideAuthRetrofit, "provideAuthRetrofit(...)");
        this.retrofitAuth = b0VarProvideAuthRetrofit;
        AuthService authServiceProvideAuthService = provideAuthService(b0VarProvideAuthRetrofit);
        y.h(authServiceProvideAuthService, "provideAuthService(...)");
        this.serviceAuth = authServiceProvideAuthService;
        this.authDataSource = provideAuthDataSource(authServiceProvideAuthService, this.baseDataSource);
    }

    private final AuthDataSource provideAuthDataSource(AuthService service, BaseDataSource baseDataSource) {
        return new AuthDataSource(service, baseDataSource);
    }

    private final c0 provideAuthOkHttp() {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.m
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideAuthOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.n
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideAuthOkHttp$lambda$0$1(aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideAuthOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideAuthOkHttp$lambda$0$1(nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").b());
    }

    private final b0 provideAuthRetrofit(c0 okHttp) {
        return new b0.b().f(okHttp).b(Service.INSTANCE.provideAuthUrl(Service.ApplicationEnvironment.PROD_2)).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final AuthService provideAuthService(b0 retrofit) {
        return (AuthService) retrofit.b(AuthService.class);
    }

    private final CatalogueDataSource provideCatalogueDataSource(CatalogueService service, BaseDataSource baseDataSource) {
        return new CatalogueDataSource(service, baseDataSource);
    }

    private final c0 provideCatalogueOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.h
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideCatalogueOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.i
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideCatalogueOkHttp$lambda$0$1(this.f20853a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideCatalogueOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideCatalogueOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideCatalogueRetrofit(c0 okHttp) {
        String strProvideCatalogueUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideCatalogueUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideCatalogueUrl)) {
                strProvideCatalogueUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideCatalogueUrl = Service.INSTANCE.provideCatalogueUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideCatalogueUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final CatalogueService provideCatalogueService(b0 retrofit) {
        return (CatalogueService) retrofit.b(CatalogueService.class);
    }

    private final CertifiedInfoDataSource provideCertifiedDataSource(CertifiedInfoService service, BaseDataSource baseDataSource) {
        return new CertifiedInfoDataSource(service, baseDataSource);
    }

    private final c0 provideCertifiedOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.j
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideCertifiedOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.k
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideCertifiedOkHttp$lambda$0$1(this.f20855a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideCertifiedOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideCertifiedOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideCertifiedRetrofit(c0 okHttp) {
        String strProvideChatUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideChatUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideChatUrl)) {
                strProvideChatUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideChatUrl = Service.INSTANCE.provideChatUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideChatUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final CertifiedInfoService provideCertifiedService(b0 retrofit) {
        return (CertifiedInfoService) retrofit.b(CertifiedInfoService.class);
    }

    private final ClientDataSource provideClientDataSource(ClientService service, BaseDataSource baseDataSource) {
        return new ClientDataSource(service, baseDataSource);
    }

    private final c0 provideClientOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.s
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideClientOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.t
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideClientOkHttp$lambda$0$1(this.f20863a, token, aVar);
            }
        });
        aVarA.c(new TokenAuthenticator(requestToken));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideClientOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideClientOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideClientRetrofit(c0 okHttp) {
        String strProvideClientUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideClientUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideClientUrl)) {
                strProvideClientUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideClientUrl = Service.INSTANCE.provideClientUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideClientUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final ClientService provideClientService(b0 retrofit) {
        return (ClientService) retrofit.b(ClientService.class);
    }

    private final LinkedDeviceDataSource provideLinkedDataSource(LinkedDeviceService service, BaseDataSource baseDataSource) {
        return new LinkedDeviceDataSource(service, baseDataSource);
    }

    private final c0 provideLinkedOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.q
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideLinkedOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.r
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideLinkedOkHttp$lambda$0$1(this.f20861a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideLinkedOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideLinkedOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideLinkedRetrofit(c0 okHttp) {
        String strProvideLinkedDeviceUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideLinkedDeviceUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideLinkedDeviceUrl)) {
                strProvideLinkedDeviceUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideLinkedDeviceUrl = Service.INSTANCE.provideLinkedDeviceUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideLinkedDeviceUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final LinkedDeviceService provideLinkedService(b0 retrofit) {
        return (LinkedDeviceService) retrofit.b(LinkedDeviceService.class);
    }

    private final ReportDataSource provideReportDataSource(ReportService service, BaseDataSource baseDataSource) {
        return new ReportDataSource(service, baseDataSource);
    }

    private final c0 provideReportOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.e
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideReportOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.l
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideReportOkHttp$lambda$0$1(this.f20857a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideReportOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideReportOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideReportRetrofit(c0 okHttp) {
        String strProvideAuthUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideAuthUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideAuthUrl)) {
                strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideAuthUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final ReportService provideReportService(b0 retrofit) {
        return (ReportService) retrofit.b(ReportService.class);
    }

    private final StickerDataSource provideStickerDataSource(StickerService service, BaseDataSource baseDataSource) {
        return new StickerDataSource(service, baseDataSource);
    }

    private final c0 provideStickerOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.f
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideStickerOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.g
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideStickerOkHttp$lambda$0$1(this.f20851a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideStickerOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideStickerOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideStickerRetrofit(c0 okHttp) {
        String strProvideAuthUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideAuthUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideAuthUrl)) {
                strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideAuthUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final StickerService provideStickerService(b0 retrofit) {
        return (StickerService) retrofit.b(StickerService.class);
    }

    private final UserDataSource provideUserDataSource(UserService service, BaseDataSource baseDataSource) {
        return new UserDataSource(service, baseDataSource);
    }

    private final c0 provideUserOkHttp(final String token, lb.a requestToken) {
        c0.a aVarA = new c0().A();
        Pair<SSLSocketFactory, X509TrustManager> pairAllowAllCertificated = INSTANCE.allowAllCertificated();
        if (pairAllowAllCertificated != null) {
            aVarA.Q(pairAllowAllCertificated.getFirst(), pairAllowAllCertificated.getSecond());
            aVarA.M(new HostnameVerifier() { // from class: cu.todus.android.di.o
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return RetrofitModule.provideUserOkHttp$lambda$0$0$0(str, sSLSession);
                }
            });
        }
        aVarA.c(new TokenAuthenticator(requestToken));
        aVarA.a(new nf.z() { // from class: cu.todus.android.di.p
            @Override // nf.z
            public final g0 a(nf.z.a aVar) {
                return RetrofitModule.provideUserOkHttp$lambda$0$1(this.f20859a, token, aVar);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVarA.e(15L, timeUnit);
        aVarA.R(15L, timeUnit);
        aVarA.N(15L, timeUnit);
        return aVarA.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean provideUserOkHttp$lambda$0$0$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 provideUserOkHttp$lambda$0$1(RetrofitModule retrofitModule, String str, nf.z.a it) {
        y.i(it, "it");
        return it.a(it.b().i().l("User-Agent", "ToDus 2.1.2 Auth").l(retrofitModule.AUTHORIZATION, str).b());
    }

    private final b0 provideUserRetrofit(c0 okHttp) {
        String strProvideAuthUrl;
        b0.b bVarF = new b0.b().f(okHttp);
        if (this.environment.getApplicationEnvironment() == Service.ApplicationEnvironment.LOCAL) {
            strProvideAuthUrl = this.environment.getRootUrl();
            if (d0.q0(strProvideAuthUrl)) {
                strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
            }
        } else {
            strProvideAuthUrl = Service.INSTANCE.provideAuthUrl(this.environment.getApplicationEnvironment());
        }
        return bVarF.b(strProvideAuthUrl).a(new NullOnEmptyConverterFactory()).a(ProtobufConverterFactoryV2.INSTANCE.create()).a(ni.a.a()).d();
    }

    private final UserService provideUserService(b0 retrofit) {
        return (UserService) retrofit.b(UserService.class);
    }

    public final AuthDataSource getAuthDataSource() {
        return this.authDataSource;
    }

    public final CatalogueDataSource getCatalogueDataSource() {
        CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
        if (catalogueDataSource != null) {
            return catalogueDataSource;
        }
        y.w("catalogueDataSource");
        return null;
    }

    public final List<X509Certificate> getCertPool() {
        return this.certPool;
    }

    public final CertifiedInfoDataSource getCertifiedInfoDataSource() {
        CertifiedInfoDataSource certifiedInfoDataSource = this.certifiedInfoDataSource;
        if (certifiedInfoDataSource != null) {
            return certifiedInfoDataSource;
        }
        y.w("certifiedInfoDataSource");
        return null;
    }

    public final ClientDataSource getClientDataSource() {
        ClientDataSource clientDataSource = this.clientDataSource;
        if (clientDataSource != null) {
            return clientDataSource;
        }
        y.w("clientDataSource");
        return null;
    }

    public final LinkedDeviceDataSource getLinkedDeviceDataSource() {
        LinkedDeviceDataSource linkedDeviceDataSource = this.linkedDeviceDataSource;
        if (linkedDeviceDataSource != null) {
            return linkedDeviceDataSource;
        }
        y.w("linkedDeviceDataSource");
        return null;
    }

    public final ReportDataSource getReportDataSource() {
        ReportDataSource reportDataSource = this.reportDataSource;
        if (reportDataSource != null) {
            return reportDataSource;
        }
        y.w("reportDataSource");
        return null;
    }

    public final StickerDataSource getStickerDataSource() {
        StickerDataSource stickerDataSource = this.stickerDataSource;
        if (stickerDataSource != null) {
            return stickerDataSource;
        }
        y.w("stickerDataSource");
        return null;
    }

    public final UserDataSource getUserDataSource() {
        UserDataSource userDataSource = this.userDataSource;
        if (userDataSource != null) {
            return userDataSource;
        }
        y.w("userDataSource");
        return null;
    }

    public final void initDependentsOfAuth(String token, lb.a requestToken) {
        y.i(token, "token");
        y.i(requestToken, "requestToken");
        c0 c0VarProvideClientOkHttp = provideClientOkHttp(token, requestToken);
        this.okHttpClient = c0VarProvideClientOkHttp;
        CatalogueService catalogueService = null;
        if (c0VarProvideClientOkHttp == null) {
            y.w("okHttpClient");
            c0VarProvideClientOkHttp = null;
        }
        b0 b0VarProvideClientRetrofit = provideClientRetrofit(c0VarProvideClientOkHttp);
        y.h(b0VarProvideClientRetrofit, "provideClientRetrofit(...)");
        this.retrofitClient = b0VarProvideClientRetrofit;
        if (b0VarProvideClientRetrofit == null) {
            y.w("retrofitClient");
            b0VarProvideClientRetrofit = null;
        }
        ClientService clientServiceProvideClientService = provideClientService(b0VarProvideClientRetrofit);
        y.h(clientServiceProvideClientService, "provideClientService(...)");
        this.serviceClient = clientServiceProvideClientService;
        if (clientServiceProvideClientService == null) {
            y.w("serviceClient");
            clientServiceProvideClientService = null;
        }
        setClientDataSource(provideClientDataSource(clientServiceProvideClientService, this.baseDataSource));
        c0 c0VarProvideUserOkHttp = provideUserOkHttp(token, requestToken);
        this.okHttpUser = c0VarProvideUserOkHttp;
        if (c0VarProvideUserOkHttp == null) {
            y.w("okHttpUser");
            c0VarProvideUserOkHttp = null;
        }
        b0 b0VarProvideUserRetrofit = provideUserRetrofit(c0VarProvideUserOkHttp);
        y.h(b0VarProvideUserRetrofit, "provideUserRetrofit(...)");
        this.retrofitUser = b0VarProvideUserRetrofit;
        if (b0VarProvideUserRetrofit == null) {
            y.w("retrofitUser");
            b0VarProvideUserRetrofit = null;
        }
        UserService userServiceProvideUserService = provideUserService(b0VarProvideUserRetrofit);
        y.h(userServiceProvideUserService, "provideUserService(...)");
        this.serviceUser = userServiceProvideUserService;
        if (userServiceProvideUserService == null) {
            y.w("serviceUser");
            userServiceProvideUserService = null;
        }
        setUserDataSource(provideUserDataSource(userServiceProvideUserService, this.baseDataSource));
        c0 c0VarProvideCertifiedOkHttp = provideCertifiedOkHttp(token, requestToken);
        this.okHttpCertified = c0VarProvideCertifiedOkHttp;
        if (c0VarProvideCertifiedOkHttp == null) {
            y.w("okHttpCertified");
            c0VarProvideCertifiedOkHttp = null;
        }
        b0 b0VarProvideCertifiedRetrofit = provideCertifiedRetrofit(c0VarProvideCertifiedOkHttp);
        y.h(b0VarProvideCertifiedRetrofit, "provideCertifiedRetrofit(...)");
        this.retrofitCertified = b0VarProvideCertifiedRetrofit;
        if (b0VarProvideCertifiedRetrofit == null) {
            y.w("retrofitCertified");
            b0VarProvideCertifiedRetrofit = null;
        }
        CertifiedInfoService certifiedInfoServiceProvideCertifiedService = provideCertifiedService(b0VarProvideCertifiedRetrofit);
        y.h(certifiedInfoServiceProvideCertifiedService, "provideCertifiedService(...)");
        this.serviceCertified = certifiedInfoServiceProvideCertifiedService;
        if (certifiedInfoServiceProvideCertifiedService == null) {
            y.w("serviceCertified");
            certifiedInfoServiceProvideCertifiedService = null;
        }
        setCertifiedInfoDataSource(provideCertifiedDataSource(certifiedInfoServiceProvideCertifiedService, this.baseDataSource));
        c0 c0VarProvideReportOkHttp = provideReportOkHttp(token, requestToken);
        this.okHttpReport = c0VarProvideReportOkHttp;
        if (c0VarProvideReportOkHttp == null) {
            y.w("okHttpReport");
            c0VarProvideReportOkHttp = null;
        }
        b0 b0VarProvideReportRetrofit = provideReportRetrofit(c0VarProvideReportOkHttp);
        y.h(b0VarProvideReportRetrofit, "provideReportRetrofit(...)");
        this.retrofitReport = b0VarProvideReportRetrofit;
        if (b0VarProvideReportRetrofit == null) {
            y.w("retrofitReport");
            b0VarProvideReportRetrofit = null;
        }
        ReportService reportServiceProvideReportService = provideReportService(b0VarProvideReportRetrofit);
        y.h(reportServiceProvideReportService, "provideReportService(...)");
        this.serviceReport = reportServiceProvideReportService;
        if (reportServiceProvideReportService == null) {
            y.w("serviceReport");
            reportServiceProvideReportService = null;
        }
        setReportDataSource(provideReportDataSource(reportServiceProvideReportService, this.baseDataSource));
        c0 c0VarProvideLinkedOkHttp = provideLinkedOkHttp(token, requestToken);
        this.okHttpLinked = c0VarProvideLinkedOkHttp;
        if (c0VarProvideLinkedOkHttp == null) {
            y.w("okHttpLinked");
            c0VarProvideLinkedOkHttp = null;
        }
        b0 b0VarProvideLinkedRetrofit = provideLinkedRetrofit(c0VarProvideLinkedOkHttp);
        y.h(b0VarProvideLinkedRetrofit, "provideLinkedRetrofit(...)");
        this.retrofitLinked = b0VarProvideLinkedRetrofit;
        if (b0VarProvideLinkedRetrofit == null) {
            y.w("retrofitLinked");
            b0VarProvideLinkedRetrofit = null;
        }
        LinkedDeviceService linkedDeviceServiceProvideLinkedService = provideLinkedService(b0VarProvideLinkedRetrofit);
        y.h(linkedDeviceServiceProvideLinkedService, "provideLinkedService(...)");
        this.serviceLinked = linkedDeviceServiceProvideLinkedService;
        if (linkedDeviceServiceProvideLinkedService == null) {
            y.w("serviceLinked");
            linkedDeviceServiceProvideLinkedService = null;
        }
        setLinkedDeviceDataSource(provideLinkedDataSource(linkedDeviceServiceProvideLinkedService, this.baseDataSource));
        c0 c0VarProvideStickerOkHttp = provideStickerOkHttp(token, requestToken);
        this.okHttpSticker = c0VarProvideStickerOkHttp;
        if (c0VarProvideStickerOkHttp == null) {
            y.w("okHttpSticker");
            c0VarProvideStickerOkHttp = null;
        }
        b0 b0VarProvideStickerRetrofit = provideStickerRetrofit(c0VarProvideStickerOkHttp);
        y.h(b0VarProvideStickerRetrofit, "provideStickerRetrofit(...)");
        this.retrofitSticker = b0VarProvideStickerRetrofit;
        if (b0VarProvideStickerRetrofit == null) {
            y.w("retrofitSticker");
            b0VarProvideStickerRetrofit = null;
        }
        StickerService stickerServiceProvideStickerService = provideStickerService(b0VarProvideStickerRetrofit);
        y.h(stickerServiceProvideStickerService, "provideStickerService(...)");
        this.serviceSticker = stickerServiceProvideStickerService;
        if (stickerServiceProvideStickerService == null) {
            y.w("serviceSticker");
            stickerServiceProvideStickerService = null;
        }
        setStickerDataSource(provideStickerDataSource(stickerServiceProvideStickerService, this.baseDataSource));
        c0 c0VarProvideCatalogueOkHttp = provideCatalogueOkHttp(token, requestToken);
        this.okHttpCatalogue = c0VarProvideCatalogueOkHttp;
        if (c0VarProvideCatalogueOkHttp == null) {
            y.w("okHttpCatalogue");
            c0VarProvideCatalogueOkHttp = null;
        }
        b0 b0VarProvideCatalogueRetrofit = provideCatalogueRetrofit(c0VarProvideCatalogueOkHttp);
        y.h(b0VarProvideCatalogueRetrofit, "provideCatalogueRetrofit(...)");
        this.retrofitCatalogue = b0VarProvideCatalogueRetrofit;
        if (b0VarProvideCatalogueRetrofit == null) {
            y.w("retrofitCatalogue");
            b0VarProvideCatalogueRetrofit = null;
        }
        CatalogueService catalogueServiceProvideCatalogueService = provideCatalogueService(b0VarProvideCatalogueRetrofit);
        y.h(catalogueServiceProvideCatalogueService, "provideCatalogueService(...)");
        this.serviceCatalogue = catalogueServiceProvideCatalogueService;
        if (catalogueServiceProvideCatalogueService == null) {
            y.w("serviceCatalogue");
        } else {
            catalogueService = catalogueServiceProvideCatalogueService;
        }
        setCatalogueDataSource(provideCatalogueDataSource(catalogueService, this.baseDataSource));
        this.fullInit = true;
    }

    public final void setAuthDataSource(AuthDataSource authDataSource) {
        y.i(authDataSource, "<set-?>");
        this.authDataSource = authDataSource;
    }

    public final void setCatalogueDataSource(CatalogueDataSource catalogueDataSource) {
        y.i(catalogueDataSource, "<set-?>");
        this.catalogueDataSource = catalogueDataSource;
    }

    public final void setCertifiedInfoDataSource(CertifiedInfoDataSource certifiedInfoDataSource) {
        y.i(certifiedInfoDataSource, "<set-?>");
        this.certifiedInfoDataSource = certifiedInfoDataSource;
    }

    public final void setClientDataSource(ClientDataSource clientDataSource) {
        y.i(clientDataSource, "<set-?>");
        this.clientDataSource = clientDataSource;
    }

    public final void setLinkedDeviceDataSource(LinkedDeviceDataSource linkedDeviceDataSource) {
        y.i(linkedDeviceDataSource, "<set-?>");
        this.linkedDeviceDataSource = linkedDeviceDataSource;
    }

    public final void setReportDataSource(ReportDataSource reportDataSource) {
        y.i(reportDataSource, "<set-?>");
        this.reportDataSource = reportDataSource;
    }

    public final void setStickerDataSource(StickerDataSource stickerDataSource) {
        y.i(stickerDataSource, "<set-?>");
        this.stickerDataSource = stickerDataSource;
    }

    public final void setUserDataSource(UserDataSource userDataSource) {
        y.i(userDataSource, "<set-?>");
        this.userDataSource = userDataSource;
    }
}
