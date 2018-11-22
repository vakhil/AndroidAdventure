package com.example.akhil.tictactoe;

import android.content.Context;

import com.example.akhil.tictactoe.Utility.UtilityVariables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

 public class GamePlay {

    private char[] boxes; // 0 for nothing 1 for X and 2 for 0
    private int numberOfMoves = 0;
    private char AICharacter;
    private char playerCharacter;
    private int latestAIMove;
    GamePlay(char playerCharacter, char AICharacter)
    {
        boxes = new char[9];
        Arrays.fill(boxes,UtilityVariables.EMPTY_FLAG);
        this.AICharacter = AICharacter;
        this.playerCharacter = playerCharacter;
    }

    public int getLatestAIMove()
    {
        return latestAIMove;
    }
    public int place(int boxNo)
    {
        if(boxes[boxNo] != UtilityVariables.EMPTY_FLAG )
            return UtilityVariables.ALREADY_OCCUPIED;
        boxes[boxNo] = playerCharacter;
        numberOfMoves++;

        if(numberOfMoves == boxes.length)
        { return UtilityVariables.GAME_COMPLETED; }


        if(checkSuccesfulEnd())
        {
            return UtilityVariables.YOU_WON;
        }
        latestAIMove = AIPlay();
        numberOfMoves++;
        if(checkSuccesfulEnd())
        {
            return UtilityVariables.YOU_LOST;
        }
        return UtilityVariables.GO_ON;
    }

    public int AIPlay()
    {
        ArrayList<Integer> freeSpaces = new ArrayList<Integer>();
        for (int i=0; i< 9; i++)
        {
         if(boxes[i] == UtilityVariables.EMPTY_FLAG)
         {
             freeSpaces.add(i);
         }
        }
        int Max = freeSpaces.size();
        int randomAIPick = (int) (Math.random() * (Max));
        boxes[freeSpaces.get(randomAIPick)] = AICharacter;
        return freeSpaces.get(randomAIPick);
    }

    public boolean checkSuccesfulEnd()
    {
        if(numberOfMoves < 3)
            return false;

        for (int i=0;i < 3; i++)
        {
            if(boxes[0+3*i]!=UtilityVariables.EMPTY_FLAG && (boxes[0+3*i] == boxes[1+3*i]) &&  (boxes[1+3*i]== boxes[2+3*i]))
            {
                return true;
            }
            if(boxes[i+3*0]!=UtilityVariables.EMPTY_FLAG && boxes[i+3*0]==boxes[i+3*1] && (boxes[i+3*1]==boxes[i+3*2]))
            {
                return true;
            }
        }
        if(boxes[0] != UtilityVariables.EMPTY_FLAG && (boxes[0]==boxes[4]) && (boxes[4]==boxes[8]))
            return true;
        if(boxes[2] != UtilityVariables.EMPTY_FLAG &&  (boxes[2] == boxes[4]) && (boxes[4] == boxes[6]))
            return true;
        return false;
    }
}
