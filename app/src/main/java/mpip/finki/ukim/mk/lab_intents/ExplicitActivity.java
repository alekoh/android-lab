package mpip.finki.ukim.mk.lab_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExplicitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
    }

    public void submit(View view) {
        Intent intent = new Intent();

        EditText message = (EditText) findViewById(R.id.message);
        String textMessage = String.valueOf(message.getText());
        intent.putExtra("result", textMessage);
        setResult(1, intent);

        finish();
    }

    public void cancel(View view) {
        finish();
    }
}
