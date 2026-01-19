// ==============================================
// VERIFICA DI GEOMETRIA (ESEMPIO)
// ==============================================

CANVAS(800, 800);

// --- PALETTE ISTITUZIONALE ---
DEF carta = #FFFFFF;
DEF inchiostro = #000000;
DEF grigio_chiaro = #DDDDDD;
DEF blu_intestazione = #003366;
DEF rosso_correzione = #CC0000;

// Sfondo foglio A4 (simulato)
RECT AT (0,0) SIZE (800,800) FILL carta;

// ----------------------------------------------
// INTESTAZIONE SCUOLA
// ----------------------------------------------
POLYGON POINTS (60, 32, 88, 60, 60, 88, 32, 60) FILL blu_intestazione;

TEXT("ISTITUTO COMPRENSIVO 'EUCLIDE'", 120, 50) COLOR blu_intestazione;
TEXT("Verifica di Geometria Piana - Classe 2^B", 120, 80) COLOR inchiostro;

LINE FROM (50, 100) TO (750, 100) STROKE inchiostro;

// Campi Dati Alunno
TEXT("Alunno: _______________________", 50, 140) COLOR inchiostro;
TEXT("Data: ___/___/______", 550, 140) COLOR inchiostro;

// ----------------------------------------------
// ESERCIZIO 1: AREE COMPOSTE
// ----------------------------------------------
VAR y_ex1 = 200;
TEXT("ESERCIZIO 1 (Punti: 4)", 50, y_ex1) COLOR inchiostro;
TEXT("Calcola l'area della figura composta (Rettangolo + Triangolo).", 50, y_ex1 + 25) COLOR inchiostro;

// Disegno Figura (Casetta)
VAR fig_x = 100;
VAR fig_y = y_ex1 + 60;

// Rettangolo base
RECT AT (fig_x, fig_y + 60) SIZE (120, 80) STROKE inchiostro;
// Triangolo tetto
TRIANGLE AT (0,0) POINTS (fig_x, fig_y + 60, fig_x + 120, fig_y + 60, fig_x + 60, fig_y) STROKE inchiostro;

// Quote (Misure)
TEXT("12 cm", fig_x + 40, fig_y + 155) COLOR inchiostro; // Base
TEXT("8 cm", fig_x - 45, fig_y + 110) COLOR inchiostro; // Altezza rect
TEXT("h=5", fig_x + 130, fig_y + 50) COLOR inchiostro; // Altezza tetto

// Spazio Risposta (Griglia quadrettata leggera per i calcoli)
VAR grid_x = 400;
VAR grid_y = y_ex1 + 50;
VAR r = 0;
VAR c = 0;

FOR (r = 0; r < 5; r = r + 1) {
    LINE FROM (grid_x, grid_y + r*25) TO (grid_x + 300, grid_y + r*25) STROKE grigio_chiaro;
}
TEXT("Svolgimento:", grid_x, grid_y - 5) COLOR inchiostro;

// ----------------------------------------------
// ESERCIZIO 2: CERCHIO E CIRCONFERENZA
// ----------------------------------------------
VAR y_ex2 = 480;
TEXT("ESERCIZIO 2 (Punti: 6)", 50, y_ex2) COLOR inchiostro;
TEXT("Osserva la figura. Se il raggio misura 4 cm, qual e' l'area del cerchio esterno?", 50, y_ex2 + 25) COLOR inchiostro;

// Disegno Cerchi Concentrici
CIRCLE AT (160, y_ex2 + 100) RADIUS 50 STROKE inchiostro; // Esterno
CIRCLE AT (160, y_ex2 + 100) RADIUS 30 STROKE inchiostro; // Interno
CIRCLE AT (160, y_ex2 + 100) RADIUS 2 FILL inchiostro;    // Centro

// Raggio disegnato
LINE FROM (160, y_ex2 + 100) TO (210, y_ex2 + 100) STROKE inchiostro;
TEXT("r = 4", 170, y_ex2 + 90) COLOR inchiostro;

// Box Risposta
RECT AT (400, y_ex2 + 60) SIZE (300, 80) STROKE inchiostro;
TEXT("Risposta:", 410, y_ex2 + 80) COLOR inchiostro;

// ----------------------------------------------
// PIÉ DI PAGINA
// ----------------------------------------------
LINE FROM (50, 750) TO (750, 750) STROKE inchiostro;
TEXT("Valutazione Insegnante:", 50, 770) COLOR rosso_correzione;
RECT AT (220, 755) SIZE (50, 25) STROKE rosso_correzione;
