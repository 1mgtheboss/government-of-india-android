package mg.governmentofindia;

import mg.governmentofindia.GAApplication.TrackerName;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

@SuppressLint("InflateParams")
public class MainMenuActivity extends ActionBarActivity {
	private InterstitialAd interstitial;
	private ListView listView1;
	private String path="MainMenuActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		// Get tracker.
        Tracker t = ((GAApplication) getApplication()).getTracker(
            TrackerName.APP_TRACKER);

        // Set screen name.
        // Where path is a String representing the screen name.
        t.setScreenName(path);

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());
        
		MainMenuItem menu_data[] = new MainMenuItem[]
		        {
		            new MainMenuItem(R.drawable.mygov, "My Gov"),
		            new MainMenuItem(R.drawable.at_a_glance, "At a glance"),
		            new MainMenuItem(R.drawable.directory, "Directory"),
		            new MainMenuItem(R.drawable.write_to_pm, "Write to PM"),
		            new MainMenuItem(R.drawable.pmo, "PMO India"),
		            new MainMenuItem(R.drawable.recruitment, "Recruitment Information"),
		            new MainMenuItem(R.drawable.rti, "RTI"),
		            new MainMenuItem(R.drawable.online_portal, "Online Portal"),
		            new MainMenuItem(R.drawable.share, "Share this app"),
		            new MainMenuItem(R.drawable.about, "About")
		            
		            
		        };
		
		MainMenuItemAdapter adapter = new MainMenuItemAdapter(this, 
                R.layout.listview_item_row, menu_data);
        
        
        listView1 = (ListView)findViewById(R.id.listView1);
         
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);
        
        listView1.setAdapter(adapter);
        
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {
                
                
                switch(position)
                {
                
                case 1:
                	Intent intent1 = new Intent(getApplicationContext(), MyGovActivity.class);
            		startActivity(intent1);
                	break;
                case 2:
                	Intent intent2 = new Intent(getApplicationContext(), AtAGlanceActivity.class);
            		startActivity(intent2);
                	break;
                case 3:
                	Intent intent3 = new Intent(getApplicationContext(), DirectoryActivity.class);
            		startActivity(intent3);
                	break;
                case 4:
                	Intent intent4 = new Intent(getApplicationContext(), WriteToPMActivity.class);
            		startActivity(intent4);
                	break;
                case 5:
                	Intent intent5 = new Intent(getApplicationContext(), PMOIndiaActivity.class);
            		startActivity(intent5);
                	break;
                case 6:
                	Intent intent6 = new Intent(getApplicationContext(), RecruitmentInformationActivity.class);
            		startActivity(intent6);
                	break;
                case 7:
                	Intent intent7 = new Intent(getApplicationContext(), RTIActivity.class);
            		startActivity(intent7);
                	break;
                case 8:
                	Intent intent8 = new Intent(getApplicationContext(), OnlinePortalActivity.class);
            		startActivity(intent8);
                	break;
                case 9:
                	Intent intent9 = new Intent(getApplicationContext(), ShareActivity.class);
            		startActivity(intent9);
                	break;
                case 10:
                	Intent intent10 = new Intent(getApplicationContext(), AboutActivity.class);
            		startActivity(intent10);
                	break;
                	
                	
                }
                
                
            }
        });
        
        
        
     // Create the interstitial.
	    interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId("ca-app-pub-2738757694043962/2505090532");


interstitial.setAdListener(new AdListener() {
	        @Override
	        public void onAdLoaded() {
	          
	        	displayInterstitial();

	          
	        }
	        @Override
	        public void onAdFailedToLoad(int errorCode) {
	          
	        }
	    });
		
	    // Create ad request.
	    AdRequest adRequest = new AdRequest.Builder().addTestDevice("6DEA8AA4615AD954F7FAE46405A9F4C2").build();
	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
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
	
	// Invoke displayInterstitial() when you are ready to display an interstitial.
		  public void displayInterstitial() {
		    if (interstitial.isLoaded()) {
		      interstitial.show();
		    }
		  }
}
