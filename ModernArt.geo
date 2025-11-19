CANVAS(800, 600);

DEF bg_color = #ECF0F1;      // Grigio molto chiaro
DEF color_dark = #2C3E50;    // Blu scuro (Midnight Blue)
DEF color_teal = #1ABC9C;    // Turchese
DEF color_orange = #E67E22;  // Arancione
DEF color_red = #E74C3C;     // Rosso
DEF color_white = #FFFFFF;

RECT AT (0, 0) SIZE (800, 600) FILL bg_color STROKE bg_color;

VAR rows = 12;
VAR cols = 16;
VAR size = 40;
VAR gap = 50;
VAR startX = 25;
VAR startY = 25;

VAR r = 0;
VAR c = 0;

FOR (r = 0; r < rows; r = r + 1) {
// Ciclo per le colonne
FOR (c = 0; c < cols; c = c + 1) {
VAR posX = startX + c * gap;
VAR posY = startY + r * gap;

    VAR sum = r + c;
    VAR mod = sum - (sum / 2) * 2;
    
    IF (mod == 0) THEN {
        // Quadrati scuri
        SQUARE AT (posX, posY) SIZE size FILL color_dark STROKE color_white;
    } ELSE {
        // Quadrati turchesi
        SQUARE AT (posX, posY) SIZE size FILL color_teal STROKE color_white;
    }
}


}

VAR centerX = 400;
VAR centerY = 300;
VAR maxRadius = 160;
VAR step = 20;
VAR currentRadius = maxRadius;
VAR iter = 0;

WHILE (currentRadius > 0) {
VAR mod_iter = iter - (iter / 2) * 2;

IF (mod_iter == 0) THEN {
    CIRCLE AT (centerX, centerY) RADIUS currentRadius FILL color_orange STROKE color_white;
} ELSE {
    CIRCLE AT (centerX, centerY) RADIUS currentRadius FILL color_red STROKE color_white;
}

currentRadius = currentRadius - step;
iter = iter + 1;


}


TRIANGLE AT (0, 0) POINTS (0, 0, 150, 0, 0, 150) FILL color_dark STROKE color_white;
TRIANGLE AT (800, 600) POINTS (800, 600, 650, 600, 800, 450) FILL color_dark STROKE color_white;

LINE FROM (0, 300) TO (800, 300) STROKE color_white;
LINE FROM (400, 0) TO (400, 600) STROKE color_white;

RECT AT (250, 540) SIZE (300, 40) FILL color_white STROKE color_dark;
TEXT("GeoScript Modern Art", 290, 565) COLOR color_dark;