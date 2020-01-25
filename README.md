<img src="https://raw.githubusercontent.com/bsobe/text-spacer/master/images/text-spacer-example.png" width="240"/>

[![](https://jitpack.io/v/bsobe/text-spacer.svg)](https://jitpack.io/#bsobe/text-spacer) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Text Spacer
Text Spacer is easy way of the adding space on TextView.

# Usage
```kotlin
    val textViewCreditCardNumber = findViewById<TextView>(R.id.textViewCreditCardNumber)
    Spacer.Builder()
        .setPatternSequentially(4)
        .attach(textViewCreditCardNumber)


    val textViewPhoneNumber = findViewById<TextView>(R.id.textViewPhoneNumber)
    Spacer.Builder()
        .setPattern("#${SPACE}###${SPACE}###${SPACE}##${SPACE}##${SPACE}")
        .attach(textViewPhoneNumber)


    val textViewExample = findViewById<TextView>(R.id.textViewExample)
    Spacer.Builder()
        .addSpaceIndexAt(2)
        .addSpaceIndexAt(7)
        .addSpaceIndexAt(12)
        .attach(textViewExample)
```

# Installation
 - To implement **Text Spacer** to your Android project via Gradle, you need to add JitPack repository to your root build.gradle.
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
 - After adding JitPack repository, you can add **Text Spacer** dependency to your app level build.gradle.
```gradle
dependencies {
    implementation "com.github.bsobe:text-spacer:$last-version"
}
```

License
--------
    Copyright 2019 bsobe / Barış Söbe

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
