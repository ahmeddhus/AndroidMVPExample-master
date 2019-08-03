package com.ahmedelsayed.androidmvpexample;

public interface GetQuoteInteractor
{
    interface OnFinishedListener
    {
        void  onFinished(String string);
    }

    void getNextQuote(OnFinishedListener listener);
}
