package test.com.mvpraces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import test.com.mvpraces.model.Race;
import test.com.mvpraces.ui.presenter.IMainPresenter;
import test.com.mvpraces.ui.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private IMainPresenter presenter;
    private ProgressBar progressBar;
    private TextView txtExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtExample = (TextView) findViewById(R.id.txtExample);
        presenter.start();

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRaceInfo(List<Race> raceList) {
        Log.d("RaceList", "-->" + String.valueOf(raceList.size()));
        txtExample.setText(raceList.get(0).getName());
    }
}
