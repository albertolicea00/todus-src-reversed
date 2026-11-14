# TODO — toDus Reverse Engineering

## Extraction & Setup

- [x] Verify APK identity (SHA-256, package `cu.todus.android`, version `2.1.2`, code `30102`, SDK levels)
- [x] Initialize repository directory structure, documentation templates, and toolchain scripts
- [ ] Inventory APK contents (DEX files, assets, native `.so` libraries, resources)
- [ ] Run `make decompile` to extract JADX Java (`src/`), Apktool smali (`smali/`), manifest, resources (`app/res/`), and assets (`app/assets/`)
- [ ] Archive local smali disassembly into `.workspace/archives/smali-2.1.2.30102.zip` and record its SHA-256
- [ ] Verify JADX decompilation quality, error count, and Kotlin/Java class distribution
- [ ] Decode and analyze `app/AndroidManifest.xml` (activities, services, receivers, providers, permissions, intent filters, deep links)
- [ ] Extract resource strings, endpoints, and configuration constants

## Clean Java Reconstruction

- [ ] Generate initial reproducible [source-to-clean inventory](docs/reconstruction-inventory.md) after decompilation (`make inventory`)
- [ ] Identify named (unobfuscated) classes and infer obfuscated sub-package roles in `cu.todus.android`
- [ ] Populate initial high-confidence class mappings in `mappings/classes.json`
- [ ] Classify main-package sources in [unmapped-source-review.md](docs/unmapped-source-review.md) (application behavior, support, generated, library)
- [ ] Reconstruct core application entry points (`Application` subclass, splash/launcher, authentication activities)
- [ ] Reconstruct domain entities, database models, and protocol message classes
- [ ] Set up local `target-bytecode.jar` with dex2jar and run `make compile-audit`

## Architecture & Components

- [ ] Map application startup flow and dependency injection structure
- [ ] Document foreground/background services responsible for persistent messaging connections
- [ ] Document broadcast receivers (`RECEIVE_BOOT_COMPLETED`, `RECEIVE_SMS`, connectivity listeners)
- [ ] Document ContentProviders and `FileProvider` configurations
- [ ] Inspect bundled native libraries (`lib/*.so`) and JNI bridges

## Messaging & Real-Time Protocol

- [ ] Identify core messaging transport protocol (`im.todus.cu` — XMPP, WebSocket, Protobuf, gRPC, or custom framing)
- [ ] Document connection establishment, authentication handshake, keep-alive pings, and reconnection strategy
- [ ] Reverse engineer message stanza/frame serialization and payload schemas
- [ ] Trace 1-to-1 message states (sending, sent, delivered, read receipts, typing indicators, presence)
- [ ] Trace multi-user group chat creation, roster management, roles, and group message broadcasting
- [ ] Document voice note recording, audio encoding, and playback pipeline
- [ ] Analyze real-time communication / signaling (`rtc.todus.cu`) for calls or live media

## Networking, Media & Storage Endpoints

- [ ] Extract all hardcoded `*.todus.cu` and external URLs from DEX and resources
- [ ] Document HTTP client stack (OkHttp/Retrofit/Ktor), interceptors, headers, and User-Agent format
- [ ] Trace media upload and download flows (`s3.todus.cu`, `upload.todus.cu`), pre-signed URLs, and chunking
- [ ] Analyze `reserve.todus.cu` and `api.todus.cu` REST/RPC endpoints
- [ ] Trace in-app update check and APK installation mechanism (`REQUEST_INSTALL_PACKAGES`)

## Authentication & Security

- [ ] Audit manifest security flags (`debuggable`, `allowBackup`, `usesCleartextTraffic`, exported components)
- [ ] Trace phone number registration and SMS OTP verification flow (`auth.todus.cu`, `READ_SMS`, `RECEIVE_SMS`)
- [ ] Analyze authentication token format (JWT/OAuth/custom), token refresh flow, and session lifecycle
- [ ] Audit TLS configuration, custom `X509TrustManager` or `CertificatePinner`, and certificate pinning strength
- [ ] Identify cryptographic primitives (AES/RSA/Curve25519/Signal), key derivation, IV usage, and any hardcoded keys or salts
- [ ] Audit local credential and token storage in `SharedPreferences` / Android Keystore

## Local Storage & Database

- [ ] Identify database engine and ORM (Room, SQLiteOpenHelper, ORMLite, Realm, or SQLCipher)
- [ ] Extract complete database schema (tables, columns, indices, foreign keys) and schema version migrations
- [ ] Document message, conversation, contact, and group persistence models
- [ ] Map all `SharedPreferences` files and keys used across the application
- [ ] Document media cache layout and external storage file handling (`MANAGE_EXTERNAL_STORAGE`, `READ_MEDIA_*`)

## UI & Features

- [ ] Map main navigation structure (chats list, contacts, groups, settings, profile)
- [ ] Document contact discovery and address book synchronization (`READ_CONTACTS`)
- [ ] Document calendar integration and appointment sharing (`READ_CALENDAR`, `WRITE_CALENDAR`)
- [ ] Document business catalog and notification gateway features
- [ ] Document location sharing (`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`, `ACCESS_BACKGROUND_LOCATION`)
- [ ] Document QR code scanning / generation features (`CAMERA`)

## Dynamic & Runtime Checks (Isolated Emulator)

- [ ] Launch APK in an isolated, network-restricted Android emulator and capture initial startup behavior
- [ ] Inspect UI hierarchy and compare with static layout/navigation analysis
- [ ] Record runtime observations and safety boundaries in [runtime-validation.md](docs/runtime-validation.md)
