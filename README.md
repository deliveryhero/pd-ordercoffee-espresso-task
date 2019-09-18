# Mailordercoffee-workshop

<img src="./readme-images/3.png" width="25%" align="right" >
<img src="./readme-images/2.png" width="25%" align="right" >
<img src="./readme-images/1.png" width="25%" align="right" >

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />


This Repo contains the source code for the 'Mail Order Coffeeshop app'.
The MailOrder Coffeeshop app was built for Android App test automation practice.


### Setup

In order to run this app you'll need a way to download this project, an IDE, and a Android device or Emulator.
Using Android Studio and Git is recommended:

### Clone the project

If you're familiar with Git, then you should know what to do.

When the clone is finished you're all set to open the project.


### Download Android Studio

Android Studio is Google's IDE that's made for Android app development. 
 Follow the installation instructions on the Android Studio website: 
[https://developer.android.com/studio/install] (https://developer.android.com/studio/install)


### Open the Project in Android Studio

1.	Open android studio
2.	Select "Open an existing Android Studio project"
3.	Browse to the directory where you saved the project and open it:
4.	This is the point where Android Studio may ask you a few questions about the setup of your IDE and/or a few project related questions. If you don't know what to do, most of the time accepting the (default) suggestions is fine.
5.  Time to see if everything works:  This is what the project structure should look like in Android Studio: 
![android-studio-android-project-view.png](./readme-images/android-studio-android-project-view.png)

If it doesn't look like this, there are a few thing you can do:

- Check in the bottom bar of Android Studio if Gradle is still syncing, downloading dependencies etc. If it is, wait a few minutes.
- Make sure the project pane is open (click the "1: Project" button on the left side).
- Make sure the 'Android' view is selected in the drop down menu at the top.

If all else fails: 
- From the file menu select Invalidate Caches / Restart.. (and invalidate the caches and restart)
- From the Build menu select Clean Project
- From the build menu select Rebuild project

6.  If you haven't already: setup a device or emulator so you can run the app
7.  Run the app to test if everything was downloaded and imported correctly: Press the 'play' icon in the top right corner of Android Studio, make sure "app" is selected in the drop-down menu.
![build-app.png](./readme-images/build-app.png) 


### Emulator setup

1.	In Android Studio select the Tools menu and then 'AVD Manager'.  
2.	Click the '+ Create Virtual Device' button.
3.	Select a device from the list, for example Nexus 5X, and click 'Next'
4.	Select a system image. I'd go with one of the recommended images (Pie, API 28) and click 'Next'
5.	Give the virtual device a name and click 'Finish'

Note: downloading the files for the emulator may take a while. 

### Device setup

Developer options on your device should be enabled so we can use usb debug mode and disable animations. Debug mode allows Android Studio to recognize the device, and turning animations off is a recommended practice for mobile test automation. If turned on, animation may cause unexpected delays and test failures.

Instructions may differ for different manufacturers. 
In general, this works*: 
1. Open de Settings app;
2. (Android 8.0 or higher) Select system;
3. Scroll to the bottom and select About Phone;
4. Scroll to the bottom and tap Build Number 7 times;
5. Return to the previous screen to find Developer options near the bottom.

### Tech Stack

- Use `Java`Or `Kotlin`
- Use [Espresso](https://developer.android.com/training/testing/espresso) for writing Android UI tests


### Workshop task 1

Goto to `app/src/androidTest/java/de/deliveryhero/mailordercoffeeshop` you will find `EspressoWorkshopTest` and here you can start writing your tests

- Close the `Onboarding` screen
- Place and Order with `2 Espresso shots , Chocolate and Low fat Steamed Milk `
- Ensure that your order is correct in Review Screen 
- Fill the form with valid data to submit your order 
- Click `Submit Order` - Just click the button not continue with Email part


### Workshop task 2
- Close the `Onboarding` screen
- Click on `Menu`
- Select `CAPPUCCINO`
- Enter `your Name` and `your email`
- Click `Submit Order`

##Optional: 
- Ensure that Gmail app is opened
