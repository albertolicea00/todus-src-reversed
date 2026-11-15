package cu.todus.android.data.db.entity.configs;

/**
 * Hierarchical tag inheritance chain used by notification {@link Config} resolution.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.configs.Heritage
 */
public final class Heritage {

    private final String tag;
    private final Heritage heritage;

    public Heritage(String tag, Heritage heritage) {
        this.tag = tag;
        this.heritage = heritage;
    }

    public String getTag() {
        return tag;
    }

    public Heritage getHeritage() {
        return heritage;
    }

    public static boolean contains(String uid, Heritage heritage) {
        if (heritage.getTag().equals(uid)) {
            return true;
        }
        return heritage.getHeritage() != null && contains(uid, heritage.getHeritage());
    }

    public static String getLeaf(Heritage heritage) {
        return heritage.getHeritage() == null ? heritage.getTag() : getLeaf(heritage.getHeritage());
    }
}
