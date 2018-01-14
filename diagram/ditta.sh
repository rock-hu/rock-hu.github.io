#!/bin/bash
echo $PATH
echo $CLASSPATH

java -version
javac -version

java -jar ditaa0_9.jar ../mobile/react-native-ditaa.txt 
