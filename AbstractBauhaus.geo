// ==============================================
// BAUHAUS CONSTRUCTIVISM EXERCISE
// ==============================================

CANVAS(800, 600);

// --- PALETTE BAUHAUS ---
DEF bg_cream = #F4F1EA;
DEF ink_black = #1A1A1A;
DEF art_red = #BE2623;
DEF art_blue = #1E3799;
DEF art_yellow = #F0C419;

// Sfondo
RECT AT (0,0) SIZE (800,600) FILL bg_cream;

// ----------------------------------------------
// 1. FORME GEOMETRICHE FONDAMENTALI
// ----------------------------------------------

// Grande Cerchio Nero (Equilibrio)
CIRCLE AT (550, 250) RADIUS 180 FILL ink_black;

// Linea Blu Verticale (Struttura)
RECT AT (150, 0) SIZE (20, 600) FILL art_blue;

// Quadrato Giallo (Accento)
RECT AT (100, 450) SIZE (120, 120) FILL art_yellow;

// Linee di connessione (Sottili)
LINE FROM (160, 300) TO (550, 250) STROKE ink_black;
LINE FROM (0, 100) TO (800, 100) STROKE ink_black;

// ----------------------------------------------
// 2. ELEMENTI TRASFORMATI
// ----------------------------------------------

TRANSLATE (400, 300); 
ROTATE 30; // Ruota di 30 gradi

// Rettangolo Rosso che attraversa la composizione
// Disegnato relativo alla nuova origine (400, 300)
RECT AT (0-300, 0-20) SIZE (600, 40) FILL art_red;

// ----------------------------------------------
// 3. DETTAGLI FINALI
// ----------------------------------------------
// Queste forme subiranno la rotazione e traslazione corrente! 
// Possiamo usarlo a nostro vantaggio per altri elementi dinamici.

RECT AT (100, 100) SIZE (20, 20) FILL art_blue; // Sarà ruotato e spostato
RECT AT (140, 100) SIZE (20, 20) FILL art_blue; 

// Nota artistica: L'asimmetria è voluta.
