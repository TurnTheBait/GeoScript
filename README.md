# 🎨 GeoScript

**GeoScript** è un interprete per un linguaggio di programmazione procedurale e generativa, sviluppato per il progetto del corso di **Linguaggi Formali e Compilatori** (LFC).

---

## 👥 Team
* Cesari Matteo  
* Girolamo Davide

---

## 🖌️ Il Linguaggio GeoScript

L'interprete analizza uno script GeoScript, ne valida la correttezza sintattica e semantica, e infine esegue i comandi per produrre un output.

Il linguaggio supporta:
* Definizione di variabili (colori e numeri)
* Espressioni aritmetiche complesse
* Flusso di controllo (`IF/THEN/ELSE`, `WHILE`, `FOR`)
* Un set esteso di forme geometriche
* Trasformazioni della matrice di disegno

---

## 🏛️ Architettura dell'Interprete (Command Pattern)

Questo progetto è implementato come un **interprete a due passaggi (Two-Pass Interpreter)** direttamente dentro **ANTLR**, utilizzando il **Command Pattern**.

---

### 🔹 Passaggio 1: Parsing (Costruzione)

Mentre ANTLR analizza il codice, non esegue i comandi immediatamente.  
Costruisce invece una lista di oggetti Java (`List<Command>`).

Le espressioni (`expr`, `term`, `factor`) vengono trasformate in un albero di oggetti `Expr` (es. `BinExpr`, `ConstExpr`) per la **valutazione posticipata**.

---

### 🔹 Passaggio 2: Esecuzione

Una volta che il parsing raggiunge **EOF** (fine del file), la regola `prog` avvia l'esecuzione.

L'interprete cicla sulla `List<Command>` e chiama il metodo `execute(sem)` su ciascun comando (`IfCommand`, `ForCommand`, `ShapeCommand`, ecc.).

Questo design permette una **gestione complessa dello stato e del flusso di controllo**  
(ad esempio, i cicli `WHILE` / `FOR` possono ri-eseguire i loro comandi interni).

---

## 🧠 Analisi Semantica e Gestione Errori

L'analisi semantica è gestita sia durante il parsing che durante l'esecuzione tramite la classe `SemanticHandler`, definita direttamente nel blocco `@members` della grammatica.

---

### 🗂️ Gestione Stato (Symbol Table)

L'handler mantiene due "symbol table" separate:

- una per i **colori** → `Map<String, String> colors`
- una per le **variabili numeriche** → `Map<String, Integer> vars`

---

### 🚨 Errori e Warning Rilevati

- **Errore (Stato):** Un comando di disegno (es. `RECT`) viene usato prima della definizione di `CANVAS`.
- **Warning (Scope):** Si fa riferimento a una variabile colore non definita (es. `FILL colore_sconosciuto`).
- **Warning (Scope):** Si fa riferimento a una variabile numerica non definita (es. `x + variabile_inesistente`).
- **Errore (Esecuzione):** Divisione per zero durante la valutazione di un'espressione.
- **Errore (Sintassi):** Gestione personalizzata degli errori di sintassi ANTLR tramite `displayRecognitionError`.

---

## 🛠️ Stack Tecnologico

Questo progetto utilizza lo stack software definito dai requisiti del corso e dai file forniti:

- **Java (JDK):** Per la logica dell'interprete, le classi del Command Pattern e l'interfaccia grafica (Swing).
- **ANTLR 3.4:** Il generatore di parser utilizzato per l'analisi lessicale e sintattica.
- **AntlrWorks 1.5.2:** L'IDE specifico per lo sviluppo e il debug delle grammatiche ANTLR 3 (`.g`).
- **Eclipse IDE:** L'ambiente di sviluppo per la scrittura e la compilazione del codice Java.
- **Git & GitHub:** Per il controllo di versione e la gestione del progetto.



## 💡 Esempio di Codice Completo

Questo esempio mostra le funzionalità principali del linguaggio, inclusa la sintassi C-style del ciclo `FOR`.

```geoscript
// --- GeoScript Example ---

// 1. Setup Obbligatorio
CANVAS(800, 600);

// 2. Variabili Colore e Numeriche
DEF colore_rosso = #FF0000;
DEF colore_blu = #0000FF;
VAR size = 10;
VAR padding = 5;
VAR max_items = 5;

// 3. FOR loop (C-style) e IF statement
// Disegna una fila di forme alternate
FOR (VAR i = 0; i < max_items; i = i + 1) {
    VAR x_pos = i * (size + padding) + 10;
    
    IF (x_pos > 300) THEN {
        // Non fare nulla
    } ELSE {
        // Disegna un rettangolo rosso
        RECT AT (x_pos, 50) SIZE (size, size) FILL colore_rosso;
    }
}

// 4. WHILE loop
// Disegna cerchi concentrici
VAR r = 200;
WHILE (r > 0) {
    ELLIPSE AT (400, 300) RADII (r, r / 2) STROKE #333333;
    r = r - 20; // Aggiorna la variabile
}

// 5. Trasformazioni e Testo
TRANSLATE (10, 500);
ROTATE (15); // Ruota il contesto di 15 gradi
TEXT ("Progetto LFC Finito!", 0, 0) COLOR #000000;
