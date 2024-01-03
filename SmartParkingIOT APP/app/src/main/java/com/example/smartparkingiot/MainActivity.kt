package com.example.smartparkingiot

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.smartparkingiot.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.button.setOnClickListener{readData()}
        if (isOnline()) {
            databaseListener()
        } else {
            Toast.makeText(this@MainActivity, "No internet connection", Toast.LENGTH_SHORT).show()
        }

    }
    //----------------------------------------------------------------------------------------------
    private fun isOnline(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    //----------------------------------------------------------------------------------------------
    private fun databaseListener(){
        database = FirebaseDatabase.getInstance().getReference()
        val postListener1 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 1").value
                if (status ==("Available")) {
                    binding.imageViewSlot01.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot01.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot01.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot01.setText(status.toString()+" 01    ")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener1)

        val postListener2 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 2").value

                if (status ==("Available")) {
                    binding.imageViewSlot02.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot02.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot02.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot02.setText(status.toString()+" 02    ")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener2)
        val postListener3 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 3").value
                if (status ==("Available")) {
                    binding.imageViewSlot03.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot03.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot03.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot03.setText(status.toString()+" 03    ")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener3)
        val postListener4 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 4").value
                if (status ==("Available")) {
                    binding.imageViewSlot04.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot04.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot04.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot04.setText(status.toString()+" 04    ")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener4)
        val postListener5 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 5").value
                if (status ==("Available")) {
                    binding.imageViewSlot05.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot05.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot05.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot05.setText(status.toString()+" 05    ")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener5)
        val postListener6 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 6").value
                if (status ==("Available")) {
                    binding.imageViewSlot06.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot06.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot06.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot06.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot06.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot06.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot06.setText("    06 " +status.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener6)
        val postListener7 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 7").value
                if (status ==("Available")) {
                    binding.imageViewSlot07.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot07.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot07.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot07.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot07.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot07.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot07.setText("    07 " +status.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener7)
        val postListener8 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 8").value
                if (status ==("Available")) {
                    binding.imageViewSlot08.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot08.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot08.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot08.setText("    08 " +status.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener8)
        val postListener9 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 9").value
                if (status ==("Available")) {
                    binding.imageViewSlot09.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot09.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot09.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot09.setText("    09 " +status.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener9)
        val postListener10 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Slot 10").value
                if (status ==("Available")) {
                    binding.imageViewSlot10.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot10.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot10.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot10.setText("    10 " +status.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener10)
//--------------------------------------------------------------------------------------------------------------------------------------------------
        val postListener11 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val status = snapshot.child("Sensors/Total_Slots").value

                if (status == "0") {
                    binding.textViewTotalSlots.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.red))

                    // Show a message box or a Toast when status is 0
                    val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
                    alertDialogBuilder.setTitle("Alert")
                    alertDialogBuilder.setMessage("Sorry! The Parking is full.")

                    alertDialogBuilder.setPositiveButton("Okay") { dialog, which ->
                        // Add code to handle the positive button click event
                        // For example, you can show another dialog or perform some action
                        Toast.makeText(this@MainActivity, "Thank You! Visit Again", Toast.LENGTH_SHORT).show()
                        //Toast.makeText(this@MainActivity, "Visit Again", Toast.LENGTH_SHORT).show()
                    }

                    val alertDialog = alertDialogBuilder.create()
                    alertDialog.show()
                    binding.textViewStatus.text = "Sorry! Parking is full."

                } else {
                    binding.textViewTotalSlots.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                    binding.textViewStatus.text = ""
                }

                binding.textViewTotalSlots.text = status.toString()


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to Fetch Database", Toast.LENGTH_SHORT).show()
            }
        }

        database.addValueEventListener(postListener11)

    }
//------------------------------------------------------------------------------------------------------------------------------------------
    private fun readData(){
        database = FirebaseDatabase.getInstance().getReference("Sensors")
        database.child("Slot 1").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot01.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot01.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot01.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot01.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot01.setText(status.toString()+" 01    ")
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }

        database.child("Slot 2").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot02.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot02.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot02.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot02.setText(status.toString()+" 02    ")
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 3").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot03.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot03.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot03.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot03.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot03.setText(status.toString()+" 03    ")
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 4").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot04.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot04.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot04.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot04.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot04.setText(status.toString()+" 04    ")
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 5").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot05.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot05.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot05.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot05.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot05.setText(status.toString()+" 05    ")
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 6").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot06.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot06.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot06.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot06.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot06.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot06.setText("    06 " +status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 7").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot07.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot07.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot07.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot02.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot07.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot07.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot07.setText("    07 " +status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 8").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot08.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot08.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot08.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot08.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot08.setText("    08 " +status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 9").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot09.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot09.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot09.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot09.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot09.setText("    09 " +status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Slot 10").get().addOnSuccessListener {
            if(it.exists()){
                val status: String = it.value.toString()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status ==("Available")) {
                    binding.imageViewSlot10.setImageResource(R.drawable.available_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Available))
                } else if (status == ("Engaged")) {
                    binding.imageViewSlot10.setImageResource(R.drawable.engaged_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.Engaged))
                } else {
                    binding.imageViewSlot10.setImageResource(R.drawable.default_parking)
                    binding.textViewSlot10.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                binding.textViewSlot10.setText("    10 " +status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        database.child("Total_Slots").get().addOnSuccessListener {
            if(it.exists()){
                val status: Int = it.value.toString().toInt()
//                Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
                if (status == 0) {
                    binding.textViewTotalSlots.setTextColor(ContextCompat.getColor(this, R.color.Engaged))
                } else {
                    binding.textViewTotalSlots.setTextColor(ContextCompat.getColor(this, R.color.white))
                }
                binding.textViewTotalSlots.setText(status.toString())
            }else{
//                Toast.makeText(this,"Update Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this,"Failed to Fetch Database",Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this,"Updated Successully",Toast.LENGTH_SHORT).show()
    }
}