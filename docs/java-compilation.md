# Java Compilation Audit

Records the baseline status of `app/src/main/java/` clean Java reconstruction for `cu.todus.android` (`2.1.2`, `versionCode` `30102`).

## Scope

- **Reconstructed clean files (`17` classes)**: Core entrypoints, constants, crypto, Room databases, DI/TLS, REST/auth interfaces, XMPP configuration/IQ, WebRTC signaling/services, and Compose activities under `app/src/main/java/cu/todus/android/`.
- **Status**: Static structural reconstruction with `@obfuscated_class` Javadoc links verified by `make stats` (`scripts/mapping-stats.sh`).
- **Classpath limits**: Full standalone `javac` compilation of `app/src/main/java/` against Android SDK, Room, Smack, Retrofit, OkHttp, Jetpack Compose, and `cu.todus.proto.ApiProto` stubs is deferred to a dedicated Gradle/classpath audit in a subsequent internal release (`2.1.2.30102-v1.1+`).
