package mpip.finki.ukim.mk.lab_intents;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class ImplicitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
    }

    public void showActivities(View view) {
        Intent localIntent1 = new Intent("android.intent.action.PICK_ACTIVITY");
        Intent localIntent2 = new Intent("android.intent.action.MAIN", null);
        localIntent2.addCategory("android.intent.category.LAUNCHER");
        localIntent1.putExtra("android.intent.extra.INTENT", localIntent2);
        startActivityForResult(localIntent1, 100);
    }
}
