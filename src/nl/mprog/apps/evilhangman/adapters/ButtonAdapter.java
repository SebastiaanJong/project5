package nl.mprog.apps.evilhangman.adapters;

import nl.mprog.apps.evilhangman.MainActivity;
import nl.mprog.apps.evilhangman.clickhandlers.ButtonClickHandler;
import nl.mprog.apps.evilhangman.hangman.Hangman;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * The adapter that will create all the buttons that represent the alfabet.
 * 
 * @author Marten
 * @author Sebastiaan
 *
 */
public class ButtonAdapter extends BaseAdapter {
	
    private Context context;
    private int buttonSize;
    private int fontSize;
    
    private Hangman hangman;
    
    public ButtonAdapter(Context c, int bs, int fs) { 
    	context = c;
    	buttonSize = bs;
    	fontSize = fs;
    }
    
    public void setHangman(Hangman hangman) {
		this.hangman = hangman;
	}

    public int getCount () {
    	return 26;
    }

    public Object getItem(int position) {
    	return null; 
    }

    public long getItemId(int position) {
    	return position; 
    }
    
    public View getView(int position, View convertView, ViewGroup parent){     
    	Button btn;         
        if (convertView == null) {     
            btn = new Button(context);
            btn.setLayoutParams(new GridView.LayoutParams (buttonSize, buttonSize));
            btn.setPadding(0,0,0,0); 
            btn.setText(Character.toString((char) (position+97)));
            btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
		    btn.setOnClickListener(new ButtonClickHandler((MainActivity) context, hangman));
        } else {        
            btn = (Button) convertView;
        }       

        btn.setId(position);
        	
        return btn; 
    }
}