# Networking & Endpoints

Target: `cu.todus.android` v2.1.2 (versionCode `30102`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Known ecosystem domains are listed below as initial references; verify exact hardcoded URLs, HTTP clients, and interceptors from decompiled source.

## Ecosystem & Known Infrastructure Domains

| Domain / URL | Role |
| :--- | :--- |
| `https://www.todus.cu/` | Official portal, documentation, and landing page |
| `https://web.todus.cu/` | Official web client |
| `auth.todus.cu` | Authentication, SMS/OTP verification, and token issuance |
| `im.todus.cu` | Instant messaging real-time server |
| `api.todus.cu` | Core REST/RPC API gateway |
| `s3.todus.cu` / `upload.todus.cu` | Object storage for media, voice notes, avatars, and document attachments |
| `rtc.todus.cu` | Real-Time Communication / signaling server |
| `reserve.todus.cu` | Reserve / failover / reservation service endpoint |
| `https://www.apklis.cu/application/cu.todus.android` | Official Android distribution page on Apklis |

## Pending Analysis Sections (Post-Decompilation)

- **HTTP / Socket Stack:** OkHttp / Retrofit / Ktor / gRPC versions, interceptors, User-Agent strings, and retry policies.
- **Media Upload & Download Flow:** Pre-signed URLs, chunked transfers, compression, and attachment encryption/hashing.
- **TLS & Certificate Pinning:** `network_security_config.xml`, custom `X509TrustManager` / `CertificatePinner`, and cleartext traffic flags.
- **Self-Update Mechanism:** `REQUEST_INSTALL_PACKAGES` usage and version-check endpoints.
