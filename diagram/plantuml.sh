#!/bin/bash
set PLANTUML_LIMIT_SIZE=81920

echo $PATH
echo $CLASSPATH

java -version
javac -version

java -jar plantuml.jar
