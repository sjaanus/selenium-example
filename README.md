# Test-assignment
An example project of Selenium and Java using ChromeWebDriver (current project uses Google Chrome version 105.0.5195.102, if needed update ChromeWebDriver).


## Prerequisites for running on Mac

* Have IntelliJ IDEA (or any other IDE)
* Have [Java 1.8 JDK](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) installed
* Have [Xcode](https://apps.apple.com/us/app/xcode/id497799835?mt=12) installed
* Have [Homebrew](https://brew.sh/) installed
* Have [Maven](https://mkyong.com/maven/install-maven-on-mac-osx/) installed
* Have [Allure](https://formulae.brew.sh/formula/allure) installed


## Execute automation tests ##

```bash
mvn clean test
```

## Check test results ##
```bash
allure serve target/allure-results
```
