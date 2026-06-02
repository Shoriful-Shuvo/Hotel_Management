<h1>Hotel Management System</h1>
For the project we decided to build a Hotel Management System using Java that helps in
managing the daily operations of a hotel in an organized and efficient way.
Instead of handling records manually this system stores and processes all information digitally, 
making hotel management faster, more accurate, and easier to control.
It stores guest information,show room availability and room types with the facilities of booking rooms and checking out. 
This management system demonstrate all four core Object-Oriented Programming (OOP)
principles which are  Encapsulation, Abstraction, Inheritance, and Polymorphism
and a Java swing graphical user interface(GUI) as the frontend.

# Core Features :

Hotel Management System that helps in managing the daily operations of a hotel in an organized and efficient way. Instead of handling records manually this system stores and processes all information digitally, making hotel management faster, more accurate, and easier to control. The core features of the systems are given below :

## 1. Reservation Management
This is one of the core feature of the system. It allows staff to book rooms, modify bookings, check availability of rooms.

## 2. Checkin/Checkout
Handles guest arrivals and departures. Staff can quickly assign rooms, issue keys, update guest details, and process checkouts with billing.

## 3. Room Management
Tracks room status whether room is available or occupied, under maintenance, cleaning in progress.

## 4. Guest Management
Stores guest information such as contact details, preferences, booking history, and special requests.

## 5. Billing
Automatically calculates charges like room rates, services, taxes, discounts.

---

# Implementation :

## The Classes we will use :

1. HotelManagement.java class – This is the parent class where the common properties will be declared.
2. Guest.java class – This class store personal information and their reservation history.
3. Stuff.java class – This class hold the information about the stuff.
4. Reservation.java class – This class will handle room booking, checking out and total amount etc.
5. Room.java class – This class will handle room number, availability, types.

---

## The Methods/Function we will use :

1. Getter and Setter method – To access and and update information in private fields like NID no. , Name, phone number etc.
2. addGuest method – This method is for adding a guest during reservation.
3. roomAvailability method – To check availability of empty rooms and their informations.
4. Totalbill method – To calculate the total bill of the guest.
5. checkout method – To clear and update room status.

---

## Types of data used :

In the program of the Hotel management system, three types of variable is used according to the need of the system. String, int, Double types data are used where String type data is used for Name of guest and stuff, department, int data is used for handling or taking integer type number like phone number, NID and double data is used salary of stuff and total bill of the guest.

---

In this program of Hotel management, it takes the guest details, stuff details, room details and as input of the system and provides or display guest list, room availability, stuff information, total bill of guest for staying in the hotel etc as output of the system.

---

# Conclusion :

In conclusion a Hotel Management system is build to simply and everyday operation of a hotel in a efficient way. We applied object-oriented principles like encapsulation, inheritance, polymorphism, and abstraction and due to this reasone the system becomes more structured, secure , reusable, and easy to maintain. Each class has a clear responsibility, which makes the overall design logical and closer to real-life scenarios. This system helps to manage guests, staff, and rooms effectively. It also helps in understanding of how software systems are designed in the real world. With further improvements such as booking management and a graphical interface, the system can become even more powerful and user-friendly.