package mg.governmentofindia;
import mg.governmentofindia.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class PMOMenuItemAdapter extends ArrayAdapter<PMOMenuItem>{
	 Context context;
	 int layoutResourceId; 
	 PMOMenuItem data[] = null;
	 
	 public PMOMenuItemAdapter(Context context, int layoutResourceId, PMOMenuItem[]
	data) {
	 super(context, layoutResourceId, data);
	 this.layoutResourceId = layoutResourceId;
	 this.context = context;
	 this.data = data;
	 }
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	 View row = convertView;
	 PMOMenuItemHolder holder = null;
	 
	 if(row == null)
	 {
	 LayoutInflater inflater =((Activity)context).getLayoutInflater();
	 row = inflater.inflate(layoutResourceId, parent, false);
	 
	 holder = new PMOMenuItemHolder();
	 holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
	 holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
	 
	 row.setTag(holder);
	 }
	 else
	 {
	 holder = (PMOMenuItemHolder)row.getTag();
	 }
	 
	 PMOMenuItem pMOMenuItem = data[position];
	 holder.txtTitle.setText(pMOMenuItem.title);
	 holder.imgIcon.setImageResource(pMOMenuItem.icon);
	 return row;
	 }
	 
	 static class PMOMenuItemHolder
	 {
	 ImageView imgIcon;
	 TextView txtTitle;
	 }
	}
