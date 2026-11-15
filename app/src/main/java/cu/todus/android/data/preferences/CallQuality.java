package cu.todus.android.data.preferences;

/**
 * WebRTC call send and receive quality preference levels.
 *
 * @obfuscated_class cu.todus.android.data.preferences.CallQuality
 */
public final class CallQuality {
    private final int sendQuality;
    private final int receivingQuality;

    public CallQuality() {
        this(2, 2);
    }

    public CallQuality(int sendQuality, int receivingQuality) {
        this.sendQuality = sendQuality;
        this.receivingQuality = receivingQuality;
    }

    public int getSendQuality() {
        return this.sendQuality;
    }

    public int getReceivingQuality() {
        return this.receivingQuality;
    }

    public CallQuality copy(int sendQuality, int receivingQuality) {
        return new CallQuality(sendQuality, receivingQuality);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallQuality)) {
            return false;
        }
        CallQuality that = (CallQuality) other;
        return this.sendQuality == that.sendQuality && this.receivingQuality == that.receivingQuality;
    }

    @Override
    public int hashCode() {
        return (this.sendQuality * 31) + this.receivingQuality;
    }

    @Override
    public String toString() {
        return "CallQuality(sendQuality=" + this.sendQuality + ", receivingQuality=" + this.receivingQuality + ")";
    }
}
