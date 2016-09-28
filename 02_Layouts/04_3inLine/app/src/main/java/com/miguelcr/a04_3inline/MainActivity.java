package com.miguelcr.a04_3inline;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ImageView box1, box2, box3, box4, box5, box6, box7, box8, box9;
    boolean playerOneIsPlaying = true;
    TextView player;
    // Soluction 1
    int b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, b6 = 0, b7 = 0, b8 = 0, b9 = 0;

    // Solution 2          0, 1, 2, 3, 4, 5, 6, 7, 8
    int[] selectedBoxes = {0, 0, 0, 0, 0, 0, 0, 0, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box1 = (ImageView)findViewById(R.id.imageViewBox1);
        box2 = (ImageView)findViewById(R.id.imageViewBox2);
        box3 = (ImageView)findViewById(R.id.imageViewBox3);
        box4 = (ImageView)findViewById(R.id.imageViewBox4);
        box5 = (ImageView)findViewById(R.id.imageViewBox5);
        box6 = (ImageView)findViewById(R.id.imageViewBox6);
        box7 = (ImageView)findViewById(R.id.imageViewBox7);
        box8 = (ImageView)findViewById(R.id.imageViewBox8);
        box9 = (ImageView)findViewById(R.id.imageViewBox9);

        player = (TextView) findViewById(R.id.player);

    }

    public void onBoxClick(View view) {
        ImageView currentBox = (ImageView) view;
        int idBoxSelected = currentBox.getId();

        switch (idBoxSelected) {
            case R.id.imageViewBox1: changeBoxValue(0, currentBox); break;
            case R.id.imageViewBox2: changeBoxValue(1, currentBox); break;
            case R.id.imageViewBox3: changeBoxValue(2, currentBox); break;
            case R.id.imageViewBox4: changeBoxValue(3, currentBox); break;
            case R.id.imageViewBox5: changeBoxValue(4, currentBox); break;
            case R.id.imageViewBox6: changeBoxValue(5, currentBox); break;
            case R.id.imageViewBox7: changeBoxValue(6, currentBox); break;
            case R.id.imageViewBox8: changeBoxValue(7, currentBox); break;
            case R.id.imageViewBox9: changeBoxValue(8, currentBox); break;
        }

        int solution = checkSolution();
        if(solution==1) {
            player.setText("Player 1 Wins!");

        } else if(solution==2) {
            player.setText("Player 2 Wins!");
        }

        // If exist solution restart the game
        if(solution==1 || solution==2) {
            selectedBoxes = new int[]{0,0,0,0,0,0,0,0,0};
            box1.setImageResource(R.drawable.ic_box_empty);
            box2.setImageResource(R.drawable.ic_box_empty);
            box3.setImageResource(R.drawable.ic_box_empty);
            box4.setImageResource(R.drawable.ic_box_empty);
            box5.setImageResource(R.drawable.ic_box_empty);
            box6.setImageResource(R.drawable.ic_box_empty);
            box7.setImageResource(R.drawable.ic_box_empty);
            box8.setImageResource(R.drawable.ic_box_empty);
            box9.setImageResource(R.drawable.ic_box_empty);
        }

    }


    public int checkSolution() {
        int result = 0;
        boolean existSolution = false;

        /*
        *   0 1 2
        *   3 4 5
        *   6 7 8
        *
        * */

        // 1) 0,1,2
        if(selectedBoxes[0]==selectedBoxes[1]
                && selectedBoxes[1]==selectedBoxes[2]
                && selectedBoxes[0]!=0) {
            existSolution = true;

            // 2) 3,4,5
        } else if(selectedBoxes[3]==selectedBoxes[4]
                && selectedBoxes[4]==selectedBoxes[5]
                && selectedBoxes[3]!=0) {
            existSolution = true;

            // 3) 6,7,8
        } else if(selectedBoxes[6]==selectedBoxes[7]
                && selectedBoxes[7]==selectedBoxes[8]
                && selectedBoxes[6]!=0) {
            existSolution = true;
        }
        // 4) 0,3,6
        else if(selectedBoxes[0]==selectedBoxes[3]
                && selectedBoxes[3]==selectedBoxes[6]
                && selectedBoxes[0]!=0) {
            existSolution = true;
            // 5) 1,4,7
        } else if(selectedBoxes[1]==selectedBoxes[4]
                && selectedBoxes[4]==selectedBoxes[7]
                && selectedBoxes[1]!=0) {
            existSolution = true;
            // 6) 2,5,8
        } else if(selectedBoxes[2]==selectedBoxes[5]
                && selectedBoxes[5]==selectedBoxes[8]
                && selectedBoxes[2]!=0) {
            existSolution = true;
            // 7) 0,4,8
        }else if(selectedBoxes[0]==selectedBoxes[4]
                && selectedBoxes[4]==selectedBoxes[8]
                && selectedBoxes[0]!=0) {
            existSolution = true;
            // 8) 2,4,6
        } else if(selectedBoxes[2]==selectedBoxes[4]
                && selectedBoxes[4]==selectedBoxes[6]
                && selectedBoxes[6]!=0) {
            existSolution = true;
        }

        //... we must to write here the 7 possible solutions
        // that exist


        if(existSolution && !playerOneIsPlaying) {
            result = 1;
            player.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPlayer1));
        } else if(existSolution && playerOneIsPlaying) {
            result = 2;
            player.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPlayer2));
        }

        return result;
    }

    public void changeBoxValue(int boxPosition, ImageView currentBox) {
        // If position is empty (==0) we can change the color
        // and set the correct player number
        if(selectedBoxes[boxPosition]==0) {
            if (playerOneIsPlaying) {
                selectedBoxes[boxPosition] = 1;
            } else {
                selectedBoxes[boxPosition] = 2;
            }

            if (playerOneIsPlaying) {
                currentBox.setImageResource(R.drawable.ic_box_player_one);
                playerOneIsPlaying = false;
                player.setText("Player 2");
                player.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPlayer2));
            } else {
                currentBox.setImageResource(R.drawable.ic_box_player_two);
                playerOneIsPlaying = true;
                player.setText("Player 1");
                player.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPlayer1));

            }

        } else {
            Toast.makeText(MainActivity.this,"This box is not empty",
                    Toast.LENGTH_LONG).show();
        }
    }




}
