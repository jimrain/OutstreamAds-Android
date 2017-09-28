package net.rainville.android.outstreamads;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by jim on 9/24/17.
 */

public class ArticleListFragment extends Fragment {

    private RecyclerView mArticleRecyclerView;
    private ArticleAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        mArticleRecyclerView = (RecyclerView) view.findViewById(R.id.article_recycler_view);
        mArticleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        Article article = Article.get(getActivity());
        List<ArticleItem> articleItems = article.getArticleItems();

        mAdapter = new ArticleAdapter(articleItems);
        mArticleRecyclerView.setAdapter(mAdapter);
    }

    private abstract class AbstractArticleItemHolder extends RecyclerView.ViewHolder {
        private ArticleItem mArticleItem;

        public AbstractArticleItemHolder(LayoutInflater inflater, ViewGroup parent, int layoutId) {
            super(inflater.inflate(layoutId, parent, false));
        }

        public void bind(ArticleItem articleItem ) {
            mArticleItem = articleItem;
        }

        public ArticleItem getArticleItem() {
            return mArticleItem;
        }
    }

    private class TextArticleHolder extends AbstractArticleItemHolder {
        public TextArticleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.ariticle_item_text);
        }
    }

    private class VideoArticleHolder extends AbstractArticleItemHolder {
        public VideoArticleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.article_item_video);
        }
    }

    private class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int ARTICLE_ITEM_TEXT = 0;
        private static final int ARTICLE_ITEM_VIDEO = 1;

        private List<ArticleItem> mArticleItems;

        public ArticleAdapter(List<ArticleItem> articleItems) {
            mArticleItems = articleItems;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            if (viewType == ARTICLE_ITEM_TEXT) {
                return new TextArticleHolder(layoutInflater, parent);
            } else if (viewType == ARTICLE_ITEM_VIDEO) {
                return new VideoArticleHolder(layoutInflater, parent);
            } else {
                return null;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ArticleItem articleItem = mArticleItems.get(position);

            if (articleItem.getArticleType() == ArticleItem.ARTICLE_TYPE.TEXT) {
                ((TextArticleHolder)holder).bind(articleItem);
            } else if (articleItem.getArticleType() == ArticleItem.ARTICLE_TYPE.VIDEO) {
                ((VideoArticleHolder)holder).bind(articleItem);
            }
        }

        @Override
        public int getItemCount() {
            return mArticleItems.size();
        }

        @Override
        public int getItemViewType(int position) {
            ArticleItem.ARTICLE_TYPE aType = mArticleItems.get(position).getArticleType();

            if (aType == ArticleItem.ARTICLE_TYPE.VIDEO) {
                return ARTICLE_ITEM_VIDEO;
            } else {
                return ARTICLE_ITEM_TEXT;
            }
        }
    }


}
