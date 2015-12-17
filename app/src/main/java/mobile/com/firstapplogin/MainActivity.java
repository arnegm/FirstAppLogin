package mobile.com.firstapplogin;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // dbManager = new DatabaseManager(MainActivity.this);
       /*
        dbManager.AddCar("aston martin", "ASX", "Martin", "DB9");
        dbManager.AddCar("Audi","ADX","AUDI","A4");
        dbManager.AddCar("BMW","BMX","BMW","228i xDrive Convertible");
        dbManager.AddCar("Honda","HNX","HONDA","FIT LX");
        */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View v) {

        EditText et1 = (EditText) findViewById(R.id.editText);
        EditText et2 = (EditText) findViewById(R.id.editText2);
        String username = et1.getText().toString();
        String password = et2.getText().toString();
        if (username.equals("reda") && password.equals("123")) {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);


        } else {
            Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
        }
    }


}



