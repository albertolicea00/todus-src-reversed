package cu.todus.android.constants;

import java.util.Objects;

/**
 * Determines whether an S3 URL requires authentication headers.
 *
 * @obfuscated_class cu.todus.android.constants.HeadersChecker
 */
public final class HeadersChecker {
    public static final HeadersChecker INSTANCE = new HeadersChecker();

    private HeadersChecker() {
    }

    public boolean needHeaders(String url) {
        Objects.requireNonNull(url, "url");
        return !(url.contains("s3.todus.cu/official")
                || url.contains("s3.todus.cu/catalog")
                || url.contains("s3.todus.cu/videodown")
                || url.contains("s3.todus.cu/status")
                || url.contains("s3.todus.cu/stream"));
    }
}
