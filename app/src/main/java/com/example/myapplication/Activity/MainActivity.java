package com.example.myapplication.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.Dao.UserDao;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        t=(EditText) findViewById(R.id.password);
        UserDao userDao=new UserDao(this,"account.db",null,1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserDao user=new UserDao(getApplicationContext(),"account.db",null,1);
                String passw=user.findPassw();
                String userin=t.getText().toString();
                if (userin.equals(passw)){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainScreen.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("");
            }
        });
    }
}
