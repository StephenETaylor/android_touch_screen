package edu.fitchburgstate.staylor.touch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    WorldView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (WorldView) findViewById(R.id.wv);
        b.setOnTouchListener(new View.OnTouchListener() {
            float oldX; // position at ACTION_DOWN
            float oldY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int t = motionEvent.getAction();
                if (t == MotionEvent.ACTION_DOWN) {
                    if (b.insideCircle(motionEvent.getX(), motionEvent.getY())) {
                        oldX = motionEvent.getX();
                        oldY = motionEvent.getY();
                        return true;
                    }

                }
                else if (t == MotionEvent.ACTION_UP) {
                    b.bx = motionEvent.getX();
                    b.by = motionEvent.getY();
                    b.invalidate();
                    return true;
                }
                else {
                    if (t == MotionEvent.ACTION_MOVE){
                        if (b.insideCircle(motionEvent.getX(),motionEvent.getY())){
                            oldX = b.bx = motionEvent.getX();
                            oldY = b.by = motionEvent.getY();
                            b.invalidate();
                            return true;
                        }
                    }
                }
                return false;
            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
