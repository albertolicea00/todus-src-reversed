package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup;
import cu.todus.android.data.xmpp.AddMembersToGroupResponse;
import cu.todus.android.data.xmpp.AdminGroupActionsResponse;
import cu.todus.android.data.xmpp.GroupAffiliation;
import cu.todus.android.data.xmpp.JoinResult;
import cu.todus.android.data.xmpp.MucInfo;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.xmpp.StanzaListenerManager;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.groups.AddGroupMembersIQ;
import cu.todus.android.xmpp.iq.groups.ChangeGroupConfigsIQ;
import cu.todus.android.xmpp.iq.groups.DemoteGroupAdminIQ;
import cu.todus.android.xmpp.iq.groups.ExpelMemberFromGroupIQ;
import cu.todus.android.xmpp.iq.groups.GetGroupListPaginatedIQ;
import cu.todus.android.xmpp.iq.groups.GroupGetLinkIQ;
import cu.todus.android.xmpp.iq.groups.GroupInfoByIdIQ;
import cu.todus.android.xmpp.iq.groups.GroupInfoIQByLink;
import cu.todus.android.xmpp.iq.groups.GroupMembersIQ;
import cu.todus.android.xmpp.iq.groups.GroupSetLinkIQ;
import cu.todus.android.xmpp.iq.groups.JoinGroupIQ;
import cu.todus.android.xmpp.iq.groups.LeaveGroupIQ;
import cu.todus.android.xmpp.iq.groups.PromoteGroupAdminIQ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import le.d0;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import ua.k0;
import va.w0;
import va.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Be\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002\u00120\u0010\u000f\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00120\nH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b#\u0010$J.\u0010'\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b*\u0010!J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b+\u0010!J \u0010-\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b-\u0010.JZ\u00103\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2(\b\u0002\u00102\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u000100j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`1H\u0086@¢\u0006\u0004\b3\u00104J\u001a\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b5\u0010!J\u001a\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b6\u0010!J\u001a\u00109\u001a\u0004\u0018\u0001082\u0006\u00107\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b9\u0010!J\u001a\u0010;\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b;\u0010!J&\u0010=\u001a\u00020<2\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b=\u0010>J \u0010@\u001a\u00020?2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b@\u0010.J \u0010B\u001a\u00020?2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bB\u0010.J\u000f\u0010C\u001a\u00020\u0014H\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0014H\u0016¢\u0006\u0004\bE\u0010DR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010F\u001a\u0004\bG\u0010HR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010F\u001a\u0004\bI\u0010HR\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010F\u001a\u0004\bJ\u0010HRA\u0010\u000f\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Tj\b\u0012\u0004\u0012\u00020\u000b`U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006["}, d2 = {"Lcu/todus/android/xmpp/managers/GroupsManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lkotlin/Function2;", "", "", "Lab/e;", "Lcu/todus/android/data/db/entity/toDus/User;", "", "getUsersInfo", "<init>", "(Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Pair;", Service.Endpoint.LINKED_DEVICES_LIST, "Lua/k0;", "updateMucList", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "groupId", "", "members", "updateMucMember", "(Ljava/lang/String;Ljava/util/Map;)V", "Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInGroup;", "messagePayload", "processPrivilegesChangePayload", "(Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInGroup;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "reloadGroup", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "askForReloadMucMemberList", "reloadGroupList", "(Lab/e;)Ljava/lang/Object;", "name", "affiliates", "createGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/MucInfo;", "getGroupInfoById", "leaveGroup", UserRoomJoin.AFFILIATION_MEMBER, "expelMember", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "subject", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "customConfigs", "changeGroupConfigs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lab/e;)Ljava/lang/Object;", "createGroupLinkId", "getGroupLinkId", "link", "Lcu/todus/android/data/xmpp/JoinResult;", "joinToGroup", "linkId", "getGroupInfoByLinkId", "Lcu/todus/android/data/xmpp/AddMembersToGroupResponse;", "addNewMembers", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/AdminGroupActionsResponse;", "promoteToAdmin", "adminId", "demoteFromAdmin", "startManager", "()V", "stopManager", "Llb/a;", "getOwner", "()Llb/a;", "getCanSend", "getMXMPPConnection", "Lkotlin/jvm/functions/Function2;", "getGetUsersInfo", "()Lkotlin/jvm/functions/Function2;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadingMembersFrom", "Ljava/util/ArrayList;", "Lorg/jivesoftware/smack/StanzaListener;", "roomStanzaListener", "Lorg/jivesoftware/smack/StanzaListener;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GroupsManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final m0 coroutineScope;
    private final DatabaseModule databaseModule;
    private final Function2 getUsersInfo;
    private final ArrayList<String> loadingMembersFrom;
    private final lb.a mXMPPConnection;
    private final lb.a owner;
    private final StanzaListener roomStanzaListener;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrivilegesChangeInGroup.PRIVILEGES.values().length];
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrivilegesChangeInGroup.PRIVILEGES.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$addNewMembers$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "addNewMembers", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.addNewMembers(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$askForReloadMucMemberList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "askForReloadMucMemberList", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14381 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14381(ab.e<? super C14381> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.askForReloadMucMemberList(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$changeGroupConfigs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "changeGroupConfigs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14391 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14391(ab.e<? super C14391> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.changeGroupConfigs(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$createGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475, 287, 300}, m = "createGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14401 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C14401(ab.e<? super C14401> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.createGroup(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$createGroupLinkId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "createGroupLinkId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14411 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14411(ab.e<? super C14411> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.createGroupLinkId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$demoteFromAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "demoteFromAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14421 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14421(ab.e<? super C14421> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.demoteFromAdmin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$expelMember$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "expelMember", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14431 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14431(ab.e<? super C14431> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.expelMember(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$getGroupInfoById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "getGroupInfoById", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14441 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14441(ab.e<? super C14441> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.getGroupInfoById(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$getGroupInfoByLinkId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "getGroupInfoByLinkId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14451 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14451(ab.e<? super C14451> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.getGroupInfoByLinkId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$getGroupLinkId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "getGroupLinkId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14461 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14461(ab.e<? super C14461> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.getGroupLinkId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$joinToGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "joinToGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14471 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14471(ab.e<? super C14471> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.joinToGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$leaveGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "leaveGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14481 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14481(ab.e<? super C14481> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.leaveGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$promoteToAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {475}, m = "promoteToAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14491 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14491(ab.e<? super C14491> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.promoteToAdmin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$reloadGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {90, 92, 100, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, WebmConstants.MkvEbmlElement.TRACK_TYPE}, m = "reloadGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14501 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14501(ab.e<? super C14501> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.reloadGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$reloadGroupList$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager$reloadGroupList$2", f = "GroupsManager.kt", l = {475}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", DataLayout.ELEMENT, "", "pageSize"}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(Map.Entry entry) {
            return !d0.q0(entry.getKey().toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Pair invokeSuspend$lambda$1(Map.Entry entry) {
            return ua.z.a(entry.getKey().toString(), entry.getValue());
        }

        public final Object invoke(int i10, int i11, ab.e<? super List<Pair<String, String>>> eVar) {
            AnonymousClass2 anonymousClass2 = GroupsManager.this.new AnonymousClass2(eVar);
            anonymousClass2.I$0 = i10;
            anonymousClass2.I$1 = i11;
            return anonymousClass2.invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            GetGroupListPaginatedIQ getGroupListPaginatedIQ;
            HashMap<Jid, String> mucs;
            ke.h hVarB;
            ke.h hVarE;
            ke.h hVarQ;
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = bb.b.g();
            int i12 = this.label;
            if (i12 == 0) {
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) GroupsManager.this.getMXMPPConnection().invoke();
                if (xMPPTCPConnection != null) {
                    GetGroupListPaginatedIQ getGroupListPaginatedIQ2 = new GetGroupListPaginatedIQ(null, i11, i10, 1, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getGroupListPaginatedIQ2);
                    this.L$0 = cb.l.a(xMPPTCPConnection);
                    this.L$1 = cb.l.a(getGroupListPaginatedIQ2);
                    this.I$0 = i10;
                    this.I$1 = i11;
                    this.I$2 = 0;
                    this.label = 1;
                    obj = te.j.x(hVarSendIQFlow, this);
                    if (obj == objG) {
                        return objG;
                    }
                } else {
                    getGroupListPaginatedIQ = null;
                }
                if (getGroupListPaginatedIQ != null || (mucs = getGroupListPaginatedIQ.getMucs()) == null || (hVarB = y0.B(mucs)) == null || (hVarE = ke.u.E(hVarB, new Function1() { // from class: cu.todus.android.xmpp.managers.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(GroupsManager.AnonymousClass2.invokeSuspend$lambda$0((Map.Entry) obj2));
                    }
                })) == null || (hVarQ = ke.u.Q(hVarE, new Function1() { // from class: cu.todus.android.xmpp.managers.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GroupsManager.AnonymousClass2.invokeSuspend$lambda$1((Map.Entry) obj2);
                    }
                })) == null) {
                    return null;
                }
                return ke.u.a0(hVarQ);
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            getGroupListPaginatedIQ = (GetGroupListPaginatedIQ) ((IQ) obj);
            if (getGroupListPaginatedIQ != null) {
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<Pair<String, String>>>) obj3);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$reloadGroupList$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager$reloadGroupList$3", f = "GroupsManager.kt", l = {249}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lkotlin/Pair;", "", "it", "Lua/k0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass3 anonymousClass3 = GroupsManager.this.new AnonymousClass3(eVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                GroupsManager groupsManager = GroupsManager.this;
                this.L$0 = cb.l.a(list);
                this.label = 1;
                if (groupsManager.updateMucList(list, this) == objG) {
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
        public final Object invoke(List<Pair<String, String>> list, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(list, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$updateMucList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager", f = "GroupsManager.kt", l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 85}, m = "updateMucList", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14511 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14511(ab.e<? super C14511> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GroupsManager.this.updateMucList(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.GroupsManager$updateMucMember$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.GroupsManager$updateMucMember$1", f = "GroupsManager.kt", l = {WebmConstants.MkvEbmlElement.FLAG_LACING, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, WebmConstants.MkvEbmlElement.BLOCK_MORE, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, WebmConstants.MkvEbmlElement.CUE_POINT, 196, 198}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C14521 extends cb.m implements Function2 {
        final /* synthetic */ String $groupId;
        final /* synthetic */ Map<String, String> $members;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ GroupsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14521(Map<String, String> map, GroupsManager groupsManager, String str, ab.e<? super C14521> eVar) {
            super(2, eVar);
            this.$members = map;
            this.this$0 = groupsManager;
            this.$groupId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C14521(this.$members, this.this$0, this.$groupId, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:34:0x0232  */
        /* JADX WARN: Code duplicated, block: B:37:0x0241  */
        /* JADX WARN: Code duplicated, block: B:38:0x0244  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v42, types: [cu.todus.android.db.dao.toDus.UserRoomJoinDao] */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v38 */
        /* JADX WARN: Type inference failed for: r3v39 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x02f4 -> B:49:0x02f7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0303 -> B:51:0x030b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 1118
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.GroupsManager.C14521.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C14521) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public GroupsManager(lb.a owner, lb.a canSend, lb.a mXMPPConnection, Function2 getUsersInfo) {
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(getUsersInfo, "getUsersInfo");
        this.owner = owner;
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.getUsersInfo = getUsersInfo;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
        this.loadingMembersFrom = new ArrayList<>();
        this.roomStanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.managers.m
            @Override // org.jivesoftware.smack.StanzaListener
            public final void processStanza(Stanza stanza) {
                GroupsManager.roomStanzaListener$lambda$0(this.f28865c, stanza);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object changeGroupConfigs$default(GroupsManager groupsManager, String str, String str2, String str3, HashMap map, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            map = null;
        }
        return groupsManager.changeGroupConfigs(str, str2, str3, map, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jid createGroup$lambda$0(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return JidCreate.from(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processPrivilegesChangePayload(PrivilegesChangeInGroup privilegesChangeInGroup, String str, ab.e<? super k0> eVar) {
        String str2;
        UserRoomJoinDao userRoomJoinDao = this.databaseModule.getUserRoomJoinDao();
        String userId = privilegesChangeInGroup.getUserId();
        int i10 = WhenMappings.$EnumSwitchMapping$0[privilegesChangeInGroup.getPrivileges().ordinal()];
        if (i10 == 1) {
            str2 = UserRoomJoin.AFFILIATION_MEMBER;
        } else if (i10 == 2) {
            str2 = UserRoomJoin.AFFILIATION_OWNER;
        } else if (i10 == 3) {
            str2 = "admin";
        } else {
            if (i10 != 4) {
                throw new ua.r();
            }
            str2 = "none";
        }
        Object objUpdate = userRoomJoinDao.update(new UserRoomJoin(userId, str, str2), eVar);
        return objUpdate == bb.b.g() ? objUpdate : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void roomStanzaListener$lambda$0(GroupsManager groupsManager, Stanza stanza) {
        if (stanza instanceof GroupMembersIQ) {
            GroupMembersIQ groupMembersIQ = (GroupMembersIQ) stanza;
            String strAsEntityBareJidString = groupMembersIQ.getFrom().asEntityBareJidIfPossible().asEntityBareJidString();
            kotlin.jvm.internal.y.h(strAsEntityBareJidString, "asEntityBareJidString(...)");
            groupsManager.updateMucMember(strAsEntityBareJidString, w0.w(ke.u.Q(y0.B(groupMembersIQ.getMembers()), new Function1() { // from class: cu.todus.android.xmpp.managers.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GroupsManager.roomStanzaListener$lambda$0$0((Map.Entry) obj);
                }
            })));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair roomStanzaListener$lambda$0$0(Map.Entry it) {
        kotlin.jvm.internal.y.i(it, "it");
        return ua.z.a(it.getKey().toString(), it.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x008a  */
    /* JADX WARN: Code duplicated, block: B:22:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:25:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c3 -> B:23:0x00cb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object updateMucList(java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r18, ab.e<? super ua.k0> r19) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.GroupsManager.updateMucList(java.util.List, ab.e):java.lang.Object");
    }

    private final void updateMucMember(String groupId, Map<String, String> members) {
        pe.k.d(this.coroutineScope, null, null, new C14521(members, this, groupId, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object addNewMembers(String str, List<String> list, ab.e<? super AddMembersToGroupResponse> eVar) {
        AnonymousClass1 anonymousClass1;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objX = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                AddGroupMembersIQ addGroupMembersIQ = new AddGroupMembersIQ(str, list, null, 4, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, addGroupMembersIQ);
                anonymousClass1.L$0 = cb.l.a(str);
                anonymousClass1.L$1 = cb.l.a(list);
                anonymousClass1.L$2 = cb.l.a(xMPPTCPConnection);
                anonymousClass1.L$3 = cb.l.a(addGroupMembersIQ);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                objX = te.j.x(hVarSendIQFlow, anonymousClass1);
                if (objX == objG) {
                    return objG;
                }
            }
            return new AddMembersToGroupResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        AddGroupMembersIQ addGroupMembersIQ2 = (AddGroupMembersIQ) ((IQ) objX);
        if (addGroupMembersIQ2 != null) {
            String code = addGroupMembersIQ2.getCode();
            int iHashCode = code.hashCode();
            if (iHashCode != -792934015) {
                if (iHashCode != 96673) {
                    if (iHashCode == 3387192 && code.equals("none")) {
                        return new AddMembersToGroupResponse(1);
                    }
                } else if (code.equals("all")) {
                    return new AddMembersToGroupResponse(2);
                }
            } else if (code.equals("partial")) {
                return new AddMembersToGroupResponse(3);
            }
            return new AddMembersToGroupResponse(4);
        }
        return new AddMembersToGroupResponse(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object askForReloadMucMemberList(String str, ab.e<? super k0> eVar) {
        C14381 c14381;
        if (eVar instanceof C14381) {
            c14381 = (C14381) eVar;
            int i10 = c14381.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14381.label = i10 - Integer.MIN_VALUE;
            } else {
                c14381 = new C14381(eVar);
            }
        } else {
            c14381 = new C14381(eVar);
        }
        Object objX = c14381.result;
        Object objG = bb.b.g();
        int i11 = c14381.label;
        if (i11 == 0) {
            ua.v.b(objX);
            this.loadingMembersFrom.add(str);
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection == null) {
                return k0.f43947a;
            }
            GroupMembersIQ groupMembersIQ = new GroupMembersIQ(str, null, 2, 0 == true ? 1 : 0);
            te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, groupMembersIQ);
            c14381.L$0 = cb.l.a(str);
            c14381.L$1 = cb.l.a(xMPPTCPConnection);
            c14381.L$2 = cb.l.a(groupMembersIQ);
            c14381.I$0 = 0;
            c14381.label = 1;
            objX = te.j.x(hVarSendIQFlow, c14381);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object changeGroupConfigs(String str, String str2, String str3, HashMap<String, String> map, ab.e<? super Boolean> eVar) {
        C14391 c14391;
        boolean z10;
        IQ iq;
        if (eVar instanceof C14391) {
            c14391 = (C14391) eVar;
            int i10 = c14391.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14391.label = i10 - Integer.MIN_VALUE;
            } else {
                c14391 = new C14391(eVar);
            }
        } else {
            c14391 = new C14391(eVar);
        }
        Object objX = c14391.result;
        Object objG = bb.b.g();
        int i11 = c14391.label;
        if (i11 == 0) {
            ua.v.b(objX);
            z10 = false;
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    ChangeGroupConfigsIQ changeGroupConfigsIQ = new ChangeGroupConfigsIQ(str, str2, str3, map);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, changeGroupConfigsIQ);
                    c14391.L$0 = cb.l.a(str);
                    c14391.L$1 = cb.l.a(str2);
                    c14391.L$2 = cb.l.a(str3);
                    c14391.L$3 = cb.l.a(map);
                    c14391.L$4 = cb.l.a(xMPPTCPConnection);
                    c14391.L$5 = cb.l.a(changeGroupConfigsIQ);
                    c14391.I$0 = 0;
                    c14391.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14391);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                z10 = iq instanceof EmptyResultIQ;
            }
            return cb.b.a(z10);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        z10 = iq instanceof EmptyResultIQ;
        return cb.b.a(z10);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x018e  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01d7, code lost:
    
        if (r2.upsert(r11, r0) == r8) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createGroup(java.lang.String r32, java.lang.String r33, java.util.List<java.lang.String> r34, ab.e<? super java.lang.Boolean> r35) {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.GroupsManager.createGroup(java.lang.String, java.lang.String, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createGroupLinkId(String str, ab.e<? super String> eVar) {
        C14411 c14411;
        IQ iq;
        if (eVar instanceof C14411) {
            c14411 = (C14411) eVar;
            int i10 = c14411.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14411.label = i10 - Integer.MIN_VALUE;
            } else {
                c14411 = new C14411(eVar);
            }
        } else {
            c14411 = new C14411(eVar);
        }
        Object objX = c14411.result;
        Object objG = bb.b.g();
        int i11 = c14411.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    GroupSetLinkIQ groupSetLinkIQ = new GroupSetLinkIQ(str);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, groupSetLinkIQ);
                    c14411.L$0 = cb.l.a(str);
                    c14411.L$1 = cb.l.a(xMPPTCPConnection);
                    c14411.L$2 = cb.l.a(groupSetLinkIQ);
                    c14411.I$0 = 0;
                    c14411.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14411);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                if (iq instanceof GroupGetLinkIQ) {
                    return ((GroupGetLinkIQ) iq).getLink();
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        if (iq instanceof GroupGetLinkIQ) {
            return ((GroupGetLinkIQ) iq).getLink();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object demoteFromAdmin(String str, String str2, ab.e<? super AdminGroupActionsResponse> eVar) {
        C14421 c14421;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14421) {
            c14421 = (C14421) eVar;
            int i10 = c14421.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14421.label = i10 - Integer.MIN_VALUE;
            } else {
                c14421 = new C14421(eVar);
            }
        } else {
            c14421 = new C14421(eVar);
        }
        Object objX = c14421.result;
        Object objG = bb.b.g();
        int i11 = c14421.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                DemoteGroupAdminIQ demoteGroupAdminIQ = new DemoteGroupAdminIQ(str, str2, null, 4, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, demoteGroupAdminIQ);
                c14421.L$0 = cb.l.a(str);
                c14421.L$1 = cb.l.a(str2);
                c14421.L$2 = cb.l.a(xMPPTCPConnection);
                c14421.L$3 = cb.l.a(demoteGroupAdminIQ);
                c14421.I$0 = 0;
                c14421.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14421);
                if (objX == objG) {
                    return objG;
                }
            }
            return new AdminGroupActionsResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        DemoteGroupAdminIQ demoteGroupAdminIQ2 = (DemoteGroupAdminIQ) ((IQ) objX);
        if (demoteGroupAdminIQ2 != null) {
            return kotlin.jvm.internal.y.d(demoteGroupAdminIQ2.getCode(), "") ? new AdminGroupActionsResponse(2) : new AdminGroupActionsResponse(1);
        }
        return new AdminGroupActionsResponse(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object expelMember(String str, String str2, ab.e<? super Boolean> eVar) {
        C14431 c14431;
        boolean z10;
        IQ iq;
        if (eVar instanceof C14431) {
            c14431 = (C14431) eVar;
            int i10 = c14431.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14431.label = i10 - Integer.MIN_VALUE;
            } else {
                c14431 = new C14431(eVar);
            }
        } else {
            c14431 = new C14431(eVar);
        }
        Object objX = c14431.result;
        Object objG = bb.b.g();
        int i11 = c14431.label;
        if (i11 == 0) {
            ua.v.b(objX);
            z10 = false;
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    ExpelMemberFromGroupIQ expelMemberFromGroupIQ = new ExpelMemberFromGroupIQ(str, w0.k(ua.z.a(JidCreate.from(str2), GroupAffiliation.none)));
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, expelMemberFromGroupIQ);
                    c14431.L$0 = cb.l.a(str);
                    c14431.L$1 = cb.l.a(str2);
                    c14431.L$2 = cb.l.a(xMPPTCPConnection);
                    c14431.L$3 = cb.l.a(expelMemberFromGroupIQ);
                    c14431.I$0 = 0;
                    c14431.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14431);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                z10 = iq instanceof EmptyResultIQ;
            }
            return cb.b.a(z10);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        z10 = iq instanceof EmptyResultIQ;
        return cb.b.a(z10);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final Function2 getGetUsersInfo() {
        return this.getUsersInfo;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getGroupInfoById(String str, ab.e<? super MucInfo> eVar) {
        C14441 c14441;
        if (eVar instanceof C14441) {
            c14441 = (C14441) eVar;
            int i10 = c14441.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14441.label = i10 - Integer.MIN_VALUE;
            } else {
                c14441 = new C14441(eVar);
            }
        } else {
            c14441 = new C14441(eVar);
        }
        Object objX = c14441.result;
        Object objG = bb.b.g();
        int i11 = c14441.label;
        MucInfo mucInfo = null;
        Object[] objArr = 0;
        if (i11 == 0) {
            ua.v.b(objX);
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                GroupInfoByIdIQ groupInfoByIdIQ = new GroupInfoByIdIQ(str, mucInfo, 2, objArr == true ? 1 : 0);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, groupInfoByIdIQ);
                c14441.L$0 = cb.l.a(str);
                c14441.L$1 = cb.l.a(xMPPTCPConnection);
                c14441.L$2 = cb.l.a(groupInfoByIdIQ);
                c14441.I$0 = 0;
                c14441.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14441);
                if (objX == objG) {
                    return objG;
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        GroupInfoByIdIQ groupInfoByIdIQ2 = (GroupInfoByIdIQ) ((IQ) objX);
        if (groupInfoByIdIQ2 != null) {
            return groupInfoByIdIQ2.getMucInfo();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getGroupInfoByLinkId(String str, ab.e<? super MucInfo> eVar) {
        C14451 c14451;
        if (eVar instanceof C14451) {
            c14451 = (C14451) eVar;
            int i10 = c14451.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14451.label = i10 - Integer.MIN_VALUE;
            } else {
                c14451 = new C14451(eVar);
            }
        } else {
            c14451 = new C14451(eVar);
        }
        Object objX = c14451.result;
        Object objG = bb.b.g();
        int i11 = c14451.label;
        MucInfo mucInfo = null;
        Object[] objArr = 0;
        if (i11 == 0) {
            ua.v.b(objX);
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                GroupInfoIQByLink groupInfoIQByLink = new GroupInfoIQByLink(str, mucInfo, 2, objArr == true ? 1 : 0);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, groupInfoIQByLink);
                c14451.L$0 = cb.l.a(str);
                c14451.L$1 = cb.l.a(xMPPTCPConnection);
                c14451.L$2 = cb.l.a(groupInfoIQByLink);
                c14451.I$0 = 0;
                c14451.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14451);
                if (objX == objG) {
                    return objG;
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        GroupInfoIQByLink groupInfoIQByLink2 = (GroupInfoIQByLink) ((IQ) objX);
        if (groupInfoIQByLink2 != null) {
            return groupInfoIQByLink2.getMucInfo();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getGroupLinkId(String str, ab.e<? super String> eVar) {
        C14461 c14461;
        GroupGetLinkIQ groupGetLinkIQ;
        if (eVar instanceof C14461) {
            c14461 = (C14461) eVar;
            int i10 = c14461.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14461.label = i10 - Integer.MIN_VALUE;
            } else {
                c14461 = new C14461(eVar);
            }
        } else {
            c14461 = new C14461(eVar);
        }
        Object objX = c14461.result;
        Object objG = bb.b.g();
        int i11 = c14461.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    GroupGetLinkIQ groupGetLinkIQ2 = new GroupGetLinkIQ(str, null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, groupGetLinkIQ2);
                    c14461.L$0 = cb.l.a(str);
                    c14461.L$1 = cb.l.a(xMPPTCPConnection);
                    c14461.L$2 = cb.l.a(groupGetLinkIQ2);
                    c14461.I$0 = 0;
                    c14461.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14461);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    groupGetLinkIQ = null;
                }
                if (groupGetLinkIQ != null) {
                    return groupGetLinkIQ.getLink();
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        groupGetLinkIQ = (GroupGetLinkIQ) ((IQ) objX);
        if (groupGetLinkIQ != null) {
            return groupGetLinkIQ.getLink();
        }
        return null;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object joinToGroup(String str, ab.e<? super JoinResult> eVar) {
        C14471 c14471;
        IQ iq;
        if (eVar instanceof C14471) {
            c14471 = (C14471) eVar;
            int i10 = c14471.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14471.label = i10 - Integer.MIN_VALUE;
            } else {
                c14471 = new C14471(eVar);
            }
        } else {
            c14471 = new C14471(eVar);
        }
        Object objX = c14471.result;
        Object objG = bb.b.g();
        int i11 = c14471.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    JoinGroupIQ joinGroupIQ = new JoinGroupIQ(str);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, joinGroupIQ);
                    c14471.L$0 = cb.l.a(str);
                    c14471.L$1 = cb.l.a(xMPPTCPConnection);
                    c14471.L$2 = cb.l.a(joinGroupIQ);
                    c14471.I$0 = 0;
                    c14471.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14471);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                if (iq == null) {
                    return null;
                }
                if (iq instanceof ErrorIQ) {
                    return JoinResult.FAIL;
                }
                if (iq instanceof EmptyResultIQ) {
                    return JoinResult.JOINED;
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        if (iq == null) {
            return null;
        }
        if (iq instanceof ErrorIQ) {
            return JoinResult.FAIL;
        }
        if (iq instanceof EmptyResultIQ) {
            return JoinResult.JOINED;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object leaveGroup(String str, ab.e<? super Boolean> eVar) {
        C14481 c14481;
        boolean z10;
        IQ iq;
        if (eVar instanceof C14481) {
            c14481 = (C14481) eVar;
            int i10 = c14481.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14481.label = i10 - Integer.MIN_VALUE;
            } else {
                c14481 = new C14481(eVar);
            }
        } else {
            c14481 = new C14481(eVar);
        }
        Object objX = c14481.result;
        Object objG = bb.b.g();
        int i11 = c14481.label;
        if (i11 == 0) {
            ua.v.b(objX);
            z10 = false;
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    LeaveGroupIQ leaveGroupIQ = new LeaveGroupIQ(str);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, leaveGroupIQ);
                    c14481.L$0 = cb.l.a(str);
                    c14481.L$1 = cb.l.a(xMPPTCPConnection);
                    c14481.L$2 = cb.l.a(leaveGroupIQ);
                    c14481.I$0 = 0;
                    c14481.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14481);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                z10 = iq instanceof EmptyResultIQ;
            }
            return cb.b.a(z10);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        z10 = iq instanceof EmptyResultIQ;
        return cb.b.a(z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object promoteToAdmin(String str, String str2, ab.e<? super AdminGroupActionsResponse> eVar) {
        C14491 c14491;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14491) {
            c14491 = (C14491) eVar;
            int i10 = c14491.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14491.label = i10 - Integer.MIN_VALUE;
            } else {
                c14491 = new C14491(eVar);
            }
        } else {
            c14491 = new C14491(eVar);
        }
        Object objX = c14491.result;
        Object objG = bb.b.g();
        int i11 = c14491.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                PromoteGroupAdminIQ promoteGroupAdminIQ = new PromoteGroupAdminIQ(str, str2, null, 4, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, promoteGroupAdminIQ);
                c14491.L$0 = cb.l.a(str);
                c14491.L$1 = cb.l.a(str2);
                c14491.L$2 = cb.l.a(xMPPTCPConnection);
                c14491.L$3 = cb.l.a(promoteGroupAdminIQ);
                c14491.I$0 = 0;
                c14491.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14491);
                if (objX == objG) {
                    return objG;
                }
            }
            return new AdminGroupActionsResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        PromoteGroupAdminIQ promoteGroupAdminIQ2 = (PromoteGroupAdminIQ) ((IQ) objX);
        if (promoteGroupAdminIQ2 != null) {
            return kotlin.jvm.internal.y.d(promoteGroupAdminIQ2.getCode(), "") ? new AdminGroupActionsResponse(2) : new AdminGroupActionsResponse(1);
        }
        return new AdminGroupActionsResponse(0);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:52:0x010b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x0145  */
    /* JADX WARN: Code duplicated, block: B:63:0x0149  */
    /* JADX WARN: Code duplicated, block: B:65:0x0150  */
    /* JADX WARN: Code duplicated, block: B:68:0x0156  */
    /* JADX WARN: Code duplicated, block: B:69:0x015d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0161  */
    /* JADX WARN: Code duplicated, block: B:72:0x0168  */
    /* JADX WARN: Code duplicated, block: B:74:0x016c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0173  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0205  */
    /* JADX WARN: Code duplicated, block: B:93:0x021e  */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0248, code lost:
    
        if (askForReloadMucMemberList(r12, r3) == r4) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reloadGroup(java.lang.String r29, ab.e<? super ua.k0> r30) throws cu.z17.singledi.SinglediException {
        /*
            Method dump skipped, instruction units count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.GroupsManager.reloadGroup(java.lang.String, ab.e):java.lang.Object");
    }

    public final Object reloadGroupList(ab.e<? super k0> eVar) {
        Object objRecursivePagingRequest$default = XMPPInlinesKt.recursivePagingRequest$default(new AnonymousClass2(null), 0, 10, 0L, new AnonymousClass3(null), new lb.a() { // from class: cu.todus.android.xmpp.managers.o
            @Override // lb.a
            public final Object invoke() {
                return k0.f43947a;
            }
        }, null, eVar, 72, null);
        return objRecursivePagingRequest$default == bb.b.g() ? objRecursivePagingRequest$default : k0.f43947a;
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        StanzaFilter stanzaFilter = IQTypeFilter.RESULT;
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.addAsyncStanzaListener(this.roomStanzaListener, stanzaFilter);
        }
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.removeAsyncStanzaListener(this.roomStanzaListener);
        }
    }
}
