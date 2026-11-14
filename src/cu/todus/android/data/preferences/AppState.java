package cu.todus.android.data.preferences;

import androidx.compose.runtime.Immutable;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\bHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcu/todus/android/data/preferences/AppState;", "", "appStep", "Lcu/todus/android/data/preferences/AppStateStep;", "savedNumber", "", "clientUid", "countryCode", "", "lastTimeSmsWaSent", "", "<init>", "(Lcu/todus/android/data/preferences/AppStateStep;Ljava/lang/String;Ljava/lang/String;IJ)V", "getAppStep", "()Lcu/todus/android/data/preferences/AppStateStep;", "getSavedNumber", "()Ljava/lang/String;", "getClientUid", "getCountryCode", "()I", "getLastTimeSmsWaSent", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AppState {
    public static final int $stable = 0;
    private final AppStateStep appStep;
    private final String clientUid;
    private final int countryCode;
    private final long lastTimeSmsWaSent;
    private final String savedNumber;

    public AppState() {
        this(null, null, null, 0, 0L, 31, null);
    }

    public static /* synthetic */ AppState copy$default(AppState appState, AppStateStep appStateStep, String str, String str2, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            appStateStep = appState.appStep;
        }
        if ((i11 & 2) != 0) {
            str = appState.savedNumber;
        }
        if ((i11 & 4) != 0) {
            str2 = appState.clientUid;
        }
        if ((i11 & 8) != 0) {
            i10 = appState.countryCode;
        }
        if ((i11 & 16) != 0) {
            j10 = appState.lastTimeSmsWaSent;
        }
        long j11 = j10;
        return appState.copy(appStateStep, str, str2, i10, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AppStateStep getAppStep() {
        return this.appStep;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSavedNumber() {
        return this.savedNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClientUid() {
        return this.clientUid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLastTimeSmsWaSent() {
        return this.lastTimeSmsWaSent;
    }

    public final AppState copy(AppStateStep appStep, String savedNumber, String clientUid, int countryCode, long lastTimeSmsWaSent) {
        y.i(appStep, "appStep");
        y.i(savedNumber, "savedNumber");
        y.i(clientUid, "clientUid");
        return new AppState(appStep, savedNumber, clientUid, countryCode, lastTimeSmsWaSent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppState)) {
            return false;
        }
        AppState appState = (AppState) other;
        return this.appStep == appState.appStep && y.d(this.savedNumber, appState.savedNumber) && y.d(this.clientUid, appState.clientUid) && this.countryCode == appState.countryCode && this.lastTimeSmsWaSent == appState.lastTimeSmsWaSent;
    }

    public final AppStateStep getAppStep() {
        return this.appStep;
    }

    public final String getClientUid() {
        return this.clientUid;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final long getLastTimeSmsWaSent() {
        return this.lastTimeSmsWaSent;
    }

    public final String getSavedNumber() {
        return this.savedNumber;
    }

    public int hashCode() {
        return (((((((this.appStep.hashCode() * 31) + this.savedNumber.hashCode()) * 31) + this.clientUid.hashCode()) * 31) + this.countryCode) * 31) + l.a(this.lastTimeSmsWaSent);
    }

    public String toString() {
        return "AppState(appStep=" + this.appStep + ", savedNumber=" + this.savedNumber + ", clientUid=" + this.clientUid + ", countryCode=" + this.countryCode + ", lastTimeSmsWaSent=" + this.lastTimeSmsWaSent + ")";
    }

    public AppState(AppStateStep appStep, String savedNumber, String clientUid, int i10, long j10) {
        y.i(appStep, "appStep");
        y.i(savedNumber, "savedNumber");
        y.i(clientUid, "clientUid");
        this.appStep = appStep;
        this.savedNumber = savedNumber;
        this.clientUid = clientUid;
        this.countryCode = i10;
        this.lastTimeSmsWaSent = j10;
    }

    public /* synthetic */ AppState(AppStateStep appStateStep, String str, String str2, int i10, long j10, int i11, p pVar) {
        this((i11 & 1) != 0 ? AppStateStep.NEW_USER : appStateStep, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 53 : i10, (i11 & 16) != 0 ? 0L : j10);
    }
}
