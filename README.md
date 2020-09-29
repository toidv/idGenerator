# idGenerator
Random id generator in Kotlin that motivation from https://github.com/auth0/id-generator

# How to use

####  Step 1. Add the JitPack repository to your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

#### Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.toidv:idGenerator:v0.0.1'
}
```