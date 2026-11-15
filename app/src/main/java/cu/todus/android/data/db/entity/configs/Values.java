package cu.todus.android.data.db.entity.configs;

/**
 * Embedded notification configuration values (alert flag, sound URI, priority, LED color).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.configs.Values
 */
public final class Values {

    private final boolean alert;
    private final String sound;
    private final int priority;
    private final int color;

    public Values(boolean alert, String sound, int priority, int color) {
        this.alert = alert;
        this.sound = sound;
        this.priority = priority;
        this.color = color;
    }

    public boolean getAlert() {
        return alert;
    }

    public String getSound() {
        return sound;
    }

    public int getPriority() {
        return priority;
    }

    public int getColor() {
        return color;
    }
}
