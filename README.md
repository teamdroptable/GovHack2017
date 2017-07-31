# GovHack2017

This Android application was made in Android Studio, to run the program, download a copy of Android Studio and clone this repo onto your computer.  Aside from the normal Android studio functions you will need to download the 'Google Play' services in the SDK manager of Android Studio if opening the project does not automatically do so.

Android Studio will allow you to run the application either from an emulated phone (Android Studio allows you to set up an emulator) or you can run it through an actual Android phone which you can connect to your computer.

If you choose an actual phone you will need to put your Android phone in 'developer mode', the method to do so varies between android devices but can be found with a quich internet search.  It is worth mentioning that the Google API will only work on a phyiscal phone and not on an emulated copy.

About the Program:
The application is clearly not fully functional for distribution, the current version on this repo lacks two main features that need to be implemented before distribution.  
1.  The GPS feature has not been implemented, the application requires the users location to obtain relevant longitude and latitude settings, at the moment a static longitude and latitude input is being used for the City region in the ACT.  Likewise the emergency call function phone-numbers are not configured to their correct phone numbers and instead are using a static testing number.  
2.  Communication with the Server.  The ServiceCaller.class is an operational class to talk the free server that was setup for Govhack and the server does contain a functioning database for the application.  However Service caller is not implemented and needs to be impelmented in the ReportActivity.class and the GraphActivity.class to send and obtain information from the server.

The developers would also like it known that we are aware of how...haphhazard our code is with indecision between using Java constructor's for elements and Android XML resources for elements, as well as indecisive design in techniques.  All that said for a rushed project we're happy with a vaguely working result and we have identified most of the cleanups and implementation changes we would do.
