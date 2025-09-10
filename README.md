# 🚀 Flipkart Automation Testing Framework

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Coverage](https://img.shields.io/badge/coverage-90%25-yellowgreen)

---

## 📖 Project Description

Automates testing of the Flipkart e-commerce website using **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**, employing the **Page Object Model (POM)** design pattern.  
This framework delivers maintainable, scalable, and robust automation for critical Flipkart flows.

---

## 🏗️ Architecture Overview


<img width="301" height="811" alt="Screenshot 2025-08-31 103859" src="https://github.com/user-attachments/assets/e33a0559-1177-47e0-998e-8820d2b92e25" />


## ✅ Test Case Coverage

### 🔐 Login Module
- Valid login with phone number and password/OTP
- Invalid phone number login attempt
- Verification of Login UI elements for presence and functionality

### 🔎 Product Search & Details
- Searching for electronic items
- Applying filters: RAM size, brand, price range
- Sorting results by popularity or price
- Viewing product details and verifying specifications
- Handling searches without keywords

### 🛒 Cart & Checkout
- Adding products to cart
- Modifying quantity, verifying updates
- Removing items and confirming removal
- Proceeding to buy and verifying address/payment pages
- Attempting to place order without selecting address/payment methods

---

## 🛠 Technology Stack

- Java 1.8+
- Maven
- Selenium WebDriver
- TestNG
- ExtentReports
- Chrome, Firefox, Edge Browsers
1. Clone the repository:  
git clone https://github.com/MONDALaritra/Flipkart-Automation-Testing-Project.git

text
2. Navigate to the project folder and install dependencies:  
mvn clean install

text
3. Configure WebDriver executables in the `config/` directory or update your system PATH variables.
4. Run the tests using the TestNG suite:  
mvn test -DsuiteXmlFile=testng.xml

text

---

## 🚦 How to Use

- Modify `testng.xml` to select/deselect test scenarios.
- View test reports and logs in the `test-output/` folder.
- Utilize Excel files or config properties for data-driven testing.

---

## 📊 Reporting

- Generates HTML reports through ExtentReports.
- Takes screenshots automatically on test failures.
- Comprehensive logs generated for every test run.
- EmailableReport
  
<img width="1920" height="1080" alt="Screenshot 2025-08-30 084701" src="https://github.com/user-attachments/assets/2d1404d7-126b-466e-859c-94de58c3b289" />


- ExtentReport

<img width="1919" height="929" alt="Screenshot 2025-09-05 122520" src="https://github.com/user-attachments/assets/59dd84a4-195d-4f58-ae11-c699db5a6453" />

<img width="1908" height="926" alt="Screenshot 2025-09-06 095939" src="https://github.com/user-attachments/assets/d7cb9ea2-43db-4b79-8f13-2ad5f064cbf7" />




