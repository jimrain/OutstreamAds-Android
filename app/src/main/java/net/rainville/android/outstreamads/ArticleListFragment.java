package net.rainville.android.outstreamads;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

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

}
