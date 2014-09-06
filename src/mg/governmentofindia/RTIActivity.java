package mg.governmentofindia;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class RTIActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rti);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rti, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void openRTIOfficialSite(View view) {
	    // Do something in response to button
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rti.gov.in/"));
		startActivity(browserIntent);
	}
	
	public void openRTIOnlinePortal(View view) {
	    // Do something in response to button
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rtionline.gov.in/"));
		startActivity(browserIntent);
	}
}
