package com.example.akhil.tictactoe;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private ImageButton imageButton;
    private GamePlay gamePlay;
    private final char X_PLAY = 'O';
    private final char O_PLAY = 'X';
    private char playerSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gamePlay = new GamePlay();

        //Setting OnClick Listeners for all buttons
        setOnClickListener();
        playerSelected = X_PLAY;



    //    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    private void setOnClickListener()
    {
        int[] buttonlist = {R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9};
        for (int i : buttonlist)
        {
            findViewById(i).setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {
        int indexToPlaceCharacter =-99;
        switch (v.getId())
        {
            case R.id.button1:
                indexToPlaceCharacter = 0;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image11).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image12).setVisibility(View.VISIBLE);
                }
            break;
            case R.id.button2:
                indexToPlaceCharacter = 1;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image21).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image22).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button3:
                indexToPlaceCharacter = 2;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image31).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image32).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button4:
                indexToPlaceCharacter =3;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button4).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image41).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button4).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image42).setVisibility(View.VISIBLE);
                }
            case R.id.button5:
                indexToPlaceCharacter = 4;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button5).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image51).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button5).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image52).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button6:
                indexToPlaceCharacter = 5;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button6).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image61).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button6).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image62).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button7:
                indexToPlaceCharacter = 6;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button7).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image71).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button7).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image72).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button8:
                indexToPlaceCharacter = 7;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button8).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image81).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button8).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image82).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button9:
                indexToPlaceCharacter = 8;
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button9).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image91).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button9).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image92).setVisibility(View.VISIBLE);
                }
                break;
        }

        String returnValue = gamePlay.place(indexToPlaceCharacter,playerSelected);
        if( returnValue != null)
        {
            Toast.makeText(this,returnValue ,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"You can continue!!!" ,Toast.LENGTH_LONG).show();

        }

    }
}
