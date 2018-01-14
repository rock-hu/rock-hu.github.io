aliyun instances:   
39.108.224.69/172.18.244.167    
39.108.230.117/172.18.244.168   

http://upload-images.jianshu.io/upload_images/5776456-f31a0535f4c2b479.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240


scp .ssh/id_rsa.pub rockhu@39.108.224.69:/home/rockhu/id_rsa-x201.pub
scp .ssh/id_rsa.pub rockhu@39.108.230.117:/home/rockhu/id_rsa-x201.pub

ssh rockhu@39.108.224.69
ssh rockhu@39.108.230.117


## aliyun
```bash
sudo apt-get install python-pip
pip install --upgrade pip
pip -V
sudo pip install --upgrade aliyun-python-sdk-ecs
sudo pip install --upgrade aliyuncli
sudo pip install --upgrade aliyun-python-sdk-aas
sudo pip install --upgrade aliyun-python-sdk-cdn
sudo pip install --upgrade aliyun-python-sdk-ram
```

aliyuncli ecs help	
```bash
aliyuncli ecs help
```

### 阿里云 Python SDK 列表	
https://help.aliyun.com/document_detail/30003.html?spm=5176.doc43103.6.558.Ff6Gcs 	
