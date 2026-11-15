package cu.todus.android.constants;

/**
 * Media/attachment type constants and WorkManager data keys for cloud uploads and downloads.
 *
 * @obfuscated_class cu.todus.android.constants.CloudType
 */
public final class CloudType {
    public static final int TYPE_FILE = 0;
    public static final int TYPE_VOICE = 1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_VIDEO = 3;
    public static final int TYPE_PICTURE = 4;
    public static final int TYPE_PROFILE = 5;
    public static final int TYPE_PROFILE_THUMBNAIL = 6;
    public static final int TYPE_PRODUCT = 7;
    public static final int TYPE_BACKUP = 8;
    public static final int TYPE_NEWS = 9;
    public static final int TYPE_STREAM_VIDEO = 10;
    public static final int TYPE_STATUS_IMAGE = 11;

    public static final String WORKER_DOWNLOAD_ATTACHMENT_ID = "d_at_id";
    public static final String WORKER_DOWNLOAD_FILE_PATH = "d_filePath";
    public static final String WORKER_DOWNLOAD_URL = "d_url";
    public static final String WORKER_NOTIFICATION = "notification";
    public static final String WORKER_PROGRESS = "progress";
    public static final String WORKER_UPLOAD_FILE_PATH = "u_filePath";
    public static final String WORKER_UPLOAD_ITEM_ID = "u_at_id";
    public static final String WORKER_UPLOAD_URL = "u_url";

    public CloudType() {
    }
}
