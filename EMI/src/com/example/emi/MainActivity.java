package com.example.emi;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	 EditText loanamt,intrate,loanprd;
	 TextView mr,tr;
	 Button cal,clr;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loanamt=(EditText)findViewById(R.id.EditText1);
        intrate=(EditText)findViewById(R.id.EditText2);
        loanprd=(EditText)findViewById(R.id.EditText3);
        mr=(TextView)findViewById(R.id.textView4);
        tr=(TextView)findViewById(R.id.textView5);
        cal=(Button)findViewById(R.id.button1);
        clr=(Button)findViewById(R.id.button2);
        clr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				loanamt.setText("");
				intrate.setText("");
				loanprd.setText("");
				mr.setText("");
				tr.setText("");
				
			}
		});
        cal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double loanamount=Integer.parseInt(loanamt.getText().toString());
				double interestrate=Float.parseFloat(intrate.getText().toString());
				double loanperiod=Integer.parseInt(loanprd.getText().toString());
				double r=interestrate/1200;
				double r1=Math.pow(r+1,loanperiod);
				double monthlypayment=(double)(loanamount*r*(r1/(r1-1)));
				double totalpayment=monthlypayment*loanperiod;
				mr.setText("Monthlypayment:"+monthlypayment);
				tr.setText("Totalpayment:"+totalpayment);
				
				
				
			}
		});
    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

}
		
    
