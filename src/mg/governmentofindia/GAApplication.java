package mg.governmentofindia;

import java.util.HashMap;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger.LogLevel;
import com.google.android.gms.analytics.Tracker;

public class GAApplication extends Application {
	
	private static final String PROPERTY_ID = "UA-53449196-2";
	/**
	   * Enum used to identify the tracker that needs to be used for tracking.
	   *
	   * A single tracker is usually enough for most purposes. In case you do need multiple trackers,
	   * storing them all in Application object helps ensure that they are created only once per
	   * application instance.
	   */
	  public enum TrackerName {
	    APP_TRACKER, // Tracker used only in this app.
	    GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg: roll-up tracking.
	    ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a company.
	  }

	  HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();
	  
	  public GAApplication() {
		  
		  super();
		  
		  }

	  synchronized Tracker getTracker(TrackerName trackerId) {
		    if (!mTrackers.containsKey(trackerId)) {

		      // When dry run is set, hits will not be dispatched, but will still be logged as
		      // though they were dispatched.
		      GoogleAnalytics.getInstance(this).setDryRun(true);
		      // Set the log level to verbose.
		      GoogleAnalytics.getInstance(this).getLogger()
		          .setLogLevel(LogLevel.VERBOSE);
		      GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
		      Tracker t = (trackerId == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID)
		          : (trackerId == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker)
		              : analytics.newTracker(R.xml.ecommerce_tracker);
		      mTrackers.put(trackerId, t);

		    }
		    return mTrackers.get(trackerId);
		  }
}
