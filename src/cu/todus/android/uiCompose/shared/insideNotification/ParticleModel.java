package cu.todus.android.uiCompose.shared.insideNotification;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcu/todus/android/uiCompose/shared/insideNotification/ParticleModel;", "", "verticalFraction", "", "horizontalFraction", "initialScale", TypedValues.TransitionType.S_DURATION, "", "emoji", "", "<init>", "(FFFILjava/lang/String;)V", "getVerticalFraction", "()F", "getHorizontalFraction", "getInitialScale", "getDuration", "()I", "getEmoji", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ParticleModel {
    public static final int $stable = 0;
    private final int duration;
    private final String emoji;
    private final float horizontalFraction;
    private final float initialScale;
    private final float verticalFraction;

    public ParticleModel(float f10, float f11, float f12, int i10, String emoji) {
        y.i(emoji, "emoji");
        this.verticalFraction = f10;
        this.horizontalFraction = f11;
        this.initialScale = f12;
        this.duration = i10;
        this.emoji = emoji;
    }

    public static /* synthetic */ ParticleModel copy$default(ParticleModel particleModel, float f10, float f11, float f12, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f10 = particleModel.verticalFraction;
        }
        if ((i11 & 2) != 0) {
            f11 = particleModel.horizontalFraction;
        }
        if ((i11 & 4) != 0) {
            f12 = particleModel.initialScale;
        }
        if ((i11 & 8) != 0) {
            i10 = particleModel.duration;
        }
        if ((i11 & 16) != 0) {
            str = particleModel.emoji;
        }
        String str2 = str;
        float f13 = f12;
        return particleModel.copy(f10, f11, f13, i10, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getVerticalFraction() {
        return this.verticalFraction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getHorizontalFraction() {
        return this.horizontalFraction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getInitialScale() {
        return this.initialScale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEmoji() {
        return this.emoji;
    }

    public final ParticleModel copy(float verticalFraction, float horizontalFraction, float initialScale, int duration, String emoji) {
        y.i(emoji, "emoji");
        return new ParticleModel(verticalFraction, horizontalFraction, initialScale, duration, emoji);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParticleModel)) {
            return false;
        }
        ParticleModel particleModel = (ParticleModel) other;
        return Float.compare(this.verticalFraction, particleModel.verticalFraction) == 0 && Float.compare(this.horizontalFraction, particleModel.horizontalFraction) == 0 && Float.compare(this.initialScale, particleModel.initialScale) == 0 && this.duration == particleModel.duration && y.d(this.emoji, particleModel.emoji);
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final float getHorizontalFraction() {
        return this.horizontalFraction;
    }

    public final float getInitialScale() {
        return this.initialScale;
    }

    public final float getVerticalFraction() {
        return this.verticalFraction;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.verticalFraction) * 31) + Float.floatToIntBits(this.horizontalFraction)) * 31) + Float.floatToIntBits(this.initialScale)) * 31) + this.duration) * 31) + this.emoji.hashCode();
    }

    public String toString() {
        return "ParticleModel(verticalFraction=" + this.verticalFraction + ", horizontalFraction=" + this.horizontalFraction + ", initialScale=" + this.initialScale + ", duration=" + this.duration + ", emoji=" + this.emoji + ")";
    }
}
