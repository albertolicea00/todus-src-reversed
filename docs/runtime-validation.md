# Runtime Validation

Tracks dynamic verification status for `cu.todus.android` (`2.1.2`, `versionCode` `30102`).

## Status (`2.1.2.30102-v1.0` Baseline)

- **Static baseline complete**: APK verified, decompiled via JADX `1.5.6` and Apktool `3.0.3`, smali archived locally (`smali-2.1.2.30102.zip`), manifest/XML resources/assets extracted, and core classes/protocols documented.
- **Dynamic / Emulator checks (Pending)**:
  - Hybrid APK repackaging & isolated emulator boot check.
  - Runtime inspection of `auth.todus.cu` Protobuf token exchange, `im.todus.cu` XMPP handshake, and `s3.todus.cu` upload/download flows.
  - Runtime verification of `RetrofitModule.allowAllCertificated()` behavior when `AppVolatileState.isCertificateValid` toggles.
