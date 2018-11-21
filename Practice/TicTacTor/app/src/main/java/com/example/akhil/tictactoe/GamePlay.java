package com.example.akhil.tictactoe;

import java.util.Arrays;

public class GamePlay {
    private int X_FLAG = 1;
    private int O_FLAG = 0;
    private int[] boxes; // 0 for nothing 1 for X and 2 for 0
    private int numberOfMoves = 0;
    GamePlay()
    {
        boxes = new int[9];
        Arrays.fill(boxes,0);
    }

    String place(int boxNo, char boxValue)
    {
        if(boxValue == 'X')
            boxes[boxNo] = X_FLAG;
        else
            boxes[boxNo] = O_FLAG;


        numberOfMoves++;
        if(checkSuccesfulEnd())
        {
            return "SUCCESS";
        }
        if(numberOfMoves ==9)
        {
            return "COMPLETED";
        }
        return null;
    }

    public boolean checkSuccesfulEnd()
    {
        if(numberOfMoves < 3)
            return false;

        for (int i=0;i < 3; i++)
        {
            if( (boxes[0+3*i] == boxes[1+3*i]) &&  (boxes[1+3*i]== boxes[2+3*i]))
            {
                return true;
            }
            if(boxes[i+3*0]==boxes[i+3*1] && (boxes[i+3*1]==boxes[i+3*2]))
            {
                return true;
            }
        }
        if( (boxes[0]==boxes[4]) && (boxes[4]==boxes[8]))
            return true;
        if( (boxes[2] == boxes[4]) && (boxes[4] == boxes[6]))
            return true;
        return false;
    }
}
