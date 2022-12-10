package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView image_pl1,image_pl2;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_pl1 = findViewById(R.id.image_pl1);
        image_pl2 = findViewById(R.id.image_pl2);


        image_pl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (image_pl1!=null && image_pl1.getTag().toString().contains("Not_Play")){
                    if (mediaPlayer!=null) mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.song_1);
                    mediaPlayer.start();
                    image_pl1.setImageResource(R.drawable.pause);
                    image_pl1.setTag("Plaing");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            image_pl1.setImageResource(R.drawable.play);
                            image_pl1.setTag("Not_Play");
                        }
                    });

                }else {
                    if (mediaPlayer!=null)mediaPlayer.release();
                    image_pl1.setImageResource(R.drawable.play);
                    image_pl1.setTag("Not_Play");

                }
          }
        });


        image_pl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (mediaPlayer!=null) mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();

                    try {
                        mediaPlayer.setDataSource("https://file-examples.com/storage/fe97c107176394b31a11146/2017/11/file_example_MP3_700KB.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();



                    } catch (IOException e) {
                        e.printStackTrace();
                    }




            }
        });


    }
}