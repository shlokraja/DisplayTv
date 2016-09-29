package com.atchayam.foodbox.displaykitkat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Display extends Activity {
    private Button button;
    private ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_display);

        button = (Button) findViewById(R.id.buttonUrl);
        imgLogo = (ImageView) findViewById(R.id.imageView);
        imgLogo.setBackgroundResource(R.drawable.atchayam_logo);
        final Spinner dropdown = (Spinner)findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, WebDisplayActivity.class);
                final String text = dropdown.getSelectedItem().toString();
                intent.putExtra("URL_NAME", text);
                startActivity(intent);
            }
        });
        //String[] items = new String[]{"192.168.1.26/atchayamTV", "192.168.1.47:8000/menu_display/bigtv", "192.168.1.47:9090","192.168.1.47:8000/menu_display/tv"};
        String[] items = new String[]{ "192.168.1.147:3000","192.168.1.47:8000/menu_display/tv","192.168.1.47:9090"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }
}
