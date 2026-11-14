package cu.todus.android.xmpp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.StatusExistenceContent;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.data.preferences.RosterVersionManager;
import cu.todus.android.data.xmpp.ChannelInfo;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.data.xmpp.MucInfo;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.downloadOffline.DownloadOfflineUtility;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.s3.download.DownloadDataSource;
import cu.todus.android.s3.upload.UploadDataSource;
import cu.todus.android.s3.upload.UploadStatusDataSource;
import cu.todus.android.sentry.SentryDataSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager;
import cu.todus.android.xmpp.dispatchers.OwnerMarkersManager;
import cu.todus.android.xmpp.dispatchers.OwnerMessageManager;
import cu.todus.android.xmpp.dispatchers.OwnerReactionManager;
import cu.todus.android.xmpp.dispatchers.OwnerStatusManager;
import cu.todus.android.xmpp.extension.audio.ExtensionAudio;
import cu.todus.android.xmpp.extension.audio.ExtensionAudioProvider;
import cu.todus.android.xmpp.extension.button.ExtensionButton;
import cu.todus.android.xmpp.extension.button.ExtensionButtonProvider;
import cu.todus.android.xmpp.extension.call.ExtensionCall;
import cu.todus.android.xmpp.extension.call.ExtensionCallProvider;
import cu.todus.android.xmpp.extension.chunk.ExtensionChunk;
import cu.todus.android.xmpp.extension.chunk.ExtensionChunkProvider;
import cu.todus.android.xmpp.extension.contact.ExtensionContact;
import cu.todus.android.xmpp.extension.contact.ExtensionContactProvider;
import cu.todus.android.xmpp.extension.deleteOwnerMessage.ExtensionDeleteOwnerMessage;
import cu.todus.android.xmpp.extension.deleteOwnerMessage.ExtensionDeleteOwnerMessageProvider;
import cu.todus.android.xmpp.extension.deleted.ExtensionDeleted;
import cu.todus.android.xmpp.extension.deleted.ExtensionDeletedProvider;
import cu.todus.android.xmpp.extension.edited.ExtensionEdited;
import cu.todus.android.xmpp.extension.edited.ExtensionEditedProvider;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import cu.todus.android.xmpp.extension.event.ExtensionEventProvider;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import cu.todus.android.xmpp.extension.file.ExtensionFileProvider;
import cu.todus.android.xmpp.extension.forward.ExtensionForwarded;
import cu.todus.android.xmpp.extension.forward.ExtensionForwardedProvider;
import cu.todus.android.xmpp.extension.gif.ExtensionGif;
import cu.todus.android.xmpp.extension.gif.ExtensionGifProvider;
import cu.todus.android.xmpp.extension.groups.AffiliationsChangeExtensionProvider;
import cu.todus.android.xmpp.extension.groups.ConfigurationsChangeProvider;
import cu.todus.android.xmpp.extension.image.ExtensionImage;
import cu.todus.android.xmpp.extension.image.ExtensionImageProvider;
import cu.todus.android.xmpp.extension.link.ExtensionLinkInfo;
import cu.todus.android.xmpp.extension.link.ExtensionLinkInfoProvider;
import cu.todus.android.xmpp.extension.location.ExtensionLocation;
import cu.todus.android.xmpp.extension.location.ExtensionLocationProvider;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import cu.todus.android.xmpp.extension.mention.ExtensionMentionProvider;
import cu.todus.android.xmpp.extension.pubDeleted.ExtensionPubDeleted;
import cu.todus.android.xmpp.extension.pubDeleted.ExtensionPubDeletedProvider;
import cu.todus.android.xmpp.extension.pubEdited.ExtensionPubEdited;
import cu.todus.android.xmpp.extension.pubEdited.ExtensionPubEditedProvider;
import cu.todus.android.xmpp.extension.reaction.ExtensionReaction;
import cu.todus.android.xmpp.extension.reaction.ExtensionReactionProvider;
import cu.todus.android.xmpp.extension.refreshToDusId.ExtensionRefreshToDusId;
import cu.todus.android.xmpp.extension.refreshToDusId.ExtensionRefreshToDusIdProvider;
import cu.todus.android.xmpp.extension.statusExistence.ExtensionStatusExistence;
import cu.todus.android.xmpp.extension.statusExistence.ExtensionStatusExistenceProvider;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import cu.todus.android.xmpp.extension.sticker.ExtensionStickerProvider;
import cu.todus.android.xmpp.extension.streamVideo.ExtensionStreamVideo;
import cu.todus.android.xmpp.extension.streamVideo.ExtensionStreamVideoProvider;
import cu.todus.android.xmpp.extension.video.ExtensionVideo;
import cu.todus.android.xmpp.extension.video.ExtensionVideoProvider;
import cu.todus.android.xmpp.extension.voice.ExtensionVoice;
import cu.todus.android.xmpp.extension.voice.ExtensionVoiceProvider;
import cu.todus.android.xmpp.iq.block.BlockUserIQ;
import cu.todus.android.xmpp.iq.block.BlockUserIQProvider;
import cu.todus.android.xmpp.iq.block.GetBlockListIQ;
import cu.todus.android.xmpp.iq.block.GetBlockListIQProvider;
import cu.todus.android.xmpp.iq.block.GetBlockListPaginatedIQ;
import cu.todus.android.xmpp.iq.block.GetBlockListPaginatedIQProvider;
import cu.todus.android.xmpp.iq.block.UnBlockUserIQ;
import cu.todus.android.xmpp.iq.block.UnBlockUserIQProvider;
import cu.todus.android.xmpp.iq.call.CallStatusIQ;
import cu.todus.android.xmpp.iq.call.CallStatusIQProvider;
import cu.todus.android.xmpp.iq.call.GetCredentialsIQ;
import cu.todus.android.xmpp.iq.call.GetCredentialsIQProvider;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQById;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQByIdProvider;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQByLink;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQByLinkProvider;
import cu.todus.android.xmpp.iq.channels.CreateChannelIQ;
import cu.todus.android.xmpp.iq.channels.CreateChannelIQProvider;
import cu.todus.android.xmpp.iq.channels.DeletePubFromChannelIQ;
import cu.todus.android.xmpp.iq.channels.DeletePubFromChannelIQProvider;
import cu.todus.android.xmpp.iq.channels.GetChannelAdminsIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelAdminsIQProvider;
import cu.todus.android.xmpp.iq.channels.GetChannelListIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelListIQProvider;
import cu.todus.android.xmpp.iq.channels.GetChannelListPaginatedIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelListPaginatedIQProvider;
import cu.todus.android.xmpp.iq.channels.GetChannelSubscribersIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelSubscribersIQProvider;
import cu.todus.android.xmpp.iq.channels.GetPubByIdIQ;
import cu.todus.android.xmpp.iq.channels.GetPubByIdIQProvider;
import cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ;
import cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQProvider;
import cu.todus.android.xmpp.iq.channels.NotificationChannelEditedIQ;
import cu.todus.android.xmpp.iq.channels.NotificationChannelEditedIQProvider;
import cu.todus.android.xmpp.iq.channels.PublishToChannelIQ;
import cu.todus.android.xmpp.iq.channels.PublishToChannelIQProvider;
import cu.todus.android.xmpp.iq.groups.AddGroupMembersIQ;
import cu.todus.android.xmpp.iq.groups.AddGroupMembersIQProvider;
import cu.todus.android.xmpp.iq.groups.DemoteGroupAdminIQ;
import cu.todus.android.xmpp.iq.groups.DemoteGroupAdminIQProvider;
import cu.todus.android.xmpp.iq.groups.GetGroupListPaginatedIQ;
import cu.todus.android.xmpp.iq.groups.GetGroupListPaginatedIQProvider;
import cu.todus.android.xmpp.iq.groups.GroupInfoByIdIQ;
import cu.todus.android.xmpp.iq.groups.GroupInfoByIdIQProvider;
import cu.todus.android.xmpp.iq.groups.GroupInfoIQByLink;
import cu.todus.android.xmpp.iq.groups.GroupInfoIQByLinkProvider;
import cu.todus.android.xmpp.iq.groups.GroupLinkIQProvider;
import cu.todus.android.xmpp.iq.groups.GroupMembersIQProvider;
import cu.todus.android.xmpp.iq.groups.PromoteGroupAdminIQ;
import cu.todus.android.xmpp.iq.groups.PromoteGroupAdminIQProvider;
import cu.todus.android.xmpp.iq.last.LastIQ;
import cu.todus.android.xmpp.iq.last.LastIQProvider;
import cu.todus.android.xmpp.iq.near.NearGetStatusIQ;
import cu.todus.android.xmpp.iq.near.NearGetStatusIQProvider;
import cu.todus.android.xmpp.iq.near.NearHideIQ;
import cu.todus.android.xmpp.iq.near.NearHideIQProvider;
import cu.todus.android.xmpp.iq.near.NearSetIQ;
import cu.todus.android.xmpp.iq.near.NearSetIQProvider;
import cu.todus.android.xmpp.iq.near.PeopleNearIQ;
import cu.todus.android.xmpp.iq.near.PeopleNearIQProvider;
import cu.todus.android.xmpp.iq.offline.OfflineElement;
import cu.todus.android.xmpp.iq.offline.OfflineElementProvider;
import cu.todus.android.xmpp.iq.privacy.PrivacyAddGetIQProvider;
import cu.todus.android.xmpp.iq.privacy.PrivacyAddUpdateIQProvider;
import cu.todus.android.xmpp.iq.privacy.PrivacyGetIQProvider;
import cu.todus.android.xmpp.iq.privacy.PrivacyUpdateIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterDeleteIQ;
import cu.todus.android.xmpp.iq.roster.RosterDeleteIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterEditToDusIdIQ;
import cu.todus.android.xmpp.iq.roster.RosterEditToDusIdIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterGetHashIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetHashIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterGetListPaginatedIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetListPaginatedIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterGetToDusIdIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetToDusIdIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterGetUsersInfoIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetUsersInfoIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterGetVersionIQ;
import cu.todus.android.xmpp.iq.roster.RosterGetVersionIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterUpdateIQ;
import cu.todus.android.xmpp.iq.roster.RosterUpdateIQProvider;
import cu.todus.android.xmpp.iq.roster.RosterUpdateVersionIQ;
import cu.todus.android.xmpp.iq.roster.RosterUpdateVersionIQProvider;
import cu.todus.android.xmpp.iq.s3.GetUrlIQ;
import cu.todus.android.xmpp.iq.s3.GetUrlIQProvider;
import cu.todus.android.xmpp.iq.s3.PutUrlIQ;
import cu.todus.android.xmpp.iq.s3.PutUrlIQProvider;
import cu.todus.android.xmpp.iq.status.DeleteStatusIQ;
import cu.todus.android.xmpp.iq.status.DeleteStatusIQProvider;
import cu.todus.android.xmpp.iq.status.FollowIQ;
import cu.todus.android.xmpp.iq.status.FollowIQProvider;
import cu.todus.android.xmpp.iq.status.GetFollowInfoIQ;
import cu.todus.android.xmpp.iq.status.GetFollowInfoIQProvider;
import cu.todus.android.xmpp.iq.status.GetFollowersIQ;
import cu.todus.android.xmpp.iq.status.GetFollowersIQProvider;
import cu.todus.android.xmpp.iq.status.GetFollowingIQ;
import cu.todus.android.xmpp.iq.status.GetFollowingIQProvider;
import cu.todus.android.xmpp.iq.status.GetStatusIQ;
import cu.todus.android.xmpp.iq.status.GetStatusIQProvider;
import cu.todus.android.xmpp.iq.status.PublishStatusIQ;
import cu.todus.android.xmpp.iq.status.PublishStatusIQProvider;
import cu.todus.android.xmpp.iq.status.UnFollowIQ;
import cu.todus.android.xmpp.iq.status.UnFollowIQProvider;
import cu.todus.android.xmpp.iq.version.GetUpdateInfoIQ;
import cu.todus.android.xmpp.iq.version.GetUpdateInfoIQProvider;
import cu.todus.android.xmpp.managers.BlocksManager;
import cu.todus.android.xmpp.managers.CallManager;
import cu.todus.android.xmpp.managers.ChannelManager;
import cu.todus.android.xmpp.managers.GroupsManager;
import cu.todus.android.xmpp.managers.LastManager;
import cu.todus.android.xmpp.managers.LocationManager;
import cu.todus.android.xmpp.managers.MessageManager;
import cu.todus.android.xmpp.managers.PresenceManager;
import cu.todus.android.xmpp.managers.PrivacyManager;
import cu.todus.android.xmpp.managers.ProfileManager;
import cu.todus.android.xmpp.managers.RosterManager;
import cu.todus.android.xmpp.managers.StatusManager;
import cu.todus.android.xmpp.managers.UrlManager;
import cu.z17.views.utils.Z17MutableListFlow;
import j$.util.Objects;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ReconnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.UnparseableStanza;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.provided.SASLPlainMechanism;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.blocking.element.BlockListIQ;
import org.jivesoftware.smackx.blocking.element.UnblockContactsIQ;
import org.jivesoftware.smackx.blocking.provider.BlockContactsIQProvider;
import org.jivesoftware.smackx.blocking.provider.BlockListIQProvider;
import org.jivesoftware.smackx.blocking.provider.UnblockContactsIQProvider;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chat_markers.provider.AcknowledgedProvider;
import org.jivesoftware.smackx.chat_markers.provider.DisplayedProvider;
import org.jivesoftware.smackx.chat_markers.provider.MarkableProvider;
import org.jivesoftware.smackx.chat_markers.provider.ReceivedProvider;
import org.jivesoftware.smackx.chatstates.ChatStateToDus;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtensionToDus;
import org.jivesoftware.smackx.chatstates.provider.ChatStateExtensionProvider;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.delay.provider.DelayInformationProvider;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;
import org.jivesoftware.smackx.ping.PingManager;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.jivesoftware.smackx.ping.provider.PingProvider;
import org.jxmpp.jid.impl.JidCreate;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import pe.w0;
import pe.w2;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u008a\u0002\b\u0007\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012(\u0010\u0012\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010!J\u001a\u0010$\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\bH\u0082@¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010!J\u0018\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b*\u0010+J \u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0002¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\bH\u0082@¢\u0006\u0004\b3\u0010'J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010!J\u0018\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0082@¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00190/2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010!J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010!J\u0010\u0010=\u001a\u00020\bH\u0082@¢\u0006\u0004\b=\u0010'J\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010!J\u0017\u0010?\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u0019¢\u0006\u0004\b?\u0010@J\u001d\u0010C\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0019¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0011¢\u0006\u0004\bF\u0010GJ\u0012\u0010I\u001a\u0004\u0018\u00010HH\u0086@¢\u0006\u0004\bI\u0010'J \u0010K\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0011H\u0086@¢\u0006\u0004\bK\u0010.J\u0015\u0010M\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000b¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0019¢\u0006\u0004\bO\u0010PJ\u0010\u0010Q\u001a\u00020\bH\u0086@¢\u0006\u0004\bQ\u0010'J\u0010\u0010R\u001a\u00020\bH\u0086@¢\u0006\u0004\bR\u0010'J\r\u0010S\u001a\u00020\b¢\u0006\u0004\bS\u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010Y\u001a\u0004\bZ\u0010[R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\\\u001a\u0004\b]\u0010^R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010_\u001a\u0004\b`\u0010aR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010Y\u001a\u0004\bb\u0010[R9\u0010\u0012\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\\\u001a\u0004\bc\u0010^R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010d\u001a\u0004\be\u0010fR\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010g\u001a\u0004\bh\u0010iR\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010j\u001a\u0004\bk\u0010lR\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010m\u001a\u0004\b\u001a\u0010PR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010n\u001a\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00190\n8\u0006¢\u0006\f\n\u0004\b}\u0010_\u001a\u0004\b~\u0010aR\u0016\u0010\u007f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010mR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010mR,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R,\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010³\u0001\u001a\u00030®\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R\u001c\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R,\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R,\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R,\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R,\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R,\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R,\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R,\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bì\u0001\u0010í\u0001\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R,\u0010ó\u0001\u001a\u0005\u0018\u00010ò\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R,\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bú\u0001\u0010û\u0001\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R,\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R&\u0010\u0087\u0002\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0002\u0010m\u001a\u0005\b\u0088\u0002\u0010P\"\u0005\b\u0089\u0002\u0010@R\u0018\u0010\u008b\u0002\u001a\u00030\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u0018\u0010\u008d\u0002\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0002\u0010mR\u0016\u0010\u008e\u0002\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008e\u0002\u0010sR\u001c\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008f\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002¨\u0006\u0092\u0002"}, d2 = {"Lcu/todus/android/xmpp/XMPPDataSource;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function1;", "Lua/k0;", "updateOwner", "Lte/b0;", "Lcu/todus/android/xmpp/ConnectionState;", "connectionState", "restartActivity", "Lab/e;", "Lkotlin/Pair;", "", "", "refreshToken", "Lcu/todus/android/s3/upload/UploadDataSource;", "uploadDataSource", "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "uploadStatusDataSource", "Lcu/todus/android/s3/download/DownloadDataSource;", "downloadDataSource", "", "isFirstTime", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/webrtc/CallState;", "requestingCalls", "<init>", "(Landroid/content/Context;Llb/a;Lkotlin/jvm/functions/Function1;Lte/b0;Llb/a;Lkotlin/jvm/functions/Function1;Lcu/todus/android/s3/upload/UploadDataSource;Lcu/todus/android/s3/upload/UploadStatusDataSource;Lcu/todus/android/s3/download/DownloadDataSource;ZLcu/z17/views/utils/Z17MutableListFlow;)V", "initPingManager", "()V", "initializeBase64Encoder", "hasContactsPermission", "loadRoster", "(ZLab/e;)Ljava/lang/Object;", "getOfflineMessages", "(Lab/e;)Ljava/lang/Object;", "getLastOfflineChannelMessages", "chId", "loadLastChannelMsgs", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "lastId", "loadOfflineChannelMsgs", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lte/h;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "setConfigurations", "()Lte/h;", "initManagers", "addExtensionProvider", "Lorg/jivesoftware/smack/XMPPConnection;", "conn", "initConnectWithIM", "(Lorg/jivesoftware/smack/XMPPConnection;Lab/e;)Ljava/lang/Object;", "loginWithIM", "(Lorg/jivesoftware/smack/XMPPConnection;)Lte/h;", "startSending", "stopSending", "initListeners", "startReconnectingTimer", "runParallelRosterLoad", "(Z)V", "uid", "b", "sendTyping", "(Ljava/lang/String;Z)V", "token", "sendFirebaseToken", "(Ljava/lang/String;)V", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;", "requestUpdateInfo", "firstId", "loadChannelMsgsBefore", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setConnectionState", "(Lcu/todus/android/xmpp/ConnectionState;)V", "canSend", "()Z", "reset", "disconnect", "stopReconnectingTimer", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Llb/a;", "getOwner", "()Llb/a;", "Lkotlin/jvm/functions/Function1;", "getUpdateOwner", "()Lkotlin/jvm/functions/Function1;", "Lte/b0;", "getConnectionState", "()Lte/b0;", "getRestartActivity", "getRefreshToken", "Lcu/todus/android/s3/upload/UploadDataSource;", "getUploadDataSource", "()Lcu/todus/android/s3/upload/UploadDataSource;", "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "getUploadStatusDataSource", "()Lcu/todus/android/s3/upload/UploadStatusDataSource;", "Lcu/todus/android/s3/download/DownloadDataSource;", "getDownloadDataSource", "()Lcu/todus/android/s3/download/DownloadDataSource;", "Z", "Lcu/z17/views/utils/Z17MutableListFlow;", "getRequestingCalls", "()Lcu/z17/views/utils/Z17MutableListFlow;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lcu/todus/android/notification/NotificationManager;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "Lcu/todus/android/volatileState/AppVolatileState;", "appVolatileState", "Lcu/todus/android/volatileState/AppVolatileState;", "updatingInitialData", "getUpdatingInitialData", "hasTryingFirst", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "isLoadingRoster", "Lcu/todus/android/xmpp/managers/PresenceManager;", "presenceManager", "Lcu/todus/android/xmpp/managers/PresenceManager;", "getPresenceManager", "()Lcu/todus/android/xmpp/managers/PresenceManager;", "setPresenceManager", "(Lcu/todus/android/xmpp/managers/PresenceManager;)V", "Lcu/todus/android/xmpp/managers/UrlManager;", "urlManager", "Lcu/todus/android/xmpp/managers/UrlManager;", "getUrlManager", "()Lcu/todus/android/xmpp/managers/UrlManager;", "setUrlManager", "(Lcu/todus/android/xmpp/managers/UrlManager;)V", "Lcu/todus/android/xmpp/managers/BlocksManager;", "blocksManager", "Lcu/todus/android/xmpp/managers/BlocksManager;", "getBlocksManager", "()Lcu/todus/android/xmpp/managers/BlocksManager;", "setBlocksManager", "(Lcu/todus/android/xmpp/managers/BlocksManager;)V", "Lcu/todus/android/xmpp/managers/StatusManager;", "statusManager", "Lcu/todus/android/xmpp/managers/StatusManager;", "getStatusManager", "()Lcu/todus/android/xmpp/managers/StatusManager;", "setStatusManager", "(Lcu/todus/android/xmpp/managers/StatusManager;)V", "Lcu/todus/android/xmpp/managers/LocationManager;", "locationManager", "Lcu/todus/android/xmpp/managers/LocationManager;", "getLocationManager", "()Lcu/todus/android/xmpp/managers/LocationManager;", "setLocationManager", "(Lcu/todus/android/xmpp/managers/LocationManager;)V", "Lcu/todus/android/xmpp/managers/GroupsManager;", "groupsManager", "Lcu/todus/android/xmpp/managers/GroupsManager;", "getGroupsManager", "()Lcu/todus/android/xmpp/managers/GroupsManager;", "setGroupsManager", "(Lcu/todus/android/xmpp/managers/GroupsManager;)V", "Lcu/todus/android/xmpp/managers/CallManager;", "callManager$delegate", "Lua/n;", "getCallManager", "()Lcu/todus/android/xmpp/managers/CallManager;", "callManager", "Lcu/todus/android/xmpp/managers/MessageManager;", "messageManager", "Lcu/todus/android/xmpp/managers/MessageManager;", "getMessageManager", "()Lcu/todus/android/xmpp/managers/MessageManager;", "setMessageManager", "(Lcu/todus/android/xmpp/managers/MessageManager;)V", "Lorg/jivesoftware/smack/ReconnectionManager;", "reconnectionManager", "Lorg/jivesoftware/smack/ReconnectionManager;", "Lorg/jivesoftware/smackx/ping/PingManager;", "pingManager", "Lorg/jivesoftware/smackx/ping/PingManager;", "Lcu/todus/android/xmpp/managers/RosterManager;", "rosterManager", "Lcu/todus/android/xmpp/managers/RosterManager;", "getRosterManager", "()Lcu/todus/android/xmpp/managers/RosterManager;", "setRosterManager", "(Lcu/todus/android/xmpp/managers/RosterManager;)V", "Lcu/todus/android/xmpp/managers/LastManager;", "lastManager", "Lcu/todus/android/xmpp/managers/LastManager;", "getLastManager", "()Lcu/todus/android/xmpp/managers/LastManager;", "setLastManager", "(Lcu/todus/android/xmpp/managers/LastManager;)V", "Lcu/todus/android/xmpp/managers/ChannelManager;", "channelManager", "Lcu/todus/android/xmpp/managers/ChannelManager;", "getChannelManager", "()Lcu/todus/android/xmpp/managers/ChannelManager;", "setChannelManager", "(Lcu/todus/android/xmpp/managers/ChannelManager;)V", "Lcu/todus/android/xmpp/managers/ProfileManager;", "profileManager", "Lcu/todus/android/xmpp/managers/ProfileManager;", "getProfileManager", "()Lcu/todus/android/xmpp/managers/ProfileManager;", "setProfileManager", "(Lcu/todus/android/xmpp/managers/ProfileManager;)V", "Lcu/todus/android/xmpp/dispatchers/OwnerMessageManager;", "ownerMessageManager", "Lcu/todus/android/xmpp/dispatchers/OwnerMessageManager;", "getOwnerMessageManager", "()Lcu/todus/android/xmpp/dispatchers/OwnerMessageManager;", "setOwnerMessageManager", "(Lcu/todus/android/xmpp/dispatchers/OwnerMessageManager;)V", "Lcu/todus/android/xmpp/dispatchers/OwnerReactionManager;", "ownerReactionManager", "Lcu/todus/android/xmpp/dispatchers/OwnerReactionManager;", "getOwnerReactionManager", "()Lcu/todus/android/xmpp/dispatchers/OwnerReactionManager;", "setOwnerReactionManager", "(Lcu/todus/android/xmpp/dispatchers/OwnerReactionManager;)V", "Lcu/todus/android/xmpp/dispatchers/OwnerMarkersManager;", "ownerMarkersManager", "Lcu/todus/android/xmpp/dispatchers/OwnerMarkersManager;", "getOwnerMarkersManager", "()Lcu/todus/android/xmpp/dispatchers/OwnerMarkersManager;", "setOwnerMarkersManager", "(Lcu/todus/android/xmpp/dispatchers/OwnerMarkersManager;)V", "Lcu/todus/android/xmpp/managers/PrivacyManager;", "privacyManager", "Lcu/todus/android/xmpp/managers/PrivacyManager;", "getPrivacyManager", "()Lcu/todus/android/xmpp/managers/PrivacyManager;", "setPrivacyManager", "(Lcu/todus/android/xmpp/managers/PrivacyManager;)V", "Lcu/todus/android/xmpp/dispatchers/OwnerStatusManager;", "ownerStatusManager", "Lcu/todus/android/xmpp/dispatchers/OwnerStatusManager;", "getOwnerStatusManager", "()Lcu/todus/android/xmpp/dispatchers/OwnerStatusManager;", "setOwnerStatusManager", "(Lcu/todus/android/xmpp/dispatchers/OwnerStatusManager;)V", "Lcu/todus/android/xmpp/dispatchers/OwnerDeleteMessageManager;", "ownerDeleteMessageManager", "Lcu/todus/android/xmpp/dispatchers/OwnerDeleteMessageManager;", "getOwnerDeleteMessageManager", "()Lcu/todus/android/xmpp/dispatchers/OwnerDeleteMessageManager;", "setOwnerDeleteMessageManager", "(Lcu/todus/android/xmpp/dispatchers/OwnerDeleteMessageManager;)V", "firstTry", "getFirstTry", "setFirstTry", "cu/todus/android/xmpp/XMPPDataSource$connectionListener$1", "connectionListener", "Lcu/todus/android/xmpp/XMPPDataSource$connectionListener$1;", "isTrying", "reconnectionScope", "Lpe/a2;", "timerJob", "Lpe/a2;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XMPPDataSource {
    public static final int $stable = 8;
    private final AppVolatileState appVolatileState;
    private BlocksManager blocksManager;

    /* JADX INFO: renamed from: callManager$delegate, reason: from kotlin metadata */
    private final ua.n callManager;
    private ChannelManager channelManager;
    private final XMPPDataSource$connectionListener$1 connectionListener;
    private final te.b0 connectionState;
    private Context context;
    private final m0 coroutineScope;
    private final DatabaseModule databaseModule;
    private final DownloadDataSource downloadDataSource;
    private boolean firstTry;
    private GroupsManager groupsManager;
    private boolean hasTryingFirst;
    private final boolean isFirstTime;
    private boolean isLoadingRoster;
    private boolean isTrying;
    private LastManager lastManager;
    private LocationManager locationManager;
    private XMPPTCPConnection mXMPPConnection;
    private MessageManager messageManager;
    private final NotificationManager notificationManager;
    private final lb.a owner;
    private OwnerDeleteMessageManager ownerDeleteMessageManager;
    private OwnerMarkersManager ownerMarkersManager;
    private OwnerMessageManager ownerMessageManager;
    private OwnerReactionManager ownerReactionManager;
    private OwnerStatusManager ownerStatusManager;
    private PingManager pingManager;
    private PresenceManager presenceManager;
    private PrivacyManager privacyManager;
    private ProfileManager profileManager;
    private ReconnectionManager reconnectionManager;
    private final m0 reconnectionScope;
    private final Function1 refreshToken;
    private final Z17MutableListFlow<CallState> requestingCalls;
    private final lb.a restartActivity;
    private RosterManager rosterManager;
    private StatusManager statusManager;
    private a2 timerJob;
    private final Function1 updateOwner;
    private final te.b0 updatingInitialData;
    private final UploadDataSource uploadDataSource;
    private final UploadStatusDataSource uploadStatusDataSource;
    private UrlManager urlManager;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$1", f = "XMPPDataSource.kt", l = {1679}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$1$1", f = "XMPPDataSource.kt", l = {1674}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lte/i;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "", "<unused var>", "", "attempt", "", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;J)Z"}, k = 3, mv = {2, 3, 0})
        public static final class C02631 extends cb.m implements lb.o {
            /* synthetic */ long J$0;
            int label;

            public C02631(ab.e<? super C02631> eVar) {
                super(4, eVar);
            }

            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return invoke((te.i) obj, (Throwable) obj2, ((Number) obj3).longValue(), (ab.e<? super Boolean>) obj4);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                long j10 = this.J$0;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    this.J$0 = j10;
                    this.label = 1;
                    if (w0.b(100L, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                return cb.b.a(j10 < SieveCacheKt.NodeLinkMask);
            }

            public final Object invoke(te.i iVar, Throwable th2, long j10, ab.e<? super Boolean> eVar) {
                C02631 c02631 = new C02631(eVar);
                c02631.J$0 = j10;
                return c02631.invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$1$2", f = "XMPPDataSource.kt", l = {1678}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function3 {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
                super(3, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                te.i iVar = (te.i) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    th2.printStackTrace();
                    this.L$0 = cb.l.a(iVar);
                    this.L$1 = cb.l.a(th2);
                    this.label = 1;
                    if (iVar.emit(null, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
                anonymousClass2.L$0 = iVar;
                anonymousClass2.L$1 = th2;
                return anonymousClass2.invokeSuspend(k0.f43947a);
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.h hVarG = te.j.g(te.j.P(XMPPDataSource.this.setConfigurations(), new C02631(null)), new AnonymousClass2(null));
                this.label = 1;
                if (te.j.x(hVarG, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$2", f = "XMPPDataSource.kt", l = {1683}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function1 {
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new AnonymousClass2(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.b0 connectionState = XMPPDataSource.this.getConnectionState();
                final XMPPDataSource xMPPDataSource = XMPPDataSource.this;
                te.i iVar = new te.i() { // from class: cu.todus.android.xmpp.XMPPDataSource.2.1

                    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$2$1$1", f = "XMPPDataSource.kt", l = {1691, 1692}, m = "invokeSuspend", v = 2)
                    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
                    public static final class C02641 extends cb.m implements Function1 {
                        int label;
                        final /* synthetic */ XMPPDataSource this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C02641(XMPPDataSource xMPPDataSource, ab.e<? super C02641> eVar) {
                            super(1, eVar);
                            this.this$0 = xMPPDataSource;
                        }

                        @Override // cb.a
                        public final ab.e<k0> create(ab.e<?> eVar) {
                            return new C02641(this.this$0, eVar);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(ab.e<? super k0> eVar) {
                            return ((C02641) create(eVar)).invokeSuspend(k0.f43947a);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
                        
                            if (r5.getOfflineMessages(r4) == r0) goto L15;
                         */
                        @Override // cb.a
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                            /*
                                r4 = this;
                                java.lang.Object r0 = bb.b.g()
                                int r1 = r4.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L1e
                                if (r1 == r3) goto L1a
                                if (r1 != r2) goto L12
                                ua.v.b(r5)
                                goto L3c
                            L12:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r0)
                                throw r5
                            L1a:
                                ua.v.b(r5)
                                goto L31
                            L1e:
                                ua.v.b(r5)
                                cu.todus.android.xmpp.XMPPDataSource r5 = r4.this$0
                                r5.stopReconnectingTimer()
                                cu.todus.android.xmpp.XMPPDataSource r5 = r4.this$0
                                r4.label = r3
                                java.lang.Object r5 = cu.todus.android.xmpp.XMPPDataSource.access$initListeners(r5, r4)
                                if (r5 != r0) goto L31
                                goto L3b
                            L31:
                                cu.todus.android.xmpp.XMPPDataSource r5 = r4.this$0
                                r4.label = r2
                                java.lang.Object r5 = cu.todus.android.xmpp.XMPPDataSource.access$getOfflineMessages(r5, r4)
                                if (r5 != r0) goto L3c
                            L3b:
                                return r0
                            L3c:
                                ua.k0 r5 = ua.k0.f43947a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.AnonymousClass2.AnonymousClass1.C02641.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    @Override // te.i
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                        return emit((ConnectionState) obj2, (ab.e<? super k0>) eVar);
                    }

                    public final Object emit(ConnectionState connectionState2, ab.e<? super k0> eVar) {
                        String.valueOf(connectionState2);
                        if (connectionState2.isDisconnected()) {
                            xMPPDataSource.stopSending();
                            xMPPDataSource.startReconnectingTimer();
                        } else if (connectionState2.isConnected()) {
                            CoroutineUtilsKt.launchWithContext$default(xMPPDataSource.coroutineScope, null, null, new C02641(xMPPDataSource, null), 3, null);
                        }
                        return k0.f43947a;
                    }
                };
                this.label = 1;
                if (connectionState.collect(iVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            throw new ua.j();
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$3", f = "XMPPDataSource.kt", l = {1700, 1704}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function1 {
        int I$0;
        Object L$0;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new AnonymousClass3(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        
            if (r11 == r0) goto L19;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r10.L$0
                cu.todus.android.xmpp.ConnectionState r0 = (cu.todus.android.xmpp.ConnectionState) r0
                ua.v.b(r11)
                goto L6f
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1e:
                ua.v.b(r11)
                goto L34
            L22:
                ua.v.b(r11)
                cu.todus.android.xmpp.XMPPDataSource r11 = cu.todus.android.xmpp.XMPPDataSource.this
                te.b0 r11 = r11.getConnectionState()
                r10.label = r3
                java.lang.Object r11 = te.j.x(r11, r10)
                if (r11 != r0) goto L34
                goto L6e
            L34:
                cu.todus.android.xmpp.XMPPDataSource r1 = cu.todus.android.xmpp.XMPPDataSource.this
                cu.todus.android.xmpp.ConnectionState r11 = (cu.todus.android.xmpp.ConnectionState) r11
                boolean r3 = r11.isConnected()
                if (r3 == 0) goto L71
                cu.todus.android.xmpp.managers.RosterManager r3 = r1.getRosterManager()
                if (r3 == 0) goto L71
                lb.a r1 = r1.getOwner()
                java.lang.Object r1 = r1.invoke()
                cu.todus.android.data.preferences.Owner r1 = (cu.todus.android.data.preferences.Owner) r1
                java.lang.String r4 = r1.getNameWithDomain()
                r8 = 4
                r9 = 0
                java.lang.String r5 = "@im.todus.cu"
                java.lang.String r6 = ""
                r7 = 0
                java.lang.String r1 = le.a0.O(r4, r5, r6, r7, r8, r9)
                java.lang.Object r11 = cb.l.a(r11)
                r10.L$0 = r11
                r11 = 0
                r10.I$0 = r11
                r10.label = r2
                java.lang.Object r11 = r3.getToDusId(r1, r10)
                if (r11 != r0) goto L6f
            L6e:
                return r0
            L6f:
                kotlin.Pair r11 = (kotlin.Pair) r11
            L71:
                ua.k0 r11 = ua.k0.f43947a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$disconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1520}, m = "disconnect", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13531 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C13531(ab.e<? super C13531> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.disconnect(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$disconnect$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$disconnect$2", f = "XMPPDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13542 extends cb.m implements Function2 {
        int label;

        public C13542(ab.e<? super C13542> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return XMPPDataSource.this.new C13542(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            ReconnectionManager reconnectionManager = XMPPDataSource.this.reconnectionManager;
            if (reconnectionManager != null) {
                reconnectionManager.disableAutomaticReconnection();
            }
            XMPPTCPConnection xMPPTCPConnection = XMPPDataSource.this.mXMPPConnection;
            if (xMPPTCPConnection == null) {
                return null;
            }
            xMPPTCPConnection.disconnect();
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13542) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$getLastOfflineChannelMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$getLastOfflineChannelMessages$1", f = "XMPPDataSource.kt", l = {518, 521, 525, 529, 532}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13551 extends cb.m implements Function1 {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        public C13551(ab.e<? super C13551> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new C13551(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13551) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:25:0x012f  */
        /* JADX WARN: Code duplicated, block: B:28:0x013b  */
        /* JADX WARN: Code duplicated, block: B:31:0x0147  */
        /* JADX WARN: Code duplicated, block: B:33:0x014a  */
        /* JADX WARN: Code duplicated, block: B:35:0x0150  */
        /* JADX WARN: Code duplicated, block: B:48:0x0215  */
        /* JADX WARN: Code duplicated, block: B:50:0x0220  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00db, code lost:
        
            if (r2 == r1) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01d3, code lost:
        
            if (r5.loadLastChannelMsgs(r6, r17) == r1) goto L47;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0215 -> B:49:0x021a). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 547
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.C13551.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$getOfflineMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {TypedValues.PositionType.TYPE_SIZE_PERCENT, 1754}, m = "getOfflineMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13561 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13561(ab.e<? super C13561> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.getOfflineMessages(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initConnectWithIM$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1499}, m = "initConnectWithIM", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13571 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13571(ab.e<? super C13571> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.initConnectWithIM(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initConnectWithIM$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initConnectWithIM$2", f = "XMPPDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lte/i;", "", "", "cause", "", "attempt", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;J)Z"}, k = 3, mv = {2, 3, 0})
    public static final class C13582 extends cb.m implements lb.o {
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        public C13582(ab.e<? super C13582> eVar) {
            super(4, eVar);
        }

        @Override // lb.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((te.i) obj, (Throwable) obj2, ((Number) obj3).longValue(), (ab.e<? super Boolean>) obj4);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Throwable th2 = (Throwable) this.L$0;
            long j10 = this.J$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return cb.b.a(!(th2 instanceof SASLErrorException) && j10 < 3);
        }

        public final Object invoke(te.i iVar, Throwable th2, long j10, ab.e<? super Boolean> eVar) {
            C13582 c13582 = new C13582(eVar);
            c13582.L$0 = th2;
            c13582.J$0 = j10;
            return c13582.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initConnectWithIM$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initConnectWithIM$3", f = "XMPPDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13593 extends cb.m implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        public C13593(ab.e<? super C13593> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Throwable th2 = (Throwable) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            th2.printStackTrace();
            if (th2 instanceof SASLErrorException) {
                SentryDataSource.Companion.onError$default(SentryDataSource.INSTANCE, (Exception) th2, "OwnerReactionManager", AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, 0, 8, null);
                XMPPDataSource.this.getRestartActivity().invoke();
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            C13593 c13593 = XMPPDataSource.this.new C13593(eVar);
            c13593.L$0 = th2;
            return c13593.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initListeners$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1591, 1597, WindowSizeClass.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND, 1603, 1606}, m = "initListeners", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13601 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C13601(ab.e<? super C13601> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.initListeners(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$11", f = "XMPPDataSource.kt", l = {733}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass11 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass11(ab.e<? super AnonymousClass11> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass11 anonymousClass11 = XMPPDataSource.this.new AnonymousClass11(eVar);
            anonymousClass11.L$0 = obj;
            return anonymousClass11;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = rosterManager.reloadUser(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (User) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super User> eVar) {
            return ((AnonymousClass11) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass12 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass12(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass14 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass14(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$16, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass16 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass16(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$18, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$18", f = "XMPPDataSource.kt", l = {764}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass18 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass18(ab.e<? super AnonymousClass18> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass18 anonymousClass18 = XMPPDataSource.this.new AnonymousClass18(eVar);
            anonymousClass18.L$0 = obj;
            return anonymousClass18;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager != null) {
                    this.L$0 = cb.l.a(str);
                    this.label = 1;
                    obj = rosterManager.reloadUser(str, this);
                    if (obj == objG) {
                        return objG;
                    }
                }
                return k0.f43947a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super k0> eVar) {
            return ((AnonymousClass18) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$19, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$19", f = "XMPPDataSource.kt", l = {766}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass19 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass19(ab.e<? super AnonymousClass19> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass19 anonymousClass19 = XMPPDataSource.this.new AnonymousClass19(eVar);
            anonymousClass19.L$0 = obj;
            return anonymousClass19;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = rosterManager.reloadUser(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (User) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super User> eVar) {
            return ((AnonymousClass19) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$20, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass20 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass20(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$22, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$22", f = "XMPPDataSource.kt", l = {777}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass22 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass22(ab.e<? super AnonymousClass22> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass22 anonymousClass22 = XMPPDataSource.this.new AnonymousClass22(eVar);
            anonymousClass22.L$0 = obj;
            return anonymousClass22;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = rosterManager.reloadUser(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (User) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super User> eVar) {
            return ((AnonymousClass22) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$23, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass23 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass23(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$24, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$24", f = "XMPPDataSource.kt", l = {788}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "cloudType", "", "size", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass24 extends cb.m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ long J$0;
        int label;

        public AnonymousClass24(ab.e<? super AnonymousClass24> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, long j10, ab.e<? super FileResponse.FileResult> eVar) {
            AnonymousClass24 anonymousClass24 = XMPPDataSource.this.new AnonymousClass24(eVar);
            anonymousClass24.I$0 = i10;
            anonymousClass24.J$0 = j10;
            return anonymousClass24.invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.I$0;
            long j10 = this.J$0;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                ua.v.b(obj);
                UrlManager urlManager = XMPPDataSource.this.getUrlManager();
                if (urlManager == null) {
                    return null;
                }
                this.I$0 = i10;
                this.J$0 = j10;
                this.label = 1;
                obj = UrlManager.getPutUrl$default(urlManager, null, i10, j10, false, this, 9, null);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (FileResponse.FileResult) obj;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).longValue(), (ab.e<? super FileResponse.FileResult>) obj3);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$25, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass25 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass25(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$27, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$27", f = "XMPPDataSource.kt", l = {801}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass27 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass27(ab.e<? super AnonymousClass27> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass27 anonymousClass27 = XMPPDataSource.this.new AnonymousClass27(eVar);
            anonymousClass27.L$0 = obj;
            return anonymousClass27;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List<String> list = (List) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(list);
                this.label = 1;
                obj = rosterManager.getUsersInfo(list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (List) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List<String> list, ab.e<? super List<User>> eVar) {
            return ((AnonymousClass27) create(list, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$28, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass28 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass28(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class C13623 extends kotlin.jvm.internal.v implements lb.a {
        public C13623(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$31, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$31", f = "XMPPDataSource.kt", l = {821}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass31 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass31(ab.e<? super AnonymousClass31> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass31 anonymousClass31 = XMPPDataSource.this.new AnonymousClass31(eVar);
            anonymousClass31.L$0 = obj;
            return anonymousClass31;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                GroupsManager groupsManager = XMPPDataSource.this.getGroupsManager();
                if (groupsManager != null) {
                    this.L$0 = cb.l.a(str);
                    this.label = 1;
                    if (groupsManager.askForReloadMucMemberList(str, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super k0> eVar) {
            return ((AnonymousClass31) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$32, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$32", f = "XMPPDataSource.kt", l = {819}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass32 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass32(ab.e<? super AnonymousClass32> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass32 anonymousClass32 = XMPPDataSource.this.new AnonymousClass32(eVar);
            anonymousClass32.L$0 = obj;
            return anonymousClass32;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = rosterManager.reloadUser(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (User) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super User> eVar) {
            return ((AnonymousClass32) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$33, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$33", f = "XMPPDataSource.kt", l = {824}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/xmpp/MucInfo;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass33 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass33(ab.e<? super AnonymousClass33> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass33 anonymousClass33 = XMPPDataSource.this.new AnonymousClass33(eVar);
            anonymousClass33.L$0 = obj;
            return anonymousClass33;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                GroupsManager groupsManager = XMPPDataSource.this.getGroupsManager();
                if (groupsManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = groupsManager.getGroupInfoById(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (MucInfo) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super MucInfo> eVar) {
            return ((AnonymousClass33) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$34, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$34", f = "XMPPDataSource.kt", l = {827}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/xmpp/ChannelInfo;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass34 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass34(ab.e<? super AnonymousClass34> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass34 anonymousClass34 = XMPPDataSource.this.new AnonymousClass34(eVar);
            anonymousClass34.L$0 = obj;
            return anonymousClass34;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ChannelManager channelManager = XMPPDataSource.this.getChannelManager();
                if (channelManager == null) {
                    return null;
                }
                this.L$0 = cb.l.a(str);
                this.label = 1;
                obj = channelManager.getChannelInfoById(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return (ChannelInfo) obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super ChannelInfo> eVar) {
            return ((AnonymousClass34) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$35, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$35", f = "XMPPDataSource.kt", l = {830}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "pubList", "Lua/k0;", "<anonymous>", "(Ljava/util/ArrayList;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass35 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass35(ab.e<? super AnonymousClass35> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass35 anonymousClass35 = XMPPDataSource.this.new AnonymousClass35(eVar);
            anonymousClass35.L$0 = obj;
            return anonymousClass35;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            ArrayList<Bundle> arrayList = (ArrayList) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ChannelManager channelManager = XMPPDataSource.this.getChannelManager();
                if (channelManager != null) {
                    this.L$0 = cb.l.a(arrayList);
                    this.label = 1;
                    if (channelManager.handlePublications(arrayList, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ArrayList<Bundle> arrayList, ab.e<? super k0> eVar) {
            return ((AnonymousClass35) create(arrayList, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$36, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$36", f = "XMPPDataSource.kt", l = {833}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "chId", "pubId", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass36 extends cb.m implements Function3 {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass36(ab.e<? super AnonymousClass36> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            String str2 = (String) this.L$1;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ChannelManager channelManager = XMPPDataSource.this.getChannelManager();
                if (channelManager != null) {
                    this.L$0 = cb.l.a(str);
                    this.L$1 = cb.l.a(str2);
                    this.label = 1;
                    if (channelManager.reloadPubById(str, str2, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(String str, String str2, ab.e<? super k0> eVar) {
            AnonymousClass36 anonymousClass36 = XMPPDataSource.this.new AnonymousClass36(eVar);
            anonymousClass36.L$0 = str;
            anonymousClass36.L$1 = str2;
            return anonymousClass36.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$37, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$37", f = "XMPPDataSource.kt", l = {836}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass37 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass37(ab.e<? super AnonymousClass37> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass37 anonymousClass37 = XMPPDataSource.this.new AnonymousClass37(eVar);
            anonymousClass37.L$0 = obj;
            return anonymousClass37;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                RosterManager rosterManager = XMPPDataSource.this.getRosterManager();
                if (rosterManager != null) {
                    this.L$0 = cb.l.a(str);
                    this.label = 1;
                    obj = rosterManager.reloadUser(str, this);
                    if (obj == objG) {
                        return objG;
                    }
                }
                return k0.f43947a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super k0> eVar) {
            return ((AnonymousClass37) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$39, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$initManagers$39", f = "XMPPDataSource.kt", l = {842}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/pojo/content/CallContent;", "callContent", "", "isCancelled", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/CallContent;Z)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass39 extends cb.m implements lb.o {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass39(ab.e<? super AnonymousClass39> eVar) {
            super(4, eVar);
        }

        @Override // lb.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((String) obj, (CallContent) obj2, ((Boolean) obj3).booleanValue(), (ab.e<? super k0>) obj4);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            CallContent callContent = (CallContent) this.L$1;
            boolean z10 = this.Z$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                CallManager callManager = XMPPDataSource.this.getCallManager();
                if (callManager != null) {
                    this.L$0 = cb.l.a(str);
                    this.L$1 = cb.l.a(callContent);
                    this.Z$0 = z10;
                    this.label = 1;
                    if (callManager.onCallMessage(str, callContent, z10, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        public final Object invoke(String str, CallContent callContent, boolean z10, ab.e<? super k0> eVar) {
            AnonymousClass39 anonymousClass39 = XMPPDataSource.this.new AnonymousClass39(eVar);
            anonymousClass39.L$0 = str;
            anonymousClass39.L$1 = callContent;
            anonymousClass39.Z$0 = z10;
            return anonymousClass39.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass4(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$40, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass40 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass40(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$42, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass42 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass42(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$44, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass44 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass44(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$46, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass46 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass46(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$48, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass48 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass48(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$50, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass50 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass50(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass7 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass7(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$initManagers$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass9 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass9(Object obj) {
            super(0, obj, XMPPDataSource.class, "canSend", "canSend()Z", 0);
        }

        @Override // lb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((XMPPDataSource) this.receiver).canSend());
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loadChannelMsgsBefore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1754, 584}, m = "loadChannelMsgsBefore", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13631 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13631(ab.e<? super C13631> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.loadChannelMsgsBefore(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loadLastChannelMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1754, 545}, m = "loadLastChannelMsgs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13641 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13641(ab.e<? super C13641> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.loadLastChannelMsgs(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loadOfflineChannelMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1754, 558, 560, 563, 566}, m = "loadOfflineChannelMsgs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13651 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C13651(ab.e<? super C13651> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.loadOfflineChannelMsgs(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loadRoster$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {RendererCapabilities.DECODER_SUPPORT_MASK}, m = "loadRoster", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13661 extends cb.d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13661(ab.e<? super C13661> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.loadRoster(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1", f = "XMPPDataSource.kt", l = {1510, 1515}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13671 extends cb.m implements Function2 {
        final /* synthetic */ XMPPConnection $conn;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ XMPPDataSource this$0;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1$1", f = "XMPPDataSource.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02651 extends cb.m implements Function2 {
            int label;
            final /* synthetic */ XMPPDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02651(XMPPDataSource xMPPDataSource, ab.e<? super C02651> eVar) {
                super(2, eVar);
                this.this$0 = xMPPDataSource;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02651(this.this$0, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) throws SmackException, InterruptedException, IOException, XMPPException {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = this.this$0.mXMPPConnection;
                if (xMPPTCPConnection == null) {
                    return null;
                }
                xMPPTCPConnection.login(((Owner) this.this$0.getOwner().invoke()).getUsername(), ((Owner) this.this$0.getOwner().invoke()).getToken());
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02651) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13671(XMPPConnection xMPPConnection, XMPPDataSource xMPPDataSource, ab.e<? super C13671> eVar) {
            super(2, eVar);
            this.$conn = xMPPConnection;
            this.this$0 = xMPPDataSource;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13671 c13671 = new C13671(this.$conn, this.this$0, eVar);
            c13671.L$0 = obj;
            return c13671;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        
            if (r0.emit(r8, r7) == r1) goto L19;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                ua.v.b(r8)
                goto L5f
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                ua.v.b(r8)
                goto L4c
            L22:
                ua.v.b(r8)
                org.jivesoftware.smack.XMPPConnection r8 = r7.$conn
                boolean r8 = r8.isConnected()
                if (r8 == 0) goto L35
                org.jivesoftware.smack.XMPPConnection r8 = r7.$conn
                boolean r8 = r8.isAuthenticated()
                if (r8 != 0) goto L4c
            L35:
                pe.k0 r8 = pe.d1.b()
                cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1$1 r2 = new cu.todus.android.xmpp.XMPPDataSource$loginWithIM$1$1
                cu.todus.android.xmpp.XMPPDataSource r5 = r7.this$0
                r6 = 0
                r2.<init>(r5, r6)
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = pe.i.g(r8, r2, r7)
                if (r8 != r1) goto L4c
                goto L5e
            L4c:
                java.lang.Boolean r8 = cb.b.a(r4)
                java.lang.Object r2 = cb.l.a(r0)
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r0.emit(r8, r7)
                if (r8 != r1) goto L5f
            L5e:
                return r1
            L5f:
                ua.k0 r8 = ua.k0.f43947a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.C13671.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(te.i iVar, ab.e<? super k0> eVar) {
            return ((C13671) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$requestUpdateInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {1754}, m = "requestUpdateInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13681 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13681(ab.e<? super C13681> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.requestUpdateInfo(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource", f = "XMPPDataSource.kt", l = {TypedValues.Custom.TYPE_REFERENCE, 907, 911}, m = "reset", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13691 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C13691(ab.e<? super C13691> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPDataSource.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$reset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$reset$2", f = "XMPPDataSource.kt", l = {910}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13702 extends cb.m implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C13702(ab.e<? super C13702> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.i iVar = (te.i) this.L$0;
            Throwable th2 = (Throwable) this.L$1;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                th2.printStackTrace();
                this.L$0 = cb.l.a(iVar);
                this.L$1 = cb.l.a(th2);
                this.label = 1;
                if (iVar.emit(null, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            C13702 c13702 = new C13702(eVar);
            c13702.L$0 = iVar;
            c13702.L$1 = th2;
            return c13702.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$runParallelRosterLoad$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$runParallelRosterLoad$1", f = "XMPPDataSource.kt", l = {377}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13711 extends cb.m implements Function1 {
        final /* synthetic */ boolean $hasContactsPermission;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13711(boolean z10, ab.e<? super C13711> eVar) {
            super(1, eVar);
            this.$hasContactsPermission = z10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new C13711(this.$hasContactsPermission, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13711) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                if (!XMPPDataSource.this.isLoadingRoster) {
                    XMPPDataSource xMPPDataSource = XMPPDataSource.this;
                    boolean z10 = this.$hasContactsPermission;
                    this.label = 1;
                    if (xMPPDataSource.loadRoster(z10, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$sendFirebaseToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$sendFirebaseToken$1", f = "XMPPDataSource.kt", l = {1754, 470}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13721 extends cb.m implements Function1 {
        final /* synthetic */ String $token;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13721(String str, ab.e<? super C13721> eVar) {
            super(1, eVar);
            this.$token = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new C13721(this.$token, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13721) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0078  */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
        
            if (r8 == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
        
            if (pe.w0.b(5000, r7) == r0) goto L24;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r7.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L30
                if (r1 == r4) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r0 = r7.L$0
                kotlin.jvm.internal.u0 r0 = (kotlin.jvm.internal.u0) r0
                ua.v.b(r8)
                goto L8e
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                java.lang.Object r1 = r7.L$2
                org.jivesoftware.smack.packet.IQ r1 = (org.jivesoftware.smack.packet.IQ) r1
                java.lang.Object r1 = r7.L$1
                org.jivesoftware.smack.tcp.XMPPTCPConnection r1 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r1
                java.lang.Object r1 = r7.L$0
                kotlin.jvm.internal.u0 r1 = (kotlin.jvm.internal.u0) r1
                ua.v.b(r8)
                goto L6e
            L30:
                ua.v.b(r8)
                kotlin.jvm.internal.u0 r1 = new kotlin.jvm.internal.u0
                r1.<init>()
                r1.f36629c = r4
                cu.todus.android.xmpp.XMPPDataSource r8 = cu.todus.android.xmpp.XMPPDataSource.this
                boolean r8 = r8.canSend()
                if (r8 == 0) goto L74
                cu.todus.android.xmpp.XMPPDataSource r8 = cu.todus.android.xmpp.XMPPDataSource.this
                org.jivesoftware.smack.tcp.XMPPTCPConnection r8 = cu.todus.android.xmpp.XMPPDataSource.access$getMXMPPConnection$p(r8)
                if (r8 == 0) goto L74
                cu.todus.android.xmpp.iq.push.ToDusPushIQ r5 = new cu.todus.android.xmpp.iq.push.ToDusPushIQ
                java.lang.String r6 = r7.$token
                r5.<init>(r6)
                te.h r6 = cu.todus.android.xmpp.XMPPInlinesKt.sendIQFlow(r8, r5)
                r7.L$0 = r1
                java.lang.Object r8 = cb.l.a(r8)
                r7.L$1 = r8
                java.lang.Object r8 = cb.l.a(r5)
                r7.L$2 = r8
                r7.I$0 = r2
                r7.label = r4
                java.lang.Object r8 = te.j.x(r6, r7)
                if (r8 != r0) goto L6e
                goto L8d
            L6e:
                org.jivesoftware.smack.packet.IQ r8 = (org.jivesoftware.smack.packet.IQ) r8
                if (r8 == 0) goto L74
                r1.f36629c = r2
            L74:
                boolean r8 = r1.f36629c
                if (r8 == 0) goto L95
                java.lang.Object r8 = cb.l.a(r1)
                r7.L$0 = r8
                r8 = 0
                r7.L$1 = r8
                r7.L$2 = r8
                r7.label = r3
                r1 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r8 = pe.w0.b(r1, r7)
                if (r8 != r0) goto L8e
            L8d:
                return r0
            L8e:
                cu.todus.android.xmpp.XMPPDataSource r8 = cu.todus.android.xmpp.XMPPDataSource.this
                java.lang.String r0 = r7.$token
                r8.sendFirebaseToken(r0)
            L95:
                ua.k0 r8 = ua.k0.f43947a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.C13721.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$sendTyping$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$sendTyping$1", f = "XMPPDataSource.kt", l = {449}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13731 extends cb.m implements Function1 {
        final /* synthetic */ Message $replyMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13731(Message message, ab.e<? super C13731> eVar) {
            super(1, eVar);
            this.$replyMessage = message;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return XMPPDataSource.this.new C13731(this.$replyMessage, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13731) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = XMPPDataSource.this.mXMPPConnection;
                if (xMPPTCPConnection != null) {
                    Message message = this.$replyMessage;
                    this.label = 1;
                    obj = XMPPInlinesKt.suspendSendStanzaAndWaitForConfirm(xMPPTCPConnection, message, this);
                    if (obj == objG) {
                        return objG;
                    }
                }
                return k0.f43947a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$setConfigurations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$setConfigurations$1", f = "XMPPDataSource.kt", l = {671}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13741 extends cb.m implements Function2 {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C13741(ab.e<? super C13741> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(UnparseableStanza unparseableStanza) {
            unparseableStanza.getParsingException().printStackTrace();
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13741 c13741 = XMPPDataSource.this.new C13741(eVar);
            c13741.L$0 = obj;
            return c13741;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractXMPPConnection abstractXMPPConnectionConnect;
            te.i iVar = (te.i) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                XMPPDataSource.this.hasTryingFirst = false;
                ReconnectionManager reconnectionManager = XMPPDataSource.this.reconnectionManager;
                if (reconnectionManager != null) {
                    reconnectionManager.disableAutomaticReconnection();
                }
                XMPPInlinesKt.removeAllXMPPConnectionListeners();
                XMPPDataSource.this.setConnectionState(ConnectionState.CONNECTING);
                XMPPDataSource.this.initializeBase64Encoder();
                SASLAuthentication.blacklistSASLMechanism("SCRAM-SHA-1");
                SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
                SASLAuthentication.unBlacklistSASLMechanism("PLAIN");
                SASLAuthentication.registerSASLMechanism(new SASLPlainMechanism());
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.hoxt.HOXTManager");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.json");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.gcm");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.xdata.XDataManager");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.xdatalayout.XDataLayoutManager");
                SmackConfiguration.addDisabledSmackClass("org.jivesoftware.smackx.xdatavalidation.XDataValidationManager");
                XMPPDataSource.this.addExtensionProvider();
                RootEnvironment rootEnvironment = XMPPDataSource.this.appVolatileState.getRootEnvironment();
                XMPPDataSource.this.mXMPPConnection = new XMPPTCPConnection(ToDusXMPPFactoryConfiguration.INSTANCE.create(((Owner) XMPPDataSource.this.getOwner().invoke()).getUsername(), (rootEnvironment.getApplicationEnvironment() != Service.ApplicationEnvironment.LOCAL || le.d0.q0(rootEnvironment.getRootUrl())) ? Service.INSTANCE.provideIMUrl(rootEnvironment.getApplicationEnvironment()) : le.a0.O(le.a0.O(le.a0.O(rootEnvironment.getRootUrl(), "http://", "", false, 4, null), "https://", "", false, 4, null), "/", "", false, 4, null), Service.INSTANCE.provideIMPort(rootEnvironment.getApplicationEnvironment())));
                XMPPTCPConnection xMPPTCPConnection = XMPPDataSource.this.mXMPPConnection;
                if (xMPPTCPConnection != null) {
                    xMPPTCPConnection.setParsingExceptionCallback(new ParsingExceptionCallback() { // from class: cu.todus.android.xmpp.u
                        @Override // org.jivesoftware.smack.parsing.ParsingExceptionCallback
                        public final void handleUnparsableStanza(UnparseableStanza unparseableStanza) {
                            XMPPDataSource.C13741.invokeSuspend$lambda$0(unparseableStanza);
                        }
                    });
                }
                XMPPTCPConnection xMPPTCPConnection2 = XMPPDataSource.this.mXMPPConnection;
                if (xMPPTCPConnection2 != null) {
                    xMPPTCPConnection2.addConnectionListener(XMPPDataSource.this.connectionListener);
                }
                XMPPTCPConnection xMPPTCPConnection3 = XMPPDataSource.this.mXMPPConnection;
                if (xMPPTCPConnection3 == null || (abstractXMPPConnectionConnect = xMPPTCPConnection3.connect()) == null) {
                    throw new Exception("BAD INITIALIZATION");
                }
                this.L$0 = cb.l.a(iVar);
                this.L$1 = cb.l.a(rootEnvironment);
                this.L$2 = cb.l.a(abstractXMPPConnectionConnect);
                this.label = 1;
                if (iVar.emit(abstractXMPPConnectionConnect, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(te.i iVar, ab.e<? super k0> eVar) {
            return ((C13741) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$startReconnectingTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$startReconnectingTimer$1", f = "XMPPDataSource.kt", l = {1624, 1631, 1641}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13751 extends cb.m implements Function2 {
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPDataSource$startReconnectingTimer$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$startReconnectingTimer$1$1", f = "XMPPDataSource.kt", l = {1640}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "", "error", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02661 extends cb.m implements Function3 {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public C02661(ab.e<? super C02661> eVar) {
                super(3, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                te.i iVar = (te.i) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    Log.e("RECONNECTION_TIMER", "❌ Reconnection failed: " + th2.getMessage());
                    th2.printStackTrace();
                    this.L$0 = cb.l.a(iVar);
                    this.L$1 = cb.l.a(th2);
                    this.label = 1;
                    if (iVar.emit(null, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
                C02661 c02661 = new C02661(eVar);
                c02661.L$0 = iVar;
                c02661.L$1 = th2;
                return c02661.invokeSuspend(k0.f43947a);
            }
        }

        public C13751(ab.e<? super C13751> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13751 c13751 = XMPPDataSource.this.new C13751(eVar);
            c13751.L$0 = obj;
            return c13751;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0085 A[Catch: Exception -> 0x00b3, TryCatch #2 {Exception -> 0x00b3, blocks: (B:31:0x007d, B:33:0x0085, B:38:0x00b6, B:28:0x0076, B:41:0x00c3, B:42:0x00f5), top: B:50:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00b6 A[Catch: Exception -> 0x00b3, TryCatch #2 {Exception -> 0x00b3, blocks: (B:31:0x007d, B:33:0x0085, B:38:0x00b6, B:28:0x0076, B:41:0x00c3, B:42:0x00f5), top: B:50:0x000f }] */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        
            if (te.j.x(r2, r13) == r1) goto L35;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 286
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.C13751.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13751) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public XMPPDataSource(Context context, lb.a owner, Function1 updateOwner, te.b0 connectionState, lb.a restartActivity, Function1 refreshToken, UploadDataSource uploadDataSource, UploadStatusDataSource uploadStatusDataSource, DownloadDataSource downloadDataSource, boolean z10, Z17MutableListFlow<CallState> requestingCalls) {
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(updateOwner, "updateOwner");
        kotlin.jvm.internal.y.i(connectionState, "connectionState");
        kotlin.jvm.internal.y.i(restartActivity, "restartActivity");
        kotlin.jvm.internal.y.i(refreshToken, "refreshToken");
        kotlin.jvm.internal.y.i(uploadDataSource, "uploadDataSource");
        kotlin.jvm.internal.y.i(uploadStatusDataSource, "uploadStatusDataSource");
        kotlin.jvm.internal.y.i(downloadDataSource, "downloadDataSource");
        kotlin.jvm.internal.y.i(requestingCalls, "requestingCalls");
        this.context = context;
        this.owner = owner;
        this.updateOwner = updateOwner;
        this.connectionState = connectionState;
        this.restartActivity = restartActivity;
        this.refreshToken = refreshToken;
        this.uploadDataSource = uploadDataSource;
        this.uploadStatusDataSource = uploadStatusDataSource;
        this.downloadDataSource = downloadDataSource;
        this.isFirstTime = z10;
        this.requestingCalls = requestingCalls;
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.coroutineScope = m0VarA;
        this.notificationManager = NotificationManager.INSTANCE.getInstance();
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
        this.appVolatileState = AppVolatileState.INSTANCE.getInstance();
        this.updatingInitialData = r0.a(Boolean.FALSE);
        this.callManager = ua.o.a(new lb.a() { // from class: cu.todus.android.xmpp.l
            @Override // lb.a
            public final Object invoke() {
                return XMPPDataSource.callManager_delegate$lambda$0(this.f28853c);
            }
        });
        this.firstTry = true;
        this.connectionListener = new XMPPDataSource$connectionListener$1(this);
        this.reconnectionScope = n0.a(d1.a().plus(w2.b(null, 1, null)));
        CoroutineUtilsKt.launchWithContext$default(m0VarA, null, null, new AnonymousClass1(null), 3, null);
        CoroutineUtilsKt.launchWithContext$default(m0VarA, null, null, new AnonymousClass2(null), 3, null);
        CoroutineUtilsKt.launchPeriodic$default(m0VarA, null, 0L, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtensionProvider() {
        ProviderManager.addExtensionProvider("x", "x11", new AffiliationsChangeExtensionProvider());
        ProviderManager.addExtensionProvider("x", "x10", new ConfigurationsChangeProvider());
        ProviderManager.addExtensionProvider(ChatMarkersElements.AcknowledgedExtension.ELEMENT, ChatMarkersElements.NAMESPACE, new AcknowledgedProvider());
        ProviderManager.addExtensionProvider(ChatMarkersElements.DisplayedExtension.ELEMENT, ChatMarkersElements.NAMESPACE, new DisplayedProvider());
        ProviderManager.addExtensionProvider(ChatMarkersElements.MarkableExtension.ELEMENT, ChatMarkersElements.NAMESPACE, new MarkableProvider());
        ProviderManager.addExtensionProvider(ChatMarkersElements.ReceivedExtension.ELEMENT, ChatMarkersElements.NAMESPACE, new ReceivedProvider());
        ProviderManager.addExtensionProvider("csa", ChatStateExtensionToDus.NAMESPACE, new ChatStateExtensionProvider());
        ProviderManager.addExtensionProvider("csc", ChatStateExtensionToDus.NAMESPACE, new ChatStateExtensionProvider());
        ProviderManager.addExtensionProvider("csg", ChatStateExtensionToDus.NAMESPACE, new ChatStateExtensionProvider());
        ProviderManager.addExtensionProvider("csi", ChatStateExtensionToDus.NAMESPACE, new ChatStateExtensionProvider());
        ProviderManager.addExtensionProvider("csp", ChatStateExtensionToDus.NAMESPACE, new ChatStateExtensionProvider());
        ProviderManager.addExtensionProvider(DelayInformation.ELEMENT, DelayInformation.NAMESPACE, new DelayInformationProvider());
        ProviderManager.addExtensionProvider(Forwarded.ELEMENT, Forwarded.NAMESPACE, new ForwardedProvider());
        ProviderManager.addIQProvider(BlockContactsIQ.ELEMENT, "urn:xmpp:blocking", new BlockContactsIQProvider());
        ProviderManager.addIQProvider(UnblockContactsIQ.ELEMENT, "urn:xmpp:blocking", new UnblockContactsIQProvider());
        ProviderManager.addIQProvider(BlockListIQ.ELEMENT, "urn:xmpp:blocking", new BlockListIQProvider());
        ProviderManager.addIQProvider(Ping.ELEMENT, Ping.NAMESPACE, new PingProvider());
        ProviderManager.addIQProvider("query", GetBlockListIQ.NAMESPACE, new GetBlockListIQProvider());
        ProviderManager.addIQProvider("query", GetBlockListPaginatedIQ.NAMESPACE, new GetBlockListPaginatedIQProvider());
        ProviderManager.addIQProvider("query", RosterEditToDusIdIQ.NAMESPACE, new RosterEditToDusIdIQProvider());
        ProviderManager.addIQProvider("query", RosterDeleteIQ.NAMESPACE, new RosterDeleteIQProvider());
        ProviderManager.addIQProvider("query", NearSetIQ.NAMESPACE, new NearSetIQProvider());
        ProviderManager.addIQProvider("query", BlockUserIQ.NAMESPACE, new BlockUserIQProvider());
        ProviderManager.addIQProvider("query", CreateChannelIQ.NAMESPACE, new CreateChannelIQProvider());
        ProviderManager.addIQProvider("query", DeletePubFromChannelIQ.NAMESPACE, new DeletePubFromChannelIQProvider());
        ProviderManager.addIQProvider("query", GetChannelListIQ.NAMESPACE, new GetChannelListIQProvider());
        ProviderManager.addIQProvider("query", GetChannelListPaginatedIQ.NAMESPACE, new GetChannelListPaginatedIQProvider());
        ProviderManager.addIQProvider("query", GetGroupListPaginatedIQ.NAMESPACE, new GetGroupListPaginatedIQProvider());
        ProviderManager.addIQProvider("query", "x14", new GroupLinkIQProvider());
        ProviderManager.addIQProvider("query", "x11", new GroupMembersIQProvider());
        ProviderManager.addIQProvider("query", AddGroupMembersIQ.NAMESPACE, new AddGroupMembersIQProvider());
        ProviderManager.addIQProvider("query", PromoteGroupAdminIQ.NAMESPACE, new PromoteGroupAdminIQProvider());
        ProviderManager.addIQProvider("query", DemoteGroupAdminIQ.NAMESPACE, new DemoteGroupAdminIQProvider());
        ProviderManager.addIQProvider("query", ChannelInfoIQById.NAMESPACE, new ChannelInfoIQByIdProvider());
        ProviderManager.addIQProvider("query", ChannelInfoIQByLink.NAMESPACE, new ChannelInfoIQByLinkProvider());
        ProviderManager.addIQProvider("query", GetPublicationsChannelIQ.NAMESPACE, new GetPublicationsChannelIQProvider());
        ProviderManager.addIQProvider("query", GetPubByIdIQ.NAMESPACE, new GetPubByIdIQProvider());
        ProviderManager.addIQProvider("query", RosterGetUsersInfoIQ.NAMESPACE, new RosterGetUsersInfoIQProvider());
        ProviderManager.addIQProvider("query", LastIQ.NAMESPACE, new LastIQProvider());
        ProviderManager.addIQProvider("query", GetChannelSubscribersIQ.NAMESPACE, new GetChannelSubscribersIQProvider());
        ProviderManager.addIQProvider("query", GetChannelAdminsIQ.NAMESPACE, new GetChannelAdminsIQProvider());
        ProviderManager.addIQProvider("query", PublishToChannelIQ.NAMESPACE, new PublishToChannelIQProvider());
        ProviderManager.addIQProvider("query", NotificationChannelEditedIQ.NAMESPACE, new NotificationChannelEditedIQProvider());
        ProviderManager.addIQProvider("query", UnBlockUserIQ.NAMESPACE, new UnBlockUserIQProvider());
        ProviderManager.addIQProvider("query", NearGetStatusIQ.NAMESPACE, new NearGetStatusIQProvider());
        ProviderManager.addIQProvider("query", NearHideIQ.NAMESPACE, new NearHideIQProvider());
        ProviderManager.addIQProvider("query", PeopleNearIQ.NAMESPACE, new PeopleNearIQProvider());
        ProviderManager.addIQProvider("query", PutUrlIQ.NAMESPACE, new PutUrlIQProvider());
        ProviderManager.addIQProvider("query", GetUrlIQ.NAMESPACE, new GetUrlIQProvider());
        ProviderManager.addIQProvider("query", GroupInfoIQByLink.NAMESPACE, new GroupInfoIQByLinkProvider());
        ProviderManager.addIQProvider("query", GroupInfoByIdIQ.NAMESPACE, new GroupInfoByIdIQProvider());
        ProviderManager.addIQProvider("query", RosterGetToDusIdIQ.NAMESPACE, new RosterGetToDusIdIQProvider());
        ProviderManager.addIQProvider("query", PublishStatusIQ.NAMESPACE, new PublishStatusIQProvider());
        ProviderManager.addIQProvider("query", GetStatusIQ.NAMESPACE, new GetStatusIQProvider());
        ProviderManager.addIQProvider("query", DeleteStatusIQ.NAMESPACE, new DeleteStatusIQProvider());
        ProviderManager.addIQProvider("query", GetFollowersIQ.NAMESPACE, new GetFollowersIQProvider());
        ProviderManager.addIQProvider("query", GetFollowingIQ.NAMESPACE, new GetFollowingIQProvider());
        ProviderManager.addIQProvider("query", FollowIQ.NAMESPACE, new FollowIQProvider());
        ProviderManager.addIQProvider("query", UnFollowIQ.NAMESPACE, new UnFollowIQProvider());
        ProviderManager.addIQProvider("query", GetFollowInfoIQ.NAMESPACE, new GetFollowInfoIQProvider());
        ProviderManager.addExtensionProvider(ExtensionFile.ELEMENT, ExtensionFile.NAMESPACE, new ExtensionFileProvider());
        ProviderManager.addExtensionProvider("sticker", ExtensionSticker.NAMESPACE, new ExtensionStickerProvider());
        ProviderManager.addExtensionProvider("audio", ExtensionAudio.NAMESPACE, new ExtensionAudioProvider());
        ProviderManager.addIQProvider("query", GetCredentialsIQ.NAMESPACE, new GetCredentialsIQProvider());
        ProviderManager.addExtensionProvider("video", ExtensionVideo.NAMESPACE, new ExtensionVideoProvider());
        ProviderManager.addExtensionProvider(ExtensionVoice.ELEMENT, ExtensionVoice.NAMESPACE, new ExtensionVoiceProvider());
        ProviderManager.addExtensionProvider("location", ExtensionLocation.NAMESPACE, new ExtensionLocationProvider());
        ProviderManager.addExtensionProvider(ExtensionLinkInfo.ELEMENT, ExtensionLinkInfo.NAMESPACE, new ExtensionLinkInfoProvider());
        ProviderManager.addExtensionProvider(ExtensionForwarded.ELEMENT, ExtensionForwarded.NAMESPACE, new ExtensionForwardedProvider());
        ProviderManager.addExtensionProvider(ExtensionEdited.ELEMENT, ExtensionEdited.NAMESPACE, new ExtensionEditedProvider());
        ProviderManager.addExtensionProvider(ExtensionDeleted.ELEMENT, ExtensionDeleted.NAMESPACE, new ExtensionDeletedProvider());
        ProviderManager.addExtensionProvider("image", ExtensionImage.NAMESPACE, new ExtensionImageProvider());
        ProviderManager.addExtensionProvider(ExtensionGif.ELEMENT, ExtensionGif.NAMESPACE, new ExtensionGifProvider());
        ProviderManager.addExtensionProvider("contact", ExtensionContact.NAMESPACE, new ExtensionContactProvider());
        ProviderManager.addExtensionProvider("event", ExtensionEvent.NAMESPACE, new ExtensionEventProvider());
        ProviderManager.addExtensionProvider(ExtensionMention.ELEMENT, ExtensionMention.NAMESPACE, new ExtensionMentionProvider());
        ProviderManager.addExtensionProvider(ExtensionDeleteOwnerMessage.ELEMENT, ExtensionDeleteOwnerMessage.NAMESPACE, new ExtensionDeleteOwnerMessageProvider());
        ProviderManager.addExtensionProvider(ExtensionStatusExistence.ELEMENT, ExtensionStatusExistence.NAMESPACE, new ExtensionStatusExistenceProvider());
        ProviderManager.addExtensionProvider(OfflineElement.ELEMENT, "jc", new OfflineElementProvider());
        ProviderManager.addExtensionProvider(ExtensionButton.ELEMENT, ExtensionButton.NAMESPACE, new ExtensionButtonProvider());
        ProviderManager.addExtensionProvider(ExtensionPubEdited.ELEMENT, ExtensionPubEdited.NAMESPACE, new ExtensionPubEditedProvider());
        ProviderManager.addExtensionProvider(ExtensionPubDeleted.ELEMENT, ExtensionPubDeleted.NAMESPACE, new ExtensionPubDeletedProvider());
        ProviderManager.addExtensionProvider(ExtensionStreamVideo.ELEMENT, ExtensionStreamVideo.NAMESPACE, new ExtensionStreamVideoProvider());
        ProviderManager.addExtensionProvider(ExtensionCall.ELEMENT, ExtensionCall.NAMESPACE, new ExtensionCallProvider());
        ProviderManager.addIQProvider("query", CallStatusIQ.NAMESPACE, new CallStatusIQProvider());
        ProviderManager.addIQProvider("query", RosterGetHashIQ.NAMESPACE, new RosterGetHashIQProvider());
        ProviderManager.addIQProvider("query", RosterUpdateIQ.NAMESPACE, new RosterUpdateIQProvider());
        ProviderManager.addIQProvider("query", RosterGetListPaginatedIQ.NAMESPACE, new RosterGetListPaginatedIQProvider());
        ProviderManager.addIQProvider("query", RosterGetVersionIQ.NAMESPACE, new RosterGetVersionIQProvider());
        ProviderManager.addIQProvider("query", RosterUpdateVersionIQ.NAMESPACE, new RosterUpdateVersionIQProvider());
        ProviderManager.addExtensionProvider(ExtensionRefreshToDusId.ELEMENT, ExtensionRefreshToDusId.NAMESPACE, new ExtensionRefreshToDusIdProvider());
        ProviderManager.addIQProvider("query", "todus:privacy", new PrivacyUpdateIQProvider());
        ProviderManager.addIQProvider("query", "todus:privacy", new PrivacyGetIQProvider());
        ProviderManager.addIQProvider("query", "todus:group:privacy", new PrivacyAddUpdateIQProvider());
        ProviderManager.addIQProvider("query", "todus:group:privacy", new PrivacyAddGetIQProvider());
        ProviderManager.addExtensionProvider("reaction", ExtensionReaction.NAMESPACE, new ExtensionReactionProvider());
        ProviderManager.addExtensionProvider(ExtensionChunk.ELEMENT, ExtensionChunk.NAMESPACE, new ExtensionChunkProvider());
        ProviderManager.addIQProvider("query", GetUpdateInfoIQ.NAMESPACE, new GetUpdateInfoIQProvider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallManager callManager_delegate$lambda$0(final XMPPDataSource xMPPDataSource) {
        return new CallManager(new XMPPDataSource$callManager$2$1(xMPPDataSource), new lb.a() { // from class: cu.todus.android.xmpp.a
            @Override // lb.a
            public final Object invoke() {
                return this.f28787c.mXMPPConnection;
            }
        }, xMPPDataSource.owner, new XMPPDataSource$callManager$2$3(xMPPDataSource, null), xMPPDataSource.requestingCalls);
    }

    private final void getLastOfflineChannelMessages() {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C13551(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r7 == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOfflineMessages(ab.e<? super ua.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cu.todus.android.xmpp.XMPPDataSource.C13561
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.xmpp.XMPPDataSource$getOfflineMessages$1 r0 = (cu.todus.android.xmpp.XMPPDataSource.C13561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.XMPPDataSource$getOfflineMessages$1 r0 = new cu.todus.android.xmpp.XMPPDataSource$getOfflineMessages$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r1 = r0.L$1
            org.jivesoftware.smack.packet.IQ r1 = (org.jivesoftware.smack.packet.IQ) r1
            java.lang.Object r0 = r0.L$0
            org.jivesoftware.smack.tcp.XMPPTCPConnection r0 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r0
            ua.v.b(r7)     // Catch: java.lang.Exception -> L35
            goto L84
        L35:
            r7 = move-exception
            goto L8c
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3f:
            ua.v.b(r7)
            goto L60
        L43:
            ua.v.b(r7)
            boolean r7 = r6.firstTry
            if (r7 == 0) goto L53
            cu.todus.android.downloadOffline.DownloadOfflineUtility r7 = cu.todus.android.downloadOffline.DownloadOfflineUtility.INSTANCE
            android.content.Context r2 = r6.context
            r7.startService(r2)
            r6.firstTry = r3
        L53:
            cu.todus.android.xmpp.managers.PresenceManager r7 = r6.presenceManager
            if (r7 == 0) goto L60
            r0.label = r5
            java.lang.Object r7 = r7.sendAway(r0)
            if (r7 != r1) goto L60
            goto L83
        L60:
            org.jivesoftware.smack.tcp.XMPPTCPConnection r7 = r6.mXMPPConnection     // Catch: java.lang.Exception -> L35
            if (r7 == 0) goto L88
            cu.todus.android.xmpp.iq.offline.GetOfflineIQ r2 = new cu.todus.android.xmpp.iq.offline.GetOfflineIQ     // Catch: java.lang.Exception -> L35
            r2.<init>()     // Catch: java.lang.Exception -> L35
            te.h r5 = cu.todus.android.xmpp.XMPPInlinesKt.sendIQFlow(r7, r2)     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = cb.l.a(r7)     // Catch: java.lang.Exception -> L35
            r0.L$0 = r7     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = cb.l.a(r2)     // Catch: java.lang.Exception -> L35
            r0.L$1 = r7     // Catch: java.lang.Exception -> L35
            r0.I$0 = r3     // Catch: java.lang.Exception -> L35
            r0.label = r4     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = te.j.x(r5, r0)     // Catch: java.lang.Exception -> L35
            if (r7 != r1) goto L84
        L83:
            return r1
        L84:
            org.jivesoftware.smack.packet.IQ r7 = (org.jivesoftware.smack.packet.IQ) r7     // Catch: java.lang.Exception -> L35
            cu.todus.android.xmpp.iq.offline.GetOfflineIQ r7 = (cu.todus.android.xmpp.iq.offline.GetOfflineIQ) r7     // Catch: java.lang.Exception -> L35
        L88:
            r6.getLastOfflineChannelMessages()     // Catch: java.lang.Exception -> L35
            goto L8f
        L8c:
            r7.printStackTrace()
        L8f:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.getOfflineMessages(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object initConnectWithIM(XMPPConnection xMPPConnection, ab.e<? super k0> eVar) {
        C13571 c13571;
        if (eVar instanceof C13571) {
            c13571 = (C13571) eVar;
            int i10 = c13571.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13571.label = i10 - Integer.MIN_VALUE;
            } else {
                c13571 = new C13571(eVar);
            }
        } else {
            c13571 = new C13571(eVar);
        }
        Object objZ = c13571.result;
        Object objG = bb.b.g();
        int i11 = c13571.label;
        if (i11 == 0) {
            ua.v.b(objZ);
            if (!this.isTrying) {
                this.isTrying = true;
                te.h hVarG = te.j.g(te.j.P(loginWithIM(xMPPConnection), new C13582(null)), new C13593(null));
                c13571.L$0 = cb.l.a(xMPPConnection);
                c13571.label = 1;
                objZ = te.j.z(hVarG, c13571);
                if (objZ == objG) {
                    return objG;
                }
            }
            return k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objZ);
        Boolean bool = (Boolean) objZ;
        if (bool != null && !bool.booleanValue()) {
            this.restartActivity.invoke();
        }
        this.isTrying = false;
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:32:0x007d  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        if (loadRoster$default(r8, false, r0, 1, null) == r1) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initListeners(ab.e<? super ua.k0> r9) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.initListeners(ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initManagers(ab.e<? super k0> eVar) {
        ReconnectionManager reconnectionManager = this.reconnectionManager;
        if (reconnectionManager == null) {
            this.reconnectionManager = new ReconnectionManager(this.mXMPPConnection);
        } else if (reconnectionManager != null) {
            reconnectionManager.weakRefConnection = new WeakReference<>(this.mXMPPConnection);
        }
        ReconnectionManager reconnectionManager2 = this.reconnectionManager;
        if (reconnectionManager2 != null) {
            reconnectionManager2.setReconnectionPolicy(ReconnectionManager.ReconnectionPolicy.FIXED_DELAY);
        }
        ReconnectionManager reconnectionManager3 = this.reconnectionManager;
        if (reconnectionManager3 != null) {
            reconnectionManager3.setFixedDelay(3);
        }
        ReconnectionManager reconnectionManager4 = this.reconnectionManager;
        if (reconnectionManager4 != null) {
            reconnectionManager4.enableAutomaticReconnection();
        }
        ReconnectionManager reconnectionManager5 = this.reconnectionManager;
        if (reconnectionManager5 != null) {
            cb.b.a(reconnectionManager5.addReconnectionListener(new ReconnectionListener() { // from class: cu.todus.android.xmpp.XMPPDataSource.initManagers.2
                @Override // org.jivesoftware.smack.ReconnectionListener
                public void reconnectingIn(int seconds) {
                    XMPPDataSource.this.setConnectionState(ConnectionState.RECONNECTING);
                }

                @Override // org.jivesoftware.smack.ReconnectionListener
                public void reconnectionFailed(Exception e10) {
                    XMPPDataSource.this.setConnectionState(ConnectionState.DISCONNECTED);
                }
            }));
        }
        initPingManager();
        if (this.presenceManager == null) {
            this.presenceManager = new PresenceManager(new C13623(this), this.mXMPPConnection);
        }
        if (this.urlManager == null) {
            this.urlManager = new UrlManager(new AnonymousClass4(this), new lb.a() { // from class: cu.todus.android.xmpp.m
                @Override // lb.a
                public final Object invoke() {
                    return this.f28854c.mXMPPConnection;
                }
            }, new lb.a() { // from class: cu.todus.android.xmpp.c
                @Override // lb.a
                public final Object invoke() {
                    return XMPPDataSource.initManagers$lambda$1(this.f28797c);
                }
            });
        }
        if (this.blocksManager == null) {
            this.blocksManager = new BlocksManager(new AnonymousClass7(this), new lb.a() { // from class: cu.todus.android.xmpp.d
                @Override // lb.a
                public final Object invoke() {
                    return this.f28802c.mXMPPConnection;
                }
            }, this.owner);
        }
        if (this.locationManager == null) {
            this.locationManager = new LocationManager(new AnonymousClass9(this), new lb.a() { // from class: cu.todus.android.xmpp.e
                @Override // lb.a
                public final Object invoke() {
                    return this.f28808c.mXMPPConnection;
                }
            }, new AnonymousClass11(null));
        }
        if (this.lastManager == null) {
            this.lastManager = new LastManager(new AnonymousClass12(this), new lb.a() { // from class: cu.todus.android.xmpp.f
                @Override // lb.a
                public final Object invoke() {
                    return this.f28829c.mXMPPConnection;
                }
            });
        }
        if (this.rosterManager == null) {
            this.rosterManager = new RosterManager(new AnonymousClass14(this), new lb.a() { // from class: cu.todus.android.xmpp.g
                @Override // lb.a
                public final Object invoke() {
                    return this.f28833c.mXMPPConnection;
                }
            }, new RosterVersionManager(this.context));
        }
        if (this.statusManager == null) {
            this.statusManager = new StatusManager(new AnonymousClass16(this), new lb.a() { // from class: cu.todus.android.xmpp.h
                @Override // lb.a
                public final Object invoke() {
                    return this.f28838c.mXMPPConnection;
                }
            }, this.owner, new AnonymousClass18(null), new AnonymousClass19(null));
        }
        if (this.channelManager == null) {
            this.channelManager = new ChannelManager(new AnonymousClass20(this), new lb.a() { // from class: cu.todus.android.xmpp.i
                @Override // lb.a
                public final Object invoke() {
                    return this.f28842c.mXMPPConnection;
                }
            }, this.owner, new AnonymousClass22(null));
        }
        if (this.profileManager == null) {
            this.profileManager = new ProfileManager(this.owner, this.updateOwner, new AnonymousClass23(this), this.context, new AnonymousClass24(null));
        }
        if (this.groupsManager == null) {
            this.groupsManager = new GroupsManager(this.owner, new AnonymousClass25(this), new lb.a() { // from class: cu.todus.android.xmpp.j
                @Override // lb.a
                public final Object invoke() {
                    return this.f28851c.mXMPPConnection;
                }
            }, new AnonymousClass27(null));
        }
        if (this.messageManager == null) {
            AnonymousClass28 anonymousClass28 = new AnonymousClass28(this);
            Context context = this.context;
            lb.a aVar = this.owner;
            NotificationManager notificationManager = this.notificationManager;
            this.messageManager = new MessageManager(anonymousClass28, new lb.a() { // from class: cu.todus.android.xmpp.k
                @Override // lb.a
                public final Object invoke() {
                    return this.f28852c.mXMPPConnection;
                }
            }, this.appVolatileState.getBlockRooms(), aVar, context, notificationManager, new lb.a() { // from class: cu.todus.android.xmpp.n
                @Override // lb.a
                public final Object invoke() {
                    return XMPPDataSource.initManagers$lambda$10(this.f28874c);
                }
            }, new AnonymousClass31(null), new AnonymousClass32(null), new AnonymousClass33(null), new AnonymousClass34(null), new AnonymousClass35(null), new AnonymousClass36(null), new AnonymousClass37(null), new Function1() { // from class: cu.todus.android.xmpp.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return XMPPDataSource.initManagers$lambda$11(this.f28875c, (StatusExistenceContent) obj);
                }
            }, new AnonymousClass39(null));
        }
        if (this.ownerMessageManager == null) {
            this.ownerMessageManager = new OwnerMessageManager(new AnonymousClass40(this), new lb.a() { // from class: cu.todus.android.xmpp.p
                @Override // lb.a
                public final Object invoke() {
                    return this.f28876c.mXMPPConnection;
                }
            }, this.uploadDataSource, this.owner);
        }
        if (this.ownerReactionManager == null) {
            this.ownerReactionManager = new OwnerReactionManager(new AnonymousClass42(this), new lb.a() { // from class: cu.todus.android.xmpp.q
                @Override // lb.a
                public final Object invoke() {
                    return this.f28877c.mXMPPConnection;
                }
            });
        }
        if (this.ownerMarkersManager == null) {
            this.ownerMarkersManager = new OwnerMarkersManager(new AnonymousClass44(this), new lb.a() { // from class: cu.todus.android.xmpp.r
                @Override // lb.a
                public final Object invoke() {
                    return this.f28878c.mXMPPConnection;
                }
            });
        }
        if (this.privacyManager == null) {
            this.privacyManager = new PrivacyManager(new AnonymousClass46(this), new lb.a() { // from class: cu.todus.android.xmpp.s
                @Override // lb.a
                public final Object invoke() {
                    return this.f28879c.mXMPPConnection;
                }
            });
        }
        if (this.ownerStatusManager == null) {
            this.ownerStatusManager = new OwnerStatusManager(new AnonymousClass48(this), new lb.a() { // from class: cu.todus.android.xmpp.t
                @Override // lb.a
                public final Object invoke() {
                    return this.f28880c.mXMPPConnection;
                }
            }, this.owner, this.uploadStatusDataSource);
        }
        if (this.ownerDeleteMessageManager == null) {
            this.ownerDeleteMessageManager = new OwnerDeleteMessageManager(new AnonymousClass50(this), new lb.a() { // from class: cu.todus.android.xmpp.b
                @Override // lb.a
                public final Object invoke() {
                    return this.f28792c.mXMPPConnection;
                }
            }, this.owner);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 initManagers$lambda$1(XMPPDataSource xMPPDataSource) {
        CoroutineUtilsKt.launchWithContext$default(xMPPDataSource.coroutineScope, null, null, new XMPPDataSource$initManagers$6$1(xMPPDataSource, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 initManagers$lambda$10(XMPPDataSource xMPPDataSource) {
        CoroutineUtilsKt.launchWithContext$default(xMPPDataSource.coroutineScope, null, null, new XMPPDataSource$initManagers$30$1(xMPPDataSource, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 initManagers$lambda$11(XMPPDataSource xMPPDataSource, StatusExistenceContent it) {
        kotlin.jvm.internal.y.i(it, "it");
        StatusManager statusManager = xMPPDataSource.statusManager;
        if (statusManager != null) {
            statusManager.handleStatusExistence(it);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPingManager() {
        if (this.pingManager == null) {
            PingManager instanceFor = PingManager.getInstanceFor(this.mXMPPConnection);
            this.pingManager = instanceFor;
            if (instanceFor != null) {
                instanceFor.setPingInterval(30);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
    
        if (r2.handlePublications(r5, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadLastChannelMsgs(java.lang.String r14, ab.e<? super ua.k0> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof cu.todus.android.xmpp.XMPPDataSource.C13641
            if (r0 == 0) goto L13
            r0 = r15
            cu.todus.android.xmpp.XMPPDataSource$loadLastChannelMsgs$1 r0 = (cu.todus.android.xmpp.XMPPDataSource.C13641) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.XMPPDataSource$loadLastChannelMsgs$1 r0 = new cu.todus.android.xmpp.XMPPDataSource$loadLastChannelMsgs$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r14 = r0.L$1
            cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ r14 = (cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ) r14
            java.lang.Object r14 = r0.L$0
            java.lang.String r14 = (java.lang.String) r14
            ua.v.b(r15)
            goto Lbc
        L36:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3e:
            java.lang.Object r14 = r0.L$2
            org.jivesoftware.smack.packet.IQ r14 = (org.jivesoftware.smack.packet.IQ) r14
            java.lang.Object r14 = r0.L$1
            org.jivesoftware.smack.tcp.XMPPTCPConnection r14 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r14
            java.lang.Object r14 = r0.L$0
            java.lang.String r14 = (java.lang.String) r14
            ua.v.b(r15)
            goto L8a
        L4e:
            ua.v.b(r15)
            boolean r15 = r13.canSend()
            if (r15 == 0) goto Lbc
            org.jivesoftware.smack.tcp.XMPPTCPConnection r15 = r13.mXMPPConnection
            if (r15 == 0) goto Lbc
            cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ r6 = new cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ
            r11 = 8
            r12 = 0
            java.lang.String r8 = "9223372036854775807"
            r9 = -8
            r10 = 0
            r7 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12)
            te.h r14 = cu.todus.android.xmpp.XMPPInlinesKt.sendIQFlow(r15, r6)
            java.lang.Object r2 = cb.l.a(r7)
            r0.L$0 = r2
            java.lang.Object r15 = cb.l.a(r15)
            r0.L$1 = r15
            java.lang.Object r15 = cb.l.a(r6)
            r0.L$2 = r15
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r15 = te.j.x(r14, r0)
            if (r15 != r1) goto L89
            goto Lbb
        L89:
            r14 = r7
        L8a:
            org.jivesoftware.smack.packet.IQ r15 = (org.jivesoftware.smack.packet.IQ) r15
            cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ r15 = (cu.todus.android.xmpp.iq.channels.GetPublicationsChannelIQ) r15
            if (r15 == 0) goto Lbc
            java.util.ArrayList r2 = r15.getPubList()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lbc
            cu.todus.android.xmpp.managers.ChannelManager r2 = r13.channelManager
            if (r2 == 0) goto Lbc
            java.util.ArrayList r5 = r15.getPubList()
            java.lang.Object r14 = cb.l.a(r14)
            r0.L$0 = r14
            java.lang.Object r14 = cb.l.a(r15)
            r0.L$1 = r14
            r14 = 0
            r0.L$2 = r14
            r0.I$0 = r3
            r0.label = r4
            java.lang.Object r14 = r2.handlePublications(r5, r0)
            if (r14 != r1) goto Lbc
        Lbb:
            return r1
        Lbc:
            ua.k0 r14 = ua.k0.f43947a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.loadLastChannelMsgs(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0114  */
    /* JADX WARN: Code duplicated, block: B:39:0x0130  */
    /* JADX WARN: Code duplicated, block: B:41:0x0139  */
    /* JADX WARN: Code duplicated, block: B:45:0x0158  */
    /* JADX WARN: Code duplicated, block: B:48:0x0162  */
    /* JADX WARN: Code duplicated, block: B:51:0x018f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0197  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e5, code lost:
    
        if (loadOfflineChannelMsgs(r12, r13, r2) == r3) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadOfflineChannelMsgs(java.lang.String r20, java.lang.String r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.loadOfflineChannelMsgs(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadRoster(boolean z10, ab.e<? super k0> eVar) {
        C13661 c13661;
        if (eVar instanceof C13661) {
            c13661 = (C13661) eVar;
            int i10 = c13661.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13661.label = i10 - Integer.MIN_VALUE;
            } else {
                c13661 = new C13661(eVar);
            }
        } else {
            c13661 = new C13661(eVar);
        }
        Object obj = c13661.result;
        Object objG = bb.b.g();
        int i11 = c13661.label;
        if (i11 == 0) {
            ua.v.b(obj);
            this.isLoadingRoster = true;
            RosterManager rosterManager = this.rosterManager;
            if (rosterManager != null) {
                c13661.Z$0 = z10;
                c13661.label = 1;
                if (rosterManager.loadRosterAndUsersInfo(z10, c13661) == objG) {
                    return objG;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        this.updatingInitialData.setValue(cb.b.a(false));
        this.isLoadingRoster = false;
        return k0.f43947a;
    }

    public static /* synthetic */ Object loadRoster$default(XMPPDataSource xMPPDataSource, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return xMPPDataSource.loadRoster(z10, eVar);
    }

    private final te.h loginWithIM(XMPPConnection conn) {
        return te.j.B(new C13671(conn, this, null));
    }

    public static /* synthetic */ void runParallelRosterLoad$default(XMPPDataSource xMPPDataSource, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        xMPPDataSource.runParallelRosterLoad(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final te.h setConfigurations() {
        return te.j.B(new C13741(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startReconnectingTimer() {
        stopReconnectingTimer();
        this.timerJob = pe.k.d(this.reconnectionScope, null, null, new C13751(null), 3, null);
    }

    private final void startSending() {
        MessageManager messageManager = this.messageManager;
        if (messageManager != null) {
            messageManager.startManager();
        }
        GroupsManager groupsManager = this.groupsManager;
        if (groupsManager != null) {
            groupsManager.startManager();
        }
        OwnerMessageManager ownerMessageManager = this.ownerMessageManager;
        if (ownerMessageManager != null) {
            ownerMessageManager.startManager();
        }
        OwnerReactionManager ownerReactionManager = this.ownerReactionManager;
        if (ownerReactionManager != null) {
            ownerReactionManager.startManager();
        }
        OwnerMarkersManager ownerMarkersManager = this.ownerMarkersManager;
        if (ownerMarkersManager != null) {
            ownerMarkersManager.startManager();
        }
        OwnerStatusManager ownerStatusManager = this.ownerStatusManager;
        if (ownerStatusManager != null) {
            ownerStatusManager.startManager();
        }
        StatusManager statusManager = this.statusManager;
        if (statusManager != null) {
            statusManager.startManager();
        }
        OwnerDeleteMessageManager ownerDeleteMessageManager = this.ownerDeleteMessageManager;
        if (ownerDeleteMessageManager != null) {
            ownerDeleteMessageManager.startManager();
        }
        getCallManager().startManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSending() {
        this.appVolatileState.clearLast();
        MessageManager messageManager = this.messageManager;
        if (messageManager != null) {
            messageManager.stopManager();
        }
        GroupsManager groupsManager = this.groupsManager;
        if (groupsManager != null) {
            groupsManager.stopManager();
        }
        OwnerMessageManager ownerMessageManager = this.ownerMessageManager;
        if (ownerMessageManager != null) {
            ownerMessageManager.stopManager();
        }
        OwnerReactionManager ownerReactionManager = this.ownerReactionManager;
        if (ownerReactionManager != null) {
            ownerReactionManager.stopManager();
        }
        OwnerMarkersManager ownerMarkersManager = this.ownerMarkersManager;
        if (ownerMarkersManager != null) {
            ownerMarkersManager.stopManager();
        }
        OwnerStatusManager ownerStatusManager = this.ownerStatusManager;
        if (ownerStatusManager != null) {
            ownerStatusManager.stopManager();
        }
        OwnerDeleteMessageManager ownerDeleteMessageManager = this.ownerDeleteMessageManager;
        if (ownerDeleteMessageManager != null) {
            ownerDeleteMessageManager.stopManager();
        }
        StatusManager statusManager = this.statusManager;
        if (statusManager != null) {
            statusManager.stopManager();
        }
        this.appVolatileState.clearLast();
        this.uploadDataSource.cancelAll();
        this.uploadStatusDataSource.cancelAll();
        this.downloadDataSource.cancelAll();
        getCallManager().stopManager();
        getCallManager().destroy();
        try {
            DownloadOfflineUtility.INSTANCE.stopService(this.context);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final boolean canSend() {
        XMPPTCPConnection xMPPTCPConnection;
        return this.connectionState.getValue() == ConnectionState.CONNECTED && (xMPPTCPConnection = this.mXMPPConnection) != null && xMPPTCPConnection.isConnected();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object disconnect(ab.e<? super k0> eVar) {
        C13531 c13531;
        if (eVar instanceof C13531) {
            c13531 = (C13531) eVar;
            int i10 = c13531.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13531.label = i10 - Integer.MIN_VALUE;
            } else {
                c13531 = new C13531(eVar);
            }
        } else {
            c13531 = new C13531(eVar);
        }
        Object obj = c13531.result;
        Object objG = bb.b.g();
        int i11 = c13531.label;
        try {
            if (i11 == 0) {
                ua.v.b(obj);
                pe.k0 k0VarB = d1.b();
                C13542 c13542 = new C13542(null);
                c13531.label = 1;
                if (pe.i.g(k0VarB, c13542, c13531) == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            setConnectionState(ConnectionState.DISCONNECTED);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    public final BlocksManager getBlocksManager() {
        return this.blocksManager;
    }

    public final CallManager getCallManager() {
        return (CallManager) this.callManager.getValue();
    }

    public final ChannelManager getChannelManager() {
        return this.channelManager;
    }

    public final te.b0 getConnectionState() {
        return this.connectionState;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DownloadDataSource getDownloadDataSource() {
        return this.downloadDataSource;
    }

    public final boolean getFirstTry() {
        return this.firstTry;
    }

    public final GroupsManager getGroupsManager() {
        return this.groupsManager;
    }

    public final LastManager getLastManager() {
        return this.lastManager;
    }

    public final LocationManager getLocationManager() {
        return this.locationManager;
    }

    public final MessageManager getMessageManager() {
        return this.messageManager;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final OwnerDeleteMessageManager getOwnerDeleteMessageManager() {
        return this.ownerDeleteMessageManager;
    }

    public final OwnerMarkersManager getOwnerMarkersManager() {
        return this.ownerMarkersManager;
    }

    public final OwnerMessageManager getOwnerMessageManager() {
        return this.ownerMessageManager;
    }

    public final OwnerReactionManager getOwnerReactionManager() {
        return this.ownerReactionManager;
    }

    public final OwnerStatusManager getOwnerStatusManager() {
        return this.ownerStatusManager;
    }

    public final PresenceManager getPresenceManager() {
        return this.presenceManager;
    }

    public final PrivacyManager getPrivacyManager() {
        return this.privacyManager;
    }

    public final ProfileManager getProfileManager() {
        return this.profileManager;
    }

    public final Function1 getRefreshToken() {
        return this.refreshToken;
    }

    public final Z17MutableListFlow<CallState> getRequestingCalls() {
        return this.requestingCalls;
    }

    public final lb.a getRestartActivity() {
        return this.restartActivity;
    }

    public final RosterManager getRosterManager() {
        return this.rosterManager;
    }

    public final StatusManager getStatusManager() {
        return this.statusManager;
    }

    public final Function1 getUpdateOwner() {
        return this.updateOwner;
    }

    public final te.b0 getUpdatingInitialData() {
        return this.updatingInitialData;
    }

    public final UploadDataSource getUploadDataSource() {
        return this.uploadDataSource;
    }

    public final UploadStatusDataSource getUploadStatusDataSource() {
        return this.uploadStatusDataSource;
    }

    public final UrlManager getUrlManager() {
        return this.urlManager;
    }

    /* JADX INFO: renamed from: isFirstTime, reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d1, code lost:
    
        if (r7.handlePublications(r8, r1) == r2) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadChannelMsgsBefore(java.lang.String r15, java.lang.String r16, ab.e<? super ua.k0> r17) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.loadChannelMsgsBefore(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object requestUpdateInfo(ab.e<? super GetUpdateInfoIQ> eVar) {
        C13681 c13681;
        GetUpdateInfoIQ getUpdateInfoIQ;
        if (eVar instanceof C13681) {
            c13681 = (C13681) eVar;
            int i10 = c13681.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13681.label = i10 - Integer.MIN_VALUE;
            } else {
                c13681 = new C13681(eVar);
            }
        } else {
            c13681 = new C13681(eVar);
        }
        Object objX = c13681.result;
        Object objG = bb.b.g();
        int i11 = c13681.label;
        try {
            if (i11 == 0) {
                ua.v.b(objX);
                canSend();
                if (!canSend()) {
                    Log.w("XMPPDataSource", "Cannot send: not connected");
                    return null;
                }
                XMPPTCPConnection xMPPTCPConnection = this.mXMPPConnection;
                if (xMPPTCPConnection != null) {
                    GetUpdateInfoIQ getUpdateInfoIQ2 = new GetUpdateInfoIQ(null, 0L, null, 0L, null, null, 63, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getUpdateInfoIQ2);
                    c13681.L$0 = cb.l.a(xMPPTCPConnection);
                    c13681.L$1 = cb.l.a(getUpdateInfoIQ2);
                    c13681.I$0 = 0;
                    c13681.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c13681);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    getUpdateInfoIQ = null;
                }
                Objects.toString(getUpdateInfoIQ);
                return getUpdateInfoIQ;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
            getUpdateInfoIQ = (GetUpdateInfoIQ) ((IQ) objX);
            Objects.toString(getUpdateInfoIQ);
            return getUpdateInfoIQ;
        } catch (Exception e10) {
            Log.e("XMPPDataSource", "Error sending GetUpdateInfoIQ", e10);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (te.j.x(r7, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reset(ab.e<? super ua.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cu.todus.android.xmpp.XMPPDataSource.C13691
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.xmpp.XMPPDataSource$reset$1 r0 = (cu.todus.android.xmpp.XMPPDataSource.C13691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.XMPPDataSource$reset$1 r0 = new cu.todus.android.xmpp.XMPPDataSource$reset$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            ua.v.b(r7)
            goto L6d
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            ua.v.b(r7)
            goto L56
        L3b:
            ua.v.b(r7)
            goto L4b
        L3f:
            ua.v.b(r7)
            r0.label = r5
            java.lang.Object r7 = r6.disconnect(r0)
            if (r7 != r1) goto L4b
            goto L6c
        L4b:
            kotlin.jvm.functions.Function1 r7 = r6.refreshToken
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r0)
            if (r7 != r1) goto L56
            goto L6c
        L56:
            te.h r7 = r6.setConfigurations()
            cu.todus.android.xmpp.XMPPDataSource$reset$2 r2 = new cu.todus.android.xmpp.XMPPDataSource$reset$2
            r4 = 0
            r2.<init>(r4)
            te.h r7 = te.j.g(r7, r2)
            r0.label = r3
            java.lang.Object r7 = te.j.x(r7, r0)
            if (r7 != r1) goto L6d
        L6c:
            return r1
        L6d:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPDataSource.reset(ab.e):java.lang.Object");
    }

    public final void runParallelRosterLoad(boolean hasContactsPermission) {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C13711(hasContactsPermission, null), 3, null);
    }

    public final void sendFirebaseToken(String token) {
        kotlin.jvm.internal.y.i(token, "token");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C13721(token, null), 3, null);
    }

    public final void sendTyping(String uid, boolean b10) {
        kotlin.jvm.internal.y.i(uid, "uid");
        if (canSend()) {
            try {
                Message message = new Message();
                String string = UUID.randomUUID().toString();
                kotlin.jvm.internal.y.h(string, "toString(...)");
                message.setStanzaId(le.a0.O(string, "-", "", false, 4, null));
                message.setTo(JidCreate.bareFrom(uid).asBareJid());
                XMPPTCPConnection xMPPTCPConnection = this.mXMPPConnection;
                message.setFrom(xMPPTCPConnection != null ? xMPPTCPConnection.getUser() : null);
                if (le.d0.a0(uid, Service.Config.SERVER_NAME_MUC, false, 2, null)) {
                    message.setType(Message.Type.groupchat);
                } else {
                    message.setType(Message.Type.chat);
                    message.setTo(JidCreate.bareFrom(uid).asEntityBareJidIfPossible());
                }
                message.addExtension(new ChatStateExtensionToDus(b10 ? ChatStateToDus.csc : ChatStateToDus.csp));
                CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C13731(message, null), 3, null);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void setBlocksManager(BlocksManager blocksManager) {
        this.blocksManager = blocksManager;
    }

    public final void setChannelManager(ChannelManager channelManager) {
        this.channelManager = channelManager;
    }

    public final void setConnectionState(ConnectionState value) {
        kotlin.jvm.internal.y.i(value, "value");
        this.connectionState.setValue(value);
    }

    public final void setContext(Context context) {
        kotlin.jvm.internal.y.i(context, "<set-?>");
        this.context = context;
    }

    public final void setFirstTry(boolean z10) {
        this.firstTry = z10;
    }

    public final void setGroupsManager(GroupsManager groupsManager) {
        this.groupsManager = groupsManager;
    }

    public final void setLastManager(LastManager lastManager) {
        this.lastManager = lastManager;
    }

    public final void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public final void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    public final void setOwnerDeleteMessageManager(OwnerDeleteMessageManager ownerDeleteMessageManager) {
        this.ownerDeleteMessageManager = ownerDeleteMessageManager;
    }

    public final void setOwnerMarkersManager(OwnerMarkersManager ownerMarkersManager) {
        this.ownerMarkersManager = ownerMarkersManager;
    }

    public final void setOwnerMessageManager(OwnerMessageManager ownerMessageManager) {
        this.ownerMessageManager = ownerMessageManager;
    }

    public final void setOwnerReactionManager(OwnerReactionManager ownerReactionManager) {
        this.ownerReactionManager = ownerReactionManager;
    }

    public final void setOwnerStatusManager(OwnerStatusManager ownerStatusManager) {
        this.ownerStatusManager = ownerStatusManager;
    }

    public final void setPresenceManager(PresenceManager presenceManager) {
        this.presenceManager = presenceManager;
    }

    public final void setPrivacyManager(PrivacyManager privacyManager) {
        this.privacyManager = privacyManager;
    }

    public final void setProfileManager(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    public final void setRosterManager(RosterManager rosterManager) {
        this.rosterManager = rosterManager;
    }

    public final void setStatusManager(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    public final void setUrlManager(UrlManager urlManager) {
        this.urlManager = urlManager;
    }

    public final void stopReconnectingTimer() {
        a2 a2Var = this.timerJob;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
            k0 k0Var = k0.f43947a;
        }
        this.timerJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeBase64Encoder() {
    }
}
