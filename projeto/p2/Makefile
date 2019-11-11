
.PHONY: all

all:
	javac -cp lib/po-uilib.jar:. `find m19 -name *.java`

run: all
	java -cp lib/po-uilib.jar:. m19.app.App

runA: all #usa o ficheiro ficheiro.im para inicializar a library
	java -Dimport=ficheiro.im -cp lib/po-uilib.jar:. m19.app.App

clean:
	rm -rf `find m19 -name *.class`