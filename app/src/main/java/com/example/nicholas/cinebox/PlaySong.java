package com.example.nicholas.cinebox;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicholas.cinebox.model.MusicModel;
import com.example.nicholas.cinebox.utils.SongCollection;

import java.io.IOException;

public class PlaySong extends AppCompatActivity {

    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";

    private String songId = "";
    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private String coverArt = "";
    private String url = "";

    private MediaPlayer player = null;


    private int musicPosition = 0;


    private Button btnPlayPause = null;


    private SongCollection songCollection = new SongCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        btnPlayPause = findViewById(R.id.btnPlayPause);

        retrieveData();

        displaySong(title, artist, coverArt);
    }

    private void retrieveData() {
        Bundle songData = this.getIntent().getExtras();

        songId = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");

        url = BASE_URL + fileLink;
    }
    public static int getImageIdFromDrawable(Context context, String imageName)
    {
        int imageID = context.getResources().getIdentifier(imageName,"drawable", context.getPackageName());

        return imageID;
    }

    private void displaySong(String title, String artist, String coverArt) {

        TextView txtTitle = findViewById(R.id.txtSongTitle);


        txtTitle.setText(title);


        TextView txtArtist = findViewById(R.id.txtArtist);


        txtArtist.setText(artist);


        int imageId = getImageIdFromDrawable(this, coverArt);


        ImageView ivCoverArt = findViewById(R.id.imgCoverArt);


        ivCoverArt.setImageResource(imageId);
    }

    private void preparePlayer() {

        player = new MediaPlayer();


        try {

            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            player.setDataSource(url);


            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void pauseMusic() {

        player.pause();


        musicPosition = player.getCurrentPosition();


        btnPlayPause.setText("PLAY");
    }

    public void playOrPauseMusic(View view) {

        if (player == null)
            preparePlayer();


        if (!player.isPlaying()) {


            if (musicPosition > 0) {

                player.seekTo(musicPosition);
            }


            player.start();


            btnPlayPause.setText("PAUSE");


            setTitle("Now Playing:" +  title + '-' + artist);


            gracefullyStopWhenMusicEnds();
        } else {

            pauseMusic();
        }
    }

    private void gracefullyStopWhenMusicEnds()
    {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                                       {
                                           @Override
                                           public void onCompletion(MediaPlayer mediaPlayer)
                                           {
                                               stopActivities();
                                           }
                                       }
        );
    }

    private void stopActivities()
    {
        if (player!= null)
        {
            player.stop();
            player.release();
            btnPlayPause.setText("PLAY");
            setTitle(" ");
            musicPosition = 0;
        }
    }

    public void playNext(View view)
    {

        MusicModel nextSong = songCollection.getNextSong(songId);


        if (nextSong != null)
        {

            songId = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFileLink();
            coverArt = nextSong.getCoverArt();


            url = BASE_URL + fileLink;


            displaySong(title, artist, coverArt);


            stopActivities();


            playOrPauseMusic(view);
        }
    }
}
