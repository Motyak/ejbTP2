#!/bin/sh
ps=powershell.exe
# Creation des dossiers nécessaires (s'ils n'existent pas déjà)
mkdir -p EJB/META-INF classes
cd EJB &&
# Compilation des sources java
$ps 'javac.exe ..\src\server\monpackage\*.java -d .' &&
# Regroupement des fichiers de l'ejb
$ps 'jar.exe cvf .\ejb_archive.jar .\*' && 
# Déploiement de l'archive jar sur le serveur glassfish
$ps 'asadmin.bat deploy --force .\ejb_archive.jar'