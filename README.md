# 🎨 GeoScript

**GeoScript** è un linguaggio di scripting intuitivo progettato per creare grafica vettoriale attraverso il codice.
Nato come progetto per il corso di **Linguaggi Formali e Compilatori**, GeoScript permette di trasformare logica e matematica in forme, disegni e visualizzazioni grafiche.

---

## 👥 Il Team
* **Cesari Matteo**
* **Girolamo Davide**

---

## 🚀 Che cos'è GeoScript?

GeoScript nasce per colmare il divario tra la programmazione e il disegno. Invece di disegnare manualmente con il mouse, l'utente descrive la scena utilizzando comandi testuali semplici e leggibili.

Il sistema agisce come un "artista virtuale": legge le istruzioni, controlla che siano coerenti (ad esempio, che non si stia cercando di usare un colore inesistente) e genera automaticamente l'immagine finale.

### ✨ Funzionalità Principali

* **📐 Disegno Geometrico:** Supporto nativo per forme classiche come rettangoli, cerchi, ellissi, linee e poligoni complessi.
* **🧠 Logica Intelligente:** Grazie ai comandi `IF`, `ELSE` e ai cicli `FOR` e `WHILE`, è possibile creare disegni che cambiano in base a regole o generare pattern ripetitivi complessi con poche righe di codice.
* **🔢 Matematica e Variabili:** Possibilità di definire variabili (numeri e colori) e usare espressioni matematiche per calcolare posizioni e dimensioni dinamicamente.
* **🛡️ Controllo Errori:** Il sistema avvisa l'utente se ci sono errori logici, come il tentativo di disegnare fuori dai bordi della tela o l'uso di variabili non dichiarate.
* **🔄 Trasformazioni:** Strumenti per ruotare, spostare e ridimensionare intere parti del disegno.

---

## 🛠️ Stack Tecnologico

Questo progetto utilizza lo stack software definito dai requisiti del corso e dai file forniti:

- **Java (JDK):** Per la logica dell'interprete, le classi del Command Pattern.
- **ANTLR 3.4:** Il generatore di parser utilizzato per l'analisi lessicale e sintattica.
- **AntlrWorks 1.5.2:** L'IDE specifico per lo sviluppo e il debug delle grammatiche ANTLR 3 (`.g`).
- **Eclipse IDE:** L'ambiente di sviluppo per la scrittura e la compilazione del codice Java.
- **Git & GitHub:** Per il controllo di versione e la gestione del progetto.

---

## 💡 Esempio: Cosa puoi fare?

Con GeoScript, creare pattern complessi è immediato. Ecco un esempio di script che genera forme alternate e cerchi concentrici automaticamente:

```geoscript
// --- Esempio GeoScript ---

// 1. Prepariamo la tela
CANVAS(800, 600);

// 2. Definiamo i nostri colori e parametri
DEF rosso = #FF0000;
DEF blu = #0000FF;
VAR dimensione = 50;
VAR spaziatura = 10;

// 3. Generazione Automatica (Ciclo FOR)
// Disegna una serie di forme una accanto all'altra
FOR (VAR i = 0; i < 5; i = i + 1) {
    VAR x = i * (dimensione + spaziatura) + 20;
    
    // Logica Condizionale: Alterna tra quadrato e cerchio
    IF (i % 2 == 0) THEN {
        RECT AT (x, 50) SIZE (dimensione, dimensione) FILL rosso;
    } ELSE {
        CIRCLE AT (x + 25, 75) RADIUS (dimensione / 2) FILL blu;
    }
}

// 4. Pattern Concentrico (Ciclo WHILE)
VAR raggio = 200;
WHILE (raggio > 0) {
    ELLIPSE AT (400, 300) RADII (raggio, raggio / 2) STROKE #333333;
    raggio = raggio - 20; // Riduciamo il raggio ad ogni passaggio
}

// 5. Aggiunta di Testo e Rotazione
TRANSLATE (50, 500);
ROTATE (15); 
TEXT ("Grafica Generativa!", 0, 0) COLOR #000000;