## HockeyApp    
https://www.hockeyapp.net/	
```bash
code-push release-react ReactNativeApp-android android
code-push deployment ls ReactNativeApp
cd android
gradle tasks
gradle clean
gradle assembleRelease -S
gradle publishApkRelease
gradle uploadReleaseToHockeyApp
```bash
