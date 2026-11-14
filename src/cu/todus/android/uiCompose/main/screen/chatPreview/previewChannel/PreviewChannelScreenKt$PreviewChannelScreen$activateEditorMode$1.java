package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.PsExtractor;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.z17.views.form.FormItemRequest;
import cu.z17.views.form.FormItemType;
import cu.z17.views.form.UtilRegex;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y0;
import pe.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1", f = "PreviewChannelScreen.kt", l = {191}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1 extends cb.m implements Function2 {
    final /* synthetic */ String $deleteImageLabel;
    final /* synthetic */ MutableState<Boolean> $editorModeActive$delegate;
    final /* synthetic */ List<FormItemRequest> $editorParams;
    final /* synthetic */ String $imageLabel;
    final /* synthetic */ String $informationLabel;
    final /* synthetic */ y0 $lastImage;
    final /* synthetic */ String $nameLabel;
    final /* synthetic */ State<Room> $preview$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1(y0 y0Var, List<FormItemRequest> list, String str, String str2, String str3, String str4, State<Room> state, MutableState<Boolean> mutableState, ab.e<? super PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1> eVar) {
        super(2, eVar);
        this.$lastImage = y0Var;
        this.$editorParams = list;
        this.$imageLabel = str;
        this.$deleteImageLabel = str2;
        this.$nameLabel = str3;
        this.$informationLabel = str4;
        this.$preview$delegate = state;
        this.$editorModeActive$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1(this.$lastImage, this.$editorParams, this.$imageLabel, this.$deleteImageLabel, this.$nameLabel, this.$informationLabel, this.$preview$delegate, this.$editorModeActive$delegate, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0114  */
    /* JADX WARN: Code duplicated, block: B:49:0x011d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0139  */
    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        String picture;
        String onlyName;
        String str;
        String onlyName2;
        Room roomPreviewChannelScreen$lambda$0;
        String onlySubject;
        Room roomPreviewChannelScreen$lambda$1;
        String onlySubject2;
        String str2;
        Room roomPreviewChannelScreen$lambda$2;
        String onlySubject3;
        String onlyName3;
        String picture2;
        Object objG = bb.b.g();
        int i10 = this.label;
        String strSubstring = "";
        if (i10 == 0) {
            ua.v.b(obj);
            y0 y0Var = this.$lastImage;
            Room roomPreviewChannelScreen$lambda$3 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
            if (roomPreviewChannelScreen$lambda$3 == null || (picture = roomPreviewChannelScreen$lambda$3.getPicture()) == null) {
                picture = "";
            }
            y0Var.f36634c = picture;
            this.$editorParams.clear();
            this.label = 1;
            if (w0.b(10L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        List<FormItemRequest> list = this.$editorParams;
        FormItemType formItemType = FormItemType.LARGE_IMAGE;
        String str3 = this.$imageLabel;
        Room roomPreviewChannelScreen$lambda$4 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
        FormItemRequest formItemRequest = new FormItemRequest("image", formItemType, str3, "", (roomPreviewChannelScreen$lambda$4 == null || (picture2 = roomPreviewChannelScreen$lambda$4.getPicture()) == null) ? "" : picture2, "", "", 0, 0.0f, null, null, 1920, null);
        FormItemRequest formItemRequest2 = new FormItemRequest("delete_image", FormItemType.MULTIPLE_SELECTION, "", "", "", "", "", 0, 0.0f, va.v.e(this.$deleteImageLabel), null, 1408, null);
        FormItemType formItemType2 = FormItemType.TEXT;
        String str4 = this.$nameLabel;
        Room roomPreviewChannelScreen$lambda$5 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
        if (roomPreviewChannelScreen$lambda$5 == null || (onlyName = roomPreviewChannelScreen$lambda$5.getOnlyName()) == null) {
            onlyName = "";
        }
        if (onlyName.length() <= 150) {
            Room roomPreviewChannelScreen$lambda$6 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
            if (roomPreviewChannelScreen$lambda$6 == null || (onlyName2 = roomPreviewChannelScreen$lambda$6.getOnlyName()) == null) {
                str = "";
            }
            FormItemRequest formItemRequest3 = new FormItemRequest("name", formItemType2, str4, "", str, UtilRegex.CANNOT_BE_EMPTY, "", 150, 0.0f, null, null, 1792, null);
            FormItemType formItemType3 = FormItemType.LARGE_TEXT;
            String str5 = this.$informationLabel;
            roomPreviewChannelScreen$lambda$0 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
            if (roomPreviewChannelScreen$lambda$0 != null || (onlySubject = roomPreviewChannelScreen$lambda$0.getOnlySubject()) == null) {
                onlySubject = "";
            }
            if (onlySubject.length() > 250) {
                roomPreviewChannelScreen$lambda$1 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
                if (roomPreviewChannelScreen$lambda$1 == null && (onlySubject2 = roomPreviewChannelScreen$lambda$1.getOnlySubject()) != null) {
                    str2 = onlySubject2;
                }
                list.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest3, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType3, str5, "", str2, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
                PreviewChannelScreenKt.PreviewChannelScreen$lambda$19(this.$editorModeActive$delegate, true);
                return ua.k0.f43947a;
            }
            roomPreviewChannelScreen$lambda$2 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
            if (roomPreviewChannelScreen$lambda$2 != null && (onlySubject3 = roomPreviewChannelScreen$lambda$2.getOnlySubject()) != null) {
                strSubstring = onlySubject3;
            }
            strSubstring = strSubstring.substring(0, 200);
            kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
            str2 = strSubstring;
            list.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest3, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType3, str5, "", str2, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
            PreviewChannelScreenKt.PreviewChannelScreen$lambda$19(this.$editorModeActive$delegate, true);
            return ua.k0.f43947a;
        }
        Room roomPreviewChannelScreen$lambda$7 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
        if (roomPreviewChannelScreen$lambda$7 == null || (onlyName3 = roomPreviewChannelScreen$lambda$7.getOnlyName()) == null) {
            onlyName3 = "";
        }
        onlyName2 = onlyName3.substring(0, 150);
        kotlin.jvm.internal.y.h(onlyName2, "substring(...)");
        str = onlyName2;
        FormItemRequest formItemRequest4 = new FormItemRequest("name", formItemType2, str4, "", str, UtilRegex.CANNOT_BE_EMPTY, "", 150, 0.0f, null, null, 1792, null);
        FormItemType formItemType4 = FormItemType.LARGE_TEXT;
        String str6 = this.$informationLabel;
        roomPreviewChannelScreen$lambda$0 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
        if (roomPreviewChannelScreen$lambda$0 != null) {
            onlySubject = "";
        } else {
            onlySubject = "";
        }
        if (onlySubject.length() > 250) {
            roomPreviewChannelScreen$lambda$1 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
            if (roomPreviewChannelScreen$lambda$1 == null) {
            }
            list.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest4, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType4, str6, "", str2, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
            PreviewChannelScreenKt.PreviewChannelScreen$lambda$19(this.$editorModeActive$delegate, true);
            return ua.k0.f43947a;
        }
        roomPreviewChannelScreen$lambda$2 = PreviewChannelScreenKt.PreviewChannelScreen$lambda$0(this.$preview$delegate);
        if (roomPreviewChannelScreen$lambda$2 != null) {
            strSubstring = onlySubject3;
        }
        strSubstring = strSubstring.substring(0, 200);
        kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
        str2 = strSubstring;
        list.addAll(va.w.q(formItemRequest, formItemRequest2, formItemRequest4, new FormItemRequest(TtmlNode.TAG_INFORMATION, formItemType4, str6, "", str2, "", "", PsExtractor.VIDEO_STREAM_MASK, 0.0f, null, null, 1792, null)));
        PreviewChannelScreenKt.PreviewChannelScreen$lambda$19(this.$editorModeActive$delegate, true);
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((PreviewChannelScreenKt$PreviewChannelScreen$activateEditorMode$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
