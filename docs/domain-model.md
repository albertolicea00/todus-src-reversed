# Domain Model

Entity and enum catalog derived from `src/cu/todus/android/data/db/entity/`, `src/cu/todus/android/data/db/pojo/`, and `src/cu/todus/android/webrtc/`.

## Core Entities (`ToDusDatabase`)

- **Identity & Contacts**: `User`, `Contact`, `RosterChange`, `LinkedDevice`.
- **Conversations & Messaging**: `Room`, `UserRoomJoin`, `Message`, `Attachment`, `MarkerAction`, `Reaction`, `ChunkEntity`.
- **Stories, Stickers & Config**: `Status`, `StickerPack`, `Sticker`, `Config` (`Heritage`, `Values`).

## Cache Entities (`CacheDatabase`)

- **Catalogue & Bots**: `Product`, `WelcomeMessage`, `BotShortcut`.

## POJOs & Message Content Models (`data/db/pojo/`)

- **Room / User Views**: `RoomItemView`, `RoomMember`, `ChannelSubscriber`, `FollowPartner`, `Friend`, `NearPartner`, `Partner`, `UserCommon`, `MessageWithAttachments`, `MessageWithPartnerWithReactions`, `MessageWithPartnerWithRoomWithReactions`, `MsgWithDate`, `MarkerWithPartner`, `ReactionWithPartner`, `StatusForPagination`, `StatusWithPartnersOrRooms`, `StickerGroup`.
- **Message Content (`data/db/pojo/content/`)**: `AudioContent`, `ButtonContent`, `ButtonTemplate`, `LocationContent`, `LinkEntity`, and media/file attachment descriptors.

## Key Enums

- **`Service.ApplicationEnvironment`**: `LOCAL`, `PROD_2`, `PROD`, `F5`.
- **`SignalingCommand`** (`webrtc`): `CALL`, `PICKED`, `OFFER`, `ANSWER`, `ICE`, `CONFIG`, `REJECT`, `END`, `CHECKING_REQUEST`, `CHECKING_RESPONSE`.
- **`ConfigKey`** (`webrtc`): `CAMERA`, `MIC`, `SOUND`.
