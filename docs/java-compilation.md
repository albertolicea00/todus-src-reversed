# Hybrid Java compiler audit

Target: `cu.todus.android-v30102.apk`, SHA-256
`8da7f305e9763e542b087935714b726fafa3e26105e9e6f96261074c56461ce1`.

`scripts/compile-reconstruction.py` compiles every Java source under
`app/src/main/java` against a **local APK-derived bytecode jar** and a **local
Android platform jar**. This is a dependency-backed compiler audit: it detects
unresolved symbols, invalid signatures, type mismatches, and other Java errors
in the reconstructed tree while retaining the APK's raw dependencies.
It is not a standalone Android build, an APK produced from clean source, a
resource-packaging test, behavioral equivalence, or runtime verification.

## Local prerequisites and provenance

- Python 3 and a JDK with `javac` on `PATH`.
- The target APK remains local in `.workspace/bin/cu.todus.android-v30102.apk`.
- Pin dex2jar to **2.4**, using its official
  [v2.4 release](https://github.com/pxb1988/dex2jar/releases/tag/v2.4) and
  [dex-tools-v2.4.zip asset](https://github.com/pxb1988/dex2jar/releases/download/v2.4/dex-tools-v2.4.zip)
  under `.workspace/tools/dex-tools-v2.4/`.
- Convert the target APK bytecode to `.workspace/tools/target-bytecode.jar`:

```sh
bash .workspace/tools/dex-tools-v2.4/d2j-dex2jar.sh \
  -f -o .workspace/tools/target-bytecode.jar \
  .workspace/bin/cu.todus.android-v30102.apk
```

## Run the full audit

Once decompilation (`src/cu/todus/android/R.java`) and clean Java files exist under `app/src/main/java/`:

```sh
make compile-audit ANDROID_JAR="$HOME/Library/Android/sdk/platforms/android-36/android.jar"
```

The script writes `.workspace/compile-reconstruction/report.json` and `.workspace/compile-reconstruction/javac.log`.
