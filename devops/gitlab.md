
https://gitlab.com/gitlab-org/gitlab-ci-yml	

* 定制化的部署jobs；
* 能够在Metal、VM和Docker images运行jobs；
* 能够每次在同一个台机器上运行（例如性能测试）；
* 能够运行在特殊的架构上（例如一个Raspberry Pi 2）；
* 能够运行在特殊地方或特定证书的机器上；
* 支持简单和浅显的YAML文件的语法；
* 命名jobs，实现轻易地辨别。

## GitLab CI Lint Tool
https://gitlab.com/ci/lint	
https://doc.gitlab.cc/ce/ci/yaml/README.html    

## Docker image
https://hub.docker.com/r/library/	

## GitLab Continuous Integration (GitLab CI) 
http://docs.gitlab.com/ce/ci/	

## GitLab Pages
http://docs.gitlab.com/ce/user/project/pages/index.html
https://about.gitlab.com/features/pages/


## Setting up GitLab CI for iOS projects
https://about.gitlab.com/2016/03/10/setting-up-gitlab-ci-for-ios-projects/	
## Setting up GitLab CI for Android projects	
https://about.gitlab.com/2016/11/30/setting-up-gitlab-ci-for-android-projects/	

## GitBook site using GitLab Pages	
https://gitlab.com/groups/pages 
https://gitlab.com/gitlab-com/gitlab-docs/pipelines 
https://gitlab.com/pages/gitbook	

GitLab Installation 
https://about.gitlab.com/installation/  
GitLab Our Application Partners 
https://about.gitlab.com/applications/   

```
+------------------+           +----------------+
|                  |  trigger  |                |
|   Commit / MR    +---------->+    Pipeline    |
|                  |           |                |
+------------------+           +----------------+
```
```
+--------------------------------------------------------+
|                                                        |
|  Pipeline                                              |
|                                                        |
|  +-----------+     +------------+      +------------+  |
|  |  Stage 1  |---->|   Stage 2  |----->|   Stage 3  |  |
|  +-----------+     +------------+      +------------+  |
|                                                        |
+--------------------------------------------------------+

```

```
+------------------------------------------+
|                                          |
|  Stage 1                                 |
|                                          |
|  +---------+  +---------+  +---------+   |
|  |  Job 1  |  |  Job 2  |  |  Job 3  |   |
|  +---------+  +---------+  +---------+   |
|                                          |
+------------------------------------------+
```
