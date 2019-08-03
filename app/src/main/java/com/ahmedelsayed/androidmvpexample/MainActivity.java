package com.ahmedelsayed.androidmvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView
{
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    void init()
    {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());
    }

    @Override
    public void showProgress()
    {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress()
    {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string)
    {
        textView.setText(string);
    }

    public void btnAction(View view)
    {
        presenter.onButtonClick();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.onDestroy();
    }
}
