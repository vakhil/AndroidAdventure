package com.example.akhil.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button newGame;
    private Button aboutMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        newGame = (Button) findViewById(R.id.new_game);
        aboutMe = (Button) findViewById(R.id.about_me);

        newGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChoosePlayer.class);
                startActivity(intent);
            }
        });

        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(MainActivity.this,AboutMe.class);
                // startActivity(intent);
            }
        });
    }

    //    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

}
