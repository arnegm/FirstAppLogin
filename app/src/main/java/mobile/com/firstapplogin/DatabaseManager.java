package mobile.com.firstapplogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 12/17/2015.
 */
public class DatabaseManager extends SQLiteOpenHelper {


    public DatabaseManager(Context context) {
        super(context, "CarsDatabase", null, 1);
        Log.d("Database","Database created Successfully.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table carsDatabase(ID integer primary key autoincrement,VehicleManufacturerName text,VehMfrCode text,RepresentedTestVehMake text,RepresentedTestVehModel text)";

        try {
            db.execSQL(sql);
            Log.d("Table1","Table created successfully");
        } catch (Exception e) {

            Log.d("Table1","Table creating failed!");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddCar( String VehicleManufacturerName, String VehMfrCode, String RepresentedTestVehMake, String RepresentedTestVehModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("VehicleManufacturerName", VehicleManufacturerName);
        contentValues.put("VehMfrCode", VehMfrCode);
        contentValues.put("RepresentedTestVehMake", RepresentedTestVehMake);
        contentValues.put("RepresentedTestVehModel", RepresentedTestVehModel);
        long row =db.insert("carsDatabase", null, contentValues);
        Log.d("Cars", "row" + row + "inserted");
        db.close();


    }

    public ArrayList<Cars> getAllCars() {
        ArrayList<Cars> listCars = new ArrayList<Cars>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("carsDatabase", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Cars cars = new Cars();
            int ID = cursor.getInt(0);
            String VehicleManufacturerName = cursor.getString(1);
            String VehMfrCode = cursor.getString(2);
            String RepresentedTestVehMake = cursor.getString(3);
            String RepresentedTestVehModel = cursor.getString(4);
            cars.ID = ID;
            cars.VehicleManufacturerName = VehicleManufacturerName;
            cars.VehMfrCode = VehMfrCode;
            cars.RepresentedTestVehMake = RepresentedTestVehMake;
            cars.RepresentedTestVehModel = RepresentedTestVehModel;
            Log.d("Retrieved","row:" + ID + "," + VehicleManufacturerName+VehMfrCode+RepresentedTestVehMake+RepresentedTestVehModel);
            listCars.add(cars);


        }
        cursor.close();
        db.close();
        return listCars;

    }


}
