# TODO — toDus Reverse Engineering

## Extraction & Setup

- [x] Verify APK identity (SHA-256, package `cu.todus.android`, version `2.1.2`, code `30102`, SDK levels)
- [x] Initialize repository directory structure, documentation templates, and toolchain scripts
- [x] Inventory APK contents (DEX files, assets, native `.so` libraries, resources)
- [x] Run `make decompile` to extract JADX Java (`src/`), Apktool smali (`smali/`), manifest, resources (`app/res/`), and assets (`app/assets/`)
- [x] Archive local smali disassembly into `.workspace/archives/smali-2.1.2.30102.zip` and record its SHA-256
- [x] Verify JADX decompilation quality, error count, and Kotlin/Java class distribution
- [x] Decode and analyze `app/AndroidManifest.xml` (activities, services, receivers, providers, permissions, intent filters, deep links)
- [x] Extract resource strings, endpoints, and configuration constants

## Clean Java Reconstruction

- [x] Generate initial reproducible [source-to-clean inventory](docs/reconstruction-inventory.md) after decompilation (`make inventory`)
- [x] Identify named (unobfuscated) classes and infer obfuscated sub-package roles in `cu.todus.android`
- [x] Populate initial high-confidence class mappings in `mappings/classes.json`
- [x] Classify main-package sources in [unmapped-source-review.md](docs/unmapped-source-review.md) (application behavior, support, generated, library)
- [x] Reconstruct core application entry points (`Application` subclass, splash/launcher, authentication activities)
- [ ] Reconstruct domain entities, database models, and protocol message classes
- [ ] Set up local `target-bytecode.jar` with dex2jar and run `make compile-audit`

## Architecture & Components

- [x] Map application startup flow and dependency injection structure
- [x] Document foreground/background services responsible for persistent messaging connections
- [x] Document broadcast receivers (`DirectReplyIntent`, `CancelTransferReceiver`, `CallIntentReceiver`)
- [x] Document ContentProviders and `FileProvider` configurations
- [x] Inspect bundled native libraries (`lib/*.so`) and JNI bridges

## Messaging & Real-Time Protocol

- [x] Identify core messaging transport protocol (`im.todus.cu` — Smack XMPP over TCP with zlib compression)
- [x] Document connection establishment, authentication handshake, keep-alive pings, and reconnection strategy
- [x] Reverse engineer message stanza/frame serialization and extension/IQ namespaces
- [ ] Trace 1-to-1 message states (sending, sent, delivered, read receipts, typing indicators, presence)
- [ ] Trace multi-user group chat creation, roster management, roles, and group message broadcasting
- [ ] Document voice note recording, audio encoding, and playback pipeline
- [x] Analyze real-time communication / signaling (WebRTC `SignalingCommand`, `StreamPeerConnectionFactory`, `todus:turn:cred`)

## Networking, Media & Storage Endpoints

- [x] Extract all hardcoded `*.todus.cu` and external URLs from DEX and resources
- [x] Document HTTP client stack (OkHttp/Retrofit, `ProtobufConverterFactoryV2`, `TokenAuthenticator`, `ToDus 2.1.2` User-Agent)
- [x] Trace media upload and download flows (`s3.todus.cu`, `DirectUploadCallbackFlow`) and endpoint paths
- [x] Analyze `auth.todus.cu`, `client.todus.cu`, `stickers.todus.cu`, and `todus.cu/catalog/` REST/Protobuf endpoints
- [x] Trace in-app update check and APK installation mechanism (`UpdateDownloadService`, `toDus_latest.apk`)

## Authentication & Security

- [x] Audit manifest security flags (`cleartextTrafficPermitted`, exported components, `InstrumentationActivityInvoker`)
- [x] Trace phone number registration and auth flow (`auth.todus.cu` Protobuf `v2/auth/*` endpoints)
- [x] Analyze authentication token format, `TokenAuthenticator` refresh flow, and session lifecycle
- [x] Audit TLS configuration (`todus_cert_ago_2024`, `todus_cert_may_2025`, `allowAllCertificated()`, WebRTC `TLS_CERT_POLICY_INSECURE_NO_CHECK`)
- [x] Identify cryptographic primitives (`AESUtils` Blowfish/CBC/PKCS5Padding with static IV `"abcdefgh"`, MD5/SHA-256)
- [ ] Audit local credential and token storage in `Z17Preferences` / Android Keystore

## Local Storage & Database

- [x] Identify database engine and ORM (Room: `ToDusDatabase` v11, `CacheDatabase` v6)
- [x] Extract database entities (15 in `toDus.db`, 3 in `cache.db`) and schema version migrations (`2->11`)
- [ ] Document message, conversation, contact, and group persistence models in full detail
- [x] Map all `PreferencesModule` keys used across the application (`Z17Preferences`)
- [ ] Document media cache layout and external storage file handling

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
