package net.rainville.android.outstreamads;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Rainville (jrainville@brightcove.com) on 9/25/17.
 */

public class Article {
    private static Article sArticle;

    private List<ArticleItem> mArticleItems;

    public static Article get(Context context) {
        if (sArticle == null) {
            sArticle = new Article(context);
        }
        return sArticle;
    }

    private Article(Context context) {
        mArticleItems = new ArrayList<>();

        ArticleItemText article1 = new ArticleItemText(getString(R.string.text_item_1));

    }
}
