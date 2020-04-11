package com.kt.std.quizeg1.listeners;

public interface WebListener {
    public void onStart();
    public void onLoaded();
    public void onProgress(int progress);
    public void onNetworkError();
    public void onPageTitle(String title);
}
