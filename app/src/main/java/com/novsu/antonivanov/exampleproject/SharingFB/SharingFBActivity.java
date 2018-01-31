package com.novsu.antonivanov.exampleproject.SharingFB;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.novsu.antonivanov.exampleproject.R;

public class SharingFBActivity extends AppCompatActivity {

    private WebView mWebView;

    private static final String FACEBOOK_APP_ID = "1626631160912773"; //release
    private static final String FACEBOOK_RETURN_URL = "https://www.facebook.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_fb);

        mWebView = (WebView) findViewById(R.id.webview);

        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(getShareUrlFacebook());

    }

    private String getShareUrlFacebook() {

        String url = "https://m.facebook.com/dialog/feed?"
                + "app_id=" + FACEBOOK_APP_ID
                + "&name=" + "Title shared"
                + "&description=" + "This description /// "
                + "&link=" + getShareLink()
                + "&redirect_uri=" + FACEBOOK_RETURN_URL;

        return url;
    }

    private String getShareLink() {
        return "https://dl.dropboxusercontent.com/s/0h82tfu7dug0ob9/hellowWorld.html?dl=0";
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            /*if (url.contains("localhost/odnoklassniki")) {

                Toast.makeText(getActivity(), getString(R.string.string_success_sharing), Toast.LENGTH_SHORT).show();
                getActivity().finish();
            } else {
                view.loadUrl(url);
            }*/

            view.loadUrl(url);

            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }
    }
}
