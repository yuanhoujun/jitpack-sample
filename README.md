JitPack是发布JVM或Android库最简单的方式，这个库主要用于演示整个操作流程。

### a）确保本地代码运行正常
Android端可以使用如下命令测试本地代码是否运行正常：

```
MacOS:
./gradlew assembleDebug

Windows:
gradlew.bat assembleDebug
```

### b）在项目根目录的build.gradle文件中添加maven插件依赖

```
classpath 'com.github.dcendents:android-maven-gradle-plugin:2.0'

```

### c）在需要上传的库工程中添加aar包组ID

```
group='com.github.yuanhoujun'
```

按照JitPack的约定，组ID由Github域名加你的用户名组成。因此，你只需要将这里的yuanhoujun修改为你的Github账户名称即可。

### d）提交代码，标记Tag，并推送到远程

```
git add xxx
git commit -m xxx
git tag 1.0.0
git push origin master --tags
```

### e）使用Github账号登录JitPack，按照下图操作
![](https://raw.githubusercontent.com/yuanhoujun/jitpack-sample/master/images/jitpack.png)

点击Get it会直接进入构建阶段，等待构建完成后，确保第二处位置的图标显示为绿色，即表示构建成功。如果显示为构建失败，点击图标查看失败原因。
请修改后尝试再次构建。

### f）以上操作完成后，就可以在你的其它工程使用maven依赖引用了。
本篇例子引用方式如下：

1）增加JitPack库链接到你的根目录build.gradle文件中

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2）在你的主工程中添加如下依赖

```
dependencies {
	  compile 'com.github.yuanhoujun:jitpack-sample:1.0.0'
}
```

3）尝试调用库工程API，测试工作是否正常

```
 JitPack.get().pack();
```