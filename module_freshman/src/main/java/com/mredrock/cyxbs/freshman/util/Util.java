package com.mredrock.cyxbs.freshman.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class Util {
    @BindingAdapter(value = { "imageUrl", "error" }, requireAll = false)
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
