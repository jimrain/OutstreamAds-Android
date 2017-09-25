package net.rainville.android.outstreamads;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.UUID;

import static net.rainville.android.outstreamads.ArticleItem.ARTICLE_TYPE.TEXT;

/**
 * Created by Jim Rainville (jrainville@brightcove.com) on 9/24/17.
 */

public class ArticleItemText implements ArticleItem {
    private UUID mId;
    private ARTICLE_TYPE mType;
    private String mArticleText;

    public ArticleItemText(String articleText) {
        mType = ARTICLE_TYPE.TEXT;
        mId = UUID.randomUUID();
        mArticleText = articleText;
    }

    public Object getContent() {
        return (Object)mArticleText;
    }

    public UUID getArticleId() {
        return mId;
    }

    public ARTICLE_TYPE getArticleType() {
        return mType;
    }

}
