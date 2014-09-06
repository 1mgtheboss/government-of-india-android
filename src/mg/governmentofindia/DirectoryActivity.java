package mg.governmentofindia;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DirectoryActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directory);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.departments, menu);
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
	
	public void openGovernmentDirectory(View view) {
	    // Do something in response to button
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://india.gov.in/my-government/government-directory"));
		startActivity(browserIntent);
	}
	
	public void openGovernmentWebDirectory(View view) {
	    // Do something in response to button
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://goidirectory.nic.in/index.php"));
		startActivity(browserIntent);
	}
}
