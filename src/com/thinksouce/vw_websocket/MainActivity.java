package com.thinksouce.vw_websocket;

import com.strumsoft.websocket.phonegap.WebSocketFactory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        WebView wv = (WebView)findViewById(R.id.webview);				
		wv.getSettings().setJavaScriptEnabled(true);
		wv.setWebChromeClient(new WebChromeClient() {
			   public void onProgressChanged(WebView view, int progress) {				   
			   }
			 });
		wv.setWebViewClient(
				new WebViewClient(){
					public boolean shouldOverrideUrlLoading(WebView view, String url){
						view.loadUrl(url);
						return false;
					}
		});
		wv.loadUrl("file:///android_asset/www/index.html");
		wv.addJavascriptInterface(new WebSocketFactory(wv), "WebSocketFactory");
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
