## GCP	

### SSH Remote Logon	
```bash
ssh rock_c_c_hu@35.201.255.176
```

### Install JDK/Maven	
```bash
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install maven
sudo apt-get install ant
```

### Install GCloud SDK Cli 		
```bash
gcloud components install app-engine-go cbt bigtable datalab cloud-datastore-emulator alpha beta app-engine-java 
gcloud components install  gcd-emulator  pubsub-emulator emulator-reverse-proxy container-builder-local docker-credential-gcr kubectl
```


### Install Jenkins		
https://wiki.jenkins.io/display/JENKINS/Installing+Jenkins+on+Ubuntu
```bash
wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins
sudo /etc/init.d/jenkins status
```


### Jenkins Pipeline	
https://wiki.jenkins.io/display/JENKINS/Pipeline+Plugin	
https://jenkins.io/solutions/pipeline/	
https://github.com/jenkinsci/pipeline-plugin/blob/master/TUTORIAL.md 	

### Spring boot memory performance 	
```
rock_c_c_hu@gcp-master:~$ smem
  PID User     Command                         Swap      USS      PSS      RSS 
31911 rock_c_c_hu -bash                              0     3564     3708     5776 
 3146 rock_c_c_hu /usr/bin/python /usr/bin/sm        0     6428     6604     8732 
10109 rock_c_c_hu java -jar spring-cloud-netf        0   195772   196958   204680 
10106 rock_c_c_hu java -jar spring-cloud-netf        0   204484   205663   213352 
10107 rock_c_c_hu java -jar spring-cloud-netf        0   258560   259754   267480 
10102 rock_c_c_hu java -jar spring-cloud-netf        0   366668   367877   375716 
10108 rock_c_c_hu java -jar spring-cloud-netf        0   430944   432197   440028 
```

### java -X
```
rockhu@rockhu-ThinkPad-X201:/develop/repo/spring-cloud-netflix-oss$ java -X
    -Xmixed           mixed mode execution (default)
    -Xint             interpreted mode execution only
    -Xbootclasspath:<directories and zip/jar files separated by :>
                      set search path for bootstrap classes and resources
    -Xbootclasspath/a:<directories and zip/jar files separated by :>
                      append to end of bootstrap class path
    -Xbootclasspath/p:<directories and zip/jar files separated by :>
                      prepend in front of bootstrap class path
    -Xdiag            show additional diagnostic messages
    -Xnoclassgc       disable class garbage collection
    -Xincgc           enable incremental garbage collection
    -Xloggc:<file>    log GC status to a file with time stamps
    -Xbatch           disable background compilation
    -Xms<size>        set initial Java heap size
    -Xmx<size>        set maximum Java heap size
    -Xss<size>        set java thread stack size
    -Xprof            output cpu profiling data
    -Xfuture          enable strictest checks, anticipating future default
    -Xrs              reduce use of OS signals by Java/VM (see documentation)
    -Xcheck:jni       perform additional checks for JNI functions
    -Xshare:off       do not attempt to use shared class data
    -Xshare:auto      use shared class data if possible (default)
    -Xshare:on        require using shared class data, otherwise fail.
    -XshowSettings    show all settings and continue
    -XshowSettings:all
                      show all settings and continue
    -XshowSettings:vm show all vm related settings and continue
    -XshowSettings:properties
                      show all property settings and continue
    -XshowSettings:locale
                      show all locale related settings and continue

The -X options are non-standard and subject to change without notice.
```

### java -XX:+PrintFlagsFinal 	
```
java -XX:+PrintFlagsFinal -version | grep Xm
```



```
./mvn.sh clean package
chmod 755 *.sh
export SPRING_BOOT_APPS_BASE_PATH=/develop/repo/spring-cloud-netflix-oss/apps
source ./java-env.sh
./deployment-local.sh

```











### daemonize — A tool to run a command as a daemon 	
http://software.clapper.org/daemonize/ 	




```
ps aux | grep -ie spring-boot | awk '{print $2}' | xargs echo 
ps aux | grep -ie spring-boot | awk '{print $2}' | xargs kill -9 
```