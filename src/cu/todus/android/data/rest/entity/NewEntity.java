package cu.todus.android.data.rest.entity;

import androidx.compose.runtime.Immutable;
import defpackage.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003Je\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcu/todus/android/data/rest/entity/NewEntity;", "", "id", "", "title", "reduced", "description", "releaseDate", "", "author", "body", "configs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getTitle", "getReduced", "getDescription", "getReleaseDate", "()J", "getAuthor", "getBody", "getConfigs", "()Ljava/util/Map;", "getColor", "getImagePreview", "getAuthorImage", "getConfigSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NewEntity {
    public static final int $stable = 0;
    public static final String NEWS_AUTHOR_IMAGE = "author_image";
    public static final String NEWS_CONFIG_COLOR = "color";
    public static final String NEWS_CONFIG_IMAGE_PREVIEW = "image";
    public static final String NEWS_CONFIG_SOURCE = "source";
    private final String author;
    private final String body;
    private final Map<String, String> configs;
    private final String description;
    private final String id;
    private final String reduced;
    private final long releaseDate;
    private final String title;

    public NewEntity(String id2, String title, String reduced, String description, long j10, String author, String body, Map<String, String> configs) {
        y.i(id2, "id");
        y.i(title, "title");
        y.i(reduced, "reduced");
        y.i(description, "description");
        y.i(author, "author");
        y.i(body, "body");
        y.i(configs, "configs");
        this.id = id2;
        this.title = title;
        this.reduced = reduced;
        this.description = description;
        this.releaseDate = j10;
        this.author = author;
        this.body = body;
        this.configs = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewEntity copy$default(NewEntity newEntity, String str, String str2, String str3, String str4, long j10, String str5, String str6, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = newEntity.id;
        }
        if ((i10 & 2) != 0) {
            str2 = newEntity.title;
        }
        if ((i10 & 4) != 0) {
            str3 = newEntity.reduced;
        }
        if ((i10 & 8) != 0) {
            str4 = newEntity.description;
        }
        if ((i10 & 16) != 0) {
            j10 = newEntity.releaseDate;
        }
        if ((i10 & 32) != 0) {
            str5 = newEntity.author;
        }
        if ((i10 & 64) != 0) {
            str6 = newEntity.body;
        }
        if ((i10 & 128) != 0) {
            map = newEntity.configs;
        }
        Map map2 = map;
        String str7 = str5;
        long j11 = j10;
        String str8 = str3;
        String str9 = str4;
        return newEntity.copy(str, str2, str8, str9, j11, str7, str6, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReduced() {
        return this.reduced;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getReleaseDate() {
        return this.releaseDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> component8() {
        return this.configs;
    }

    public final NewEntity copy(String id2, String title, String reduced, String description, long releaseDate, String author, String body, Map<String, String> configs) {
        y.i(id2, "id");
        y.i(title, "title");
        y.i(reduced, "reduced");
        y.i(description, "description");
        y.i(author, "author");
        y.i(body, "body");
        y.i(configs, "configs");
        return new NewEntity(id2, title, reduced, description, releaseDate, author, body, configs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewEntity)) {
            return false;
        }
        NewEntity newEntity = (NewEntity) other;
        return y.d(this.id, newEntity.id) && y.d(this.title, newEntity.title) && y.d(this.reduced, newEntity.reduced) && y.d(this.description, newEntity.description) && this.releaseDate == newEntity.releaseDate && y.d(this.author, newEntity.author) && y.d(this.body, newEntity.body) && y.d(this.configs, newEntity.configs);
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getAuthorImage() {
        return this.configs.get(NEWS_AUTHOR_IMAGE);
    }

    public final String getBody() {
        return this.body;
    }

    public final String getColor() {
        return this.configs.get("color");
    }

    public final String getConfigSource() {
        return this.configs.get(NEWS_CONFIG_SOURCE);
    }

    public final Map<String, String> getConfigs() {
        return this.configs;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImagePreview() {
        return this.configs.get("image");
    }

    public final String getReduced() {
        return this.reduced;
    }

    public final long getReleaseDate() {
        return this.releaseDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.reduced.hashCode()) * 31) + this.description.hashCode()) * 31) + l.a(this.releaseDate)) * 31) + this.author.hashCode()) * 31) + this.body.hashCode()) * 31) + this.configs.hashCode();
    }

    public String toString() {
        return "NewEntity(id=" + this.id + ", title=" + this.title + ", reduced=" + this.reduced + ", description=" + this.description + ", releaseDate=" + this.releaseDate + ", author=" + this.author + ", body=" + this.body + ", configs=" + this.configs + ")";
    }
}
