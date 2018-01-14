## HockeyApp    
### Register & Logon 
https://hockeyapp.net/  

### Create API Token for mobile app  
Profile->Account Settings->API Tokens->Create API Token 
https://rink.hockeyapp.net/manage/auth_tokens   

### HockeyApp Gradel Plugin 
app/build.gradle    
```
apply plugin: 'de.felixschulze.gradle.hockeyapp'

dependencies {
    compile "net.hockeyapp.android:HockeySDK:4.1.5"
}    

// https://github.com/x2on/gradle-hockeyapp-plugin
hockeyapp {
    apiToken = "772edddf203449a6b2e1f4f96ac88d89"
    // releaseType: 0 beta, 1 live, 2 alpha, 3 enterprise
    releaseType = 3 // alpha
    // 0 not notify testers, 1 notify all testers that can install this app
    notify = 1
    // 1 not allow users to download the version, 2 make the version available for download
    status = 2
    // 0 Textile, 1 Markdown
    notesType = 1
    notes = new File(file('../../README.md').absolutePath).getText('UTF-8')
}

```
build.gradle
```
buildscript {
    dependencies {
        classpath 'de.felixschulze.gradle:gradle-hockeyapp-plugin:3.6'        
    }
}
```