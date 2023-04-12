package in.sarthak.imageslider;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class ImagesliderDialog extends Dialog {

    private int [] imageArr = new int[5];

    private ImageView imgSlider,imgCancle;

    public ImagesliderDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.image_slider_dialog);



       initViews();
       init();
       setOnClick();

       new TimeThread().execute();
    }
    private void initViews () {

        imgSlider = findViewById(R.id.imgSlider);
        imgCancle = findViewById(R.id.imgCancle);


    }
    private void init () {
        imageArr[0] = R.drawable.floppydisk;
        imageArr[1] = R.drawable.graduation;
        imageArr[2] = R.drawable.smartphone;
        imageArr[3] = R.drawable.pendrive;
        imageArr[4] = R.drawable.graduation1;

    }

    private void setOnClick (){
        imgCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();

            }
        });
    }

    private class TimeThread extends AsyncTask<Integer,Integer,Integer> {

        int [] temp = new int[1];

        @Override
        protected Integer doInBackground(Integer... integers) {

            for (int i = 0; i < imageArr.length; i++) {
                try {
                    Thread.sleep(1000);
                    temp[0] = i;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                publishProgress(i);

                if (i == imageArr.length - 1) {
                    i = 0;
                }

            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgSlider.setImageResource(imageArr[values[0]]);
        }

    }

}
