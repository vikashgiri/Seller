package gem.in.seller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
      /*  1) Buyer User ID :- rajmisri.rdd
        Password :- Gem@2019
        2) Seller User ID :-  seller0001
        Password :- India@123*/
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this, WebViewActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
