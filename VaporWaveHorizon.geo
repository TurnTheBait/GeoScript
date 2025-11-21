// ==========================================
// ESEMPIO: VAPORWAVE HORIZON 
// ==========================================

CANVAS(800, 600);

// --- 1. SETUP VARIABILI & COLORI ---
DEF c_sky_top = #1a0b2e;
DEF c_sky_bot = #4a1a5e;
DEF c_sun = #ff0055;
DEF c_sun_glow = #ffbd00;
DEF c_grid = #00f2ff;
DEF c_ground = #0f0518;
DEF c_mount = #0a0a0a;
DEF c_black = #000000;

// VAR usate per i numeri
VAR width = 800;
VAR height = 600;
VAR horizon = 350;

// Sfondo
RECT AT (0, 0) SIZE (width, height) FILL c_sky_top STROKE c_sky_top;

// ==========================================
// 2. IL SOLE RETROWAVE
// ==========================================

VAR sun_x = 400;
VAR sun_y = 250;
VAR sun_r = 120;
VAR sun_glow_r = 80;

CIRCLE AT (sun_x, sun_y) RADIUS sun_r FILL c_sun STROKE c_sun;
CIRCLE AT (sun_x, sun_y) RADIUS sun_glow_r FILL c_sun_glow STROKE c_sun_glow;

// TAGLI DEL SOLE
VAR cut_y = 260;
VAR cut_h = 4;
VAR i = 0;

WHILE (i < 8) {
// Striscia che copre il sole
RECT AT (200, cut_y) SIZE (400, cut_h) FILL c_sky_top STROKE c_sky_top;

// Calcolo gap
VAR gap = 8 + (i * 3);
cut_y = cut_y + gap;
cut_h = cut_h + 1;

i = i + 1;


}

// ==========================================
// 3. LE MONTAGNE
// ==========================================

// Montagna Sinistra
VAR m1_p1_x = 0;
VAR m1_p1_y = 350;
VAR m1_p2_x = 200;
VAR m1_p2_y = 150;
VAR m1_p3_x = 400;
VAR m1_p3_y = 350;

TRIANGLE AT (0,0) POINTS (m1_p1_x, m1_p1_y, m1_p2_x, m1_p2_y, m1_p3_x, m1_p3_y) FILL c_mount STROKE c_grid;

// Montagna Destra
VAR m2_p1_x = 350;
VAR m2_p1_y = 350;
VAR m2_p2_x = 600;
VAR m2_p2_y = 180;
VAR m2_p3_x = 800;
VAR m2_p3_y = 350;

TRIANGLE AT (0,0) POINTS (m2_p1_x, m2_p1_y, m2_p2_x, m2_p2_y, m2_p3_x, m2_p3_y) FILL c_mount STROKE c_grid;

// ==========================================
// 4. LA GRIGLIA PROSPETTICA
// ==========================================

// Terreno
RECT AT (0, horizon) SIZE (width, 250) FILL c_ground STROKE c_grid;

// A. LINEE VERTICALI
VAR v_lines = 12;
VAR j = 0;
VAR center_x = 400;

FOR (j = 0; j < 13; j = j + 1) {
// Fix per numeri negativi: (0 - 200) invece di -200
VAR start_offset = 0 - 200;
VAR base_x = start_offset + (j * 100);

LINE FROM (center_x, horizon) TO (base_x, 600) STROKE c_grid;


}

// B. LINEE ORIZZONTALI
VAR k = 1;
VAR h_y = horizon + 10;
VAR limit = 600;

WHILE (h_y < limit) {
LINE FROM (0, h_y) TO (width, h_y) STROKE c_grid;

VAR step = k * 4;
h_y = h_y + step;
k = k + 1;


}

// ==========================================
// 5. CORNICE
// ==========================================
RECT AT (0, 0) SIZE (width, 20) FILL c_black STROKE c_black;
RECT AT (0, 580) SIZE (width, 20) FILL c_black STROKE c_black;