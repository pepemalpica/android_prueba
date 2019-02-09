package com.example.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etNumber;
    Button btnCalculate;
    TextView tvResult;

    int number = 0;
    int result = 0;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //find views
        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get number
                number = Integer.parseInt( etNumber.getText().toString().trim() );

                if( isPar(number) ){
                    //Calcular el factorial
                    result = factorial(number);
                    msg = "El número: "+number+" es par, y el resultado de su factorial es: "+result;
                }else{
                    //Calcular el factorial con suma (+)
                    result = factorialSuma(number);
                    msg = "El número: "+number+" es impar, y el resultado de su factorial con suma es: "+result;
                }

                //Mostrar resultado
                tvResult.setText( msg );
            }
        });

    }

    private boolean isPar( int mNumber ) {
        return mNumber % 2 == 0;
    }


    private int factorial( int mNumber ){
        if( mNumber <= 1 ){
            return 1;
        }else {
            return mNumber * factorial(mNumber-1);
        }
    }

    private int factorialSuma( int mNumber ){
        if( mNumber <= 1 ){
            return 1;
        }else {
            return mNumber + factorialSuma(mNumber-1);
        }
    }


}
