package com;

import com.Bean.Link;
import com.service.ShareItem;
import com.service.ShareListener;

/**
 * Main
 */
public class Main {

	public void share(ShareItem item, ShareListener listener) {
		if (item == null) {
			if (listener != null) {
				listener.onCallback(ShareListener.STATE_FAIL, "ShareItem ����Ϊ null");
			}
			return;
		}

		if (listener == null) {
			listener = new ShareListener() {
				@Override
				public void onCallback(int state, String msg) {
					System.out.println("DEBUGShareListener is null");
				}
			};
		}

		shareImpl(item, listener);
	}

	private void shareImpl(ShareItem item, ShareListener listener) {
		item.doShare(listener);
	}

	public static void main(String[] args) {
		new Main().share(new Link("", "", ""), null);
	}

}
