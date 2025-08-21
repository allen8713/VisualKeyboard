all:Main.class VisualKeyboardFrame.class

Main.class : Main.java
	javac Main.java

VisualKeyboardFrame.class : VisualKeyboardFrame.java
	javac VisualKeyboardFrame.java



run : 
	make clean
	make
	java Main
	make clean

clean:
	del *.class