Make "target" folder
mkdir target

Copy resourcse:
cp -a src/resources target

Compilation:
javac -d target src\java\edu\school21\printer\app\Printer.java src\java\edu\school21\printer\logic\Converter.java

Archive:
jar cvfm target\ImagesToChar.jar src\manifest.txt -C target\ .

Run:
java -jar "target\ImagesToChar.jar" --white=. --black=z
