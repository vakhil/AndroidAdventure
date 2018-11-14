# NewsGetter App

This is a simple app written for getting news from various internet sources and show them at one place. Get all your news from NDTV.com in your hand by just a single click.

Some important libraries have been used to make this app.

## CircleImageView

Using the library at this [link](https://github.com/hdodenhof/CircleImageView), I have created the thumbnail of the news article which I will be displaying. You can make round circle objects yourself but this kind of makes it easier. My viewholder in Recycler View is basically a circleImageView along with some Text.

## JSoup HTML Parser

Since I needed to parse HTML data from the websites, I did it using JSoup HTML Parser. This allowed me to find all thumbails with a particular div name. Since, it is a netWork call, we need to make this in a new thread and not the main UI Thread.

## Regarding the UI 
You can make buttons of your choice and gradient backgrounds in drawable. For making a attractive button, you can create a drawable file called rounded_button.xml and then write this code

```<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/btColot"/>
    <corners android:radius="150dp"/>

</shape>
```

Then create a button in main layout and set the background of the button to be drawable/rounded_button.

Check out some cool gradients and button making [here](https://android.jlelse.eu/android-shape-drawables-tutorial-17fbece6fef5)