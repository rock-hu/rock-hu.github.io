
## code-push    
https://docs.microsoft.com/en-us/appcenter/distribution/codepush/react-native   
https://github.com/Microsoft/code-push  
### npm install -g code-push-cli  
```bash
npm install -g code-push-cli
```
### Create a CodePush account
```bash
code-push register
01243bbad2c11b15caebb8323bc07fa13259fa2a
```
```bash
rock@rock-HP-ProBook-4341s:/develop/repo/ReactNativeUniversal$ code-push register
Please login to Mobile Center in the browser window we've just opened.
Enter your token from the browser:  01243bbad2c11b15caebb8323bc07fa13259fa2a
Successfully logged-in. Your session file was written to /home/rock/.code-push.config. You can run the code-push logout command at any time to delete this file and terminate your session.
```
.code-push.config   
```bash
rock@rock-HP-ProBook-4341s:/develop/repo/ReactNativeUniversal$ cat /home/rock/.code-push.config
```
### Register your app with the service  
```bash
code-push app add ReactNativeUniversal-iOS ios react-native
code-push app add ReactNativeUniversal-android android react-native
```
```bash
rock@rock-HP-ProBook-4341s:/develop/repo/ReactNativeUniversal$ code-push app add ReactNativeUniversal-iOS ios react-native
Successfully added the "ReactNativeUniversal-iOS" app, along with the following default deployments:
┌────────────┬──────────────────────────────────────────────────────────────────┐
│ Name       │ Deployment Key                                                   │
├────────────┼──────────────────────────────────────────────────────────────────┤
│ Production │ DscRw5Dheywmev0oB1vtvuDCgBNa039c155d-d1e7-4db4-9560-13007cfee637 │
├────────────┼──────────────────────────────────────────────────────────────────┤
│ Staging    │ QbC_GYXwiX0wefRJiPzvqxcNbpgZ039c155d-d1e7-4db4-9560-13007cfee637 │
└────────────┴──────────────────────────────────────────────────────────────────┘
```
```bash
rock@rock-HP-ProBook-4341s:/develop/repo/ReactNativeUniversal$ code-push app add ReactNativeUniversal-android android react-native
Successfully added the "ReactNativeUniversal-android" app, along with the following default deployments:
┌────────────┬──────────────────────────────────────────────────────────────────┐
│ Name       │ Deployment Key                                                   │
├────────────┼──────────────────────────────────────────────────────────────────┤
│ Production │ Kd8k5iDve4Cl85lvJoyht9QLUulf039c155d-d1e7-4db4-9560-13007cfee637 │
├────────────┼──────────────────────────────────────────────────────────────────┤
│ Staging    │ Ag70oE84gbcWM-1ln0ZfB7sSLHB5039c155d-d1e7-4db4-9560-13007cfee637 │
└────────────┴──────────────────────────────────────────────────────────────────┘

```
## Code-Push Commands
### code-push into app  
```bash
npm install --save react-native-code-push   
npm link react-native-code-push
```
### code-push release-react
```bash
code-push release-react ReactNativeUniversal-android android
```
### code-push deployment ls
```bash
code-push deployment ls ReactNativeUniversal-android
```
### code-push deployment history  
```bash
code-push deployment history ReactNativeUniversal-android Staging
```
