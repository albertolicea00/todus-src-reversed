# Networking, Media & Storage Endpoints

Static analysis of `cu.todus.android.constants.Service`, `cu.todus.android.di.RetrofitModule`, `cu.todus.android.rest.*`, and `app/res/xml/network_security_config.xml`.

## HTTP Stack & Serialization

- **Clients**: OkHttp + Retrofit (`RetrofitModule`) with `ProtobufConverterFactoryV2` (`cu.todus.proto.ApiProto`), Gson, and `NullOnEmptyConverterFactory`.
- **User-Agent** (`TokenAuthenticator`): `ToDus 2.1.2 <serviceName>` (default `serviceName = "ToDus"`).
- **Logging**: `RetrofitModule` attaches an OkHttp logging interceptor configured at `Level.BODY` (`eg.a.b.BODY`).
- **Token Refresh**: `TokenAuthenticator` handles HTTP 401 challenges via `requestToken`, injecting `Authorization: Bearer <token>`.

## `*.todus.cu` & Internal Endpoints (`Service`)

| Service | `PROD` / `PROD_2` | `F5` (Test) | `LOCAL` |
| :--- | :--- | :--- | :--- |
| **Auth** | `https://auth.todus.cu/` | `https://auth-test.todus.cu/` | `https://auth.todus.cu/` |
| **Client** | `https://client.todus.cu/` | `https://client-test.todus.cu/` | `https://client.todus.cu/` |
| **Chat / Deep Links** | `https://chat.todus.cu/` | `https://chat-test.todus.cu/` | `https://chat.todus.cu/` |
| **S3 Media** | `https://s3.todus.cu/` | `https://s3-test.todus.cu/` | `https://s3.todus.cu/` |
| **Stickers** | `https://stickers.todus.cu/` | `https://stickers-test.todus.cu/` | `https://stickers.todus.cu/` |
| **Catalogue** | `https://todus.cu/catalog/` | `https://todus.cu/catalog/` | `http://10.37.41.159:8086/catalog/` |
| **Linked Devices** | `http://10.37.41.190:8086/` | `http://10.37.41.190:8086/` | `http://10.37.41.190:8086/` |
| **IM (XMPP)** | `im.todus.cu` (`1756` / `5443`) | `im-test.todus.cu` (`1756`) | `10.37.41.107` (`1756`) |

Additional observed hosts/paths:
- **Maps**: `https://map.todus.cu/styles/basic-preview/static/<lon>,<lat>,<zoom>/512x512.png` (`TokenAuthenticator.getMapUrl`).
- **Profile / Terms / Updates**: `profile.todus.cu`, `https://www.todus.cu/landing/terms`, `https://s3.todus.cu/official/todus/release/rel/toDus_latest.apk`.

## REST Paths (`Service.Endpoint`)

- **Auth (`AuthService`)**: `v2/auth/users.reserve`, `v2/auth/users.register`, `v2/auth/token`, `v2/auth/check`, `v3/preview` (`linkInfo`).
- **User / Client / Report**: `v2/todus/users.me`, `card/info/{uid}`, `info/{uid}`, `card/subscribe/{uid}`, `card/unsubscribe/{uid}`, `todus/release/rel/latest`, `todus/release/bet/latest`, `v1/report`.
- **Stickers & Linked Devices**: `v1/stickers/packs/{limit}/{offset}`, `v1/stickers/info/{pack_name}`, `version`, `list`, `logout`.
- **Catalogue**: `{todus_id}/{limit}/{offset}`, `shop/{limit}/{offset}`, `product/{todus_id}/{id}`, `product`, `product/{id}`, `share/product/{id}`, `request/product/{id}`, `search/tags/{todus_id}`, `search/products/tag/{todus_id}/{tag}/{limit}/{offset}`.

## Network Security Config (`network_security_config.xml`)

- `base-config` sets `cleartextTrafficPermitted="false"`.
- `cleartextTrafficPermitted="false"` is also explicit for `im.todus.cu`, `todus.cu`, `chat.todus.cu`, `s3.todus.cu`, `client.todus.cu`, `auth.todus.cu`.
- `cleartextTrafficPermitted="true"` is enabled for internal RFC1918 hosts `10.37.41.{159,164,180,184,190,191,194,195,199}`.
