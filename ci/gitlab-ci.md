## .gitlab-ci.yml

GitLab offers a continuous integration service. If you
add a .gitlab-ci.yml file to the root directory of your repository,
and configure your GitLab project to use a Runner, then each commit or
push, triggers your CI pipeline.

The .gitlab-ci.yml file tells the GitLab runner what to do. By default it runs
a pipeline with three stages: build, test, and deploy. You don't need to
use all three stages; stages with no jobs are simply ignored.

So in brief, the steps needed to have a working CI can be summed up to: 
1. Add .gitlab-ci.yml to the root directory of your repository 
2. Configure a Runner  

https://gitlab.com/help/ci/yaml/README  
https://gitlab.com/help/ci/quick_start/README.md    
Setting up GitLab CI for Android projects   
https://about.gitlab.com/2016/11/30/setting-up-gitlab-ci-for-android-projects/  
Setting up GitLab CI for iOS projects   
https://about.gitlab.com/2016/03/10/setting-up-gitlab-ci-for-ios-projects/  
