import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Equation;
import model.Player;
import model.ViewLine;
import model.Wall;

public class GameView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2DNot2D");

        Canvas canvas = new Canvas(600, 200);

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.fillRect(10, 10, 10, 40);


        Player player = new Player(0, 0, 0);
        Wall wall = new Wall(10, -5, Math.PI / 2, 1000);

        ViewLine viewLine  = player.viewLine(0);

        Equation e = new Equation(viewLine, wall);

        System.out.println(e.distanceAlongViewLine());
        System.out.println(e.distanceAlongWall());

        Pane root = new Pane(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}