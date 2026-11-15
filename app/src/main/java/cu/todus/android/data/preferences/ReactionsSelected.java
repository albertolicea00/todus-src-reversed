package cu.todus.android.data.preferences;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Persisted list of user-selected emoji reactions.
 *
 * @obfuscated_class cu.todus.android.data.preferences.ReactionsSelected
 */
public final class ReactionsSelected {
    private final List<String> list;

    public ReactionsSelected() {
        this(Collections.emptyList());
    }

    public ReactionsSelected(List<String> list) {
        this.list = Objects.requireNonNull(list, "list");
    }

    public List<String> getList() {
        return this.list;
    }

    public ReactionsSelected copy(List<String> list) {
        return new ReactionsSelected(Objects.requireNonNull(list, "list"));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReactionsSelected)
                && Objects.equals(this.list, ((ReactionsSelected) other).list);
    }

    @Override
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override
    public String toString() {
        return "ReactionsSelected(list=" + this.list + ")";
    }
}
