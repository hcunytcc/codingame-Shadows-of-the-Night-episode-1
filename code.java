import java.util.*;
import java.io.*;
import java.math.*;

/*Basically, this problem requires a search algorithm. Since there are limited amount of moves allowed
we can't do anything expensive, like looking window by window. So, i went with a binary search algorithm.
The challenge was to implement it on a two dimensional grid. As it turns out, it is just as simple as on
regular array or list. 
In this example, I explain  my rationale:

if(bombDir.equals("UR")){ (UR stands for Up and Right of Batman's position)
    xMin = x; (We set current x as the minimum position because we know x has to be higher)
    yMax = y; (We set current y as the maximum position because we know y has to be lower)
    
    (The math below is the formula to find the mid point between min/max and current position)
    System.out.println((x+((xMax-xMin)/2)) + " " + (y-((yMax-yMin)/2))); 
    x = (x+((xMax-xMin)/2)); (Then set new x to mid point)
    y = (y-((yMax-yMin)/2)); (then set new y to mid point)
}

A new loop will tell us whether we found the bomb or the next place to move to.
*/



class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        int x = X0; // x is eaier than X0
        int y = Y0; //y is easier than Y0
        
        int xMin = -1;
        int xMax = W;
        int yMax = H;
        int yMin = -1;
        

        // game loop
        while (true) {
            
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            
            if(bombDir.equals("U")){
                yMax = y;
                System.out.println(x + " " + (y-((yMax-yMin)/2)));
                y = (y-((yMax-yMin)/2));
            }
            else if(bombDir.equals("D")){
                yMin = y;
                System.out.println(x + " " + (y+((yMax-yMin)/2)));
                y = (y+((yMax-yMin)/2));
                
            }
            else if(bombDir.equals("L")){
                xMax = x;
                System.out.println((x-((xMax-xMin)/2)) + " " + y);
                x = (x-((xMax-xMin)/2));
            }
            else if(bombDir.equals("R")){
                xMin = x;
                System.out.println((x+((xMax-xMin)/2)) + " " + y);
                x = (x+((xMax-xMin)/2));
            }
            else if(bombDir.equals("UR")){
                xMin = x;
                yMax = y;
                System.out.println((x+((xMax-xMin)/2)) + " " + (y-((yMax-yMin)/2)));
                x = (x+((xMax-xMin)/2));
                y = (y-((yMax-yMin)/2));
            }
            else if(bombDir.equals("UL")){
                xMax = x;
                yMax = y;
                System.out.println((x-((xMax-xMin)/2)) + " " + (y-((yMax-yMin)/2)));
                x = (x-((xMax-xMin)/2));
                y = (y-((yMax-yMin)/2));
            }
            else if(bombDir.equals("DR")){
                xMin = x;
                yMin = y;
                System.out.println((x+((xMax-xMin)/2)) + " " + (y+((yMax-yMin)/2)));
                x = (x+((xMax-xMin)/2));
                y = (y+((yMax-yMin)/2));
            }
            else if(bombDir.equals("DL")){
                xMax = x;
                yMin = y;
                System.out.println((x-((xMax-xMin)/2)) + " " + (y+((yMax-yMin)/2)));
                x = (x-((xMax-xMin)/2));
                y = (y+((yMax-yMin)/2));
            }
            
        }
    }
}
