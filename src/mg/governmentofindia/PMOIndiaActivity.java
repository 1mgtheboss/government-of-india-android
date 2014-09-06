package mg.governmentofindia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PMOIndiaActivity extends ActionBarActivity {
	private ListView listView1;


	@SuppressLint("InflateParams")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pmoindia);
		
		PMOMenuItem pmo_menu_data[] = new PMOMenuItem[]
				 {
				 new PMOMenuItem(R.drawable.pmo_official_site, "Official site"),
				 new PMOMenuItem(R.drawable.facebook, "PMO on Facebook"),
				 new PMOMenuItem(R.drawable.twitter, "PMO on Twitter"),
				 
				 };
		
		PMOMenuItemAdapter adapter = new PMOMenuItemAdapter(this,
				 R.layout.listview_item_row_pmo, pmo_menu_data);
				 
				 
				 listView1 = (ListView)findViewById(R.id.listView1);
				 
				 View header =
				(View)getLayoutInflater().inflate(R.layout.listview_header_row_pmo, null);
				 listView1.addHeaderView(header);
				 
				 listView1.setAdapter(adapter);
				 
				  listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			            @Override
			            public void onItemClick(AdapterView<?> parent, View view, int position,
			                    long id) {
			                
			                
			                switch(position)
			                {
			                
			                case 1:
			                	Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pmindia.nic.in/"));
			            		startActivity(browserIntent1);
			                	break;
			                case 2:
			                	Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/PMOIndia"));
			            		startActivity(browserIntent2);
			                	break;
			                case 3:
			                	Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/PMOIndia"));
			            		startActivity(browserIntent3);
			                	break;
			                
			                	
			                	
			                }
			                
			                
			            }
			        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pmoindia, menu);
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
}
