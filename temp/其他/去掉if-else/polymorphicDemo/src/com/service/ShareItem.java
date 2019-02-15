package com.service;

/**
 * ShareItem
 */
public abstract class ShareItem {
   int type;

   public ShareItem(int type) {
       this.type = type;
   }

   public abstract void doShare(ShareListener listener);
}