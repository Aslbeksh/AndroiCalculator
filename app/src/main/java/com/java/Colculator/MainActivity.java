package com.java.Colculator;

import android.support.v7.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display =findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("C");
                }
            }
        });
    }

    private  void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }else{
            display.setText(String.format("%s%s%s",leftStr, strToAdd,rightStr));
            display.setSelection(cursorPos + 1);

        }


    }

    public void nollBTN(View view){
        updateText("0");
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void exponentBTN(View view){
        updateText("^");
    }
    public void qavislarBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {


            if (display.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(") ){
            updateText("(");
            display.setSelection(cursorPos + 1);

        }
        else if (closedPar < openPar && ! display.getText().toString().substring(textLen-1, textLen).equals("(") ){
            updateText(")");
            display.setSelection(closedPar + 1);
        }


    }
    public void buluvBTN(View view){
        updateText("÷");
    }
    public void ettiBTN(View view){
        updateText("7");
    }
    public void sakisBTN(View view){
        updateText("8");
    }
    public void toqisBTN(View view){
        updateText("9");
    }
    public void  kupaytruvBTN(View view){
        updateText("×");
    }
    public void tortBTN(View view){
        updateText("4");
    }
    public void  beshBTN(View view){
        updateText("5");
    }
    public void  oltiBTN(View view){
        updateText("6");
    }
    public void  plusBTN(View view){
        updateText("+");
    }
    public void  birBTN(View view){
        updateText("1");
    }
    public void ikkiBTN(View view){
        updateText("2");
    }
    public void  uchBTN(View view){
        updateText("3");
    }
    public void  minusBTN(View view){
        updateText("-");
    }
    public void  yokiBTN(View view){
     updateText("+/-");
    }
    public void  tochkaBTN(View view){
        updateText(".");
    }

    public void  tengBTN(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }

    public void backspaceBTN (View view){
int cursorPos = display.getSelectionStart();
int texLen = display. getText().length();
if (cursorPos != 0 && texLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

}