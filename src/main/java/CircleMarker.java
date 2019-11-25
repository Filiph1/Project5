import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.shape.Circle;

import java.awt.peer.ScrollPanePeer;

public class CircleMarker extends Circle {
    private int[] coordinates;
    public CircleMarker(int size){
        super( Math.sqrt(size*size)/Math.PI);
        setStyle(" -fx-background-color: black; -fx-border-color: black;");
        coordinates = new int[2];



    }

    public int getX(){
        return coordinates[0];
    }
    public int getY(){
        return coordinates[1];
    }

    public void drawCircle(Grid g, int[] coords)
    {
        int x = coords[0];
        int y = coords[1];
        g.setAlignment(Pos.CENTER);

        coordinates[0] = x;
        coordinates[1] = y;

        g.add(this,x,y);
        g.setHalignment(this, HPos.CENTER);
    }

    public void updateLocation(Grid g, int[] arr)
    {



        if(arr[0]>-1 && arr[0]< 25 && arr[1] > -1 && arr[1] < 25)
        {

            g.getChildren().remove(this);
            coordinates[0] = arr[0];
            coordinates[1] = arr[1];
            g.add(this,arr[0], arr[1]);

        }
    }

}
