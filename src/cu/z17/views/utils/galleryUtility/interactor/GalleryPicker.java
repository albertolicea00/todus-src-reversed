package cu.z17.views.utils.galleryUtility.interactor;

import ab.e;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.BundleKt;
import cb.b;
import cu.z17.views.utils.galleryUtility.GalleryImage;
import cu.z17.views.utils.galleryUtility.GalleryVideo;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ0\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\rj\b\u0012\u0004\u0012\u00020\u0012`\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0013\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcu/z17/views/utils/galleryUtility/interactor/GalleryPicker;", "", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "", "isReadWritePermitted2", "()Z", "isReadWritePermitted", "", "limit", "offset", "Ljava/util/ArrayList;", "Lcu/z17/views/utils/galleryUtility/GalleryImage;", "Lkotlin/collections/ArrayList;", "getImages", "(IILab/e;)Ljava/lang/Object;", "Lcu/z17/views/utils/galleryUtility/GalleryVideo;", "getVideos", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "setCtx", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GalleryPicker {
    public static final int $stable = 8;
    private Context ctx;

    public GalleryPicker(Context ctx) {
        y.i(ctx, "ctx");
        this.ctx = ctx;
    }

    private final boolean isReadWritePermitted() {
        return true;
    }

    private final boolean isReadWritePermitted2() {
        return this.ctx.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.ctx.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public final Context getCtx() {
        return this.ctx;
    }

    public final Object getImages(int i10, int i11, e<? super ArrayList<GalleryImage>> eVar) {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (isReadWritePermitted()) {
                    String[] strArr = {"_id", "_data", "date_added", "date_modified", "_display_name", "height", "mime_type", "_size", "title", "width", "bucket_display_name", "bucket_id", "datetaken", "description", "isprivate", "latitude", "longitude", "mini_thumb_magic", "orientation", "picasa_id"};
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    if (Build.VERSION.SDK_INT >= 29) {
                        cursorQuery = this.ctx.getContentResolver().query(uri, strArr, BundleKt.bundleOf(z.a("android:query-arg-offset", b.d(i11)), z.a("android:query-arg-limit", b.d(i10)), z.a("android:query-arg-sort-columns", new String[]{"date_added"}), z.a("android:query-arg-sort-direction", b.d(1))), null);
                    } else {
                        cursorQuery = this.ctx.getContentResolver().query(uri, strArr, null, null, "date_added DESC LIMIT " + i10 + " OFFSET " + i11, null);
                    }
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                GalleryImage galleryImage = new GalleryImage(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
                                galleryImage.setID(cursorQuery.getString(cursorQuery.getColumnIndex("_id")));
                                galleryImage.setDATA(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                                galleryImage.setDATE_ADDED(cursorQuery.getString(cursorQuery.getColumnIndex("date_added")));
                                galleryImage.setDATE_MODIFIED(cursorQuery.getString(cursorQuery.getColumnIndex("date_modified")));
                                galleryImage.setDISPLAY_NAME(cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
                                galleryImage.setHEIGHT(cursorQuery.getString(cursorQuery.getColumnIndex("height")));
                                galleryImage.setMIME_TYPE(cursorQuery.getString(cursorQuery.getColumnIndex("mime_type")));
                                galleryImage.setSIZE(cursorQuery.getString(cursorQuery.getColumnIndex("_size")));
                                galleryImage.setTITLE(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                                galleryImage.setWIDTH(cursorQuery.getString(cursorQuery.getColumnIndex("width")));
                                galleryImage.setBUCKET_DISPLAY_NAME(cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name")));
                                galleryImage.setBUCKET_ID(cursorQuery.getString(cursorQuery.getColumnIndex("bucket_id")));
                                galleryImage.setDATE_TAKEN(cursorQuery.getString(cursorQuery.getColumnIndex("datetaken")));
                                galleryImage.setDESCRIPTION(cursorQuery.getString(cursorQuery.getColumnIndex("description")));
                                galleryImage.setIS_PRIVATE(cursorQuery.getString(cursorQuery.getColumnIndex("isprivate")));
                                galleryImage.setLATITUDE(cursorQuery.getString(cursorQuery.getColumnIndex("latitude")));
                                galleryImage.setLONGITUDE(cursorQuery.getString(cursorQuery.getColumnIndex("longitude")));
                                galleryImage.setMINI_THUMB_MAGIC(cursorQuery.getString(cursorQuery.getColumnIndex("mini_thumb_magic")));
                                galleryImage.setORIENTATION(cursorQuery.getString(cursorQuery.getColumnIndex("orientation")));
                                galleryImage.setPICASA_ID(cursorQuery.getString(cursorQuery.getColumnIndex("picasa_id")));
                                galleryImage.setALBUM_NAME(new File(galleryImage.getDATA()).getParentFile().getName());
                                arrayList.add(galleryImage);
                            } while (cursorQuery.moveToNext());
                        }
                        cursorQuery.close();
                        return arrayList;
                    }
                }
            } catch (Exception e10) {
                Log.e("IMAGES", e10.toString());
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public final Object getVideos(int i10, int i11, e<? super ArrayList<GalleryVideo>> eVar) {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (isReadWritePermitted()) {
                    String[] strArr = {"_id", "_data", "date_added", "date_modified", "_display_name", "height", "mime_type", "_size", "title", "width", "album", "artist", "bookmark", "bucket_display_name", "bucket_id", "category", "datetaken", "description", TypedValues.TransitionType.S_DURATION, "isprivate", "language", "latitude", "longitude", "mini_thumb_magic", "resolution", "tags"};
                    Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    if (Build.VERSION.SDK_INT >= 29) {
                        cursorQuery = this.ctx.getContentResolver().query(uri, strArr, BundleKt.bundleOf(z.a("android:query-arg-offset", b.d(i11)), z.a("android:query-arg-limit", b.d(i10)), z.a("android:query-arg-sort-columns", new String[]{"date_added"}), z.a("android:query-arg-sort-direction", b.d(1))), null);
                    } else {
                        cursorQuery = this.ctx.getContentResolver().query(uri, strArr, null, null, "date_added DESC LIMIT " + i10 + " OFFSET " + i11, null);
                    }
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                GalleryVideo galleryVideo = new GalleryVideo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
                                galleryVideo.setID(cursorQuery.getString(cursorQuery.getColumnIndex("_id")));
                                galleryVideo.setDATA(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                                galleryVideo.setDATE_ADDED(cursorQuery.getString(cursorQuery.getColumnIndex("date_added")));
                                galleryVideo.setDATE_MODIFIED(cursorQuery.getString(cursorQuery.getColumnIndex("date_modified")));
                                galleryVideo.setDISPLAY_NAME(cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
                                galleryVideo.setHEIGHT(cursorQuery.getString(cursorQuery.getColumnIndex("height")));
                                galleryVideo.setMIME_TYPE(cursorQuery.getString(cursorQuery.getColumnIndex("mime_type")));
                                galleryVideo.setSIZE(cursorQuery.getString(cursorQuery.getColumnIndex("_size")));
                                galleryVideo.setTITLE(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                                galleryVideo.setWIDTH(cursorQuery.getString(cursorQuery.getColumnIndex("width")));
                                galleryVideo.setALBUM(cursorQuery.getString(cursorQuery.getColumnIndex("album")));
                                galleryVideo.setARTIST(cursorQuery.getString(cursorQuery.getColumnIndex("artist")));
                                galleryVideo.setBOOKMARK(cursorQuery.getString(cursorQuery.getColumnIndex("bookmark")));
                                galleryVideo.setBUCKET_DISPLAY_NAME(cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name")));
                                galleryVideo.setBUCKET_ID(cursorQuery.getString(cursorQuery.getColumnIndex("bucket_id")));
                                galleryVideo.setCATEGORY(cursorQuery.getString(cursorQuery.getColumnIndex("category")));
                                galleryVideo.setDATE_TAKEN(cursorQuery.getString(cursorQuery.getColumnIndex("datetaken")));
                                galleryVideo.setDESCRIPTION(cursorQuery.getString(cursorQuery.getColumnIndex("description")));
                                galleryVideo.setDURATION(cursorQuery.getString(cursorQuery.getColumnIndex(TypedValues.TransitionType.S_DURATION)));
                                galleryVideo.setIS_PRIVATE(cursorQuery.getString(cursorQuery.getColumnIndex("isprivate")));
                                galleryVideo.setLANGUAGE(cursorQuery.getString(cursorQuery.getColumnIndex("language")));
                                galleryVideo.setLATITUDE(cursorQuery.getString(cursorQuery.getColumnIndex("latitude")));
                                galleryVideo.setLONGITUDE(cursorQuery.getString(cursorQuery.getColumnIndex("longitude")));
                                galleryVideo.setMINI_THUMB_MAGIC(cursorQuery.getString(cursorQuery.getColumnIndex("mini_thumb_magic")));
                                galleryVideo.setRESOLUTION(cursorQuery.getString(cursorQuery.getColumnIndex("resolution")));
                                galleryVideo.setTAGS(cursorQuery.getString(cursorQuery.getColumnIndex("tags")));
                                galleryVideo.setALBUM_NAME(new File(galleryVideo.getDATA()).getParentFile().getName());
                                arrayList.add(galleryVideo);
                            } while (cursorQuery.moveToNext());
                        }
                        cursorQuery.close();
                        return arrayList;
                    }
                }
            } catch (Exception e10) {
                Log.e("VIDEOS", e10.toString());
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public final void setCtx(Context context) {
        y.i(context, "<set-?>");
        this.ctx = context;
    }
}
