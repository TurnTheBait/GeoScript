// ==============================================
// GEOSCRIPT - QUADERNO DI GEOMETRIA
// ==============================================

// 1. SETUP AMBIENTE
CANVAS(800, 600);

// Palette "Quaderno a Quadretti"
DEF bg_paper = #FFFFFF;       // Bianco Carta
DEF grid_lines = #E6E6FA;     // Lavanda Chiarissimo (Righe quadretti)
DEF margin_line = #FFB6C1;    // Rosa chiaro (Margine)
DEF pen_blue = #000080;       // Blu Scuro (Inchiostro)
DEF pen_red = #B22222;        // Rosso (Correzioni/Titoli important)
DEF pencil = #708090;         // Grigio Ardesia (Disegno a matita)
DEF ink_black = #000000;      // Nero

// Sfondo Bianco
RECT AT (0,0) SIZE (800,600) FILL bg_paper;

// ----------------------------------------------
// 2. BACKGROUND: GRIGLIA A QUADRETTI
// ----------------------------------------------
VAR cell_size = 25;
VAR i = 0;

// Righe Verticali
FOR (i = 0; i < 800; i = i + cell_size) {
    LINE FROM (i, 0) TO (i, 600) STROKE grid_lines;
}

// Righe Orizzontali
FOR (i = 0; i < 600; i = i + cell_size) {
    LINE FROM (0, i) TO (800, i) STROKE grid_lines;
}

// Margine Rosso
LINE FROM (80, 0) TO (80, 600) STROKE margin_line;

// ----------------------------------------------
// 3. INTESTAZIONE COMPITINO
// ----------------------------------------------
TEXT("Compito di Geometria", 100, 40) COLOR pen_blue;
TEXT("Nome Cognome - Classe", 600, 40) COLOR pen_blue;
LINE FROM (100, 45) TO (300, 45) STROKE pen_blue;

TEXT("Data: 21/01/2026", 600, 65) COLOR pen_blue;

// ----------------------------------------------
// 4. ESERCIZIO 1: TEOREMA DI EUCLIDE (Simulato)
// ----------------------------------------------
VAR ex1_y = 120;
TEXT("Esercizio 1: Triangolo e Cerchio Inscritto", 100, ex1_y) COLOR pen_red;

// Coordinate Base
VAR A_x = 150; VAR A_y = ex1_y + 150;
VAR B_x = 350; VAR B_y = ex1_y + 150;
VAR C_x = 250; VAR C_y = ex1_y + 30;

// Triangolo (Disegno a matita scura/penna)
TRIANGLE AT (0,0) POINTS (150, 270, 350, 270, 250, 150) STROKE pen_blue;

// Aggiungiamo lettere ai vertici
TEXT("A", 140, 280) COLOR ink_black;
TEXT("B", 360, 280) COLOR ink_black;
TEXT("C", 245, 140) COLOR ink_black;

// Cerchio Inscritto (Simulato geometricamente approx)
// Centro approx a (250, 230), raggio ~ 40
CIRCLE AT (250, 230) RADIUS 35 STROKE pencil; // Matita

// Linee di costruzione (Altezze/Mediane - simulate)
LINE FROM (250, 150) TO (250, 270) STROKE grid_lines; // Altezza (usiamo colore griglia per farla tenue)

// Annotazioni Formule
TEXT("Area = (b * h) / 2", 400, 200) COLOR pen_blue;
TEXT("h = 120", 400, 220) COLOR pencil;
TEXT("b = 200", 400, 240) COLOR pencil;

// Voto Simulato
TEXT("Voto: 8+", 700, 250) COLOR pen_red;
CIRCLE AT (730, 245) RADIUS 30 STROKE pen_red;

// ----------------------------------------------
// 5. ESERCIZIO 2: PROSPETTIVA E SOLIDI
// ----------------------------------------------
VAR ex2_y = 350;
TEXT("Esercizio 2: Proiezione Cubo", 100, ex2_y) COLOR pen_red;

// Faccia Frontale
RECT AT (150, ex2_y + 50) SIZE (100, 100) STROKE pen_blue;

// Faccia Posteriore (Shiftata)
// Usiamo POLYGON o LINEE per collegare, ma RECT per il retro
// RECT AT (200, ex2_y + 20) SIZE (100, 100) STROKE pencil; 
// Facciamolo a mano con linee per effetto "tratteggiato" o matita leggera

VAR back_x = 200; 
VAR back_y = ex2_y + 20;

// Retro (Matita)
RECT AT (200, 370) SIZE (100, 100) STROKE pencil;

// Collegamenti Spigoli
LINE FROM (150, 400) TO (200, 370) STROKE pencil; // Top-Left
LINE FROM (250, 400) TO (300, 370) STROKE pencil; // Top-Right
LINE FROM (150, 500) TO (200, 470) STROKE pencil; // Bottom-Left
LINE FROM (250, 500) TO (300, 470) STROKE pencil; // Bottom-Right

// Riempimento selettivo per dare "volume" (Opzionale, ma GeoScript riempie tutto il rect)
// Lasciamo "wireframe" stile disegno tecnico

TEXT("Volume = L^3", 400, 420) COLOR pen_blue;
TEXT("L = 10u", 400, 440) COLOR pencil;

// ----------------------------------------------
// 6. CONCLUSIONE
// ----------------------------------------------
TEXT("Ottimo lavoro!", 550, 550) COLOR pen_red;