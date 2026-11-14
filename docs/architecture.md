# Architecture Overview

Target: `cu.todus.android` v2.1.2 (versionCode `30102`), SHA-256 `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`.

> [!NOTE]
> **Status:** Pre-decompilation baseline. Only APK badging metadata (`aapt2 dump badging`) has been extracted so far. Run `make decompile` to populate `src/`, `smali/`, `app/res/`, `app/assets/`, and `app/AndroidManifest.xml`.

## Build & Package Properties

| Property | Value |
| :--- | :--- |
| **Package Name** | `cu.todus.android` |
| **Version Name** | `2.1.2` |
| **Version Code** | `30102` |
| **Compile SDK** | `36` (Android 16) |
| **Min SDK** | `23` (Android 6.0) |
| **Target SDK** | `36` (Android 16) |
| **APK Size** | 71,554,413 bytes (~68 MB) |

## Declared Permissions (from `aapt2 dump badging`)

- Account & Identity: `AUTHENTICATE_ACCOUNTS` (maxSdk 22), `GET_ACCOUNTS` (maxSdk 22), `READ_CONTACTS`
- Network & Connectivity: `INTERNET`, `ACCESS_NETWORK_STATE`, `WAKE_LOCK`, `RECEIVE_BOOT_COMPLETED`
- Telephony & SMS: `READ_PHONE_STATE`, `CALL_PHONE`, `READ_SMS`, `RECEIVE_SMS`
- Media & Hardware: `CAMERA`, `RECORD_AUDIO`, `MODIFY_AUDIO_SETTINGS`, `VIBRATE`, `BODY_SENSORS`
- Storage: `READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`, `MANAGE_EXTERNAL_STORAGE`, `READ_MEDIA_IMAGES`, `READ_MEDIA_VIDEO`
- Calendar & Location: `READ_CALENDAR`, `WRITE_CALENDAR`, `ACCESS_COARSE_LOCATION`, `ACCESS_FINE_LOCATION`, `ACCESS_BACKGROUND_LOCATION`
- App Updates: `REQUEST_INSTALL_PACKAGES`

## Pending Analysis Sections (Post-Decompilation)

- **Manifest Components:** Activities, Services, BroadcastReceivers, ContentProviders, exported flags, and deep links.
- **Application Class & Dependency Injection:** Startup initialization, DI framework (Dagger/Hilt/Koin), and global state.
- **Package Structure & Obfuscation:** ProGuard/R8 obfuscation patterns, Kotlin vs. Java ratio, and module boundaries.
- **Bundled Assets & Native Libraries:** Inspect `app/assets/` and any `.so` libraries (e.g., WebRTC, audio codecs, SQLCipher, or custom JNI).
