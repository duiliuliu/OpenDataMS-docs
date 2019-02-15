package com;

/**
 * ExtMain
 */
public class ExtMain {

    public ShareItem createLinkShareItem(String link, String title, String content) {
        return new Link(link, title, content);
    }

    public ShareItem createImageShareItem(String ImagePath) {
        return new Image(ImagePath);
    }

    public ShareItem createTextShareItem(String content) {
        return new Text(content);
    }

    public ShareItem createImageTextShareItem(String ImagePath, String content) {
        return new ImageText(ImagePath, content);
    }

}

/**
 * ExtMain_1
 */
class ExtMain_1 {

    private Map<Integer, Class<? extends ShareItem>> map = new HashMap<>();

    private void init() {
        map.put(TYPE_LINK, Link.class);
        map.put(TYPE_IMAGE, Image.class);
        map.put(TYPE_TEXT, Text.class);
        map.put(TYPE_IMAGE_TEXT, ImageText.class);
    }

    public ShareItem createShareItem(int type) {
        try {
            Class<? extends ShareItem> shareItemClass = map.get(type);
            return shareItemClass.newInstance();
        } catch (Exception e) {
            return new DefaultShareItem(); // 返回默认实现，不要返回null
        }
    }

}