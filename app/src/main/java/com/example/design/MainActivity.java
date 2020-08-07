package com.example.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout linearLayout;
    int dot_count;
    ImageView[] dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
linearLayout=findViewById( R.id.linearlayout );
viewPager=findViewById( R.id.viewpager );
ViewPagerAdapte viewPagerAdapte=new ViewPagerAdapte( this );
viewPager.setAdapter( viewPagerAdapte );
dot_count=viewPagerAdapte.getCount();
dot=new ImageView[dot_count];
for(int i=0;i<dot_count;i++)
{
    dot[i]=new ImageView( this );
    dot[i].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.off_dot ) );
    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    params.setMargins( 8,0,8,0 );
    linearLayout.addView( dot[i],params );
}
dot[0].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.on_dot) );
        Timer timer=new Timer(  );
        timer.scheduleAtFixedRate( new TimerTask1(),2000,4000 );
viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
for(int i=0;i<dot_count;i++)
{
    dot[i].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.off_dot ) );
}
        dot[position].setImageDrawable( ContextCompat.getDrawable( getApplicationContext(),R.drawable.on_dot ) );
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
} );
}

    public class TimerTask1 extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread( new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem( 1 );
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem( 2 );
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem( 3 );
                    } else {
                        viewPager.setCurrentItem( 0 );
                    }

                }
            } );

        }
    }

}
