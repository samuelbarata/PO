
.PHONY: all clean run test jar

all: lib/po-uilib.jar
	@clear
	javac -cp lib/po-uilib.jar:. `find m19 -name *.java`

run: all
	@java -Dimport=tests/A-99-99-M-ok.import -cp lib/po-uilib.jar:. m19.app.App

runy: all
	@java -cp lib/po-uilib.jar:. m19.app.App
clean:
	@rm -rf `find m19 -name *.class` tests/*.outhyp tests/*.diff proj2.jar 0 1 2 3 4 5 6 7 8 9 10 s requisicao cumpridor faltoso user work works tests/*.out2 notificacao

individual: all
	java -Dimport=tests/A-99-98-M-ok.import -cp lib/po-uilib.jar:. m19.app.App

test: all
	@./runtests.sh

jar:
	@jar -cvf proj.jar `find m19 -name "*.java"`
