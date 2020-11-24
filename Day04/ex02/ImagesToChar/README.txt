Compilation:
javac -d target -cp "lib\jcommander-1.78.jar;lib\JCDP-2.0.1.jar;." src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java

Copy resourcse:
copy src\resources\img.bmp target\resources\
jar -xf lib\jcommander-1.78.jar
jar -xf lib\JCDP-2.0.1.jar
move com\. target\

Archive:
jar cvfm target\ImagesToChar.jar src\manifest.txt -C target\ .

Run:
java -jar "target\ImagesToChar.jar" --white=WHITE --black=BLACK
