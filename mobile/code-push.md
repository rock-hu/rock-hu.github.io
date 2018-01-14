## Code Push   

###

https://mobile.azure.com/login?original_url=/cli-login?hostname=DESKTOP-HA6O8MH

```bash
D:\Workspace\ReactNativeApp>code-push register
Please login to Mobile Center in the browser window we've just opened.

Enter your token from the browser:  

Successfully logged-in. Your session file was written to C:\Users\cchu1\AppData\Local\.code-push.config. You can run the code-push logout command at any time to delete this file and terminate your session.

```

```bash
D:\Workspace\ReactNativeApp>code-push app add ReactNativeApp-android android react-native
Successfully added the "ReactNativeApp-android" app, along with the following default deployments:
┌────────────┬──────────────────────────────────────────────────────────── ──────┐
│ Name       │ Deployment Key                                                   │
├────────────┼──────────────────────────────────────────────────────────── ──────┤
│ Production │ 5PtSNDnBcE8Dy_aPVk4Jr5AqmSd2039c155d-d1e7-4db4-9560-13007cfee637 │
├────────────┼──────────────────────────────────────────────────────────── ──────┤
│ Staging    │ s6sbMXHG-iJViYYHi_S8wfX4oDzw039c155d-d1e7-4db4-9560-13007cfee637 │
└────────────┴──────────────────────────────────────────────────────────── ──────┘
```



### Deploy code-push-server	
https://github.com/lisong/code-push-server	

ubuntu@ip-172-31-31-226:/ebs/codepush/code-push-server-0.2.19$ ./bin/db init --dbhost localhost --dbuser root --dbpassword pwdhere
success.
ubuntu@ip-172-31-31-226:/ebs/codepush/code-push-server-0.2.19$ npm start

> code-push-server@0.2.19 start /ebs/codepush/code-push-server-0.2.19
> node ./bin/www

[2017-06-23 16:58:51.463] [INFO] cps:config - use config file /ebs/codepush/code-push-server-0.2.19/config/config.js
[2017-06-23 16:58:51.466] [INFO] cps:config - use env development
[2017-06-23 16:58:52.327] [INFO] startup - Listening on port 3000


```bash
mysql> show tables;
+----------------------+
| Tables_in_codepush   |
+----------------------+
| apps                 |
| collaborators        |
| deployments          |
| deployments_history  |
| deployments_versions |
| packages             |
| packages_diff        |
| packages_metrics     |
| user_tokens          |
| users                |
| versions             |
+----------------------+
11 rows in set (0.00 sec)
```



```bash 
npm install code-push-cli
D:\Workspace\ReactNativeApp>code-push login http://ec2-52-76-22-128.ap-southeast-1.compute.amazonaws.com:3000
Please login to Mobile Center in the browser window we've just opened.

Enter your token from the browser:  77lloA9e8YX3rs0f3kbRldtqLoXD4ksvOXqog

Successfully logged-in. Your session file was written to C:\Users\cchu1\AppData\Local\.code-push.config. You can run the code-push logout command at any time to delete this file and terminate your session.

```

### Command 
code-push login 登陆  
code-push loout 注销  
code-push access-key ls 列出登陆的token  
code-push access-key rm <accessKye> 删除某个 access-key 
code-push app add在账号里面添加一个新的app 
code-push app remove或者 rm 在账号里移除一个app   
code-push app rename重命名一个存在app  
code-push app list或则 ls 列出账号下面的所有app    
code-push app transfer把app的所有权转移到另外一个账号 
code-push deployment ls 您的应用名 -k    

### 项目中安装react-native-code-push插件   
https://github.com/Microsoft/react-native-code-push#getting-started 
```bash
npm i -g rnpm
npm install --save react-native-code-push   
rnpm link react-native-code-push    
```


```
* code-push release-react 发布更新
```bash
code-push release-react ReactNativeApp-android android -d Staging
code-push release-react ReactNativeApp-android android -d Production

D:\Workspace\ReactNativeApp>code-push release-react ReactNativeApp-android android
Detecting android app version:

Using the target binary version value "1.0" from "android\app\build.gradle".

Running "react-native bundle" command:

node node_modules\react-native\local-cli\cli.js bundle --assets-dest C:\Users\cchu1\AppData\Local\Temp\CodePush --bundle-output C:\Users\cchu1\AppData\Local\Temp\CodePush\index.android.bundle --dev false --entry-file index.android.js --platform android
Scanning 645 folders for symlinks in D:\Workspace\ReactNativeApp\node_modules (66ms)
Scanning 645 folders for symlinks in D:\Workspace\ReactNativeApp\node_modules (60ms)
Loading dependency graph, done.
bundle: start
bundle: finish
bundle: Writing bundle output to: C:\Users\cchu1\AppData\Local\Temp\CodePush\index.android.bundle
bundle: Done writing bundle output

Releasing update contents to CodePush:

Upload progress:[==================================================] 100% 0.0s
Successfully released an update containing the "C:\Users\cchu1\AppData\Local\Temp\CodePush" directory to the "Staging" deployment of the "ReactNativeApp-android" app.

```
* code-push release 发布更新   
code-push release发布更新呢我们首先需要将js与图片资源进行打包成 bundle。  
第一步： 在 工程目录里面新增 bundles文件：mkdir bundles 
第二步： 运行命令打包 react-native bundle --platform 平台 --entry-file 启动文件 --bundle-output 打包js输出文件 --assets-dest 资源输出目录 --dev 是否调试    

* 查看部署App     
```bash
D:\Workspace\ReactNativeApp>code-push deployment ls ReactNativeApp-android
┌────────────┬───────────────────────────────────┬──────────────────────┐
│ Name       │ Update Metadata                   │ Install Metrics      │
├────────────┼───────────────────────────────────┼──────────────────────┤
│ Production │ No updates released               │ No installs recorded │
├────────────┼───────────────────────────────────┼──────────────────────┤
│ Staging    │ Label: v1                         │ Active: 0% (0 of 0)  │
│            │ App Version: 1.0                  │ Total: 0             │
│            │ Mandatory: No                     │                      │
│            │ Release Time: 16 minutes ago      │                      │
│            │ Released By: lisong2010@gmail.com │                      │
└────────────┴───────────────────────────────────┴──────────────────────┘

```
* 查看历史版本    
```bash
D:\Workspace\ReactNativeApp>code-push deployment history ReactNativeApp-android Staging
┌───────┬────────────────┬─────────────┬───────────┬─────────────┬───────── ────────────┐
│ Label │ Release Time   │ App Version │ Mandatory │ Description │ Install Metrics     │
├───────┼────────────────┼─────────────┼───────────┼─────────────┼───────── ────────────┤
│ v1    │ 17 minutes ago │ 1.0         │ No        │             │ Active: 0% (0 of 0) │
│       │                │             │           │             │ Total: 0            │
└───────┴────────────────┴─────────────┴───────────┴─────────────┴───────── ────────────┘
```
