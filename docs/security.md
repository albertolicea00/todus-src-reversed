# Authentication & Security

Static analysis of `cu.todus.android` authentication, TLS handling, cryptography, and manifest exposure.

## Authentication & Token Flow

- Registration and token issuance use Protobuf messages (`cu.todus.proto.ApiProto`) over `https://auth.todus.cu/` (`AuthService`):
  1. `v2/auth/users.reserve` (`ProtoUserReserveRequest`)
  2. `v2/auth/users.register` (`ProtoUserRegisterRequest` → `ProtoUserRegisterResponse`)
  3. `v2/auth/token` (`ProtoUserAuthTokenRequest` → `ProtoUserAuthTokenResponse`)
  4. `v2/auth/check` (`ProtoAuthCheckRequest`)
- Authenticated REST calls attach `Authorization: Bearer <token>` and refresh expired tokens synchronously via `TokenAuthenticator`.

## TLS & Certificate Handling

- **Bundled X.509 Pool** (`RetrofitModule`): Loads `R.raw.todus_cert_ago_2024` and `R.raw.todus_cert_may_2025` into `certPool`.
- **`allowAllCertificated()`** (`RetrofitModule.Companion`): Despite its name, when `AppVolatileState.isCertificateValid == false`, it builds an `X509TrustManager` whose `checkClientTrusted` and `checkServerTrusted` require at least one certificate in the presented chain to equal a certificate in `certPool` (throwing `CertificateException` otherwise).
- **XMPP & WebRTC TLS**: `ToDusXMPPFactoryConfiguration` sets `SecurityMode.disabled` on Smack while passing the custom `SSLSocketFactory`/`X509TrustManager` from `allowAllCertificated()`. `StreamPeerConnectionFactory` configures TURN `IceServer` entries with `PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_INSECURE_NO_CHECK`.
- **HTTP Logging**: `RetrofitModule` sets OkHttp logging to `Level.BODY` (`eg.a.b.BODY`) in the `production` `pFast` build (`BuildConfig.DEBUG == false`).

## Cryptography Findings

- **`cu.todus.android.backup.AESUtils`**: Despite the class name, `encrypt()` and `decrypt()` instantiate `Cipher.getInstance("Blowfish/CBC/PKCS5Padding")` using `SecretKeySpec(..., "Blowfish")` and a static 8-byte IV `"abcdefgh"`.
- **Hashing (`HashUtils`, `MediaUtil`)**: Uses `MD5` (e.g., XMPP resource `<md5(username)>_Android`) and `SHA-256`.

## Manifest & Component Exposure (`app/AndroidManifest.xml`)

- Exported activities include `LoadingActivity`, `MainActivity` (deep links for `chat.todus.cu` and `todus.cu`), `StartActivity`, `AuthActivity`, `PlayerActivity`, `CallActivity`, `AudioCallActivity`, `VideoCallActivity`, `IntentReceiverActivity`, plus `androidx.test.core.app.InstrumentationActivityInvoker$*` and `androidx.compose.ui.tooling.PreviewActivity` left in the manifest.
- `android:networkSecurityConfig` enforces HTTPS for public `*.todus.cu` domains while permitting cleartext HTTP to `10.37.41.*` development/internal IPs (including `provideLinkedDeviceUrl` pointing to `http://10.37.41.190:8086/`).
