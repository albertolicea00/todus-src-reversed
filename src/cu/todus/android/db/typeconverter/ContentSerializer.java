package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EditedContent;
import cu.todus.android.data.db.pojo.content.EmojiContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.ForwardedContent;
import cu.todus.android.data.db.pojo.content.GifContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.ReactionContent;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import v5.k;
import v5.q;
import v5.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/ContentSerializer;", "Lv5/r;", "Lcu/todus/android/data/db/pojo/content/Content;", "<init>", "()V", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lv5/q;", "context", "Lv5/k;", "serialize", "(Lcu/todus/android/data/db/pojo/content/Content;Ljava/lang/reflect/Type;Lv5/q;)Lv5/k;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentSerializer implements r {
    public static final int $stable = 0;

    @Override // v5.r
    public k serialize(Content src, Type typeOfSrc, q context) {
        y.i(src, "src");
        y.i(context, "context");
        switch (src.getType()) {
            case 1:
                k kVarB = context.b((ImageContent) src);
                y.f(kVarB);
                return kVarB;
            case 2:
                k kVarB2 = context.b((VideoContent) src);
                y.f(kVarB2);
                return kVarB2;
            case 3:
                k kVarB3 = context.b((AudioContent) src);
                y.f(kVarB3);
                return kVarB3;
            case 4:
                k kVarB4 = context.b((VoiceContent) src);
                y.f(kVarB4);
                return kVarB4;
            case 5:
            case 12:
            case 17:
            case 18:
            case 19:
            case 22:
            case 24:
            case 25:
            case 28:
            case 29:
            case 31:
            default:
                k kVarB5 = context.b((FileContent) src);
                y.f(kVarB5);
                return kVarB5;
            case 6:
                k kVarB6 = context.b((ContactContent) src);
                y.f(kVarB6);
                return kVarB6;
            case 7:
                k kVarB7 = context.b((GifContent) src);
                y.f(kVarB7);
                return kVarB7;
            case 8:
                k kVarB8 = context.b((EventContent) src);
                y.f(kVarB8);
                return kVarB8;
            case 9:
                k kVarB9 = context.b((ReplyMsgContent) src);
                y.f(kVarB9);
                return kVarB9;
            case 10:
                k kVarB10 = context.b((LocationContent) src);
                y.f(kVarB10);
                return kVarB10;
            case 11:
                k kVarB11 = context.b((EmojiContent) src);
                y.f(kVarB11);
                return kVarB11;
            case 13:
                k kVarB12 = context.b((StickerContent) src);
                y.f(kVarB12);
                return kVarB12;
            case 14:
                k kVarB13 = context.b((ForwardedContent) src);
                y.f(kVarB13);
                return kVarB13;
            case 15:
                k kVarB14 = context.b((EditedContent) src);
                y.f(kVarB14);
                return kVarB14;
            case 16:
                k kVarB15 = context.b((DeletedContent) src);
                y.f(kVarB15);
                return kVarB15;
            case 20:
                k kVarB16 = context.b((LinkInfoContent) src);
                y.f(kVarB16);
                return kVarB16;
            case 21:
                k kVarB17 = context.b((ButtonContent) src);
                y.f(kVarB17);
                return kVarB17;
            case 23:
                k kVarB18 = context.b((ReactionContent) src);
                y.f(kVarB18);
                return kVarB18;
            case 26:
                k kVarB19 = context.b((StatusTextContent) src);
                y.f(kVarB19);
                return kVarB19;
            case 27:
                k kVarB20 = context.b((StatusImageContent) src);
                y.f(kVarB20);
                return kVarB20;
            case 30:
                k kVarB21 = context.b((StatusVideoContent) src);
                y.f(kVarB21);
                return kVarB21;
            case 32:
                k kVarB22 = context.b((CallContent) src);
                y.f(kVarB22);
                return kVarB22;
        }
    }
}
