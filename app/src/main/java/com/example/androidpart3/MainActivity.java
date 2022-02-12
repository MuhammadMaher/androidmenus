package com.example.androidpart3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//                              -- Menus and Android ssp,sdp and Alert Dialog --

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";// logt
    Button buttonAddress;
    TextView textViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddress=findViewById(R.id.button);
        textViewSignUp=findViewById(R.id.tv_SignUP);
// هتظهر لما ادوس علي ال textview دا
        registerForContextMenu(textViewSignUp);
        Log.i(TAG, "onCreate: ");
    }

    public void Address(View view) {
        Intent intent =new Intent(MainActivity.this,SelectAddressActivity.class);
        startActivityForResult(intent,1213);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1213 && resultCode==RESULT_OK && data !=null){
// هات ال string المتخزن في ال address
            String address = data.getStringExtra("address");
            buttonAddress.setText(address); }

    }


   // Activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    public void alertDialog(View view) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert Dialog")
                .setMessage("Are You Sure ?!")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel",null)
                .show();
    }

    // Optional Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // عايز ابدل ال Default menu بتاع ال Activity الي ال menu اللي انا عاملها جديد
        getMenuInflater().inflate(R.menu.optional_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // لما ادوس علي ال icon تنفذ اكشن
// لما ادوس عليها تنفذ اكشن
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item_notification) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


                                    // ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

       if (item.getItemId() == R.id.item_copy_text) {
        //    String text= textViewSignUp.getText().toString();
            ClipboardManager clipboardmanager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data=ClipData.newPlainText("TextView",textViewSignUp.getText().toString());
            clipboardmanager.setPrimaryClip(data);
            Toast.makeText(this, "Copy Text", Toast.LENGTH_SHORT).show();
       }
            return super.onContextItemSelected(item);
    }

}