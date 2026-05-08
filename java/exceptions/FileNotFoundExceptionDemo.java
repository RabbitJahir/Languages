// ─────────────────────────────────────────────
//  FileNotFoundException & IOException
//  FileNotFoundException: file doesn't exist or
//    can't be opened.
//  IOException: general I/O failure (parent class).
// ─────────────────────────────────────────────

import java.io.*;
import java.nio.file.*;

public class FileNotFoundExceptionDemo {

    public static void main(String[] args) {

        // ── Example 1: Reading a non-existent file ──────────────────────
        System.out.println("=== Example 1: File doesn't exist ===");
        try {
            FileReader reader = new FileReader("ghost.txt");  // throws FileNotFoundException
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // ── Example 2: BufferedReader on a missing file ─────────────────
        System.out.println("\n=== Example 2: BufferedReader on missing file ===");
        try (BufferedReader br = new BufferedReader(new FileReader("missing_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Caught: file not found — " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException while reading: " + e.getMessage());
        }

        // ── Fix: Check if file exists before opening ────────────────────
        System.out.println("\n=== Fix 1: Check existence before reading ===");
        File file = new File("ghost.txt");
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                System.out.println("First line: " + br.readLine());
            } catch (IOException e) {
                System.out.println("Caught: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist — skipping read.");
        }

        // ── Fix: Create, write to, then read back a real temp file ──────
        System.out.println("\n=== Fix 2: Write then read a real file ===");
        String tempPath = System.getProperty("java.io.tmpdir") + "/demo_output.txt";

        // Write
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempPath))) {
            bw.write("Line 1: Hello from Java!");
            bw.newLine();
            bw.write("Line 2: FileWriter works.");
            bw.newLine();
            System.out.println("File written to: " + tempPath);
        } catch (IOException e) {
            System.out.println("Write failed: " + e.getMessage());
        }

        // Read back
        try (BufferedReader br = new BufferedReader(new FileReader(tempPath))) {
            System.out.println("--- File contents ---");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }

        // ── Modern: java.nio.file.Files (cleaner API) ───────────────────
        System.out.println("\n=== Fix 3: java.nio.file.Files (modern approach) ===");
        Path nioPath = Paths.get(tempPath);
        try {
            // Write
            Files.writeString(nioPath, "Written with NIO!\nLine 2 via NIO.");
            // Read all lines at once
            var lines = Files.readAllLines(nioPath);
            lines.forEach(System.out::println);
        } catch (NoSuchFileException e) {
            System.out.println("NIO: file not found — " + e.getFile());
        } catch (IOException e) {
            System.out.println("NIO IOException: " + e.getMessage());
        }
    }
}
