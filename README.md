# 🎨 GeoScript

[cite_start]**GeoScript** è un interprete per un semplice linguaggio di programmazione generativa, sviluppato per il progetto del corso di **Linguaggi Formali e Compilatori** (LFC)[cite: 3182].

L'obiettivo è implementare un compilatore completo che esegue:
1.  **Analisi Lessicale e Sintattica:** Riconoscimento della struttura del linguaggio.
2.  **Analisi Semantica:** Validazione della logica e della coerenza del codice (controllo tipi, scope, ecc.).
3.  [cite_start]**Gestione Errori:** Rilevamento di errori bloccanti e warning non bloccanti [cite: 1488-1499].
4.  [cite_start]**Generazione Output:** Traduzione dello script in un output visivo (un disegno su un pannello Java Swing) .

---

## 🖌️ Il Linguaggio GeoScript

GeoScript permette di definire una lavagna (canvas) e di usare variabili, condizionali (`IF`) e cicli (`FOR`) per creare disegni geometrici.

### Esempio di Codice

```geoscript
# 1. Setup della lavagna (obbligatorio)
CANVAS (800, 600);

# 2. Definizioni di variabili (Colori e Numeri)
DEF colore_primario = #FF0000;
DEF colore_secondario = #0000FF;
DEF dimensione_base = 50;
DEF num_forme = 10;

# 3. Esempio di IF / ELSE
# Disegna una forma diversa in base a una condizione
IF (dimensione_base < 100) [
    RECT AT (10, 10) SIZE (dimensione_base, dimensione_base) FILL colore_primario;
] ELSE [
    CIRCLE AT (10, 10) RADIUS (dimensione_base / 2) FILL colore_secondario;
]

# 4. Esempio di FOR
# Disegna una linea di cerchi usando un ciclo
FOR i FROM 1 TO num_forme DO
    # 'i' è la variabile del ciclo
    DEF x_pos = i * 60;
    CIRCLE AT (x_pos, 300) RADIUS 20 STROKE colore_secondario;
END
