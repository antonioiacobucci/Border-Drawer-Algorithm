/*
table(n,m)

draw(int a): 
    if a=0 -> writes and moves the pointer one border segment to the right
    if a=1 -> writes and moves the pointer one border segment to the left
    if a=2 -> writes and moves the pointer one border segment up
    if a=3 -> writes and moves the pointer one border segment down
    else doesn't move
move(int b):
    if a=0 -> moves the pointer one border segment to the right
    if a=1 -> moves the pointer one border segment to the left
    if a=2 -> moves the pointer one border segment up
    if a=3 -> moves the pointer one border segment down
    else doesn't move
*/

public void draw_horizontal(int n, int m) {
    for (int i = 1; i < m + 1; i++) { // 1 to m+1 so I can correctly track even and odd numbers
        if (!isEven(i)) { // i ODD: horizontal line towards right
            for (int j = 0; j < n; j++) draw(0);
        } else { // i EVEN: horizontal line towards left
            for (int j = 0; j < n; j++) draw(1);
        }
        draw(3);
    }
}

public void draw_vertical(int n, int m) {
    int direction = (isEven(m)) ? 1 : 0; // m EVEN: drawing from right to left (pointer is in n,m)
                                         // m ODD: drawing from left to right (pointer is in 0,m)
    draw_first_vertical(m);
    if (n > 1) { // there are more vertical lines only if n>1
        draw_central_vertical(n, m, direction);
        draw_last_vertical(n, m);
    }
}

private void draw_first_vertical(int m) {
    // first vertical line has alternated drawn and blank borders starting with a blank one to fill
    int first = m;
    while (first > 1) { // at least two segments left
        draw(2);
        move(2);
        first = first - 2;
    }
    if (first == 1) draw(2); // drawing last border of the line if m ODD
}

private void draw_central_vertical(int n, int m, boolean direction) {
    // central vertical lines have no drawn vertical borders
    move(direction); // moving left or right to the next vertical line
    for (int j = 2; j < n + 1; j++) { // 2 to n+1 so I can correctly track even and odd numbers (instead of 1 to n)
        if (!isEven(j)) { // j ODD: vertical line towards up
            for (int i = 0; i < m; i++) draw(2);
        } else { // j EVEN: vertical line towards down
            for (int i = 0; i < m; i++) draw(3);
        }
        move(direction); // moving left or right to the last vertical line
    }
}

private void draw_last_vertical(int n, int m) {
    // last vertical line has alternated drawn and blank borders
    int last = m;
    if (!isEven(n)) {
        if (isEven(m)) { // m EVEN, n ODD: line towards down starting with a blank border
            while (last > 1) {
                draw(3);
                move(3);
                last = last - 2;
            }
        } else { // m ODD, n ODD: line towards down starting with a drawn border
            while (last > 1) {
                move(3);
                draw(3);
                last = last - 2;
            }
        }
    } else { // n EVEN: line towards up always starting with a drawn border
        while (last > 1) {
            move(2);
            draw(2);
            last = last - 2;
        }
    }
    // if m ODD last border is always already drawn anywyay
}

private boolean isEven(int x) {
    return (x % 2) == 0);
}

public void solver(int n, int m) {
    (n > 0 & m > 0) {
        draw_horizontal(n, m); // draws all the horizontal lines
        draw_vertical(n, m); // draws all the vertical lines without drawing those already done
    }
}
