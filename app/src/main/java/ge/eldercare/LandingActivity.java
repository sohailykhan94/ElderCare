package ge.eldercare;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void launchSignup(View v){
        Intent myIntent = new Intent(LandingActivity.this, LoginActivity.class);
        LandingActivity.this.startActivity(myIntent);
    }

    public void launchLogin(View v){
        Intent myIntent = new Intent(LandingActivity.this, LoginMainActivity.class);
        LandingActivity.this.startActivity(myIntent);
    }

}
