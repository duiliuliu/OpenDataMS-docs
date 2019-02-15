package com.Bean;

import com.component.TextUtils;
import com.constant.TypeConstant;
import com.service.ShareItem;
import com.service.ShareListener;

/**
 * ImageText
 */
public class ImageText extends ShareItem {
    String content;
    String imagePath;

    public ImageText(String imagePath, String content) {
        super(TypeConstant.TYPE_IMAGE_TEXT);
        this.imagePath = !TextUtils.isEmpty(imagePath) ? imagePath : "default";
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
        System.out.println("IagmeText");
    }
}
