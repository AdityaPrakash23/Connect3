package com.a09gmail.a23.adityaprakash.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activeplayer = 0;        //0 is yellow player and 1 is red player.....
    int[] g = {2,2,2,2,2,2,2,2,2};
    int flag = 0;
    int count = 0;


    public void dropin(View v) {
        ImageView counter = (ImageView) v;
        TextView message = (TextView)findViewById(R.id.msg);
        int i = Integer.parseInt(counter.getTag().toString());

        if (flag == 0) {
            if (g[i] == 2) {
                counter.setTranslationY(-1000f);
                if (activeplayer == 0) {
                    counter.setImageResource(R.drawable.yellow);
                    counter.animate().translationYBy(1000f).setDuration(300);
                    activeplayer++;
                    g[i] = 0;
                    winCheck(0);
                    count++;
                } else if (activeplayer == 1) {
                    counter.setImageResource(R.drawable.red);
                    counter.animate().translationYBy(1000f).setDuration(300);
                    activeplayer--;
                    g[i] = 1;
                    winCheck(1);
                    count++;
                }
            } else {
                Log.d("Test", "Already tapped!!!");
            }
        }
        else if(flag == 1){
            //Restarting the app.....
        }
        if (count == 9){
            if(flag == 0){message.setText("It's a draw!!!");}
        }
    }

    public void winCheck(int x){
        TextView message = (TextView)findViewById(R.id.msg);
        boolean c1 = (g[0]==x)&&(g[1]==x)&&(g[2]==x);
        boolean c2 = (g[3]==x)&&(g[4]==x)&&(g[5]==x);
        boolean c3 = (g[6]==x)&&(g[7]==x)&&(g[8]==x);
        boolean c4 = (g[0]==x)&&(g[3]==x)&&(g[6]==x);
        boolean c5 = (g[1]==x)&&(g[4]==x)&&(g[7]==x);
        boolean c6 = (g[2]==x)&&(g[5]==x)&&(g[8]==x);
        boolean c7 = (g[0]==x)&&(g[4]==x)&&(g[8]==x);
        boolean c8 = (g[2]==x)&&(g[4]==x)&&(g[6]==x);

        if(x == 0){
            if(c1||c2||c3||c4||c5||c6||c7||c8){
                message.setText("Yellow player has won!!!");
                flag = 1;
            }
        }
        else if(x == 1){
            if(c1||c2||c3||c4||c5||c6||c7||c8){
                message.setText("Red player has won!!!");
                flag = 1;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
