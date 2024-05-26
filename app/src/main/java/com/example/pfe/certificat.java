package com.example.pfe;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class certificat extends Fragment {

    ImageButton back;
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_certificat, container, false);

        // Find the back button after inflating the layout
        back = view.findViewById(R.id.back);
        webView = view.findViewById(R.id.webView);

        // Set an onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() as the context for the Intent
                Intent intent = new Intent(getActivity(), mainparent.class);
                startActivity(intent);
            }
        });

        // Set an onClickListener for the TextView to view PDF
        TextView pdfTextView = view.findViewById(R.id.tv_header);
        pdfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPdfInWebView();
            }
        });

        return view;
    }

    private void loadPdfInWebView() {
        // URL of the PDF to be loaded
        String pdfUrl = "http://www.africau.edu/images/default/sample.pdf"; // Replace with your PDF URL

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        // Load the PDF using Google Docs viewer
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfUrl);
    }
}
