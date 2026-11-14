package cu.z17.views.picturesAlbum.util;

import ab.e;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.os.BundleKt;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import cu.z17.views.picturesAlbum.data.AlbumImage;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a&\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\t\u0010\u0006\"\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "", "limit", "offset", "Landroid/database/Cursor;", "createCursor", "(Landroid/content/Context;IILab/e;)Ljava/lang/Object;", "", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "fetchPagePicture", "", "", "projection", "[Ljava/lang/String;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MediaLoaderKt {
    private static final String[] projection = {"_id", "_display_name", "datetaken", "bucket_display_name"};

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.util.MediaLoaderKt$createCursor$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.util.MediaLoaderKt$createCursor$2", f = "MediaLoader.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/database/Cursor;", "<anonymous>", "(Lpe/m0;)Landroid/database/Cursor;"}, k = 3, mv = {2, 2, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        final /* synthetic */ Context $this_createCursor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i10, int i11, Context context, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$offset = i10;
            this.$limit = i11;
            this.$this_createCursor = context;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$offset, this.$limit, this.$this_createCursor, eVar);
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
                    return this.$this_createCursor.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaLoaderKt.projection, BundleKt.bundleOf(z.a("android:query-arg-offset", cb.b.d(this.$offset)), z.a("android:query-arg-limit", cb.b.d(this.$limit)), z.a("android:query-arg-sort-columns", new String[]{"date_added"}), z.a("android:query-arg-sort-direction", cb.b.d(1))), null);
                }
                return this.$this_createCursor.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaLoaderKt.projection, null, null, "date_added DESC LIMIT " + this.$limit + " OFFSET " + this.$offset, null);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Cursor> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.util.MediaLoaderKt$fetchPagePicture$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.util.MediaLoaderKt", f = "MediaLoader.kt", l = {56}, m = "fetchPagePicture")
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
            return MediaLoaderKt.fetchPagePicture(null, 0, 0, this);
        }
    }

    public static final Object createCursor(Context context, int i10, int i11, e<? super Cursor> eVar) {
        return i.g(d1.b(), new AnonymousClass2(i11, i10, context, null), eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public static final Object fetchPagePicture(Context context, int i10, int i11, e<? super List<AlbumImage>> eVar) {
        AnonymousClass1 anonymousClass1;
        ArrayList arrayList;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i12 = anonymousClass1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i12 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object obj = anonymousClass1.result;
        Object objG = b.g();
        int i13 = anonymousClass1.label;
        try {
            if (i13 == 0) {
                v.b(obj);
                ArrayList arrayList2 = new ArrayList();
                anonymousClass1.L$0 = l.a(context);
                anonymousClass1.L$1 = arrayList2;
                anonymousClass1.I$0 = i10;
                anonymousClass1.I$1 = i11;
                anonymousClass1.label = 1;
                Object objCreateCursor = createCursor(context, i10, i11, anonymousClass1);
                if (objCreateCursor == objG) {
                    return objG;
                }
                obj = objCreateCursor;
                arrayList = arrayList2;
            } else {
                if (i13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (ArrayList) anonymousClass1.L$1;
                v.b(obj);
            }
            Cursor cursor = (Cursor) obj;
            if (cursor != null) {
                try {
                    String[] strArr = projection;
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow(strArr[0]);
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(strArr[1]);
                    int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(strArr[2]);
                    int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(strArr[3]);
                    while (cursor.moveToNext()) {
                        long j10 = cursor.getLong(columnIndexOrThrow);
                        long j11 = cursor.getLong(columnIndexOrThrow3);
                        String string = cursor.getString(columnIndexOrThrow2);
                        Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j10);
                        y.h(uriWithAppendedId, "withAppendedId(...)");
                        arrayList.add(new AlbumImage(uriWithAppendedId, cb.b.e(j11), string, cb.b.e(j10), cursor.getString(columnIndexOrThrow4).toString()));
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
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
