run: caneta.class car.class pneu.class aula02.class
	java aula02


pneu.class: pneu.java
	javac pneu.java

car.class: car.java
	javac car.java

caneta.class: caneta.java
	javac caneta.java

aula02.class: aula02.java caneta.class car.class pneu.class
	javac aula02.java

clean:
	rm -f *.class