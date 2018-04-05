package com.example.aula7.colores;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int seekA,seekR, seekG, seekB;
   SeekBar seekBarRed,seekBarGreen, seekBarBlue ,seekBarAlpha;
   View viewbackgroud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.id_sib_red);
        seekBarGreen = (SeekBar) findViewById(R.id.id_sib_green);
        seekBarBlue = (SeekBar) findViewById(R.id.id_sib_blue);
        seekBarAlpha = (SeekBar) findViewById(R.id.id_sib_alpha);

        viewbackgroud=(View) findViewById(R.id.id_v_backgound);




       // registerForContextMenu(textViewName);

}
    public void updateBackground() {
        seekR = seekBarRed.getProgress();
        seekG=seekBarGreen.getProgress();
        seekB = seekBarBlue.getProgress();
        seekA = seekBarAlpha.getProgress();
        int color = Color.argb(seekA, seekR, seekG, seekB);
        viewbackgroud.setBackgroundColor(color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuinicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_item_menu_1:
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.id_item_menu_2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuinicio, menu);
    }
}


