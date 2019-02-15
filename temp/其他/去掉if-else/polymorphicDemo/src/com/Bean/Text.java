package com.Bean;

import com.component.TextUtils;
import com.constant.TypeConstant;
import com.service.ShareItem;
import com.service.ShareListener;

/**
 * Text
 */
public class Text extends ShareItem {
    String content;

    public Text(String content) {
        super(TypeConstant.TYPE_TEXT);
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
        System.out.println("Text");
    }
}
