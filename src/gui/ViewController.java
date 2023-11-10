package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

public class ViewController implements Initializable {

    @FXML
    private MediaPlayer mediaPlayer;

    @FXML
    private Button btnOpenFile;

    @FXML
    private Button btnPlayPause;

    @FXML
    private void openMusicFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a music file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.m4a"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            playMusic(selectedFile);
        }
    }

    @FXML
    private void playPauseMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                btnPlayPause.setText("Play");
            } else {
                mediaPlayer.play();
                btnPlayPause.setText("Pause");
            }
        }
    }

    private void playMusic(File musicFile) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media media = new Media(musicFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnOpenFile.setOnAction(e -> openMusicFile());
        btnPlayPause.setOnAction(e -> playPauseMusic());
    }

    
    
    
}
