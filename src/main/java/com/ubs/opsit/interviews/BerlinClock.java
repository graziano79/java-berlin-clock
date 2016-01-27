package com.ubs.opsit.interviews;


public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
        StringBuffer timeSB = new StringBuffer() ;
        String[] timeElements = aTime.split(":");
        String ls=System.getProperty("line.separator");
        
        timeSB.append(getSeconds(Integer.parseInt(timeElements[2]))).append(ls);
        timeSB.append(getTopHours(Integer.parseInt(timeElements[0]))).append(ls);
        timeSB.append(getBottomHours(Integer.parseInt(timeElements[0]))).append(ls);
        timeSB.append(getTopMinutes(Integer.parseInt(timeElements[1]))).append(ls);
        timeSB.append(getBottomMinutes(Integer.parseInt(timeElements[1])));
        
        return timeSB.toString();
	}

    protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }
 
    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }
 
    protected String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }
 
    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }
 
    protected String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }
 
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }
 
    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }
}
