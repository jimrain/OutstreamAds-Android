# OutstreamAds-Android
Android Sample app that uses a recycler view to do outstream ads. This is helpful to show how to do 
video inline with articles or other data interspersed. 


## Setup
Use [this](https://support.brightcove.com/quick-start-build-app-using-brightcove-native-sdk-android#Create_a_project
)  documentation to set up the project and add the Brightcove SDK.

I like to use new versions of the SDK when possible so I added in version 5.3 of the SDK. 
 Where *anpVersion* is set in gradle.properties change it to reflect that version:

    # gradle.properties

    # Use this property to select the most recent Brightcove Android
    # Native Player version.
    anpVersion=5.3+

I also had to add the Recycler Library: Go to *File -> Project Structure*, then select the *app* module 
on the left. Then select the*Dependencies* tab. Use the *+* button and choose *Libary dependency*. Search or Recycler 
and make sure you select the one for com.android.support:recyclerview (there's a bunch of them).

## Design

 