# Messaging & Real-Time Protocol

Static analysis of `cu.todus.android.xmpp.*`, `cu.todus.android.webrtc.*`, and `cu.todus.proto.ApiProto`.

## XMPP Transport (`im.todus.cu`)

toDus uses **Smack** (`org.jivesoftware.smack.tcp.XMPPTCPConnection`) configured by `cu.todus.android.xmpp.ToDusXMPPFactoryConfiguration`:
- **Production domain**: `im.todus.cu` (`Service.Config.SERVER_DOMAIN`); test host `im-test.todus.cu` (`F5` environment); local dev `10.37.41.107`.
- **Ports** (`Service.provideIMPort`): `1756` (`LOCAL`, `PROD`, `F5`) and `5443` (`PROD_2`).
- **Resource**: `<md5(username)>_Android` (`HashUtils.INSTANCE.md5(username) + "_Android"`).
- **Compression & TLS**: `setCompressionEnabled(true)`, `setSendPresence(true)`, and `setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)` with custom `SSLSocketFactory` / `X509TrustManager` from `RetrofitModule.allowAllCertificated()` when `AppVolatileState.isCertificateValid == false`.
- **Message Limits** (`Service.Config`): `MAX_MSG_TEXT_SIZE = 8192`, `MAX_MESSAGE_LENGTH = 65536`.

## Subdomains & MUC / Channels / Status

Defined in `cu.todus.android.constants.Service.Config`:
- **Group Chat (MUC Light)**: `muclight.im.todus.cu` (`SERVER_NAME_MUC = "muclight"`).
- **Channels**: `ch.im.todus.cu` (`SERVER_NAME_CHANNELS = "ch"`).
- **Statuses (Stories)**: `status@status.im.todus.cu` (`STATUS_NAMESPACE = "status"`).
- **Reactions**: `REACTION_NAMESPACE = "reaction"`.

## Custom XMPP Extensions & IQ Namespaces

- **Extensions (`src/cu/todus/android/xmpp/extension/`)**: `audio`, `button`, `call`, `chunk`, `contact`, `deleteOwnerMessage`, `deleted`, `edited`, `event`, `file`, `forward`, `gif`, `groups`, `image`, `link`, `location`, `mention`, `pubDeleted`, `pubEdited`, `reaction`, `refreshToDusId`, `statusExistence`, `sticker`, `streamVideo`, `video`, `voice`.
- **IQ handlers (`src/cu/todus/android/xmpp/iq/`)**: `block`, `call` (`GetCredentialsIQ`, namespace `todus:turn:cred`), `channels`, `error`, `groups`, `last`, `near`, `offline`, `packet`, `privacy`, `push`, `roster`, `s3`, `status`, `version`.

## Real-Time Signaling (WebRTC)

- **Native engine**: `libjingle_peerconnection_so.so` via `cu.todus.android.webrtc.peer.StreamPeerConnectionFactory`.
- **ICE / STUN / TURN**: Hardcodes `stun:l.google.com:19302` plus dynamic TURN URIs retrieved over XMPP via `GetCredentialsIQ` (`todus:turn:cred`), configured with `PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_INSECURE_NO_CHECK`, `SdpSemantics.UNIFIED_PLAN`, `IceTransportsType.ALL`, `BundlePolicy.MAXBUNDLE`, `RtcpMuxPolicy.REQUIRE`, and `iceCandidatePoolSize = 10`.
- **Signaling commands (`SignalingCommand`)**: `CALL`, `PICKED`, `OFFER`, `ANSWER`, `ICE`, `CONFIG` (`ConfigKey`: `CAMERA`, `MIC`, `SOUND`), `REJECT`, `END`, `CHECKING_REQUEST`, `CHECKING_RESPONSE`.
