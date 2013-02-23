package moreland.MirrorMate;

/*import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;*/
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import moreland.MirrorMate.R;

public class ShowMap extends FragmentActivity {

	public FragmentManager fragManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_map);
		
		fragManager = getSupportFragmentManager();
		
	    Button showMapButton = (Button) findViewById(R.id.showMapButton);
	    showMapButton.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	            loadMapFragment();

	        }
	    });
	}

	private void loadMapFragment(){
		MapFragment pageFragment = new MapFragment();
		FragmentTransaction ft = fragManager.beginTransaction();
	//	ft.replace(R.id.allFragmentsFrameLayout,pageFragment);
		ft.addToBackStack(null);
		ft.commit();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_show_map, menu);
		return true;
	}

}
