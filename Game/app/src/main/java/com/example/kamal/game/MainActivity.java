package com.example.kamal.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int i=1,j=0,k=0;
    int[] firstplayer= new int[5];
    int[] secondplayer= new int[4];
    int[][] winnercombinations={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    public void zerokata(View view){
        //Log.d("CREATION",""+i);
        ImageView bc = (ImageView) view;
        int tappedlocation=Integer.parseInt(bc.getTag().toString());


        if (i%2==1 && i<10 &&j<5)
        {

            bc.setImageResource(R.drawable.x);
            firstplayer[0]=tappedlocation;
            //  Log.d("CREATION",Arrays.toString(firstplayer));

            j++;

        }
        else if (i%2==0 && i<10 &&k<4)
        {
            //  Log.d("CREATION second",""+k);
            bc.setImageResource(R.drawable.o);
            secondplayer[0]=tappedlocation;
            //  Log.d("CREATION",Arrays.toString(secondplayer));
            k++;
        }
        bc.setEnabled(false);


        i++;
        if(i>10)
        {
            Toast.makeText(MainActivity.this,"no result play agian ",Toast.LENGTH_SHORT).show();
            reset();
        }
        //Toast.makeText(Game.this,""+tappedlocation,Toast.LENGTH_SHORT).show();
        Arrays.sort(firstplayer);
        Arrays.sort(secondplayer);
        //  Log.d("CREATION",Arrays.toString(firstplayer));
        //  Log.d("CREATION",Arrays.toString(secondplayer));
        if (wincondition(firstplayer))
        {
            Toast.makeText(MainActivity.this,"first player won",Toast.LENGTH_SHORT).show();
            try {
                //set time in mili
                Thread.sleep(500);

            }catch (Exception e){
                e.printStackTrace();
            }
            reset();

        }
        else if (wincondition(secondplayer))
        {
            Toast.makeText(MainActivity.this,"second player won",Toast.LENGTH_SHORT).show();
            try {
                //set time in mili
                Thread.sleep(500);

            }catch (Exception e){
                e.printStackTrace();
            }
            reset();

        }


    }

    public void reset() {
        i=1;
        j=0;
        k=0;
        firstplayer=new int[5];
        secondplayer=new int[4];
        GridLayout gridLayout=(GridLayout) findViewById(R.id.Gridlayout);
        for(int i=0; i< gridLayout.getChildCount();i++) {
            ((ImageView) gridLayout.getChildAt(i)).setEnabled(true);
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    public void reset(View view){

        //  Log.d("CREATION",Arrays.toString(firstplayer));
        // Log.d("CREATION",Arrays.toString(secondplayer));
        i=1;
        j=0;
        k=0;
        firstplayer=new int[5];
        secondplayer=new int[4];
        GridLayout gridLayout=(GridLayout) findViewById(R.id.Gridlayout);
        for(int i=0; i< gridLayout.getChildCount();i++) {
            ((ImageView) gridLayout.getChildAt(i)).setEnabled(true);
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    public boolean wincondition(int[] x){
        boolean win=false;
        //  int numberarray=(x.length-2);
        int[] playerl1= new int[3];
        for(int i=0;i<x.length-2;i++){
            for (int ij=0;ij<3;ij++)
            {
                playerl1[ij]=x[ij+i];

            }

            for (int ij1=0;ij1<8;ij1++)
            {
                win= Arrays.equals(playerl1,winnercombinations[ij1]);
                if (win==true)
                {
                    return true;
                }

            }

        }
        return win;


    }

}
