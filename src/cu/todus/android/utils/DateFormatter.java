package cu.todus.android.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcu/todus/android/utils/DateFormatter;", "", "<init>", "()V", "Formatter", "Template", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DateFormatter {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007J\n\u0010\u001c\u001a\u00020\u0007*\u00020\f¨\u0006\u001d"}, d2 = {"Lcu/todus/android/utils/DateFormatter$Companion;", "", "<init>", "()V", "getYMDFormat", "", "actualTime", "", "separator", "getHMFormat", "format", "date", "Ljava/util/Date;", "template", "Lcu/todus/android/utils/DateFormatter$Template;", "isSameDay", "", "date1", "date2", "cal1", "Ljava/util/Calendar;", "cal2", "isSameYear", "isToday", "calendar", "isYesterday", "isCurrentYear", "prettyFormatter", "getDaysDifference", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public static /* synthetic */ String getHMFormat$default(Companion companion, long j10, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            return companion.getHMFormat(j10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String getHMFormat$lambda$0(Calendar calendar) {
            int i10 = calendar.get(11);
            if (i10 >= 10) {
                return String.valueOf(i10);
            }
            return "0" + i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String getHMFormat$lambda$1(Calendar calendar) {
            int i10 = calendar.get(12);
            if (i10 >= 10) {
                return String.valueOf(i10);
            }
            return "0" + i10;
        }

        public static /* synthetic */ String getYMDFormat$default(Companion companion, long j10, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            return companion.getYMDFormat(j10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String getYMDFormat$lambda$0(Calendar calendar) {
            int i10 = calendar.get(5);
            if (i10 >= 10) {
                return String.valueOf(i10);
            }
            return "0" + i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String getYMDFormat$lambda$1(Calendar calendar) {
            int i10 = calendar.get(2) + 1;
            if (i10 >= 10) {
                return String.valueOf(i10);
            }
            return "0" + i10;
        }

        public final String format(Date date, Template template) {
            y.i(date, "date");
            y.i(template, "template");
            return format(date, template.getTemplate());
        }

        public final long getDaysDifference(Date date) {
            y.i(date, "<this>");
            return (new Date().getTime() - date.getTime()) / ((long) 86400000);
        }

        public final String getHMFormat(long actualTime, String separator) {
            y.i(separator, "separator");
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(actualTime));
            lb.a aVar = new lb.a() { // from class: cu.todus.android.utils.c
                @Override // lb.a
                public final Object invoke() {
                    return DateFormatter.Companion.getHMFormat$lambda$0(calendar);
                }
            };
            lb.a aVar2 = new lb.a() { // from class: cu.todus.android.utils.d
                @Override // lb.a
                public final Object invoke() {
                    return DateFormatter.Companion.getHMFormat$lambda$1(calendar);
                }
            };
            return aVar.invoke() + separator + aVar2.invoke();
        }

        public final String getYMDFormat(long actualTime, String separator) {
            y.i(separator, "separator");
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(actualTime));
            lb.a aVar = new lb.a() { // from class: cu.todus.android.utils.a
                @Override // lb.a
                public final Object invoke() {
                    return DateFormatter.Companion.getYMDFormat$lambda$0(calendar);
                }
            };
            lb.a aVar2 = new lb.a() { // from class: cu.todus.android.utils.b
                @Override // lb.a
                public final Object invoke() {
                    return DateFormatter.Companion.getYMDFormat$lambda$1(calendar);
                }
            };
            return calendar.get(1) + separator + aVar2.invoke() + separator + aVar.invoke();
        }

        public final boolean isCurrentYear(Date date) {
            y.i(date, "date");
            return isSameYear(date, Calendar.getInstance().getTime());
        }

        public final boolean isSameDay(Date date1, Date date2) {
            if (date1 == null || date2 == null) {
                throw new IllegalArgumentException("Dates must not be null");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return isSameDay(calendar, calendar2);
        }

        public final boolean isSameYear(Date date1, Date date2) {
            if (date1 == null || date2 == null) {
                throw new IllegalArgumentException("Dates must not be null");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return isSameYear(calendar, calendar2);
        }

        public final boolean isToday(Calendar calendar) {
            y.i(calendar, "calendar");
            return isSameDay(calendar, Calendar.getInstance());
        }

        public final boolean isYesterday(Calendar calendar) {
            y.i(calendar, "calendar");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(5, -1);
            return isSameDay(calendar, calendar2);
        }

        public final String prettyFormatter(Date date) {
            y.i(date, "date");
            String strE = new ph.e(Locale.getDefault()).e(date);
            y.h(strE, "format(...)");
            return strE;
        }

        private Companion() {
        }

        public final String format(Date date, String format) {
            y.i(format, "format");
            if (date == null) {
                return "";
            }
            String str = new SimpleDateFormat(format, Locale.getDefault()).format(date);
            y.h(str, "format(...)");
            return str;
        }

        public final boolean isCurrentYear(Calendar calendar) {
            y.i(calendar, "calendar");
            return isSameYear(calendar, Calendar.getInstance());
        }

        public final boolean isToday(Date date) {
            y.i(date, "date");
            return isSameDay(date, Calendar.getInstance().getTime());
        }

        public final String prettyFormatter(long date) {
            String strE = new ph.e(Locale.getDefault()).e(new Date(date));
            y.h(strE, "format(...)");
            return strE;
        }

        public final boolean isYesterday(Date date) {
            y.i(date, "date");
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -1);
            return isSameDay(date, calendar.getTime());
        }

        public final boolean isSameDay(Calendar cal1, Calendar cal2) {
            if (cal1 == null || cal2 == null) {
                throw new IllegalArgumentException("Dates must not be null");
            }
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        }

        public final boolean isSameYear(Calendar cal1, Calendar cal2) {
            if (cal1 == null || cal2 == null) {
                throw new IllegalArgumentException("Dates must not be null");
            }
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcu/todus/android/utils/DateFormatter$Formatter;", "", "format", "", "date", "Ljava/util/Date;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Formatter {
        String format(Date date);
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcu/todus/android/utils/DateFormatter$Template;", "", "template", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "STRING_DAY_MONTH_YEAR", "STRING_DAY_MONTH", "STRING_TIME_DAY_MONTH", "STRING_TIME_DAY_MONTH_12", "STRING_TIME_DAY_MONTH_YEAR", "STRING_TIME_DAY_MONTH_YEAR_12", "TIME", "TIME_12", "STRING_DATE_DAY", "STRING_DATE_TIME_24", "STRING_DATE_TIME_12", "STRING_YOUR_DATE_TIME_24", "STRING_YOUR_DATE_TIME_12", "get", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Template {
        STRING_DAY_MONTH_YEAR("d MMMM yyyy"),
        STRING_DAY_MONTH("d MMMM"),
        STRING_TIME_DAY_MONTH("d/MMMM HH:mm"),
        STRING_TIME_DAY_MONTH_12("d/MMMM hh:mm a"),
        STRING_TIME_DAY_MONTH_YEAR("d/MMMM/yyyy HH:mm"),
        STRING_TIME_DAY_MONTH_YEAR_12("d/MMMM/yyyy hh:mm a"),
        TIME("HH:mm"),
        TIME_12("hh:mm a"),
        STRING_DATE_DAY("EE, d MMM"),
        STRING_DATE_TIME_24("HH:mm"),
        STRING_DATE_TIME_12("hh:mm a"),
        STRING_YOUR_DATE_TIME_24("d/MM/yyyy HH:mm\n(zzzz Z)"),
        STRING_YOUR_DATE_TIME_12("d/MM/yyyy hh:mm a\n(zzzz Z)");

        private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());
        private final String template;

        Template(String str) {
            this.template = str;
        }

        public static db.a getEntries() {
            return $ENTRIES;
        }

        /* JADX INFO: renamed from: get, reason: from getter */
        public final String getTemplate() {
            return this.template;
        }
    }

    private DateFormatter() {
        throw new AssertionError();
    }
}
