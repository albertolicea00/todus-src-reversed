# Local Android runtime validation

Target: `cu.todus.android-v30102.apk`, SHA-256
`8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`.

## Scope and safety rules

When performing dynamic or hybrid-APK validation in an Android emulator:

1. Use an isolated Android Virtual Device (AVD) dedicated to research.
2. Disable radio/network connectivity or isolate traffic unless explicitly inspecting local protocol framing.
3. Do not submit live user credentials, SMS verification codes, or unauthorized requests to production `*.todus.cu` servers.
4. Keep all modified/hybrid APKs, UI hierarchy dumps, screenshots, and logcat captures inside `.workspace/` (excluded from Git).

## Observed results

Pending decompilation and initial static analysis. Record emulator environment, API level, startup behavior, and screen hierarchy comparisons here once dynamic checks are performed.
