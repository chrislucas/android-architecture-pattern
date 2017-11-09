package lab.xplore.livedatatwitterapi.models;

import android.graphics.Bitmap;

/**
 * Created by r028367 on 09/11/2017.
 */

public class Twiitt {

    private String text, urlImage;
    private Bitmap image;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
