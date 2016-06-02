package com.example.user.imcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditPeso;
    private EditText mEditEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mTextViewImc;
    private TextView mTextViewClasificacion;
    ImageView mImageViewIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditPeso = (EditText)findViewById(R.id.edit_text_peso);
        mEditEstatura = (EditText)findViewById(R.id.edit_text_estatura);
        mBotonCalcular = (Button)findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button)findViewById(R.id.boton_limpiar);
        mTextViewImc = (TextView)findViewById(R.id.text_view_imc);
        mTextViewClasificacion = (TextView)findViewById(R.id.text_view_clasificacion);
        mImageViewIMC = (ImageView)findViewById(R.id.imageView);

        mBotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEditPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mEditEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso /(estatura * estatura);

                if (imc >= 30){
                    mTextViewClasificacion.setText("Obesidad");
                }else if ((imc < 30)&& (imc >= 25)){
                    mTextViewClasificacion.setText("Sobrepeso");
                }else if ((imc < 24.9)&& (imc >=18.5)) {
                    mTextViewClasificacion.setText("Normal");
                }else if (imc <= 18.4) {
                    mTextViewClasificacion.setText("Bajo peso");
                }
                mTextViewImc.setText(Double.toString(imc));
            }
        });
        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditPeso.setText("");
                mEditEstatura.setText("");
                mTextViewClasificacion.setText("");
                mTextViewImc.setText("0");
            }
        });
    }
}
