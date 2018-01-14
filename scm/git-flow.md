## Gitflow  
https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow    
The Gitflow Workflow defines a strict branching model designed around the project release. This provides a robust framework for managing larger projects.  

How it works

![Develop Branches](http://nvie.com/img/git-model@2x.png)

* master
* develop
* features/*
* hotfix/*
* release/*

The overall flow of Gitflow is:

1. A develop branch is created from master
2. A release branch is created from develop
3. Feature branches are created from develop
4. When a feature is complete it is merged into the develop branch
5. When the release branch is done it is merged into develop and master
6. If an issue in master is detected a hotfix branch is created from master
7. Once the hotfix is complete it is merged to both develop and master

A successful Git branching model    
http://nvie.com/posts/a-successful-git-branching-model/

### Master Branches 
We consider origin/master to be the main branch where the source code of HEAD always reflects a production-ready state. 
### Develop Branches 
We consider origin/develop to be the main branch where the source code of HEAD always reflects a state with the latest delivered development changes for the next release. Some would call this the “integration branch”. This is where any automatic nightly builds are built from.    
![Develop Branches](http://nvie.com/img/main-branches@2x.png)


### Feature Branches    
May branch off from:    
develop 
Must merge back into:   
develop 
Branch naming convention:   
anything except master, develop, release-*, or hotfix-* 
![Feature branches](http://nvie.com/img/fb@2x.png)

* Creating a feature branch   
```bash
git checkout develop
git checkout -b features/account-information
```
* Finishing a feature branch  
merge featues into develop  

### Release Branches    
May branch off from:    
develop 
Must merge back into:   
develop and master  
Branch naming convention:   
release-*   
![Feature branches](http://nvie.com/img/fb@2x.png)
![Feature branches merge](http://nvie.com/img/merge-without-ff@2x.png)

### Hotfix Branches 
May branch off from:    
master  
Must merge back into:   
develop and master  
Branch naming convention:   
hotfix-*    
![Hotfix branches](http://nvie.com/img/hotfix-branches@2x.png)