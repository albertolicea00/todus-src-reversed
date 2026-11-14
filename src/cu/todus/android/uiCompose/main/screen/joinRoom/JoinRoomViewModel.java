package cu.todus.android.uiCompose.main.screen.joinRoom;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import cu.todus.android.R;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.xmpp.JoinResult;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import le.a0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/joinRoom/JoinRoomViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "roomLinkId", "Lua/k0;", "loadRoomInfo", "(Ljava/lang/String;)V", "linkId", "joinGroup", "joinChannel", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "Lcu/todus/android/uiCompose/main/screen/joinRoom/JoinRoomState;", "_roomInfo", "Lte/b0;", "Lte/p0;", "roomInfo", "Lte/p0;", "getRoomInfo", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JoinRoomViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _roomInfo;
    private final p0 roomInfo;
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinChannel$1", f = "JoinRoomViewModel.kt", l = {126}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $linkId;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinChannel$1$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[JoinResult.values().length];
                try {
                    iArr[JoinResult.JOINED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$linkId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return JoinRoomViewModel.this.new AnonymousClass1(this.$linkId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objJoinChannel;
            JoinRoomState joinRoomState;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Object data = ((FlowsState) JoinRoomViewModel.this._roomInfo.getValue()).getData();
                y.f(data);
                JoinRoomState joinRoomState2 = (JoinRoomState) data;
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.loading());
                MainRepository mainRepository = JoinRoomViewModel.this.mainRepository;
                String str = this.$linkId;
                this.L$0 = joinRoomState2;
                this.label = 1;
                objJoinChannel = mainRepository.joinChannel(str, this);
                if (objJoinChannel == objG) {
                    return objG;
                }
                joinRoomState = joinRoomState2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JoinRoomState joinRoomState3 = (JoinRoomState) this.L$0;
                v.b(obj);
                objJoinChannel = obj;
                joinRoomState = joinRoomState3;
            }
            JoinResult joinResult = (JoinResult) objJoinChannel;
            if (joinResult == null || WhenMappings.$EnumSwitchMapping$0[joinResult.ordinal()] != 1) {
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.success(JoinRoomState.copy$default(joinRoomState, false, null, null, null, null, 0, false, false, true, 255, null)));
            } else {
                MainRepository mainRepository2 = JoinRoomViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CONGRATS;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.welcome_new_channel);
                y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.success(JoinRoomState.copy$default(joinRoomState, false, null, null, null, null, 0, false, true, false, 383, null)));
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinGroup$1", f = "JoinRoomViewModel.kt", l = {95}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12881 extends m implements Function1 {
        final /* synthetic */ String $linkId;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$joinGroup$1$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[JoinResult.values().length];
                try {
                    iArr[JoinResult.JOINED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12881(String str, ab.e<? super C12881> eVar) {
            super(1, eVar);
            this.$linkId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return JoinRoomViewModel.this.new C12881(this.$linkId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12881) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objJoinGroup;
            JoinRoomState joinRoomState;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Object data = ((FlowsState) JoinRoomViewModel.this._roomInfo.getValue()).getData();
                y.f(data);
                JoinRoomState joinRoomState2 = (JoinRoomState) data;
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.loading());
                MainRepository mainRepository = JoinRoomViewModel.this.mainRepository;
                String str = this.$linkId;
                this.L$0 = joinRoomState2;
                this.label = 1;
                objJoinGroup = mainRepository.joinGroup(str, this);
                if (objJoinGroup == objG) {
                    return objG;
                }
                joinRoomState = joinRoomState2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JoinRoomState joinRoomState3 = (JoinRoomState) this.L$0;
                v.b(obj);
                objJoinGroup = obj;
                joinRoomState = joinRoomState3;
            }
            JoinResult joinResult = (JoinResult) objJoinGroup;
            if (joinResult == null || WhenMappings.$EnumSwitchMapping$0[joinResult.ordinal()] != 1) {
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.success(JoinRoomState.copy$default(joinRoomState, false, null, null, null, null, 0, false, false, true, 255, null)));
            } else {
                MainRepository mainRepository2 = JoinRoomViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CONGRATS;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.welcome_new_group);
                y.h(string2, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string2));
                JoinRoomViewModel.this._roomInfo.setValue(FlowsState.INSTANCE.success(JoinRoomState.copy$default(joinRoomState, false, null, null, null, null, 0, false, true, false, 383, null)));
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$loadRoomInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel$loadRoomInfo$1", f = "JoinRoomViewModel.kt", l = {39, 43, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, MdtaMetadataEntry.TYPE_INDICATOR_INT32}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12891 extends m implements Function1 {
        final /* synthetic */ String $roomLinkId;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12891(String str, ab.e<? super C12891> eVar) {
            super(1, eVar);
            this.$roomLinkId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return JoinRoomViewModel.this.new C12891(this.$roomLinkId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12891) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0081  */
        /* JADX WARN: Code duplicated, block: B:26:0x009b A[DONT_INVERT, PHI: r2 r7
          0x009b: PHI (r2v7 int) = (r2v4 int), (r2v19 int) binds: [B:24:0x0097, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]
          0x009b: PHI (r7v2 java.lang.Object) = (r7v1 java.lang.Object), (r7v6 java.lang.Object) binds: [B:24:0x0097, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:27:0x009d  */
        /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:36:0x00ee  */
        /* JADX WARN: Code duplicated, block: B:37:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:41:0x0101  */
        /* JADX WARN: Code duplicated, block: B:44:0x0110  */
        /* JADX WARN: Code duplicated, block: B:45:0x0113  */
        /* JADX WARN: Code duplicated, block: B:48:0x011b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0124  */
        /* JADX WARN: Code duplicated, block: B:53:0x013b  */
        /* JADX WARN: Code duplicated, block: B:55:0x013f  */
        /* JADX WARN: Code duplicated, block: B:58:0x0159  */
        /* JADX WARN: Code duplicated, block: B:61:0x017e  */
        /* JADX WARN: Code duplicated, block: B:64:0x0187  */
        /* JADX WARN: Code duplicated, block: B:66:0x019d  */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        
            if (pe.w0.b(1000, r23) == r1) goto L57;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007b -> B:22:0x007f). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 431
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.joinRoom.JoinRoomViewModel.C12891.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public JoinRoomViewModel() {
        b0 b0VarA = r0.a(FlowsState.INSTANCE.notRequested());
        this._roomInfo = b0VarA;
        this.roomInfo = te.j.b(b0VarA);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final p0 getRoomInfo() {
        return this.roomInfo;
    }

    public final void joinChannel(String linkId) {
        y.i(linkId, "linkId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(linkId, null), 3, null);
    }

    public final void joinGroup(String linkId) {
        y.i(linkId, "linkId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12881(linkId, null), 3, null);
    }

    public final void loadRoomInfo(String roomLinkId) {
        y.i(roomLinkId, "roomLinkId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12891(roomLinkId, null), 3, null);
    }
}
