package com.example.akhil.tictactoe;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akhil.tictactoe.Utility.UtilityVariables;

import java.util.HashMap;

import static com.example.akhil.tictactoe.Utility.UtilityVariables.ALREADY_OCCUPIED;

public class GamePlayActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = GamePlayActivity.class.getName();
    private TextView textView;
    private ImageButton imageButton;
    private GamePlay gamePlay;

    private Dialog showDialog;

    private final char X_PLAY = 'X';
    private final char O_PLAY = 'O';

    private int ALREADY_OCCUPIED = 0;
    private int GAME_COMPLETED = 1;
    private int YOU_WON = 2;
    private int YOU_LOST = 3;
    private int GO_ON = 4;



    private char playerSelected;
    private HashMap<Integer,Integer> buttonIndexRelation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Add back buttons
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gamePlay = new GamePlay(X_PLAY,O_PLAY);
        buttonIndexRelation = new HashMap<>();
        //Setting OnClick Listeners for all buttons and all association of all Buttons with their indexes
        setOnClickListener();
        playerSelected = X_PLAY;

        showDialog = new Dialog(this);
    }

    //    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "-- ON STOP --");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /* if(id == R.id.refresh)
        {

        } */

        if(id > 0 )
        {        NavUtils.navigateUpFromSameTask(this);
                 return true;
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }


    private void setOnClickListener()
    {
        int[] buttonlist = {R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9};
        for (int index=0;index < buttonlist.length; index++)
        {
            buttonIndexRelation.put(buttonlist[index],index);
        }
        for (int i : buttonlist)
        {
            findViewById(i).setOnClickListener(this);

        }
    }
    @Override
    public void onClick(View v) {
        int indexToPlaceCharacter = buttonIndexRelation.get(v.getId());
        UICharacterPlace(indexToPlaceCharacter,this.playerSelected);

        int returnValue = gamePlay.place(indexToPlaceCharacter);
        switch (returnValue) {
            case UtilityVariables.ALREADY_OCCUPIED:
                Toast.makeText(this, "THIS IS ALREADY OCCUPIED. TRY AGAIN!!", Toast.LENGTH_LONG).show();
                return;
            case UtilityVariables.GAME_COMPLETED:
                Toast.makeText(this, "GAME COMPLETED!!", Toast.LENGTH_LONG).show();
                // showDialogDraw();
                return;
            case UtilityVariables.GO_ON:
                try {
                    Thread.sleep(1000);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                UICharacterPlace( gamePlay.getLatestAIMove(),O_PLAY);
                Toast.makeText(this, "GO ON!!!", Toast.LENGTH_LONG).show();
                break;
            case UtilityVariables.YOU_WON:
                Toast.makeText(this, "Someone has won!!", Toast.LENGTH_LONG).show();
                showDialogWin();
                return;
        }


        //AI Game character Play!!!!


    }


    void UICharacterPlace(int whereToPlaceCharacter, char playerSelected)
    {
        switch (whereToPlaceCharacter)
        {
            case 0:

                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image11).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image12).setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image21).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image22).setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image31).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image32).setVisibility(View.VISIBLE);
                }
                break;
            case 3:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button4).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image41).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button4).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image42).setVisibility(View.VISIBLE);
                }
                break;
            case 4:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button5).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image51).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button5).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image52).setVisibility(View.VISIBLE);
                }
                break;
            case 5:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button6).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image61).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button6).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image62).setVisibility(View.VISIBLE);
                }
                break;
            case 6:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button7).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image71).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button7).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image72).setVisibility(View.VISIBLE);
                }
                break;
            case 7:
                if(playerSelected == X_PLAY) {
                    findViewById(R.id.button8).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image81).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.button8).setVisibility(View.INVISIBLE);
                    findViewById(R.id.image82).setVisibility(View.VISIBLE);
                }
                break;
            case 8:
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
    }

    void showDialogWin()
    {
        showDialog.setContentView(R.layout.you_won);
        ImageView closePopUpYouWonImg = (ImageView)showDialog.findViewById(R.id.closeWonGamePopUpImg);
        Button btnWon = (Button) showDialog.findViewById(R.id.positiveButton);
        btnWon.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                showDialog.dismiss();
            }
        });

        showDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        showDialog.show();
    }

    void showDialogDraw()
    {
        showDialog.setContentView(R.layout.draw_match);
        ImageView closePopUpYouWonImg = (ImageView)showDialog.findViewById(R.id.closeDrawGamePopUpImg);
        Button btnWon = (Button) showDialog.findViewById(R.id.negativeButton);
        closePopUpYouWonImg.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                showDialog.dismiss();
            }
        });

        btnWon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        showDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        showDialog.show();
    }
}