package mpip.finki.ukim.mk.lab_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final int PICK_IMAGE = 2;
    public static final int EXPLICIT_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choosePicture(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    public void sendContent(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TITLE, "MPiP Send");
        intent.putExtra(Intent.EXTRA_TEXT, "Content send from MPiP");
        intent.setType("message/rfc822");

        startActivity(intent);
    }

    public void implicitActivityStart(View view) {
        String CUSTOM_ACTION = "mpip.finki.ukim.mk.IMPLICIT_ACTION";
        Intent intent = new Intent();
        intent.setAction(CUSTOM_ACTION);

        startActivity(intent);
    }

    public void explicitActivityStart(View view) {
        Intent intent = new Intent(this, ExplicitActivity.class);
        startActivityForResult(intent, EXPLICIT_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EXPLICIT_ACTIVITY) {
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(data.getStringExtra("result"));
        } else {
           // todo: show the selected image
        }
    }
}
