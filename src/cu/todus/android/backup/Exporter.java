package cu.todus.android.backup;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import bb.b;
import cb.d;
import cb.m;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.c;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B¥\u0001\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012(\u0010\n\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019R3\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR9\u0010\n\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"R3\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b#\u0010\u001fR3\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b$\u0010\u001f¨\u0006%"}, d2 = {"Lcu/todus/android/backup/Exporter;", "", "Lkotlin/Function1;", "Lab/e;", "", "Lcu/todus/android/data/db/pojo/RoomItemView;", "getAllForSaves", "Lkotlin/Function2;", "", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "getAllByRoomForSave", "Lv5/f;", "gson", "Lua/k0;", "reloadRoom", "insertMsg", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lv5/f;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", TemplateContent.NUMBER_TYPE, "", "export", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Ljava/io/File;", ExtensionFile.ELEMENT, "import", "(Ljava/io/File;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "getGetAllForSaves", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "getGetAllByRoomForSave", "()Lkotlin/jvm/functions/Function2;", "Lv5/f;", "getGson", "()Lv5/f;", "getReloadRoom", "getInsertMsg", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Exporter {
    public static final int $stable = 8;
    private final Function2 getAllByRoomForSave;
    private final Function1 getAllForSaves;
    private final f gson;
    private final Function2 insertMsg;
    private final Function2 reloadRoom;

    /* JADX INFO: renamed from: cu.todus.android.backup.Exporter$export$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.backup.Exporter", f = "Exporter.kt", l = {25, 28, RectListKt.BitOffsetForGesturable}, m = "export", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Exporter.this.export(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.backup.Exporter$export$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.backup.Exporter$export$3", f = "Exporter.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)Z"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends m implements Function2 {
        final /* synthetic */ List<String> $data;
        final /* synthetic */ File $newFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(File file, List<String> list, e<? super AnonymousClass3> eVar) {
            super(2, eVar);
            this.$newFile = file;
            this.$data = list;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass3(this.$newFile, this.$data, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                this.$newFile.createNewFile();
                File file = this.$newFile;
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), c.f37236b), 8192);
                List<String> list = this.$data;
                try {
                    bufferedWriter.write("");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.append((CharSequence) it.next());
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    Boolean boolA = cb.b.a(true);
                    hb.c.a(bufferedWriter, null);
                    return boolA;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        hb.c.a(bufferedWriter, th2);
                        throw th3;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return cb.b.a(false);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Boolean> eVar) {
            return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.backup.Exporter$import$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.backup.Exporter$import$2", f = "Exporter.kt", l = {95, 107}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "", "<anonymous>", "(Lpe/m0;)Z"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ AESUtils $aesUtil;
        final /* synthetic */ File $file;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ Exporter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file, Exporter exporter, AESUtils aESUtils, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$file = file;
            this.this$0 = exporter;
            this.$aesUtil = aESUtils;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$file, this.this$0, this.$aesUtil, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x0157 A[Catch: all -> 0x0059, Exception -> 0x005d, TryCatch #2 {Exception -> 0x005d, blocks: (B:7:0x0041, B:39:0x0151, B:41:0x0157, B:46:0x01f2, B:26:0x00bb, B:29:0x00c5, B:47:0x01fd), top: B:61:0x0041 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x01e7  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0148 -> B:39:0x0151). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01e7 -> B:45:0x01ed). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 547
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.backup.Exporter.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Boolean> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public Exporter(Function1 getAllForSaves, Function2 getAllByRoomForSave, f gson, Function2 reloadRoom, Function2 insertMsg) {
        y.i(getAllForSaves, "getAllForSaves");
        y.i(getAllByRoomForSave, "getAllByRoomForSave");
        y.i(gson, "gson");
        y.i(reloadRoom, "reloadRoom");
        y.i(insertMsg, "insertMsg");
        this.getAllForSaves = getAllForSaves;
        this.getAllByRoomForSave = getAllByRoomForSave;
        this.gson = gson;
        this.reloadRoom = reloadRoom;
        this.insertMsg = insertMsg;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x011e  */
    /* JADX WARN: Code duplicated, block: B:72:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:75:0x02c1 A[LOOP:4: B:73:0x02bb->B:75:0x02c1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0336 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c5, code lost:
    
        if (r7 == r4) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x014f, code lost:
    
        if (r2 == r4) goto L78;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x014f -> B:36:0x0153). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object export(java.lang.String r34, ab.e<? super java.lang.Boolean> r35) {
        /*
            Method dump skipped, instruction units count: 823
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.backup.Exporter.export(java.lang.String, ab.e):java.lang.Object");
    }

    public final Function2 getGetAllByRoomForSave() {
        return this.getAllByRoomForSave;
    }

    public final Function1 getGetAllForSaves() {
        return this.getAllForSaves;
    }

    public final f getGson() {
        return this.gson;
    }

    public final Function2 getInsertMsg() {
        return this.insertMsg;
    }

    public final Function2 getReloadRoom() {
        return this.reloadRoom;
    }

    /* JADX INFO: renamed from: import, reason: not valid java name */
    public final Object m9796import(File file, String str, e<? super Boolean> eVar) {
        return i.g(d1.b(), new AnonymousClass2(file, this, new AESUtils(str + "9ABCDEF"), null), eVar);
    }
}
