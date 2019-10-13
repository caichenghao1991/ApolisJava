package com.java.util;

public enum Month {
JANUARY("01","JANUARY"),FEBURARY("02","FEBURARY"),MARCH("03","MARCH"),APRIL("04","APRIL"),
MAY("05","MAY"),JUNE("06","JUNE"),JULY("07","JULY"),AUGUST("08","AUGUST"),SEPTEMBER("09","SEPTEMBER"),
OCTOBER("10","OCTOBER"),NOVEMBER("11","NOVEMBER"),DECEMBER("12","DECEMBER");
	private String code;
	private String value;
	private  Month(String code,String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public static String getValueByCode(String code){
        for(Month m:Month.values()){
            if(code.equals(m.getCode())){
                return m.getValue();
            }
        }
        return  null;
    }

}
