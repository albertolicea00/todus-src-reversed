package cu.todus.android.uiCompose.main.screen.dateEditor;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJA\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/dateEditor/DateEditorViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "title", "", "allDay", "", "startDate", "endDate", "createICS", "(Ljava/lang/String;ZJJ)Ljava/lang/String;", "roomId", "replyMsg", "Lua/k0;", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "getMainRepository", "()Lcu/todus/android/repositories/MainRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DateEditorViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorViewModel$sendEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.dateEditor.DateEditorViewModel$sendEvent$1", f = "DateEditorViewModel.kt", l = {96}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ EventContent $eventContent;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, EventContent eventContent, String str2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$eventContent = eventContent;
            this.$replyMsg = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return DateEditorViewModel.this.new AnonymousClass1(this.$roomId, this.$eventContent, this.$replyMsg, eVar);
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
                MainRepository mainRepository = DateEditorViewModel.this.getMainRepository();
                String str = this.$roomId;
                EventContent eventContent = this.$eventContent;
                String str2 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendEvent(str, eventContent, str2, this) == objG) {
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

    private final String createICS(String title, boolean allDay, long startDate, long endDate) {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(startDate);
        Instant instantOfEpochMilli2 = Instant.ofEpochMilli(endDate);
        Instant instantOfEpochMilli3 = Instant.ofEpochMilli(new Date().getTime());
        DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(ZoneOffset.UTC);
        String str = dateTimeFormatterWithZone.format(instantOfEpochMilli);
        String str2 = dateTimeFormatterWithZone.format(instantOfEpochMilli2);
        String str3 = dateTimeFormatterWithZone.format(instantOfEpochMilli3);
        if (allDay) {
            return le.t.n("\n            BEGIN:VCALENDAR\n            PRODID:-//Events Calendar//ToDus 2//ES\n            CALSCALE:GREGORIAN\n            VERSION:2.0\n            BEGIN:VEVENT\n            DTSTAMP:" + str3 + "\n            DTSTART;VALUE=DATE:" + str + "\n            DTEND;VALUE=DATE:" + str2 + "\n            SUMMARY:" + title + "\n            TZID:America/Havana\n            END:VEVENT\n            END:VCALENDAR\n        ");
        }
        return le.t.n("\n            BEGIN:VCALENDAR\n            PRODID:-//Events Calendar//ToDus 2//ES\n            CALSCALE:GREGORIAN\n            VERSION:2.0\n            BEGIN:VEVENT\n            DTSTAMP:" + str3 + "\n            DTSTART:" + str + "\n            DTEND:" + str2 + "\n            SUMMARY:" + title + "\n            TZID:America/Havana\n            END:VEVENT\n            END:VCALENDAR\n        ");
    }

    public static /* synthetic */ String createICS$default(DateEditorViewModel dateEditorViewModel, String str, boolean z10, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return dateEditorViewModel.createICS(str, z10, j10, j11);
    }

    public static /* synthetic */ void sendEvent$default(DateEditorViewModel dateEditorViewModel, String str, String str2, String str3, String str4, boolean z10, String str5, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            str5 = null;
        }
        dateEditorViewModel.sendEvent(str, str2, str3, str4, z10, str5);
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final MainRepository getMainRepository() {
        return this.mainRepository;
    }

    public final void sendEvent(String roomId, String startDate, String endDate, String title, boolean allDay, String replyMsg) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(startDate, "startDate");
        kotlin.jvm.internal.y.i(endDate, "endDate");
        kotlin.jvm.internal.y.i(title, "title");
        long epochMilli = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).w(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long epochMilli2 = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).w(ZoneId.systemDefault()).toInstant().toEpochMilli();
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(roomId, new EventContent(title, createICS(title, allDay, epochMilli, epochMilli2), epochMilli, epochMilli2, allDay), replyMsg, null), 3, null);
    }
}
