package com.verizon.appiumtests.controls;

public class CloudContact {
    public String FirstName;
    public String LastName;
    public String Mobile;
    public String HomePhone;
    int currentSeed;

    public CloudContact(int _currentSeed) {
        currentSeed = _currentSeed;
        generateDynamicContactDetails();
    }

    private void generateDynamicContactDetails() {
        long MobileNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        long HomePhoneNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        FirstName = "CFName" + currentSeed;
        LastName = "CLName" + currentSeed;
        Mobile = "1"+String.valueOf(MobileNumber);
        HomePhone = "1"+String.valueOf(HomePhoneNumber);
    }
}
