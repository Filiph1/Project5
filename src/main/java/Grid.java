import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Grid extends GridPane {

    private Cell[][] cells;

    public Grid(int n, int dimension)
    {
        cells = new Cell[n][n];

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {


               add(new Cell(dimension),i,j);


            }
        }

    }

    public Cell getCell(int row, int col)
    {
        return cells[row][col];
    }

    public int getSize()
    {
        return cells.length;
    }

    public class Cell extends StackPane{

        private final int size;


        public Cell(int size)
        {
            this.size = size;
            setStyle(" -fx-border-color: black;");
            setMinHeight(size);
            setMinWidth(size);
        }

    }
}
