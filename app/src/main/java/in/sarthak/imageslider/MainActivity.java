package in.sarthak.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSlideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews ();
        setupListener ();
    }
    private void initViews () {
        btnSlideShow = findViewById(R.id.btnSlideShow);

    }
    private void setupListener (){
        btnSlideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagesliderDialog imagesliderDialog = new ImagesliderDialog(MainActivity.this);
                imagesliderDialog.show();

            }
        });
    }

}