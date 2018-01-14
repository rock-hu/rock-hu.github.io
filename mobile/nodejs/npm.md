## NodeJS

## NPM

```
npm config set registry https://registry.npm.taobao.org
npm config set registry https://registry.npmjs.org
```

```
npm i --save-dev prettier
npm i --save redux-thunk
```
package.json
```json
{
  "name": "ReactNativeUniversal",
  "version": "0.0.1",
  "private": true,
  "main": "main.electron.js",
  "description": "A better way to develop React Native app",
  "homepage": "./",
  "scripts": {
    "start": "node node_modules/react-native/local-cli/cli.js start",
    "android:bundle": "react-native bundle --verbose --platform android --dev false --entry-file index.android.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/",
    "android:install-debug": "npm run android:bundle && cd android && ./gradlew clean installDebug --stacktrace"
  },
  "dependencies": {
    "react-native": "^0.50.3"
  },
  "devDependencies": {
    "autoprefixer": "^7.1.6"
  },
  "jest": {
    "preset": "react-native"
  }
}

```