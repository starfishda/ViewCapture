package com.hd.viewcapture.demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;


/**
 * Created by hd on 2018/2/6 .
 * view demo
 */
public class MainActivity extends BaseCaptureActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("View Capture");
    }

    public void capture(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.captureView:
                captureView(findViewById(R.id.lin).getRootView());
                return;
            case R.id.captureScrollView:
                intent = new Intent(this, ScrollViewActivity.class);
                break;
            case R.id.captureHorizontalScrollView:
                intent = new Intent(this, HorizontalScrollViewActivity.class);
                break;
            case R.id.captureListView:
                intent = new Intent(this, ListViewActivity.class);
                break;
            case R.id.captureRecyclerView:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
            case R.id.captureWebView:
                intent = new Intent(this, WebViewActivity.class);
                break;
            case R.id.mediaProjection:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    intent = new Intent(this, NewApiCaptureActivity.class);
                    break;
                }else{
                    Toast.makeText(this,"android 5.0+ API",Toast.LENGTH_SHORT).show();
                    return;
                }
        }
        startActivity(intent);
    }
}
