# net.cactusthorn.utils

One more Java library with trivial static utilities.

## Checkstyle configuration
1. maven goal: **checkstyle:check**
2. Based on "standard" **sun_checks.xml**
3. To comment out:
```
<module name="JavadocMethod"/>
<module name="JavadocType"/>
<module name="JavadocVariable"/>
<module name="JavadocStyle"/>
<module name="AvoidNestedBlocks"/>
<module name="HideUtilityClassConstructor"/>
<module name="FinalParameters"/>
<module name="AvoidInlineConditionals"/>
```
4. To modify:
```
<module name="LineLength">
  <property name="max" value="140"/>
</module>
<module name="HiddenField">
  <property name="ignoreConstructorParameter" value="true"/>
  <property name="ignoreSetter" value="true"/>
</module>
```
5. https://stackoverflow.com/questions/4023185/how-to-disable-a-particular-checkstyle-rule-for-a-particular-line-of-code

## Jenkins
Declarative pipeline stage example with SSH (required "SSH Pipeline Steps" Plugin)
```
stage('Copy Jar') {
  steps {
    withCredentials([sshUserPrivateKey(credentialsId: 'some-cr-id', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'userName')]) {
      script {
        def remote = [:]
        remote.name = "myhost.net"
        remote.host = "myhost.net"
        remote.port = 5022
        remote.allowAnyHosts = true
        remote.user = userName
        remote.identity = identity

        sshPut remote: remote, from: 'target/*.jar', into: '.'
      }
    }
  }
}
```

## License
Released under the BSD 2-Clause License
```
Copyright (C) 2017, Alexei Khatskevich
All rights reserved.

Licensed under the BSD 2-clause (Simplified) License (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://opensource.org/licenses/BSD-2-Clause
```