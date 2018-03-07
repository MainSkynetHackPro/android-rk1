package tt.test.test.rk1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        final ArticleListFragment articleList = new ArticleListFragment();


        transaction.replace(R.id.list_container, articleList);
        transaction.commit();

        articleList.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                final FragmentManager fragmentManager1 = getSupportFragmentManager();
                final FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
                Bundle b = new Bundle();
                b.putString("title", article.getTitle());
                b.putString("content", article.getContent());
                b.putString("date", article.getDate().toString());

                ArticleFragment articleFragment = new ArticleFragment();

                articleFragment.setArguments(b);

                transaction1.replace(R.id.list_container, articleFragment).addToBackStack(null);

                transaction1.commit();
            }
        });
    }

}
