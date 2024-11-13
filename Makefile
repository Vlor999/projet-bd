#Compilation
#  -d : repertoire ou sont placés les fichiers .class compilés
#  -sourcepath : repertoire ou sont cherché les fichiers .java
#  -classpath : repertoire ou sont cherché les fichiers .class 

all: connexion

connexion : 
	javac -d bin -classpath lib/ojdbc6.jar -sourcepath src src/lecteur.java

run:
	java -classpath bin:lib/ojdbc6.jar lecteur

clean:
	rm -rf bin/*

.PHONY: all connexion run clean
