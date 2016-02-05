# AndroidPhotoExtract

## What is it?

It's an Android library that lets the user pick a photo from somewhere on the device and returns all kinds of information to the user.

## Why do you need a library to do that?

Because depending on which app the user used to pick a photo, the information returned will be different. Dealing with that in your app is a real pain! This library abstracts over all that, and tries to return the information in a standard format.

## How do I install it?

Grab the library from this repository.

Note you will need android.permission.READ_EXTERNAL_STORAGE permission. If you are using optional permission (targetting Android 6 and above) you will need to make sure you have obtained this permission from the user first.

## How do I use it?

See the "app" module, which is an example app. In the MainActivity you will see the 4 basic steps:

  *  Set up a request object with what you want back, get the intent, start it.
  *  Get back the intent result. Start a background process to get the data you wanted.
  *  In this background process call the library, which does all the processing.
  *  Get the data you wanted back!

Note you must ensure the processing is called in a background thread as has been done in the demo app.

## What is it's current status?

Early days.

## When will you declare version 1?

When we are happy with the internal API. From version 1 onwards, semantic versioning will apply.

Until version 1 is produced, we reserve the rights to mess around with the internal API as much as we want.

## FAQ

### Sometimes I get back more data than I ask for

This is because to get the data you did ask for we need more information. For example, to get a thumbnail we need to check the orientation in the EXIF data - so we will load the EXIF data to even if you didn't explicitly ask for it.


## Misc

Post any suggestions in the issue tracker at https://github.com/JMB-Technology-Limited/AndroidPhotoExtract or email the address you find on http://jmbtechnology.co.uk/

