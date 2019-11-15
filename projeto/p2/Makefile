
.PHONY: all clean

all:
	@clear
	javac -cp lib/po-uilib.jar:. `find m19 -name *.java`

run: all #usa o ficheiro ficheiro.im para inicializar a library
	@java -Dimport=ficheiro.im -cp lib/po-uilib.jar:. m19.app.App

clean:
	@rm -rf `find m19 -name *.class` tests/*.outhyp tests/*.diff proj2.jar
	

test: all
	@./runtests.sh
	@make clean

deliver:
	@jar -cvf proj2.jar `find m19 -name "*.java"`
	
