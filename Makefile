source := App
dest := Bin
app := App

all: compile run
compile:
	javac -d ${dest} ${source}/${app}.java
run:
	java -cp ${dest} ${source}/${app}

clean:
	rm -r Bin
