run: teorica.class
	java teorica
	make clean

teorica.class: point.class animal.class dog.class 
	javac teorica.java

point.class:
	javac point.java

animal.class:
	javac animal.java

dog.class: animal.class
	javac dog.java

clean:
	rm *.class