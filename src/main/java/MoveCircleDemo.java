import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MoveCircleDemo extends Application
{

    private Grid grid;
    private final int N = 25;
    private final int GRID_SIZE = 600;
    private final int DIM = (int) Math.sqrt(GRID_SIZE  * GRID_SIZE/ (N * N));
    private CircleMarker marker;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        grid = new Grid(N,DIM);
        makeCircle();
        InputHBox hBox = new InputHBox();



        BorderPane borderPane = setupBorderPane(hBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Move the Circle");


        hBox.addMoveButtonAction(this.grid, this.marker);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void makeCircle() {
        marker = new CircleMarker(DIM);
        int first = (int)(Math.random() * ((24 - 1) + 1)) + 1;
        int second = (int)(Math.random() * ((24 - 1) + 1)) + 1;
        int[] arr = new int[2];
        arr[0] = first;
        arr[1] = second;
        marker.drawCircle(grid, arr);
    }

    private BorderPane setupBorderPane(HBox hBox) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        borderPane.setCenter(grid);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setAlignment(grid, Pos.CENTER);
        return borderPane;
    }

}
