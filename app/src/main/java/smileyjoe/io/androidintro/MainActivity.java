package smileyjoe.io.androidintro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_proceed).setOnClickListener(new OnProceedClick());
        mEditName = findViewById(R.id.edit_name);

        addTextView();
    }

    private void addTextView(){
        LinearLayout layoutMain = findViewById(R.id.layout_main);

        TextView textLast = new TextView(getBaseContext());
        textLast.setText(R.string.text_last);

        layoutMain.addView(textLast);
    }

    private class OnProceedClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Log.d("IntroLogs", "Proceed Clicked");

            String name = mEditName.getText().toString().trim();

            if(!TextUtils.isEmpty(name)) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_NAME, name);
                startActivity(intent);
            } else {
                Log.e("IntroLogs", "Name empty");
            }
        }
    }
}
