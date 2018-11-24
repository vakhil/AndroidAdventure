package com.example.akhil.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChoosePlayer extends AppCompatActivity {

    TextView mPlayerFound;
    Button mButtonNewGame;
    EditText newPlayerName;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_player);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mButtonNewGame = (Button) findViewById(R.id.new_game_button);
        newPlayerName = (EditText) findViewById(R.id.edit_new_player);
        mPlayerFound = (TextView) findViewById(R.id.player_found);
        if(!preferences.contains("active_player"))
        {
            mPlayerFound.setText("No player Found!!! Enter name below to start a new game");
        }
        else {
            String playerName = preferences.getString("active_player","Akhil");
            mPlayerFound.setText("Hi "+ playerName+ " . Continue playing the game!!!");
            findViewById(R.id.button_player_found).setVisibility(View.VISIBLE);
        }
        mButtonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newPlayerName.getText().toString() != null)
                {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ChoosePlayer.this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("active_player",newPlayerName.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(ChoosePlayer.this,GamePlayActivity.class);
                    startActivity(intent);
                }
                else
                {
                    mButtonNewGame.setText("Enter name DumbFuck!");
                }
            }
        });
    }
}
