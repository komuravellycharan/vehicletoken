package com.cmrit.parkingtick;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.cmrit.parkingtick.parkingdetails.tableschema;
public class Entry extends AppCompatActivity {

    private static final String TAG = "jdfls;";
    public Spinner sp;
    Button entry_bt;
    EditText vehicle_no;
    String spacetaken;
    private SQLiteDatabase database;
    private database databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        sp=(Spinner)findViewById(R.id.spin);
        entry_bt=(Button)findViewById(R.id.entry_btn);
        vehicle_no=(EditText)findViewById(R.id.vehicle_no);
        databaseHelper = new database(Entry.this);
        database = databaseHelper.getWritableDatabase();
        entry_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String type,vhn;

               // type=String.valueOf(sp.getSelectedItem());
                type="car";
                vhn=vehicle_no.getText().toString();
                if (type.equals("car"))
                    spacetaken="1";
                else
                    spacetaken="2";
                onEnter(vhn,type,spacetaken);

            }
        });
    }

    public void onEnter(String vhn,String type,String spacetaken){
        // need to complete function
        ContentValues contentValues = new ContentValues();
        contentValues.put(tableschema._ID, vhn);
        contentValues.put(tableschema.IN_TIME ,"chaaran");
        contentValues.put(tableschema.VEHICLE_TYPE, type);
        contentValues.put(tableschema.SPACE_TAKEN, spacetaken);

        long rowId = database.insert(tableschema.TABLE_NAME,null, contentValues);
       // Toast toast=Toast.makeText(getApplicationContext(), (int) rowId,Toast.LENGTH_LONG);
       // toast.show();
        Log.i(TAG,"number "+rowId);
    }
}
