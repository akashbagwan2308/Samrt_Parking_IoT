#include <WiFi.h>
#include <Firebase_ESP_Client.h>
#include "addons/TokenHelper.h"
#include "addons/RTDBHelper.h"
#include <ESP32Servo.h>

#define WIFI_SSID "Wokwi-GUEST"
#define WIFI_PASSWORD ""
#define API_KEY "AIzaSyCnV8Wr0OcL6NOts2vcK36npQL7NGiw3L8"
#define DATABASE_URL "https://smart-parking-iot-b304b-default-rtdb.asia-southeast1.firebasedatabase.app/"

#define slot_1 23
#define slot_2 19
#define slot_3 18
#define slot_4 5
#define slot_5 17
#define slot_6 34
#define slot_7 35
#define slot_8 32
#define slot_9 33
#define slot_10 25

#define ir_enter 27
#define ir_exit 26
#define servoPin 14


FirebaseData fbdo;
FirebaseAuth auth;
FirebaseConfig config;


unsigned long sendDataPrevMillis = 0;
bool signupOK = false;

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

Servo servo;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  servo.attach(servoPin, 500, 2400);
  WiFi.begin(WIFI_SSID,WIFI_PASSWORD);
  Serial.println("Connecting to Wi-Fi");
  while(WiFi.status() != WL_CONNECTED){
    Serial.print(".");delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP");
  Serial.println(WiFi.localIP());
  Serial.println();

  config.api_key = API_KEY;
  config.database_url = DATABASE_URL;
  if(Firebase.signUp(&config,&auth,"","")){
    Serial.println("signUp OK");
    signupOK = true;
  }else{
    Serial.printf("%s\n",config.signer.signupError.message.c_str());
  }
  config.token_status_callback = tokenStatusCallback;
  Firebase.begin(&config, &auth);
  Firebase.reconnectWiFi(true);

  pinMode(slot_1, INPUT);
  pinMode(slot_2, INPUT);

}

void loop() {
  if(Firebase.ready() && signupOK && (millis()-sendDataPrevMillis > 3000 || sendDataPrevMillis == 0)){
    sendDataPrevMillis = millis();
    //----------------------------------------------
    Update_Slots();
    if(digitalRead(ir_enter)==0 && S_total > 0 ){
      servo.write(90);
      if(digitalRead(ir_exit)==0){
      servo.write(-90);
    }
    }

    if(digitalRead(ir_exit)==0){
      servo.write(90);
      if(digitalRead(ir_enter)==0){
      servo.write(-90);
    } 
  }


    ReadSensorData();
  
  
  
  }  
}

void ReadSensorData(){

    S_1 = digitalRead(slot_1);
    String status1;
    if(S_1==0){
      status1 = "Engaged";
    }else{
      status1 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 1",status1);
    Update_Slots();

    S_2 = digitalRead(slot_2);
    String status2;
    if(S_2==0){
      status2 = "Engaged";
    }else{
      status2 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 2",status2);
    Update_Slots();

    S_3 = digitalRead(slot_3);
    String status3;
    if(S_3==0){
      status3 = "Engaged";
    }else{
      status3 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 3",status3);
    Update_Slots();
  
    S_4 = digitalRead(slot_4);
    String status4;
    if(S_4==0){
      status4 = "Engaged";
    }else{
      status4 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 4",status4);
    Update_Slots();
  
    S_5 = digitalRead(slot_5);
    String status5;
    if(S_5==0){
      status5 = "Engaged";
    }else{
      status5 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 5",status5);
    Update_Slots();

    S_6 = digitalRead(slot_6);
    String status6;
    if(S_6==0){
      status6 = "Engaged";
    }else{
      status6 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 6",status6);
    Update_Slots();

    S_7 = digitalRead(slot_7);
    String status7;
    if(S_7==0){
      status7 = "Engaged";
    }else{
      status7 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 7",status7);
    Update_Slots();

    S_8 = digitalRead(slot_8);
    String status8;
    if(S_8==0){
      status8 = "Engaged";
    }else{
      status8 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 8",status8);
    Update_Slots();
  
    S_9 = digitalRead(slot_9);
    String status9;
    if(S_9==0){
      status9 = "Engaged";
    }else{
      status9 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 9",status9);
    Update_Slots();
  
    S_10 = digitalRead(slot_10);
    String status10;
    if(S_10==0){
      status10 = "Engaged";
    }else{
      status10 = "Available";
    }
    Firebase.RTDB.setString(&fbdo,"Sensors/Slot 10",status10);
    Update_Slots();

}

void Update_Slots(){

    S_total = S_1 + S_2 + S_3 + S_4 + S_5 + S_6 + S_7 + S_8 + S_9 + S_10 ;
    Firebase.RTDB.setString(&fbdo,"Sensors/Total_Slots",S_total);

}
