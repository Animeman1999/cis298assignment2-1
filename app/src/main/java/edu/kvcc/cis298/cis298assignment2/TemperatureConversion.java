package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by jmartin5229 on 10/3/2016.
 */

import android.widget.RadioGroup;
import android.widget.Toast;

public class TemperatureConversion {

    //******************Backing Fields
    private double mInputTemperature;
    private double mOutputTemperature;
    private int mFormulaNumber;

    private String mOutputFormula;

    public TemperatureConversion (double InputTemperature, int FormulaNumber)
    {
        mInputTemperature = InputTemperature;
        mFormulaNumber = FormulaNumber;

        switch (mFormulaNumber){
            case 0://°F = °C × 1.8 + 32
                mOutputTemperature = mInputTemperature * 1.8 + 32;
                mOutputFormula = "°F = °C × 1.8 + 32";
                break;
            case 1:// K = °C + 273.15
                mOutputTemperature = mInputTemperature + 273.15;
                mOutputFormula = " K = °C + 273.15";
                break;
            case 2://Ra = °C × 1.8 + 491.67
                mOutputTemperature = mInputTemperature * 1.8 + 491.67;
                mOutputFormula = "Ra = °C × 1.8 + 491.67";
                break;
            case 3://°C = (°F − 32) / 1.8
                mOutputTemperature = (mInputTemperature - 32) / 1.8;
                mOutputFormula = "°C = (°F − 32) / 1.8";
                break;
            case 4://K = (°F + 459.67) / 1.8
                mOutputTemperature = (mInputTemperature + 459.67) / 1.8;
                mOutputFormula = "K = (°F + 459.67) / 1.8";
                break;
            case 5://Ra = °F + 459.67
                mOutputTemperature = (mInputTemperature + 459.67);
                mOutputFormula = "Ra = °F + 459.67";
                break;
            case 6://C = K − 273.15
                mOutputTemperature = (mInputTemperature - 273.15);
                mOutputFormula = "C = K − 273.15";
                break;
            case 7://F = (K  − 273.15) × 1.8 + 32
                mOutputTemperature = (mInputTemperature  - 273.15) * 1.8 + 32;
                mOutputFormula = "°F = (K  − 273.15) × 1.8 + 32";
                break;
            case 8://°Ra = K × 1.8
                mOutputTemperature = (mInputTemperature *1.8);
                mOutputFormula = "°Ra = K × 1.8";
                break;
            case 9://°C = °Ra / 1.8 -491.67
                mOutputTemperature = (mInputTemperature / 1.8 -491.67);
                mOutputFormula = "°C = °Ra / 1.8 -491.67";
                break;
            case 10://°F = °Ra - 459.67
                mOutputTemperature = (mInputTemperature -459.67);
                mOutputFormula = "°F = °Ra - 459.67";
                break;
            case 11:// K = °Ra / 1.8
                mOutputTemperature = (mInputTemperature / 1.8);
                mOutputFormula = "°Ra = K × 1.8";
                break;
            default:// NO CONVERSION
                mOutputTemperature = mInputTemperature;
                mOutputFormula = "No conversion taking place!";
        }
    }

    public double getOutputTemperature() {
        return mOutputTemperature;
    }

    public String getOuputFormula() {
        return mOutputFormula;
    }

}
