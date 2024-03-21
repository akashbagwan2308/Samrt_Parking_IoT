
#include <Arduino.h>
#include <WiFi.h>
#include <FirebaseESP-32.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>
#include <ESP-32Servo.h>

#include <addons/TokenHelper.h>
#include <addons/RTDBHelper.h>

/* 1. Define the WiFi credentials */
#define WIFI_SSID "WiFi Name"
#define WIFI_PASSWORD "WiFi Password"

/* 2. Define the API Key */
#define API_KEY "Your web api key"

/* 3. Define the RTDB URL */
#define DATABASE_URL "your database link" 

/* 4. Define the user Email and password that alreadey registerd or added in your project */
#define USER_EMAIL " user Email "
#define USER_PASSWORD " password "

// Define Firebase Data object
FirebaseData fbdo;
FirebaseAuth auth;
FirebaseConfig config;

unsigned long sendDataPrevMillis = 0;
unsigned long count = 0;
#define slot_1 34
#define slot_2 35
#define slot_3 32
#define slot_4 33
#define slot_5 25
#define slot_6 16
#define slot_7 17
#define slot_8 5
#define slot_9 18
#define slot_10 19

#define ir_enter 26
#define ir_exit 27
#define servo_enter 14
#define servo_exit 12
#define buzzer 4
/* ----------------------------------------------------- */
String line1 = " Welcome! "; // stationary 
String line2 = " Its an IoT Based Smart Parking. Developed by: Akash Bagwan,Jay Barode,Surendra Prajapat. ";

int screenWidth = 16;
int screenHeight = 2;

int stringStart, stringEnd = 0;
int scrollCursor = screenWidth; 

LiquidCrystal_I2C LCD = LiquidCrystal_I2C(0x27, 16, 2);
Servo myservo_enter;
Servo myservo_exit;

int pos_enter = 0;
int pos_exit = 0;

int S_1 = 1;
int S_2 = 1;
int S_3 = 1;
int S_4 = 1;
int S_5 = 1;
int S_6 = 1;
int S_7 = 1;
int S_8 = 1;
int S_9 = 1;
int S_10 = 1;
int S_total = 0;
int counter = 0;
/* ----------------------------------------------------- */
void setup()
{ Serial.begin(115200);
  LCD.begin();
  LCD.backlight();

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  LCD.print("Connecting....");

  unsigned long wifiConnectStartTime = millis();
  while (WiFi.status() != WL_CONNECTED && millis() - wifiConnectStartTime < 10000) {
    Serial.print(".");
    delay(300);
  }
  
  if (WiFi.status() != WL_CONNECTED) {
    Serial.println("\nFailed to connect to Wi-Fi. Skipping Firebase setup.");
    LCD.setCursor(0, 1);
    LCD.print("Failed");
    delay(800);
  }
  else {
  Serial.println();
  Serial.print("Connected with IP: ");
  LCD.setCursor(0, 1);
  LCD.print("WiFi-Connected");
  Serial.println(WiFi.localIP());
  Serial.println();
  delay(700);
  Serial.printf("Firebase Client v%s\n\n", FIREBASE_CLIENT_VERSION);
  LCD.clear();
  LCD.setCursor(0, 0);
  LCD.print("Getting Firebase");
  LCD.setCursor(0, 1);
  LCD.print("...");
  /* Assign the api key (required) */
  config.api_key = API_KEY;

  auth.user.email = USER_EMAIL;
  auth.user.password = USER_PASSWORD;
  
  config.database_url = DATABASE_URL;
  config.token_status_callback = tokenStatusCallback; 
  Firebase.reconnectNetwork(true);
  Firebase.begin(&config, &auth);
  }
  pinMode(slot_1, INPUT);
  pinMode(slot_2, INPUT);
  pinMode(slot_3, INPUT);
  pinMode(slot_4, INPUT);
  pinMode(slot_5, INPUT);
  pinMode(slot_6, INPUT);
  pinMode(slot_7, INPUT);
  pinMode(slot_8, INPUT);
  pinMode(slot_9, INPUT);
  pinMode(slot_10, INPUT);
  pinMode(ir_enter, INPUT);
  pinMode(ir_exit, INPUT);
  pinMode(buzzer, OUTPUT);
  
  myservo_enter.attach(servo_enter);
  myservo_exit.attach(servo_exit);
  myservo_enter.write(9);
  myservo_exit.write(9);
  
  LCD.clear();
  scroll(line1,line2);
  ReadSensorData1();
  if (WiFi.status() != WL_CONNECTED) {Update_Slots(); counter = S_total; ReadSensorData3();}
  else{Update_Slots(); counter = S_total; ReadSensorData2();}
 }





void loop()
{  if (Firebase.ready() && (millis() - sendDataPrevMillis > 5000 || sendDataPrevMillis == 0))
    { sendDataPrevMillis = millis();
      ReadSensorData2();
    } else{
      ReadSensorData3();
      }
}
/* It will update counter */
void ReadSensorData1(){
    
    S_1 = digitalRead(slot_1);
    String status1;
    if(S_1==0){status1= "Engaged";}else{status1 = "Available";}

    S_2 = digitalRead(slot_2);
    String status2;
    if(S_2==0){status2 = "Engaged";}else{status2 = "Available";}

    S_3 = digitalRead(slot_3);
    String status3;
    if(S_3==0){status3 = "Engaged";}else{status3 = "Available";}
  
    S_4 = digitalRead(slot_4);
    String status4;
    if(S_4==0){status4 = "Engaged";}else{status4 = "Available";}
  
    S_5 = digitalRead(slot_5);
    String status5;
    if(S_5==0){status5 = "Engaged";}else{status5 = "Available";}

    S_6 = digitalRead(slot_6);
    String status6;
    if(S_6==0){status6 = "Engaged";}else{status6 = "Available";}

    S_7 = digitalRead(slot_7);
    String status7;
    if(S_7==0){status7 = "Engaged";}else{status7 = "Available";}
    S_8 = digitalRead(slot_8);
    String status8;
    if(S_8==0){status8 = "Engaged";}else{status8 = "Available";}
  
    S_9 = digitalRead(slot_9);
    String status9;
    if(S_9==0){status9 = "Engaged";}else{status9 = "Available";}
  
    S_10 = digitalRead(slot_10);
    String status10;
    if(S_10==0){status10 = "Engaged";} else{status10 = "Available";}
 }
/* ----------------------------------------------------- */
/* It Will Update data inn Firebase */
void ReadSensorData2(){

    S_1 = digitalRead(slot_1);
    String status1;
    if(S_1==0){
      status1 = "Engaged";
    }else{
      status1 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 1"),status1);
    LCD.setCursor(1,1);
    LCD.print("S_1: "+String(status1)+"    ");
    Update_Slots();
    ServoStatus();

    S_2 = digitalRead(slot_2);
    String status2;
    if(S_2==0){
      status2 = "Engaged";
    }else{
      status2 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 2"),status2);
    LCD.setCursor(1,1);
    LCD.print("S_2: "+String(status2)+"    ");
    Update_Slots();
    ServoStatus();

    S_3 = digitalRead(slot_3);
    String status3;
    if(S_3==0){
      status3 = "Engaged";
    }else{
      status3 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 3"),status3);
    LCD.setCursor(1,1);
    LCD.print("S_3: "+String(status3)+"    ");
    Update_Slots();
    ServoStatus();
  
    S_4 = digitalRead(slot_4);
    String status4;
    if(S_4==0){
      status4 = "Engaged";
    }else{
      status4 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 4"),status4);
    LCD.setCursor(1,1);
    LCD.print("S_4: "+String(status4)+"    ");
    Update_Slots();
    ServoStatus();
  
    S_5 = digitalRead(slot_5);
    String status5;
    if(S_5==0){
      status5 = "Engaged";
    }else{
      status5 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 5"),status5);
    LCD.setCursor(1,1);
    LCD.print("S_5: "+String(status5)+"    ");
    Update_Slots();
    ServoStatus();

    S_6 = digitalRead(slot_6);
    String status6;
    if(S_6==0){
      status6 = "Engaged";
    }else{
      status6 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 6"),status6);
    LCD.setCursor(1,1);
    LCD.print("S_6: "+String(status6)+"    ");
    Update_Slots();
    ServoStatus();

    S_7 = digitalRead(slot_7);
    String status7;
    if(S_7==0){
      status7 = "Engaged";
    }else{
      status7 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 7"),status7);
    LCD.setCursor(1,1);
    LCD.print("S_7: "+String(status7)+"    ");
    Update_Slots();
    ServoStatus();

    S_8 = digitalRead(slot_8);
    String status8;
    if(S_8==0){
      status8 = "Engaged";
    }else{
      status8 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 8"),status8);
    LCD.setCursor(1,1);
    LCD.print("S_8: "+String(status8)+"    ");
    Update_Slots();
    ServoStatus();
  
    S_9 = digitalRead(slot_9);
    String status9;
    if(S_9==0){
      status9 = "Engaged";
    }else{
      status9 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 9"),status9);
    LCD.setCursor(1,1);
    LCD.print("S_9: "+String(status9)+"    ");
    Update_Slots();
    ServoStatus();
  
    S_10 = digitalRead(slot_10);
    String status10;
    if(S_10==0){
      status10 = "Engaged";
    }else{
      status10 = "Available";
    }
    Firebase.setString(fbdo,F("Sensors/Slot 10"),status10);
    LCD.setCursor(1,1); 
    LCD.print("S_10: "+String(status10)+"    ");
    Update_Slots();
    ServoStatus();
}
void Update_Slots(){
    S_total = S_1 + S_2 + S_3 + S_4 + S_5 + S_6 + S_7 + S_8 + S_9 + S_10 ;
    Firebase.setString(fbdo,F("Sensors/Total_Slots"),S_total);
    LCD.setCursor(0,0);
    LCD.print("Total_Slots:"+String(counter)+"  ");
}
void ServoStatus(){
      
      if(digitalRead(ir_enter)==0 && (S_total > 0 && counter > 0)){
      counter = counter - 1;
      myservo_enter.write(99);
      LCD.setCursor(1,1);
      LCD.print("Opening Gate...");
      digitalWrite(buzzer,HIGH);
      delay(3000);
      digitalWrite(buzzer,LOW);
      myservo_enter.write(9); 
      }
      
      if(digitalRead(ir_exit)==0){
      counter = counter + 1;
      myservo_exit.write(99);
      LCD.setCursor(1,1);
      LCD.print("Opening Gate...");
      digitalWrite(buzzer,HIGH);
      delay(3000);
      digitalWrite(buzzer,LOW);
      myservo_exit.write(9);
      } 
      if(counter==0){LCD.setCursor(1,1);
      LCD.print("Parking is Full");}
}
void scroll(String line1, String line2){
  for(int i = 1 ; i <=line2.length();i++){
  LCD.setCursor(0, 0); // Seting the cursor on first row 
  LCD.print(line1); // To print line1 message
  LCD.setCursor(scrollCursor, 1); // Seting the cursor on first row and (scrolling from left end to right)
  LCD.print(line2.substring(stringStart,stringEnd)); // To print line1 first character "T"
  delay(230);
  
  LCD.clear(); // clear message
  
  if(stringStart == 0 && scrollCursor > 0){
    scrollCursor--; // Moving cursor from 16 to 0
    stringEnd++; // Character T, H, I, S ...
                 // it will print out character from 0 to 15 the whole length of the screen
  }
  else if (stringStart == stringEnd){ // start all over again
    stringStart = stringEnd = 0;
    scrollCursor = screenWidth;
  } 
  else if (stringEnd == line1.length() && scrollCursor == 0) { // if reach to the end c haracter
    stringStart++;
  } 
  else { // it will print out character from (1 to 16) to end character (this case it's !))
    stringStart++;
    stringEnd++;
  }  
  }
}
/* It will print info on LCd in case of Offline System i.e not connected to wi-fi and firebase*/
void ReadSensorData3(){

    S_1 = digitalRead(slot_1);
    String status1;
    if(S_1==0){
      status1 = "Engaged";
    }else{
      status1 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_1: "+String(status1)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);

    S_2 = digitalRead(slot_2);
    String status2;
    if(S_2==0){
      status2 = "Engaged";
    }else{
      status2 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_2: "+String(status2)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);

    S_3 = digitalRead(slot_3);
    String status3;
    if(S_3==0){
      status3 = "Engaged";
    }else{
      status3 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_3: "+String(status3)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);
  
    S_4 = digitalRead(slot_4);
    String status4;
    if(S_4==0){
      status4 = "Engaged";
    }else{
      status4 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_4: "+String(status4)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);
  
    S_5 = digitalRead(slot_5);
    String status5;
    if(S_5==0){
      status5 = "Engaged";
    }else{
      status5 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_5: "+String(status5)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);

    S_6 = digitalRead(slot_6);
    String status6;
    if(S_6==0){
      status6 = "Engaged";
    }else{
      status6 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_6: "+String(status6)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);

    S_7 = digitalRead(slot_7);
    String status7;
    if(S_7==0){
      status7 = "Engaged";
    }else{
      status7 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_7: "+String(status7)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);

    S_8 = digitalRead(slot_8);
    String status8;
    if(S_8==0){
      status8 = "Engaged";
    }else{
      status8 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_8: "+String(status8)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);
  
    S_9 = digitalRead(slot_9);
    String status9;
    if(S_9==0){
      status9 = "Engaged";
    }else{
      status9 = "Available";
    }
    LCD.setCursor(1,1);
    LCD.print("S_9: "+String(status9)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);
  
    S_10 = digitalRead(slot_10);
    String status10;
    if(S_10==0){
      status10 = "Engaged";
    }else{
      status10 = "Available";
    }
    LCD.setCursor(1,1); 
    LCD.print("S_10: "+String(status10)+"    ");
    Update_Slots();
    ServoStatus();
    delay(900);
