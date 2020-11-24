mkdir target

Compilation:
javac -d target src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java

Run:
java -cp target edu.school21.printer.app.Printer --white=o --black=x  full path to //the image//
