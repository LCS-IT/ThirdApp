package moreland.MirrorMate;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import moreland.MirrorMate.R;

public class MainMenu extends Activity {

	public final static String EXTRA_MESSAGE = "moreland.Ryan.firstapplication.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		// Show the Up button in the action bar.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public void goToBluetooth(View view) {
		Intent bluetooth = new Intent(this, BluetoothScreen2.class);
		EditText editText = (EditText) findViewById(R.id.pair_with_bluetooth);
		String message = editText.getText().toString();
		bluetooth.putExtra(EXTRA_MESSAGE, message);
		startActivity(bluetooth);
	}
	
	public void goToShowMap(View view) {
	/*	Intent showMap = new Intent(this, ShowMap.class);
		EditText editText = (EditText) findViewById(R.id.go_to_map);
		String message = editText.getText().toString();
		showMap.putExtra(EXTRA_MESSAGE, message);
		startActivity(showMap);*/
		Intent mapFragment = new Intent(this, MapFragment.class);
		startActivity(mapFragment); 
	}
	
	public void goToGetDirections(View view) {
		Intent getDirections = new Intent(this, GetDirections.class);
		EditText editText = (EditText) findViewById(R.id.go_to_get_directions);
		String message = editText.getText().toString();
		getDirections.putExtra(EXTRA_MESSAGE, message);
		startActivity(getDirections);
	
	}
}
