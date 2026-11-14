# Unlinked main-package source review

Target: `cu.todus.android-v30102.apk`, SHA-256
`8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`.

## Purpose and limits

This ledger tracks Java source files in the main application package (`cu.todus.android`) that lack exact clean-source links in `app/src/main/java/`. The ledger is an audit queue, not a decompilation-success metric. JADX decompilation success and source-to-clean class identity links are separate measures, and a link does not prove behavioral equivalence.

Classification categories:
- `application behavior`: UI, routing, domain rules, persistence, messaging protocol, network, or security logic.
- `application support`: shared helpers, base classes, adapters, or internal utilities supporting app behavior.
- `generated`: resource/build output, synthetic bridges, binding code, or compiler-generated machinery (`BuildConfig`, `R`, R8 synthetic classes).
- `third-party/library`: vendored or dependency implementation rather than toDus-specific behavior.

## Current status

Pending initial decompilation (`make decompile`). Populate package-by-package review tables after generating the baseline inventory with `make inventory`.
