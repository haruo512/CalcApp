package jp.techacademy.motoharu.watanabe.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1;
    EditText mEditText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText1.setInputType(InputType.TYPE_CLASS_NUMBER);   //数値入力指定
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER);   //数値入力指定
    }

    @Override
    public void onClick(View v){

        //String→doubleに変換
        String result_text1 = mEditText1.getText().toString();
        String result_text2 = mEditText2.getText().toString();
        double result_double1 = Double.parseDouble(result_text1);
        double result_double2 = Double.parseDouble(result_text2);

        Intent intent = new Intent(this,SecondActivity.class);

        //引数分岐
        if(v.getId()==R.id.button1){
            intent.putExtra("VALUE1",result_double1+result_double2);
        }else if(v.getId()==R.id.button2){
            intent.putExtra("VALUE1",result_double1-result_double2);
        }else if(v.getId()==R.id.button3){
            intent.putExtra("VALUE1",result_double1*result_double2);
        }else if(v.getId()==R.id.button4) {
            intent.putExtra("VALUE1",result_double1/result_double2);
        }

        //画面遷移
        startActivity(intent);

    }
}
