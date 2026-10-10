import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CountJavaTests {
    
    private static final String TEST_ROOT_PATH = "src/test/java";
    private static final String TEST_SUFFIX = "Test.java";
    private static final String TESTS_SUFFIX = "Tests.java";
    
    public static void main(String[] args) throws IOException {
        Path testRoot = Path.of(TEST_ROOT_PATH);
        long count = 0;

        if (Files.isDirectory(testRoot)) {
            try (Stream<Path> files = Files.walk(testRoot)) {
                count = files
                        .filter(Files::isRegularFile)
                        .filter(CountJavaTests::isTestFile)
                        .count();
            }
        }

        System.out.println("{\"tests\": " + count + "}");
    }
    
    private static boolean isTestFile(Path path) {
        String name = path.getFileName().toString();
        return name.endsWith(TEST_SUFFIX) || name.endsWith(TESTS_SUFFIX);
    }
}
