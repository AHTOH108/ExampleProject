package com.novsu.antonivanov.exampleproject.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.novsu.antonivanov.exampleproject.R;

import java.net.URL;

public class WebViewActivity extends AppCompatActivity {

    public static final String SERVER_URL_DEV = "http://access.inrecolan.com:5555"; // VLADIMIR

    private String html = "<p><a title=\\\"ТЛУМ!\\\" href=\\\"http://tlum.ru\\\" target=\\\"_blank\\\">Ссылка на Тлум</a></p> <p>Ниже опрос:</p> <p><!— TlumVote start —> <link rel=\\\"stylesheet\\\" href=\\\"//access.inrecolan.com:5555/assets/vote/style.min.css\\\"> <script type=\\\"text/javascript\\\"> (function (d, w, c, h) { (w[c] = w[c] || []).push({ id: '24', el: (function () { var a = d.getElementsByTagName('script'); return a[a.length - 1]; })(), host: h, endpoint: '', }); var s = d.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = h + '/assets/vote/script.min.js?_t=' + Date.now(); d.head.appendChild(s); })(document, window, 'TlumVote', '//access.inrecolan.com:5555'); </script> <!-- TlumVote end --> </p> ";
    private String urlTest = "http://access.inrecolan.com:5555/news/novost-dla-proverki-otobrazenia-na-mobilnom-kliente/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webViewContent = (WebView) findViewById(R.id.webViewContent);
        setupWebView(webViewContent);
    }

    private String getHtmlText() {
        //return getString(R.string.html_script_1);
        return html;
    }


    private void setupWebView(WebView webView) {


        //final WebSettings settings = webView.getSettings();
        //settings.setJavaScriptEnabled(true);
        //settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //settings.setPluginState(WebSettings.PluginState.ON);

        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);

        //webView.setWebChromeClient(new WebChromeClient());
        String cssStyle = "<style>" +
                "img{display: inline;height: auto;max-width: 100%;}" +
                "iframe{height: auto;max-width: 99%;}" +
                "</style>";
        webView.loadUrl(urlTest);
        //webView.loadDataWithBaseURL(null, getHtmlText(), "text/html", "UTF-8", null);
    }

}
