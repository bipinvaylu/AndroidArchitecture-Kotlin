package bipin.com.android.arch.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * Created by Bipin Vayalu on 26/07/18.
 */


class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    fun loadImage(view: ImageView, url: String) {
        // Load image using your favorite image loading library
    }


}
