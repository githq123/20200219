package com.example.admin.touch;

import android.gesture.GestureOverlayView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView iv;
//Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        //iv.setOnTouchListener(new MyGesture());
        //btn=findViewById(R.id.btn);
       // btn.setOnTouchListener(new MyOnTouch());
        findViewById(R.id.root).setOnTouchListener(new View.OnTouchListener() {
            float currentDistance;
            float lastDistance=-1;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("DOWN");
                        break;
                     case MotionEvent.ACTION_UP:
                            System.out.println("UP");
                            break;
                      case MotionEvent.ACTION_MOVE:

                          if(event.getPointerCount()>=2){
                              float offsetX=event.getX(0)-event.getX(1);
                              float offsetY=event.getY(0)-event.getY(1);
                              currentDistance= (float) Math.sqrt(offsetX*offsetX+offsetY*offsetY);
                              if(lastDistance<0){
                                  lastDistance=currentDistance;
                              }else {
                                  if (currentDistance-lastDistance>5){
                                      System.out.println("放大");
                                      FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams) iv.getLayoutParams();
                                      lp.width= (int) (1.1f*iv.getWidth());
                                      lp.height= (int) (1.1f*iv.getHeight());
                                      iv.setLayoutParams(lp);
                                      lastDistance=currentDistance;
                                  }else if (lastDistance-currentDistance>5){
                                      System.out.println("缩小");
                                      FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams) iv.getLayoutParams();
                                      lp.width= (int) (0.9f*iv.getWidth());
                                      lp.height= (int) (0.9f*iv.getHeight());
                                      iv.setLayoutParams(lp);
                                      lastDistance=currentDistance;
                                  }
                              }
                          }

                          /*System.out.println("MOVE");
                                System.out.println("x="+event.getX()+",y="+event.getY());
                                System.out.println("rawx="+event.getRawX()+",rawy="+event.getRawY());
                                FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams) iv.getLayoutParams();
                                lp.leftMargin= (int) event.getX();
                                lp.topMargin= (int) event.getY();
                                iv.setLayoutParams(lp);*/

                                break;
                }
                return true;
            }
        });
    }
     /*private class MyGesture implements View.OnTouchListener,GestureDetector.OnGestureListener{
GestureDetector myGesture
         @Override
         public boolean onDown(MotionEvent e) {
             return false;
         }

         @Override
         public void onShowPress(MotionEvent e) {

         }

         @Override
         public boolean onSingleTapUp(MotionEvent e) {
             return false;
         }

         @Override
         public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
             return false;
         }

         @Override
         public void onLongPress(MotionEvent e) {

         }

         @Override
         public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
             return false;
         }

         @Override
         public boolean onTouch(View v, MotionEvent event) {
             return false;
         }
     }
   private class MyOnTouch implements View.OnTouchListener {
        int[] temp=new int[]{0,0};
        Boolean ismove=false;
        int downX=0;
        int downY=0;


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int x= (int) event.getRawX();
            int y= (int) event.getRawY();
            temp[0]=;
            temp[1];
            return false;
        }
    }*/
}
