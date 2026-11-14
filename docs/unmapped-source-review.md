# Unmapped Source Review

Classification ledger for `src/cu/` (`2,066` JADX-decompiled Java files from `cu.todus.android-v30102.apk`).

## Package Classification

| Package / Class Group | Classification | Role & Evidence |
| :--- | :--- | :--- |
| `cu.todus.android.BuildConfig`, `R.java`, `databinding.*` | Generated / build artifacts | Standard AGP build constants, resource IDs (`828 KB`), and ViewBinding classes. |
| `cu.todus.android.ToDusApp` & `$*` synthetics | Application entrypoint | DI bootstrap, Sentry init, XMPP/Room startup, `AliveService` lifecycle; 17 core classes reconstructed in `app/src/main/java/cu/todus/android/` and mapped in `mappings/classes.json`. |
| `cu.todus.android.{accountManager,alive,backup,connection,constants,contact,data,db,di,domain,downloadOffline,exceptions,firebase,image,location,media,migration,notification,repositories,rest,s3,sentry,service,session,uiCompose,utils,viewModel,volatileState,webrtc,xmpp}` | Application behavior (readable Kotlin/Java) | Minimally obfuscated first-party application packages; remaining classes beyond the 17 reconstructed core entrypoints are queued for incremental clean reconstruction. |
| `cu.todus.proto.ApiProto` | Generated Protobuf models | `protoc`-generated request/response messages (`ProtoUserReserveRequest`, `ProtoUserRegisterRequest`, `ProtoUserAuthTokenRequest`, `ProtoAuthCheckRequest`, etc.). |
| `cu.z17.*` | Bundled first-party/shared library | Shared `cu.z17.views.*`, `cu.z17.preferences.*`, and `cu.z17.singledi.*` UI/DI/Preferences library used by toDus. |
