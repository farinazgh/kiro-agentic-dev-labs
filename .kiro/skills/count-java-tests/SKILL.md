---
name: count-java-tests
description: Count Java test source files in this Maven/Spring Boot project. Use when asked how many Java test files are in the repository.
---

# Count Java Test Files

1. From the workspace root, run `java .kiro/skills/count-java-tests/scripts/CountJavaTests.java` using the terminal tool.
2. Read the JSON printed to standard output, for example `{ "tests": 3 }`.
3. Replace `{tests}` in [TEMPLATE.md](./TEMPLATE.md) with the JSON `tests` value and respond using that template.
4. Do not invent a number. If execution fails, report the error.

Count *files* named `*Test.java` or `*Tests.java` under `src/test/java`, not individual test methods.
