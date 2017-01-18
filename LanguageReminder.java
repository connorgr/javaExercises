import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

class LanguageReminder {
  public static void main(String[] args) {
    // String tests
    StringBuilder dividerBuilder = new StringBuilder();
    for(int i = 0; i < 80; i++) dividerBuilder.append("=");
    String divider = dividerBuilder.toString();

    System.out.println(divider);
    System.out.println("String tests:\n");
    String unicode = "∆üت✅道";
    System.out.println("Unicode Test" + unicode);

    String reverseTest = "Reverse Test";
    StringBuilder reverser = new StringBuilder();
    for(int i = reverseTest.length()-1; i >= 0; i--) {
      reverser.append(reverseTest.charAt(i));
    }
    System.out.println(reverseTest + " : " + reverser.toString());

    reverseTest += " 2";
    String anotherReversed = (new StringBuilder(reverseTest)).reverse().toString();
    System.out.println(reverseTest + " : " + anotherReversed);

    System.out.println("\"asdf\".indexOf(\"道\") : " + "asdf".indexOf("✅"));
    System.out.println("\"asdf\".charAt(3) : " + "asdf".charAt(3));

    System.out.println("\n"+divider+"\n"+divider);

    // File I/O
    // Note that a pro/con list of the many I/O options can be found here:
    // http://stackoverflow.com/questions/21817816
    // Take note of streaming vs. read all into memory options
    ArrayList<String> lines = new ArrayList();
    try {
      Stream<String> stream = Files.lines(Paths.get("ioTest.txt"));
      stream.forEach(line -> lines.add(line));
    } catch(IOException e) {
      e.printStackTrace();
    }
    String original = String.join("\n", lines);

    System.out.println("Original In:");
    System.out.println(original);

    String date = ""+System.currentTimeMillis()+"\n";
    // try { Files.write(Paths.get("ioTest.txt"), date.getBytes()); }
    try { Files.write(Paths.get("ioTest.txt"), date.getBytes(), StandardOpenOption.APPEND); }
    catch(IOException e) { e.printStackTrace(); }

    // More traditional way to read a file
    try {
      FileInputStream fstream = new FileInputStream("ioTest.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      ArrayList<String> lines2 = new ArrayList();
      String strLine;
      while ((strLine = br.readLine()) != null) lines2.add(strLine);
      br.close();

      FileOutputStream ostream = new FileOutputStream("ioTest.txt", true); // true == append
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ostream));
      bw.write("BUFFERED WRITE\n");
      bw.close();
    } catch(IOException e) { e.printStackTrace(); }
  }
}
