# Border-Drawer-Algorithm

This is just a simple algorithm exercise. It has no real purposes.

Starting from a table(n,m) this algorithm draws all table borders with a unique segmented line, without lifting the pointer. The program also pays attention to not re-draw borders already drawn.

The pointer starts in position (0,0) and is allowed to move/draw one border square at a time, using draw(direction) and move(direction).

Here's how input and output look like:

![Input](input.png?raw=true) ![Output](output.png?raw=true)

The main drawer method is split into draw_horizontal() and draw_vertical().

## Draw_horizontal(int n, int m)

First method draws all horizontal lines of the table without passing on already drawn borders.

![Draw_horizontal](horiz.png?raw=true)

## Draw_vertical(int n, int m)

Second method draws all vertical lines of the table (red borders in the figure) without drawing on borders already drawn.

![Draw_vertical](vert.png?raw=true)
