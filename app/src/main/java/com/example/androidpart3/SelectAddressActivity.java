package com.example.androidpart3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectAddressActivity extends AppCompatActivity {
    EditText editTextAddress;
    Button buttonBrassed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);

        editTextAddress=findViewById(R.id.et_edittext);
        buttonBrassed=findViewById(R.id.bu_button);

    }

    public void confirmAddress(View view) {
        String address=editTextAddress.getText().toString();
        if(address.isEmpty()){
            Toast.makeText(this, "Address Required", Toast.LENGTH_SHORT).show();
            editTextAddress.setError("Address Required");
            return;
        }

        Intent intent= new Intent();
        //بابعت من Activity الي التانية سواء كانت قبلها او بعدها استخدم putExtra
        intent.putExtra("address",address);
       // ضيف النتيجة اللي هترجع لل activity ال قبلها
       setResult(RESULT_OK,intent);
        finish();


    }

    //  PoP-UP Menu
    public void Language(View view) {
        PopupMenu popupMenu = new PopupMenu(this,findViewById(R.id.bu_button_language));
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.arabic) {
                    Toast.makeText(SelectAddressActivity.this, "Arabic", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.english) {
                    Toast.makeText(SelectAddressActivity.this, "English", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}