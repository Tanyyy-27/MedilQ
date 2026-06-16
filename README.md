```md
<div align="center">

<img src="./assets/medilq-logo.svg" alt="MedilQ Logo" width="140"/>

# MedilQ

### Intelligent Medical Store Inventory Management System

**Smart Inventory • Supplier Management • Stock Tracking • Purchase Analytics**

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![MIT License](https://img.shields.io/badge/License-MIT-success?style=for-the-badge)

---

### Modernizing Pharmacy Operations Through Intelligent Inventory Management

*A scalable inventory management solution designed to simplify medicine tracking, supplier management, stock monitoring, and purchase reporting.*

</div>

---

# 📖 Overview

MedilQ is a modern **Medical Store Inventory Management System** developed to streamline pharmacy operations through intelligent inventory tracking, supplier management, and organized purchase reporting.

The application provides a centralized platform for maintaining medicine records, monitoring stock availability, managing supplier information, and generating daily purchase reports. Built with **Java, MySQL, HTML, CSS, and JavaScript**, MedilQ demonstrates modular software architecture, CRUD operations, and efficient relational database design.

Whether it's a small pharmacy or a growing medical store, MedilQ helps reduce manual work, improve inventory accuracy, and enhance operational efficiency.

---

# ✨ Key Highlights

- 📦 Smart Medicine Inventory Management
- 🤝 Supplier & Vendor Management
- 📊 Real-Time Stock Monitoring
- 🔍 Fast Search & Record Management
- 🗄️ MySQL Database Integration
- ⚙️ Modular Java Architecture
- 🚀 Clean & Scalable Project Structure
- 💼 Business-Oriented Workflow

---

# 💼 Business Challenge

Traditional medical stores often rely on manual inventory systems that can lead to:

- Medicine stock inconsistencies
- Time-consuming supplier management
- Delayed purchase tracking
- Duplicate inventory records
- Increased operational errors

MedilQ digitizes the complete workflow by providing a centralized and structured inventory management system that improves business productivity and data accuracy.

---

# 🌟 Features

| Module | Description |
|-----------------------------|-----------------------------------------------------------|
| 📦 Medicine Management | Add, update, delete and search medicine records |
| 📊 Inventory Control | Monitor stock availability and inventory status |
| 🤝 Supplier Management | Maintain supplier information and medicine mapping |
| 📈 Purchase Reports | Generate organized daily purchase reports |
| 🔍 Smart Search | Quickly locate medicines and suppliers |
| 🔐 Secure Login | Simple authentication system |
| 🗄️ Database Integration | Structured MySQL data management |
| ⚙️ CRUD Operations | Complete Create, Read, Update & Delete functionality |

---

# 📸 Project Preview

## 🔐 Login Screen

<p align="center">
<img src="./screenshots/login.png" width="900"/>
</p>

---

## 📊 Dashboard

<p align="center">
<img src="./screenshots/dashboard.png" width="900"/>
</p>

---

## 💊 Medicine Management

<p align="center">
<img src="./screenshots/medicine-management.png" width="900"/>
</p>

---

## 🤝 Supplier Management

<p align="center">
<img src="./screenshots/supplier-management.png" width="900"/>
</p>

---

## 📈 Purchase Report

<p align="center">
<img src="./screenshots/purchase-report.png" width="900"/>
</p>

---
```
````md
# 🏗️ System Architecture

```text
                           User

                             │

                             ▼

                Java Desktop Application

                             │

                  Business Logic Layer

                             │

        ┌────────────────────┼────────────────────┐
        │                    │                    │

  Medicine Module     Supplier Module     Report Module

        │                    │                    │

        └────────────────────┼────────────────────┘

                             │

                             ▼

                      MySQL Database

                             │

                             ▼

                Inventory & Business Records
```

---

# 🛠️ Technology Stack

| Category | Technology |
| ------------------------- | ----------------------------- |
| Programming Language | Java |
| Database | MySQL |
| Frontend | HTML5 |
| Styling | CSS3 |
| Client Scripting | JavaScript |
| Database Language | SQL |
| IDE | NetBeans / Eclipse |
| Version Control | Git & GitHub |

---

# 📂 Project Structure

```text
MedilQ/

├── assets/
│   └── medilq-logo.svg
│
├── css/
│   └── style.css
│
├── js/
│   └── app.js
│
├── database/
│   └── medical_store.sql
│
├── java-src/
│   ├── Login.java
│   ├── MainMenu.java
│   ├── AddNewMedicine.java
│   ├── UpdateMedicine.java
│   ├── DeleteMedicine.java
│   ├── SearchMedicine.java
│   ├── MedicineList.java
│   ├── AddNewSupplier.java
│   ├── UpdateSupplier.java
│   ├── DeleteSupplier.java
│   ├── SearchSupplier.java
│   ├── SupplierList.java
│   ├── SupplierWiseMedList.java
│   ├── DailyPurchaseReport.java
│   ├── About.java
│   └── printer.java
│
├── screenshots/
│   ├── login.png
│   ├── dashboard.png
│   ├── medicine-management.png
│   ├── supplier-management.png
│   └── purchase-report.png
│
├── README.md
├── LICENSE
└── .gitignore
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/Tanyyy-27/MedilQ.git
```

```bash
cd MedilQ
```

---

# ⚙️ Database Setup

Import the following SQL file into your local MySQL server.

```text
database/medical_store.sql
```

Create a database and execute the SQL script to generate the required tables.

---

# 💻 Run the Application

Compile Java source files

```bash
javac *.java
```

Run the application

```bash
java Login
```

---

# 🎯 Functional Modules

## 📦 Medicine Module

- Add New Medicine
- Update Medicine
- Delete Medicine
- Search Medicine
- Medicine List

---

## 🤝 Supplier Module

- Add New Supplier
- Update Supplier
- Delete Supplier
- Search Supplier
- Supplier List
- Supplier-wise Medicine List

---

## 📊 Reports Module

- Daily Purchase Report
- Inventory Records
- Stock Monitoring
- Purchase History

---

# 🎓 Learning Outcomes

This project demonstrates practical implementation of:

- Object-Oriented Programming
- Java Desktop Development
- Relational Database Design
- CRUD Operations
- Inventory Management Systems
- Software Engineering Principles
- MySQL Integration
- Modular Application Architecture

---
````

````md
# 🛣️ Product Roadmap

The following features are planned for future releases to make **MedilQ** a complete pharmacy management solution.

### 📦 Inventory Enhancements

- ✅ Barcode Scanner Integration
- ✅ QR Code Medicine Lookup
- ✅ Automatic Stock Updates
- ✅ Low Stock Notifications

### 💼 Business Features

- ✅ GST Billing System
- ✅ Invoice Generation
- ✅ Sales & Purchase Analytics
- ✅ Customer Management

### 🔐 Security

- ✅ Role-Based Authentication
- ✅ Admin & Staff Access Control
- ✅ Activity Logs
- ✅ Secure Database Backup

### ☁️ Cloud Integration

- ✅ Cloud Database Support
- ✅ Multi-Store Inventory Management
- ✅ Online Backup & Synchronization
- ✅ Web Dashboard

### 🤖 AI Features

- ✅ AI Stock Prediction
- ✅ Demand Forecasting
- ✅ Smart Purchase Recommendations
- ✅ Medicine Expiry Prediction

---

# 📊 Project Statistics

| Property | Details |
|--------------------------|---------------------------|
| Project Type | Desktop Application |
| Domain | Healthcare / Pharmacy |
| Architecture | Modular Java Application |
| Database | MySQL |
| Design Pattern | CRUD-Based Management |
| Version Control | Git & GitHub |
| License | MIT |

---

# 🌟 Why MedilQ?

MedilQ is designed to simplify pharmacy inventory operations by providing a centralized platform for medicine tracking, supplier management, and purchase reporting.

### Key Benefits

- 📦 Organized Medicine Inventory
- 🤝 Efficient Supplier Management
- 📈 Better Business Insights
- ⚡ Faster Search Operations
- 🗄️ Reliable Database Management
- 🚀 Scalable Software Architecture

---

# 🤝 Contributing

Contributions are welcome!

If you would like to improve MedilQ:

### 1. Fork the Repository

### 2. Create a New Branch

```bash
git checkout -b feature/new-feature
```

### 3. Commit Your Changes

```bash
git commit -m "feat: add new feature"
```

### 4. Push to GitHub

```bash
git push origin feature/new-feature
```

### 5. Open a Pull Request

Every contribution helps make MedilQ better.

---

# 📜 License

This project is licensed under the **MIT License**.

See the **LICENSE** file for more information.

---

# 👨‍💻 Developer

## Tanmay Yenpure

**Computer Engineering Student | Full Stack Developer | Java Developer | Open Source Enthusiast**

Passionate about building scalable software solutions that solve real-world business problems through clean architecture, efficient database design, and modern software engineering practices.

### 💻 Skills

- Java Development
- Full Stack Development
- Database Design
- Software Engineering
- Git & GitHub
- HTML • CSS • JavaScript • MySQL

### 🔗 Connect

**GitHub**

https://github.com/Tanyyy-27

---

# ⭐ Repository Support

If you found this project useful,

please consider giving it a ⭐ on GitHub.

Your support motivates continuous improvements and future open-source contributions.

---

<div align="center">

<img src="./assets/medilq-logo.svg" width="90"/>

# MedilQ

### Intelligent Medical Store Inventory Management System

**Building smarter pharmacy management solutions through modern software engineering.**

Made with ❤️ by **Tanmay Yenpure**

© 2026 MedilQ. All Rights Reserved.

</div>
````



