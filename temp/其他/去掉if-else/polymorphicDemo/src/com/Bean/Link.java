package com.Bean;

import com.component.TextUtils;
import com.constant.TypeConstant;
import com.service.ShareItem;
import com.service.ShareListener;

/**
 * Link
 */
public class Link extends ShareItem {
    String title;
    String content;
    String link;

    public Link(String link, String title, String content) {
        super(TypeConstant.TYPE_LINK);
        this.link = !TextUtils.isEmpty(link) ? link : "default";
        this.title = !TextUtils.isEmpty(title) ? title : "default";
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
        System.out.println("Link");
    }
}
