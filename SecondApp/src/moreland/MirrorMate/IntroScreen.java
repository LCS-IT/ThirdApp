package moreland.MirrorMate;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import moreland.MirrorMate.R;

public class IntroScreen extends Activity {

	public final static String EXTRA_MESSAGE = "moreland.Ryan.firstapplication.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro_screen);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		Intent bluetooth = new Intent(this, BluetoothScreen2.class);
		EditText editText = (EditText) findViewById(R.id.pair_with_bluetooth);
		String message = editText.getText().toString();
		bluetooth.putExtra(EXTRA_MESSAGE, message);
		startActivity(bluetooth);
	}
	
	public void goToMain(View view) {
		Intent mainMenu = new Intent(this, MainMenu.class);
		EditText editText = (EditText) findViewById(R.id.go_to_main);
		String message = editText.getText().toString();
		mainMenu.putExtra(EXTRA_MESSAGE, message);
		startActivity(mainMenu);
	}
}
