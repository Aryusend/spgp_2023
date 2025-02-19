package kr.ac.tukorea.ge.sgp02.s12345678.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private int page;
    private ImageView mainImageView;
    private TextView pageTextView;
    private ImageButton prevButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImageView = findViewById(R.id.mainImageView);
        pageTextView = findViewById(R.id.pageTextView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        setPage(1);
    }

    public void onBtnPrev(View view) {
        Log.d(TAG, "Prev button clicked!!");
        setPage(page - 1);
    }

    public void onBtnNext(View view) {
        Log.d(TAG, "Next button clicked!!");
        setPage(page + 1);
    }

    private static final int[] IMG_RES_IDS = new int[] {
            R.mipmap.cat_1,
            R.mipmap.cat_2,
            R.mipmap.cat_3,
            R.mipmap.cat_4,
            R.mipmap.cat_5,
            R.mipmap.cat_6,
    };

    private void setPage(int page) {
        if (page < 1 || page > IMG_RES_IDS.length) return;

        int resId = IMG_RES_IDS[page - 1];
        mainImageView.setImageResource(resId);
        pageTextView.setText(page + " / " + IMG_RES_IDS.length);

        prevButton.setEnabled(page > 1);
        nextButton.setEnabled(page < IMG_RES_IDS.length);

        this.page = page;
    }
}