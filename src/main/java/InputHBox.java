import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;



public class InputHBox extends HBox
{
    private Label directionLabel;
    private Label spacesLabel;
    private TextField directionText;
    private TextField spacesText;
    private Button btnMove;

    public InputHBox() {
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 0, 0, 10));
        createAndAddChildren();
    }

    private void createLabels() {
        this.directionLabel = new Label("Direction (U/D/L/R)");
        this.spacesLabel = new Label("Number of Spaces");
    }

    private void createTextFields() {
        this.directionText = new TextField();
        this.spacesText = new TextField();
        this.directionText.setPrefWidth(30);
        this.spacesText.setPrefWidth(50);
    }

    private void createMoveButton() {
        this.btnMove = new Button("Move");
    }

    private void createAndAddChildren() {
        createLabels();
        createTextFields();
        createMoveButton();
        getChildren().addAll(this.directionLabel, this.directionText,
                             this.spacesLabel, this.spacesText, this.btnMove);
    }

    public void addMoveButtonAction(Grid g, CircleMarker cm)
    {




        btnMove.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String s = directionText.getText();
                char ch = ' ';
                if(s.length() > 0)
                 ch = s.charAt(0);

                if(ch == 'U' || ch == 'D' || ch == 'L' || ch == 'R')
                {

                    String spaces = spacesText.getText();
                int num = 0;
                    try {
                         num = Integer.parseInt(spaces);
                    } catch (NumberFormatException | NullPointerException nfe) {

                    }



                    int x = cm.getX();


                    int y = cm.getY();
                    int[] arr = {x, y};
                    int[] arrNew = Direction.getNewCoordinatesForDirection(s.charAt(0), arr, num);


                    cm.updateLocation(g, arrNew);
                    directionText.setText("");
                    spacesText.setText("");
                }
                else {
                    directionText.setText("");
                    spacesText.setText("");
                }
            }
        });




    }
}
