package cu.todus.android.uiCompose.main.screen.chat.component;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.uiCompose.main.screen.chat.preview.PinnedMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J»\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0014\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010C\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010D\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006E"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "", "id", "", "name", "image", "type", "", TemplateContent.NUMBER_TYPE, "description", "rights", "", "errorOnLoadCardInfo", "", "subscribed", "version", "isSecret", User.COLUMN_TODUS_ID, "backgroundPath", "unknownUserState", UserRoomJoin.COLUMN_AFFILIATION, "pinnedMessage", "Lcu/todus/android/uiCompose/main/screen/chat/preview/PinnedMsg;", Room.CONFIG_DRAFT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/uiCompose/main/screen/chat/preview/PinnedMsg;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getImage", "getType", "()I", "getNumber", "getDescription", "getRights", "()Ljava/util/List;", "getErrorOnLoadCardInfo", "()Z", "getSubscribed", "getVersion", "getToDusId", "getBackgroundPath", "getUnknownUserState", "getAffiliation", "getPinnedMessage", "()Lcu/todus/android/uiCompose/main/screen/chat/preview/PinnedMsg;", "getDraft", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChatScreenState {
    public static final int $stable = 0;
    private final String affiliation;
    private final String backgroundPath;
    private final String description;
    private final String draft;
    private final boolean errorOnLoadCardInfo;
    private final String id;
    private final String image;
    private final boolean isSecret;
    private final String name;
    private final String number;
    private final PinnedMsg pinnedMessage;
    private final List<String> rights;
    private final boolean subscribed;
    private final String toDusId;
    private final int type;
    private final String unknownUserState;
    private final String version;

    public ChatScreenState(String id2, String name, String image, int i10, String number, String description, List<String> rights, boolean z10, boolean z11, String version, boolean z12, String toDusId, String backgroundPath, String unknownUserState, String affiliation, PinnedMsg pinnedMsg, String draft) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        y.i(number, "number");
        y.i(description, "description");
        y.i(rights, "rights");
        y.i(version, "version");
        y.i(toDusId, "toDusId");
        y.i(backgroundPath, "backgroundPath");
        y.i(unknownUserState, "unknownUserState");
        y.i(affiliation, "affiliation");
        y.i(draft, "draft");
        this.id = id2;
        this.name = name;
        this.image = image;
        this.type = i10;
        this.number = number;
        this.description = description;
        this.rights = rights;
        this.errorOnLoadCardInfo = z10;
        this.subscribed = z11;
        this.version = version;
        this.isSecret = z12;
        this.toDusId = toDusId;
        this.backgroundPath = backgroundPath;
        this.unknownUserState = unknownUserState;
        this.affiliation = affiliation;
        this.pinnedMessage = pinnedMsg;
        this.draft = draft;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatScreenState copy$default(ChatScreenState chatScreenState, String str, String str2, String str3, int i10, String str4, String str5, List list, boolean z10, boolean z11, String str6, boolean z12, String str7, String str8, String str9, String str10, PinnedMsg pinnedMsg, String str11, int i11, Object obj) {
        String str12;
        PinnedMsg pinnedMsg2;
        String str13 = (i11 & 1) != 0 ? chatScreenState.id : str;
        String str14 = (i11 & 2) != 0 ? chatScreenState.name : str2;
        String str15 = (i11 & 4) != 0 ? chatScreenState.image : str3;
        int i12 = (i11 & 8) != 0 ? chatScreenState.type : i10;
        String str16 = (i11 & 16) != 0 ? chatScreenState.number : str4;
        String str17 = (i11 & 32) != 0 ? chatScreenState.description : str5;
        List list2 = (i11 & 64) != 0 ? chatScreenState.rights : list;
        boolean z13 = (i11 & 128) != 0 ? chatScreenState.errorOnLoadCardInfo : z10;
        boolean z14 = (i11 & 256) != 0 ? chatScreenState.subscribed : z11;
        String str18 = (i11 & 512) != 0 ? chatScreenState.version : str6;
        boolean z15 = (i11 & 1024) != 0 ? chatScreenState.isSecret : z12;
        String str19 = (i11 & 2048) != 0 ? chatScreenState.toDusId : str7;
        String str20 = (i11 & 4096) != 0 ? chatScreenState.backgroundPath : str8;
        String str21 = (i11 & 8192) != 0 ? chatScreenState.unknownUserState : str9;
        String str22 = str13;
        String str23 = (i11 & 16384) != 0 ? chatScreenState.affiliation : str10;
        PinnedMsg pinnedMsg3 = (i11 & 32768) != 0 ? chatScreenState.pinnedMessage : pinnedMsg;
        if ((i11 & 65536) != 0) {
            pinnedMsg2 = pinnedMsg3;
            str12 = chatScreenState.draft;
        } else {
            str12 = str11;
            pinnedMsg2 = pinnedMsg3;
        }
        return chatScreenState.copy(str22, str14, str15, i12, str16, str17, list2, z13, z14, str18, z15, str19, str20, str21, str23, pinnedMsg2, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsSecret() {
        return this.isSecret;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getBackgroundPath() {
        return this.backgroundPath;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUnknownUserState() {
        return this.unknownUserState;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAffiliation() {
        return this.affiliation;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final PinnedMsg getPinnedMessage() {
        return this.pinnedMessage;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getDraft() {
        return this.draft;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component7() {
        return this.rights;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getErrorOnLoadCardInfo() {
        return this.errorOnLoadCardInfo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public final ChatScreenState copy(String id2, String name, String image, int type, String number, String description, List<String> rights, boolean errorOnLoadCardInfo, boolean subscribed, String version, boolean isSecret, String toDusId, String backgroundPath, String unknownUserState, String affiliation, PinnedMsg pinnedMessage, String draft) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        y.i(number, "number");
        y.i(description, "description");
        y.i(rights, "rights");
        y.i(version, "version");
        y.i(toDusId, "toDusId");
        y.i(backgroundPath, "backgroundPath");
        y.i(unknownUserState, "unknownUserState");
        y.i(affiliation, "affiliation");
        y.i(draft, "draft");
        return new ChatScreenState(id2, name, image, type, number, description, rights, errorOnLoadCardInfo, subscribed, version, isSecret, toDusId, backgroundPath, unknownUserState, affiliation, pinnedMessage, draft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatScreenState)) {
            return false;
        }
        ChatScreenState chatScreenState = (ChatScreenState) other;
        return y.d(this.id, chatScreenState.id) && y.d(this.name, chatScreenState.name) && y.d(this.image, chatScreenState.image) && this.type == chatScreenState.type && y.d(this.number, chatScreenState.number) && y.d(this.description, chatScreenState.description) && y.d(this.rights, chatScreenState.rights) && this.errorOnLoadCardInfo == chatScreenState.errorOnLoadCardInfo && this.subscribed == chatScreenState.subscribed && y.d(this.version, chatScreenState.version) && this.isSecret == chatScreenState.isSecret && y.d(this.toDusId, chatScreenState.toDusId) && y.d(this.backgroundPath, chatScreenState.backgroundPath) && y.d(this.unknownUserState, chatScreenState.unknownUserState) && y.d(this.affiliation, chatScreenState.affiliation) && y.d(this.pinnedMessage, chatScreenState.pinnedMessage) && y.d(this.draft, chatScreenState.draft);
    }

    public final String getAffiliation() {
        return this.affiliation;
    }

    public final String getBackgroundPath() {
        return this.backgroundPath;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDraft() {
        return this.draft;
    }

    public final boolean getErrorOnLoadCardInfo() {
        return this.errorOnLoadCardInfo;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNumber() {
        return this.number;
    }

    public final PinnedMsg getPinnedMessage() {
        return this.pinnedMessage;
    }

    public final List<String> getRights() {
        return this.rights;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnknownUserState() {
        return this.unknownUserState;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.type) * 31) + this.number.hashCode()) * 31) + this.description.hashCode()) * 31) + this.rights.hashCode()) * 31) + r.a(this.errorOnLoadCardInfo)) * 31) + r.a(this.subscribed)) * 31) + this.version.hashCode()) * 31) + r.a(this.isSecret)) * 31) + this.toDusId.hashCode()) * 31) + this.backgroundPath.hashCode()) * 31) + this.unknownUserState.hashCode()) * 31) + this.affiliation.hashCode()) * 31;
        PinnedMsg pinnedMsg = this.pinnedMessage;
        return ((iHashCode + (pinnedMsg == null ? 0 : pinnedMsg.hashCode())) * 31) + this.draft.hashCode();
    }

    public final boolean isSecret() {
        return this.isSecret;
    }

    public String toString() {
        return "ChatScreenState(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", type=" + this.type + ", number=" + this.number + ", description=" + this.description + ", rights=" + this.rights + ", errorOnLoadCardInfo=" + this.errorOnLoadCardInfo + ", subscribed=" + this.subscribed + ", version=" + this.version + ", isSecret=" + this.isSecret + ", toDusId=" + this.toDusId + ", backgroundPath=" + this.backgroundPath + ", unknownUserState=" + this.unknownUserState + ", affiliation=" + this.affiliation + ", pinnedMessage=" + this.pinnedMessage + ", draft=" + this.draft + ")";
    }

    public /* synthetic */ ChatScreenState(String str, String str2, String str3, int i10, String str4, String str5, List list, boolean z10, boolean z11, String str6, boolean z12, String str7, String str8, String str9, String str10, PinnedMsg pinnedMsg, String str11, int i11, p pVar) {
        this(str, str2, str3, i10, str4, str5, (i11 & 64) != 0 ? w.n() : list, (i11 & 128) != 0 ? false : z10, (i11 & 256) != 0 ? false : z11, (i11 & 512) != 0 ? "" : str6, (i11 & 1024) != 0 ? false : z12, (i11 & 2048) != 0 ? "" : str7, (i11 & 4096) != 0 ? "" : str8, (i11 & 8192) != 0 ? "new" : str9, (i11 & 16384) != 0 ? "" : str10, (32768 & i11) != 0 ? null : pinnedMsg, (i11 & 65536) != 0 ? "" : str11);
    }
}
