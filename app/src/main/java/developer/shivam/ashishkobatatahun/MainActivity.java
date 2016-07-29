package developer.shivam.ashishkobatatahun;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int FOCUSED_CHILD_HEIGHT;
    int DEFAULT_CHILD_HEIGHT;
    ScrollView scrollViewChanel;
    int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int deviceHeight = getWindowManager().getDefaultDisplay().getHeight();
        FOCUSED_CHILD_HEIGHT = (60 * deviceHeight)/100;
        DEFAULT_CHILD_HEIGHT = deviceHeight/6;

        colors = new int[5];

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            colors[i] = 100000 + random.nextInt(900000);
            Log.d("Color:", String.valueOf(colors[i]));
        }

        scrollViewChanel = (ScrollView) findViewById(R.id.svChanel);
        addViewToScrollView();
    }

    private void addViewToScrollView() {
        LinearLayout mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < 5; i++) {

            if (i == 0) {
                LinearLayout childLayout = new LinearLayout(this);
                childLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        FOCUSED_CHILD_HEIGHT));
                childLayout.setBackgroundColor(Color.parseColor(String.valueOf("#"+colors[i])));
                mainContainer.addView(childLayout);
            } else {
                LinearLayout childLayout = new LinearLayout(this);
                childLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        DEFAULT_CHILD_HEIGHT));
                childLayout.setBackgroundColor(Color.parseColor(String.valueOf("#"+colors[i])));
                mainContainer.addView(childLayout);
            }
        }

        scrollViewChanel.addView(mainContainer);
    }
}
