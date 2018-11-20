package com.pmdm.menucontextual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView starks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos lista de starks para el menú contextual
        starks=(ListView)findViewById(R.id.listaStarks);
        registerForContextMenu(starks);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.starks,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.matar:
                Toast.makeText(getApplicationContext(), "Hemos matado a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            case R.id.sanar:
                Toast.makeText(getApplicationContext(), "Hemos sanado a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            case R.id.enviarmensjae:
                Toast.makeText(getApplicationContext(), "Le hemos enviado un mensaje a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Le hemos hecho otra cosa a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
        }

    }
}
