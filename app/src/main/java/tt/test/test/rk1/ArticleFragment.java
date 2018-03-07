package tt.test.test.rk1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();

        TextView content = getView().findViewById(R.id.article_content);
        TextView title = getView().findViewById(R.id.article_name);
        TextView date = getView().findViewById(R.id.article_date);
        content.setText(bundle.getString("content"));
        title.setText(bundle.getString("title"));
        date.setText(bundle.getString("date"));
    }
}
