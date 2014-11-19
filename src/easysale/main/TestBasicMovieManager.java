package easysale.main;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class TestBasicMovieManager extends Application {
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	public static void main(String[] args) {
		BasicMovieManager manager = new BasicMovieManager();
		Movie filme = new Movie();
		filme.setDirector("diretor");
		filme.setSynopsis("sinopse");
		filme.setTitle("title");
		manager.persistMovie(filme);
		manager.findAll();
	}
}
