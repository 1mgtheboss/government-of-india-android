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

public class MainMenuItemAdapter extends ArrayAdapter<MainMenuItem>{
	Context context; 
    int layoutResourceId;    
    MainMenuItem data[] = null;
    public MainMenuItemAdapter(Context context, int layoutResourceId, MainMenuItem[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MenuItemHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new MenuItemHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            
            row.setTag(holder);
        }
        else
        {
            holder = (MenuItemHolder)row.getTag();
        }
        
        MainMenuItem menuItem = data[position];
        holder.txtTitle.setText(menuItem.title);
        holder.imgIcon.setImageResource(menuItem.icon);
        
        return row;
    }
    static class MenuItemHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

}
