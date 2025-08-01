# Janitri-automation
Login Page Automation Framework
# 🔐 Login Page Automation Framework | Java + Selenium + TestNG

This project is a simple and scalable automation framework designed to test the login functionality of [Janitri Dashboard](https://dev-dash.janitri.in/) using Selenium WebDriver, Java, and TestNG.

---

## 📂 Project Structure

Janitri/
├── .idea/                      # IntelliJ project settings (optional to share)
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   ├── test/
│   │   └── java/
│   │       └── org.example/
│   │           ├── page/
│   │           │   └── LoginPage.java       # Page Object class for Login functionality
│   │           └── runnerfile/
│   │               └── basetest/
│   │                   └── BaseTest.java    # TestNG test class with test cases
├── target/                    # Compiled classes and test reports (auto-generated)
├── .gitignore                 # To ignore target/, .idea/, etc.
├── pom.xml                    # Maven configuration file with dependencies
└── testng.xml                 # TestNG suite configuration

---

## 🔧 Tech Stack

- **Language:** Java  
- **Testing Framework:** TestNG  
- **Automation Tool:** Selenium WebDriver  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Browser:** Chrome with ChromeOptions

---

## 🧪 Features Covered

- ✅ Login button is disabled when fields are empty  
- ✅ Password visibility toggle (mask/unmask)  
- ✅ Error message shown for invalid login  
- ✅ Verification of page elements on the login screen  
- ✅ Implicit waits for element loading

---
✅ 2 PASSED Test Cases
We'll keep these two as passed:
1. Test Password Masked button
2. Test Validate Presence Of Page Elements

❌ 2 FAILED Test Cases
We'll intentionally fail these:

1. Test Login Button Disabled When Field Are Empty
2. Test Invalid Login Show Error Msg
