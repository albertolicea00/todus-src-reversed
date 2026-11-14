package cu.z17.views.form;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class FormItemViewKt$FormItemView$1$1$8$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ FormItemRequest $formItemRequest;
    final /* synthetic */ Function1 $updateItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormItemViewKt$FormItemView$1$1$8$1(Function1 function1, FormItemRequest formItemRequest) {
        super(1, kotlin.jvm.internal.y.a.class, "handleChange", "FormItemView$lambda$19$handleChange(Lkotlin/jvm/functions/Function1;Lcu/z17/views/form/FormItemRequest;Ljava/lang/String;)V", 0);
        this.$updateItem = function1;
        this.$formItemRequest = formItemRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return ua.k0.f43947a;
    }

    public final void invoke(String p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        FormItemViewKt.FormItemView$lambda$19$handleChange(this.$updateItem, this.$formItemRequest, p10);
    }
}
