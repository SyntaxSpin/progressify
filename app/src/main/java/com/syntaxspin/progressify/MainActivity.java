package com.syntaxspin.progressify;

//import of statics


import static com.google.android.material.progressindicator.CircularProgressIndicator.INDETERMINATE_ANIMATION_TYPE_ADVANCE;
import static com.google.android.material.progressindicator.CircularProgressIndicator.INDETERMINATE_ANIMATION_TYPE_RETREAT;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.syntaxspin.progressify.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
	
	  private ActivityMainBinding binding;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
		setSupportActionBar(binding.toolbar);
        //Listeners and Actions
        //Progress State Slider
        progressSl();
        // Boolean of Determinate mode
        determinateMode();
        //Circular InDeterminate Animation Type
        setAnimIndeterminateMethod();
        // Amplitude Size
        setAmplitudeProgress();
        // Wave Length
        waveLength();
        // Wave Speed
        waveSpeed();
        // Circle Indicator Size
        circleIndicatorSize();
        //Track Thickness
        trackThickness();
        //Corner Radius
        cornerRadius();
        // Gap Size
        gapSize();
		
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuitem1 = menu.add(Menu.NONE, 0, Menu.NONE, "github");
        menuitem1.setIcon(R.drawable.github);
        menuitem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       final int id = item.getItemId();
   	final String title = (String) item.getTitle();
	   if (id == 0) {
		String url = "https://github.com/syntaxspin/progressify"; // Replace with the desired URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);			
		}
				return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
    
    
    
    public void progressSl() {
    	binding.progressSlider.addOnChangeListener((slider, value, fromUser) -> {
            binding.progressC.setProgress((int)value );
            binding.progressL.setProgress((int)value );
       });
    }
    
    public void determinateMode() {
    	binding.deterSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
          binding.progressC.setIndeterminate(!(isChecked));
          binding.progressL.setIndeterminate(!(isChecked));
          if (isChecked == true){
              binding.pAnim.setEnabled(true);
          } else {
              binding.pAnim.setEnabled(false);
          }
          
        });
    }
    public void setAnimIndeterminateMethod() {
    	binding.pAnim.addOnButtonCheckedListener(
        (group, checkedId, isChecked) -> {
            if(isChecked) {
             return;	
            }
            if(checkedId == binding.progressAnimAdvanceButton.getId() ){
                binding.progressC.setIndeterminateAnimationType(INDETERMINATE_ANIMATION_TYPE_ADVANCE);

            }else{
                binding.progressC.setIndeterminateAnimationType(INDETERMINATE_ANIMATION_TYPE_RETREAT);
            }        
        });
    }
    public void setAmplitudeProgress() {
    	binding.amplitudeSlider.addOnChangeListener((slider , value , fromUser)->{
            binding.progressC.setWaveAmplitude((int)value);
            binding.progressL.setWaveAmplitude((int)value);
        });
    }
    public void waveLength() {
    	binding.wavelengthSlider.addOnChangeListener((slider , value , fromUser)->{
            binding.progressC.setWavelength((int)value);
            binding.progressL.setWavelength((int)value);
        });
    }
    public void waveSpeed() {
    	binding.wavespeedSlider.addOnChangeListener((slider , value , fromUser)->{
            binding.progressC.setWaveSpeed((int)value);
            binding.progressL.setWaveSpeed((int)value);
        });
    }
    public void circleIndicatorSize() {
    	binding.cindicatorsizeSlider.addOnChangeListener((slider , value , fromUser) -> {
            binding.progressC.setIndicatorSize((int)value);
        });
    }
    public void trackThickness() {
    	binding.trackthickSlider.addOnChangeListener((slider , value , fromUser) -> {
            binding.progressL.setTrackThickness((int)value);
            binding.progressC.setTrackThickness((int)value);
        });
    }
    public void cornerRadius() {
    	binding.cornerradiusSlider.addOnChangeListener((slider , value , fromUser)->{
            binding.progressC.setTrackCornerRadius((int)value);
            binding.progressL.setTrackCornerRadius((int)value);
        });
    }
    public void gapSize() {
        binding.gapsizeSlider.addOnChangeListener((slider , value , fromUser)->{
      	binding.progressC.setIndicatorTrackGapSize((int)value);
          binding.progressL.setIndicatorTrackGapSize((int)value);
        });
    }
}