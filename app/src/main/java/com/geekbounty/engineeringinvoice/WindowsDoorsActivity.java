package com.geekbounty.engineeringinvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.geekbounty.engineeringinvoice.dialog.TitleDialog;

public class WindowsDoorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_doors);
        getSupportActionBar().setTitle("Windows and doors");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle item selection
        switch (item.getItemId()){
            case R.id.result:
                //Show dialog
                Toast.makeText(getApplicationContext(), "Result", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add_title:
                showDialog();
                return true;
            case R.id.generate_invoice:
                Toast.makeText(getApplicationContext(), "Generate Invoice", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showDialog(){
        TitleDialog electricalDialog = new TitleDialog();
        electricalDialog.show(getSupportFragmentManager(), "Windows and Doors Dialog");
    }
}
