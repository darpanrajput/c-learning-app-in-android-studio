
# C-Learning-Android-App
This is a sample project for c learning android app with firebase attached as database. it uses the Google play billing library for purchasing the digital content which is stored on firebase database. 

| First View | Second view | third Vivew |
| :---         |          ---: |          --|
| ![Image of Yaktocat](https://1.bp.blogspot.com/-NIeBQOa_QHI/XaQOrzoS-oI/AAAAAAAABtI/yFryq1gOC4IlubjG1DPAAMoIdC09Hq7DACLcBGAsYHQ/s400/20191014_005131.gif)   | ![Image of Yaktocat](https://1.bp.blogspot.com/-0ifaR3eUzLQ/XaQOsJsfXPI/AAAAAAAABtM/RIFQMnmFh_MycWLhdPbBBY0v78yG9iG7QCLcBGAsYHQ/s400/20191014_005315.gif) |![Image of Yaktocat](https://1.bp.blogspot.com/-9dmsmyPzRxg/XaQOo4T5ovI/AAAAAAAABtE/SMjvm4W32NkGYHJ9KcgkRNUJeyzgWiCdQCLcBGAsYHQ/s400/20191014_005445.gif=360x720) |

# Notable Changes

Before you start building the project you must setup some things quickly

## setup a google firebase 

attach the google firebase to the project and setup  the rules of the database

[follow this link] (https://firebase.google.com/docs/storage/security/start)

[set up firebase] https://firebase.google.com/docs/android/setup
after all this a file (C-Learning-Android-App/app/google-services.json )will be added to your project

## setup a google play console and obtain BASE_64_KEY_PUBLIC KEY
a)To published app on playstore as the production use the link below

[follow this link]https://support.google.com/googleplay/android-developer/answer/113469?hl=en

the version of the app is free you don't have to create a paid release
only managed product id will do the work.


b) you have to create 10 manged products with  
 these ids.
To know more the creating managed products 

[follow]https://support.google.com/googleplay/android-developer/answer/1153481?hl=en

you can change the title and description of each app

1.the price will be the 10 euro each or in you default currency

2.title=purchase this pdf

3.description=to view the pdf you have to purcahse the item.

#### the given below the product id that you have to create with these name

purchase_pdf_1

purchase_pdf_2

purchase_pdf_3

purchase_pdf_4

purchase_pdf_5

purchase_pdf_6

purchase_pdf_7

purchase_pdf_8

purchase_pdf_9

purchase_pdf_10

after this you have to give the app specific base64 key  

To find the public licensing key for your app perform the following steps...

1.) Login to the Google Play Developer console from where you published your app

2.) Click on your app in the list of apps

3.) Click on Developer Tools on the left menu

3.) Select Services & API's

4.) Under Licensing & In-App billing you will see the public key


### To know more about the App release types

[fOLLOW] https://support.google.com/googleplay/android-developer/answer/3131213?hl=en#start&closed_open_beta&multiply_test&closed_beta&open_beta&closed_groups&games&version_codes&track_status&when_internal_test&internal_test&create_additional_track

We will use Internal test track (before production release )so you 
have to create an internal test track
* you have to change the version code to 2 and version name to 2.0 whenever required 

* Remove/delete the previously uploaded app if any

* release the app in internal test track

* you will be avilable to test the app with a url 

* rollout to internal test and create emal list of tester and active tester

* wait to publish the app

*  downlaod the app with this url(from playstore)to test the purchase

*  if any error occur it will be displayed in the form of pop message

signature and keys passwords
(these can be used while creating  additional customization. you have to save these privately)

 
#HOW TO ADD fIREBASE

[Follow] https://firebase.google.com/docs/android/setup#console

1.login to firebase console https://console.firebase.google.com

2.ADD projects and project name to -->download-pdf-from-firebase

3.check Not right now and create project

4.click on setting icon-->click on android icon fil details

       * android app name="Your App Name"
       
       * SHA1="YOur SHA"
       
       * click on register app
       
       * leave optinal field
       
       * then download the google_services.json file  
       
       * leave steps for adding the sdk
       
       * click next

  




