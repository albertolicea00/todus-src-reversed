package cu.todus.android.xmpp.managers;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.container.MdtaMetadataEntry;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.user.UserDataSource;
import cu.todus.android.s3.upload.UploadDataSource;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import cu.todus.proto.ApiProto;
import cu.z17.compress.Compressor;
import cu.z17.compress.constraint.Compression;
import cu.z17.compress.constraint.ResolutionConstraintKt;
import cu.z17.compress.constraint.SizeConstraintKt;
import cu.z17.views.utils.Z17CoilDecoders;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import ua.k0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012*\u0010\u0011\u001a&\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u001c\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bH\u0086@¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b)\u0010%R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R;\u0010\u0011\u001a&\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcu/todus/android/xmpp/managers/ProfileManager;", "", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function1;", "Lua/k0;", "updateOwner", "", "canSend", "Landroid/content/Context;", "context", "Lkotlin/Function3;", "", "", "Lab/e;", "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "getPutUrl", "<init>", "(Llb/a;Lkotlin/jvm/functions/Function1;Llb/a;Landroid/content/Context;Lkotlin/jvm/functions/Function3;)V", ExtensionMention.TAG_OFFSET, "push", "(Lcu/todus/android/data/preferences/Owner;Lab/e;)Ljava/lang/Object;", "", User.COLUMN_ALIAS, "updateAlias", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "bio", "updateBio", "Landroid/net/Uri;", "imageUri", "updateProfileImage", "(Landroid/net/Uri;Lab/e;)Ljava/lang/Object;", "removeProfileImage", "(Lab/e;)Ljava/lang/Object;", "Llb/a;", "getOwner", "()Llb/a;", "Lkotlin/jvm/functions/Function1;", "getUpdateOwner", "()Lkotlin/jvm/functions/Function1;", "getCanSend", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/jvm/functions/Function3;", "getGetPutUrl", "()Lkotlin/jvm/functions/Function3;", "Lcu/todus/android/rest/user/UserDataSource;", "dataSourceUser", "Lcu/todus/android/rest/user/UserDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProfileManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final Context context;
    private final UserDataSource dataSourceUser;
    private final Function3 getPutUrl;
    private final lb.a owner;
    private final Function1 updateOwner;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ProfileManager$push$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ProfileManager", f = "ProfileManager.kt", l = {30}, m = "push", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.push(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ProfileManager$updateProfileImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ProfileManager", f = "ProfileManager.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, MdtaMetadataEntry.TYPE_INDICATOR_INT32, 73, 77, 83, 95, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 107, 113}, m = "updateProfileImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14901 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C14901(ab.e<? super C14901> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.updateProfileImage(null, this);
        }
    }

    public ProfileManager(lb.a owner, Function1 updateOwner, lb.a canSend, Context context, Function3 getPutUrl) {
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(updateOwner, "updateOwner");
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(getPutUrl, "getPutUrl");
        this.owner = owner;
        this.updateOwner = updateOwner;
        this.canSend = canSend;
        this.context = context;
        this.getPutUrl = getPutUrl;
        this.dataSourceUser = RetrofitModule.INSTANCE.getInstance().getUserDataSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object push(Owner owner, ab.e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
        Owner owner2;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objUpdateProfile = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        boolean z10 = false;
        if (i11 == 0) {
            ua.v.b(objUpdateProfile);
            UserDataSource userDataSource = this.dataSourceUser;
            ApiProto.ProtoUsersMeRequest protoUsersMeRequestBuild = ApiProto.ProtoUsersMeRequest.newBuilder().putAllUserInfo(w0.l(ua.z.a(User.COLUMN_ALIAS, owner.getAlias()), ua.z.a("description", owner.getInfo()), ua.z.a("picture_url", owner.getPhotoUrl()), ua.z.a(Room.CONFIG_PICTURE_THUMBNAIL, owner.getPhotoThumbnail()))).build();
            kotlin.jvm.internal.y.h(protoUsersMeRequestBuild, "build(...)");
            owner2 = owner;
            anonymousClass1.L$0 = owner2;
            anonymousClass1.label = 1;
            objUpdateProfile = userDataSource.updateProfile(protoUsersMeRequestBuild, anonymousClass1);
            if (objUpdateProfile == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Owner owner3 = (Owner) anonymousClass1.L$0;
            ua.v.b(objUpdateProfile);
            owner2 = owner3;
        }
        if (((DataWrapper) objUpdateProfile).getResponseOkButNull()) {
            this.updateOwner.invoke(Owner.copy$default(owner2, null, null, null, owner2.getVersion() + 1, null, null, null, null, null, 0L, null, 0, 4087, null));
            z10 = true;
        }
        return cb.b.a(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 updateProfileImage$lambda$0(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 updateProfileImage$lambda$1(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        SizeConstraintKt.size(compress, 64L, 10, 10);
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return k0.f43947a;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function3 getGetPutUrl() {
        return this.getPutUrl;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final Function1 getUpdateOwner() {
        return this.updateOwner;
    }

    public final Object removeProfileImage(ab.e<? super Boolean> eVar) {
        return push(Owner.copy$default((Owner) this.owner.invoke(), null, null, "", 0, null, "", null, null, null, 0L, null, 0, 4059, null), eVar);
    }

    public final Object updateAlias(String str, ab.e<? super Boolean> eVar) {
        return push(Owner.copy$default((Owner) this.owner.invoke(), null, str, null, 0, null, null, null, null, null, 0L, null, 0, 4093, null), eVar);
    }

    public final Object updateBio(String str, ab.e<? super Boolean> eVar) {
        return push(Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, str, null, null, null, null, 0L, null, 0, 4079, null), eVar);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:46:0x0223  */
    /* JADX WARN: Code duplicated, block: B:49:0x0231  */
    /* JADX WARN: Code duplicated, block: B:57:0x0278  */
    /* JADX WARN: Code duplicated, block: B:60:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:63:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:71:0x0332  */
    /* JADX WARN: Code duplicated, block: B:75:0x0382  */
    /* JADX WARN: Code duplicated, block: B:78:0x0391  */
    /* JADX WARN: Code duplicated, block: B:83:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:86:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x045f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:92:0x0468  */
    public final Object updateProfileImage(Uri uri, ab.e<? super Boolean> eVar) {
        C14901 c14901;
        Uri uri2;
        File file;
        Object bounds;
        u0 u0Var;
        Uri uri3;
        final Pair pair;
        u0 u0Var2;
        Object obj;
        Object objCompress$default;
        Uri uri4;
        File file2;
        Pair pair2;
        u0 u0Var3;
        File file3;
        Object objInvoke;
        File file4;
        Pair pair3;
        u0 u0Var4;
        FileResponse.FileResult fileResult;
        File file5;
        final Pair pair4;
        File file6;
        Uri uri5;
        FileResponse.FileResult fileResult2;
        Pair pair5;
        Uri uri6;
        File file7;
        u0 u0Var5;
        FileResponse.FileResult fileResult3;
        File file8;
        u0 u0Var6;
        int i10;
        Object objCompress$default2;
        FileResponse.FileResult fileResult4;
        File file9;
        File file10;
        Pair pair6;
        Uri uri7;
        u0 u0Var7;
        boolean zBooleanValue;
        File file11;
        Object objInvoke2;
        FileResponse.FileResult fileResult5;
        Uri uri8;
        File file12;
        Pair pair7;
        u0 u0Var8;
        File file13;
        File file14;
        File file15;
        int i11;
        FileResponse.FileResult fileResult6;
        Uri uri9;
        Object objDirectUpload;
        Uri uri10;
        FileResponse.FileResult fileResult7;
        u0 u0Var9;
        FileResponse.FileResult fileResult8;
        boolean zBooleanValue2;
        if (eVar instanceof C14901) {
            c14901 = (C14901) eVar;
            int i12 = c14901.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c14901.label = i12 - Integer.MIN_VALUE;
            } else {
                c14901 = new C14901(eVar);
            }
        } else {
            c14901 = new C14901(eVar);
        }
        C14901 c14902 = c14901;
        Object objPush = c14902.result;
        Object objG = bb.b.g();
        switch (c14902.label) {
            case 0:
                ua.v.b(objPush);
                try {
                    uri2 = uri;
                    try {
                        String path = MediaUtil.INSTANCE.getPath(this.context, uri2);
                        kotlin.jvm.internal.y.f(path);
                        file = new File(path);
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        file = null;
                    }
                } catch (Exception e11) {
                    e = e11;
                    uri2 = uri;
                }
                if (file == null) {
                    return cb.b.a(false);
                }
                u0 u0Var10 = new u0();
                File file16 = new File(uri2.getPath());
                c14902.L$0 = cb.l.a(uri2);
                c14902.L$1 = file;
                c14902.L$2 = u0Var10;
                c14902.label = 1;
                bounds = Z17InlineUtilsKt.getBounds(file16, c14902);
                if (bounds != objG) {
                    Uri uri11 = uri2;
                    u0Var = u0Var10;
                    uri3 = uri11;
                    pair = (Pair) bounds;
                    Compressor compressor = Compressor.INSTANCE;
                    Context context = this.context;
                    Function1 function1 = new Function1() { // from class: cu.todus.android.xmpp.managers.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ProfileManager.updateProfileImage$lambda$0(pair, (Compression) obj2);
                        }
                    };
                    c14902.L$0 = cb.l.a(uri3);
                    c14902.L$1 = file;
                    c14902.L$2 = u0Var;
                    c14902.L$3 = pair;
                    c14902.label = 2;
                    u0Var2 = u0Var;
                    obj = null;
                    objCompress$default = Compressor.compress$default(compressor, context, file, false, null, function1, c14902, 12, null);
                    if (objCompress$default != objG) {
                        uri4 = uri3;
                        objPush = objCompress$default;
                        file2 = file;
                        pair2 = pair;
                        u0Var3 = u0Var2;
                        file3 = (File) objPush;
                        Function3 function3 = this.getPutUrl;
                        Integer numD = cb.b.d(5);
                        Long lE = cb.b.e(file3.length());
                        c14902.L$0 = cb.l.a(uri4);
                        c14902.L$1 = file2;
                        c14902.L$2 = u0Var3;
                        c14902.L$3 = pair2;
                        c14902.L$4 = file3;
                        c14902.label = 3;
                        objInvoke = function3.invoke(numD, lE, c14902);
                        if (objInvoke != objG) {
                            file4 = file3;
                            objPush = objInvoke;
                            u0 u0Var11 = u0Var3;
                            pair3 = pair2;
                            u0Var4 = u0Var11;
                            fileResult = (FileResponse.FileResult) objPush;
                            if (fileResult != null || fileResult.getWasError()) {
                                file5 = file4;
                                pair4 = pair3;
                                file6 = file2;
                                uri5 = uri4;
                                Compressor compressor2 = Compressor.INSTANCE;
                                Context context2 = this.context;
                                Function1 function2 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                                    }
                                };
                                c14902.L$0 = cb.l.a(uri5);
                                c14902.L$1 = cb.l.a(file6);
                                c14902.L$2 = u0Var4;
                                c14902.L$3 = cb.l.a(pair4);
                                c14902.L$4 = cb.l.a(file5);
                                c14902.L$5 = cb.l.a(fileResult);
                                c14902.L$6 = obj;
                                c14902.label = 6;
                                u0Var6 = u0Var4;
                                i10 = 6;
                                objCompress$default2 = Compressor.compress$default(compressor2, context2, file6, false, null, function2, c14902, 12, null);
                                if (objCompress$default2 != objG) {
                                    fileResult4 = fileResult;
                                    objPush = objCompress$default2;
                                    file9 = file6;
                                    file10 = file5;
                                    pair6 = pair4;
                                    uri7 = uri5;
                                    u0Var7 = u0Var6;
                                    file11 = (File) objPush;
                                    Function3 function4 = this.getPutUrl;
                                    Integer numD2 = cb.b.d(i10);
                                    Long lE2 = cb.b.e(file11.length());
                                    c14902.L$0 = cb.l.a(uri7);
                                    c14902.L$1 = cb.l.a(file9);
                                    c14902.L$2 = u0Var7;
                                    c14902.L$3 = cb.l.a(pair6);
                                    c14902.L$4 = cb.l.a(file10);
                                    c14902.L$5 = cb.l.a(fileResult4);
                                    c14902.L$6 = cb.l.a(file11);
                                    c14902.L$7 = file11;
                                    c14902.I$0 = 0;
                                    c14902.label = 7;
                                    objInvoke2 = function4.invoke(numD2, lE2, c14902);
                                    if (objInvoke2 != objG) {
                                        Uri uri12 = uri7;
                                        fileResult5 = fileResult4;
                                        uri8 = uri12;
                                        file12 = file10;
                                        pair7 = pair6;
                                        u0Var8 = u0Var7;
                                        file13 = file9;
                                        file14 = file11;
                                        file15 = file14;
                                        objPush = objInvoke2;
                                        i11 = 0;
                                        fileResult6 = (FileResponse.FileResult) objPush;
                                        if (fileResult6 != null && !fileResult6.getWasError()) {
                                            UploadDataSource.Companion companion = UploadDataSource.INSTANCE;
                                            String path2 = file14.getPath();
                                            kotlin.jvm.internal.y.h(path2, "getPath(...)");
                                            String put = fileResult6.getPut();
                                            uri9 = uri8;
                                            c14902.L$0 = cb.l.a(uri9);
                                            c14902.L$1 = cb.l.a(file13);
                                            c14902.L$2 = u0Var8;
                                            c14902.L$3 = cb.l.a(pair7);
                                            c14902.L$4 = cb.l.a(file12);
                                            c14902.L$5 = cb.l.a(fileResult5);
                                            c14902.L$6 = cb.l.a(file15);
                                            c14902.L$7 = cb.l.a(file14);
                                            c14902.L$8 = fileResult6;
                                            c14902.L$9 = u0Var8;
                                            c14902.I$0 = i11;
                                            c14902.label = 8;
                                            objDirectUpload = companion.directUpload(put, path2, c14902);
                                            if (objDirectUpload != objG) {
                                                uri10 = uri9;
                                                fileResult7 = fileResult6;
                                                objPush = objDirectUpload;
                                                u0Var9 = u0Var8;
                                                u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                                if (u0Var9.f36629c) {
                                                    Owner ownerCopy$default = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                                    c14902.L$0 = cb.l.a(uri10);
                                                    c14902.L$1 = cb.l.a(file13);
                                                    c14902.L$2 = u0Var9;
                                                    c14902.L$3 = cb.l.a(pair7);
                                                    c14902.L$4 = cb.l.a(file12);
                                                    c14902.L$5 = cb.l.a(fileResult5);
                                                    c14902.L$6 = cb.l.a(file15);
                                                    c14902.L$7 = cb.l.a(file14);
                                                    c14902.L$8 = fileResult7;
                                                    c14902.L$9 = null;
                                                    c14902.I$0 = i11;
                                                    c14902.label = 9;
                                                    objPush = push(ownerCopy$default, c14902);
                                                    if (objPush != objG) {
                                                        fileResult8 = fileResult7;
                                                        zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                                        if (zBooleanValue2) {
                                                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                                        }
                                                        u0Var9.f36629c = zBooleanValue2;
                                                    }
                                                }
                                                u0Var8 = u0Var9;
                                            }
                                        }
                                        return cb.b.a(u0Var8.f36629c);
                                    }
                                }
                            } else {
                                UploadDataSource.Companion companion2 = UploadDataSource.INSTANCE;
                                String path3 = file4.getPath();
                                kotlin.jvm.internal.y.h(path3, "getPath(...)");
                                String put2 = fileResult.getPut();
                                c14902.L$0 = cb.l.a(uri4);
                                c14902.L$1 = file2;
                                c14902.L$2 = u0Var4;
                                c14902.L$3 = pair3;
                                c14902.L$4 = cb.l.a(file4);
                                c14902.L$5 = fileResult;
                                c14902.L$6 = u0Var4;
                                c14902.label = 4;
                                Object objDirectUpload2 = companion2.directUpload(put2, path3, c14902);
                                if (objDirectUpload2 != objG) {
                                    Pair pair8 = pair3;
                                    fileResult2 = fileResult;
                                    objPush = objDirectUpload2;
                                    pair5 = pair8;
                                    uri6 = uri4;
                                    file7 = file2;
                                    u0Var5 = u0Var4;
                                    u0Var4.f36629c = ((Boolean) objPush).booleanValue();
                                    if (u0Var5.f36629c) {
                                        Owner ownerCopy$default2 = Owner.copy$default((Owner) this.owner.invoke(), null, null, fileResult2.getGet(), 0, null, null, null, null, null, 0L, null, 0, 4091, null);
                                        c14902.L$0 = cb.l.a(uri6);
                                        c14902.L$1 = file7;
                                        c14902.L$2 = u0Var5;
                                        c14902.L$3 = pair5;
                                        c14902.L$4 = cb.l.a(file4);
                                        c14902.L$5 = fileResult2;
                                        c14902.L$6 = obj;
                                        c14902.label = 5;
                                        objPush = push(ownerCopy$default2, c14902);
                                        if (objPush != objG) {
                                            fileResult3 = fileResult2;
                                            file8 = file4;
                                            zBooleanValue = ((Boolean) objPush).booleanValue();
                                            if (zBooleanValue) {
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult3.getGet());
                                            }
                                            u0Var5.f36629c = zBooleanValue;
                                            fileResult = fileResult3;
                                            file5 = file8;
                                            pair4 = pair5;
                                            u0Var4 = u0Var5;
                                            file6 = file7;
                                            uri5 = uri6;
                                            Compressor compressor3 = Compressor.INSTANCE;
                                            Context context3 = this.context;
                                            Function1 function5 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj2) {
                                                    return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                                                }
                                            };
                                            c14902.L$0 = cb.l.a(uri5);
                                            c14902.L$1 = cb.l.a(file6);
                                            c14902.L$2 = u0Var4;
                                            c14902.L$3 = cb.l.a(pair4);
                                            c14902.L$4 = cb.l.a(file5);
                                            c14902.L$5 = cb.l.a(fileResult);
                                            c14902.L$6 = obj;
                                            c14902.label = 6;
                                            u0Var6 = u0Var4;
                                            i10 = 6;
                                            objCompress$default2 = Compressor.compress$default(compressor3, context3, file6, false, null, function5, c14902, 12, null);
                                            if (objCompress$default2 != objG) {
                                                fileResult4 = fileResult;
                                                objPush = objCompress$default2;
                                                file9 = file6;
                                                file10 = file5;
                                                pair6 = pair4;
                                                uri7 = uri5;
                                                u0Var7 = u0Var6;
                                                file11 = (File) objPush;
                                                Function3 function6 = this.getPutUrl;
                                                Integer numD3 = cb.b.d(i10);
                                                Long lE3 = cb.b.e(file11.length());
                                                c14902.L$0 = cb.l.a(uri7);
                                                c14902.L$1 = cb.l.a(file9);
                                                c14902.L$2 = u0Var7;
                                                c14902.L$3 = cb.l.a(pair6);
                                                c14902.L$4 = cb.l.a(file10);
                                                c14902.L$5 = cb.l.a(fileResult4);
                                                c14902.L$6 = cb.l.a(file11);
                                                c14902.L$7 = file11;
                                                c14902.I$0 = 0;
                                                c14902.label = 7;
                                                objInvoke2 = function6.invoke(numD3, lE3, c14902);
                                                if (objInvoke2 != objG) {
                                                    Uri uri13 = uri7;
                                                    fileResult5 = fileResult4;
                                                    uri8 = uri13;
                                                    file12 = file10;
                                                    pair7 = pair6;
                                                    u0Var8 = u0Var7;
                                                    file13 = file9;
                                                    file14 = file11;
                                                    file15 = file14;
                                                    objPush = objInvoke2;
                                                    i11 = 0;
                                                    fileResult6 = (FileResponse.FileResult) objPush;
                                                    if (fileResult6 != null) {
                                                        UploadDataSource.Companion companion3 = UploadDataSource.INSTANCE;
                                                        String path4 = file14.getPath();
                                                        kotlin.jvm.internal.y.h(path4, "getPath(...)");
                                                        String put3 = fileResult6.getPut();
                                                        uri9 = uri8;
                                                        c14902.L$0 = cb.l.a(uri9);
                                                        c14902.L$1 = cb.l.a(file13);
                                                        c14902.L$2 = u0Var8;
                                                        c14902.L$3 = cb.l.a(pair7);
                                                        c14902.L$4 = cb.l.a(file12);
                                                        c14902.L$5 = cb.l.a(fileResult5);
                                                        c14902.L$6 = cb.l.a(file15);
                                                        c14902.L$7 = cb.l.a(file14);
                                                        c14902.L$8 = fileResult6;
                                                        c14902.L$9 = u0Var8;
                                                        c14902.I$0 = i11;
                                                        c14902.label = 8;
                                                        objDirectUpload = companion3.directUpload(put3, path4, c14902);
                                                        if (objDirectUpload != objG) {
                                                            uri10 = uri9;
                                                            fileResult7 = fileResult6;
                                                            objPush = objDirectUpload;
                                                            u0Var9 = u0Var8;
                                                            u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                                            if (u0Var9.f36629c) {
                                                                Owner ownerCopy$default3 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                                                c14902.L$0 = cb.l.a(uri10);
                                                                c14902.L$1 = cb.l.a(file13);
                                                                c14902.L$2 = u0Var9;
                                                                c14902.L$3 = cb.l.a(pair7);
                                                                c14902.L$4 = cb.l.a(file12);
                                                                c14902.L$5 = cb.l.a(fileResult5);
                                                                c14902.L$6 = cb.l.a(file15);
                                                                c14902.L$7 = cb.l.a(file14);
                                                                c14902.L$8 = fileResult7;
                                                                c14902.L$9 = null;
                                                                c14902.I$0 = i11;
                                                                c14902.label = 9;
                                                                objPush = push(ownerCopy$default3, c14902);
                                                                if (objPush != objG) {
                                                                    fileResult8 = fileResult7;
                                                                    zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                                                    if (zBooleanValue2) {
                                                                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                                                    }
                                                                    u0Var9.f36629c = zBooleanValue2;
                                                                }
                                                            }
                                                            u0Var8 = u0Var9;
                                                        }
                                                    }
                                                    return cb.b.a(u0Var8.f36629c);
                                                }
                                            }
                                        }
                                    } else {
                                        file5 = file4;
                                        fileResult = fileResult2;
                                        pair4 = pair5;
                                        u0Var4 = u0Var5;
                                        file6 = file7;
                                        uri5 = uri6;
                                        Compressor compressor4 = Compressor.INSTANCE;
                                        Context context4 = this.context;
                                        Function1 function7 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                                            }
                                        };
                                        c14902.L$0 = cb.l.a(uri5);
                                        c14902.L$1 = cb.l.a(file6);
                                        c14902.L$2 = u0Var4;
                                        c14902.L$3 = cb.l.a(pair4);
                                        c14902.L$4 = cb.l.a(file5);
                                        c14902.L$5 = cb.l.a(fileResult);
                                        c14902.L$6 = obj;
                                        c14902.label = 6;
                                        u0Var6 = u0Var4;
                                        i10 = 6;
                                        objCompress$default2 = Compressor.compress$default(compressor4, context4, file6, false, null, function7, c14902, 12, null);
                                        if (objCompress$default2 != objG) {
                                            fileResult4 = fileResult;
                                            objPush = objCompress$default2;
                                            file9 = file6;
                                            file10 = file5;
                                            pair6 = pair4;
                                            uri7 = uri5;
                                            u0Var7 = u0Var6;
                                            file11 = (File) objPush;
                                            Function3 function8 = this.getPutUrl;
                                            Integer numD4 = cb.b.d(i10);
                                            Long lE4 = cb.b.e(file11.length());
                                            c14902.L$0 = cb.l.a(uri7);
                                            c14902.L$1 = cb.l.a(file9);
                                            c14902.L$2 = u0Var7;
                                            c14902.L$3 = cb.l.a(pair6);
                                            c14902.L$4 = cb.l.a(file10);
                                            c14902.L$5 = cb.l.a(fileResult4);
                                            c14902.L$6 = cb.l.a(file11);
                                            c14902.L$7 = file11;
                                            c14902.I$0 = 0;
                                            c14902.label = 7;
                                            objInvoke2 = function8.invoke(numD4, lE4, c14902);
                                            if (objInvoke2 != objG) {
                                                Uri uri14 = uri7;
                                                fileResult5 = fileResult4;
                                                uri8 = uri14;
                                                file12 = file10;
                                                pair7 = pair6;
                                                u0Var8 = u0Var7;
                                                file13 = file9;
                                                file14 = file11;
                                                file15 = file14;
                                                objPush = objInvoke2;
                                                i11 = 0;
                                                fileResult6 = (FileResponse.FileResult) objPush;
                                                if (fileResult6 != null) {
                                                    UploadDataSource.Companion companion4 = UploadDataSource.INSTANCE;
                                                    String path5 = file14.getPath();
                                                    kotlin.jvm.internal.y.h(path5, "getPath(...)");
                                                    String put4 = fileResult6.getPut();
                                                    uri9 = uri8;
                                                    c14902.L$0 = cb.l.a(uri9);
                                                    c14902.L$1 = cb.l.a(file13);
                                                    c14902.L$2 = u0Var8;
                                                    c14902.L$3 = cb.l.a(pair7);
                                                    c14902.L$4 = cb.l.a(file12);
                                                    c14902.L$5 = cb.l.a(fileResult5);
                                                    c14902.L$6 = cb.l.a(file15);
                                                    c14902.L$7 = cb.l.a(file14);
                                                    c14902.L$8 = fileResult6;
                                                    c14902.L$9 = u0Var8;
                                                    c14902.I$0 = i11;
                                                    c14902.label = 8;
                                                    objDirectUpload = companion4.directUpload(put4, path5, c14902);
                                                    if (objDirectUpload != objG) {
                                                        uri10 = uri9;
                                                        fileResult7 = fileResult6;
                                                        objPush = objDirectUpload;
                                                        u0Var9 = u0Var8;
                                                        u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                                        if (u0Var9.f36629c) {
                                                            Owner ownerCopy$default4 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                                            c14902.L$0 = cb.l.a(uri10);
                                                            c14902.L$1 = cb.l.a(file13);
                                                            c14902.L$2 = u0Var9;
                                                            c14902.L$3 = cb.l.a(pair7);
                                                            c14902.L$4 = cb.l.a(file12);
                                                            c14902.L$5 = cb.l.a(fileResult5);
                                                            c14902.L$6 = cb.l.a(file15);
                                                            c14902.L$7 = cb.l.a(file14);
                                                            c14902.L$8 = fileResult7;
                                                            c14902.L$9 = null;
                                                            c14902.I$0 = i11;
                                                            c14902.label = 9;
                                                            objPush = push(ownerCopy$default4, c14902);
                                                            if (objPush != objG) {
                                                                fileResult8 = fileResult7;
                                                                zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                                                if (zBooleanValue2) {
                                                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                                                }
                                                                u0Var9.f36629c = zBooleanValue2;
                                                            }
                                                        }
                                                        u0Var8 = u0Var9;
                                                    }
                                                }
                                                return cb.b.a(u0Var8.f36629c);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return objG;
            case 1:
                u0 u0Var12 = (u0) c14902.L$2;
                file = (File) c14902.L$1;
                Uri uri15 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                bounds = objPush;
                uri3 = uri15;
                u0Var = u0Var12;
                pair = (Pair) bounds;
                Compressor compressor5 = Compressor.INSTANCE;
                Context context5 = this.context;
                Function1 function9 = new Function1() { // from class: cu.todus.android.xmpp.managers.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ProfileManager.updateProfileImage$lambda$0(pair, (Compression) obj2);
                    }
                };
                c14902.L$0 = cb.l.a(uri3);
                c14902.L$1 = file;
                c14902.L$2 = u0Var;
                c14902.L$3 = pair;
                c14902.label = 2;
                u0Var2 = u0Var;
                obj = null;
                objCompress$default = Compressor.compress$default(compressor5, context5, file, false, null, function9, c14902, 12, null);
                if (objCompress$default != objG) {
                    uri4 = uri3;
                    objPush = objCompress$default;
                    file2 = file;
                    pair2 = pair;
                    u0Var3 = u0Var2;
                    file3 = (File) objPush;
                    Function3 function10 = this.getPutUrl;
                    Integer numD5 = cb.b.d(5);
                    Long lE5 = cb.b.e(file3.length());
                    c14902.L$0 = cb.l.a(uri4);
                    c14902.L$1 = file2;
                    c14902.L$2 = u0Var3;
                    c14902.L$3 = pair2;
                    c14902.L$4 = file3;
                    c14902.label = 3;
                    objInvoke = function10.invoke(numD5, lE5, c14902);
                    if (objInvoke != objG) {
                        file4 = file3;
                        objPush = objInvoke;
                        u0 u0Var13 = u0Var3;
                        pair3 = pair2;
                        u0Var4 = u0Var13;
                        fileResult = (FileResponse.FileResult) objPush;
                        if (fileResult != null) {
                        }
                        file5 = file4;
                        pair4 = pair3;
                        file6 = file2;
                        uri5 = uri4;
                        Compressor compressor6 = Compressor.INSTANCE;
                        Context context6 = this.context;
                        Function1 function11 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                            }
                        };
                        c14902.L$0 = cb.l.a(uri5);
                        c14902.L$1 = cb.l.a(file6);
                        c14902.L$2 = u0Var4;
                        c14902.L$3 = cb.l.a(pair4);
                        c14902.L$4 = cb.l.a(file5);
                        c14902.L$5 = cb.l.a(fileResult);
                        c14902.L$6 = obj;
                        c14902.label = 6;
                        u0Var6 = u0Var4;
                        i10 = 6;
                        objCompress$default2 = Compressor.compress$default(compressor6, context6, file6, false, null, function11, c14902, 12, null);
                        if (objCompress$default2 != objG) {
                            fileResult4 = fileResult;
                            objPush = objCompress$default2;
                            file9 = file6;
                            file10 = file5;
                            pair6 = pair4;
                            uri7 = uri5;
                            u0Var7 = u0Var6;
                            file11 = (File) objPush;
                            Function3 function12 = this.getPutUrl;
                            Integer numD6 = cb.b.d(i10);
                            Long lE6 = cb.b.e(file11.length());
                            c14902.L$0 = cb.l.a(uri7);
                            c14902.L$1 = cb.l.a(file9);
                            c14902.L$2 = u0Var7;
                            c14902.L$3 = cb.l.a(pair6);
                            c14902.L$4 = cb.l.a(file10);
                            c14902.L$5 = cb.l.a(fileResult4);
                            c14902.L$6 = cb.l.a(file11);
                            c14902.L$7 = file11;
                            c14902.I$0 = 0;
                            c14902.label = 7;
                            objInvoke2 = function12.invoke(numD6, lE6, c14902);
                            if (objInvoke2 != objG) {
                                Uri uri16 = uri7;
                                fileResult5 = fileResult4;
                                uri8 = uri16;
                                file12 = file10;
                                pair7 = pair6;
                                u0Var8 = u0Var7;
                                file13 = file9;
                                file14 = file11;
                                file15 = file14;
                                objPush = objInvoke2;
                                i11 = 0;
                                fileResult6 = (FileResponse.FileResult) objPush;
                                if (fileResult6 != null) {
                                    UploadDataSource.Companion companion5 = UploadDataSource.INSTANCE;
                                    String path6 = file14.getPath();
                                    kotlin.jvm.internal.y.h(path6, "getPath(...)");
                                    String put5 = fileResult6.getPut();
                                    uri9 = uri8;
                                    c14902.L$0 = cb.l.a(uri9);
                                    c14902.L$1 = cb.l.a(file13);
                                    c14902.L$2 = u0Var8;
                                    c14902.L$3 = cb.l.a(pair7);
                                    c14902.L$4 = cb.l.a(file12);
                                    c14902.L$5 = cb.l.a(fileResult5);
                                    c14902.L$6 = cb.l.a(file15);
                                    c14902.L$7 = cb.l.a(file14);
                                    c14902.L$8 = fileResult6;
                                    c14902.L$9 = u0Var8;
                                    c14902.I$0 = i11;
                                    c14902.label = 8;
                                    objDirectUpload = companion5.directUpload(put5, path6, c14902);
                                    if (objDirectUpload != objG) {
                                        uri10 = uri9;
                                        fileResult7 = fileResult6;
                                        objPush = objDirectUpload;
                                        u0Var9 = u0Var8;
                                        u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                        if (u0Var9.f36629c) {
                                            Owner ownerCopy$default5 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                            c14902.L$0 = cb.l.a(uri10);
                                            c14902.L$1 = cb.l.a(file13);
                                            c14902.L$2 = u0Var9;
                                            c14902.L$3 = cb.l.a(pair7);
                                            c14902.L$4 = cb.l.a(file12);
                                            c14902.L$5 = cb.l.a(fileResult5);
                                            c14902.L$6 = cb.l.a(file15);
                                            c14902.L$7 = cb.l.a(file14);
                                            c14902.L$8 = fileResult7;
                                            c14902.L$9 = null;
                                            c14902.I$0 = i11;
                                            c14902.label = 9;
                                            objPush = push(ownerCopy$default5, c14902);
                                            if (objPush != objG) {
                                                fileResult8 = fileResult7;
                                                zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                                if (zBooleanValue2) {
                                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                                }
                                                u0Var9.f36629c = zBooleanValue2;
                                            }
                                        }
                                        u0Var8 = u0Var9;
                                    }
                                }
                                return cb.b.a(u0Var8.f36629c);
                            }
                        }
                    }
                    break;
                }
                return objG;
            case 2:
                pair2 = (Pair) c14902.L$3;
                u0Var3 = (u0) c14902.L$2;
                File file17 = (File) c14902.L$1;
                Uri uri17 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                obj = null;
                uri4 = uri17;
                file2 = file17;
                file3 = (File) objPush;
                Function3 function13 = this.getPutUrl;
                Integer numD7 = cb.b.d(5);
                Long lE7 = cb.b.e(file3.length());
                c14902.L$0 = cb.l.a(uri4);
                c14902.L$1 = file2;
                c14902.L$2 = u0Var3;
                c14902.L$3 = pair2;
                c14902.L$4 = file3;
                c14902.label = 3;
                objInvoke = function13.invoke(numD7, lE7, c14902);
                if (objInvoke != objG) {
                    file4 = file3;
                    objPush = objInvoke;
                    u0 u0Var14 = u0Var3;
                    pair3 = pair2;
                    u0Var4 = u0Var14;
                    fileResult = (FileResponse.FileResult) objPush;
                    if (fileResult != null) {
                    }
                    file5 = file4;
                    pair4 = pair3;
                    file6 = file2;
                    uri5 = uri4;
                    Compressor compressor7 = Compressor.INSTANCE;
                    Context context7 = this.context;
                    Function1 function14 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                        }
                    };
                    c14902.L$0 = cb.l.a(uri5);
                    c14902.L$1 = cb.l.a(file6);
                    c14902.L$2 = u0Var4;
                    c14902.L$3 = cb.l.a(pair4);
                    c14902.L$4 = cb.l.a(file5);
                    c14902.L$5 = cb.l.a(fileResult);
                    c14902.L$6 = obj;
                    c14902.label = 6;
                    u0Var6 = u0Var4;
                    i10 = 6;
                    objCompress$default2 = Compressor.compress$default(compressor7, context7, file6, false, null, function14, c14902, 12, null);
                    if (objCompress$default2 != objG) {
                        fileResult4 = fileResult;
                        objPush = objCompress$default2;
                        file9 = file6;
                        file10 = file5;
                        pair6 = pair4;
                        uri7 = uri5;
                        u0Var7 = u0Var6;
                        file11 = (File) objPush;
                        Function3 function15 = this.getPutUrl;
                        Integer numD8 = cb.b.d(i10);
                        Long lE8 = cb.b.e(file11.length());
                        c14902.L$0 = cb.l.a(uri7);
                        c14902.L$1 = cb.l.a(file9);
                        c14902.L$2 = u0Var7;
                        c14902.L$3 = cb.l.a(pair6);
                        c14902.L$4 = cb.l.a(file10);
                        c14902.L$5 = cb.l.a(fileResult4);
                        c14902.L$6 = cb.l.a(file11);
                        c14902.L$7 = file11;
                        c14902.I$0 = 0;
                        c14902.label = 7;
                        objInvoke2 = function15.invoke(numD8, lE8, c14902);
                        if (objInvoke2 != objG) {
                            Uri uri18 = uri7;
                            fileResult5 = fileResult4;
                            uri8 = uri18;
                            file12 = file10;
                            pair7 = pair6;
                            u0Var8 = u0Var7;
                            file13 = file9;
                            file14 = file11;
                            file15 = file14;
                            objPush = objInvoke2;
                            i11 = 0;
                            fileResult6 = (FileResponse.FileResult) objPush;
                            if (fileResult6 != null) {
                                UploadDataSource.Companion companion6 = UploadDataSource.INSTANCE;
                                String path7 = file14.getPath();
                                kotlin.jvm.internal.y.h(path7, "getPath(...)");
                                String put6 = fileResult6.getPut();
                                uri9 = uri8;
                                c14902.L$0 = cb.l.a(uri9);
                                c14902.L$1 = cb.l.a(file13);
                                c14902.L$2 = u0Var8;
                                c14902.L$3 = cb.l.a(pair7);
                                c14902.L$4 = cb.l.a(file12);
                                c14902.L$5 = cb.l.a(fileResult5);
                                c14902.L$6 = cb.l.a(file15);
                                c14902.L$7 = cb.l.a(file14);
                                c14902.L$8 = fileResult6;
                                c14902.L$9 = u0Var8;
                                c14902.I$0 = i11;
                                c14902.label = 8;
                                objDirectUpload = companion6.directUpload(put6, path7, c14902);
                                if (objDirectUpload != objG) {
                                    uri10 = uri9;
                                    fileResult7 = fileResult6;
                                    objPush = objDirectUpload;
                                    u0Var9 = u0Var8;
                                    u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                    if (u0Var9.f36629c) {
                                        Owner ownerCopy$default6 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                        c14902.L$0 = cb.l.a(uri10);
                                        c14902.L$1 = cb.l.a(file13);
                                        c14902.L$2 = u0Var9;
                                        c14902.L$3 = cb.l.a(pair7);
                                        c14902.L$4 = cb.l.a(file12);
                                        c14902.L$5 = cb.l.a(fileResult5);
                                        c14902.L$6 = cb.l.a(file15);
                                        c14902.L$7 = cb.l.a(file14);
                                        c14902.L$8 = fileResult7;
                                        c14902.L$9 = null;
                                        c14902.I$0 = i11;
                                        c14902.label = 9;
                                        objPush = push(ownerCopy$default6, c14902);
                                        if (objPush != objG) {
                                            fileResult8 = fileResult7;
                                            zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                            if (zBooleanValue2) {
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                            }
                                            u0Var9.f36629c = zBooleanValue2;
                                        }
                                    }
                                    u0Var8 = u0Var9;
                                }
                            }
                            return cb.b.a(u0Var8.f36629c);
                        }
                    }
                    break;
                }
                return objG;
            case 3:
                File file18 = (File) c14902.L$4;
                pair3 = (Pair) c14902.L$3;
                u0 u0Var15 = (u0) c14902.L$2;
                file2 = (File) c14902.L$1;
                uri4 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                obj = null;
                file4 = file18;
                u0Var4 = u0Var15;
                fileResult = (FileResponse.FileResult) objPush;
                if (fileResult != null) {
                    break;
                }
                file5 = file4;
                pair4 = pair3;
                file6 = file2;
                uri5 = uri4;
                Compressor compressor8 = Compressor.INSTANCE;
                Context context8 = this.context;
                Function1 function16 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                    }
                };
                c14902.L$0 = cb.l.a(uri5);
                c14902.L$1 = cb.l.a(file6);
                c14902.L$2 = u0Var4;
                c14902.L$3 = cb.l.a(pair4);
                c14902.L$4 = cb.l.a(file5);
                c14902.L$5 = cb.l.a(fileResult);
                c14902.L$6 = obj;
                c14902.label = 6;
                u0Var6 = u0Var4;
                i10 = 6;
                objCompress$default2 = Compressor.compress$default(compressor8, context8, file6, false, null, function16, c14902, 12, null);
                if (objCompress$default2 != objG) {
                    fileResult4 = fileResult;
                    objPush = objCompress$default2;
                    file9 = file6;
                    file10 = file5;
                    pair6 = pair4;
                    uri7 = uri5;
                    u0Var7 = u0Var6;
                    file11 = (File) objPush;
                    Function3 function17 = this.getPutUrl;
                    Integer numD9 = cb.b.d(i10);
                    Long lE9 = cb.b.e(file11.length());
                    c14902.L$0 = cb.l.a(uri7);
                    c14902.L$1 = cb.l.a(file9);
                    c14902.L$2 = u0Var7;
                    c14902.L$3 = cb.l.a(pair6);
                    c14902.L$4 = cb.l.a(file10);
                    c14902.L$5 = cb.l.a(fileResult4);
                    c14902.L$6 = cb.l.a(file11);
                    c14902.L$7 = file11;
                    c14902.I$0 = 0;
                    c14902.label = 7;
                    objInvoke2 = function17.invoke(numD9, lE9, c14902);
                    if (objInvoke2 != objG) {
                        Uri uri19 = uri7;
                        fileResult5 = fileResult4;
                        uri8 = uri19;
                        file12 = file10;
                        pair7 = pair6;
                        u0Var8 = u0Var7;
                        file13 = file9;
                        file14 = file11;
                        file15 = file14;
                        objPush = objInvoke2;
                        i11 = 0;
                        fileResult6 = (FileResponse.FileResult) objPush;
                        if (fileResult6 != null) {
                            UploadDataSource.Companion companion7 = UploadDataSource.INSTANCE;
                            String path8 = file14.getPath();
                            kotlin.jvm.internal.y.h(path8, "getPath(...)");
                            String put7 = fileResult6.getPut();
                            uri9 = uri8;
                            c14902.L$0 = cb.l.a(uri9);
                            c14902.L$1 = cb.l.a(file13);
                            c14902.L$2 = u0Var8;
                            c14902.L$3 = cb.l.a(pair7);
                            c14902.L$4 = cb.l.a(file12);
                            c14902.L$5 = cb.l.a(fileResult5);
                            c14902.L$6 = cb.l.a(file15);
                            c14902.L$7 = cb.l.a(file14);
                            c14902.L$8 = fileResult6;
                            c14902.L$9 = u0Var8;
                            c14902.I$0 = i11;
                            c14902.label = 8;
                            objDirectUpload = companion7.directUpload(put7, path8, c14902);
                            if (objDirectUpload != objG) {
                                uri10 = uri9;
                                fileResult7 = fileResult6;
                                objPush = objDirectUpload;
                                u0Var9 = u0Var8;
                                u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                if (u0Var9.f36629c) {
                                    Owner ownerCopy$default7 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                    c14902.L$0 = cb.l.a(uri10);
                                    c14902.L$1 = cb.l.a(file13);
                                    c14902.L$2 = u0Var9;
                                    c14902.L$3 = cb.l.a(pair7);
                                    c14902.L$4 = cb.l.a(file12);
                                    c14902.L$5 = cb.l.a(fileResult5);
                                    c14902.L$6 = cb.l.a(file15);
                                    c14902.L$7 = cb.l.a(file14);
                                    c14902.L$8 = fileResult7;
                                    c14902.L$9 = null;
                                    c14902.I$0 = i11;
                                    c14902.label = 9;
                                    objPush = push(ownerCopy$default7, c14902);
                                    if (objPush != objG) {
                                        fileResult8 = fileResult7;
                                        zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                        if (zBooleanValue2) {
                                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                        }
                                        u0Var9.f36629c = zBooleanValue2;
                                    }
                                }
                                u0Var8 = u0Var9;
                            }
                        }
                        return cb.b.a(u0Var8.f36629c);
                    }
                }
                return objG;
            case 4:
                u0Var4 = (u0) c14902.L$6;
                fileResult2 = (FileResponse.FileResult) c14902.L$5;
                File file19 = (File) c14902.L$4;
                Pair pair9 = (Pair) c14902.L$3;
                u0 u0Var16 = (u0) c14902.L$2;
                File file20 = (File) c14902.L$1;
                Uri uri20 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                obj = null;
                file4 = file19;
                pair5 = pair9;
                u0Var5 = u0Var16;
                file7 = file20;
                uri6 = uri20;
                u0Var4.f36629c = ((Boolean) objPush).booleanValue();
                if (u0Var5.f36629c) {
                    Owner ownerCopy$default8 = Owner.copy$default((Owner) this.owner.invoke(), null, null, fileResult2.getGet(), 0, null, null, null, null, null, 0L, null, 0, 4091, null);
                    c14902.L$0 = cb.l.a(uri6);
                    c14902.L$1 = file7;
                    c14902.L$2 = u0Var5;
                    c14902.L$3 = pair5;
                    c14902.L$4 = cb.l.a(file4);
                    c14902.L$5 = fileResult2;
                    c14902.L$6 = obj;
                    c14902.label = 5;
                    objPush = push(ownerCopy$default8, c14902);
                    if (objPush != objG) {
                        fileResult3 = fileResult2;
                        file8 = file4;
                        zBooleanValue = ((Boolean) objPush).booleanValue();
                        if (zBooleanValue) {
                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult3.getGet());
                        }
                        u0Var5.f36629c = zBooleanValue;
                        fileResult = fileResult3;
                        file5 = file8;
                        pair4 = pair5;
                        u0Var4 = u0Var5;
                        file6 = file7;
                        uri5 = uri6;
                        Compressor compressor9 = Compressor.INSTANCE;
                        Context context9 = this.context;
                        Function1 function18 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                            }
                        };
                        c14902.L$0 = cb.l.a(uri5);
                        c14902.L$1 = cb.l.a(file6);
                        c14902.L$2 = u0Var4;
                        c14902.L$3 = cb.l.a(pair4);
                        c14902.L$4 = cb.l.a(file5);
                        c14902.L$5 = cb.l.a(fileResult);
                        c14902.L$6 = obj;
                        c14902.label = 6;
                        u0Var6 = u0Var4;
                        i10 = 6;
                        objCompress$default2 = Compressor.compress$default(compressor9, context9, file6, false, null, function18, c14902, 12, null);
                        if (objCompress$default2 != objG) {
                            fileResult4 = fileResult;
                            objPush = objCompress$default2;
                            file9 = file6;
                            file10 = file5;
                            pair6 = pair4;
                            uri7 = uri5;
                            u0Var7 = u0Var6;
                            file11 = (File) objPush;
                            Function3 function19 = this.getPutUrl;
                            Integer numD10 = cb.b.d(i10);
                            Long lE10 = cb.b.e(file11.length());
                            c14902.L$0 = cb.l.a(uri7);
                            c14902.L$1 = cb.l.a(file9);
                            c14902.L$2 = u0Var7;
                            c14902.L$3 = cb.l.a(pair6);
                            c14902.L$4 = cb.l.a(file10);
                            c14902.L$5 = cb.l.a(fileResult4);
                            c14902.L$6 = cb.l.a(file11);
                            c14902.L$7 = file11;
                            c14902.I$0 = 0;
                            c14902.label = 7;
                            objInvoke2 = function19.invoke(numD10, lE10, c14902);
                            if (objInvoke2 != objG) {
                                Uri uri110 = uri7;
                                fileResult5 = fileResult4;
                                uri8 = uri110;
                                file12 = file10;
                                pair7 = pair6;
                                u0Var8 = u0Var7;
                                file13 = file9;
                                file14 = file11;
                                file15 = file14;
                                objPush = objInvoke2;
                                i11 = 0;
                                fileResult6 = (FileResponse.FileResult) objPush;
                                if (fileResult6 != null) {
                                    UploadDataSource.Companion companion8 = UploadDataSource.INSTANCE;
                                    String path9 = file14.getPath();
                                    kotlin.jvm.internal.y.h(path9, "getPath(...)");
                                    String put8 = fileResult6.getPut();
                                    uri9 = uri8;
                                    c14902.L$0 = cb.l.a(uri9);
                                    c14902.L$1 = cb.l.a(file13);
                                    c14902.L$2 = u0Var8;
                                    c14902.L$3 = cb.l.a(pair7);
                                    c14902.L$4 = cb.l.a(file12);
                                    c14902.L$5 = cb.l.a(fileResult5);
                                    c14902.L$6 = cb.l.a(file15);
                                    c14902.L$7 = cb.l.a(file14);
                                    c14902.L$8 = fileResult6;
                                    c14902.L$9 = u0Var8;
                                    c14902.I$0 = i11;
                                    c14902.label = 8;
                                    objDirectUpload = companion8.directUpload(put8, path9, c14902);
                                    if (objDirectUpload != objG) {
                                        uri10 = uri9;
                                        fileResult7 = fileResult6;
                                        objPush = objDirectUpload;
                                        u0Var9 = u0Var8;
                                        u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                        if (u0Var9.f36629c) {
                                            Owner ownerCopy$default9 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                            c14902.L$0 = cb.l.a(uri10);
                                            c14902.L$1 = cb.l.a(file13);
                                            c14902.L$2 = u0Var9;
                                            c14902.L$3 = cb.l.a(pair7);
                                            c14902.L$4 = cb.l.a(file12);
                                            c14902.L$5 = cb.l.a(fileResult5);
                                            c14902.L$6 = cb.l.a(file15);
                                            c14902.L$7 = cb.l.a(file14);
                                            c14902.L$8 = fileResult7;
                                            c14902.L$9 = null;
                                            c14902.I$0 = i11;
                                            c14902.label = 9;
                                            objPush = push(ownerCopy$default9, c14902);
                                            if (objPush != objG) {
                                                fileResult8 = fileResult7;
                                                zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                                if (zBooleanValue2) {
                                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                                }
                                                u0Var9.f36629c = zBooleanValue2;
                                            }
                                        }
                                        u0Var8 = u0Var9;
                                    }
                                }
                                return cb.b.a(u0Var8.f36629c);
                            }
                        }
                    }
                } else {
                    file5 = file4;
                    fileResult = fileResult2;
                    pair4 = pair5;
                    u0Var4 = u0Var5;
                    file6 = file7;
                    uri5 = uri6;
                    Compressor compressor10 = Compressor.INSTANCE;
                    Context context10 = this.context;
                    Function1 function110 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                        }
                    };
                    c14902.L$0 = cb.l.a(uri5);
                    c14902.L$1 = cb.l.a(file6);
                    c14902.L$2 = u0Var4;
                    c14902.L$3 = cb.l.a(pair4);
                    c14902.L$4 = cb.l.a(file5);
                    c14902.L$5 = cb.l.a(fileResult);
                    c14902.L$6 = obj;
                    c14902.label = 6;
                    u0Var6 = u0Var4;
                    i10 = 6;
                    objCompress$default2 = Compressor.compress$default(compressor10, context10, file6, false, null, function110, c14902, 12, null);
                    if (objCompress$default2 != objG) {
                        fileResult4 = fileResult;
                        objPush = objCompress$default2;
                        file9 = file6;
                        file10 = file5;
                        pair6 = pair4;
                        uri7 = uri5;
                        u0Var7 = u0Var6;
                        file11 = (File) objPush;
                        Function3 function111 = this.getPutUrl;
                        Integer numD11 = cb.b.d(i10);
                        Long lE11 = cb.b.e(file11.length());
                        c14902.L$0 = cb.l.a(uri7);
                        c14902.L$1 = cb.l.a(file9);
                        c14902.L$2 = u0Var7;
                        c14902.L$3 = cb.l.a(pair6);
                        c14902.L$4 = cb.l.a(file10);
                        c14902.L$5 = cb.l.a(fileResult4);
                        c14902.L$6 = cb.l.a(file11);
                        c14902.L$7 = file11;
                        c14902.I$0 = 0;
                        c14902.label = 7;
                        objInvoke2 = function111.invoke(numD11, lE11, c14902);
                        if (objInvoke2 != objG) {
                            Uri uri111 = uri7;
                            fileResult5 = fileResult4;
                            uri8 = uri111;
                            file12 = file10;
                            pair7 = pair6;
                            u0Var8 = u0Var7;
                            file13 = file9;
                            file14 = file11;
                            file15 = file14;
                            objPush = objInvoke2;
                            i11 = 0;
                            fileResult6 = (FileResponse.FileResult) objPush;
                            if (fileResult6 != null) {
                                UploadDataSource.Companion companion9 = UploadDataSource.INSTANCE;
                                String path10 = file14.getPath();
                                kotlin.jvm.internal.y.h(path10, "getPath(...)");
                                String put9 = fileResult6.getPut();
                                uri9 = uri8;
                                c14902.L$0 = cb.l.a(uri9);
                                c14902.L$1 = cb.l.a(file13);
                                c14902.L$2 = u0Var8;
                                c14902.L$3 = cb.l.a(pair7);
                                c14902.L$4 = cb.l.a(file12);
                                c14902.L$5 = cb.l.a(fileResult5);
                                c14902.L$6 = cb.l.a(file15);
                                c14902.L$7 = cb.l.a(file14);
                                c14902.L$8 = fileResult6;
                                c14902.L$9 = u0Var8;
                                c14902.I$0 = i11;
                                c14902.label = 8;
                                objDirectUpload = companion9.directUpload(put9, path10, c14902);
                                if (objDirectUpload != objG) {
                                    uri10 = uri9;
                                    fileResult7 = fileResult6;
                                    objPush = objDirectUpload;
                                    u0Var9 = u0Var8;
                                    u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                    if (u0Var9.f36629c) {
                                        Owner ownerCopy$default10 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                        c14902.L$0 = cb.l.a(uri10);
                                        c14902.L$1 = cb.l.a(file13);
                                        c14902.L$2 = u0Var9;
                                        c14902.L$3 = cb.l.a(pair7);
                                        c14902.L$4 = cb.l.a(file12);
                                        c14902.L$5 = cb.l.a(fileResult5);
                                        c14902.L$6 = cb.l.a(file15);
                                        c14902.L$7 = cb.l.a(file14);
                                        c14902.L$8 = fileResult7;
                                        c14902.L$9 = null;
                                        c14902.I$0 = i11;
                                        c14902.label = 9;
                                        objPush = push(ownerCopy$default10, c14902);
                                        if (objPush != objG) {
                                            fileResult8 = fileResult7;
                                            zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                            if (zBooleanValue2) {
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                            }
                                            u0Var9.f36629c = zBooleanValue2;
                                        }
                                    }
                                    u0Var8 = u0Var9;
                                }
                            }
                            return cb.b.a(u0Var8.f36629c);
                        }
                    }
                }
                return objG;
            case 5:
                fileResult3 = (FileResponse.FileResult) c14902.L$5;
                file8 = (File) c14902.L$4;
                pair5 = (Pair) c14902.L$3;
                u0Var5 = (u0) c14902.L$2;
                file7 = (File) c14902.L$1;
                uri6 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                obj = null;
                zBooleanValue = ((Boolean) objPush).booleanValue();
                if (zBooleanValue) {
                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult3.getGet());
                }
                u0Var5.f36629c = zBooleanValue;
                fileResult = fileResult3;
                file5 = file8;
                pair4 = pair5;
                u0Var4 = u0Var5;
                file6 = file7;
                uri5 = uri6;
                Compressor compressor11 = Compressor.INSTANCE;
                Context context11 = this.context;
                Function1 function112 = new Function1() { // from class: cu.todus.android.xmpp.managers.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ProfileManager.updateProfileImage$lambda$1(pair4, (Compression) obj2);
                    }
                };
                c14902.L$0 = cb.l.a(uri5);
                c14902.L$1 = cb.l.a(file6);
                c14902.L$2 = u0Var4;
                c14902.L$3 = cb.l.a(pair4);
                c14902.L$4 = cb.l.a(file5);
                c14902.L$5 = cb.l.a(fileResult);
                c14902.L$6 = obj;
                c14902.label = 6;
                u0Var6 = u0Var4;
                i10 = 6;
                objCompress$default2 = Compressor.compress$default(compressor11, context11, file6, false, null, function112, c14902, 12, null);
                if (objCompress$default2 != objG) {
                    fileResult4 = fileResult;
                    objPush = objCompress$default2;
                    file9 = file6;
                    file10 = file5;
                    pair6 = pair4;
                    uri7 = uri5;
                    u0Var7 = u0Var6;
                    file11 = (File) objPush;
                    Function3 function113 = this.getPutUrl;
                    Integer numD12 = cb.b.d(i10);
                    Long lE12 = cb.b.e(file11.length());
                    c14902.L$0 = cb.l.a(uri7);
                    c14902.L$1 = cb.l.a(file9);
                    c14902.L$2 = u0Var7;
                    c14902.L$3 = cb.l.a(pair6);
                    c14902.L$4 = cb.l.a(file10);
                    c14902.L$5 = cb.l.a(fileResult4);
                    c14902.L$6 = cb.l.a(file11);
                    c14902.L$7 = file11;
                    c14902.I$0 = 0;
                    c14902.label = 7;
                    objInvoke2 = function113.invoke(numD12, lE12, c14902);
                    if (objInvoke2 != objG) {
                        Uri uri112 = uri7;
                        fileResult5 = fileResult4;
                        uri8 = uri112;
                        file12 = file10;
                        pair7 = pair6;
                        u0Var8 = u0Var7;
                        file13 = file9;
                        file14 = file11;
                        file15 = file14;
                        objPush = objInvoke2;
                        i11 = 0;
                        fileResult6 = (FileResponse.FileResult) objPush;
                        if (fileResult6 != null) {
                            UploadDataSource.Companion companion10 = UploadDataSource.INSTANCE;
                            String path11 = file14.getPath();
                            kotlin.jvm.internal.y.h(path11, "getPath(...)");
                            String put10 = fileResult6.getPut();
                            uri9 = uri8;
                            c14902.L$0 = cb.l.a(uri9);
                            c14902.L$1 = cb.l.a(file13);
                            c14902.L$2 = u0Var8;
                            c14902.L$3 = cb.l.a(pair7);
                            c14902.L$4 = cb.l.a(file12);
                            c14902.L$5 = cb.l.a(fileResult5);
                            c14902.L$6 = cb.l.a(file15);
                            c14902.L$7 = cb.l.a(file14);
                            c14902.L$8 = fileResult6;
                            c14902.L$9 = u0Var8;
                            c14902.I$0 = i11;
                            c14902.label = 8;
                            objDirectUpload = companion10.directUpload(put10, path11, c14902);
                            if (objDirectUpload != objG) {
                                uri10 = uri9;
                                fileResult7 = fileResult6;
                                objPush = objDirectUpload;
                                u0Var9 = u0Var8;
                                u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                                if (u0Var9.f36629c) {
                                    Owner ownerCopy$default11 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                    c14902.L$0 = cb.l.a(uri10);
                                    c14902.L$1 = cb.l.a(file13);
                                    c14902.L$2 = u0Var9;
                                    c14902.L$3 = cb.l.a(pair7);
                                    c14902.L$4 = cb.l.a(file12);
                                    c14902.L$5 = cb.l.a(fileResult5);
                                    c14902.L$6 = cb.l.a(file15);
                                    c14902.L$7 = cb.l.a(file14);
                                    c14902.L$8 = fileResult7;
                                    c14902.L$9 = null;
                                    c14902.I$0 = i11;
                                    c14902.label = 9;
                                    objPush = push(ownerCopy$default11, c14902);
                                    if (objPush != objG) {
                                        fileResult8 = fileResult7;
                                        zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                        if (zBooleanValue2) {
                                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                        }
                                        u0Var9.f36629c = zBooleanValue2;
                                    }
                                }
                                u0Var8 = u0Var9;
                            }
                        }
                        return cb.b.a(u0Var8.f36629c);
                    }
                }
                return objG;
            case 6:
                fileResult4 = (FileResponse.FileResult) c14902.L$5;
                file10 = (File) c14902.L$4;
                pair6 = (Pair) c14902.L$3;
                u0Var7 = (u0) c14902.L$2;
                file9 = (File) c14902.L$1;
                uri7 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                i10 = 6;
                file11 = (File) objPush;
                Function3 function114 = this.getPutUrl;
                Integer numD13 = cb.b.d(i10);
                Long lE13 = cb.b.e(file11.length());
                c14902.L$0 = cb.l.a(uri7);
                c14902.L$1 = cb.l.a(file9);
                c14902.L$2 = u0Var7;
                c14902.L$3 = cb.l.a(pair6);
                c14902.L$4 = cb.l.a(file10);
                c14902.L$5 = cb.l.a(fileResult4);
                c14902.L$6 = cb.l.a(file11);
                c14902.L$7 = file11;
                c14902.I$0 = 0;
                c14902.label = 7;
                objInvoke2 = function114.invoke(numD13, lE13, c14902);
                if (objInvoke2 != objG) {
                    Uri uri113 = uri7;
                    fileResult5 = fileResult4;
                    uri8 = uri113;
                    file12 = file10;
                    pair7 = pair6;
                    u0Var8 = u0Var7;
                    file13 = file9;
                    file14 = file11;
                    file15 = file14;
                    objPush = objInvoke2;
                    i11 = 0;
                    fileResult6 = (FileResponse.FileResult) objPush;
                    if (fileResult6 != null) {
                        UploadDataSource.Companion companion11 = UploadDataSource.INSTANCE;
                        String path12 = file14.getPath();
                        kotlin.jvm.internal.y.h(path12, "getPath(...)");
                        String put11 = fileResult6.getPut();
                        uri9 = uri8;
                        c14902.L$0 = cb.l.a(uri9);
                        c14902.L$1 = cb.l.a(file13);
                        c14902.L$2 = u0Var8;
                        c14902.L$3 = cb.l.a(pair7);
                        c14902.L$4 = cb.l.a(file12);
                        c14902.L$5 = cb.l.a(fileResult5);
                        c14902.L$6 = cb.l.a(file15);
                        c14902.L$7 = cb.l.a(file14);
                        c14902.L$8 = fileResult6;
                        c14902.L$9 = u0Var8;
                        c14902.I$0 = i11;
                        c14902.label = 8;
                        objDirectUpload = companion11.directUpload(put11, path12, c14902);
                        if (objDirectUpload != objG) {
                            uri10 = uri9;
                            fileResult7 = fileResult6;
                            objPush = objDirectUpload;
                            u0Var9 = u0Var8;
                            u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                            if (u0Var9.f36629c) {
                                Owner ownerCopy$default12 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                                c14902.L$0 = cb.l.a(uri10);
                                c14902.L$1 = cb.l.a(file13);
                                c14902.L$2 = u0Var9;
                                c14902.L$3 = cb.l.a(pair7);
                                c14902.L$4 = cb.l.a(file12);
                                c14902.L$5 = cb.l.a(fileResult5);
                                c14902.L$6 = cb.l.a(file15);
                                c14902.L$7 = cb.l.a(file14);
                                c14902.L$8 = fileResult7;
                                c14902.L$9 = null;
                                c14902.I$0 = i11;
                                c14902.label = 9;
                                objPush = push(ownerCopy$default12, c14902);
                                if (objPush != objG) {
                                    fileResult8 = fileResult7;
                                    zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                    if (zBooleanValue2) {
                                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                    }
                                    u0Var9.f36629c = zBooleanValue2;
                                }
                            }
                            u0Var8 = u0Var9;
                        }
                    }
                    return cb.b.a(u0Var8.f36629c);
                }
                return objG;
            case 7:
                int i13 = c14902.I$0;
                File file21 = (File) c14902.L$7;
                File file22 = (File) c14902.L$6;
                FileResponse.FileResult fileResult9 = (FileResponse.FileResult) c14902.L$5;
                File file23 = (File) c14902.L$4;
                Pair pair10 = (Pair) c14902.L$3;
                u0 u0Var17 = (u0) c14902.L$2;
                File file24 = (File) c14902.L$1;
                Uri uri21 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                i11 = i13;
                file13 = file24;
                file12 = file23;
                file14 = file21;
                uri8 = uri21;
                pair7 = pair10;
                file15 = file22;
                u0Var8 = u0Var17;
                fileResult5 = fileResult9;
                fileResult6 = (FileResponse.FileResult) objPush;
                if (fileResult6 != null) {
                    UploadDataSource.Companion companion12 = UploadDataSource.INSTANCE;
                    String path13 = file14.getPath();
                    kotlin.jvm.internal.y.h(path13, "getPath(...)");
                    String put12 = fileResult6.getPut();
                    uri9 = uri8;
                    c14902.L$0 = cb.l.a(uri9);
                    c14902.L$1 = cb.l.a(file13);
                    c14902.L$2 = u0Var8;
                    c14902.L$3 = cb.l.a(pair7);
                    c14902.L$4 = cb.l.a(file12);
                    c14902.L$5 = cb.l.a(fileResult5);
                    c14902.L$6 = cb.l.a(file15);
                    c14902.L$7 = cb.l.a(file14);
                    c14902.L$8 = fileResult6;
                    c14902.L$9 = u0Var8;
                    c14902.I$0 = i11;
                    c14902.label = 8;
                    objDirectUpload = companion12.directUpload(put12, path13, c14902);
                    if (objDirectUpload != objG) {
                        uri10 = uri9;
                        fileResult7 = fileResult6;
                        objPush = objDirectUpload;
                        u0Var9 = u0Var8;
                        u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                        if (u0Var9.f36629c) {
                            Owner ownerCopy$default13 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                            c14902.L$0 = cb.l.a(uri10);
                            c14902.L$1 = cb.l.a(file13);
                            c14902.L$2 = u0Var9;
                            c14902.L$3 = cb.l.a(pair7);
                            c14902.L$4 = cb.l.a(file12);
                            c14902.L$5 = cb.l.a(fileResult5);
                            c14902.L$6 = cb.l.a(file15);
                            c14902.L$7 = cb.l.a(file14);
                            c14902.L$8 = fileResult7;
                            c14902.L$9 = null;
                            c14902.I$0 = i11;
                            c14902.label = 9;
                            objPush = push(ownerCopy$default13, c14902);
                            if (objPush != objG) {
                                fileResult8 = fileResult7;
                                zBooleanValue2 = ((Boolean) objPush).booleanValue();
                                if (zBooleanValue2) {
                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                                }
                                u0Var9.f36629c = zBooleanValue2;
                            }
                        }
                        u0Var8 = u0Var9;
                    }
                    return objG;
                }
                return cb.b.a(u0Var8.f36629c);
            case 8:
                int i14 = c14902.I$0;
                u0Var8 = (u0) c14902.L$9;
                fileResult7 = (FileResponse.FileResult) c14902.L$8;
                file14 = (File) c14902.L$7;
                file15 = (File) c14902.L$6;
                fileResult5 = (FileResponse.FileResult) c14902.L$5;
                file12 = (File) c14902.L$4;
                pair7 = (Pair) c14902.L$3;
                u0 u0Var18 = (u0) c14902.L$2;
                file13 = (File) c14902.L$1;
                uri10 = (Uri) c14902.L$0;
                ua.v.b(objPush);
                i11 = i14;
                u0Var9 = u0Var18;
                u0Var8.f36629c = ((Boolean) objPush).booleanValue();
                if (u0Var9.f36629c) {
                    Owner ownerCopy$default14 = Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, fileResult7.getGet(), null, null, null, 0L, null, 0, 4063, null);
                    c14902.L$0 = cb.l.a(uri10);
                    c14902.L$1 = cb.l.a(file13);
                    c14902.L$2 = u0Var9;
                    c14902.L$3 = cb.l.a(pair7);
                    c14902.L$4 = cb.l.a(file12);
                    c14902.L$5 = cb.l.a(fileResult5);
                    c14902.L$6 = cb.l.a(file15);
                    c14902.L$7 = cb.l.a(file14);
                    c14902.L$8 = fileResult7;
                    c14902.L$9 = null;
                    c14902.I$0 = i11;
                    c14902.label = 9;
                    objPush = push(ownerCopy$default14, c14902);
                    if (objPush != objG) {
                        fileResult8 = fileResult7;
                        zBooleanValue2 = ((Boolean) objPush).booleanValue();
                        if (zBooleanValue2) {
                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                        }
                        u0Var9.f36629c = zBooleanValue2;
                    }
                    return objG;
                }
                u0Var8 = u0Var9;
                return cb.b.a(u0Var8.f36629c);
            case 9:
                fileResult8 = (FileResponse.FileResult) c14902.L$8;
                u0Var9 = (u0) c14902.L$2;
                ua.v.b(objPush);
                zBooleanValue2 = ((Boolean) objPush).booleanValue();
                if (zBooleanValue2) {
                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor(fileResult8.getGet());
                }
                u0Var9.f36629c = zBooleanValue2;
                u0Var8 = u0Var9;
                return cb.b.a(u0Var8.f36629c);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
