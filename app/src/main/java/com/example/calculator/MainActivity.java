package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button num0, num1, num2, num3, num4, num5, num6,num7, num8, num9, addBtn, subBtn,
       mulBtn, divBtn, equalBtn, clearBtn, deciBtn;

    TextView inputsView, answerView;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Identifying the widgets
        num0=(Button) findViewById(R.id.num0);
        num1=(Button) findViewById(R.id.num1);
        num2=(Button) findViewById(R.id.num2);
        num3=(Button) findViewById(R.id.num3);
        num4=(Button) findViewById(R.id.num4);
        num5=(Button) findViewById(R.id.num5);
        num6=(Button) findViewById(R.id.num6);
        num7=(Button) findViewById(R.id.num7);
        num8=(Button) findViewById(R.id.num8);
        num9=(Button) findViewById(R.id.num9);
        addBtn=(Button) findViewById(R.id.addBtn);
        mulBtn=(Button) findViewById(R.id.mulBtn);
        subBtn=(Button) findViewById(R.id.subBtn);
        divBtn=(Button) findViewById(R.id.divBtn);
        equalBtn=(Button) findViewById(R.id.equalBtn);
        clearBtn=(Button) findViewById(R.id.clearBtn);
        deciBtn=(Button) findViewById(R.id.deciBtn);
        inputsView=(TextView) findViewById(R.id.inputsView);
        answerView=(TextView) findViewById(R.id.answerView);

        //setting up the event handlers
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputsView.setText("");
                answerView.setText("");
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "0");
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "1");
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "2");
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "3");
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "4");
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "5");
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "6");
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "7");
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "8");
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "9");
            }
        });

        deciBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + ".");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "+");
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "-");
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "x");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();
                inputsView.setText(process + "/");
            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputsView.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String result = " ";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    result = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                }
                catch (Exception e){
                    result = "0";
                }
                answerView.setText(result);

            }
        });
    }
}
