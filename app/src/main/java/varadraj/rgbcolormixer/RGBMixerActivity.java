package varadraj.rgbcolormixer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RGBMixerActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    SurfaceView sv_color;
    TextView hexRed,hexGreen,hexBlue,valueRed,valueGreen,valueBlue,percentRed,percentGreen,percentBlue;
    SeekBar seekBarRed,seekBarGreen,seekBarBlue;
    Button iRed,dRed,iGreen,dGreen,iBlue,dBlue;
    static int red = 255, green = 255, blue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgbmixer_linearlayout);
        initViews();
        initListener();
        sv_color.setBackgroundColor(Color.rgb(red,green,blue));
    }

    void initViews(){
        //SurfaceView
        sv_color = (SurfaceView)findViewById(R.id.sv_color);
        //TextView
        hexRed = (TextView)findViewById(R.id.tv_hexRed);
        hexGreen = (TextView)findViewById(R.id.tv_hexGreen);
        hexBlue = (TextView)findViewById(R.id.tv_hexBlue);
        valueRed = (TextView)findViewById(R.id.valueRed);
        valueGreen = (TextView)findViewById(R.id.valueGreen);
        valueBlue = (TextView)findViewById(R.id.valueBlue);
        percentRed =  (TextView)findViewById(R.id.tv_percentRed);
        percentGreen = (TextView)findViewById(R.id.tv_percentGreen);
        percentBlue = (TextView)findViewById(R.id.tv_percentBlue);
        //SeekBar
        seekBarRed = (SeekBar)findViewById(R.id.sb_Red);
        seekBarGreen = (SeekBar)findViewById(R.id.sb_Green);
        seekBarBlue = (SeekBar)findViewById(R.id.sb_Blue);
        //Button
        iRed = (Button)findViewById(R.id.bt_increase_red);
        dRed = (Button)findViewById(R.id.bt_decrease_red);
        iGreen = (Button)findViewById(R.id.bt_increase_green);
        dGreen = (Button)findViewById(R.id.bt_decrease_green);
        iBlue = (Button)findViewById(R.id.bt_increase_blue);
        dBlue =  (Button)findViewById(R.id.bt_decrease_blue);
    }

    void initListener(){
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);

        iRed.setOnClickListener(this);
        dRed.setOnClickListener(this);
        iGreen.setOnClickListener(this);
        dGreen.setOnClickListener(this);
        iBlue.setOnClickListener(this);
        dBlue.setOnClickListener(this);


    }

    public String int2hex(int x){
        String c=Integer.toHexString(x);
        return c.toUpperCase();
    }

    public String int2percent(int x){
        float p=(float)(x/2.55);
        DecimalFormat df=new DecimalFormat("###.##");
        return df.format(p)+"%";
    }

    void changeRed(){
        sv_color.setBackgroundColor(Color.rgb(red,green,blue));
        hexRed.setText(int2hex(red));
        valueRed.setText(Integer.toString(red));
        percentRed.setText(int2percent(red));
    }

    void changeGreen(){
        sv_color.setBackgroundColor(Color.rgb(red,green,blue));
        hexGreen.setText(int2hex(green));
        valueGreen.setText(Integer.toString(green));
        percentGreen.setText(int2percent(green));
    }

    void changeBlue(){
        sv_color.setBackgroundColor(Color.rgb(red,green,blue));
        hexBlue.setText(int2hex(blue));
        valueBlue.setText(Integer.toString(blue));
        percentBlue.setText(int2percent(blue));
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch(seekBar.getId()){
            case R.id.sb_Red:
                Log.d("SeekBar Red ",String.valueOf(progress));
                red = progress;
                changeRed();
                break;
            case R.id.sb_Green:
                Log.d("SeekBar Green ",String.valueOf(progress));
                green = progress;
                changeGreen();
                break;
            case R.id.sb_Blue:
                Log.d("SeekBar Blue ",String.valueOf(progress));
                blue = progress;
                changeBlue();
                break;
            default:
                break;
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    //nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    //nothing
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_increase_red:
                if(red < 255) {
                    red++;
                    changeRed();
                    seekBarRed.setProgress(red);
                }
                break;
            case R.id.bt_decrease_red:
                if(red > 0) {
                    red--;
                    changeRed();
                    seekBarRed.setProgress(red);
                }
                break;
            case R.id.bt_increase_green:
                if(green < 255) {
                    green++;
                    changeGreen();
                    seekBarGreen.setProgress(green);
                }
                break;
            case R.id.bt_decrease_green:
                if(green > 0) {
                    green--;
                    changeGreen();
                    seekBarGreen.setProgress(green);
                }
                break;
            case R.id.bt_increase_blue:
                if(blue < 255) {
                    blue++;
                    changeBlue();
                    seekBarBlue.setProgress(blue);
                }
                break;
            case R.id.bt_decrease_blue:
                if(blue > 0) {
                    blue--;
                    changeBlue();
                    seekBarBlue.setProgress(blue);
                }
                break;
            default:
                break;
        }

    }
}
