package smileyjoe.io.androidintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("IntroLogs", "Second screen loading");
        Log.i("IntroLogs", "OnCreate");

        setContentView(R.layout.activity_second);
        handleExtras();
    }

    private void handleExtras(){
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if(extras.containsKey(EXTRA_NAME)){
                String name = extras.getString(EXTRA_NAME);
                TextView textName = findViewById(R.id.text_name);
                textName.setText(name);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("IntroLogs", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("IntroLogs", "OnPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("IntroLogs", "OnDestroy");
    }
}
