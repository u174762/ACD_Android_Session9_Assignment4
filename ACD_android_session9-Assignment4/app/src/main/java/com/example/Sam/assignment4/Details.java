package com.example.Sam.assignment4;

/**
 * Created by Sam prakash on 03/10/16.
 */

public class Details {

    String name;
    String phone;
    String dob;



    public Details(String name, String phone, String dob)
    {
        this.name= name;
        this.phone = phone;
        this.dob = dob;
    }

    public Details() {

    }

        public String getName() {

            return name;
        }

        public void setName(String name){

            this.name=name;



    }

    public String getPhone(){

        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone=phone;

    }



public String getDob()


{
    return dob;

}

    public void setDob(String dob)

    {
        this.dob = dob;
    }





}
