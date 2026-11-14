package cu.z17.views.videosAlbum.util;

import ab.e;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.BundleKt;
import bb.b;
import cb.d;
import cb.f;
import cb.m;
import cu.z17.views.videosAlbum.data.VideoAlbum;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.i;
import pe.m0;
import ua.k0;
import ua.v;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a&\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\t\u0010\u0006\"\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "", "limit", "offset", "Landroid/database/Cursor;", "createVideoCursor", "(Landroid/content/Context;IILab/e;)Ljava/lang/Object;", "", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "fetchPageVideo", "", "", "videoProjection", "[Ljava/lang/String;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoMediaLoaderKt {
    private static final String[] videoProjection = {"_id", "_display_name", "datetaken", "bucket_display_name", TypedValues.TransitionType.S_DURATION};

    /* JADX INFO: renamed from: cu.z17.views.videosAlbum.util.VideoMediaLoaderKt$createVideoCursor$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.videosAlbum.util.VideoMediaLoaderKt$createVideoCursor$2", f = "VideoMediaLoader.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lpe/m0;", "Landroid/database/Cursor;", "Lkotlin/jvm/internal/EnhancedNullability;", "<anonymous>", "(Lpe/m0;)Landroid/database/Cursor;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        final /* synthetic */ Context $this_createVideoCursor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i10, int i11, Context context, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$offset = i10;
            this.$limit = i11;
            this.$this_createVideoCursor = context;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$offset, this.$limit, this.$this_createVideoCursor, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    return this.$this_createVideoCursor.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, VideoMediaLoaderKt.videoProjection, BundleKt.bundleOf(z.a("android:query-arg-offset", cb.b.d(this.$offset)), z.a("android:query-arg-limit", cb.b.d(this.$limit)), z.a("android:query-arg-sort-columns", new String[]{"date_added"}), z.a("android:query-arg-sort-direction", cb.b.d(1))), null);
                }
                return this.$this_createVideoCursor.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, VideoMediaLoaderKt.videoProjection, null, null, "date_added DESC LIMIT " + this.$limit + " OFFSET " + this.$offset, null);
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Cursor> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.videosAlbum.util.VideoMediaLoaderKt$fetchPageVideo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.videosAlbum.util.VideoMediaLoaderKt", f = "VideoMediaLoader.kt", l = {RectListKt.BitOffsetForFocusable}, m = "fetchPageVideo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoMediaLoaderKt.fetchPageVideo(null, 0, 0, this);
        }
    }

    public static final Object createVideoCursor(Context context, int i10, int i11, e<? super Cursor> eVar) {
        return i.g(d1.b(), new AnonymousClass2(i11, i10, context, null), eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static final Object fetchPageVideo(Context context, int i10, int i11, e<? super List<VideoAlbum>> eVar) {
        AnonymousClass1 anonymousClass1;
        ArrayList arrayList;
        Object obj;
        Context context2;
        int i12;
        int i13;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i14 = anonymousClass1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i14 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object obj2 = anonymousClass1.result;
        Object objG = b.g();
        int i15 = anonymousClass1.label;
        try {
            if (i15 == 0) {
                v.b(obj2);
                arrayList = new ArrayList();
                anonymousClass1.L$0 = context;
                anonymousClass1.L$1 = arrayList;
                anonymousClass1.I$0 = i10;
                anonymousClass1.I$1 = i11;
                anonymousClass1.label = 1;
                Object objCreateVideoCursor = createVideoCursor(context, i10, i11, anonymousClass1);
                if (objCreateVideoCursor == objG) {
                    return objG;
                }
                obj = objCreateVideoCursor;
                context2 = context;
            } else {
                if (i15 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ArrayList arrayList2 = (ArrayList) anonymousClass1.L$1;
                context2 = (Context) anonymousClass1.L$0;
                v.b(obj2);
                obj = obj2;
                arrayList = arrayList2;
            }
            Cursor cursor = (Cursor) obj;
            if (cursor != null) {
                try {
                    try {
                        String[] strArr = videoProjection;
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(strArr[0]);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(strArr[1]);
                        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(strArr[2]);
                        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(strArr[3]);
                        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(strArr[4]);
                        while (cursor.moveToNext()) {
                            long j10 = cursor.getLong(columnIndexOrThrow);
                            long j11 = cursor.getLong(columnIndexOrThrow3);
                            String string = cursor.getString(columnIndexOrThrow2);
                            Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j10);
                            y.h(uriWithAppendedId, "withAppendedId(...)");
                            String string2 = cursor.getString(columnIndexOrThrow4);
                            long j12 = cursor.getLong(columnIndexOrThrow5);
                            if (j12 == 0) {
                                try {
                                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                    mediaMetadataRetriever.setDataSource(context2, uriWithAppendedId);
                                    i12 = columnIndexOrThrow;
                                    i13 = columnIndexOrThrow2;
                                    long j13 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                                    try {
                                        mediaMetadataRetriever.release();
                                        j12 = j13;
                                    } catch (Exception e10) {
                                        e = e10;
                                        j12 = j13;
                                        e.printStackTrace();
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    i12 = columnIndexOrThrow;
                                    i13 = columnIndexOrThrow2;
                                }
                            } else {
                                i12 = columnIndexOrThrow;
                                i13 = columnIndexOrThrow2;
                            }
                            arrayList.add(new VideoAlbum(uriWithAppendedId, cb.b.e(j11), string, cb.b.e(j10), string2.toString(), cb.b.e(j12), null, 64, null));
                            columnIndexOrThrow = i12;
                            columnIndexOrThrow2 = i13;
                        }
                        k0 k0Var = k0.f43947a;
                        c.a(cursor, null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            c.a(cursor, th2);
                            throw th3;
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e13) {
            e13.printStackTrace();
            return new ArrayList();
        }
    }
}
