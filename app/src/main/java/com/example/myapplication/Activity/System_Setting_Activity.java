package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.UserDao;

public class System_Setting_Activity extends AppCompatActivity {
    EditText old_pass,new_pass,sec_new_pass;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_passw);
        new_pass=(EditText)findViewById(R.id.edt_NewPassWord);
        sec_new_pass=(EditText)findViewById(R.id.edt_NewPassWord2);
        b1=findViewById(R.id.btn_Confirm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(new_pass.getText().toString().equals(sec_new_pass.getText().toString())){
                    UserDao user=new UserDao(getApplicationContext(),"account.db",null,1);
                    user.changePassw(1,new_pass.getText().toString());
                    Toast.makeText(getApplicationContext(), "修改成功！", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "两次密码不一致!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
