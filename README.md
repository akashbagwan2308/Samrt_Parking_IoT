# **<p align="center">IoT-BASED Smart PARKING </p>**

## Introduction:
An IoT-powered car parking system is an intelligent transportation system (ITS) that uses technology to optimize parking availability and efficiency. It typically comprises a network of sensors, cameras, databases, and software that detect and track vehicles in a parking lot. This information is then utilized to provide drivers with real-time updates on available parking slots and guide them to the nearest open spot using their device. The Smart Parking System (SPS) aims to reduce traffic congestion, enhance safety, and provide convenience for drivers.

## Block Diagram:

<p align="center">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/0e9dd9d4-ac35-4885-9fa6-c3042e7f03d5" width="750" height="400">
</p>

### **<p align="center">Block Diagram</p>**

### Description of Block Diagram:

The block diagram of the IoT-based Smart Parking system using ESP-32, IR sensors, LCD Display, and a servo motor illustrates how the different components work together to detect the presence of vehicles in parking spaces and control the movement of a barrier to allow or deny access and update the data on a cloud database.

1. The IR sensors are placed at the entrance and exit of the parking space.
2. When a vehicle enters the parking space, the IR sensor at the entrance detects its presence and sends a signal to the ESP-32.
3. The ESP-32 then checks if there is any available parking space. If there is, it sends a signal to the servo motor to open the barrier and allow the vehicle to enter and decrease the count of available slots by one and display it on LCD.
4. Once the vehicle has entered the parking space and parked, the IR sensor at the entrance detects its presence and sends a signal to the ESP-32.
5. The ESP-32 then updates the record of available parking spaces and sends it to the database over the Internet.
6. When the vehicle exits the parking space, the IR sensor at the exit detects its presence and sends a signal to the ESP-32.
7. The ESP-32 then sends a signal to the servo motor to open the barrier increase the count of available slots by one and update the database also.
8. This process is repeated for all vehicles that enter and exit the parking space.

## Components Used:
- **Hardware:**
  - ESP-32
  - 16x2 LCD
  - I2C Module
  - IR Sensor
  - Servo SG90
  - RGB LEDs
  - BC337 Transistor
  - Resistors
  - Toggle Switch
  - Zero PCB
  - Power Adapter (5V 2A)
    
- **Software:**
  - Arduino IDE
  - Firebase Database

## Circuit Diagram:

<p align="center">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/a7c51645-0e90-4ebf-91f4-61aede5d21f7" width="750" height="400">
</p>

### **<p align="center">Circuit Diagram</p>**

### Pin Connections:

- **ESP-32 to IR Sensor**:
  - ESP-32 Pin 34 – Out pin of IR 1
  - ESP-32 Pin 35 – Out pin of IR 2
  - ESP-32 Pin 32 – Out pin of IR 3
  - ESP-32 Pin 33 – Out pin of IR 4
  - ESP-32 Pin 25 – Out pin of IR 5
  - ESP-32 Pin 19 – Out pin of IR 6
  - ESP-32 Pin 18 – Out pin of IR 7
  - ESP-32 Pin 05 – Out pin of IR 8
  - ESP-32 Pin 17 – Out pin of IR 9
  - ESP-32 Pin 16 – Out pin of IR 10
  - ESP-32 Pin 26 – Out pin of IR Entry
  - ESP-32 Pin 27 – Out pin of IR Exit

- **ESP-32 to Servo Motor**:
  - ESP-32 Pin 14 – Signal pin of IR Servo_Entry
  - ESP-32 Pin 12 – Signal pin of IR Servo_Exit

- **ESP-32 to Buzzer**:
  - ESP-32 Pin 04 – Pin of Buzzer

## PCB Layout and Circuit Diagram:

<p align="center">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/935ce74a-7230-4890-ba88-45e9d2149736" width="300" height="250">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/eab48083-1244-4c49-b087-212878f6a302" width="280" height="250">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/5900b484-0f81-4484-9b03-203ed079ce6e" width="250" height="250">
</p>

### **<p align="center">PCB Layout and Circuit Diagram</p>**

The circuit presented above serves a specific purpose, to detect parking slot availability. When the parking slot is **empty**, a **green LED** turns on, and when the slot is **occupied**, the green LED turns off and the **red LED** turns on. This is achieved by using the BC337 transistor for switching and designing one NOT Gate. The LEDs are switched based on the data obtained from an IR Sensor placed at the slot. To cover 10 parking slots, we created 10 replicas of this circuit module, which receives input from the respective IR sensor module and acts accordingly.



## Main Code Function:


### Setup Function
```cpp
void setup() {
    // Initialization of components and setup of Wi-Fi and Firebase
    // Checking Wi-Fi connection and Firebase setup status
    // Initializing pin modes for sensors, servo, and buzzer
    // Attaching servo motors and setting initial positions
    // Clearing LCD and displaying a welcome message
    // Reading sensor data and updating slots status
    // Checking Wi-Fi connection and choosing the appropriate data update method
}
```

### Loop Function
```cpp
void loop() {
    // Continuously checking if Firebase is ready and updating sensor data
    // If Firebase is ready, calling ReadSensorData2() function to update data
    // If Firebase is not ready, calling ReadSensorData3() function to simulate data update offline
}
```

### ReadSensorData2 Function
```cpp
void ReadSensorData2() {
    // Reading sensor data for each slot and updating Firebase with slot status
    // Displaying slot status on the LCD screen
    // Updating total available slots count and controlling servo motor
}
```

### Update_Slots Function
```cpp
void Update_Slots() {
    // Calculating total available slots based on individual slot statuses
    // Updating total available slots count in Firebase and displaying on LCD
}
```

### ServoStatus Function
```cpp
void ServoStatus() {
    // Controlling servo motors to open or close the barrier based on IR sensor data
    // Updating available slots count and displaying relevant messages on the LCD
}
```

[![Full_Code](https://img.shields.io/badge/Full_Code-%230077B5.svg?logo=arduino&logoColor=white)](https://github.com/akashbagwan2308/Samrt_Parking_IoT/blob/main/Smart_Parking_Arduino_Code_ESP32.ino)


## Result:

<p align="center">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/6434d874-4e74-4e3f-8843-39c67329cd50" width="300" height="400">
  <img src="https://github.com/akashbagwan2308/Samrt_Parking_IoT/assets/97840357/a15ca11f-4651-48df-8031-c5d033cda9b7" width="300" height="450>
</p>

### **<p align="center">Result(Parking & Iot App)</p>**

The picture above depicts the outcome we obtained upon the successful completion of our project. Our system is designed to display the status of a parking slot on both the Android application and a physical LED. When a slot is occupied, it is displayed as "**Engaged**" on the Android app and the corresponding LED glows red. Conversely, when a slot is free, it is displayed as "**Available**" on the app and the LED glows green.


## Conclusion:
Our IoT-Based Car Parking System represents a significant advancement in parking management technology. By harnessing the power of IoT, we have created a solution that addresses the challenges of urban parking while improving efficiency, safety, and user convenience. As cities continue to grow, innovative solutions like ours will play a crucial role in shaping the future of urban mobility.

## References: 
    1. Aggarwal, S. (2011). Smart Parking System using Sensors and Networking Technologies. International Journal of Electronics and Computer Science Engineering (IJECSE), 1(2), 1-8.
    2. Kumar, S. (2023). Smart Car Parking System. International Journal for Research in Applied Science and Engineering Technology (IJRASTE), 11(5), 707-711.

    Articles
    4. Harnessing Technology to Solve Urban Parking Woes: The Rise of Smart Parking Systems
    5. A City Transformed: The Impact of Smart Parking Systems on Urban Traffic and Congestion

    Text Books
    6. Programming Arduino: Getting Started With Sketches (second edition) 
    7. Servo Motors and Industrial Control Theor


## Developed By: 

- **Akash Bagwan** [![LinkedIn](https://img.shields.io/badge/linkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/akashbagwan/) [![Gmail](https://img.shields.io/badge/Gmail-%230077B5.svg?logo=gmail&logoColor=white)](akashbagwan01@gmail.com)

- **Jay Barode** [![LinkedIn](https://img.shields.io/badge/linkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jaybarode728/) [![Gmail](https://img.shields.io/badge/Gmail-%230077B5.svg?logo=gmail&logoColor=white)](barodejay468@gmail.com)

- **Surendra Prajapat** [![LinkedIn](https://img.shields.io/badge/linkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/surendraprajapat18/) [![Gmail](https://img.shields.io/badge/Gmail-%230077B5.svg?logo=gmail&logoColor=white)](prajapatsurendra78980@gmail.com)
