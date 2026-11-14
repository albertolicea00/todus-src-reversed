# Local Storage & Database

Static analysis of `cu.todus.android.db.*` and `cu.todus.android.di.PreferencesModule`.

## Room Databases

### 1. `ToDusDatabase` (`toDus.db`, version `11`)
- **Location**: `src/cu/todus/android/db/ToDusDatabase.java` (`exportSchema = false`).
- **TypeConverters**: `ToDusTypeConverter`, `Data`, `JobTypeConverters`.
- **Migrations**: `MIGRATION_2_3` through `MIGRATION_10_11` (`Migrations.INSTANCE`), with `fallbackToDestructiveMigrationOnDowngrade()` and `allowMainThreadQueries()`.
- **Entities (15)**:
  - `User`, `Room`, `UserRoomJoin`, `Contact`, `RosterChange`
  - `Message`, `Attachment`, `MarkerAction`, `Reaction`, `ChunkEntity`
  - `Status`, `StickerPack`, `Sticker`
  - `LinkedDevice`, `Config`

### 2. `CacheDatabase` (`cache.db`, version `6`)
- **Location**: `src/cu/todus/android/db/CacheDatabase.java` (`exportSchema = false`).
- **Migrations**: `fallbackToDestructiveMigrationOnDowngrade()` and `fallbackToDestructiveMigration()`.
- **Entities (3)**: `Product`, `WelcomeMessage`, `BotShortcut`.

## Preferences (`PreferencesModule`)

- Backed by `cu.z17.preferences.Z17Preferences` (serialized with Gson) plus legacy migration via `ToDus2Migration` / `SharedPreferencesStorage`.
- **Keys**: `KEY_OWNER` (`Owner`), `KEY_DATA_PREFERENCES` (`DataPreferences`), `KEY_SECRET_ROOM_READY`, `KEY_SECRET_ROOM_CODE`, `KEY_SECRET_ROOM_CLEAN_CODE`, `KEY_SENTRY_ACTIVE`, `KEY_ALIAS_SELECTED`, `KEY_THEME_SELECTED`, `KEY_CATALOGUE_VERSION`, `KEY_ALIVE_WELCOME_MESSAGE_DATA_PREFERENCES`, `KEY_REACTIONS_SELECTED`, `KEY_VALID_CERTIFICATE`, `KEY_LAST_VERSION`, `keyRootUrl` (`RootEnvironment`), `keyRequestMode`, `keyPhoneState` (`AppState`), `keyCallQuality` (`CallQuality`), `keyBatterySettingsShowed`.
