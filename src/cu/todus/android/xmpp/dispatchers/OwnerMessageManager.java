package cu.todus.android.xmpp.dispatchers;

import ab.e;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import bb.b;
import cb.d;
import cb.l;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.s3.upload.UploadDataSource;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.StanzaConfirmResponse;
import cu.todus.android.xmpp.StanzaListenerManager;
import defpackage.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.Stanza;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import pe.o0;
import pe.w0;
import te.i;
import ua.k0;
import ua.v;
import v5.f;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B;\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0012\u0010\u0010J&\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ*\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\"\u0010#R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b+\u0010&R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107¨\u0006:"}, d2 = {"Lcu/todus/android/xmpp/dispatchers/OwnerMessageManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/s3/upload/UploadDataSource;", "uploadDataSource", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;Llb/a;Lcu/todus/android/s3/upload/UploadDataSource;Llb/a;)V", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "message", "send", "(Lcu/todus/android/data/db/pojo/MessageWithAttachments;Lab/e;)Ljava/lang/Object;", "it", "sendMessageToChannel", "Lcu/todus/android/data/db/entity/toDus/Message;", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "sendMessage", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lua/k0;", "startManager", "()V", "stopManager", "Lorg/jivesoftware/smack/packet/Stanza;", "stanza", "", "originalMsgId", "isLastChunk", "sendSingleStanza", "(Lorg/jivesoftware/smack/packet/Stanza;Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Lcu/todus/android/s3/upload/UploadDataSource;", "getUploadDataSource", "()Lcu/todus/android/s3/upload/UploadDataSource;", "getOwner", "Lv5/f;", "gson", "Lv5/f;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lpe/a2;", "listenerJob", "Lpe/a2;", "timeoutJob", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OwnerMessageManager implements StanzaListenerManager {
    private static final String TAG = "OwnerMessageManager";
    private final lb.a canSend;
    private final f gson;
    private a2 listenerJob;
    private final lb.a mXMPPConnection;
    private final MessageDao messageDao;
    private final lb.a owner;
    private final RoomDao roomDao;
    private a2 timeoutJob;
    private final UploadDataSource uploadDataSource;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StanzaConfirmResponse.values().length];
            try {
                iArr[StanzaConfirmResponse.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StanzaConfirmResponse.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager", f = "OwnerMessageManager.kt", l = {WebmConstants.MkvEbmlElement.PREV_SIZE, 173}, m = "send", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerMessageManager.this.send(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager", f = "OwnerMessageManager.kt", l = {223, 229, 230, 249, 259, 263, 292}, m = "sendMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13871 extends d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13871(e<? super C13871> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerMessageManager.this.sendMessage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$sendMessageToChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager", f = "OwnerMessageManager.kt", l = {325, 200, 205, 210}, m = "sendMessageToChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13881 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C13881(e<? super C13881> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerMessageManager.this.sendMessageToChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$sendSingleStanza$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager", f = "OwnerMessageManager.kt", l = {299, 304, 311, TypedValues.AttributesType.TYPE_EASING}, m = "sendSingleStanza", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13891 extends d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13891(e<? super C13891> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerMessageManager.this.sendSingleStanza(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1", f = "OwnerMessageManager.kt", l = {74, 75, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 79, 82, 103}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13901 extends m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1$2", f = "OwnerMessageManager.kt", l = {95}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass2 extends m implements Function2 {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(e<? super AnonymousClass2> eVar) {
                super(2, eVar);
            }

            @Override // cb.a
            public final e<k0> create(Object obj, e<?> eVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Throwable th2 = (Throwable) this.L$0;
                Object objG = b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    Log.w(OwnerMessageManager.TAG, "Flow collection failed, retrying...", th2);
                    this.L$0 = l.a(th2);
                    this.label = 1;
                    if (w0.b(1000L, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                return cb.b.a(true);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Throwable th2, e<? super Boolean> eVar) {
                return ((AnonymousClass2) create(th2, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1$3", f = "OwnerMessageManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "", "exception", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends m implements Function3 {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass3(e<? super AnonymousClass3> eVar) {
                super(3, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Throwable th2 = (Throwable) this.L$0;
                b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Log.e(OwnerMessageManager.TAG, "CRITICAL: Message Flow collection has stopped permanently.", th2);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(eVar);
                anonymousClass3.L$0 = th2;
                return anonymousClass3.invokeSuspend(k0.f43947a);
            }
        }

        public C13901(e<? super C13901> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerMessageManager.this.new C13901(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0072  */
        /* JADX WARN: Code duplicated, block: B:22:0x0074 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:31:0x00a5, B:32:0x00b0, B:34:0x00b6, B:10:0x001e, B:28:0x0095, B:11:0x0023, B:25:0x0085, B:12:0x0027, B:22:0x0074, B:13:0x002b, B:19:0x0053, B:16:0x0032), top: B:42:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0083  */
        /* JADX WARN: Code duplicated, block: B:25:0x0085 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:31:0x00a5, B:32:0x00b0, B:34:0x00b6, B:10:0x001e, B:28:0x0095, B:11:0x0023, B:25:0x0085, B:12:0x0027, B:22:0x0074, B:13:0x002b, B:19:0x0053, B:16:0x0032), top: B:42:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0094  */
        /* JADX WARN: Code duplicated, block: B:28:0x0095 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:31:0x00a5, B:32:0x00b0, B:34:0x00b6, B:10:0x001e, B:28:0x0095, B:11:0x0023, B:25:0x0085, B:12:0x0027, B:22:0x0074, B:13:0x002b, B:19:0x0053, B:16:0x0032), top: B:42:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a5 A[Catch: Exception -> 0x001b, PHI: r6
          0x00a5: PHI (r6v25 java.lang.Object) = (r6v24 java.lang.Object), (r6v0 java.lang.Object) binds: [B:29:0x00a2, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:31:0x00a5, B:32:0x00b0, B:34:0x00b6, B:10:0x001e, B:28:0x0095, B:11:0x0023, B:25:0x0085, B:12:0x0027, B:22:0x0074, B:13:0x002b, B:19:0x0053, B:16:0x0032), top: B:42:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b6 A[Catch: Exception -> 0x001b, LOOP:0: B:32:0x00b0->B:34:0x00b6, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:31:0x00a5, B:32:0x00b0, B:34:0x00b6, B:10:0x001e, B:28:0x0095, B:11:0x0023, B:25:0x0085, B:12:0x0027, B:22:0x0074, B:13:0x002b, B:19:0x0053, B:16:0x0032), top: B:42:0x0006 }] */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0104, code lost:
        
            if (r6.collect(r1, r5) == r0) goto L39;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.C13901.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((C13901) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass4<T> implements i {
            final /* synthetic */ OwnerMessageManager this$0;

            public AnonymousClass4(OwnerMessageManager ownerMessageManager) {
                this.this$0 = ownerMessageManager;
            }

            /* JADX WARN: Code duplicated, block: B:62:0x0116 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:14:0x0033, B:59:0x010a, B:60:0x010c, B:62:0x0116, B:21:0x004b, B:31:0x006f, B:33:0x0081, B:45:0x00a8, B:36:0x0089, B:37:0x008d, B:39:0x0093, B:41:0x009f), top: B:67:0x0023 }] */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            public final Object emit(MessageWithAttachments messageWithAttachments, e<? super k0> eVar) {
                OwnerMessageManager$startManager$1$4$emit$1 ownerMessageManager$startManager$1$4$emit$1;
                OwnerMessageManager ownerMessageManager;
                int i10;
                MessageWithAttachments messageWithAttachments2;
                int i11;
                MessageWithAttachments messageWithAttachments3;
                int i12;
                MessageWithAttachments messageWithAttachments4;
                AppVolatileState instanceOrNull;
                if (eVar instanceof OwnerMessageManager$startManager$1$4$emit$1) {
                    ownerMessageManager$startManager$1$4$emit$1 = (OwnerMessageManager$startManager$1$4$emit$1) eVar;
                    int i13 = ownerMessageManager$startManager$1$4$emit$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        ownerMessageManager$startManager$1$4$emit$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        ownerMessageManager$startManager$1$4$emit$1 = new OwnerMessageManager$startManager$1$4$emit$1(this, eVar);
                    }
                } else {
                    ownerMessageManager$startManager$1$4$emit$1 = new OwnerMessageManager$startManager$1$4$emit$1(this, eVar);
                }
                Object obj = ownerMessageManager$startManager$1$4$emit$1.result;
                Object objG = b.g();
                int i14 = ownerMessageManager$startManager$1$4$emit$1.label;
                try {
                    if (i14 != 0) {
                        if (i14 == 1) {
                            i12 = ownerMessageManager$startManager$1$4$emit$1.I$1;
                            i11 = ownerMessageManager$startManager$1$4$emit$1.I$0;
                            messageWithAttachments2 = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$2;
                            ownerMessageManager = (OwnerMessageManager) ownerMessageManager$startManager$1$4$emit$1.L$1;
                            messageWithAttachments3 = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$0;
                            try {
                                v.b(obj);
                            } catch (Exception e10) {
                                e = e10;
                                messageWithAttachments = messageWithAttachments2;
                                Log.e(OwnerMessageManager.TAG, "Error processing message " + messageWithAttachments.getMessage().getId() + " inside collector. The collector will continue.", e);
                            }
                        } else if (i14 == 2) {
                            messageWithAttachments = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$1;
                            messageWithAttachments4 = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$0;
                            v.b(obj);
                        } else {
                            if (i14 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            messageWithAttachments = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$1;
                            messageWithAttachments4 = (MessageWithAttachments) ownerMessageManager$startManager$1$4$emit$1.L$0;
                            v.b(obj);
                            k0 k0Var = k0.f43947a;
                        }
                        instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
                        if (instanceOrNull != null) {
                            instanceOrNull.onNewMessage(messageWithAttachments4.getMessage().getRoomId());
                        }
                        return k0.f43947a;
                    }
                    v.b(obj);
                    if (messageWithAttachments != null) {
                        ownerMessageManager = this.this$0;
                        messageWithAttachments.getMessage().getId();
                        List<Attachment> attachments = messageWithAttachments.getAttachments();
                        if (!r.a(attachments) || !attachments.isEmpty()) {
                            Iterator<T> it = attachments.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    i10 = 1;
                                    break;
                                }
                                Attachment attachment = (Attachment) it.next();
                                if (attachment.getState() != 2 && attachment.getState() != 6) {
                                    i10 = 0;
                                    break;
                                }
                            }
                        } else {
                            i10 = 1;
                            break;
                        }
                        ownerMessageManager$startManager$1$4$emit$1.L$0 = messageWithAttachments;
                        ownerMessageManager$startManager$1$4$emit$1.L$1 = ownerMessageManager;
                        ownerMessageManager$startManager$1$4$emit$1.L$2 = messageWithAttachments;
                        ownerMessageManager$startManager$1$4$emit$1.I$0 = 0;
                        ownerMessageManager$startManager$1$4$emit$1.I$1 = i10;
                        ownerMessageManager$startManager$1$4$emit$1.label = 1;
                        if (w0.b(100L, ownerMessageManager$startManager$1$4$emit$1) != objG) {
                            messageWithAttachments2 = messageWithAttachments;
                            i11 = 0;
                            messageWithAttachments3 = messageWithAttachments2;
                            i12 = i10;
                        }
                        return objG;
                    }
                    return k0.f43947a;
                    if (i12 != 0) {
                        messageWithAttachments2.getMessage().getId();
                        ownerMessageManager$startManager$1$4$emit$1.L$0 = messageWithAttachments3;
                        ownerMessageManager$startManager$1$4$emit$1.L$1 = messageWithAttachments2;
                        ownerMessageManager$startManager$1$4$emit$1.L$2 = null;
                        ownerMessageManager$startManager$1$4$emit$1.I$0 = i11;
                        ownerMessageManager$startManager$1$4$emit$1.I$1 = i12;
                        ownerMessageManager$startManager$1$4$emit$1.label = 2;
                        if (ownerMessageManager.send(messageWithAttachments2, ownerMessageManager$startManager$1$4$emit$1) != objG) {
                            messageWithAttachments = messageWithAttachments2;
                            messageWithAttachments4 = messageWithAttachments3;
                            instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
                            if (instanceOrNull != null) {
                                instanceOrNull.onNewMessage(messageWithAttachments4.getMessage().getRoomId());
                            }
                            return k0.f43947a;
                        }
                    } else {
                        messageWithAttachments2.getMessage().getId();
                        MessageDao messageDao = ownerMessageManager.messageDao;
                        String id2 = messageWithAttachments3.getMessage().getId();
                        ownerMessageManager$startManager$1$4$emit$1.L$0 = messageWithAttachments3;
                        ownerMessageManager$startManager$1$4$emit$1.L$1 = messageWithAttachments2;
                        ownerMessageManager$startManager$1$4$emit$1.L$2 = null;
                        ownerMessageManager$startManager$1$4$emit$1.I$0 = i11;
                        ownerMessageManager$startManager$1$4$emit$1.I$1 = i12;
                        ownerMessageManager$startManager$1$4$emit$1.label = 3;
                        if (messageDao.forceUpdateStatus(id2, -1, ownerMessageManager$startManager$1$4$emit$1) != objG) {
                            messageWithAttachments = messageWithAttachments2;
                            messageWithAttachments4 = messageWithAttachments3;
                            k0 k0Var2 = k0.f43947a;
                            instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
                            if (instanceOrNull != null) {
                                instanceOrNull.onNewMessage(messageWithAttachments4.getMessage().getRoomId());
                            }
                            return k0.f43947a;
                        }
                    }
                    return objG;
                } catch (Exception e11) {
                    e = e11;
                }
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit((MessageWithAttachments) obj, (e<? super k0>) eVar);
            }
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerMessageManager$startManager$2", f = "OwnerMessageManager.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS, 142}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        int label;

        public AnonymousClass2(e<? super AnonymousClass2> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerMessageManager.this.new AnonymousClass2(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0023  */
        /* JADX WARN: Code duplicated, block: B:17:0x002e A[Catch: Exception -> 0x0012, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0012, blocks: (B:6:0x000e, B:17:0x002e), top: B:21:0x000e }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003a -> B:14:0x0023). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003d -> B:14:0x0023). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                ua.v.b(r7)     // Catch: java.lang.Exception -> L12
                goto L23
            L12:
                r7 = move-exception
                goto L3d
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                ua.v.b(r7)
                goto L2e
            L20:
                ua.v.b(r7)
            L23:
                r6.label = r3
                r4 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r7 = pe.w0.b(r4, r6)
                if (r7 != r0) goto L2e
                goto L3c
            L2e:
                cu.todus.android.xmpp.dispatchers.OwnerMessageManager r7 = cu.todus.android.xmpp.dispatchers.OwnerMessageManager.this     // Catch: java.lang.Exception -> L12
                cu.todus.android.db.dao.toDus.MessageDao r7 = cu.todus.android.xmpp.dispatchers.OwnerMessageManager.access$getMessageDao$p(r7)     // Catch: java.lang.Exception -> L12
                r6.label = r2     // Catch: java.lang.Exception -> L12
                java.lang.Object r7 = r7.prepareToSendMsgsWithTimeout(r6)     // Catch: java.lang.Exception -> L12
                if (r7 != r0) goto L23
            L3c:
                return r0
            L3d:
                java.lang.String r1 = "OwnerMessageManager"
                java.lang.String r4 = "Error during periodic timeout check."
                android.util.Log.e(r1, r4, r7)
                goto L23
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public OwnerMessageManager(lb.a canSend, lb.a mXMPPConnection, UploadDataSource uploadDataSource, lb.a owner) {
        y.i(canSend, "canSend");
        y.i(mXMPPConnection, "mXMPPConnection");
        y.i(uploadDataSource, "uploadDataSource");
        y.i(owner, "owner");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.uploadDataSource = uploadDataSource;
        this.owner = owner;
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.messageDao = companion.getInstance().getMessageDao();
        this.roomDao = companion.getInstance().getRoomDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        if (r7 == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object send(cu.todus.android.data.db.pojo.MessageWithAttachments r6, ab.e<? super java.lang.Boolean> r7) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.send(cu.todus.android.data.db.pojo.MessageWithAttachments, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x041f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0433 A[Catch: Exception -> 0x0439, TryCatch #13 {Exception -> 0x0439, blocks: (B:102:0x042b, B:104:0x0433, B:110:0x0445), top: B:175:0x042b }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0442  */
    /* JADX WARN: Code duplicated, block: B:113:0x049e  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x02e2 A[Catch: Exception -> 0x050a, TRY_LEAVE, TryCatch #2 {Exception -> 0x050a, blocks: (B:64:0x02dc, B:66:0x02e2, B:73:0x02f6), top: B:154:0x02dc }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0300 A[Catch: Exception -> 0x04e9, TRY_LEAVE, TryCatch #4 {Exception -> 0x04e9, blocks: (B:75:0x02fc, B:77:0x0300), top: B:158:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0391  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:93:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:94:0x03c5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [cu.todus.android.xmpp.mapper.MapperMessageToStanza] */
    /* JADX WARN: Type inference failed for: r11v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v5, types: [cu.todus.android.data.db.entity.toDus.Message] */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v17 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r31v0, types: [cu.todus.android.xmpp.dispatchers.OwnerMessageManager] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v6, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x049e -> B:114:0x04ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x04f6 -> B:134:0x0503). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendMessage(cu.todus.android.data.db.entity.toDus.Message r32, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r33, ab.e<? super java.lang.Boolean> r34) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            Method dump skipped, instruction units count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.sendMessage(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendMessage$lambda$0(List it) {
        y.i(it, "it");
        return g0.G0(it, "", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x0124 A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:26:0x0097, B:41:0x011e, B:43:0x0124, B:51:0x0165), top: B:61:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0150  */
    /* JADX WARN: Code duplicated, block: B:47:0x0156 A[PHI: r4 r12 r13
      0x0156: PHI (r4v7 java.lang.String) = (r4v3 java.lang.String), (r4v24 java.lang.String) binds: [B:50:0x015f, B:42:0x0122] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r12v6 cu.todus.android.data.db.entity.toDus.Message) = (r12v3 cu.todus.android.data.db.entity.toDus.Message), (r12v7 cu.todus.android.data.db.entity.toDus.Message) binds: [B:50:0x015f, B:42:0x0122] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r13v9 cu.todus.android.data.db.pojo.MessageWithAttachments) = 
      (r13v4 cu.todus.android.data.db.pojo.MessageWithAttachments)
      (r13v15 cu.todus.android.data.db.pojo.MessageWithAttachments)
     binds: [B:50:0x015f, B:42:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b9, code lost:
    
        if (r0.forceUpdateStatus(r6, 4, r2) == r3) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01fd, code lost:
    
        if (r6.forceUpdateStatus(r8, 4, r2) == r3) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendMessageToChannel(cu.todus.android.data.db.pojo.MessageWithAttachments r17, ab.e<? super java.lang.Boolean> r18) {
        /*
            Method dump skipped, instruction units count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.sendMessageToChannel(cu.todus.android.data.db.pojo.MessageWithAttachments, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object sendSingleStanza$default(OwnerMessageManager ownerMessageManager, Stanza stanza, String str, boolean z10, e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return ownerMessageManager.sendSingleStanza(stanza, str, z10, eVar);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final UploadDataSource getUploadDataSource() {
        return this.uploadDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:35:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:38:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0113  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r13 == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
    
        if (r13.forceUpdateStatus(r11, 4, r0) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010e, code lost:
    
        if (r13.forceUpdateStatus(r11, 7, r0) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012c, code lost:
    
        if (r13.updateStatusProgressive(r11, 1, r0) == r1) goto L41;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x0095, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x00dc, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendSingleStanza(org.jivesoftware.smack.packet.Stanza r10, java.lang.String r11, boolean r12, ab.e<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMessageManager.sendSingleStanza(org.jivesoftware.smack.packet.Stanza, java.lang.String, boolean, ab.e):java.lang.Object");
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        Log.i(TAG, "startManager() called. Ensuring previous jobs are stopped.");
        stopManager();
        Log.i(TAG, "Creating and starting new jobs.");
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        o0 o0Var = o0.LAZY;
        a2 a2VarD = k.d(m0VarA, null, o0Var, new C13901(null), 1, null);
        this.listenerJob = a2VarD;
        if (a2VarD != null) {
            a2VarD.start();
        }
        a2 a2VarD2 = k.d(n0.a(d1.b().plus(e2.b(null, 1, null))), null, o0Var, new AnonymousClass2(null), 1, null);
        this.timeoutJob = a2VarD2;
        if (a2VarD2 != null) {
            a2VarD2.start();
        }
        Log.i(TAG, "startManager() finished.");
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        a2 a2Var;
        a2 a2Var2;
        Log.i(TAG, "stopManager() called.");
        a2 a2Var3 = this.listenerJob;
        if (a2Var3 != null && a2Var3.isActive() && (a2Var2 = this.listenerJob) != null) {
            a2.a.a(a2Var2, null, 1, null);
        }
        a2 a2Var4 = this.timeoutJob;
        if (a2Var4 != null && a2Var4.isActive() && (a2Var = this.timeoutJob) != null) {
            a2.a.a(a2Var, null, 1, null);
        }
        this.listenerJob = null;
        this.timeoutJob = null;
    }
}
