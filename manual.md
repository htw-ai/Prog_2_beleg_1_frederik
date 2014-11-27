Das vorliegende JAVA(v1.6) Programm dient zur Berechnung von Vektor Operationen.

Bedienung:

Das kompilierte Programm wird mit `$ java Main` aufgerufen.
Es wird eine Liste von den vorhandenen Operationen in der Konsole ausgegeben.
Das Programm wird Sie nach den notwendigen Eingaben fragen.
Es handelt sich dabei um Vektoren. Diese werden in der Haskell List notation angegeben (Transponierter Vektor): x:xs
Zum Beispiel: 1.23:2.12:3:4.0002:43.2
Ein Punkt wird anstatt einem Komma benutzt um rationale Zahlen abzubilden.
Wenn die Berechnung erfolgreich war, wird das Ergebnis in der Konsole ausgegeben.
Darauf hin werden sie gefragt ob sie noch eine Berechnung vornehmen wollen.
Bei einer Eingaben von einem grossen 'J' fängt das Programm von vorne an.
Bei jeder anderen Eingabe terminiert das Programm.
Jede Eingabe des Programms wird mit einem Enter bestätigt.

Testbeispiele:

1)
```zsh
Geben sie die Methode ein die Sie anwenden möchten
> einheitsvektor
Geben sie einen zweiten Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen
> 4:3
[0.8, 0.6000000000000001]
```
Ergebnis: (0.8, 0.6)
Quelle: http://www.mathe-lexikon.at/algebra/vektoralgebra/vektor-grundlagen/einheitsvektor.html

2)
```zsh
Geben sie die Methode ein die Sie anwenden möchten
> skalarprodukt
Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen
> 2:-4:0
Geben sie einen zweiten Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen
> 3:2:5
-2.0
```
Ergebnis: -2
Quelle: http://www.mathebibel.de/skalarprodukt

3)
```zsh
Geben sie die Methode ein die Sie anwenden möchten
>spatprodukt
Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen
>2:0:5
Geben sie einen zweiten Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen
>-1:5:-2
Geben sie einen dritten Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen
>2:1:2
31.0
```

Ergebnis: 31
Quelle: http://www.frustfrei-lernen.de/mathematik/spatprodukt.html


Implementation

Das Programm ist in drei Klassen unterteilt: Main, Vektor, VektorCliAdapter
Die Vektor Klasse hat alle Methoden zur Berechnung von Vektoren.
Die Vektor Klasse interagiert nicht mit der Aussenwelt, sondern nur in einem Java Kontext.
Dies wurde gemacht um die Methoden besser mit JUnit testen zu können. Dadurch kann man sichergehen, dass die Berechnungen alle
korrekt sind.
Die Vektor Klasse besitzt zudem eine toString Methode, welche eine vektor Instanze zu einer String Representation umwandelt.
Weiterhin gibt es optionale Gültigkeitserklärung Methoden auf der vektor Klasse die von Adaptern verwendet werden können.


Die VektorCliAdapter Klasse ist ein Adapter zwischen Konsole und der vektor Klasse.
Der Adapter wird über die Methode Eingabe gestartet und die Methode Ausgabe gibt das Ergebnis von der Eingabe in der Konsole aus.

Der Adapter wird über die main Methode gestartet. Die Abfrage Schleife wird in der Main Methode definiert.

Das Ziel ist, dass die Klassen nur ihren Aufgabenbereich abdecken, damit die Komplexität gering bleibt.