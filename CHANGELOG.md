# Changelog

## 2026-11-14 — cu.todus.android-v30102.apk — SHA-256: `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`

- Initialized repository directory structure (`app/assets/`, `app/res/`, `app/src/main/java/`, `src/`, `smali/`, `mappings/evidence/`, `scripts/tests/`, `docs/`, `.workspace/bin/`, `.workspace/archives/`) matching `transfermovil-src-reversed` without starting APK decompilation yet.
- Verified target APK metadata (`cu.todus.android` v2.1.2, versionCode `30102`, minSdk `23`, targetSdk `36`, compileSdk `36`, SHA-256 `8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`) and documented reproducible extraction commands in `docs/target-metadata.md`.
- Added `Makefile` and analysis toolchain scripts (`verify-apk.sh`, `decompile.sh`, `search-strings.sh`, `mapping-stats.sh`, `reconstruction-inventory.py`, `update-progress.py`, `compile-reconstruction.py`) configured for `cu.todus.android`.
- Created initial documentation set in `docs/` (`target-metadata.md`, `versioning.md`, `architecture.md`, `messaging-protocol.md`, `networking.md`, `security.md`, `storage.md`, `domain-model.md`, `reconstruction-inventory.md`, `unmapped-source-review.md`, `java-compilation.md`, `runtime-validation.md`).
- Added `README.md` with target metadata, official toDus web and infrastructure references (`todus.cu`, `web.todus.cu`, Apklis, UCI, `*.todus.cu` endpoints), project status, documentation index, versioning strategy, and repository structure.
- Added `AGENTS.md` repository working guide and `TODO.md` reverse-engineering checklist.
