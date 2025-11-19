// ======================================
// TEST COMPLETO PER GeoScript
// ======================================

CANVAS(800, 600);

DEF colore_rosso = #FF0000;
DEF colore_blu = #0000FF;
DEF colore_verde = #00FF00;
DEF colore_grigio = #888888;

VAR x = 10;
VAR y = 20;
VAR lato = 50;
VAR step = 100;

RECT AT (x, y) SIZE (100, 50) FILL colore_rosso STROKE colore_grigio;
CIRCLE AT (400, 300) RADIUS 50 STROKE colore_blu;
LINE FROM (0, 0) TO (800, 600) STROKE #00FF00;
SQUARE AT (600, 100) SIZE lato FILL colore_grigio;
TRIANGLE AT (300, 400) POINTS (350, 450, 250, 450, 300, 350) FILL colore_verde;

ELLIPSE AT (200, 500) RADII (60, 30) STROKE colore_blu;
POLYGON POINTS (100,400,150,450,120,480,90,460) FILL colore_rosso;
TEXT("Benvenuto in GeoScript!", 50, 580) COLOR colore_blu;

ROTATE 45;
TRANSLATE (10, 10);
SCALE (2, 2);

IF (x < 100) THEN {
  TEXT("x è minore di 100", 100, 100) COLOR #00FF00;
}
ELSE {
  TEXT("x è maggiore o uguale a 100", 100, 100) COLOR #FF0000;
}

VAR count = 0;
WHILE (count < 3) {
  RECT AT (50 + count * 60, 350) SIZE (50, 20) FILL colore_blu;
  count = count + 1;
}

VAR i = 0;
FOR (i = 0; i < 5; i = i + 1) {
  IF ((i - (i / 2) * 2) == 0) THEN {
    CIRCLE AT (100 + i * 60, 200) RADIUS 20 FILL colore_rosso;
  }
  ELSE {
    CIRCLE AT (100 + i * 60, 200) RADIUS 20 FILL colore_blu;
  }
}

// Questi generano warning intenzionali
RECT AT (0, 0) SIZE (10, 10) FILL colore_inesistente;
VAR zero = 0;
VAR test_div = 100 / zero;
VAR test_undef = 10 + variabile_inesistente;

TEXT("Test completato!", 300, 550) COLOR colore_verde;