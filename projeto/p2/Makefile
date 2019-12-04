
.PHONY: all clean run test jar

all: lib/po-uilib.jar
	@clear
	javac -cp lib/po-uilib.jar:. `find m19 -name *.java`

run: all #usa o ficheiro ficheiro.im para inicializar a library
	@java -Dimport=ficheiro.im -cp lib/po-uilib.jar:. m19.app.App

clean:
	@rm -rf `find m19 -name *.class` tests/*.outhyp tests/*.diff proj2.jar 0 1 2 cumpridor faltoso user work works tests/*.out2
	

test: all
	@./runtests.sh

jar:
	@jar -cvf proj.jar `find m19 -name "*.java"`
