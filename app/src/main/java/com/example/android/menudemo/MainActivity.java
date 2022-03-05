package com.example.android.menudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button contextMenuButton;
    Button popUpMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextMenuButton = findViewById(R.id.ContextMenuBtn);
        registerForContextMenu(contextMenuButton);
        popUpMenuButton = findViewById(R.id.PopUpMenuBtn);
    }//end onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_option_menu, menu);
        return true;
    }//end of onCreateOptionsMenu()

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aboutUsOptionItem:
                Toast.makeText(getApplicationContext(), "You pressed About Us", Toast.LENGTH_LONG).show();
                return true;

            case R.id.exitOptionItem:
                Toast.makeText(getApplicationContext(), "You pressed Exit", Toast.LENGTH_LONG).show();
                return true;

            default: return super.onOptionsItemSelected(item);

        }//end switch()
    }// end of onOptionsItemSelected()

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_context_menu, menu);
    }//end onCreateContextMenu()

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){

            case R.id.deleteContextItem:
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                return true;
            case R.id.shareContextItem:
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_LONG).show();
                return true;
            case R.id.archiveContextItem:
                Toast.makeText(getApplicationContext(), "Archived", Toast.LENGTH_LONG).show();
                return true;
            default: return super.onContextItemSelected(item);

        }//end switch
    }//end onContextItemSelected()



   
   

}//end class