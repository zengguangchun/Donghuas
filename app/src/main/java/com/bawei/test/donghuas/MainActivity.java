package com.bawei.test.donghuas;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView textview = (ImageView)findViewById(R.id.tv);
        final Button button = (Button)findViewById(R.id.but);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //平移
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview, "translationX", 0f, 300f);
               //旋转
                ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
               // 渐变
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
                //创建AnimatorSet对象
                AnimatorSet animSet =  new AnimatorSet();

//                after(Animator anim)   将现有动画插入到传入的动画之后执行
//                after(long delay)   将现有动画延迟指定毫秒后执行
//                before(Animator anim)   将现有动画插入到传入的动画之前执行
//                with(Animator anim)   将现有动画和传入的动画同时执行

                animSet.play(rotate).with(fadeInOut).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
                //监听动画的各种事件
                animSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {//在动画开始的时候调用
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {//在动画重复执行的时候调用
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {//在动画结束的时候调用
                        Toast.makeText(MainActivity.this,"动画结束。。。",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {//在动画被取消的时候调用
                    }
                });
            }
        });


    }
}
