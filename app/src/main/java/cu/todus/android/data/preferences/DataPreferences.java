package cu.todus.android.data.preferences;

import java.util.Objects;

/**
 * Media auto-download, public visibility, battery mode, and upload format/quality preferences.
 *
 * @obfuscated_class cu.todus.android.data.preferences.DataPreferences
 */
public final class DataPreferences {
    public static final String CON_BALANCED = "BALANCED";
    public static final String CON_ECO = "ECO";
    public static final String CON_FULL_TIME = "FULL_TIME";

    private final boolean publicImages;
    private final boolean publicVideos;
    private final boolean publicAudios;
    private final boolean publicVoice;
    private final boolean publicFiles;
    private final boolean autoDownloadImages;
    private final boolean autoDownloadVideos;
    private final boolean autoDownloadAudios;
    private final boolean autoDownloadVoice;
    private final boolean autoDownloadFiles;
    private final String batteryPreference;
    private final int uploadQuality;
    private final String defaultFormat;

    public DataPreferences() {
        this(false, false, true, false, true, false, false, false, true, false, CON_BALANCED, 2, "webp");
    }

    public DataPreferences(
            boolean publicImages,
            boolean publicVideos,
            boolean publicAudios,
            boolean publicVoice,
            boolean publicFiles,
            boolean autoDownloadImages,
            boolean autoDownloadVideos,
            boolean autoDownloadAudios,
            boolean autoDownloadVoice,
            boolean autoDownloadFiles,
            String batteryPreference,
            int uploadQuality,
            String defaultFormat) {
        this.publicImages = publicImages;
        this.publicVideos = publicVideos;
        this.publicAudios = publicAudios;
        this.publicVoice = publicVoice;
        this.publicFiles = publicFiles;
        this.autoDownloadImages = autoDownloadImages;
        this.autoDownloadVideos = autoDownloadVideos;
        this.autoDownloadAudios = autoDownloadAudios;
        this.autoDownloadVoice = autoDownloadVoice;
        this.autoDownloadFiles = autoDownloadFiles;
        this.batteryPreference = Objects.requireNonNull(batteryPreference, "batteryPreference");
        this.uploadQuality = uploadQuality;
        this.defaultFormat = Objects.requireNonNull(defaultFormat, "defaultFormat");
    }

    public boolean getPublicImages() {
        return this.publicImages;
    }

    public boolean getPublicVideos() {
        return this.publicVideos;
    }

    public boolean getPublicAudios() {
        return this.publicAudios;
    }

    public boolean getPublicVoice() {
        return this.publicVoice;
    }

    public boolean getPublicFiles() {
        return this.publicFiles;
    }

    public boolean getAutoDownloadImages() {
        return this.autoDownloadImages;
    }

    public boolean getAutoDownloadVideos() {
        return this.autoDownloadVideos;
    }

    public boolean getAutoDownloadAudios() {
        return this.autoDownloadAudios;
    }

    public boolean getAutoDownloadVoice() {
        return this.autoDownloadVoice;
    }

    public boolean getAutoDownloadFiles() {
        return this.autoDownloadFiles;
    }

    public String getBatteryPreference() {
        return this.batteryPreference;
    }

    public int getUploadQuality() {
        return this.uploadQuality;
    }

    public String getDefaultFormat() {
        return this.defaultFormat;
    }

    public DataPreferences copy(
            boolean publicImages,
            boolean publicVideos,
            boolean publicAudios,
            boolean publicVoice,
            boolean publicFiles,
            boolean autoDownloadImages,
            boolean autoDownloadVideos,
            boolean autoDownloadAudios,
            boolean autoDownloadVoice,
            boolean autoDownloadFiles,
            String batteryPreference,
            int uploadQuality,
            String defaultFormat) {
        return new DataPreferences(
                publicImages,
                publicVideos,
                publicAudios,
                publicVoice,
                publicFiles,
                autoDownloadImages,
                autoDownloadVideos,
                autoDownloadAudios,
                autoDownloadVoice,
                autoDownloadFiles,
                Objects.requireNonNull(batteryPreference, "batteryPreference"),
                uploadQuality,
                Objects.requireNonNull(defaultFormat, "defaultFormat")
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPreferences)) {
            return false;
        }
        DataPreferences that = (DataPreferences) other;
        return this.publicImages == that.publicImages
                && this.publicVideos == that.publicVideos
                && this.publicAudios == that.publicAudios
                && this.publicVoice == that.publicVoice
                && this.publicFiles == that.publicFiles
                && this.autoDownloadImages == that.autoDownloadImages
                && this.autoDownloadVideos == that.autoDownloadVideos
                && this.autoDownloadAudios == that.autoDownloadAudios
                && this.autoDownloadVoice == that.autoDownloadVoice
                && this.autoDownloadFiles == that.autoDownloadFiles
                && Objects.equals(this.batteryPreference, that.batteryPreference)
                && this.uploadQuality == that.uploadQuality
                && Objects.equals(this.defaultFormat, that.defaultFormat);
    }

    @Override
    public int hashCode() {
        return (((((((((((((((((((((((Boolean.hashCode(this.publicImages) * 31)
                + Boolean.hashCode(this.publicVideos)) * 31)
                + Boolean.hashCode(this.publicAudios)) * 31)
                + Boolean.hashCode(this.publicVoice)) * 31)
                + Boolean.hashCode(this.publicFiles)) * 31)
                + Boolean.hashCode(this.autoDownloadImages)) * 31)
                + Boolean.hashCode(this.autoDownloadVideos)) * 31)
                + Boolean.hashCode(this.autoDownloadAudios)) * 31)
                + Boolean.hashCode(this.autoDownloadVoice)) * 31)
                + Boolean.hashCode(this.autoDownloadFiles)) * 31)
                + this.batteryPreference.hashCode()) * 31)
                + this.uploadQuality) * 31)
                + this.defaultFormat.hashCode();
    }

    @Override
    public String toString() {
        return "DataPreferences(publicImages=" + this.publicImages
                + ", publicVideos=" + this.publicVideos
                + ", publicAudios=" + this.publicAudios
                + ", publicVoice=" + this.publicVoice
                + ", publicFiles=" + this.publicFiles
                + ", autoDownloadImages=" + this.autoDownloadImages
                + ", autoDownloadVideos=" + this.autoDownloadVideos
                + ", autoDownloadAudios=" + this.autoDownloadAudios
                + ", autoDownloadVoice=" + this.autoDownloadVoice
                + ", autoDownloadFiles=" + this.autoDownloadFiles
                + ", batteryPreference=" + this.batteryPreference
                + ", uploadQuality=" + this.uploadQuality
                + ", defaultFormat=" + this.defaultFormat + ")";
    }
}
