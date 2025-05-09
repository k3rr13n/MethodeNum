#!/bin/bash
mvn compile
mvn exec:java -Dexec.mainClass="java.fr.univ_orleans.iut45.r207.tp2.App"

# Permet de convertir un fichier .dot en pdf
# dot -Tpdf graph.dot -o graph.pdf
