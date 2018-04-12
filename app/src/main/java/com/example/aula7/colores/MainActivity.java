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

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    int seekA,seekR, seekG, seekB,valorR,ValorG,ValorB,ValorA;
   SeekBar seekBarRed,seekBarGreen, seekBarBlue ,seekBarAlpha;
   View viewbackgroud;
   TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.id_sib_red);
        seekBarGreen = (SeekBar) findViewById(R.id.id_sib_green);
        seekBarBlue = (SeekBar) findViewById(R.id.id_sib_blue);
        seekBarAlpha = (SeekBar) findViewById(R.id.id_sib_alpha);

        viewbackgroud=(View) findViewById(R.id.id_v_backgound);

        textView1= (TextView) findViewById(R.id.id_valor);
        textView2 = (TextView) findViewById(R.id.id_valor2);
        textView3 = (TextView) findViewById(R.id.id_valor3);
        textView4 = (TextView) findViewById(R.id.id_valor4);




       // registerForContextMenu(textViewName);
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateBackground();
        valorR=seekBarRed.getProgress();
        textView1.setText(String.valueOf(valorR));
        ValorG=seekBarGreen.getProgress();
        textView2.setText(String.valueOf(ValorG));
        ValorB=seekBarBlue.getProgress();
        textView3.setText(String.valueOf(ValorB));
        ValorA=seekBarAlpha.getProgress();
        textView4.setText(String.valueOf(ValorA));



    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}


