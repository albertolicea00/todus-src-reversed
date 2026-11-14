package cu.todus.android.uiCompose.main.screen.chat.item;

import android.content.Context;
import android.text.format.DateFormat;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material.MenuKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.utils.DateFormatter;
import cu.z17.views.label.Z17LabelKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import va.n0;
import va.o0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "msg", "", "resendLabel", "editedLabel", "createTags", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "", "createReactionsText", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;)Ljava/util/Map;", "", "createAt", "Landroid/content/Context;", "context", "createTime", "(JLandroid/content/Context;)Ljava/lang/String;", "state", "createStatus", "(I)Ljava/lang/String;", "Landroidx/compose/ui/Modifier;", "modifier", "Lua/k0;", "OutgoingMsgStatus", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Landroidx/compose/runtime/Composer;I)V", "IncomingMsgStatus", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MsgStatusKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void IncomingMsgStatus(final Modifier modifier, final MessageWithPartnerWithReactions msg, Composer composer, final int i10) {
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(msg, "msg");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1260298384);
        int i11 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(msg) ? 32 : 16;
        }
        int i12 = 18;
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1260298384, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.IncomingMsgStatus (MsgStatus.kt:129)");
            }
            composerStartRestartGroup.startReplaceGroup(34036778);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            composerStartRestartGroup.startReplaceGroup(34036831);
            int i13 = 10;
            int iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(10), (FontWeight) null, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65525, (kotlin.jvm.internal.p) null));
            try {
                builder.append(createTags(msg, StringResources_androidKt.stringResource(R.string.forwarded, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.edited, composerStartRestartGroup, 0)));
                ua.k0 k0Var = ua.k0.f43947a;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                for (Map.Entry<String, Integer> entry : createReactionsText(msg).entrySet()) {
                    long sp = TextUnitKt.getSp(i12);
                    FontWeight.Companion companion = FontWeight.INSTANCE;
                    FontWeight bold = companion.getBold();
                    long sp2 = TextUnitKt.getSp(1);
                    TextUnitKt.m9026checkArithmeticR2X_6o(sp2);
                    int i14 = i13;
                    int iPushStyle2 = builder.pushStyle(new SpanStyle(0L, sp, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(sp2), -TextUnit.m9013getValueimpl(sp2)), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65401, (kotlin.jvm.internal.p) null));
                    try {
                        builder.append(" ");
                        InlineTextContentKt.appendInlineContent$default(builder, entry.getKey(), null, 2, null);
                        builder.append(" ");
                        ua.k0 k0Var2 = ua.k0.f43947a;
                        builder.pop(iPushStyle2);
                        int iPushStyle3 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(16), companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (kotlin.jvm.internal.p) null));
                        try {
                            if (entry.getValue().intValue() > 1) {
                                builder.append(String.valueOf(entry.getValue().intValue()));
                            }
                            builder.pop(iPushStyle3);
                            i13 = i14;
                            i12 = 18;
                        } catch (Throwable th2) {
                            builder.pop(iPushStyle3);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        builder.pop(iPushStyle2);
                        throw th3;
                    }
                }
                composerStartRestartGroup.startReplaceGroup(34074371);
                int iPushStyle4 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(i13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (kotlin.jvm.internal.p) null));
                try {
                    builder.append(" ");
                    builder.append(createTime(msg.getMessage().getCreateAt(), (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    ua.k0 k0Var3 = ua.k0.f43947a;
                    builder.pop(iPushStyle4);
                    composerStartRestartGroup.endReplaceGroup();
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = ReactionsRepository.m9801inlineContentR2X_6o$default(ReactionsRepository.INSTANCE.getInstance(), 0L, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Z17LabelKt.m10261Z17Label3f6hBDE(modifier, annotatedString, (Map) objRememberedValue, null, 0L, 0, 0, composerStartRestartGroup, i11 & 14, MenuKt.InTransitionDuration);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } catch (Throwable th4) {
                    builder.pop(iPushStyle4);
                    throw th4;
                }
            } catch (Throwable th5) {
                builder.pop(iPushStyle);
                throw th5;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgStatusKt.IncomingMsgStatus$lambda$2(modifier, msg, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 IncomingMsgStatus$lambda$2(Modifier modifier, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10, Composer composer, int i11) {
        IncomingMsgStatus(modifier, messageWithPartnerWithReactions, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OutgoingMsgStatus(final Modifier modifier, final MessageWithPartnerWithReactions msg, Composer composer, final int i10) {
        kotlin.jvm.internal.y.i(modifier, "modifier");
        kotlin.jvm.internal.y.i(msg, "msg");
        Composer composerStartRestartGroup = composer.startRestartGroup(469128246);
        int i11 = (i10 & 6) == 0 ? (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10 : i10;
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(msg) ? 32 : 16;
        }
        int i12 = 18;
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(469128246, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.item.OutgoingMsgStatus (MsgStatus.kt:61)");
            }
            composerStartRestartGroup.startReplaceGroup(-139315210);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            composerStartRestartGroup.startReplaceGroup(-139315291);
            int i13 = 10;
            int iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(10), (FontWeight) null, FontStyle.m8368boximpl(FontStyle.INSTANCE.m8377getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65525, (kotlin.jvm.internal.p) null));
            try {
                builder.append(createTags(msg, StringResources_androidKt.stringResource(R.string.forwarded, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.edited, composerStartRestartGroup, 0)));
                ua.k0 k0Var = ua.k0.f43947a;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                for (Map.Entry<String, Integer> entry : createReactionsText(msg).entrySet()) {
                    long sp = TextUnitKt.getSp(i12);
                    FontWeight.Companion companion = FontWeight.INSTANCE;
                    FontWeight bold = companion.getBold();
                    long sp2 = TextUnitKt.getSp(1);
                    TextUnitKt.m9026checkArithmeticR2X_6o(sp2);
                    int i14 = i13;
                    int iPushStyle2 = builder.pushStyle(new SpanStyle(0L, sp, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.pack(TextUnit.m9011getRawTypeimpl(sp2), -TextUnit.m9013getValueimpl(sp2)), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65401, (kotlin.jvm.internal.p) null));
                    try {
                        builder.append(" ");
                        InlineTextContentKt.appendInlineContent$default(builder, entry.getKey(), null, 2, null);
                        builder.append(" ");
                        ua.k0 k0Var2 = ua.k0.f43947a;
                        builder.pop(iPushStyle2);
                        int iPushStyle3 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(16), companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (kotlin.jvm.internal.p) null));
                        try {
                            if (entry.getValue().intValue() > 1) {
                                builder.append(String.valueOf(entry.getValue().intValue()));
                            }
                            builder.pop(iPushStyle3);
                            i13 = i14;
                            i12 = 18;
                        } catch (Throwable th2) {
                            builder.pop(iPushStyle3);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        builder.pop(iPushStyle2);
                        throw th3;
                    }
                }
                composerStartRestartGroup.startReplaceGroup(-139277723);
                int iPushStyle4 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(i13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (kotlin.jvm.internal.p) null));
                try {
                    builder.append(" ");
                    builder.append(createTime(msg.getMessage().getCreateAt(), (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    builder.append(" ");
                    ua.k0 k0Var3 = ua.k0.f43947a;
                    builder.pop(iPushStyle4);
                    composerStartRestartGroup.endReplaceGroup();
                    String strCreateStatus = createStatus(msg.getMessage().getState());
                    if (strCreateStatus != null) {
                        InlineTextContentKt.appendInlineContent$default(builder, strCreateStatus, null, 2, null);
                    }
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = ReactionsRepository.m9801inlineContentR2X_6o$default(ReactionsRepository.INSTANCE.getInstance(), 0L, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Z17LabelKt.m10261Z17Label3f6hBDE(modifier, annotatedString, (Map) objRememberedValue, null, 0L, 0, 0, composerStartRestartGroup, i11 & 14, MenuKt.InTransitionDuration);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } catch (Throwable th4) {
                    builder.pop(iPushStyle4);
                    throw th4;
                }
            } catch (Throwable th5) {
                builder.pop(iPushStyle);
                throw th5;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MsgStatusKt.OutgoingMsgStatus$lambda$2(modifier, msg, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 OutgoingMsgStatus$lambda$2(Modifier modifier, MessageWithPartnerWithReactions messageWithPartnerWithReactions, int i10, Composer composer, int i11) {
        OutgoingMsgStatus(modifier, messageWithPartnerWithReactions, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }

    public static final Map<String, Integer> createReactionsText(MessageWithPartnerWithReactions msg) {
        kotlin.jvm.internal.y.i(msg, "msg");
        List<Reaction> reactions = msg.getReactions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : reactions) {
            if (!le.d0.q0(((Reaction) obj).getReactionContent())) {
                arrayList.add(obj);
            }
        }
        final ArrayList arrayList2 = new ArrayList(va.x.y(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Reaction) it.next()).getReactionContent());
        }
        return o0.a(new n0() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.MsgStatusKt$createReactionsText$$inlined$groupingBy$1
            @Override // va.n0
            public String keyOf(String element) {
                return element;
            }

            @Override // va.n0
            public Iterator<String> sourceIterator() {
                return arrayList2.iterator();
            }
        });
    }

    public static final String createStatus(int i10) {
        switch (i10) {
            case 1:
                return "server";
            case 2:
                return "received";
            case 3:
                return "read";
            case 4:
                return "unable";
            case 5:
            case 6:
                return "sentryUnsent";
            case 7:
                return "timeout";
            default:
                return null;
        }
    }

    public static final String createTags(MessageWithPartnerWithReactions msg, String resendLabel, String editedLabel) {
        String str;
        kotlin.jvm.internal.y.i(msg, "msg");
        kotlin.jvm.internal.y.i(resendLabel, "resendLabel");
        kotlin.jvm.internal.y.i(editedLabel, "editedLabel");
        List<Attachment> attachments = msg.getAttachments();
        if (!defpackage.r.a(attachments) || !attachments.isEmpty()) {
            Iterator<T> it = attachments.iterator();
            while (it.hasNext()) {
                if (((Attachment) it.next()).getType() == 14) {
                    return resendLabel + " ";
                }
            }
        }
        List<Attachment> attachments2 = msg.getAttachments();
        if (defpackage.r.a(attachments2) && attachments2.isEmpty()) {
            str = "";
        } else {
            Iterator<T> it2 = attachments2.iterator();
            while (it2.hasNext()) {
                if (((Attachment) it2.next()).getType() == 15) {
                    str = editedLabel + " ";
                }
            }
            str = "";
        }
        return str;
    }

    public static final String createTime(long j10, Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        return " " + DateFormatter.INSTANCE.format(new Date(j10), DateFormat.is24HourFormat(context) ? DateFormatter.Template.TIME : DateFormatter.Template.TIME_12);
    }
}
