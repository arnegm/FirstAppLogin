package mobile.com.firstapplogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {


    ListView lv;
    DatabaseManager dbManager;
    ListViewAdapter lvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<Cars> ArrayListCars = new ArrayList<Cars>();

        dbManager = new DatabaseManager(ListViewActivity.this);



       /* dbManager.AddCar("aston martin", "ASX", "Martin", "DB9");
        dbManager.AddCar("Audi", "ADX", "AUDI", "A4");
        dbManager.AddCar("BMW", "BMX", "BMW", "228i xDrive Convertible");
        dbManager.AddCar("Honda", "HNX", "HONDA", "FIT LX");
       */
        dbManager.getAllCars();
        lv = (ListView) findViewById(R.id.listView);

        lvAdapter = new ListViewAdapter(this, ArrayListCars);
        lv.setAdapter(lvAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }

}
