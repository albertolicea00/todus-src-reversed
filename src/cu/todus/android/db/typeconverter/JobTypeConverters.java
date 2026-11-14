package cu.todus.android.db.typeconverter;

import androidx.room.TypeConverter;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public class JobTypeConverters {

    /* JADX INFO: renamed from: cu.todus.android.db.typeconverter.JobTypeConverters$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cu$todus$android$db$typeconverter$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$cu$todus$android$db$typeconverter$State = iArr;
            try {
                iArr[State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cu$todus$android$db$typeconverter$State[State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cu$todus$android$db$typeconverter$State[State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cu$todus$android$db$typeconverter$State[State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cu$todus$android$db$typeconverter$State[State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cu$todus$android$db$typeconverter$State[State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    @TypeConverter
    public static State intToState(int i10) {
        if (i10 == 0) {
            return State.ENQUEUED;
        }
        if (i10 == 1) {
            return State.RUNNING;
        }
        if (i10 == 2) {
            return State.SUCCEEDED;
        }
        if (i10 == 3) {
            return State.FAILED;
        }
        if (i10 == 4) {
            return State.BLOCKED;
        }
        if (i10 == 5) {
            return State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to State");
    }

    @TypeConverter
    public static int stateToInt(State state) {
        switch (AnonymousClass1.$SwitchMap$cu$todus$android$db$typeconverter$State[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }
}
