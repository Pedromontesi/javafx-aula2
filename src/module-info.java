module javafxaula {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;	
    requires javafx.media;
    
	opens gui to javafx.fxml;

	opens application to javafx.graphics, javafx.fxml;
}
