# 🏨 Hotel Management System

A Java-based Hotel Management System developed as a course project for **Introduction to Programming Language II (Java) Lab**. The system helps manage hotel operations digitally, including room reservations, guest management, staff administration, and billing.

---

## 📋 Project Information

| Field | Details |
|---------|---------|
| Course | Introduction to Programming Language II (Java) Lab |
| Course Code | CSE282 |
| Department | Computer Science & Engineering |
| University | Southeast University |
| Submission Date | 04 June 2026 |

---

## 👥 Team Members

| Name | Student ID |
|--------|------------|
| Shoriful Islam | 2024100000159 |
| Istiak Ahamed | 2024100000273 |
| Abdul Ahad | 2024100000140 |
| Rifatul Islam Shakib | 2024100000124 |
| Rahidul Islam Patwary | 2024100000147 |

---

## 📖 Project Overview

The Hotel Management System is designed to simplify and automate hotel operations. Instead of managing records manually, the system stores and processes information digitally, making hotel management faster, more efficient, and more accurate.

The system manages:

- Room Inventory
- Guest Information
- Reservation Management
- Employee Administration
- Hotel Facilities

---

## ✨ Features

### 🛏️ Room Management
- Add and manage rooms
- Check room availability
- Support for multiple room types:
  - Single Room
  - Luxury Room
  - Duplex Room

### 👤 Guest Management
- Store guest information
- VIP Guest support
- Business Guest support
- Guest reservation history

### 📅 Reservation Management
- Online reservations
- Offline reservations
- Confirm reservations
- Cancel reservations
- Check-in and Check-out

### 💰 Billing System
- Calculate room charges
- Apply discounts
- Generate total bill

### 👨‍💼 Employee Management
- Manager
- Receptionist
- Attendant
- Porter

### 🏊 Facility Management
- Gym
- Swimming Pool

---

## 🏗️ System Architecture

The project follows a three-layer architecture:

```text
Presentation Layer (Java Swing GUI)
            │
            ▼
Business Logic Layer
(Rooms, Guests, Reservations, Employees)
            │
            ▼
Data Layer
(ArrayList Collections)
```

---

## 📚 Object-Oriented Programming Concepts

### Encapsulation
- Private fields with Getter and Setter methods.

### Inheritance
- Room hierarchy
- Guest hierarchy
- Reservation hierarchy
- Employee hierarchy

### Polymorphism
- Method overriding in subclasses.
- Runtime polymorphism through parent class references.

### Abstraction
- Abstract classes define common behavior.
- Concrete subclasses implement specific functionality.

---

## 🧩 Class Hierarchy

### Room Hierarchy

```text
Room (Abstract)
├── SingleRoom
├── LuxuryRoom
└── DuplexRoom
```

### Guest Hierarchy

```text
Guest (Abstract)
├── Vip
└── Business
```

### Reservation Hierarchy

```text
Reservation (Abstract)
├── OnlineReservation
└── OfflineReservation
```

### Employee Hierarchy

```text
Employee (Abstract)
├── Manager
├── Receptionist
├── Attendant
└── Porter
```

---

## ⚠️ Exception Handling

Custom exceptions implemented:

- InvalidRoomException
- GuestException
- InvalidReservationException
- InvalidStatusException
- ReservationNotFoundException
- InvalidFacilityException

---

## 🖥️ GUI Modules

- Dashboard
- Rooms
- Guests
- Reservations
- Facilities
- Employees

---

## 🛠️ Technologies Used

- Java
- Java Swing (GUI)
- Object-Oriented Programming (OOP)
- ArrayList Collections
- Exception Handling

---

## 🚀 How to Run

### Clone the Repository

```bash
git clone https://github.com/your-username/Hotel-Management-System.git
```

### Open Project

Open the project in:

- IntelliJ IDEA
- Eclipse
- NetBeans

### Compile and Run

```bash
javac *.java
java HotelGUI
```

---

## 📸 Screenshots

Add your GUI screenshots here.

```markdown
![Dashboard](images/dashboard.png)

![Rooms](images/rooms.png)

![Reservations](images/reservations.png)
```

---

## 🎯 Learning Outcomes

This project demonstrates:

- Java Programming
- GUI Development using Swing
- Object-Oriented Design
- Exception Handling
- Software Architecture
- Team Collaboration

---

## 🔮 Future Improvements

- Database Integration (MySQL)
- User Authentication
- Online Payment Gateway
- Advanced Reporting
- Room Service Management
- Web-Based Version

---

## 📄 License

This project was developed for academic purposes as part of the CSE282 course at Southeast University.

---

## 🙏 Acknowledgements

Special thanks to our course instructor for guidance throughout the project development process.
