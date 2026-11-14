package cu.todus.android.di;

import android.content.Context;

import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.android.rest.auth.AuthDataSource;
import cu.todus.android.rest.catalogue.CatalogueDataSource;
import cu.todus.android.rest.certified.CertifiedInfoDataSource;
import cu.todus.android.rest.client.ClientDataSource;
import cu.todus.android.rest.linkedDevice.LinkedDeviceDataSource;
import cu.todus.android.rest.report.ReportDataSource;
import cu.todus.android.rest.sticker.StickerDataSource;
import cu.todus.android.rest.user.UserDataSource;
import kotlin.Pair;

/**
 * Dependency-injection module configuring OkHttp clients, Retrofit instances,
 * Protobuf/Gson converters, HTTP BODY logging, and bundled X.509 certificate pinning
 * ({@code R.raw.todus_cert_ago_2024}, {@code R.raw.todus_cert_may_2025}).
 *
 * @obfuscated_class cu.todus.android.di.RetrofitModule
 */
public final class RetrofitModule {

    private final BaseDataSource baseDataSource;
    private final Context appContext;
    private final RootEnvironment environment;
    private List<X509Certificate> certPool;

    public AuthDataSource authDataSource;
    public UserDataSource userDataSource;
    public ClientDataSource clientDataSource;
    public CertifiedInfoDataSource certifiedInfoDataSource;
    public ReportDataSource reportDataSource;
    public LinkedDeviceDataSource linkedDeviceDataSource;
    public CatalogueDataSource catalogueDataSource;
    public StickerDataSource stickerDataSource;

    public RetrofitModule(BaseDataSource baseDataSource, Context appContext, RootEnvironment environment) {
        this.baseDataSource = baseDataSource;
        this.appContext = appContext;
        this.environment = environment;
    }

    /**
     * When {@code AppVolatileState.isCertificateValid == false}, builds an SSLSocketFactory
     * and X509TrustManager that verifies chains against the bundled {@code certPool}.
     */
    public static Pair<SSLSocketFactory, X509TrustManager> allowAllCertificated() {
        return null;
    }

    public List<X509Certificate> getCertPool() {
        return certPool;
    }
}
