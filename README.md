<div align="center">

<img src="./assets/medilq-logo.svg" alt="MedilQ Logo" width="110">

# MedilQ

### Smart Medical Store Inventory Management System

**Smart Inventory • Supplier Management • Stock Tracking • Purchase Analytics**

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![MIT](https://img.shields.io/badge/License-MIT-success?style=for-the-badge)

<br>

### Modernizing Pharmacy Operations Through Intelligent Inventory Management

*Efficient Inventory • Intelligent Tracking • Better Business Decisions*

</div>

---

# 📖 Overview

MedilQ is a Smart Medical Store Inventory Management System designed to simplify pharmacy operations through efficient medicine inventory tracking, supplier management, stock monitoring, and purchase reporting.

The platform provides a centralized environment for managing medicines, suppliers, inventory records, and daily business operations while reducing manual effort, improving accuracy, and increasing operational efficiency.

Built using Java, MySQL, HTML, CSS, and JavaScript, MedilQ demonstrates modular software architecture, CRUD operations, and reliable relational database management suitable for modern healthcare businesses.

---

# ✨ Key Features

| Module | Description |
| -------------------------------- | -------------------------------------------- |
| 📦 Medicine Management | Add, Update, Delete & Search Medicines |
| 📊 Smart Inventory Control | Monitor Medicine Stock & Availability |
| 🤝 Supplier Management | Manage Supplier Records Efficiently |
| 📈 Purchase Reports | Daily Purchase Analytics |
| 🔍 Smart Search | Quick Medicine & Supplier Lookup |
| 🔐 Login System | Secure User Authentication |
| 🗄️ Database Integration | MySQL Based Storage |
| ⚙️ CRUD Operations | Complete Data Management |

---

# 📸 Project Preview

## 🔐 Login Screen

<p align="center">
<img src="./screenshots/login.png" width="900">
</p>

---

## 📊 Dashboard

<p align="center">
<img src="./screenshots/dashboard.png" width="900">
</p>

---
## 💊 Medicine Management

<p align="center">
  <img src="./screenshots/medicine-management system.png" alt="Medicine Management System" width="900">
</p>

---

## 🤝 Supplier Management

<p align="center">
<img src="./screenshots/supplier-management.png" width="900">
</p>

---

## 📈 Purchase Report

<p align="center">
<img src="./screenshots/purchase-report.png" width="900">
</p>

---

# 🏗️ System Architecture

```text
                        Pharmacy Staff

                              │

                              ▼

                 MedilQ Desktop Application

                              │

                    Business Logic Layer

                              │

        ┌─────────────────────┼─────────────────────┐

        ▼                     ▼                     ▼

 Medicine Module      Supplier Module      Report Module

        │                     │                     │

        └─────────────────────┼─────────────────────┘

                              ▼

                       MySQL Database

                              │

                              ▼

          Medicines • Suppliers • Purchase Records
```

---

# 🛠️ Technology Stack

| Category | Technology |
| ---------------------- | ---------------- |
| Programming Language | Java |
| Database | MySQL |
| Frontend | HTML5 |
| Styling | CSS3 |
| Client Scripting | JavaScript |
| Database Language | SQL |
| IDE | NetBeans / Eclipse |
| Version Control | Git & GitHub |

---

# 📊 Project Statistics

| Property | Details |
| ---------------- | ----------------------------- |
| Project Type | Desktop Application |
| Domain | Healthcare / Pharmacy |
| Architecture | Modular Java Application |
| Database | MySQL |
| Design Pattern | CRUD-Based System |
| License | MIT |
| Status | Active Development |

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
git clone https://github.com/tanmayyenpure/MedilQ.git
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

Create a new database and execute the SQL script to generate all required tables and initialize the application database.

---

# 💻 Running the Application

### Compile Java Files

```bash
javac *.java
```

### Run the Application

```bash
java Login
```

---

# 🎯 Functional Modules

## 💊 Medicine Management

- Add Medicine
- Update Medicine
- Delete Medicine
- Search Medicine
- Medicine List

---

## 🤝 Supplier Management

- Add Supplier
- Update Supplier
- Delete Supplier
- Search Supplier
- Supplier List
- Supplier-wise Medicine List

---

## 📊 Reports & Analytics

- Daily Purchase Report
- Inventory Monitoring
- Purchase Records
- Stock Management

---

# 🎓 Learning Outcomes

This project demonstrates practical understanding of:

- Object-Oriented Programming (OOP)
- Java Desktop Application Development
- Relational Database Design
- CRUD Operations
- Medical Inventory Management Systems
- Software Engineering Principles
- MySQL Database Integration
- Modular Application Architecture

---

# 🛣️ Future Roadmap

MedilQ is designed with scalability in mind, with future enhancements focused on automation, business intelligence, and healthcare technology.

### 📦 Inventory Enhancements

- Barcode Scanner Integration
- QR Code Medicine Lookup
- Automatic Stock Updates
- Low Stock Notifications

### 💼 Business Features

- GST Billing System
- Invoice Generation
- Customer Management
- Sales & Purchase Analytics

### 🔐 Security & Administration

- Role-Based Authentication
- Admin & Staff Dashboard
- Activity Logs
- Secure Database Backup

### ☁️ Cloud Solutions

- Cloud Database Support
- Multi-Store Inventory Management
- Online Synchronization
- Web-Based Dashboard

### 🤖 AI-Powered Features

- AI Stock Prediction
- Medicine Demand Forecasting
- Smart Purchase Recommendations
- Medicine Expiry Alerts

---

# 🌟 Why MedilQ?

MedilQ is designed to simplify medical store operations through an intelligent and centralized inventory management platform.

### Key Benefits

- Organized Medicine Inventory
- Efficient Supplier Management
- Better Business Insights
- Faster Search Operations
- Reliable Database Management
- Modular & Scalable Architecture

---
# 🤝 Contributing

Contributions, suggestions, and improvements are always welcome.

### 1. Fork the Repository

Create your own copy of the project to start contributing.

### 2. Create a Feature Branch

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

Submit your changes for review and help improve MedilQ for the developer community.

---

# 📜 License

This project is licensed under the **MIT License**.

You are free to use, modify, and distribute this project in accordance with the license terms.

---

# 👨‍💻 Developer

**Tanmay Yenpure**

### AI/ML Engineer & Java Developer

---

### 🔗 GitHub

https://github.com/tanmayyenpure

---

# ⭐ Support the Project

If you found **MedilQ** useful or interesting, consider giving this repository a **Star ⭐** on GitHub.

Your support encourages continuous improvements and future open-source contributions.

---

<div align="center">

<img src="./assets/medilq-logo.svg" alt="MedilQ Logo" width="90">

# MedilQ

### Smart Medical Store Inventory Management System

**Building smarter pharmacy management solutions through modern software engineering.**

**Engineered by Tanmay Yenpure**

</div>
