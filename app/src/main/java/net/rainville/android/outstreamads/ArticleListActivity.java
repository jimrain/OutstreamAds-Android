package net.rainville.android.outstreamads;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ArticleListFragment();
    }
}
