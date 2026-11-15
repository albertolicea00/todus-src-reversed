# Changelog

## 2026-11-15 — cu.todus.android-v30102.apk — SHA-256: `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`

- Reconstructed 20 Room entity classes across `cu.todus.android.data.db.entity.{cache,configs,toDus}` (`BotShortcut`, `Product`, `WelcomeMessage`, `Config`, `Heritage`, `Values`, `Attachment`, `ChunkEntity`, `Contact`, `LinkedDevice`, `MarkerAction`, `Message`, `Reaction`, `Room`, `RosterChange`, `Status`, `Sticker`, `StickerPack`, `User`, `UserRoomJoin`).
- Reconstructed 20 constants, exception, and preference classes under `cu.todus.android.{constants,exceptions,data.preferences}` (`CloudType`, `HeadersChecker`, `ToDusException` hierarchy, `AppState`, `AppStateStep`, `CallQuality`, `DataPreferences`, `Owner`, `ReactionsSelected`, `RootEnvironment`, `RosterVersionManager`, `AliveWelcomeMessageDataPreferences`).
- Updated `mappings/classes.json` (`17 -> 57` linked clean classes, `0` mapping issues) and refreshed `README.md` weighted reconstruction progress (`34%` overall; `57/2066` Java files).

## 2026-11-14 — cu.todus.android-v30102.apk — SHA-256: `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`

- Initialized repository directory structure (`app/assets/`, `app/res/`, `app/src/main/java/`, `src/`, `smali/`, `mappings/evidence/`, `scripts/tests/`, `docs/`, `.workspace/bin/`, `.workspace/archives/`) matching `transfermovil-src-reversed` without starting APK decompilation yet.
- Verified target APK metadata (`cu.todus.android` v2.1.2, versionCode `30102`, minSdk `23`, targetSdk `36`, compileSdk `36`, SHA-256 `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`) and documented reproducible extraction commands in `docs/target-metadata.md`.
- Added `Makefile` and analysis toolchain scripts (`verify-apk.sh`, `decompile.sh`, `search-strings.sh`, `mapping-stats.sh`, `reconstruction-inventory.py`, `update-progress.py`, `compile-reconstruction.py`) configured for `cu.todus.android`.
- Created initial documentation set in `docs/` (`target-metadata.md`, `versioning.md`, `architecture.md`, `messaging-protocol.md`, `networking.md`, `security.md`, `storage.md`, `domain-model.md`, `reconstruction-inventory.md`, `unmapped-source-review.md`, `java-compilation.md`, `runtime-validation.md`).
- Added `README.md` with target metadata, official toDus web and infrastructure references (`todus.cu`, `web.todus.cu`, Apklis, UCI, `*.todus.cu` endpoints), project status, documentation index, versioning strategy, and repository structure.
- Added `AGENTS.md` repository working guide and `TODO.md` reverse-engineering checklist.
- Added a `Related Repositories` cross-reference table in `README.md` linking all six Cuban Android reverse-engineering repositories.
- Decompiled `cu.todus.android-v30102.apk` with JADX `1.5.6` (`28,334` classes, `496` errors; `2,066` Java files imported under `src/cu/`) and Apktool `3.0.3` (`app/AndroidManifest.xml`, `app/res/`, `app/assets/PublicSuffixDatabase.list`), and archived local smali as `.workspace/archives/smali-2.1.2.30102.zip` (`SHA-256: bdd73296eff93ec7a8ee5775c8d4d011923e22a26537a71ff0c8a359b0991ab9`).
- Reconstructed 17 core clean Java entrypoints, services, databases, crypto, TLS, XMPP, REST, and WebRTC classes under `app/src/main/java/cu/todus/android/` with `@obfuscated_class` Javadoc links and populated `mappings/classes.json`.
- Documented architecture, XMPP/WebRTC messaging protocols, `*.todus.cu` and `10.37.41.*` endpoints, Blowfish/TLS/manifest security findings, Room schemas (`toDus.db` v11, `cache.db` v6), domain models, unmapped source review, compilation audit, and runtime validation baseline for tag `2.1.2.30102-v1.0`.
- Updated `scripts/update-progress.py` and `README.md` to combine `TODO.md` checklist completion with actual `make stats` source-to-clean reconstruction coverage (`17/2066`, `0.8%`).
