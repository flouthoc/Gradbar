package com.flouthoc.gradbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
//import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.view.View;
import java.util.*;
import android.widget.TextView;

public class Main extends AppCompatActivity
{
    /** Called when the activity is first created. */

    public int i;
    public int max_size;
    public Map<String, Integer> gradient_map;
    public String[] gradients = {"intuitive_purple", "grad", "blood_red", "firewatch", "sherbert", "lush", "sunset"};
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        max_size = gradients.length;

        gradient_map = new HashMap<String, Integer>();

        gradient_map.put("intuitive_purple", R.drawable.intuitive_purple);
        gradient_map.put("grad", R.drawable.grad);
        gradient_map.put("blood_red", R.drawable.blood_red);
        gradient_map.put("firewatch", R.drawable.firewatch);
        gradient_map.put("sherbert", R.drawable.sherbert);
        gradient_map.put("lush", R.drawable.lush);
        gradient_map.put("sunset", R.drawable.sunset);

		final Button button = (Button) findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {

             	if(i >= max_size)
             		i = 0;

             	TextView textview = (TextView) findViewById(R.id.textv);
             	textview.setText(gradients[i]+"!");
             	ActionBar actionBar = getSupportActionBar();        
				actionBar.setBackgroundDrawable(ContextCompat.getDrawable(Main.this, gradient_map.get(gradients[i])));
				v.setBackgroundDrawable(ContextCompat.getDrawable(Main.this, gradient_map.get(gradients[i])));

				i++;
                 // Perform action on click
             }
         });
		//ContextCompat.getDrawable(getSupportActionBar(), R.drawable.grad);
    }


}
