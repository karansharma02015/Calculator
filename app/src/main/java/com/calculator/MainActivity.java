package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputtext, outputtext;

    private String input, output, newOutput;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonadd,buttonmultiply,buttonsubs,buttondiv,buttonpoint,buttonpercent,buttonpower,buttonequal,buttonclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputtext = findViewById(R.id.input_text);
        outputtext = findViewById(R.id.output_text);

        button0 = findViewById(R.id.zero_button);
        button1 = findViewById(R.id.one_button);
        button2 = findViewById(R.id.two_button);
        button3 = findViewById(R.id.three_button);
        button4 = findViewById(R.id.four_button);
        button5 = findViewById(R.id.five_button);
        button6 = findViewById(R.id.six_button);
        button7 = findViewById(R.id.seven_button);
        button8 = findViewById(R.id.eight_button);
        button9 = findViewById(R.id.nine_button);
        buttonadd = findViewById(R.id.addition_button);
        buttonsubs = findViewById(R.id.subtraction_button);
        buttonmultiply = findViewById(R.id.multiply_button);
        buttondiv = findViewById(R.id.div_button);
        buttonpercent = findViewById(R.id.percent_button);
        buttonequal = findViewById(R.id.equal_button);
        buttonpoint = findViewById(R.id.point_button);
        buttonpower = findViewById(R.id.power_button);
        buttonclear = findViewById(R.id.clear_button);
    }

    public void onButtonClicked(View view){

        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {

            case "C":
                input = null;
                output = null;
                newOutput = null;
                outputtext.setText("");
                break;

            case "^":

                if (input == null){
                    break;
                }
                else {
                    solve();
                    input += "^";
                    break;
                }
            case "*":

                if(input == null){
                    break;
                }
                else {
                    solve();
                    input += "*";
                    break;
                }
            case "=":

                if (input == null || input.equals("")){
                    break;
                }
                else {
                    solve();
                    break;
                }
            case "%":
                if (input == null){
                    input = "";
                }
                else {
                    input += "%";
                    try {
                        double d = Double.parseDouble(inputtext.getText().toString()) / 100;
                        outputtext.setText(String.valueOf(d));
                    }
                    catch (NumberFormatException ex) {

                    }
                    break;
                }

            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    solve();
                }
                input += data;
        }
        inputtext.setText(input);
    }

    private void solve(){
        if(input.split("\\+").length == 2){

            String numbers[] = input.split("\\+");

            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = (output);
                outputtext.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                outputtext.setText(e.getMessage().toString());
            }

        }

        if(input.split("\\*").length == 2){

            String numbers[] = input.split("\\*");

            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = (output);
                outputtext.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                outputtext.setText(e.getMessage().toString());
            }

        }
        if(input.split("\\/").length == 2){

            String numbers[] = input.split("\\/");

            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);

                newOutput = (output);
                outputtext.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                outputtext.setText(e.getMessage().toString());
            }

        }
        if(input.split("\\^").length == 2){

            String numbers[] = input.split("\\^");

            try {
                double d = Math.pow(Double.parseDouble(numbers[0]) , Double.parseDouble(numbers[1]));
                output = Double.toString(d);

                newOutput = (output);
                outputtext.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                outputtext.setText(e.getMessage().toString());
            }

        }

        if(input.split("\\-").length == 2){

            String numbers[] = input.split("\\-");

            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
               newOutput = (output);
                outputtext.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                outputtext.setText(e.getMessage().toString());
            }

        }

    }

//    private String cutdecimal(String number){
//        String n [] = number.split("//.");
//        if(n.length > 1){
//             if(n[1].equals("0")){       //<-------
//                 number = n[0];
//             }
//        }
//        return number;
//    }
}