package com.Bean;

import com.component.TextUtils;
import com.constant.TypeConstant;
import com.service.ShareItem;
import com.service.ShareListener;

/**
 * Image
 */
public class Image extends ShareItem {
    String imagePath;

    public Image(String imagePath) {
        super(TypeConstant.TYPE_IMAGE);
        this.imagePath = !TextUtils.isEmpty(imagePath) ? imagePath : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
        System.out.println("Image");
    }
}