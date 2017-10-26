/*
draw(int a): 
    if a=0 -> writes and moves the pointer one border to the right
    if a=1 -> writes and moves the pointer one border to the left
    if a=2 -> writes and moves the pointer one border up
    if a=3 -> writes and moves the pointer one border down
    else doesn't move
move(int b):
    if a=0 -> moves the pointer one border to the right
    if a=1 -> moves the pointer one border to the left
    if a=2 -> moves the pointer one border up
    if a=3 -> moves the pointer one border down
    else doesn't move
    
    
    
    CONTROLLARE CASO BANALE (1,1) / (1,m) / (n,1)
*/

public void draw_horizontal(int n, int m){
    for(int i=1; i<m+1; i++){
        if((i % 2)!=0){                                     // i ODD: horizontal line towards right
            for(int j=1; j<n; j++) draw(0);
        }
        else{                                               // i EVEN: horizontal line towards left
            for(int j=1; j<n; j++) draw(1);
        }
        draw(3);
    }  
}

public void draw_vertical(int n, int m){
    bool controller= false;                                 // m ODD: drawing from left to right
    if((m % 2)==0) controller= true;                        // m EVEN: drawing from right to left
    // first vertical line has alternated drawn and blank borders starting with a blank one
    int first= m;
    while(first > 1){
        draw(2);
        move(2);
        first= first-2;
    }
    if(first==1) draw(2);                                   // drawing last border of the line if m ODD
    if(controller) move(1);                                 // moving left or right
    else move(0);
    // central vertical lines have no drawn borders except horizontal ones
    for(int j=2; j<n; j++){
        if((j % 2)!=0){                                     // j ODD: vertical line towards up
            for(int i=1; i<m; i++) draw(2);
        }
        else{                                               // j EVEN: vertical line towards down
            for(int i=1; i<m; i++) draw(3);
        }
        if(controller) move(1);                             // MOVING left or right(horizontal lines are already drawn)
        else move(0);
    }
    // last vertical line has alternated drawn and blank borders
    int last=m;
    if(controller && ((n % 2)!=0)){                         // m EVEN, n ODD: line towards down starting with a blank border
        while(last > 1){
            draw(3);
            move(3);
            last= last-2;
        }
        if(last==1) draw(3);
    }
    else if((n % 2)!=0)){                                   // m ODD, n ODD: line towards down starting with a drawn border
        while(last > 1){
            move(3);
            draw(3);
            last= last-2;
        }
    }
    else{                                                   // n EVEN: line towards up
        while(last > 1){
            move(2);
            draw(2);
            last= last-2;
        }
    }
}

public void solver(int n, int m){
  draw_horizontal(n,m);                                     // draws all the horizontal lines
  draw_vertical(n,m);                                       // draws all the vertical lines without drawing those already done 
}
