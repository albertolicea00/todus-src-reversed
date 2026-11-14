# Security & Cryptography

Target: `cu.todus.android` v2.1.2 (versionCode `30102`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Populate with concrete evidence from `app/AndroidManifest.xml`, `src/`, and `smali/` after decompiling.

## Audit Checklist

1. **Manifest Security Posture**
   - `android:debuggable`, `android:allowBackup`, `android:usesCleartextTraffic`, and `android:requestLegacyExternalStorage`.
   - Exported Activities, Services, BroadcastReceivers, and ContentProviders (`FileProvider` path configurations).

2. **Authentication & Session Management (`auth.todus.cu`)**
   - Phone number registration and SMS verification (`READ_SMS`, `RECEIVE_SMS`) flow.
   - JWT / OAuth / custom token structure, refresh mechanism, expiration handling, and local credential storage.

3. **Message & Media Cryptography**
   - End-to-end or transport-layer encryption schemes (AES, RSA, Signal protocol, or custom ciphers).
   - Key generation, key exchange, IV handling, and hardcoded secrets or salts in DEX/native libraries.

4. **Local Data Protection**
   - Plaintext vs. encrypted storage in SQLite/Room databases and `SharedPreferences` / `EncryptedSharedPreferences`.
