package com.pomelo.myproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.pomelo.myproject.R;
import com.pomelo.myproject.view.APIWebviewTBS;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    String loadurl = "http://mp.weixin.qq.com/s?__biz=MzIwODAyODE4NQ==&mid=512728181&idx=5&sn=7f95ecc5f593041fa0cbfb58ae210648&chksm=0c726b033b05e215a01cafe1c3b10942a4c7b72717376e09a121651d318f9b44cc0ea1812113#rd";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        APIWebviewTBS.getAPIWebview().initTBSActivity(this);
        loadWebViewUrl(loadurl);
    }

    private void loadWebViewUrl(String url) {
        webView = (WebView) findViewById(R.id.webview_wechat);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView var1, int var2, String var3, String var4) {
                //progressBar.setVisibility(View.GONE);
                //ToastUtil.show("网页加载失败");
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
