Compilation:
javac -d target src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java

Run:
java -cp target edu.school21.printer.app.Printer --white=o --black=x img.bmp


"C:\Program Files\Java\jdk1.8.0_112\bin\javac" -d target src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java

"C:\Program Files\Java\jdk1.8.0_112\bin\java.exe" -cp target edu.school21.printer.app.Printer --white=A --black=& img.bmp

"C:\Program Files\Java\jdk1.8.0_112\bin\jar" cvfm target\ImagesToChar.jar src\manifest.txt -C target\ .

java -jar "target\ImagesToChar.jar" --white=RED --black=WHITE

"C:\Program Files\Java\jdk1.8.0_112\bin\jar" -xf lib/jcommander-1.78.jar -C target\ 
"C:\Program Files\Java\jdk1.8.0_112\bin\jar" -xf lib/JCDP-2.0.3.1.jar

"C:\Program Files\Java\jdk1.8.0_112\bin\javac" -d target -cp ".;lib\jcommander-1.78.jar;lib\JCDP-2.0.3.1.jar;lib\jna-5.5.0.jar;lib\jna-platform-5.5.0.jar" src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java