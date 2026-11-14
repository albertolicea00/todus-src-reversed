# Messaging & Real-Time Protocol

Target: `cu.todus.android` v2.1.2 (versionCode `30102`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Document confirmed wire protocols, stanza/frame formats, and signaling flows once `src/` and `smali/` are extracted.

## Scope

toDus is an instant messaging and collaborative platform developed at the Universidad de las Ciencias Informáticas (UCI) in collaboration with ETECSA. This document tracks the reverse-engineered messaging transport and real-time signaling layer.

## Areas to Document

1. **Core Messaging Transport (`im.todus.cu`)**
   - Underlying transport protocol (XMPP / WebSocket / gRPC / Protobuf / custom TCP framing).
   - Connection lifecycle, keep-alive/ping intervals, reconnection backoff, and background service management.
   - Message serialization format (Protobuf schemas, XML stanzas, or JSON payloads).

2. **Conversation & Group Semantics**
   - 1-to-1 chat delivery states (sent, delivered, read receipts, typing indicators, presence).
   - Multi-user group chats, participant roles, invitations, and group metadata synchronization.

3. **Real-Time Communication & Signaling (`rtc.todus.cu`)**
   - Voice notes, audio/video calling or live streaming signaling, STUN/TURN configuration, and codec negotiation.

4. **Business, Catalogs & Calendar Events**
   - Structured message payloads for appointments/calendar sharing (`READ_CALENDAR` / `WRITE_CALENDAR`), business catalogs, and notification gateways.
