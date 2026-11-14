# Architecture & Components

Static analysis of `cu.todus.android` (`2.1.2`, `versionCode` `30102`, `buildType` `pFast`, `flavor` `production`).

## Application Entrypoint & DI

- **`cu.todus.android.ToDusApp`** (`Application`): Bootstraps dependency injection modules (`PreferencesModule`, `DatabaseModule`, `RetrofitModule`, `MainModule`, `MediaModule`), `Z17CameraModule`, `Z17VideoModule`, `Z17CoilDecoders`, `Z17Markown`, and `SentryDataSource`, then observes `appState` to start `AliveService`, XMPP, and notification channels.
- **`cu.todus.android.BuildConfig`**: `APPLICATION_ID = "cu.todus.android"`, `BUILD_TYPE = "pFast"`, `FLAVOR = "production"`, `VERSION_CODE = 30102`, `VERSION_NAME = "2.1.2"`.

## Manifest Components (`app/AndroidManifest.xml`)

### Activities
- **`cu.todus.android.uiCompose.loading.LoadingActivity`** (`MAIN`/`LAUNCHER`, `Theme.ToDus.Starting`): Splash/bootstrap Jetpack Compose activity observing `ToDusApp.appState`.
- **`cu.todus.android.uiCompose.main.MainActivity`** (`singleTask`): Main Jetpack Compose host handling deep links for `chat.todus.cu` and `todus.cu` (`https`/`http`).
- **`cu.todus.android.uiCompose.start.StartActivity`**, **`cu.todus.android.uiCompose.auth.AuthActivity`**: Onboarding and SMS/token authentication flows.
- **`cu.todus.android.uiCompose.call.CallActivity`**, **`AudioCallActivity`**, **`VideoCallActivity`** (`supportsPictureInPicture="true"`): WebRTC call UI.
- **`cu.todus.android.uiCompose.player.PlayerActivity`** (`supportsPictureInPicture="true"`): Media player.
- **`cu.todus.android.uiCompose.intentReceiver.IntentReceiverActivity`**: Share target (`SEND`, `SEND_MULTIPLE`, `SENDTO` `sms:`/`smsto:`).

### Services, Receivers & Providers
- **`cu.todus.android.accountManager.AuthenticatorService`**: Android AccountAuthenticator service.
- **`cu.todus.android.firebase.ToDusFirebaseMessagingService`**: Push notification receiver (`FirebaseMessagingService`).
- **`cu.todus.android.alive.AliveService`** (`foregroundServiceType="remoteMessaging"`): Persistent XMPP keepalive foreground service.
- **`cu.todus.android.downloadOffline.DownloadOfflineService`** (`foregroundServiceType="remoteMessaging"`): Offline message/media sync service.
- **`cu.todus.android.utils.UpdateDownloadService`** (`foregroundServiceType="dataSync"`): Self-update APK downloader.
- **`cu.todus.android.webrtc.service.CallService`** (`foregroundServiceType="phoneCall"`): Active WebRTC call foreground service.
- **Receivers**: `DirectReplyIntent`, `CancelTransferReceiver`, `CallIntentReceiver`.
- **Providers**: `androidx.core.content.FileProvider` (`cu.todus.android.provider`), `FirebaseInitProvider`, `JLatexMathInitProvider`.

## Bundled Assets & Native Libraries

- **Assets (`app/assets/`)**: `PublicSuffixDatabase.list` (132 KB, OkHttp public suffix list).
- **Native Libraries** (`arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64`):
  - `libjingle_peerconnection_so.so` (WebRTC native engine)
  - `libandroidx.graphics.path.so`
  - `libdatastore_shared_counter.so`
  - `libimage_processing_util_jni.so`
  - `libsurface_util_jni.so`
- **Obfuscation**: Application packages under `cu.todus.android.*` and `cu.todus.proto.ApiProto` retain readable Kotlin/Java class, method, and `@Metadata` names; R8 obfuscates third-party/support libraries (`pe.*`, `te.*`, `nf.*`, `mi.*`) and Kotlin lambda/coroutine synthetics.
