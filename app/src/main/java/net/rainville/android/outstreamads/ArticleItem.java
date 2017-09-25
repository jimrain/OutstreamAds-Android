package net.rainville.android.outstreamads;

import java.util.UUID;

/**
 * Created by Jim Rainville (jrainville@brightcove.com) on 9/24/17.
 */

public interface ArticleItem {

    public static enum ARTICLE_TYPE {
        TEXT,
        VIDEO
    }

    public Object getContent();

    public UUID getArticleId();

    public ARTICLE_TYPE getArticleType();

}
