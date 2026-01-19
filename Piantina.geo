// ==========================================
// PROGETTO: PIANTINA ARCHITETTONICA
// Dimostrazione di uso "CAD-like"
// ==========================================

CANVAS(1000, 800);

// --- 1. DEFINIZIONE STILE ARCHITETTONICO ---
DEF muro_colore = #2C3E50;     // Grigio Scuro (Muri)
DEF pavimento = #ECF0F1;       // Grigio Chiaro (Sfondo)
DEF mobili_wood = #D35400;     // Legno (Mobili)
DEF mobili_soft = #3498DB;     // Blu (Divani/Letti)
DEF quote_colore = #E74C3C;    // Rosso (Misure)
DEF verde_piante = #27AE60;    // Verde

// Sfondo carta
RECT AT (0,0) SIZE (1000, 800) FILL #FFFFFF;
TEXT("PROGETTO: APPARTAMENTO A", 40, 40) COLOR #000000;

// --- 2. MURI PERIMETRALI (Disegniamo rettangoli pieni) ---
// La casa è un rettangolo 600x400
// Muro Nord
RECT AT (0, 0) SIZE (600, 20) FILL muro_colore;
// Muro Sud
RECT AT (0, 400) SIZE (600, 20) FILL muro_colore;
// Muro Ovest
RECT AT (0, 0) SIZE (20, 420) FILL muro_colore;
// Muro Est
RECT AT (580, 0) SIZE (20, 420) FILL muro_colore;

// --- 3. STANZE INTERNE (Divisori) ---

// Muro divisorio verticale (Separa Giorno/Notte)
RECT AT (300, 20) SIZE (10, 400) FILL muro_colore;

// Muro divisorio orizzontale (Bagno/Camera)
RECT AT (300, 200) SIZE (280, 10) FILL muro_colore;

// Etichette Stanze
// Etichette Stanze (Spostate per evitare sovrapposizioni)
TEXT("ZONA GIORNO", 180, 100) COLOR #7F8C8D;
TEXT("CAMERA", 330, 180) COLOR #7F8C8D;
TEXT("BAGNO", 450, 300) COLOR #7F8C8D;

// --- 4. ARREDAMENTO (Composizione di Primitive) ---

// -- Cucina (Zona Giorno) --
// Blocco cucina (Sostituito sopra)
// RECT AT (30, 30) SIZE (20, 300) FILL mobili_wood;
// Tavolo rotondo
CIRCLE AT (150, 150) RADIUS 40 FILL #FFFFFF STROKE mobili_wood;
// Sedie (Ciclo per posizionarle attorno)
VAR i = 0;
FOR (i = 0; i < 4; i = i + 1) {
    // Usiamo IF per posizionare le sedie a croce
    IF (i == 0) THEN { SQUARE AT (135, 60) SIZE 30 FILL mobili_wood; }
    IF (i == 1) THEN { SQUARE AT (135, 210) SIZE 30 FILL mobili_wood; }
    IF (i == 2) THEN { SQUARE AT (70, 135) SIZE 30 FILL mobili_wood; }
    IF (i == 3) THEN { SQUARE AT (210, 135) SIZE 30 FILL mobili_wood; }
}

// -- Salotto --
// Divano (Rettangolo + Braccioli)
RECT AT (30, 300) SIZE (150, 50) FILL mobili_soft; // Seduta
RECT AT (30, 280) SIZE (20, 70) FILL mobili_soft;  // Bracciolo SX
RECT AT (160, 280) SIZE (20, 70) FILL mobili_soft; // Bracciolo DX
// Tappeto
RECT AT (50, 280) SIZE (110, 30) FILL pavimento STROKE mobili_soft;

// -- Camera da Letto --
// Letto Matrimoniale
RECT AT (450, 30) SIZE (100, 140) FILL mobili_soft; 
// Cuscini (Bianchi)
RECT AT (460, 40) SIZE (30, 20) FILL #FFFFFF;
RECT AT (510, 40) SIZE (30, 20) FILL #FFFFFF;
// Comodini
SQUARE AT (420, 50) SIZE 20 FILL mobili_wood;
SQUARE AT (560, 50) SIZE 20 FILL mobili_wood;
// Armadio (Muro Nord Camera)
RECT AT (310, 20) SIZE (100, 40) FILL mobili_wood;
TEXT("ARMADIO", 330, 45) COLOR #FFFFFF;

// -- Bagno --
// Vasca
RECT AT (480, 350) SIZE (90, 40) FILL #FFFFFF STROKE #3498DB;
// Lavandino (Cerchio in un rettangolo)
RECT AT (320, 350) SIZE (40, 40) FILL mobili_wood;
CIRCLE AT (340, 370) RADIUS 15 FILL #FFFFFF;
// WC
CIRCLE AT (400, 230) RADIUS 15 FILL #FFFFFF STROKE #000000;
RECT AT (390, 210) SIZE (20, 20) FILL #FFFFFF STROKE #000000; // Cassetta

// --- 5. DETTAGLI TECNICI (Porte e Finestre) ---

// Finestra Zona Giorno (Buca nel muro Ovest)
RECT AT (0, 120) SIZE (20, 100) FILL #87CEEB; // Vetro azzurro

// Porta Ingresso (Simulata aperta)
RECT AT (100, 395) SIZE (60, 30) FILL #FFFFFF; 
LINE FROM (100, 420) TO (100, 360) STROKE #000000; // Anta porta aperta
// ARC_SIMULATED (Rimosso label non supportata)
LINE FROM (100, 420) TO (160, 420) STROKE quote_colore; // Ingombro

// Porte Interne (Aperture nei muri)
// Porta Camera (su muro divisorio x=300, y=100)
RECT AT (300, 100) SIZE (10, 60) FILL pavimento; // Buca
LINE FROM (300, 100) TO (340, 140) STROKE #000000; // Anta 
// Porta Bagno (su muro divisorio x=300, y=300)
RECT AT (300, 300) SIZE (10, 60) FILL pavimento; // Buca
LINE FROM (300, 300) TO (340, 340) STROKE #000000; // Anta

// --- 6. DIMENSIONI ---
// Linee di quota esterne
VAR dist = 30;
LINE FROM (0, 450) TO (600, 450) STROKE quote_colore; // Linea orizzontale
LINE FROM (0, 440) TO (0, 460) STROKE quote_colore;   // Tacca inizio
LINE FROM (600, 440) TO (600, 460) STROKE quote_colore; // Tacca fine
TEXT("12.00 mt", 280, 470) COLOR quote_colore;

LINE FROM (630, 0) TO (630, 420) STROKE quote_colore; // Linea verticale
TEXT("8.40 mt", 640, 200) COLOR quote_colore;

// --- 7. TOCCO FINALE: UNA PIANTA ---
// Usiamo un ciclo per fare le foglie
CIRCLE AT (550, 380) RADIUS 15 FILL #8E44AD; // Vaso
VAR k = 0;
FOR (k = 0; k < 8; k = k + 1) {
    // Foglie sparse attorno
    // Foglie sparse attorno a X=550, Y=380
    VAR leaf_x = 550 + ((k % 3) * 10) - 10;
    VAR leaf_y = 380 + (k * (0-5)) - 10;
    CIRCLE AT (leaf_x, leaf_y) RADIUS 8 FILL verde_piante;
}