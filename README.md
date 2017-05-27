# MFMIS

Manila Fame Android App (Final Push for Github)

An android app prototype developed during my internship in CITEM.

Developed using Android Studio 2.2.3. Other details below:

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 24
        buildToolsVersion '25.0.2'
        defaultConfig {
            applicationId "com.example.smdojt.manilafame"
            minSdkVersion 19
            targetSdkVersion 24
            versionCode 1
            versionName "1.0"
            testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            }
        }
    }

    dependencies {
        compile fileTree(include: ['*.jar'], dir: 'libs')
        androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
            exclude group: 'com.android.support', module: 'support-annotations'
        })

        compile 'com.android.support:appcompat-v7:24.2.1'
        compile 'com.android.support:design:24.2.1'
        compile 'com.android.support:support-v4:24.2.1'
        compile 'com.prolificinteractive:material-calendarview:1.4.2'
        compile 'com.android.support:cardview-v7:24.2.1'
        compile 'com.android.support:recyclerview-v7:24.2.1'
        compile 'de.hdodenhof:circleimageview:2.1.0'
        compile 'com.android.volley:volley:1.0.0'
        compile 'com.github.bumptech.glide:glide:3.7.0'
        compile 'com.github.chrisbanes:Photoview:1.3.1'
        compile 'com.jakewharton:butterknife:8.5.1'
        compile 'com.github.sundeepk:compact-calendar-view:1.9.9'
        compile 'me.dm7.barcodescanner:zxing:1.8.4'
        compile 'com.android.support.constraint:constraint-layout:1.0.2'
        compile 'com.intuit.sdp:sdp-android:1.0.4'
        testCompile 'junit:junit:4.12'
    }

Above are the versions needed for the app to properly. For the database part of the app, you will need to pull my php and mysql files in my other repositories.

