package it.polimi.ingsw.Model.Player.Board;

import it.polimi.ingsw.Model.Enumerations.Color;
import java.util.*;

/**
 * 
 */
public class Hall {

    /**
     * Constructor that create the lines in Hall
     */
    public Hall() {
        for (Color c : Color.values()){
            Line line=new Line(c);
            this.lines.add(line);
          }



    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private LinkedList<Line> lines=new LinkedList<Line>();

    /**
     * @param color 
     * @return Line Return the line with te specified color
     */

    public Line getLine(Color color) {
        int i=0;
        for (i=0;i<this.lines.size()-1;i++){
            if(this.lines.get(i).getColor()==color){
                break;
                    }
             }
            return new Line(this.lines.get(i).getColor());
         }


}