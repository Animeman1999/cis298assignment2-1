package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureConverter extends AppCompatActivity {

    private Button mConvertButton;
    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;
    private TextView mAnswerTextView;

    private int [] [] mFindFormula = {// ARRAY TO HOLD THE FORMULA NUMBERS, ROWS ARE THE FROM TYPE AND COLUMNS ARE THE TO TYPE
            {12, 0,  1,  2},
            {3, 12,  4,  5},
            {6,  7, 12,  8},
            {9, 10, 11, 12}};


    private void getTemperatureInput(){

        int mFormulaNumberSelected = 0; //To hold the formula number selected

        double mInputTemperatureDouble; // converted double from the mInputTemperatureString

        String mTempFromType = "-"; //To hold the Temperature type being converted from

        String mTempToType = "-";// To hold the Temperature type being converted to

        String mInputTemperatureString = ((EditText) findViewById(R.id.edit_text)).getText().toString();  // holds the input data from the EditText


        if(mInputTemperatureString != null && !mInputTemperatureString.isEmpty()){//Make sure a temperature has been entered.

            mInputTemperatureDouble = Double.parseDouble(mInputTemperatureString); //Since input type was restricted to numbers in the XML file convert it to a double.

            int mSelectedFrom = mFromGroup.getCheckedRadioButtonId();

            if (mSelectedFrom > 0){
                mSelectedFrom = (Math.abs(mSelectedFrom) % 10);

                int mSelectedTo = mToGroup.getCheckedRadioButtonId();

                if (mSelectedTo > 0){
                    mSelectedTo = (Math.abs(mSelectedTo) % 10);

                    switch (mSelectedFrom)
                    {
                        case 1:
                            mTempFromType = "°C";
                            break;
                        case 2:
                            mTempFromType = "°F";
                            break;
                        case 3:
                            mTempFromType = "K";
                            break;
                        default:
                            mTempFromType = "°Ra";
                    }

                    switch (mSelectedTo)
                    {
                        case 5:
                            mTempToType = "°C";
                            break;
                        case 6:
                            mTempToType = "°F";
                            break;
                        case 7:
                            mTempToType = "K";
                            break;
                        default:
                            mTempToType = "°Ra";
                            break;
                    }

                    mFormulaNumberSelected = mFindFormula[(mSelectedFrom -1)] [(mSelectedTo - 5) ];

                    //******************************Stoped here*************************************
                }
                else
                {
                    Toast.makeText(TemperatureConverter.this, R.string.no_to_chosen, Toast.LENGTH_SHORT).show();
                }

            }
            else
            {
                Toast.makeText(TemperatureConverter.this, R.string.no_from_chosen, Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(TemperatureConverter.this, R.string.no_temperature_entered, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mConvertButton = (Button) findViewById(R.id.convertButton);

        mFromGroup = (RadioGroup) findViewById(R.id.radioGroupFrom);

        mToGroup = (RadioGroup) findViewById(R.id.radioGroupTo);

        mConvertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                getTemperatureInput();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
