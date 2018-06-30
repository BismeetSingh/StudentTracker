package com.app.bissudroid.androidtutorials.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;

public class CodeActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_text);
        String text = getIntent().getStringExtra(Constants.FIELD_KEY);
        TextView filename = findViewById(R.id.filename);
        Toolbar toolbar = findViewById(R.id.toolbar);
        String title = getIntent().getStringExtra("title");
        if (title != null) {
            toolbar.setTitle(title);
        }
        if (text != null) {
            textView = findViewById(R.id.codeview);
            //This sets the code
            text=text.replace("class","<font color='#EE0000'>some word</font>");
            textView.setText(text);
            textView.setTextIsSelectable(true);
            //This sets the java filename.
            filename.setText(getIntent().getStringExtra(Constants.FIELDFILENAME));

//            textView.setText(Html.fromHtml("<![CDATA[<font color='#145A14'>text</font>]]>"));
        }



//        String keywords[]=new String[]{"public","class","protected","void","public","private"};
//        SpannableString spannableString=null;
//        for (String mySearchedString : keywords) {
//            StringBuilder textBuilder = new StringBuilder(textView.getText().toString());
//            StringBuilder searchedTextBuilder = new StringBuilder((mySearchedString));
//            spannableString = new SpannableString(textView.getText().toString());
//
//            int counter = 0;
//            int index = 0;
//
//            for (int i = 0; i < textBuilder.length() - mySearchedString.length() - 1; i++) {
//                counter = 0;
//                if (Character.toLowerCase(textBuilder.charAt(i)) == Character.toLowerCase(searchedTextBuilder.charAt(index))) {
//                    counter++;
//                    index++;
//                    for (int j = 1, z = i + 1; j < mySearchedString.length() - 1; j++, z++) {
//                        if (Character.toLowerCase(textBuilder.charAt(z)) == Character.toLowerCase(searchedTextBuilder.charAt(index))) {
//                            counter++;
//                            index++;
//                        } else {
//                            index++;
//                            if (index % mySearchedString.length() == 0) {
//                                index = 0;
//                            }
//                            break;
//                        }
//                    }
//                    if (counter == mySearchedString.length() - 1) // A match
//                    {
//                        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), i,
//                                i + mySearchedString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // Do the change you want(In this case changing the fore ground color to red)
//                        index = 0;
//                    } else {
//                        index = 0;
//
//                    }
//                }
//                textView.setText(spannableString);
//            }
//
//        }
//
//
//
    }
}
