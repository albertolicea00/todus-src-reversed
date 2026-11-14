package cu.todus.android.volatileState;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.connection.Quality;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.preferences.CallQuality;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.iq.privacy.PrivacyGetIQ;
import cu.z17.singledi.SingletonInitializer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import lb.a;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.b0;
import te.j;
import te.p0;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 n2\u00020\u0001:\u0001nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ!\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\r¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0003R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00103\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010+\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R\u001d\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R&\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0@058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00108R)\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0@0B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR&\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120@058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u00108R)\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120H0B8\u0006¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010FR#\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0@8\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010+\u001a\u0004\bV\u0010-\"\u0004\bW\u0010/R\"\u0010X\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010\bR\"\u0010]\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e058\u0006¢\u0006\f\n\u0004\bc\u00108\u001a\u0004\bc\u0010:R\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020d058\u0006¢\u0006\f\n\u0004\be\u00108\u001a\u0004\bf\u0010:R\u001d\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000e058\u0006¢\u0006\f\n\u0004\bg\u00108\u001a\u0004\bg\u0010:R\"\u0010h\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lcu/todus/android/volatileState/AppVolatileState;", "", "<init>", "()V", "", "key", "Lua/k0;", "autoClearTyping", "(Ljava/lang/String;)V", Room.COLUMN_LAST_MSG, "showReply", "clearShowingReply", "clearTyping", "Lkotlin/Pair;", "", "typing", "updateUserTyping", "(Lkotlin/Pair;)V", "", PrivacyGetIQ.PRIVACY_PROFILE_LAST, "updateUserLast", "clearLast", "uid", "onNewMessage", "fullClear", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lcu/todus/android/data/preferences/RootEnvironment;", "rootEnvironment", "Lcu/todus/android/data/preferences/RootEnvironment;", "getRootEnvironment", "()Lcu/todus/android/data/preferences/RootEnvironment;", "setRootEnvironment", "(Lcu/todus/android/data/preferences/RootEnvironment;)V", "Lcu/todus/android/connection/Quality;", "ownerConnection", "Lcu/todus/android/connection/Quality;", "getOwnerConnection", "()Lcu/todus/android/connection/Quality;", "setOwnerConnection", "(Lcu/todus/android/connection/Quality;)V", "aliasSelected", "Z", "getAliasSelected", "()Z", "setAliasSelected", "(Z)V", "batterySettingsShowed", "getBatterySettingsShowed", "setBatterySettingsShowed", "isCertificateValid", "setCertificateValid", "Lte/b0;", "", "themeSelected", "Lte/b0;", "getThemeSelected", "()Lte/b0;", "Landroidx/compose/runtime/MutableState;", "showingReplyTo", "Landroidx/compose/runtime/MutableState;", "getShowingReplyTo", "()Landroidx/compose/runtime/MutableState;", "", "_usersTyping", "Lte/p0;", "usersTyping", "Lte/p0;", "getUsersTyping", "()Lte/p0;", "_usersLast", "", "usersLast", "getUsersLast", "blockRooms", "Ljava/util/Map;", "getBlockRooms", "()Ljava/util/Map;", "Lcu/todus/android/volatileState/MsgListenerFor;", "onNewMessageListener", "Lcu/todus/android/volatileState/MsgListenerFor;", "getOnNewMessageListener", "()Lcu/todus/android/volatileState/MsgListenerFor;", "setOnNewMessageListener", "(Lcu/todus/android/volatileState/MsgListenerFor;)V", "isServiceRunning", "setServiceRunning", "aliveConfiguration", "Ljava/lang/String;", "getAliveConfiguration", "()Ljava/lang/String;", "setAliveConfiguration", "uploadQuality", "I", "getUploadQuality", "()I", "setUploadQuality", "(I)V", "isRequestModeActivated", "Lcu/todus/android/data/preferences/CallQuality;", "callQuality", "getCallQuality", "isCallServiceRunning", "callStartTime", "J", "getCallStartTime", "()J", "setCallStartTime", "(J)V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppVolatileState {
    private final b0 _usersLast;
    private final b0 _usersTyping;
    private boolean aliasSelected;
    private String aliveConfiguration;
    private boolean batterySettingsShowed;
    private final Map<String, Boolean> blockRooms;
    private final b0 callQuality;
    private long callStartTime;
    private final b0 isCallServiceRunning;
    private final b0 isRequestModeActivated;
    private boolean isServiceRunning;
    private MsgListenerFor onNewMessageListener;
    private int uploadQuality;
    private final p0 usersLast;
    private final p0 usersTyping;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final m0 coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
    private RootEnvironment rootEnvironment = new RootEnvironment(Service.ApplicationEnvironment.PROD_2, "");
    private Quality ownerConnection = Quality.INDETERMINATE;
    private boolean isCertificateValid = true;
    private final b0 themeSelected = r0.a(0);
    private final MutableState<String> showingReplyTo = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/volatileState/AppVolatileState$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/volatileState/AppVolatileState;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<AppVolatileState> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public AppVolatileState() {
        b0 b0VarA = r0.a(new LinkedHashMap());
        this._usersTyping = b0VarA;
        this.usersTyping = b0VarA;
        b0 b0VarA2 = r0.a(new LinkedHashMap());
        this._usersLast = b0VarA2;
        this.usersLast = j.b(b0VarA2);
        this.blockRooms = new HashMap();
        this.onNewMessageListener = new MsgListenerFor() { // from class: cu.todus.android.volatileState.AppVolatileState$onNewMessageListener$1
            @Override // cu.todus.android.volatileState.MsgListenerFor
            public void received(String uid) {
                y.i(uid, "uid");
            }
        };
        this.aliveConfiguration = "";
        this.uploadQuality = 3;
        Boolean bool = Boolean.FALSE;
        this.isRequestModeActivated = r0.a(bool);
        this.callQuality = r0.a(new CallQuality(0, 0, 3, null));
        this.isCallServiceRunning = r0.a(bool);
    }

    private final void autoClearTyping(final String key) {
        CoroutineUtilsKt.launchUntil$default(this.coroutineScope, null, 4000L, new a() { // from class: a9.a
            @Override // lb.a
            public final Object invoke() {
                return AppVolatileState.autoClearTyping$lambda$0(this.f588c, key);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 autoClearTyping$lambda$0(AppVolatileState appVolatileState, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) appVolatileState.usersTyping.getValue()).entrySet()) {
            String str2 = (String) entry.getKey();
            Boolean bool = (Boolean) entry.getValue();
            bool.booleanValue();
            linkedHashMap.put(str2, bool);
        }
        linkedHashMap.remove(str);
        appVolatileState._usersTyping.setValue(linkedHashMap);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 clearShowingReply$lambda$0(AppVolatileState appVolatileState) {
        appVolatileState.showingReplyTo.setValue("");
        return k0.f43947a;
    }

    public final void clearLast() {
        b0 b0Var = this._usersLast;
        Object value = b0Var.getValue();
        ((Map) value).clear();
        b0Var.setValue(value);
    }

    public final void clearShowingReply(String msgId) {
        y.i(msgId, "msgId");
        if (y.d(this.showingReplyTo.getValue(), msgId)) {
            CoroutineUtilsKt.launchUntil$default(this.coroutineScope, null, 4000L, new a() { // from class: a9.b
                @Override // lb.a
                public final Object invoke() {
                    return AppVolatileState.clearShowingReply$lambda$0(this.f590c);
                }
            }, 1, null);
        }
    }

    public final void clearTyping() {
        b0 b0Var = this._usersTyping;
        Object value = b0Var.getValue();
        ((Map) value).clear();
        b0Var.setValue(value);
    }

    public final void fullClear() {
        this.ownerConnection = Quality.INDETERMINATE;
        this.aliasSelected = false;
        this.isCertificateValid = true;
        this.themeSelected.setValue(0);
        this.showingReplyTo.setValue("");
        clearTyping();
        clearLast();
        this.blockRooms.clear();
        this.onNewMessageListener = new MsgListenerFor() { // from class: cu.todus.android.volatileState.AppVolatileState.fullClear.1
            @Override // cu.todus.android.volatileState.MsgListenerFor
            public void received(String uid) {
                y.i(uid, "uid");
            }
        };
        this.isServiceRunning = false;
        this.aliveConfiguration = "";
        this.uploadQuality = 3;
        this.callQuality.setValue(new CallQuality(0, 0, 3, null));
    }

    public final boolean getAliasSelected() {
        return this.aliasSelected;
    }

    public final String getAliveConfiguration() {
        return this.aliveConfiguration;
    }

    public final boolean getBatterySettingsShowed() {
        return this.batterySettingsShowed;
    }

    public final Map<String, Boolean> getBlockRooms() {
        return this.blockRooms;
    }

    public final b0 getCallQuality() {
        return this.callQuality;
    }

    public final long getCallStartTime() {
        return this.callStartTime;
    }

    public final MsgListenerFor getOnNewMessageListener() {
        return this.onNewMessageListener;
    }

    public final Quality getOwnerConnection() {
        return this.ownerConnection;
    }

    public final RootEnvironment getRootEnvironment() {
        return this.rootEnvironment;
    }

    public final MutableState<String> getShowingReplyTo() {
        return this.showingReplyTo;
    }

    public final b0 getThemeSelected() {
        return this.themeSelected;
    }

    public final int getUploadQuality() {
        return this.uploadQuality;
    }

    public final p0 getUsersLast() {
        return this.usersLast;
    }

    public final p0 getUsersTyping() {
        return this.usersTyping;
    }

    /* JADX INFO: renamed from: isCallServiceRunning, reason: from getter */
    public final b0 getIsCallServiceRunning() {
        return this.isCallServiceRunning;
    }

    /* JADX INFO: renamed from: isCertificateValid, reason: from getter */
    public final boolean getIsCertificateValid() {
        return this.isCertificateValid;
    }

    /* JADX INFO: renamed from: isRequestModeActivated, reason: from getter */
    public final b0 getIsRequestModeActivated() {
        return this.isRequestModeActivated;
    }

    /* JADX INFO: renamed from: isServiceRunning, reason: from getter */
    public final boolean getIsServiceRunning() {
        return this.isServiceRunning;
    }

    public final void onNewMessage(String uid) {
        y.i(uid, "uid");
        this.onNewMessageListener.received(uid);
    }

    public final void setAliasSelected(boolean z10) {
        this.aliasSelected = z10;
    }

    public final void setAliveConfiguration(String str) {
        y.i(str, "<set-?>");
        this.aliveConfiguration = str;
    }

    public final void setBatterySettingsShowed(boolean z10) {
        this.batterySettingsShowed = z10;
    }

    public final void setCallStartTime(long j10) {
        this.callStartTime = j10;
    }

    public final void setCertificateValid(boolean z10) {
        this.isCertificateValid = z10;
    }

    public final void setOnNewMessageListener(MsgListenerFor msgListenerFor) {
        y.i(msgListenerFor, "<set-?>");
        this.onNewMessageListener = msgListenerFor;
    }

    public final void setOwnerConnection(Quality quality) {
        y.i(quality, "<set-?>");
        this.ownerConnection = quality;
    }

    public final void setRootEnvironment(RootEnvironment rootEnvironment) {
        y.i(rootEnvironment, "<set-?>");
        this.rootEnvironment = rootEnvironment;
    }

    public final void setServiceRunning(boolean z10) {
        this.isServiceRunning = z10;
    }

    public final void setUploadQuality(int i10) {
        this.uploadQuality = i10;
    }

    public final void showReply(String msgId) {
        y.i(msgId, "msgId");
        this.showingReplyTo.setValue(msgId);
    }

    public final void updateUserLast(Pair<String, Long> last) {
        y.i(last, "last");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) this.usersLast.getValue()).entrySet()) {
            linkedHashMap.put((String) entry.getKey(), Long.valueOf(((Number) entry.getValue()).longValue()));
        }
        linkedHashMap.put(last.getFirst(), last.getSecond());
        this._usersLast.setValue(linkedHashMap);
    }

    public final void updateUserTyping(Pair<String, Boolean> typing) {
        y.i(typing, "typing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) this.usersTyping.getValue()).entrySet()) {
            String str = (String) entry.getKey();
            Boolean bool = (Boolean) entry.getValue();
            bool.booleanValue();
            linkedHashMap.put(str, bool);
        }
        linkedHashMap.put(typing.getFirst(), typing.getSecond());
        if (typing.getSecond().booleanValue()) {
            this._usersTyping.setValue(linkedHashMap);
            autoClearTyping(typing.getFirst());
        } else {
            linkedHashMap.remove(typing.getFirst());
            this._usersTyping.setValue(linkedHashMap);
        }
    }

    public final void clearTyping(String key) {
        y.i(key, "key");
        if (((Map) this.usersTyping.getValue()).get(key) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) this.usersTyping.getValue()).entrySet()) {
            String str = (String) entry.getKey();
            Boolean bool = (Boolean) entry.getValue();
            bool.booleanValue();
            linkedHashMap.put(str, bool);
        }
        linkedHashMap.remove(key);
        this._usersTyping.setValue(linkedHashMap);
    }
}
