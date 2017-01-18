.PHONY=all clean

FILE=HelloWorld

all:
	javac -classpath . $(FILE).java; java -classpath . $(FILE)

clean:
	rm *.class
