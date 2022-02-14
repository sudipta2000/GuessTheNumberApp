package com.example.guessthenumber;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checking extends AppCompatActivity {
    int count = 5; // hints count
    int guess_count = 10; //guess count
    int hint_counter = 0; //Hints counter
    int result;
    boolean flag = true;
    boolean flag_success = false;
    int score = 0;
    int score_hint = 0;
    int check = 0;
    String hints1[] = new String[10];
    String hints2[] = new String[10];

    int hints_guess = getRandomNumber(9, 0);
    Button btn1;

    static int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void makeToast(String str) {
        Toast.makeText(checking.this, str, Toast.LENGTH_SHORT).show();
    }

    public void clickFunction(View view) {
        Button btn2;
        btn2 = (Button) findViewById(R.id.button);
        btn2.setEnabled(true);

        int userGuessing;
        EditText variable = (EditText) findViewById(R.id.editId);
        userGuessing = Integer.parseInt(variable.getText().toString());

        if (userGuessing < result) {

            makeToast("Think of  Higher Number,Try Again");
        } else if (userGuessing > result) {
            makeToast("Think of Lower Number,Try Again");
        } else if (userGuessing == result) {
            flag_success = true;


            makeToast("Congratulations," + " You Got the Number");
            if (flag_success) {
                btn2.setEnabled(false);

            }
            GameOver(guess_count);


        }

        guess_count--;
        if (guess_count == 0) {
            flag = false;
            btn2.setEnabled(false);
            makeToast("Game Over!!");
            GameOver(guess_count);

        }


    }

    public void GameOver(int guess_count) {
        switch (guess_count) {
            case 10:
                this.score = 10;
                break;
            case 9:
                this.score = 9;
                break;
            case 8:
                this.score = 8;
                break;
            case 7:
                this.score = 7;
                break;
            case 6:
                this.score = 6;
                break;
            case 5:
                this.score = 5;
                break;
            case 4:
                this.score = 4;
                break;
            case 3:
                this.score = 3;
                break;
            case 2:
                this.score = 2;
                break;
            case 1:
                this.score = 1;
                break;
        }
        score = score - score_hint;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("\nYour score is: " + this.score + "\n\nYour Accuracy: " + (score * 10) + "%\n\n" + "You Have Used: " + hint_counter + " Hints  \n\n\n The Actual number was: " + result);
        final View customLayout = getLayoutInflater().inflate(R.layout.csutom, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // send data from the
                // AlertDialog to the Activity

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    public void onClickCount(View View) {
        hint_counter++;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hints");
        int random = getRandomNumber(10, 0);
        String hints = "";

        switch (count) {
            case 5:
            case 4:
            case 3:
                hints = hints1[random];
                break;
            case 2:
            case 1:
                hints = hints2[random];
                break;
        }
        builder.setMessage(hints + "\n\n\n" + " You Have " + (count - 1) + " Hints Left");


        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.csutom, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // send data from the
                // AlertDialog to the Activity

            }
        });

        // create and show
        // the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        btn1 = (Button) findViewById(R.id.button2);
        if (flag == true) {
            btn1.setEnabled(true);
        } else {
            btn1.setEnabled(false);
        }

        if (flag_success == true) {
            btn1.setEnabled(false);
        }

        count--;
        score_hint = score_hint + 1;
        makeToast("You have " + count + " Hints Left..!!");
        if (count == 0) {
            btn1.setEnabled(false);
        }

    }

    public String fun1(int num) {
        String prime = "";
        int count = 1;
        for (int i = 1; i < num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            prime = "The Number Is a Prime Number."; // Modify Range with Num+ Random number.
        } else {
            prime = "The Number Is Not a Prime Number.";
        }
        return prime;
    }

    public String fun2(int num) {
        String palindrome = "";
        int temp = 0;
        int sum = 0, rem = 0;
        while (num != 0) {
            rem = num % 10;
            sum = (sum * 10) + rem;
            num /= 10;
        }
        if (temp == sum) {
            palindrome = "The Number Is a Palindrome Number.";
        } else
            palindrome = "The Number Is Not a Palindrome Number.";
        return palindrome;
    }

    public String fun3(int num) {
        String range = "The Number is in Range.." + (num - 10) + " " + (num + 10) + " " + "_____" + (num + 15) + " " + (num + 20);
        return range;
    }

    public String fun4(int num) {

        String range = "The Number is a common factor of..." + (num * 5) + ", " + (num * 6) + ", " + (num * 7) + ", " + (num * 8);
        return range;
    }

    public String fun5(int num) {
        String circle = "We can Create a Circle With Area: " + (3.14 * num * num);
        return circle;
    }

    public String fun6(int num) {
        String math = "The Number is Multiplied with 10 Then Addition with 20. After Calculation it is: " + (num * 10 + 20) + " Find The Number.";
        return math;
    }

    public String fun7(int num) {
        String replica = "It has Its Own 3 Replica. Like You You You. After Calculation: " + (num * num * num) + " Find The Number";
        return replica;
    }

    public String fun8(int num) {
        String factorial = "The Number is in Format like N power N or in Computer Science Term it is O(n^n). After Calculation: " + (num - 4) * (num - 3) * (num - 2) * (num - 1) + " Find The Number.";
        return factorial;
    }

    public String fun9(int num) {
        String range = "Its in Range Like " + (num + 10) + " " + (num + 20) + " " + (num + 30) + " " + (num + 35) + " " + (num + 40) + " Find The Number";
        return range;
    }

    public String fun10(int num) {
        String res = " ";
        double d = num;
        if (d == 28 || d == 30 || d == 31) {
            res = "Your Salary is Credited into Your Account.";
        } else {
            res = "It Has 18% GST With it. " + (d + 18) / 100;
        }
        return res;
    }

    //Hints 2....

    public String fun11(int num) {
        String range = "Its in range Like " + (num * 2) + " " + (num * 3) + " " + (num * 4) + " " + (num * 5);
        return range;
    }

    public String fun12(int num) {
        String bird = "There are " + (num) + " Birds Sitting on a Tree";
        return bird;
    }

    public String fun13(int num) {
        String range = "Its like " + (num) + " " + (num + num) + " " + (num + num + num);
        return range;
    }

    public String fun14(int num) {
        String purchase = "A man Came to a Shop To Purchase X amount of Toys. By Mistake ShopKeeper Gave 5 Toys Extra: " + (num + 5);
        return purchase;
    }

    public String fun15(int num) {
        String sqr = "Hey I am Square Root of X : " + Math.sqrt(num); //Ekhane Number er sqrt add kre dis.
        return sqr;
    }

    public String fun16(int num) {
        String rev = " " + (num * 20 + 20) + " Its Calculation of X*20+20. FInd The Number.";
        return rev;
    }

    public String fun17(int num) {
        String ctc = "Jimmy Gets His Salary Package of " + (num * 12) + " He Got Was Happy Because He Got To Know His In Hand is Same As His CTC";
        return ctc;
    }

    public String fun18(int num) {
        String apple = "There are " + (num) + " Apples.";
        return apple;
    }

    public String fun19(int num) {
        String passenger = "From a Certain Number of Passengers 2 3 5 Passengers Just Boarded The Train. Now The Train is Leaving For Next Station With " + (num + 2 + 3 + 5) + " No of Passengers.";
        return passenger;
    }

    public String fun20(int num) {
        String res = " ";
        if (num == 28) {
            res = "You Have to Wait For Me For  4 Years";
        } else {
            res = "He Got Rs." + (num * 2) + " As a Double Salary Bonus.";

        }
        return res;
    }

    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        btn5 = (Button) findViewById(R.id.button3);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(checking.this, MainActivity.class);
                startActivity(intent);
            }
        });

        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
        hints1[0] = fun1(result);
        hints1[1] = fun2(result);
        hints1[2] = fun3(result);
        hints1[3] = fun4(result);
        hints1[4] = fun5(result);
        hints1[5] = fun6(result);
        hints1[6] = fun7(result);
        hints1[7] = fun8(result);
        hints1[8] = fun9(result);
        hints1[9] = fun10(result);

        //hints 2

        hints2[0] = fun11(result);
        hints2[1] = fun12(result);
        hints2[2] = fun13(result);
        hints2[3] = fun14(result);
        hints2[4] = fun15(result);
        hints2[5] = fun16(result);
        hints2[6] = fun17(result);
        hints2[7] = fun18(result);
        hints2[8] = fun19(result);
        hints2[9] = fun20(result);

    }
}
